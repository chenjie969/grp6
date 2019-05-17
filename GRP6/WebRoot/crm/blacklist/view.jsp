<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="viewBadClient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看黑名单</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   <div class="col-sm-offset-1">
		  	<h5 class="col-sm-12 company">企业名称：<span class="grey ztb_view_clientName"></span></h5>
			<h5 class="col-sm-12 company">客户编号：<span class="grey ztb_view_clientBH"></span></h5>
		  	<h5 class="col-sm-12 company">成立日期：<span class="grey ztb_view_createDate"></span></h5>
		  	<h5 class="col-sm-12 company">注册币别：<span class="grey ztb_view_currencyName"></span></h5>
		  	<h5 class="col-sm-12 company">注册资金：<span class="grey ztb_view_registerSum"></span></h5>
		  	
		  	<h5 class="col-sm-12 person">申请人姓名：<span class="grey ztb_view_personName"></span></h5>
		  	<h5 class="col-sm-12 person">身份证号码：<span class="grey ztb_view_certificateCode"></span></h5>
		  	<h5 class="col-sm-12 person">性别：<span class="grey ztb_view_sex"></span></h5>
		  	<h5 class="col-sm-12 person">年龄：<span class="grey ztb_view_age"></span></h5>
		  	<h5 class="col-sm-12 person">联系方式：<span class="grey ztb_view_phone"></span></h5>
		  	
		  	<h5 class="col-sm-12 person company">机构名称：<span class="grey ztb_view_unit_uidName"></span></h5>
			<h5 class="col-sm-12 person company">拉黑经办部门：<span class="grey ztb_view_operationDepartName"></span></h5>
			<h5 class="col-sm-12 person company">拉黑经办人：<span class="grey ztb_view_operatorName"></span></h5>
			<h5 class="col-sm-12 person company">拉黑日期：<span class="grey ztb_view_operatorDate"></span></h5>
		  	<h5 class="col-sm-12 person company">拉黑原因：<span class="grey ztb_view_operationDescription" style="line-height:26px;"></span></h5>
		   </div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
