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
							<button type="button" class="btn btn-sm btn-info" id="btn_projectApply">申请登记</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_agreeToAccept">同意立项</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_disagreeToAccept">不予立项</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_putProjectInPackage">放入打包车</button>
							&nbsp;&nbsp;
							<button type="button" class="btn btn-sm btn-info" id="btn_delSelectProjectApply">删除所选</button>
							<!-- 根据业务实际, 挪到了业务跟踪页面
								<button type="button" class="btn btn-sm btn-info" id="btn_slaveSynchrMainClient">同步到客户库</button> -->
							<button type="button" class="btn btn-sm btn-info" id="btn_projectApplySelect">高级查询</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_refreshApplyTable">重置列表</button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="projectApply_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="projectApply_page"></div>
<div id="nodeTaskModal_page"></div>
<div id="companyClientSynchroPage"></div>



<%@ include file="/project/apply/projectApplySelect.jsp"%><!-- 高级条件查询页面 -->	
<%@ include file="/common_del.jsp" %>
<%@ include file="/sys/listSet/listSetColumns.jsp" %>
<%@ include file="/sys/listSet/listSet_warning.jsp" %>
<script type="text/javascript" src="<%=path %>/sys/listSet/listSetColumns.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/project/setNodeTask/nodeTaskModal.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/crm/apply/basic.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/project/apply/apply.js?v=<%=vardate%>"></script> 
<%@ include file="/project/apply/singleApplyInfo.jsp" %><!-- -单笔申请查看页面 -->
<%@ include file="/project/apply/multiApplyInfo.jsp" %><!-- -多笔申请查看页面 -->

<%@ include file="/project/apply/ralatioMainApplyInfo.jsp" %><!-- 集团/关联申请查看页面 -->
<%@ include file="/project/apply/selectProductModal.jsp" %><!-- 同意立项-选择流程页面 -->
<%@ include file="/common_message.jsp"%><!-- 公共提示框 -->
<%-- 根据业务实际, 挪到了业务跟踪页面
	<%@ include file="/crm/client/companyClient/syncSuccess.jsp"%> <!-- 客户资料同步成功 --> --%>

<%-- <%@ include file="/project/apply/applyEdit.jsp" %> --%>
	