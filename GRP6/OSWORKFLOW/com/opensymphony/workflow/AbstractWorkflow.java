/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.module.propertyset.PropertySetManager;

import com.opensymphony.workflow.config.Configuration;
import com.opensymphony.workflow.config.DefaultConfiguration;
import com.opensymphony.workflow.loader.*;
import com.opensymphony.workflow.query.WorkflowExpressionQuery;
import com.opensymphony.workflow.query.WorkflowQuery;
import com.opensymphony.workflow.spi.*;
import com.opensymphony.workflow.util.DynamicSplitGroupCallback;
import com.opensymphony.workflow.util.VariableResolver;
import com.zjm.common.db.model.User;
import com.zjm.gworkFlow.db.model.FlowRole;
import com.zjm.util.SystemSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Abstract workflow instance that serves as the base for specific implementations, such as EJB or SOAP.
 *
 * @author <a href="mailto:plightbo@hotmail.com">Pat Lightbody</a>
 * @author Hani Suleiman
 */
@Service("workflow")
public class AbstractWorkflow implements Workflow {
    //~ Static fields/initializers /////////////////////////////////////////////

    private static final Log log = LogFactory.getLog(AbstractWorkflow.class);

    //~ Instance fields ////////////////////////////////////////////////////////

    protected WorkflowContext context;
    private Configuration configuration;
    private ThreadLocal stateCache = new ThreadLocal();
    private TypeResolver typeResolver;

    //~ Constructors ///////////////////////////////////////////////////////////

    public AbstractWorkflow() {
        stateCache.set(new HashMap());
    }

    //~ Methods ////////////////////////////////////////////////////////////////

    /**
     * @ejb.interface-method
     * @deprecated use {@link #getAvailableActions(long, Map)}  with an empty Map instead.
     */
    public int[] getAvailableActions(long id) {
        return getAvailableActions(id, new HashMap());
    }

