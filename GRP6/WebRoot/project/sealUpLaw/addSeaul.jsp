<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="modal fade bs-example-modal-sm" id="addSeaulModal"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">资产查封登记</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="addSeaul_Form">

					<input type="hidden" name="project_ID" id="project_ID"
						value="${SeaulUp.project_ID}" />
					<div class="form-group  col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>案件序号：
						</label>
						<div class="col-sm-8">
							<input type="text" name="serialNum" id="serialNum"
								class=" col-sm-10 ztb_add validate[required,maxSize[25]]" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>申请人： </label>
						<div class="col-sm-8">
							<input type="text" name="applyPerson" id="applyPerson"
								class=" col-sm-10 ztb_add validate[required,maxSize[50]]" />
						</div>
					</div>


					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>执行标的： </label>
						<div class="col-sm-8">
							<input type="text" name="targetSum" id="targetSum"
								class=" col-sm-10 ztb_add validate[custom[number],required,maxSize[18]]" /> 万元
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>资产保全方式： </label>
						<div class="col-sm-8">
							<input type="text" name="propertyType" id="propertyType"
								class=" col-sm-10 ztb_add validate[required,maxSize[50]]" />
						</div>
					</div>

					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">案号： </label>
						<div class="col-sm-8">
							<input type="text" name="recordNum" id="recordNum"
								class=" col-sm-10 ztb_add validate[maxSize[25]]" />
						</div>
					</div>
					<div class="form-group col-sm-6 ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">受理法院： </label>
						<div class="col-sm-8">
							<input type="text" name="lawCourt" id="lawCourt"
								class=" col-sm-10 ztb_add validate[maxSize[100]]" />
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-2 control-label no-padding-right"
							for="form-input">是否立案： </label>
						<div class="col-sm-10">
							<label class="radio-inline"> <input type="radio"
								value="1" name="isRecord"
								<%-- <c:if test="${SeaulUp.isRecord != '0'}"> checked</c:if> --%>>是
							</label> <label class="radio-inline"> <input type="radio"
								value="0" name="isRecord" checked="checked"
								<%-- <c:if test="${SeaulUp.isRecord == '0'}"> checked</c:if> --%>>否
							</label>
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label no-padding-right"
							for="form-input">执行依据： </label>
						<div class="col-sm-10">
							<textarea
								class="col-sm-10 limited  ztb_edit_dynamicContent validate[maxSize[2000]]"
								rows="5" name="executeBasis" id="executeBasis"></textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制2000个字符</span>
							</div>
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label no-padding-right"
							for="form-input">负责法院或其他备注信息： </label>
						<div class="col-sm-10">
							<textarea
								class="col-sm-10 limited  ztb_edit_dynamicContent validate[maxSize[2000]]"
								rows="5" name="remark" id="remark"></textarea>
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
