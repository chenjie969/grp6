<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp"%>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">项目信息</h4>
			<h5 class="col-sm-6">
				项目编号：<span class="grey">${apply.busiCode}</span>
			</h5>
			<h5 class="col-sm-6">
				项目名称：<span class="grey">${apply.projectName}</span>
			</h5>
			<div class="col-sm-12 space-20"></div>

			<h4 class="header smaller lighter blue">
				项目动态
				<button type="button" name="button" 
					class="btn btn-minier btn-warning pull-right" id="btn_addDynamic">
					<i class="icon-edit bigger-110"></i> <span
						class="bigger-110 no-text-shadow">添加</span>
				</button>
			</h4>
		  <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo"> 
						 <table id="dynamic_table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
	

		</div>
	</div>
</div>

​<%@ include file="/common_foot.jsp"%>
​<%@ include file="/project/apply/projectBeforeTracking/dynamicdelloser.jsp"%>
<div id="DynamicInfo_page"></div>
<div id="ViewdynamicInfo_page"></div>
<script
	src="<%=path%>/project/apply/projectBeforeTracking/projectState.js?v=<%=vardate%>"></script>