(function($,z){
	$.zjm_projectSuggest = {
			projectSuggestAdd:projectSuggestAdd,//新增意见信息
			closeSuggestAddPage:closeSuggestAddPage,//关闭新增意见信息页面
			initDate:initDate,//初始化页面,隐藏相应的div
			projectSuggestEdit:projectSuggestEdit,//修改意见信息
			
	};
	
	function projectSuggestAdd(){
		var apply_ID = $("#entityID").val();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"projectSuggestAdd_form"
		});		
		tool.disabled(".btn_projectSuggestAdd");		
		if($("#projectSuggestAdd_form").validationEngine("validate")){
			var queryContainer_form = $("#projectSuggestAdd_form");
			$.ajax({type:'POST',url:'/project/suggest/insertProjectSuggest',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					window.parent.openMenu('projectDeal'+apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+apply_ID);
					$.zjm_projectSuggest.closeSuggestAddPage();	//关闭
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_applyAdd");
		}
	}
	/**
	 * 关闭新增页面
	 * @returns
	 */
	function closeSuggestAddPage(){
		var apply_ID = $("#entityID").val();
		var taskName = $("#taskName").val();
		window.parent.closeMenu(taskName+apply_ID);
	}
	
	function initDate(type){
		/*if('view' == type){
			$("#projectSuggestEditPage").hide();//查看时隐藏,意见输入框
			$("#btn_projectSuggestAdd").hide();//查看时隐藏,保存按钮
			$("#picker").hide();//查看时隐藏,选择文件按钮
			$("#ctlBtn").hide();//查看时隐藏,开始上传按钮
		}else if('edit' == type){//修改时隐藏;			
			$("#projectSuggestViewPage").hide();
		}*/
		if('view' == type){
			$(".btn_projectSuggestEdit").hide();//查看时隐藏,意见输入框
		}
		
	}
	
	//修改意见信息
	function projectSuggestEdit(suggest_ID){
		var entityID = $("#entityID").val();
		var productInstanceID = $("#productInstanceID").val();
		var taskName = $("#taskName").val();
		var taskID = $("#taskID").val();
		var nodeID = $("#nodeID").val();
//		var suggest_ID = $("#suggest_ID").val();
		var type = $("#type").val();
		var entityType = $("#entityType").val();
		var suggestType = $("#suggestType").val();
		
		$("#projectSuggest_page").load("/project/suggest/returnProjectSuggestEditPage",{"suggest_ID":suggest_ID,"entityID":entityID, "type":suggestType},function(response,status,xhr){				
			
			zjm.init();
			//$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
			$("#productInstanceID2").val(productInstanceID);
			$("#taskName2").val(taskName);
			$("#myModalLabel").text(taskName);
			$("#taskID2").val(taskID);
			$("#nodeID2").val(nodeID);
			$("#entityID3").val(entityID);
//			$("#suggest_ID2").val(suggest_ID);
			$("#type2").val(type);
			$("#entityType2").val(entityType);
			$("#projectSuggestEditPage").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submitUpdate").click(function(){
				tool.disabled(".btn_submitUpdate");
				if($("#projectSuggestEdit_form").validationEngine("validate")){
					$("#projectSuggestEditPage").modal("hide");
						var queryContainer_form = $("#projectSuggestEdit_form");
						$.ajax({type:'POST',url:'/project/suggest/insertProjectSuggest',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#projectSuggestEditPage").modal("hide");
								 window.location.reload();
							}else{
								alert("意见修改失败！");
							}
						}
						});
						
				}else{
					tool.undisabled(".btn_submitUpdate");
				}
			});
			$("#projectSuggestEditPage").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submitUpdate").unbind("click");
			});
		})
	}
		
})(jQuery, this);

$(function () {
	var type = $("#type").val();
	
	$.zjm_projectSuggest.initDate(type);
	/**
	 * 新增意见信息
	 */
	$(".btn_projectSuggestAdd").click(function(){
		$.zjm_projectSuggest.projectSuggestAdd();
	});
	/**
	 * 关闭新增意见信息页面
	 */
	$(".btn_closeSuggestAddPage").click(function(){
		
		$.zjm_projectSuggest.closeSuggestAddPage();
	});
	
	$(".btn_projectSuggestEdit").click(function(){
		var  suggest_ID= $(this).attr("value");		
		$.zjm_projectSuggest.projectSuggestEdit(suggest_ID);
	});
	
	
	
});

