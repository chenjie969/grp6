(function($,z){
	$.zjm_meetingApplyRecord = {
		initTable:initTable,
		viewProMeeting:viewProMeeting,
		editProMeeting:editProMeeting,
		clickDivViewBtn:clickDivViewBtn,
		clickListViewBtn:clickListViewBtn,
		openPage:openPage
	};
	
	/**
	 * 初始化列表 
	 */
	function initTable(){
		$('#table_submitedApplyRecord').bootstrapTable('destroy');
		$('#table_submitedApplyRecord').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"meetingCode",title: '评审会编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingCode;}},
						{field:"meetingTypeName",title: '评审会类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingTypeName;}},
						{field:"meetingDateTime",title: '上会时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDateDetail(row.meetingDateTime);}},
						{field:"meetingRoomName",title: '会议室',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingRoomName;}},
						{field:"userNameList",title: '参会评委',align: 'center',formatter: function (value, row, index) { 
								var tmp = row.userNameList; 
								if(tmp != null ){
									tmp = tmp.replace(/,/g,"，"); 
								}
								return tmp;
							}
						},
						{field:"otherUserNameList",title: '列席人员',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.otherUserNameList;}},
						{field:"applyNum",title: '项目数量',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applyNum+"个";}},
						{field:"meetingStatus",title: '上会状态',align: 'center',sortable:"true",formatter: function (value, row, index) { 
								if(row.meetingStatus=="01"){ return "未上会"}
								else if(row.meetingStatus=="02"){ return "已上会"}
							}
						},
						{title:"操作",align: 'center',formatter:function(value,row,index){
								var btnStr = '<button class="btn_proArrange_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>';
								if(row.meetingStatus=="01"){
									btnStr += '<button class="btn_proArrange_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>';
								}
								return btnStr;
							},
							events:{
								'click .btn_proArrange_view': function(e, value, row, index) {
									$.zjm_meetingApplyRecord.viewProMeeting(row);
								},
								'click .btn_proArrange_edit': function(e, value, row, index) {
									$.zjm_meetingApplyRecord.editProMeeting(row);
								}
							}
						}
					 ],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
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
			url: "/project/meetingArrange/selectProMeetingPageTables",//这个接口需要处理bootstrap table传递的固定参数
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
	 * 查看一条评审会信息
	 */
	function viewProMeeting(row){
		$("#page_meetingArrangeIndex").load("/project/meetingArrange/showMeetingViewPage",{"meeting_ID":row.meeting_ID},function(response,status,xhr){
			$("#proMeetingView").modal({keyboard:true});
		});
	}
	
	/**
	 * 修改一条评审会信息
	 */
	function editProMeeting(row){
		$("#page_meetingArrangeIndex").load("/project/meetingArrange/showMeetingEditPage",{"meeting_ID":row.meeting_ID},function(response,status,xhr){
			$("#proMeeting_edit").modal({keyboard:true});
			$.zjm_zTreeJury.initTreeOne("userSetTree", "userIDList_edit", "userNameList_edit","/pro/meetingJury/selectEnableJuryTree","edit");
			$.zjm_meetingArrange.tableOperation("edit");
			$("#btn_setVotingJury_edit").click(function(){	//设置表决评委
				$.zjm_meetingArrange.setVoteJury("edit");
			});
			$("#btn_addArrangedApply_edit").click(function(){	//添加项目
				$.zjm_meetingArrange.addArrangedApply("edit");
			});
			tool.undisabled("#btn_submit_edit");
			$("#btn_submit_edit").click(function(){
				var btnID = $("i[showType=true]").attr("id");	//标识当前打开的页面形式
				var rowNum = $("#table_arrangingApply_edit tbody").find("tr").length;	//表格行数
				var meetingApplyList = new Array();  
				for(var i=0; i<rowNum; i++){
					var idList = $("#table_arrangingApply_edit tbody tr:eq("+i+") .tdVoteJuryIDList_edit").val();
					var nameList = $("#table_arrangingApply_edit tbody tr:eq("+i+") .tdVoteJuryNameList_edit").val();
					var applyID = $("#table_arrangingApply_edit tbody tr:eq("+i+") .tdApplyID_edit").val();
					var tmap = {"idList":idList,"nameList":nameList,"applyID":applyID,"order":i};
					meetingApplyList.push(tmap);
				}
				/*注册编辑验证引擎*/
				$.zjm.rules = $.zjm_meetingArrangeIndex.rules();
				zjm.validata({formId:"form_proMeeting_edit"});
				tool.disabled("#btn_submit_edit");
				var queryContainer_form = $("#form_proMeeting_edit");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/meetingArrange/updateOneMeeting",data:JSON.stringify($.extend(queryContainer_form.serializeJson(),{"mapList":meetingApplyList})),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj != null){
								$("#proMeeting_edit").modal("hide");
								if(btnID=="btn_divView"){
									$.zjm_meetingApplyRecord.clickDivViewBtn();
								}else if(btnID=="btn_listView"){
									$.zjm_meetingApplyRecord.clickListViewBtn();
								}else{
									$.zjm_meetingApplyRecord.clickDivViewBtn();
								}
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit_edit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit_edit");
				}
			});
			$("#proMeeting_edit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit_edit").unbind("click");
			});
		});
	}
	
	/**
	 * 点击列表按钮
	 */
	function clickListViewBtn(){
		$.zjm_meetingApplyRecord.initTable();
		$("#recordContent").empty();
		$("#btn_listView").css("color","#478fca").attr("showType",true);
		$("#btn_divView").css("color","#bbb").removeAttr("showType");
	}
	
	/**
	 * 点击图标按钮
	 */
	function clickDivViewBtn(){
		$("#btn_listView").css("color","#bbb").removeAttr("showType");
		$("#btn_divView").css("color","#478fca").attr("showType",true);
		$('#table_submitedApplyRecord').bootstrapTable('destroy');
		$.zjm_meetingApplyRecord.openPage("1");
	}
	
	/**
	 * div块状页面的分页方法
	 */
	function openPage(pageNumber,pageSize){
		if(typeof pageSize == "undefined" || pageSize==""){
			pageSize = 9;
		}
		$("#recordContent").load("/project/meetingArrange/showMeetingDIVPage",{"pageNumber":pageNumber,"pageSize":pageSize},function(response,status,xhr){
			$(".btn_view").click(function() {
				var meeting_ID = $(this).attr("data-meetingID");	
				var data={"meeting_ID":meeting_ID};
				$.zjm_meetingApplyRecord.viewProMeeting(data);
			});
			$(".btn_edit").click(function() {
				var meeting_ID = $(this).attr("data-meetingID");	
				var data={"meeting_ID":meeting_ID};
				$.zjm_meetingApplyRecord.editProMeeting(data);
			});
			$(".btn_print").click(function(){
				alert("尚未完成");
			});
			$(".btn_notice").click(function(){
				alert("尚未完成");
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
				$.zjm_meetingApplyRecord.openPage(pageNumber);
			});
			$("#btn_prevPage").click(function(){	//上一页
				var pageNumber = parseInt($(".pageNumber.active").children().text());
				if(pageNumber > 1){
					$.zjm_meetingApplyRecord.openPage(pageNumber-1);
				}
			});
			$("#btn_nextPage").click(function(){	//下一页
				var pageNumber = parseInt($(".pageNumber.active").children().text());
				if(pageNumber < parseInt($("#pageTotal").val())){
					$.zjm_meetingApplyRecord.openPage(pageNumber+1);
				}
			})*/
		});
	}
})(jQuery, this);

$(function () {
	
	$.zjm_meetingApplyRecord.clickDivViewBtn();
	/**
	 * 点击列表按钮
	 */
	$("#btn_listView").click(function(){
		$.zjm_meetingApplyRecord.clickListViewBtn();
	});
	
	/**
	 * 点击图标按钮
	 */
	$("#btn_divView").click(function(){
		$.zjm_meetingApplyRecord.clickDivViewBtn();
	});
	
})

