<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>	

<script type="text/javascript" charset="utf-8">
  
    
    
</script>





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
	
<form class="form-horizontal" role="form" id="add_reportZcfzForm"> 
 <textarea style="display: none;"  name="client_ID" id="client_ID" class="ztb_view_client_ID" >${client.client_ID}</textarea>	

    
<table class="table table-bordered" style="font-size: 13px">
 
    <tr>
       
		  <div class="form-group col-sm-3">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>类型： </label>
			        <div class="col-sm-8">
						<!-- <input type="hidden" id="reportTypeName" name="reportTypeName" class="ztb_add_reportTypeName">
						<select class="col-xs-10 col-sm-9 ztb_add select_reportTypeUuid btn_ztb_select validate[required]"   name="reportTypeUuid" class_name="ztb_add_reportTypeName" id="select_reportTypeUuid">
						</select> -->
						<input type="hidden" id="reportTypeName" class="reportTypeName" name="reportTypeName" >
						<select id="reportTypeList" class="reportTypeList  col-sm-12 validate[required]"  name="reportTypeUuid"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${reportTypeList}" var="reportType">
									<option value="${reportType.dicTypeID}">${reportType.dicTypeName}</option>
								</c:forEach>
					   </select>
					</div>
		 </div>	
         <div class="form-group col-sm-3">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>年月： </label>
		         	<div class="col-sm-8">
						<div class="input-group">
							<input class="form-control date-picker  validate[required]" type="text" name="yearMonth" id="pickerYearsMonths" data-date-format="yyyy-mm"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
		 </div>
   
   </tr>
   
   
   <tr>
        <h5 style="text-align: right;margin:20px 0 20px 0;">金额单位：（元）</h5>
   </tr>
    <tbody align="center">       
        <tr >
            <td align="left" style="font-weight: bolder;">流动资产：</td>
			<td>
			     				    
			</td>
			<td align="left" style="font-weight: bolder;">流动负债：</td>
			<td>
			</td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;货币资金</td>
			<td>
			     <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]"  name="currencyFunds" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期借款</td>
			<td>
			    <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="shortTermBorrowings" id="" value="" />				    
			</td>
        </tr>
         <tr >
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;短期投资</td>
			<td>
			    <input type="text" class="currentAssetsSum countInput   validate[maxSize[18],custom[number]]" name="shorttermInvest" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付票据</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="notesPayable" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收票据</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]" name="notesReceivable" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付账款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="accountPayable" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收股利</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="dividendsReceivable" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预收账款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="receivableAdvance" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收利息</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="interestReceivable" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付职工薪酬</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="employeeSalary" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收账款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="accountsReceivable" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付股利</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="dividendPayable" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它应收款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="otherReceivables" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付税金</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="taxPayable" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预付账款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="prepaidAccount" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应交款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="otherPayment" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应收补贴款</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="subsidiesReceivable" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他应付款</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="otherPayables" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;存货</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="stock" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预提费用</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="accruedExpenses" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput validate[maxSize[18],custom[number]]" name="deferredExpenses" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;预计负债</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="totalLiabilities" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期债券投资</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]" name="oneYearInvest" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的长期负债</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="oneYearLiabilities" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动资产</td>
			<td>
			   <input type="text" class="currentAssetsSum countInput  validate[maxSize[18],custom[number]]" name="otherCurrentAssets" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他流动负债</td>
			<td>
			   <input type="text" class="currentLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="otherCurrentLiabilities" id="" value="" />				    
			</td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">流动资产合计</td>
			<td>
			   <input type="text" class="assetsSum countInput  validate[maxSize[18],custom[number]]" name="currentAssetsSum" id="currentAssetsSum" value="" />				    
			</td>
			<td style="font-weight: bolder;">流动负债合计</td>
			<td>                         
			   <input type="text" class="liabilitiesSum countInput validate[maxSize[18],custom[number]]" name="currentLiabilitiesSum" id="currentLiabilitiesSum" value="" />				    
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
			   <input type="text" class="longtermInvestSum countInput validate[maxSize[18],custom[number]]" name="longtermEquity" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期借款</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="longtermLoans" id="" value="" />				    
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期债权投资</td>
			<td>
			   <input type="text" class="longtermInvestSum countInput validate[maxSize[18],custom[number]]" name="longtermInvest" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;应付债券</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="bondsPayable" id="" value="" />				    
			</td>
        </tr>
        
           <td  style="font-weight: bolder;">长期投资合计</td>
            <td>
			   <input type="text" class="assetsSum countInput validate[maxSize[18],custom[number]]" name="longtermInvestSum" id="longtermInvestSum" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期应付款</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="longtermPayables" id="" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">固定资产</td>
			<td>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期负债</td>
			<td>
			   <input type="text" class="longtermLiabilitiesSum countInput validate[maxSize[18],custom[number]]" name="otherLiabilitiesSum" id="" value="" />				    
			</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产原价</td>
			<td>
			   <input type="text" class="fixedAssetsOldValue countInput  validate[maxSize[18],custom[number]]" name="fixedAssetsOldValue" id="fixedAssetsOldValue" value="" />				    
			</td>
			<td style="font-weight: bolder;">长期负债合计</td>
			<td>
			   <input type="text" class="liabilitiesSum countInput validate[maxSize[18],custom[number]]" name="longtermLiabilitiesSum" id="longtermLiabilitiesSum" value="" />				    
			</td>
        </tr>
       
         <tr>
            <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 ： 累计折旧</td>
			<td>
			   <input type="text" class="fixedAssetsDepreciation countInput  validate[maxSize[18],custom[number]]" name="fixedAssetsDepreciation" id="" value="" />				    
			</td>
			<td align="left" style="font-weight: bolder;">递延税项 ：</td>
			<td>
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净值</td>
			<td>
			   <input type="text" class=" countInput validate[maxSize[18],custom[number]]" name="fixedAssetsValue" id="fixedAssetsValue" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项</td>
			<td>
			   <input type="text" class="liabilitiesSum countInput validate[maxSize[18],custom[number]]" name="deferredTax" id="deferredTax" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产减值准备</td>
			<td>
			   <input type="text" class="fixedAssetsAmount countInput validate[maxSize[18],custom[number]]" name="fixedAssetsDevalue" id="fixedAssetsDevalue" value="" />				    
			</td>
			<td style="font-weight: bolder;">负债合计</td>
			<td>
			   <input type="text" class="piabilitiesOwerRigtSum1 countInput validate[maxSize[18],custom[number]]" name="liabilitiesSum" id="liabilitiesSum" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产净额</td>
			<td>                         
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" name="fixedAssetsAmount" id="fixedAssetsAmount" value="" />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
       
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;工程物资</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" name="engineeringMaterials" id="" value="" />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;在建工程</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" name="constructionEngineering" id="" value="" />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产清理</td>
			<td>
			   <input type="text" class="fixedAssetsSum countInput validate[maxSize[18],custom[number]]" name="fixedAssetsClean" id="" value="" />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td  style="font-weight: bolder;">固定资产合计</td>
			<td>
			   <input type="text" class="assetsSum countInput validate[maxSize[18],custom[number]]" name="fixedAssetsSum" id="fixedAssetsSum" value="" />				    
			</td>
			<td>--</td>
			<td>--</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">无形资产及其他资产 :</td>
			<td></td>
			<td align="left" style="font-weight: bolder;"> 所有者权益 ：</td>
			<td></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产</td>
			<td>
			   <input type="text" class="intangibleAssetsSum countInput validate[maxSize[18],custom[number]]" name="intangibleAssets" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;实收资本</td>
			<td>
			   <input type="text" class="owerRigtSum countInput  validate[maxSize[18],custom[number]]" name="paidCapital" id="" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td>
			   <input type="text" class="intangibleAssetsSum countInput validate[maxSize[18],custom[number]]" name="prepaidExpenses" id="" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;资本公积</td>
			<td>
			    <input type="text" class="owerRigtSum countInput  validate[maxSize[18],custom[number]]" name="capitalReserve" id="" value="" />	
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其他长期资产</td>
			<td>
			   <input type="text" class="intangibleAssetsSum  countInput validate[maxSize[18],custom[number]]" name="otherLongtermAssets" id="otherLongtermAssets" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;盈余公积</td>
			<td>
			   <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]" name="surplusReserve" id="" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">无形资产及其他资产合计</td>
			<td>
			   <input type="text" class="assetsSum countInput validate[maxSize[18],custom[number]]" name="intangibleAssetsSum" id="intangibleAssetsSum" value="" />				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其中 ： 法定公益金</td>
			<td><!-- owerRigtSum -->
			   <input type="text" class=" countInput validate[maxSize[18],custom[number]]" name="statutoryReserve" id="" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="center" style="font-weight: bolder;">递延税项 ：</td>
			<td>
			   				    
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;未分配利润</td>
			<td>
			   <input type="text" class="owerRigtSum countInput validate[maxSize[18],custom[number]]" name="undistributedProfit" id="" value="" />				    
			</td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款借项</td>
			<td>
			   <input type="text" class="assetsSum deferredTaxDebit countInput validate[maxSize[18],custom[number]]" name="deferredTaxDebit" id="deferredTaxDebit" value="" />				    
			</td>
			<td style="font-weight: bolder;">所有者权益合计</td>
			<td>
			   <input type="text" class="piabilitiesOwerRigtSum2 countInput validate[maxSize[18],custom[number]]" name="owerRigtSum" id="owerRigtSum" value="" />				    
			</td>
        </tr>
         <tr>
            <td style="font-weight: bolder;"><i class="icon-asterisk orange"></i>资产总计</td>
			<td>
			   <input type="text" class="validate[required,maxSize[18],custom[number],custom[isEquality]]" name="assetsSum" id="assetsSum" value="" />				    
			</td>
			<td style="font-weight: bolder;"><i class="icon-asterisk orange"></i>负债及所有者权益合计</td>
			<td>
			   <input type="text" class="validate[required,maxSize[18],custom[number],custom[isEquality]]" name="piabilitiesOwerRigtSum" id="piabilitiesOwerRigtSum" value="" />				    
			</td>
        </tr> 
    
           
    </tbody>
    
</table>
</form> 
    
	<div class="col-md-offset-5" style="margin-top:30px;">
		<button class="btn btn-primary btn_addReportZcfz" type="button" id="btn_addReportZcfz"><i class="icon-ok bigger-110"></i>
			保存
		</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn" type="button" id="btn_closeReportZcfzAddPage"><i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
</div>
<%@ include file="/crm/client/companyFinance/successMessage.jsp" %><%--保存成功后提示刷新页面--%>

​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportZcfz/reportZcfz.js?v=<%=vardate%>"></script>




