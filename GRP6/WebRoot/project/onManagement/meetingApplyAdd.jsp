<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<style type="text/css">
#equipments i.unavailable {
	display: none;
}

#add_meeting {
	overflow-y: scroll;
}
</style>
<div class="modal fade" id="add_meeting" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">上会申请</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="meetingApply_form">
					<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="meetingCode"><i class="icon-asterisk orange"></i>评审会编号：
								</label>
								<div class="col-sm-9">
									<input id="meetingCode" name="meetingCode" placeholder="评审会编号"
										class="col-sm-6 validate[required,maxSize[50]]">
								</div>
							</div>

							<div class="space-4"></div>

							<!-- <div class="form-group">
                                <label class="col-sm-2 control-label no-padding-right" for="meetingDateTime">
                                    	<i class="icon-asterisk orange"></i>上会时间</label>
                                <div class="col-sm-9">
                                    <div class="input-group ">
                                        <input type="text" class="form-control date-picker validate[required,custom[date]]" name="meetingDateTime" id="meetingDateTime" 
                                               date-format="yyyy-dd-mm" />
                                        <span class="input-group-addon"><i class="fa fa-calendar bigger-110"></i></span>
                                    </div>
                                </div>
                            </div> -->

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="meetingDateTimeStr"> <i
									class="icon-asterisk orange"></i>上会时间：
								</label>
								<div class="col-sm-9">
									<div class="row">
										<div class="col-sm-8">
											<div class="input-group ">
												<input type="text" name="meetingDateTimeStr" placeholder="上会时间"
													id="meetingDateTimeStr" style="width: 100%;" readonly="readonly"
													onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d+1}'})"
													class="Wdate form-control validate[required,funcCall[checkMeetingDate]]" /> 
												<span class="input-group-addon ">
													 <i class="icon-calendar bigger-110 icocalenda"></i>
												</span>
									</div>
										</div>
									</div>
									
								</div>
							</div>
							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="userName"><i class="icon-asterisk orange"></i>会议主持人：</label>
								<div class="col-sm-9">
									<div class="row">
										<div class="col-sm-8">
											<div class="userName input-group ">
												<input id="userName" name="userName" placeholder="会议主持人"
													class="form-control validate[required]" autoField="userID"
													dataValue="" readonly type="text">
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
								<label class="col-sm-3 control-label no-padding-right"><i
									class="icon-asterisk orange"></i>参会评委：</label>

								<div class="col-sm-9">
									<input type="hidden" name="userIDList" id="userIDList"
										class="validate[required]"> <input type="hidden"
										name="userNameList" id="userNameList"
										class="validate[required]">
									<!-- <div class="widget-box col-sm-6" style="max-height:500px;OVERFLOW: auto; "> -->
									<div class="widget-box col-sm-6" style="height: 240px;">
										<div class="widget-header">
											<h4>选择人员</h4>
										</div>
										<div class="widget-body"
											style="height: 200px; OVERFLOW: auto;">
											<div class="widget-main padding-8">
												<ul id="userSetTree" class="ztree"></ul>
											</div>
										</div>
									</div>

									<!-- <div class="widget-box col-sm-offset-1 col-sm-4"
                                         style="max-height:500px;OVERFLOW: auto; "> -->
									<div class="widget-box col-sm-offset-1 col-sm-4"
										style="height: 240px;">
										<div class="widget-header">
											<h4>已选人员</h4>
										</div>
										<div class="widget-body">
											<div class="widget-main padding-8"
												style="height: 200px; OVERFLOW: auto;">
												<div id="userNames"></div>
											</div>
										</div>
									</div>
								</div>
							</div>


							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="otherUserNameList">外部专家：</label>
								<div class="col-sm-9">
									<textarea id="otherUserNameList" name="otherUserNameList" class="col-sm-10 autosize-transitionl" placeholder="外部专家请以逗号隔开"></textarea>
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="meetingRoomID"><i class="icon-asterisk orange"></i>会议室：</label>
								<div class="col-sm-9">
											<select class="col-sm-6 validate[required]"
										id="meetingRoomID" name="meetingRoomID">
										<!-- <option value="">--请选择--</option> -->
										<c:forEach var="room" items="${rooms}" varStatus="status">
											<option value="${room.meetingRoom_ID}">${room.meetingRoomName}</option>
										</c:forEach>
									</select>
									
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" for="form-field-1">申请项目清单： </label>
								<div class="col-sm-9">
									<textarea id="projectName" name="projectName" class="col-sm-8 autosize-transition" readonly="readonly" placeholder="申请项目清单" "></textarea>
									<input type="hidden" id="entityID" name="proEntityID">
									<button style="margin:8px 0 0 10px;" class="btn btn-xs btn-info" type="button" name="button" id="selectClient0" data-toggle="modal" data-target="#select">选择申请项目</button>
								</div>
								<!-- <input type="text" id="projectName"  name="projectName"  placeholder="请选择申请项目清单" class="col-md-5 col-sm-6" readonly="readonly"/> -->
								<!-- <input type="hidden" id="entityID" name="proEntityID">
								<label class="col-md-3 control-label no-padding-right"
									for="form-field-1"> </label>
								<div class="col-sm-9">
									
								</div> -->
							</div>
							<br />
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right"
									for="form-field-1"> 打包项目清单： </label>
								<div class="col-sm-9">
									<textarea id="packageProName" name="packageProName" class="col-sm-8 autosize-transition" readonly="readonly" placeholder="打包项目清单" ></textarea>
									<input type="hidden" id="packEagentityID" name="packEagentityID">
									<button style="margin:8px 0 0 10px;" class="btn btn-xs btn-info" type="button" name="button" id="selectClient1" data-toggle="modal" data-target="#select">选择打包项目</button>	
								</div>
								<!-- <label class="col-md-3 control-label no-padding-right"
									for="form-field-1"> </label>
								<div class="col-sm-9">
									
								</div> -->
							</div>

							<!-- <div class="form-group">
                                <label class="col-sm-2 control-label no-padding-right" for="meetingStatus"><i class="icon-asterisk orange"></i>会议状态</label>
                                <div class="col-sm-9">
                                    <select class="col-xs-10 validate[required]" id="meetingStatus" name="meetingStatus">
                                        <option value="01">待审核</option>
                                    </select>
                                </div>
                            </div> -->

						<div class="space-4"></div>

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
<script src="/assets/js/chosen.jquery.min.js"></script>
<script src="/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<link rel="stylesheet" href="/assets/css/iconfont.css" />
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/plugins/viewer/viewer.min.js"></script>
<script src="/project/onManagement/js/treeUser.js"></script>

