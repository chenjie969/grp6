<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							 <button type="button" class="btn btn-sm btn-info" id="btn_stopProjectsDel">删除所选</button>&nbsp;
							<button type="button" class="btn btn-sm btn-info" id="btn_refreshApplyTable">重置列表</button>&nbsp;
							<!--<button type="button" class="btn btn-sm btn-info" id="btn_disagreeToAccept">不予立项</button>&nbsp; -->
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="stopProject_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="stopProjectTable_page"></div>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/project/stop/stopProject.js?v=<%=vardate%>"></script>
<%@ include file="/project/stop/stopProjectInfo.jsp" %><!--否决项目查看页面 -->
<%@ include file="/common_message.jsp"%><!-- 公共提示框 -->