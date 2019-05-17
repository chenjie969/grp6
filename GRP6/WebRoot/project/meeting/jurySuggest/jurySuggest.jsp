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
							<a data-toggle="tab" href="javascript:void(0)" id="tab_notVote">
								未表决
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="javascript:void(0)" id="tab_hasVoted">
								已表决
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
	
<div id="page_jurySuggestIndex"></div>	
<div id="page_jurySuggestIndex2"></div>

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_confirm.jsp" %>

<script src="<%=path %>/project/meeting/jurySuggest/jurySuggest.js?v=<%=vardate%>"></script>
<script src="<%=path %>/js/paging.js?v=<%=vardate%>"></script>