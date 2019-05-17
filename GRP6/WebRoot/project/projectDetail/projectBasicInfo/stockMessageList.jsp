<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
 --%>
<%@ include file="/crm/client/companyClient/companyClientHead.jsp"%>

	<h4 class="header smaller lighter blue">
		股权信息
		<button type="button" name="button"
			class="btn btn-minier btn-warning pull-right" id="stockAdd">
			<i class="icon-edit bigger-110"></i> <span
				class="bigger-110 no-text-shadow">添加</span>
		</button>
	</h4>
	<div class="table-responsive" id="stockMessageList">
		<table id="stockMessage-table" style="font-size: 13px !important;"></table>
	</div>
	<br>
	<div class="row" style="margin: 0;">
		<span class="ztb_view_managerinfoId" style="display: none;"></span>
		<h4 class="header smaller lighter blue">
			股权结构历史沿革：
			<button type="button" name="button"
			class="btn btn-minier btn-warning pull-right" id="history">
			<i class="icon-edit bigger-110"></i> <span
				class="bigger-110 no-text-shadow">修改</span>
			</button>
		</h4>
		<div class="row" style="margin: 0;">
			<pre id="stockStructure" class="col-xs-12 ztb_view_stockstructure"
				style="white-space: pre-wrap;"></pre>
		</div>
	</div>
	
	<br>
	<h4 class="header smaller lighter blue">
		股东背景及主要管理人员分析
	</h4>
			<h5 class="smaller">
				法定代表人及其配偶情况：
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right edit_manager legalpersoninfo">
					<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
				</button>
			</h5>
			<br>
			<div class="row" style="margin: 0;">
				<pre id="stockStructure" class="col-xs-12 ztb_view_legalpersoninfo"
					style="white-space: pre-wrap;"></pre>
			</div>
			<br>
			<h5 class="smaller">
				实际控制人及其配偶情况（包含从业经历）：
				<button type="button" name="button"
					class="btn btn-minier btn-warning pull-right  edit_manager controlpersoninfo" >
					<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
				</button>
			</h5>
			<br>
			<div class="row" style="margin: 0;">
				<pre class="col-xs-12 ztb_view_controlpersoninfo"style="white-space: pre-wrap;"></pre>
			</div>
			<br>
			<h5 class="smaller">
				其他股东情况：
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right edit_manager otherstockinfo">
					<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
				</button>
			</h5>
			<br>
			<div class="row" style="margin: 0;">
				<pre class="col-xs-12 ztb_view_otherstockinfo" style="white-space: pre-wrap;"></pre>
			</div>
			<br>
			<h5 class="smaller">
				公司主要高管人员情况：
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right edit_manager managerinfo">
					<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
				</button>
			</h5>
			<br>
			<div class="row" style="margin: 0;">
				<pre class="col-xs-12 ztb_view_managerinfo" style="white-space: pre-wrap;"></pre>
			</div>
			<br>
			<h5 class="smaller">
				公司员工概况：
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right edit_manager employeeinfo">
					<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
				</button>
			</h5>
			<br>
			<div class="row" style="margin: 0;">
				<pre class="col-xs-12 ztb_view_employeeinfo" style="white-space: pre-wrap;"></pre>
			</div>
	
