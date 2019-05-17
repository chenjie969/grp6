<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="modal fade" id="costFactEditPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="costFactEdit_form">
			<input type="hidden" name="costFact_ID" value="${costFact.costFact_ID}">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>费用类型： </label>
				<div class="col-sm-8">
					<input type="text"  class="col-sm-6 validate[required]" id="costTypeName" name="costTypeName" value="${costFact.costTypeName}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">确认实收金额： </label>
				<label class="col-sm-8" for="form-field-1">
				<input type="text"  class="col-sm-6 validate[required]" id="factCostSum" name="factCostSum" value="<fmt:formatNumber value="${costFact.factCostSum}" pattern="###.##"/>"/>
				元</label>
			</div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>计划实收日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" id="date-picker-1"  data-date-format="yyyy-mm-dd" name="planFactCostDate" 
								value="<fmt:formatDate value="${costFact.planFactCostDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"
								/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
			
		</form>
      </div>
      <div class="modal-footer">
		<button type="button" class="btn btn-primary " id="btn_submitUpdateCostFact"><i class='icon-ok bigger-110'></i>保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
