$(function () {
	var applyID = $("#applyID").val();
	var checkPlan_ID = $("#checkPlan_ID").val();//获取计划检查id
	var riskLevelID=$("#riskLevelID").val();
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});	
		$("#btn_submit222").click(function(){
			tool.undisabled("#btn_submit222");					
			if($("#checkDetail_Form").validationEngine("validate")){
				var queryContainer_form = $("#checkDetail_Form");		
					$.ajax({type:'POST',
						url:'/project/afterCheck/updateOneReportInfo',
						data:JSON.stringify(queryContainer_form.serializeJson()),
						contentType:'application/json; charset=UTF-8'	,
						dataType:'json',success:function(data) {					
				        	if(data.obj==1){										
				        		window.parent.closeMenu('viewCheckPlan_Detail'+applyID);
				        		window.parent.closeMenu('viewCheckPlanDetail'+applyID);
				        		window.location.reload();
							}else{
								alert("保存失败！");
							}
				        }
					});
			
			}else{
				tool.undisabled("#btn_submit222");
			}
		});
		
		$("#btn-close").click(function(){
			window.parent.closeMenu('viewCheckPlanDetail'+applyID);
		});
		$.ajax({type:'POST',
			url:'/sys/dic/selectDepartsUserTree',
			data:JSON.stringify({}),
			contentType:'application/json,charset=UTF-8',
			dataType:'json',
			success:function(data) {
				debugger
				$("#select_user_tree_roles").selectTreeWidgets({
					width : "93%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
			}
		});
		


		$('#newRiskLevelName').attr("value",$('#newRiskLevelID option:selected').text());
		$("#newRiskLevelID").on("change", function () {//解除类型
			$('#newRiskLevelName').attr("value",$('#newRiskLevelID option:selected').text());
		});

		$('#riskLevelName').attr("value",$('#riskLevelID option:selected').text());
		$("#riskLevelID").on("change", function () {//解除类型
			$('#riskLevelName').attr("value",$('#riskLevelID option:selected').text());
		});

		$('#checkTypeName').attr("value",$('#checkTypeID option:selected').text());
		$("#riskLevelID").on("change", function () {//解除类型
			$('#checkTypeName').attr("value",$('#checkTypeID option:selected').text());
		});
});

