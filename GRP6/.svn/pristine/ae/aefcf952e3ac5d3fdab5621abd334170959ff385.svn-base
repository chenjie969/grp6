(function($,z){
	$.zjm_transact = {
			taskTansact:taskTansact,//任务办结
			loadNodeTaskForm:loadNodeTaskForm,//加载任务事项
			taskReturn:taskReturn,//退回
			taskStop:taskStop,//提前终止
			taskSugget:taskSugget//填写意见
	};



	/**
	 * 任务办结
	 */
	function taskTansact(){
		//加载提交下一步的信息
		$("#transact_page").load(
				"/gworkFlow/returnDoActionFlag",{"flowID":tool.getUrlParam("flowID")
					,"actionID":$("#actionID").val(),"projectID":tool.getUrlParam("projectID")},function(response,status,xhr){
				}
		);
	}

	/**
	 * 加载任务事项
	 */
	function loadNodeTaskForm(indexes,url,projectID,flowType,stepName,stepID,type,flowID,businessId,businessType){
		
		var htmlContainer = 
			[
			 '<div id="loadFormInfoPage'+indexes+'"></div>'
			];
		if($("#loadFormInfoPage"+indexes).length <= 0 ){
			$("#loadFormInfoPage").append(htmlContainer.join(''));
		}
		
		
		
		$("#loadFormInfoPage"+indexes).load(
				url,
				{
					"projectID":projectID,"businessId":businessId, "businessType":businessType
					,"flowType":flowType,"flowID":flowID
					,"stepName":stepName,"stepID":stepID,"type":type
				},
				function(response,status,xhr){});
	}

	/**
	 * 任务退回
	 */
	function taskReturn(){

		//加载提交下一步的信息
		$("#transact_page").load(
				"/gbpm/processInstance/selectHisTaskPage",{"taskID":tool.getUrlParam("taskID")},function(response,status,xhr){
					$("#taskTansact").modal({keyboard:true});
					$.zjm_transact.initNodeTaskTable(tool.getUrlParam("taskID"));
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");

						var selectContent = $('#nodeTask_table').bootstrapTable('getSelections')[0];  
						if(typeof(selectContent) == 'undefined') {  
							$("#pleaseSelectOne").modal({keyboard:true});
							tool.undisabled(".btn_submit");
							return false;  
						}else{ 
							if($("#nextTask_form").validationEngine("validate")){
								var allTask=$('#nodeTask_table').bootstrapTable('getData');
								var allTaskKey="";
								$.each(allTask, function(i, item){ 
									allTaskKey=allTaskKey+item.nextTaskDefKey+"<>";
								});

								var selectTask=$('#nodeTask_table').bootstrapTable('getSelections');
								var selectTaskKey="";
								var selectTaskUserID="";
								var selectNull=false;
								var selectNullID=[];
								$.each(selectTask, function(i, item){ 
									selectTaskKey=selectTaskKey+item.nextTaskDefKey+"<>";
									if($("#"+item.nextTaskDefKey).val()==''){
										selectNull=true;
										selectNullID.push(item.nextTaskDefKey);
									}else{
										$("#"+item.nextTaskDefKey).validationEngine("showPrompt","验证通过","pass");
									}
									selectTaskUserID=selectTaskUserID+$("#"+item.nextTaskDefKey).val()+"<>";
								});
								if(selectNull){
									$.each(selectNullID, function(i, item){ 
										$("#"+item).validationEngine("showPrompt","*此处不可空白","error");
										
									});
									tool.undisabled(".btn_submit");
									return false;
								}
								$.ajax({type:'POST',url:'/gbpm/processInstance/createProcessTaskTaskFinish',data:JSON.stringify({"taskID":tool.getUrlParam("taskID"),"nextAllTaskKeys":allTaskKey,"nextTaskKeys":selectTaskKey,"nextTaskUserIDs":selectTaskUserID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									if(data.obj==1){
										$("#taskTansact").modal("hide");
									}else{
										alert("退回失败！");
										tool.undisabled(".btn_submit");
									}
								}
								});
							}else{
								tool.undisabled(".btn_submit");
							}
						}
					});
				}
		);
	}
	
	
	/**提前中止**/
	function taskStop(){
		$("#transact_page").load(
				"/gbpm/processInstance/stopProcessInstancePage",{},function(response,status,xhr){
					$("#processInstanceStop").modal({keyboard:true});
					/*设置日期初始值，默认为当天*/
					$("#stopDate").attr("value",tool.parseDate(new Date().getTime()));
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#stop_form").validationEngine("validate")){
							$.ajax({type:'POST',url:'/gbpm/processInstance/stopProcessInstance',data:JSON.stringify({"processInstanceID":tool.getUrlParam("processInstanceID"),"instanceEntity_ID":tool.getUrlParam("instanceEntity_ID"),"stopTypeID":$("#stopTypeID").val(),"stopTypeName":$("#stopTypeName").val(),"stopDate":$("#stopDate").val(),"stopReason":$("#stopReason").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
									$("#processInstanceStop").modal("hide");
									window.parent.closeMenu('edit_transact'+tool.getUrlParam("entityID"));
								}else{
									alert("中止失败！");
									tool.undisabled(".btn_submit");
								}
							}
							});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	};
	
	
	/**
	 * 填写意见
	 */
	function taskSugget(){
		//加载填写意见构件
		$("#transact_page").load(
				"/gworkFlow/flowBuild/selectOneOsGworkflowProjsuggest",{
							"flowID":tool.getUrlParam("flowID"),
							"historyID":tool.getUrlParam("historyID"),
							"stepID":tool.getUrlParam("stepID"),
							"stepName":tool.getUrlParam("stepName"),
							"projectID":tool.getUrlParam("projectID")
							},function(response,status,xhr){
				}
		);
	}



})(jQuery, this);

$(function () {
	//办结，提交下一步
	$("#btn_ostaskTransact").click(function(){
		$.zjm_transact.taskTansact();
	});
	//退回
	$("#btn_taskReturn").click(function(){
		$.zjm_transact.taskReturn();
	});
	//提前终止
	$("#btn_taskStop").click(function(){
		$.zjm_transact.taskStop();
	});
	//点击切换标签页
	/*$(".btn_taskForm").click(function(){
		$.zjm_transact.loadNodeTaskForm($(this).attr("href-data")
				,$(this).attr("entityID"),$(this).attr("entityType")
				,$(this).attr("taskName"),$(this).attr("taskID")
				,$(this).attr("type"),$(this).attr("productInstanceID"));
	});*/
	//加载默认标签页
	$("input[class='btn_taskForm']").each(function(i){
		$.zjm_transact.loadNodeTaskForm(i,$(this).attr("href-data")
			,$(this).attr("projectID"),$(this).attr("flowType")
			,$(this).attr("stepName"),$(this).attr("stepID")
			,$(this).attr("type"),$(this).attr("flowID")
			,$(this).attr("businessId"),$(this).attr("businessType"));
	});
	
	
	//填写意见
	$("#btn_ostaskSugget").click(function(){
		$.zjm_transact.taskSugget();
	});
});

