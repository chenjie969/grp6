<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="costMustEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改应收费用</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_costMustEdit">
			<input type="hidden" name="costMust_ID" value="${costMust.costMust_ID }">
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
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>应收费用： </label>
				<div class="col-sm-8">
					<input type="text" name="mustCostSum" class="col-sm-6 validate[required,custom[number],maxSize[18]]" 
						value="<fmt:formatNumber value="${costMust.mustCostSum }" pattern="###.##"/>"/>
					<span class="midden col-sm-1 " style="line-height:28px;">元	</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办部门：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectOperationDepart">
								<input  type="text"  class="form-control validate[required] " autoField="operationDepartID"   id="selectOperationDepart"  
									value="${costMust.operationDepartName}" dataValue="${costMust.operationDepartID}" name="operationDepartName" readonly="readonly"/>
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
								<input  type="text"  class="form-control validate[required] " autoField="operationUserID"  dataValue="${costMust.operationUserID}"   
									id="selectOperationUser"  name="operationUserName" value="${costMust.operationUserName}" readonly="readonly"/>
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
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="operationDate"
								 	value="<fmt:formatDate value='${costMust.operationDate}' pattern='yyyy-MM-dd' type='date'/>" />
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
					<textarea rows="5" name="remark" class="col-sm-11 validate[maxSize[2000]]">${costMust.remark}</textarea>
					<div class="col-sm-11 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"  data-dismiss="modal"><i class='icon-ok bigger-110'></i>保存</button>
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
