<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp" %>

	<div class="page-header col-sm-12">
		<h4 class="" id="">日常检查登记</h4>
	</div>
	<div class="page-content">
		<div class="page-header">
			<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addCheckRegister" >添加日常检查登记</button>
			<!-- &nbsp;<button type="button" name="button" class="btn btn-sm btn-info" id="btn_autoGenerAfterPlan" >自动生成保后计划</button> -->
		</div>
		<div class="row">
			<div class="col-xs-12">
				<input type="hidden" value="${apply_ID }" id="apply_ID_input">
				<div class="tabbable">			
					<div class="tab-content">					
						<div class="table-responsive" id="">
								<table id="checkPlan-table" style="font-size: 13px !important;"></table>
							</div>
					</div>
				</div>
			</div>
		</div>
	<!-- /.row -->
	</div>
		<!-- PAGE CONTENT ENDS -->
	<div id="projectPackage_page"></div>
	<div id="checkRegister_page"></div>
<!-- /.page-content -->
<!-- <div id="fujianDiv"></div> -->

<div id="checkSocial_page"></div>
<%@ include file="/common_foot.jsp" %>
<script type="text/javascript" src="<%=path%>/project/afterCheck/checkRegisterAfter.js?v=<%=vardate%>"></script>
<%@ include file="/project/afterCheck/afterCheckUpload.jsp" %>
						
	