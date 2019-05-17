/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow;

import com.opensymphony.workflow.spi.Step;

import java.util.*;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision: 1.1 $
 */
public class JoinNodes {
    //~ Instance fields ////////////////////////////////////////////////////////

    private Collection steps;
    private DummyStep dummy = new DummyStep();

    //~ Constructors ///////////////////////////////////////////////////////////

    public JoinNodes(Collection steps) {
        this.steps = steps;
    }

    //~ Methods ////////////////////////////////////////////////////////////////
  //zhongzk 取得所有的步骤
    public Collection getSteps(){
    	return steps;
    }
    
    public Step getStep(int stepId) {
        for (Iterator iterator = steps.iterator(); iterator.hasNext();) {
            Step step = (Step) iterator.next();

            if (step.getStepId() == stepId) {
                return step;
            }
        }

        // no match, not ready to join ...
        // ... so return a dummy step that is always false
        return dummy;
    }

    public Step getStep(int stepId, String owner) {
        for (Iterator iterator = this.steps.iterator(); iterator.hasNext(); ) {
          Step step = (Step)iterator.next();
          if ((step.getStepId() == stepId) && (step.getOwner().equals(owner))) {
            return step;
          }

        }

        return this.dummy;
      }
    
    //~ Inner Classes //////////////////////////////////////////////////////////

    private static class DummyStep implements Step {
        public int getActionId() {
            return -1;
        }

        public String getCaller() {
            return null;
        }

        public Date getDueDate() {
            return null;
        }

        public long getEntryId() {
            return -1;
        }

        public Date getFinishDate() {
            return null;
        }

        public long getId() {
            return -1;
        }

        public String getOwner() {
            return null;
        }

        public long[] getPreviousStepIds() {
            return new long[0];
        }

        public Date getStartDate() {
            return null;
        }

        public String getStatus() {
            return null;
        }

        public int getStepId() {
            return -1;
        }
        
        //zhongzk 2012.04.22增加步骤名称
        public String getStepName() {
            return null;
        }
        
    }
}
