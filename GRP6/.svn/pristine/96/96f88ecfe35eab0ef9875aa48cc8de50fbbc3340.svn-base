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
                   <!--  <form class="form-horizontal" role="form" id="form_baseOne"> -->
						<div class="page-header">
							<h5>修改在建工程详情</h5>
						</div>

						<form class="form-horizontal" role="form" id="form_baseTwo">
							 	<%--   <input type="hidden"  id="ownerName" name="ownerName" value="${opt.clientName }"> --%>
                                  <input type="hidden"  id="clientID" name="clientID" value="${opt.clientID }">
                                  <input type="hidden"  id="apply_ID" name="apply_ID" value="${opt.apply_ID }"> 
                                  <input type="hidden"  id="guarantyTypeID" name="guarantyTypeID" value="${opt.guarantyTypeID }">
                                  <input type="hidden"  id="guarantyTypeName" name="guarantyTypeName" value="${opt.guarantyTypeName }">
                                  <input type="hidden"  id="optTypeID" name="optTypeID" value="${opt.optTypeID }">
                                  <input type="hidden"  id="optTypeName" name="optTypeName" value="${opt.optTypeName }">
                                  <input type="hidden"  id="optGuaranty_ID" name="optGuaranty_ID" value="${opt.optGuaranty_ID }">
                          
                           <c:if test="${opt.clientTypeID eq '01' }">      
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人： </label>
                                  <label style="line-height:29px;">${opt.clientName }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input">统一社会信用代码：</label>
                                  <label style="line-height:29px;">${opt.otherCreditCode }</label>
                              </div>
                           </c:if>   
                           
                            <c:if test="${opt.clientTypeID ne '01' }">      
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人： </label>
                                  <label style="line-height:29px;">${opt.personName }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input">身份证号码：</label>
                                  <label style="line-height:29px;" class="">${opt.otherPersonNum }</label>
                              </div>
                            </c:if>
                            
                              
                              <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否存在第三方： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isOther" value="1"  class="ace isOther validate[required]" <c:if test="${opt.isOther == 1 }">checked='checked'</c:if>>
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isOther" value="0"   class="ace isOther validate[required]" <c:if test="${opt.isOther == 0 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div>
                              
                              
                           <div id="isHaveOtherDIV">
                              <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">第三方权属人类型： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="otherType" value="01" class="ace otherType validate[required]" <c:if test="${opt.otherType == '01' }">checked='checked'</c:if>>
                                              <span class="lbl">法人</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="otherType" value="03" class="ace otherType validate[required]" <c:if test="${opt.otherType != '01' }">checked='checked'</c:if>>
                                              <span class="lbl">自然人</span>
                                          </label>
                                      </div>
                               </div>
                              
                              
                               <div class="form-group col-sm-6 ">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>权属人：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherOwner"  class="col-sm-6 legalPersonInput " name="otherOwner" value="${opt.thirdOwnerName }"/>
                                      <input type="hidden" id="otherOwnerID" placeholder="" class="col-sm-6" name="otherOwnerID" value="${opt.otherOwnerID }"/>
	                                  <div class="col-sm-2 ">
	                                      <button class="btn btn-xs btn-info" type="button" id="btn_ChooseOwnerType" name="button" data-toggle="modal" data-target="#select">选择</button>
	                                  </div>
                                  </div>
                              </div>
							

                              <div class="form-group col-sm-6 legalPerson">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>统一社会信用代码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherCreditCode" name="otherCreditCode" class="col-sm-6 legalPersonInput" value="${opt.thirdrCreditCode }" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6 legalPerson">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>法定代表人：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherLegalPerson" name="otherLegalPerson" class="col-sm-6 legalPersonInput"  value="${opt.thirdLegalPerson }"/>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6 legalPerson">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>法人联系方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherLegalPhone" name="otherLegalPhone" class="col-sm-6 legalPersonInput"  value="${opt.thirdLegalPhone }"/>
                                  </div>
                              </div>
                              
                              <div class="form-group legalPerson">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>住所： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="otherLegalAddress" name="otherLegalAddress" class="col-sm-5 legalPersonInput"  value="${opt.thirdLegalAddress }"/>
                                  </div>
                              </div>
                              
                              
                               <div class="form-group col-sm-6 person">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>身份证号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherPersonNum" name="otherPersonNum" class="col-sm-6 personInput"  value="${opt.thirdPersonNum }"/>
                                  </div>
                              </div>
                              
                              
                              <div class="form-group col-sm-6 person">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>手机号：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherPersonPhone" name="otherPersonPhone" class="col-sm-6 personInput"  value="${opt.thirdPersonPhone }"/>
                                  </div>
                              </div>
    
    						  <div class="col-sm-6 form-group hidden-xs person" style="height: 30px"></div>
                              
                              <div class="form-group person">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>现住地址： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="otherPersonAddress" name="otherPersonAddress" class="col-sm-5 personInput"  value="${opt.thirdPersonAddress }"/>
                                  </div>
                              </div>
                              
                           
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">邮编： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherPostCode" name="otherPostCode" class="col-sm-6 validate[maxSize[6],custom[number]]"  value="${opt.thirdPostCode }" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">传真： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherFax" name="otherFax" class="col-sm-6 validate[maxSize[18]]"  value="${opt.thirdFax }" />
                                  </div>
                              </div>
                              
                       </div>  <%-- end  isHaveOtherDIV --%>        
                              
                              
                              
                              
                              <div class="form-group col-sm-12">
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
                                      <input type="text" id="ProxyName" name="proxyName" class="col-sm-6 proxyInput" value="${opt.proxyName }" />
                                  </div>
                           	  </div>    
                           	 
                           	  <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">代理人联系方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="ProxyPhone" name="proxyPhone" class="col-sm-6 proxyInput" value="${opt.proxyPhone }"/>
                                  </div>
                           	 </div>
                           	 
                           	  <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">身份证号码： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="ProxyCode" name="proxyCode" class="col-sm-3 proxyInput" value="${opt.proxyCode }"/>
                                  </div>
                           	 </div>                    
                      
                      </div> <%-- isProxyDIV  end --%>
                        
                        
                              
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押物品名称： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="optName" name="optName" value="${opt.optName }" class="col-sm-3 validate[required,maxSize[50]]" />
                                  </div>
                              </div>
                              
                              
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">坐落： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="adderss" placeholder="" name="adderss" value="${opt.adderss }" class="col-sm-5 validate[maxSize[200]]" />
                                  </div>
                              </div>
                              
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">建筑工程规划许可证号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="certificateNum" name="certificateNum" value="${opt.certificateNum }" class="col-sm-6 validate[maxSize[50]]" />
                                  </div>
                              </div>
							 
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">在建工程面积： </label>
                                  <div class="col-sm-8">			
                                      <input type="text" id="houseArea" placeholder="" value="<fmt:formatNumber value="${opt.houseArea }" pattern="####.######"/>" name="houseArea" class="col-sm-4 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;平方米</span>
                                  </div>
                              </div>
							 
							  <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">抵押在建工程面积： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="havingArea" placeholder=""  value="<fmt:formatNumber value="${opt.havingArea }" pattern="####.######"/>" name="havingArea" class="col-sm-4 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;平方米</span>
                                  </div>
                              </div>
							 
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">抵押部位： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="pledgePart" placeholder="" value="${opt.pledgePart }" name="pledgePart" class="col-sm-6 validate[maxSize[50]]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押在建工程评估价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="assessValue" placeholder="" value="<fmt:formatNumber value="${opt.assessValue }" pattern="####.######"/>" name="assessValue"  class="col-sm-4 validate[required,custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>

                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押率：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="coverageRatio" placeholder="" name="coverageRatio" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" value="<fmt:formatNumber value="${opt.coverageRatio}" pattern="###.##"/>" />
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optValue" placeholder="" name="optValue" value="<fmt:formatNumber value="${opt.optValue }" pattern="####.######"/>" class="col-sm-4 validate[required,custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>

							 <div class="form-group col-sm-6 hidden-xs" style="height: 30px"></div>

							  <div class="space-4"></div>		
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

                              <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否需要登记： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isRegister" value="1" class="ace" <c:if test="${opt.isRegister == 1 }">checked='checked'</c:if>>
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isRegister" value="0" class="ace" <c:if test="${opt.isRegister == 0 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div>
                              
                             <!--  <div class="form-group col-sm-12">
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

                                      <%@ include file="/project/opt/optManager/opt_btn_Edit.jsp" %>
                              
                          </form>

						</div>


<%@ include file="/project/opt/optManager/common_optEdit.jsp" %>
	<script src="<%=path%>/project/opt/optManager/DYconstructionGuarantyEdit.js?v=<%=vardate%>"></script>
	
	<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>
	
