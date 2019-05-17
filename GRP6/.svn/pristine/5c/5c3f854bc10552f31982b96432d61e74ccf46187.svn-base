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
   <!--  <caption >现 金 流 表</caption> -->
    <input type="hidden" name="client_ID" id="client_ID" value="${reportXjl.client_ID}"  />
    <input type="hidden" name="unit_uid" id="unit_uid" value="${reportXjl.unit_uid}"  />
    <input type="hidden" name="reportXjl_ID" id="reportXjl_ID" value="${reportXjl.reportXjl_ID}"  />
    
    
    <tr>
        <h5 class="col-sm-6">类型：<span class="grey">${reportXjl.reportTypeName}</span></h5>
    </tr>
   <tr>
      <h5 class="col-sm-6" align="right" >金额单位：（元）</h5>
   </tr>
   
    <thead>
        <tr>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportXjl.yearMonth}</th>			
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportXjl.yearMonth}</th>
			
        </tr>
    </thead>
    <tbody align="center">
        <tr >
            <td align="left" style="font-weight: bolder;"> 一、经营活动产生的现金流量：</td>
			<td></td>
			<td align="left" style="font-weight: bolder;"> 补充资料：</td>
			<td></td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;销售商品、提供劳务收到的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.servicesGoodsCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left" style="font-weight: bolder;">1、将净利润调节为经营活动现金流量：</td>
			<td></td>
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的税费返还</td>
			<td>
				<fmt:formatNumber value="${reportXjl.receivedTax}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;净利润</td>
			<td>
				<fmt:formatNumber value="${reportXjl.netProfit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的其它与经营活动有关的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.operatingCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：少数股东损益</td>
			<td>
				<fmt:formatNumber value="${reportXjl.stockholderLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">经营现金流入小计</td>
			<td>
				<fmt:formatNumber value="${reportXjl.operatingCashSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：未确认投资损失</td>
			<td>
				<fmt:formatNumber value="${reportXjl.unconfirmed}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;购买商品、接受劳务支付的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.goodsLaborPayCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：计提的资产减值准备</td>
			<td>
				<fmt:formatNumber value="${reportXjl.assetsLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付给职工以及为职工支付的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.employeesToPayCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产折旧</td>
			<td>
				<fmt:formatNumber value="${reportXjl.plantAssetsLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的各项税费</td>
			<td>
				<fmt:formatNumber value="${reportXjl.taxPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产摊销</td>
			<td>
				<fmt:formatNumber value="${reportXjl.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与经营活动有关的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.otherOperatingActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td>
				<fmt:formatNumber value="${reportXjl.longTermPrepaidExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">经营现金流出小计</td>
			<td>
				<fmt:formatNumber value="${reportXjl.operatingCashFlow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用减少（减：增加）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.prepaidExpensesLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营活动产生的现金流量净额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.activitiesNetCashFlow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 预提费用增加（减：减少）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.accruedExpensesAdd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、投资活动产生的现金流量：</td>
			<td></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;处置固定资产、无形资产和其它长期资产的损失（减：收益）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.otherLongTermAssetsLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收回投资所收到的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.disinvestmentCash}" pattern="###,###.##"></fmt:formatNumber>
			
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产报废损失</td>
			<td>
				<fmt:formatNumber value="${reportXjl.disposalFixedAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;取得投资收益所收到的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.investmentIncome}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td>
				<fmt:formatNumber value="${reportXjl.financialExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;处置固定资产、无形资产和其它长期资产所回收的现金净额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.otherAssetsNetCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资损失（减：收益）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.investmentLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的其它与投资活动有关的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.investmentActivitiesCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项（减：借项）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.deferredTax}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">投资现金流入小计</td>
			<td>
				<fmt:formatNumber value="${reportXjl.inflowsOfCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 存货的减少（减：增加）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.decreaseLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;购建固定资产、无形资产和其它长期资产所支付的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.longTermAssetsCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 经营性应收项目的减少（减：增加）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.decreaseOperatingLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资所支付的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.paymentForInvestment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营性应付项目的增加（减：减少）</td>
			<td>
				<fmt:formatNumber value="${reportXjl.increaseOperatingAdd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与投资活动有关的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.otherInvestingActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它</td>
			<td>
				<fmt:formatNumber value="${reportXjl.otherCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">投资现金流出小计</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashOutflow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营活动产生的现金流量净额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.activitiesNetCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资活动产生的现金流量净额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.investmentActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">2、不涉及现金收支的投资和筹资活动：</td>
			<td></td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">三、筹资活动产生的现金流量：</td>
			<td></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;债务转为资本</td>
			<td>
				<fmt:formatNumber value="${reportXjl.convertedCapital}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 吸收投资所收到的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashReceivedInvestment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的可转换公司债券</td>
			<td>
				<fmt:formatNumber value="${reportXjl.switchingCompanyBonds}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;借款所收到的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashReceivedLoan}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;融资租入固定资产</td>
			<td>
				<fmt:formatNumber value="${reportXjl.financeLease}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 收到的其它与筹资活动有关的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.financingActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它</td>
			<td>
				<fmt:formatNumber value="${reportXjl.other}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">筹资现金流入小计</td>
			<td>
				<fmt:formatNumber value="${reportXjl.financingCashFlows}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left" style="font-weight: bolder;">3、现金及现金等价物净增加情况：</td>
			<td></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;偿还债务所支付的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;现金的期末余额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashEnd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;分配股利、利润或偿付利息所支付的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.profitCashPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：现金的期初余额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashBegin}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与筹资活动有关的现金</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashPayments}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：现金等价物的期末余额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashEquivalentsEnd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">筹资现金流出小计</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashfFlowFinancing}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：现金等价物的期初余额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashEquivalentsBegin}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;筹资活动产生的现金流量净额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.netCashFlow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;现金及现金等价物净增加额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashEquivalentsNetCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">四、汇率变动对现金的影响</td>
			<td>
				<fmt:formatNumber value="${reportXjl.exchangeRateCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td></td>
			<td></td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">五、现金及现金等价物净增加额</td>
			<td>
				<fmt:formatNumber value="${reportXjl.cashEquivalentsAmount}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td></td>
			<td></td>
			
        </tr>
    </tbody>
</table>
    <div class="col-md-offset-5" style="margin-top:30px;">		
		<button class="btn" type="button" id="closeReportXjlInfoPage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>



​</div>



​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportXjl/reportXjl.js?v=<%=vardate%>"></script>
