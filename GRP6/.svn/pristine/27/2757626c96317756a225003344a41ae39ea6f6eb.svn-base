<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	<div class="page-header"><!--begin页头部分 -->
		
    	<h5>项目名称：
    		<span class=" ">${apply.projectName}</span>
			<span style="margin-left:2em;" class="grey">项目编号：
				<span class="">${apply.busiCode}</span>
			</span>
		</h5>
		
	</div><!-- /.page-header end 页头部分--><!-- TODO：豆豆添加 2017年5月5日 14:06:39 -->
	
	<%-- <%@ include file="/crm/client/companyClient/companyClientHead.jsp"%> --%>
	
	
	
	
	<h4 class="header smaller lighter blue">
		基本信息
		<!-- <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_updateProjectBasicInfo">
			<i class="icon-edit bigger-110"></i>
			<span class="bigger-110 no-text-shadow">修改</span>
		</button> -->
	</h4>
    <div class="row" style="margin:0;">
        <h5 class="col-sm-6">业务性质：<span class="grey ">${apply.busiNatureName}</span></h5>
         <h5 class="col-sm-6">项目类型：<span class="grey ">${apply.projectType}</span></h5>
         <h5 class="col-sm-6">客户类型：<span class="grey ">${clientType.dicTypeName}</span></h5>
         <h5 class="col-sm-6">客户名称：<span class="grey ">${apply.clientName}</span></h5>
         <h5 class="col-sm-6">业务品种：<span class="grey ">${project.busiTypeName}</span></h5>
         <h5 class="col-sm-6">项目来源：<span class="grey ">${apply.projectSourceName }</span></h5>
         <h5 class="col-sm-6">资金方类型：<span class="grey ">${apply.fundType }</span></h5>
         <h5 class="col-sm-6">资金方名称：<span class="grey ">${apply.fundChinese }</span></h5>
         <h5 class="col-sm-12">资金方子机构：<span class="grey ">${apply.fundName }</span></h5>
         <h5 class="col-sm-12">合作机构：<span class="grey ">${project.bankName }</span></h5>
         <h5 class="col-sm-12">合作子机构(或个人)：<span class="grey ">${project.subBankName }</span></h5>
         <h5 class="col-sm-12">经办部门：<span class="grey ">${apply.operationDepartName}</span>&nbsp;</h5>
         <h5 class="col-sm-12">经办人：<span class="grey ">${apply.createManName}</span>&nbsp;</h5>
         <h5 class="col-sm-12">A角：<span class="grey ">${project.amanName }</span></h5>
         <h5 class="col-sm-12">B角：<span class="grey ">${project.bmanName }</span></h5>
         <h5 class="col-sm-4">受理日期：<span class="grey ">
         	<fmt:formatDate value="${apply.createDate}" pattern="yyyy-MM-dd"/> 
         </span></h5>
    </div>
	
 <script src="<%=path %>/crm/client/companyClient/clientBasicInfo.js?v=<%=vardate%>"></script>