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
					${client.clientBH}</span>					
				</span>
						
			</h5>
	 </div>
	
	<table class="table table-bordered" style="font-size: 13px">
     <input type="hidden" name="client_ID" id="client_ID" value="${reportZcfz1.client_ID}"  />
   	 <input type="hidden" name="unit_uid" id="unit_uid" value="${reportZcfz1.unit_uid}"  />
     <input type="hidden" name="reportZcfz_ID" id="reportZcfz_ID" value="${reportZcfz1.reportZcfz_ID}"  />
    
    
    
    <tr>
    <h5 class="col-sm-6">类型：<span class="grey">${reportZcfz1.reportTypeName}</span></h5>
    </tr>
   <tr>
       <h5 class="col-sm-6" align="right" >金额单位：（元）</h5>
   </tr>
    <thead>
        <tr>
            <th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportZcfz1.yearMonth}</th>
			<th style="text-align: center;">${reportZcfz2.yearMonth}</th>
			<th style="text-align: center;">增减</th>
			<th style="text-align: center;">科目</th>
			<th style="text-align: center;">${reportZcfz1.yearMonth}</th>
			<th style="text-align: center;">${reportZcfz2.yearMonth}</th>
			<th style="text-align: center;">增减</th>
        </tr>
    </thead>
    <tbody align="center" >
        <tr >
            <td align="left" style="font-weight: bolder;">流动资金：</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left" style="font-weight: bolder;">流动负债：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
       
        <tr>
            <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp;货币资金</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.currencyFunds}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.currencyFunds}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
			<c:if test="${reportZcfz1.currencyFunds-reportZcfz2.currencyFunds gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.currencyFunds-reportZcfz2.currencyFunds}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期借款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.shortTermBorrowings}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.shortTermBorrowings}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
			<c:if test="${reportZcfz1.shortTermBorrowings-reportZcfz2.shortTermBorrowings gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.shortTermBorrowings-reportZcfz2.shortTermBorrowings}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期投资</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.shorttermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.shorttermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td><c:if test="${reportZcfz1.shorttermInvest-reportZcfz2.shorttermInvest gt 0}">
				  +
				 </c:if>
			   <fmt:formatNumber value="${reportZcfz1.shorttermInvest-reportZcfz2.shorttermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付票据</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.notesPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			
			<td>
				<fmt:formatNumber value="${reportZcfz2.notesPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td><c:if test="${reportZcfz1.notesPayable-reportZcfz2.notesPayable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.notesPayable-reportZcfz2.notesPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收票据</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.notesReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.notesReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<c:if test="${reportZcfz1.notesReceivable-reportZcfz2.notesReceivable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.notesReceivable-reportZcfz2.notesReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.accountPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.accountPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<c:if test="${reportZcfz1.accountPayable-reportZcfz2.accountPayable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.accountPayable-reportZcfz2.accountPayable}" pattern="###,###.##"></fmt:formatNumber></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收股利</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.dividendsReceivable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.dividendsReceivable}" pattern="###,###.##"></fmt:formatNumber>				
			</td>
			<td>
			   <c:if test="${reportZcfz1.dividendsReceivable-reportZcfz2.dividendsReceivable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.dividendsReceivable-reportZcfz2.dividendsReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预收账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.receivableAdvance}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.receivableAdvance}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.receivableAdvance-reportZcfz2.receivableAdvance gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.receivableAdvance-reportZcfz2.receivableAdvance}" pattern="###,###.##"></fmt:formatNumber></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收利息</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.interestReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.interestReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.interestReceivable-reportZcfz2.interestReceivable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.interestReceivable-reportZcfz2.interestReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付职工薪酬</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.employeeSalary}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.employeeSalary}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.employeeSalary-reportZcfz2.employeeSalary gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.employeeSalary-reportZcfz2.employeeSalary}" pattern="###,###.##"></fmt:formatNumber></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收账款</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.accountsReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.accountsReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.accountsReceivable-reportZcfz2.accountsReceivable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.accountsReceivable-reportZcfz2.accountsReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付股利</td>
			<td>
				<fmt:formatNumber value="${reportZcfz1.dividendPayable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<fmt:formatNumber value="${reportZcfz2.dividendPayable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.dividendPayable-reportZcfz2.dividendPayable gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.dividendPayable-reportZcfz2.dividendPayable}" pattern="###,###.##"></fmt:formatNumber>
			
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它应收款</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherReceivables}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherReceivables}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.otherReceivables-reportZcfz2.otherReceivables gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.otherReceivables-reportZcfz2.otherReceivables}" pattern="###,###.##"></fmt:formatNumber> 
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付税金</td>
			<td><fmt:formatNumber value="${reportZcfz1.taxPayable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.taxPayable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.taxPayable-reportZcfz2.taxPayable gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportZcfz1.taxPayable-reportZcfz2.taxPayable}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预付账款</td>
			<td><fmt:formatNumber value="${reportZcfz1.prepaidAccount}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.prepaidAccount}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.prepaidAccount-reportZcfz2.prepaidAccount gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportZcfz1.prepaidAccount-reportZcfz2.prepaidAccount}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应交款</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherPayment}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.otherPayment-reportZcfz2.otherPayment gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportZcfz1.otherPayment-reportZcfz2.otherPayment}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付补贴款</td>
			<td><fmt:formatNumber value="${reportZcfz1.subsidiesReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.subsidiesReceivable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.subsidiesReceivable-reportZcfz2.subsidiesReceivable gt 0}">
				  +
				 </c:if>
				 <fmt:formatNumber value="${reportZcfz1.subsidiesReceivable-reportZcfz2.subsidiesReceivable}" pattern="###,###.##"></fmt:formatNumber> 
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应付款</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherPayables}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherPayables}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.otherPayables-reportZcfz2.otherPayables gt 0}">
				  +
				 </c:if>
				<fmt:formatNumber value="${reportZcfz1.otherPayables-reportZcfz2.otherPayables}" pattern="###,###.##"></fmt:formatNumber>  
			 </td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;存货</td>
			<td><fmt:formatNumber value="${reportZcfz1.stock}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.stock}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
			 <c:if test="${reportZcfz1.stock-reportZcfz2.stock gt 0}">
			  +
			 </c:if>
			 <fmt:formatNumber value="${reportZcfz1.stock-reportZcfz2.stock}" pattern="###,###.##"></fmt:formatNumber></td>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预提费用</td>
			<td><fmt:formatNumber value="${reportZcfz1.accruedExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.accruedExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
			 <c:if test="${reportZcfz1.accruedExpenses-reportZcfz2.accruedExpenses gt 0}">
			  +
			 </c:if>
			  <fmt:formatNumber value="${reportZcfz1.accruedExpenses-reportZcfz2.accruedExpenses}" pattern="###,###.##"></fmt:formatNumber>			
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用</td>
			<td><fmt:formatNumber value="${reportZcfz1.deferredExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.deferredExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.deferredExpenses-reportZcfz2.deferredExpenses gt 0}">
				  +
				</c:if>
			<fmt:formatNumber value="${reportZcfz1.deferredExpenses-reportZcfz2.deferredExpenses}" pattern="###,###.##"></fmt:formatNumber>
			
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预计负债</td>
			<td><fmt:formatNumber value="${reportZcfz1.totalLiabilities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.totalLiabilities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><c:if test="${reportZcfz1.totalLiabilities-reportZcfz2.totalLiabilities gt 0}">
				  +
				</c:if>
			<fmt:formatNumber value="${reportZcfz1.totalLiabilities-reportZcfz2.totalLiabilities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期债券投资</td>
			<td><fmt:formatNumber value="${reportZcfz1.oneYearInvest}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.oneYearInvest}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
			    <c:if test="${reportZcfz1.oneYearInvest-reportZcfz2.oneYearInvest gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.oneYearInvest-reportZcfz2.oneYearInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期负债</td>
			<td><fmt:formatNumber value="${reportZcfz1.oneYearLiabilities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.oneYearLiabilities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.oneYearLiabilities-reportZcfz2.oneYearLiabilities gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.oneYearLiabilities-reportZcfz2.oneYearLiabilities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动资产</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherCurrentAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherCurrentAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
			<c:if test="${reportZcfz1.otherCurrentAssets-reportZcfz2.otherCurrentAssets gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.otherCurrentAssets-reportZcfz2.otherCurrentAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动负债</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherCurrentLiabilities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherCurrentLiabilities}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
			   <c:if test="${reportZcfz1.otherCurrentLiabilities-reportZcfz2.otherCurrentLiabilities gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.otherCurrentLiabilities-reportZcfz2.otherCurrentLiabilities}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">流动资产合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.currentAssetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.currentAssetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.currentAssetsSum-reportZcfz2.currentAssetsSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.currentAssetsSum-reportZcfz2.currentAssetsSum}" pattern="###,###.##"></fmt:formatNumber>				
				</td>
			<td  style="font-weight: bolder;">流动负债合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.currentLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.currentLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.currentLiabilitiesSum-reportZcfz2.currentLiabilitiesSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.currentLiabilitiesSum-reportZcfz2.currentLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">长期投资：</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left" style="font-weight: bolder;">长期负债：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期股利投资</td>
			<td><fmt:formatNumber value="${reportZcfz1.longtermEquity}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.longtermEquity}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.longtermEquity-reportZcfz2.longtermEquity gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.longtermEquity-reportZcfz2.longtermEquity}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期借款</td>
			<td><fmt:formatNumber value="${reportZcfz1.longtermLoans}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.longtermLoans}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.longtermLoans-reportZcfz2.longtermLoans gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.longtermLoans-reportZcfz2.longtermLoans}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期债权投资</td>
			<td><fmt:formatNumber value="${reportZcfz1.longtermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td><fmt:formatNumber value="${reportZcfz2.longtermInvest}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>
				<c:if test="${reportZcfz1.longtermInvest-reportZcfz2.longtermInvest gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.longtermInvest-reportZcfz2.longtermInvest}" pattern="###,###.##"></fmt:formatNumber>
				
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付债券</td>
			<td><fmt:formatNumber value="${reportZcfz1.bondsPayable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.bondsPayable}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.bondsPayable-reportZcfz2.bondsPayable gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.bondsPayable-reportZcfz2.bondsPayable}" pattern="###,###.##"></fmt:formatNumber>
				
			</td>
        </tr>
        
           <td align="left" style="font-weight: bolder;">长期投资合计</td>
            <td><fmt:formatNumber value="${reportZcfz1.longtermInvestSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.longtermInvestSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.longtermInvestSum-reportZcfz2.longtermInvestSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.longtermInvestSum-reportZcfz2.longtermInvestSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期应付款</td>
			<td><fmt:formatNumber value="${reportZcfz1.longtermPayables}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.longtermPayables}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.longtermPayables-reportZcfz2.longtermPayables gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.longtermPayables-reportZcfz2.longtermPayables}" pattern="###,###.##"></fmt:formatNumber>				
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">固定资产</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsOldValue-reportZcfz2.fixedAssetsOldValue gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsOldValue-reportZcfz2.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期负债</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.otherLiabilitiesSum-reportZcfz2.otherLiabilitiesSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.otherLiabilitiesSum-reportZcfz2.otherLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
         <tr>
            <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产原价</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsOldValue-reportZcfz2.fixedAssetsOldValue gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsOldValue-reportZcfz2.fixedAssetsOldValue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">长期负债合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.longtermLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.longtermLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.longtermLiabilitiesSum-reportZcfz2.longtermLiabilitiesSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.longtermLiabilitiesSum-reportZcfz2.longtermLiabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 ： 累计折旧</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsDepreciation}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsDepreciation}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsDepreciation-reportZcfz2.fixedAssetsDepreciation gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsDepreciation-reportZcfz2.fixedAssetsDepreciation}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left" style="font-weight: bolder;">递延税项 ：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净值</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsValue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsValue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsValue-reportZcfz2.fixedAssetsValue gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsValue-reportZcfz2.fixedAssetsValue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项</td>
			<td><fmt:formatNumber value="${reportZcfz1.deferredTax}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.deferredTax}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.deferredTax-reportZcfz2.deferredTax gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.deferredTax-reportZcfz2.deferredTax}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产减值准备</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsDevalue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsDevalue}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsDevalue-reportZcfz2.fixedAssetsDevalue gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsDevalue-reportZcfz2.fixedAssetsDevalue}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">负债合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.liabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.liabilitiesSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.liabilitiesSum-reportZcfz2.liabilitiesSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.liabilitiesSum-reportZcfz2.liabilitiesSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净额</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsAmount}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsAmount}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsAmount-reportZcfz2.fixedAssetsAmount gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz.fixedAssetsAmount}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;工程物资</td>
			<td><fmt:formatNumber value="${reportZcfz1.engineeringMaterials}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.engineeringMaterials}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.engineeringMaterials-reportZcfz2.engineeringMaterials gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.engineeringMaterials-reportZcfz2.engineeringMaterials}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;在建工程</td>
			<td><fmt:formatNumber value="${reportZcfz1.constructionEngineering}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.constructionEngineering}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.constructionEngineering-reportZcfz2.constructionEngineering gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.constructionEngineering-reportZcfz2.constructionEngineering}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td >--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产清理</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsClean}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsClean}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsClean-reportZcfz2.fixedAssetsClean gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsClean-reportZcfz2.fixedAssetsClean}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td style="font-weight: bolder;">固定资产合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.fixedAssetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.fixedAssetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.fixedAssetsSum-reportZcfz2.fixedAssetsSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.fixedAssetsSum-reportZcfz2.fixedAssetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">  无形资产及其他资产 :</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left" style="font-weight: bolder;"> 所有者权益 ：</td>
			<td></td>
			<td></td>
			<td></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产</td>
			<td><fmt:formatNumber value="${reportZcfz1.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.intangibleAssets-reportZcfz2.intangibleAssets gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.intangibleAssets-reportZcfz2.intangibleAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;实收资本</td>
			<td><fmt:formatNumber value="${reportZcfz.paidCapital}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz.paidCapital}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.paidCapital-reportZcfz2.paidCapital gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.paidCapital-reportZcfz2.paidCapital}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td><fmt:formatNumber value="${reportZcfz1.prepaidExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.prepaidExpenses}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.prepaidExpenses-reportZcfz2.prepaidExpenses gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.prepaidExpenses-reportZcfz2.prepaidExpenses}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;资本公积</td>
			<td><fmt:formatNumber value="${reportZcfz1.capitalReserve}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.capitalReserve}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.capitalReserve-reportZcfz2.capitalReserve gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.capitalReserve-reportZcfz2.capitalReserve}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期资产</td>
			<td><fmt:formatNumber value="${reportZcfz1.otherLongtermAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.otherLongtermAssets}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.otherLongtermAssets-reportZcfz2.otherLongtermAssets gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.otherLongtermAssets-reportZcfz2.otherLongtermAssets}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;盈余公积</td>
			<td><fmt:formatNumber value="${reportZcfz1.surplusReserve}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.surplusReserve}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.surplusReserve-reportZcfz2.surplusReserve gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.surplusReserve-reportZcfz2.surplusReserve}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">无形资产及其他资产合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.intangibleAssetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.intangibleAssetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.intangibleAssetsSum-reportZcfz2.intangibleAssetsSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.intangibleAssetsSum-reportZcfz2.intangibleAssetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其中 ： 法定公益金</td>
			<td><fmt:formatNumber value="${reportZcfz1.statutoryReserve}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.statutoryReserve}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.statutoryReserve-reportZcfz2.statutoryReserve gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.statutoryReserve-reportZcfz2.statutoryReserve}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td style="font-weight: bolder;">递延税项 ：</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;未分配利润</td>
			<td><fmt:formatNumber value="${reportZcfz1.undistributedProfit}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.undistributedProfit}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.undistributedProfit-reportZcfz2.undistributedProfit gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.undistributedProfit-reportZcfz2.undistributedProfit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款借项</td>
			<td><fmt:formatNumber value="${reportZcfz1.deferredTaxDebit}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.deferredTaxDebit}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.deferredTaxDebit-reportZcfz2.deferredTaxDebit gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.deferredTaxDebit-reportZcfz2.deferredTaxDebit}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">所有者权益合计</td>
			<td><fmt:formatNumber value="${reportZcfz.owerRigtSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz.owerRigtSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.owerRigtSum-reportZcfz2.owerRigtSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.owerRigtSum-reportZcfz2.owerRigtSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
         <tr>
            <td style="font-weight: bolder;">资产总计</td>
			<td><fmt:formatNumber value="${reportZcfz1.assetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.assetsSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.assetsSum-reportZcfz2.assetsSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.assetsSum-reportZcfz2.assetsSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
			<td style="font-weight: bolder;">负债及所有者权益合计</td>
			<td><fmt:formatNumber value="${reportZcfz1.piabilitiesOwerRigtSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${reportZcfz2.piabilitiesOwerRigtSum}" pattern="###,###.##"></fmt:formatNumber></td>
			<td>
				<c:if test="${reportZcfz1.piabilitiesOwerRigtSum-reportZcfz2.piabilitiesOwerRigtSum gt 0}">
				  +
				</c:if>
				<fmt:formatNumber value="${reportZcfz1.piabilitiesOwerRigtSum-reportZcfz2.piabilitiesOwerRigtSum}" pattern="###,###.##"></fmt:formatNumber>
			</td>
        </tr>
       
    </tbody>
</table>
	<div class="col-md-offset-5" style="margin-top:30px;">		
		<button class="btn" type="button" id="btn_closeReportZcfzComparePage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportZcfz/reportZcfz.js?v=<%=vardate%>"></script>	
