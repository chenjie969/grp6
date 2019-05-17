/**
 * 银行字典js
 */



$(function () {
	/**
	 * 文档加载的时候 读取  银行字典信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_BankSort.initTree();
	};
	
	/**
	 * 添加下级银行字典
	 */
	$("#btn_add").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个 银行字典!");
			return false;
		}
		//最多两级 银行字典
		if(node.level >= 3){
			alert("不能添加下级 银行字典!");
			return false;
		}
		console.log(node);
		$.zjm_BankSort.addBankSort(node.id,node.name);
	}); // end 添加下级银行字典
	
	
	//同级顺序调整
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个 银行字典!");
			return false;
		}
		$("#sortop").modal({keyboard:true});
		if( node.pId == null){
			node.pId='4649d725753a4f00bd6bfe7c346b0dc5';
		}
		
		zjm.dataSortVal("/selectAllbankSortListJSON",{"pbanksortid":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () { 
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/updateSortOrder',
				data : JSON.stringify({
					"tableName" : "c_banksort",
					"tableFileName" : "banksortid",
					"tableFileIds" : $("#tableFileIds").val()
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#sortop").modal("hide");
						$.zjm_BankSort.initTree();
					} else {
						alert("保存失败！");
						$.zjm_BankSort.initTree();
					}
				}
			});
		});
		$(".btn_reset").click(function () {
			zjm.dataSortVal("/selectBankSortsListJSON",{"pbanksortid":node.pId});
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
	
	//重置列表
	$("#refresh").click(function(){
		$.zjm_BankSort.initTree();
	})
}); // end function





