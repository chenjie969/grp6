
(function($,z){
	$.zjm_basicApply = {
		initSelectTree:initSelectTree,//初始化下拉选择树，
		agreeToAccept:agreeToAccept,//同意受理，转入受理申请
		disagreeToAccept:disagreeToAccept//不同意受理，转入客户储备库	
	};
	
	/**初始化各个下拉选择树**/
	function initSelectTree(){
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		/*获取客户来源下拉框,改变时将选项文字设置到隐藏域*/
		$(".btn_ztb_select").change(function (e) {
			$("."+$(e.target).attr("class_name")).val($(e.target).find("option:selected").text());
		});
		/*获取部门用户下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectReceptionist").selectTreeWidgets({
					width : "87%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*获取业务下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectBusSort").selectTreeWidgets({
					width : "87%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*获取合作机构下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectBank").selectTreeWidgets({
					width : "87%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*获取接待部门下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectAllDepartsTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectReception").selectTreeWidgets({
					width : "87%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
	}
	
	/**同意受理，转入受理申请**/
	function agreeToAccept(pageName,selectContent){
		$("#"+pageName+"_page").load("/crm/apply/showAgreePage",{},function(response,status,xhr){
			$("#agreeToAccept").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/crm/apply/agreeToAccept',data:JSON.stringify({"capply_ID":selectContent[0].capply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#agreeToAccept").modal("hide");
							switch(pageName){
								case "enterpriseApply":$.zjm_enterpriseApply.initTable();break;
								case "personApply":$.zjm_personApply.initTable();break;
								case "enterpriseDepot":$.zjm_enterpriseDepot.initTable();break;
								case "personDepot":$.zjm_personDepot.initTable();break;
							}
						}else{
							alert("保存失败！");
						}
			        }
				});
			});
		});
	}
	
	/**不同意受理，转入客户储备库**/
	function disagreeToAccept(pageName,selectContent){
		var clientType;
		if(pageName=="enterpriseApply"){
			clientType="01";
		}else if(pageName=="personApply"){
			clientType="02";
		}
		$("#"+pageName+"_page").load("/crm/apply/showDisagreePage",{"clientType":clientType,"capply_ID":selectContent[0].capply_ID,"clientName":selectContent[0].clientName},function(response,status,xhr){
			$("#disagreeToAccept").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_disagreeToAccept"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_disagreeToAccept");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/crm/apply/disagreeToAccept',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#disagreeToAccept").modal("hide");
								if(pageName=="enterpriseApply"){
									$.zjm_enterpriseApply.initTable();
								}else{
									$.zjm_personApply.initTable();
								}
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
		});
	}
	
})(jQuery, this);