<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
	table{
		font-size:14px !important;
	}
	table tr td{
		border:1px solid #ddd;
		text-align: center;
	}
	.twoLocation{
		text-align: left;
	}
</style>

<div class="page-header">
	<h4>企业续保申请处理</h4>
</div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h5 class="header smaller lighter blue">
				项目信息
			</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务编号：<span class="grey">${empty apply.busiCode ? "（空）":apply.busiCode}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目名称：<span class="grey">${empty apply.projectName ? "（空）":apply.projectName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务性质：<span class="grey">${empty apply.busiNatureName ? "（空）":apply.busiNatureName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						类别：<span class="grey">${empty apply.projectType ? "（空）":apply.projectType}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						A角：<span class="grey">${empty apply.amanName ? "（空）":apply.amanName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
					    B角：<span class="grey">${empty apply.bmanName ? "（空）":apply.bmanName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						风控评审人：<span class="grey">${empty apply.reviewManName ? "（空）":apply.reviewManName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						经办部门：<span class="grey">${empty apply.departName ? "（空）":apply.departName}</span>
					</h5>
					
				<div class="space-16 col-sm-12"></div>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
			<form class="form-horizontal row" role="form" id="optGuarantyProcess_form">
				<input type="hidden" id="optGuarantyProcess_ID" name="optGuarantyProcess_ID" value="${guarantyProcess.optGuarantyProcess_ID }">
				<%-- <input type="hidden" id="guarantySum"  value="${project.guarantySum }">
				<input type="hidden" id="project_ID" name="project_ID" value="${project.project_ID }"> --%>
				<input type="hidden" id="apply_ID" value="${apply_ID}">
				<table class="table table-bordered table-strip">
					<col style="background:#f9f9f9;"></col>
					<colgroup>
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
					</colgroup>
					<tr>
						<td>序号</td>  
	             		<td align = "center">保证方式名称</td>  
	            		<td align = "center">反担保物类型名称</td>  
	             		<td align = "center">反担保物名称</td>  
	            		<td align = "center">权属人名称</td>  
	             		<td align = "center">抵押物原值（万）</td> 
	             		<td align = "center">购卖价值（万）</td> 
	             		<td align = "center">抵押（质押）价值（万）</td> 
	             		<td align = "center">抵押物金额</td> 
	             		<td align = "center">操作</td> 
					</tr>
					<c:forEach items="${optGuaranties}" var="optGuarantie" varStatus="vs">  
       				 <tr>  
             			<td>  
                			<s:property value="#vs.index+1"/>  
             			</td>  
	             		<td align = "center">${optGuarantie.guarantyTypeName}</td>  
	            		<td align = "center">${optGuarantie.optTypeName}</td>  
	             		<td align = "center">${optGuarantie.optName}</td>  
	            		<td align = "center">${optGuarantie.ownerName}</td>  
	             		<td align = "center">${optGuarantie.oldValue}</td> 
	             		<td align = "center">${optGuarantie.buyValue}</td> 
	             		<td align = "center">${optGuarantie.optValue}</td> 
	             		<td align = "center">${optGuarantie.optPeriod}</td> 
	             		<td align = "center"><input type="hidden" id="optGuaranty_ID" value="${optGuarantie.optGuaranty_ID}">
						<%-- <span class="grey isWorkable" id="isWorkables">
						<c:if test="${opt.isWorkables eq '0' }"><button title="落实"  id="btn_realizeOptGuaranty" data-toggle="modal" data-target="#edit_Page"><span style="color:#F00">落实</span></button></c:if>
						<c:if test="${opt.isWorkables eq '1'}">已落实 </c:if></span> --%>
						<button title="落实"  id="btn_realizeOptGuaranty" data-toggle="modal" data-target="#edit_Page"><span style="color:#F00">落实</span></button>
						</td> 
         				</tr>  
					</c:forEach>
					<jsp:include page="/gworkFlow/components/component_sugget_view_import.jsp"></jsp:include>
				</table>
				</form>
			</div>
			<div class="col-sm-12 space-16"></div>
			<!-- <div class="col-sm-12 clearfix form-actions">
				<div class="col-md-offset-5 col-md-7">
					<button class="btn btn_factPaySave" type="button"><i class="icon-save bigger-110 "></i>保存</button>
			        <button class="btn btn_factViewColse" type="button"><i class="icon-remove bigger-110 "></i>关闭</button>
	      		</div>
	      	</div> -->
			
		</div>
	</div>
</div>
<div id="optGuaranty_page"></div>
<div id="clientList_page"></div>
<div id="loanApproval_page"></div>
<script src="<%=path %>/project/opt/optManager/optManager3.js"></script>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
