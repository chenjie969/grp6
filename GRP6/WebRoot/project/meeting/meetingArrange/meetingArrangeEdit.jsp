<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
	#table_arrangingApply_edit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	#table_arrangingApply_edit tr th,#table_arrangingApply_edit tr td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	};
	/* 关于css选择器
		原来的写法是  .table_busiLimit tr th,td， 这样写是不对的。
		例如: #div1 p,span 是表示 选择#div 下的 p 元素 和全部 span元素(包括非#div下 和#div下的）
	 */
</style>
<!-- 	bootstrap 打开多层模态框的情况下，关闭任意一个模态框，都会导致其余模态框的滚动条消失。
		监测html发现，当打开模态框时，会给 body 元素加一个 modal-open 的 class，而在 bootstrap.css 中，有这样一条 css 规则：
				.modal-open .modal {overflow-x:hidden; overflow-y:auto}
		因为有 overflow-y:auto，所以模态框才可以滚动，而当关闭任何一个模态框时，body 元素的 css 规则 modal-open 会被移除掉，自然 overflow-y:auto 也就没有了，所以模态框的滚动条就消失了。
		解决方案: 在模态框的 div 元素上加一条 style="overflow: auto"，如下：
				<div class="modal fade" ... style="overflow: auto">
		这样，模态框的滚动就不依赖 body 元素的 css 规则 modal-open 了。 -->
