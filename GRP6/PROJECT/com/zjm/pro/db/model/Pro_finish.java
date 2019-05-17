package com.zjm.pro.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 完结解保实体
 * @author bailf
 * @version 1.0
 * @since 2018-03-23 14:51:41
 */
public class Pro_finish implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    /**
    * 完结解保ID
    */
    private String finishId;
    /**
    * 
    */
    private Long finishIdOld;
    /**
    * 项目原id
    */
    private Long projectIdOld;
    /**
    * 关联项目id
    */
    private String projectId;
    /**
    * 项目申请id
    */
    private String applyId;
    /**
    * 保证金
    */
    private BigDecimal margin;
    /**
    * 备注
    */
    private String remark;
    /**
    * 创建人id
    */
    private String operationmanid;
    /**
    * 创建人名字
    */
    private String operationmanname;
    /**
    * 
    */
    private String unitUid;
    /**
    * 更新人
    */
    private String updateusername;
    /**
    * 更新时间
    */
    private Date updatedatetime;
    /**
    * 审批状态（中文：待审批/审批中/通过/未通过）
    */
    private String finishstate;
    
    /**
    * 获取完结解保ID
    *
    * @return 完结解保ID
    */
    public String getFinishId(){
        return finishId;
    }
    
    /**
     * 设置完结解保ID
     * 
     * @param finishId 要设置的完结解保ID
     */
    public void setFinishId(String finishId){
        this.finishId = finishId;
    }

    /**
    * 获取
    *
    * @return 
    */
    public Long getFinishIdOld(){
        return finishIdOld;
    }
    
    /**
     * 设置
     * 
     * @param finishIdOld 要设置的
     */
    public void setFinishIdOld(Long finishIdOld){
        this.finishIdOld = finishIdOld;
    }

    /**
    * 获取项目原id
    *
    * @return 项目原id
    */
    public Long getProjectIdOld(){
        return projectIdOld;
    }
    
    /**
     * 设置项目原id
     * 
     * @param projectIdOld 要设置的项目原id
     */
    public void setProjectIdOld(Long projectIdOld){
        this.projectIdOld = projectIdOld;
    }

    /**
    * 获取关联项目id
    *
    * @return 关联项目id
    */
    public String getProjectId(){
        return projectId;
    }
    
    /**
     * 设置关联项目id
     * 
     * @param projectId 要设置的关联项目id
     */
    public void setProjectId(String projectId){
        this.projectId = projectId;
    }

    /**
    * 获取项目申请id
    *
    * @return 项目申请id
    */
    public String getApplyId(){
        return applyId;
    }
    
    /**
     * 设置项目申请id
     * 
     * @param applyId 要设置的项目申请id
     */
    public void setApplyId(String applyId){
        this.applyId = applyId;
    }

    /**
    * 获取保证金
    *
    * @return 保证金
    */
    public BigDecimal getMargin(){
        return margin;
    }
    
    /**
     * 设置保证金
     * 
     * @param margin 要设置的保证金
     */
    public void setMargin(BigDecimal margin){
        this.margin = margin;
    }

    /**
    * 获取备注
    *
    * @return 备注
    */
    public String getRemark(){
        return remark;
    }
    
    /**
     * 设置备注
     * 
     * @param remark 要设置的备注
     */
    public void setRemark(String remark){
        this.remark = remark;
    }

    /**
    * 获取创建人id
    *
    * @return 创建人id
    */
    public String getOperationmanid(){
        return operationmanid;
    }
    
    /**
     * 设置创建人id
     * 
     * @param operationmanid 要设置的创建人id
     */
    public void setOperationmanid(String operationmanid){
        this.operationmanid = operationmanid;
    }

    /**
    * 获取创建人名字
    *
    * @return 创建人名字
    */
    public String getOperationmanname(){
        return operationmanname;
    }
    
    /**
     * 设置创建人名字
     * 
     * @param operationmanname 要设置的创建人名字
     */
    public void setOperationmanname(String operationmanname){
        this.operationmanname = operationmanname;
    }

    /**
    * 获取
    *
    * @return 
    */
    public String getUnitUid(){
        return unitUid;
    }
    
    /**
     * 设置
     * 
     * @param unitUid 要设置的
     */
    public void setUnitUid(String unitUid){
        this.unitUid = unitUid;
    }

    /**
    * 获取更新人
    *
    * @return 更新人
    */
    public String getUpdateusername(){
        return updateusername;
    }
    
    /**
     * 设置更新人
     * 
     * @param updateusername 要设置的更新人
     */
    public void setUpdateusername(String updateusername){
        this.updateusername = updateusername;
    }

    /**
    * 获取更新时间
    *
    * @return 更新时间
    */
    public Date getUpdatedatetime(){
        return updatedatetime;
    }
    
    /**
     * 设置更新时间
     * 
     * @param updatedatetime 要设置的更新时间
     */
    public void setUpdatedatetime(Date updatedatetime){
        this.updatedatetime = updatedatetime;
    }

    /**
    * 获取审批状态（中文：待审批/审批中/通过/未通过）
    *
    * @return 审批状态（中文：待审批/审批中/通过/未通过）
    */
    public String getFinishstate(){
        return finishstate;
    }
    
    /**
     * 设置审批状态（中文：待审批/审批中/通过/未通过）
     * 
     * @param finishstate 要设置的审批状态（中文：待审批/审批中/通过/未通过）
     */
    public void setFinishstate(String finishstate){
        this.finishstate = finishstate;
    }

}