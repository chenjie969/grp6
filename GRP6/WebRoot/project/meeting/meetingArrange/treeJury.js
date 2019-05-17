(function($,z){
	var zTreeObjLeftOne="";
	var zTreeObjLeftTwo="";
	
	$.zjm_zTreeJury = {
			initTreeOne:initTreeOne,
			initTreeTwo:initTreeTwo
	};
	
	function initTreeOne(treeid,inputid,inputname,url,type){
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
					onCheck:zTreeOnMouseDownOne
				}
		};
	
		$.ajax({type:'POST',url:url,async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				zTreeObjLeftOne = $.fn.zTree.init($("#"+treeid),setting, data.obj);
			}
		});
		
		if($("#"+inputid).val()!=null){
			var modulesArray = $("#"+inputid).val().split(",");
			for(var i in modulesArray){
				var allNode2 = zTreeObjLeftOne.getNodeByParam("id",modulesArray[i],null);
				if(allNode2 != null){
					$('#userName_'+type).append('<span>'+allNode2.name+'</span>'+'<br>');
					zTreeObjLeftOne.checkNode(allNode2, true, false);
				}
			}
		}
		
		/**
		 * 单击 节点 触发的函数
		 */
		function zTreeOnMouseDownOne(event, treeId, treeNode, clickFlag) {
			$('#userName_'+type).html("");
			var nodes = zTreeObjLeftOne.getCheckedNodes();
			var nArr = new Array();
			var vArr = new Array();
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				if(nodes[i].pId!="-1" && nodes[i].pId!=null){
					if(nodes[i].type == "user"){
						$('#userName_'+type).append('<span>'+nodes[i].name+'</span>'+'<br>');
						nArr.push(nodes[i].name);
						vArr.push(nodes[i].id);
					}
				}
			}
			
			//设置选中的值
			var setN = nArr.join(",");
			var setV = vArr.join(",");
			$("#"+inputid).val(setV);
			$(".tdVoteJuryIDList_"+type).val(setV);
			$("#"+inputname).val(setN);
			$(".tdVoteJuryNameList_"+type).val(setN);
			
			/* ***************************设置表格中的内容*****************************/
			$(".votableJury_"+type).text(nArr.join("，"));
		};
	}
	
	
	
	function initTreeTwo(treeid,inputid,inputname,url){
		$("#voteJuryName").html("");
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
					onCheck:zTreeOnMouseDownTwo
				}
		};
	
		$.ajax({type:'POST',url:url,async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				zTreeObjLeftTwo = $.fn.zTree.init($("#"+treeid),setting, data.obj);
			}
		});
		
		if($("#"+inputid).val()!=null){
			var modulesArray = $("#"+inputid).val().split(",");
			for(var i in modulesArray){
				var allNode2 = zTreeObjLeftTwo.getNodeByParam("id",modulesArray[i],null);
				if(allNode2 != null){
					$('#voteJuryName').append('<span>'+allNode2.name+'</span>'+'<br>');
					zTreeObjLeftTwo.checkNode(allNode2, true, false);
				}
			}
		}
		
		/**
		 * 单击 节点 触发的函数
		 */
		function zTreeOnMouseDownTwo(event, treeId, treeNode, clickFlag) {
			$("#voteJuryName").html("");
			var nodes = zTreeObjLeftTwo.getCheckedNodes();
			var nArr = new Array();
			var vArr = new Array();
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				if(nodes[i].pId!="-1" && nodes[i].pId!=null){
					if(nodes[i].type == "user"){
						$('#voteJuryName').append('<span>'+nodes[i].name+'</span>'+'<br>');
						nArr.push(nodes[i].name);
						vArr.push(nodes[i].id);
					}
				}
			}
			//设置选中的值
			var setV = vArr.join(",");
			var setN = nArr.join(",");
			$("#"+inputid).val(setV);
			$("#"+inputname).val(setN);
		};
		
	}
})(jQuery, this);