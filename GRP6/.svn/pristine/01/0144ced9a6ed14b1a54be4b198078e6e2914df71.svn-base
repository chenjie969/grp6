<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/crm/client/personClient/personClientDetail.js?v=<%=vardate%>"></script>
<div class="page-content">
	<input type="hidden" id="client_ID" value="" />
	<input type="hidden" id="operate" value="edit" />
	<div class="row">
		<div class="col-xs-12"><!--begin 响应式列  -->
			<!-- PAGE CONTENT BEGINS -->
		        <!--这里放置右边的核心内容  -->
	            <div class="tabbable">
					<ul class="nav nav-tabs " id="myTab3">
						<li class="active">
							<a data-toggle="tab" href="#applicant">
								申请人信息
							</a>
						</li>
						<!-- <li>
							<a data-toggle="tab" href="#picture" class="pictureFile" id="personPictureFile">
								图片附件
							</a>
						</li> -->
						 <li>
							<a data-toggle="tab" href="#clientMaterial"  class="clientMaterial"   id="personPictureFile">
								客户需要提供的资料清单
							</a>
						</li>
						
                        <li>
							<a data-toggle="tab" href="#docment">
								文档附件
							</a>
						</li>
					</ul><!-- /.col-sm-2 -->
	
					<div class="tab-content col-sm-12" >
							<div id="applicant" class="tab-pane in active">
								<h5>申请人：
						    		<span class="ztb_view_personName "></span>
						    		&nbsp;&nbsp;
						    		<span class="ztb_view_clientName "></span>
									<span style="margin-left:2em;" class="grey">客户编号：
										<span class="ztb_view_clientBH"></span>
									</span>
								</h5>
								
								
								<h4 class="header smaller lighter blue">
									申请人基本信息
									<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_editPersonClient">
										<i class="icon-edit bigger-110"></i>
										<span class="bigger-110 no-text-shadow">修改</span>
									</button>
								</h4>
	                            <div class="row" style="margin:0;">
	                                <h5 class="col-sm-6">申请人姓名：<span class="grey ztb_view_personName">（空）</span></h5>
	                                <h5 class="col-sm-6">性别：<span class="grey ztb_view_sex">（空）</span></h5>
	                                <h5 class="col-sm-6">身份证号码：<span class="grey ztb_view_personNum">（空）</span></h5>
	                                <h5 class="col-sm-6">年龄：<span class="grey ztb_view_age">（空）</span>&nbsp;岁</h5>
	                                <h5 class="col-sm-6">婚姻状况：<span class="grey ztb_view_maritalStatus">（空）</span></h5>
	                                <h5 class="col-sm-6">户口所在地：<span class="grey ztb_view_domicile">（空）</span></h5>
	                                <h5 class="col-sm-6">家庭人数：<span class="grey ztb_view_familyNum">（空）</span>&nbsp;人</h5>
	                                <h5 class="col-sm-6">就业人数：<span class="grey ztb_view_workNum">（空）</span>&nbsp;人</h5>
	                                <h5 class="col-sm-12">家庭收入主要来源：<span class="grey ztb_view_incomeSource" style="white-space: pre-wrap;">（空）</span></h5>
	                                <h5 class="col-sm-6">教育程度：<span class="grey ztb_view_education">（空）</span></h5>
	                                <h5 class="col-sm-6">职位：<span class="grey ztb_view_position">（空）</span></h5>
	                                <h5 class="col-sm-6">工作单位：<span class="grey ztb_view_workUnit">（空）</span></h5>
	                                <h5 class="col-sm-6">单位邮编：<span class="grey ztb_view_unitPost">（空）</span></h5>
	                                <h5 class="col-sm-12">单位地址：<span class="grey ztb_view_unitAddress" style="white-space: pre-wrap;">（空）</span></h5>
	                                <h5 class="col-sm-6">税后收入：<span class="grey ztb_view_monthIncome">（空）</span>&nbsp;元</h5>
	                                <h5 class="col-sm-6">单位电话：<span class="grey ztb_view_unitPhone">（空）</span></h5>
	                                <h5 class="col-sm-6">住房面积：<span class="grey ztb_view_houseArea">（空）</span>&nbsp;㎡</h5>
	                                <h5 class="col-sm-6">现住房性质：<span class="grey ztb_view_houseNature">（空）</span></h5>
	                                <h5 class="col-sm-12">现住地址：<span class="grey ztb_view_houseAddress" style="white-space: pre-wrap;">（空）</span></h5>
	                                <h5 class="col-sm-6">住址邮编：<span class="grey ztb_view_housePost">（空）</span></h5>
	                                <h5 class="col-sm-6">手机号：<span class="grey ztb_view_phone">（空）</span></h5>
	                                <h5 class="col-sm-6">住宅电话：<span class="grey ztb_view_houseTel">（空）</span></h5>
	                            </div>
								<br>
									
	                            <h4 class="header smaller lighter blue">
									配偶信息
									<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_editSpouse">
										<i class="icon-edit bigger-110"></i>
										<span class="bigger-110 no-text-shadow" >修改</span>
									</button>
								</h4>
								<div class="row" style="margin:0;">
	                                  <h5 class="col-sm-6">姓名：<span class="grey ztb_spouse_view_spouseName">（空）</span></h5>
	                                  <h5 class="col-sm-6">身份证号码：<span class="grey ztb_spouse_view_personNum">（空）</span></h5>
	                                  <h5 class="col-sm-6">联系方式：<span class="grey ztb_spouse_view_contact">（空）</span></h5> 
	                                  <h5 class="col-sm-6">单位名称：<span class="grey ztb_spouse_view_unitName">（空）</span></h5>
	                                  <h5 class="col-sm-12">单位地址：<span class="grey ztb_spouse_view_unitAddress" style="white-space: pre-wrap;">（空）</span></h5>
	                                  <h5 class="col-sm-6">单位邮编：<span class="grey ztb_spouse_view_unitPost">（空）</span></h5>
	                                  <h5 class="col-sm-6">单位电话：<span class="grey ztb_spouse_view_unitPhone">（空）</span></h5>
	                                  <h5 class="col-sm-6">税后收入：<span class="grey ztb_spouse_view_monthIncome">（空）</span>&nbsp;元</h5> 
	                                  <h5 class="col-sm-12">备注：<span class="grey ztb_spouse_view_remark" style="white-space: pre-wrap;">（空）</span></h5>
	                             </div>
	                             <br>
	                           	 <h4 class="header smaller lighter blue">
									自有住房情况
									<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_editSelfHouse">
										<i class="icon-edit bigger-110"></i>
										<span class="bigger-110 no-text-shadow" >修改</span>
									</button>
								</h4>
								<div class="row" style="margin:0;">
	                                 <h5 class="col-sm-6">坐落：<span class="grey ztb_house_view_address">（空）</span></h5>
	                                 <h5 class="col-sm-6">建筑面积：<span class="grey ztb_house_view_area">（空）</span>&nbsp;㎡</h5>
	                                 <h5 class="col-sm-6">权属类型：<span class="grey ztb_house_view_ownership">（空）</span></h5>
	                                 <h5 class="col-sm-6">第三人姓名：<span class="grey ztb_house_view_thirdName">（空）</span></h5>
	                                 <h5 class="col-sm-6">身份证号：<span class="grey ztb_house_view_personNum">（空）</span></h5>
	                                 <h5 class="col-sm-6">与借款人关系：<span class="grey ztb_house_view_relation">（空）</span></h5>
	                                 <h5 class="col-sm-12">备注：<span class="grey ztb_house_view_remark" style="white-space: pre-wrap;">（空）</span></h5>
	                            </div>
	                            <br>
	                            <h4 class="header smaller lighter blue">
									其他家庭财产
									<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_editOtherAssets">
										<i class="icon-edit bigger-110"></i>
										<span class="bigger-110 no-text-shadow" style="white-space: pre-wrap;">修改</span>
									</button>
								</h4>
								<div class="row" style="margin:0;">
                                       <h5 class="col-sm-12">
                                       	<span class="grey ztb_view_otherAssets" style="white-space: pre-wrap;">（空）</span>
                                       </h5>   
                                </div>
                                <div id="companyData">
	                                <h4 class="header smaller lighter blue">
										经营实体情况
										<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_companyDetail">
											<i class="icon-zoom-in bigger-110"></i>
											<span class="bigger-110 no-text-shadow" >企业资料详情</span>
										</button>
									</h4>
									<div class="row" style="margin:0;">
		                                 <h5 class="col-sm-6">企业名称：<span class="grey ztb_view_clientName">（空）</span></h5>
		                                 <h5 class="col-sm-6">统一社会信用代码：<span class="grey ztb_view_certificateCode">（空）</span></h5>
		                                 <h5 class="col-sm-6">注册币别：<span class="grey ztb_view_currencyName">（空）</span></h5>
	         							 <h5 class="col-sm-6">注册资本：<span class="grey ztb_view_registerSum">（空）</span>&nbsp;万元</h5>
								         <h5 class="col-sm-6">法定代表人：<span class="grey ztb_view_legalPerson">（空）</span></h5>
		                             </div>
		                          </div>
								<br>
							</div>
							
	                         <div id="picture" class="tab-pane ">
									<%@ include file="/crm/client/pictureFiles/pictureFileIndex.jsp"%>
							</div>
							
							<div id="clientMaterial" class="tab-pane">
                                        <%@ include file="/crm/client/clientMaterial/clientMaterialIndex.jsp"%>
							</div>
							
	                        <div id="docment" class="tab-pane">
	                             <!-- <h4 class="header smaller lighter blue">
									合同附件
									<button type="button" name="button" class="btn btn-minier btn-warning pull-right">
										<i class="icon-edit bigger-110"></i>
										<span class="bigger-110 no-text-shadow">添加</span>
									</button>
								</h4> -->
								<%@ include file="/crm/client/personClient/fileup.jsp"%>
							</div>
						</div><!-- /.col-sm-10 -->
					</div><!-- /.row -->
	
	
		</div><!-- /.col --><!--end 响应式列  -->
	</div>
