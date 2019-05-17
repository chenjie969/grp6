(function($,z){
	$.zjm_arcMoveRec = {
			initTable:initTable,//初始化列表
			initColumns:initColumns,//初始化列表项
			returnArcMoveRecAdd:returnArcMoveRecAdd,//跳转到新增档案记录页面
			openArcMoveAddIndex:openArcMoveAddIndex,//跳转到新增档案主页面
			delOneArcMoveRec:delOneArcMoveRec//删除单个档案移交记录
	};
	
	/**初始化列表***/
	function initTable(type){
		$('#arcMoveRec_table').bootstrapTable('destroy');
		$('#arcMoveRec_table').bootstrapTable({
			method: 'post',
			columns: initColumns(type),
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/arcMoveRec/selectArcMoveRecPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
				 //$.extend(queryCondition,data);
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
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
	};
	
	/**初始化列表项***/
	function initColumns(type){
		var columns = [
			//{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'moveDate',title:'移交日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.moveDate);}},
			{field:'moveUserName',title:'移交人',align:'center',sortable : "true",formatter: function (value, row, index) {return row.moveUserName;}},
			{field:'acceptDate',title:'接收日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.acceptDate);}},
			{field:'acceptUserName',title:'接收人',align:'center',sortable : "true",formatter: function (value, row, index) {return row.acceptUserName;}},
			{field:'status',title:'状态',align:'center',sortable : "true",formatter: function (value, row, index) {return row.status;}},								
			];
		
		if('edit'==type){
			columns.push(
					{title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return [
							'<button class="btn_arcMoveRec_add btn btn-xs btn-warning"  href="javascript:void(0)"><i class="icon-sitemap bigger-120"></i></button>',
							'<button class="btn_arcMoveRec_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
							].join('');
						},
						
						
						events:{
							'click .btn_arcMoveRec_add': function(e, value, row, index) {
								$.zjm_arcMoveRec.openArcMoveAddIndex(row);
							},
							'click .btn_arcMoveRec_del': function(e, value, row, index) {
								$.zjm_arcMoveRec.delOneArcMoveRec(row);
							}
						}
					});
		}else if('view'==type){
			columns.push(
					{title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return [
							'<button class="btn_arcMoveRec_add btn btn-xs btn-warning" title="新增档案" href="javascript:void(0)"><i class="icon-sitemap bigger-120"></i></button>'
							].join('');
						},
						events:{
							'click .btn_arcMoveRec_add': function(e, value, row, index) {
								$.zjm_arcMoveRec.openArcMoveAddIndex(row);
							},
							'click .btn_arcMoveRec_del': function(e, value, row, index) {
								$.zjm_arcMoveRec.delOneArcMoveRec(row);
							}
						}
					});
		}
		return columns;
		
	};
	function returnArcMoveRecAdd(){
		var apply_ID = $("#apply_ID").val();
		$("#arMoveRec_page").load("/project/arcMoveRec/returnArcMoveRecAddPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#arcMoveRecAdd").modal({keyboard:true});
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
				$("#txt_id").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	          }
	        });
			$('#moveDate').attr("value",tool.parseDate(new Date().getTime()));//yyyy-mm-dd .fromat("yyyy-MM-dd")
			
			zjm.init();
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"arcMoveRecAdd_form"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#arcMoveRecAdd_form");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/arcMoveRec/insertOneArcMoveRec",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#arcMoveRecAdd").modal("hide");
								//$.zjm_arcMoveRec.initTable('add');
								 window.location.reload();
							    
				        	}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#arcMoveRecAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	};
	//跳转到新增档案主页面
	function openArcMoveAddIndex(row){
		window.parent.openMenu('openArcMoveAddIndex'+row.arcMoveRec_ID,'','档案目录及清单','/project/arcMoveRec/openArcMoveAddIndex','&apply_ID='+row.apply_ID+'&arcMoveRec_ID='+row.arcMoveRec_ID+'&operationType='+$("#operationType0").val()+'&type='+$("#type").val(),0);
	};
	//删除单个档案移交记录
	function delOneArcMoveRec(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除所选数据吗?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/arcMoveRec/delOneArcMoveRec',data:JSON.stringify({"arcMoveRec_ID":row.arcMoveRec_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#arcMoveRec_table').bootstrapTable('remove', {
							field: 'arcMoveRec_ID',
							values: [row.arcMoveRec_ID]
						});
						$("#common_del").modal("hide");
						//$.zjm_arcMoveRec.initTable();
						window.location.reload();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	
	}
})(jQuery, this);
$(function () {
	var type = $("#type").val();
	var operationType = $("#operationType0").val();
	if('view' == type){
		$("#btn_returnArcMoveRecAdd").hide();//查看时隐藏新增按钮
	}
	if('accept' == operationType){
		$("#btn_returnArcMoveRecAdd").hide();//查看时隐藏新增按钮
	}
	
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_arcMoveRec.initTable(type);
	
	/**
	 * 打开新增移交记录页面
	 */
	$("#btn_returnArcMoveRecAdd").click(function(){
		$.zjm_arcMoveRec.returnArcMoveRecAdd();
	});
	

	
});

