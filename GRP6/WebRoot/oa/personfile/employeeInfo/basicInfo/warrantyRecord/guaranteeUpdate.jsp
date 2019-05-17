<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
</script>
<div class="modal fade bs-example-modal-sm" id="guaranteeUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改担保记录</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="guaranteeUpdate_Form"> 
		<input type="hidden" name="guaranteeID" value="${guarantee.guaranteeID}"/>
		<input type="hidden" name="staffcase_Id" value="${guarantee.staffcase_Id}"/>	
                 
            		<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>保证人：
						</label>
						<div class="col-sm-9">
							<input type="text" name="guaranteeMan" id="guaranteeMan"  class="col-sm-10 validate[required,maxSize[20]]" value="${guarantee.guaranteeMan}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>担保日期： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text" value="<fmt:formatDate value='${guarantee.guaranteeDate}' pattern='yyyy-MM-dd'/>" 
								class="form-control date-picker validate[required,custom[date]]" 
								 name="guaranteeDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd"/>
								 <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">所在单位：</label>
						<div class="col-sm-9">
							<input type="text" name="guaranteeUnits" id="guaranteeUnits"  class=" col-sm-10 validate[maxSize[50]]"value="${guarantee.guaranteeUnits}" />
						</div>
					</div>  
					
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>联系方式：</label>
						<div class="col-sm-9">
							<input type="text" name="guaranteeTEL" id="guaranteeTEL"  class="col-sm-10 validate[required,maxSize[11]]" value="${guarantee.guaranteeTEL}"/>	
						</div>
					</div>  
             <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">担保内容描述：</label>
							<div class="col-sm-9">
							<textarea class="col-sm-10 limited validate[maxSize[250]]" rows="5" name="guaranteeDesc" id="guaranteeDesc">${guarantee.guaranteeDesc}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">最多允许输入字符250个</span>
							</div>
							
						</div>
					</div>
                 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
							<div class="col-sm-9">
							<textarea class="col-sm-10 limited  validate[maxSize[250]]" rows="5" name="guaranteeNotes" id="guaranteeNotes">${guarantee.guaranteeNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">最多允许输入字符250个</span>
							</div>
							
						</div>
					</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>