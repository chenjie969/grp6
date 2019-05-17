(function($,d){
	window.zt = "" || {};
	window.tree = {
			init:finitTree,  //初始化一个树
			initLocal:initLocal,//初始化一个树 (使用本地加载的数据)
			treeObj:getTreeObj, //获取一个ztree对象
			ref:refreshTree, // 异步刷新树
			getChecke:getCheckeNode, //获取当前选中的节点
			expand:expandNode,//展开当前节点
			expandAll:expandAllNode,//展开所有节点
			getAllParentID : getAllParentID,//获取所有父节点的id
			getAllParentName : getAllParentName //获取所有父节点的name
	}
	
	/**
	 * 初始化树
	 */
	function finitTree(tp,option){
		defParam = {
			initID:	"",
			url:zjm.netaddress
		};
		if(typeof tp === "object"){
			defParam = $.extend(defParam,tp);
		};
		setting = {
				check : {
					enable : false // 设置是否显示多选框
				},
				data : {
					keep : {
						leaf : false, // 需要锁定叶子节点状态 如果设置为 true，则所有 isParent = false
						// 的节点，都无法添加子节点。
						parent : true
					// 如果设置为 true，则所有 isParent = true 的节点，即使该节点的子节点被全部删除或移走，依旧保持父节点状态。
					},
					simpleData : {
						enable : true
					}
				},
				edit : {
					drag : {
						isMove : false, // 拖拽时, 设置是否允许移动节点 (true:允许(默认);false:不允许)
						isCopy : false  // 拖拽是, 设置知否允许复制 (true:允许复制(默认);false:不允许复制)
					},
					enable : true, // 设置 zTree 是否处于编辑状态
					showRemoveBtn : false, // 设置是否显示删除按钮
					showRenameBtn : false // 设置是否显示编辑名称按钮
				},
				view : {
					expandSpeed : "fast", // 设置打开节点时的动画效果 ("slow", "normal", or "fast")分别效果是:慢的,正常,快的
					dblClickExpand : dblClickExpand
					// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
				},
				callback : {
					beforeDrag : true, // 用于捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
					beforeDrop : true // 用于捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
					
				},
				async: {
					enable: true,//是否开启异步加载模式
					url:defParam.url,// 获取数据的 URL 地址
					//autoParam:["id", "name=n", "level=lv"],//异步加载时需要自动提交父节点属性的参数
					//otherParam:{"otherParam":"zTreeAsyncTest"},//Ajax 请求提交的静态参数键值对
					//dataFilter: filter,//用于对 Ajax 返回数据进行预处理的函数
					type: "post" //http 请求模式
				}
		};
		
		if(typeof option === "object"){
			setting = $.extend(setting,option);
		};
//		console.log(setting);
		//zt = $.fn.zTree.init($("#treeDemo"), setting);//, data
		// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
		function dblClickExpand(treeId, treeNode) {
			return treeNode.level > 0;
		}
		
		zt = $.fn.zTree.init($("#"+defParam.initID), setting);
		return zt; 
	}
	
	/**
	 * 初始化一个树 (使用本地数据)
	 */
	function initLocal(tp,option){
		defParam = {
				initID:	"",
				localData:zjm.netaddress
			};
			if(typeof tp === "object"){
				defParam = $.extend(defParam,tp);
			};
			setting = {
					check : {
						enable : false // 设置是否显示多选框
					},
					data : {
						keep : {
							leaf : true, // 需要锁定叶子节点状态 如果设置为 true，则所有 isParent = false
							// 的节点，都无法添加子节点。
							parent : true
						// 如果设置为 true，则所有 isParent = true 的节点，即使该节点的子节点被全部删除或移走，依旧保持父节点状态。
						},
						simpleData : {
							enable : true
						}
					},
					edit : {
						drag : {
							isMove : false, // 拖拽时, 设置是否允许移动节点 (true:允许(默认);false:不允许)
							isCopy : false  // 拖拽是, 设置知否允许复制 (true:允许复制(默认);false:不允许复制)
						},
						enable : true, // 设置 zTree 是否处于编辑状态
						showRemoveBtn : false, // 设置是否显示删除按钮
						showRenameBtn : false // 设置是否显示编辑名称按钮
					},
					view : {
						expandSpeed : "fast", // 设置打开节点时的动画效果 ("slow", "normal", or "fast")分别效果是:慢的,正常,快的
						dblClickExpand : dblClickExpand
						// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
					},
					callback : {
						beforeDrag : true, // 用于捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
						beforeDrop : true // 用于捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
						
					}
			};
			
			if(typeof option === "object"){
				setting = $.extend(setting,option);
			};
//			console.log(setting);
			//zt = $.fn.zTree.init($("#treeDemo"), setting);//, data
			// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
			function dblClickExpand(treeId, treeNode) {
				return treeNode.level > 0;
			}
			
			zt = $.fn.zTree.init($("#"+defParam.initID), setting,defParam.localData);
			return zt; 
	}
	
	/**
	 * 获取ztree 对象
	 */
	function getTreeObj(){
		return zt;
	}
	
	/**
	 * 异步刷新树 (刷新整个树,包括父节点以及子节点)
	 * Function(parentNode, reloadType, isSilent)
	 * 指定需要异步加载的父节点 JSON 数据
	 * 1.  parentNode = null 时，相当于从根节点 Root 进行异步加载
	 *     parentNode.isParent = false 时，不进行异步加载
	 * 2.  reloadType = "refresh" 表示清空后重新加载。
	 * 	   reloadType != "refresh" 时，表示追加子节点处理。
	 * 3.  设定异步加载后是否自动展开父节点。
	 * 	   isSilent = true 时，不展开父节点，其他值或缺省状态都自动展开。
	 */
	function refreshTree(zt){
		var me = this;
		me.init();
		zt.reAsyncChildNodes(null,"refresh",true);
//		console.log("正在刷新树");
//		window.location.reload()刷新当前页面.
	}
	
	/**
	 * 获取当前选中的节点
	 */
	function getCheckeNode(){
		var node = zt.getSelectedNodes()[0];
		return node
	}
	
	/**
	 * 展开当前父节点
	 */
	function expandNode(){
		var treeNode  = zt.getSelectedNodes()[0];
		if (treeNode.isParent && treeNode.level != 0) {
			zt.expandNode(treeNode);
		}
	}
	
	/**
	 * 展开所有节点
	 */
	function expandAllNode(){
		zt.expandNode();
	}
	
	
	/**
	 * 获取所有父节点的 id
	 */
	function getAllParentID(node){
		var NodeArry = new Array();
		var node_1 = node.getParentNode();
		NodeArry.push(node.id);
		if(node_1 != null && node_1.level != 0){
			NodeArry.push(node_1.id);
			var node_2 = node_1.getParentNode();
			if(node_2 != null && node_2.level != 0){
				NodeArry.push(node_2.id);
				var node_3 = node_2.getParentNode();
				if( node_3 != null && node_3.level != 0){
					NodeArry.push(node_3.id);
					var node_4 = node_3.getParentNode();
					if(node_4 != null && node_4.level != 0){
						NodeArry.push(node_4.id);
						var node_5 = node_4.getParentNode();
						if(node_5 != null && node_5.level != 0){
							NodeArry.push(node_5.id);
						}
					}
				}
			}
		}
		return NodeArry.reverse().join("/");
	}
	
	/**
	 * 获取所有父节点的name
	 */
	function getAllParentName(node){
		var NodeArry = new Array();
		var node_1 = node.getParentNode();
		NodeArry.push(node.name);
		if(node_1 != null && node_1.level != 0){
			NodeArry.push(node_1.name);
			var node_2 = node_1.getParentNode();
			if(node_2 != null && node_2.level != 0){
				NodeArry.push(node_2.name);
				var node_3 = node_2.getParentNode();
				if( node_3 != null && node_3.level != 0){
					NodeArry.push(node_3.name);
					var node_4 = node_3.getParentNode();
					if(node_4 != null && node_4.level != 0){
						NodeArry.push(node_4.name);
						var node_5 = node_4.getParentNode();
						if(node_5 != null && node_5.level != 0){
							NodeArry.push(node_5.name);
						}
					}
				}
			}
		}
		return NodeArry.reverse().join("/");
	}
	
})(jQuery,this);



