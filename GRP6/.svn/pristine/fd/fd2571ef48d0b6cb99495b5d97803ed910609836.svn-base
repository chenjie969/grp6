<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="selectProductModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">同意立项</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="selectProductForm">
				<input type="hidden" name="userID" id="userID" value="${sessionUser.user_uid}">
				<input type="hidden" name="userName" id="userName" value="${sessionUser.user_name}">
				<h5 style="margin-left:2em;">项目名称：
					<span  class="grey sProjectName" ></span>
				</h5>
				<div class="table-responsive"   id="loadinfo">
                     <table id="product-table" style="font-size:13px !important;"></table>  
                </div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_nextStep" > <i class='icon-arrow-right bigger-110'></i>下一步</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					