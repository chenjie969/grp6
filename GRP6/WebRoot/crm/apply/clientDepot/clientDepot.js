(function($,z){
	$.zjm_clientDepot = {
			
	};
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_enterpriseDepot.initTable();
	};
	
	$("#enterpriseDepotTab").click(function(){
		$.zjm_enterpriseDepot.initTable();
	});
	
	$("#personDepotTab").click(function(){
		$.zjm_personDepot.initTable();
	});
});

