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

				<div id="divTwo">	<!-- divTwo 开始-->

						<div class="page-header">
							<h5>填写专利权详情</h5>
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
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>专利名称： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="patentName" name="patentName" class="col-sm-6 validate[required,maxSize[50]]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>专利号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="patentCode" name="patentCode" class="col-sm-6 validate[required,maxSize[50]]" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">申请日期： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
                                      <div class="col-sm-5 no-padding-right">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" id="appalyDate" type="text"  data-date-format="yyyy-mm-dd" name="appalyDate" />
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									  </div>
									 </div>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">颁证日期： </label>
                                 <div class="col-sm-8">
                                  	<div class="row">
                                      <div class="col-sm-5 no-padding-right">
										<div class="input-group">
											<input class="form-control date-picker validate[custom[date]]" id="certificateDate" type="text"  data-date-format="yyyy-mm-dd" name="certificateDate" />
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									  </div>
									 </div>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">有效期： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="validPeriod" placeholder="" name="validPeriod" class="col-sm-6 validate[maxSize[18]]" />
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">账号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="depositAccounts" placeholder="" name="depositAccounts" class="col-sm-6 validate[custom[number],maxSize[18]]" />
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">维持专利权义务： </label>
                                  <div class="col-sm-8">
                                  		<select type="text" id="patentDuty" placeholder="" name="patentDuty" class="col-sm-6 validate[maxSize[18]]">
                                  			<option value="甲方">甲方</option>
                                  			<option value="乙方">乙方</option>
                                  		</select>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">保管费： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="custodyCost" placeholder="" name="custodyCost" class="col-sm-6 validate[custom[number],maxSize[18]]" />
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

							 <div class="form-group col-sm-6  hidden-xs" style="height: 30px"></div>
				
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
	<script src="<%=path%>/project/opt/optManager/ZYpatentPledge.js?v=<%=vardate%>"></script>


			<%@ include file="/project/opt/imgUpload/optUpload.jsp" %>
		
