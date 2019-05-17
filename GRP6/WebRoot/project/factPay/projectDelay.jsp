<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectDelay" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <!--   展期登记页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">项目信息摘要</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectDelay_form" >
						<input type="hidden" id="apply_ID" name="applyID" value="${apply.apply_ID}">
				    	<input type="hidden" id="project_ID" name="project_ID" value="${project_ID}">			
				    	<input type="hidden" id="delayState" name="delayState" value="待审批">			
           				
           				<div class="form-group ">
                              <label class="col-sm-2 control-label no-padding-right">项目名称：</label>
                              <label class="col-sm-10 grey">
                                     	  ${apply.projectName}
                              </label>
                          </div> 

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">业务编号： </label>
                              <label class="col-sm-10 grey">
                                	  ${apply.busiCode}  
                              </label>
                          </div>
                         <%--  <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">业务性质： </label>
                              <label class="col-sm-8 grey">
                                 	  ${applyDetail.busiNatureName}新增业务
                              </label>
                          </div>
                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">项目类型： </label>
                              <label class="col-sm-8 grey">
                                 	  ${applyDetail.projectTypeName}中小企业项目
                              </label>
                          </div>

                          <div class="form-group ">
                              <label class="col-sm-2 control-label no-padding-right">客户类型： </label>
                              <label class="col-sm-10 grey">
                                     	  ${apply.clientName}
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">客户名称： </label>
                              <label class="col-sm-10 grey">
                                	 ${applyDetail.clientName} 北京新发地丰源食用菌商行
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">项目名称： </label>
                              <label class="col-sm-10 grey">
                               	   ${applyDetail.projectName}北京新发地丰源食用菌商行
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">项目来源： </label>
                              <label class="col-sm-10 grey">
                                 	${applyDetail.projectSourceName}公司自接
                              </label>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">来源说明： </label>
                              <label class="col-sm-10 grey">
 									${applyDetail.sourceDesc}	公司自接项目
                              </label>
                          </div>

                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">业务品种： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.busiTypeName}其他融资性担保	 
                              </label>
                          </div>
                          <div class="form-group col-sm-6 ">
                              <label class="col-sm-4 control-label no-padding-right">绿色通道： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.greenChannelName}	 瞪羚计划
                              </label>
                          </div>
                          <div class="form-group col-sm-6" >
                              <label class="col-sm-4 control-label no-padding-right">申请金额： </label>
                              <label class="col-sm-8 grey">
									<fmt:formatNumber value="5000" pattern="###,###.######"> </fmt:formatNumber>
									  &nbsp;万元
                              </label>
                          </div>
                          <div class="form-group col-sm-6">
                              <label class="col-sm-4 control-label no-padding-right">申请期限： </label>
                              <label class="col-sm-8 grey">
									${applyDetail.periodMonthDay}	12 个月	  
                              </label>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 control-label no-padding-right">合作机构： </label>
                              <label class="col-sm-10 grey">
									${applyDetail.bankName}	 建设银行永安里支行
                              </label>
                          </div>
                           --%>
                          
             <h4 class="header smaller lighter blue">
								&nbsp;&nbsp;展期登记
			</h4>             
           	<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期金额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="delaySum"	 id="delaySum" value="" />
						<span class="midden col-sm-4" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>	
			<div class="space-2"></div>
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期起始日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="delayBeginDate"	 id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	            </div>
			<div class="space-2"></div>
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期结束日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="delayEndDate"	 id="id-date-picker-2" type="text" data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	            </div>
	        
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期后担保费率： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="delayRate"	 id="delayRate" value="" />
						<span class="midden col-sm-4" style="line-height:28px;">%</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">展期后融资服务费率： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="delayServiceRate"	 id="delayServiceRate" value="" />
						<span class="midden col-sm-4" style="line-height:28px;">‰</span>
				</div>
			</div>
			 <div class="form-group col-sm-6">
				 <label class="col-md-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>展期期限： </label>
				 <div class="col-md-8">
	                 <div class="col-md-12 no-padding-left">
	                  <input type="text" id="delayMonth" class="validate[required,maxSize[6],custom[integer]]" name="delayMonth"  style="width:4em;" />
	                   &nbsp;个月&nbsp;
	                  <input type="text" id="delayDay" class="validate[required,maxSize[6],custom[integer]]" name="delayDay" value="0" style="width:4em;" />
	                   &nbsp;天&nbsp;
	                 </div>
              	 </div>
			</div>     
			<div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>				
			<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-input">展期原因：</label>									   	    
		         	<div class="col-sm-10">
						<textarea class="col-sm-10 limited   validate[maxSize[2000]]" rows="5"  name="delayReason" id="delayReason" ></textarea>							
					    <span class="col-sm-4 light-grey col-sm-push-8">限制输入字数2000个</span>
					</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					