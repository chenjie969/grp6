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
							<button type="button" class="btn btn-sm btn-info" id="btn_addCreditApply">授信申请</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_agreeToCreditAccept">同意立项</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_disapproveApply">不予立项</button>
							&nbsp;&nbsp;
							<button type="button" class="btn btn-sm btn-info" id="btn_batchDeleteApply">删除所选</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_advancedQuery">高级查询</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_refreshTable">重置列表</button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="creditApply_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="creditApply_page"></div>
<div id="nodeTaskModal_page"></div>	
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>

<script src="<%=path %>/project/credit/apply/creditApply.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/project/setNodeTask/nodeTaskModal.js?v=<%=vardate%>"></script>
<%@ include file="/project/apply/selectProductModal.jsp" %><!-- 同意立项-选择流程页面 -->
<%@ include file="/common_message.jsp"%><!-- 公共提示框 -->
	