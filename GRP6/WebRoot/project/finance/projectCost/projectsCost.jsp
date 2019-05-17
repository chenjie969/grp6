<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="table_projectsCost" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="projectsCost_page"></div>
	
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>

<script src="<%=path %>/project/finance/projectCost/projectsCost.js?v=<%=vardate%>"></script>

	