</div>
<%@ include file="/crm/client/personClient/personClientEdit.jsp" %>
<%@ include file="/crm/client/personClient/spouseEdit.jsp" %>
<%@ include file="/crm/client/personClient/selfHouseEdit.jsp" %>
<%@ include file="/crm/client/personClient/otherAssetsEdit.jsp" %>
<%@ include file="/crm/client/personClient/filesUpModal.jsp" %>
<%@ include file="/crm/client/personClient/filesDel.jsp" %>

<!-- 企业详情用 -->
<%@ include file="/common_message.jsp"%>
<%@ include file="/crm/client/companyClient/updateBasicInfo.jsp"%>
<%@ include file="/crm/client/companyClient/updateClientSource.jsp"%>
<%@ include file="/crm/client/relationClient/relationClientAdd.jsp"%>
<%@ include file="/crm/client/relationClient/relationClientDel.jsp"%>
<%@ include file="/crm/client/relationClient/relationClientEdit.jsp"%>
<%@ include file="/crm/client/companyClient/addBankAccount.jsp"%><%-- 添加开户行信息 --%>
<%@ include file="/crm/client/companyClient/editBankAccount.jsp"%><%-- 修改 开户行信息 --%>
<%@ include file="/crm/client/companyClient/delBankAccount.jsp"%><%-- 删除 开户行信息 --%>
<%@ include file="/crm/client/companyClient/managerInfoEdit.jsp"%> <%-- 修改 -- 股权结构历史沿革 --%>
<%@ include file="/crm/client/companyClient/developEvolutionEdit.jsp"%> <%--修改 -- 企业发展沿革  --%>
<%@ include file="/crm/client/companyClient/managerMainInfoEdit.jsp"%> <%--修改 -- 股东背景及主要管理人员分析  --%>
<%@ include file="/crm/client/stockMessage/stockMessageAdd.jsp" %>  <%-- 股权信息 添加 --%>
<%@ include file="/crm/client/stockMessage/stockMessageEdit.jsp" %>  <%-- 股权信息 修改 --%>
<%@ include file="/crm/client/stockMessage/stockMessageDel.jsp" %>  <%-- 股权信息 删除 --%>
<%@ include file="/crm/client/creditInfo/creditInfoEdit.jsp" %>  <%-- 修改  信用信息--%>
<%@ include file="/crm/client/creditInfo/creditInfoEdit.jsp" %>  <%-- 修改  信用信息--%>
<%-- <%@ include file="/crm/client/pictureFile/uploadModel.jsp" %>图片附件选择页面 --%>
<%@ include file="/crm/client/pictureFiles/pictureFileDel.jsp" %><!-- 图片附件删除页面 -->







