<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>
	<div class="page-content">
			<div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_projectPay" >还款登记</button>&nbsp;
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_projectDelay" >展期</button>&nbsp;
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_projectReplace" >代偿登记</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_projectOverThenToRisk" >逾期确认并转风险处置</button>
			</div>
		<div class="row">
			<div class="col-xs-12">
			  <input type="hidden" id="apply_ID" name="apply_ID" value="${entityID}">
          <%--  <input type="hidden" id="project_ID" name="project_ID" value="${factPay.apply_ID}"> --%>
                    
						   <h4 class="header smaller lighter blue">
								放款情况 
								<!--<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_updateBasicInfo">
									<i class="icon-edit bigger-110"></i>
									<span class="bigger-110 no-text-shadow">修改</span>
								</button> -->
							</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="projectLoad_table" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					
					<div class="space-16 col-sm-12"></div>
					<div class="col-sm-12">
							<h4 class="header smaller lighter blue">
								还款情况
								<!-- <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_updateBasicInfo">
									<i class="icon-edit bigger-110"></i>
									<span class="bigger-110 no-text-shadow">修改</span>
								</button> -->
							</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="projectPay_table" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					<div class="space-16 col-sm-12"></div>
					<div class="col-sm-12">
							<h4 class="header smaller lighter blue">
								展期情况
							</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="projectDelay_table" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
					<div class="space-16 col-sm-12"></div>
					<div class="col-sm-12">
							<h4 class="header smaller lighter blue">
								代偿情况
							</h4>
						<div class="col-sm-12">
							<div class="table-responsive">
								<table id="projectReplace_table" style="font-size:13px !important;"></table>  
						   </div>
						</div>
					</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="projectPayLoadDelay_page"></div>
<%-- <%@ include file="/common_foot.jsp" %> --%>
<%@ include file="/common_message.jsp"%><!-- 请选择一条要操作的数据的页面 -->
<%@ include file="/common_del.jsp" %>
<%@ include file="/project/factPay/projectPay.jsp" %><!-- 还款登记 -->
<%@ include file="/project/factPay/projectDelay.jsp" %><!-- 展期登记 -->
<%@ include file="/project/factPay/projectOver.jsp" %><!-- 逾期确认 -->
<%@ include file="/project/factPay/projectReplace.jsp" %><!-- 代偿登记 -->
<script src="<%=path %>/project/factPay/projectRegist.js?v=<%=vardate%>"></script>
	

	