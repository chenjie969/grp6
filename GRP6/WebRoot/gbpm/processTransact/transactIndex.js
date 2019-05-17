(function($,z){
	$.zjm_transact = {
			taskTansact:taskTansact,//任务办结
			initNodeTaskTable:initNodeTaskTable,//任务办结
			loadNodeTaskForm:loadNodeTaskForm,//加载任务事项
			loadProcessImg:loadProcessImg,//加载流程跟踪
			taskReturn:taskReturn,//退回
			taskStop:taskStop//提前终止
	};

	/**初始化列表***/
	function initNodeTaskTable(taskID){
		$("#nodeTask_table").bootstrapTable('destroy');
		$('#nodeTask_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '选择',align:'center',checkbox:true,formatter: function (value, row, index) {return ;}},
				{title: '流程走向',align: 'center',formatter: function (value, row, index) { return row.nextLineName;}}, 
				{title: '下步任务名称',align: 'center',formatter: function (value, row, index) { return row.nextTaskName;}}, 
				{title: '办理人',align: 'center',formatter:function(value,row,index){
					if(row.nextAssigneeID != null){
						return row.nextAssigneeID;
					}else {
						var select = 
							"<select class='col-xs-12' onchange='getSelectText(this)' id='" + row.nextTaskDefKey + "'>"+
							"<option value=''>&nbsp;请选择</option>";
						if(row.userMap != null){
							$.each(row.userMap,function(key,value){
								select = select + "<option value="+ key +">" + value + "</option>"
							});
						}
						if(row.taskType=="userTask"){
						return [
							"<div class='col-md-12'>"+
							select +
							"</div>"
							].join('');
						}else{
							return "无";
						}
					}
				}},
				],
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: false,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
				url: "/gbpm/processInstance/selectNextTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition={"taskID":taskID};
					$.extend(params,{"queryCondition":queryCondition});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				singleSelect : true,// 单选checkbox
				strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
				showColumns: false,     //是否显示所有的列
				showRefresh: false,     //是否显示刷新按钮
				//minimumCountColumns: 2,    //最少允许的列数
				clickToSelect: false,    //是否启用点击选中行
				searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
				showToggle: false,//是否显示详细视图和列表视图的切换按钮
				showPaginationSwitch:false,
				showExport: false,                     //是否显示导出
				exportDataType: "basic"              //basic', 'all', 'selected'

		});
	};


	/**
	 * 任务办结
	 */
	function taskTansact(){

		//加载提交下一步的信息
		$("#transact_page").load(
				"/gbpm/processInstance/selectNextTaskPage",{"taskID":tool.getUrlParam("taskID")},function(response,status,xhr){
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
									if(item.taskType=='userTask'){
										if($("#"+item.nextTaskDefKey).val()==''){
											selectNull=true;
											selectNullID.push(item.nextTaskDefKey);
										}else{
											$("#"+item.nextTaskDefKey).validationEngine("showPrompt","验证通过","pass");
										}
										selectTaskUserID=selectTaskUserID+$("#"+item.nextTaskDefKey).val()+"<>";
									}
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
										window.parent.closeMenu('edit_transact'+tool.getUrlParam("entityID"));
									}else{
										alert("办结失败！");
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

	/**
	 * 加载任务事项
	 */
	function loadNodeTaskForm(url){
		$("#loadFormInfoPage").load(url,{},function(response,status,xhr){});
	}

	/**加载流程流转图*/
	function loadProcessImg(){
		// 获取图片资源
	    var imageUrl = "/gbpm/processInstance/selectProcessDiagram?processInstanceID=" + tool.getUrlParam("processInstanceID") + "&procDefID="+tool.getUrlParam("procDefID");
	    $.getJSON('/gbpm/processInstance/selectProcessTrace?processInstanceID=' + tool.getUrlParam("processInstanceID"), function(infos) {

	        var positionHtml = "";

	        // 生成图片
	        var varsArray = new Array();
	        $.each(infos.obj, function(i, v) {
	            var  positionDiv="<div class='activity-attr' style='position:absolute;left:"+(v.x + 15)+
	            ";top:"+(v.y - 1)+
	            ";width:"+(v.width + 2)+
	            ";height:"+(v.height + 2)+
	            ";backgroundColor:black"+
	            ";opacity:0"+
	            ";zIndex:999999"+
	            ";'>   </div>";
	            // 节点边框
	            var  border="<div style='position:absolute;left:"+(v.x + 15)+
	            ";top:"+(v.y - 1)+
	            ";width:"+(v.width + 2)+
	            ";height:"+(v.height + 2)+
	            ";zIndex:999998"+
	            ";'>   </div>";

	            if (v.currentActiviti) {
	                
	                border="<div style='position:absolute;left:"+(v.x + 15)+
		            ";top:"+(v.y - 1)+
		            ";width:"+(v.width + 2)+
		            ";height:"+(v.height + 2)+
		            ";zIndex:999998"+
		            ";border:3px solid red"+
		            ";border-radius: 5px"+
		            ";'>   </div>";
	            }
	            positionHtml += positionDiv + border;
	            varsArray[varsArray.length] = v.vars;
	        });

	        $('#img_page').attr('src', imageUrl);
            $('#div_img_page').html(positionHtml);
	        
	        // 设置每个节点的data
	        $('#workflowTraceDialog .activity-attr').each(function(i, v) {
	            $(this).data('vars', varsArray[i]);
	        });

	        
	     // 此处用于显示每个节点的信息，如果不需要可以删除
            $('.activity-attr').qtip({
                content: function() {
                    var vars = $(this).data('vars');
                    var tipContent = "<table class='need-border'>";
                    $.each(vars, function(varKey, varValue) {
                        if (varValue) {
                            tipContent += "<tr><td class='label'>" + varKey + "</td><td>" + varValue + "<td/></tr>";
                        }
                    });
                    tipContent += "</table>";
                    return tipContent;
                },
                position: {
                    at: 'bottom left',
                    adjust: {
                        x: 3
                    }
                }
            });
            // end qtip

	        
	    });
		
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



})(jQuery, this);

$(function () {
	//办结，提交下一步
	$("#btn_taskTransact").click(function(){
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
	$(".btn_taskForm").click(function(){
		$.zjm_transact.loadNodeTaskForm($(this).attr("href-data"));
	});
	//加载默认标签页
	$.zjm_transact.loadNodeTaskForm($(".active.btn_taskForm").attr("href-data"));
	//加载流程跟踪图
	$.zjm_transact.loadProcessImg();
});

