<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="singleProjectBill" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">项目票据信息</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
			<h5 class="col-sm-6">项目编号：<span class="grey">${applyDetail.projectCode }</span></h5>
			<h5 class="col-sm-6">项目名称：<span class="grey">${apply.projectName }</span></h5>
			<input type="hidden" id="hidden_applyID" value="${apply.apply_ID }">
			<input type="hidden" id="hidden_applyDetailID" value="${applyDetail.applyDetail_ID }">
			<div class="col-sm-12 ">
				<div class="page-header">
					<button type="button" class="btn btn-sm btn-info" id="btn_addSglProBillInfo">登记票据信息</button>&nbsp;
				</div>
			</div>
			<div class="col-sm-12">
				<div class="table-responsive">
					<table id="table_singleProjectBill" style="font-size:13px !important;"></table>  
				</div>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
  
</div>
					