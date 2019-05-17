<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp"%>
<div class="page-content">
	<div class="page-header">
		<!-- //测试分支111 -->
	</div>
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-sm-3">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="lighter smaller">组织结构</h4>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-8">
								<ul id="menuSetTree" class="ztree ztree_style"></ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-9">
				<button type="button" name="button" id="btn_delOneEmployee"	class="btn btn-sm btn-info">离职</button>
		<!-- <button type="button" name="button" id="btn_hightSelect" class="btn btn-sm btn-info">高级查询</button> -->
					<div class="table-responsive" id="loadinfo222">
						<table id="employee-table" style="font-size: 13px !important;"></table>

					</div>

				</div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</div>
<!-- /.page-content -->
<div id="processDefinition_page"></div>
<%@ include file="/oa/personfile/employeeInfo/hightSelectEmployee.jsp"%>
<%@ include file="/oa/personfile/employeeInfo/employeedel.jsp"%>
<%@ include file="/common_message.jsp"%>
<%@ include file="/common_del.jsp"%>

<%@ include file="/common_foot.jsp"%>
 <script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/employee.js?v=<%=vardate%>"></script>

