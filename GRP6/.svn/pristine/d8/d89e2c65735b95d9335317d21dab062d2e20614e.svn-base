<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addReplace" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">部分代偿</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_Replace_form">
      	 	<input type="hidden" name=project_ID  value="${project_ID }"/>
      		 <input type="hidden" name=apply_ID  value="${apply_ID }"/>


					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>代偿日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]]"
									type="text" id="payDate" data-date-format="yyyy-mm-dd" name="replaceDate" /> 
								<span class="input-group-addon"> 
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"><i class="icon-asterisk orange"></i>代偿金额：
						</label>
						<div class="col-sm-8">

							<input type="text" id="replaceSum-add" name="replaceSum" class="col-sm-6 validate[required]">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>

						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">其中（分类1）： </label>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1">代偿本金：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 " id="replaceCapitalSum-add" name="replaceCapitalSum">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1">代偿利息：</label>
						<div class="col-sm-8">
							<input type="text"  class="col-sm-6 "id="replaceInterestSum-add" name="replaceInterestSum" >
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">代偿其它：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 " id="replaceOtherSum-add" name="replaceOtherSum">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">其中（分类2）： </label>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">自有资金代偿：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 " id="selfReplaceSum-add" name="selfReplaceSum">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">准备金冲抵：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 " id="dangerReplaceSum-add" name="dangerReplaceSum">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">备注： </label>
						<div class="col-sm-8">
							<textarea class="col-xs-8 validate[maxSize[100]]" name="remark"
								rows="5"></textarea>
							<div class="col-xs-8 no-padding-right">
								<span class="light-grey" style="float: right">限制100个字符</span>
							</div>
						</div>
					</div>

				</form>
      </div>
      
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>

    </div>
  </div>
</div>
					
<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){
		$('#replaceDate').focus();
	});
	
</script>