<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

<div class="page-header col-sm-12">
	<h4 >业务档案移交</h4>
</div>

<div class="page-content">
	<div class="row" style="display: block">
		<div class="col-xs-12">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#ok" id="fileTransfer">档案移交 </a></li>

					<li><a data-toggle="tab" href="#no" id="transferRecords">移交记录 </a></li>
				</ul>
				<div class="tab-content">
					<div id="ok" class="tab-pane in active">
						<c:if test="${urlParam.type eq 'edit' }">
							<div class="page-header">
								<button class="btn btn-sm btn-info" id="btn_newAddFileData">新增档案资料</button>&nbsp;&nbsp;
								<button class="btn btn-sm btn-info" id="btn_fileTransfer">档案移交</button>
								
							</div>
						</c:if>
						<div class="table-responsive" id="fileTransfer">
							<table id="fileTransfer_table" style="font-size: 13px !important;"></table>
						</div>
					</div>
					<div id="no" class="tab-pane">
						<div class="table-responsive" id="transferRecords">
							<table id="transferRecords_table" style="font-size: 13px !important;"></table>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div><!-- /.row -->
	<div id="newAddFileData_page"></div>
	<div id="fileTransfer_page"></div>

</div><!-- /.page-content -->
<%@ include file="/common_message.jsp" %>
<script src="<%=path%>/project/arccTransfer/arcTransfer.js?v=<%=vardate%>"></script>
	
	