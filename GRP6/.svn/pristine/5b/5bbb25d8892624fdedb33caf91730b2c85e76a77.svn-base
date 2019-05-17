<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectOver" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <!-- 逾期确认页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">项目信息摘要</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectOver_form" >
						<input type="hidden" id="apply_ID" name="apply_ID" value="${apply.apply_ID}">
					    <input type="hidden" id="project_ID" name="project_ID" value="${project_ID}">
		           		
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
                         
                          
                          
             <h4 class="header smaller lighter blue">
								&nbsp;&nbsp;逾期确认
			</h4>             
           	<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>逾期金额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="overSum"	 id="overSum" value="" />
						<span class="midden col-sm-4" style="line-height:28px;">万元</span>
				</div>
			</div>
           	<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>逾期余额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="overplusSum"	 id="overplusSum" value="" />
						<span class="midden col-sm-4" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="space-2"></div>
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>逾期日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="overDate"	 id="id-date-picker-2" type="text" data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	            </div>
			<div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>	
	        	
			<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-input"> 逾期原因：</label>									   	    
		         	<div class="col-sm-10">
						<textarea class="col-sm-10 limited   validate[maxSize[2000]]" rows="5"  name="overDesc" id="overDesc" ></textarea>							
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
					