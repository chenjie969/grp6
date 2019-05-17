<style>
	table{
	font-size:13px;
	text-align:center;
	}
	table tr th{
	border:1px solid #ddd;
	text-align: center;
	};
	table tr td{
	border:1px solid #ddd;
	text-align: center;
	};
</style>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

	<div class="page-content">
		<div class="page-header">
			<h4>收费登记</h4>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                	<input type="hidden" id="hidden_applyID" value="${urlParam.entityID}">
                	<input type="hidden" id="openType" value="${urlParam.type}">
                	
                	
					<c:forEach items="${meetingDetailList}" var="meetingDetail">
						<div class="col-sm-12">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-flat">
									<h4 class="smaller lighter orange">
										${meetingDetail.busiTypeName} |
										<fmt:formatNumber value=" ${meetingDetail.agreeSum}" pattern="###,###.######"> </fmt:formatNumber>万元 | 
										${meetingDetail.periodMonthDay}
										${meetingDetail.bankName}
									</h4>
									<div class="widget-toolbar" style="height:37px;">
										<a href="#" data-action="collapse" style="margin-top:10px;"><i class="icon-chevron-up"></i></a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-body-inner" style="display: block;">
										<div class="widget-main no-padding">
											<h5 style="line-height: 26px;" class="col-sm-6">业务品种：<span class="grey">${meetingDetail.busiTypeName}</span></h5>
											<h5 style="line-height: 26px;" class="col-sm-6">合作机构：<span class="grey">${meetingDetail.bankName}</span></h5>
											<h5 style="line-height: 26px;" class="col-sm-6">担保金额：<span class="grey">
											<fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"> </fmt:formatNumber>
											</span>万元</h5>
											<h5 style="line-height: 26px;" class="col-sm-6">担保期限：<span class="grey">${meetingDetail.periodMonthDay}</span></h5>
											<h5 style="line-height: 26px;" class="col-sm-6">担保责任范围：<span class="grey">${meetingDetail.guarantyScope}</span></h5>
											<h5 style="line-height: 26px;" class="col-sm-6">责任金额：<span class="grey">
											<fmt:formatNumber value="${meetingDetail.guarantyDutySum}" pattern="###,###.######"> </fmt:formatNumber>
											</span>万元</h5>
											<h5 style="line-height: 26px;" class="col-sm-6">评审费率：<span class="grey">${meetingDetail.reviewRate}</span>％</h5>
											<h5 style="line-height: 26px;" class="col-sm-6">担保费率：<span class="grey">${meetingDetail.guarantyRate}</span>％</h5>
											<h5 style="line-height: 26px;" class="col-sm-6">保证金比例：<span class="grey">${meetingDetail.bzScale}</span>％</h5>
										</div>
									</div>
								</div>
							</div>
					</div>
						
				<%-- 	</c:forEach> --%>
					<!-- </div> -->
                    <div class="col-sm-12">
                    	<div class="widget-box transparent">
                    		<div class="widget-header widget-header-flat">
								<h4 class="smaller lighter orange">
									财务收费确认
								</h4>
								<div class="widget-toolbar" style="height:37px;">
									<a href="#" data-action="collapse" style="margin-top:10px;"><i class="icon-chevron-up"></i></a>
								</div>
							</div>
							<div class="widget-body">
								<div class="widget-body-inner" style="display: block;">
									<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>放款计划： 第1笔</h5>			
											</div>
											<div class="widget-body"  style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="row">
														<h5 style="line-height: 26px;" class="col-sm-6">计划放款金额：<span class="grey"><fmt:formatNumber value="${meetingDetail.agreeSum}1000" pattern="###,###.######"> </fmt:formatNumber>
														</span>万元</h5>
														<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">${meetingDetail.periodMonth}12个月 ${meetingDetail.periodMonth}20天</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">年利率：<span class="grey">${meetingDetail.reviewRate}11</span>％</h5>
														<h5 style="line-height: 26px;" class="col-sm-6">计划放款日期：<span class="grey">
														 <fmt:formatDate value="${meetingDetail.updateDateTime}" pattern="yyyy-MM-dd"/>    
														</span></h5>
													</div>
												</div>
											</div>
									 	</div>
					    			</div>
									<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>还款计划： 第1笔</h5>			
											</div>
											<div class="widget-body" style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="table-responsive">
												     <!--  <table id="table_costDelay" style="font-size:13px !important;"></table>   -->
														     <table class="table table-striped table-bordered table-hover" id="no" data-toggle="table" data-striped="true">
							                                      <thead>
								                                        <tr>
								                                            <th>序号</th>
								                                            <th>计划还款日期</th>
								                                            <th>计划还款金额（万元）</th>
								                                       </tr>
								                                    </thead>
						                                   <%--  <c:forEach items="12" var="applyDetail" >   --%>
																	    <tr>  
																		     <td>1</td>  
																		     <td>2017-7-7</td>  
																		     <td>
																		     <fmt:formatNumber value="1200" pattern="###,###.######"> </fmt:formatNumber>									   									     
																		     </td>									       
																	    </tr> 
																	   
														<%-- 	</c:forEach>   --%>
						                                        
						                                  </table> <!-- end table -->
												     
										           </div>
												</div>
											</div>
										 </div>
								    </div>
									<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>应收费用： 第1笔</h5>			
											</div>
											<div class="widget-body"  style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="table-responsive">
												      <!-- <table id="table_costMust" style="font-size:13px !important;"></table>  -->
												       <table class="table table-striped table-bordered table-hover" id="no" data-toggle="table" data-striped="true">
					                                      <thead>
						                                        <tr>
						                                            <th>序号</th>
						                                            <th>费用类型</th>
						                                            <th>费率（%）</th>
						                                            <th>应收金额（元）</th>
						                                            <th>状态</th>
						                                            <th>操作</th>
						                                       </tr>
						                                    </thead>
				                                   <%--  <c:forEach items="12" var="applyDetail" >   --%>
															    <tr>  
																     <td>1</td>  
																     <td>担保费</td>  
																     <td>12</td>  
																     <td>
																     <fmt:formatNumber value="12" pattern="###,###.######"> </fmt:formatNumber>									   									     
																     </td>									       
																     <td>未收到</td>  
																     <td><a href="javascript:void(0) " class="btn_confirmationCostMust">到账确认</a></td>  
															    </tr> 
															   
												<%-- 	</c:forEach>   --%>
				                                        
				                                  </table> <!-- end table -->
										           </div>
												</div>
											</div>
										 </div>
								    </div>
									<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>预收费用： 第1笔</h5>			
											</div>
											<div class="widget-body"  style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="table-responsive">
												     <!--  <table id="table_costMust" style="font-size:13px !important;"></table>   -->
												     <table class="table table-striped table-bordered table-hover" id="no" data-toggle="table" data-striped="true">
					                                      <thead>
						                                        <tr>
						                                            <th>序号</th>
						                                            <th>费用类型</th>
						                                            <th>费率（%）</th>
						                                            <th>预收金额（元）</th>
						                                            <th>状态</th>
						                                            <th>操作</th>
						                                       </tr>
						                                    </thead>
				                                   <%--  <c:forEach items="12" var="applyDetail" >   --%>
															    <tr>  
																     <td>1</td>  
																     <td>担保费</td>  
																     <td>12</td>  
																     <td>
																     <fmt:formatNumber value="12" pattern="###,###.######"> </fmt:formatNumber>									   									     
																     </td>									       
																     <td>未收到</td>  
																     <td><a href="javascript:void(0) " class="btn_confirmationCostMust">撤销</a>
																     &nbsp;&nbsp;<a href="javascript:void(0) " class="btn_confirmationCostMust">收入确认</a></td>  
															    </tr> 
															   
												<%-- 	</c:forEach>   --%>
				                                        
				                                  </table> <!-- end table -->
										           </div>
												</div>
											</div>
										 </div>
								    </div>
						
									<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>实收费用： 第1笔</h5>			
											</div>
											<div class="widget-body"  style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="table-responsive">
												     <!--  <table id="table_costFact" style="font-size:13px !important;"></table>   -->
												     <table class="table table-striped table-bordered table-hover" id="no" data-toggle="table" data-striped="true">
					                                      <thead>
						                                        <tr>
						                                            <th>序号</th>
						                                            <th>费用类型</th>
						                                            <th>费率（%）</th>
						                                            <th>实收金额（元）</th>
						                                            <th>状态</th>
						                                            <th>操作</th>
						                                       </tr>
						                                    </thead>
				                                   <%--  <c:forEach items="12" var="applyDetail" >   --%>
															    <tr>  
																     <td>1</td>  
																     <td>担保费</td>  
																     <td>12</td>  
																     <td>
																     <fmt:formatNumber value="12" pattern="###,###.######"> </fmt:formatNumber>									   									     
																     </td>									       
																     <td>未收到</td>  
																     <td><a href="javascript:void(0) " class="btn_confirmationCostMust">撤销</a></td>  
															    </tr> 
															   
												<%-- 	</c:forEach>   --%>
				                                        
				                                  </table> <!-- end table -->
										           </div>
												</div>
											</div>
										 </div>
								    </div>
									<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>退费： 第1笔</h5>			
											</div>
											<div class="widget-body"  style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="table-responsive">
												      <!-- <table id="table_costReturn" style="font-size:13px !important;"></table>   -->
												      <table class="table table-striped table-bordered table-hover" id="no" data-toggle="table" data-striped="true">
					                                      <thead>
						                                        <tr>
						                                            <th>序号</th>
						                                            <th>原收费金额（元）</th>
						                                            <th>变更后金额（元）</th>
						                                            <th>退费金额（元）</th>
						                                            <th>退费原因</th>
						                                            <th>退费确认日期</th>
						                                            <th>操作</th>
						                                       </tr>
						                                    </thead>
				                                   <%--  <c:forEach items="12" var="applyDetail" >   --%>
															    <tr>  
																     <td>1</td>  
																     <td>12</td>  
																     <td>12</td>  
																     <td>12</td>  
																     <td>计算错误								   									     
																     </td>									       
																     <td>2017-12-4</td>  
																     <td><a href="javascript:void(0) " class="btn_confirmationCostMust">退费确认</a></td>  
															    </tr> 
															   
												<%-- 	</c:forEach>   --%>
				                                         	   <tr>
						                                            <th>小计</th>
						                                            <td>12</td>  
																    <td>12</td>  
																    <td>12</td>  
																    <td></td>  
																    <td></td>  
																    <td></td>  
						                                       </tr>
				                                  </table> <!-- end table -->
										           </div>
												</div>
											</div>
										 </div>
								    </div>
								    <div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h5>收费小计</h5>			
											</div>
											<div class="widget-body"  style="border:1px solid #ccc;">
												<div class="widget-main">
													<div class="table-responsive">
												      <!-- <table id="table_costReturn" style="font-size:13px !important;"></table>   -->
												      <table class="table table-striped table-bordered table-hover" id="no" data-toggle="table" data-striped="true">
					                                      <thead>
						                                        <tr>
						                                            <th>序号</th>
						                                            <th>费用类型</th>
						                                            <th>费率（%）</th>
						                                            <th>实收金额（元）</th>
						                                       </tr>
						                                    </thead>
				                                   <%--  <c:forEach items="12" var="applyDetail" >   --%>
															    <tr>  
																     <td>1</td>  
																     <td>担保费</td>  
																     <td>12</td>  
																     <td>12</td>  
															    </tr> 
															   
												<%-- 	</c:forEach>   --%>
				                                               <tr>
						                                            <th>收费小计</th>
						                                            <td>12</td>  
																    <td>12</td>  
																    <td>12</td>  
						                                       </tr>
				                                  </table> <!-- end table -->
										           </div>
												</div>
											</div>
										 </div>
								    </div>
								    
								    
								    
								    
								</div>
							</div>
                    	</div>
					</div>
					<div class="space-16"></div>
				</c:forEach> 	
                   <!--  <div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							应收费用
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costMust" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					<div class="form-group col-sm-12 col-xs-12" style="height:30px"></div>
					
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							缓收费用
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costDelay" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					<div class="form-group col-sm-12 col-xs-12" style="height:30px"></div>
					
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							预收费用
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costPre" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					<div class="form-group col-sm-12 col-xs-12" style="height:30px"></div>
					
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							退费
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costReturn" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					<div class="form-group col-sm-12 col-xs-12" style="height:30px"></div>
					
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							实收费用
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costFact" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div> -->
				
				
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="costRecord_page"></div>

<%@ include file="/common_confirm.jsp" %>
<script src="<%=path %>/project/cost/costRecord.js?v=<%=vardate%>"></script>

	