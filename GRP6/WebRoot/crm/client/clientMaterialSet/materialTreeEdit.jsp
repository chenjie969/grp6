<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="materialTreeEdit_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改客户资料类型</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="materialTreeEdit_form">
      	 	
      	     <input type="hidden" name="materialTree_ID" id="materialTree_ID" value="${materialTree.materialTree_ID}"/><!-- 客户资料类型树ID -->
      	     <input type="hidden" name="pmaterialTree_ID" id="pmaterialTree_ID" value="${materialTree.pmaterialTree_ID}"/><!-- 父客户资料类型树ID -->
      	 	 <%-- <div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1">上级客户资料类型： </label>
				<label class="col-sm-8 " >${materialTree.pmaterialTreeName}</label>
			</div> --%>			
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户资料类型： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" class="col-xs-12  validate[required,maxSize[50]]" name="materialTreeName" id="materialTreeName"  value="${materialTree.materialTreeName}"/>
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
					