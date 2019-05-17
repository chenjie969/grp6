<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ include file="/common_timestamp.jsp" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script>
 <div class="modal fade" id="creditApplyAdQuery" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">高级查询</h4>
                  </div>
                  <div class="modal-body">

                <form class="form-horizontal" role="form" id="form_creditApplyAdQuery">
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信编号： </label>
                              <div class="col-sm-8">
                                  <input type="text" name=busiCode class="col-xs-10 col-sm-11 " />
                              </div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信项目名称： </label>
                              <div class="col-sm-8">
                                  <input type="text" name="projectName" class="col-xs-10 col-sm-11 ztb_add_mod_name ztb_add validate[maxSize[50]]" />
                              </div>
                          </div>
                          
                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">授信项目类型： </label>
                             <div class="col-sm-5">
                                  <select id="busiNatureList" class="selectList  col-sm-12 "  name="creditTypeID"  >		
										<option value="">&nbsp;请选择</option>
										<c:forEach items="${creditTypeList}" var="creditType">
											<option value="${creditType.dicTypeID}">${creditType.dicTypeName}</option>
										</c:forEach>
			    				  </select>
                             </div>
                          </div>

						  <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">客户名称： </label>
                              <div class="col-sm-8">
                                  <input type="text" name="clientName" class="col-xs-10 col-sm-11  ztb_add validate[maxSize[50]]" />
                              </div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">授信客户类型： </label>
                             <div class="col-sm-5">
                              		 <select class="selectList  col-sm-12 "  name="clientTypeID" >  		
											<option value="">&nbsp;请选择</option>                                    
											<option value="01">企业客户</option>
											<option value="02">集团/关联客户</option>
					 				 </select>
                             </div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">授信申请金额： </label>
            			        <div class="col-sm-8">
            						<input  type="text" class="col-sm-3 ztb_add validate[custom[number],maxSize[18]]" name="applySumLow"/>
            						<p class="col-sm-1">-</p>
            						<input  type="text" class="col-sm-3 ztb_add validate[custom[number],maxSize[18]]" name="applySumHigh"/>
            						<span style="line-height:28px;margin-left:1em;">
            								万元
            						</span>
            					</div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">授信起始日期： </label>
            			       	 <div class="col-sm-9">
            					  <div class="input-group col-sm-4" style="float:left;">
            						<input  type="text" class="form-control date-picker validate[custom[date]]  " name="creditBeginDateLow"  data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            					   </div>

            					   <p class="col-sm-1" style="line-height:28px;">-</p>
            					   <div class="input-group col-sm-4">
            						<input  type="text" class="form-control date-picker validate[custom[date]]  " name="creditBeginDateHigh"  data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            						</div>
            					</div>
                          </div>
                          
                          <div class="space-4"></div>
                          <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">授信结束日期： </label>
            			       	 <div class="col-sm-9">
            					  <div class="input-group col-sm-4" style="float:left;">
            						<input  type="text" class="form-control date-picker validate[custom[date]]  " name="creditEndDateLow" data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            					   </div>

            					   <p class="col-sm-1" style="line-height:28px;">-</p>
            					   <div class="input-group col-sm-4">
            						<input  type="text" class="form-control date-picker validate[custom[date]]  " name="creditEndDateHigh" data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            						</div>
            					</div>
                          </div>
	
						<!--  列表中暂无法显示 业务品种 与 合作机构这两项, 高级查询中暂时也不查询这两项
								这两项需要联合查询pro_applyDetail表, 目前sql无法满足
						<div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">业务品种： </label>
                             <div class="col-sm-5">
                                <div class="col-sm-12 input-group selectBusiType">
									<input  type="text"  class="form-control " autoField="busiTypeID"   id="selectBusiType"  value="" dataValue="" name="busiTypeName"  readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
				    		    </div>
                             </div>	
                          </div>
                          
                          <div class="space-4"></div>
                          <div class="form-group">
                             <label class="col-sm-3 control-label no-padding-right" for="form-input">合作机构： </label>
                             <div class="col-sm-5">
                                 <div class="col-sm-12 input-group selectBank">
									<input  type="text"  class="form-control " autoField="bankID"   id="selectBank"  value="" dataValue="" name="bankName"  readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
				   			 	</div>
                             </div>
                          </div> -->
							
							<div class="space-4"></div>
                           <div class="form-group">
            				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">受理日期： </label>
            			        <div class="col-sm-9">
            					  <div class="input-group col-sm-4" style="float:left;">
            						<input  type="text" class="form-control date-picker validate[custom[date]]  " name="createDateStart"  id="createDateStart" data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            					   </div>

            					   <p class="col-sm-1" style="line-height:28px;">-</p>
            					   <div class="input-group col-sm-4">
            						<input  type="text" class="form-control date-picker validate[custom[date]]  " name="createDateEnd"  id="createDateEnd" data-date-format="yyyy-mm-dd" />
            						<span class="input-group-addon">
            							<i class="icon-calendar bigger-110"></i>
            						</span>
            						</div>
            					</div>
                         </div>
							
                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">经办部门： </label>
                             <div class="col-sm-5">
                                 <div class="col-sm-12 input-group selectCreateDepart">
										<input  type="text"  class="form-control" autoField="departID"   id="selectCreateDepart"  value="" dataValue="" name="departName"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
								</div>
                             </div>
                          </div>

                           <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">经办人： </label>
                              <div class="col-sm-5">
                                  <input type="text" name="createManName" class="col-xs-10 col-sm-11   validate[maxSize[50]]" />
                              </div>
                          </div>

						 <div class="form-group col-sm-12 col-xs-12" style="height:80px"></div>
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
