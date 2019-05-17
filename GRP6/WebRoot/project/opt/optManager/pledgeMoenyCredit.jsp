<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<h5>填写保证金详情</h5>
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
                              
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">申请金额：</label>
                                  <label  style="line-height:29px;">2000万元</label> <%-- TODO: 已和李贵州确定： 取评审结束的决议金额，暂时不做。 2017年7月14日 14:35:01 --%>
                              </div>
                              
                            <!--    <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>保证金比例： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="form-field-1" name="guaranteeScale" class="col-sm-4 validate[required,custom[number],max[100],maxSize[5]]" />
                                 	  <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                              </div> -->
							 <div class="form-group col-sm-12">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>保证金比例： </label>
                                  <div class="col-sm-4">
                                      <input type="text" id="form-field-1" name="guaranteeScale" class="col-sm-6 validate[required,custom[number],max[100],maxSize[5]]" />
                                 	  <span style="line-height:28px;">&nbsp;%</span>
                                  </div>
                                  
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>保证金种类： </label>
                                  <div class="col-sm-4">
                                   <!--  <input type="hidden" name="guarantyTypeName"> -->
									<select name="depositTypeId"  class="col-xs-6 col-sm-6 validate[required,maxSize[50]]" id="btn_depositTypes">
										<option value="">请选择</option>
										 <c:forEach var="bz"  items="${depositTypeList}">
											<option value="${bz.dicTypeID }">${bz.dicTypeName }</option>
										</c:forEach> 
									</select>
                                  </div>
                              </div>

                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>保证金金额： </label>
                                  <div class="col-sm-8">
                                      <input type="text" id="guaranteeSum" name="guaranteeSum" class="col-sm-4 validate[required,custom[number],maxSize[18]]z" />
                                      <span style="line-height:28px;">&nbsp;万元</span>
                                  </div>
                              </div>
		
                             <div class="space-4"></div>		
                              <div class="form-group">
                                  <label class="col-sm-2 control-label no-padding-right" for="form-input">说明： </label>
                                  <div class="col-sm-10">
	                                  <div class="row">
	                                  	<div class="col-sm-12">
                                  			<textarea class="col-sm-5 limited" id="form-field-9 validate[maxSize[2000]]" rows="5" name="disposeRemark"></textarea>
                                  		</div>
	                                  </div>
                                  	
                                     <div class="col-sm-5 no-padding-right">
                                          <span class="light-grey" style="float:right;">限制2000个字符</span>
                                     </div>
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
                              </div>
 -->
                           	 <%@ include file="/project/opt/optManager/opt_btn.jsp" %>
                          </form>

						</div>



	<%@ include file="/common_timestamp.jsp" %>
	<script src="<%=path%>/project/opt/optManager/pledgeMoenyCredit.js?v=<%=vardate%>"></script>
	
	<%@ include file="/project/opt/imgUpload/optUpload.jsp" %>
	
	
