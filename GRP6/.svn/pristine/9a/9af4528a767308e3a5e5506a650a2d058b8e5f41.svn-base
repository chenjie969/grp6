<%@ include file="/common_timestamp.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectDelayEditPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改展期登记</h4>
      </div>
      <!--   展期登记修改页面 -->
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectDelayEdit_form" >
				<input type="hidden" id="delay_ID" name="delay_ID" value="${delay.delay_ID}">
				<input type="hidden" id="apply_ID" name="applyID" value="${delay.applyID}">
		    	<input type="hidden" id="project_ID" name="project_ID" value="${delay.project_ID}">	
		    	<input type="hidden" id="delayState" name="delayState" value="已审批">			
           	<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期金额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="delaySum"	 id="delaySum" value="<fmt:formatNumber value="${delay.delaySum}" pattern="###.######"/>"/>
						<span class="midden col-sm-4" style="line-height:28px;">万元</span>
				</div>
			</div>
			<!-- <div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div> -->	
			<div class="space-2"></div>
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上报日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="delayBeginDate" type="text" value="<fmt:formatDate value="${delay.delayBeginDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>" data-date-format="yyyy-mm-dd" />
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
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期起始日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="factBeginDate" type="text" value="<fmt:formatDate value="${delay.factBeginDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>" data-date-format="yyyy-mm-dd" />
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
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="delayEndDate" type="text" value="<fmt:formatDate value="${delay.delayEndDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>" data-date-format="yyyy-mm-dd" />
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
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="delayRate"	 id="delayRate" value="${delay.delayRate}" />
						<span class="midden col-sm-4" style="line-height:28px;">%</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">展期后融资服务费率： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="delayServiceRate"	 id="delayServiceRate" value="${delay.delayServiceRate}" />
						<span class="midden col-sm-4" style="line-height:28px;">‰</span>
				</div>
			</div>
			 <div class="form-group col-sm-6">
				 <label class="col-md-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>展期期限： </label>
				 <div class="col-md-8">
	                 <div class="col-md-12 no-padding-left">
	                  <input type="text" id="delayMonth" class="validate[required,maxSize[6],custom[integer]]" name="delayMonth" value="${delay.delayMonth}" style="width:4em;" />
	                   &nbsp;个月&nbsp;
	                  <input type="text" id="delayDay" class="validate[required,maxSize[6],custom[integer]]" name="delayDay" value="${delay.delayDay}" style="width:4em;" />
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
						<textarea class="col-sm-10 limited   validate[maxSize[2000]]" rows="5"  name="delayReason" id="delayReason" >${delay.delayReason}</textarea>							
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
					