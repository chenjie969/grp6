package com.opensymphony.workflow.util;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.util.SystemSession;

/**
 * <p>
 * 描述：&nbsp;&nbsp;项目完结 - 改变子流程主表外其他表状态
 * </p>
 * 
 * <p>
 * 动作：&nbsp;&nbsp;目前只更改pro_project表的完结状态；
 * </p>
 * 
 * <p>
 * 业务：&nbsp;&nbsp;融投项目完结分线上线下结合完成; <br>
 * 针对线下 完结解保最后节点风控部门跟进相关反担保物；<br>
 * 线上这里通过就意味着线上业务结束
 * </p>
 * 
 * @author bailf
 *
 */
@Component
public class Function_FinishRelieveModifyState implements FunctionProvider {

	/**
	 * 日志工具
	 */
	private Logger log = LoggerFactory.getLogger(Function_FinishRelieveModifyState.class);
	
	@Override
	public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		String applyId = transientVars.get("projectid") == null ? "" : transientVars.get("projectid").toString();
		if ("".equals(applyId)) {
			throw new WorkflowException("projectid is expected");
		}
		
		try {
			ProjectService projectService = (ProjectService) SpringContextUtil.getBean("projectService");
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and apply_ID = '"+applyId+"'");
			if (null != project) {
				Pro_project new_pro = new Pro_project();
				new_pro.setProject_ID(project.getProject_ID());
				new_pro.setUpdateDateTime(new Date());
				new_pro.setUpdateUserName(SystemSession.getUserSession().getUser_name());
				new_pro.setIsFree(1);
				projectService.updateOneProjectInfo(SystemSession.getUserSession(), new_pro);
				log.info("完结解保 更新project成功");
			}else{
				throw new WorkflowException("project info is expected");
			}
		} catch (WorkflowException e) {
			log.error(e.getMessage(), e);
			throw new WorkflowException(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WorkflowException("更改业务完结状态失败", e);
		}
	}
}
