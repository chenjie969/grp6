<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<input type="text" id="condition" value="">
 				<div class="tabbable">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#badCompany" id="companyTab">
								企业&nbsp;&nbsp;<span class="badge badge-danger">30</span>
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#badPerson" id="personTab">
								个人&nbsp;&nbsp;<span class="badge badge-danger">20</span>
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="badCompany" class="tab-pane in active">
							<div class="row" style="display:block">
								<div class="col-xs-12">
									<div class="table-responsive"  id="loadCompanyInfo">
										<table id="companyClient-table" style="font-size:13px !important;"></table> 
									</div>
								</div>
							</div>
						</div>
						<div id="badPerson" class="tab-pane">
							<div class="row" style="display:block">
								<div class="col-xs-12">
									<div class="table-responsive"  id="loadPersonInfo">
										<table id="personClient-table" style="font-size:13px !important;"></table> 
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
<%@ include file="/common_foot.jsp" %>

<script src="<%=path %>/crm/relationQuery/queryResultList.js?v=<%=vardate%>"></script>

