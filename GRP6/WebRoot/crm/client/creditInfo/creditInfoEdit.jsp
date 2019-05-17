<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="creditInfoEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改信用信息及银企往来情况</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="creditInfoEdit_form">
				<input type="hidden" name="creditInfo_ID">
				<input type="hidden" name="client_ID">
				<div class="form-group edit_bankCreditInfo">
					<label class="col-xs-12">申请人及其关联公司在银行授信及使用情况： </label>
					<div class="col-xs-12">
						<textarea class="col-xs-12 validate[maxSize[2000]]"   name="bankCreditInfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				<div class="form-group edit_creditResult">
					<label class="col-xs-12">人民银行信贷征信系统查询结果： </label>
					<div class="col-xs-12">
						<textarea class="col-xs-12 validate[maxSize[2000]]"   name="creditResult" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				<div class="form-group edit_lawsuitInfo">
					<label class="col-xs-12">申请人及其关联人、关联企业是否涉及诉讼、仲裁及执行情况等法律文件： </label>
					<div class="col-xs-12">
						<textarea class="col-xs-12 validate[maxSize[2000]]"   name="lawsuitInfo" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				<div class="form-group edit_marketMessage">
					<label class="col-xs-12">市场软消息（同行业评价、银行评价、周边熟悉人评价等）： </label>
					<div class="col-xs-12">
						<textarea class="col-xs-12 validate[maxSize[2000]]"   name="marketMessage" rows="20"></textarea>
						<div class="col-xs-12 no-padding-right">
							<span class="light-grey" style="float:right">限制2000个字符</span>
						</div>
					</div>
				</div>
				<div class="form-group edit_historicalCreditRecord">
					<h5 class="col-xs-12">申请人的历史信用记录：</h5>
					<br>
					<div class="row">
						<label class="col-sm-2 control-label no-padding-right">未结清贷款余额： </label>
						<div class="col-sm-10">
							<input type="text" class="col-sm-3 validate[maxSize[18],custom[number]]" maxlength="18" name="loanBalance">
							<span class="midden col-sm-7" style="line-height:28px;">万元</span>
						</div>
					</div>
					<br>
					<div class="row">
						<label class="col-sm-2 control-label no-padding-right">对外担保余额： </label>
						<div class="col-sm-10">
							<input type="text" class="col-sm-3 validate[maxSize[18],custom[number]]" maxlength="18" name="garantySum">
							<span class="midden col-sm-7" style="line-height:28px;">万元</span>
						</div>
					</div>
					<br>
					<div class="row">
						<label class="col-sm-2 control-label no-padding-right">其它重要事项： </label>
						<div class="col-sm-10">
							<textarea class="col-sm-11 validate[maxSize[2000]]" name="otherDesc" rows="20"></textarea>
							<div class="col-sm-11 no-padding-right">
								<span class="light-grey" style="float:right">限制2000个字符</span>
							</div>
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
				