    /**
     * Get the available actions for the specified workflow instance.
     * @ejb.interface-method
     * @param id The workflow instance id.
     * @param inputs The inputs map to pass on to conditions
     * @return An array of action id's that can be performed on the specified entry.
     * @throws IllegalArgumentException if the specified id does not exist, or if its workflow
     * descriptor is no longer available or has become invalid.
     */
    public int[] getAvailableActions(long id, Map inputs) {
        try {
            WorkflowStore store = getPersistence();
            WorkflowEntry entry = store.findEntry(id);

            if (entry == null) {
                throw new IllegalArgumentException("No such workflow id " + id);
            }

            if (entry.getState() != WorkflowEntry.ACTIVATED) {
                return new int[0];
            }

            WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());

            if (wf == null) {
                throw new IllegalArgumentException("No such workflow " + entry.getWorkflowName());
            }

            List l = new ArrayList();
            PropertySet ps = store.getPropertySet(id);
            Map transientVars = (inputs == null) ? new HashMap() : new HashMap(inputs);
            Collection currentSteps = store.findCurrentSteps(id);

            populateTransientMap(entry, transientVars, wf.getRegisters(), new Integer(0), currentSteps, ps);

            // get global actions
            List globalActions = wf.getGlobalActions();

            for (Iterator iterator = globalActions.iterator();
                    iterator.hasNext();) {
                ActionDescriptor action = (ActionDescriptor) iterator.next();
                RestrictionDescriptor restriction = action.getRestriction();
                ConditionsDescriptor conditions = null;

                transientVars.put("actionId", new Integer(action.getId()));

                if (restriction != null) {
                    conditions = restriction.getConditionsDescriptor();
                }

                //todo verify that 0 is the right currentStepId
                if (passesConditions(wf.getGlobalConditions(), transientVars, ps, 0) && passesConditions(conditions, transientVars, ps, 0)) {
                    l.add(new Integer(action.getId()));
                }
            }

            // get normal actions
            for (Iterator iterator = currentSteps.iterator();
                    iterator.hasNext();) {
                Step step = (Step) iterator.next();
                l.addAll(getAvailableActionsForStep(wf, step, transientVars, ps));
            }

            int[] actions = new int[l.size()];

            for (int i = 0; i < actions.length; i++) {
                actions[i] = ((Integer) l.get(i)).intValue();
            }

            return actions;
        } catch (Exception e) {
            log.error("Error checking available actions", e);

            return new int[0];
        }
    }

    /**
     * @ejb.interface-method
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Get the configuration for this workflow.
     * This method also checks if the configuration has been initialized, and if not, initializes it.
     * @return The configuration that was set.
     * If no configuration was set, then the default (static) configuration is returned.
     *
     */
    public Configuration getConfiguration() {
        Configuration config = (configuration != null) ? configuration : DefaultConfiguration.INSTANCE;

        if (!config.isInitialized()) {
            try {
                config.load(null);
            } catch (FactoryException e) {
                log.fatal("Error initialising configuration", e);

                //fail fast, better to blow up with an NPE that hide the error
                return null;
            }
        }

        return config;
    }

    /**
     * @ejb.interface-method
     */
    public List getCurrentSteps(long id) {
        try {
            WorkflowStore store = getPersistence();

            return store.findCurrentSteps(id);
        } catch (StoreException e) {
            log.error("Error checking current steps for instance #" + id, e);

            return Collections.EMPTY_LIST;
        }
    }

    /**
     * @ejb.interface-method
     */
    public int getEntryState(long id) {
        try {
            WorkflowStore store = getPersistence();

            return store.findEntry(id).getState();
        } catch (StoreException e) {
            log.error("Error checking instance state for instance #" + id, e);
        }

        return WorkflowEntry.UNKNOWN;
    }

    /**
     * @ejb.interface-method
     */
    public List getHistorySteps(long id) {
        try {
            WorkflowStore store = getPersistence();

            return store.findHistorySteps(id);
        } catch (StoreException e) {
            log.error("Error getting history steps for instance #" + id, e);
        }

        return Collections.EMPTY_LIST;
    }

    /**
     * @ejb.interface-method
     */
    public Properties getPersistenceProperties() {
        Properties p = new Properties();
        Iterator iter = getConfiguration().getPersistenceArgs().entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            p.setProperty((String) entry.getKey(), (String) entry.getValue());
        }

        return p;
    }

    /**
     * Get the PropertySet for the specified workflow ID
     * @ejb.interface-method
     * @param id The workflow ID
     */
    public PropertySet getPropertySet(long id) {
        PropertySet ps = null;

        try {
            ps = getPersistence().getPropertySet(id);
        } catch (StoreException e) {
            log.error("Error getting propertyset for instance #" + id, e);
        }

        return ps;
    }

    public void setResolver(TypeResolver resolver) {
        this.typeResolver = resolver;
    }

    public TypeResolver getResolver() {
        if (typeResolver == null) {
            typeResolver = TypeResolver.getResolver();
        }

        return typeResolver;
    }

    /**
     * @ejb.interface-method
     */
    public List getSecurityPermissions(long id) {
        return getSecurityPermissions(id, null);
    }

    /**
     * @ejb.interface-method
     */
    public List getSecurityPermissions(long id, Map inputs) {
        try {
            WorkflowStore store = getPersistence();
            WorkflowEntry entry = store.findEntry(id);
            WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());

            PropertySet ps = store.getPropertySet(id);
            Map transientVars = (inputs == null) ? new HashMap() : new HashMap(inputs);
            Collection currentSteps = store.findCurrentSteps(id);
            populateTransientMap(entry, transientVars, wf.getRegisters(), null, currentSteps, ps);

            List s = new ArrayList();

            for (Iterator interator = currentSteps.iterator();
                    interator.hasNext();) {
                Step step = (Step) interator.next();

                int stepId = step.getStepId();

                StepDescriptor xmlStep = wf.getStep(stepId);

                List securities = xmlStep.getPermissions();

                for (Iterator iterator2 = securities.iterator();
                        iterator2.hasNext();) {
                    PermissionDescriptor security = (PermissionDescriptor) iterator2.next();

                    // to have the permission, the condition must be met or not specified
                    // securities can't have restrictions based on inputs, so it's null
                    if (security.getRestriction() != null) {
                        if (passesConditions(security.getRestriction().getConditionsDescriptor(), transientVars, ps, xmlStep.getId())) {
                            s.add(security.getName());
                        }
                    }
                }
            }

            return s;
        } catch (Exception e) {
            log.error("Error getting security permissions for instance #" + id, e);
        }

        return Collections.EMPTY_LIST;
    }

    /**
     * Returns a workflow definition object associated with the given name.
     *
     * @param workflowName the name of the workflow
     * @return the object graph that represents a workflow definition
     * @ejb.interface-method
     */
    public WorkflowDescriptor getWorkflowDescriptor(String workflowName) {
        try {
            return getConfiguration().getWorkflow(workflowName);
        } catch (FactoryException e) {
            log.error("Error loading workflow " + workflowName, e);
        }

        return null;
    }

    /**
     * @ejb.interface-method
     */
    public String getWorkflowName(long id) {
        try {
            WorkflowStore store = getPersistence();
            WorkflowEntry entry = store.findEntry(id);

            if (entry != null) {
                return entry.getWorkflowName();
            }
        } catch (StoreException e) {
            log.error("Error getting instance name for instance #" + id, e);
        }

        return null;
    }

    /**
     * Get a list of workflow names available
     * @return String[] an array of workflow names.
     * @ejb.interface-method
     */
    public String[] getWorkflowNames() {
        try {
            return getConfiguration().getWorkflowNames();
        } catch (FactoryException e) {
            log.error("Error getting workflow names", e);
        }

        return new String[0];
    }

    /**
     * @ejb.interface-method
     */
    public boolean canInitialize(String workflowName, int initialAction) {
        return canInitialize(workflowName, initialAction, null);
    }

    /**
     * @ejb.interface-method
     * @param workflowName the name of the workflow to check
     * @param initialAction The initial action to check
     * @param inputs the inputs map
     * @return true if the workflow can be initialized
     */
    public boolean canInitialize(String workflowName, int initialAction, Map inputs) {
        final String mockWorkflowName = workflowName;
        WorkflowEntry mockEntry = new WorkflowEntry() {
            public long getId() {
                return 0;
            }

            public String getWorkflowName() {
                return mockWorkflowName;
            }

            public boolean isInitialized() {
                return false;
            }

            public int getState() {
                return WorkflowEntry.CREATED;
            }
        };

        // since no state change happens here, a memory instance is just fine
        PropertySet ps = PropertySetManager.getInstance("memory", null);
        Map transientVars = new HashMap();

        if (inputs != null) {
            transientVars.putAll(inputs);
        }

        try {
            populateTransientMap(mockEntry, transientVars, Collections.EMPTY_LIST, new Integer(initialAction), Collections.EMPTY_LIST, ps);

            return canInitialize(workflowName, initialAction, transientVars, ps);
        } catch (InvalidActionException e) {
            log.error(e.getMessage());

            return false;
        } catch (WorkflowException e) {
            log.error("Error checking canInitialize", e);

            return false;
        }
    }

    /**
     * @ejb.interface-method
     */
    public boolean canModifyEntryState(long id, int newState) {
        try {
            WorkflowStore store = getPersistence();
            WorkflowEntry entry = store.findEntry(id);
            int currentState = entry.getState();
            boolean result = false;

            switch (newState) {
            case WorkflowEntry.COMPLETED:

                if (currentState == WorkflowEntry.ACTIVATED) {
                    result = true;
                }

                break;

            case WorkflowEntry.CREATED:
                result = false;

            case WorkflowEntry.ACTIVATED:

                if ((currentState == WorkflowEntry.CREATED) || (currentState == WorkflowEntry.SUSPENDED)) {
                    result = true;
                }

                break;

            case WorkflowEntry.SUSPENDED:

                if (currentState == WorkflowEntry.ACTIVATED) {
                    result = true;
                }

                break;

            case WorkflowEntry.KILLED:

                if ((currentState == WorkflowEntry.CREATED) || (currentState == WorkflowEntry.ACTIVATED) || (currentState == WorkflowEntry.SUSPENDED)) {
                    result = true;
                }

                break;

            default:
                result = false;

                break;
            }

            return result;
        } catch (StoreException e) {
            log.error("Error checking state modifiable for instance #" + id, e);
        }

        return false;
    }

    public void changeEntryState(long id, int newState) throws WorkflowException {
        WorkflowStore store = getPersistence();
        WorkflowEntry entry = store.findEntry(id);

        if (entry.getState() == newState) {
            return;
        }

        if (canModifyEntryState(id, newState)) {
            if ((newState == WorkflowEntry.KILLED) || (newState == WorkflowEntry.COMPLETED)) {
                Collection currentSteps = getCurrentSteps(id);

                if (currentSteps.size() > 0) {
                    completeEntry(null, id, currentSteps, newState);
                }
            }

            store.setEntryState(id, newState);
        } else {
            throw new InvalidEntryStateException("Can't transition workflow instance #" + id + ". Current state is " + entry.getState() + ", requested state is " + newState);
        }

        if (log.isDebugEnabled()) {
            log.debug(entry.getId() + " : State is now : " + entry.getState());
        }
    }

    public void doAction(long id, int actionId, Map inputs,Map<String,String> rolemap) throws WorkflowException {
    	    	
        WorkflowStore store = getPersistence();
        WorkflowEntry entry = store.findEntry(id);
        
        //判断工作流实例是否活动状态即,数值为1，当它为不是1时，则返回，1表示活动中的流程实例
        if (entry.getState() != WorkflowEntry.ACTIVATED) {
            return;
        }
        
       
        //根据流程名称，找到流程配置文件，从而得到流程描述对象WorkflowDescriptor
        WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());
        
        //根据流程实例ID取得当前工作流实例的所有当前步骤
        List currentSteps = store.findCurrentSteps(id);
        ActionDescriptor action = null;//动作描述对象
        
        //取得工作流实例的所有propertySet
        PropertySet ps = store.getPropertySet(id);
        Map transientVars = new HashMap(); //Map是接口,HashMap是其实现类,list是接口,Arraylist是它的实现类

        if (inputs != null) {
            transientVars.putAll(inputs);
        }
        
        //调用的populateTransientMap方法。该方法把众多参数都存放入transientVars这个map中，包括context，workflowDescritor(工作流XML文件描述对象)，actionId等。
        populateTransientMap(entry, transientVars, wf.getRegisters(), new Integer(actionId), currentSteps, ps);
        
        /*3.判断要执行的这个action是否存在（在globalActions与当前所有step的action的列表中查找），并且其验证条件是否满足。如果action没有找到或者验证不通过，则抛出InvalidActionException*/
        boolean validAction = false;

        //check global actions 即检查是否是公共Action
        for (Iterator gIter = wf.getGlobalActions().iterator();
                !validAction && gIter.hasNext();) {
            ActionDescriptor actionDesc = (ActionDescriptor) gIter.next();

            if (actionDesc.getId() == actionId) {
                action = actionDesc;

                if (isActionAvailable(action, transientVars, ps, 0)) {
                    validAction = true;
                }
            }
        }

        //非公共Action时
        for (Iterator iter = currentSteps.iterator();
                !validAction && iter.hasNext();) {
            Step step = (Step) iter.next();
            StepDescriptor s = wf.getStep(step.getStepId());
            
            //从流程模板文件中找到要执行的这个动作的上下文
            for (Iterator iterator = s.getActions().iterator();
                    !validAction && iterator.hasNext();) {
                ActionDescriptor actionDesc = (ActionDescriptor) iterator.next();

                if (actionDesc.getId() == actionId) { //找到了这个动作的上下文
                    action = actionDesc;  //返回这个动作的上下文

                    if (isActionAvailable(action, transientVars, ps, s.getId())) {
                        validAction = true;
                    }
                }
            }
        }

        //判断要执行的这个action是否存在,如果action没有找到或者验证不通过，则抛出InvalidActionException
        if (!validAction) {
            throw new InvalidActionException("Action " + actionId + " is invalid");
        }

        try {
            //transition the workflow, if it wasn't explicitly finished, check for an implicit finish
        	/*4.调用transitionWorkflow方法。该方法返回流程实例是否明确完成的标记，如果流程结束，则返回true，否则返回false。*/
            if (!transitionWorkflow(entry, currentSteps, store, wf, action, transientVars, inputs, ps,rolemap)) {
                checkImplicitFinish(action, id);//如果流程实例已结束，则不执行此函数
            }
        } catch (WorkflowException e) {
            context.setRollbackOnly();
            throw e;
        }
    }

    public void executeTriggerFunction(long id, int triggerId) throws WorkflowException {
        WorkflowStore store = getPersistence();
        WorkflowEntry entry = store.findEntry(id);

        if (entry == null) {
            log.warn("Cannot execute trigger #" + triggerId + " on non-existent workflow id#" + id);

            return;
        }

        WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());

        PropertySet ps = store.getPropertySet(id);
        Map transientVars = new HashMap();
        populateTransientMap(entry, transientVars, wf.getRegisters(), null, store.findCurrentSteps(id), ps);
        executeFunction(wf.getTriggerFunction(triggerId), transientVars, ps);
    }

    public long initialize(String workflowName, int initialAction, Map inputs) throws InvalidRoleException, InvalidInputException, WorkflowException {
        WorkflowDescriptor wf = getConfiguration().getWorkflow(workflowName);

        WorkflowStore store = getPersistence();
        WorkflowEntry entry = store.createEntry(workflowName);

        // start with a memory property set, but clone it after we have an ID
        PropertySet ps = store.getPropertySet(entry.getId());
        Map transientVars = new HashMap();

        if (inputs != null) {
            transientVars.putAll(inputs);
        }

        populateTransientMap(entry, transientVars, wf.getRegisters(), new Integer(initialAction), Collections.EMPTY_LIST, ps);

        if (!canInitialize(workflowName, initialAction, transientVars, ps)) {
            context.setRollbackOnly();
            throw new InvalidRoleException("You are restricted from initializing this workflow");
        }

        ActionDescriptor action = wf.getInitialAction(initialAction);

        try {
        	Map<String,String> rolemap=new LinkedHashMap();//其实没用
            transitionWorkflow(entry, Collections.EMPTY_LIST, store, wf, action, transientVars, inputs, ps,rolemap);
        } catch (WorkflowException e) {
            context.setRollbackOnly();
            throw e;
        }

        long entryId = entry.getId();

        // now clone the memory PS to the real PS
        //PropertySetManager.clone(ps, store.getPropertySet(entryId));
        return entryId;
    }

    /**
     * @ejb.interface-method
     */
    public List query(WorkflowQuery query) throws StoreException {
        return getPersistence().query(query);
    }

    /**
     * @ejb.interface-method
     */
    public List query(WorkflowExpressionQuery query) throws WorkflowException {
        return getPersistence().query(query);
    }

    /**
     * @ejb.interface-method
     */
    public boolean removeWorkflowDescriptor(String workflowName) throws FactoryException {
        return getConfiguration().removeWorkflow(workflowName);
    }

    /**
     * @ejb.interface-method
     */
    public boolean saveWorkflowDescriptor(String workflowName, WorkflowDescriptor descriptor, boolean replace) throws FactoryException {
        boolean success = getConfiguration().saveWorkflow(workflowName, descriptor, replace);

        return success;
    }

    protected List getAvailableActionsForStep(WorkflowDescriptor wf, Step step, Map transientVars, PropertySet ps) throws WorkflowException {
        List l = new ArrayList();
        StepDescriptor s = wf.getStep(step.getStepId());

        if (s == null) {
            log.warn("getAvailableActionsForStep called for non-existent step Id #" + step.getStepId());

            return l;
        }

        List actions = s.getActions();

        if ((actions == null) || (actions.size() == 0)) {
            return l;
        }

        for (Iterator iterator2 = actions.iterator(); iterator2.hasNext();) {
            ActionDescriptor action = (ActionDescriptor) iterator2.next();
            RestrictionDescriptor restriction = action.getRestriction();
            ConditionsDescriptor conditions = null;

            transientVars.put("actionId", new Integer(action.getId()));

            if (restriction != null) {
                conditions = restriction.getConditionsDescriptor();
            }

            if (passesConditions(wf.getGlobalConditions(), new HashMap(transientVars), ps, s.getId()) && passesConditions(conditions, new HashMap(transientVars), ps, s.getId())) {
                l.add(new Integer(action.getId()));
            }
        }

        return l;
    }

    protected int[] getAvailableAutoActions(long id, Map inputs) {
        try {
            WorkflowStore store = getPersistence();
            WorkflowEntry entry = store.findEntry(id);

            if (entry == null) {
                throw new IllegalArgumentException("No such workflow id " + id);
            }

            if (entry.getState() != WorkflowEntry.ACTIVATED) {
                log.debug("--> state is " + entry.getState());

                return new int[0];
            }

            WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());

            if (wf == null) {
                throw new IllegalArgumentException("No such workflow " + entry.getWorkflowName());
            }

            List l = new ArrayList();
            PropertySet ps = store.getPropertySet(id);
            Map transientVars = (inputs == null) ? new HashMap() : new HashMap(inputs);
            Collection currentSteps = store.findCurrentSteps(id);

            populateTransientMap(entry, transientVars, wf.getRegisters(), new Integer(0), currentSteps, ps);

            // get global actions
            List globalActions = wf.getGlobalActions();

            for (Iterator iterator = globalActions.iterator();
                    iterator.hasNext();) {
                ActionDescriptor action = (ActionDescriptor) iterator.next();

                transientVars.put("actionId", new Integer(action.getId()));

                if (action.getAutoExecute()) {
                    if (isActionAvailable(action, transientVars, ps, 0)) {
                        l.add(new Integer(action.getId()));
                    }
                }
            }

            // get normal actions
            for (Iterator iterator = currentSteps.iterator();
                    iterator.hasNext();) {
                Step step = (Step) iterator.next();
                l.addAll(getAvailableAutoActionsForStep(wf, step, transientVars, ps));
            }

            int[] actions = new int[l.size()];

            for (int i = 0; i < actions.length; i++) {
                actions[i] = ((Integer) l.get(i)).intValue();
            }

            return actions;
        } catch (Exception e) {
            log.error("Error checking available actions", e);

            return new int[0];
        }
    }

    /**
     * Get just auto action availables for a step
     */
    protected List getAvailableAutoActionsForStep(WorkflowDescriptor wf, Step step, Map transientVars, PropertySet ps) throws WorkflowException {
        List l = new ArrayList();
        StepDescriptor s = wf.getStep(step.getStepId());

        if (s == null) {
            log.warn("getAvailableAutoActionsForStep called for non-existent step Id #" + step.getStepId());

            return l;
        }

        List actions = s.getActions();

        if ((actions == null) || (actions.size() == 0)) {
            return l;
        }

        for (Iterator iterator2 = actions.iterator(); iterator2.hasNext();) {
            ActionDescriptor action = (ActionDescriptor) iterator2.next();

            transientVars.put("actionId", new Integer(action.getId()));

            //check auto
            if (action.getAutoExecute()) {
                if (isActionAvailable(action, transientVars, ps, s.getId())) {
                    l.add(new Integer(action.getId()));
                }
            }
        }

        return l;
    }

    protected WorkflowStore getPersistence() throws StoreException {
        return getConfiguration().getWorkflowStore();
    }

    protected void checkImplicitFinish(ActionDescriptor action, long id) throws WorkflowException {
        WorkflowStore store = getPersistence();
        WorkflowEntry entry = store.findEntry(id);

        WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());

        Collection currentSteps = store.findCurrentSteps(id);

        boolean isCompleted = true;

        for (Iterator iterator = currentSteps.iterator(); iterator.hasNext();) {
            Step step = (Step) iterator.next();
            StepDescriptor stepDes = wf.getStep(step.getStepId());

            // if at least on current step have an available action
            if (stepDes.getActions().size() > 0) {
                isCompleted = false;
            }
        }

        if (isCompleted) {
            completeEntry(action, id, currentSteps, WorkflowEntry.COMPLETED);
        }
    }

    /**
     * Mark the specified entry as completed, and move all current steps to history.
     */
    protected void completeEntry(ActionDescriptor action, long id, Collection currentSteps, int state) throws StoreException {
        getPersistence().setEntryState(id, state);

        Iterator i = new ArrayList(currentSteps).iterator();

        while (i.hasNext()) {
            Step step = (Step) i.next();
            String oldStatus = (action != null) ? action.getUnconditionalResult().getOldStatus() : "Finished";
            getPersistence().markFinished(step, (action != null) ? action.getId() : (-1), new Date(), oldStatus, context.getCaller());
            getPersistence().moveToHistory(step);
        }
    }

    /**
     * Executes a function.
     *
     * @param function the function to execute
     * @param transientVars the transientVars given by the end-user
     * @param ps the persistence variables
     */
    protected void executeFunction(FunctionDescriptor function, Map transientVars, PropertySet ps) throws WorkflowException {
        if (function != null) {
            String type = function.getType();

            Map args = new HashMap(function.getArgs());

            for (Iterator iterator = args.entrySet().iterator();
                    iterator.hasNext();) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                mapEntry.setValue(getConfiguration().getVariableResolver().translateVariables((String) mapEntry.getValue(), transientVars, ps));
            }

            FunctionProvider provider = getResolver().getFunction(type, args);

            if (provider == null) {
                String message = "Could not load FunctionProvider class";
                context.setRollbackOnly();
                throw new WorkflowException(message);
            }

            try {
                provider.execute(transientVars, args, ps);
            } catch (WorkflowException e) {
                context.setRollbackOnly();
                throw e;
            }
        }
    }

    protected boolean passesCondition(ConditionDescriptor conditionDesc, Map transientVars, PropertySet ps, int currentStepId) throws WorkflowException {
        String type = conditionDesc.getType();

        Map args = new HashMap(conditionDesc.getArgs());

        for (Iterator iterator = args.entrySet().iterator();
                iterator.hasNext();) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            mapEntry.setValue(getConfiguration().getVariableResolver().translateVariables((String) mapEntry.getValue(), transientVars, ps));
        }

        if (currentStepId != -1) {
            Object stepId = args.get("stepId");

            if ((stepId != null) && stepId.equals("-1")) {
                args.put("stepId", String.valueOf(currentStepId));
            }
        }

        Condition condition = getResolver().getCondition(type, args);

        if (condition == null) {
            context.setRollbackOnly();
            throw new WorkflowException("Could not load condition");
        }

        try {
            boolean passed = condition.passesCondition(transientVars, args, ps);

            if (conditionDesc.isNegate()) {
                passed = !passed;
            }

            return passed;
        } catch (Exception e) {
            context.setRollbackOnly();

            if (e instanceof WorkflowException) {
                throw (WorkflowException) e;
            }

            throw new WorkflowException("Unknown exception encountered when checking condition " + condition, e);
        }
    }

    protected boolean passesConditions(String conditionType, List conditions, Map transientVars, PropertySet ps, int currentStepId) throws WorkflowException {
        if ((conditions == null) || (conditions.size() == 0)) {
            return true;
        }

        boolean and = "AND".equals(conditionType);
        boolean or = !and;

        for (Iterator iterator = conditions.iterator(); iterator.hasNext();) {
            AbstractDescriptor descriptor = (AbstractDescriptor) iterator.next();
            boolean result;

            if (descriptor instanceof ConditionsDescriptor) {
                ConditionsDescriptor conditionsDescriptor = (ConditionsDescriptor) descriptor;
                result = passesConditions(conditionsDescriptor.getType(), conditionsDescriptor.getConditions(), transientVars, ps, currentStepId);
            } else {
                result = passesCondition((ConditionDescriptor) descriptor, transientVars, ps, currentStepId);
            }

            if (and && !result) {
                return false;
            } else if (or && result) {
                return true;
            }
        }

        if (and) {
            return true;
        } else if (or) {
            return false;
        } else {
            return false;
        }
    }

    protected boolean passesConditions(ConditionsDescriptor descriptor, Map transientVars, PropertySet ps, int currentStepId) throws WorkflowException {
        if (descriptor == null) {
            return true;
        }

        return passesConditions(descriptor.getType(), descriptor.getConditions(), transientVars, ps, currentStepId);
    }

    protected void populateTransientMap(WorkflowEntry entry, Map transientVars, List registers, Integer actionId, Collection currentSteps, PropertySet ps) throws WorkflowException {
        transientVars.put("context", context);
        transientVars.put("entry", entry);
        transientVars.put("store", getPersistence());
        transientVars.put("configuration", getConfiguration());
        transientVars.put("descriptor", getConfiguration().getWorkflow(entry.getWorkflowName()));

        if (actionId != null) {
            transientVars.put("actionId", actionId);
        }

        transientVars.put("currentSteps", new ArrayList(currentSteps));

        // now talk to the registers for any extra objects needed in scope
        for (Iterator iterator = registers.iterator(); iterator.hasNext();) {
            RegisterDescriptor register = (RegisterDescriptor) iterator.next();
            Map args = register.getArgs();

            String type = register.getType();
            Register r = getResolver().getRegister(type, args);

            if (r == null) {
                String message = "Could not load register class";
                context.setRollbackOnly();
                throw new WorkflowException(message);
            }

            try {
                transientVars.put(register.getVariableName(), r.registerVariable(context, entry, args, ps));
            } catch (Exception e) {
                context.setRollbackOnly();

                if (e instanceof WorkflowException) {
                    throw (WorkflowException) e;
                }

                throw new WorkflowException("An unknown exception occured while registering variable using register " + r, e);
            }
        }
    }

    /**
     * @return true if the instance has been explicitly completed is this transition, false otherwise
     * @throws WorkflowException
     */
    /**
     * 变迁一个工作流，即真正执行一个动作中的所有内容,例如前置和后置函数,条件,结果
     */
    protected boolean transitionWorkflow(WorkflowEntry entry, List currentSteps, WorkflowStore store, WorkflowDescriptor wf, ActionDescriptor action, Map transientVars, Map inputs, PropertySet ps,Map<String,String> rolemap) throws WorkflowException {
    	/*
    	1.清空ThreadLocal中的状态缓存；   
    	2.通过传入参数Action取得当前Step；   
    	3.检查输入验证；   
    	4.获取当前Step的PostFunction，并执行；   
    	5.执行当前Action的preFunction，并执行；   
    	6.获取满足条件的Result；   
    	7.执行当前Result的preFunction，并执行；   
    	8.如果Result的Split不为空，执行Splist的Result；   
    	9.如果Result的Join不为空，执行（结束当前步骤，移动到历史步骤，找到所有join步骤放入“jn”，执行条件，执行Result。）；   
    	10.执行未执行的PostFunction；   
    	11.执行自动action。  
    	*/
    	Map cache = (Map) stateCache.get();

        if (cache != null) {
            cache.clear();
        } else {
            stateCache.set(new HashMap());
        }

        //根据动作id，找到这个步骤
        Step step = getCurrentStep(wf, action.getId(), currentSteps, transientVars, ps);

        if (action.getValidators().size() > 0) {
            verifyInputs(entry, action.getValidators(), Collections.unmodifiableMap(transientVars), ps);
        }

        //we're leaving the current step, so let's execute its post-functions
        //check if we actually have a current step
        //执行步骤后置函数
        if (step != null) {
            List stepPostFunctions = wf.getStep(step.getStepId()).getPostFunctions();

            for (Iterator iterator = stepPostFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }
        }

        // preFunctions
        //这个动作的所有前置函数
        List preFunctions = action.getPreFunctions();

        for (Iterator iterator = preFunctions.iterator(); iterator.hasNext();) {
            FunctionDescriptor function = (FunctionDescriptor) iterator.next();
            executeFunction(function, transientVars, ps);
        }

        // check each conditional result
        List conditionalResults = action.getConditionalResults();
        List extraPreFunctions = null;
        List extraPostFunctions = null;
        ResultDescriptor[] theResults = new ResultDescriptor[1];

        //有条件Result
        for (Iterator iterator = conditionalResults.iterator();
                iterator.hasNext();) {
            ConditionalResultDescriptor conditionalResult = (ConditionalResultDescriptor) iterator.next();

            if (passesConditions(null, conditionalResult.getConditions(), Collections.unmodifiableMap(transientVars), ps, (step != null) ? step.getStepId() : (-1))) {
                //if (evaluateExpression(conditionalResult.getCondition(), entry, wf.getRegisters(), null, transientVars)) {
                theResults[0] = conditionalResult;

                if (conditionalResult.getValidators().size() > 0) {
                    verifyInputs(entry, conditionalResult.getValidators(), Collections.unmodifiableMap(transientVars), ps);
                }

                extraPreFunctions = conditionalResult.getPreFunctions();
                extraPostFunctions = conditionalResult.getPostFunctions();

                break;
            }
        }

        // use unconditional-result if a condition hasn't been met
        //无条件Result
        if (theResults[0] == null) {
            theResults[0] = action.getUnconditionalResult();           
            
            verifyInputs(entry, theResults[0].getValidators(), Collections.unmodifiableMap(transientVars), ps);
            extraPreFunctions = theResults[0].getPreFunctions();
            extraPostFunctions = theResults[0].getPostFunctions();
        }

        if (log.isDebugEnabled()) {
            log.debug("theResult=" + theResults[0].getStep() + ' ' + theResults[0].getStatus());
        }

        if ((extraPreFunctions != null) && (extraPreFunctions.size() > 0)) {
            // run any extra pre-functions that haven't been run already
            for (Iterator iterator = extraPreFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }
        }

        // go to next step
        //分支动作
        if (theResults[0].getSplit() != 0) {
        	System.out.println("dynaem=======================");
        	//以下代码钟招坤改造，增加对动态分支的支持        	
        	SplitDescriptor splitDesc = wf.getSplit(theResults[0].getSplit());
            Collection results = splitDesc.getResults();
            /*zhongzk 判断是否动态分支*/        	
            if (splitDesc.isDynamic()) {
            	System.out.println("dynaem=======================");
          	    log.debug("dynamic create results");
                String owner = theResults[0].getOwner();
                //System.out.println("test split owners:"+owner);
                
                VariableResolver variableResolver = getConfiguration().getVariableResolver();
                if ((owner != null) && (owner.length() > 0)) {
                  Object o = variableResolver.translateVariables(owner, transientVars, ps);
                  owner = o != null ? o.toString() : null;
                } else {
                  log.error("dynamic must specify owner group");
                  throw new WorkflowException("dynamic must specify owner group");
                }
                String obtainGroupsCallback = splitDesc.getObtainGroupsCallback();
                if ((obtainGroupsCallback == null) || (obtainGroupsCallback.length() == 0)) {
                  log.error("dynamic must specify group callback");
                  throw new WorkflowException("dynamic must specify group callback");
                }
                /*
                DynamicSplitGroupCallback callback = null;
                try {
                  callback = (DynamicSplitGroupCallback)ClassLoaderUtil.loadClass(obtainGroupsCallback.trim(), getClass()).newInstance();
                } catch (Exception e) {
                  log.error("Could not load class '" + obtainGroupsCallback + "'", e);
                  throw new WorkflowException("Could not load class '" + obtainGroupsCallback + "'");
                }
                */
                
               // String[] group = callback.excute(owner);//把操作者带逗号的字符串转化为数组
                
                if (splitDesc.getResults().size() == 0) {
                  log.error("Please specify at least one result to be a template");
                  throw new WorkflowException("Please specify at least one result to be a template");
                }
                ResultDescriptor template = (ResultDescriptor)splitDesc.getResults().get(0);
                results = new ArrayList();
                ResultDescriptor result = null;
                
                //编历map中的用户id
                Set keySet = rolemap.keySet();
                Map<String,String> newrolemap=new HashMap();
                int i=1;
          	    for (Iterator<?> iter = keySet.iterator(); iter.hasNext();){
	          	     String key = (String) iter.next();
	          	     String value = (String) rolemap.get(key);//取得用户id 
	      	         
	      	         String rolenameid=Integer.valueOf(i)+key;
	      	         System.out.println("rolenameid:"+rolenameid);
	      	         newrolemap.put(rolenameid, value);
	      	         
	                 result = new ResultDescriptor();
	                 result.setDisplayName(template.getDisplayName());
	                 result.setOldStatus(template.getOldStatus());
	                 
	                 result.setOwner(rolenameid);//设置角色对应的角色，并且在角色前面加上序号
	                 
	                 result.setParent(template.getParent());
	                 result.setStatus(template.getStatus());
	                 result.setStep(template.getStep());
	                 result.setPreFunctions(template.getPreFunctions());
	                 result.setPostFunctions(template.getPostFunctions());
	                 
	                 i++;
	                 results.add(result);	
          	   }//end for
          	   rolemap=newrolemap;//转换的后的map重新给rolemap 
              	
            }else{//普通分支        
               // Collection results = splitDesc.getResults();      
          	     results = splitDesc.getResults();
            }//else end            
        	
        	
            // the result is a split request, handle it correctly
            //SplitDescriptor splitDesc = wf.getSplit(theResults[0].getSplit());
           // Collection results = splitDesc.getResults();
            List splitPreFunctions = new ArrayList();
            List splitPostFunctions = new ArrayList();

            //check all results in the split and verify the input against any validators specified
            //also build up all the pre and post functions that should be called.
            for (Iterator iterator = results.iterator(); iterator.hasNext();) {
                ResultDescriptor resultDescriptor = (ResultDescriptor) iterator.next();

                if (resultDescriptor.getValidators().size() > 0) {
                    verifyInputs(entry, resultDescriptor.getValidators(), Collections.unmodifiableMap(transientVars), ps);
                }

                splitPreFunctions.addAll(resultDescriptor.getPreFunctions());
                splitPostFunctions.addAll(resultDescriptor.getPostFunctions());
            }

            // now execute the pre-functions
            for (Iterator iterator = splitPreFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }

            if (!action.isFinish()) {
                // now make these steps...
                boolean moveFirst = true;

                theResults = new ResultDescriptor[results.size()];
                results.toArray(theResults);

                for (Iterator iterator = results.iterator();
                        iterator.hasNext();) {
                    ResultDescriptor resultDescriptor = (ResultDescriptor) iterator.next();
                    Step moveToHistoryStep = null;

                    if (moveFirst) {
                        moveToHistoryStep = step;
                    }

                    long[] previousIds = null;

                    if (step != null) {
                        previousIds = new long[] {step.getId()};
                    }
                    
                    //test zhongzk
                    System.out.println("分支角色："+resultDescriptor.getOwner());
                    createNewCurrentStep(wf,resultDescriptor, entry, store, action.getId(), moveToHistoryStep, previousIds, transientVars, ps,rolemap);
                    moveFirst = false;
                }//end for
            }//end if (!action.isFinish())

            // now execute the post-functions
            for (Iterator iterator = splitPostFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }
        } else if (theResults[0].getJoin() != 0) {  //合并动作
            // this is a join, finish this step...
            JoinDescriptor joinDesc = wf.getJoin(theResults[0].getJoin());
            step = store.markFinished(step, action.getId(), new Date(), theResults[0].getOldStatus(), context.getCaller());
            store.moveToHistory(step);

            // ... now check to see if the expression evaluates
            // (get only current steps that have a result to this join)
            Collection joinSteps = new ArrayList();
            joinSteps.add(step);

            //currentSteps = store.findCurrentSteps(id); // shouldn't need to refresh the list
            for (Iterator iterator = currentSteps.iterator();
                    iterator.hasNext();) {
                Step currentStep = (Step) iterator.next();

                if (currentStep.getId() != step.getId()) {
                    StepDescriptor stepDesc = wf.getStep(currentStep.getStepId());

                    if (stepDesc.resultsInJoin(theResults[0].getJoin())) {
                        joinSteps.add(currentStep);
                    }
                }
            }

            //we also need to check history steps that were finished before this one
            //that might be part of the join
            List historySteps = store.findHistorySteps(entry.getId());

            for (Iterator i = historySteps.iterator(); i.hasNext();) {
                Step historyStep = (Step) i.next();

                if (historyStep.getId() != step.getId()) {
                    StepDescriptor stepDesc = wf.getStep(historyStep.getStepId());

                    if (stepDesc.resultsInJoin(theResults[0].getJoin())) {
                        joinSteps.add(historyStep);
                    }
                }
            }

            JoinNodes jn = new JoinNodes(joinSteps);
            transientVars.put("jn", jn);

            //todo verify that 0 is the right value for currentstep here
            if (passesConditions(null, joinDesc.getConditions(), Collections.unmodifiableMap(transientVars), ps, 0)) {
                // move the rest without creating a new step ...
                ResultDescriptor joinresult = joinDesc.getResult();

                if (joinresult.getValidators().size() > 0) {
                    verifyInputs(entry, joinresult.getValidators(), Collections.unmodifiableMap(transientVars), ps);
                }

                // now execute the pre-functions
                for (Iterator iterator = joinresult.getPreFunctions().iterator();
                        iterator.hasNext();) {
                    FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                    executeFunction(function, transientVars, ps);
                }

                long[] previousIds = new long[joinSteps.size()];
                int i = 1;

                for (Iterator iterator = joinSteps.iterator();
                        iterator.hasNext();) {
                    Step currentStep = (Step) iterator.next();

                    if (currentStep.getId() != step.getId()) {
                        //if this is already a history step (eg, for all join steps completed prior to this one),
                        //we don't move it, since it's already history.
                        if (!historySteps.contains(currentStep)) {
                            store.moveToHistory(currentStep);
                        }

                        previousIds[i] = currentStep.getId();
                        i++;
                    }
                }

                if (!action.isFinish()) {
                    // ... now finish this step normally
                    previousIds[0] = step.getId();
                    theResults[0] = joinDesc.getResult();

                    //we pass in null for the current step since we've already moved it to history above
                    
                    System.out.println("doAtcion合并角色："+theResults[0].getOwner());                   
                    createNewCurrentStep(wf,joinDesc.getResult(), entry, store, action.getId(), null, previousIds, transientVars, ps,rolemap);
                }

                // now execute the post-functions
                for (Iterator iterator = joinresult.getPostFunctions().iterator();
                        iterator.hasNext();) {
                    FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                    executeFunction(function, transientVars, ps);
                }
            }
        } else { //普通动作
            // normal finish, no splits or joins
            long[] previousIds = null;

            if (step != null) {
                previousIds = new long[] {step.getId()};
            }

            if (!action.isFinish()) {
            	
                System.out.println("无条件Owner:"+theResults[0].getOwner());//zhongzk test 

                //theResults[0].setOwner("liying");
                createNewCurrentStep(wf,theResults[0], entry, store, action.getId(), step, previousIds, transientVars, ps,rolemap);
            }
        }

        // postFunctions (BOTH)
        if (extraPostFunctions != null) {
            for (Iterator iterator = extraPostFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }
        }

        List postFunctions = action.getPostFunctions();

        for (Iterator iterator = postFunctions.iterator(); iterator.hasNext();) {
            FunctionDescriptor function = (FunctionDescriptor) iterator.next();
            executeFunction(function, transientVars, ps);
        }

        //if executed action was an initial action then workflow is activated ，初始动作
        if ((wf.getInitialAction(action.getId()) != null) && (entry.getState() != WorkflowEntry.ACTIVATED)) {
            changeEntryState(entry.getId(), WorkflowEntry.ACTIVATED);
        }

        //if it's a finish action, then we halt
        //若此动作是结束动作，则流程实例结束，设为4
        if (action.isFinish()) {
            completeEntry(action, entry.getId(), getCurrentSteps(entry.getId()), WorkflowEntry.COMPLETED);

            return true;
        }

        //get available autoexec actions
        int[] availableAutoActions = getAvailableAutoActions(entry.getId(), inputs);

        //we perform the first autoaction that applies, not all of them.
        if (availableAutoActions.length > 0) {
            doAction(entry.getId(), availableAutoActions[0], inputs,rolemap);
        }

        return false;
    }

    /**
     * Validates input against a list of ValidatorDescriptor objects.
     *
     * @param entry the workflow instance
     * @param validators the list of ValidatorDescriptors
     * @param transientVars the transientVars
     * @param ps the persistence variables
     * @throws InvalidInputException if the input is deemed invalid by any validator
     */
    protected void verifyInputs(WorkflowEntry entry, List validators, Map transientVars, PropertySet ps) throws WorkflowException {
        for (Iterator iterator = validators.iterator(); iterator.hasNext();) {
            ValidatorDescriptor input = (ValidatorDescriptor) iterator.next();

            if (input != null) {
                String type = input.getType();
                HashMap args = new HashMap(input.getArgs());

                for (Iterator iterator2 = args.entrySet().iterator();
                        iterator2.hasNext();) {
                    Map.Entry mapEntry = (Map.Entry) iterator2.next();
                    mapEntry.setValue(getConfiguration().getVariableResolver().translateVariables((String) mapEntry.getValue(), transientVars, ps));
                }

                Validator validator = getResolver().getValidator(type, args);

                if (validator == null) {
                    String message = "Could not load validator class";
                    context.setRollbackOnly();
                    throw new WorkflowException(message);
                }

                try {
                    validator.validate(transientVars, args, ps);
                } catch (InvalidInputException e) {
                    throw e;
                } catch (Exception e) {
                    context.setRollbackOnly();

                    if (e instanceof WorkflowException) {
                        throw (WorkflowException) e;
                    }

                    String message = "An unknown exception occured executing Validator " + validator;
                    throw new WorkflowException(message, e);
                }
            }
        }
    }

    /**
     * check if an action is available or not
     * @param action The action descriptor
     * @return true if the action is available
     */
    private boolean isActionAvailable(ActionDescriptor action, Map transientVars, PropertySet ps, int stepId) throws WorkflowException {
        if (action == null) {
            return false;
        }

        WorkflowDescriptor wf = getWorkflowDescriptorForAction(action);

        Map cache = (Map) stateCache.get();

        Boolean result = null;

        if (cache != null) {
            result = (Boolean) cache.get(action);
        } else {
            cache = new HashMap();
            stateCache.set(cache);
        }

        if (result == null) {
            RestrictionDescriptor restriction = action.getRestriction();
            ConditionsDescriptor conditions = null;

            if (restriction != null) {
                conditions = restriction.getConditionsDescriptor();
            }

            result = new Boolean(passesConditions(wf.getGlobalConditions(), new HashMap(transientVars), ps, stepId) && passesConditions(conditions, new HashMap(transientVars), ps, stepId));
            cache.put(action, result);
        }

        return result.booleanValue();
    }

    private Step getCurrentStep(WorkflowDescriptor wfDesc, int actionId, List currentSteps, Map transientVars, PropertySet ps) throws WorkflowException {
       //当前步骤只有一个时
    	if (currentSteps.size() == 1) {
            return (Step) currentSteps.get(0);
        }

    	//当前步聚有多个时，这种情况一般分支时产生的，根步动作id，找到这个步骤
        for (Iterator iterator = currentSteps.iterator(); iterator.hasNext();) {
            Step step = (Step) iterator.next();
            ActionDescriptor action = wfDesc.getStep(step.getStepId()).getAction(actionId);

            //$AR init
            if (isActionAvailable(action, transientVars, ps, step.getStepId())) {
            	//zhongzk fixed 2015.01.14 解决动态分支合并的bug，原来bug不能正确识别结束当前步骤
            	String curUserID=SystemSession.getUserSession().getUser_uid();
            	if (curUserID.equals(step.getOwner())){
                  return step;
            	}
            }

            //$AR end
        }

        return null;
    }

    private WorkflowDescriptor getWorkflowDescriptorForAction(ActionDescriptor action) {
        AbstractDescriptor objWfd = action;

        while (!(objWfd instanceof WorkflowDescriptor)) {
            objWfd = objWfd.getParent();
        }

        WorkflowDescriptor wf = (WorkflowDescriptor) objWfd;

        return wf;
    }

    private boolean canInitialize(String workflowName, int initialAction, Map transientVars, PropertySet ps) throws WorkflowException {
        WorkflowDescriptor wf = getConfiguration().getWorkflow(workflowName);

        ActionDescriptor actionDescriptor = wf.getInitialAction(initialAction);

        if (actionDescriptor == null) {
            throw new InvalidActionException("Invalid Initial Action #" + initialAction);
        }

        RestrictionDescriptor restriction = actionDescriptor.getRestriction();
        ConditionsDescriptor conditions = null;

        if (restriction != null) {
            conditions = restriction.getConditionsDescriptor();
        }

        return passesConditions(conditions, new HashMap(transientVars), ps, 0);
    }

    private Step createNewCurrentStep(WorkflowDescriptor wf,ResultDescriptor theResult, WorkflowEntry entry, WorkflowStore store, int actionId, Step currentStep, long[] previousIds, Map transientVars, PropertySet ps,Map<String,String> rolemap) throws WorkflowException {
        try {
        	//System.out.println("create new step===========其中角色中的rolemap是否有数据："+rolemap.size());
        	//zhongzk 鎶妌extStep鏀逛负nextStepID鍙硶锛屽鍔犳槗璇绘�
            int nextStepID = theResult.getStep();//浠巖esult涓婁笅鏂囦腑鍙栧緱涓嬩竴涓楠ょ殑ID
            //zhongzk澧炲姞鍙栧緱姝ラ鍚嶇О鐨勫姛鑳�
            StepDescriptor nextStepDescriptor=wf.getStep(nextStepID);
            String nextStepName=nextStepDescriptor.getName();
         
            
            //濡傛灉娌℃湁璁惧畾涓嬩竴涓楠D锛屽垯灏辨槸褰撳墠姝ラ
            if (nextStepID == -1) {
                if (currentStep != null) {
                    nextStepID = currentStep.getStepId();
                    nextStepName=currentStep.getStepName();
                    
                } else {
                    throw new StoreException("Illegal argument: requested new current step same as current step, but current step not specified");
                }
            }

            if (log.isDebugEnabled()) {
                log.debug("Outcome: stepId=" + nextStepID + ", status=" + theResult.getStatus() + ", owner=" + theResult.getOwner() + ", actionId=" + actionId + ", currentStep=" + ((currentStep != null) ? currentStep.getStepId() : 0));
            }

            if (previousIds == null) {
                previousIds = new long[0];
            }

            
            String owner = theResult.getOwner();
            
            //zhongzk改造，根据流程模板中的角色名称，取得用户id
            //判断是不是系统函数
            System.out.println("转换角色:"+owner+"  为用户id:");
            String firstchar=owner.trim().substring(0,1);//判断是不是$开头            
            if  (!firstchar.equals("$")) {             
              try{
            	  String userid=getUseridByRoleName(rolemap,owner);
               owner=String.valueOf(userid);
              }catch(Exception e){
            	  System.out.println("error:get join role is userid happan error!");
              }             
               System.out.println("action useid:"+owner);
            }   
            
           // System.out.println("create step owner:"+owner);

            VariableResolver variableResolver = getConfiguration().getVariableResolver();

            if (owner != null) {
                Object o = variableResolver.translateVariables(owner, transientVars, ps);
                owner = (o != null) ? o.toString() : null;
            }

            String oldStatus = theResult.getOldStatus();
            oldStatus = variableResolver.translateVariables(oldStatus, transientVars, ps).toString();

            String status = theResult.getStatus();
            status = variableResolver.translateVariables(status, transientVars, ps).toString();

            if (currentStep != null) {
                store.markFinished(currentStep, actionId, new Date(), oldStatus, context.getCaller());
                store.moveToHistory(currentStep);

                //store.moveToHistory(actionId, new Date(), currentStep, oldStatus, context.getCaller());
            }

            // construct the start date and optional due date
            Date startDate = new Date();
            Date dueDate = null;

            if ((theResult.getDueDate() != null) && (theResult.getDueDate().length() > 0)) {
                Object dueDateObject = variableResolver.translateVariables(theResult.getDueDate(), transientVars, ps);

                if (dueDateObject instanceof Date) {
                    dueDate = (Date) dueDateObject;
                } else if (dueDateObject instanceof String) {
                    long offset = 0;

                    try {
                        offset = Long.parseLong((String) dueDateObject);
                    } catch (NumberFormatException e) {
                    }

                    if (offset > 0) {
                        dueDate = new Date(startDate.getTime() + offset);
                    }
                } else if (dueDateObject instanceof Number) {
                    Number num = (Number) dueDateObject;
                    long offset = num.longValue();

                    if (offset > 0) {
                        dueDate = new Date(startDate.getTime() + offset);
                    }
                }
            }

            //Step newStep = store.createCurrentStep(entry.getId(), nextStep, owner, startDate, dueDate, status, previousIds);
            //灏嗗綋鍓嶆楠ゆ彃鍏ュ埌os_currentsteps琛ㄤ腑锛屼笖鍦╫s_currentsteps_prev涓彃鍏ヤ竴鏉″綋鍓嶈褰曪紝璁板綍褰撳墠stepid涓庝笂涓�釜stepid鐨勫搴�
            Step newStep = store.createCurrentStep(entry.getId(), nextStepID,nextStepName, owner, startDate, dueDate, status, previousIds);//鍒涘缓褰撳墠姝ラ
            transientVars.put("createdStep", newStep);

            if ((previousIds != null) && (previousIds.length == 0) && (currentStep == null)) {
                // At this point, it must be a brand new workflow, so we'll overwrite the empty currentSteps
                // with an array of just this current step
                List currentSteps = new ArrayList();
                currentSteps.add(newStep);
                transientVars.put("currentSteps", new ArrayList(currentSteps));
            }

            WorkflowDescriptor descriptor = (WorkflowDescriptor) transientVars.get("descriptor");
            StepDescriptor step = descriptor.getStep(nextStepID);

            if (step == null) {
                throw new WorkflowException("step #" + nextStepID + " does not exist");
            }

            List preFunctions = step.getPreFunctions();

            for (Iterator iterator = preFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }

            return newStep;
        } catch (WorkflowException e) {
            context.setRollbackOnly();
            throw e;
        }
    }
    
    /**
     * 瀵筭etAvailableActions杩涜浜嗛噸鏂版敼閫狅紝浠ユ弧瓒冲疄闄呬笟鍔￠渶姹傦紝鍘熸潵姝ゆ柟娉曪紝涓嶉�鍚堝疄闄呴渶姹�
     * @author:zhongzk 2012.04.22锛屽鍔犳鏂规硶锛屼富瑕佸彇寰楁煇涓�釜娴佺▼瀹炰緥锛屾煇涓�釜浜虹殑涓�釜褰撳墠寰呭姙姝ラ涓婄殑鎵�湁鏈夋晥鍔ㄤ綔ID
     * 鍙傛暟锛�
     * id:娴佺▼瀹炰緥ID
     * stepID:褰撳墠姝ラID
     * inputs锛氬彲閫夛紝鍙互涓簄ull
     */
    public int[] getOneCurStepAvailableActions(long id,int stepID,String curuserid, Map inputs) {
        try {
            WorkflowStore store = getPersistence();   //娴佺▼瀛樺偍浣�
            WorkflowEntry entry = store.findEntry(id);//娴佺▼瀹炰緥瀵硅薄

            //鍒ゆ柇娴佺▼瀹炰緥鏄惁涓虹┖
            if (entry == null) {
                throw new IllegalArgumentException("No such workflow id " + id);
            }

            //鍒ゆ柇娴佺▼瀹炰緥鏄縺娲荤殑
            if (entry.getState() != WorkflowEntry.ACTIVATED) {
                return new int[0];
            }
            
            //閫氳繃娴佺▼瀹炰緥鐨勬祦绋嬪悕绉拌幏鍙栦笂涓嬫枃
            WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());

            if (wf == null) {
                throw new IllegalArgumentException("No such workflow " + entry.getWorkflowName());
            }

            List l = new ArrayList();
            PropertySet ps = store.getPropertySet(id);//浠巓s_propertyentry涓彇寰楁娴佺▼瀹炰緥鐨勭浉鍏冲睘鎬ч泦鍚�
            Map transientVars = (inputs == null) ? new HashMap() : new HashMap(inputs);//鎶奿nputs杞崲涓簍ransienVas
            
            //zhongzk锛屾敼閫爏tore.findCurrentSteps鏂规硶锛屽鍔犱竴涓弬鏁皊tepID
            Collection currentSteps = store.findOneCurrentSteps(id,stepID,curuserid);//浠庡綋鍓嶆楠よ〃涓竴涓綋鍓嶆楠ょ殑淇℃伅

            //娴佺▼瀹炰緥鐨勬墍鏈夊弬鏁�
            populateTransientMap(entry, transientVars, wf.getRegisters(), new Integer(0), currentSteps, ps);

            // get global actions
            //1.鍙栧緱姝ゆ祦绋嬬殑鎵�湁鍏敤鍔ㄤ綔锛屽苟鎶婅繖浜涘姩浣滅殑ID鏀惧叆鍒發杩欎釜list鍙橀噺涓�
            List globalActions = wf.getGlobalActions();

            for (Iterator iterator = globalActions.iterator();
                    iterator.hasNext();) {
                ActionDescriptor action = (ActionDescriptor) iterator.next();
                RestrictionDescriptor restriction = action.getRestriction();
                ConditionsDescriptor conditions = null;

                transientVars.put("actionId", new Integer(action.getId()));

                if (restriction != null) {
                    conditions = restriction.getConditionsDescriptor();
                }

                //todo verify that 0 is the right currentStepId
                if (passesConditions(wf.getGlobalConditions(), transientVars, ps, 0) && passesConditions(conditions, transientVars, ps, 0)) {
                    l.add(new Integer(action.getId()));
                   
                }
            }

            // get normal actions
            //2.鍙栧緱鏅�鐨勬墍鏈夊姩浣滐紝骞舵妸杩欎簺鍔ㄤ綔鐨処D鏀惧叆鍒發杩欎釜list鍙橀噺涓�
            for (Iterator iterator = currentSteps.iterator();
                    iterator.hasNext();) {
                Step step = (Step) iterator.next();
                l.addAll(getAvailableActionsForStep(wf, step, transientVars, ps));
            }

            int[] actions = new int[l.size()];

            for (int i = 0; i < actions.length; i++) {
                actions[i] = ((Integer) l.get(i)).intValue();//鍙栧緱杩欎簺鍔ㄤ綔鐨処D锛屽苟鏀惧叆鍒癮ctions鏁扮粍涓�
            }

            return actions;//杩斿洖鏁扮粍
        } catch (Exception e) {
            log.error("Error checking available actions", e);

            return new int[0];
        }
    }
    
    /*
     * 得到下一个步骤上的角色集合，下一个步骤，有可能是普通步骤，分支步骤，动态分支步骤，合并步骤
     *
     */
    public FlowRole getNextStepRoles(long id, int actionId, Map inputs) throws WorkflowException {
    	//zhongzk
    	FlowRole flowRole=new FlowRole();
    	
        WorkflowStore store = getPersistence();
        WorkflowEntry entry = store.findEntry(id);
        
        //判断工作流实例是否活动状态即,数值为1，当它为不是1时，则返回，1表示活动中的流程实例
        if (entry.getState() != WorkflowEntry.ACTIVATED) {
           // return;
        	return null;
        }
        
       
        //根据流程名称，找到流程配置文件，从而得到流程描述对象WorkflowDescriptor
        WorkflowDescriptor wf = getConfiguration().getWorkflow(entry.getWorkflowName());
        
        //根据流程实例ID取得当前工作流实例的所有当前步骤
        List currentSteps = store.findCurrentSteps(id);
        ActionDescriptor action = null;//动作描述对象
        
        //取得工作流实例的所有propertySet
        PropertySet ps = store.getPropertySet(id);
        Map transientVars = new HashMap(); //Map是接口,HashMap是其实现类,list是接口,Arraylist是它的实现类

        if (inputs != null) {
            transientVars.putAll(inputs);
        }
        
        //调用的populateTransientMap方法。该方法把众多参数都存放入transientVars这个map中，包括context，workflowDescritor(工作流XML文件描述对象)，actionId等。
        populateTransientMap(entry, transientVars, wf.getRegisters(), new Integer(actionId), currentSteps, ps);
        
        /*3.判断要执行的这个action是否存在（在globalActions与当前所有step的action的列表中查找），并且其验证条件是否满足。如果action没有找到或者验证不通过，则抛出InvalidActionException*/
        boolean validAction = false;

        //check global actions 即检查是否是公共Action
        for (Iterator gIter = wf.getGlobalActions().iterator();
                !validAction && gIter.hasNext();) {
            ActionDescriptor actionDesc = (ActionDescriptor) gIter.next();

            if (actionDesc.getId() == actionId) {
                action = actionDesc;

                if (isActionAvailable(action, transientVars, ps, 0)) {
                    validAction = true;
                }
            }
        }

        //非公共Action时
        for (Iterator iter = currentSteps.iterator();
                !validAction && iter.hasNext();) {
            Step step = (Step) iter.next();
            StepDescriptor s = wf.getStep(step.getStepId());
            
            //从流程模板文件中找到要执行的这个动作的上下文
            for (Iterator iterator = s.getActions().iterator();
                    !validAction && iterator.hasNext();) {
                ActionDescriptor actionDesc = (ActionDescriptor) iterator.next();

                if (actionDesc.getId() == actionId) { //找到了这个动作的上下文
                    action = actionDesc;  //返回这个动作的上下文

                    if (isActionAvailable(action, transientVars, ps, s.getId())) {
                        validAction = true;
                    }
                }
            }
        }

        //判断要执行的这个action是否存在,如果action没有找到或者验证不通过，则抛出InvalidActionException
        if (!validAction) {
            throw new InvalidActionException("Action " + actionId + " is invalid");
        }

        try {
        	
        	flowRole=getNextStepOwners(entry, currentSteps, store, wf, action, transientVars, inputs, ps);
        	
            //transition the workflow, if it wasn't explicitly finished, check for an implicit finish
        	/*4.调用transitionWorkflow方法。该方法返回流程实例是否明确完成的标记，如果流程结束，则返回true，否则返回false。*/
            //if (!transitionWorkflow(entry, currentSteps, store, wf, action, transientVars, inputs, ps)) {
                //zhongzk
            	//checkImplicitFinish(action, id);//如果流程实例已结束，则不执行此函数
            //}
        } catch (WorkflowException e) {
           context.setRollbackOnly();
           throw e;
       }
        return flowRole;
    }

    
    /**
     * zhongzk开发
     * 功能：取得此动作可能转向的步骤（普通步骤，或分支步骤，动态分支步骤，合并步骤上的所有角色
     */
    private FlowRole getNextStepOwners(WorkflowEntry entry, List currentSteps, WorkflowStore store, WorkflowDescriptor wf, ActionDescriptor action, Map transientVars, Map inputs, PropertySet ps) throws WorkflowException {
    	/*
    	1.清空ThreadLocal中的状态缓存；   
    	2.通过传入参数Action取得当前Step；   
    	3.检查输入验证；   
    	4.获取当前Step的PostFunction，并执行；   
    	5.执行当前Action的preFunction，并执行；   
    	6.获取满足条件的Result；   
    	7.执行当前Result的preFunction，并执行；   
    	8.如果Result的Split不为空，执行Splist的Result；   
    	9.如果Result的Join不为空，执行（结束当前步骤，移动到历史步骤，找到所有join步骤放入“jn”，执行条件，执行Result。）；   
    	10.执行未执行的PostFunction；   
    	11.执行自动action。  
    	*/
    	//zhongzk
    	FlowRole flowRole=new FlowRole();
    	
    	Map cache = (Map) stateCache.get();

        if (cache != null) {
            cache.clear();
        } else {
            stateCache.set(new HashMap());
        }

        //根据动作id，找到这个步骤
        Step step = getCurrentStep(wf, action.getId(), currentSteps, transientVars, ps);

        if (action.getValidators().size() > 0) {
            verifyInputs(entry, action.getValidators(), Collections.unmodifiableMap(transientVars), ps);
        }

        //we're leaving the current step, so let's execute its post-functions
        //check if we actually have a current step
        //执行步骤后置函数
        if (step != null) {
            List stepPostFunctions = wf.getStep(step.getStepId()).getPostFunctions();

            for (Iterator iterator = stepPostFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }
        }

        // preFunctions
        //这个动作的所有前置函数
        List preFunctions = action.getPreFunctions();

        for (Iterator iterator = preFunctions.iterator(); iterator.hasNext();) {
            FunctionDescriptor function = (FunctionDescriptor) iterator.next();
            executeFunction(function, transientVars, ps);
        }

        // check each conditional result
        List conditionalResults = action.getConditionalResults();
        List extraPreFunctions = null;
        List extraPostFunctions = null;
        ResultDescriptor[] theResults = new ResultDescriptor[1];

        //有条件Result
        for (Iterator iterator = conditionalResults.iterator();
                iterator.hasNext();) {
            ConditionalResultDescriptor conditionalResult = (ConditionalResultDescriptor) iterator.next();

            if (passesConditions(null, conditionalResult.getConditions(), Collections.unmodifiableMap(transientVars), ps, (step != null) ? step.getStepId() : (-1))) {
                //if (evaluateExpression(conditionalResult.getCondition(), entry, wf.getRegisters(), null, transientVars)) {
                theResults[0] = conditionalResult;

                if (conditionalResult.getValidators().size() > 0) {
                    verifyInputs(entry, conditionalResult.getValidators(), Collections.unmodifiableMap(transientVars), ps);
                }

                extraPreFunctions = conditionalResult.getPreFunctions();
                extraPostFunctions = conditionalResult.getPostFunctions();

                break;
            }
        }

        // use unconditional-result if a condition hasn't been met
        //无条件Result
        if (theResults[0] == null) {
            theResults[0] = action.getUnconditionalResult();           
            
            verifyInputs(entry, theResults[0].getValidators(), Collections.unmodifiableMap(transientVars), ps);
            extraPreFunctions = theResults[0].getPreFunctions();
            extraPostFunctions = theResults[0].getPostFunctions();
        }

        if (log.isDebugEnabled()) {
            log.debug("theResult=" + theResults[0].getStep() + ' ' + theResults[0].getStatus());
        }

        if ((extraPreFunctions != null) && (extraPreFunctions.size() > 0)) {
            // run any extra pre-functions that haven't been run already
            for (Iterator iterator = extraPreFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                executeFunction(function, transientVars, ps);
            }
        }

        // go to next step
        //分支动作
        if (theResults[0].getSplit() != 0) {
        	SplitDescriptor splitDesc = wf.getSplit(theResults[0].getSplit());
        	
        	
            if (splitDesc.isDynamic()) {    	//判断是否动态生成分支，同时判断分支上的角色是否需要人工选择            
            	System.out.println("测试创建动态分支步骤的取人=====");
            	 if (splitDesc.isAutochoose()){ //判断动态分支上的操作人员，是否还要再选择，还是按固定人员进行分发
            		flowRole.setRoleType("autodynamicsplitrole"); 
            	 }else{ //需要人工再选择
            		flowRole.setRoleType("dynamicsplitrole");
            	 }
                 Map<Long,String> roleMap = new LinkedHashMap<Long, String>();
                 String strOwner=theResults[0].getOwner();
                 
                 //判断Owner中是否第一个字是$
                 String firstchar=strOwner.trim().substring(0,1);//判断是不是$开头            
                 if  (!firstchar.equals("$")) {   
                	 roleMap.put(1L,strOwner);
                 }else{
                	/*
                	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
                	*/
                	//当owner设置是取人函数时，它会自动取人，这时显示这个自动取得的人员返回给flowRole
                  	VariableResolver variableResolver = getConfiguration().getVariableResolver();
                      if (strOwner != null) {
                          Object o = variableResolver.translateVariables(strOwner, transientVars, ps);
                          strOwner = (o != null) ? o.toString() : null;
                         
                      }            	
                   	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
                     roleMap.put(1L, strOwner);
                 }
                 
                 
                 System.out.println("动态分支角色："+theResults[0].getOwner());
                 flowRole.setRoleMap(roleMap);
            }//end if 动态分支结束
            else{    
            	//动态分支但非动态分支开始
        	     // the result is a split request, handle it correctly
            	System.out.println("测试非动态分支取人===");
            	String strOwner=theResults[0].getOwner();
            	 //判断Owner中是否第一个字是$
            	if (strOwner!=null &&!strOwner.equals("")){            		
	                String firstchar=strOwner.trim().substring(0,1);//判断是不是$开头            
	                if  (firstchar.equals("$")) {   
	                	/*
	                 	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
	                 	 Map<Long,String> map=new HashMap();
	                   	flowRole.setRoleMap(map);
	                 	 return flowRole;//中断
	                 	*/
	                	
	                	//当owner设置是取人函数时，它会自动取人，这时显示这个自动取得的人员返回给flowRole
	                  	VariableResolver variableResolver = getConfiguration().getVariableResolver();
	                      if (strOwner != null) {
	                          Object o = variableResolver.translateVariables(strOwner, transientVars, ps);
	                          strOwner = (o != null) ? o.toString() : null;
	                         
	                      }            	
	                   	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
	                     Map<Long,String> roleMap = new LinkedHashMap<Long, String>();
	                     roleMap.put(1L, strOwner);
	                 	 
	                }
            	}   
            	
	            //SplitDescriptor splitDesc = wf.getSplit(theResults[0].getSplit()); zhongzk 注释掉
	            Collection results = splitDesc.getResults();
	            List splitPreFunctions = new ArrayList();
	            List splitPostFunctions = new ArrayList();
	
	            //check all results in the split and verify the input against any validators specified
	            //also build up all the pre and post functions that should be called.
	            for (Iterator iterator = results.iterator(); iterator.hasNext();) {
	                ResultDescriptor resultDescriptor = (ResultDescriptor) iterator.next();
	
	                if (resultDescriptor.getValidators().size() > 0) {
	                    verifyInputs(entry, resultDescriptor.getValidators(), Collections.unmodifiableMap(transientVars), ps);
	                }
	
	                splitPreFunctions.addAll(resultDescriptor.getPreFunctions());
	                splitPostFunctions.addAll(resultDescriptor.getPostFunctions());
	            }
	
	            // now execute the pre-functions
	            for (Iterator iterator = splitPreFunctions.iterator();
	                    iterator.hasNext();) {
	                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
	                //executeFunction(function, transientVars, ps);
	            }
	
	            if (!action.isFinish()) {
	                // now make these steps...
	                boolean moveFirst = true;
	
	                theResults = new ResultDescriptor[results.size()];
	                results.toArray(theResults);
	                
	                //zhongzk
	                int icount=0;
	                flowRole.setRoleType("nodynamicsplitrole");
	                Map<Long,String> roleMap = new LinkedHashMap<Long, String>();
	                
	                for (Iterator iterator = results.iterator();
	                        iterator.hasNext();) {
	                    ResultDescriptor resultDescriptor = (ResultDescriptor) iterator.next();
	                    Step moveToHistoryStep = null;
	
	                    if (moveFirst) {
	                        moveToHistoryStep = step;
	                    }
	
	                    long[] previousIds = null;
	
	                    if (step != null) {
	                        previousIds = new long[] {step.getId()};
	                    }
	                    
	                    //test zhongzk
	                    System.out.println("分支角色："+resultDescriptor.getOwner());
	                    icount=icount+1;//角色序号作为键值
	                    //判断此角色是否在roleMap中有了
	                    if (roleMap.containsKey(resultDescriptor.getOwner())==false){                     	
	            		   roleMap.put(Long.valueOf(icount) , resultDescriptor.getOwner());
	                    }
	                   //createNewCurrentStep(wf,resultDescriptor, entry, store, action.getId(), moveToHistoryStep, previousIds, transientVars, ps);
	                    moveFirst = false;
	                }//end for
	        		flowRole.setRoleMap(roleMap);
	            }
	
	            // now execute the post-functions
	            for (Iterator iterator = splitPostFunctions.iterator();
	                    iterator.hasNext();) {
	                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
	                //executeFunction(function, transientVars, ps);
	            }
            }//end else if  非动态分支结束
        } else if (theResults[0].getJoin() != 0) {  //合并动作
            // this is a join, finish this step...
            JoinDescriptor joinDesc = wf.getJoin(theResults[0].getJoin());
            //step = store.markFinished(step, action.getId(), new Date(), theResults[0].getOldStatus(), context.getCaller());
            //store.moveToHistory(step);

            // ... now check to see if the expression evaluates
            // (get only current steps that have a result to this join)
          
            Collection joinSteps = new ArrayList();
            joinSteps.add(step);
           

            //currentSteps = store.findCurrentSteps(id); // shouldn't need to refresh the list
            for (Iterator iterator = currentSteps.iterator();
                    iterator.hasNext();) {
                Step currentStep = (Step) iterator.next();

                if (currentStep.getId() != step.getId()) {
                    StepDescriptor stepDesc = wf.getStep(currentStep.getStepId());

                    if (stepDesc.resultsInJoin(theResults[0].getJoin())) {
                        joinSteps.add(currentStep);
                    }
                }
            }
            

            //we also need to check history steps that were finished before this one
            //that might be part of the join
            List historySteps = store.findHistorySteps(entry.getId());

            for (Iterator i = historySteps.iterator(); i.hasNext();) {
                Step historyStep = (Step) i.next();

                if (historyStep.getId() != step.getId()) {
                    StepDescriptor stepDesc = wf.getStep(historyStep.getStepId());

                    if (stepDesc.resultsInJoin(theResults[0].getJoin())) {
                        joinSteps.add(historyStep);
                    }
                }
            }
         

            JoinNodes jn = new JoinNodes(joinSteps);
            transientVars.put("jn", jn);
            
           

            //todo verify that 0 is the right value for currentstep here
          //  if (passesConditions(null, joinDesc.getConditions(), Collections.unmodifiableMap(transientVars), ps, 0)) {
          if (true) {
                // move the rest without creating a new step ...
            	 System.out.println("test join role");
               
                ResultDescriptor joinresult = joinDesc.getResult();
             

                if (joinresult.getValidators().size() > 0) {
                    //verifyInputs(entry, joinresult.getValidators(), Collections.unmodifiableMap(transientVars), ps);
                }

                // now execute the pre-functions
                /*
                for (Iterator iterator = joinresult.getPreFunctions().iterator();
                        iterator.hasNext();) {
                    FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                    //executeFunction(function, transientVars, ps);
                }
                */
                
                long[] previousIds = new long[joinSteps.size()];
                int i = 1;
                
                /*
                for (Iterator iterator = joinSteps.iterator();
                        iterator.hasNext();) {
                    Step currentStep = (Step) iterator.next();

                    if (currentStep.getId() != step.getId()) {
                        //if this is already a history step (eg, for all join steps completed prior to this one),
                        //we don't move it, since it's already history.
                        if (!historySteps.contains(currentStep)) {
                           // store.moveToHistory(currentStep);
                        }

                        previousIds[i] = currentStep.getId();
                        i++;
                    }
                }
                */
                
               // System.out.println("test");
                if (!action.isFinish()) {
                    // ... now finish this step normally
                    previousIds[0] = step.getId();
                    theResults[0] = joinDesc.getResult();

                    //we pass in null for the current step since we've already moved it to history above
                    
                    //test zhongzk
                    System.out.println("合并角色："+theResults[0].getOwner()); 
                    
                    //判断Owner中是否第一个字是$
                	String strOwner=theResults[0].getOwner();
                    String firstchar=strOwner.trim().substring(0,1);//判断是不是$开头           
                    
                    
                    Map<Long,String> roleMap = new LinkedHashMap<Long, String>();
                    if  (firstchar.equals("$")) {      
                    	/*
                    	 System.out.println("test join role2");
                     	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
                     	 Map<Long,String> map=new HashMap();
                     	 flowRole.setRoleMap(map);
                     	 return flowRole;//中断
                     	 */
                    	//当owner设置是取人函数时，它会自动取人，这时显示这个自动取得的人员返回给flowRole
                     	VariableResolver variableResolver = getConfiguration().getVariableResolver();
                         if (strOwner != null) {
                             Object o = variableResolver.translateVariables(strOwner, transientVars, ps);
                             strOwner = (o != null) ? o.toString() : null;
                            
                         }            	
                      	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
                      	 System.out.println("owner 配的是$curCaler或者${mostRecentOwner}自动取人是，用户id:"+strOwner);
                         roleMap.put(1L, strOwner);
                    }else{
                    
                       flowRole.setRoleType("nodynamicsplitrole");  
                       roleMap.put(1L,theResults[0].getOwner()); //合并的步骤只有一个角色          
                    }
            		flowRole.setRoleMap(roleMap);
            		
                    
                    //zhongzk以下一行作废
                    //createNewCurrentStep(wf,joinDesc.getResult(), entry, store, action.getId(), null, previousIds, transientVars, ps);
                }

                // now execute the post-functions
                /*
                for (Iterator iterator = joinresult.getPostFunctions().iterator();
                        iterator.hasNext();) {
                    FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                    //executeFunction(function, transientVars, ps);
                }
                */
            }
        } else { //普通动作
            // normal finish, no splits or joins
        	 //判断Owner中是否第一个字是$
            
        	String strOwner=theResults[0].getOwner();
            String firstchar=strOwner.trim().substring(0,1);//判断是不是$开头            
            if  (firstchar.equals("$")) {   
            	/*
             	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
             	 Map<Long,String> map=new HashMap();
             	flowRole.setRoleMap(map);
             	 return flowRole;//中断
             	 */
             	 
             	//当owner设置是取人函数时，它会自动取人，这时显示这个自动取得的人员返回给flowRole
             	VariableResolver variableResolver = getConfiguration().getVariableResolver();
                 if (strOwner != null) {
                     Object o = variableResolver.translateVariables(strOwner, transientVars, ps);
                     strOwner = (o != null) ? o.toString() : null;
                    
                 }            	
              	 flowRole.setRoleType("prestepowner");//表示此步骤由流程自动取人，不需要人工选择人员
              	 Map<Long,String> map=new LinkedHashMap();
              	 map.put(1L, strOwner);
              	flowRole.setRoleMap(map);
              	return flowRole;//中断
            }

        	
            long[] previousIds = null;

            if (step != null) {
                previousIds = new long[] {step.getId()};
            }

            if (!action.isFinish()) {
            	
            	//zhongzk
                System.out.println("无条件Owner:"+theResults[0].getOwner());//zhongzk test 

                flowRole.setRoleType("nodynamicsplitrole");
                Map<Long,String> roleMap = new LinkedHashMap<Long, String>();
        		roleMap.put(1L,theResults[0].getOwner()); //普通步骤只有一个角色
        		flowRole.setRoleMap(roleMap);
                //createNewCurrentStep(wf,theResults[0], entry, store, action.getId(), step, previousIds, transientVars, ps);
            }
        }

        // postFunctions (BOTH)
        if (extraPostFunctions != null) {
            for (Iterator iterator = extraPostFunctions.iterator();
                    iterator.hasNext();) {
                FunctionDescriptor function = (FunctionDescriptor) iterator.next();
                //executeFunction(function, transientVars, ps);
            }
        }

        List postFunctions = action.getPostFunctions();

        for (Iterator iterator = postFunctions.iterator(); iterator.hasNext();) {
            FunctionDescriptor function = (FunctionDescriptor) iterator.next();
            //executeFunction(function, transientVars, ps);
        }

        //if executed action was an initial action then workflow is activated ，初始动作
        if ((wf.getInitialAction(action.getId()) != null) && (entry.getState() != WorkflowEntry.ACTIVATED)) {
           // changeEntryState(entry.getId(), WorkflowEntry.ACTIVATED);
        }

        //if it's a finish action, then we halt
        //若此动作是结束动作，则流程实例结束，设为4
        if (action.isFinish()) {
           // completeEntry(action, entry.getId(), getCurrentSteps(entry.getId()), WorkflowEntry.COMPLETED);

            //return true;
            //zhongzk
            return flowRole;
        }

        //get available autoexec actions
        int[] availableAutoActions = getAvailableAutoActions(entry.getId(), inputs);

        //we perform the first autoaction that applies, not all of them.
        if (availableAutoActions.length > 0) {
           // doAction(entry.getId(), availableAutoActions[0], inputs);
        }

        //return false;
        //zhongzk
        return flowRole;
    }

    //从角色人员rolemap中取得某一个角的人员
    private String getUseridByRoleName(Map<String,String> rolemap,String rolename){
    	
    	Set keySet = rolemap.keySet();
    	  for (Iterator<?> iter = keySet.iterator(); iter.hasNext();){
    	   String key = (String) iter.next();
    	   String value = (String) rolemap.get(key);
    	   if (rolename.equals(key)==true){
    		   return value;
    	   }
    	   }
    	return null;
    }

    
}