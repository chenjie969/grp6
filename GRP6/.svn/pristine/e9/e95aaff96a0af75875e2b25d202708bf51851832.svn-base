<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<div class="page-content">
	<div class="row"> <!-- style="display: block" -->
		<div class="col-xs-12">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#ok" id="approvalingMeeting">待安排会议</a></li>

					<li><a data-toggle="tab" href="#no" id="approvaledMeeting">已安排会议</a></li>
				</ul>
				<div class="tab-content">
					<div id="ok" class="tab-pane in active">
						<%-- <c:if test="${urlParam.type eq 'edit' }"> --%>
							<div class="page-header">
								<button class="btn btn-sm btn-info" id="btn_addMeeting">安排会议</button>
							</div>
						<%-- </c:if> --%>
						<div class="table-responsive" id="approvalingMeeting">
							<table id="approvalMeeting_table" style="font-size: 13px !important;"></table>
						</div>
					</div>
					
					<div id="no" class="tab-pane">
						<div class="table-responsive" id="approvaledMeeting">
							<table id="approvalMeet_table" style="font-size: 13px !important;"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- /.row -->
	
	<!-- <div id="fileTransfer_page"></div> -->

</div><!-- /.page-content -->
<div id="awaitingMeeting_page"></div>
<div id="awaitedMeeting_page"></div>
<%@ include file="/common_message.jsp" %>
<script src="<%=path%>/project/riskResponse/meetingArrange/approvalMeeting.js?v=<%=vardate%>"></script>