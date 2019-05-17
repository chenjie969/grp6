(function($,z){
	var zTreeObjLeft="";
	$.zjm_announce = {
			initTree : initTree,// 加载树结构
			addTree:addTree,
			editTree:editTree
	};
	

	var zTreeObj; // ztree对象
	/** 加载树结构 */
	function initTree(CooperationID,isChild) {
		var setting = {
			callback : {
				onClick : zTreeOnMouseDown	/** 捕获 zTree 上鼠标按键按下后的事件回调函数* */
				,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/
			}
		};
		// 初始化加载左侧树形结构
		zTreeObj = tree.init({
			initID : "menuSetTree",
			url : "/oa/announce/selectAllInfoListTree"
		}, setting);
		
		/** 单击 节点 触发的函数* */
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
//			tree.expand();
			
			var treeLevel = "";
			if(treeNode.id=="b4cb8bf303974996ac4df5e87cf30ac0"){	//祖先节点
				treeLevel = "1";
			}else if(treeNode.isParent){	//判断当前节点是否有子节点
				treeLevel = "2";
			}else{
				treeLevel = "3";
			}
			
			$("#currentTreeId").val(treeNode.id);
			$("#treeLevel").val(treeLevel);
			
			//初始化右边的列表
			var currentTab = $("li.active > a").attr("id");
			switch(currentTab){
				case "noSignTab":$.zjm_noSignAnnounce.initTable(treeNode.id,treeLevel);break;
				case "yesSignTab":$.zjm_yesSignAnnounce.initTable(treeNode.id,treeLevel);break;
				case "allTab":$.zjm_allAnnounce.initTable(treeNode.id,treeLevel);break;
			}
		};
		
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
				$.each(nodes,function(index,element){
					if(nodes[index].id == CooperationID){
						zTreeObj.selectNode(nodes[index]);
						zTreeObj.expandNode(nodes[index],true,false,true);
					}
				})
		};
		
		
	//	$.zjm_announce.initTable(CooperationID,isChild);
	}
	
	/** 多级字典修改**/
	function editTree(id,unitUid){
		$("#editMultilevelsort").modal({keyboard:true});
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		// 获取修改对象
		$.ajax({
			type:'post',
			url:'/selectOneMultilevelsortInfo',
			data: JSON.stringify({"multilevelsortid":id ,"unitUid":unitUid }),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('iseable') > 0){
							if(value == 1){ // =1 禁用，0启用
								$("#edit_iseable1").prop("checked","checked");
								$("#edit_iseable0").prop("checked");
							}else{
								$("#edit_iseable0").prop("checked","checked");
								$("#edit_iseable1").prop("checked");
							}
						}else{
							$(".ztb_edit_"+key).val(value);
						}
					}
				})
			}
		})// 获取修改对象 信息 end 
		
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOneMultilevelsortInfo",{"multilevelsortid":id});
		});
		/**提交  保存修改***/
		tool.undisabled(".btn_submit"); // 按钮调整为 可用
		$(".btn_submit").click(function(){
			if($("#edit_form").validationEngine("validate")){
				var queryContainer_form = $("#edit_form"); 
				var	edit_multilevelsortname=$("#edit_multilevelsortname").val();
				if(zjm.ajaxValidata("edit_multilevelsortname","/selectEditMmultilevelSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson())," 多级字典名称重复！")){
					tool.disabled(".btn_submit"); // 按钮调整为 不可用
					$.ajax({
						type : 'POST',
						url : '/updateOneMultilevelsortInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj == 1) {
								$("#editMultilevelsort").modal("hide");
								$(".ztb_add").val("");
								
								$.ajax({type:'POST',url:'/selectAllmultilevelsortListPageTables',data:JSON.stringify({"queryCondition":{"pmultilevelsortid":$("#lastTableDictypeID").val()}}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									//修改后刷新列表，取的是上一次查询列表的ID
										if(data.obj.rows.length==0){	//没有查到数据，说明是叶子节点	
											$.zjm_announce.initTree($("#lastTableDictypeID").val(),false);
										}else{							
											$.zjm_announce.initTree($("#lastTableDictypeID").val(),true);
										}
									}
								});
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
		$("#editMultilevelsort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	/** 添加   添加下级*/
	function addTree(id,name){
		$("#announceAddChildrenOrg").modal({keyboard:true});
		$(".ztb_add_pmultilevelsortid").val(id);
		$(".ztb_add_up_multilevelsortname").text(name);
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		/**提交  保存岗位信息*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#add_form");
			var add_multilevelsortname =$("#add_multilevelsortname").val();
			if($("#add_form").validationEngine("validate") 
					&& zjm.ajaxValidata(add_multilevelsortname,"/selectAddMmultilevelSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级名称已存在！")){
				
				$.ajax({
					type : 'POST',
					url : '/insertOneMultilevelsortInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj != null) {
							$("#announceAddChildrenOrg").modal("hide");
							$(".ztb_add").val("");
							$.zjm_announce.initTree();
							
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#announceAddChildrenOrg").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	
	
})(jQuery, this);

$(function () {
	
	$.zjm_noSignAnnounce.initTable();
	$.zjm_announce.initTree();
	
	
	$("#noSignTab").click(function(){
		$.zjm_noSignAnnounce.initTable();
	});
	
	
	$("#yesSignTab").click(function(){
		$.zjm_yesSignAnnounce.initTable();
	});
	
	$("#allTab").click(function(){
		$.zjm_allAnnounce.initTable();
	});
	//修改当前节点
	$("#btn_updateChildrenOrg").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectTree").modal({keyboard:true});
			return false;
		}
		if(node.isParent){
			$("#pleaseSelectChildTree").modal({keyboard:true});
			$("#msg").text("该信息分类不允许修改");
			return false;
		}
		$.zjm_announce.editTree(node.id,node.unitUid);
	});
	//添加下级机构
	$("#btn_addChildrenOrg").click(function(){
		
	
			var node = tree.getChecke();
			if(node == null){
				$("#pleaseSelectTree").modal({keyboard:true});
				return false;
			}
			
			//最多两级 银行字典
			/*if(node.level >= 3){
				alert("不能添加下级 银行字典!");
				return false;
			}*/
			$.zjm_announce.addTree(node.id,node.name);
	
	/*	
		$("#info_page").load("/oa/announce/announceaddChildrenOrgPage",{},function(response,status,xhr){
			$("#announceAddChildrenOrg").modal({keyboard:true});
		});*/
		
	});
	

	/** 同级顺序调整 */
	$("#btn_sort").click(function() {
		
		/*$("#info_page").load("/oa/announce/announceSortPage",{},function(response,status,xhr){
			$("#sortOrg").modal({
				keyboard : true
			});
		});*/
		
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectTree").modal({keyboard:true});
			return false;
		}
		$("#sortOrg").modal({keyboard:true});
		if( node.pId == null){
			node.pId='b4cb8bf303974996ac4df5e87cf30ac0';
		}
		zjm.dataSortVal("/selectMultilevelsortListJSON",{"pmultilevelsortid":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/updateSortOrder',
				data : JSON.stringify({
					"tableName" : "c_multilevelsort",
					"tableFileName" : "multilevelsortid",
					"tableFileIds" : $("#tableFileIds").val()
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#sortOrg").modal("hide");
						$.zjm_announce.initTree();
					} else {
						alert("保存失败！");
						$.zjm_announce.initTree();
					}
				}
			});
			
		});
		$(".btn_reset").click(function () {
			zjm.dataSortVal("/selectMultilevelsortsListJSON",{"pmultilevelsortid":node.pId});
		});
		$("#sortOrg").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
			 $("#btn_moveUp").unbind("click");
			 $("#btn_moveDown").unbind("click");
			 $("#btn_moveTop").unbind("click");
			 $("#btn_moveBottom").unbind("click");
		});
	});
		// 排序页面重置 按钮
		$(".btn_reset").click(function() {
			$.zjm_announce.initTree();
		});

});
