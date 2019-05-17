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
   <!--  <caption >现 金 流 表对比</caption> -->
     <input type="hidden" name="client_ID" id="client_ID" value="${reportXjl1.client_ID}"  />
   	 <input type="hidden" name="unit_uid" id="unit_uid" value="${reportXjl1.unit_uid}"  />
     <input type="hidden" name="reportXjl_ID" id="reportXjl_ID" value="${reportXjl1.reportXjl_ID}"  />
    
   <tr>
        <h5 class="col-sm-6">类型：<span class="grey">${reportXjl1.reportTypeName}</span></h5>
    </tr>
   <tr>
      <h5 class="col-sm-6" align="right" >金额单位：（元）</h5>
   </tr>
   
    <thead>
        <tr>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportXjl1.yearMonth}</th>			
			<th style="text-align: center;">${reportXjl2.yearMonth}</th>			
			<th style="text-align: center;">增减</th>			
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportXjl1.yearMonth}</th>
			<th style="text-align: center;">${reportXjl2.yearMonth}</th>
			<th style="text-align: center;">增减</th>
			
        </tr>
    </thead>
    <tbody align="center">
        <tr >
            <td align="left" style="font-weight: bolder;"> 一、经营活动产生的现金流量：</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left" style="font-weight: bolder;"> 补充资料：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;销售商品、提供劳务收到的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.servicesGoodsCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.servicesGoodsCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.servicesGoodsCash-reportXjl2.servicesGoodsCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.servicesGoodsCash-reportXjl2.servicesGoodsCash}" pattern="###,###.##"></fmt:formatNumber>
			
			</td>
			<td align="left" style="font-weight: bolder;">1、将净利润调节为经营活动现金流量：</td>
			<td></td>
			<td></td>
			<td></td>

        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的税费返还</td>
			<td><fmt:formatNumber value="${reportXjl1.receivedTax}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.receivedTax}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.receivedTax-reportXjl2.receivedTax gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.receivedTax-reportXjl2.receivedTax}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;净利润</td>
			<td><fmt:formatNumber value="${reportXjl1.netProfit}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.netProfit}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.netProfit-reportXjl2.netProfit gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.netProfit-reportXjl2.netProfit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的其它与经营活动有关的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.operatingCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.operatingCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.operatingCash-reportXjl2.operatingCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.operatingCash-reportXjl2.operatingCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：少数股东损益</td>
			<td><fmt:formatNumber value="${reportXjl1.stockholderLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.stockholderLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.stockholderLoss-reportXjl2.stockholderLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.stockholderLoss-reportXjl2.stockholderLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">经营现金流入小计</td>
			<td><fmt:formatNumber value="${reportXjl1.operatingCashSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.operatingCashSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.operatingCashSum-reportXjl2.operatingCashSum gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.operatingCashSum-reportXjl2.operatingCashSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：未确认投资损失</td>
			<td><fmt:formatNumber value="${reportXjl1.unconfirmed}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.unconfirmed}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.unconfirmed-reportXjl2.unconfirmed gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.unconfirmed-reportXjl2.unconfirmed}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;购买商品、接受劳务支付的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.goodsLaborPayCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.goodsLaborPayCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.goodsLaborPayCash-reportXjl2.goodsLaborPayCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.goodsLaborPayCash-reportXjl2.goodsLaborPayCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：计提的资产减值准备</td>
			<td><fmt:formatNumber value="${reportXjl1.assetsLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.assetsLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.assetsLoss-reportXjl2.assetsLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.assetsLoss-reportXjl2.assetsLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付给职工以及为职工支付的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.employeesToPayCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.employeesToPayCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.employeesToPayCash-reportXjl2.employeesToPayCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.employeesToPayCash-reportXjl2.employeesToPayCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产折旧</td>
			<td><fmt:formatNumber value="${reportXjl1.plantAssetsLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.plantAssetsLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.plantAssetsLoss-reportXjl2.plantAssetsLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.plantAssetsLoss-reportXjl2.plantAssetsLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的各项税费</td>
			<td><fmt:formatNumber value="${reportXjl1.taxPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.taxPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.taxPayment-reportXjl2.taxPayment gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.taxPayment-reportXjl2.taxPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产摊销</td>
			<td><fmt:formatNumber value="${reportXjl1.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.intangibleAssets-reportXjl2.intangibleAssets gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.intangibleAssets-reportXjl2.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与经营活动有关的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.otherOperatingActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.otherOperatingActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.otherOperatingActivities-reportXjl2.otherOperatingActivities gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.otherOperatingActivities-reportXjl2.otherOperatingActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td><fmt:formatNumber value="${reportXjl1.longTermPrepaidExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.longTermPrepaidExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.longTermPrepaidExpenses-reportXjl2.longTermPrepaidExpenses gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.longTermPrepaidExpenses-reportXjl2.longTermPrepaidExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">经营现金流出小计</td>
			<td><fmt:formatNumber value="${reportXjl1.operatingCashFlow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.operatingCashFlow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.operatingCashFlow-reportXjl2.operatingCashFlow gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.operatingCashFlow-reportXjl2.operatingCashFlow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用减少（减：增加）</td>
			<td><fmt:formatNumber value="${reportXjl1.prepaidExpensesLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.prepaidExpensesLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.prepaidExpensesLoss-reportXjl2.prepaidExpensesLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.prepaidExpensesLoss-reportXjl2.prepaidExpensesLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营活动产生的现金流量净额</td>
			<td><fmt:formatNumber value="${reportXjl1.activitiesNetCashFlow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.activitiesNetCashFlow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.activitiesNetCashFlow-reportXjl2.activitiesNetCashFlow gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.activitiesNetCashFlow-reportXjl2.activitiesNetCashFlow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 预提费用增加（减：减少）</td>
			<td><fmt:formatNumber value="${reportXjl1.accruedExpensesAdd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.accruedExpensesAdd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.accruedExpensesAdd-reportXjl2.accruedExpensesAdd gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.accruedExpensesAdd-reportXjl2.accruedExpensesAdd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、投资活动产生的现金流量：</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;处置固定资产、无形资产和其它长期资产的损失（减：收益）</td>
			<td><fmt:formatNumber value="${reportXjl1.otherLongTermAssetsLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.otherLongTermAssetsLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.otherLongTermAssetsLoss-reportXjl2.otherLongTermAssetsLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.otherLongTermAssetsLoss-reportXjl2.otherLongTermAssetsLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收回投资所收到的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.disinvestmentCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.disinvestmentCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.disinvestmentCash-reportXjl2.disinvestmentCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.disinvestmentCash-reportXjl2.disinvestmentCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产报废损失</td>
			<td><fmt:formatNumber value="${reportXjl1.disposalFixedAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.disposalFixedAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.disposalFixedAssets-reportXjl2.disposalFixedAssets gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.disposalFixedAssets-reportXjl2.disposalFixedAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;取得投资收益所收到的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.investmentIncome}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.investmentIncome}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.investmentIncome-reportXjl2.investmentIncome gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.investmentIncome-reportXjl2.investmentIncome}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td><fmt:formatNumber value="${reportXjl1.financialExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.financialExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.financialExpenses-reportXjl2.financialExpenses gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.financialExpenses-reportXjl2.financialExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;处置固定资产、无形资产和其它长期资产所回收的现金净额</td>
			<td><fmt:formatNumber value="${reportXjl1.otherAssetsNetCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.otherAssetsNetCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.otherAssetsNetCash-reportXjl2.otherAssetsNetCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.otherAssetsNetCash-reportXjl2.otherAssetsNetCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资损失（减：收益）</td>
			<td><fmt:formatNumber value="${reportXjl1.investmentLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.investmentLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.investmentLoss-reportXjl2.investmentLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.investmentLoss-reportXjl2.investmentLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的其它与投资活动有关的现金</td>
			<td><fmt:formatNumber value="${reportXjl.investmentActivitiesCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl.investmentActivitiesCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.investmentActivitiesCash-reportXjl2.investmentActivitiesCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.investmentActivitiesCash-reportXjl2.investmentActivitiesCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项（减：借项）</td>
			<td><fmt:formatNumber value="${reportXjl1.deferredTax}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.deferredTax}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.deferredTax-reportXjl2.deferredTax gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.deferredTax-reportXjl2.deferredTax}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">投资现金流入小计</td>
			<td><fmt:formatNumber value="${reportXjl1.inflowsOfCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.inflowsOfCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.inflowsOfCash-reportXjl2.inflowsOfCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.inflowsOfCash-reportXjl2.inflowsOfCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 存货的减少（减：增加）</td>
			<td><fmt:formatNumber value="${reportXjl1.decreaseLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.decreaseLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.decreaseLoss-reportXjl2.decreaseLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.decreaseLoss-reportXjl2.decreaseLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;购建固定资产、无形资产和其它长期资产所支付的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.longTermAssetsCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.longTermAssetsCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.longTermAssetsCash-reportXjl2.longTermAssetsCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.longTermAssetsCash-reportXjl2.longTermAssetsCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 经营性应收项目的减少（减：增加）</td>
			<td><fmt:formatNumber value="${reportXjl1.decreaseOperatingLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.decreaseOperatingLoss}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.decreaseOperatingLoss-reportXjl2.decreaseOperatingLoss gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.decreaseOperatingLoss-reportXjl2.decreaseOperatingLoss}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资所支付的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.paymentForInvestment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.paymentForInvestment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.paymentForInvestment-reportXjl2.paymentForInvestment gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.paymentForInvestment-reportXjl2.paymentForInvestment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营性应付项目的增加（减：减少）</td>
			<td><fmt:formatNumber value="${reportXjl1.increaseOperatingAdd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.increaseOperatingAdd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.increaseOperatingAdd-reportXjl2.increaseOperatingAdd gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.increaseOperatingAdd-reportXjl2.increaseOperatingAdd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与投资活动有关的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.otherInvestingActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.otherInvestingActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.otherInvestingActivities-reportXjl2.otherInvestingActivities gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.otherInvestingActivities-reportXjl2.otherInvestingActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它</td>
			<td><fmt:formatNumber value="${reportXjl1.otherCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.otherCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.otherCash-reportXjl2.otherCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.otherCash-reportXjl2.otherCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">投资现金流出小计</td>
			<td><fmt:formatNumber value="${reportXjl1.cashOutflow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashOutflow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashOutflow-reportXjl2.cashOutflow gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashOutflow-reportXjl2.cashOutflow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营活动产生的现金流量净额</td>
			<td><fmt:formatNumber value="${reportXjl1.activitiesNetCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.activitiesNetCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.activitiesNetCash-reportXjl2.activitiesNetCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.activitiesNetCash-reportXjl2.activitiesNetCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资活动产生的现金流量净额</td>
			<td><fmt:formatNumber value="${reportXjl1.investmentActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.investmentActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.investmentActivities-reportXjl2.investmentActivities gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.investmentActivities-reportXjl2.investmentActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">2、不涉及现金收支的投资和筹资活动：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">三、筹资活动产生的现金流量：</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;债务转为资本</td>
			<td><fmt:formatNumber value="${reportXjl1.convertedCapital}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.convertedCapital}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.convertedCapital-reportXjl2.convertedCapital gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.convertedCapital-reportXjl2.convertedCapital}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 吸收投资所收到的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.cashReceivedInvestment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashReceivedInvestment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashReceivedInvestment-reportXjl2.cashReceivedInvestment gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashReceivedInvestment-reportXjl2.cashReceivedInvestment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的可转换公司债券</td>
			<td><fmt:formatNumber value="${reportXjl1.switchingCompanyBonds}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.switchingCompanyBonds}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.switchingCompanyBonds-reportXjl2.switchingCompanyBonds gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.switchingCompanyBonds-reportXjl2.switchingCompanyBonds}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;借款所收到的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.cashReceivedLoan}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashReceivedLoan}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashReceivedLoan-reportXjl2.cashReceivedLoan gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashReceivedLoan-reportXjl2.cashReceivedLoan}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;融资租入固定资产</td>
			<td><fmt:formatNumber value="${reportXjl1.financeLease}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.financeLease}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.financeLease-reportXjl2.financeLease gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.financeLease-reportXjl2.financeLease}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 收到的其它与筹资活动有关的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.financingActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.financingActivities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.financingActivities-reportXjl2.financingActivities gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.financingActivities-reportXjl2.financingActivities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它</td>
			<td><fmt:formatNumber value="${reportXjl1.other}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.other}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.other-reportXjl2.other gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.other-reportXjl2.other}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">筹资现金流入小计</td>
			<td><fmt:formatNumber value="${reportXjl1.financingCashFlows}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.financingCashFlows}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.financingCashFlows-reportXjl2.financingCashFlows gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.financingCashFlows-reportXjl2.financingCashFlows}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left" style="font-weight: bolder;">3、现金及现金等价物净增加情况：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;偿还债务所支付的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.cashPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashPayment-reportXjl2.cashPayment gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashPayment-reportXjl2.cashPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;现金的期末余额</td>
			<td><fmt:formatNumber value="${reportXjl1.cashEnd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashEnd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashEnd-reportXjl2.cashEnd gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashEnd-reportXjl2.cashEnd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;分配股利、利润或偿付利息所支付的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.profitCashPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.profitCashPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.profitCashPayment-reportXjl2.profitCashPayment gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.profitCashPayment-reportXjl2.profitCashPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：现金的期初余额</td>
			<td><fmt:formatNumber value="${reportXjl1.cashBegin}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashBegin}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashBegin-reportXjl2.cashBegin gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashBegin-reportXjl2.cashBegin}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与筹资活动有关的现金</td>
			<td><fmt:formatNumber value="${reportXjl1.cashPayments}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashPayments}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashPayments-reportXjl2.cashPayments gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashPayments-reportXjl2.cashPayments}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：现金等价物的期末余额</td>
			<td><fmt:formatNumber value="${reportXjl1.cashEquivalentsEnd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashEquivalentsEnd}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashEquivalentsEnd-reportXjl2.cashEquivalentsEnd gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashEquivalentsEnd-reportXjl2.cashEquivalentsEnd}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">筹资现金流出小计</td>
			<td><fmt:formatNumber value="${reportXjl1.cashfFlowFinancing}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashfFlowFinancing}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashfFlowFinancing-reportXjl2.cashfFlowFinancing gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashfFlowFinancing-reportXjl2.cashfFlowFinancing}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：现金等价物的期初余额</td>
			<td><fmt:formatNumber value="${reportXjl1.cashEquivalentsBegin}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashEquivalentsBegin}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashEquivalentsBegin-reportXjl2.cashEquivalentsBegin gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashEquivalentsBegin-reportXjl2.cashEquivalentsBegin}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;筹资活动产生的现金流量净额</td>
			<td><fmt:formatNumber value="${reportXjl1.netCashFlow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.netCashFlow}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.netCashFlow-reportXjl2.netCashFlow gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.netCashFlow-reportXjl2.netCashFlow}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;现金及现金等价物净增加额</td>
			<td><fmt:formatNumber value="${reportXjl1.cashEquivalentsNetCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashEquivalentsNetCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashEquivalentsNetCash-reportXjl2.cashEquivalentsNetCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashEquivalentsNetCash-reportXjl2.cashEquivalentsNetCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">四、汇率变动对现金的影响</td>
			<td><fmt:formatNumber value="${reportXjl1.exchangeRateCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.exchangeRateCash}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.exchangeRateCash-reportXjl2.exchangeRateCash gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.exchangeRateCash-reportXjl2.exchangeRateCash}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">五、现金及现金等价物净增加额</td>
			<td><fmt:formatNumber value="${reportXjl1.cashEquivalentsAmount}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportXjl2.cashEquivalentsAmount}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportXjl1.cashEquivalentsAmount-reportXjl2.cashEquivalentsAmount gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportXjl1.cashEquivalentsAmount-reportXjl2.cashEquivalentsAmount}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			
        </tr>
    </tbody>
</table>
	<div class="col-md-offset-5" style="margin-top:30px;">		
		<button class="btn" type="button" id="btn_closeReportXjlComparePage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>

​</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportXjl/reportXjl.js?v=<%=vardate%>"></script>
