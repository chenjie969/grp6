<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<div class="modal fade" id="editGuarantyRec" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改对外担保</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="edit_guarantyRec_form">
      	 	<input type="hidden" name="guarantyRec_ID" value="${guarantyRec.guarantyRec_ID }">
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>对外担保单位：  </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<input type="text" name="guarantyUnit" class="col-sm-12 validate[required,maxSize[25]]" value="${guarantyRec.guarantyUnit }"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保金额： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<input type="text" name="guarantySum" class="col-xs-6 validate[required,maxSize[18],custom[number]]" value="${guarantyRec.guarantySum }"/>
							<span class="col-xs-4" style="line-height:28px;">万元</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保期限： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<input type="text" name="period" class="col-sm-12 validate[required,maxSize[25]]" value="${guarantyRec.period }"/>
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
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="beginDate" 
									value="<fmt:formatDate value='${guarantyRec.beginDate }' pattern='yyyy-MM-dd'/>">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<span class="midden col-xs-1" style="line-height:28px;"> - </span>
						<div class="col-xs-5 no-padding-left">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="endDate" 
									value="<fmt:formatDate value='${guarantyRec.endDate }' pattern='yyyy-MM-dd'/>">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">互保企业： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-11">
							<textarea class="col-xs-12 validate[maxSize[100]]"   name="eachOther" rows="5">${guarantyRec.eachOther }</textarea>
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
							<textarea class="col-xs-12 validate[maxSize[100]]"   name="remark" rows="5">${guarantyRec.remark }</textarea>
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
					