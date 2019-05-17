<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="editTaskManager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改任务事项</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="edit_taskManager_form">
      	 	<input type="hidden" name="taskManager_ID" id="edit_taskManagerID">
			<div class="form-group">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项类型： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
					    	<div class="input-group tasktype_id">
								<input  type="text"  class="form-control validate[required] " autoField="taskType_ID"   id="tasktype_id"  value="${taskManager.taskTypeName}" dataValue="${taskManager.taskType_ID}" name="taskTypeName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>人工任务/系统任务： </label>
				<div class="col-sm-8">
					<div class="radio"  >
						<label>
							<input  name="isPersonTask"  type="radio" class="ace" value="true" <c:if test="${taskManager.isPersonTask}">checked</c:if> />
							<span class="lbl">人工任务</span>
						</label>
					   <label>
							<input  name="isPersonTask"  type="radio" class="ace" value="false" <c:if test="${!taskManager.isPersonTask}">checked</c:if>/>
							<span class="lbl">系统任务</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项编号： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="taskCode" class="col-xs-4 validate[required,maxSize[4]]" id="add_taskCode" value="${taskManager.taskCode }"/>
							<span class="col-xs-8" style="line-height:28px;">（限制输入4个字符）</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项名称： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="taskName" class="col-xs-12 validate[required,maxSize[50]]" id="add_taskName" value="${taskManager.taskName}"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项查看URL： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="viewTaskUrl" class="col-xs-12 validate[required,maxSize[100]]" value="${taskManager.viewTaskUrl}"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项办理URL： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="taskUrl" class="col-xs-12 validate[required,maxSize[100]]" value="${taskManager.taskUrl}"/>
						</div>
			        </div>
				</div>
			</div>
			
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<%-- <input type="text" name="taskUrl" class="col-xs-12 validate[required,maxSize[100]]" value="${taskManager.taskUrl }"/> --%>
							<%-- <textarea class="col-xs-10 col-sm-8 ztb_add_clientSourceDesc ztb_add validate[maxSize[250]]" style="width: 285px;height: 100px;" name="remark" >
								${taskManager.remark }
							</textarea> --%>
							
							<textarea class="col-xs-12 validate[maxSize[250]]"   name="remark" rows="5">${taskManager.remark}</textarea>
							<div class="col-xs-12 no-padding-right">
								<span class="light-grey" style="float:right">限制250个字符</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					