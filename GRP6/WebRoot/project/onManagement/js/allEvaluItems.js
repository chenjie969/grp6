/*(function($,z){
	$.zjm_allEvaluItems = {
		initTable:initTable,//初始化列表
		viewAllEvaluItems:viewAllEvaluItems,//查看
		delAllEvaluItems:delAllEvaluItems
	};
	
	*//**初始化列表***//*
	function initTable(){
		$("#allEvaluItems_table").bootstrapTable('destroy');
		$('#allEvaluItems_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				
					{field:"meetingCode",title: '评审会编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingCode;}},
					{field:"meetingRoomName",title: '会议室名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingRoomName;}},
					{field:"meetingPlace",title: '会议室位置',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingPlace;}},
					{field:"userName",title: '主持人名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.userName;}},
					{field:"userNameList",title: '参会评委',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.userNameList;}},
					{field:"otherUserNameList",title: '外部专家',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.otherUserNameList;}},
					{field:"projectNameList",title: '评审会项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { 
						var proNameList = row.projectNameList;
						var key = "projectName";
						var projectNames = "";
						for (var i = 0; i < proNameList.length; i++) {
					        if(i < proNameList.length-1){
					        	if (typeof(proNameList[i]["projectName"]) != "undefined"){ 
					        		projectNames += proNameList[i]["projectName"]+"<br/>";
					        	}
					        }else{
					        	if (typeof(proNameList[i]["projectName"]) != "undefined"){ 
					        		projectNames += proNameList[i]["projectName"];
					        	}
					        }
					    };
						
						return projectNames;
						
					}},
					{field:"meetingDateTime",title: '上会时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return moment(row.meetingDateTime).format("YYYY年MM月DD日 HH:mm:ss");}},
					{field:"dicNode_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_allEvaluItems.viewAllEvaluItems(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_allEvaluItems.delAllEvaluItems(row);
							}
						}
						
					}],
			detailView: true,
			detailFormatter:function(index, row){
				var proNameList = row.projectNameList;
				var key = "projectName";
				var projectNames = "";
				for (var i = 0; i < proNameList.length; i++) {
					if(i < proNameList.length-1){
			        	if (typeof(proNameList[i]["projectName"]) != "undefined"){ 
			        		projectNames += proNameList[i]["projectName"]+"<br/>";
			        	}
			        }else{
			        	if (typeof(proNameList[i]["projectName"]) != "undefined"){ 
			        		projectNames += proNameList[i]["projectName"];
			        	}
			        }
			    };
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>评审会编号:</b> ' + row.meetingCode + '</p>');
				    html.push('<p><b>会议室名称:</b> ' + row.meetingRoomName + '</p>');
				    html.push('<p><b>会议室位置:</b> ' + row.meetingPlace + '</p>');
				    html.push('<p><b>主挂人名称:</b> ' + row.userName + '</p>');
				    html.push('<p><b>参会评委:</b> ' + row.userNameList + '</p>');
				    html.push('<p><b>外部专家:</b> ' + row.otherUserNameList + '</p>');
				    html.push('<p><b>评审会项目名称:</b> ' + projectNames + '</p>');
				    html.push('<p><b>上会时间:</b> ' + moment(row.meetingDateTime).format("YYYY年MM月DD日 HH:mm:ss") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 10,      //每页的记录行数（*）
			pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
			url: "/pro/meeting/selectAllEvaluItemsTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				// $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
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

	
	*//**查看我的评审会*//*
	function viewAllEvaluItems(row){
		$("#allEvaluItems_page").load("/pro/meeting/showOneEvaluItemsViewPage",{"meeting_ID":row.meeting_ID},function(response,status,xhr){
			$("#viewEvaluItems").modal({keyboard:true});
			$("#myModalLabel").text("查看所有评审会");
		});
	}
	*//**删除我的评审会*//*
	function delAllEvaluItems(row){
		$("#allEvaluItems_page").load("/pro/meeting/showEvaluItemsDelPage",{},function(response,status,xhr){
			$("#delEvaluItems").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/pro/meeting/deleteOneEvaluItems',data:JSON.stringify({"meeting_ID":row.meeting_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delEvaluItems").modal("hide");
							$.zjm_allEvaluItems.initTable();
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delEvaluItems").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);*/

/*$(function () {
	window.onload = floaddata;
	function floaddata() {
		$.zjm_allEvaluItems.initTable();
		$(".form-control-ztb").attr("placeholder",'输入会议室名称,按回车搜索');
	};
});*/

$(function () {
    $("#myTab").on("click", "a", function () {
        var $this = $(this);
       $("#one").load("/pro/meeting/allMeetingList", function (data) {
               updateNumberBadge();
       })
        
    }).find("[href='#one']").click();
    
    $("#one").load("/pro/meeting/allMeetingList", function (data) {
        updateNumberBadge();
    });
    
    //查看
    $(".tab-content").on("click","a.subjectView", function () {
        $("#meetingView").load("/pro/meeting/showOneEvaluItemsViewPage", 
        		{'meeting_ID': $(this).parents("div.meeting").attr("data-meeting-id").trim()}, function () {
            $("#viewEvaluItems").modal({keyboard: true});
            $("#myModalLabel").text("查看所有评审会");
          //弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    });
    
    //查看项目详细信息
    //查看
    $(".tab-content").on("click","a.subjectView1", function () {
        $("#meetingView").load("/pro/meeting/showProViewPage",
        		{'meeting_ID': $(this).parents("div.meeting").attr("data-meeting-id").trim()}, function () {
            $("#view_proName").modal({keyboard: true});
          //弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    });
    
    
    $(".tab-content").on("click", "a.view", function () {
        $("#meetingView").load("/pro/meeting/showOneEvaluItemsViewPage",
        		{'meeting_ID': $(this).parents("div.meeting").attr("data-meeting-id").trim()}, function () {
            $("#viewEvaluItems").modal({keyboard: true});
            $("#myModalLabel").text("查看所有评审会");
          //弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    })
})

function updateNumberBadge() {
      var number = $("#one").find("div.meeting").length;
      if (number) {
           $("a[href='#one'] span").text(number).show();
      } else {
           $("a[href='#one'] span").text(0).show();
      }
}
