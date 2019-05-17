<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp"%>
		<div class="page-content">
			<div class="page-header">
				<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addTaskType" >添加类型</button>
				<button type="button" name="button" class="btn btn-sm btn-info" id="btn_editTaskType" >修改类型</button>
				<button type="button" name="button" class="btn btn-sm btn-info" id="btn_delTaskType" >删除类型</button>
				<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sortTaskType" >同级顺序调整</button>
				<button type="button" name="button" class="btn btn-sm btn-info pull-right" id="btn_taskManagerSort" >顺序调整</button>
				<button type="button" name="button" class="btn btn-sm btn-info pull-right" id="btn_addTaskManager" style="margin-right:5px">添加任务事项</button>
				
				
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                       	<div class="col-sm-3">
							<div class="widget-box">
                                 <div class="widget-header">
                                     <h4>任务事项类型</h4>
                                 </div>
                                 <div class="widget-body">
                                     <div class="widget-main padding-8">
                                         <ul id="taskTypeTree" class="ztree ztree_style"></ul>
                                     </div>
                                 </div>
                            </div>
                        </div>
                        <div class="col-sm-9">
							<div class="row">
								<table id="taskManager_table" style="font-size: 13px !important;"></table>
							</div>
                        </div>
					</div>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
						
			<div id="taskManager_page"></div>
		</div><!-- /.page-content -->
					
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/common_del.jsp" %>

<style type="text/css">
       .dropdown-menu {
	    z-index: 1100;
	}
        body{ overflow: auto !important;} .modal{ overflow: auto !important;}
   </style>
<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
<script src="<%=path%>/gbpm/product/taskManager/taskManagerIndex.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/jquery/jquery.md5.js?v=<%=vardate%>"></script>




