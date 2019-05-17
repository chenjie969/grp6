(function($,z){
	$.zjm_enterprise = {
			
	};
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_enterpriseApply.initTable();
	};
	
	$("#enterpriseApplyTab").click(function(){
		$.zjm_enterpriseApply.initTable();
	});
	
	$("#enterpriseRegisterTab").click(function(){
		$.zjm_enterpriseRegister.initTable();
	});
});

