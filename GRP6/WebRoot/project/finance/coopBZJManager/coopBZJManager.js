(function($,z){
	$.zjm_coopBZJManager = {
		initTable:initTable,	//初始化列表
		viewCoopBZJManager:viewCoopBZJManager,//查看合作机构保证金
		editCoopBZJManager:editCoopBZJManager,//修改合作机构保证金
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#table_coopBZJManager').bootstrapTable('destroy');
		$('#table_coopBZJManager').bootstrapTable({
			method: 'post',
			showFooter: true,
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"banksortname",title: '合作机构',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.banksortname;},
							footerFormatter:function(){ return "合计"}
						},
						{field:"creditSum",title: '授信额度（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.creditSum;},
							footerFormatter:function(rows){ 
								var count_creditSum = 0
								for(var index in rows){
									count_creditSum += rows[index].creditSum;
								}
								return count_creditSum;
							}
						},
						{field:"bzScale",title: '保证金比例（%）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.bzScale;}},
						{field:"busiCode",title: '存出保证金（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.factBzSum;},
							footerFormatter:function(rows){ 
								var count_factBzSum = 0
								for(var index in rows){
									count_factBzSum += rows[index].factBzSum;
								}
								return count_factBzSum;
							}
						},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_coopBZJManager_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_coopBZJManager_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_coopBZJManager_view': function(e, value, row, index) {
									$.zjm_coopBZJManager.viewCoopBZJManager(row);
								},
								'click .btn_coopBZJManager_edit': function(e, value, row, index) {
									$.zjm_coopBZJManager.editCoopBZJManager(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>合作机构：</b> ' + row.banksortname + '</p>');
				    html.push('<p><b>授信额度：</b> ' + row.creditSum + '万元</p>');
				    html.push('<p><b>保证金比例：</b> ' + row.bzScale + '%</p>');
				    html.push('<p><b>存出保证金：</b> ' + (row.mustBzSum==null?"（空）":(row.mustBzSum+"万元")) + '</p>');
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
//			sortName:"updateDateTime",	//默认排序字段
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/finance/selectCoopBZJPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"pbanksortid": "e7e282ee61b249eba0f64161fee6ff45"};
				$.extend(queryCondition,data);
				$.extend(params, {"queryCondition":queryCondition});
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
            exportDataType: "basic",              //basic', 'all', 'selected'
		});
	}
	
	/**
	 * 查看合作机构保证金
	 */
	function viewCoopBZJManager(row){
		$("#coopBZJManager_page").load("/project/finance/showBankSortViewPage",{"banksortid":row.banksortid},function(response,status,xhr){
			$("#viewCoopBZJManager").modal({keyboard:true});
		});
	}
	
	/**
	 * 修改合作机构保证金
	 */
	function editCoopBZJManager(row){
		$("#coopBZJManager_page").load("/project/finance/showBankSortEditPage",{"banksortid":row.banksortid},function(response,status,xhr){
			$("#editCoopBZJManager").modal({keyboard:true});
			$("#btn_computeBZJ").click(function(){
				var creditSum = Number($("#creditSumVal").val());
				var bzScale = Number($("#bzScaleVal").val());
				var bzj = creditSum*bzScale/100;
				$("#mustBzSumVal").val(bzj);
				$("#factBzSumVal").val(bzj);
			});
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_coopBZJManager"});
				if($("#form_coopBZJManager").validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/finance/updateOneBankSort",data:JSON.stringify($("#form_coopBZJManager").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj){	//保存成功，关闭页面
								$("#editCoopBZJManager").modal("hide");
								$.zjm_coopBZJManager.initTable();
							}else{
								alert("保存失败");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editCoopBZJManager").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_coopBZJManager.initTable();
	};

	/**
	 * 修改合作机构保证金
	 */
	$("#btn_editCoopBZJ").click(function(){
		var selectContent = $("#table_coopBZJManager").bootstrapTable('getSelections');
		if(selectContent.length == 1){
			$.zjm_coopBZJManager.editCoopBZJManager(selectContent[0]);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
});

