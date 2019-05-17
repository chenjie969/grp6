<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ include file="/common_timestamp.jsp" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script>
 <div class="modal fade" id="projectApplySelect" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">高级查询</h4>
                  </div>
                  <div class="modal-body">

                <form class="form-horizontal" role="form" id="projectApplySelect_form">
                        <!--   <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">项目编号1： </label>
                              <div class="col-sm-8">
                                  <input type="text"  id="projectCode"  name="projectCode" class="col-xs-10 col-sm-11 " />
                              </div>
                          </div> -->

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">项目名称： </label>
                              <div class="col-sm-8">
                                  <input type="text" name="projectName" id="projectName"  class="col-xs-10 col-sm-11 ztb_add_mod_name ztb_add validate[maxSize[50]]" />
                              </div>
                          </div>

                       <%--    <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">业务性质1： </label>
                             <div class="col-sm-5">
                                  <select id="busiNatureList" class="selectList  col-md-12 "  name="busiNatureID"  >		
										<option value="">&nbsp;请选择</option>
										<c:forEach items="${busiNatureList}" var="busiNature">
											<option value="${busiNature.dicTypeID}">${busiNature.dicTypeName}</option>
										</c:forEach>
			    				  </select>
                             </div>
                          </div> --%>

                       <%--    <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">项目类型1： </label>
                             <div class="col-sm-5">
                                <select id="projectTypeList" class="selectList  col-md-12 "  name="projectTypeID01"  >		
										<option value="">&nbsp;请选择</option>
										<c:forEach items="${projectTypeList}" var="projectType">
											<option value="${projectType.dicTypeID}">${projectType.dicTypeName}</option>
										</c:forEach>
				 				 </select>
                             </div>
                          </div> --%>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">客户类型： </label>
                             <div class="col-sm-5">
                              		  <select id="clientTypeList0" class="selectList  col-md-12 "  name="clientTypeID" >  		
											<option value="">&nbsp;请选择</option>                                    
											<c:forEach items="${clientTypeList}" var="clientType">
												<option value="${clientType.dicTypeID}">${clientType.dicTypeName}</option>
											</c:forEach>
					 				 </select>
                             </div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">客户名称： </label>
                              <div class="col-sm-8">
                                  <input type="text" name="clientName" id="clientName"  class="col-xs-10 col-sm-11  ztb_add validate[maxSize[50]]" />
                              </div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">业务品种： </label>
                             <div class="col-sm-5">
                                <div class="col-md-12 input-group busiSortDicTree">
									<input  type="text"  class="form-control " autoField="busiTypeID"   id="busiSortDicTree"  value="" dataValue="" name="busiTypeName"  readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
				    		  </div>
                             </div>
                          </div>

                          <%-- <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">绿色通道1： </label>
                             <div class="col-sm-5">
                                 <select id="greenChannelList" class="col-md-12"  name="greenChannelID"  >		
										<option value="">&nbsp;请选择</option>
										<c:forEach items="${greenChannelList}" var="greenChannel">
											<option value="${greenChannel.dicTypeID}">${greenChannel.dicTypeName}</option>
										</c:forEach>
					    		</select>
                             </div>
                          </div> --%>

                          <div class="space-4"></div>
                          <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">申请金额： </label>
            			        <div class="col-sm-8">
            						<input  type="text" class="col-sm-3 ztb_add" name="registerSumStart"  id="registerSumStart"/>
            						<p class="col-sm-1">-</p>
            						<input  type="text" class="col-sm-3 ztb_add" name="registerSumEnd"  id="registerSumEnd"/>
            						<span style="line-height:28px;margin-left:1em;">
            								万元
            						</span>
            					</div>
                          </div>

                        <!--   <div class="space-4"></div>
                          <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">申请期限1： </label>
            			        <div class="col-sm-8">
            						<input  type="text" class="col-sm-3 ztb_add" name="periodMonthStrat"  id="periodMonthStrat"/>
            						<p class="col-sm-1">-</p>
            						<input  type="text" class="col-sm-3 ztb_add" name="periodMonthEnd"  id="periodMonthEnd"/>
            						<span style="line-height:28px;margin-left:1em;">
            								个月
            						</span>
            					</div>
                          </div> -->

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">合作机构： </label>
                             <div class="col-sm-5">
                                 <div class="col-md-12 input-group cooperationTree">
									<input  type="text"  class="form-control " autoField="bankID"   id="cooperationTree"  value="" dataValue="" name="bankName"  readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
				   			 	</div>
                             </div>
                          </div>

                         <%--  <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">客户来源1： </label>
                             <div class="col-sm-5">
                                 <select id="projectSourceList" class="col-md-12 "  name="projectSourceID"  >		
										<option value="">&nbsp;请选择</option>
										<c:forEach items="${projectSourceList}" var="projectSource">
											<option value="${projectSource.dicTypeID}">${projectSource.dicTypeName}</option>
										</c:forEach>
					    		</select>
                             </div>
                          </div> --%>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">经办部门： </label>
                             <div class="col-sm-5">
                                 <div class="col-md-12 input-group allDepartsTree">
										<input  type="text"  class="form-control" autoField="departID"   id="allDepartsTree"  value="" dataValue="" name="departName"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
								</div>
                             </div>
                          </div>

                           <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">经办人： </label>
                              <div class="col-sm-4">
                                  <input type="text" name="createManName" id="createManName"  class="col-xs-10 col-sm-11   validate[maxSize[50]]" />
                              </div>
                          </div>

                          <div class="space-4"></div>
                           <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">受理日期： </label>
            			        <div class="col-sm-9">
            					  <div class="input-group col-sm-4" style="float:left;">
            						<input  type="text" class="form-control date-picker   " name="createDateStart"  id="createDateStart" data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            					   </div>

            					   <p class="col-sm-1" style="line-height:28px;">-</p>
            					   <div class="input-group col-sm-4">
            						<input  type="text" class="form-control date-picker   " name="createDateEnd"  id="createDateEnd" data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            						</div>
            					</div>
                         </div>

                      <form>

                  </div>
                  <div class="modal-footer">
                      <button class="btn btn-primary btn_submit" type="button">
                          <i class="icon-search bigger-110"></i>查询
                      </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                          <i class="icon-remove bigger-110"></i>关闭
                    </button>
      		</div>
       </div>
    </div>
 </div>
