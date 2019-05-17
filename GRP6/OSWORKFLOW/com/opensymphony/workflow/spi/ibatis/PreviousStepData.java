/** 
* @author 作者 E-mail: zhongzk@bjsurong.com
* @version 创建时间：Dec 8, 2011 10:34:33 PM 
* 类说明： 
*/ 
package com.opensymphony.workflow.spi.ibatis;

public class PreviousStepData {
    private Long id;
    private Long previousId;
    
    public Long getId() {
            return id;
    }
    
    public void setId(Long id) {
            this.id = id;
    }
    
    public Long getPreviousId() {
            return previousId;
    }
    
    public void setPreviousId(Long previousId) {
            this.previousId = previousId;
    }
    
}
