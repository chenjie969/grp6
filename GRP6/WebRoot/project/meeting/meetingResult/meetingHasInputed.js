(function($,z){
	$.zjm_hasInputed = {
		initTable:initTable,
		showMeetingDetail:showMeetingDetail,
		clickDivViewBtn:clickDivViewBtn,
		clickListViewBtn:clickListViewBtn,
		openPage:openPage
	};
	
	/**
	 * 初始化列表
	 */
	function initTable(){
		$("#table_hasInputedMeeting").bootstrapTable('destroy');
		$("#table_hasInputedMeeting").bootstrapTable({
			method: 'post',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"meetingCode",title: '评审会编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingCode;}},
						{field:"meetingTypeName",title: '评审会类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingTypeName;}},
						{field:"meetingDateTime",title: '上会时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.meetingDateTime);}},
						{field:"meetingRoomName",title: '会议室',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingRoomName;}},
						{field:"userNameList",title: '参会评委',align: 'center',formatter: function (value, row, index) { return row.userNameList.replace(/,/g,"，");}},
						{field:"otherUserNameList",title: '列席人员',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.otherUserNameList;}},
						{field:"applyNum",title: '项目数量',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applyNum+"个";}},
						{field:"meetingStatus",title: '上会状态',align: 'center',sortable:"true",formatter: function (value, row, index) { 
								if(row.meetingStatus=="	01"){ return "未上会";}
								else if(row.meetingStatus=="02"){ return "已上会";}
							}
						},
						{title:"操作",align: 'center',formatter:function(value,row,index){
								return '<a class="btn_viewJurySuggest" href="javascript:void(0)">查看</a>';
							},
							events:{
								'click .btn_viewJurySuggest': function(e, value, row, index) {
									$.zjm_hasInputed.showMeetingDetail(row.meeting_ID);
								}
							}
						}
					 ],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName: "meetingDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/pro/meetResolution/meetingResolution/selectHasInputedMeetingPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
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
	
	/**
	 * 显示评审会详情 
	 */
	function showMeetingDetail(meeting_ID){
		$("#page_meetingResultIndex").load("/pro/meetResolution/meetingResolution/selectMeetingWithVoteResult",{"meeting_ID":meeting_ID,"showBtn":"view"},function(response,status,xhr){
			$("#proMeetingDetail").modal({keyboard:true});
			$("#btn_inputOK").hide();
			$(".btn_viewResult").click(function(){		//点击"查看决议"
				var apply_ID = $(this).attr("data-applyID");
				window.parent.openMenu('viewResult'+apply_ID,'','查看评审会决议','/pro/meetResolution/meetingResolution/openMeeingResolution','&apply_ID='+apply_ID+'&type=view');
			});
		});
	}
	
	/**
	 * 点击列表按钮
	 */
	function clickListViewBtn(){
		$.zjm_hasInputed.initTable();
		$("#divHasInputed").empty();
		$("#btn_listView").css("color","#478fca");
		$("#btn_divView").css("color","#bbb");
	}
	
	/**
	 * 点击图标按钮
	 */
	function clickDivViewBtn(){
		$("#btn_listView").css("color","#bbb");
		$("#btn_divView").css("color","#478fca");
		$('#table_hasInputedMeeting').bootstrapTable('destroy');
		$.zjm_hasInputed.openPage("1");
	}
	
	/**
	 * div块状页面的分页方法
	 */
	function openPage(pageNumber,pageSize){
		if(typeof pageSize == "undefined" || pageSize==""){
			pageSize = 9;
		}
		$("#divHasInputed").load("/pro/meetResolution/meetingResolution/showHasInputedDIVPage",{"pageNumber":pageNumber,"pageSize":pageSize},function(response,status,xhr){
			$(".btn_view").click(function() {
				var meeting_ID = $(this).attr("data-meetingID");	
				$.zjm_hasInputed.showMeetingDetail(meeting_ID);
			});
			var totalSize = Number($("#total").val());
			$("#pageDiv").paging({
				pageNo: pageNumber,
				totalSize: totalSize,
				totalPage: Math.ceil(totalSize/pageSize),	
				callback: function(num) {
					openPage(num,pageSize);
				}
			});
			/*$(".pageNumber").click(function(){
				var pageNumber = $(this).children().text();
				$.zjm_hasInputed.openPage(pageNumber);
			});
			$("#btn_prevPage").click(function(){	//上一页
				var pageNumber = parseInt($(".pageNumber.active").children().text());
				if(pageNumber > 1){
					$.zjm_hasInputed.openPage(pageNumber-1);
				}
			});
			$("#btn_nextPage").click(function(){	//下一页
				var pageNumber = parseInt($(".pageNumber.active").children().text());
				if(pageNumber < parseInt($("#pageTotal").val())){
					$.zjm_hasInputed.openPage(pageNumber+1);
				}
			})*/
		});
	}
	
})(jQuery, this);

$(function () {

	$.zjm_hasInputed.clickDivViewBtn();
	/**
	 * 点击列表按钮
	 */
	$("#btn_listView").click(function(){
		$.zjm_hasInputed.clickListViewBtn();
	});
	
	/**
	 * 点击图标按钮
	 */
	$("#btn_divView").click(function(){
		$.zjm_hasInputed.clickDivViewBtn();
	});
	
});
