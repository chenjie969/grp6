<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/crm/client/companyClient/companyClientHead.jsp"%>

           <div class="tabbable">
				<ul class="nav nav-tabs" id="tab_companyBusiness">
					<li class="active">
						<a data-toggle="tab" href="#leadingProducts" >
							主导产品介绍
						</a>
					</li>
					<li>
						<a data-toggle="tab" href="#downClient">
							下游销售客户情况
						</a>
					</li>
                    <li>
						<a data-toggle="tab" href="#upClient">
							上游供货客户情况
						</a>
					</li>
                    <li>
						<a data-toggle="tab" href="#order">
							近期主要订单情况
						</a>
					</li>
                    <li>
						<a data-toggle="tab" href="#costInfo">
							水电费缴纳情况
						</a>
					</li>
                  	<li>
						<a data-toggle="tab" href="#payTaxInfo">
							企业纳税情况
						</a>
					</li>
				</ul>
			<div class="tab-content">
				<div id="leadingProducts" class="tab-pane in active">
					<h4 class="header smaller lighter blue">
						主导产品介绍及其工艺流程（企业产能、产品产量、销量、销售价格等）
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_leadingProductsEdit">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">修改</span>
						</button>
					</h4>
					<div class="row" style="margin:10;">
						<pre class="col-xs-12" style="white-space: pre-wrap;"  id="leadingProducts_content"></pre>
					</div>
				</div>
				<div id="downClient" class="tab-pane">
			     	<h4 class="header smaller lighter blue">主要下游销售客户、结算方式及市场分布情况（近三年比较）
			     		<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addDownClient">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button>
			     	</h4>
					<div class="table-responsive"> 
						 <table id="table_downClient" style="font-size:13px !important;"></table>  
					</div>
			    </div>
				<div id="upClient" class="tab-pane"> 
					<h4 class="header smaller lighter blue">主要上游供货客户、结算方式及市场分布情况（近三年比较）
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addUpClient">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button>
					</h4>
					<div class="table-responsive"> 
						 <table id="table_upClient" style="font-size:13px !important;"></table>  
					</div>
				</div>
				<div id="order" class="tab-pane">
					<h4 class="header smaller lighter blue">近期主要订单情况
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addOrder">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button>
					</h4>
				    <div class="table-responsive"> 
						 <table id="table_order" style="font-size:13px !important;"></table>  
					</div>
				</div>
				<div id="costInfo" class="tab-pane">
					<h4 class="header smaller lighter blue">水电费缴纳情况（检查其最近六个月运营的稳定性）
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addCostInfo">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button>
					</h4>
				    <div class="table-responsive"> 
						 <table id="table_costInfo" style="font-size:13px !important;"></table>  
					</div>
				</div>
				<div id="payTaxInfo" class="tab-pane">
					<h4 class="header smaller lighter blue">企业纳税情况（近三年度、最近一期）
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right hideWhenView" id="btn_addPayTaxInfo">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">添加</span>
						</button>
					</h4>
				    <div class="table-responsive"> 
						 <table id="table_payTaxInfo" style="font-size:13px !important;"></table>  
					</div>
				</div>
			</div>
		</div>


<script src="<%=path %>/crm/client/companyBusiness/companyBusinessIndex.js?v=<%=vardate%>"></script>

<script src="<%=path %>/crm/client/companyBusiness/leadingProducts/leadingProducts.js?v=<%=vardate%>"></script><!-- 主导产品介绍 -->
<script src="<%=path %>/crm/client/companyBusiness/downClient/downClient.js?v=<%=vardate%>"></script><!-- 下游销售客户情况 -->
<script src="<%=path %>/crm/client/companyBusiness/upClient/upClient.js?v=<%=vardate%>"></script><!-- 上游供货客户情况 -->
<script src="<%=path %>/crm/client/companyBusiness/order/order.js?v=<%=vardate%>"></script><!-- 近期主要订单情况 -->
<script src="<%=path %>/crm/client/companyBusiness/costInfo/costInfo.js?v=<%=vardate%>"></script><!-- 水电气费缴纳情况 -->
<script src="<%=path %>/crm/client/companyBusiness/payTaxInfo/payTaxInfo.js?v=<%=vardate%>"></script><!-- 企业纳税情况 -->

