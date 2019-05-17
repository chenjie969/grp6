<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="page-content">
	<div class="page-header">
		<input type="hidden" id="entityID_flow" value='${apply.apply_ID}' /> 
		<input type="hidden" id="entityName_flow" value='${apply.projectName}' /> 
		项目名称：${apply.projectName}
		项目编号:${apply.busiCode}
	</div>
	<div class="row">
		<input type="hidden" id="os_login_user_uid" value='<shiro:principal property="user_uid"/>' /> 
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#postTrackingActive">活动中的实例</a></li>
				<li><a data-toggle="tab" href="#postTrackingStop">已结束的实例</a></li>
			</ul>
			<div class="tab-content">
				<div id="postTrackingActive" class="tab-pane in active">
					<div class="row">
						<div class="col-sm-12">
							<div class="table-responsive" id="loadinfo">
								<table id="postTrackingActive-table" style="font-size: 13px !important;"></table>
							</div>
						</div>
					</div>
				</div>
				<div id="postTrackingStop" class="tab-pane">
					<div class="row">
						<div class="col-sm-12">
							<div class="table-responsive" id="loadinfo">
								<table id="postTrackingStop-table" style="font-size: 13px !important;"></table>
							</div>
						</div>
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
<script src="/gworkFlow/trackingWorkFlow.js?v=<%=vardate%>"></script>
<script src="/gworkFlow/startWorkFlow.js?v=<%=vardate%>"></script>
