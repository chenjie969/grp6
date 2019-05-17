(function($,z){
	$.zjm_notVote = {
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
		$("#table_notVoteMeeting").bootstrapTable('destroy');
		$("#table_notVoteMeeting").bootstrapTable({
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
								if(row.meetingStatus=="01"){ return "未上会";}
								else if(row.meetingStatus=="02"){ return "已上会";}
							}
						},
						{title:"操作",align: 'center',formatter:function(value,row,index){
								return '<a class="btn_addJurySuggest" href="javascript:void(0)">项目表决</a>';
							},
							events:{
								'click .btn_addJurySuggest': function(e, value, row, index) {
									$.zjm_notVote.showMeetingDetail(row.meeting_ID);
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
			url: "/project/jurySuggest/selectNotVoteMeetingPageTables",//这个接口需要处理bootstrap table传递的固定参数
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
		$("#page_jurySuggestIndex").load("/project/jurySuggest/selectMeetingWithJurySuggest",{"meeting_ID":meeting_ID,"showBtn":"vote"},function(response,status,xhr){
			$("#proMeetingDetail").modal({keyboard:true});
			$("#btn_submitSuggest").show();
			var closeType = false;		//标志位, 判断proMeetingDetail模态框的关闭方式, 点击"关闭"按钮时 closeType=false; 保存成功后调用.modal("hide")关闭时 closeType=true
			//评审会详情页面, 点击"表决"按钮
			$(".btn_applyVote").click(function(){
				var projectCode = $(this).next().val();
				var projectName = $(this).next().next().val();
				var param = {
					"jurySuggest_ID":$(this).attr("data-jurySuggestID"),
					"apply_ID":$(this).attr("data-applyID"),
					"meeting_ID":$("#hidden_meetingID").val()
				};
				$("#page_jurySuggestIndex2").load("/project/jurySuggest/showJurySuggestEditPage",param,function(response,status,xhr){
					$("#jurySuggestEdit").modal({keyboard:true});
					$("#edit_projectCode").text(projectCode);
					$("#edit_projectName").text(projectName);
					var zindex = parseInt($("#proMeetingDetail").css("z-index"));
					$("#jurySuggestEdit").css("z-index",zindex+50);
					$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
					
					tool.undisabled("#btn_save");
					/*点击保存按钮*/
					$("#btn_save").click(function(){
						/*注册编辑验证引擎*/
						zjm.validata({formId:"form_jurySuggest_edit"});
						tool.disabled("#btn_save");
						var queryContainer_form = $("#form_jurySuggest_edit");
						if(queryContainer_form.validationEngine("validate")){
							$.ajax({type:'POST',url:"/project/jurySuggest/updateOneJurySuggest",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						        	if(data.obj){
										$("#jurySuggestEdit").modal("hide");
										$("#proMeetingDetail").modal("hide");
										closeType = true;
									}else{
										alert("保存失败！");
										tool.undisabled("#btn_save");
									}
						        }
							});
						}else{
							tool.undisabled("#btn_save");
						}
					});
					$("#jurySuggestEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
						$("#btn_save").unbind("click");
					});
				});
			});
			// 点击"确认提交"按钮
			$("#btn_submitSuggest").click(function(){
				var btnID = $("i[showType=true]").attr("id");	//标识当前打开的页面形式
				$("#confirmModal").modal({keyboard:true});
				$("#confirmValue").text("表决结果提交后将不能修改或撤回，是否确认提交？");
				var zindex2 = parseInt($("#proMeetingDetail").css("z-index"));
				$("#confirmModal").css("z-index",zindex2+50);
				$(".modal-backdrop:eq(1)").css("z-index",zindex2+40);
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					var isNull = false;
					$(".suggestResult").each(function(){
						if($(this).text()==""){
							isNull = true;
						}
					});
					if(isNull){
						$("#confirmValue").text("尚有项目未表决，请对所有项目进行表决后再提交！");
					}else{
						$.ajax({type:'POST',url:"/project/jurySuggest/submitJurySuggest",data:JSON.stringify({"meeting_ID":$("#hidden_meetingID").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj){
									$("#confirmModal").modal("hide");
									$("#proMeetingDetail").modal("hide");
									if(btnID=="btn_divView"){
										$.zjm_notVote.clickDivViewBtn();
									}else if(btnID=="btn_listView"){
										$.zjm_notVote.clickListViewBtn();
									}else{
										$.zjm_notVote.clickDivViewBtn();
									}
								}else{
									alert("提交失败！");
									tool.undisabled(".btn_submit");
								}
					        }
						});
					}
				});
			});
			$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
			$("#proMeetingDetail").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submitSuggest").unbind("click");
				if(closeType){	//表决结果保存成功, 关闭模态框后再次显示出来,刷新数据
					$.zjm_notVote.showMeetingDetail(meeting_ID);
				}
			});
		});
	}
	
	/**
	 * 点击列表按钮
	 */
	function clickListViewBtn(){
		$.zjm_notVote.initTable();
		$("#divNotVote").empty();
		$("#btn_listView").css("color","#478fca").attr("showType",true);
		$("#btn_divView").css("color","#bbb").removeAttr("showType");
	}
	
	/**
	 * 点击图标按钮
	 */
	function clickDivViewBtn(){
		$("#btn_listView").css("color","#bbb").removeAttr("showType");
		$("#btn_divView").css("color","#478fca").attr("showType",true);
		$('#table_notVoteMeeting').bootstrapTable('destroy');
		$.zjm_notVote.openPage("1");
	}
	
	/**
	 * div块状页面的分页方法
	 */
	function openPage(pageNumber,pageSize){
		if(typeof pageSize == "undefined" || pageSize==""){
			pageSize = 9;
		}
		$("#divNotVote").load("/project/jurySuggest/showNotVoteDIVPage",{"pageNumber":pageNumber,"pageSize":pageSize},function(response,status,xhr){
			$(".btn_vote").click(function() {
				var meeting_ID = $(this).attr("data-meetingID");	
				$.zjm_notVote.showMeetingDetail(meeting_ID);
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
				$.zjm_notVote.openPage(pageNumber);
			});
			$("#btn_prevPage").click(function(){	//上一页
				var pageNumber = parseInt($(".pageNumber.active").children().text());
				if(pageNumber > 1){
					$.zjm_notVote.openPage(pageNumber-1);
				}
			});
			$("#btn_nextPage").click(function(){	//下一页
				var pageNumber = parseInt($(".pageNumber.active").children().text());
				if(pageNumber < parseInt($("#pageTotal").val())){
					$.zjm_notVote.openPage(pageNumber+1);
				}
			})*/
		});
	}
	
})(jQuery, this);

$(function () {
	
	$.zjm_notVote.clickDivViewBtn();
	/**
	 * 点击列表按钮
	 */
	$("#btn_listView").click(function(){
		$.zjm_notVote.clickListViewBtn();
	});
	
	/**
	 * 点击图标按钮
	 */
	$("#btn_divView").click(function(){
		$.zjm_notVote.clickDivViewBtn();
	});
	
});

