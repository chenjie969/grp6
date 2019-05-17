<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row" style="margin-top: 30px;margin-bottom: 30px;">
					<h5 class="col-sm-3" id="projectBH">项目编号：<span class="grey">XMBH00001</span></h5>
					<h5 class="col-sm-3" id="projectBH">项目名称：<span class="grey">A公司</span></h5>
				</div>
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<button type="button" class="btn btn-sm btn-info" id="btn_addProjectBillInfo">登记票据信息</button>&nbsp;
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="table_projectBillInfo" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="projectBillInfo_page"></div>
	
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>

<script src="<%=path %>/project/finance/projectCost/projectBillInfo.js?v=<%=vardate%>"></script>	
	