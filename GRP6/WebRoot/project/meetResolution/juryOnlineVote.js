(function($,z){
	$.zjm_juryOnlineVote = {
		initTable:initTable, //初始化列表
		addJuryOnlineVote:addJuryOnlineVote,
		viewJuryOnlineVote:viewJuryOnlineVote
		
	};
	
	/*var applyID = $("#applyID").val();*/
	/**初始化列表***/
	function initTable(){
		$("#juryOnlineVote_table").bootstrapTable('destroy');
		$('#juryOnlineVote_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"syllable1",title: '评审结论',align: 'center',sortable:"true",formatter: function (value, row, index) {return "公司比较有诚信";}},
				{field:"syllable4",title: '担保金额',align: 'center',sortable:"true",formatter: function (value, row, index){return "2000万元";}},
				{field:"syllable5",title: '担保期限',align: 'center',sortable:"true",formatter: function (value, row, index){return "15个月";}},
				{field:"syllable6",title: '担保年费率',align: 'center',sortable:"true",formatter: function (value, row, index){return "5%";}},
				{field:"syllable7",title: '履约保证金比例',align: 'center',sortable:"true",formatter: function (value, row, index){return "7%";}},
					
					{field:"meetingResolution_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_juryOnlineVote.viewJuryOnlineVote(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>评审结论:</b> ' + "公司比较有诚信" + '</p>');
				    html.push('<p><b>担保金额:</b> ' + "2000万元" + '</p>');
				    html.push('<p><b>担保期限:</b> ' + "15个月" + '</p>');
				    html.push('<p><b>担保年费率:</b> ' + "5%" + '</p>');
				    html.push('<p><b>履约保证金比例:</b> ' + "7%" + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/pro/meetingResolution/selectJuryOnlineVotePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				// $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
	
	
	
	
	//添加评审会决议
	/*function addMeetingResolution(){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetResolutionAddPage?applyID="+applyID,{},function(response,status,xhr){
			$("#add_meetResolution").modal({keyboard:true});
			
			注册编辑验证引擎
			zjm.validata({formId:"meetResolution_form"});
			tool.undisabled(".btn_submit");
			
			$("#add_meetResolution").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}*/
	
	//查看
	function viewJuryOnlineVote(){
		$("#juryOnlineVote_page").load("/pro/meetingResolution/showJuryOnlineVoteViewPage",{},function(response,status,xhr){
			$("#viewJuryOnlineVote").modal({keyboard:true});
			
		});
	}
	
	
	//添加评审会决议
	function addJuryOnlineVote(){
		$("#juryOnlineVote_page").load("/pro/meetingResolution/showJuryOnlineVoteAddPage",{},function(response,status,xhr){
			$("#add_juryOnlineVote").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"juryOnlineVote_form"});
			tool.undisabled(".btn_submit");
		});
	}

})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_juryOnlineVote.initTable();
	};
	
	$("#btn_juryOnlineVote").click(function(){
		$.zjm_juryOnlineVote.addJuryOnlineVote();
	});
	
});
