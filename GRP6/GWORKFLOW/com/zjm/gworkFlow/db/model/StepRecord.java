package com.zjm.gworkFlow.db.model;

/**
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2015-1-19 下午8:04:52 类说明：
 */
public class StepRecord {
	private String optionalItem;// 可选事项
	private String flowBuild;// 流程构件

	public String getOptionalItem() {
		return optionalItem;
	}

	public void setOptionalItem(String optionalItem) {
		this.optionalItem = optionalItem;
	}

	public String getFlowBuild() {
		return flowBuild;
	}

	public void setFlowBuild(String flowBuild) {
		this.flowBuild = flowBuild;
	}
}
