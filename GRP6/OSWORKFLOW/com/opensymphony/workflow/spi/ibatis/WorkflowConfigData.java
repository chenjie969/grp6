/** 
* @author ���� E-mail: zhongzk@bjsurong.com
* @version ����ʱ�䣺Dec 8, 2011 10:33:18 PM 
* ��˵���� 
*/ 
package com.opensymphony.workflow.spi.ibatis;

public class WorkflowConfigData {
    private String name;
    private String descriptor;
    
    public String getDescriptor() {
            return descriptor;
    }
    
    public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
    }
    
    public String getName() {
            return name;
    }
    
    public void setName(String name) {
            this.name = name;
    }
    
}