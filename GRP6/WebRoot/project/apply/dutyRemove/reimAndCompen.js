(function($,z){
	$.zjm_dutyRemove = {
		initTable:initTable, //初始化列表
		reimAndCompen:reimAndCompen  //登记还款与代偿
		
	};
	
	var apply_ID = tool.getUrlParam('entityID');
	var type = tool.getUrlParam('type');
	/**初始化列表***/
	function initTable(){
		$("#dutyRemove_table").bootstrapTable('destroy');
		$('#dutyRemove_table').bootstrapTable({
			method: 'get',
			columns: [
				{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"projectCode",title: '项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.projectCode;}},
				{field:"projectName",title: '项目名称',align: 'center',sortable:"true",formatter: function (value, row, index){return row.projectName;}},
				{field:"loadCode",title: '放款单编号',align: 'center',sortable:"true",formatter: function (value, row, index){return row.loadCode;}},
				{field:"busiTypeName",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index){return row.busiTypeName;}},
				{field:"bankName",title: '合作机构',align: 'center',sortable:"true",formatter: function (value, row, index){return row.bankName;}},
				{field:"loadSum",title: '放款金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.loadSum;}},
				{field:"guarantySum",title: '在保余额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.guarantySum;}},
				{field:"guarantyDutySum",title: '责任金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.guarantyDutySum;}},
				{field:"guarantyDutyResSum",title: '责任余额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.guarantyDutyResSum;}},
				{field:"billBeginDate",title: '借据起始日期',align: 'center',sortable:"true",formatter: function (value, row, index){return moment(row.billBeginDate).format("YYYY-MM-DD");}},
				{field:"billEndDate",title: '借据结束日期',align: 'center',sortable:"true",formatter: function (value, row, index){return moment(row.billEndDate).format("YYYY-MM-DD");}},
				
				{field:"isFree",title: '状态',align: 'center',sortable:"true",formatter: function (value, row, index){
					if(row.isFree==0){
						return "未解除";
					}else{
						return "解除";
					}
				}}
				],
			singleSelect:true,
			detailView: true,
			detailFormatter:function(index, row){
				var isOrNotfree = "";
				if(row.isFree==0){
					isOrNotfree = "未解除";
				}else{
					isOrNotfree = "解除";
				}
				var billBeginDate = row.billBeginDate;
				if(billBeginDate==null || typeof(billBeginDate)==undefined){
					billBeginDate = "（空）";
				}else{
					billBeginDate = moment(billBeginDate).format("YYYY-MM-DD")
				}
				var billEndDate = row.billEndDate;
				if(billEndDate==null || typeof(billEndDate)==undefined){
					billEndDate = "（空）";
				}else{
					billEndDate = moment(billEndDate).format("YYYY-MM-DD")
				}
				
			    var html = [];
				    html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>项目编号:</b> ' + row.projectCode + '</p>');
				    html.push('<p><b>项目名称:</b> ' + tool.isNull(row.projectName,"（空）") + '</p>');
				    html.push('<p><b>放款单编号:</b> ' + tool.isNull(row.loadCode,"（空）") + '</p>');
				    html.push('<p><b>业务品种:</b> ' + tool.isNull(row.busiTypeName,"（空）") + '</p>');
				    html.push('<p><b>合作机构:</b> ' + tool.isNull(row.bankName,"（空）") + '</p>');
				    html.push('<p><b>放款金额（万元）:</b> ' + tool.isNull(row.loadSum,"（空）") + '</p>');
				    html.push('<p><b>在保余额（万元）:</b> ' + tool.isNull(row.guarantySum,"（空）") + '</p>');
				    html.push('<p><b>责任金额（万元）:</b> ' + tool.isNull(row.guarantyDutySum,"（空）") + '</p>');
				    html.push('<p><b>责任余额（万元）:</b> ' + tool.isNull(row.guarantyDutyResSum,"（空）") + '</p>');
				    html.push('<p><b>借据起始日期:</b> ' + billBeginDate + '</p>');
				    html.push('<p><b>借据结束日期:</b> ' + billEndDate + '</p>');
				    html.push('<p><b>状态:</b> ' + isOrNotfree + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"billBeginDate",    //排序字段
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/project/selectReimAndCompenPage",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":apply_ID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
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
	
	
	//查看
	function reimAndCompen(){
		
		var selectContent = $('#dutyRemove_table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {
        	$("#pleaseSelectOne").modal({keyboard:true});
        	return false;
            //alert("您还没选择一条记录，请您选择一条记录!");  
        }else{ 
        	var project_ID = selectContent.project_ID;
        	window.parent.openMenu('view_reimAndCompen'+project_ID,'',
        			'还款与代偿详情','/project/project/viewReimAndCompenInfo','&project_ID='+project_ID+'&type='+type);
        }
	}
	

})(jQuery, this);

$(function () {
	
	$.zjm_dutyRemove.initTable();
	$(".form-control-ztb").attr("placeholder",'输入项目名称,按回车搜索');
	
	$("#btn_ReimAndCompen").click(function(){
		$.zjm_dutyRemove.reimAndCompen();
	});
});