<script src="/assets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function initModal() {
		$.zjm_zTreeUser.initTree("userSetTree", "userIDList", "userNameList",
		"/sys/dic/selectDepartsUserTreeTwo");
		//主持人
		$.ajax({
			type : 'POST',
			url : '/sys/dic/selectDepartsUserTreeTwo',
			data : JSON.stringify({}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$("#userName").selectTreeWidgets({
					width : "93%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj
				//数据源
				});
			}
		});
		
		$('.icocalenda').click(function(){
			$('#meetingDateTimeStr').focus();
			
		});
		
		$('.timepicker').timepicker({
			minuteStep : 1,
			showSeconds : true,
			showMeridian : false,
			disableFocus : true,
			icons : {
				up : 'fa fa-chevron-up',
				down : 'fa fa-chevron-down'
			}
		}).on('focus', function() {
			$(this).timepicker('showWidget');
		}).next().on(ace.click_event, function() {
			$(this).prev().focus();
		});
		$('.date-picker1').datepicker({
			autoclose : true
		}).next().on(ace.click_event, function() {
			$(this).prev().focus();
		});

	}
	
	function checkMeetingDate(field, rules, i, options) {
        var meetingDate = new Date(field.val());
        var currentDate = new Date();
        if (meetingDate < currentDate) {
            return "上会时间不能小于当前时间";
        }
    }
</script>
