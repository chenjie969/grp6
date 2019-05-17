<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="editDicNode" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改节点</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="edit_dicNode_form">
      	 	<input type="hidden" name="node_ID" id="edit_dicNodeID">
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>节点名称： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="nodeNames" class="col-xs-12 validate[required,maxSize[100]]" id="add_nodeName" value="${dicNode.nodeNames }"/>
							<span class="col-xs-8" style="line-height:28px;"></span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>任务事项编号： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="nodeCode" class="col-xs-4 validate[required,maxSize[3]]" id="add_nodeCode" value="${dicNode.nodeCode }"/>
							<span class="col-xs-8" style="line-height:28px;">（限制输入3个字符）</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"></i>备注： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
					    	<%-- <textarea class="col-xs-10 col-sm-8 ztb_add_clientSourceDesc ztb_add validate[maxSize[250]]" style="width: 237px;height: 100px;" name="remark" id="add_remark" >
					    	${dicNode.remark }
					    	</textarea> --%>
					    	<textarea class="col-xs-12 validate[maxSize[250]]"   name="remark" id="add_remark" rows="5">${dicNode.remark }</textarea>
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
					