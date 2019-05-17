<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                	 <c:if test="${apply.type=='edit' }">
	                	 <div class="col-sm-12">
							<div class="page-header">
								<button type="button" class="btn btn-sm btn-info" id="btn_addSglProBillInfo">登记票据信息</button>&nbsp;
							</div>
	                     </div>
                	 </c:if>
                	 <c:if test="${apply.type=='view' }">
	                	 <div class="col-xs-12" style="height:30px"></div>
                	 </c:if>
                     <div class="col-sm-12">
	                    <input type="hidden" id="hidden_applyID" value="${apply.apply_ID }">
						<input type="hidden" id="hidden_applyDetailID" value="${applyDetail.applyDetail_ID }">
						<input type="hidden" id="hidden_type" value="${apply.type }">
						<div class="table-responsive">
							<table id="table_singleProjectBill" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="singleProjectBill_page"></div>
	
<script src="<%=path %>/project/finance/billManage/singleProjectBill_GBPM.js?v=<%=vardate%>"></script>

	