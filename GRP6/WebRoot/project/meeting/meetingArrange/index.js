(function($,z){
	$.zjm_meetingArrangeIndex = {
		loadMeetingArrange:loadMeetingArrange,
		loadMeetingArrangeRecord:loadMeetingArrangeRecord,
		viewApplyInfo:viewApplyInfo,
		rules:rules
	};
	
	function loadMeetingArrange(){
		$("#tabContent").load("/project/meetingArrange/showMeetingArrangePage",{},function(response,status,xhr){
		});
	}
	
	function loadMeetingArrangeRecord(){
		$("#tabContent").load("/project/meetingArrange/showMeetingArrangeRecordPage",{},function(response,status,xhr){
		});
	}
	
	/**
	 * 查看申请详情
	 */
	function viewApplyInfo(row){
		$("#page_meetingArrangeIndex").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});
	}
	
	/**
	 * 页面验证规则
	 */
	function rules (){
		var allRules = {
			"isEmptyTable_add":{
				"func":function(field,rules,i,options){
					if($("#table_arrangingApply_add tbody").find("input").length==0){
						return false;
					}else{
						return true;
					}
				},
				"alertText": "安排上会项目列表不能为空",
			},
			"isEmptyTable_edit":{
				"func":function(field,rules,i,options){
					if($("#table_arrangingApply_edit tbody").find("input").length==0){
						return false;
					}else{
						return true;
					}
				},
				"alertText": "安排上会项目列表不能为空",
			},
			"isEmptyVoteJury_add":{
				"func":function(field,rules,i,options){
					var flag = true;
					$(".votableJury_add").each(function(){
						if($(this).text() == ""){
							flag = false;
						}
					});
					return flag;
				},
				"alertText": "上会项目表决评委不能为空",
			},
			"isEmptyVoteJury_edit":{
				"func":function(field,rules,i,options){
					var flag = true;
					$(".votableJury_edit").each(function(){
						if($(this).text() == ""){
							flag = false;
						}
					});
					return flag;
				},
				"alertText": "上会项目表决评委不能为空",
			}
		};
		return allRules;
	};
	
})(jQuery, this);

$(function () {
	
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_meetingArrangeIndex.loadMeetingArrange();
	};
	
	/**
	 * 上会申请标签
	 */
	$("#tab_meetingArrange").click(function(){
		$.zjm_meetingArrangeIndex.loadMeetingArrange();
	});
	
	/**
	 * 上会申请记录标签
	 */
	$("#tab_meetingArrangeRecord").click(function(){
		$.zjm_meetingArrangeIndex.loadMeetingArrangeRecord();
	});
	
});

