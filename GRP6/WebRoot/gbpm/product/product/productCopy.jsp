<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="copyOneProductModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">复制产品流程</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="copy_productForm">
      	 	<input type="hidden" name="product_ID"  value="${product.product_ID}">
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>产品流程名称： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="productName" id="copy_productName" class="col-xs-12 validate[required,maxSize[50]]" value="${product.productName}"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>版本号： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="version" class="col-xs-12 validate[required,maxSize[5]]" value="${product.version}" />
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>产品流程状态： </label>
				<div class="col-sm-8">
					<div class="radio" id="" >
						<label>
							<input  name="isUsed"  type="radio" class="ace" value="true" <c:if test="${product.isUsed}">checked</c:if> />
							<span class="lbl">启用</span>
						</label>
					   <label>
							<input  name="isUsed"  type="radio" class="ace" value="false" <c:if test="${!product.isUsed}">checked</c:if> />
							<span class="lbl">禁用</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>产品流程类型： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
					    	<input type="hidden" id="productTypeName"  name="productTypeName" >
							<select name="productTypeID" class="selectList col-xs-10 validate[required]" id="productTypeList">
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${productTypeList}" var="productType">
									<option value="${productType.dicTypeID}"  <c:if test="${productType.dicTypeID == product.productTypeID}">selected="selected"</c:if> >${productType.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-4 col-xs-12 control-label no-padding-right"  for="form-field-1" >备注： </label>
				<div class="col-sm-8 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-12 validate[maxSize[250]]"   name="remark" rows="5">${product.remark}</textarea>
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
					