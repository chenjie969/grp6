(function($,z){
	
	$.zjm_announce = {
		initTree : initTree,// 加载树结构
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
			
			//加载右边的表格
			var currentTab = $("li.active > a").attr("id");
			switch(currentTab){
				case "noCheckTab":$.zjm_noCheckAnnounce.initTable(treeNode.id,treeLevel);break;
				case "yesCheckTab":$.zjm_yesCheckAnnounce.initTable(treeNode.id,treeLevel);break;
				case "bouncedTab":$.zjm_auditBouncedAnnounce.initTable(treeNode.id,treeLevel);break;
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
	
})(jQuery, this);

$(function () {
	$.zjm_announce.initTree();
	$.zjm_noCheckAnnounce.initTable();
	
	$("#noCheckTab").click(function(){
		$.zjm_noCheckAnnounce.initTable();
	});
	$("#yesCheckTab").click(function(){
		$.zjm_yesCheckAnnounce.initTable();
	});
	
	$("#bouncedTab").click(function(){
		$.zjm_auditBouncedAnnounce.initTable();
	});

});
