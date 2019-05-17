<style>
	table tr th{
	text-align:center;
	}
</style>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div  class="page-content">
		<div class="page-header">
			<h4>查看申请登记信息</h4>
		</div>
         <form class="form-horizontal" role="form">

                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">业务性质： </label>
                              <label class="col-sm-8 grey">
                                 	  ${applyDetail.busiNatureName}
                              </label>
                          </div>
                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">项目类型： </label>
                              <label class="col-sm-8 grey">
                                 	  ${applyDetail.projectTypeName}
                              </label>
                          </div>

                        <%--   <div class="form-group ">
                              <label class="col-sm-2 control-label no-padding-right">客户类型： </label>
                              <label class="col-sm-10 grey">
                                     	  ${apply.clientName}
                              </label>
                          </div> --%>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">客户名称： </label>
                              <label class="col-sm-10 grey">
                                	 ${applyDetail.clientName}
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">项目名称： </label>
                              <label class="col-sm-10 grey">
                               	   ${applyDetail.projectName}
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">项目来源： </label>
                              <label class="col-sm-10 grey">
                                 	${applyDetail.projectSourceName}
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">来源说明： </label>
                              <label class="col-sm-10 grey">
 									${applyDetail.sourceDesc}	
                              </label>
                          </div>
                          
                           <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">借款用途及还款来源： </label>
                              <label class="col-sm-10 grey">
 									${applyDetail.applySumUse}	
                              </label>
                          </div>

                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">业务品种： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.busiTypeName}		 
                              </label>
                          </div>
                         <%--  <div class="form-group col-sm-6 ">
                              <label class="col-sm-4 control-label no-padding-right">绿色通道： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.greenChannelName}			 
                              </label>
                          </div> --%>
                          <div class="form-group col-sm-6" >
                              <label class="col-sm-4 control-label no-padding-right">申请金额： </label>
                              <label class="col-sm-8 grey">
									<fmt:formatNumber value="${applyDetail.applySum}" pattern="###,###.######"> </fmt:formatNumber>
									  &nbsp;万元
                              </label>
                          </div>
                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">申请期限： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.periodMonthDay}		  
                              </label>
                          </div>
                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">合作机构： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.bankName}	 
                              </label>
                          </div>
                         <%--  <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">贷款(担保)用途： </label>
                              <label class="col-sm-10 grey">
								    ${applyDetail.loadUsed}	 
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">还款计划和来源： </label>
                              <label class="col-sm-10 grey">
                               		${applyDetail.repaymentPlan}	 
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">拟提供的保证措施： </label>
                              <label class="col-sm-10 grey">
									 ${applyDetail.provideGuaranty}
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">备注： </label>
                              <label class="col-sm-10 grey">
 									${applyDetail.otherDesc}
                              </label>
                          </div> --%>


                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">经办部门： </label>
                              <label class="col-sm-8 grey">
                                 	 ${applyDetail.departName}
                              </label>
                          </div>

                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">经办人： </label>
                              <label class="col-sm-8 grey">
                                 	 ${applyDetail.createManName}
                              </label>
                          </div>
							 <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">A角： </label>
                              <label class="col-sm-8 grey">
                                 	 ${applyDetail.amanName}
                              </label>
                          </div>
                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">B角： </label>
                              <label class="col-sm-8 grey">
                                 	 ${applyDetail.bmanName}
                              </label>
                          </div>
                          <div class="form-group">
                              <label class="col-md-2 control-label no-padding-right">受理日期： </label>
                              <label class="col-md-10 grey">
                                 <fmt:formatDate value="${applyDetail.createDate}" pattern="yyyy-MM-dd"/>                                  
                              </label>
                          </div>

                      </form>
 						<!-- <button type="button" class="btn btn-default" data-dismiss="modal">
                                    <i class="icon-remove bigger-110"></i>
                            	关闭
                        </button> -->
                        <!-- <div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
					       <button class="btn btn-primary btn_applyUpdate" value="0" type="button"><i class="icon-ok bigger-110"></i>保存</button>
					        &nbsp; &nbsp; &nbsp;
					      
					       <button class="btn btn_colse" type="button" value="0"><i class="icon-remove bigger-110 "></i>关闭</button>
			            </div>
			            </div>  -->

   <!-- 
              <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">查看申请登记</h4>
                  </div>
                  <div class="modal-body">
                      


                  </div>
                  <div class="modal-footer">

                       
                  </div>
                </div>
              </div> -->
</div> 
<%-- ​<%@ include file="/common_foot.jsp" %> --%>