/**
 * 合作机构管理 ---- 额度使用情况 js
 * author:wuhn
 * date:2017年5月23日 14:01:35
 * 
 */

(function($, z) {
	$.zjm_Cooperation = {
		initTree : initTree,// 加载树结构
		initTable : initTable,// 初始化列表
		viewCooperation : viewCooperation,// 额度使用情况 查看
		creditDetail:creditDetail,//额度使用明细
	};

	var zTreeObj; // ztree对象
	/** 加载树结构 */
	function initTree(CooperationID) {
		var setting = {
			callback : {
				onClick : zTreeOnMouseDown
			/** 捕获 zTree 上鼠标按键按下后的事件回调函数* */
			}
		};
		// 初始化加载左侧树形结构
		zTreeObj = tree.init({
			initID : "menuSetTree",
			url : "/crm/cooperation/selectAllCooperationListTree"
		}, setting);
		
		/** 单击 节点 触发的函数* */
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			
			$.zjm_Cooperation.initTable(treeNode.id ,isChild);
		};
		if (CooperationID == null) {
			CooperationID = '4649d725753a4f00bd6bfe7c346b0dc5'; // 默认根节点 : 4649d725753a4f00bd6bfe7c346b0dc5
		}
		$.zjm_Cooperation.initTable(CooperationID);
	}
	
	
	
	/** 初始化列表** */
	function initTable(nodeid,isChild) {
		$("#cooperation-table").bootstrapTable('destroy');
		$('#cooperation-table')
				.bootstrapTable(
						{
							columns : [
									{
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{	
										title : '合作机构',
										align : 'center',
										formatter : function(value, row, index) {
											return [ '<a title="查看" class="btn_Cooperations_view" href="javascript:void(0)" >'+ row.banksortname+' </a>'].join("");
										},
										events : {
											'click .btn_Cooperations_view' : function(e, value, row, index) {
												$.zjm_Cooperation.viewCooperation(row);
														
											},
										}
									},
									
									{
										field : "creditSum",
										sortable : "true",
										title : '授信额度（万元）',
										align : 'center',
										formatter : function(value, row, index) {
											return row.creditSum;
										}
									},
									{
										field : "usedSum",
										sortable : "true",
										title : '已用额度（万元）',
										align : 'center',
										formatter : function(value, row, index) {
											return row.usedSum;
										}
									},
									{
										field : "unificationid",
										title : '可用余额（万元）',
										align : 'center',
										formatter : function(value, row, index) {
											 return (row.creditSum-row.usedSum);
										}
									},
									{
										field : "creditBeginDate",
										sortable : "true",
										title : '授信起始日期',
										align : 'center',
										formatter : function(value, row, index) {
											return tool.parseDate(row.creditBeginDate);
										}
									},
									{
										field : "creditEndDate",
										sortable : "true",
										title : '授信到期日期',
										align : 'center',
										formatter : function(value, row, index) {
											return  tool.parseDate(row.creditEndDate);
										}
									},	
									/*{
										field : "zrScale",
										sortable : "true",
										title : '责任比例（%）',
										align : 'center',
										formatter : function(value, row, index) {
											return row.zrScale;
											
										}
									},	
									{
										field : "bzScale",
										sortable : "true",
										title : '保证金比例（%）',
										align : 'center',
										formatter : function(value, row, index) {
											return row.bzScale
											
										}
									},
									{
										field : "depositMethodID",
										sortable : "true",
										title : '缴存方式',
										align : 'center',
										formatter : function(value, row, index) {
											return row.depositMethodID;
										}
									},*/
									{
										field : "iseable",
										sortable :"true",
										title : '信贷偏好',
										align : 'center',
										formatter : function(value, row, index) {
											return row.creditRemark;
										}
									},
									/*{
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button class="btn_Cooperations_view btn btn-xs btn-warning" title="额度使用明细" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													].join('');
										},
										// 事件绑定
										events : {
											'click .btn_Cooperations_view' : function(e, value, row, index) {
												$.zjm_Cooperation.creditDetail(row);
														
											},
										}
									}*/ ],
							detailView : true,
							detailFormatter : function(index, row) {
								/**
								 * 描述: 实现对某个特殊值的处理。
								 * value: 预处理的值
								 * isValue: 预处理值的期望结果值
								 * replaceValue: 不满足条件的替换值
								 * newValue: 满足条件的补充值，一般为单位,百分号等
								 * @author:wuhn
								 * @date: 2017年5月25日 15:31:21
								 */
								function isValue(value,isValue,replaceValue,newValue){
									if(isValue == value){
										return replaceValue;
									}else{
										return value+newValue;
									}
								}

								var html = [];
								html.push('<p><b>合作机构:</b> '+ row.banksortname + '</p>');
								html.push('<p><b>授信额度:</b> '+ isValue(row.creditSum,null,"（空）","万元") + '</p>');
								html.push('<p><b>已用额度:</b> '+ isValue(row.usedSum,null,"（空）","万元") + '</p>');
								html.push('<p><b>可用余额:</b> '+isValue((tool.isNull(row.creditSum,0)-tool.isNull(row.usedSum,0)),"","0 万元"," 万元") + '</p>');
								html.push('<p><b>授信起始日期:</b> '+isValue(tool.parseDate(row.creditBeginDate),"","（空）","")  + '</p>');
								html.push('<p><b>授信到期日期:</b> '+isValue(tool.parseDate(row.creditEndDate),"","（空）","")+ '</p>');
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
							pageList : [30,50,100,200,500], // 可供选择的每页的行数（*）
							// 该url是用于实现右侧列表显示的
							url : "/crm/cooperation/selectCooperationPageTables",// 这个接口需要处理bootstrap
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
							search:true,
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
					});
	}

	
	/** * 额度使用情况查看** */
	function viewCooperation(row) {
		$("#creditConditionsPage").load(
			"/crm/creditConditions/selectCreditConditionsView",
			{"banksortid":row.banksortid,"unitUid":row.unitUid},
			function(){
				$("#creditConditionsDetail").modal({
					keyboard : true
				});
			}
		)
	}
	
	/**额度使用明细 查看 */
	function creditDetail(row){
		alert("开发中...");
	}
})(jQuery, this);





$(function() {
	/**
	 * 文档加载的时候初始化列表
	 */
	$.zjm_Cooperation.initTree();
	
	//重置列表
	$("#refresh").click(function(){
		$.zjm_Cooperation.initTree();
	})

}); // $(function) end

