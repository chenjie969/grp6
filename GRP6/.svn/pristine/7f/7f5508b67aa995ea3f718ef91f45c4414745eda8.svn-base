(function($,z){
	$.zjm_nodeTaskModal = {
			initNodeTaskModal:initNodeTaskModal,//初始化流程列表
			initNodeTaskTable:initNodeTaskTable,//初始化流程列表
	};
	
		
		/**
		 * 下一步，设置下一节点下任务事项办理人
		 * @returns
		 * 十个参数  1，产品ID 2，节点顺序 3，流程发起人ID 4，流程发起人名称 5，当前办理人ID 6，当前办理人名称 7.业务ID 8，业务类型：申请：01 打包：02 化解方案：03 9.项目名称/标题 10 实例化流程ID
		 */
		function initNodeTaskModal(productID,nodeSort,startProductID,startProductName,nowUserID,nowUserName,entityID,entityType,projectName,productInstanceID){
			$("#nodeTaskModal_page").load("/gbpm/productNode/setNodeTaskPage",{"productID":productID,"nodeSort":nodeSort,"entityID":entityID},function(response,status,xhr){
				$("#nodeTaskModal").modal({keyboard:true});
				$("#productID").val(productID);
				$("#productInstanceID").val(productInstanceID);
				$("#entityID").val(entityID);
				$("#entityName").val(projectName);
				$("#entityType").val(entityType);
				$("#nodeSort").val(nodeSort);
				$("#productInstanceID").val(productInstanceID);
				$(".sProjectName").html(projectName);
				//六个参数  1，productID产品ID 2，节点顺序 3，流程发起人ID 4，流程发起人Name 5，当前办理人ID 6，当前办理人Name 
				$.zjm_nodeTaskModal.initNodeTaskTable(productID,nodeSort,startProductID,startProductName,nowUserID,nowUserName);
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					var selectContent = $('#nodeTask_table').bootstrapTable('getSelections').length;
					var isAutoAssign = $("#isAutoAssign").val();
					if(isAutoAssign == 'false'){
						if(selectContent == 0){
				        	$("#pleaseSelectOne").modal({keyboard:true});
				        	return false;  
				        }else{
							tool.disabled(".btn_submit");
							if($("#nodeTaskForm").validationEngine("validate")){
								var nodeTaskIDS = '';
								$.map($('#nodeTask_table').bootstrapTable('getSelections'), function(row) {
									nodeTaskIDS = nodeTaskIDS + row.nodeTask_ID + ',';
				     			});//多选
								$("#nodeTaskIDS").val(nodeTaskIDS);
								var queryContainer_form = $("#nodeTaskForm");
								$.ajax({type:'POST',url:'/gbpm/productInstance/insertOneProductInstanceInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									if(data.obj==true){
			     						$("#nodeTaskModal").modal("hide");
			     						alert(productInstanceID);
			     						alert(entityType);
			     						if(productInstanceID == ''){
			     							if(entityType == '01'){
				     							$.zjm_projectApply.initTable();
				     						}else if(entityType == '02'){
				     							$.zjm_projectPackage.initPackageTable();
				     						}else if(entityType == '03'){
				     							$.zjm_keyproject.initApprovalRecordTable();
				     						}
			     						}else{
			     							window.parent.openMenu('projectDeal'+entityID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+entityID,'1');
			     						}
			     					}else{
			     						alert("办理人设置失败！");
			     					}
		     		        	}});	
							}else{
								tool.undisabled(".btn_submit");
							}
				        }
					}else{
						tool.disabled(".btn_submit");
						if($("#nodeTaskForm").validationEngine("validate")){
							$.map($('#nodeTask_table').bootstrapTable('getSelections'), function(row) {
			     			});//多选
							var queryContainer_form = $("#nodeTaskForm");
							$.ajax({type:'POST',url:'/gbpm/productInstance/insertOneProductInstanceInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		     		        	if(data.obj==true){
		     						$("#nodeTaskModal").modal("hide");
		     						if(productInstanceID == ''){
		     							if(entityType == '01'){
			     							$.zjm_projectApply.initTable();
			     						}else if(entityType == '02'){
			     							$.zjm_projectPackage.initPackageTable();
			     						}else if(entityType == '03'){
			     							$.zjm_keyproject.initApprovalRecordTable();
			     						}
		     						}else{
		     							if(entityType != '03'){
		     								window.parent.openMenu('projectDeal'+entityID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+entityID,'1');
			     						}else{
			     							window.parent.openMenu('riskrojectDeal'+entityID,'','项目办理','/project/projectTracking/riskProjectDeal','&riskScheme_ID='+entityID,1);
			     						}
		     							
		     						}
		     					}else{
		     						alert("办理人设置失败！");
		     					}
	     		        	}});	
						}else{
							tool.undisabled(".btn_submit");
						}
					}
				});
				$("#nodeTaskModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			});
		};
		
		/**初始化列表***/
		function initNodeTaskTable(productID,nodeSort,startProductID,startProductName,nowUserID,nowUserName){
			$("#nodeTask_table").bootstrapTable('destroy');
			$('#nodeTask_table').bootstrapTable({
				method: 'get',
				columns: initColunmns(startProductID,startProductName,nowUserID,nowUserName),
				detailView: false,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>任务事项:</b> ' + row.taskName + '</p>');
			        html.push('<p><b>前置任务:</b> ' + row.beforeTaskName + '</p>');
			        html.push('<p><b>后置任务:</b> ' + row.afterTaskNameList+ '</p>');
			        html.push('<p><b>提醒方式:</b> ' + row.warnMethodNameList + '</p>');
			        html.push('<p><b>操作者类型:</b> ' + row.operaterTypeName + '</p>');
					return html;
				},
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortName:"taskSort",
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
				url: "/gbpm/nodeTask/selectNodeTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition={"productID":productID,"nodeSort":nodeSort};
					$.extend(params,{"queryCondition":queryCondition});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
				showColumns: false,     //是否显示所有的列
				showRefresh: false,     //是否显示刷新按钮
				minimumCountColumns: 2,    //最少允许的列数
				clickToSelect: false,    //是否启用点击选中行
				searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
				showToggle: false,//是否显示详细视图和列表视图的切换按钮
				showPaginationSwitch:false,
				showExport: false,                     //是否显示导出
				exportDataType: "basic"              //basic', 'all', 'selected'
						
			});
		};
		
		/**初始化列表***/
		function initColunmns(startProductID,startProductName,nowUserID,nowUserName){
			var isAutoAssign = $("#isAutoAssign").val();
			var columns = [];
			if(isAutoAssign == 'false'){
				columns.push({field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}});
			};
			columns.push({field:"dicTypeName",title: '任务事项',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taskName;}}, 
					{field:"operaterTypeName",title: '操作者类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operaterTypeName;}},
					{field:"operaterTypeName",title: '操作者',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operatorName;}},
					{title: '办理人',align: 'center',formatter:function(value,row,index){
						if(row.operaterTypeName == "部门负责人"){
							return $("#departLeaderName").val()
							+"<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + $("#departLeaderID").val() + ">" + 
							"<input type='hidden' name='handleUserName' value=" + $("#departLeaderName").val() + ">";
						}else if(row.operaterTypeName == "流程发起人"){
							return startProductName
							+"<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + startProductID + ">" + 
							"<input type='hidden' name='handleUserName' value=" + startProductName + ">";
						}else if(row.operaterTypeName == "当前办理人"){
							return nowUserName
								+ "<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
								"<input type='hidden' name='handleUserID' value=" + nowUserID + ">" + 
								"<input type='hidden' name='handleUserName' value=" + nowUserName + ">";
						}else if(row.operaterTypeName == "A角"){
							return $("#amanName").val()
							+ "<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + $("#amanID").val() + ">" + 
							"<input type='hidden' name='handleUserName' value=" + $("#amanName").val() + ">";
						}else if(row.operaterTypeName == "B角"){
							return $("#bmanName").val()
							+ "<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + $("#bmanID").val() + ">" + 
							"<input type='hidden' name='handleUserName' value=" + $("#bmanName").val() + ">";
						}else if(row.operaterTypeName == "风控复核人"){
							return $("#reviewManName").val()
							+ "<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + $("#reviewManID").val() + ">" + 
							"<input type='hidden' name='handleUserName' value=" + $("#reviewManName").val() + ">";
						}else if(row.operaterTypeName == "法务审核人"){
							return $("#legalManName").val()
							+ "<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + $("#legalManID").val() + ">" + 
							"<input type='hidden' name='handleUserName' value=" + $("#legalManName").val() + ">";
						}else if(row.operaterTypeName == "角色中任何人"){
							return row.operatorName
							+ "<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
							"<input type='hidden' name='handleUserID' value=" + row.operatorID + ">" + 
							"<input type='hidden' name='handleUserName' value=" + row.operatorName + ">";
						}else if(row.operaterTypeName == "角色中某一人"){
							var select = 
								"<select name='handleUserID' class='col-xs-12 validate[required]' onchange='getSelectText(this)' id=handleUserList" + row.nodeTask_ID + ">"+
								"<option value=''>&nbsp;请选择</option>";
							if(row.handleUserMap != null){
								$.each(row.handleUserMap,function(key,value){
									select = select + "<option value="+ key +">" + value + "</option>"
								});
							}
							return [
								"<input type='hidden' name='nodeTaskID' value=" + row.nodeTask_ID + ">" + 
								"<input type='hidden' name='handleUserName' id=handleUserName" + row.nodeTask_ID + ">" + 
								"<div class='col-md-12'>"+
								select +
								"</div>"
								].join('');
						}
					}});
			return columns;
				
		};
})(jQuery, this);

$(function () {
	
});

