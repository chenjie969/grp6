<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	<h4 class="header smaller lighter blue">（一）贷款情况</h4>
		<h5 class="header lighter blue">
			贷款银行
			<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addLoanRec">
				<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">添加</span>
			</button>
		</h5>
	    <div class="table-responsive"> 
			 <table id="table_loanRec" style="font-size:13px !important;"></table>  
		</div>
		<br>
		<h5 class="header lighter blue">
			开票银行
			<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addBillRec">
				<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">添加</span>
			</button>
		</h5>
	    <div class="table-responsive"> 
			 <table id="table_billRec" style="font-size:13px !important;"></table>  
		</div>
		<br>
		<h5 class="header lighter blue">
			近三年贷款及或有负债变动情况
			<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_editLoanChangeDesc">
				<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
			</button>
		</h5>
	    <div class="row" style="margin:0;">
			<pre class="col-xs-12" style="white-space: pre-wrap;" id="pre_loanChangeDesc">（空）</pre>
		</div>
	
	<h4 class="header smaller lighter blue">（二）对外担保
		<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addGuarantyRec">
			<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">添加</span>
		</button>
	</h4>
	    <div class="table-responsive"> 
			 <table id="table_guarantyRec" style="font-size:13px !important;"></table>  
		</div>
	
	<br>
	<h4 class="header smaller lighter blue">（三）或有负债
		<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_editIncurDebtDesc">
			<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">修改</span>
		</button>
	</h4>
	    <div class="row" style="margin:0;">
			<pre class="col-xs-12" style="white-space: pre-wrap;" id="pre_incurDebtDesc">（空）</pre>
		</div>
	
<script src="<%=path %>/crm/client/companyFinance/liabilities/liabilitiesIndex.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/companyFinance/liabilities/loanRec/loanRec.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/companyFinance/liabilities/billRec/billRec.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/companyFinance/liabilities/guarantyRec/guarantyRec.js?v=<%=vardate%>"></script>
