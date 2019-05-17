<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/crm/client/companyClient/companyClientHead.jsp"%>

           <div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active">
						<a class="btn_Zcfz" data-toggle="tab" href="#reportZcfz" >
							资产负债表
						</a>
					</li>
					<li>
						<a class="btn_Sy" data-toggle="tab" href="#reportSy">
							损益表
						</a>
					</li>
                    <li>
						<a class="btn_Xjl" data-toggle="tab" href="#reportXjl">
							现金流表
						</a>
					</li>
                    <li>
						<a data-toggle="tab" href="#finance" id="btn_financeAnalyze">
							主要财务指标分析
						</a>
					</li>
                    <li>
						<a data-toggle="tab" href="#property" id="mainAssetList">
							主要资产情况分析
						</a>
					</li>
                    <li>
						<a class="btn_liabilities" data-toggle="tab" href="#liabilities">
							主要负债情况分析
						</a>
					</li>
                  	<li>
						<a class="btn_profit" data-toggle="tab" href="#profit">
							收入利润情况分析
						</a>
					</li>
				</ul>

			<div class="tab-content">
			   
			
				<div id="reportZcfz" class="tab-pane in active"><!-- 资产负债表 -->
				     <div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_openReportZcfzAddPage" >添加资产负债报表</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_reportZcfzCompare" >选择两期对比</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_refreshReportZcfz" >重置列表</button>&nbsp;
				     </div>
				     
                    <!--  <div id="reportZcfzList"></div> -->
                     <div class="table-responsive"  id="reportZcfzList"> 
						 <table id="reportZcfz-table" style="font-size:13px !important;"></table>  
                    </div>
				</div>
				<div id="reportSy" class="tab-pane"><!--损益表-->
				     <div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_openReportSyAddPage" >添加损益报表</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_reportSyCompare" >选择两期对比</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_refreshReportSy" >重置列表</button>&nbsp;
				     </div>
				    <!--  <div id="reportSyList"></div> -->
				    <div class="table-responsive"  id="reportSyList"> 
						 <table id="reportSy-table" style="font-size:13px !important;"></table>  
                    </div>
			    </div>
				<div id="reportXjl" class="tab-pane"> 
				     <div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_openReportXjlAddPage" >添加现金流报表</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_reportXjlCompare" >选择两期对比</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_refreshReportXjl" >重置列表</button>&nbsp;
				     </div>
				     <!-- <div  class="" id="reportXjlList"></div> -->
				     <div class="table-responsive"  id="reportXjlList"> 
						 <table id="reportXjl-table" style="font-size:13px !important;"></table>  
                    </div>
				</div>
				<div id="finance" class="tab-pane"><%--主要财务指标分析 --%>
				  	  <div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_financeComputed" >多期财务指标分析</button>&nbsp;
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_refreshFinanceAnalyze" >重置列表</button>&nbsp;
				     </div>
				     
                     <div class="table-responsive"  id="reportZcfzLists"> 
						 <table id="reportZcfzs-table" style="font-size:13px !important;"></table>  
                    </div>
				</div>
				<div id="property" class="tab-pane"><%-- 主要资产情况分析 --%>
					  <!-- <div class="page-header">
						    <button type="button" name="button" class="btn btn-sm btn-info" id="btn_mainAsset" >重置列表</button>&nbsp;
				     </div> -->
					 <%@ include file="/crm/client/companyFinance/mainAsset/mainAssetList.jsp" %>
				</div>
				<div id="liabilities" class="tab-pane">
					<%@ include file="/crm/client/companyFinance/liabilities/liabilitiesIndex.jsp"%>
				</div>
				<div id="profit" class="tab-pane">
					<%@ include file="/crm/client/companyFinance/profit/profit.jsp"%>
				</div>
			</div>
		</div>

<script src="<%=path %>/crm/client/companyFinance/reportZcfz/reportZcfz.js?v=<%=vardate%>"></script><!-- 资产负债报表 -->
<script src="<%=path %>/crm/client/companyFinance/reportSy/reportSy.js?v=<%=vardate%>"></script><!--损益报表-->
<script src="<%=path %>/crm/client/companyFinance/reportXjl/reportXjl.js?v=<%=vardate%>"></script><!--现金流报表 -->
<script src="<%=path %>/crm/client/companyFinance/finance/financeAnalyze.js?v=<%=vardate%>"></script><!-- 财务指标分析 -->

	








