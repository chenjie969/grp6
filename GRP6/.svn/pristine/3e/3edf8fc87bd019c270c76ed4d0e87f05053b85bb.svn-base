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
<table class="table table-bordered " style="font-size: 13px" id="ReportSyPage">
    <!-- <caption >损益表</caption> -->
    <input type="hidden" name="client_ID" id="client_ID" value="${reportSy.client_ID}"  />
    <input type="hidden" name="unit_uid" id="unit_uid" value="${reportSy.unit_uid}"  />
    <input type="hidden" name="reportSy_ID" id="reportSy_ID" value="${reportSy.reportSy_ID}"  />
    
    
    
    <tr>
        <h5 class="col-sm-6">类型：<span class="grey">${reportSy.reportTypeName}</span></h5>
    </tr>
    <tr>
      <h5  class="col-sm-6" align="right" >金额单位：（元）</h5>
    </tr>
    
    <thead>
        <tr>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportSy.yearMonth}</th>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportSy.yearMonth}</th>
        </tr>
    </thead>
    <tbody align="center" >
        <tr >
            <td align="left" style="font-weight: bolder;">一、主营业务收入：</td>
			<td>
			<span>
			    <fmt:formatNumber value="${reportSy.mainIncome}" pattern="###,###.##"/>
			</span>
			
			</td>
			<td align="left" style="font-weight: bolder;">三、营业利润</td>
			<td>
				<fmt:formatNumber value="${reportSy.operatingProfit}" pattern="###,###.##"/>
			</td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 :主营业务成本</td>
			<td>
				<fmt:formatNumber value="${reportSy.mainCost}" pattern="###,###.##"/>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 投资收益</td>
			<td>
				<fmt:formatNumber value="${reportSy.incomeInvestment}" pattern="###,###.##"/>
			</td>
			
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主营业务税金及附加</td>
			<td>
				<fmt:formatNumber value="${reportSy.mainBusiTax}" pattern="###,###.##"/>
			</td>
			 <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补贴收入</td>
			<td>
				<fmt:formatNumber value="${reportSy.subsidizeRevenue}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、主营业务利润</td>
			<td>
				<fmt:formatNumber value="${reportSy.mainOperatingProfit}" pattern="###,###.##"/>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;营业外收入</td>
			<td>
				<fmt:formatNumber value="${reportSy.operatingIncome}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 其它业务利润</td>
			<td>
				<fmt:formatNumber value="${reportSy.otherBusiProfit}" pattern="###,###.##"/>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业外支出</td>
			<td>
				<fmt:formatNumber value="${reportSy.busiExpenditure}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业费用</td>
			<td>
				<fmt:formatNumber value="${reportSy.busiFee}" pattern="###,###.##"/>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：以前年度损益调整</td>
			<td>
				<fmt:formatNumber value="${reportSy.annualProfitLoss}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理费用</td>
			<td>
				<fmt:formatNumber value="${reportSy.managementFee}" pattern="###,###.##"/>
			</td>
			<td align="left" style="font-weight: bolder;">四、利润总额</td>
			<td>
				<fmt:formatNumber value="${reportSy.profitSum}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td>
				<fmt:formatNumber value="${reportSy.financialFee}" pattern="###,###.##"/>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 : 所得税</td>
			<td>
				<fmt:formatNumber value="${reportSy.incomeTax}" pattern="###,###.##"/>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;汇兑损失</td>
			<td>
				<fmt:formatNumber value="${reportSy.exchangeLoss}" pattern="###,###.##"/>
			</td>
			<td align="left" style="font-weight: bolder;">五、净利润</td>
			<td>
				<fmt:formatNumber value="${reportSy.netProfit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
    </tbody>
</table>
   <div class="col-md-offset-5" style="margin-top:30px;">
		
		<button class="btn" type="button" id="closeReportSyInfoPage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
​</div>

​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportSy/reportSy.js?v=<%=vardate%>"></script>
