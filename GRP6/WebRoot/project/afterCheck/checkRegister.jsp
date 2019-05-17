<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
	<div class="page-header col-sm-12">
		<h4 class="" id="">日常检查登记</h4>
	</div>
	<div class="page-content">
		<c:if test="${urlParam.type eq 'edit' }">
			<div class="page-header">
				<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addCheckRegister" >添加日常检查登记</button>
			</div>
		</c:if>
		<div class="row">
			<div class="col-xs-12">
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

<script type="text/javascript" src="<%=path%>/project/afterCheck/checkRegister.js?v=<%=vardate%>"></script>
	
			<%@ include file="/project/afterCheck/afterCheckUpload.jsp" %>
						
	