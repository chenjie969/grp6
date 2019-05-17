<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>


<!-- <script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script> -->

<div class="page-content">   
      <!--  <input type="hidden" id="singleAppleAddPage" class="pageType" name="singleAppleAddPage" value="0">
     
       -->
     
      <div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">
						 项目信息
		  	</h4>
			<div class="col-sm-12">
				<input type="hidden"  id="project_ID" value="${project.project_ID}">
				<input type="hidden"  id="applyID" value="${project.apply_ID}">
                <h5 class="col-sm-12">项目名称：<span class="grey">${project.projectName}</span></h5>
                <h5 class="col-sm-6">业务品种：<span class="grey">${project.busiTypeName}</span></h5>
                <h5 class="col-sm-6">放款机构：<span class="grey">${project.bankName}</span></h5>
                <h5 class="col-sm-6">项目金额：<span class="grey"><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"/></span></h5>
                <h5 class="col-sm-6">在保余额：<span class="grey"><fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######"/></span></h5>
                <h5 class="col-sm-6">开始日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></span></h5>
                <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadEndDate}"/></span></h5>
                <h5 class="col-sm-6">期限：<span class="grey">${project.periodMonthDay}</span></h5>
			</div>
			<div class="col-sm-12 space-20"></div>
            	<div>
					<h4 class="header smaller lighter blue">
						代偿明细
						<!-- <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_replaceAdd">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button> -->
					</h4>
					<div class="col-sm-12">
						<div class="table-responsive">
							<table id="replacePro_table" style="font-size:13px !important;"></table>  
					   </div>
					</div>
				</div>
				<div class="col-sm-12 space-20"></div>
				<div>
					<h4 class="header smaller lighter blue">
						追偿明细
						<!-- <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_returnAdd">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button> -->
					</h4>
					<div class="col-sm-12">
						<div class="table-responsive">
							<table id="returnDetailPro_table" style="font-size:13px !important;"></table>  
					   </div>
					</div>
				</div>
	    
     </div>
    </div>
    <div id="replace_page"></div>
</div>
<%-- <%@ include file="/common_foot.jsp" %> --%>
<script src="<%=path %>/project/apply/projectReplaceAndReturnInfo.js?v=<%=vardate%>"></script> 