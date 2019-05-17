(function($,z){
	$.zjm_costStandard= {
			initTable:initTable, //初始化页面
			costStandardAdd:costStandardAdd, //添加
			costStandardDel:costStandardDel,//删除
			costStandardView:costStandardView //查看
	
	};
	/**初始化列表***/
	function initTable(){
		$("#costStandard_table").bootstrapTable('destroy');
		$('#costStandard_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
				{field:"costName",title: '费用名称',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.costName;}},
				{field:"costTypeName",title: '费用类型名称',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.costTypeName;}},
				{field:"costRate",title: '费率',align: 'center',formatter: function (value, row, index) { return row.costRate;}},
				{field:"costUnit",title: '费率单位',align: 'center',formatter: function (value, row, index) { return row.costUnit;}},
				{field:"culate",title: '计算规则',align: 'center',formatter: function (value, row, index) { return row.culate;}},			
				{title: '操作',align: 'center',formatter:function(value,row,index){
					return ['<button class="btn_costStandard_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
						'<button class="btn_costStandard_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					},
					events:{
						'click .btn_costStandard_view': function(e, value, row, index) {
							$.zjm_costStandard.costStandardView(row);
						},
						'click .btn_costStandard_del': function(e, value, row, index) {
							$.zjm_costStandard.costStandardDel(row);
						}
					}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
					html.push('<p><b>费用名称:</b> ' + row.costName + '</p>');
					html.push('<p><b>费用类型名称:</b> ' + row.costTypeName + '</p>');
					html.push('<p><b>费率:</b> ' + row.costRate + '</p>');
					html.push('<p><b>费率单位:</b> ' + row.costUnit + '</p>');
					html.push('<p><b>计算规则:</b> ' + row.culate + '</p>');
					return html;
				},//url: "/sys/costStandard/selectCostStandardTable",//这个接口需要处理bootstrap table传递的固定参数
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				sortName: "costName",     //排序字段
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
				url: "/sys/costStandard/selectCostStandardTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
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
	};
	

	/**添加*/
	function costStandardAdd(){	
		$("#costStandard_page").load("/sys/costStandard/showCostStandardAdd",{},function(response,status,xhr){
					$("#costStandardAdd").modal({keyboard:true});
					/*注册编辑验证引擎*/
					zjm.validata({formId:"costStandardAdd_Form"});
					//tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#costStandardAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#costStandardAdd_Form");
							$.ajax({type:'POST',url:'/sys/costStandard/insertOneCostStandard',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#costStandardAdd").modal("hide");
										$.zjm_costStandard.initTable();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
						}else{
							tool.undisabled(".btn_submit");
						}
						$("#costStandardAdd").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
						});
					});
				});
			}
	/**查看收费标准记录*/
	function costStandardView(row){
		$("#costStandard_page").load("/sys/costStandard/selectOneCostStandard",{"costStandard_ID":row.costStandard_ID,"operationType":"view"},function(response,status,xhr){
			$("#costStandardView").modal({keyboard:true});
		});
	}
	/**删除*/
	function costStandardDel(row){
		$("#costStandardDel").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			$.ajax({type:'POST',url:'/sys/costStandard/deleteOneCostStandard',data:JSON.stringify({"costStandard_ID":row.costStandard_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
		        		$.zjm_costStandard.initTable(row.costStandard_ID);
						$("#costStandardDel").modal("hide");
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$.zjm_costStandard.initTable();
	
	$("#btn_costStandardAdd").click(function(){
		$.zjm_costStandard.costStandardAdd();
	});
	
	
});