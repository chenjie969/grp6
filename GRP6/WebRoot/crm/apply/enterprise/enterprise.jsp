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
							<a data-toggle="tab" href="#enterpriseApply" id="enterpriseApplyTab">
								企业咨询登记
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#enterpriseRegister" id="enterpriseRegisterTab">
								企业咨询记录
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="enterpriseApply" class="tab-pane in active ">
							<%@ include file="/crm/apply/enterprise/enterpriseApply/enterpriseApply.jsp" %>
						</div>
						<div id="enterpriseRegister" class="tab-pane ">
							<%@ include file="/crm/apply/enterprise/enterpriseRegister/enterpriseRegister.jsp" %>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->
	
<div id="enterpriseApply_page"></div>
<div id="enterpriseRegister_page"></div>	
<%@ include file="/common_message.jsp" %>
<%@ include file="/sys/listSet/listSetColumns.jsp" %>
<%@ include file="/sys/listSet/listSet_warning.jsp" %> 
<script type="text/javascript" src="<%=path %>/sys/listSet/listSetColumns.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/apply/basic.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/apply/enterprise/enterprise.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/apply/enterprise/enterpriseRegister/enterpriseRegister.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/apply/enterprise/enterpriseApply/enterpriseApply.js?v=<%=vardate%>"></script>
