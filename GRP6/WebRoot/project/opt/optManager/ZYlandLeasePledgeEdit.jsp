<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

			
			<%@ include file="/common_timestamp.jsp" %>
		<%@ include file="/common_head.jsp" %>
		
				<div id="divTwo">	<!-- divTwo 开始-->

						<div class="page-header">
							<h5>修改土地租赁权详情</h5>
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
                              
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">土地承租权人： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landOwnerName" name="landOwnerName" class="col-sm-6 col-sm-4 validate[maxSize[50]]" value="${opt.landOwnerName }"/>
                                  </div>
                              </div>
                             
                             <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">土地面积： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landArea" placeholder="" name="landArea" class="col-sm-4 validate[maxSize[50]]" value="${opt.landArea }"/>
                                      <span style="line-height:28px;">&nbsp;（面积单位自由填写）</span>
                                  </div>
                              </div>
                             
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">位于： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="adderss" placeholder="" name="adderss" class="col-sm-5 validate[maxSize[200]]" value="${opt.adderss }"/>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">租赁协议/合同名称： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="leaseName" placeholder="" name="leaseName" class="col-sm-5 validate[maxSize[200]]" value="${opt.leaseName }" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">合同起止日期： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
                                  		<div class="col-sm-5 no-padding-right">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" type="text" id="insuranceBeginDate" data-date-format="yyyy-mm-dd" name="insuranceBeginDate" 
											value="<fmt:formatDate value="${opt.insuranceBeginDate }" pattern="yyyy-MM-dd"/>"/>
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
									<span class="midden col-sm-1" style="line-height:28px;">~</span>
									<div class="col-sm-5 no-padding-left">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" type="text"  id="insuranceEndDate" data-date-format="yyyy-mm-dd" name="insuranceEndDate" 
											value="<fmt:formatDate value="${opt.insuranceEndDate }" pattern="yyyy-MM-dd"/>"/>
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
                                  </div>
                                  	</div>
									
                              </div>
								
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">租赁期限： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="leasePeriod" name="leasePeriod" class="col-sm-4 validate[custom[number],maxSize[18]]" value="${opt.leasePeriod }"/>
                                      <span style="line-height:28px;">&nbsp;年</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">年租金： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="yearRent" placeholder="" name="yearRent" class="col-sm-4 validate[custom[number],maxSize[18]]" value="${opt.yearRent }"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
							
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">付款方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="payPattern" placeholder="" name="payPattern" class="col-sm-6 validate[maxSize[50]]" value="${opt.payPattern }"/>
                                  </div>
                              </div>
							 
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">支付时间： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
                                      <div class="col-sm-5 no-padding-right">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" id="payDate" name="payDate" 
											value="<fmt:formatDate value="${opt.payDate }" pattern="yyyy-MM-dd"/>"/>
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									  </div>
									 </div>
                                  </div>
                              </div>
							
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">合同已履行时长： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="alreadyTime" placeholder="" class="col-sm-4 validate[custom[number],maxSize[18]]" name="alreadyTime" value="<fmt:formatNumber value="${opt.alreadyTime }" pattern="####.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;年</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">剩余承租权时长： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="residueTime" placeholder="" class="col-sm-4 validate[custom[number],maxSize[18]]"  name="residueTime" value="<fmt:formatNumber value="${opt.residueTime }" pattern="####.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;年</span>
                                  </div>
                              </div>
							 
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">剩余期限租金： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="residueRent" placeholder="" class="col-sm-4 validate[custom[number],maxSize[18]]"  name="residueRent" value="<fmt:formatNumber value="${opt.residueRent }" pattern="####.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>评估价值：</label>
                                  <div class="col-sm-8">																													
                                      <input type="text" id="assessValue" placeholder="" name="assessValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" value="<fmt:formatNumber value="${opt.assessValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质押率：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="coverageRatio" placeholder="" name="coverageRatio" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" value="<fmt:formatNumber value="${opt.coverageRatio}" pattern="###.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质押价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optValue" placeholder="" name="optValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" value="<fmt:formatNumber value="${opt.optValue }" pattern="###.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                              
									
							  <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">备注： </label>
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
<script src="<%=path%>/project/opt/optManager/ZYlandLeasePledgeEdit.js?v=<%=vardate%>"></script>

 <script type="text/javascript">
	// 注册日期控件点击事件
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
</script>
		
		<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>
		
