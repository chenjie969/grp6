<style>
	table tr th{
	text-align:center;
	}
</style>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<link rel="stylesheet" href="/plugins/bootstraptable/bootstrap-table.css" />
<script src="/plugins/bootstraptable/bootstrap-table.js?"></script>
<script src="/plugins/bootstraptable/locale/bootstrap-table-zh-CN.js?></script>
<script src="/plugins/bootstraptable/extensions/export/bootstrap-table-export.js?"></script>



<div class="page-content">
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
                              <label class="col-sm-4 control-label no-padding-right">客户名称： </label>
                              <label class="col-sm-8 grey">
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

                          <div class="form-group">
                              <label class="col-sm-2"><strong>业务申请明细：</strong></label>
                              <div class="col-sm-12" >
                                  <table style="font-size:13px;text-align:center;" id="no" 
                                         data-toggle="table"                                                                             
                                         data-striped="true">
                                      <thead>
                                        <tr >
                                            <th>项目类型</th>
                                            <th>合作机构</th>
                                            <th>业务品种</th>
                                            <!-- <th>绿色通道</th> -->
                                            <th>申请金额(万元) </th>
                                            <th>申请期限</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${applyDetailList}" var="applyDetail" >  
									    <tr>  
									     <td>${applyDetail.projectTypeName}</td>  
									     <td>${applyDetail.bankName}</td>  
									     <td>${applyDetail.busiTypeName}</td>  
									     <%-- <td>${applyDetail.greenChannelName}</td>  --%> 
									     <td>
									     <fmt:formatNumber value="${applyDetail.applySum}" pattern="###,###.######"> </fmt:formatNumber>									   									     
									     </td>									       
									     <td>${applyDetail.periodMonthDay}</td>  
									    </tr>  
									</c:forEach>  
                                        
                                   </tbody>
                                  </table> <!-- end table -->
                              </div>

                          </div>

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
</div> 
<%-- ​<%@ include file="/common_foot.jsp" %> --%>