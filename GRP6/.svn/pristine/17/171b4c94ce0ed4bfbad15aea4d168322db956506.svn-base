<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content">		
	<div class="page-header"><!--begin页头部分 -->	
	    	<h5>客户名称：
	    		<span class="ztb_view_clientName">${client.clientName}</span>
				<span style="margin-left:2em;" class="grey">客户编号：
					<span class="ztb_view_clientBH">
					<c:if test="${client.clientBH eq null}">
						  （空）
					</c:if>
						${client.clientBH}
					</span>					
				</span>
						
			</h5>
	 </div>
	<table class="table table-bordered" style="font-size: 13px">
    <!-- <caption >损益表</caption> -->
    
     <input type="hidden" name="client_ID" id="client_ID" value="${reportSy1.client_ID}"  />
   	 <input type="hidden" name="unit_uid" id="unit_uid" value="${reportSy1.unit_uid}"  />
     <input type="hidden" name="reportSy_ID" id="reportSy_ID" value="${reportSy1.reportSy_ID}"  />
    
    
    <tr>
        <h5 class="col-sm-6">类型：<span class="grey">${reportSy1.reportTypeName}</span></h5>
    </tr>
    <tr>
      <h5 class="col-sm-6" align="right" >金额单位：（元）</h5>
    </tr>
    
    <thead>
        <tr>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportSy1.yearMonth}</th>
			<th style="text-align: center;">${reportSy2.yearMonth}</th>
			<th style="text-align: center;">增减</th>
        </tr>
    </thead>
    <tbody align="center" >
        <tr >
            <td align="left" style="font-weight: bolder;">一、主营业务收入：</td>
			<td><fmt:formatNumber value="${reportSy1.mainIncome}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.mainIncome}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.mainIncome-reportSy2.mainIncome gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportSy1.mainIncome-reportSy2.mainIncome}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 :主营业务成本</td>
			<td><fmt:formatNumber value="${reportSy1.mainCost}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.mainCost}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.mainCost-reportSy2.mainCost gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.mainCost-reportSy2.mainCost}" pattern="###,###.##"/>
			</td>
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主营业务税金及附加</td>
			<td><fmt:formatNumber value="${reportSy1.mainBusiTax}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.mainBusiTax}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.mainBusiTax-reportSy2.mainBusiTax gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.mainBusiTax-reportSy2.mainBusiTax}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、主营业务利润</td>
			<td><fmt:formatNumber value="${reportSy1.mainOperatingProfit}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.mainOperatingProfit}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.mainOperatingProfit-reportSy2.mainOperatingProfit gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportSy1.mainOperatingProfit-reportSy2.mainOperatingProfit}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 其它业务利润</td>
			<td><fmt:formatNumber value="${reportSy1.otherBusiProfit}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.otherBusiProfit}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.otherBusiProfit-reportSy2.otherBusiProfit gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.otherBusiProfit-reportSy2.otherBusiProfit}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业费用</td>
			<td><fmt:formatNumber value="${reportSy1.busiFee}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.busiFee}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.busiFee-reportSy2.busiFee gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.busiFee-reportSy2.busiFee}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理费用</td>
			<td><fmt:formatNumber value="${reportSy1.managementFee}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.managementFee}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.managementFee-reportSy2.managementFee gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportSy1.managementFee-reportSy2.managementFee}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td><fmt:formatNumber value="${reportSy1.financialFee}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.financialFee}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.financialFee-reportSy2.financialFee gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.financialFee-reportSy2.financialFee}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;汇兑损失</td>
			<td><fmt:formatNumber value="${reportSy1.exchangeLoss}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.exchangeLoss}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.exchangeLoss-reportSy2.exchangeLoss gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.exchangeLoss-reportSy2.exchangeLoss}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">三、营业利润</td>
			<td><fmt:formatNumber value="${reportSy1.operatingProfit}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.operatingProfit}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.operatingProfit-reportSy2.operatingProfit gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.operatingProfit-reportSy2.operatingProfit}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 投资收益</td>
			<td><fmt:formatNumber value="${reportSy1.incomeInvestment}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.incomeInvestment}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.incomeInvestment-reportSy2.incomeInvestment gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.incomeInvestment-reportSy2.incomeInvestment}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补贴收入</td>
			<td><fmt:formatNumber value="${reportSy1.subsidizeRevenue}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.subsidizeRevenue}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.subsidizeRevenue-reportSy2.subsidizeRevenue gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.subsidizeRevenue-reportSy2.subsidizeRevenue}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;营业外收入</td>
			<td><fmt:formatNumber value="${reportSy1.operatingIncome}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.operatingIncome}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.operatingIncome-reportSy2.operatingIncome gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.operatingIncome-reportSy2.operatingIncome}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业外支出</td>
			<td><fmt:formatNumber value="${reportSy1.busiExpenditure}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.busiExpenditure}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.busiExpenditure-reportSy2.busiExpenditure gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.busiExpenditure-reportSy2.busiExpenditure}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：以前年度损益调整</td>
			<td><fmt:formatNumber value="${reportSy1.annualProfitLoss}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.annualProfitLoss}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.annualProfitLoss-reportSy2.annualProfitLoss gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.annualProfitLoss-reportSy2.annualProfitLoss}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">四、利润总额</td>
			<td><fmt:formatNumber value="${reportSy1.profitSum}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.profitSum}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.profitSum-reportSy2.profitSum gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.profitSum-reportSy2.profitSum}" pattern="###,###.##"/>
			</td>
        </tr>
       <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 : 所得税</td>
			<td><fmt:formatNumber value="${reportSy1.incomeTax}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.incomeTax}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.incomeTax-reportSy2.incomeTax gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.incomeTax-reportSy2.incomeTax}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">五、净利润</td>
			<td><fmt:formatNumber value="${reportSy1.netProfit}" pattern="###,###.##"/></td>
			<td><fmt:formatNumber value="${reportSy2.netProfit}" pattern="###,###.##"/></td>
			<td>
				<c:if test="${reportSy1.netProfit-reportSy2.netProfit gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportSy1.netProfit-reportSy2.netProfit}" pattern="###,###.##"/>
			</td>
        </tr>
    </tbody>
</table>
	<div class="col-md-offset-5" style="margin-top:30px;">		
		<button class="btn" type="button" id="btn_closeReportSyComparePage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>

​</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportSy/reportSy.js?v=<%=vardate%>"></script>
	