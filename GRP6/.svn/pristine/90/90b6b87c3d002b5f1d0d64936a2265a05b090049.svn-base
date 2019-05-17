<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>

	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
				<div class="page-header">
					<button class="btn btn-sm btn-info" id="btn_transact" >项目办理</button>
					<!-- <button class="btn btn-sm btn-info" id="btn_unpack">拆包</button> -->
					&nbsp;&nbsp;
				<!-- 	<button class="btn btn-sm btn-info" id="btn_hightSelect" >高级查询</button> -->
					<button class="btn btn-sm btn-info" id="btn_refresh" >重置列表</button>
				</div>
                <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo">
						 <table id="package-table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
		<div id="shareClient_page"></div>
	</div><!-- /.page-content -->
	<script type="text/javascript" src="<%=path %>/project/package/packageTracking.js?v=<%=vardate%>"></script>
	<%@ include file="/common_message.jsp"%>
	<%@ include file="/project/package/unPackageModal.jsp"%>
	