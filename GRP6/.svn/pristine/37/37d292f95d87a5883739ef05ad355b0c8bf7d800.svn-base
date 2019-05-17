<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="editCoopBZJManager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改合作机构保证金</h4>
      </div>
      <div class="modal-body">

		<form class="form-horizontal" role="form" id="form_coopBZJManager">
			<input type="hidden" name="unitUid"  value="${bankSort.unitUid}">
			<input type="hidden" name="banksortid" value="${bankSort.banksortid}">
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">合作机构： </label>
				<label class="col-sm-6"><span>${bankSort.banksortname}</span></label>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信金额： </label>
				<label class="col-sm-6"><span><fmt:formatNumber value="${bankSort.creditSum}" pattern="###,###.######"/>万元</span></label>
				<input value="${bankSort.creditSum}" id="creditSumVal" class="col-xs-10 col-sm-8" type="hidden"/>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>保证金比例： </label>
				<div class="col-sm-6">
					<input value="${bankSort.bzScale}" name="bzScale" id="bzScaleVal" class="col-xs-10 col-sm-8  ztb_edit validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">应缴存保证金： </label>
				<div class="col-sm-6">
					<input value="${bankSort.mustBzSum}" name="mustBzSum" id="mustBzSumVal"  class="col-xs-10 col-sm-8  ztb_edit validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
				<button type="button" class="btn btn-xs btn-info" id="btn_computeBZJ">保证金计算</button>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>存出保证金： </label>
				<div class="col-sm-6">
					<input value="${bankSort.factBzSum}" name="factBzSum" id="factBzSumVal"  class="col-xs-10 col-sm-8  ztb_edit validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-8">
					<textarea rows="5" class="col-sm-12" name="remark">${bankSort.remark}</textarea>
					<div class="col-sm-12 no-padding-right">
						<span class="light-grey" style="float:right">限制250个字符</span>
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
				