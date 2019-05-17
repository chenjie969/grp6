<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
	#table_arrangingApply{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	#table_arrangingApply tr th,#table_arrangingApply tr td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	};
</style>
<div class="modal fade" id="proMeetingView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" 
	style="overflow: auto">
			
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看评审会详情</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">评审会编号：</label>
				<label class="col-sm-8 grey">${meeting.meetingCode }</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">评审会类型：</label>
				<label class="col-sm-8 grey">${meeting.meetingTypeName }</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">上会时间： </label>
		        <label class="col-sm-8 grey">
		        	<fmt:formatDate value="${meeting.meetingDateTime }" pattern="yyyy年MM月dd日  HH时mm分" type="both"/>
		        </label>
 			</div>
 			<div class="space-4"></div>
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">会议室：</label>
				<label class="col-sm-8 grey">${meeting.meetingRoomName }</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">参会评委：</label>
				<label class="col-sm-8 grey">${fn:replace(meeting.userNameList,',', '，')}</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">列席人员：</label>
				<label class="col-sm-8 grey">${meeting.otherUserNameList }</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<h4 class="col-sm-12 header smaller lighter blue">上会项目列表</h4>
				<div class="col-sm-12">
	            	<table id="table_arrangingApply" class="table table-hover table-striped" >	
						<thead>
							<tr>
								<th width="45px">序号</th>
								<th>项目编号</th>
								<th>项目名称</th>
								<th>经办部门</th>
								<th width="70px">A角</th>
								<th width="70px">B角</th>
								<th width="85px">风控评审人</th>
								<th width="25%">表决评委</th>
							</tr>
						</thead>	
						<tbody>
							<c:forEach begin="0" end="${fn:length(meeting.meetingApplyList)-1 }" var="index">
								<c:forEach items="${meeting.meetingApplyList}" var="meetingApply">
									<c:if test="${meetingApply.meetingSort == index }">
										<tr>
											<td>${index+1 }</td>
											<td>${meetingApply.proApply.busiCode }</td>
											<td><a class="btn_proApply_view" href="javascript:void(0)" data-applyID="${meetingApply.proApply.apply_ID }">${meetingApply.proApply.projectName }</a></td>
											<td>${meetingApply.proApply.operationDepartName }</td>
											<td>${meetingApply.proApply.amanName }</td>
											<td>${empty meetingApply.proApply.bmanName?"（空）":meetingApply.proApply.bmanName }</td>
											<td>${empty meetingApply.proApply.reviewManName?"（空）":meetingApply.proApply.reviewManName }</td>
											<td>${fn:replace(meetingApply.userNameList,',', '，')}</td>
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
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	$(".btn_proApply_view").click(function(){
		var apply_ID = $(this).attr("data-applyID");
		$("#page_meetingArrangeIndex2").load("/project/apply/projectApplyViewPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
			var zindex = parseInt($("#proMeetingView").css("z-index"));
			$("#applyInfo").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		});
	});
</script>
