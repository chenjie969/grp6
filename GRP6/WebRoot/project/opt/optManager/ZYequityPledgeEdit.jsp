<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	table .table_busiLimit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	table .table_busiLimit tr,th,td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	}
	
</style>
		
		<%@ include file="/common_timestamp.jsp" %>
		<%@ include file="/common_head.jsp" %>
				<div id="divTwo">	<!-- divTwo 开始-->
						<div class="page-header">
							<h5>修改股权详情</h5>
						</div>

						<form class="form-horizontal" role="form" id="form_baseTwo">
                             
                              
                                  <input type="hidden"  id="clientID" name="clientID" value="${opt.clientID }">
                                  <input type="hidden"  id="apply_ID" name="apply_ID" value="${opt.apply_ID }"> 
                                  <input type="hidden"  id="guarantyTypeID" name="guarantyTypeID" value="${opt.guarantyTypeID }">
                                  <input type="hidden"  id="guarantyTypeName" name="guarantyTypeName" value="${opt.guarantyTypeName }">
                                  <input type="hidden"  id="optTypeID" name="optTypeID" value="${opt.optTypeID }">
                                  <input type="hidden"  id="optTypeName" name="optTypeName" value="${opt.optTypeName }">
                                  <input type="hidden"  id="optGuaranty_ID" name="optGuaranty_ID" value="${opt.optGuaranty_ID }">
                          
                           <c:if test="${opt.clientTypeID eq '01' }">      
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人：</label>
                                  <label style="line-height:29px;">${opt.clientName }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input">统一社会信用代码：</label>
                                  <label style="line-height:29px;">${opt.otherCreditCode }</label>
                              </div>
                           </c:if>   
                           
                            <c:if test="${opt.clientTypeID ne '01' }">      
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人：</label>
                                  <label style="line-height:29px;">${opt.personName }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input">身份证号码：</label>
                                  <label style="line-height:29px;" class="">${opt.otherPersonNum }</label>
                              </div>
                            </c:if>
                              
                             <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否其他公司股权： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;"> 
                                          	 <span style="display: none;" id="clientIDText">${client.client_ID }</span>
                                              <input type="radio" name="isCompanyStock" value="1" <c:if test="${opt.isCompanyStock eq 1 }">checked="checked"</c:if>  class="ace isCompanyStock validate[required]">
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                          	 <span style="display: none;" id="clientIDText">${opt.clientID }</span>
                                              <input type="radio" name="isCompanyStock" value="0"  <c:if test="${opt.isCompanyStock ne 1 }">checked="checked"</c:if>  class="ace isCompanyStock validate[required]">
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div>
                              
                              <div class="form-group col-sm-12">
	                             <h5 class="header smaller lighter blue">
	                             	股权所在公司信息
	                             </h5>	                              
							  </div>
							  
							 <div id="isHaveOtherDIV">
                               
                               <input type="radio" name="otherType" value="01" checked="checked" class="ace otherType validate[required]"><%-- 第三方权属人类型：企业01 --%>
                               <div class="form-group col-sm-6 ">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>股权所在企业全称：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherOwner" value="${client.clientName }" class="col-sm-6 legalPersonInput validate[maxSize[50],required] otherOwner" name="otherOwner" />
                                      <input type="hidden" id="otherOwnerID" value="${client.client_ID}" class="col-sm-6 otherOwnerID" name="otherOwnerID" />
	                                  <div class="col-sm-6 " id="btnDIV" style="display: none;">
	                                      <button class="btn btn-xs btn-info" type="button" id="btn_ChooseOwnerType" name="button" data-toggle="modal" data-target="#select">选择</button>
										  <button class="btn btn-xs btn-info" type="button" id="btn_addStock" name="button">新增</button>
	                                  </div>
                                  </div>
                              </div>
							

                              <div class="form-group col-sm-6 legalPerson">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>统一社会信用代码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherCreditCode" value="${client.certificateCode}"  name="otherCreditCode" class="col-sm-6 legalPersonInput otherCreditCode validate[maxSize[50],required]" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6 legalPerson">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>法定代表人：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherLegalPerson" value="${client.legalPerson}"  name="otherLegalPerson" class="col-sm-6 legalPersonInput otherLegalPerson validate[maxSize[50],required]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6 legalPerson">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>法人联系方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherLegalPhone" value="${client.phoneOne}"  name="otherLegalPhone" class="col-sm-6 legalPersonInput otherLegalPhone validate[maxSize[50],required]" />
                                  </div>
                              </div>
                              
                              <div class="form-group legalPerson">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>住所： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="otherLegalAddress" value="${client.workAddress}" name="otherLegalAddress" class="col-sm-5 legalPersonInput otherLegalAddress validate[maxSize[50],required]" />
                                  </div>
                              </div>
                              
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">邮编： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherPostCode" value="${client.zipCode}" name="otherPostCode" class="col-sm-6 validate[maxSize[6],custom[number]] otherPostCode legalPersonInput" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">传真： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherFax" value="${client.fax}"  name="otherFax" class="col-sm-6 validate[maxSize[18]] otherFax legalPersonInput" />
                                  </div>
                              </div>
                              
                      	 </div>  <%-- end  isHaveOtherDIV --%>     
							  
							  <div class="form-group col-sm-12">
	                             <h5 class="header smaller lighter blue">
	                     					股权所在企业股东信息
		                             <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="stockAdd">
											<i class="icon-edit bigger-110"></i> <span class="bigger-110 no-text-shadow">添加</span>
									</button>                              
	                             </h5>	
							  </div>
							  
							  <div class="table-responsive form-group col-sm-12" id="stockMessageList"> <%-- 股权所在企业股东信息 列表位置 --%>
								<table id="stockMessage-table" style="font-size: 13px !important;"></table>
							  </div>
							  
							  <div class="form-group col-sm-12">
	                             <h5 class="header smaller lighter blue">
	                             	股权出质信息
	                             </h5>                             
							  </div>
							  
							   <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>股权出质比例： </label>
                                  <div class="col-sm-8">
                           			  <input type="text" id="guaranteeScale" value="<fmt:formatNumber value="${opt.guaranteeScale}" pattern="###.##"/>" name="guaranteeScale" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" />
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>
                              
                              <!-- <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否有最高保证额： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isGuarantyMaxSum" value="1" class="ace" checked="checked">
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isGuarantyMaxSum" value="0" class="ace">
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div> -->

                             		 <%@ include file="/project/opt/optManager/common_ZY_Edit.jsp" %>
                              </div>
                          </form>
						</div>
						
						
	<div id="ZYequityPledgeEdit_page"></div>
	
	
	<%@ include file="/project/opt/optManager/common_optEdit.jsp" %>
<script src="<%=path %>/crm/client/stockMessage/stockMessage.js?v=<%=vardate%>"></script><%--股权信息 js --%>	
<script src="<%=path%>/project/opt/optManager/ZYequityPledgeEdit.js?v=<%=vardate%>"></script>
<script src="<%=path%>/project/opt/optManager/optGuarantyAdd.js?v=<%=vardate%>"></script>
	
	<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %><%--图片上传 --%>
	
	
	<%@ include file="/crm/client/stockMessage/stockMessageAdd.jsp" %>
	<%@ include file="/crm/client/stockMessage/stockMessageDel.jsp" %>
	<%@ include file="/crm/client/stockMessage/stockMessageEdit.jsp" %>
	<%@ include file="/crm/client/stockMessage/stockMessageInfo.jsp" %>
	
	