<div class="modal fade" id="proMeeting_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" 
	style="overflow: auto">
			
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改上会信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_proMeeting_edit">
			<input type="hidden" name="meeting_ID" value="${meeting.meeting_ID }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingCode"><i class="icon-asterisk orange"></i>评审会编号：</label>
				<div class="col-sm-9">
					<input name="meetingCode" class="col-sm-6 validate[required,maxSize[50]]" value="${meeting.meetingCode }">
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID"><i class="icon-asterisk orange"></i>评审会类型：</label>
				<div class="col-sm-9">
					<select class="col-sm-6 validate[required] select" id="select_meetingTypeID" name="meetingTypeID" data-name="meetingType">
						<c:forEach items="${meetingTypeList }" var="meetingType">
							<option value="${meetingType.dicTypeID }" <c:if test="${meetingType.dicTypeID==meeting.meetingTypeID }">selected="selected"</c:if>>${meetingType.dicTypeName }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="meetingTypeName" id="select_meetingTypeName" value="${meeting.meetingTypeName }">
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上会时间： </label>
		        <div class="col-sm-9">
					<div class="row">
						<div class="col-sm-6 no-padding-right">
							<div class="input-group">
								<input class="form-control datetime-picker validate[required]" type="text" data-date-format="yyyy-mm-dd hh:ii" name="meetingDateTimeStr" 
									 value="<fmt:formatDate value="${meeting.meetingDateTime }" pattern="yyyy-MM-dd HH:mm" type="both"/>"/>
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
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID"><i class="icon-asterisk orange"></i>会议室：</label>
				<div class="col-sm-9">
					<select class="col-sm-6 validate[required] select" id="select_meetingRoomID" name="meetingRoomID"  data-name="meetingRoom">
						<option value="1" <c:if test="${meeting.meetingRoomID==1 }">selected="selected"</c:if>>第一会议室</option>
						<option value="2" <c:if test="${meeting.meetingRoomID==2 }">selected="selected"</c:if>>第二会议室</option>
					</select>
					<input type="hidden" name="meetingRoomName" id="select_meetingRoomName" value="${meeting.meetingRoomName }">
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">
					<i class="icon-asterisk orange"></i>参会评委：
				</label>
				<div class="col-sm-9">
					<div class="widget-box col-sm-5" style="height: 240px;">
						<div class="widget-header">
							<h5>选择人员</h5>
						</div>
						<div class="widget-body" style="height: 200px; OVERFLOW: auto;">
							<div class="widget-main padding-8">
								<ul id="userSetTree" class="ztree"></ul>
							</div>
						</div>
					</div>
					<div class="widget-box col-sm-4" style="height: 240px;">
						<div class="widget-header">
							<h5>已选人员</h5>
						</div>
						<div class="widget-body">
							<input type="hidden" name="userIDList" id="userIDList_edit" class="validate[required]" value="${meeting.userIDList }"> 
							<input type="hidden" name="userNameList" id="userNameList_edit" class="validate[required]" value="${meeting.userNameList }">
							<div class="widget-main padding-8" style="height: 200px; OVERFLOW: auto;">
								<div id="userName_edit"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingCode">列席人员：</label>
				<div class="col-sm-9">
					<textarea rows="5" class="col-sm-9 validate[maxSize[100]]" name="otherUserNameList">${meeting.otherUserNameList }</textarea>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<h4 class="col-sm-12 header smaller lighter blue">
	             	安排上会项目列表
	             	<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_setVotingJury_edit">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">设置表决评委</span>
					</button>
					<span class="pull-right">&nbsp;&nbsp;</span>
					<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addArrangedApply_edit">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">添加项目</span>
					</button>
	           	</h4>
				<div class="col-sm-12">
					<input type="hidden" id="tableRowIndex_edit" value="${fn:length(meeting.meetingApplyList) }">
					<input type="hidden" class="validate[required,custom[isEmptyTable_edit],custom[isEmptyVoteJury_edit]]" value="0">
	            	<table  id="table_arrangingApply_edit" class="table table-hover table-striped ">	
						<thead>
							<tr>
								<th width="30px"></th>
								<th>项目编号</th>
								<th>项目名称</th>
								<th>经办部门</th>
								<th width="70px">A角</th>
								<th width="70px">B角</th>
								<th width="85px">风控评审人</th>
								<th>表决评委</th>
								<th width="110px">操作</th>
							</tr>
						</thead>	
						<tbody>
							<c:forEach begin="0" end="${fn:length(meeting.meetingApplyList)-1 }" var="index">
								<c:forEach items="${meeting.meetingApplyList}" var="meetingApply">
									<c:if test="${meetingApply.meetingSort == index }">
										<tr>
											<td><input type='checkbox' class='tdCheckbox_edit' data-trIndex='${index }'/></td>
											<td>${meetingApply.proApply.busiCode }</td>
											<td><a class="btn_proApply_view" href="javascript:void(0)" data-applyID="${meetingApply.proApply.apply_ID }">${meetingApply.proApply.projectName }</a></td>
											<td>${meetingApply.proApply.operationDepartName }</td>
											<td>${meetingApply.proApply.amanName }</td>
											<td>${empty meetingApply.proApply.bmanName?"（空）":meetingApply.proApply.bmanName }</td>
											<td>${empty meetingApply.proApply.reviewManName?"（空）":meetingApply.proApply.reviewManName }</td>
											<td class='votableJury_edit' id='votableJury_${index }_edit'>${fn:replace(meetingApply.userNameList,',', '，')}</td>
											<td style='display:none;'>
												<input type='hidden' id='tdVoteJuryID_${index }_edit' class='tdVoteJuryIDList_edit validate[required]' value="${meetingApply.userIDList }">
												<input type='hidden' id='tdVoteJuryName_${index }_edit' class='tdVoteJuryNameList_edit validate[required]' value="${meetingApply.userNameList }">
												<input type='hidden' id='tdApplyID_${index }_edit' class='tdApplyID_edit' value='${meetingApply.entityID }'>
											</td>
											<td>
												<a href='javascript:void(0)' class='trMoveUp'>上移</a>  
												<a href='javascript:void(0)' class='trMoveDown'>下移</a>  
												<a href='javascript:void(0)' class='trDelete'>撤销</a>
											</td>
										</tr>
									</c:if>
								</c:forEach>		             
							</c:forEach>
						</tbody>		               
					</table>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btn_submit_edit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	/*注册日期控件点击事件*/
	$('.datetime-picker').datetimepicker({language:"zh",autoclose:true,minuteStep:10}).next().on("click", function(){
		$(this).prev().focus();
	});
	/*绑定下拉框选项改变事件 */
	$(".select").change(function(){
		var opText = $(this).children("option:selected").text();
		var dataName = $(this).attr("data-name");
		$("#select_"+dataName+"Name").val(opText);
	});
	/*为表格中的内容动态绑定事件*/
	$("#table_arrangingApply_edit tbody").on("click",".btn_proApply_view",function(){
		var apply_ID = $(this).attr("data-applyID");
		$("#page_meetingArrangeIndex2").load("/project/apply/projectApplyViewPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
			var zindex = parseInt($("#proMeeting_edit").css("z-index"));
			$("#applyInfo").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		}); 
	});
</script>				