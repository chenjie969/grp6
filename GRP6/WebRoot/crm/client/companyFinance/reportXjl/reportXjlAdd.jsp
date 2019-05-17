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






<form class="form-horizontal" role="form" id="add_reportXjlForm"> 
<textarea style="display: none;"  name="client_ID" class="ztb_view_client_ID">${client.client_ID}</textarea>	

<table class="table table-bordered" style="font-size: 13px">
   <!--  <caption >现 金 流 表</caption> -->
   <tr>
        <div class="form-group col-sm-3">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>类型： </label>
			        <div class="col-sm-8">
						<!-- <input type="hidden" id="reportTypeName" name="reportTypeName" class="ztb_add_reportTypeName">
						<select class="col-xs-10 col-sm-9 ztb_add select_reportTypeUuid btn_ztb_select validate[required]"   name="reportTypeUuid" class_name="ztb_add_reportTypeName" id="select_reportTypeUuid">
						 </select>
						 -->
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
            <td align="left" style="font-weight: bolder;"> 一、经营活动产生的现金流量：</td>
			<td></td>
			<td align="left" style="font-weight: bolder;"> 补充资料：</td>
			<td></td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;销售商品、提供劳务收到的现金</td>
			<td>
			    <input type="text" class="operatingCashSum- countInput validate[maxSize[18],custom[number]]"  name="servicesGoodsCash" id="servicesGoodsCash" value="" />
			</td>
			<td align="left" style="font-weight: bolder;">1、将净利润调节为经营活动现金流量：</td>
			<td>
			
			</td>
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的税费返还</td>
			<td><input type="text" class="operatingCashSum- countInput validate[maxSize[18],custom[number]]"  name="receivedTax" id="receivedTax" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;净利润</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  
			name="netProfit" id="netProfit" 
			value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的其它与经营活动有关的现金</td>
			<td><input type="text" class="operatingCashSum- countInput validate[maxSize[18],custom[number]]"  name="operatingCash" id="operatingCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：少数股东损益</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="stockholderLoss" id="stockholderLoss" value="" /></td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">经营现金流入小计</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="operatingCashSum" id="operatingCashSum"  value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：未确认投资损失</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="unconfirmed" id="unconfirmed" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;购买商品、接受劳务支付的现金</td>
			<td><input type="text" class="operatingCashFlow- countInput validate[maxSize[18],custom[number]]"  name="goodsLaborPayCash" id="goodsLaborPayCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：计提的资产减值准备</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="assetsLoss" id="assetsLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付给职工以及为职工支付的现金</td>
			<td><input type="text" class="operatingCashFlow- countInput validate[maxSize[18],custom[number]]"  name="employeesToPayCash" id="employeesToPayCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产折旧</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="plantAssetsLoss" id="plantAssetsLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的各项税费</td>
			<td><input type="text" class="operatingCashFlow- countInput validate[maxSize[18],custom[number]]"  name="taxPayment" id="taxPayment" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;无形资产摊销</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="intangibleAssets" id="intangibleAssets" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与经营活动有关的现金</td>
			<td><input type="text" class="operatingCashFlow- countInput validate[maxSize[18],custom[number]]"  name="otherOperatingActivities" id="otherOperatingActivities" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;长期待摊费用</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="longTermPrepaidExpenses" id="longTermPrepaidExpenses" value="" /></td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">经营现金流出小计</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="operatingCashFlow" id="operatingCashFlow" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;待摊费用减少（减：增加）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="prepaidExpensesLoss" id="prepaidExpensesLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营活动产生的现金流量净额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="activitiesNetCashFlow" id="activitiesNetCashFlow" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 预提费用增加（减：减少）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="accruedExpensesAdd" id="" value="" /></td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、投资活动产生的现金流量：</td>
			<td>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;处置固定资产、无形资产和其它长期资产的损失（减：收益）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="otherLongTermAssetsLoss" id="otherLongTermAssetsLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收回投资所收到的现金</td>
			<td><input type="text" class="inflowsOfCash- countInput validate[maxSize[18],custom[number]]"  name="disinvestmentCash" id="disinvestmentCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;固定资产报废损失</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="disposalFixedAssets" id="disposalFixedAssets" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;取得投资收益所收到的现金</td>
			<td><input type="text" class="inflowsOfCash- countInput validate[maxSize[18],custom[number]]"  name="investmentIncome" id="investmentIncome" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="financialExpenses" id="financialExpenses" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;处置固定资产、无形资产和其它长期资产所回收的现金净额</td>
			<td><input type="text" class="inflowsOfCash- countInput validate[maxSize[18],custom[number]]"  name="otherAssetsNetCash" id="otherAssetsNetCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资损失（减：收益）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="investmentLoss" id="investmentLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;收到的其它与投资活动有关的现金</td>
			<td><input type="text" class="inflowsOfCash- countInput validate[maxSize[18],custom[number]]"  name="investmentActivitiesCash" id="investmentActivitiesCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;递延税款贷项（减：借项）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="deferredTax" id="deferredTax" value="" /></td>
        </tr>
        <tr>
            <td  style="font-weight: bolder;">投资现金流入小计</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="inflowsOfCash" id="inflowsOfCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 存货的减少（减：增加）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="decreaseLoss" id="decreaseLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;购建固定资产、无形资产和其它长期资产所支付的现金</td>
			<td><input type="text" class="cashOutflow- countInput validate[maxSize[18],custom[number]]"  name="longTermAssetsCash" id="longTermAssetsCash" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 经营性应收项目的减少（减：增加）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="decreaseOperatingLoss" id="decreaseOperatingLoss" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资所支付的现金</td>
			<td><input type="text" class="cashOutflow- countInput validate[maxSize[18],custom[number]]"  name="paymentForInvestment" id="paymentForInvestment" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营性应付项目的增加（减：减少）</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="increaseOperatingAdd" id="increaseOperatingAdd" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与投资活动有关的现金</td>
			<td><input type="text" class="cashOutflow- countInput validate[maxSize[18],custom[number]]"  name="otherInvestingActivities" id="otherInvestingActivities" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="otherCash" id="otherCash" value="" /></td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">投资现金流出小计</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashOutflow" id="cashOutflow" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;经营活动产生的现金流量净额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="activitiesNetCash" id="" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;投资活动产生的现金流量净额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="investmentActivities" id="investmentActivities" value="" /></td>
			<td align="left" style="font-weight: bolder;">2、不涉及现金收支的投资和筹资活动：</td>
			<td>
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">三、筹资活动产生的现金流量：</td>
			<td>
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;债务转为资本</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="convertedCapital" id="convertedCapital" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 吸收投资所收到的现金</td>
			<td><input type="text" class="financingCashFlows- countInput validate[maxSize[18],custom[number]]"  name="cashReceivedInvestment" id="cashReceivedInvestment" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;一年内到期的可转换公司债券</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="switchingCompanyBonds" id="switchingCompanyBonds" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;借款所收到的现金</td>
			<td><input type="text" class="financingCashFlows- countInput validate[maxSize[18],custom[number]]"  name="cashReceivedLoan" id="cashReceivedLoan" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;融资租入固定资产</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="financeLease" id="financeLease" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 收到的其它与筹资活动有关的现金</td>
			<td><input type="text" class="financingCashFlows- countInput validate[maxSize[18],custom[number]]"  name="financingActivities" id="financingActivities" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;其它</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="other" id="other" value="" /></td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">筹资现金流入小计</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="financingCashFlows" id="financingCashFlows" value="" /></td>
			<td align="left" style="font-weight: bolder;">3、现金及现金等价物净增加情况：</td>
			<td>
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;偿还债务所支付的现金</td>
			<td><input type="text" class="cashfFlowFinancing- countInput validate[maxSize[18],custom[number]]"  name="cashPayment" id="cashPayment" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;现金的期末余额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashEnd" id="cashEnd" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;分配股利、利润或偿付利息所支付的现金</td>
			<td><input type="text" class="cashfFlowFinancing- countInput validate[maxSize[18],custom[number]]"  name="profitCashPayment" id="profitCashPayment" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：现金的期初余额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashBegin" id="cashBegin" value="" /></td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;支付的其它与筹资活动有关的现金</td>
			<td><input type="text" class="cashfFlowFinancing- countInput validate[maxSize[18],custom[number]]"  name="cashPayments" id="cashPayments" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：现金等价物的期末余额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashEquivalentsEnd" id="cashEquivalentsEnd" value="" /></td>
        </tr>
        <tr>
            <td style="font-weight: bolder;">筹资现金流出小计</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashfFlowFinancing" id="cashfFlowFinancing" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减：现金等价物的期初余额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashEquivalentsBegin" id="cashEquivalentsBegin" value="" /></td>
        </tr>
         <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;筹资活动产生的现金流量净额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="netCashFlow" id="netCashFlow" value="" /></td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;现金及现金等价物净增加额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashEquivalentsNetCash" id="cashEquivalentsNetCash" value="" /></td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">四、汇率变动对现金的影响</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="exchangeRateCash" id="exchangeRateCash" value="" /></td>
			<td></td>
			<td></td>
        </tr>
         <tr>
            <td align="left" style="font-weight: bolder;">五、现金及现金等价物净增加额</td>
			<td><input type="text" class="validate[maxSize[18],custom[number]]"  name="cashEquivalentsAmount" id="cashEquivalentsAmount" value="" /></td>
			<td></td>
			<td></td>
			
        </tr>
    </tbody>
</table>
</form>
    <div class="col-md-offset-5" style="margin-top:30px;">
		<button class="btn btn-primary " id="btn_addReportXjl" type="button"><i class="icon-ok bigger-110"></i>保存</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn" type="button" id="closeReportXjlAddPage"><i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
​</div>
<%@ include file="/crm/client/companyFinance/successMessage.jsp" %><%--保存成功后提示刷新页面--%>

​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportXjl/reportXjl.js?v=<%=vardate%>"></script>