(function($,z){
	$.zjm_BankSort = {
			initTree:initTree,//加载树结构
			initTable:initTable,//初始化列表
			addBankSort:addBankSort,// 银行字典添加
			viewBankSort:viewBankSort,// 银行字典查看
			editBankSort:editBankSort,// 银行字典修改
			delBankSort:delBankSort// 银行字典删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(banksortid){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllBankSortListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			
			$.zjm_BankSort.initTable(treeNode.id,isChild);
		}
		if (banksortid == null) {
			banksortid = '4649d725753a4f00bd6bfe7c346b0dc5';
		}
		$.zjm_BankSort.initTable(banksortid);
	}// end initTree
	
	
	/**初始化列表***/
	function initTable(nodeid,isChild){
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'get',
							columns : [
									{
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : "banksortname",
										title : '银行字典名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.banksortname;
										}
									},
									{
										field : "unificationid",
										title : '对应监管机构银行字典编号',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.unificationid;
										}
									},
									{
										field : "isDefault",
										title : '是否缺省',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											if(row.isDefault == 1){
												return '是';
											}else{
												return '否';
											}
										}
									},
									{
										field : "iseable",
										title : '状态',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											// 是否禁用 
											if(row.iseable == 1){
												return '禁用';
											}else{
												return '启用';
											}
										}
									},
									{
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button class="btn_BankSorts_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_BankSorts_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
													'<button class="btn_BankSorts_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
													.join('');
										},
						events:{
							'click .btn_BankSorts_view': function(e, value, row, index) {
								$.zjm_BankSort.viewBankSort(row);
							},
							'click .btn_BankSorts_edit': function(e, value, row, index) {
								$.zjm_BankSort.editBankSort(row);
							},
							'click .btn_BankSorts_del': function(e, value, row, index) {
								$.zjm_BankSort.delBankSort(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
				var iseable="";
				if(row.iseable == 1){
					iseable="禁用";
				}else{
					iseable="启用";
				}
				var isDefault="";
				if(row.isDefault ==1){
					isDefault="是";
				}else{
					isDefault="否";
				}
			    var html = [];
			        html.push('<p><b>银行字典名称：</b> ' + row.banksortname + '</p>');
			        html.push('<p><b>对应监管机构银行字典编号：</b> ' + row.unificationid + '</p>');
			        html.push('<p><b>是否缺省：</b> ' + isDefault + '</p>');
			        html.push('<p><b>状态：</b> '+iseable+ '</p>');
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
			url: "/selectBankSortsPageTables", //这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				console.info(params);
				if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"pbanksortid":nodeid}});
				}else{
					$.extend(params,{"queryCondition":{"banksortid":nodeid}});
				}
				return params;
			},// queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
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


	/** 银行字典添加   添加下级银行字典 */
	function addBankSort(id,name){
		$("#addBankSort").modal({keyboard:true});
		$(".ztb_add_pbanksortid").val(id);//当前节点id 赋给父id 
		$(".ztb_add_up_banksortname").text(name); //上级银行名称，用于页面显示
		
		
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		/**提交  保存银行信息*/
		tool.undisabled(".btn_submit"); //按钮调整为可用
		$(".btn_submit").click(function(){
			if($("#add_form").validationEngine("validate")){
				var queryContainer_form = $("#add_form");
			//	alert( queryContainer_form.serialize());//表单系列化
				if(zjm.ajaxValidata("add_banksortname","/selectAddBankSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson())," 银行字典名称重复！")){
					tool.disabled(".btn_submit"); // 按钮调整为不可用
					$.ajax({
						type : 'POST',
						url : '/insertOneBankSortInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj == 1) {
								$("#addBankSort").modal("hide");
								$(".ztb_add").val("");
								$.zjm_BankSort.initTree(id);
							} else {
								alert("保存失败！");
							}
						}
					});
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addBankSort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/*** 银行字典查看***/
	function viewBankSort(row){
		$("#viewBankSort").modal({keyboard:true});
	//	zjm.dataViewText("view_","/selectOneBankSortsInfo",{"banksortid":row.banksortid});
		$.ajax({
			type : 'POST',
			url : '/selectOneBankSortsInfo',
			data : JSON.stringify({"banksortid":row.banksortid,"unitUid":row.unitUid}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_view_"+key).attr("class");
					if(typeof  rt != 'undefined'){
						if( rt.indexOf('iseable') >0){ //判断是否包含isable  状态的
							if( value == 1 ){
							//	alert( value +"========急用");
								$(".ztb_view_"+key).text('禁用');
							}else{
								$(".ztb_view_"+key).text('启用');
							}
						}else if(rt.indexOf('isDefault')>0){
							if(value == 1){
								$(".ztb_view_"+key).text('是');
							}else{
								$(".ztb_view_"+key).text('否');
								
							}
						}else{
							$(".ztb_view_"+key).text(value);
						}
					}
				})
			}
		});
	
	}
	/** 银行字典修改**/
	function editBankSort(row){
		$("#editBankSort").modal({keyboard:true});
		$(".icon-picker").iconPicker("edit_wraper");
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		$.ajax({
			type:'post',
			url:'/selectOneBankSortsInfo',
			data: JSON.stringify({"banksortid":row.banksortid,"unitUid":row.unitUid}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('iseable') > 0){
							if(value == 1){ // =1 禁用，0启用
								$("#edit_iseable1").prop("checked","checked");
								$("#edit_iseable0").prop("checked","");
							}else{
								$("#edit_iseable0").prop("checked","checked");
								$("#edit_iseable1").prop("checked","");
							}
						}else{
							$(".ztb_edit_"+key).val(value);
						}
					}
				})
			}
		})// 获取修改对象 信息  end 
		
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOneBankSortsInfo",{"banksortid":row.banksortid});
		});
		/**提交***/
		tool.undisabled(".btn_submit"); // 按钮调整为可用
		$(".btn_submit").click(function(){
			if($("#edit_form").validationEngine("validate")){
				var queryContainer_form = $("#edit_form");
				//修改时,判断名称是否重复
				if(zjm.ajaxValidata("edit_banksortname",
						"/selectEditBankSortNameIsExist",
						JSON.stringify(queryContainer_form.serializeJson())," 银行字典名称重复！")){
					tool.disabled(".btn_submit"); //按钮调整为不可用
					$.ajax({
						type : 'POST',
						url : '/updateOneBankSortsInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj == 1) {
								$("#editBankSort").modal("hide");
								$(".ztb_edit").val("");
								$.zjm_BankSort.initTree(row.pbanksortid);
							} else {
								alert("保存失败！");
							}
						}
					});
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editBankSort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	/** 银行字典删除***/
	function delBankSort(row){
		if(row.isDefault == 1){
			$("#isDefault").modal({keyboard:true});
			return false ;
		}
		$("#delBankSort").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteOneBankSortsInfo',
				data : JSON.stringify({
					"banksortid" : row.banksortid,
					"unitUid":row.unitUid
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$('#test-table').bootstrapTable('remove', {
							field : 'banksortid',
							values : [ row.banksortid ]
						});
						$.zjm_BankSort.initTree(row.pbanksortid);
						$("#delBankSort").modal("hide");
					} else {
						$("#isDefault").modal({keyboard:true});
						//alert("删除失败！");
					}
				}
			});
		});
		$("#delBankSort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}

})(jQuery, this); 



