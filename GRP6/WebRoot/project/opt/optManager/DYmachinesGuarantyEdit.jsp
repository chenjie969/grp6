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
							<h5>修改机器设备详情</h5>
						</div>

						<form class="form-horizontal" role="form" id="form_baseTwo">
						
                              <form class="form-horizontal" role="form" id="form_baseTwo">
							 	 <%--  <input type="hidden"  id="ownerName" name="ownerName" value="${opt.clientName }"> --%>
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
                                      <input type="text" id="otherPostCode" name="otherPostCode" class="col-sm-6 validate[maxSize[6]]"  value="${opt.thirdPostCode }" />
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
                                 <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否存在第三方使用权人： </label>
                                     <div class="radio">
                                         <label style="margin-top:-10px;">
                                             <input type="radio" name="isUseOther" value="1"  class="ace  validate[required] isUseOther" <c:if test="${opt.isUseOther eq 1 }">checked='checked'</c:if>>
                                             <span class="lbl">是</span>
                                         </label>
                                         <label style="margin-top:-10px;">
                                             <input type="radio" name="isUseOther" value="0"   class="ace  validate[required] isUseOther" <c:if test="${opt.isUseOther ne 1 }">checked='checked'</c:if>>
                                             <span class="lbl">否</span>
                                         </label>
                                     </div>
                             </div>    
                              
                        <div id="isUseOtherDIV">
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>使用权人名称/姓名： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherUseName" name="otherUseName" value="${opt.otherUseName }" class="col-sm-6 otherUseInput" />
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">统一社会信用代码/身份证号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherUseCode" name="otherUseCode"  value="${opt.otherUseCode }" class="col-sm-6 validate[maxSize[50]] otherUseInput" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">联系方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="otherUsePhone" name="otherUsePhone" value="${opt.otherUsePhone }"  class="col-sm-6 validate[maxSize[50]] otherUseInput" />
                                  </div>
                              </div>
                              
                        	 <div class="col-sm-6 form-group hidden-xs " style="height: 30px"></div>
                        </div> 
                              
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押物品名称： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optName" name="optName" value="${opt.optName }" class="col-sm-6 validate[required,maxSize[50]]" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>设备名称： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="machinesNumber" name="machinesNumber" value="${opt.machinesNumber }" class="col-sm-6 validate[required,maxSize[64]]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">规格型号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="specifications" name="specifications" value="${opt.specifications }" class="col-sm-6 validate[maxSize[50]]" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">单位： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="unitName" name="unitName"  value="${opt.unitName }" class="col-sm-6 validate[maxSize[50]]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">数量： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="count" name="count" value="<fmt:formatNumber value="${opt.count }" pattern="####.######"/>" class="col-sm-6 validate[custom[number],maxSize[10]]" />
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">发票价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="invoiceValue" placeholder="" class="col-sm-4 col-sm-4 validate[custom[number],maxSize[18]]" name="invoiceValue" value="<fmt:formatNumber value="${opt.invoiceValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                             <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>评估价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="assessValue" placeholder="" name="assessValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" value="<fmt:formatNumber value="${opt.assessValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押率：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="coverageRatio" placeholder="" name="coverageRatio" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" value="<fmt:formatNumber value="${opt.coverageRatio}" pattern="###.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押价值： </label>
                                  <div class="col-sm-8">																					
                                      <input type="text" id="optValue" placeholder="" name="optValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" value="<fmt:formatNumber value="${opt.optValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input"> 是否已上保险： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isInsurance" class="ace" value="1"  <c:if test="${opt.isInsurance eq 1 }">checked='checked'</c:if>>
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isInsurance" value="0" class="ace" <c:if test="${opt.isInsurance ne 1 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                               </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">保险公司： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="insuranceCompany" placeholder="" class="col-sm-6 validate[maxSize[50]]" name="insuranceCompany" value="${opt.insuranceCompany }"/>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">保单编号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="insuranceCode" placeholder="" class="col-sm-6 validate[maxSize[50]]" name="insuranceCode" value="${opt.insuranceCode }"/>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">保单起止日期： </label>
                                  <div class="col-sm-8">
										<div class="row">
											<div class="col-sm-5 no-padding-right">
												<div class="input-group">
													<input class="form-control date-picker validate[custom[date]]" type="text" id="insuranceBeginDate"  data-date-format="yyyy-mm-dd" name="insuranceBeginDate" 
													value="<fmt:formatDate value="${opt.insuranceBeginDate }" pattern="yyyy-MM-dd"/>"/>
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
											</div>
											<span class="midden col-sm-1" style="line-height:28px;">~</span>
											<div class="col-sm-5 no-padding-left">
												<div class="input-group">
													<input class="form-control date-picker validate[custom[date]]" type="text" id="insuranceEndDate"  data-date-format="yyyy-mm-dd" name="insuranceEndDate" 
													value="<fmt:formatDate value="${opt.insuranceEndDate }" pattern="yyyy-MM-dd"/>"/>
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>	
                                  </div>
                              </div>
                              
                              	
                           	  <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">存放地： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="adderss" name="adderss"  value="${opt.adderss}" class="col-sm-5 validate[maxSize[200]]" />
                                  </div>
                              </div>
                              
                              <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>状况（现有或将有）： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" id="otherDesc" name="otherDesc" rows="5">${opt.otherDesc}</textarea>
                                  		</div>
	                                  </div>
                                  	
                                     <div class="col-sm-5 no-padding-right">
                                          <span class="light-grey" style="float:right;">限制2000个字符</span>
                                     </div>
                                  </div>
                              </div>
							
							     <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">说明： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited  validate[maxSize[2000]]" id="disposeRemark" rows="5" name="disposeRemark">${opt.disposeRemark }</textarea>
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

                             
                               <%@ include file="/project/opt/optManager/opt_btn_Edit.jsp" %>
                             
                          </form>

						</div>


	

	<%@ include file="/project/opt/optManager/common_optEdit.jsp" %>
	<script src="<%=path%>/project/opt/optManager/DYmachinesGuarantyEdit.js?v=<%=vardate%>"></script>

	<script type="text/javascript">
			// 注册日期控件点击事件
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
	   </script>

	   <%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>
	   