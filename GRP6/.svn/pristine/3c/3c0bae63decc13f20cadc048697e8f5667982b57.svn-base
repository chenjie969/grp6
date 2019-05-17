<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="backNodeTaskModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">退回指定环节</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="backNodeTaskForm">
				<input type="hidden" name="productInstance_ID" id="productInstanceID_back" >
				<input type="hidden" name="returnBeforeNodeID" id="returnBeforeNodeID" >
				<input type="hidden" name="finishTaskIDS" id="finishTaskIDS" >
                <div class="form-group" >
					<label class="col-sm-3  control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>退回环节： </label>
					<div class="col-sm-9">
						<div class="row">
						    <div class="col-xs-10">
								<select name="returnAfterNodeID" class="col-xs-8 validate[required]" id="finishNodeList">
									<option value="">&nbsp;请选择</option>
									<c:forEach items="${finishNodeList}" var="finishNode">
										<option value="${finishNode.finishNode_ID}">${finishNode.nodeNames}</option>
									</c:forEach>
								</select>
							</div>
				        </div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退回规则： </label>
					<div class="col-sm-9">
						<div class="radio">
							<label>
								<input  name="returnType"  type="radio" class="ace" value="01" checked />
								<span class="lbl">修改后直接返回当前环节</span>
							</label>
						   <label>
								<input  name="returnType"  type="radio" class="ace" value="02"/>
								<span class="lbl">修改后重走流程</span>
							</label>                                    
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退回原因： </label>
					<div class="col-sm-9">
						<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-10 validate[required,maxSize[250]]"   name="returnDesc" rows="3"></textarea>
							<div class="col-xs-10 no-padding-right">
								<span class="light-grey" style="float:right">限制250个字符</span>
							</div>
						</div>
					</div>
					</div>
				</div>
				<div class="form-group" >
					<label class="col-sm-4   no-padding-right" for="form-field-1">选择任务事项</label>
					<div class="table-responsive col-sm-12">
						<table id="finishTask-table" style="font-size:13px !important;"></table>
                	</div>
				</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
