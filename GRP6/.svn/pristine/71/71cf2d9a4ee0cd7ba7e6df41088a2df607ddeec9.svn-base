(function($,z){
	$.zjm_meetingApply = {
		initTable:initTable
	};
	
	/**初始化列表***/
	function initTable(){
		$('#table_selectableApply').bootstrapTable('destroy');
		$('#table_selectableApply').bootstrapTable({
			method: 'post',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"busiCode",title: '项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
						{field:"projectName",title: '项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { 
							return [ '<a class="btn_proApply_view" href="javascript:void(0)">'+ row.projectName + '</a>' ].join('');},
							events:{
								'click .btn_proApply_view' : function(e, value, row, index) {
									$.zjm_meetingApplyIndex.viewApplyInfo(row);
								}
							}
						},
//						{field:"unit_uidName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeNameList.replace(",","<br/>");}},
						{field:"unit_uidName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return ((row.busiTypeNameList ==null || row.busiTypeNameList ==undefined))?"-":row.busiTypeNameList.replace(",","<br/>");}},
						{field:"applySum",title: '申请金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applySum;}},
//						{field:"unit_uidName",title: '申请期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}},
						{field:"departName",title: '经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.departName;}},
						{field:"amanName",title: 'A角',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.amanName;}},
						{field:"bmanName",title: 'B角',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.bmanName;}},
						{field:"reviewManName",title: '风控评审人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.reviewManName;}},
						{title:"操作",align: 'center',formatter:function(value,row,index){
								return '<button class="btn_proApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>';
							},
							events:{
								'click .btn_proApply_view': function(e, value, row, index) {
									$.zjm_meetingApplyIndex.viewApplyInfo(row);
								}
							}
						}],
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
			sortName: "busiCode",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/meetingApply/selectSelectableApplyPageTables",//这个接口需要处理bootstrap table传递的固定参数
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
	
})(jQuery, this);

$(function () {
	
	$.zjm_meetingApply.initTable();
	
	/**
	 * 点击"上会申请"按钮
	 */
	$("#btn_addMeetingApply").click(function(){
		var selectContent = $('#table_selectableApply').bootstrapTable('getSelections');
		if(typeof(selectContent) == 'undefined' || selectContent.length == 0) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").text("请至少选择一条数据，然后再操作！")
			return false;  
		}else{
			var projectNameList = "";
			var applyIDList = "";
			for(var i=0; i<selectContent.length; i++){
				projectNameList += selectContent[i].projectName;
				applyIDList += selectContent[i].apply_ID;
				if(i != selectContent.length-1){
					projectNameList += "<br />";
					applyIDList += ",";
				}
			}
			$("#page_meetingApplyIndex").load("/project/meetingApply/showMeetingApplyAddPage",{"projectNameList":projectNameList,"applyIDList":applyIDList},function(response,status,xhr){
				$("#addMeeingApply").modal({keyboard:true});
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_addMeetingApply"});
				tool.undisabled("#btn_submit");
				$("#btn_submit").click(function(){
					tool.disabled(".btn_submit");
					var queryContainer_form = $("#form_addMeetingApply");
					if(queryContainer_form.validationEngine("validate")){
						$.ajax({type:'POST',url:'/project/meetingApply/setMeetingStatusArranging',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#addMeeingApply").modal("hide");
									$.zjm_meetingApply.initTable();
								}else{
									alert("保存失败！");
								}
					        }
						});
					}else{
						tool.undisabled("#btn_submit");
					}
				});
				$("#addMeeingApply").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $("#btn_submit").unbind("click");
				});
			});
		}
	});
	
})

