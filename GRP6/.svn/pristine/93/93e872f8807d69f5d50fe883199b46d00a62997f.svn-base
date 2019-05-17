<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp"%>

<div class="page-content">
	<div class="page-header">
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add" >添加流程分类</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort" >顺序调整</button>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="widget-box">
               <div class="widget-header">
                   <h4>流程分类设置</h4>
               </div>
               <div class="widget-body">
                   <div class="widget-main padding-8">
                       <ul id="menuSetTree" class="ztree"></ul>
                   </div>
               </div>
             </div>
        </div>
        <div class="col-sm-9">
			<table id="actSort-table" style="font-size: 13px !important;"></table>
		</div>
	</div>
</div>
<div id="actSort_page"></div>

<%@ include file="/common_foot.jsp"%>
<script src="index.js?v=<%=vardate%>"></script>
<%@ include file="/sys/sort/sort.jsp"%>