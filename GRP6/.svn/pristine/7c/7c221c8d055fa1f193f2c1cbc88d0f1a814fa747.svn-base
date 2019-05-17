<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editCostInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改水电气费缴纳情况</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="edit_costInfo_form">
      	 	<input type="hidden" name="costInfo_ID" value="${costInfo.costInfo_ID }">
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>年月： </label>
				<div class="col-sm-9 col-xs-12" style="left:15px;">
					<div class="row">
					    <div class="col-xs-4 input-group">
							<input class="form-control date-picker   validate[required]" type="text" id="date-pickerEditCost" data-date-format="yyyy-mm" name="yearMonth" readonly="readonly" value="${costInfo.yearMonth}"/>
							<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>电费： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="electricCost" class="col-xs-6 validate[required,maxSize[18],custom[number]]" value="${costInfo.electricCost }"/>
							<span class="col-xs-4" style="line-height:28px;">万元</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>水费： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="waterCost" class="col-xs-6 validate[required,maxSize[18],custom[number]]" value="${costInfo.waterCost }"/>
							<span class="col-xs-4" style="line-height:28px;">万元</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>其他费用： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="otherCost" class="col-xs-6 validate[required,maxSize[18],custom[number]]" value="${costInfo.otherCost }"/>
							<span class="col-xs-4" style="line-height:28px;">万元</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-12 validate[maxSize[100]]"   name="remark" rows="5"></textarea>
							<div class="col-xs-12 no-padding-right">
								<span class="light-grey" style="float:right">限制100个字符</span>
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
					