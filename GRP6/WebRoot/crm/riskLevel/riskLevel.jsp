<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ include file="/common_head.jsp"%>
<%@ include file="/common_foot.jsp"%> --%>
<style media="screen">
			table tr th,td{
				font-size:13px;
				text-align:center;
			}
</style>

<div class="page-content">
	<!--begin页面内容  -->
	
	<div class="page-header">
		<h4 class="" id="">风险等级评定</h4>
	</div>
	<div class="space-4"></div>
	<form class="form-horizontal row" role="form" id="checkCircle">
  	   <div>
			<h4 class="header smaller lighter blue">
				 风险等级评定
				 <c:if test="${'view' ne urlParam.type }">
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addRiskLevelRec">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
				</button>
				</c:if>
			</h4>
			<div class="table-responsive">
				<table id="riskLevelRec_table" style="font-size:13px !important;"></table>  
		  	</div>
		</div>
		
		<div class="col-sm-6">
			<div class="space-6"></div>
			<table class="table table-striped table-bordered table-hover" data-toggle="table" data-striped="true" >
	             <thead>
					<tr>
						<th>等级</th>
						<th>评级说明</th>
					</tr>
				 </thead>
				 <tbody>
					<tr>  
						 <td><span class="label label-success arrowed-in-right arrowed-in">正常</span></td>  
						 <td>担保对象有能力履约，能正常还本付息，不存在影响还债的消极因素及代偿的可能性。</td>  
					</tr>  
					<tr>  
						<td><span class="label label-yellow arrowed-in-right arrowed-in">关注</span></td>  
						<td>尽管担保对象目前有能力偿还本息，但是存在潜在缺陷，继续下去会影响贷款的偿还，担保机构有发生代偿的潜在风险。</td>  
					 </tr> 
					<tr>  
				     	<td><span class="label label-pink arrowed-in-right arrowed-in">次级</span></td>  
				    	 <td>担保对象的偿还能力明显出现问题，完全依靠正常营业收入无法足额偿还债务，即使执行反担保，也可能会造成少部分损失。</td>  
				    </tr> 
				    <tr>  
					     <td><span class="label label-warning arrowed-in-right arrowed-in">可疑</span></td>  
					     <td>担保对象出现支付困难，正常经营收入不能保证还款，需要通过变卖资产，甚至通过担保机构履行部分代偿责任来还款。</td>  
				    </tr> 
				    <tr>  
					     <td><span class="label label-danger arrowed-in-right arrowed-in">损失</span></td>  
					     <td>在采取所有可能的措施或一切必要的法律程序之后，债权无法收回，或只能部分收回。</td>  
				    </tr> 
			    </tbody>
		    </table>
		</div>
	</form>
</div>
<div id="riskLevel_page"></div>
<%@ include file="/crm/riskLevel/addRiskLevel.jsp" %>
<%@ include file="/crm/riskLevel/riskLevelDel.jsp" %>
<script src="<%=path %>/crm/riskLevel/riskLevel.js?v=<%=vardate%>"></script>