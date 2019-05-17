<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>


<div class="page-content">		
     <div class="page-header"><!--begin页头部分 -->	
	    	<h5>客户名称：
	    		<span class="ztb_view_clientName">
	    			${client.clientName}
	    		</span>
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
     <!--  <caption >资 产 负 债 表</caption> -->
    <input type="hidden" name="client_ID" id="client_ID" value="${reportZcfz.client_ID}"  />
    <input type="hidden" name="unit_uid" id="unit_uid" value="${reportZcfz.unit_uid}"  />
    <input type="hidden" name="reportZcfz_ID" id="reportZcfz_ID" value="${reportZcfz.reportZcfz_ID}"  />
    
   
   
     
    <tr>
        <h5 class="col-sm-6" >类型：<span class="grey">${reportZcfz.reportTypeName}</span></h5>
    </tr>
   
   
   <tr>
        <h5 class="col-sm-6" align="right" >金额单位： （元）</h5>
   </tr>
    <thead>
        <tr>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportZcfz.yearMonth}</th>
			<th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportZcfz.yearMonth}</th>
        </tr>
    </thead>
    <tbody align="center">
        <tr >
            <td align="left" style="font-weight: bolder;">流动资产：</td>
			<td></td>
			<td align="left" style="font-weight: bolder;">流动负债：</td>
			<td></td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;货币资金</td>
			<td>
			    <fmt:formatNumber value="${reportZcfz.currencyFunds}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期借款</td>
			<td>
			     <fmt:formatNumber value="${reportZcfz.shortTermBorrowings}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期投资</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.shorttermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付票据</td>
			<td >
				<fmt:formatNumber value="${reportZcfz.notesPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收票据</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.notesReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>			
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.accountPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收股利</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.dividendsReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预收账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.receivableAdvance}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收利息</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.interestReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付职工薪酬</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.employeeSalary}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.accountsReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付股利</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.dividendPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它应收款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherReceivables}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付税金</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.taxPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预付账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.prepaidAccount}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应交款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付补贴款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.subsidiesReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应付款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherPayables}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;存货</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.stock}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预提费用</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.accruedExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.deferredExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预计负债</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.totalLiabilities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期债券投资</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.oneYearInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期负债</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.oneYearLiabilities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动资产</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherCurrentAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动负债</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherCurrentLiabilities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">流动资产合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.currentAssetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">流动负债合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.currentLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">长期投资：</td>
			<td></td>
			<td align="left" style="font-weight: bolder;">长期负债：</td>
			<td></td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期股利投资</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.longtermEquity}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期借款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.longtermLoans}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期债权投资</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.longtermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付债券</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.bondsPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        
           <td align="" style="font-weight: bolder;">长期投资合计</td>
            <td>
            	<fmt:formatNumber value="${reportZcfz.longtermInvestSum}" pattern="###,###.##"></fmt:formatNumber>
            </td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期应付款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.longtermPayables}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">固定资产</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期负债</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产原价</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber>
				
			</td>
			<td style="font-weight: bolder;">长期负债合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.longtermLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
         <tr>
            <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 ： 累计折旧</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsDepreciation}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left" style="font-weight: bolder;">递延税项 ：</td>
			<td></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净值</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsValue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.deferredTax}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产减值准备</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsDevalue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">负债合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.liabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净额</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsAmount}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;工程物资</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.engineeringMaterials}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;在建工程</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.constructionEngineering}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产清理</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsClean}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td  style="font-weight: bolder;">固定资产合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">无形资产及其他资产 :</td>
			<td></td>
			<td align="left" style="font-weight: bolder;">所有者权益 ：</td>
			<td></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;实收资本</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.paidCapital}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.prepaidExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;资本公积</td>
			<td >
				<fmt:formatNumber value="${reportZcfz.capitalReserve}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期资产</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.otherLongtermAssets}" pattern="###,###.##"></fmt:formatNumber>	
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;盈余公积</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.surplusReserve}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">无形资产及其他资产合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.intangibleAssetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其中 ： 法定公益金</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.statutoryReserve}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="center" style="font-weight: bolder;">递延税项 ：</td>
			<td></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;未分配利润</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.undistributedProfit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款借项</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.deferredTaxDebit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">所有者权益合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.owerRigtSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td style="font-weight: bolder;">资产总计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.assetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">负债及所有者权益合计</td>
			<td>
				<fmt:formatNumber value="${reportZcfz.piabilitiesOwerRigtSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
    </tbody>
</table>
 	<div class="col-md-offset-5" style="margin-top:30px;">
		
		<button class="btn" type="button" id="btn_closeReportSyInfoPage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
​</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportZcfz/reportZcfz.js?v=<%=vardate%>"></script>





















