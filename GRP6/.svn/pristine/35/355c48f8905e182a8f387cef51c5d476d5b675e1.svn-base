$(function () {

	/**
	 * 加载企业经营情况时，判断请求路径，view时要隐藏修改、新增等按钮
	 */
	var type = tool.getUrlParam('type');//获取路径类型:查看/修改
	if(type == 'view'){		//查看页面隐藏修改按钮
		$(".hideWhenView").hide();
	}
	
	/**点击 右侧标签页-企业经营情况 时执行，默认显示 主导产品介绍*/
	$("#myTab3 a[href='#companyBusiness']").click(function(){
		$.zjm_leadingProducts.initData();
	});
	
});