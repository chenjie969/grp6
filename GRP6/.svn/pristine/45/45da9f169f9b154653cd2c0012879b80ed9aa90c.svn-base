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
                    <!-- <form class="form-horizontal" role="form" id="form_baseOne"> -->
						<div class="page-header">
							<h5>修改土地详情</h5>
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
                            
                              
                              <%-- <div class="form-group col-sm-12">
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
                              
                       </div> --%>  <%-- end  isHaveOtherDIV --%>        
                              
                              
                              
                              
                              <%-- <div class="form-group col-sm-12">
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
                      
                      </div> --%> <%-- isProxyDIV  end --%>
                        
                        
                        
                        
                              
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
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>土地证号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landCode" placeholder="" name="landCode" value="${opt.landCode }" class="col-sm-6 validate[required,maxSize[50]]" />
                                  </div>
                              </div>

                              <%-- <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>土地来源： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landSource" placeholder="" name="landSource" value="${opt.landSource }" class="col-sm-6 validate[required,maxSize[50]]" />
                                  </div>
                              </div> --%>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">土地面积： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landArea" placeholder="" name="landArea" value="${opt.landArea }" class="col-sm-4 validate[maxSize[50]]" />
                                      <span style="line-height:28px;">&nbsp;（面积单位自由填写）</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押土地面积： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="pledgeLandArea" name="pledgeLandArea" value="${opt.pledgeLandArea }"  class="col-sm-4 validate[required,maxSize[50]]" />
                                      <span style="line-height:28px;">&nbsp;（面积单位自由填写）</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押土地评估价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="assessValue" placeholder="" name="assessValue" value="<fmt:formatNumber value="${opt.assessValue }" pattern="####.######"/>" class="col-sm-4 validate[required,custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
								
							  <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>我公司抵押权顺位：</label>
                                  <div class="col-sm-8">
                                      <select class="col-sm-4" id="pledgeOrder" name="sortNum">
                                      	<option value="第一位" <c:if test="${opt.sortNum == '第一位' }">selected='selected'</c:if>>第一位</option>
                                      	<option value="第二位" <c:if test="${opt.sortNum == '第二位' }">selected='selected'</c:if>>第二位</option>
                                      	<option value="第三位" <c:if test="${opt.sortNum == '第三位' }">selected='selected'</c:if>>第三位</option>
                                      	<option value="第四位" <c:if test="${opt.sortNum == '第四位' }">selected='selected'</c:if>>第四位</option>
                                      </select>
                                      <span style="line-height:28px;">&nbsp;</span>
                                  </div>
                              </div>
                              
                           
                              
                                <div class="form-group col-sm-6 prefixOne" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">第一位前置抵押人：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="preposePledgeeOne" name="preposePledgeeOne" value="${opt.preposePledgeeOne }" class="col-sm-4 validate[maxSize[50]] prefixOneInput" />
                                      <span style="line-height:28px;">&nbsp;</span>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6 prefixOne" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">第一位前置抵押价值：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="preposeOneSum" name="preposeOneSum" value="<fmt:formatNumber value="${opt.preposeOneSum }" pattern="####.######"/>" class="col-sm-4 validate[custom[number],maxSize[18]] prefixOneInput" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6 prefixTwo" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">第二位前置抵押人：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="preposePledgeeTwo" name="preposePledgeeTwo" value="${opt.preposePledgeeTwo }" class="col-sm-4 validate[maxSize[50]] prefixTwoInput" />
                                      <span style="line-height:28px;">&nbsp;</span>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6 prefixTwo" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">第二位前置抵押价值：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="preposeTwoSum" name="preposeTwoSum" value="<fmt:formatNumber value="${opt.preposeTwoSum }" pattern="####.######"/>" class="col-sm-4 validate[custom[number],maxSize[18]] prefixTwoInput" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6 prefixThree" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">第三位前置抵押人：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="preposePledgeeThree" name="preposePledgeeThree" value="${opt.preposePledgeeThree }" class="col-sm-4 validate[maxSize[50]] prefixThreeInput" />
                                      <span style="line-height:28px;">&nbsp;</span>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6 prefixThree" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">第三位前置抵押价值：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="preposeThreeSum" name="preposeThreeSum" value="<fmt:formatNumber value="${opt.preposeThreeSum }" pattern="####.######"/>" class="col-sm-4 validate[custom[number],maxSize[18]] prefixThreeInput" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6 prefixOne" style="display: none;">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">我公司抵押顺位实际余值：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="actualValue" name="actualValue" value="<fmt:formatNumber value="${opt.actualValue }" pattern="####.######"/>" class="col-sm-4 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
							 <div class="form-group col-sm-6 hidden-xs prefixOne" style="height: 30px;display: none;"></div>
							 
							 	
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押率：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="coverageRatio" placeholder="" name="coverageRatio" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" value="<fmt:formatNumber value="${opt.coverageRatio}" pattern="###.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>抵押土地抵押价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optValue" placeholder="" name="optValue" value="<fmt:formatNumber value="${opt.optValue }" pattern="####.######"/>" class="col-sm-4 validate[required,custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>


						      <div class="space-4"></div>		
                              <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">有无法律纠纷、产权是否明晰： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" id="legalDsputeDesc" name="legalDsputeDesc" rows="5">${opt.legalDsputeDesc }</textarea>
                                  		</div>
	                                  </div>
                                  	
                                     <div class="col-sm-5 no-padding-right">
                                          <span class="light-grey" style="float:right;">限制2000个字符</span>
                                     </div>
                                  </div>
                              </div>
							
							  <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">变现能力评价： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" id="cashabilityDesc" name="cashabilityDesc" rows="5">${opt.cashabilityDesc }</textarea>
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
                              <%-- <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否有最高保证额：${opt.isGuarantyMaxSum}</label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isGuarantyMaxSum" value="1" class="ace" <c:if test="${opt.isGuarantyMaxSum == 1 }">checked='checked'</c:if>>
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isGuarantyMaxSum" value="0" class="ace" <c:if test="${opt.isGuarantyMaxSum == 0 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div> --%>
                            	        <%@ include file="/project/opt/optManager/opt_btn_Edit.jsp" %>
                            	
                          </form>

						</div>



<%@ include file="/project/opt/optManager/common_optEdit.jsp" %>
	<script src="<%=path%>/project/opt/optManager/DYlandGuarantyEdit.js?v=<%=vardate%>"></script>



<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>


