<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addLoanRec" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增贷款银行</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_loanRec_form">
      	 	<input type="hidden" name="client_ID">
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>贷款银行： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<input type="text" name="loanBank" class="col-sm-12 validate[required,maxSize[25]]"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>贷款金额： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<input type="text" name="loanSum" class="col-xs-6 validate[required,maxSize[18],custom[number]]"/>
							<span class="col-xs-4" style="line-height:28px;">万元</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>贷款期限： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<input type="text" name="period" class="col-sm-12 validate[required,maxSize[25]]"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>起止日期： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
						<div class="col-xs-5 no-padding-right">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="beginDate">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<span class="midden col-xs-1" style="line-height:28px;"> - </span>
						<div class="col-xs-5 no-padding-left">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="endDate">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">担保方式： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<textarea class="col-xs-12 validate[maxSize[100]]" name="guarantyType" rows="5"></textarea>
							<div class="col-xs-12 no-padding-right">
								<span class="light-grey" style="float:right">限制100个字符</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
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
					