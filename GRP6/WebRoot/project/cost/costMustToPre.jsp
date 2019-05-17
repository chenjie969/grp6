<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="costMustToPre" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">应收转预收</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_costMustToPre">
			<input type="hidden" name="apply_ID" value="${costMust.apply_ID }">
			<input type="hidden" name="costMust_ID" value="${costMust.costMust_ID }">
			<input type="hidden" name="applyDetail_ID" value="${costMust.applyDetail_ID }">
			<input type="hidden" name="costStandard_ID" value="${costMust.costStandard_ID }">
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款机构</label>
				<label class="col-sm-8" for="form-field-1">${costMust.bankName } </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">业务品种:</label>
				<label class="col-sm-8" for="form-field-1">${costMust.busiTypeName } </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">担保金额:</label>
				<label class="col-sm-8" for="form-field-1"><fmt:formatNumber value="${costMust.agreeSum }" pattern="###,###.######"/> 万元</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">费用类型:</label>
				<label class="col-sm-8" for="form-field-1">${costMust.costStandard.costTypeName } </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">费率:</label>
				<label class="col-sm-8" for="form-field-1">${costMust.costStandard.costRate }&nbsp;${costMust.costStandard.costUnit } </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">应收费用： </label>
				<label class="col-sm-8" for="form-field-1"><fmt:formatNumber value="${costMust.mustCostSum }" pattern="###,###.##"/>元</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">预收费用： </label>
				<label class="col-sm-8" for="form-field-1"><fmt:formatNumber value="${costMust.mustCostSum }" pattern="###,###.##"/>元</label>
				<input type="hidden" name="preCostSum" value="${costMust.mustCostSum }">
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办部门：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectOperationDepart">
								<input  type="text"  class="form-control validate[required] " autoField="operationDepartID"   id="selectOperationDepart"  
									value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="operationDepartName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办人：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectOperationUser">
								<input  type="text"  class="form-control validate[required] " autoField="operationUserID"  dataValue="${sessionUser.user_uid}"   
									id="selectOperationUser"  name="operationUserName" value="${sessionUser.user_name}" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>经办日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="preCostDate"
								 	id="date-picker-1"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-8">
					<textarea rows="5" name="remark" class="col-sm-11 validate[maxSize[2000]]"></textarea>
					<div class="col-sm-11 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
		<button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>转入预收费用</button>
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
	/*设置日期初始值，默认为当天*/
	$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));
	/*获取部门下拉选择树*/
	$.ajax({type:'POST',url:'/sys/dic/selectAllDepartsTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
		success:function(data) {		
			$("#selectOperationDepart").selectTreeWidgets({
				width : "87%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
	    }
	});
	/*获取用户下拉选择树*/
	$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
		success:function(data) {		
			$("#selectOperationUser").selectTreeWidgets({
				width : "87%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
	    }
	});
</script>
