<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<div class="tabbable">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#badCompany" id="blackCompanyTab">
								企业黑名单
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#badPerson" id="blackPersonTab">
								个人黑名单
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="badCompany" class="tab-pane in active">
							<div class="row" style="display:block">
								<div class="col-xs-12">
									<div class="page-header">
										<!-- <button type="button" class="btn btn-sm btn-info viewInfo" value="badCompany" >查看企业资料</button> -->
										<!-- <button type="button" class="btn btn-sm btn-info"  >业务明细</button> -->
										<button type="button" class="btn btn-sm btn-info changeToNormal" value="badCompany" >转为正常企业</button>
										<button type="button" class="btn btn-sm btn-info" id="btn_refreshBadCompanyTable" >重置列表</button>
										<!-- <button type="button" class="btn btn-sm btn-info" id="btn_daoruinfos" >导入黑名单</button>	 -->										
								<input type="hidden" value="${count}" id="count"/>
								<input type="hidden" value="${errorMessage}" id="errorMessage"/>								
									</div>
									<div class="table-responsive"  id="loadCompanyInfo"></div>
								</div>
							</div>
							
						</div>
						<div id="badPerson" class="tab-pane">
							<div class="row" style="display:block">
								<div class="col-xs-12">
									<div class="page-header">
										<!-- <button type="button" class="btn btn-sm btn-info viewInfo" value="badPerson" >查看个人资料</button> -->
										<!-- <button type="button" class="btn btn-sm btn-info"  >业务明细</button> -->
										<button type="button" class="btn btn-sm btn-info changeToNormal" value="badPerson" >转为正常个人</button>
										<button type="button" class="btn btn-sm btn-info" id="btn_refreshBadPersonTable" >重置列表</button>
										<!-- <button type="button" class="btn btn-sm btn-info" id="btn_Excel" >导入黑名单</button> -->
									</div>
									<div class="table-responsive"  id="loadPersonInfo"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
		<div id="enterpriseBlack_page"></div>
	</div><!-- /.page-content -->
	
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>

	<style type="text/css">
		.dropdown-menu {z-index: 1100;}
		body{ overflow: auto !important;} 
		.modal{ overflow: auto !important;}
	</style>
<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/blacklist/blacklist.js?v=<%=vardate%>"></script>
<%-- <script src="<%=path %>/crm/blacklist/jquery-form.js?v=<%=vardate%>"></script>
 --%>
<%@ include file="/crm/blacklist/toNormalCompany.jsp" %>
<%@ include file="/crm/blacklist/toNormalPerson.jsp" %>
<%@ include file="/crm/blacklist/edit.jsp" %>
<%@ include file="/crm/blacklist/view.jsp" %>
<%@ include file="/crm/blacklist/blackView3.jsp" %>
<%@ include file="/crm/blacklist/blackView.jsp" %>