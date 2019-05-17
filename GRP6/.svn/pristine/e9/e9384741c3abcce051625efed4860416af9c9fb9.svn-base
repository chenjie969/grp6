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
							<a data-toggle="tab" href="#personApply" id="personApplyTab">
								个人咨询登记
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#personRegister" id="personRegisterTab">
								个人咨询记录
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="personApply" class="tab-pane in active">
							<%@ include file="/crm/apply/person/personApply/personApply.jsp" %>
						</div>
						<div id="personRegister" class="tab-pane">
						<%@ include file="/crm/apply/person/personRegister/personRegister.jsp" %>
						
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->	
<div id="personApply_page"></div>
<div id="personRegister_page"></div>
<script src="<%=path %>/crm/apply/person/person.js?v=<%=vardate%>"></script>
<%@ include file="/common_message.jsp" %>
<%@ include file="/sys/listSet/listSetColumns.jsp" %>
<%@ include file="/sys/listSet/listSet_warning.jsp" %>
<script type="text/javascript" src="<%=path %>/sys/listSet/listSetColumns.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/apply/person/personRegister/personRegister.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/apply/person/personApply/personApply.js?v=<%=vardate%>"></script>




