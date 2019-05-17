/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.util;

import com.opensymphony.module.propertyset.PropertySet;

import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowContext;
import com.zjm.common.db.model.User;
import com.zjm.util.SystemSession;

import java.util.Map;


/**
 * 取得当前用户
 *
 * @author zhongzk
 * @version $Revision: 1.1 $
 */
public class CurCaller implements FunctionProvider {
    //~ Methods ////////////////////////////////////////////////////////////////

    public void execute(Map transientVars, Map args, PropertySet ps) {
        transientVars.put("curCaller", SystemSession.getUserSession().getUser_uid());
    }
}
