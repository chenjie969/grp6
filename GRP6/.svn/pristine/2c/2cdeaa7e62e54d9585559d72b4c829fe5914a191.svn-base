<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addMeeingApply" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">申请上会</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_addMeetingApply">
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">申请上会项目： </label>
				<label class="col-sm-8">${projectNameList }</label>
				<input type="hidden" value="${applyIDList }" name="meetingApplyIDs">
			</div>
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>申请上会日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="applyMeetingDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			<div class="space-4"></div>
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">经办部门：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectDepart">
								<input  type="text"  class="form-control " autoField="operationDepartID"   id="selectDepart"  
									value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="operationDepartName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">申请人：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectUser">
								<input  type="text"  class="form-control" autoField=""   id="selectUser"  
									value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="applyMeetingUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">提交日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="meetingSubmitDate"/>
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
        <button type="button" class="btn btn-primary" id="btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
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
			$("#selectDepart").selectTreeWidgets({
				width : "87%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
	});
	/*获取部门用户下拉选择树*/
	$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
		success:function(data) {		
			$("#selectUser").selectTreeWidgets({
				width : "87%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
	});
</script>				