<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="materialDetailAdd_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加客户资料</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="materialDetailAdd_form">
      	 
      	 	<input type="hidden" name="materialModel_ID" id="materialModelID" value="${materialTree.materialModel_ID}"/><!--客户资料模板ID -->
      	 	<input type="hidden" name="materialTree_ID" id="materialTree_ID" value="${materialTree.materialTree_ID}"/><!--客户资料类型树ID-->
      	 	<input type="hidden" name="materialTreeName" id="materialTreeName" value="${materialTree.materialTreeName}"/><!--客户资料类型名称-->
      	 	
      	 	<div class="form-group ">
				<label class="col-sm-4  control-label no-padding-right" for="form-field-1">客户资料类型： </label>
				<label class="col-sm-8 " >${materialTree.materialTreeName}</label>
			</div>			
			<div class="form-group ">
				<label class="col-sm-4  control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户资料名称： </label>
				<div class="col-sm-8 ">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="materialName" id="materialName" class="col-xs-12  validate[required,maxSize[50]]" />
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>资料类型： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<select name="materialType" class=" col-xs-10 validate[required]" id="materialType">
								<option value="">&nbsp;请选择</option>
								<option value="原件">原件</option>
								<option value="复印件">复印件</option>
								<option value="原件&复印件">原件&复印件</option>
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
					