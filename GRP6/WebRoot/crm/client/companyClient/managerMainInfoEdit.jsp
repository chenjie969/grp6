<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="managerMainInfoEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改股东背景及主要管理人员分析</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_managerMainInfoEdit">
				<input type="hidden" name="client_ID" class="ztb_edit_client_ID" >
				<input type="hidden" name="managerinfoId" class="ztb_edit_managerinfoId">
			
				<div class="form-group edit_stockinfo legalpersoninfo" name="legalpersoninfo">
					<label class="col-sm-12 "> 法定代表人及其配偶情况： </label>
					<div class="col-sm-12">
						<textarea  class="col-xs-10 col-sm-12 ztb_edit_legalpersoninfo ztb_edit validate[maxSize[2000]]"  name="legalpersoninfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				
				<div class="form-group edit_stockinfo otherstockinfo" name="otherstockinfo">
					<label class="col-sm-12" for="form-field-2"> 其他股东情况： </label>
					<div class="col-sm-12">
						<textarea class="col-xs-10 col-sm-12 ztb_edit_otherstockinfo ztb_edit validate[maxSize[2000]]"  name="otherstockinfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				
				<div class="form-group edit_stockinfo controlpersoninfo" name="controlpersoninfo">
					<label class="col-sm-12 " for="form-field-2"> 实际控制人及其配偶情况（包含从业经历）： </label>
					<div class="col-sm-12">
						<textarea class="col-xs-10 col-sm-12 ztb_edit_controlpersoninfo ztb_edit validate[maxSize[2000]]"  name="controlpersoninfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				
				<div class="form-group edit_stockinfo managerinfo" name="managerinfo">
					<label class="col-sm-12  " for="form-field-2"> 公司主要高管人员情况： </label>
					<div class="col-sm-12">
						<textarea class="col-xs-12 col-sm-12 ztb_edit_managerinfo ztb_edit validate[maxSize[2000]]"  name="managerinfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				
				<div class="form-group edit_stockinfo employeeinfo" name="employeeinfo">
					<label class="col-sm-12   " for="form-field-2"> 公司员工概况： </label>
					<div class="col-sm-12">
						<textarea class="col-xs-12 col-sm-12 ztb_edit_employeeinfo ztb_edit validate[maxSize[2000]]"  name="employeeinfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				
				
				
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				