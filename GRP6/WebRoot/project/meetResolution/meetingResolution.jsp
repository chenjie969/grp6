<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.a_style{
		float: right;;
	}
	.a_style:hover{ 
		font-size:24px;
		color: red;
		text-decoration:none;
		cursor: pointer;
	}
	.a_style:visited{
 		text-decoration:none;  /*超链接无下划线*/
 		color: red;
	}
	.a_style:link{
	 text-decoration:none;  /*超链接无下划线*/
	}
</style>

<div class="page-content"><!--begin页面内容  -->
	<div class="page-header"><!--begin页头部分 -->
		<h4 >评审会决议</h4>
	</div>
	
	<div class="row"><!--begin 响应式行  -->
		<div class="col-xs-12"><!--begin 响应式列  -->
		
		<%-- 	<h4 class="header smaller lighter blue">
				客户信息
			</h4>
			<div class="row">
				<h5 class="col-sm-4">客户名称：<span class="grey" style="line-height:26px;">${pro_apply.clientName}</span></h5>
				<h5 class="col-sm-4">业务性质：<span class="grey" style="line-height:26px;">${pro_apply.clientName}</span></h5>
				<h5 class="col-sm-4">类别：<span class="grey" style="line-height:26px;">${pro_apply.projectType}</span></h5>
			</div> --%>
			
			<div class="space-16"></div>
			
			<h4 class="header smaller lighter blue">
				批准担保情况
			</h4>
			<table id="approveGuarantee_table" style="font-size: 13px !important;"></table>
			
			<div class="space-16"></div>
			
			<h4 class="header smaller lighter blue">
				收费标准
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addBusiCostStandard">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
				</button>
			</h4>
			<table id="busiCostStandard_table" style="font-size: 13px !important;"></table>
			
			<div class="space-16"></div>
			 <input type="hidden" id="meeting_ID" class="" name="meeting_ID" value="${meeting.meeting_ID}">
			<%-- <h4 class="header smaller lighter blue">
					参会委员
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right"  id="btn_updateUserName">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">修改</span>
				</button>
			</h4>
			<div class="row">
				<h5 class="col-sm-6">参会委员：<span class="grey">${meeting.userNameList}</span></h5>
				<h5 class="col-sm-6">外部专家：<span class="grey">${meeting.otherUserNameList}</span></h5>
				<h5 class="col-sm-12">评委投票结果：
					<span class="text-success"></span>，
					<span class="text-danger">反对1票</span>，
					<span class="text-primary">再议1票</span></h5>
				<h5 class="col-sm-12">反担保措施：
				  <span class="grey"></span>
				</h5>
			</div>
			 --%>
			<%-- <div class="space-16"></div>
			
				<h4 class="header smaller lighter blue">
					审批意见
					<button type="button" name="button" class="btn btn-minier btn-warning pull-right">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">修改</span>
					</button>
				</h4>
				<div class="row">
					<!-- <h5 class="col-sm-12">业务部门意见：<span class="grey"></span></h5>
					<h5 class="col-sm-12">风险部门意见：<span class="grey"></span></h5>
					<h5 class="col-sm-12">总经理意见：<span class="grey"></span></h5>
					<h5 class="col-sm-12">董事长（或授权人）意见：<span class="grey"></span></h5> -->
					<c:forEach items="${suggestList}" var="suggest">
							<h5 class="col-sm-12">${suggest.taskName}：<span class="grey">${suggest.suggestContent}</span></h5>
					</c:forEach>
				</div> --%>
				
			<div class="space-16"></div>
			  <input type="hidden" id="meetingResolution_ID" class="" name="meetingResolution_ID" value="${meetingResolution.meetingResolution_ID}">
			  <input type="hidden" id="applyID" class="" name="applyID" value="${meetingResolution.applyID}">
				<h4 class="header smaller lighter blue">
					决议内容：
					<button type="button" name="button" class="btn btn-minier btn-warning pull-right"  id="btn_updateMeetingResolution">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">修改</span>
					</button>
				</h4>
				<div class="row">
					<h5 class="col-sm-12">签批决议：<span class="grey">${meetingResolution.signed}</span></h5>
					<h5 class="col-sm-12">过程控制：<span class="grey">${meetingResolution.processControl}</span></h5>
					<h5 class="col-sm-12">放款条件：<span class="grey">${meetingResolution.loanConditions}</span></h5>
					<h5 class="col-sm-12">其他事项：<span class="grey">${meetingResolution.otherMatters}</span></h5> 
					<h5 class="col-sm-12">保后监管周期：<span class="grey">${meetingResolution.controlTypeName}</span></h5> 
					<h5 class="col-sm-12">在保监管要求：<span class="grey">${meetingResolution.monitoredAsking}</span></h5> 
					<h5 class="col-sm-12">决议结果：<span class="grey">${meetingResolution.resolutionResultName}</span></h5> 
				</div>
				<!-- <div class="clearfix form-actions">
					<div class="col-sm-offset-4 col-sm-8">
						<button class="btn btn-primary" type="button">
							<i class="icon-location-arrow bigger-110"></i>
							生成评审会决议
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn" type="button">
							<i class="icon-remove bigger-110 "></i>
							关闭
						</button>
					</div>
				</div>  -->
			
		</div>
	</div>
	
</div>
<div id="meetingResolution_page"></div>

<%@ include file="/project/meetResolution/sysCostStandardModal.jsp" %>










<%@ include file="/project/meetResolution/meetingResolutionEdit.jsp"%>
<script src="<%=path%>/assets/js/fullcalendar/moment.min.js?v=<%=vardate%>"></script>

<script src="<%=path%>/project/meetResolution/meetingResolution.js?v=<%=vardate%>"></script>