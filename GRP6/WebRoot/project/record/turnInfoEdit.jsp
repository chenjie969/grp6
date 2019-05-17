<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="turnInfoEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改移交人信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form">
      		<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-input">移交人：</label>
				<div class="col-sm-9">
					<input type="text" name="sort" id="sort"  class="col-sm-6 validate[maxSize[50]]" />
				</div>
			</div> 
 			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>审批日期： </label>
		        <div class="col-sm-9">
					<div class="input-group col-sm-6">
						<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="receiveDate"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
 			</div>
 			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-input">移交说明：</label>
				<div class="col-sm-9">
						<textarea class="col-sm-10 limited   validate[maxSize[100]]" rows="5" name="Notes" id="turnInfoEdit"></textarea>
						<!-- <span class="col-sm-4 light-grey col-sm-push-100">限制输入字数500个</span> -->
				</div>
			</div>	
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"  data-dismiss="modal"><i class='icon-ok bigger-110'></i>确定</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	/*注册日期控件点击事件*/
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
</script>
				