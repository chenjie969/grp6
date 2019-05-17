(function($,z){
	
	
	/*
	 * 
	 *
	 * $.ajax({type:'POST',url:'/selectAllModulesListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$("#txt_id").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : true,//是否多选
				data : data.obj//数据源
			});
        }
        });
        
	<div class="space-4"></div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 菜单名称(下拉选择)： </label>
		<div class="col-sm-9">
			<div class="row">
				<div class="col-xs-10 col-sm-11 ">
					<div class="input-group txt_id">
						<input class="form-control validate[required,maxSize[50]]" autoField="mod_uids" id="txt_id" type="text" value="首页,个人咨询登记,客户储备库" dataValue="27,111,123" />
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110  "></i>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$.widget("zjm.selectTreeWidgets", {
		
		 options: {
			 tip : "请选择", //默认提示信息
			 width : "66.5%", //默认宽度
			 height : "30px", //默认高度
			 style : {},//add样式
		     selected : ["a","b","c"], //选中的节点
		     data : [], // 数据集合
		     shape : "tree", //显示的样子,默认显示tree, select : 普通的下拉框
		     multiple : false, // 是否多选,默认单选, true为多选
		 	 selected : "" ,//选中的
		 	 autoComple : { //自动补全
		 		 pushID : {
		 			 //用法: key : 指定要从结果中获取的字段key ,value : 指定要输入的控件的id
		 		 },
		 		 onchange : $.noop
		 	 },
		 	 isParentUp : false, // 是否允许父节点被选中,默认是false,
		 	 isSetFullCode : false // 是否设置完整编码，false（默认） : 设置完整编码  ； true : 不设置完整编码（添加于20150110，但未启用此参数）
		 },
		 
		 _create: function() {
			 var stw = this,
			 	 prototype =  this.element,
			 	 HtmlContainer,//html集合
			 	 treeObj,proID = prototype.attr("id");
			 	 
			     
			 if (!prototype.is('input[type="text"]')) {
				 	throw new TypeError("selectTreeWidgets expects a <input[type='text']> element .");
			 }
			 //▼
			 HtmlContainer = 
				 [
				  	'	<div class="row zjm-selectTree-inward-'+ proID +'" style="position:absolute; display:none;border: 1px solid #d5d5d5;left:2.35em; top:33px;background-color: #fff; ">',
				  	'		<ul class="col-sm-11 zjm-selectTree-tree-'+ proID +' ztree" id="tree-'+ proID +'"></ul>',
				  	'	</div>',
				  ];
			 
			 
			 $("."+proID).parent().append(HtmlContainer.join(""));
			 
			 
			 
			//设置提交字段
				var autoField = prototype.attr("autoField");
				if(typeof autoField !== "undefined"){
					var Field = $("<input>",{
						"type" : "hidden",
						"val" : prototype.attr("dataValue"),
						"name" : autoField,
						"mark" : prototype.attr("marking"),
						"id" : autoField
					})
					if(document.getElementsByName(autoField).length === 0){
						stw.element.after(Field);
					}else{
						$(document.getElementsByName(autoField)[0]).val(setV);
					}
				}
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 /**
			  * 打开 下拉框
			  */
			 $("." + proID).click(function(){
				var inward = $(".zjm-selectTree-inward-" + proID);
				
				var d = $(document).height()
				var x = prototype.position().top;
				var y = prototype.position().left;
				var h = prototype.height();
				
				inward.css("z-index","99999");
				inward.css("display","table");
				inward.css("width",stw.options.width);
				 inward.show();
				 inward.slideDown(200);
				 //初始化树 参数 
				 stw.initTree(stw,stw.options.data,proID);
				 
				 //绑定文档 当点失去焦点 关闭选择框
				 $(document).bind("click", function(e){
					 var target  = $(e.target); 
					 if(!target.is(".zjm-selectTree-inward-"+ proID+ " *") && !target.is("."+ proID+ " *")){
						 $(".zjm-selectTree-inward-" + proID).hide();
					 }
				 });
			 });
		    },
		    
			 
			 
			 /**
			  * 初始化 tree
			  */
			 initTree : function(stw,data,proID){
				 var Treedata;
				 setting = {
							check : {
								enable : stw.options.multiple // 设置是否显示多选框
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
								dblClickExpand: false,
								expandSpeed : "fast", // 设置打开节点时的动画效果 ("slow", "normal", or
								// "fast")分别效果是:慢的,正常,快的
								//dblClickExpand : dblClickExpand
								// 设置 zTree 仅仅 level=0 的父节点取消双击展开的功能
							},
							callback : {
								beforeDrag : true, // 用于捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
								beforeDrop : true, // 用于捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
								onClick:clickFun
								
							}
						};
				 
					 if(stw.options.multiple){
						 var multipleParam={
								 check : {
									 
									 chkStyle: "checkbox",  
							        chkboxType: { "Y": "s", "N": "s" },  
							        autoCheckTrigger: true 
								 },
								 callback:{
									 onClick : null
//									 onCheck ：onCheckNode
								 } 
						 };
						 setting=$.extend(true,setting,multipleParam);
					 }
					var $treeContainer=$(".zjm-selectTree-tree-" + proID);
					
					 var $btnContainer=$("<div>",{
						 "class":"col-sm-12",
						 "style":"margin-top:10px;text-align:center",
						 "id":"btnContainer"+proID
					 });
					 if(!stw.options.multiple){
						 var $btnClear=$("<button>",{
							 "type" : "button",
							 "class" : "btn btn-xs btn-danger",
							 "style":"margin-right:1em",
							 "text":"清空",
							 click : function(e){
								 setSelectValue(stw,Treedata);
								 close(proID);
							 }
						 });
						 $btnContainer.append($btnClear);
					 }
					 
				    if(stw.options.multiple){
				    	var $btnClose=$("<button>",{
				    		"type" : "button",
				    		"class" : "btn btn-xs btn-defalt",
				    		"style":"margin-left:1em",
							 "text":"取消",
							 click : function(e){
								 close(proID);
							 }
						 });
						 var $btnYes=$("<button>",{
							 "type" : "button",
							 "class" : "btn btn-xs btn-info",
							 "text":"确定",
							 click : function(e){
								 //判断如果是父节点禁止选择
								 if(stw.options.isParentUp){
									 var nodes = Treedata.getCheckedNodes(true);
									 setSelectValue(stw,nodes);
									 //close(proID);
								 }else{
									 
									//if(treeNode && !treeNode.isParent){
										var nodes = Treedata.getCheckedNodes(true);
										setSelectValue(stw,nodes);
										//close(proID);
									//}
								 }
								 close(proID);
							 }
						 });
						 $btnContainer.append($btnYes);
						 $btnContainer.append($btnClose);
				    }
				    if($treeContainer.children($btnContainer).size() <= 0){
				    	$treeContainer.before($btnContainer);
				    }
				 
				   
					Treedata = $.fn.zTree.init($treeContainer,setting, data);
					 if(stw.options.multiple){
						 var tnodes = Treedata.getNodes();
							for (var ti in tnodes) {
								if(tnodes[ti].id === -1){
									Treedata.setChkDisabled(tnodes[ti], true);
								}
							}
					 }
					
					
					if(stw.options.multiple){
						//设置选中node
						var tmp =  stw.element.attr("dataValue") ;
						if(typeof tmp !== 'undefined' && tmp!== ""){
							var valCont = stw.element.attr("dataValue").split(",");
							for(var i in valCont){
								var allNode = Treedata.getNodeByParam("id",valCont[i],null);
								if(allNode != null){
									Treedata.checkNode(allNode, true, false);
								}
							 }
//							 sw.setCheckCount(sw,Treedata);
						}
					}
					
					
					
					
					
					/**
					 * 点击监听
					 * @param event
					 * @param treeId
					 * @param treeNode
					 */
					function clickFun(event, treeId, treeNode){
//						if(treeNode.pId !== "-1" && treeNode.pId != null){
						//判断如果是父节点禁止选择
//						if(treeNode && !treeNode.isParent){
						if(stw.options.isParentUp){
							setSelectValue(stw,Treedata);
						}else{
							if(treeNode && !treeNode.isParent){
								setSelectValue(stw,Treedata);
							}
						}
					 };
					 
					 //设置选中的值
					 function setSelectValue(stw,Treedata){
						 
						if(stw.options.multiple){
							nodes = Treedata;
						}else{
							nodes = Treedata.getSelectedNodes();
							//设置选中节点的父节点,在消息中心模块使用----xuyz
							if(nodes.length==0){	//点击"清空"按钮时,清除PID
								$("#hidden_messageTypePID").val("");
								$("#hidden_messageTypePName").val("");
							}else{
								$("#hidden_messageTypePID").val(nodes[0].getParentNode().id);
								$("#hidden_messageTypePName").val(nodes[0].getParentNode().name);
							}
						}
						
						v = "";
						var vArr = new Array();
						var nArr = new Array();
						nodes.sort(function compare(a,b){return a.id-b.id;});
						for (var i=0, l=nodes.length; i<l; i++) {
//									v += nodes[i].name + ",";
							if(nodes[i].type!='depart'){
								vArr.push(nodes[i].name);
								nArr.push(nodes[i].id);
							}
						}
						if (v.length > 0 ) v = v.substring(0, v.length-1);
						//设置选中的name
						var selectedName = vArr.join(",");
						//$("#" + proID+"_name").val(selectedName);
						//设置选中的值
						var setV = nArr.join(",");
						stw.element.val(selectedName);
						
						//设置提交字段
						var autoField = stw.element.attr("autoField");
						if(typeof autoField !== "undefined"){
							var Field = $("<input>",{
								"type" : "hidden",
								"val" : setV,
								"name" : autoField,
								"mark" : stw.element.attr("marking"),
								"id" : autoField
							})
							if(document.getElementsByName(autoField).length === 0){
								stw.element.after(Field);
							}else{
								$(document.getElementsByName(autoField)[0]).val(setV);
							}
						}
							close(proID);
					 }
					 /**
					  * 触发
					  */
					 function onc(callback){
							//alert(callback);
					 }
					/**
					 * close
					 */
					 function close(proID){
						 $(".zjm-selectTree-inward-" + proID).slideUp(200);
					 }
					return Treedata;
			 },
			 
			
			
		    
	});
	
})(jQuery, this);