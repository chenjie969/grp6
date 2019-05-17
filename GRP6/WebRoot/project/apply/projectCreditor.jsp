<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

<!-- <script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script> -->

<div class="page-content">   
     
      <div class="row">
		<div class="col-xs-12">
		<h4 class="header smaller lighter blue">
						 项目信息
		  	</h4>
			<div class="col-sm-12">
				<input type="hidden"  id="project_ID" value="${project.project_ID}">
				<input type="hidden"  id="apply_ID" value="${project.apply_ID}">
                <h5 class="col-sm-12">项目名称：<span class="grey">${project.projectName}</span></h5>
                <h5 class="col-sm-6">业务品种：<span class="grey">${project.busiTypeName}</span></h5>
                <h5 class="col-sm-6">放款机构：<span class="grey">${project.bankName}</span></h5>
                <h5 class="col-sm-6">项目金额：<span class="grey"><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"/></span></h5>
                <h5 class="col-sm-6">在保余额：<span class="grey"><fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######"/></span></h5>
                <h5 class="col-sm-6">开始日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></span></h5>
                <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.delayEndDate}"/></span></h5>
                <h5 class="col-sm-6">期限：<span class="grey">${project.periodMonthDay}</span></h5>
			</div>
		<h4 class="header smaller lighter blue">
				 债权情况记录
		</h4>
			<div class="col-sm-12">
				<div class="table-responsive">
					<table id="projectCreditor_table" style="font-size:13px !important;"></table>  
			   </div>
			</div>
		 	<div class="col-sm-12 space-20"></div>
        <h4 class="header smaller lighter blue">
				债权情况
	  	</h4>
		<form class="form-horizontal" role="form" id="projectCreditor_form">
         <!--  <input type="hidden" id="projectType" class="" name="projectType" value="单笔">是否单笔业务 
          <input type="hidden" id="projectStageID" name="projectStageID" value="保后阶段">	 项目阶段id		 			
    	  <input type="hidden" id="projectStageName" name="projectStageName"  value="保后阶段">	 项目阶段名称 -->
    	  <input type="hidden" id="projectId" name="projectId" value="${project.project_ID}">
    	  <input type="hidden" id="oldClientId" name="oldClientId" value="${apply.client_ID }"/><!-- 客户id -->	
    	  <input type="hidden" id="oldClientName" name="oldClientName" value="${apply.clientName }"/><!-- 客户xingming-->	 		
    	  <input type="hidden" id="applyId" name="applyId" value="${apply.apply_ID }"/><!-- 客户唯一标示 -->	 		
		<!--  <input type="hidden" id="busiNatureName" class="busiNatureName" name="busiNatureName" value="存量业务">
		 <input type="hidden" id="busiNatureID" class="busiNatureID" name="busiNatureID" value="f11443ed9b444a2db6242925c4f5a1dd"> -->
         <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>资金来源： </label>
				<div class="col-md-6">
	                 	<!-- <input type="hidden" id="projectSourceName" class="projectSourceName" name="projectSourceName"> -->
						<select id="fundSourceList" class=" col-sm-6 col-md-6 validate[required] selectList"  name="fundSource"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${fundSourceList}" var="fundSource">
									<option value="${fundSource.dicTypeName}">${fundSource.dicTypeName}</option>
								</c:forEach>
					    </select>
				</select>
				</div>
          </div>
         
           <div class="space-4"></div>
           <div class="form-group">
			   <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>资金方类型： </label>
				<div class="col-md-6">
						<input type="hidden" id="fundTypeName" class="" name="fundType" >
						<select id="fundTypeList" class="selectList validate[required]  col-sm-6 col-md-6 "  name="fundTypeId"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${fundTypeList}" var="fundType">
									<option value="${fundType.dicTypeID}">${fundType.dicTypeName}</option>
								</c:forEach>
					    </select>
				</div>
           </div> 

           <div class="space-4"></div>
		    <div class="form-group" id="cooperation">
		   		<label class="col-md-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>资金方名称： </label>
		        <div class="col-md-6">
					<div class="col-sm-6 col-md-6 input-group fundChineseTree">
							<input  type="text"  class="form-control validate[required]" autoField="fundID"   id="fundChineseTree"  value="" dataValue="" name="fundName"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
				    </div>
				</div>
           	</div>
          
          <div class="space-4"></div>
          <div class="form-group">
          <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>资金方子机构： </label>
				<div class="col-md-10">
	            	<input type="text" id="subFundName" name="subFundName"  class="col-md-5 col-sm-6 validate[required,maxSize[50]]" />
				</div>
          </div>
          
		   <div class="space-4"></div>
           <div class="form-group">
           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>转让金额： </label>
             <div class="col-md-10">
                 <input type="text" id="creditorSum" name="creditorSum" class="col-md-2 col-lg-1 validate[required,maxSize[18],custom[number]]" />
                 <span class="col-md-10 col-lg-11" style="line-height:28px;">万元</span>
             </div>
			</div>
        <div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上报日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-sm-6 col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]" id="creditorDate" name="creditorDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
        </form>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_projectCreditorAdd" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      <!--  <button class="btn btn-primary btn_agreeAdd" type="button" value="0"><i class="icon-ok bigger-110"></i>同意立项</button>
		        &nbsp; &nbsp; &nbsp; -->
		       <button class="btn btn_colse" id="btn_closeProjectCreditorAdd" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div>     
     </div>
    </div>
</div>
<div id="projectDelay_page"/>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/project/apply/clientList.jsp" %>
<script src="<%=path %>/project/apply/projectCreditor.js?v=<%=vardate%>"></script> 