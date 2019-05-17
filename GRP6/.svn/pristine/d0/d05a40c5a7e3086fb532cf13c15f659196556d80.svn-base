<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
 <!-- <caption >更新损益表</caption> -->
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
<form class="form-horizontal" role="form" id="update_reportSyForm"> 
<table class="table table-bordered " style="font-size: 13px">
   
    <input type="hidden" name="client_ID" id="client_ID" value="${reportSy.client_ID}"  />
    <input type="hidden" name="unit_uid" id="unit_uid" value="${reportSy.unit_uid}"  />
    <input type="hidden" name="reportSy_ID" id="reportSy_ID" value="${reportSy.reportSy_ID}"  />
    <tr>
        <h5 class="col-sm-6">类型：<span class="grey">${reportSy.reportTypeName}</span></h5>
    </tr>
    <tr>
       <h5 class="col-sm-6" align="right" >金额单位：（元）</h5>
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
				<input type="text" class="validate[maxSize[18],custom[number]]" name="mainIncome" id="mainIncome" value="${reportSy.mainIncome}" />
			</td>
			<td align="left" style="font-weight: bolder;">三、营业利润</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="operatingProfit" id="operatingProfit" value="${reportSy.operatingProfit}" />
			</td>
        </tr>
       
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 :主营业务成本</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="mainCost" id="" value="${reportSy.mainCost}" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 投资收益</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="incomeInvestment" id="" value="${reportSy.incomeInvestment}" />
			</td>
			
        </tr>
         <tr >
           <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主营业务税金及附加</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="mainBusiTax" id="" value="${reportSy.mainBusiTax}" />
			</td>
			 <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补贴收入</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="subsidizeRevenue" id="" value="${reportSy.subsidizeRevenue}" />
			</td>
        </tr>
        <tr>
            <td align="left" style="font-weight: bolder;">二、主营业务利润</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="mainOperatingProfit" id="" value="${reportSy.mainOperatingProfit}" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;营业外收入</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="operatingIncome" id="" value="${reportSy.operatingIncome}" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加 : 其它业务利润</td>
			<td>
				<input type="text" class="validate[maxSize[18],custom[number]]" name="otherBusiProfit" id="" value="${reportSy.otherBusiProfit}" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业外支出</td>
			<td>
			    <input type="text" class="validate[maxSize[18],custom[number]]" name="busiExpenditure" id="" value="${reportSy.busiExpenditure}" />			
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;减 : 营业费用</td>
			<td>
			 	<input type="text" class="validate[maxSize[18],custom[number]]" name="busiFee" id="" value="${reportSy.busiFee}" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;加：以前年度损益调整</td>
			<td>
			   <input type="text" class="validate[maxSize[18],custom[number]]" name="annualProfitLoss" id="" value="${reportSy.annualProfitLoss}" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理费用</td>
			<td>
			 	<input type="text" class="validate[maxSize[18],custom[number]]" name="managementFee" id="" value="${reportSy.managementFee}" />
			</td>
			<td align="left" style="font-weight: bolder;">四、利润总额</td>
			<td>
			   <input type="text" class="validate[maxSize[18],custom[number]]" name="profitSum" id="" value="${reportSy.profitSum}" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;财务费用</td>
			<td>
			   <input type="text" class="validate[maxSize[18],custom[number]]" name="financialFee" id="" value="${reportSy.financialFee}" />
			</td>
			<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 减 : 所得税</td>
			<td>
			   <input type="text" class="validate[maxSize[18],custom[number]]" name="incomeTax" id="" value="${reportSy.incomeTax}" />
			</td>
        </tr>
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;汇兑损失</td>
			<td>
			    <input type="text" class="validate[maxSize[18],custom[number]]" name="exchangeLoss" id="" value="${reportSy.exchangeLoss}" />
			</td>
			<td align="left" style="font-weight: bolder;">五、净利润</td>
			<td>
			    <input type="text" class="validate[maxSize[18],custom[number]]" name="netProfit" id="" value="${reportSy.netProfit}" />
			</td>
        </tr>
        
    </tbody>
</table>
</form>
    <div class="col-md-offset-5" style="margin-top:30px;">
		<button class="btn btn-primary  btn_updateReportSy"  type="button" ><i class="icon-ok bigger-110"></i>
			保存
		</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn" type="button" id="closeReportSyUpdatePage">
			<i class="icon-remove bigger-110"></i>
			关闭
		</button>
	</div>
​</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/companyFinance/reportSy/reportSy.js?v=<%=vardate%>"></script>
