/**
 * 合作机构管理 ---- 合作机构设置 js
 * author:wuhn
 * date:2017年5月22日 15:19:01
 * 
 */

(function($, z) {
	$.zjm_Cooperation = {
		initTree : initTree,// 加载树结构
		initTable : initTable,// 初始化列表
		addCooperation : addCooperation,// 合作机构 添加
		viewCooperation : viewCooperation,// 合作机构 查看
		editCooperation : editCooperation,// 合作机构 修改
		delCooperation : delCooperation, // 合作机构 删除
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
			url : "/crm/cooperation/selectCooperationListTree"
		}, setting);
		
		/** 单击 节点 触发的函数* */
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			$.zjm_Cooperation.initTable(treeNode.id,isChild);
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
		
		if (CooperationID == null) {
			CooperationID = '4649d725753a4f00bd6bfe7c346b0dc5';
		}
		$.zjm_Cooperation.initTable(CooperationID,isChild);
	}

	/** 初始化列表** */
	function initTable(nodeid,isChild) {
		$("#lastTableDictypeID").val(nodeid);
		oldBanksortid=nodeid;
		$("#cooperation-table").bootstrapTable('destroy');
		$('#cooperation-table')
				.bootstrapTable(
						{
							method : 'get',
							columns : [
									{
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : "banksortname",
										title : '合作机构',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.banksortname;
										}
									},
									{
										field : "creditSum",
										title : '授信额度（万元）',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.creditSum;
										}
									},
									{
										field : "creditBeginDate",
										title : '授信起始日期',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
												return tool.parseDate(row.creditBeginDate);
											
										}
									},
									{
										field : "creditEndDate",
										title : '授信到期日期',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
												return  tool.parseDate(row.creditEndDate);
										}
									},	
									{
										field : "zrScale",
										title : '责任比例（%）',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
												return row.zrScale;
											
										}
									},	
									{
										field : "bzScale",
										title : '保证金比例（%）',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
												return  row.bzScale;
											
										}
									},
									{
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button  title="查看" class="btn_Cooperations_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button title="修改" class="btn_Cooperations_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
													'<button  title="删除"  class="btn_Cooperations_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
													.join('');
										},
										// 事件绑定
										events : {
											'click .btn_Cooperations_view' : function(
													e, value, row, index) {
												$.zjm_Cooperation
														.viewCooperation(row);
											},
											'click .btn_Cooperations_edit' : function(
													e, value, row, index) {
												$.zjm_Cooperation
														.editCooperation(row);
											},
											'click .btn_Cooperations_del' : function(
													e, value, row, index) {
												$.zjm_Cooperation.delCooperation(row);
											}
										}
									} ],
							detailView : true,
							detailFormatter : function(index, row) {
								//实现对null值的处理
								function isNull(value,newValue,replaceValue){
									if( null == value){ //null 值替换为 replaceValue
										return replaceValue;
									}else{
										return value+newValue; //不是 null值替换为 value+newValue; 一般是单位
									}
								}
								var beginDate= tool.parseDate(tool.isNull(row.creditBeginDate,""));
								beginDate=beginDate==""?'（空）':beginDate;
								var endDate= tool.parseDate(tool.isNull(row.creditEndDate,""));
								endDate=endDate==""?'（空）':endDate;
								
								var html = [];
								html.push('<p><b>合作机构:</b> '+ row.banksortname + '</p>');
								html.push('<p><b>授信额度:</b> '+ isNull(row.creditSum,"万元","（空）") + '</p>');
								html.push('<p><b>授信起始日期:</b> '+beginDate+ '</p>');
								html.push('<p><b>授信到期日期:</b> ' +endDate+ '</p>');
								html.push('<p><b>责任比例:</b> ' +isNull(row.zrScale,"%","（空）")+ '</p>');
								html.push('<p><b>保证金比例:</b> '+isNull(row.bzScale,"%","（空）")+ '</p>');
								return html;
							},
							toolbar : '#toolbar', // 工具按钮用哪个容器
							striped : true, // 是否显示行间隔色
							cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
							pagination : true, // 设置为 true 会在表格底部显示分页条
							paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
							sortable : true, // 是否启用排序
							sortOrder : "asc", // 排序方式
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pageSize : 30, // 每页的记录行数（*）
							pageList : [30,50,100,  200,  500], // 可供选择的每页的行数（*）
							// 该url是用于实现右侧列表显示的
							url : "/crm/cooperation/selectCooperationPageTables",// 这个接口需要处理bootstrap
							// //
							// table传递的固定参数
							// url 连接中的参数
							queryParamsType : '', // 默认值为 'limit' ,在默认情况下//
							// 传给服务端的参数为：offset,limit,sort
							// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
							queryParams: function(params) {
								if(isChild || typeof isChild == 'undefined'){
									$.extend(params, {"queryCondition":{"pbanksortid":nodeid}});
								}else{
									$.extend(params,{"queryCondition":{"banksortid":nodeid}});
								}
								return params;
							},// queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
							
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
							strictSearch : true,// 设置为 true启用 全匹配搜索，否则为模糊搜索
							showColumns : true, // 是否显示所有的列
							showRefresh : true, // 是否显示刷新按钮
							minimumCountColumns : 2, // 最少允许的列数
							clickToSelect : false, // 是否启用点击选中行
							searchOnEnterKey : true,// 设置为
							// true时，按回车触发搜索方法，否则自动触发搜索方法
							showToggle : true,// 是否显示详细视图和列表视图的切换按钮
							showPaginationSwitch : true,
							showExport : true, // 是否显示导出
							exportDataType : "basic" // basic', 'all',
						// 'selected'

						});
	}

	/** 合作机构添加 */
	function addCooperation(id, name, ppnode,unificationid) {
		$("#addCooperation").modal({
			keyboard : true
		});

		$(".ztb_add_pbanksortid").val(id);
		$(".ztb_add_up_banksortname").text(name);
		// 获取  缴存方式 下拉列表
		$.ajax({
			type : 'POST',
			url : "/selectDicTypeSelectJSON",
			data : JSON.stringify({"dicTypePID" : '203f85cf7e534c4f84d910b58089ba7d'}),
			async : false,
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$("." +"select_depositMethodID").empty();
				$("." + "select_depositMethodID").append("<option value=''>&nbsp;请选择</option>");
				$.each(data.obj, function(key1, value1) {
					$.each(value1, function(key2, value2) {
						$("." + "select_depositMethodID").append("<option value='" + value2 + "'>"+ value2 + "</option>");
					});
				});
			}
		});
		
		zjm.init();
		/** 注册编辑验证引擎 */
		zjm.validata({
			formId : "add_form"
		});

		tool.undisabled(".btn_submit");// 按钮变为可用
		$(".btn_submit").click(function() {
			// 按钮置为不可用，防止重复提交
			if ($("#add_form").validationEngine("validate")) {
  				 var queryContainer_form = $("#add_form");
				 if(zjm.ajaxValidata("add_banksortname","/crm/cooperation/selectAddCooperationNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"合作机构名称重复！")){
					tool.disabled(".btn_submit"); // 按钮变为不可用
					var banksortname=$("#add_banksortname").val();
					$.ajax({
						type : 'POST',
						url : '/crm/cooperation/insertOneCooperationInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj != null) {
								$("#addCooperation").modal("hide");
								$(".ztb_add").val("");
								$(".ztb_add").text("");
								
								$.zjm_Cooperation.initTree(id);
							} else {
								alert("保存失败！");
							}
						}
					});
				 } 
			} else {
				tool.undisabled(".btn_submit");
			}
		});
		$("#addCooperation").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}


	/** * 合作机构 查看** */
	function viewCooperation(row) {
		$("#cooperationPage").load("/crm/cooperation/selectOneCooperationInfo",{"banksortid":row.banksortid,"unitUid":row.unitUid},function(response,status,xhr){
			$("#viewCooperation").modal({
				keyboard : true
			});
		});
	}
	
	var oldBanksortid="";
	/** 合作机构 修改* */
	function editCooperation(row) {
		$("#cooperationPage").load("/crm/cooperation/selectCooperationEditPage",{"banksortid":row.banksortid,"unitUid":row.unitUid},function(response,status,xhr){
			$("#editCooperation").modal({
				keyboard : true
			});
			//日期控件初始化
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});

			// 获取  缴存方式 下拉列表
			$.ajax({
				type : 'POST',
				url : "/selectDicTypeSelectJSON",
				data : JSON.stringify({"dicTypePID" : '203f85cf7e534c4f84d910b58089ba7d'}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("." +"select_depositMethodID").empty();
					$("." + "select_depositMethodID").append("<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("." + "select_depositMethodID").append("<option value='" + value2 + "'>"+ value2 + "</option>");
						});
					});
				}
			});
			//设置下拉框默认值
			$("select[name=depositMethodID]").val($("#hidden_depositMethodID").val());
			
			zjm.init();
			/** 注册编辑验证引擎 */
			zjm.validata({
				formId : "edit_form"
			});
			/** 保存修改** */
			tool.undisabled(".btn_submit"); //按钮调整为 可用
			$(".btn_submit").click(function() {
				if ($("#edit_form").validationEngine("validate")) {
					var queryContainer_form = $("#edit_form");
					var edit_banksortname=$("#edit_banksortname").val();//获取修改名称
					if(zjm.ajaxValidata("edit_banksortname","/crm/cooperation/selectEditCooperationNameIsExist",
							JSON.stringify(queryContainer_form.serializeJson()),"合作机构重复！")){
						tool.disabled(".btn_submit");// 按钮调整为 不可用
						$.ajax({
							type : 'POST',
							url : '/crm/cooperation/updateOneCooperationInfo',
							data : JSON.stringify(queryContainer_form.serializeJson()),
							contentType : 'application/json; charset=UTF-8',
							dataType : 'json',
							success : function(data) {
								if (data.obj == 1) {
									$("#editCooperation").modal("hide");
									// 右侧列表刷新
									$.ajax({type:'POST',url:'/crm/cooperation/selectCooperationPageTables',data:JSON.stringify({"queryCondition":{"pbanksortid":oldBanksortid}}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
										//修改后刷新列表，取的是上一次查询列表的ID
											console.info(data.obj.rows);
											if(data.obj.rows.length==0){	//没有查到数据，说明是叶子节点	
												$.zjm_Cooperation.initTree(oldBanksortid,false);
											}else{							
												$.zjm_Cooperation.initTree(oldBanksortid,true);
											}
										}
									});
								} else {
									alert("保存失败！");
								}
							}
						});
					} 
				} else {
					tool.undisabled(".btn_submit");
				}
			});
			$("#editCooperation").on("hidden.bs.modal", function(e) {// 解除事件绑定
				$(".btn_reset").unbind("click");
				$(".btn_submit").unbind("click");
			});
		}); //end  load page
	}
	
	
	/** 合作机构 删除** */
	function delCooperation(row) {
		if(row.isDefault == 1){
			$("#isDefaults").modal({keyboard:true});
			return false ;
		}
		$("#cooperationPage").load("/crm/cooperation/selectCooperationDelPage",{"banksortid":row.banksortid,"unitUid":row.unitUid},function(response,status,xhr){
			// 调用模态窗  //delCooperation
			$("#delCooperation").modal({
				keyboard : true
			});
			
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function() {
				tool.disabled(".btn_submit");
				$.ajax({
					type : 'POST',
					url : '/crm/cooperation/deleteOneCooperationInfo',
					data : JSON.stringify({
						"banksortid" : row.banksortid,
						"unitUid":row.unitUid
					}),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == true) {
							$("#delCooperation").modal("hide");
							//列表刷新
							$.zjm_Cooperation.initTree(row.pbanksortid);
						} else {
							$("#failDel").modal({keyboard:true});
						}
					}
				});
			});
			$("#delCooperation").on("hidden.bs.modal", function(e) {// 解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}

})(jQuery, this);





