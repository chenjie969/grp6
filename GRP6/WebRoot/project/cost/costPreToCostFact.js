(function($,z){
	$.zjm_costPreToFact = {
			updateCostFact:updateCostFact,//修改
			changeCostPreToPlan:changeCostPreToPlan,//跳转到 调整计划页面
			submitToNext:submitToNext,//下一步
			submitToLast:submitToLast,//上一步
			tableAdd:tableAdd,//动态添加table
			deleteOneCostFact:deleteOneCostFact,//删除
			changeCostFact:changeCostFact,//实收费用---到账确认
	};
	function updateCostFact(costFact_ID){
		
		$("#costPreToFact_page").load("/project/costFact/returnCostFactEditPage",{"costFact_ID":costFact_ID},function(response,status,xhr){				
			$("#costFactEditPage").modal({keyboard:true});
			
			
			var zindex = parseInt($("#costPreToFact").css("z-index"));
			$("#costFactEditPage").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
			zjm.init();
			//$('#date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
			var costPre_ID = $("#costPre_ID").val();
			tool.undisabled("#btn_submitUpdateCostFact");
			$("#btn_submitUpdateCostFact").click(function(){
				tool.disabled("#btn_submitUpdateCostFact");
				if($("#costFactEdit_form").validationEngine("validate")){
					$("#costFactEditPage").modal("hide");
						var queryContainer_form = $("#costFactEdit_form");
						$.ajax({type:'POST',url:'/project/costFact/updateOneCostFact',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#costFactEditPage").modal("hide");
								$("#costPreToFact").modal("hide");
								setTimeout(function(){
									//调整成功后重新加载页面---start
									$("#costRecordIndex_page").load("/project/costPre/returnCostPreToCostFactPage",{"costPre_ID":costPre_ID},function(response,status,xhr){				
										$("#costPreToFact").modal({keyboard:true});
									});
								},200);
								//调整成功后重新加载页面---end
								
							}else{
								alert("修改失败！");
							}
						}
						});
						
				}else{
					tool.undisabled("#btn_submitUpdateCostFact");
				}
			});
			$("#costFactEditPage").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submitUpdateCostFact").unbind("click");
			});
		});
	}
	function changeCostPreToPlan(costPre_ID){
		$("#costPreToFact_page").load("/project/costPre/returnCostPreToplanPage",{"costPre_ID":costPre_ID},function(response,status,xhr){				
			$("#costPreToPlanPage").modal({keyboard:true});
			//$("#costPreToFact").modal("hide");//关闭预收转实收页面
			var zindex = parseInt($("#costPreToFact").css("z-index"));
			$("#costPreToPlanPage").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
			
			zjm.init();
			$('#planFactTableDate0').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
			tool.undisabled("#btn_submit");
			$("#btn_submitCostPlanToFact").click(function(){
				tool.disabled("#btn_submitCostPlanToFact");
				if($("#submitToLast_form").validationEngine("validate")){
					var rowNum = $("#rowNum").val();//获取数据行数
					//拼接出要提交的数据----start
				    $("#planFactTableData").attr("value",getSubmitData(rowNum));
					//拼接出要提交的数据----end
					
					//$("#costPreToPlanPage").modal("hide");//
					//$("#costPreToFact").modal("hide");
					var queryContainer_form = $("#submitToLast_form");
					$.ajax({type:'POST',url:'/project/costFact/insertCostPlanToCostFact',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==true){
							$("#costPreToPlanPage").modal("hide");
							$("#costPreToFact").modal("hide");
							setTimeout(function(){
								//调整成功后重新加载页面---start
								$("#costRecordIndex_page").load("/project/costPre/returnCostPreToCostFactPage",{"costPre_ID":costPre_ID},function(response,status,xhr){				
									$("#costPreToFact").modal({keyboard:true});
								});
							},200);
							//调整成功后重新加载页面---end
						}else{
							alert("调整失败！");
						}
					}
					});					
				}else{
					tool.undisabled("#btn_submitCostPlanToFact");
				}
			});
			$("#costPreToPlanPage").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submitCostPlanToFact").unbind("click");
			});
		});
	}
	
	//下一步:
	function submitToNext(){
		if($("#submitToNext_form").validationEngine("validate")){//通过验证
			 $("#div_submitToNext").hide();
			 $("#form_submitToNext").hide();
			 $("#div_submitToLast").show();
			 $("#form_submitToLast").show();
			var costCount = $("#costCount").val();//拆分份数
			var planFactTableDate0 = $("#planFactTableDate0").val();//首次计划实收日期
			
			var preCostSum =Number($("#preCostSum").val()).toFixed(2);//总金额
			var everyNum = (preCostSum/costCount).toFixed(2);//平均数
			
			for (var i = 1; i <= costCount; i++) {
				$.zjm_costPreToFact.tableAdd(i);
				$("#factCostSum"+i).val(everyNum);//拆分后确认收入金额（元）赋值
				//为日期赋值---start
				var year = parseInt(planFactTableDate0.substring(0,4))-1;
				var temp = planFactTableDate0.substring(4);
				$('#planFactCostDate'+i).attr("value",(year+i)+temp);//设置首次计划实收日期1
				//为日期赋值---end
				
			 }
			tableAddTotal(preCostSum);
		}else{
			tool.undisabled(".btn_submit");
		}
	
	}
	
	
	//上一步
	function submitToLast(){
		 var costCount = $("#costCount").val();//拆分份数
		//移除table下的tr
		for (var i = 1; i <= costCount; i++) {
			$("#tr"+i).remove();
		 }
		$("#total").remove();//删除合计tr
		//隐藏当前页面,显示上一步页面
		 $("#div_submitToLast").hide();
		 $("#form_submitToLast").hide();
		 $("#div_submitToNext").show();
		 $("#form_submitToNext").show();
		 
	}
	

	//新增table;
	function tableAdd(rowNum){
		$("#rowNum").val(rowNum);
		$("#table").append("<tr id='tr"+rowNum+"'>"+
				"	<td style='border:1px solid #ddd;'><!--期次 -->"+
				"		"+rowNum+" "+
				"	</td>"+
				"	<td style='border:1px solid #ddd;'><!-- 实收金额（元） -->"+
				"		<input type='text' style='width:100%;' class='validate[required,maxSize[18],custom[number]] ' name='factCostSum"+rowNum+"' id='factCostSum"+rowNum+"' value='' />"+
				"	</td>"+
				"	<td style='border:1px solid #ddd;' ><!--计划实收日期 -->"+
				"<div class='input-group'>"+
				"		<input type='text' style='width:100%;height:30px;' class=' date-picker  validate[required,custom[date]]'name='planFactCostDate"+rowNum+"' id='planFactCostDate"+rowNum+"' value='' data-date-format='yyyy-mm-dd' /> "+
				"<span class='input-group-addon' style='height:28px;'>"+
				"<i class='icon-calendar bigger-110'></i>"+
			     "</span>"+
			     "</div>"+
				"	</td>"+
				"</tr>");
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
			
	}
	//新增table合计;
	function tableAddTotal(total){
		$("#table").append("<tr id='total'>"+
				"	<th style='border:1px solid #ddd;'><!--标题 -->"+
				"		"+"合计"+" "+
				"	</th>"+
				"	<th style='border:1px solid #ddd;'><!-- 合计实收金额（元） -->"+
				"		"+total+" "+
				"	</th>"+
				"	<th style='border:1px solid #ddd;'>"+
				"	</th>"+
				
				"</tr>");
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
	}
	
	//拼接出要提交的数据
	function  getSubmitData(rowNum){
		var busiDetails = "";			
		for(var i=1;i<=rowNum;i++){
			busiDetails += $("input[name='factCostSum"+i+"']").val()+",";//依次获取金额
			busiDetails += $("input[name='planFactCostDate"+i+"']").val()+",";//依次获取日期
			busiDetails += ";";	
		}
		return busiDetails;
	}
	function deleteOneCostFact(costFact_ID){
		
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除所选数据吗?");//提示信息;
		
		var zindex = parseInt($("#costPreToFact").css("z-index"));
		$("#common_del").css("z-index",zindex+50);
		$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		
		
		var costPre_ID = $("#costPre_ID").val();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costFact/deleteOneCostFact',data:JSON.stringify({"costFact_ID":costFact_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$("#common_del").modal("hide");
						$("#costPreToFact").modal("hide");
						setTimeout(function(){
							//调整成功后重新加载页面---start
							$("#costRecordIndex_page").load("/project/costPre/returnCostPreToCostFactPage",{"costPre_ID":costPre_ID},function(response,status,xhr){				
								$("#costPreToFact").modal({keyboard:true});
							});
						},200);
						//调整成功后重新加载页面---end
						
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	function changeCostFact(costFact_ID){
		
		$("#confirmModal").modal({keyboard:true});
		
		var zindex = parseInt($("#costPreToFact").css("z-index"));
		$("#confirmModal").css("z-index",zindex+60);
		$(".modal-backdrop:eq(1)").css("z-index",zindex+50);
		
		$("#confirmValue").text("是否确认已到账?");//提示信息;
		
		
		var costPre_ID = $("#costPre_ID").val();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costFact/changeCostFact',data:JSON.stringify({"costFact_ID":costFact_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					$("#confirmModal").modal("hide");
					$("#costPreToFact").modal("hide");
					setTimeout(function(){
						//调整成功后重新加载页面---start
						$("#costRecordIndex_page").load("/project/costPre/returnCostPreToCostFactPage",{"costPre_ID":costPre_ID},function(response,status,xhr){				
							$("#costPreToFact").modal({keyboard:true});
						});
					},500);
					//调整成功后重新加载页面---end
					
				}else{
					alert("确认失败！");
				}
			}
			});
		});
		
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}
	
	
	
})(jQuery, this);
$(function () {
	$(".btn_updateCostFact").click(function(){
		var  costFact_ID= $(this).attr("id");	
		$.zjm_costPreToFact.updateCostFact(costFact_ID);
	});
	$(".btn_deleteOneCostFact").click(function(){
		var  costFact_ID= $(this).attr("id");	
		$.zjm_costPreToFact.deleteOneCostFact(costFact_ID);
	});
	
	$(".btn_changeCostFact").click(function(){
		var  costFact_ID= $(this).attr("id");	
		$.zjm_costPreToFact.changeCostFact(costFact_ID);
	});
	
	
	$("#btn_changeCostPreToPlan").click(function(){
		var  costPre_ID= $("#costPre_ID").val();
		$.zjm_costPreToFact.changeCostPreToPlan(costPre_ID);
	});
	$("#btn_submitToNext").click(function(){//点击下一步
		$.zjm_costPreToFact.submitToNext();
		tool.undisabled("#btn_submitToNext");
	});
	$("#btn_submitToLast").click(function(){//点击上一步
		$.zjm_costPreToFact.submitToLast();
	});
});

