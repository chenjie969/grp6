<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="announceAdQuery" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">高级查询</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="query_annouce_form">
			<div class="form-group col-sm-12">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">标题： </label>
				<div class="col-sm-9">
					<div class="row">
					    <div class="col-sm-10">
							<input type="text" name="titleName" class="col-sm-12" id="add_titilName"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">发布人： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group  select_CreateName">
								<input  type="text"  class="form-control"  autoField="createUserId"  id="select_CreateName"  name="createUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		<!-- <div class="form-group col-sm-12">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">审批流程： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<select class="col-sm-12 select_apprvalProcess  btn_ztb_select validate[required]"  name="apprvalProcess" class_name="ztb_add_apprvalProcess" id="select_apprvalProcess">
								<option value="一级审核">一级审核</option>
								<option value="不需要审核">不需要审核</option>
							</select>
						</div>
					</div>
				</div>
			</div> -->
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input">发布日期： </label>
		        <div class="col-sm-9">
					<div class="row">
						<div class="col-sm-4 no-padding-right">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" name="createDateStart" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<span class="midden col-sm-1" style="line-height:28px;"> - </span>
						<div class="col-sm-4 no-padding-left">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" name="createDateEnd" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
		 </form>
      </div>
     
      <div class="modal-footer ">
      	<button type="button" class="btn btn-primary btn_submit" > <i class='icon-search bigger-110'></i>查询</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

					