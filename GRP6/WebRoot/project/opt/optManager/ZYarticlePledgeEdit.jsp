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
							<h5>修改物件质押详情</h5>
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
                              
                              
                            
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质物名称： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optName" name="optName" class="col-sm-6 validate[required,maxSize[50]]" value="${opt.optName }"/>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">规格： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="specifications" name="specifications" class="col-sm-6 validate[maxSize[50]]" value="${opt.specifications }"/>
                                  </div>
                              </div>
                              
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">数量： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="count" name="count" class="col-sm-6 validate[custom[number],maxSize[6]]" 
                                      value="<fmt:formatNumber value="${opt.count }" pattern="####.######"/>"/>
                                  </div>
                              </div>
                              

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">账面原值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="oldValue" placeholder="" name="oldValue" class="col-sm-4 validate[custom[number],maxSize[18]]" 
                                      value="<fmt:formatNumber value="${opt.oldValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
							
							 <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">发票号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="billNumber" name="billNumber" class="col-sm-6 validate[maxSize[50]]" value="${opt.billNumber }"/>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">发票代码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="billCode" name="billCode" class="col-sm-6 validate[maxSize[50]]" value="${opt.billCode }"/>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">购买地点： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="adderss" name="adderss" class="col-sm-6 validate[maxSize[50]]" value="${opt.adderss }"/>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">付款人： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="payPerson" name="payPerson" class="col-sm-6 validate[maxSize[50]]" value="${opt.payPerson }"/>
                                  </div>
                              </div>
							
                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">租用编号： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="leaseCode" name="leaseCode" class="col-sm-6 validate[maxSize[50]]" value="${opt.leaseCode }"/>
                                      
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">租用期限： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="carFrame" name="carFrame" class="col-sm-6 validate[maxSize[50]]" value="${opt.carFrame }"/>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">甲方授权人： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="firstOwner" name="firstOwner" class="col-sm-6 validate[maxSize[50]]" value="${opt.firstOwner }"/>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">甲方授权人身份证号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="firstOwnerCode" name="firstOwnerCode" class="col-sm-6 validate[maxSize[50]]" value="${opt.firstOwnerCode }"/>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">已方授权人： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="secondOwner" name="secondOwner" class="col-sm-6 validate[maxSize[50]]" value="${opt.secondOwner }"/>
                                  </div>
                              </div>
                              
                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">已方授权人身份证号码： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="secondOwnerCode" name="secondOwnerCode" class="col-sm-6 validate[maxSize[50]]" value="${opt.secondOwnerCode }"/>
                                  </div>
                              </div>

                               <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>评估价值： </label>
                                  <div class="col-sm-8">			
                                      <input type="text" id="assessValue" placeholder="" name="assessValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" 
                                      value="<fmt:formatNumber value="${opt.assessValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质押率： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="coverageRatio" placeholder="" name="coverageRatio" class="col-sm-4 validate[required,custom[number],max[100],maxSize[18]]" value="<fmt:formatNumber value="${opt.coverageRatio}" pattern="###.##"/>"/>
                                      <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div>

                              <div class="form-group col-sm-6">
                                  <label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>质押价值： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="optValue" placeholder="" name="optValue" class="col-sm-4 validate[required,custom[number],maxSize[18]]" 
                                      value="<fmt:formatNumber value="${opt.optValue }" pattern="####.######"/>"/>
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
                              	<div class="form-group col-sm-6 hidden-xs" style="height:30px;"> </div>
									
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
<script src="<%=path%>/project/opt/optManager/ZYarticlePledgeEdit.js?v=<%=vardate%>"></script>

		<%@ include file="/project/opt/imgUpload/optUploadEdit.jsp" %>
		
		