(function($,z){
	$.zjm_jurySuggest = {
		loadNotVotePage:loadNotVotePage,
		loadHasVotedPage:loadHasVotedPage
	};
	
	/**
	 * 加载未表决页面 
	 */
	function loadNotVotePage(){
		$("#tabContent").load("/project/jurySuggest/showMeetingNotVotePage");
	}
	
	/**
	 * 加载已表决页面 
	 */
	function loadHasVotedPage(){
		$("#tabContent").load("/project/jurySuggest/showMeetingHasVotedPage");
	}
	
})(jQuery, this);

$(function () {
	
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_jurySuggest.loadNotVotePage();
	};
	
	/**
	 * 未表决标签
	 */
	$("#tab_notVote").click(function(){
		$.zjm_jurySuggest.loadNotVotePage();
	});
	
	/**
	 * 已表决标签
	 */
	$("#tab_hasVoted").click(function(){
		$.zjm_jurySuggest.loadHasVotedPage();
	});
	
});

