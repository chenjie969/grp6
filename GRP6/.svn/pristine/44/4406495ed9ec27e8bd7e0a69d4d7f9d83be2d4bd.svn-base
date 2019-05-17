(function($,z){
	$.zjm_meetingApplyIndex = {
		loadMeetingApply:loadMeetingApply,
		loadMeetingApplyRecord:loadMeetingApplyRecord,
		viewApplyInfo:viewApplyInfo
	};
	
	function loadMeetingApply(){
		$("#tabContent").load("/project/meetingApply/showMeetingApplyPage",{},function(response,status,xhr){
		});
	}
	
	function loadMeetingApplyRecord(){
		$("#tabContent").load("/project/meetingApply/showMeetingApplyRecordPage",{},function(response,status,xhr){
		});
	}
	
	/**
	 * 查看申请详情
	 */
	function viewApplyInfo(row){
		$("#page_meetingApplyIndex").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});
	}
	
	
})(jQuery, this);



$(function () {
	
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_meetingApplyIndex.loadMeetingApply();
	};
	
	/**
	 * 上会申请标签
	 */
	$("#tab_meetingApply").click(function(){
		$.zjm_meetingApplyIndex.loadMeetingApply();
	});
	
	/**
	 * 上会申请记录标签
	 */
	$("#tab_meetingApplyRecord").click(function(){
		$.zjm_meetingApplyIndex.loadMeetingApplyRecord();
	});
	
});

