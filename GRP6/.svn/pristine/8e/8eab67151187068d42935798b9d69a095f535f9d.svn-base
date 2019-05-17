<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addProductNodeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加流程节点</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_productNode_form">
      	 	<input type="hidden" name="productID" value="${product.product_ID }"/>
      	 	<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1">流程名称： </label>
				<label class="col-sm-8 ">${product.productName}</label>
			</div>
			<input type="hidden" id="nodeNames" name="nodeNames" >
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>产品节点： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group nodeid">
								<input  type="text"  class="form-control validate[required] " autoField="nodeID"   id="nodeid"  value="" dataValue="" name="nodeNames" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">任务事项指派规则： </label>
				<div class="col-sm-8">
					<div class="radio" id="" >
						<label>
							<input  name="isAutoAssign"  type="radio" class="ace" value="true" checked/>
							<span class="lbl">系统自动分配</span>
						</label>
					   <label>
							<input  name="isAutoAssign"  type="radio" class="ace" value="false" />
							<span class="lbl">人工派发</span>
						</label>                                    
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