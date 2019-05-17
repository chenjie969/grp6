(function($,z){
	$.zjm_leadingProducts = {
		initData:initData,	
		leadingProductsEdit:leadingProductsEdit
	};
	
	
	function initData(){
		/**主导产品介绍在股东背景表(crm_managerInfo)中*/
		$.ajax({type:'POST',url:"/selectOneManagerInfo",data:JSON.stringify({"client_ID":$("#client_ID").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				$.each(data.obj, function(key, value){ 
	        		if(key=="productdesc"){
	        			$("#leadingProducts_content").text((value==null||value=="")?"（空）":value);
	        		}
	        		$("#leadingProductsEdit_form input[name='"+key+"']").val(value);	//给修改页面的隐藏域设值，client_ID 和 managerInfo_ID
				});
	        }
		});
	}
	
	function leadingProductsEdit(){
		var l = $("#leadingProducts_content").text();
		$("#productdesc_text").val(l=="（空）"?"":l);
		$("#leadingProductsEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"leadingProductsEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#leadingProductsEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/updateOneManagerInfo",data:JSON.stringify($("#leadingProductsEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#leadingProductsEdit").modal("hide");
						$.zjm_leadingProducts.initData();
					}else{
						tool.undisabled(".btn_submit");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#developEvolutionEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
})(jQuery, this);

$(function () {
	
	/**点击 主导产品介绍 时执行*/
	$("#tab_companyBusiness a[href='#leadingProducts']").click(function(){
		$.zjm_leadingProducts.initData();
	});
	
	$("#btn_leadingProductsEdit").click(function(){
		$.zjm_leadingProducts.leadingProductsEdit();
	});
	
});

