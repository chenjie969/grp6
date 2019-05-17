(function($,z){
	$.zjm_projectDetailInfo = {
			mangerInfo:mangerInfo,//查看
			projectBasicInfo:projectBasicInfo,//查看项目信息
			resolutionReview:resolutionReview,//查看评审会信息
			contractInfo:contractInfo,//合同信息
			loanInfo:loanInfo,//放款信息
			proDelayInfo:proDelayInfo,//展期信息
			projectAppraisal:projectAppraisal,//项目评价
			guarantyList:guarantyList,//保证措施
			overDueInfo:overDueInfo,//逾期情况
			reimDetailInfo:reimDetailInfo,//还款记录
			replacePros:replacePros,//核销损失
			replaceAndReturnInfo:replaceAndReturnInfo,//代偿与追偿
	};
	function mangerInfo(){
		$("#one").load("/project/projectDetail/projectview",{},function(response,status,xhr){
		});
	};
	
	//查看项目信息
	function projectBasicInfo(project_ID,apply_ID){
		$("#one").load("/project/projectDetail/projectBasicInfo",{"apply_ID":apply_ID,"project_ID":project_ID},function(response,status,xhr){
		});
	};
	
	//调查报告
	
	function resolutionReview(apply_ID,type,comming){
		$("#three").load("/pro/meetResolution/meetingResolution/openMeeingResolution",{"apply_ID":apply_ID,"type":type,"comming":comming},function(response,status,xhr){
		});
	};
	
	function contractInfo(apply_ID ,type ,comming){
		$("#four").load("/pro/contractdoc/selectContract",{"entityID":apply_ID,"type":type,"comming":comming},function(response,status,xhr){
		});
	};
	
	//保证措施
	function guarantyList(apply_ID,comming ){
		$("#five").load("/optGuarantyAction/initOptGuaranty",{"entityID":apply_ID,"comming":comming},function(response,status,xhr){
		});
	};
	
	
	function loanInfo(apply_ID ,comming){
		$("#six").load("/project/project/selectSingleLoanReview",{"entityID":apply_ID,"comming":comming},function(response,status,xhr){
		});
	};
	
	//还款记录
	function reimDetailInfo(project_ID ,comming, type){
		$("#seven").load("/project/project/viewReimAndCompenInfo",{"project_ID":project_ID,"comming":comming,"type":type},function(response,status,xhr){
		});
	};
	
	
	function proDelayInfo(project_ID,comming){
		$("#eight").load("/project/project/openProjectDelayPage",{"project_ID":project_ID,"comming":comming},function(response,status,xhr){
		});
	};

	//逾期情况
	function overDueInfo(project_ID ,comming){
		$("#nine").load("/project/project/openProjectOverRegisterPage",{"project_ID":project_ID,"comming":comming},function(response,status,xhr){
		});
	};
	
	//代偿与追偿
	function replaceAndReturnInfo(project_ID,comming){
		$("#ten").load("/project/project/openProjectReplaceAndReturnPage",{"project_ID":project_ID,"comming":comming},function(response,status,xhr){
		});
	};
	
	//核销损失情况
	function replacePros(apply_ID ){
		$("#eleven").load("/project/project/badProInfo",{"entityID":apply_ID},function(response,status,xhr){
		});
	};

	function projectAppraisal(apply_ID ,type){
		$("#twelve").load("/project/apply/endProPage",{"entityID":apply_ID,"type":type},function(response,status,xhr){
		});
	};
	
	
		
})(jQuery, this);

$(function () {
	
	/*window.onload = floaddata;
	function floaddata() {//初始化页面时加载
	
	};*/ 
	var  apply_ID = $("#apply_ID").val();
	var  project_ID = $("#project_ID").val();
	$.zjm_projectDetailInfo.projectBasicInfo(project_ID,apply_ID);
	$("#mangerInfo").click(function(){
		$.zjm_projectDetailInfo.mangerInfo();
		
	});
	
	//项目详情
	$("#btn_projectBasicInfo").click(function(){
		$.zjm_projectDetailInfo.projectBasicInfo(project_ID,apply_ID);
		
	});
	
	//评审会决议
	$("#btn_resolutionReview").click(function() {
		var  type = "view";
		var  comming = "projectDetail";
		$.zjm_projectDetailInfo.resolutionReview(apply_ID,type,comming);
	});
	
	//合同信息
	$("#btn_contractInfo").click(function(){
		var type = 'view';
		var  comming = "projectDetail";
		$.zjm_projectDetailInfo.contractInfo(apply_ID,type,comming);
	});
	
	//放款信息
	$("#btn_loanInfo").click(function(){
		var comming = "projectDetail";
		$.zjm_projectDetailInfo.loanInfo(apply_ID ,comming);
	});
	
	//展期项目
	$("#btn_proDelayInfo").click(function(){
		var comming = "projectDetail";
		$.zjm_projectDetailInfo.proDelayInfo(project_ID,comming);
	});
	
	//项目评价
	$("#btn_projectAppraisal").click(function(){
		var type = 'view';
		$.zjm_projectDetailInfo.projectAppraisal(apply_ID,type);
	});
	
	//保证措施
	$("#btn_guarantyList").click(function(){
		var comming = "projectDetail";
		$.zjm_projectDetailInfo.guarantyList(apply_ID,comming);
	});
	
	//逾期情况
	$("#btn_overDueInfo").click(function(){
		var comming = "projectDetail";
		$.zjm_projectDetailInfo.overDueInfo(project_ID,comming);
	});
	
	//还款情况 
	$("#btn_reimDetailInfo").click(function(){
		var comming = "projectDetail";
		var type = "view";
		$.zjm_projectDetailInfo.reimDetailInfo(project_ID,comming,type);
	});
	
	//核销损失情况
	$("#btn_replacePros").click(function(){
		$.zjm_projectDetailInfo.replacePros(apply_ID);
	});
	
	//待尝与追偿
	$("#btn_replaceAndReturnInfo").click(function(){
		var comming = "projectDetail";
		$.zjm_projectDetailInfo.replaceAndReturnInfo(project_ID,comming);
	});
	
	
});

