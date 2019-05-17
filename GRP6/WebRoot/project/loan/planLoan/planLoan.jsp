<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	
	<div class="page-content">
		<div class="page-header">
			<h4>计划放款登记</h4>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                	 <input type="hidden" id="hidden_applyID" value="${apply_ID }">
                	 <input type="hidden" id="openType" value="${openType }">
                	 
                     <div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							评审会批准担保情况：
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_approveGuarantee" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					
					<div class="col-sm-12" style="height:30px"></div>
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							放款方式：
							<c:if test="${openType =='edit'}">
								<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addPlanLoan">
									<i class="icon-edit bigger-110"></i>
									<span class="bigger-110 no-text-shadow">添加</span>
								</button>
							</c:if>
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_planLoan" style="font-size:13px !important;"></table>  
						    </div>
						</div>
					</div>
					
					<div class="col-sm-12" style="height:30px"></div>
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							还款方式：
							<c:if test="${openType =='edit'}">
								<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addPlanRepay">
									<i class="icon-edit bigger-110"></i>
									<span class="bigger-110 no-text-shadow">添加</span>
								</button>
							</c:if>
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_planRepay" style="font-size:13px !important;"></table>  
						    </div>
						</div>
					</div>
					
					<div class="col-sm-12" style="height:30px"></div>
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							评审会批准收费标准：
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_meetingCost" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					
					<div class="col-sm-12" style="height:30px"></div>
					<div class="col-sm-12">
						<h4 class="header smaller lighter blue">
							应收费用：
							<!-- <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addCostMust">
								<i class="icon-edit bigger-110"></i>
								<span class="bigger-110 no-text-shadow">添加</span>
							</button> -->
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costMust" style="font-size:13px !important;"></table>  
						   	</div>
						</div>
					</div>
					
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="planLoan_page"></div>

<%@ include file="/common_confirm.jsp" %>
<%@ include file="/common_succeed.jsp" %>
<%@ include file="/project/loan/planLoan/planLoanEdit.jsp" %>

<script src="<%=path %>/project/loan/planLoan/planLoan.js?v=<%=vardate%>"></script>

	