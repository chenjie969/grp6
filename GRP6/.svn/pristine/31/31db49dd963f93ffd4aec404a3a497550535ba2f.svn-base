(function($,z){
	$.zjm_meetingArrange = {
			initAwaitingMeetingTable:initAwaitingMeetingTable,//初始化待安排会议列表
			initAwaitedMeetingTable:initAwaitedMeetingTable,//初始化已安排会议列表
			meetingAdd:meetingAdd,//添加会议
			awaitingMeetingView:awaitingMeetingView, //查看待安排会议详情
			awaitedMeetingView:awaitedMeetingView  //查看已安排会议详情
		
	};

	/**加载待安排会议列表***/
	function initAwaitingMeetingTable(){
		$('#approvalMeeting_table').bootstrapTable('destroy');
		$('#approvalMeeting_table').bootstrapTable({
			method: 'post',
			columns: [  {field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1 ;}},	
				       {title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"title",title: '标题',align: 'center',formatter: function (value, row, index) { return row.title;}},
						{field:"productName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.productName;}},
						{field:"nodeNames",title: '当前环节',align: 'center',formatter: function (value, row, index) { return row.nodeNames;}},
						{field:"createUserName",title: '创建人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
						{field:"createDate",title: '创建日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.createDate);}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
									'<button class="btn_awaitMeeting_view btn btn-xs btn-warning"title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								
								'click .btn_awaitMeeting_view': function(e, value, row, index) {
									$.zjm_meetingArrange.awaitingMeetingView(row);
								}
							}
						}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			/*sortOrder: "desc",     //排序方式
			sortName: "createDate",     //排序字段
*/			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/riskMeetingRec/selectAwaitingMeetingPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/* 初始化已安排会议列表*/
	function initAwaitedMeetingTable(){
		$('#approvalMeet_table').bootstrapTable('destroy');
		$('#approvalMeet_table').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"meetingName",title: '会议名称',align: 'center',formatter: function (value, row, index) { return row.meetingName;}},
						{field:"meetingTypeName",title: '会议类型',align: 'center',formatter: function (value, row, index) { return row.meetingTypeName;}},
						{field:"meetingDateTime",title: '会议时间',sortable: true,align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.meetingDateTime);}},
						{field:"meetingRoomName",title: '会议室',align: 'center',formatter: function (value, row, index) { return  row.meetingRoomName;}},
						{field:"userNameList",title: '参会人员',align: 'center',formatter: function (value, row, index) { return row.userNameList;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
							return [
								
								'<button class="btn_awaitedMeeting_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_awaitedMeeting_view': function(e, value, row, index) {
								$.zjm_meetingArrange.awaitedMeetingView(row);
							}
						}
					}
				],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName: "updateDateTime",     //排序字段
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/riskMeetingRec/selectAwaitedMeetingPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			/*queryParams: function(params) {
				 var queryCondition ={"apply_clientType":"01","apply_approvalStatu":"01"}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
*/		
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
			showExport: true,                     //是否显示导出
			exportDataType: "basic" 
		});
	}
	
	/**
	 * 
	 * 新增会议
	 * @returns
	 */
		function meetingAdd(){
			var selectContent = $('#approvalMeeting_table').bootstrapTable('getSelections');  
			if(typeof(selectContent) == 'undefined' || selectContent.length == 0) { 
				$("#pleaseSelectOne").modal({keyboard:true});
				$("#message").text("请至少选择一条数据，然后再操作！")
				return false;  
			}else{
				var riskScheme_ID = "";
				for(var i=0; i<selectContent.length; i++){
					riskScheme_ID = riskScheme_ID +"'"+selectContent[i].riskScheme_ID+"'";
					if(i != selectContent.length-1){
						riskScheme_ID += ",";
					}
				}
				
			$("#awaitingMeeting_page").load("/project/riskMeetingRec/showRiskMeetingRecPage",{'riskScheme_ID':riskScheme_ID},function(response,status,xhr){
				$("#addMeeting").modal({keyboard:true});
				zjm.validata({formId:"meetingAdd_form"});
				/*参会人员 */
				$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						$("#userNameList").selectTreeWidgets({
							width : "87%",//设置控件宽度
							multiple : true,//是否多选
							data : data.obj//数据源
						});
						
				    }
				});
				/*创建人  */
				$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {		
						$("#createUserID").selectTreeWidgets({
							width : "87%",//设置控件宽度
							multiple : false ,//是否多选
							data : data.obj//数据源
						});
				    }
				});
				
				$('#meetingRoomName').attr("value",$('#meetingRoom_ID option:selected').text());
				$("#meetingRoom_ID").on("change", function () {
					$('#meetingRoomName').attr("value",$('#meetingRoom_ID option:selected').text());
			    });
				
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					var queryContainer_form = $("#meetingAdd_form");
					if($(queryContainer_form).validationEngine("validate")){
								$.ajax({type:'POST',url:'/project/riskMeetingRec/insertOneArrangeMeeting',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
									success:function(data) {
							        	if(data.obj){
											$("#addMeeting").modal("hide");
											window.location.reload();
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
				$("#addMeeting").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
		}
		}
		/**查看待安排上会信息*/
		function awaitingMeetingView(row){
			//$("#awaitingMeeting_page").load("/project/riskMeetingRec/showAwaitingMeetingPage",{'riskScheme_ID':row.riskScheme_ID},function(response,status,xhr){
				//$("#awaitingMeetingView").modal({keyboard:true});
			//});
			$("#awaitingMeeting_page").load("/project/riskScheme/selectOneRiskSchemeInfo",{"riskScheme_ID":row.riskScheme_ID},function(response,status,xhr){
				$("#riskSchemeWorkInfo").modal({keyboard:true});
			});
			
		}
		
		/**查看已安排会议信息*/
		function awaitedMeetingView(row){
			$("#awaitedMeeting_page").load("/project/riskMeetingRec/showAwaitedMeetingPage",{'riskMeetingRec_ID':row.riskMeetingRec_ID},function(response,status,xhr){
				$("#awaitedMeetingView").modal({keyboard:true});
			});
		}
		
})(jQuery, this);

$(function () {
	$.zjm_meetingArrange.initAwaitingMeetingTable();
	$(".form-control-ztb").attr("placeholder",'输入标题或关键人,回车搜索');
	$("#approvalingMeeting").click(function(){
		$.zjm_meetingArrange.initAwaitingMeetingTable();
		$(".form-control-ztb").attr("placeholder",'输入标题或关键人,回车搜索');
	});
	$("#approvaledMeeting").click(function(){
		$.zjm_meetingArrange.initAwaitedMeetingTable();
		$(".form-control-ztb").attr("placeholder",'输入名称或类型,回车搜索');
	});
	// 
	$("#btn_addMeeting").click(function(){
		$.zjm_meetingArrange.meetingAdd();
	});
	
	
});

