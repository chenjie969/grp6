(function($,z){
	var zTreeObjLeft="";
	$.zjm_zTreeUser = {
			initTree:initTree
	};
	
	function initTree(treeid,inputid,inputname,url){
		/**加载树结构*/
		var setting = {
				check :{
					enable : true,
					chkStyle: "checkbox",
					chkboxType: { "Y": "ps", "N": "ps" }
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
				callback :{
					onCheck : zTreeOnMouseDown // 捕获 zTree 上鼠标按键按下后的事件回调函数
				}
		};
		$.ajax({type:'POST',url:url,async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			zTreeObjLeft = $.fn.zTree.init($("#"+treeid),setting, data.obj);
		}
		});
		if($("#"+inputid).val()!=null){
			var modulesArray = $("#"+inputid).val().split(",");
			for(var i in modulesArray){
				var allNode2 = zTreeObjLeft.getNodeByParam("id",modulesArray[i],null);
				if(allNode2 != null){
					$('#userName').append('<span>'+allNode2.name+'</span>'+'<br>');
					zTreeObjLeft.checkNode(allNode2, true, false);
				}
			}
		}
		/**
		 * 单击 节点 触发的函数
		 */
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			$("#userName").html("");
			var nodes = zTreeObjLeft.getCheckedNodes();
			var nArr = new Array();
			var vArr = new Array();
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				if(nodes[i].pId!="-1" && nodes[i].pId!=null){
					if(nodes[i].type == "user"){
						$('#userName').append('<span>'+nodes[i].name+'</span>'+'<br>');
						nArr.push(nodes[i].name);
						vArr.push(nodes[i].id);
					}
				}
			}
			
			//设置选中的值
			var setN = nArr.join(",");
			var setV = vArr.join(",");
			$("#"+inputid).val(setV);
			$("#"+inputname).val(setN);
		};
		
		
	}
	
	
	
	
})(jQuery, this);