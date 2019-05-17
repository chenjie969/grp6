<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active">
							<a data-toggle="tab" href="javascript:void(0)" id="tab_meetingArrange">
								安排上会
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="javascript:void(0)" id="tab_meetingArrangeRecord">
								已安排上会记录
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="tabContent" class="tab-pane in active"></div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="page_meetingArrangeIndex"></div>	
<div id="page_meetingArrangeIndex2"></div>	

<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/project/meeting/meetingArrange/treeJury.js?v=<%=vardate%>"></script>
<%@ include file="/project/meeting/meetingArrange/meetingArrangeAdd.jsp" %>	
<%@ include file="/project/meeting/meetingArrange/setVoteJury.jsp" %>	
<%@ include file="/project/meeting/meetingArrange/waitingArrangeApply.jsp" %>
<%@ include file="/common_message.jsp" %>

<script src="<%=path %>/project/meeting/meetingArrange/index.js?v=<%=vardate%>"></script>