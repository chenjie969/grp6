package com.opensymphony.workflow.timer;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zjm.pro.project.service.ProjectService;

import tool.util.DateUtil;




/**
 * 定时任务主方法
 * @Async 添加异步调度，默认是同步的
 * @author ssh
 *
 */
@Component
public class QuartzJob {
	
	private static final Logger LOG = LoggerFactory.getLogger(QuartzJob.class);
	
	@Resource
	private ProjectService projectService;
	
	/**
	 * 0点计算订单逾期罚息信息
	 */
	
	@Scheduled(cron="0 0 0 * * ?")
	public void doOverDue() {
		Long start = System.currentTimeMillis();
		LOG.info("开始计算逾期订单罚息明细，时间{}", new Date());
		
		projectService.insertOverDueInfo();
		
		Long interval = System.currentTimeMillis() - start;
		LOG.info("计算逾期订单罚息明细结束，时间{}，用时{}ms", new Date(), interval);
	}
	
	

}
