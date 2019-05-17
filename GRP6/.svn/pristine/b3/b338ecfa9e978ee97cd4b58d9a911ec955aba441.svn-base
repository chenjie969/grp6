<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %> --%>

<div class="page-content">
	<input type="hidden" id="client_ID" value="" />
	<%-- <input type="hidden" id="client_ID" class="" value="${client.client_ID}" /> --%>
	
	<div class="col-xs-12"><!--begin 响应式列  -->
								<!-- PAGE CONTENT BEGINS -->
							        <!--这里放置右边的核心内容  -->
                                    <div class="tabbable tabs-right row">
										<ul class="nav nav-tabs col-sm-2 pull-right" id="myTab3">
											<li class="active">
												<a data-toggle="tab" href="#one">
													企业基本情况
												</a>
											</li>

											<li>
												<a data-toggle="tab" href="#two" id="mangerInfo">
 													股东背景及主要管理人员
												</a>
											</li>

											<li>
												<a class="btn_Zcfz" data-toggle="tab" href="#three" >
													企业财务状况
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#four">
													企业发展沿革
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#companyBusiness">
													企业经营情况
												</a>
											</li>
                                            <li>
												<a class="btn_relationClient" data-toggle="tab" href="#five">
													<span >关联企业</span>
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#six">
													信用信息及银企往来情况
												</a>
											</li>
                                            <!-- <li>
												<a data-toggle="tab" href="#seven" class="pictureFile" id="companyPictureFile">
													图片附件
												</a>
											</li> -->
											<li>
												<a data-toggle="tab" href="#clientMaterial"  class="clientMaterial"   id="companyPictureFile1">
													客户需要提供的资料清单
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#eight">
													文档附件
												</a>
											</li>
										</ul><!-- /.col-sm-2 -->

										<div class="tab-content col-sm-9"   style="border:none;">
												<div id="one" class="tab-pane in active">
                									<%@ include file="/crm/client/companyClient/clientBasicInfo.jsp"%>
												</div>
												<div id="two" class="tab-pane">
													<%@ include file="/crm/client/stockMessage/stockMessageList.jsp" %>
												</div>
												<div id="three" class="tab-pane">
													<%@ include file="/crm/client/companyFinance/companyFinanceIndex.jsp"%> 
												</div>	                                                   
                                                <div id="four" class="tab-pane">
													<%@ include file="/crm/client/companyClient/developEvolution.jsp"%>
												</div>
												<div id="companyBusiness" class="tab-pane">
													<%@ include file="/crm/client/companyBusiness/companyBusinessIndex.jsp"%>
												</div>
                                                <div id="five" class="tab-pane">
                                                    <%@ include file="/crm/client/relationClient/relationClient.jsp"%>
												</div>
                                                <div id="six" class="tab-pane">
                                                    <%@ include file="/crm/client/creditInfo/creditInfo.jsp"%>
												</div>
                                                <%--<div id="seven" class="tab-pane">
                                                    <%@ include file="/crm/client/pictureFiles/pictureFileIndex.jsp"%>
												</div> --%>
												
												<div id="clientMaterial" class="tab-pane">
                                                    <%@ include file="/crm/client/clientMaterial/clientMaterialIndex.jsp"%>
                                                  <%--   <%@ include file="/project/clientData/clientDataIndex.jsp"%> --%>
												</div>
												
                                                <div id="eight" class="tab-pane">
                                                    <!-- <h4 class="header smaller lighter blue">
            											附件
            											<button type="button" name="button" class="btn btn-minier btn-warning pull-right">
            												<i class="icon-edit bigger-110"></i>
            												<span class="bigger-110 no-text-shadow">添加</span>
            											</button>
            										</h4> -->
            										<%@ include file="/crm/client/companyClient/fileup.jsp"%>
											</div><!-- /.col-sm-10 -->
										</div><!-- /.row -->

							</div><!-- /.col --><!--end 响应式列  -->
	</div>

