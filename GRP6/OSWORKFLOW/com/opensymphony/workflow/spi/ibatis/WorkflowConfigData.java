/** 
* @author 作者 E-mail: zhongzk@bjsurong.com
* @version 创建时间：Dec 8, 2011 10:33:18 PM 
* 类说明： 
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