<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
	<style>
		.table th, .table td {
		vertical-align: middle!important;
		}
	</style>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<button type="button" id="btn_addOptGuaranty" class="btn btn-sm btn-info" data-toggle="modal" data-target="#edit">新增</button>
                                <button class="btn btn-sm btn-info" id="btn_realizeOptGuaranty" data-toggle="modal" data-target="#agree">落实</button>
                                <button class="btn btn-sm btn-info" id="btn_relieveOptGuaranty" data-toggle="modal" data-target="#release">解除</button>
                                <button class="btn btn-sm btn-info"  id="btn_disposeOptGuaranty" data-toggle="modal" data-target="#dispose">处置</button>
                                <button class="btn btn-sm btn-info"  id="btn_returnOptSum" data-toggle="modal" data-target="#dispose">退回保证金</button>
                                &nbsp;&nbsp;
								<button class="btn btn-sm btn-info"  id="btn_deleteOptGuaranty" data-toggle="modal" data-target="#delete">删除所选</button>
                                <button class="btn btn-sm btn-info" id="btn_highOptQuery" data-toggle="modal" data-target="#search">高级查询</button>
                                <button class="btn btn-sm btn-info" id="btn_refresh">重置列表</button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="optManager_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="optGuaranty_page"></div>
<div id="clientList_page"></div>
	
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/opt/optManager/failDel.jsp" %>

<script src="<%=path %>/project/opt/optManager/optManager2.js?v=<%=vardate%>"></script>

	