$(function() {
	/**
	 * 文档加载的时候 读取 合作机构 信息: 左侧树形结构和右侧列表
	 */
	$.zjm_Cooperation.initTree();

	// 初始化日期选择按钮
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	
	// 添加同级合作机构  添加同级机构
	$("#btn_add").click(function() {
		var ppnode;//新增
		var node = tree.getChecke();
		if (node == null) {
			alert("请选择一个合作机构!");
			return false;
		}

		//新增 ppnode
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		// 最多五级合作机构
		if (node.level >= 4) {
			alert("不能添加下级合作机构!");
			return false;
		}
		$.zjm_Cooperation.addCooperation(node.id, node.name,ppnode);
	});

	/** 同级顺序调整 */
	$("#btn_sort").click(function() {
		var node = tree.getChecke();
		if (node == null) {
			alert("请选择一个合作机构!");
			return false;
		}
		$("#sortop").modal({
			keyboard : true
		});
	 	if( null == node.pId){  // 若是根节点,则把根节点id 赋给 pId
	 		node.pId='4649d725753a4f00bd6bfe7c346b0dc5';
	 	}
		zjm.dataSortVal("/crm/cooperation/selectCooperationSortJSON", {
			"pbanksortid" : node.pId
		});
		tool.sort(); //填充排序数据
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			// tableName:表名 tableFileName:字段名 tableFileIds:字段值
			$.ajax({
				type : 'POST',
				url : '/updateSortOrder',
				data : JSON.stringify({
					"tableName" : "c_banksort",
					"tableFileName" : "banksortid",
					"tableFileIds" : $("#tableFileIds").val()
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#sortop").modal("hide");
						$.zjm_Cooperation.initTree();
					} else {
						alert("保存失败！");
						$.zjm_Cooperation.initTree();
					}
				}
			});
			
		});

		// 排序页面重置 按钮
		$(".btn_reset").click(function() {
			zjm.dataSortVal("/crm/cooperation/selectCooperationSortJSON", {
				"pbanksortid" : node.pId
			});
		});

		$("#sortop").on("hidden.bs.modal", function(e) {// 解除模态窗 事件绑定
			$(".btn_reset").unbind("click");
			$(".btn_submit").unbind("click");
			$("#btn_moveUp").unbind("click");
			$("#btn_moveDown").unbind("click");
			$("#btn_moveTop").unbind("click");
			$("#btn_moveBottom").unbind("click");
		});

	}); // 同级顺序调整 end
	
	//重置列表
	$("#refresh").click(function(){
		$.zjm_Cooperation.initTree();
	});
	
	//解决添加有缓存的问题
	$(".close").click(function(){
		clear();
	});
	
	$(".btn-default").click(function(){
		clear();
	});
	
	function clear(){
		$(".ztb_add").val("");
	}
	
}); // $(function) end

