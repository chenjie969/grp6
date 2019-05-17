(function($,z){
	$.common_optEdit={
		submitOptGuaranty:submitOptGuaranty ,// 修改页面-- 保存按钮 
		closeMenu:closeMenu // 修改页面 -- 关闭按钮 
	}
	
	
	/**
	 * 修改页面-- 保存按钮 
	 */
	function submitOptGuaranty(optGuaranty_ID){
		/** 注册编辑验证引擎 */
		zjm.init();
		zjm.validata({ formId : "form_baseTwo" });
		if ($("#form_baseTwo").validationEngine("validate")) {
				tool.disabled("#btn_updateptGuaranty");
			var queryContainer_form=$("#form_baseTwo");
			var formData = JSON.stringify(queryContainer_form.serializeJson());
			$.ajax({
				type:'POST',
				url:'/optGuarantyAction/updateOneOptGuarantyInfo',
				data:formData ,
				contentType: 'application/json; charset=UTF-8',
				dataType:'json' ,
				success:function(data){
					if(data.obj){
						window.parent.closeMenu('update_OptGuaranty'+optGuaranty_ID);
					}else{
						alert("保存失败...");
					}
				} 
			});
			
		}else{
			tool.undisabled("#btn_updateptGuaranty"); // 下一步按钮 可用
			return ;
		}	
	}
	
	/**
	 * 修改页面 -- 关闭按钮 
	 */
	function closeMenu(optGuaranty_ID){
		window.parent.closeMenu('view_OptGuaranty'+optGuaranty_ID);
	}
	
})(jQuery,this);

$(function(){
	

		/**
		 * 修改页面-- 保存按钮 
		 */
		$("#btn_updateptGuaranty").click(function(){
			var optGuaranty_ID=$("#optGuaranty_ID").val();
			$.common_optEdit.submitOptGuaranty(optGuaranty_ID);
		})
		
		/**
		 *  修改页面 -- 关闭按钮 
		 */
		$("#btn_close").click(function(){
			var optGuaranty_ID=$("#optGuaranty_ID").val();
			$.common_optEdit.closeMenu(optGuaranty_ID);
		})
})


