package com.opensymphony.workflow.util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.Condition;
import com.opensymphony.workflow.JoinNodes;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.Step;
public class RejectJoinCondition implements Condition{
public boolean passesCondition(Map transientVars, Map args, PropertySet ps)   
    throws WorkflowException {   
 JoinNodes jn = (JoinNodes)transientVars.get("jn");   
    
 Collection steps  = (Collection)jn.getSteps();   
 Iterator it = steps.iterator();   
 Step step = null;   
 boolean result = false;   
 while(it.hasNext()){   
     step = (Step)it.next();   
    result = result || "Rejected".equals(step.getStatus());   
 }   
 return result;   
 }   
}
