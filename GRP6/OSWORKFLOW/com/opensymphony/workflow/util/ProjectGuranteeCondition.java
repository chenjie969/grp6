package com.opensymphony.workflow.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.Condition;
import com.opensymphony.workflow.WorkflowException;
import com.zjm.pro.db.model.Pro_finish;
import com.zjm.pro.finish.service.Pro_finishService;
/**
 * <p>完结解保子流程条件 - 有无保证金</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有保证金-需经过子公司或母公司财务审核</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;无保证金-直接风控审核</p>
 * 
 * @author bulf
 *
 */
public class ProjectGuranteeCondition implements Condition {
	/**
	 * 日志记录
	 */
	private Logger log = LoggerFactory.getLogger(ProjectGuranteeCondition.class);
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean passesCondition(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		
		String projectId = transientVars.get("projectid")==null?"":transientVars.get("projectid").toString();
		
		if ("".equals(projectId)) {
			throw new WorkflowException("projectid is expected");
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
					return true;
				}else{
					return false;
				}
			}else{
				log.error("缺少项目信息");
				throw new WorkflowException("缺少项目信息");
			}
		} catch (WorkflowException e) {
			log.error(e.getMessage(), e);
			throw new WorkflowException(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WorkflowException("有无保证金判断失败");
		}
        
	}
}
