<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	#table_arrangingApply_add{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	#table_arrangingApply_add tr th,#table_arrangingApply_add tr td{
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
<div class="modal fade" id="proMeeting_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" 
	style="overflow: auto">
			
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">安排上会</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_proMeeting_add">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingCode"><i class="icon-asterisk orange"></i>评审会编号：</label>
				<div class="col-sm-9">
					<input name="meetingCode" class="col-sm-6 validate[required,maxSize[50]]">
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID"><i class="icon-asterisk orange"></i>评审会类型：</label>
				<div class="col-sm-9">
					<select class="col-sm-6 validate[required] select" id="select_meetingTypeID" name="meetingTypeID" data-name="meetingType">
						<option value="1">部门内部评审</option>
						<option value="2">董事会评审</option>
					</select>
					<input type="hidden" name="meetingTypeName" id="select_meetingTypeName" value="部门内部评审">
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上会时间： </label>
		        <div class="col-sm-9">
					<div class="row">
						<div class="col-sm-6 no-padding-right">
							<div class="input-group">
								<input class="form-control validate[required]" type="text" data-date-format="yyyy-mm-dd hh:ii" name="meetingDateTimeStr" id="datetime-picker"/>
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
						<option value="1">第一会议室</option>
						<option value="2">第二会议室</option>
					</select>
					<input type="hidden" name="meetingRoomName" id="select_meetingRoomName" value="第一会议室">
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
							<input type="hidden" name="userIDList" id="userIDList_add" class="validate[required]"> 
							<input type="hidden" name="userNameList" id="userNameList_add">
							<div class="widget-main padding-8" style="height: 200px; OVERFLOW: auto;">
								<div id="userName_add"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">列席人员：</label>
				<div class="col-sm-9">
					<textarea rows="5" class="col-sm-9 validate[maxSize[100]]" name="otherUserNameList"></textarea>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<h4 class="col-sm-12 header smaller lighter blue">
	             	安排上会项目列表
	             	<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_setVotingJury_add">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">设置表决评委</span>
					</button>
					<span class="pull-right">&nbsp;&nbsp;</span>
					<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addArrangedApply_add">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">添加项目</span>
					</button>
	           	</h4>
				<div class="col-sm-12">
					<input type="hidden" id="tableRowIndex_add" value="0">
					<input type="hidden" class="validate[required,custom[isEmptyTable_add],custom[isEmptyVoteJury_add]]" value="0">
	            	<table  id="table_arrangingApply_add" class="table table-hover table-striped" >	
						<thead>
							<tr>
								<th width="30px"></th>
								<th>项目编号</th>
								<th>项目名称</th>
								<th>经办部门</th>
								<th width="70px">A角</th>
								<th width="70px">B角</th>
								<th width="85px">风控评审人</th>
								<th >表决评委</th>
								<th width="110px">操作</th>
							</tr>
						</thead>	
						<tbody>
							<!-- <tr>	class="validate[custom[isEmptyVoteJury_add]]"
								<td><input type="checkbox"/></td>
								<td>项目编号</td>
								<td>项目名称</td>
								<td>经办部门</td>
								<td>西门吹雪</td>
								<td>B角</td>
								<td>风控评审人</td>
								<td>朱立新，郑成，王元，曹盼盼，张可要，王振坤，吕晓刚，李斌</td>
								<td>上移  下移  撤销</td>
							</tr>	-->		             
						</tbody>		               
					</table>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btn_submit_add" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	/*注册日期控件点击事件*/
	$('#datetime-picker').datetimepicker({language:"zh",autoclose:true,minuteStep:10}).next().on("click", function(){
		$(this).prev().focus();
	});
	/*绑定下拉框选项改变事件 */
	$(".select").change(function(){
		var opText = $(this).children("option:selected").text();
		var dataName = $(this).attr("data-name");
		$("#select_"+dataName+"Name").val(opText);
	});
	/*为表格中的内容动态绑定事件*/
	$("#table_arrangingApply_add tbody").on("click",".btn_proApply_view",function(){
		var apply_ID = $(this).attr("data-applyID");
		$("#page_meetingArrangeIndex2").load("/project/apply/projectApplyViewPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
			var zindex = parseInt($("#proMeeting_add").css("z-index"));
			$("#applyInfo").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		}); 
	});
</script>				