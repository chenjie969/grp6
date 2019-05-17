<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectReplace" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <!-- 项目移交页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">项目移交</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectReplaceEdit_form" >
			        	 <input type="hidden" id="apply_ID" name="apply_ID" value="${apply.apply_ID}">
					     <input type="hidden" id="project_ID" name="project_ID" value="${project.project_ID}">
					     <input type="hidden" id="project_ID" name="applyDetail_ID" value="${detail.applyDetail_ID}">
					     
	        <div class="form-group col-sm-6 ">
			   <label class="col-sm-4 control-label no-padding-right" for="form-field-1">原项目经理A角： </label>
				<div class="col-sm-8">
					<div class="  input-group oldAmanNameTree col-sm-12" >
						<span class="form-control col-sm-12" >${project.beforeAManName}</span>
						<input type="hidden" class="form-control col-sm-12" id = "oldAmanName" value="${project.beforeAManName}"  name="oldAmanName"  >
						<input type="hidden"  id = "oldAmanId" name="oldAmanId" value="${project.beforeAManID}" >
				    </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">原项目经理B角： </label>
				<div class="col-sm-8">
					<div class="  input-group  col-sm-12 oldBmanNameTree">
						<%-- <input type="text" class="form-control col-sm-12" id = "oldBmanName" name="oldBmanName" value="${project.beforeBManName}" disabled="disabled"> --%>
						<span class="form-control col-sm-12" >${project.beforeBManName}</span>
						<input type="hidden" class="form-control col-sm-12" id = "oldBmanName" name="oldBmanName" value="${project.beforeBManName}" >
						<input type="hidden"  id = "oldBmanId"  name="oldBmanId" value="${project.beforeBManID}" >
				    </div>
				</div>
			</div>
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>新项目经理A角： </label>
				<div class="col-sm-8">
					<div class="  input-group newAmanNameTree col-sm-12 ">
						<input  type="text"  class="form-control col-sm-12  validate[required] " autoField="newAmanId" style="line-height:28px;"  id="newAmanNameTree" value="${project.amanName}" dataValue="${project.amanID}" name="newAmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
					</div>
			    </div>
			</div> 
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>新项目经理B角： </label>
				<div class="col-sm-8">
					<div class="  input-group newBmanNameTree col-sm-12">
						<input  type="text"  class="form-control col-sm-12  validate[required]" autoField="newBmanId" style="line-height:28px;"  id="newBmanNameTree" value="${project.bmanName}" dataValue="${project.bmanID}" name="newBmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>
		 	<%-- <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">原C角： </label>
				<div class="col-sm-6">
					<div class="  input-group col-sm-5 oldCmanNameTree">
						<input  type="text"  class="form-control col-sm-5" autoField="oldCmanId" style="line-height:28px;"  id="oldCmanNameTree" value="${project.amanName}" dataValue="${project.amanID}" name="oldCmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">新C角： </label>
				<div class="col-sm-6">
					<div class="  input-group newCmanNameTree col-sm-5">
						<input  type="text"  class="form-control col-sm-5" autoField="newCmanId" style="line-height:28px;"  id="newCmanNameTree" value="${project.amanName}" dataValue="${project.amanID}" name="newCmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>   --%>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">移交办理人： </label>
				<div class="col-sm-8">
					<div class="  input-group changeManTree col-sm-12">
						<input  type="text"  class="form-control col-sm-12" autoField="changeManId" style="line-height:28px;"  id="changeManTree" value="${user.user_name}" dataValue="${user.user_uid}" name="changeManName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>移交日期： </label>
	         	<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-12">
							<div class="input-group">
								<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name=changeDateTime	 id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
            </div>
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>移交原因： </label>
				<textarea class="col-sm-10 col-sm-offset-1 validate[required,maxSize[2000]]" rows="8" cols="80" name="changeReason" id="changeReason"></textarea>
			</div>
			<div class="form-group"></div>
				
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					