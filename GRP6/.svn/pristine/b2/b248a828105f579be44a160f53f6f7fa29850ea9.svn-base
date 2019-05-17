/** 
 * @author ���� E-mail: zhongzk@bjsurong.com
 * @version ����ʱ�䣺Dec 30, 2011 3:08:30 PM 
 * ��˵���� 
 */
package com.opensymphony.workflow.spi.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowContext;
import com.opensymphony.workflow.basic.BasicWorkflowContext;
import com.opensymphony.workflow.loader.WorkflowDescriptor;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ApplicationContext cxt =
		// WebApplicationContextUtils.getWebApplicationContext(this.getServletConfig().getServletContext());
		ApplicationContext cxt = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");
		Workflow wf = (Workflow) cxt.getBean("workflow");
			
		

		try {

		   //���һ����������ʼ���̲���	
		//	long id = wf.initialize("example", 100, null);
		   //���������е�����ʵ�����
			long id=1;

		//	System.out.println("id:" + id);
			
			//ִ�ж�������
//			wf.doAction(6, 201, null);
			Map<String,Long> rolemap=new HashMap();
			//wf.doAction(6, 201, null,rolemap);
			
			
			
			//ȡ��ĳ�������ϵ����ж���ID����			
			int[] actions = wf.getOneCurStepAvailableActions(id,2,"admin",null);
		    WorkflowDescriptor wd =  wf.getWorkflowDescriptor(wf.getWorkflowName(id));
			 
			 for (int i = 0; i < actions.length; i++) {
			        String name = wd.getAction(actions[i]).getName();//��ݶ���ID,ȡ�ö������
			        System.out.println("actionName:"+name);
			  }       

		} catch (Exception e) {
			System.out.println("error:" + e);
		}

		
		
		System.out.println("actions:"+wf.getOneCurStepAvailableActions(7,1,"admin",null).length);

	}

}
