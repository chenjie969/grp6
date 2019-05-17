(function($,z){
	$.zjm_meetingResult = {
		loadNotInputPage:loadNotInputPage,
		loadHasInputedPage:loadHasInputedPage
	};
	
	/**
	 * 加载未表决页面 
	 */
	function loadNotInputPage(){
		$("#tabContent").load("/pro/meetResolution/meetingResolution/showMeetingNotInputPage");
	}
	
	/**
	 * 加载已表决页面 
	 */
	function loadHasInputedPage(){
		$("#tabContent").load("/pro/meetResolution/meetingResolution/showMeetingHasInputedPage");
	}
	
})(jQuery, this);

$(function () {
	
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_meetingResult.loadNotInputPage();
	};
	
	/**
	 * 未录入决议标签
	 */
	$("#tab_notInput").click(function(){
		$.zjm_meetingResult.loadNotInputPage();
	});
	
	/**
	 * 已录入决议标签
	 */
	$("#tab_hasInputed").click(function(){
		$.zjm_meetingResult.loadHasInputedPage();
	});
	
});

