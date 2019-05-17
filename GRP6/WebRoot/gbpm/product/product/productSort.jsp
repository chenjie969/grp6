<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade bs-example-modal-sm" id="sortop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">同级顺序调整</h4>
      </div>
      <div class="modal-body">
      <input type="hidden" id="tableFileIds">
			<label for="OrderContent" >排序字段</label>
			<select class="form-control" id="OrderContent" multiple="multiple" style="height:200px;">
				<c:forEach items="${productList}" var="product">
					<option value="${product.product_ID}">${product.productName}</option>
				</c:forEach>
			</select>
			<div class="space-12">
			</div>
			<div class="row col-sm-offset-1">
					<button class="btn btn-sm btn-warning" id="btn_moveTop"><i class='icon-chevron-up bigger-110'></i>置顶</button>
					<button class="btn btn-sm" id="btn_moveUp"><i class='icon-arrow-up bigger-110'></i>上移</button>
					<button class="btn btn-sm" id="btn_moveDown"><i class='icon-arrow-down bigger-110'></i>下移</button>
					<button class="btn btn-sm btn-warning" id="btn_moveBottom"><i class='icon-chevron-down bigger-110'></i>置底</button>
			</div>

	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default btn_reset"><i class='icon-repeat bigger-110'></i>重置</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
