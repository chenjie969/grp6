<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="addNodeTaskModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加节点任务</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_nodeTask_form">
      	 	<input type="hidden" name="productNodeID" value="${productNode.productNode_ID}"/>
      	 	<input type="hidden" name="productID" value="${productNode.productID}"/>
      	 	<input type="hidden" name="nodeNames" value="${productNode.nodeNames}"/>
      	 	<div class="form-group">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1">节点名称：</label>
				<label class="col-sm-8 " >${productNode.nodeNames}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
					    	<div class="input-group taskmanager_id">
								<input  type="text"  class="form-control validate[required] " autoField="taskMangerID"   id="taskmanager_id"  value="" dataValue="" name="taskName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>操作类型： </label>
				<div class="col-sm-8">
					<div class="radio"  >
						<label>
							<input  name="operationType"  type="radio" class="ace" value="必做" checked/>
							<span class="lbl">必做</span>
						</label>
					   <label>
							<input  name="operationType"  type="radio" class="ace" value="选做" />
							<span class="lbl">选做</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否有前置任务： </label>
				<div class="col-sm-8">
					<div class="radio" id="isBeforeTask" >
						<label>
							<input  name="isBeforeTask"  type="radio" class="ace" value="true" />
							<span class="lbl">是</span>
						</label>
					   <label>
							<input  name="isBeforeTask"  type="radio" class="ace" value="false" checked/>
							<span class="lbl">否</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="form-group" id="beforeTaskID"  style="display:none;">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>前置任务： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
					    	<div class="input-group beforetaskmanager_id">
								<input  type="text"  class="form-control " autoField="beforeTaskID"   id="beforetaskmanager_id"  value="" dataValue="" name="beforeTaskName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>是否有后置任务： </label>
				<div class="col-sm-8">
					<div class="radio" id="isAfterTask" >
						<label>
							<input name="isAfterTask"  type="radio" class="ace" value="true" />
							<span class="lbl">是</span>
						</label>
					   <label>
							<input name="isAfterTask"  type="radio" class="ace" value="false" checked/>
							<span class="lbl">否</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="form-group" id="afterTaskIDList" style="display:none;">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>后置任务： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
					    	<div class="input-group aftertaskmanager_id">
								<input  type="text"  class="form-control " autoField="afterTaskIDList"   id="aftertaskmanager_id"  value="" dataValue="" name="afterTaskNameList" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			<input type="hidden" name="warnMethodNameList" id="warnMethodNameList"/>
			<div class="form-group" id="warnMethodIDList">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">提醒方式： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<select name="warnMethodIDList" class="col-xs-12" id="warnMethod">
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${warnMethodList}" var="warnMethod">
									<option value="${warnMethod.dicTypeID}">${warnMethod.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
			        </div>
				</div>
			</div>
			<input type="hidden" name="operaterTypeName" id="operaterTypeName"/>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>操作者类型：</label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<select name="operaterTypeID" class="col-xs-12 validate[required]" id="operaterTypeID">
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${operaterTypeList}" var="operaterType">
									<option value="${operaterType.dicTypeID}">${operaterType.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
			        </div>
				</div>
			</div>
			<input type="hidden" name="operatorName" id="operatorName"/>
			<div class="form-group" id="operatorIDDiv" style="display:none;">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>操作者：</label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<select name="operatorID" class="col-xs-12 " id="operatorID">
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${rolesList}" var="role">
									<option value="${role.role_uid}">${role.role_name}</option>
								</c:forEach>
							</select>
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
					