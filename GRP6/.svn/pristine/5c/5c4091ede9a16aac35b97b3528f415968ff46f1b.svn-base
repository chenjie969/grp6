(function($,z){
	$.zjm_applyPageIndex = {
			openSingleApplyAdd:openSingleApplyAdd,//初始化函数:单笔业务;
			openMultiApplyAdd:openMultiApplyAdd,//初始化函数:多笔业务;
			relationMainApplyAdd :relationMainApplyAdd,//初始化函数:主体关联项目;
	};
	//初始化函数:单笔业务;
	function openSingleApplyAdd(){
		$("#singleApplyAdd").load("/project/apply/openSingleApplyAdd","",function(){});};
	//初始化函数:多笔业务;
	function openMultiApplyAdd(){
		$("#multiApplyAdd").load("/project/apply/openMultiApplyAdd","",function(){});};
	//初始化函数:主体关联项目;
	function relationMainApplyAdd(){
		$("#relationMainApplyAdd").load("/project/apply/relationMainApplyAdd","",function(){});};
	
	
})(jQuery, this);
$(function () {		
	
	 //初始化单笔业务
	window.onload = floaddata;
	function floaddata() {		
		
		$.zjm_applyPageIndex.openSingleApplyAdd();
		
	};
	//初始化函数:单笔业务;
	$("#btn_openSingleApplyAdd").click(function(){
		
		$.zjm_applyPageIndex.openSingleApplyAdd();
	});
	//初始化函数:多笔业务;
	$("#btn_openMultiApplyAdd").click(function(){
		
		$.zjm_applyPageIndex.openMultiApplyAdd();
	});
	//初始化函数:主体关联项目;
	$("#btn_relationMainApplyAdd").click(function(){
		$.zjm_applyPageIndex.relationMainApplyAdd();
	});
	
	
});

