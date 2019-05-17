(function($,d) {
	$.zjm_riskAnalysis = {
		initData:initData,
		initRiskSchemeTable:initRiskSchemeTable
	};
	function initData(){
	
		$.post("/project/riskDesktop/analysisOfGuarantySumDrop",
				{},				
				function(data){
					var id = 'guarantySumDrop';
					var titleArray=new Array('在保余额(万元)');					
					$.zjm_echart.lineStandard2(id,titleArray,data);
					
				}
		);
		$.post("/project/riskDesktop/analysisOfEntrustGuarantySumDrop",
				{},				
				function(data){
					var id = 'entrustGuarantySumDrop';
					var titleArray=new Array('委贷余额(万元)');					
					$.zjm_echart.lineStandard2(id,titleArray,data);
					
				}
		);
		$.post("/project/riskDesktop/analysisOfEachCompany",
				{},				
				function(data){
					var id ='eachCompany';
					var titleArray=new Array('金额');
					$.zjm_echart.loopPieStandard(id,titleArray,data);
				}
		);
		
		$.post("/project/riskDesktop/analysisOfFiveClass",
				{},				
				function(data){
					var id ='fiveClassification';
					var titleArray=new Array('上年末','当前');	
					$.zjm_echart.barVertical2(id,titleArray,data);
				}
		);	
		$.post("/project/riskDesktop/analysisOfCostCompare",
				{},				
				function(data){
					var id ='costCompare';
					var titleArray=new Array('金额');	
					$.zjm_echart.pieStandard(id,titleArray,data);
				}
		);	
		$.zjm_riskAnalysis.initRiskSchemeTable()
	}
	
	/**初始化最新工作进度***/
	function initRiskSchemeTable(){
		$("#table_newestRiskScheme").bootstrapTable('destroy');
		$('#table_newestRiskScheme').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',valign:"middle",formatter: function (value, row, index) {return index+1;}}, 
						{title: '关联系',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.relationMainName;}}, 
//						{title: '工作进度',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.workProgress;}},
						{title: '工作进度',align: 'center',valign:"middle",formatter: function (value, row, index) { return (row.workProgress ==null ||row.workProgress==undefined)?"-":((row.workProgress.length >10)?(row.workProgress.substring(0,15)+"..."):row.workProgress);}},

					 ],
			detailView: false,
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true ,     //是否启用排序
			sortName:"prs.finishDate",	//创建日期
			sortOrder: "desc",     //排序方式
//			pageNumber:1,      //初始化加载第一页，默认第一页		pagination设置为false后, 这里的分页就失效了
//			pageSize: 6,      //每页的记录行数（*）
//			pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
			url: "/project/riskScheme/selectMoreRiskSchemeTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"pageNumber":1,"pageSize":6});
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
	}
	
})(jQuery,this);
$(function(){

	//$('#fiveClassification').attr("value",tool.parseYearsDate(new Date().getTime()));//yyyy-mm-dd .fromat("yyyy-MM-dd")

	$.zjm_riskAnalysis.initData();
	//$('#fiveClassification').text(tool.parseYearsDate(new Date().getTime()));
	
	/**
	 * 点击最新工作列表-更多
	 */
	$("#btn_viewMoreNewestRiskScheme").click(function(){
		window.parent.openMenu('viewMoreNewestRiskScheme','','最新工作进度','/project/riskResponse/index/viewMoreRiskScheme.jsp','&type=more');
	});
	
	/**
	 * 点击工作进度提醒查看全部
	 */
	$(".btn_workReminder").click(function(){
		var type = $(this).attr("data-classtype");
		if(type=="harfMonth"){
			window.parent.openMenu('viewHarfMonthReminder','','半月未提交项目','/project/riskResponse/index/viewMoreRiskScheme.jsp','&type=harfMonth');
		}else if(type=="oneMonth"){
			window.parent.openMenu('viewOneMonthReminder','','一月未提交项目','/project/riskResponse/index/viewMoreRiskScheme.jsp','&type=oneMonth');
		}else if(type=="twoMonth"){
			window.parent.openMenu('viewTwoMonthReminder','','两月以上未提交项目','/project/riskResponse/index/viewMoreRiskScheme.jsp','&type=twoMonth');
		}else{
			alert("出错了，请联系管理员！");
		}
	});
	
});