(function($,z){
	$.zjm_actSort = {
			initTree:initTree,//初始化树
			initTable:initTable,//初始化列表
			addActSort:addActSort,//添加
			editActSort:editActSort,//修改
			viewActSort:viewActSort,//查看
			delActSort:delActSort//删除
	};
	/**加载树结构*/
	function initTree(nodeId){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/gbpm/actSort/selectActSortListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_actSort.initTable(treeNode.id);
		};
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
				$.each(nodes,function(index,element){
					if(nodes[index].id == nodeId){
						zTreeObj.selectNode(nodes[index]);
						zTreeObj.expandNode(nodes[index],true,false,true);
					}
				})
		};
		if(nodeId==null){nodeId='4f36d0e58b63440eb9bf3324f0984f84';}
		$.zjm_actSort.initTable(nodeId);
	}
	/**初始化列表***/
	function initTable(nodeId){
		$("#actSort-table").bootstrapTable('destroy');
		$('#actSort-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"actSortName",title: '流程分类名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.actSortName;}}, 
					{field:"remark",title: '备注',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.remark;}},
					{field:"actSortID",title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_actSort.viewActSort(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_actSort.editActSort(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_actSort.delActSort(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + index+1 + '</p>');
			        html.push('<p><b>流程分类名称:</b> ' + row.actSortName + '</p>');
			        html.push('<p><b>备注:</b> ' + row.remark + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）			
			url: "/gbpm/actSort/selectActSortPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"pactSortID":nodeId}});
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


	/**添加*/
	function addActSort(nodeId,nodeFullCode){
		$("#actSort_page").load(
				"/gbpm/actSort/selectActSortAddPage",{"pactSortID":nodeId,"actSortFullCode":nodeFullCode},function(response,status,xhr){
					$("#addmodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#add_form").validationEngine("validate")){
							var queryContainer_form = $("#add_form");
							if(zjm.ajaxValidata("actSortName","/gbpm/actSort/selectAddActSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"流程分类名称重复！")){
								$.ajax({type:'POST',url:'/gbpm/actSort/insertOneActSortInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#addmodule").modal("hide");
											$.zjm_actSort.initTree(nodeId);
										}else{
											alert("保存失败！");
										}
							        }
								});
							}else{
								tool.undisabled(".btn_submit");
							}
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	/**查看*/
	function viewActSort(row){
		$("#actSort_page").load(
				"/gbpm/actSort/selectActSortViewPage",{"actSortID":row.actSortID},function(response,status,xhr){
					$("#viewmodule").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function editActSort(row){
		$("#actSort_page").load(
				"/gbpm/actSort/selectActSortEditPage",{"actSortID":row.actSortID},function(response,status,xhr){
					$("#editmodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#edit_form").validationEngine("validate")){
							var queryContainer_form = $("#edit_form");
							if(zjm.ajaxValidata("actSortName","/gbpm/actSort/selectEditActSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"流程分类名称重复！")){
								$.ajax({type:'POST',url:'/gbpm/actSort/updateOneActSortInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#editmodule").modal("hide");
											$.zjm_actSort.initTree(row.pactSortID);
										}else{
											alert("保存失败！");
										}
							        }
								});
							}else{
								tool.undisabled(".btn_submit");
							}
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	/**删除*/
	function delActSort(row){
		$("#actSort_page").load(
				"/gbpm/actSort/selectActSortDelPage",{"actSortID":row.actSortID},function(response,status,xhr){
					$("#delmodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/gbpm/actSort/delectOneActSortInfo',data:JSON.stringify({"actSortID":row.actSortID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
					        		$.zjm_actSort.initTree(row.pactSortID);
									$("#delmodule").modal("hide");
								}else{
									alert("删除失败！");
								}
					        }
						});
					});
				}
		);
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_actSort.initTree();
	};

	$("#btn_add").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个分类!");
			return false;
		}
		//最多两级菜单
		if(node.level >= 3){
			alert("不能添加下级分类!");
			return false;
		}
		$.zjm_actSort.addActSort(node.id,node.fullCode);
	});
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个流程分类!");
			return false;
		}
		if(node.level == 0){
			alert("根节点不允许排序!");
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/gbpm/actSort/selectActSortListJSON",{"pactSortID":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"act_re_actsort","tableFileName":"actSortID","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#sortop").modal("hide");
					$.zjm_actSort.initTree(node.pId);
				}else{
					alert("保存失败！");
					$.zjm_actSort.initTree(node.pId);
				}
		        }
			});
		});
		$(".btn_reset").click(function () {
			zjm.dataSortVal("/gbpm/actSort/selectActSortListJSON",{"pactSortID":node.pId});
		});
		$("#sortop").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
			 $("#btn_moveUp").unbind("click");
			 $("#btn_moveDown").unbind("click");
			 $("#btn_moveTop").unbind("click");
			 $("#btn_moveBottom").unbind("click");
		});
	});
});

