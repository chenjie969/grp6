/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.util;

import com.opensymphony.module.propertyset.PropertySet;

import com.opensymphony.util.TextUtils;

import com.opensymphony.workflow.*;
import com.opensymphony.workflow.spi.Step;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.opensymphony.workflow.spi.WorkflowStore;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_finish;
import com.zjm.pro.finish.service.Pro_finishService;

import java.math.BigDecimal;
import java.util.*;


/**
 * <p>针对退回上一步时 上一步存在多个的情况</p>
 * 
 * <p>condition：判定时需要的参数	</p>
 * @author bailf
 *
 */
public class Expand_MostRecentOwner implements FunctionProvider {

    public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
        // expects a stepId name/value pair
        String condtion = (String) args.get("condition");
        String []steps = condtion.split(",");
        String stepIdString = null;
        String projectId = transientVars.get("projectId")==null?"":transientVars.get("projectId").toString();
		
		if ("".equals(projectId)) {
			throw new WorkflowException("projectId is expected");
		}
		//判断有无保证金
		Pro_finishService finishService = (Pro_finishService) SpringContextUtil.getBean("proFinishServiceImpl");
		Map<String, Object> map = new HashMap<>(); 
		map.put("applyId", projectId);
		map.put("finishstate", "审批中");
        Pro_finish finish;
		try {
			//发起子流程控制  保证单个项目完结解保审批中只有一个
			finish = finishService.getOne(map);
	        if (finish != null) {
	        	if (null != finish.getMargin() 
	        			&& !"".equals(finish.getMargin())
	        			&& BigDecimal.ZERO.compareTo(finish.getMargin()) < 0) {
	        		for (String string : steps) {
						if ("有".indexOf(string) != -1) {
							stepIdString = string.substring(0, 3);
						}
					}
				}else{
					for (String string : steps) {
						if ("无".indexOf(string) != -1) {
							stepIdString = string.substring(0, 3);
						}
					}
				}
			}else{
				throw new WorkflowException("缺少项目信息");
			}
		} catch (WorkflowException e) {
			throw new WorkflowException(e.getMessage(), e);
		} catch (Exception e) {
			throw new WorkflowException("有无保证金判断失败");
		}
        WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");

        if (stepIdString == null) {
            throw new WorkflowException("This function expects a stepId!");
        }

        StringTokenizer st = new StringTokenizer(stepIdString, ",");
        List stepIds = new LinkedList();

        while (st.hasMoreTokens()) {
            stepIds.add(st.nextToken().trim());
        }

        WorkflowStore store = (WorkflowStore) transientVars.get("store");
        List historySteps = store.findHistorySteps(entry.getId());

        for (Iterator iterator = historySteps.iterator(); iterator.hasNext();) {
            Step step = (Step) iterator.next();

            if (stepIds.contains(String.valueOf(step.getStepId())) && TextUtils.stringSet(step.getOwner())) {
                transientVars.put("mostRecentOwner", step.getOwner());

                break;
            }
        }
    }
}
