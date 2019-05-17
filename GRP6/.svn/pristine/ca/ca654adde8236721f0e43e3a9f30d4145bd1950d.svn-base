(function($,z){
	$.zjm_product = {
			initColumns:initColumns,
			initProductTalble:initProductTalble,//初始化列表
			copyProduct:copyProduct,//复制产品流程
			addOneProduct:addOneProduct,//产品流程新增
			delModule:delModule,//产品流程删除
			editModule:editModule,//产品流程修改
			setNodeModule:setNodeModule//节点设置
	};
		
	function initColumns(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'productName',title:'产品流程名称',align:'center',formatter: function (value, row, index) {return row.productName;}},
			{field:'productTypeName',title:'产品流程类型名称',align:'center',formatter: function (value, row, index) {return row.productTypeName;}},
			{field:'version',title:'产品流程版本',align:'center',formatter: function (value, row, index) {return row.version;}},
			{field:'isUsed',title:'产品流程状态',align:'center',formatter: function (value, row, index) {return row.isUsed?"启用":"禁用";}},
			{field:'remark',title:'备注',align:'center',formatter: function (value, row, index) {return row.remark;}},
			{title: '操作',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_modules_edit btn btn-xs btn-info" title="修改"><i class="icon-pencil bigger-120"></i></button>',
					'<button class="btn_modules_del btn btn-xs btn-danger" title="删除"><i class="icon-trash bigger-120"></i></button>',
					'<button class="btn_modules_set btn btn-xs btn-warning" title="节点设置"><i class="icon-gear bigger-120"></i></button>'].join('');
				},
				events:{
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_product.editModule(row.product_ID);
					},
					'click .btn_modules_del': function(e, value, row, index) {
						$.zjm_product.delModule(row.product_ID);
					},
					'click .btn_modules_set': function(e, value, row, index) {
						$.zjm_product.setNodeModule(row.product_ID);
					}
				}
			}
		];
		return columns;
	}	
	
	/**初始化列表***/
	function initProductTalble(columns){
		$("#prodcut-table").bootstrapTable('destroy');
		$('#prodcut-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>产品流程名称:</b> ' + row.productName + '</p>');
			        html.push('<p><b>产品流程类型名称:</b> ' + row.productTypeName + '</p>');
			        html.push('<p><b>产品流程版本:</b> ' + row.version + '</p>');
			        html.push('<p><b>产品流程状态:</b> ' + (row.isUsed?"启用":"禁用") + '</p>');
			        html.push('<p><b>备注:</b> ' + row.remark + '</p>');
			        html.push('<p><b>操作:</b> ' + "<button class='btn_modules_edit btn btn-xs btn-info' title='修改' onclick=\"$.zjm_product.editModule('"+row.product_ID+"');\"><i class='icon-pencil bigger-120'></i></button>"+
							"<button class='btn_modules_del btn btn-xs btn-danger' title='删除' onclick=\"$.zjm_product.delModule('"+row.product_ID+"');\"><i class='icon-trash bigger-120'></i></button>"+
							"<button class='btn_modules_set btn btn-xs btn-warning' title='节点设置' onclick=\"$.zjm_product.setNodeModule('"+row.product_ID+"');\"><i class='icon-gear bigger-120'></i></button>" + '</p>');
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
			url: "/gbpm/product/selectProductPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			/*queryParams: function(params) {
				return params;
			},*///前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			singleSelect : true,// 单选checkbox
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


	/***删除***/
	function delModule(product_ID){
		if(zjm.ajaxValidata("add_prductName","/gbpm/productInstance/isExistProductInstance",JSON.stringify({"productID":product_ID}),"产品流程名称已存在！")){
			$("#common_del").modal({keyboard:true});
			$("#delMessage").html("您确认要删除这个流程吗?");
			$("#delModalLabel").html("流程删除");
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/gbpm/product/deleteOneProduct',data:JSON.stringify({"product_ID":product_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==true){
							$('#product-table').bootstrapTable('remove', {
								field: 'product_ID',
								values: [product_ID]
							});
							$.zjm_product.initProductTalble();
							$("#common_del").modal("hide");
						}else{
							alert("删除失败！");
						}
			        }
				});
			});
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("产品流程已被实例化，不允许删除！")
		}
	};
	
	/***修改***/
	function editModule(product_ID){
			$("#productPage").load("/gbpm/product/productEditPage",{"product_ID":product_ID},function(response,status,xhr){
				$("#editOneProductModal").modal({keyboard:true});
				zjm.init();
				/**注册编辑验证引擎*/
				zjm.validata({formId:"edit_productForm"});
				/**提交*/
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#edit_productForm").validationEngine("validate")){
						var queryContainer_form = $("#edit_productForm");
						if(zjm.ajaxValidata("edit_ProductName","/gbpm/product/isExistProductName",JSON.stringify(queryContainer_form.serializeJson()),"产品流程名称加版本号不能重复！")){
							$.ajax({type:'POST',url:'/gbpm/product/updateOneProduct',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								console.log(data);
								if(data.obj==1){
										$("#editOneProductModal").modal("hide");
										$.zjm_product.initProductTalble();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
						        }
							});
						}
						tool.undisabled(".btn_submit");
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#editOneProductModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
	};
	
	/**添加产品流程*/
	function addOneProduct(){ 
		$("#productPage").load("/gbpm/product/productAddPage",{},function(response,status,xhr){
			$("#addOneProductModal").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"add_productForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_productForm").validationEngine("validate")){
						var queryContainer_form = $("#add_productForm");
						if(zjm.ajaxValidata("add_prductName","/gbpm/product/isExistProductName",JSON.stringify(queryContainer_form.serializeJson()),"产品流程名称加版本号不能重复！")){
							$.ajax({type:'POST',url:'/gbpm/product/insertOneProductInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
										$("#addOneProductModal").modal("hide");
										$.zjm_product.initProductTalble();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
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
			$("#addOneProductModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	};
	
	/**复制产品流程*/
	function copyProduct(){ 
		var selectContent = $('#prodcut-table').bootstrapTable('getSelections')[0]; 
		if(typeof(selectContent) == 'undefined') { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			$("#productPage").load("/gbpm/product/copyProductPage",{"product_ID":selectContent.product_ID},function(response,status,xhr){
				$("#copyOneProductModal").modal({keyboard:true});
				zjm.init();
				/**注册编辑验证引擎*/
				zjm.validata({formId:"copy_productForm"});
				/**提交*/
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#copy_productForm").validationEngine("validate")){
						var queryContainer_form = $("#copy_productForm");
						if(zjm.ajaxValidata("copy_productName","/gbpm/product/isExistProductNameByCopy",JSON.stringify(queryContainer_form.serializeJson()),"产品流程名称加版本号不能重复！")){
							$.ajax({type:'POST',url:'/gbpm/product/copyProduct',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
										$("#copyOneProductModal").modal("hide");
										$.zjm_product.initProductTalble();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
						        }
							});
						}
						tool.undisabled(".btn_submit");
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#copyOneProductModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
		}
	};
	
	
	/***节点设置***/
	function setNodeModule(product_ID){
		window.parent.openMenu('set_node'+product_ID,'','节点设置','/gbpm/productNode/productNodePage','&product_ID='+product_ID);
	};
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	$.zjm_product.initProductTalble();
	$(".form-control-ztb").attr("placeholder",'输入产品名称,按回车搜索');
	$("#btn_addOneProduct").click(function(){
		$.zjm_product.addOneProduct();
	});
	
	$("#btn_copyProduct").click(function(){
		$.zjm_product.copyProduct();
	});
	
	//改变节点同级顺序
	$("#btn_productSort").click(function(){
		$("#productPage").load("/gbpm/product/selectAllProductPage",{},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
				    var opt = options[i];
				    $.ajax({type:'POST',url:'/gbpm/product/updateOneProduct',data:JSON.stringify({"product_ID":opt.value,"productSort":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
						}else{
							alert("保存失败！");
						}
					}
					});
				}
				$("#sortop").modal("hide");
				$.zjm_product.initProductTalble();
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
	});
	
});

