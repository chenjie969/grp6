<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                	<input type="hidden" id="hidden_applyID" value="${urlParam.entityID}">
                	<input type="hidden" id="openType" value="${urlParam.type}">
                	
                	
                	 <div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							批准担保情况
						</h4>
					<c:forEach items="${meetingDetailList}" var="meetingDetail">
						<div class="col-sm-12">
						<div class="widget-box">
							<div class="widget-header">
								<h5>${meetingDetail.busiTypeName} |
									<fmt:formatNumber value=" ${meetingDetail.agreeSum}" pattern="###,###.######"> </fmt:formatNumber>万元 | 
								  ${meetingDetail.periodMonthDay}
								 ${meetingDetail.bankName}</h5>		
								 	<div class="widget-toolbar">
										<a href="#" data-action="collapse">
											<i class="icon-chevron-up"></i>
										</a>
									</div>	
							</div>
			
							<div class="widget-body">
								<div class="widget-main">
									<div class="row">
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
					<div class="form-group col-sm-12 col-xs-12" style="height:30px"></div>
                    <div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							财务收费确认
						
							
						</h4>
						<div class="col-sm-12">
							<div class="widget-box">
							
								<div class="widget-header">
									<h5>放款计划： 第1笔</h5>			
								</div>
								<div class="widget-body">
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
								<div class="widget-body">
									<div class="widget-main">
										<div class="table-responsive">
									      <table id="table_costDelay" style="font-size:13px !important;"></table>  
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
								<div class="widget-body">
									<div class="widget-main">
										<div class="table-responsive">
									      <table id="table_costMust" style="font-size:13px !important;"></table>  
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
								<div class="widget-body">
									<div class="widget-main">
										<div class="table-responsive">
									      <table id="table_costPre" style="font-size:13px !important;"></table>  
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
								<div class="widget-body">
									<div class="widget-main">
										<div class="table-responsive">
									      <table id="table_costFact" style="font-size:13px !important;"></table>  
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
								<div class="widget-body">
									<div class="widget-main">
										<div class="table-responsive">
									      <table id="table_costReturn" style="font-size:13px !important;"></table>  
							           </div>
									</div>
								</div>
							 </div>
					    </div>
						
					</div>
					<div class="form-group col-sm-12 col-xs-12" style="height:30px"></div>
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
				</div>
				
				
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="costRecord_page"></div>

<%@ include file="/common_confirm.jsp" %>

<script src="<%=path %>/project/cost/costRecord.js?v=<%=vardate%>"></script>

	