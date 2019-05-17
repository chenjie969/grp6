(function ($, z) {
    $.zjm_optManager = {
        addMainMeetingApply:addMainMeetingApply,//
		initClientTable : initClientTable,//初始化列表
        
		addPakageMeetingApply:addPakageMeetingApply,//
		initPakageTable : initPakageTable,//初始化列表
		
        addMeetingApply:addMeetingApply
        
    };
    
    $("#active_apply_modal").click(function(){
		$.zjm_optManager.addMeetingApply();
	});
    
	
    /**添加申请会议*/
	function addMeetingApply(){
		$("#applyModal").load("/pro/meeting/meetingApplyAdd",{},function(response,status,xhr){
			$("#add_meeting").modal({keyboard:true});
			//出席人员
			//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
			
			$("#selectClient0").click(function(){
				$.zjm_optManager.addMainMeetingApply();
			});
			$("#selectClient1").click(function(){
				$.zjm_optManager.addPakageMeetingApply();
			});
			initModal();
			/*注册编辑验证引擎*/
            $("#add_meeting").on("hidden.bs.modal", function () {
                $(this).data('bs.modal', null);
                $("#calendar").fullCalendar('refetchEvents')
            });
			zjm.validata({formId:"meetingApply_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#meetingApply_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("meetingCode","/pro/meeting/isExistMeetingCode",JSON.stringify(queryContainer_form.serializeJson()),"评审会编号重复！")){
							$.ajax({
								type : 'POST',
								url : '/pro/meeting/insertOneMeetingApply',
								data : JSON
										.stringify(queryContainer_form
												.serializeJson()),
								contentType : 'application/json; charset=UTF-8',
								dataType : 'json',
								success:function(data) {
						        	if(data.obj){
										$("#add_meeting").modal("hide");
										
										  $("#one").load("/pro/meeting/applyRecordList?approvalStatus=01&keyword=" + "", function (data) {
								                updateNumberBadge("01");
								          })
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
					}else{
						tool.undisabled(".btn_submit");
					}
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#add_meeting").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
    
    //初始申请项目清单
	var initMeetingApplyData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		{field : 'apply_ID',title : '项目id',hide:'true',formatter : function(value, row, index) {return row.apply_ID;}},
		{field : 'projectName',title : '申请项目名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.projectName;}},
	];
	//申请项目清单
    function addMainMeetingApply(){
		$("#clientListModal").load("/pro/meeting/clientListModalAdd",{},function(response,status,xhr){
			$.zjm_optManager.initClientTable();//初始化列表
			$("#clientList_ID").text("选择申请项目");
			
			var zindex = parseInt($("#add_meeting").css("z-index"));	//获取第一个模态窗的z-index。bootstrap的默认值，模态窗：z-index=1050，遮罩层：z-index=1040
	    	
	    	$("#clientList").modal({keyboard: true});
			$("#clientList").css("z-index",zindex+50);	//设置第二个模态窗的z-index，值比第一个模态窗大一些。
			$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);	//获取第二个模态窗弹出时生成的遮罩层，并设置其z-index值，比第一个模态窗的z-index要大，比第二个模态窗的z-index要小
			
			/*$("#clientList").modal({keyboard:true});*/
			$(".btn_addadd").click(function(){
				var selectContent = $("#client-table").bootstrapTable('getSelections');		
				//$("#entityID").val(selectContent[0].apply_ID);
				//$("#projectName").val(selectContent[0].projectName);
				var selectContent = $("#client-table").bootstrapTable('getSelections');		
				var apply_ID = selectContent[0].apply_ID;
				var projectName = selectContent[0].projectName;
							
				for(var i=1;i<selectContent.length;i++){
					apply_ID =apply_ID+","+selectContent[i].apply_ID;
					projectName =projectName+","+selectContent[i].projectName;
				}
				
				$("#entityID").val(apply_ID);
				$("#projectName").val(projectName);			
				$("#clientList").modal("hide");
				
			});
			$("#clientList").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_addadd").unbind("click");
			});
	    });
	};
	
	/**初始化申请项目清单列表***/
	function initClientTable(){
		$("#client-table").bootstrapTable('destroy');
		$('#client-table').bootstrapTable({
			columns:initMeetingApplyData,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : false,//多选
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			sortName:'createDate',
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: '/project/apply/selectMeetProjectApplyPageTable',//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
		$('#client-table').bootstrapTable('hideColumn', 'apply_ID');
	};
	//初始打包项目清单
	var initPakageMeetingApplyData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		{field : 'package_ID',title : '项目id',hide:'true',formatter : function(value, row, index) {return row.package_ID;}},
		{field : 'packageName',title : '打包项目名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.packageName;}},
	];
	//打包项目清单
	function addPakageMeetingApply(){
    	$("#clientListModal").load("/pro/meeting/clientListModalAdd",{},function(response,status,xhr){
    		$.zjm_optManager.initPakageTable();//初始化列表
			$("#clientList_ID").text("选择打包项目");
			
			//获取第一个模态窗的z-index。bootstrap的默认值，模态窗：z-index=1050，遮罩层：z-index=1040
			var zindex = parseInt($("#add_meeting").css("z-index"));	
	    	
	    	$("#clientList").modal({keyboard: true});
			$("#clientList").css("z-index",zindex+50);	//设置第二个模态窗的z-index，值比第一个模态窗大一些。
			//获取第二个模态窗弹出时生成的遮罩层，并设置其z-index值，比第一个模态窗的z-index要大，比第二个模态窗的z-index要小
			$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);
			
			/*$("#clientList").modal({keyboard:true});*/
			$(".btn_addadd").click(function(){
				var selectContent = $("#client-table").bootstrapTable('getSelections');	
				
				var package_ID = selectContent[0].package_ID;
				var packageName = selectContent[0].packageName;
				for(var i=1;i<selectContent.length;i++){
					package_ID =package_ID+","+selectContent[i].package_ID;
					packageName =packageName+","+selectContent[i].packageName;
				}
				$("#packEagentityID").val(package_ID);
				$("#packageProName").val(packageName);
				$("#clientList").modal("hide");
				
			});
			$("#clientList").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_addadd").unbind("click");
			});
		});
	};
	
	/**初始化 打包项目清单列表***/
	function initPakageTable(){
		$("#client-table").bootstrapTable('destroy');
		$('#client-table').bootstrapTable({
			method: 'get',
			columns: initPakageMeetingApplyData,
			/*detailView: true,
			detailFormatter:function(index, row){
				var html = [];
				html.push('<p><b>序号:</b> ' + tool.isNull(row.clientBH,"") + '</p>');
		        html.push('<p><b>打包项目编号:</b> ' + row.personName + '</p>');
		        html.push('<p><b>打包项目名称:</b> ' + tool.isNull(row.clientName,"") + '</p>');
		        html.push('<p><b>子项目编号:</b> ' + tool.isNull(row.personNum,"") + '</p>');
		        html.push('<p><b>子项目名称:</b> ' + tool.isNull(row.sex,"") + '</p>');
		        html.push('<p><b>申请金额（万元）:</b> ' + tool.isNull(row.sex,"") + '</p>');
		        html.push('<p><b>打包部门:</b> ' + tool.isNull(row.age,"") + '</p>');
		        html.push('<p><b>打包人:</b> ' + tool.isNull(row.position,"") + '</p>');
		        html.push('<p><b>打包日期:</b> ' + tool.isNull(row.domicile,"") + '</p>');
				return html;
			},*/
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : false,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"createDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/package/selectMeetingPackagePageTable",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			//queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
			showExport: false,                     //是否显示导出
			exportDataType: "basic"              //basic', 'all', 'selected'
		});
		$('#client-table').bootstrapTable('hideColumn', 'package_ID');
	};
	
	
})(jQuery, this);

$(function () {
    /**
     * 文档加载的时候 读取
     */
	
    $("#calendar").fullCalendar({
        locale: 'zh-cn',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        // slotDuration: moment.duration(1, 'hours'),
        slotMinutes: 60,
        minTime: '08:00:00',
        maxTime: '18:00:00',
        views: {
            basic: {
                // options apply to basicWeek and basicDay views
            },
            agenda: {
                // options apply to agendaWeek and agendaDay views
            },
            week: {
                // options apply to basicWeek and agendaWeek views
            },
            day: {
                // options apply to basicDay and agendaDay views
            }
        },
        
        events: {
            url: '/pro/meeting/meetingEventArray',
            data: function () { // a function that returns an object
                return {
                	meetingRoom_ID: $(".meeting-room.active").attr("id")
                };
            }
        },
        eventRender: function (event, element) {
            var date = moment(event.start).format("YYYY年MM月DD日 HH:mm:ss");
            var upDatime = moment(event.upDatime).format("YYYY年MM月DD日 HH:mm:ss");
            var meetStatus = event.meetStatus;
            var meetSta ="";
            if(meetStatus='01'){
            	meetSta="待审核";
            }else if(meetStatus='02'){
            	meetSta="已通过";
            }else if(meetStatus='03'){
            	meetSta="被拒绝";
            }else{
            	meetSta="其他";
            }
            
            element.qtip({
                content: '<b>'+event.title + '</b><br><br><b>会议室:&nbsp;</b> ' + event.meetingRoom + '<br><br><b>会议室位置:&nbsp;</b> ' + event.position+
                '</b><br><br><b>主持人:&nbsp;</b> '+event.userName+'</b><br><br><b>参与评委:&nbsp;</b> '+event.userNameList+
                '</b><br><br><b>外部专家:&nbsp;</b> '+event.otherUsers+'</b><br><br><b>上会时间:&nbsp;</b> '+date+
                '<br><br><b>申请时间:&nbsp;</b> ' + upDatime + '</b><br><br><b>申请人:&nbsp;</b> '+event.upUserName+
                '</b><br><br><b>审核状态:&nbsp;</b> '+meetSta+'</b><br><br><b>项目:&nbsp;</b> '+event.projectName
            })
        }
    });
    $("[href='#tab_meeting_record']").on("click", function () {
        var $meetingRecord = $("#tab_meeting_record");
        if (!$meetingRecord.hasClass("initialized")) {
            $meetingRecord.load("/pro/meeting/meetingRecord", function () {
                $meetingRecord.addClass("initialized");
                initRecordPage();
            });

        }
    })
    $(".meeting-room").on("click", function () {
        var $this = $(this);
        if (!$this.is(".active")) {
            $this.addClass("active").siblings(".meeting-room").removeClass("active");
            $("#calendar").fullCalendar('refetchEvents')
        }
    })
    
});

