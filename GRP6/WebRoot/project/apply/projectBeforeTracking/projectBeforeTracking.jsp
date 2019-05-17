<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
	 <!-- 获取当前登录人信息 -->
		   <input type="hidden"  id="userID" value="${sessionUser.user_uid}">
	       <input type="hidden"  id="userName" value="${sessionUser.user_name}">
	       <input type="hidden"  id="isAdmin" value="${sessionUser.isAdmin}">
	       
       <!-- 获取当前登录人信息 --> 
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
				<div class="page-header">
					<!-- <button type="button" name="button" id="btn_deployList_add" class="btn btn-sm btn-info" >启动流程</button> -->
					<button class="btn btn-sm btn-info" id="btn_transact" >项目办理</button>
					<!-- <button class="btn btn-sm btn-info" id="btn_projectDetaiil">否决项目</button> -->
					<button type="button" class="btn btn-sm btn-info" id="btn_slaveSynchrMainClient">同步到客户库</button>
					<button class="btn btn-sm btn-info" id="btn_hightSelect" >高级查询</button>
					<button class="btn btn-sm btn-info" id="btn_refresh" >重置列表</button>
				</div>
                <div class="col-sm-12">    
					<div class="table-responsive"  id="loadinfo">
						 <table id="projectBeforeTracking-table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
		<div id="shareClient_page"></div>
		<div id="processDefinition_page"></div>
		
		<div id="companyClientSynchroPage"></div>
		
	</div><!-- /.page-content -->
	<script type="text/javascript" src="<%=path %>/project/apply/projectBeforeTracking/projectBeforeTracking.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/gbpm/processDefinition/processDefinitionDeployList.js?v=<%=vardate%>"></script>
	<%@ include file="/common_message.jsp"%>
	<%@ include file="/project/apply/projectApplySelect.jsp"%><!-- 高级条件查询页面 -->	
	<%@ include file="/common_del.jsp" %>
	<%@ include file="/crm/client/companyClient/syncSuccess.jsp"%> <!-- 客户资料同步成功 -->