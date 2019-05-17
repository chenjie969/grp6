<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %> --%>
<div class="page-content">
	<div class="page-header">
		<h4>档案移交清单</h4>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="tabbable">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#planCheck" id="recordList"> 档案清单</a></li>
				<li><a data-toggle="tab" href="#truthPostion" id="recordAccessory">档案附件 </a></li>
			</ul>
			<div class="tab-content">
				<div id="planCheck" class="tab-pane in active">
					<div >
						<h4 class="header smaller lighter blue">
							文档清单：
							<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addFile">
								<i class="icon-edit bigger-110"></i>
								<span class="bigger-110 no-text-shadow">添加</span>
							</button>
						</h4>
						<div class="table-responsive">
							<table id="file_table" style="font-size:13px !important;"></table>  
					  	</div>
					</div>
					
					<div>
						<h4 class="header smaller lighter blue">
							移交人信息：
							<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_editTurnInfo">
								<i class="icon-edit bigger-110"></i>
								<span class="bigger-110 no-text-shadow">编辑</span>
							</button>
						</h4>
						<div >
								<h5 style="line-height: 26px;">
									移交人：<span class="grey">张三</span>
								</h5>
						</div>
						<div >
								<h5  style="line-height: 26px;">
									移交日期：<span class="grey">2017-08-08</span>
								</h5>
						</div>
						<div>
								<h5 style="line-height: 26px;">
									移交说明：<span class="grey">优</span>
								</h5>
						</div>
					</div>
					
					<div >
						<h4 class="header smaller lighter blue">
							审批人信息：
							<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_editApprove">
								<i class="icon-edit bigger-110"></i>
								<span class="bigger-110 no-text-shadow">编辑</span>
							</button>
						</h4>
						<div>
							<h5 style="line-height: 26px;">
								审批人：<span class="grey">李四</span>
							</h5>
						</div>
						<div>
							<h5  style="line-height: 26px;">
								审批日期：<span class="grey">2017-08-08</span>
							</h5>
						</div>
					</div>
				</div>
				
				<div id="truthPostion" class="tab-pane">
					<div class="table-responsive">
						<table id="truthPostion1" style="font-size:13px !important;"></table>  
					</div>
				</div>
			</div>
		</div>
		</div>
		
	</div>
</div><!-- /.page-content -->

<%@ include file="/common_del.jsp" %>
<%@ include file="/project/record/fileAdd.jsp" %>
<%@ include file="/project/record/fileEdit.jsp" %>
<%@ include file="/project/record/fileDelete.jsp" %>
<%@ include file="/project/record/approveInfoEdit.jsp" %>
<%@ include file="/project/record/turnInfoEdit.jsp" %>

<script src="<%=path %>/project/record/record.js?v=<%=vardate%>"></script>
	
				
	
							
									
									