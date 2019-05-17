(function($,z){
	$.zjm_person = {
			
	};
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		alert("cccc");
		$.zjm_personApply.initTable();
	};
	
	$("#personApplyTab").click(function(){
		$.zjm_personApply.initTable();
	});
	
	$("#personRegisterTab").click(function(){
		$.zjm_personRegister.initTable();
	});
});

