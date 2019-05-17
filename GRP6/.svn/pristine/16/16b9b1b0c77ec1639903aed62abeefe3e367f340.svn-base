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
						<div class="page-header">
							<h5>修改个人信用详情</h5>
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
                                  <input type="hidden"  id="otherType" name="otherType" value="${opt.clientTypeID }">
                                  
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">权属人： </label>
                                  <label style="line-height:29px;">${opt.personName }</label>
                              </div>

                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right clientType" for="form-input">身份证号码：</label>
                                  <label style="line-height:29px;" class="codeNum">${opt.otherPersonNum }</label>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-input">手机号：</label>
                                  <label style="line-height:29px;" id="phoneText">${opt.otherPersonPhone }</label>
                              </div>
                              
                               <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">现住地址：</label>
                                  <label style="line-height:29px;" id="houseAddressText">${opt.otherPersonAddress }</label>
                              </div>
                             
                              <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">是否已婚： </label>
                                      <div class="radio">
                                          <label style="margin-top:-10px;"> 
                                              <input type="radio" name="isMarried"  value="1" class="ace isMarried" <c:if test="${opt.isMarried == 1 }">checked='checked'</c:if>>
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isMarried"  value="0" class="ace isMarried" <c:if test="${opt.isMarried == 0 }">checked='checked'</c:if>>
                                              <span class="lbl">否</span>
                                          </label>
                                      </div>
                              </div>
                              
                          <div id="isMarriedDIV">
                              <div class="form-group col-sm-6 ">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>配偶姓名： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="spouseName" name="spouseName" class="col-sm-6 marriedInput"  value="${opt.spouseName }"/>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6 ">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>配偶身份证号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="spouseCode" name="spouseCode" class="col-sm-6 marriedInput" value="${opt.spouseCode }"/>
                                  </div>
                              </div>   
                              
                          </div>
                              
                              
							 <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>担保方式： </label>
                                  <div class="col-sm-8">
                                  	<div class="row">
	                                  <div class="col-sm-6">
	                                      <select class="col-sm-6"  name="guaranteePattern" id="guaranteePattern">
	                                      		<option value="个人无限连带责任" <c:if test="${opt.guaranteePattern eq '个人无限连带责任' }">selected='selected'</c:if>>个人无限连带责任</option>
	                                      		<option value="家庭无限连带责任" <c:if test="${opt.guaranteePattern eq '家庭无限连带责任' }">selected='selected'</c:if>>家庭无限连带责任</option>
	                                      </select>
	                                  </div>
	                                 </div> 
                                  </div>
                              </div>
							 
                              <%-- <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">可提供反担保金额： </label>
                                  <div class="col-sm-8">				
                                      <input type="text" id="guaranteeSum" placeholder="" name="guaranteeSum" value="<fmt:formatNumber value="${opt.guaranteeSum }" pattern="####.######"/>" class="col-sm-3 validate[custom[number],maxSize[18]]" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div> --%>

							
							  <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">资产清单描述： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited validate[maxSize[2000]]" name="otherDesc" id="otherDesc" rows="5">${opt.otherDesc }</textarea>
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
                                              <input type="radio" name="isRegister" value="1" class="ace" <c:if test="${opt.isRegister == 1 }">checked='checked'</c:if> > 
                                              <span class="lbl">是</span>
                                          </label>
                                          <label style="margin-top:-10px;">
                                              <input type="radio" name="isRegister" value="0" class="ace"  <c:if test="${opt.isRegister == 0 }">checked='checked'</c:if>>
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



<script src="<%=path%>/project/opt/optManager/personalCreditEdit.js?v=<%=vardate%>"></script>

<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>


