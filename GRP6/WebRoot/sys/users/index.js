(function($,z){
	$.zjm_module = {
			initTree:initTree,//加载树结构
			loadInfo:loadInfo,//加载列表
			initTable:initTable,//初始化列表
			addUserModule:addUserModule,//用户添加
			viewUserModule:viewUserModule,//用户查看
			editUserModule:editUserModule,//用户修改
			delModule:delModule,//用户删除
			addDepartModule:addDepartModule,//部门添加
			editDepartModule:editDepartModule,//部门修改
			delDepartModule:delDepartModule,//部门删除
			viewDepartModule:viewDepartModule,//部门查看
			setDepartLeader:setDepartLeader,//部门查看
			setPost:setPost //分配岗位
			
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(depart_uid){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/}};
		zTreeObj = tree.init({initID:"departSetTree",url:"/selectAllDepartsListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_module.loadInfo("/sys/users/list.jsp",treeNode.id);
		};
		if(depart_uid==null){depart_uid='a129b9eea27a48be896697a39aa0aee7';}
		$.zjm_module.loadInfo("/sys/users/list.jsp",depart_uid);
	}
	/**加载事件*/
	function loadInfo(url,nodeid){
		$("#loadinfo").load(url,function(){$.zjm_module.initTable(nodeid);});
	}
	/**初始化列表***/
	function initTable(nodeid){
		$('#user-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"user_bh",title: '用户编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.user_bh;}},
					{field:"user_name",title: '用户姓名',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.user_name;}},
					{field:"user_id",title: '登录帐号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.user_id;}}, 
					{field:"user_type",title: '员工类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return (row.user_type=='2'?'离职':(row.user_type=='3'?'外部':'在职'));}},
					{field:"isactive",title: '是否允许登录',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isactive==1?'是':'否';}},
					{field:"isEable",title: '是否禁用',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isEable==1?'是':'否';}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_module.viewUserModule(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_module.editUserModule(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_module.delModule(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>用户编号:</b> ' + row.user_bh + '</p>');
			        html.push('<p><b>用户姓名:</b> ' + row.user_name + '</p>');
			        html.push('<p><b>登录帐号:</b> ' + row.user_id + '</p>');
			        html.push('<p><b>员工类型:</b> ' + (row.user_type=='2'?'离职':(row.user_type=='3'?'外部':'在职')) + '</p>');
			        html.push('<p><b>所属岗位:</b> ' + tool.isNull(row.postName,'（空）') + '</p>');
			        html.push('<p><b>是否允许登录:</b> ' + (row.isactive==1?'是':'否') + '</p>');
			        html.push('<p><b>是否禁用:</b> ' + (row.isEable==1?'是':'否') + '</p>');
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
			url: "/selectUsersPageTables",//这个接口需要处理bootstrap table传递的固定参数
			ajaxOptions:{data:{"queryCondition.depart_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"depart_uid":nodeid}});
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


	
	/**用户添加*/
	function addUserModule(id,name){
		$("#addUserModule").modal({keyboard:true});
		$(".ztb_add_depart_uid").val(id);
		$(".ztb_add_up_depart_name").text(name);
		$(".icon-picker").iconPicker("add_wraper");
		// 获取  岗位选择下拉列表
		$.ajax({
			type : 'POST',
			url : "/selectPostList",
			data : JSON.stringify({"depart_uid" : id}),
			async : false,
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$("." +"ztb_add_post_ID").empty();
				$("." + "ztb_add_post_ID").append("<option value=''>&nbsp;请选择</option>");
				$.each(data.obj, function(key1, value1) {
					$.each(value1, function(key2, value2) {
						$("." + "ztb_add_post_ID").append("<option value='" + key2 + "'>"+ value2 + "</option>");
					});
				});
			}
		});
		
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_user_form"});
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#add_user_form");
			// 验证表单及帐号是否存在
			if($("#add_user_form").validationEngine("validate") 
					&& zjm.ajaxValidata("add_user_id","/selectAddUsersIdIsExist",JSON.stringify(queryContainer_form.serializeJson()),"登录账号已存在！")){
				$("#add_password").val($.md5($("#add_password").val()));
				$("#repeatpwd").val($.md5($("#add_password").val()));
				$.ajax({
					type:'POST',
					url:'/insertOneUsersInfo',
					data:JSON.stringify(queryContainer_form.serializeJson()),
					contentType:'application/json; charset=UTF-8',
					dataType:'json',success:function(data) {
		        	if(data.obj==1){
						$("#addUserModule").modal("hide");
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
		$("#addUserModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/***用户查看***/
	function viewUserModule(row){
		$("#viewUserModule").modal({keyboard:true});
		$.ajax({
			type:'post',
			url:'/selectOneUsersInfo',
			data: JSON.stringify({"user_uid":row.user_uid}),
			async:false,
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_view_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('depart_name') > 0){
							$(".ztb_view_depart_name").html(value);
						} else if(rt.indexOf('user_id') > 0){
							$(".ztb_view_user_id").html(value);
						} else if(rt.indexOf('user_name') > 0){
							$(".ztb_view_user_name").html(value);
						} else if(rt.indexOf('user_bh') > 0){
							$(".ztb_view_user_bh").html(value);
						} else if(rt.indexOf('user_type') > 0){
							$(".ztb_view_user_type").html(value=='2'?'离职':(value=='3'?'外部':'在职'));
						} else if(rt.indexOf('isactive') > 0){
							$(".ztb_view_isactive").html(value==1?'是':'否');
						} else if(rt.indexOf('isEable') > 0){
							$(".ztb_view_isEable").html(value==1?'是':'否');
						}else{
							$(".ztb_view_"+key).text(value==null?'（空）':value);
						}
					}
				})
			}
		})
	}
	/**用户修改**/
	function editUserModule(row){
		$("#editUserModule").modal({keyboard:true});
		$(".icon-picker").iconPicker("edit_wraper");
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		$.ajax({
			type:'post',
			url:'/selectOneUsersInfo',
			data: JSON.stringify({"user_uid":row.user_uid}),
			async:false,
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('depart_name') > 0){
							$("#user_edit_depart_name").html(value);
						} else{
							$(".ztb_edit_"+key).val(value);
						}
					}
				})
			}
		})
		
		// 默认的岗位名称
		var defaultPostName=	$("#defaultPostName").val();
		
		var currentNode	=zTreeObj.getSelectedNodes()[0];
		var id='';
		if(currentNode == null){
			id='a129b9eea27a48be896697a39aa0aee7';
		}else{
			id=currentNode.id;
		}
		// 获取  岗位选择下拉列表
		$.ajax({
			type : 'POST',
			url : "/selectPostList",
			data : JSON.stringify({"user_uid" : row.user_uid}),
			async : false,
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$("." +"ztb_edit_post_ID").empty();
				$("." + "ztb_edit_post_ID").append("<option value=''>&nbsp;请选择</option>");
				$.each(data.obj, function(key1, value1) {
					$.each(value1, function(key2, value2) {
						if(value2 == defaultPostName ){
							$("." + "ztb_edit_post_ID").append("<option selected='selected' value='" + key2 + "'>"+ value2 + "</option>");
						}else{
							$("." + "ztb_edit_post_ID").append("<option value='" + key2 + "'>"+ value2 + "</option>");
						}
					});
				});
			}
		});
		//获取部门下拉树;
		$.ajax({type:'POST',url:'/selectAllDepartsListTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#departUid").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#edit_form");
			if($("#edit_form").validationEngine("validate") 
					&& zjm.ajaxValidata("edit_user_id","/selectEditUsersIdIsExist",JSON.stringify(queryContainer_form.serializeJson()),"登录账号已存在！")){
				$.ajax({type:'POST',url:'/updateOneUsersInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
						$("#editUserModule").modal("hide");
						$("#departUid").val("");
						$.zjm_module.initTree(row.depart_uid);
						//window.location.reload();
					}else{
						$("#operateFailModule").modal({keyboard:true});
					}
		        }
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editUserModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/**用户删除***/
	function delModule(row){
		if(row.user_id == 'admin'){
			$("#delUserWarningModule").modal({keyboard:true});
			return false;
		}
		$("#delUserModule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
					$.ajax({type:'POST',
						url:'/deleteOneUsersInfo',
						data:JSON.stringify({"user_uid":row.user_uid,"user_name":row.user_name}),
						contentType:'application/json; charset=UTF-8',
						dataType:'json',
						success:function(data) {
							
				        	if(data.obj==true){
								$('#user-table').bootstrapTable('remove', {
									field: 'user_uid',
									values: [row.user_uid]
								});
								$.zjm_module.initTree(row.depart_uid);
								$("#delUserModule").modal("hide");
							}else{
								$("#operateFailModule").modal({keyboard:true});
							}
						}
					});
		});
		$("#delUserModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/**部门添加*/
	function addDepartModule(id,name){
		$("#addmodule").modal({keyboard:true});
		$(".ztb_add_pdepart_id").val(id);
		$(".ztb_add_up_depart_name").text(name);
		$(".icon-picker").iconPicker("add_wraper");
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_departs_from"});
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#add_departs_from");
			if($("#add_departs_from").validationEngine("validate") && zjm.ajaxValidata("add_depart_name","/selectAddDepartsNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级部门名称已存在！")){
				$.ajax({type:'POST',url:'/insertOneDepartsInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
						$("#addmodule").modal("hide");
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
		$("#addmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/**部门查看**/
	function viewDepartModule(id,name,ppnode){
		$("#viewdepartswmodule").modal({keyboard:true});
		zjm.dataViewText("view_","/selectOneDepartsInfo",{"depart_uid":id});
	}
	
	/**部门修改**/
	function editDepartModule(id,name,ppnode){
		$("#editDepartsModule").modal({keyboard:true});
		$(".icon-picker").iconPicker("edit_wraper");
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_departs_form"
		});
		zjm.dataViewVal("edit_","/selectOneDepartsInfo",{"depart_uid":id},'');
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOneDepartsInfo",{"depart_uid":id},'');
		});
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#edit_departs_form");
			if($("#edit_departs_form").validationEngine("validate") && zjm.ajaxValidata("edit_depart_name","/selectEditDepartsNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级部门名称已存在！")){
				$.ajax({type:'POST',url:'/updateOneDepartsInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
						$("#editDepartsModule").modal("hide");
						$.zjm_module.initTree(ppnode);
					}else{
						$("#operateFailModule").modal({keyboard:true});
					}
		        }
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editDepartsModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**设置部门负责人**/
	function setDepartLeader(id,name,ppnode){
		$("#setDepartLeader").load("/setDepartLeaderPage",{"depart_uid":id},function(response,status,xhr){
			$("#setDepartsLeaderModule").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({
				formId:"set_departs_leader_form"
			});
			/**提交***/
			tool.undisabled(".btn_submit");
			
			$('#usersList').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#leve1_user_name').val(p1);
			});
			
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#set_departs_leader_form");
				if($("#set_departs_leader_form").validationEngine("validate")){
					$.ajax({type:'POST',url:'/setDepartLeader',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#setDepartsLeaderModule").modal("hide");
							$.zjm_module.initTree(ppnode);
						}else{
							$("#operateFailModule").modal({keyboard:true});
						}
					}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#setDepartsLeaderModule").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_reset").unbind("click");
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	/**部门删除***/
	function delDepartModule(id,name,ppnode){
		//两个ID相等说明是根节点不可删除
		if(ppnode==id){
			$("#delRootDepartModule").modal({keyboard:true});
			return false;
		} else {
			$("#delDepartModule").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',
					url:'/deleteOneDepartsInfo',
					data:JSON.stringify({"depart_uid":id,"depart_name":name}),
					contentType:'application/json; charset=UTF-8',
					dataType:'json',
					success:function(data) {
			        	if(data.obj==true){
							$('#user-table').bootstrapTable('remove', {
								field: 'depart_uid',
								values: [id]
							});
							$.zjm_module.initTree(ppnode);
							$("#delDepartModule").modal("hide");
						}else{
							$("#operateFailModule").modal({keyboard:true});
						}
		        }
			});
			});
			$("#delDepartModule").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}
	}
	
	/**
	 * 设置岗位  分配岗位
	 * @returns
	 */
	function setPost(id,name,ppnode){
		$("#setPost").modal({keyboard:true});
		zjm.dataViewVal("edit_","/selectOneDepartsInfo",{"depart_uid":id},'');
		$("#ztb_edit_parentPostName").text(name);
		
		selectNodes=zTreeObj.getSelectedNodes();//当前选中对象
		currentNodes=selectNodes[0];
		// 获取岗位下拉树
		$.ajax({type:'POST',url:'/sys/dic/selectPostDicTree',data:JSON.stringify({"depart_uid":currentNodes.id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$("#select_user_tree_Post").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : true,//是否多选
				data : data.obj//数据源
			});
		}
		});
		
		// 获取 部门中已经分配的岗位
		var posts="";
		var postIds="";
		$.ajax({
			type : 'POST',
			url : "/selectPostList",
			data : JSON.stringify({"depart_uid" : currentNodes.id}),
			async : false,
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$("#select_user_tree_Post").val("");//清空
				$.each(data.obj, function(key1, value1) {
					$.each(value1, function(key2, value2) {
						posts= posts+value2+",";
						postIds=postIds+key2+",";
					});
				});
				$("#select_user_tree_Post").val(posts);
				$("#select_user_tree_Post").attr("dataValue",postIds);
			}
		});
		
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#edit_setPost_form");
			$.ajax({type:'POST',url:'/updateSetDepartPostInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	        	if(data.obj==1){
					$("#setPost").modal("hide");
					$.zjm_module.initTree(ppnode);
				}else{
					$("#operateFailModule").modal({keyboard:true});
				}
	        }
			});
		});
		$("#setPost").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
		
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 部门信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_module.initTree();
	};
	//添加部门
	$("#btn_add_departs").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		//最多五级部门
		if(node.level >= 4){
			alert("不能添加下级部门!");
			return false;
		}
		$.zjm_module.addDepartModule(node.id,node.name);
	});
	//添加用户
	$("#btn_add_users").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		$.zjm_module.addUserModule(node.id,node.name);
	});
	//修改部门
	$("#btn_update_departs").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_module.editDepartModule(node.id,node.name,ppnode);
	});
	//查看部门btn_view_departs
	$("#btn_view_departs").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_module.viewDepartModule(node.id,node.name,ppnode);
	});
	//删除部门
	$("#btn_delete").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		var ppnode;
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_module.delDepartModule(node.id,node.name,ppnode);
	});
	
	// 设置岗位 
	$("#btn_sort_post").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_module.setPost(node.id,node.name,ppnode);
	})
	
	// 设置部门负责人
	$("#btn_set_leader").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		var ppnode;
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_module.setDepartLeader(node.id,node.name,ppnode);
	})
	
	
	//部门同级排序
	$("#btn_sort_departs").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/selectDepartsListJSON",{"pdepart_id":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"sys_departs","tableFileName":"depart_uid","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
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
			zjm.dataSortVal("/selectDepartsListJSON",{"pdepart_id":node.pId});
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
	
	
	
	
	
	
	//用户同级排序
	$("#btn_sort_users").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectDepart").modal({keyboard:true});
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/selectUsersListJSON",{"depart_uid":node.id});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"sys_users","tableFileName":"user_uid","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
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
			zjm.dataSortVal("/selectUsersListJSON",{"depart_uid":node.id});
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

