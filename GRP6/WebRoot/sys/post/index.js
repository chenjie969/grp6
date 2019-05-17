(function($,z){
	$.zjm_post = {
			initTree:initTree,//加载树结构
			loadInfo:loadInfo,//加载列表
			initTable:initTable,//初始化列表
			addPost:addPost, //添加下级岗位
			viewPostInfo:viewPostInfo,//查看一个岗位信息;
			editPostInfo:editPostInfo, // 修改一个岗位信息;
			delPostInfo:delPostInfo   //删除岗位;
			
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(mod_uid){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllPostListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			$.zjm_post.loadInfo("/sys/post/list.jsp",treeNode.id,isChild);
		};
		if(mod_uid==null){mod_uid='1d6036039f5949e7b2b8a02be61bd7d2';}
		$.zjm_post.loadInfo("/sys/post/list.jsp",mod_uid);
	}
	/**加载事件*/
	function loadInfo(url,nodeid,isChild){
		$("#loadinfo").load(url,function(){$.zjm_post.initTable(nodeid,isChild);});
	}
	/**初始化列表***/
	function initTable(nodeid,isChild){
		$('#post-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"postName",title: '岗位名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.postName;}}, 
					{field:"postDescription",title: '岗位人员',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.post_User;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_post.viewPostInfo(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_post.editPostInfo(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_post.delPostInfo(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>岗位名称:</b> ' + tool.isNull(row.postName,"") + '</p>');
			        html.push('<p><b>岗位人员:</b> ' + tool.isNull(row.post_User,"") + '</p>');
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
			url: "/selectPostPageTables",//这个接口需要处理bootstrap table传递的固定参数
			ajaxOptions:{data:{"queryCondition.post_ID":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"parentPostID":nodeid}});
				}else{
					$.extend(params,{"queryCondition":{"post_ID":nodeid}});
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
	};
	
	
	/** 岗位添加   添加下级岗位*/
	function addPost(id,name){
		$("#addPost").modal({keyboard:true});
		$(".ztb_add_parentPostID").val(id);//当前节点id 赋给父id 
		$(".ztb_add_up_postName").text(name); //上级岗位名称，用于页面显示
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"addPost_form"});
		/**提交  保存岗位信息*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#addPost_form");
			if($("#addPost_form").validationEngine("validate") 
					&& zjm.ajaxValidata("add_postName","/selectAddPostNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级岗位名称已存在！")){
				$.ajax({
					type : 'POST',
					url : '/insertOnePostInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#addPost").modal("hide");
							$(".ztb_add").val("");
							$.zjm_post.initTree(id);
						} else {
							$("#operateFailModule").modal({keyboard:true});
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addBankSort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	
	/**岗位查看**/
	function viewPostInfo(row){
		$("#viewPostinfo").modal({keyboard:true});
		zjm.dataViewText("view_","/selectOnePostInfo",{"post_ID":row.post_ID},'');
	};
	
	/**岗位修改**/
	function editPostInfo(row){
		$("#editPost").modal({keyboard:true});
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_post_form"
		});
		/*zjm.dataViewVal("edit_","/selectOnePostInfo",{"post_ID":row.post_ID},'');*/
		$.ajax({
			type:'post',
			url:'/selectOnePostInfo',
			data: JSON.stringify({"post_ID":row.post_ID}),
			async:false,
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('parentPostName') > 0){
							$("#ztb_edit_parentPostName").html(value);
						} else{
							$(".ztb_edit_"+key).val(value);
						}
					}
				})
			}
		})
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOnePostInfo",{"post_ID":row.post_ID},'');
		});
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#edit_post_form");
			if($("#edit_post_form").validationEngine("validate") 
					&& zjm.ajaxValidata("edit_postName","/selectAddPostNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级岗位名称已存在！")){
					$.ajax({type:'POST',url:'/updateOnePostInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#editPost").modal("hide");
							$.zjm_post.initTree(row.parentPostID);
						}else{
							$("#operateFailModule").modal({keyboard:true});
						}
			        }
					});
				/*}*/
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editPost").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	};
	
	/**岗位删除***/
	function delPostInfo(row){
		//两个ID相等说明是根节点不可删除
		if(row.post_ID == '1d6036039f5949e7b2b8a02be61bd7d2'){
			$("#delRootPostModule").modal({keyboard:true});
			return false;
		}
		$("#delPostModule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',
				url:'/deleteOnePostInfo',
				data:JSON.stringify({"post_ID":row.post_ID,"postName":row.postName}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
		        	if(data.obj==true){
						$.zjm_post.initTree();
						$("#delPostModule").modal("hide");
					}else{
						$("#operateFailModule").modal({keyboard:true});
					}
	        }
		});
		});
		$("#delPostModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 岗位信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_post.initTree();
	};
	/**
	 * 添加下级 岗位
	 */
	$("#btn_add_post").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectPost").modal({keyboard:true});
			return false;
		}
		//最多两级 银行字典
		/*if(node.level >= 3){
			alert("不能添加下级 银行字典!");
			return false;
		}*/
		$.zjm_post.addPost(node.id,node.name);
	});
	
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectPost").modal({keyboard:true});
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/selectPostListJSON",{"post_ID":node.pId});
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
			zjm.dataSortVal("/selectPostListJSON",{"punit_uid":node.pId});
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

