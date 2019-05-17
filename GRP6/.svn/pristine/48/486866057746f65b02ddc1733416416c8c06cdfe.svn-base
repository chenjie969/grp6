<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

				<div id="divTwo">	<!-- divTwo 开始-->

						<div class="page-header">
							<h5>填写土地租赁权详情</h5>
						</div>

						<form class="form-horizontal" role="form" id="form_baseTwo">
						
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人： </label>
                                  <label style="line-height:29px;" class="ownerName"></label>
                                  <input type="hidden"  id="ownerName" name="ownerName">
                                  <input type="hidden"  id="clientID" name="clientID">
                                  <input type="hidden"  id="apply_ID" name="apply_ID">
                                  <input type="hidden"  id="guarantyTypeID" name="guarantyTypeID">
                                  <input type="hidden"  id="guarantyTypeName" name="guarantyTypeName">
                                  <input type="hidden"  id="optTypeID" name="optTypeID">
                                  <input type="hidden"  id="optTypeName" name="optTypeName">
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input"><i class="icon-asterisk orange">身份证号或社会信用代码</i></label>
                                  <label style="line-height:29px;" class="codeNum"></label>
                              </div>
                              
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">土地承租权人： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landOwnerName" name="landOwnerName" class="col-sm-6 col-sm-4 validate[maxSize[50]]" />
                                  </div>
                              </div>
                             
                             <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">土地面积： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="landArea" placeholder="" name="landArea" class="col-sm-4 validate[maxSize[50]]" />
                                      <span style="line-height:28px;">&nbsp;（面积单位自由填写）</span>
                                  </div>
                              </div>
                             
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">位于： </label>
                                  <div class="col-sm-10">
                                      <input type="text" id="adderss" placeholder="" name="adderss" class="col-sm-5 validate[maxSize[200]]" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">租赁协议/合同名称： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="leaseName" placeholder="" name="leaseName" class="col-sm-5 validate[maxSize[200]]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">合同起止日期： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
                                  		<div class="col-sm-5 no-padding-right">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" type="text" id="insuranceBeginDate" data-date-format="yyyy-mm-dd" name="insuranceBeginDate" />
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
									<span class="midden col-sm-1" style="line-height:28px;">~</span>
									<div class="col-sm-5 no-padding-left">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" type="text" id="insuranceEndDate"  data-date-format="yyyy-mm-dd" name="insuranceEndDate" />
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
                                      <input type="text" id="leasePeriod" name="leasePeriod" class="col-sm-4 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;年</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">年租金： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="yearRent" placeholder="" name="yearRent" class="col-sm-4 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
							
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">付款方式： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="payPattern" placeholder="" name="payPattern" class="col-sm-6 validate[maxSize[50]]" />
                                  </div>
                              </div>
							 
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">支付时间： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
                                      <div class="col-sm-5 no-padding-right">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" type="text"  id="payDate" data-date-format="yyyy-mm-dd" name="payDate" />
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
                                      <input type="text" id="alreadyTime" placeholder="" class="col-sm-4 validate[custom[number],maxSize[5]]" name="alreadyTime" />
                                      <span style="line-height:28px;">&nbsp;年</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">剩余承租权时长： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="residueTime" placeholder="" class="col-sm-4 validate[custom[number],maxSize[5]]"  name="residueTime" />
                                      <span style="line-height:28px;">&nbsp;年</span>
                                  </div>
                              </div>
							 
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">剩余期限租金： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="residueRent" placeholder="" class="col-sm-4 validate[custom[number],maxSize[18]]"  name="residueRent"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>评估价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="assessValue" placeholder="" name="assessValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
							
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质押率 ：</label>
                                  <div class="col-sm-8">
                                      <input type="text" id="coverageRatio" placeholder="" name="coverageRatio" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" />
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质押价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optValue" placeholder="" name="optValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>


							  <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">说明： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" id="disposeRemark" rows="5" name="disposeRemark"></textarea>
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
                                              <input type="radio" name="isRegister" value="1" class="ace" checked="checked">
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isRegister" value="0" class="ace">
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

								                           	 <%@ include file="/project/opt/optManager/opt_btn.jsp" %>
                          </form>

						</div>

 <script type="text/javascript">
	// 注册日期控件点击事件
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
</script>

<%@ include file="/common_timestamp.jsp" %>
<script src="<%=path%>/project/opt/optManager/ZYlandLeasePledge.js?v=<%=vardate%>"></script>

		<%@ include file="/project/opt/imgUpload/optUpload.jsp" %>
	
