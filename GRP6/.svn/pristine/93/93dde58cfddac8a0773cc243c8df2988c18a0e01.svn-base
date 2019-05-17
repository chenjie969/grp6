(function($,z){
	$.zjm_assetSealUp = {
			openAssetSealUp:openAssetSealUp,//资产查封信息
			openAssetSealUpEdit:openAssetSealUpEdit, //编辑资产查封信息
			insertOrUpdateAssetSealUp:insertOrUpdateAssetSealUp,//添加或编辑资产查封信息表
			colseInsertAssetSealUp:colseInsertAssetSealUp,//关闭资产清查信息表
			initAssetSealUp1Table:initAssetSealUp1Table, //初始化查封列表
			initAssetSealUp2Table:initAssetSealUp2Table, //初始化被查封列表
			initColumns1:initColumns1,
			initColumns2:initColumns2,
			chooseProj:chooseProj, //项目选择
			initProjNameTable:initProjNameTable, //初始化项目列表
			chooseSuit:chooseSuit, //选择诉讼信息
			initSuitTable:initSuitTable, //初始化诉讼信息列表
	};
		
	function initColumns1(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'recordNum',title:'案号',align:'center',sortable : "true",formatter: function (value, row, index) {return row.recordNum;}},
			{field:'effectiveLegalDocuments',title:'生效法律文书',align:'center',sortable : "true",formatter: function (value, row, index) {return row.effectiveLegalDocuments;}},
			{field:'lawsuitDate',title:'立案日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.lawsuitDate, '');}},
			{field:'projectNameList',title:'涉及的项目名称',align:'center',sortable : "true",formatter: function (value, row, index) {return row.projectNameList;}},
			{field:'affiliateGroup',title:'涉及公司名称',align:'center',sortable : "true",formatter: function (value, row, index) {return row.affiliateGroup;}},
			{field:'plaintiff',title:'申请执行人/原告',align:'center',sortable : "true",formatter: function (value, row, index) {return row.plaintiff;}},
			{field:'defendant',title:'被执行人/被告',align:'center',sortable : "true",formatter: function (value, row, index) {return row.defendant;}},
			{field:'targetSum',title:'标的金额',align:'center',sortable : "true",formatter: function (value, row, index) {return row.targetSum;}},
			{field:'firstSeal',title:'首封情况',align:'center',sortable : "true",formatter: function (value, row, index) {return row.firstSeal;}},
			{field:'waiting',title:'轮候情况',align:'center',sortable : "true",formatter: function (value, row, index) {return row.waiting;}},
			{field:'ifWorkingGroup',title:'是否在工作组',align:'center',sortable : "true",formatter: function (value, row, index) {
					if (row.ifWorkingGroup == 1) {
						return "是";
					} else if (row.ifWorkingGroup == 0){
						return "否";
					}
				}
			},
			{field:'remark',title:'备注',align:'center',sortable : "true",formatter: function (value, row, index) {return row.remark;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_assetSealUp_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_assetSealUp_edit': function(e, value, row, index) {
						$.zjm_assetSealUp.openAssetSealUpEdit(row);
					}
				}
			}
			
		];
		return columns;
	}	
	
	function initColumns2(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'recordNum',title:'案号',align:'center',sortable : "true",formatter: function (value, row, index) {return row.recordNum;}},
			{field:'effectiveLegalDocuments',title:'生效法律文书',align:'center',sortable : "true",formatter: function (value, row, index) {return row.effectiveLegalDocuments;}},
			{field:'lawsuitDate',title:'立案日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.lawsuitDate, '');}},
			{field:'plaintiff',title:'申请执行人/原告',align:'center',sortable : "true",formatter: function (value, row, index) {return row.plaintiff;}},
			{field:'defendant',title:'被执行人/被告',align:'center',sortable : "true",formatter: function (value, row, index) {return row.defendant;}},
			{field:'targetSum',title:'标的金额',align:'center',sortable : "true",formatter: function (value, row, index) {return row.targetSum;}},
			{field:'firstSeal',title:'首封情况',align:'center',sortable : "true",formatter: function (value, row, index) {return row.firstSeal;}},
			{field:'waiting',title:'轮候情况',align:'center',sortable : "true",formatter: function (value, row, index) {return row.waiting;}},
			{field:'remark',title:'备注',align:'center',sortable : "true",formatter: function (value, row, index) {return row.remark;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_assetSealUp_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_assetSealUp_edit': function(e, value, row, index) {
						$.zjm_assetSealUp.openAssetSealUpEdit(row);
					}
				}
			}
		];
		return columns;
	}	
	
	/**初始化查封列表***/
	function initAssetSealUp1Table(condition){
		$("#assetSealUp1-table").bootstrapTable('destroy');
		$('#assetSealUp1-table').bootstrapTable({
			method: 'get',
			columns: initColumns1(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>案号:</b> ' + tool.isNull(row.recordNum,"") + '</p>');
			    	html.push('<p><b>生效法律文书:</b> ' + tool.isNull(row.effectiveLegalDocuments,"") + '</p>');
			    	html.push('<p><b>立案日期:</b> ' + tool.isNull(row.lawsuitDate,"") + '</p>');
			    	html.push('<p><b>申请执行人/原告:</b> ' + tool.isNull(row.plaintiff,"") + '</p>');
				    html.push('<p><b>被执行人/被告:</b> ' + tool.isNull(row.defendant,"") + '</p>');
				    html.push('<p><b>标的金额:</b> ' + tool.isNull(row.targetSum,"") + '</p>');
				    html.push('<p><b>首封情况:</b> ' + tool.isNull(row.firstSeal,"") + '</p>');
			        html.push('<p><b>轮候情况:</b> ' + tool.isNull(row.waiting,"") + '</p>');
			        html.push('<p><b>备注:</b> ' + tool.isNull(row.remark,"") + '</p>');
			   return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			sortName: "",     //默认排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/assetSealUp/selectProSeaulUpPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				//简单查询的时候将高级查询的条件注释掉
				if(params.searchText != undefined){
					condition = undefined;
				}
				var queryCondition={"clientTypeID":$(".clientTypeID").val()};
				$.extend(params,{"queryCondition":condition,"wheresql":" and assetSealUpType = '01' "});
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
	
	/**初始化被查封列表***/
	function initAssetSealUp2Table(condition){
		$("#assetSealUp2-table").bootstrapTable('destroy');
		$('#assetSealUp2-table').bootstrapTable({
			method: 'get',
			columns: initColumns2(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
					html.push('<p><b>案号:</b> ' + tool.isNull(row.recordNum,"") + '</p>');
			    	html.push('<p><b>生效法律文书:</b> ' + tool.isNull(row.effectiveLegalDocuments,"") + '</p>');
			    	html.push('<p><b>立案日期:</b> ' + tool.isNull(row.lawsuitDate,"") + '</p>');
			    	html.push('<p><b>涉及的项目名称:</b> ' + tool.isNull(row.projectNameList,"") + '</p>');
			    	html.push('<p><b>涉及公司的名称:</b> ' + tool.isNull(row.affiliateGroup,"") + '</p>');
			    	html.push('<p><b>申请执行人/原告:</b> ' + tool.isNull(row.plaintiff,"") + '</p>');
				    html.push('<p><b>被执行人/被告:</b> ' + tool.isNull(row.defendant,"") + '</p>');
				    html.push('<p><b>标的金额:</b> ' + tool.isNull(row.targetSum,"") + '</p>');
				    html.push('<p><b>首封情况:</b> ' + tool.isNull(row.firstSeal,"") + '</p>');
			        html.push('<p><b>轮候情况:</b> ' + tool.isNull(row.waiting,"") + '</p>');
			        html.push('<p><b>是否在工作组:</b> ' + tool.isNull(row.ifWorkingGroup,"") + '</p>');
			    	html.push('<p><b>备注:</b> ' + tool.isNull(row.remark,"") + '</p>');
			  return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			sortName: "",     //默认排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/assetSealUp/selectProSeaulUpPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				//简单查询的时候将高级查询的条件注释掉
				if(params.searchText != undefined){
					condition = undefined;
				}
				var queryCondition={"clientTypeID":$(".clientTypeID").val()};
				$.extend(params,{"queryCondition":condition,"wheresql":"and assetSealUpType = '02' "});
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

	//资产清查登记
	function openAssetSealUp(){		
		window.parent.openMenu('openAssetSealUp','','资产查封信息','/project/assetSealUp/openAssetSealUpPage', 1);				
	}
	//资产清查登记
	function openAssetSealUpEdit(row){		
		window.parent.openMenu('openAssetSealUp','','编辑资产查封信息','/project/assetSealUp/openAssetSealUpPage','&assetSealUp_ID='+row.assetSealUp_ID ,1);				
	}
	//关闭资产清查登记页面  
	function colseInsertAssetSealUp(){
		window.parent.closeMenu('openAssetSealUp');
	}
	/***资产清查登记***/
	function insertOrUpdateAssetSealUp(){
		if($("#asserSealUp_form").validationEngine("validate")){
			var queryContainer_form = $("#asserSealUp_form");
			$.ajax({type:'POST',url:'/project/assetSealUp/insertOrUpdateOneSealUpInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					window.location.reload();
				}else{
					alert("资产清查信息操作失败！");
				}
			}
			});
			
		}else{
			tool.undisabled(".btn_insertAssetSealUp");
		}
	}
	
	//项目选择
	function chooseProj() {
		$("#relationMainOrCompanyList").modal({
			keyboard : true
		});
		$.zjm_assetSealUp.initProjNameTable();
		$("#btn_listOK").click(
				function() { // 弹出列表点击确定，将选中的企业名称填入以下几个位置：
					var selectContent = $("#table_relationMainOrCompany")
							.bootstrapTable('getSelections');
					var isGuarantyMaxSum = $("input[name='isGuarantyMaxSum']:checked").val(); 
					console.log("isGuarantyMaxSum",isGuarantyMaxSum)
					if (selectContent.length == 0 && isGuarantyMaxSum == 1) {
						$("#pleaseSelectOne").modal({
							keyboard : true
						});
					} else if (selectContent.length != 1 && isGuarantyMaxSum == 0) {
						$("#pleaseSelectOne").modal({
							keyboard : true
						});
					} else {
						var projectName = "";
						var apply_ID = "";
						selectContent.map(function(item,t){
							console.log(item,t)
							if(t == 0){
								projectName = item.projectName;
								apply_ID = item.apply_ID;
								project_ID = item.project_ID;
							}else{
								projectName = projectName + "," + item.projectName;
								apply_ID = apply_ID + "," + item.apply_ID;
								project_ID = project_ID+","+item.project_ID;
							}
							
						})
						console.log("apply_ID",apply_ID)
						$("#relationMainOrCompanyList").modal("hide");
						$("input[name='projectNameList']").val(
								projectName); // 项目名称
						$("input[name='apply_ID']").val(
								apply_ID); // 申请记录ID
						$("input[name='projectIDList']").val(
								project_ID); // 申请记录ID
						$("input[name='otherCreditCode']").val(
								selectContent[0].certificateCode);// 统一社会信用代码
						$("input[name='otherLegalPerson']").val(
								selectContent[0].legalPerson); // 法定代表人
						$("input[name='otherLegalPhone']").val(
								selectContent[0].phoneOne); // 法人联系方式
						$("input[name='otherLegalAddress']").val(
								selectContent[0].workAddress); // 住所 (法人住所)
						$("input[name='otherPostCode']").val(
								selectContent[0].zipCode); // 邮编
						$("input[name='otherFax']").val(
								selectContent[0].phoneOne); // 传真

					}
				});
		$("#relationMainOrCompanyList").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$("#btn_listOK").unbind("click");
		});
	}
	
	/**
	 * 初始化项目名称列表
	 */
	function initProjNameTable() {
		$("#selectListLabel").text("选择项目名称");
		$("#table_relationMainOrCompany").bootstrapTable('destroy');
		$('#table_relationMainOrCompany').bootstrapTable({
			method : 'post',
			singleSelect : false,// 单选checkbox
			columns : [ {
				field : 'checked',
				checkbox : true,
				align : 'center',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'index',
				title : '序号',
				align : 'center',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'pa.guarantyOrgName',
				title : '承保机构',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.guarantyOrgName;
				}
			}, {
				field : 'pa.hostAreaName',
				title : '承办地区',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.hostAreaName;
				}
			}, {
				field : 'pp.projectName',
				title : '项目名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.projectName;
				}
			}, {
				field : 'pp.busiTypeName',
				title : '业务品种',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.busiTypeName;
				}
			}, {
				field : 'pp.guarantySum',
				title : '余额（万元）',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.guarantySum;
				}
			}, {
				field : 'pa.fundChinese',
				title : '资金方',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.fundChinese;
				}
			}, {
				field : 'pa.fundName',
				title : '资金方名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.fundName;
				}
			}, {
				field : 'pp.loadBeginDate',
				title : '起始日期',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return tool.parseDate(row.loadBeginDate, '');
				}
			}, {
				field : 'pp.loadEndDate',
				title : '到期日期',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return tool.parseDate(row.loadEndDate, '');
				}
			}, {
				field : 'pa.oprationCompanyName',
				title : '报送机构',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.oprationCompanyName;
				}
			}, {
				field : 'pa.attributionName',
				title : '属地划分',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.attributionName;
				}
			}, {
				field : 'pp.loadSum',
				title : '项目金额（万元）',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.loadSum;
				}
			}, {
				field : 'pp.periodMonthDay',
				title : '期限',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.periodMonthDay;
				}
			},
			], // end columns
			detailView : false,
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 设置为 true 会在表格底部显示分页条
			paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
			sortable : true, // 是否启用排序
			sortName : "pa.createDate",
			sortOrder : "desc", // 排序方式
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 30, // 每页的记录行数（*）
			pageList : [ 30, 50, 100, 200, 500 ], // 可供选择的每页的行数（*）
			// url:
			// "/project/projectTracking/selectProjectAddOptGuarantyPageTable",//这个接口需要处理bootstrap
			// table传递的固定参数
			url : "/project/project/selectProjectAddOptGuarantyPageTable",// 这个接口需要处理bootstrap
			// table传递的固定参数
			queryParamsType : '', // 默认值为 'limit' ,在默认情况下
			// 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams : function(params) {
				return params;
			},// 前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,// 设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : false, // 是否启用点击选中行
			searchOnEnterKey : true,// 设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle : false,// 是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch : false,
			showExport : false, // 是否显示导出
			exportDataType : "basic" // basic', 'all', 'selected'
		});
	}
	
	
	//
	function chooseSuit() {
		$("#lawSuitList").modal({
			keyboard : true
		});
		$.zjm_assetSealUp.initSuitTable();
		$("#btn_suitListOK").click(
				function() { // 弹出列表点击确定，将选中的企业名称填入以下几个位置：
					var selectContent = $("#table_lawSuit")
							.bootstrapTable('getSelections');
					if (selectContent.length == 0 ) {
						$("#pleaseSelectOne").modal({
							keyboard : true
						});
					} else if (selectContent.length != 1) {
						$("#pleaseSelectOne").modal({
							keyboard : true
						});
					} else {
						var recordNum = "";
						var lawSuit_ID = "";
						selectContent.map(function(item,t){
							console.log(item,t)
							if(t == 0){
								recordNum = item.recordNum;
								lawSuit_ID = item.projectLawsuit_ID;
							}else{
								recordNum = recordNum + "," + item.recordNum;
								lawSuit_ID = lawSuit_ID + "," + item.projectLawsuit_ID;
							}
							
						})
				
						$("#lawSuitList").modal("hide");
						$("input[name='lawSuitName']").val(
								recordNum); // 项目名称
						$("input[name='lawSuitID']").val(
								lawSuit_ID); // 申请记录ID
					}
				});
		$("#lawSuitList").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$("#btn_suitListOK").unbind("click");
		});
	}
	
	/**
	 * 初始化诉讼信息列表
	 */
	function initSuitTable(condition) {
		$("#selectListLabelSuit").text("选择诉讼信息");
		$("#table_lawSuit").bootstrapTable('destroy');
		$('#table_lawSuit').bootstrapTable({
			method : 'post',
			singleSelect : true,// 单选checkbox
			columns : [ {
				field : 'checked',
				checkbox : true,
				align : 'center',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'index',
				title : '序号',
				align : 'center',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'recordNum',
				title : '案号',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.recordNum;
				}
			}, {
				field : 'group',
				title : '涉及的集团及<br>所属公司的名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.affiliateGroup;
				}
			}, {
				field : 'plaintiff',
				title : '申请人',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.plaintiff;
				}
			}, {
				field : 'defendant',
				title : '被执行人',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.defendant;
				}
			}, {
				field : 'projectNameList',
				title : '涉及的项目名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.projectNameList;
				}
			}, {
				field : 'lawsuitSum',
				title : '金额',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.lawsuitSum;
				}
			}, {
				field : 'province',
				title : '管辖法院<br>所属区域',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.province;
				}
			}, {
				field : 'lawCourt',
				title : '管辖法院名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.lawCourt;
				}
			}, {
				field : 'undertakeJudge',
				title : '承办法官',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.undertakeJudge;
				}
			}, {
				field : 'firstSeal',
				title : '首封情况',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.firstSeal;
				}
			}, {
				field : 'waiting',
				title : '轮候情况',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.waiting;
				}
			}, {
				field : 'fundDeduction',
				title : '资金划扣情况',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.fundDeduction;
				}
			}, 
			], // end columns
			detailView : false,
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 设置为 true 会在表格底部显示分页条
			paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
			sortable : true, // 是否启用排序
			sortName : "",
			sortOrder : "desc", // 排序方式
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 30, // 每页的记录行数（*）
			pageList : [ 30, 50, 100, 200, 500 ], // 可供选择的每页的行数（*）
			// url:
			// "/project/projectTracking/selectProjectAddOptGuarantyPageTable",//这个接口需要处理bootstrap
			// table传递的固定参数
			url : "/project/projectLawsuit/selectProjectLawPageTables",// 这个接口需要处理bootstrap
			// table传递的固定参数
			queryParamsType : '', // 默认值为 'limit' ,在默认情况下
			// 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams : function(params) {
				if(params.searchText != undefined){
					condition = undefined;
				}
				//查询未关联过查封信息的诉讼列表
				$.extend(params,{"queryCondition":condition,"wheresql":"  and (assetSealUp_ID is null or assetSealUp_ID = '') "});
				return params;
			},// 前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,// 设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : false, // 是否启用点击选中行
			searchOnEnterKey : true,// 设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle : false,// 是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch : false,
			showExport : false, // 是否显示导出
			exportDataType : "basic" // basic', 'all', 'selected'
		});
	}
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		$.zjm_assetSealUp.initAssetSealUp1Table();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	};
	//打开资产清查信息页面
	$("#btn_openAssetSealUp").click(function(){
		$.zjm_assetSealUp.openAssetSealUp();
	});
	//资产清查登记
	$("#btn_insertAssetSealUp").click(function(){
		$.zjm_assetSealUp.insertOrUpdateAssetSealUp();
	});
	
	//关闭资产清查登记
	$("#btn_colseInsertAssetSealUp").click(function(){
		$.zjm_assetSealUp.colseInsertAssetSealUp();
	});
	
	
	//查封列表
	$("#assetSealUp1List").click(function(){
		$.zjm_assetSealUp.initAssetSealUp1Table();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	})
	//被查封列表
	$("#assetSealUp2List").click(function(){
		$.zjm_assetSealUp.initAssetSealUp2Table();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	})
	//项目选择
	$("#btn_chooseProj").click(function() {
		$.zjm_assetSealUp.chooseProj();
	})
	//刷新
	$("#btn_refresh").click(function(){
		$.zjm_assetSealUp.initAssetSealUp1Table();
		$.zjm_assetSealUp.initAssetSealUp2Table();
	});
	//关联诉讼信息 展示关联的查询信息id
	$("input[type=radio][name=isConSuit]").change(function(){
		if($(this).val() == '1') {
			$("#div-lawSuit").show();
		} else {
			$("#div-lawSuit").hide();
		}
	});
	//关联诉讼信息选择
	$("#btn_chooseSuit").click(function() {
		$.zjm_assetSealUp.chooseSuit();
	})
	
	//初始化
	if($("input[type=radio][name=isConSuit]:checked").val() == '1'){
		$("#div-lawSuit").show();
	}else{
		$("#div-lawSuit").hide();
	}
	
	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_assetSealUp.hightSelect();
	});
	
	$(".selectList").change(function(){	
		var selectID=$(this).attr("id");	//获取当前下拉框的id;	
		tool.getSelectText(selectID);
	});

});

