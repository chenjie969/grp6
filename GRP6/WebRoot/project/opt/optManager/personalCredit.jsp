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
							<h5>填写个人信用详情</h5>
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
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">手机号：</label>
                                  <label style="line-height:29px;" id="phoneText">13245325665</label>
                              </div>
                              
                               <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">现住地址：</label>
                                  <label style="line-height:29px;" id="houseAddressText">北京市朝阳区水碓子社区10号楼2单元201</label>
                              </div>
                             
                              <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">是否已婚： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isMarried"  value="1" class="ace isMarried">
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isMarried" checked="checked" value="0" class="ace isMarried">
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div>
                              
                          <div id="isMarriedDIV">
                              <div class="form-group col-sm-6 ">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>配偶姓名： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="spouseName" name="spouseName" class="col-sm-6 marriedInput" />
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6 ">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>配偶身份证号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="spouseCode" name="spouseCode" class="col-sm-6 marriedInput" />
                                  </div>
                              </div>   
                              
                          </div>
                              
                              
							 <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>担保方式： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
	                                  <div class="col-sm-6">
	                                      <select class="col-sm-6"  name="guaranteePattern" id="guaranteePattern">
	                                      		<option value="个人无限连带责任" selected="selected">个人无限连带责任</option>
	                                      		<option value="家庭无限连带责任">家庭无限连带责任</option>
	                                      </select>
	                                  </div>
	                                 </div> 
                                  </div>
                              </div>
							 
                             <!--  <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">可提供反担保金额： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="guaranteeSum" placeholder="" name="guaranteeSum" class="col-sm-3 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div> -->

							
							  <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">资产清单描述： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" name="otherDesc" id="otherDesc" rows="5"></textarea>
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


	<%@ include file="/common_timestamp.jsp" %>
	<script src="<%=path%>/project/opt/optManager/personalCredit.js?v=<%=vardate%>"></script>

	<%@ include file="/project/opt/imgUpload/optUpload.jsp" %>
