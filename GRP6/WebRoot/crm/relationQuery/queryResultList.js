(function($,z){
	$.zjm_queryResultList = {
			
				
	};
	
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 列表信息
	 */
	var condition = tool.getUrlParam('condition');
	$('#condition').val(condition);
	window.onload = floaddata;
	function floaddata() {
		console.log(condition);
		$.zjm_queryResultList.initCompanyTable(condition);
	};
	
});

