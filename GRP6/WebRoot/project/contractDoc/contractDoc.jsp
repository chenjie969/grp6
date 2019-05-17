<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />

<div class="page-content">
	<input type="hidden" name="applyID" id="applyID" value="${urlParam.entityID}">
	<input type="hidden" name="type" id="type" value="${urlParam.type}">
	<div class="page-header">
		<c:if test="${empty comming }">
			<h4>制作合同</h4>
		</c:if>
		<c:if test="${!empty comming }">
			<h4>合同详情</h4>
		</c:if>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<h4 class="header smaller lighter blue">
				项目信息
			</h4>
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务编号：<span class="grey">${empty apply.busiCode ? "（空）":apply.busiCode}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目名称：<span class="grey">${empty apply.projectName ? "（空）":apply.projectName}</span>
					</h5>
					<%-- <h5 style="line-height: 26px;"class="col-sm-6">
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
						风控评审人：${empty apply.reviewManName ? "（空）":apply.reviewManName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						经办部门：<span class="grey">${empty apply.departName ? "（空）":apply.departName}</span>
					</h5> --%>
					<c:choose>
						<c:when test="${project.busiClass eq '01' }">
							<h5  style="line-height: 26px;"class="col-sm-12">
								委托担保合同号：
								<span class="grey"> 
									<textarea class="col-md-12 col-sm-8 limited" rows="5" id="dcontractCode"  name="dcontractCode" readonly>${applyDetail.dcontractCode }</textarea>
								</span>
							</h5>
							<h5  style="line-height: 26px;"class="col-sm-12">
								借款合同号：
								<span class="grey"> 
									<textarea class="col-md-12 col-sm-8 limited" rows="5" id="jcontractCode"  name="jcontractCode"readonly >${applyDetail.jcontractCode}</textarea>
								</span>
							</h5>
						</c:when>
						<c:otherwise>
							<h5  style="line-height: 26px;"class="col-sm-12">
								委托合同号：
								<span class="grey"> 
									<textarea class="col-md-12 col-sm-8 limited" rows="5" id="dcontractCode"  name="dcontractCode" readonly>${applyDetail.dcontractCode }</textarea>
								</span>
							</h5>
						</c:otherwise>
					</c:choose>
					
					
					<h5  style="line-height: 26px;"class="col-sm-12">
						保证合同号：
						<span class="grey"> 
							<textarea class="col-md-12 col-sm-8 limited" rows="5" id="bcontractCode"  name="bcontractCode" readonly>${applyDetail.bcontractCode }</textarea>
						</span>
					</h5>
				<div class="space-16 col-sm-12"></div>
				<h4 class="header smaller lighter blue">
					合同列表
					<c:if test="${urlParam.type eq 'edit' }">
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addHetTong">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">新增合同</span>
						</button>
					</c:if>
				</h4>
				
				<div class="table-responsive" id="loadinfo222">
						<table id="heTong_table" style="font-size: 13px !important;"></table>
					</div>
				</div>
	</div>
</div><!-- /.page-content -->
<div id="HeTong_page"></div>
<script src="<%=path %>/project/contractDoc/contractDoc.js?v=<%=vardate%>"></script>
<%@ include file="/project/contractDoc/contractDocDel.jsp" %>
<%@ include file="/project/contractDoc/contractDocUpload.jsp" %>
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>

