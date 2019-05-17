(function($,z){
	$.zjm_clientMaterial = {
			initColumns:initColumns,
			initMaterialTalble:initMaterialTalble,//初始化列表
			copyMaterialModel:copyMaterialModel,//复制客户资料模板
			returnMaterialModel:returnMaterialModel,//新增客户资料模板
			delModule:delModule,//客户资料模板删除
			editModule:editModule,//客户资料模板修改
			setMaterialModule:setMaterialModule,//模板设置
			viewModule:viewModule,//查看模板信息
	};
		
	function initColumns(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'materialModelName',title:'客户资料清单名称',align:'center',formatter: function (value, row, index) {return row.materialModelName;}},
			{field:'busiTypeNameList',title:'适用业务品种',align:'center',formatter: function (value, row, index) {return row.busiTypeNameList;}},
			{field:'clientTypeName',title:'适用客户类型',align:'center',formatter: function (value, row, index) {return row.clientTypeName;}},
			{field:'versionNumber',title:'版本',align:'center',formatter: function (value, row, index) {return "V"+row.versionNumber;}},
			{field:'status',title:'清单状态',align:'center',formatter: function (value, row, index) {return row.status?"启用":"禁用";}},
			{field:'remark',title:'备注',align:'center',formatter: function (value, row, index) {return row.remark;}},
			{title: '操作',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_modules_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
					
					'<button class="btn_modules_edit btn btn-xs btn-info" title="修改"><i class="icon-pencil bigger-120"></i></button>',
					/*'<button class="btn_modules_del btn btn-xs btn-danger" title="删除"><i class="icon-trash bigger-120"></i></button>',*/
					'<button class="btn_modules_set btn btn-xs btn-warning" title="节点设置"><i class="icon-gear bigger-120"></i></button>'].join('');
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_clientMaterial.viewModule(row);
					},
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_clientMaterial.editModule(row);
					},
					'click .btn_modules_del': function(e, value, row, index) {
						$.zjm_clientMaterial.delModule(row);
					},
					'click .btn_modules_set': function(e, value, row, index) {
						$.zjm_clientMaterial.setMaterialModule(row);
					}
				}
			}
		];
		return columns;
	}	
	
	/**初始化列表***/
	function initMaterialTalble(columns){
		$("#clientMaterial-table").bootstrapTable('destroy');
		$('#clientMaterial-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>客户资料清单名称:</b> ' + row.materialModelName + '</p>');
			        html.push('<p><b>适用业务品种:</b> ' + row.busiTypeNameList + '</p>');
			        html.push('<p><b>适用客户类型:</b> ' + row.clientTypeName + '</p>');
			        html.push('<p><b>版本:</b> ' + "V"+row.versionNumber + '</p>');
			        html.push('<p><b>清单状态:</b> ' + (row.status?"启用":"禁用") + '</p>');
			        html.push('<p><b>备注:</b> ' + row.remark + '</p>');
			        html.push('<p><b>操作:</b> ' + "<button class='btn_modules_edit btn btn-xs btn-info' title='修改' onclick=\"$.zjm_clientMaterial.editModule('"+row.product_ID+"');\"><i class='icon-pencil bigger-120'></i></button>"+
							/*"<button class='btn_modules_del btn btn-xs btn-danger' title='删除' onclick=\"$.zjm_clientMaterial.delModule('"+row.product_ID+"');\"><i class='icon-trash bigger-120'></i></button>"+*/
							"<button class='btn_modules_set btn btn-xs btn-warning' title='节点设置' onclick=\"$.zjm_clientMaterial.setNodeModule('"+row.product_ID+"');\"><i class='icon-gear bigger-120'></i></button>" + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"versionNumber",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/client/clientMaterial/selectMaterialModelPageTable",//这个接口需要处理bootstrap table传递的固定参数
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
		
	};
	/**查看**/
	function viewModule(row){
		$("#clientMaterial_Page").load("/client/clientMaterial/returnMaterialViewPage",{"materialModel_ID":row.materialModel_ID},function(response,status,xhr){
			$("#materialModelInfo_page").modal({keyboard:true});
		});
	}
	/***修改***/
	function editModule(row){
			$("#clientMaterial_Page").load("/client/clientMaterial/returnClientMaterialEditPage",{"materialModel_ID":row.materialModel_ID},function(response,status,xhr){
				$("#materialModelEdit_page").modal({keyboard:true});
				//获取业务品种下拉树;
				$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data){		
						$("#busiSortDicTree").selectTreeWidgets({
							width : "46%",//设置控件宽度
							multiple : true,//是否多选
							data : data.obj//数据源
						});
					}
				});
				zjm.init();
				/**注册编辑验证引擎*/
				zjm.validata({formId:"materialModelEdit_Form"});
				/**提交*/
				tool.undisabled("#btn_updateOneMaterialModel");
				$("#btn_updateOneMaterialModel").click(function(){
					tool.disabled("#btn_updateOneMaterialModel");
					if($("#materialModelEdit_Form").validationEngine("validate")){
						var queryContainer_form = $("#materialModelEdit_Form");
						if(zjm.ajaxValidata("materialModelEdit_Form","/client/clientMaterial/isExistMaterialModelName",JSON.stringify(queryContainer_form.serializeJson()),"客户资料清单模板加版本号不能重复！")){
							$.ajax({type:'POST',url:'/client/clientMaterial/updateOneMaterialModel',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								console.log(data);
								if(data.obj==1){
										$("#materialModelEdit_page").modal("hide");
										$.zjm_clientMaterial.initMaterialTalble();
									}else{
										alert("保存失败！");
										tool.undisabled("#btn_updateOneMaterialModel");
									}
						        }
							});
						}
						tool.undisabled("#btn_updateOneMaterialModel");
					}else{
						tool.undisabled("#btn_updateOneMaterialModel");
					}
				});
				$("#materialModelEdit_page").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $("#btn_updateOneMaterialModel").unbind("click");
				});
			});
	};
	
	/**新增客户资料模板*/
	function returnMaterialModel(){ 
		$("#clientMaterial_Page").load("/client/clientMaterial/returnMaterialModelAddPage",{},function(response,status,xhr){
			$("#materialModelAdd_page").modal({keyboard:true});
			//获取业务品种下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){		
					$("#busiSortDicTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : true,//是否多选
						data : data.obj//数据源
					});
				}
			});
			
			
			
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"materialModelAdd_Form"});
			/**提交*/
			tool.undisabled("#btn_materialModelAdd");
			$("#btn_materialModelAdd").click(function(){
				tool.disabled("#btn_materialModelAdd");
				if($("#materialModelAdd_Form").validationEngine("validate")){
						var queryContainer_form = $("#materialModelAdd_Form");
						if(zjm.ajaxValidata("materialModelAdd_Form","/client/clientMaterial/isExistMaterialModelName",JSON.stringify(queryContainer_form.serializeJson()),"客户资料清单模板加版本号不能重复！")){
							$.ajax({type:'POST',url:'/client/clientMaterial/insertOneMaterialModel',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
										$("#materialModelAdd_page").modal("hide");
										$.zjm_clientMaterial.initMaterialTalble();
									}else{
										alert("保存失败！");
										tool.undisabled("#btn_materialModelAdd");
									}
						        }
							});
						}else{
							tool.undisabled("#btn_materialModelAdd");
						}
				}else{
					tool.undisabled("#btn_materialModelAdd");
				}
			});
			$("#materialModelAdd_page").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $("#btn_materialModelAdd").unbind("click");
			});
		});
	};
	
	/**复制客户资料模板*/
	function copyMaterialModel(){ 
		var selectContent = $('#clientMaterial-table').bootstrapTable('getSelections')[0]; 
		if(typeof(selectContent) == 'undefined') { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			$("#clientMaterial_Page").load("/client/clientMaterial/returnMaterialModelCopyPage",{"materialModel_ID":selectContent.materialModel_ID},function(response,status,xhr){
				$("#materialModelCopy_page").modal({keyboard:true});
				//获取业务品种下拉树;
				$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data){		
						$("#busiSortDicTree").selectTreeWidgets({
							width : "46%",//设置控件宽度
							multiple : true,//是否多选
							data : data.obj//数据源
						});
					}
				});
				zjm.init();
				/**注册编辑验证引擎*/
				zjm.validata({formId:"materialModelCopy_form"});
				/**提交*/
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#materialModelCopy_form").validationEngine("validate")){
						var queryContainer_form = $("#materialModelCopy_form");
						if(zjm.ajaxValidata("add_materialModelName","/client/clientMaterial/isExistMaterialModelName",JSON.stringify(queryContainer_form.serializeJson()),"客户资料清单模板加版本号不能重复！")){
							$.ajax({type:'POST',url:'/client/clientMaterial/copyMaterialModel',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
										$("#materialModelCopy_page").modal("hide");
										$.zjm_clientMaterial.initMaterialTalble();
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
				$("#materialModelCopy_page").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
		}
	};
	
	
	/***节点设置***/
	function setMaterialModule(row){
		window.parent.openMenu('set_Material'+row.materialModel_ID,'','客户资料类型设置','/client/clientMaterial/setMaterialModule','&materialModel_ID='+row.materialModel_ID);
	};
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	$.zjm_clientMaterial.initMaterialTalble();
	
	$(".form-control-ztb").attr("placeholder",'输入客户资料清单名称,按回车搜索');
	
	//新增客户资料清单
	$("#btn_returnMaterialModel").click(function(){
		$.zjm_clientMaterial.returnMaterialModel();
	});
	
	$("#btn_copyMaterialModel").click(function(){
		$.zjm_clientMaterial.copyMaterialModel();
	});
	
	
});

