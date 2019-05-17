<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>	
<script src="<%=path %>/crm/apply/basic.js?v=<%=vardate%>"></script>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<div class="tabbable">
					<ul class="nav nav-tabs" id="clientDepotTab">
						<li class="active">
							<a data-toggle="tab" href="#enterpriseDepot" id="enterpriseDepotTab">
								企业客户储备库
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#personDepot" id="personDepotTab">
								个人客户储备库
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="enterpriseDepot" class="tab-pane in active">
							<%@ include file="/crm/apply/clientDepot/enterpriseClientDepot/enterpriseDepot.jsp" %>
						</div>
						<div id="personDepot" class="tab-pane">
							<%@ include file="/crm/apply/clientDepot/personClientDepot/personDepot.jsp" %>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->
	
<div id="enterpriseDepot_page"></div>
<div id="personDepot_page"></div>	

<script src="<%=path %>/crm/apply/clientDepot/clientDepot.js?v=<%=vardate%>"></script>