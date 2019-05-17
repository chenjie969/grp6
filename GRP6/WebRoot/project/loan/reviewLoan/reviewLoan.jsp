<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	
	<div class="page-content">
		<div class="page-header">
			<h4>实际放款复核</h4>
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
						</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_planPay" style="font-size:13px !important;"></table>  
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
							</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_costMust" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					
					<div class="col-sm-12" style="height:30px"></div>
					<div class="col-sm-12">
							<h4 class="header smaller lighter blue">
								实际放款情况：
							</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="table_factLoan" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="reviewLoan_page"></div>

<script src="<%=path %>/project/loan/reviewLoan/reviewLoan.js?v=<%=vardate%>"></script>

	