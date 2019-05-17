<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content ">		

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





<form class="form-horizontal" role="form" id="add_reportSyForm"> 
   <textarea style="display: none;"  name="client_ID" class="ztb_view_client_ID">${client.client_ID}</textarea>	



<table class="table table-bordered "  style="font-size: 13px">
    <!-- <caption >损益表</caption> -->
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
    <tbody >
        <tr >
            <td align="left" style="font-weight: bolder;">一、主营业务收入：</td>
			<td>
				<input type="text" class="countInput validate[maxSize[18],custom[number]]"  name="mainIncome" id="mainIncome" value="" />
			</td>
			<td align="left" style="font-weight: bolder;">三、营业利润</td>
			<td>
				<input type="text" class=" countInput validate[maxSize[18],custom[number]]"  name="operatingProfit" id="operatingProfit" value="" />
			</td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 :主营业务成本</td>
			<td>
				<input type="text" class="countInput mainOperatingProfit validate[maxSize[18],custom[number]]"  name="mainCost" id="" value="" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 投资收益</td>
			<td>
				<input type="text" class="profitSum countInput validate[maxSize[18],custom[number]]"  name="incomeInvestment" id="" value="" />
			</td>
			
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主营业务税金及附加</td>
			<td>
				<input type="text" class="countInput mainOperatingProfit validate[maxSize[18],custom[number]]"  name="mainBusiTax" id="" value="" />
			</td>
			 <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补贴收入</td>
			<td>
				<input type="text" class="profitSum countInput validate[maxSize[18],custom[number]]"  name="subsidizeRevenue" id="" value="" />
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、主营业务利润</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]"  name="mainOperatingProfit" id="mainOperatingProfit" value="" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;营业外收入</td>
			<td>
				<input type="text" class="profitSum countInput validate[maxSize[18],custom[number]]"  name="operatingIncome" id="" value="" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 其它业务利润</td>
			<td>
				<input type="text" class="countInput validate[maxSize[18],custom[number]]"  name="otherBusiProfit" id="otherBusiProfit" value="" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业外支出</td>
			<td>
			    <input type="text" class="countInput validate[maxSize[18],custom[number]]"  name="busiExpenditure" id="busiExpenditure" value="" />			
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业费用</td>
			<td>
			 	<input type="text" class="operatingProfit countInput validate[maxSize[18],custom[number]]"  name="busiFee" id="" value="" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：以前年度损益调整</td>
			<td>
			   <input type="text" class="countInput validate[maxSize[18],custom[number]]"  name="annualProfitLoss" id="annualProfitLoss" value="" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理费用</td>
			<td>
			 	<input type="text" class="operatingProfit  countInput validate[maxSize[18],custom[number]]"  name="managementFee" id="" value="" />
			</td>
			<td align="left" style="font-weight: bolder;">四、利润总额</td>
			<td>
			   <input type="text" class="validate[maxSize[18],custom[number]]"  name="profitSum" id="profitSum" value="" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td>
			   <input type="text" class="operatingProfit countInput validate[maxSize[18],custom[number]]"  name="financialFee" id="" value="" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 : 所得税</td>
			<td>
			   <input type="text" class="countInput validate[maxSize[18],custom[number]]"  name="incomeTax" id="incomeTax" value="" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;汇兑损失</td>
			<td>
			    <input type="text" class="operatingProfit countInput  validate[maxSize[18],custom[number]]"  name="exchangeLoss" id="" value="" />
			</td>
			<td align="left" style="font-weight: bolder;">五、净利润</td>
			<td>
			    <input type="text" class="validate[maxSize[18],custom[number]]"  name="netProfit" id="netProfit" value="" />
			</td>
        </tr>
        
    </tbody>
</table>
</form>
 <div class="col-md-offset-5" style="margin-top:30px;">
		<button class="btn btn-primary btn_addReportSy" type="button" id="btn_addReportSy">
			<i class="icon-ok bigger-110"></i>保存
		</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn" type="button" id="closeReportSyAddPage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
​</div>
<%@ include file="/crm/client/companyFinance/successMessage.jsp" %><%--保存成功后提示刷新页面--%>

​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportSy/reportSy.js?v=<%=vardate%>"></script>
	