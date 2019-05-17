(function($,z){
	$.zjm_personApply = {
		initTable:initTable,//初始化列表
		initColumns:initColumns,//初始化列表项
		listSet:listSet,//自定义列表栏目
		addPersonApply:addPersonApply,//新增一条个人咨询登记记录
		viewPersonApply:viewPersonApply,//查看个人咨询登记记录详情
		editPersonApply:editPersonApply,//修改一条个人咨询登记记录
		delPersonApply:delPersonApply,//删除一条个人咨询登记记录
		advancedQuery:advancedQuery,//高级查询
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#personApply_table').bootstrapTable('destroy');
		$('#personApply_table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			        html.push('<p><b>申请人姓名：</b> ' + row.clientName + '</p>');
			        html.push('<p><b>身份证号码：</b> ' + row.certificateCode + '</p>');
			        html.push('<p><b>业务品种：</b> ' + row.busiTypeName + '</p>');
			        html.push('<p><b>申请金额：</b> ' + row.applySum + '万元</p>');
			        html.push('<p><b>申请期限：</b> ' + tool.isNull(row.periodMonthDay,"（空）") + '</p>');
			        html.push('<p><b>合作机构：</b> ' + row.cooperationName + '</p>');
			        html.push('<p><b>客户来源：</b> ' + row.clientSourceName + '</p>');
			        html.push('<p><b>手机：</b> ' + row.phone + '</p>');
			        html.push('<p><b>接待日期：</b> ' + tool.parseDate(row.receiveDate) + '</p>');
			        html.push('<p><b>接待部门：</b> ' + row.receiveDeapartName + '</p>');
			        html.push('<p><b>接待人：</b> ' + row.receiveUserName + '</p>');
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
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/crm/apply/selectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"apply_clientType":"02","apply_approvalStatu":"01"};
				$.extend(queryCondition,data);
				$.extend(params, {"queryCondition":queryCondition});
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
	}
	
	/**初始化列表项***/
	function initColumns(){
		var columns = [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
			{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 		
		];
		$.ajax({type:'POST',url:'/selectOneListSetInfo',async:false,data:JSON.stringify({"listBH":'005'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj!=null && data.obj.selectedColumns!=null &&　data.obj.selectedColumns!=''){
					var arr= data.obj.selectedColumns.split(",");
	        		var arrName= data.obj.selectedColumnNames.split(",");
	        		for(var i = 0;i<arr.length;i++) {
	        			var field = arr[i];
	        			var title  = arrName[i];
	        			var column = {
	        					"field" : field,
	        					"title" : title,
	        					"align" : "center",
	        					"sortable" : "true",
	        					"formatter" : function (value, row, index) {return  value}
	        			}
	        			if(field == "receiveDate"){
	        				$.extend(column,{"formatter" : function (value, row, index) {return tool.parseDate(value)}});
    					}
	        			columns.push(column);
	        		}
				}
			}
		});
		columns.push({title: '操作',align: 'center',
			formatter:function(value,row,index){
				return ['<button class="btn_personApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
					'<button class="btn_personApply_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
					'<button class="btn_personApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
			},
			events:{
				'click .btn_personApply_view': function(e, value, row, index) {
					$.zjm_personApply.viewPersonApply(row);
				},
				'click .btn_personApply_edit': function(e, value, row, index) {
					$.zjm_personApply.editPersonApply(row);
				},
				'click .btn_personApply_del': function(e, value, row, index) {
					$.zjm_personApply.delPersonApply(row);
				}
			}
		});
		return columns;
	}
	
	/**自定义列表栏目窗口**/
	function listSet(){
		$("#listSetColumnsModule").modal({keyboard:true});
		$("#listBH").val("005");
		zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'005'},"ztb_choosable");
		zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'005'},"ztb_selected");
		$.zjm_listSet.columnsSort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			var selectedColumns = $("#selectedColumns").val();
			if(selectedColumns != null && selectedColumns != ""){
				var queryContainer_form = $("#listSetColumnsForm");
				$.ajax({type:'POST',url:'/updateOneListSetInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#listSetColumnsModule").modal("hide");
							initTable();
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
							initTable();
						}
			        }
				});
			}else{
				tool.undisabled(".btn_submit");
				$("#selectedColumnNotEmpty").modal({keyboard:true});
			}
		});
		$(".btn_reset").click(function () {
			zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'002'},"ztb_choosable");
			zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'002'},"ztb_selected");
		});
		$("#listSetColumnsModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
			 $(".add").unbind("click");
			 $(".remove").unbind("click");
			 $("#btn_moveUp").unbind("click");
			 $("#btn_moveDown").unbind("click");
			 $("#btn_moveTop").unbind("click");
			 $("#btn_moveBottom").unbind("click");
		});
	}
	
	/**新增一条个人咨询登记**/
	function addPersonApply(){
		$("#personApply_page").load("/crm/apply/personApplyAddPage",{},function(response,status,xhr){
			$("#addPersonApply").modal({keyboard:true});
			$.zjm_basicApply.initSelectTree();
			/*设置日期初始值，默认为当天*/
			$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));
			/*获取客户来源下拉框*/
			zjm.dataViewValSelect("select_clientSource", "/selectDicTypeListJSON", {"dicTypePID" : '3fafef23e87a4b9c99807207f618883d'});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_personApply_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				var queryContainer_form = $("#add_personApply_form");
				tool.disabled(".btn_submit");
				if(queryContainer_form.validationEngine("validate")){
//					if(zjm.ajaxValidata("add_personName","/crm/apply/isExistClientName",JSON.stringify(queryContainer_form.serializeJson()),"申请人姓名重复！")){
					if(zjm.ajaxValidata("add_personName","/crm/apply/isExistBadPerson",JSON.stringify(queryContainer_form.serializeJson()),"该个人已进入黑名单，不允许创建咨询记录！")){
						$.ajax({type:'POST',url:'/crm/apply/insertOneApply',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#addPersonApply").modal("hide");
									$.zjm_personApply.initTable();
								}else{
									alert("保存失败！");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addPersonApply").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**查看一条个人咨询登记**/
	function viewPersonApply(row){
		$("#personApply_page").load("/crm/apply/personApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#viewPersonApply").modal({keyboard:true});
		});
	}
	
	/**修改一条个人咨询登记**/
	function editPersonApply(row){
		$("#personApply_page").load("/crm/apply/personApplyEditPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#editPersonApply").modal({keyboard:true});
			$.zjm_basicApply.initSelectTree();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_personApply_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				var queryContainer_form = $("#edit_personApply_form");
				tool.disabled(".btn_submit");
				if(queryContainer_form.validationEngine("validate")){
//					if(zjm.ajaxValidata("edit_clientName","/crm/apply/isExistClientName",JSON.stringify(queryContainer_form.serializeJson()),"申请人姓名重复！")){
						$.ajax({type:'POST',url:'/crm/apply/updateOneApply',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#editPersonApply").modal("hide");
									$.zjm_personApply.initTable();
								}else{
									alert("保存失败！");
								}
					        }
						});
//					}else{
//						tool.undisabled(".btn_submit");
//					}
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editPersonApply").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**删除一条个人咨询登记**/
	function delPersonApply(row){
		$("#personApply_page").load("/crm/apply/personApplyDelPage",{},function(response,status,xhr){
			$("#delPersonApply").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/crm/apply/deleteOneApply',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#delPersonApply").modal("hide");
							$.zjm_personApply.initTable();
						}else{
							alert("保存失败！");
						}
			        }
				});
			});
			$("#delPersonApply").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**高级查询**/
	function advancedQuery(){
		$("#personApply_page").load("/crm/apply/personApplyAdQuery",{},function(response,status,xhr){
			$("#personApplyAdQuery").modal({keyboard:true});
			/*初始化各个下拉选择树*/
			$.zjm_basicApply.initSelectTree();
			/*获取客户来源下拉框*/
			zjm.dataViewValSelect("select_clientSource", "/selectDicTypeListJSON", {"dicTypePID" : '3fafef23e87a4b9c99807207f618883d'});
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"personApply_advancedQuery_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#personApply_advancedQuery_form");
				if(queryContainer_form.validationEngine("validate")){
					$("#personApplyAdQuery").modal("hide");
					initTable($("#personApply_advancedQuery_form").serializeJson());
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			
			$("#personApplyAdQuery").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_personApply.initTable();
	};
	
	$("#btn_addPersonApply").click(function(){
		$.zjm_personApply.addPersonApply();
	});
	
	$("#btn_agreeToAccept").click(function(){
		var selectContent = $("#personApply_table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
			$.zjm_basicApply.agreeToAccept("personApply",selectContent);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	
	$("#btn_disagreeToAccept").click(function(){
		var selectContent = $("#personApply_table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
			$.zjm_basicApply.disagreeToAccept("personApply",selectContent);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	
	$("#btn_advancedQuery").click(function(){
		$.zjm_personApply.advancedQuery();
	});
	
	$("#btn_refreshPersonApplyTable").click(function(){
		$.zjm_personApply.initTable();
	});
	$("#btn_listSetPersonApply").click(function(){
		$.zjm_personApply.listSet();//自定义列表栏目
	});
});

