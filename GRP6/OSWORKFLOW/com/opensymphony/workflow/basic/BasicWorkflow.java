/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
/*
 * Created by IntelliJ IDEA.
 * User: plightbo
 * Date: Apr 29, 2002
 * Time: 11:12:05 PM
 */
package com.opensymphony.workflow.basic;

import com.opensymphony.workflow.AbstractWorkflow;
import com.zjm.common.db.model.User;
import com.zjm.util.SystemSession;


/**
 * A basic workflow implementation which does not read in
 * the current user from any context, but allows one to be
 * specified via the constructor. Also does not support rollbacks.
 */
public class BasicWorkflow extends AbstractWorkflow {
    //~ Constructors ///////////////////////////////////////////////////////////

    public BasicWorkflow(String caller) {
      //  super.context = new BasicWorkflowContext(caller);//zhongzk 
    	System.out.println(">>>>>>>>>>>>====BasicWorkflow");
      /*����Ϊ�޸ĺ�,zhongzk 2012.04.27*/
    	try {
    	if (SystemSession.getUserSession()==null){
    		System.out.println("zhongzk----1");
    		super.context = new BasicWorkflowContext("zhongzk"); //测试用per.context = new 
    	}else{
    		
    		System.out.println(SystemSession.getUserSession().getUser_uid());
            super.context = new BasicWorkflowContext(SystemSession.getUserSession().getUser_uid()); 
    	}
    	} catch (Exception e) {
    		System.out.println("zhongzk----2");
    		super.context = new BasicWorkflowContext("zhongzk"); //测试用per.context = new 
		}
    }
}
