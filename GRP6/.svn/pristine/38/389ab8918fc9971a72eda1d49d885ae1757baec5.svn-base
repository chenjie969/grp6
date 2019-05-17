
/**
 * 初始化ztree 
 * 使用方法: initZtree(要实例化的id,数据源,节点附加参数);
 * 附加参数必须是一个json对象,与setting设置参数的格式一致,(这个参数是可以忽略的,在只显示一个树形的结构,且无任何操作的情况下可忽略)
 * 如果此处默认舒初始化的参数不符合,使用要求,在自己的文件中重新定义,即可覆盖,
 * 关于 callback 函数 尽量定义在自己的文件中,以免与其他人员的回调函数冲突
 * @param domObj
 * @param data
 * @param extraData
 * @returns
 */
function initZtree(domObj,extraData,data){
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
				isCopy : false
			// 拖拽是, 设置知否允许复制 (true:允许复制(默认);false:不允许复制)
			},
			enable : true, // 设置 zTree 是否处于编辑状态
			showRemoveBtn : false, // 设置是否显示删除按钮
			showRenameBtn : false // 设置是否显示编辑名称按钮
		},
		view : {
			expandSpeed : "fast", // 设置打开节点时的动画效果 ("slow", "normal", or
			// "fast")分别效果是:慢的,正常,快的
			dblClickExpand : dblClickExpand
			// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
		},
		callback : {
			beforeDrag : true, // 用于捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
			beforeDrop : true // 用于捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
		}
	};

		

	 if(typeof extraData === "object") {
			$.extend(setting, extraData);
		}
	 
	 	//zTreeObj = $.fn.zTree.init($("#treeDemo"), setting);//, data
		// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
		function dblClickExpand(treeId, treeNode) {
			return treeNode.level > 0;
		}

		
		/*$.ajax({
			url : url,
			type : "post",
			dataType : "json",
			cache : false,
			success : function(data) {
				thisUnitDepartData = data;//将部门数据赋值到全局变量 thisUnitDepartData,
//				zTreeObj = initZtree(depart_tree,thisUnitDepartData,setting);
				
			}
		});*/
		
		return $.fn.zTree.init(domObj, setting, data);

}

