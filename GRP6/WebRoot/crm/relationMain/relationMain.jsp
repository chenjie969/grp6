<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
				                    <div class="col-sm-12">
										<div class="page-header">
											<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add" >新增主体</button>
											<!-- <button type="button" name="button" class="btn btn-sm btn-info" >业务明细</button> -->
											<!-- &nbsp;&nbsp; -->
											<button type="button" name="button" class="btn btn-sm btn-info" id="btn_del" >删除所选</button>
											<button type="button" name="button" class="btn btn-sm btn-info" id="btn_refreshRelationMainTable">重置列表</button>
											<button type="button" name="button" class="btn btn-sm btn-info" id="btn_select">高级查询</button>
										</div>
									</div>
									<div class="col-sm-12">
										<div class="table-responsive"  id="relationMain" >
											<table id="relationMain-table" style="font-size:13px !important;"></table>	
										</div>
									</div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
	<div id="relation_page"></div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>

	<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
	<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/crm/relationMain/relationMain.js?v=<%=vardate%>"></script>

	<%@ include file="/crm/relationMain/relationMainDel.jsp" %>
	<%@ include file="/crm/relationMain/relationMainView.jsp" %>