</div>
<div id="companyBusiness_page"></div>
<script src="<%=path %>/crm/client/companyClient/companyClientDetail.js?v=<%=vardate%>"></script>
<%@ include file="/crm/client/companyClient/updateBasicInfo.jsp"%>
<%@ include file="/crm/client/companyClient/updateClientSource.jsp"%>
<%@ include file="/crm/client/relationClient/relationClientAdd.jsp"%>
<%@ include file="/crm/client/relationClient/relationClientDel.jsp"%>
<%@ include file="/crm/client/relationClient/relationClientEdit.jsp"%>
<%@ include file="/crm/client/companyClient/addBankAccount.jsp"%><%-- 添加开户行信息 --%>
<%@ include file="/crm/client/companyClient/editBankAccount.jsp"%><%-- 修改 开户行信息 --%>
<%@ include file="/crm/client/companyClient/viewBankAccountInfo.jsp"%><%-- 查看 开户行信息 --%>
<%@ include file="/crm/client/companyClient/delBankAccount.jsp"%><%-- 删除 开户行信息 --%>
<%@ include file="/crm/client/companyClient/managerInfoEdit.jsp"%> <%-- 修改 -- 股权结构历史沿革 --%>
<%@ include file="/crm/client/companyClient/developEvolutionEdit.jsp"%> <%--修改  企业发展沿革  --%>
<%@ include file="/crm/client/companyBusiness/leadingProducts/leadingProductsEdit.jsp"%> <%--修改  主导产品介绍  --%>
<%@ include file="/crm/client/companyClient/managerMainInfoEdit.jsp"%> <%--修改  股东背景及主要管理人员分析  --%>
<%@ include file="/crm/client/stockMessage/stockMessageAdd.jsp" %>  <%-- 股权信息 添加 --%>
<%@ include file="/crm/client/stockMessage/stockMessageEdit.jsp" %>  <%-- 股权信息 修改 --%>
<%@ include file="/crm/client/stockMessage/stockMessageInfo.jsp" %>  <%-- 股权信息 查看 --%>
<%@ include file="/crm/client/stockMessage/stockMessageDel.jsp" %>  <%-- 股权信息 删除 --%>
<%@ include file="/crm/client/creditInfo/creditInfoEdit.jsp" %>  <%-- 修改  信用信息--%>
<%@ include file="/common_message.jsp"%>
<%@ include file="/crm/client/companyClient/filesUpModal.jsp" %>
<%@ include file="/crm/client/companyClient/filesDel.jsp" %>
<%@ include file="/crm/client/companyFinance/del.jsp" %><%--  报表删除页面--%>
<%@ include file="/crm/client/companyFinance/selectTwoReport.jsp" %><%--报表对比时提示必须选择两条要操作的数据--%>
<%@ include file="/crm/client/companyFinance/mainAsset/receivable/receivableAdd.jsp" %> <%-- 主要资产分析  应收账款添加 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/receivable/receivableEdit.jsp" %> <%-- 主要资产分析  应收账款修改 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/receivable/receivableDel.jsp" %> <%-- 主要资产分析  应收账款删除 --%>
<%@ include file="/crm/client/companyFinance/mainAsset/receivable/receivableView.jsp" %> <%-- 主要资产分析  应收账款查看 --%>
<%@ include file="/crm/client/companyFinance/mainAsset/otherReceivable/otherReceivableAdd.jsp" %> <%-- 主要资产分析  其它应收账款添加 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/otherReceivable/otherReceivableEdit.jsp" %> <%-- 主要资产分析  其它应收账款修改 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/otherReceivable/otherReceivableView.jsp" %> <%-- 主要资产分析  其它应收账款查看 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/otherReceivable/otherReceivableDel.jsp" %> <%-- 主要资产分析  其它应收账款删除 --%>
<%@ include file="/crm/client/companyFinance/mainAsset/inventory/inventoryAdd.jsp" %> <%-- 主要资产分析  存货添加 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/inventory/inventoryEdit.jsp" %> <%-- 主要资产分析  存货修改 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/inventory/inventoryView.jsp" %> <%-- 主要资产分析  存货查看 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/inventory/inventoryDel.jsp" %> <%-- 主要资产分析  存货删除 --%>
<%@ include file="/crm/client/companyFinance/mainAsset/landHouse/landHouseAdd.jsp" %> <%-- 主要资产分析  住宅添加 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/landHouse/landHouseView.jsp" %> <%-- 主要资产分析  住宅查看 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/landHouse/landHouseEdit.jsp" %> <%-- 主要资产分析  住宅修改 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/landHouse/landHouseDel.jsp" %> <%-- 主要资产分析  住宅删除 --%>
<%@ include file="/crm/client/companyFinance/mainAsset/machine/machineAdd.jsp" %> <%-- 主要资产分析  住宅添加 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/machine/machineEdit.jsp" %> <%-- 主要资产分析  住宅修改 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/machine/machineView.jsp" %> <%-- 主要资产分析  住宅查看 --%>	
<%@ include file="/crm/client/companyFinance/mainAsset/machine/machineDel.jsp" %> <%-- 主要资产分析  住宅删除 --%>
<%@ include file="/crm/client/companyFinance/mainAsset/receivableDescEdit.jsp" %> 
<%@ include file="/crm/client/companyFinance/mainAsset/inventoryDescEdit.jsp" %> 
<%@ include file="/crm/client/companyFinance/mainAsset/fixedAssetsDescEdit.jsp" %> 
<%@ include file="/crm/client/companyFinance/mainAsset/longtermInvestDescEdit.jsp" %> 
<%@ include file="/crm/client/companyFinance/mainAsset/otherReceivableDescEdit.jsp" %>
<%@ include file="/crm/client/companyFinance/liabilities/loanChangeDescEdit.jsp" %><%--近三年贷款及或有负债变动情况编辑页面--%>
<%@ include file="/crm/client/companyFinance/liabilities/incurDebtDescEdit.jsp" %><%--或有负债编辑页面--%>
<%@ include file="/crm/client/companyFinance/profit/profitEdit.jsp" %><%--收入利润情况编辑页面--%>
<%-- <%@ include file="/crm/client/pictureFile/uploadModel.jsp" %>图片附件选择页面
<%@ include file="/crm/client/pictureFile/pictureFileDel.jsp" %>图片附件删除页面 --%>
<%@ include file="/crm/client/pictureFiles/pictureFileDel.jsp" %><!-- 图片附件删除页面 -->


<script type="text/javascript">
	$(function(){
		var client_ID = tool.getUrlParam('client_ID');
		$('#client_ID').val(client_ID);
	});
</script>