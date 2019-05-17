<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="modal fade bs-example-modal-sm" id="addLawsuitModal"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">项目诉讼登记</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="addLawsuit_Form">
					<input type="hidden" name="project_ID" id="project_ID"
						value="${LawSuit.project_ID}" />
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>案号：
						</label>
						<div class="col-sm-8">
							<input type="text" name="recordNum" id="recordNum"
								class=" col-sm-10 ztb_add validate[required,maxSize[25]]" />
							
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>原告： </label>
						<div class="col-sm-8">
							<input type="text" name="plaintiff" id="plaintiff"
								class=" col-sm-10 ztb_add validate[required,maxSize[50]]" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>被告： </label>
						<div class="col-sm-8">
							<input type="text" name="defendant" id="defendant"
								class=" col-sm-10 ztb_add validate[required,maxSize[50]]" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>涉诉金额： </label>
						<div class="col-sm-8">
							<input type="text" name="lawsuitSum" id="lawsuitSum"
								class=" col-sm-10 ztb_add validate[required,custom[number],maxSize[18]]" />万元
						</div>
					</div>
					
					
						<div class="form-group ">
						<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>起诉时间： </label>
						<div class="col-sm-10">
							<div class="input-group col-sm-4" style="float: left;">
							<input class="form-control date-picker validate[required,custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="lawsuitDate" 
										value="<fmt:formatDate value='${LawSuit.lawsuitDate}' pattern='yyyy-MM-dd' type='date'/>"/>													
								
									 <span class="input-group-addon">
									
									 <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-2 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>管辖法院： </label>
						<div class="col-sm-8">
							<input type="text" name="lawCourt" id="lawCourt"
								class=" col-sm-12 ztb_add validate[required,maxSize[100]]" />
						</div>
					</div>

					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label no-padding-right"
							for="form-input">案件进展： </label>
						<div class="col-sm-10">
							<textarea
								class="col-sm-10 limited  ztb_edit_dynamicContent validate[maxSize[2000]]"
								rows="5" name="caseInfo" id="caseInfo"></textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制2000个字符</span>
							</div>
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label no-padding-right"
							for="form-input">财产保全情况： </label>
						<div class="col-sm-10">
							<textarea
								class="col-sm-10 limited  ztb_edit_dynamicContent validate[maxSize[2000]]"
								rows="5" name="propertyInfo" id="propertyInfo"></textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制2000个字符</span>
							</div>
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-ok bigger-110'></i>保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
