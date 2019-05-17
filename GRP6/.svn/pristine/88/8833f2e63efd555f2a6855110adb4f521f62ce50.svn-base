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
<form class="form-horizontal" role="form" id="update_reportZcfzForm"> 
		<input type="hidden" name="client_ID" id="client_ID" value="${reportZcfz.client_ID}"  />
	    <input type="hidden" name="unit_uid" id="unit_uid" value="${reportZcfz.unit_uid}"  />
	    <input type="hidden" name="reportZcfz_ID" id="reportZcfz_ID" value="${reportZcfz.reportZcfz_ID}"  />
   
   <!--  <caption >资 产 负 债 表</caption> -->
    <tr>
        <h5 class="col-sm-6" >类型：<span class="grey">${reportZcfz.reportTypeName}</span></h5>
    </tr>
   <tr>
        <h5 class="col-sm-6" align="right" >金额单位：（元）</h5>
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
			<td>
			     		    
			</td>
			<td align="left" style="font-weight: bolder;">流动负债：</td>
			<td >
			     
			</td>
        </tr>       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;货币资金</td>
			<td>
			     <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]"  
			     name="currencyFunds" id="currencyFunds" 
			     value="<fmt:formatNumber  value="${reportZcfz.currencyFunds}"  pattern="###.##"/>"
			     />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期借款</td>
			<td>
			    <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			    name="shortTermBorrowings" id="shortTermBorrowings" 
			   value="<fmt:formatNumber  value="${reportZcfz.shortTermBorrowings}"  pattern="###.##"/>" 
			    />				    
			</td>
        </tr>
         <tr >
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期投资</td>
			<td>
			    <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			    name="shorttermInvest" id="shorttermInvest" 
			    value="<fmt:formatNumber  value="${reportZcfz.shorttermInvest}"  pattern="###.##"/>"
			    />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付票据</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="notesPayable" id="notesPayable" 
			   value="<fmt:formatNumber  value="${reportZcfz.notesPayable}"  pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收票据</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="notesReceivable" id="notesReceivable" 
			   value="<fmt:formatNumber  value="${reportZcfz.notesReceivable}" pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付账款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="accountPayable" id="accountPayable" 
			   value="<fmt:formatNumber  value="${reportZcfz.accountPayable}" pattern="###.##"/>" 
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收股利</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="dividendsReceivable" id="dividendsReceivable" 
			   value="<fmt:formatNumber  value="${reportZcfz.dividendsReceivable}"    pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预收账款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="receivableAdvance" id="receivableAdvance" 
			   value="<fmt:formatNumber  value="${reportZcfz.receivableAdvance}"    pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收利息</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="interestReceivable" id="interestReceivable" 
			   value="<fmt:formatNumber  value="${reportZcfz.interestReceivable}"    pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付职工薪酬</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="employeeSalary" id="employeeSalary" 
			   value="<fmt:formatNumber  value="${reportZcfz.employeeSalary}"    pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收账款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="accountsReceivable" id="accountsReceivable" 
			   value="<fmt:formatNumber  value="${reportZcfz.accountsReceivable}"    pattern="###.##"/>" 
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付股利</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="dividendPayable" id="dividendPayable" 
			   value="<fmt:formatNumber  value="${reportZcfz.dividendPayable}"   pattern="###.##"/>" 
			    />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它应收款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="otherReceivables" id="otherReceivables" 
			   value="<fmt:formatNumber  value="${reportZcfz.otherReceivables}"   pattern="###.##"/>" 
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付税金</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="taxPayable" id="taxPayable" 
			   value="<fmt:formatNumber  value="${reportZcfz.taxPayable}"   pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预付账款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="prepaidAccount" id="prepaidAccount" 
			   value="<fmt:formatNumber  value="${reportZcfz.prepaidAccount}"   pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应交款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="otherPayment" id="otherPayment" 
			   value="<fmt:formatNumber  value="${reportZcfz.otherPayment}"   pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付补贴款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="subsidiesReceivable" id="subsidiesReceivable" 
			   value="<fmt:formatNumber  value="${reportZcfz.subsidiesReceivable}"  pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应付款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="otherPayables" id="otherPayables" 
			   value="<fmt:formatNumber  value="${reportZcfz.otherPayables}"  pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;存货</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]"  
			   name="stock" id="stock" 
			   value="${reportZcfz.stock}" 
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预提费用</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="accruedExpenses" id="accruedExpenses" 
			   value="<fmt:formatNumber  value="${reportZcfz.accruedExpenses}"  pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]"  
			   name="deferredExpenses" id="deferredExpenses" 
			   value="<fmt:formatNumber value="${reportZcfz.deferredExpenses}"   pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预计负债</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput  validate[maxSize[18],custom[number]]"  
			   name="totalLiabilities" id="totalLiabilities" 
			   value="<fmt:formatNumber value="${reportZcfz.totalLiabilities}"   pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期债券投资</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput   validate[maxSize[18],custom[number]]"  
			   name="oneYearInvest" id="oneYearInvest" 
			   value="<fmt:formatNumber value="${reportZcfz.oneYearInvest}"  pattern="###.##"/>"
			    />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期负债</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="oneYearLiabilities" id="oneYearLiabilities" 
			   value="<fmt:formatNumber value="${reportZcfz.oneYearLiabilities}"  pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动资产</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="otherCurrentAssets" id="otherCurrentAssets" 
			   value="<fmt:formatNumber value="${reportZcfz.otherCurrentAssets}"  pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动负债</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" 
			    name="otherCurrentLiabilities" id="otherCurrentLiabilities" 
			    value="<fmt:formatNumber value="${reportZcfz.otherCurrentLiabilities}"  pattern="###.##"/>" 
			    />				    
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">流动资产合计</td>
			<td>
			   <input type="text" class="assetsSum countInput  validate[maxSize[18],custom[number]]" 
			    name="currentAssetsSum" id="currentAssetsSum" 
			    value="<fmt:formatNumber value="${reportZcfz.currentAssetsSum}"  pattern="###.##"/>" 
			    />				    
			</td>
			<td style="font-weight: bolder;">流动负债合计</td>
			<td>
			   <input type="text" class="liabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="currentLiabilitiesSum" id="currentLiabilitiesSum" 
			   value="<fmt:formatNumber value="${reportZcfz.currentLiabilitiesSum}"  pattern="###.##"/>"
			   />				    
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">长期投资：</td>
			<td>
			</td>
			<td align="left" style="font-weight: bolder;">长期负债：</td>
			<td>
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期股利投资</td>
			<td>
			   <input type="text" class="longtermInvestSum countInput validate[maxSize[18],custom[number]]" 
			    name="longtermEquity" id="longtermEquity" 
			    value="<fmt:formatNumber value="${reportZcfz.longtermEquity}"  pattern="###.##"/>"
			    />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期借款</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" 
			    name="longtermLoans" id="longtermLoans" 
			    value="<fmt:formatNumber value="${reportZcfz.longtermLoans}"      pattern="###.##"/>"
			    />				    
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期债权投资</td>
			<td>
			   <input type="text" class="longtermInvestSum countInput validate[maxSize[18],custom[number]]"  
			   name="longtermInvest" id="longtermInvest" 
			   value="<fmt:formatNumber value="${reportZcfz.longtermInvest}"      pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付债券</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]"  
			   name="bondsPayable" id="bondsPayable" 
			   value="<fmt:formatNumber value="${reportZcfz.bondsPayable}"     pattern="###.##"/>"
			   />				    
			</td>
        </tr>
        
           <td align="" style="font-weight: bolder;">长期投资合计</td>
            <td>
			   <input type="text" class="assetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="longtermInvestSum" id="longtermInvestSum" 
			   value="<fmt:formatNumber value="${reportZcfz.longtermInvestSum}"     pattern="###.##"/>"
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期应付款</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" 
			    name="longtermPayables" id="longtermPayables" 
			    value="<fmt:formatNumber value="${reportZcfz.longtermPayables}"    pattern="###.##"/>"
			     />				    
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">固定资产</td>
			<td>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期负债</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" 
			    name="otherLiabilitiesSum" id="otherLiabilitiesSum" 
			    value="<fmt:formatNumber value="${reportZcfz.otherLiabilitiesSum}"    pattern="###.##"/>"
			    />				    
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产原价</td>
			<td>
			   <input type="text" class="fixedAssetsOldValue countInput validate[maxSize[18],custom[number]]" 
			    name="fixedAssetsOldValue" id="fixedAssetsOldValue" 
			    value="<fmt:formatNumber value="${reportZcfz.fixedAssetsOldValue}"    pattern="###.##"/>"
			    />				    
			</td>
			<td style="font-weight: bolder;">长期负债合计</td>
			<td>
			   <input type="text" class="liabilitiesSum countInput validate[maxSize[18],custom[number]]" 
			    name="longtermLiabilitiesSum" id="longtermLiabilitiesSum" 
			    value="<fmt:formatNumber value="${reportZcfz.longtermLiabilitiesSum}"    pattern="###.##"/>"
			    />				    
			</td>
        </tr>
       
         <tr>
            <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 ： 累计折旧</td>
			<td>
			   <input type="text" class="fixedAssetsDepreciation countInput validate[maxSize[18],custom[number]]" 
			    name="fixedAssetsDepreciation" id="fixedAssetsDepreciation" 
			    value="<fmt:formatNumber value="${reportZcfz.fixedAssetsDepreciation}"   pattern="###.##"/>"
			    />				    
			</td>
			<td align="left" style="font-weight: bolder;">递延税项 ：</td>
			<td>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净值</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]"  
			   name="fixedAssetsValue" id="fixedAssetsValue" 
			  value="<fmt:formatNumber value="${reportZcfz.fixedAssetsValue}"   pattern="###.##"/>"  
			   />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项</td>
			<td>
			   <input type="text" class="liabilitiesSum countInput validate[maxSize[18],custom[number]]" 
			    name="deferredTax" id="deferredTax" 
			    value="<fmt:formatNumber value="${reportZcfz.deferredTax}"   pattern="###.##"/>"
			     />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产减值准备</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="fixedAssetsDevalue" id="fixedAssetsDevalue" 
			    value="<fmt:formatNumber value="${reportZcfz.fixedAssetsDevalue}"   pattern="###.##"/>"
			    />				    
			</td>
			<td style="font-weight: bolder;">负债合计</td>
			<td>
			   <input type="text" class="piabilitiesOwerRigtSum1 countInput validate[maxSize[18],custom[number]]" 
			    name="liabilitiesSum" id="liabilitiesSum" 
			    value="<fmt:formatNumber value="${reportZcfz.liabilitiesSum}"   pattern="###.##"/>"
			    />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净额</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="fixedAssetsAmount" id="fixedAssetsAmount" 
			    value="<fmt:formatNumber value="${reportZcfz.fixedAssetsAmount}"   pattern="###.##"/>"
			    />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;工程物资</td>
			<td>
			   <input type="text" class="validate[maxSize[18],custom[number]]" 
			    name="engineeringMaterials" id="fixedAssetsSum countInput engineeringMaterials"
			   value="<fmt:formatNumber value="${reportZcfz.engineeringMaterials}"   pattern="###.##"/>"  
			     />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;在建工程</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="constructionEngineering" id="constructionEngineering"
			     value="<fmt:formatNumber value="${reportZcfz.constructionEngineering}"   pattern="###.##"/>"
			     />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产清理</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="fixedAssetsClean" id="fixedAssetsClean" 
			    value="<fmt:formatNumber value="${reportZcfz.fixedAssetsClean}"   pattern="###.##"/>" 
			    />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td  style="font-weight: bolder;">固定资产合计</td>
			<td>
			   <input type="text" class="assetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="fixedAssetsSum" id="fixedAssetsSum" 			    
			     value="<fmt:formatNumber value="${reportZcfz.fixedAssetsSum}"   pattern="###.##"/>"
			    />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">  无形资产及其他资产 :</td>
			<td></td>
			<td align="left" style="font-weight: bolder;"> 所有者权益 ：</td>
			<td></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产</td>
			<td>
			   <input type="text" class="intangibleAssetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="intangibleAssets" id="intangibleAssets"
			     value="<fmt:formatNumber value="${reportZcfz.intangibleAssets}"   pattern="###.##"/>"
			     />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;实收资本</td>
			<td>
			   <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]" 
			    name="paidCapital" id="paidCapital" 
			    value="<fmt:formatNumber value="${reportZcfz.paidCapital}"   pattern="###.##"/>"
			    />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td>
			   <input type="text" class="intangibleAssetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="prepaidExpenses" id="prepaidExpenses" 
			    value="<fmt:formatNumber value="${reportZcfz.prepaidExpenses}"   pattern="###.##"/>"
			    />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;资本公积</td>
			<td>
			    <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]" 
			     name="capitalReserve" id="capitalReserve" 
			     value="<fmt:formatNumber value="${reportZcfz.capitalReserve}"   pattern="###.##"/>"
			     />	
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期资产</td>
			<td>
			   <input type="text" class="intangibleAssetsSum  countInput validate[maxSize[18],custom[number]]" 
			    name="otherLongtermAssets" id="otherLongtermAssets" 
			    value="<fmt:formatNumber value="${reportZcfz.otherLongtermAssets}"   pattern="###.##"/>"
			     />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;盈余公积</td>
			<td>
			   <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]" 
			    name="surplusReserve" id="surplusReserve" 
			    value="<fmt:formatNumber value="${reportZcfz.surplusReserve}"   pattern="###.##"/>"
			    />				    
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">无形资产及其他资产合计</td>
			<td>
			   <input type="text" class="assetsSum countInput validate[maxSize[18],custom[number]]" 
			    name="intangibleAssetsSum" id="intangibleAssetsSum" 
			    value="<fmt:formatNumber value="${reportZcfz.intangibleAssetsSum}"   pattern="###.##"/>"
			     />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其中 ： 法定公益金</td>
			<td>
			   <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]"  
			   name="statutoryReserve" id="statutoryReserve" 
			   value="<fmt:formatNumber value="${reportZcfz.statutoryReserve}"   pattern="###.##"/>"
			    />				    
			</td>
        </tr>
         <tr>
            <td align="center" style="font-weight: bolder;">递延税项 ：</td>
			<td>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;未分配利润</td>
			<td>
			   <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]" 
			    name="undistributedProfit" id="undistributedProfit" 
			    value="<fmt:formatNumber value="${reportZcfz.undistributedProfit}"   pattern="###.##"/>"
			     />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款借项</td>
			<td>
			   <input type="text" class="assetsSum deferredTaxDebit countInput validate[maxSize[18],custom[number]]"  
			   name="deferredTaxDebit" id="deferredTaxDebit" 
			   value="<fmt:formatNumber value="${reportZcfz.deferredTaxDebit}"   pattern="###.##"/>"
			    />				    
			</td>
			<td style="font-weight: bolder;">所有者权益合计</td>
			<td>
			   <input type="text" class="piabilitiesOwerRigtSum2 countInput validate[maxSize[18],custom[number]]"
			     name="owerRigtSum" id="owerRigtSum" 
			    value="<fmt:formatNumber value="${reportZcfz.owerRigtSum}"   pattern="###.##"/>" 
			     />				    
			</td>
        </tr>
         <tr>
            <td style="font-weight: bolder;">资产总计</td>
			<td>
			   <input type="text" class="validate[required,maxSize[18],custom[number],custom[isEquality]]" 
			    name="assetsSum" id="assetsSum" 
			  value="<fmt:formatNumber value="${reportZcfz.assetsSum}"   pattern="###.##"/>"  
			     />				    
			</td>
			<td style="font-weight: bolder;">负债及所有者权益合计</td>
			<td>
			   <input type="text" class="validate[required,maxSize[18],custom[number],custom[isEquality]]"
			     name="piabilitiesOwerRigtSum" id="piabilitiesOwerRigtSum" 
			 value="<fmt:formatNumber value="${reportZcfz.piabilitiesOwerRigtSum}"   pattern="###.##"/>"
			     />				    
			</td>
        </tr> 
    
           
    </tbody>
 </form>    
</table>
	<div class="col-md-offset-5" style="margin-top:30px;">
		<button class="btn btn-primary btn_updateReportZcfx" type="button"><i class="icon-ok bigger-110"></i>保存</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn" type="button" id="btn_closeReportSyEditPage"><i class="icon-remove bigger-110"></i>关闭</button>
	</div>
</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportZcfz/reportZcfz.js?v=<%=vardate%>"></script>