<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	<style>
		.table th, .table td {
		vertical-align: middle!important;
		}
	</style>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
						<div class="page-header">
							<h5 style="display: inline;">项目编号：<span class="grey">${apply.busiCode }</span></h5>
							<h5 style="display: inline;margin-left:2em;">项目名称：<span class="grey">${apply.projectName }</span></h5>
						</div>
					<c:if test="${luoshi != 'luoshi' }">
						<button type="button" id="btn_addOptGuaranty" class="btn btn-sm btn-info" data-toggle="modal" data-target="#edit">新增</button>
						<button class="btn btn-sm btn-info"  id="btn_deleteOptGuaranty" data-toggle="modal" data-target="#delete">删除所选</button>
					</c:if>	
					<c:if test="${luoshi eq 'luoshi'}">
                         <button class="btn btn-sm btn-info" id="btn_realizeOptGuaranty" data-toggle="modal" data-target="#agree">落实</button>
					</c:if>
						<div class="table-responsive">
							<table id="optManager_table" style="font-size:13px !important;"></table>  
                        </div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="optGuaranty_page"></div>
<div id="clientList_page"></div>

	<input type="hidden" value="${apply.apply_ID }" name="apply_ID" id="apply_ID">
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/opt/optManager/failDel.jsp" %>

<script src="<%=path %>/project/opt/optManager/optManager.js?v=<%=vardate%>"></script>

	