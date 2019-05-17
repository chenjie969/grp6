(function($,z){
	$.zjm_clientRule = {
			initData:initData,//初始化数据
			radioChange:radioChange,//选择客户规则
			colsePage:colsePage
	};
	
	/**
	 * 页面初始化
	 */
	function initData(){
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"edit_clientRuleForm"});
		/**提交*/
		tool.undisabled(".btn_submit");
		
		var ruleValue = $('input[name="ruleType"]:checked').val(); 
		$(".btn_submit").click(function(){
			if($(".autoBuild").val() == '字号'){  
				$(".autoBuild").val("");
			}
			if($(".eachBuild").val() == '字号'){  
				$(".eachBuild").val("");
			}
			tool.disabled(".btn_submit");
			if($("#edit_clientRuleForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_clientRuleForm");
					$.ajax({type:'POST',url:'/sys/clientCode/updateOneClientCodeInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							if($(".autoBuild").val() == ""){  
								$(".autoBuild").val("字号");
							}  
							if($(".eachBuild").val() == ""){  
								$(".eachBuild").val("字号");
							}
							$("#succeedMessage").modal({keyboard:true});
							tool.undisabled(".btn_submit");
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
				        }
					});
					
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$.zjm_clientRule.radioChange();
	};
	/**
	 * 选中规则时隐藏其它radio下的input
	 */
	function radioChange(){
		var ruleValue = $('input[name="ruleType"]:checked').val(); 
		if(ruleValue == '01'){  
			$(".eachBuild").attr("disabled",true);
			$(".autoBuild").attr("disabled",false);
			$(".eachBuild").val("字号");
		}  
		if(ruleValue == '02'){  
			$(".autoBuild").attr("disabled",true);
			$(".eachBuild").attr("disabled",false);
			$(".autoBuild").val("字号");
		}  
		if(ruleValue == '03'){  
			$(".autoBuild").attr("disabled",true);
			$(".eachBuild").attr("disabled",true);
			$(".eachBuild").val("字号");
			$(".autoBuild").val("字号");
		}  
	};
	
	/**
	 * 关闭当前页面
	 */
	function colsePage(){
		window.parent.closeMenu('menub8e6b74e44764ad69afe7cd6352a82f8');
	};
	
})(jQuery, this);



$(function () {
	//初始化
	$.zjm_clientRule.initData();

	$("#btn_closePage").click(function(){
		$.zjm_clientRule.colsePage();
	});
});

