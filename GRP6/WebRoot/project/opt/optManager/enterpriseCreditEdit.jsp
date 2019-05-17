<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	table.table_busiLimit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	table.table_busiLimit tr th,td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	}
	
</style>
	<%@ include file="/common_timestamp.jsp" %>
	<%@ include file="/common_head.jsp" %>
	
				<div id="divTwo">	<!-- divTwo 开始-->
                  <!--   <form class="form-horizontal" role="form" id="form_baseOne"> -->
						<div class="page-header">
							<h5>修改企业信用详情</h5>
						</div>

						<form class="form-horizontal" role="form" id="form_baseTwo">
							 <%-- 	  <input type="hidden"  id="ownerName" name="ownerName" value="${opt.clientName }"> --%>
                                  <input type="hidden"  id="clientID" name="clientID" value="${opt.clientID }">
                                  <input type="hidden"  id="apply_ID" name="apply_ID" value="${opt.apply_ID }"> 
                                  <input type="hidden"  id="guarantyTypeID" name="guarantyTypeID" value="${opt.guarantyTypeID }">
                                  <input type="hidden"  id="guarantyTypeName" name="guarantyTypeName" value="${opt.guarantyTypeName }">
                                  <input type="hidden"  id="optTypeID" name="optTypeID" value="${opt.optTypeID }">
                                  <input type="hidden"  id="optTypeName" name="optTypeName" value="${opt.optTypeName }">
                                  <input type="hidden"  id="optGuaranty_ID" name="optGuaranty_ID" value="${opt.optGuaranty_ID }">
                                  <input type="hidden"  id="otherType" name="otherType" value="${opt.clientTypeID }">
                                  
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人： </label>
                                  <label style="line-height:29px;">${opt.clientName }</label>
                              </div>

                         
                              <div class="form-group col-sm-6">
	                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input">统一社会信用代码：</label>
	                             	  <label style="line-height:29px;" class="">${opt.otherCreditCode }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">法定代表人： </label>
                                  <label style="line-height:29px;" id="">${opt.otherLegalPerson }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">法人联系方式：</label>
                                  <label style="line-height:29px;" id="">${opt.otherLegalPhone }</label>
                              </div>
                             
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">住所： </label>
                                  <label style="line-height:29px;" id="">${opt.otherLegalAddress }</label>
                              </div>
                              
                           
                           <div class="form-group col-sm-6">
                               <label class="col-sm-4 control-label no-padding-right" for="form-input">邮编： </label>
                               <label style="line-height:29px;" id="">${opt.otherPostCode }</label>
                           </div>
                           
                           <div class="form-group col-sm-6">
                               <label class="col-sm-4 control-label no-padding-right" for="form-input">传真： </label>
                               <label style="line-height:29px;" id="">${opt.otherFax }</label>
                           </div>
                             
                             
                             
                           <%--   <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">是否代理人： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isProxy" value="1" class="ace  isProxy" <c:if test="${opt.isProxy == 1 }">checked='checked'</c:if>>
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isProxy" value="0"  class="ace isProxy" <c:if test="${opt.isProxy == 0 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div>
                              
                     
                        	<div  id="isProxyDIV">
							  <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">代理人姓名： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="ProxyName" name="proxyName" class="col-sm-6 proxyInput" value="${opt.proxyName }"/>
                                  </div>
                           	 </div>    
                           	 
                           	  <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">代理人联系方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="ProxyPhone" name="proxyPhone" class="col-sm-6 proxyInput"  value="${opt.proxyPhone }"/>
                                  </div>
                           	 </div>
                           	 
                           	  <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">身份证号码： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="ProxyCode" name="proxyCode" class="col-sm-3 proxyInput"  value="${opt.proxyCode }"/>
                                  </div>
                           	 </div>                    
                      </div> isProxyDIV  end
                 
                              
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>开户银行： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="bankName" name="bankName" class="col-sm-3 validate[required,maxSize[50]]" value="${opt.bankName }" />
                                  </div>
                              </div>
                              
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>银行账号： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="bankNumber" name="bankNumber" class="col-sm-3 validate[required,custom[number],maxSize[50]]" value="${opt.bankNumber }" />
                                  </div>
                              </div>
							  
							   <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">可提供反担保金额： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="guaranteeSum" name="guaranteeSum" class="col-sm-3 validate[custom[number],maxSize[18]]" value="<fmt:formatNumber value="${opt.guaranteeSum }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                               </div> --%>
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>企业曾用名： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="companyOnceName" name="companyOnceName" class="col-sm-3 validate[required,maxSize[50]]" value="${opt.companyOnceName }" />
                                  </div>
                              </div>
		
                               <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">说明： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" id="disposeRemark" rows="5" name="disposeRemark">${opt.disposeRemark }</textarea>
                                  		</div>
	                                  </div>
                                  	
                                     <div class="col-sm-5 no-padding-right">
                                          <span class="light-grey" style="float:right;">限制2000个字符</span>
                                     </div>
                                  </div>
                              </div>
                              
             <!--                  <div class="form-group col-sm-12">
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

                              <%-- <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否需要登记： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isRegister" value="1" class="ace" <c:if test="${opt.isRegister == 1 }">checked='checked'</c:if> > 
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isRegister" value="0" class="ace"  <c:if test="${opt.isRegister == 0 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div> --%>

                               <%@ include file="/project/opt/optManager/opt_btn_Edit.jsp" %>
                          </form>
						</div>
						
						
					<div class="space-30"></div>
					<div class="clearfix form-actions">
						<div class="col-sm-offset-3 col-sm-9">
							<button class="btn btn-primary baseTwo" type="button" id="btn_updateptGuaranty" >
								<i class="icon-ok bigger-110"></i>保存
							</button>
							&nbsp; &nbsp; &nbsp;
							
							<button class="btn " type="button" id="btn_close">
								<i class="icon-remove bigger-110"></i>关闭
							</button>
						</div>
					</div>



	<%@ include file="/common_message.jsp" %>
<%@ include file="/project/opt/optManager/clientList.jsp" %>
<%@ include file="/common_foot.jsp" %>

	<script src="<%=path%>/project/opt/optManager/enterpriseCreditEdit.js?v=<%=vardate%>"></script>

	<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>
	