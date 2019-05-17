(function($,z){
	$.zjm_module = {
			initTree:initTree,//加载树结构
			loadInfo:loadInfo,//加载列表
			initTable:initTable,//初始化列表
			addUnitsModule:addUnitsModule,//机构添加
			viewUnitsModule:viewUnitsModule,//机构查看
			editUnitsModule:editUnitsModule,//机构修改
			delUnitsModule:delUnitsModule//机构删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(mod_uid){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllUnitsListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			$.zjm_module.loadInfo("/sys/units/list.jsp",treeNode.id,isChild);
		};
		if(mod_uid==null){mod_uid='cbeb758e3d824626a31aabb2a9587b0a';}
		$.zjm_module.loadInfo("/sys/units/list.jsp",mod_uid);
	}
	/**加载事件*/
	function loadInfo(url,nodeid,isChild){
		$("#loadinfo").load(url,function(){$.zjm_module.initTable(nodeid,isChild);});
	}
	/**初始化列表***/
	function initTable(nodeid,isChild){
		$('#units-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"unit_uidName",title: '机构名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}}, 
					/*{field:"unit_uidFullCode",title: '机构编号全称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidFullCode;}},
					{field:"isEable",title: '是否可禁用',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isEable;}},
					{field:"contentType",title: '系统自带还是用户自定义',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.contentType;}},
					{field:"unificationID",title: '统一编码',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unificationID;}},*/
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_module.viewUnitsModule(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_module.editUnitsModule(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_module.delUnitsModule(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>机构名称:</b> ' + row.unit_uidName + '</p>');
			       /* html.push('<p><b>机构编号全称:</b> ' + row.unit_uidFullCode + '</p>');
			        html.push('<p><b>是否可禁用:</b> ' + row.isEable + '</p>');
			        html.push('<p><b>系统自带还是用户自定义:</b> ' + row.contentType + '</p>');
			        html.push('<p><b>统一编码:</b> ' + row.unificationID + '</p>');*/
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
			url: "/selectUnitsPageTables",//这个接口需要处理bootstrap table传递的固定参数
			ajaxOptions:{data:{"queryCondition.unit_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"punit_uid":nodeid}});
				}else{
					$.extend(params,{"queryCondition":{"unit_uid":nodeid}});
				}
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


	/**机构添加*/
	function addUnitsModule(id,name,ppnode){
		$("#addUnitsModule").modal({keyboard:true});
		$(".ztb_add_punit_uid").val(id);
		$(".ztb_add_up_unit_uidName").text(name);
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		/**提交*/
		// 将按钮复活
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			//将按钮置为不可用
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#add_form");
			if($("#add_form").validationEngine("validate") 
					&& zjm.ajaxValidata("add_unit_uidName","/selectAddUnitsNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"机构名称已存在！")
					&& zjm.ajaxValidata("add_user_id","/selectAddUsersIdIsExist",JSON.stringify(queryContainer_form.serializeJson()),"管理员账号已存在！")){
				
				$("#add_password").val($.md5($("#add_password").val()));
				$("#repeatpwd").val($.md5($("#repeatpwd").val()));
				$.ajax({type:'POST',url:'/insertOneUnitsInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#addUnitsModule").modal("hide");
							$(".ztb_add").val("");
							$.zjm_module.initTree(id);
						}else{
							$("#operateFailModule").modal({keyboard:true});
						}
		        	}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addUnitsModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/***机构查看***/
	function viewUnitsModule(row){
		$("#viewUnitsModule").modal({keyboard:true});
		zjm.dataViewText("view_","/selectOneUnitsInfo",{"unit_uid":row.unit_uid},'');
	}
	/**机构修改**/
	function editUnitsModule(row){
		$("#editUnitsModule").modal({keyboard:true});
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		/*zjm.dataViewVal("edit_","/selectOneUnitsInfo",{"unit_uid":row.unit_uid},'');*/
		
		$.ajax({
			type:'post',
			url:'/selectOneUnitsInfo',
			data: JSON.stringify({"unit_uid":row.unit_uid}),
			async:false,
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('pUnitsName') > 0){
							$("#ztb_edit_pUnitsName").html(value);
						} else{
							$(".ztb_edit_"+key).val(value);
						}
					}
				})
			}
		})
		
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOneUnitsInfo",{"unit_uid":row.unit_uid},'');
		});
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#edit_form");
			if($("#edit_form").validationEngine("validate") 
					&& zjm.ajaxValidata("edit_unit_uidName","/selectEditUnitsNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"机构名称已存在！")){
				  $.ajax({type:'POST',url:'/updateOneUnitsInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#editUnitsModule").modal("hide");
							$.zjm_module.initTree(row.pmod_uid);
						}else{
							$("#operateFailModule").modal({keyboard:true});
						}
			        }
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editUnitsModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	/**机构删除***/
	function delUnitsModule(row){
		//两个ID相等说明是根节点不可删除
		if(row.unit_uid == 'cbeb758e3d824626a31aabb2a9587b0a'){
			$("#delRootUnitsModule").modal({keyboard:true});
			return false;
		} else {
			$("#delUnitsModule").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				 $.ajax({
					 type:'POST',
					 url:'/deleteOneUnitsInfo',
					 data:JSON.stringify({"unit_uid":row.unit_uid,"unit_uidName":row.unit_uidName}),
					 contentType:'application/json; charset=UTF-8',
					 dataType:'json',
					 success:function(data) {
			        	if(data.obj==true){
							$('#units-table').bootstrapTable('remove', {
								field: 'unit_uid',
								values: [row.unit_uid]
							});
							$.zjm_module.initTree(row.punit_uid);
							$("#delUnitsModule").modal("hide");
						}else{
							$("#operateFailModule").modal({keyboard:true});
						}
			        }
				 });
			});
			$("#delUnitsModule").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 机构信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_module.initTree();
	};

	$("#btn_add").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectUnits").modal({keyboard:true});
			return false;
		}
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		//最多5机构
		if(node.level >= 4){
			$("#maxLevelModule").modal({keyboard:true});
			return false;
		}
		$.zjm_module.addUnitsModule(node.id,node.name,ppnode);
	});
	
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectUnits").modal({keyboard:true});
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/selectUnitsListJSON",{"punit_uid":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({
				type:'POST',
				url:'/updateSortOrder',
				data:JSON.stringify({"tableName":"sys_units","tableFileName":"unit_uid","tableFileIds":$("#tableFileIds").val()}),
				contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==1){
						$("#sortop").modal("hide");
						$.zjm_module.initTree();
					}else{
						$("#operateFailModule").modal({keyboard:true});
						$.zjm_module.initTree();
					}
		        }
			});
		});
		$(".btn_reset").click(function () {
			zjm.dataSortVal("/selectUnitsListJSON",{"punit_uid":node.pId});
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

