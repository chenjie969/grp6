/**
 * 新增 -- 担保措施管理页面-- 按钮功能 js
 * 
 * @author wuhn 2017年7月5日 16:41:45
 */
(function($, z) {
	$.zjm_optAdd = {
		chooseProj : chooseProj, // 保证措施管理 --- 新增 --选择 项目名称
		guarantyType : guarantyType, // 保证方式的处理
		choosePerson : choosePerson, // 保证措施管理 --- 新增 --选择 权属人
		addPerson : addPerson, // 保证措施管理 --- 新增 --新增 -- 权属人
		ownerType : ownerType, // 保证措施管理 --- 权属人类型
		addOptGuarantyNext : addOptGuarantyNext, // 保证措施管理 --- 新增 --- 下一步
		previousStep : previousStep, // 保证措施管理 --- 新增 --- 下一步 --- 上一步
		initProjNameTable : initProjNameTable, // 初始化项目名称列表 -- 用于选择项目名称
		initOwnerTypeTable : initOwnerTypeTable, // 初始化 企业类型 权属人名称列表 -- 用于选择
		// 权属人 信息
		initOwnerPersonTypeTable : initOwnerPersonTypeTable, // 初始化 自然人 类型
		// 权属人名称列表 --
		// 用于选择 权属人 信息
		addSumbit : addSumbit,// 保证措施管理 --- 新增 --- 下一步--- 保存 按钮
		addSumbitAndAgain : addSumbitAndAgain,// 保证措施管理 --- 新增 --- 下一步---
		// 保存并继续添加 按钮
		rules : rules,
		chooseGuaranty : chooseGuaranty,// 选择担保物
		initGuaranty : initGuaranty,// 担保物列表
		addSave : addSave,// 保存功能
	// 验证保证措施附件规则
	};

	/**
	 * 保证措施管理 --- 新增 --选择 项目名称
	 */
	function chooseProj() {
		$("#relationMainOrCompanyList").modal({
			keyboard : true
		});
		$.zjm_optAdd.initProjNameTable();
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
							}else{
								projectName = projectName + "," + item.projectName;
								apply_ID = apply_ID + "," + item.apply_ID;
							}
							
						})
						console.log("apply_ID",apply_ID)
						$("#relationMainOrCompanyList").modal("hide");
						$("input[name='clientName']").val(
								projectName); // 项目名称
						$("input[name='apply_ID']").val(
								apply_ID); // 申请记录ID
						$("input[name='project_ID']").val(
								selectContent[0].project_ID); // 申请记录ID
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
			}, {
				field : 'pp.amanName',
				title : 'A角',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.amanName;
				}
			}, {
				field : 'pp.bmanName',
				title : 'B角',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.bmanName;
				}
			},
			// {field:'proType',title:'类型',align:'center',formatter: function
			// (value, row, index) {return row.projectType;}},
			// {field:'busiCode',title:'项目编号',align:'center',sortable :
			// "true",formatter: function (value, row, index) {return
			// row.busiCode;}},
			// {field:'projectName',title:'项目名称',align:'center',sortable :
			// "true",formatter: function (value, row, index) {return
			// row.projectName;}},
			// {field:'departName',title:'经办部门',align:'center',sortable :
			// "true",formatter: function (value, row, index) {return
			// row.departName;}},
			// {field:'createManName',title:'经办人',align:'center',sortable :
			// "true",formatter: function (value, row, index) {return
			// row.createManName;}},
			// {field:'createDate',title:'受理日期',align:'center',sortable :
			// "true",formatter: function (value, row, index) {return
			// tool.parseDate(row.createDate);}},
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
				// $.extend(params,
				// {"queryCondition":{"apply_ID":$("#apply_ID").val()}});
				// $.extend(params,{"queryCondition":condition,"wheresql":" and
				// finishDate is null "});
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

	/**
	 * 初始化 企业类型 权属人名称列表
	 */
	function initOwnerTypeTable() {
		$("#selectListLabel").text("选择权属人");
		$("#table_relationMainOrCompany").bootstrapTable('destroy');
		$('#table_relationMainOrCompany').bootstrapTable({
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
				field : "clientName",
				title : '企业名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.clientName;
				}
			}, {
				field : "legalPerson",
				title : '法定代表人',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.legalPerson;
				}
			}, {
				field : "certificateCode",
				title : '社会信用代码',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.certificateCode;
				}
			}, {
				field : "createUserName",
				title : '创建人',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.createUserName;
				}
			} ], // end columns
			detailView : false,
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 设置为 true 会在表格底部显示分页条
			paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
			sortable : true, // 是否启用排序
			sortOrder : "asc", // 排序方式
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 30, // 每页的记录行数（*）
			pageList : [ 30, 50, 100, 200, 500 ], // 可供选择的每页的行数（*）
			url : "/selectCompanyClientPageTables",// 这个接口需要处理bootstrap
			// table传递的固定参数
			queryParamsType : '', // 默认值为 'limit' ,在默认情况下
			// 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams : function(params) {
				$.extend(params, {
					"queryCondition" : {
						"clientTypeID" : "01"
					}
				});
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

	/**
	 * 初始化 自然人 类型 权属人名称列表
	 */
	function initOwnerPersonTypeTable() {
		$("#selectListLabel").text("选择权属人");
		$("#table_relationMainOrCompany").bootstrapTable('destroy');
		$('#table_relationMainOrCompany').bootstrapTable({
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
				field : "clientName",
				title : '姓名',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.personName;
				}
			}, {
				field : "legalPerson",
				title : '性别',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.sex;
				}
			}, {
				field : "personNum",
				title : '身份证号',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.personNum;
				}
			}, {
				field : "createUserName",
				title : '创建人',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.createUserName;
				}
			} ], // end columns
			detailView : false,
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 设置为 true 会在表格底部显示分页条
			paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
			sortable : true, // 是否启用排序
			sortOrder : "asc", // 排序方式
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 30, // 每页的记录行数（*）
			pageList : [ 30, 50, 100, 200, 500 ], // 可供选择的每页的行数（*）
			url : "/selectCompanyClientPageTables",// 这个接口需要处理bootstrap
			// table传递的固定参数
			queryParamsType : '', // 默认值为 'limit' ,在默认情况下
			// 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams : function(params) {
				$.extend(params, {
					"queryCondition" : {
						"clientTypeID" : "02,03"
					}
				});
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

	/**
	 * 保证措施管理--- 新增-- 保证方式处理
	 */
	function guarantyType(_optionText, _val) {
		$(".ownerInput").val("");// 权属人文本框清空
		if (_val == '4efae31cb89847b598faf3a05273f0fa'
				|| _val == '6305ed68f1674830ad65b420109c6340') { // 保证方式为:
			// 企业信用
			// 、个人信用
			$(".ownerType").hide(); // 权属人类型隐藏
			if (_val == '4efae31cb89847b598faf3a05273f0fa') {
				$("input[name='optType']").get(0).checked = true;
			} else {
				$("input[name='optType']").get(1).checked = true;
			}
		} else {
			$(".ownerType").show();
			$("#optType02").val("02");
			$("#optType01").val("01");
		}

		if (_val == 'c0b07f297c6f4e23981d9e1fed84c5f9') { // 质押
			$("#btn_optTypes").addClass("validate[required]"); // 保证方式为：质押
			// 给反担保类型 字段
			// 增加必填验证
			$("#btn_optTypesDIV").show();
			$.ajax({ // 获取 保证方式为： 质押 时的反担保物类型 字段
				type : 'POST',
				url : "/selectDicTypeSelectJSONKeyValue",
				data : JSON.stringify({
					"dicTypePID" : '686f264405e549b299a7ed815ea289d6'
				}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#btn_optTypes").empty();
					$("#btn_optTypes").append(
							"<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("#btn_optTypes").append(
									"<option value='" + key2 + "'>" + value2
											+ "</option>");
						});
					});
				}
			});
		} else if (_val == '596d424eb6594b1485ecc724a2533c1c') { // 抵押
			$("#btn_optTypes").addClass("validate[required]"); // 保证方式为：抵押
			// 给反担保类型 字段
			// 增加必填验证
			$("#btn_optTypesDIV").show();
			$.ajax({ // 获取 保证方式为： 抵押 时的反担保物类型 字段
				type : 'POST',
				url : "/selectDicTypeSelectJSONKeyValue",
				data : JSON.stringify({
					"dicTypePID" : '12b5eece874947de8e692a31939cda44'
				}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#btn_optTypes").empty();
					$("#btn_optTypes").append(
							"<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("#btn_optTypes").append(
									"<option value='" + key2 + "'>" + value2
											+ "</option>");
						});
					});
				}
			});
		} else {
			$("#btn_optTypes").removeClass("validate[required]"); // 取消验证
			$("#btn_optTypesDIV").hide();
			$("#btn_optTypes").find("option:selected").text("");// 隐藏的时候将文本内容清空
			$("#btn_optTypes").find("option:selected").val("");// 隐藏的时候，将value也清空
		}
	}

	/**
	 * 保证措施管理 --- 新增 --选择 权属人 _optType: 权属人类型 01 企业 ，02,03 自然人
	 */
	function choosePerson(_optType) {
		$("#relationMainOrCompanyList").modal({
			keyboard : true
		});
		if (_optType == '01') {
			$.zjm_optAdd.initOwnerTypeTable(); // 企业
		} else {
			$.zjm_optAdd.initOwnerPersonTypeTable(); // 自然人
		}
		$("#btn_listOK").click(
				function() { // 弹出列表点击确定，将选中的企业名称填入以下几个位置：
					var selectContent = $("#table_relationMainOrCompany")
							.bootstrapTable('getSelections');
					if (selectContent.length != 1) {
						$("#pleaseSelectOne").modal({
							keyboard : true
						});
					} else {
						$("#relationMainOrCompanyList").modal("hide");
						if (selectContent[0].clientTypeID == '01') {
							$("input[name='ownerName']").val(
									selectContent[0].clientName); // 页面显示权属人名称
						} else {
							$("input[name='ownerName']").val(
									selectContent[0].personName); // 页面显示权属人名称
						}
						$("input[name='clientTypeID']").val(
								selectContent[0].clientTypeID);// 1.权属人类型： 01
						// 企业 ，02 、03 个人
						$("input[name='personNum']").val(
								selectContent[0].personNum);// 3. 身份证号
						$("input[name='client_ID']").val(
								selectContent[0].client_ID);// 4. 权属人id
						$("input[name='certificateCode']").val(
								selectContent[0].certificateCode);// 2.
						// 统一社会信用码
						$("input[name='otherLegalPerson']").val(
								selectContent[0].legalPerson); // 法定代表人
						$("input[name='otherLegalPhone']").val(
								selectContent[0].phoneOne); // 法人联系方式
						$("input[name='otherLegalAddress']").val(
								selectContent[0].workAddress); // 住所 (法人住所)
						$("input[name='otherPostCode']").val(
								selectContent[0].zipCode); // 邮编
						$("input[name='otherFax']").val(selectContent[0].fax); // 传真
						$("input[name='otherPersonPhone']").val(
								selectContent[0].phone); // 手机号
						$("input[name='otherPersonAddress']").val(
								selectContent[0].houseAddress); // 现住地址

					}
				});
		$("#relationMainOrCompanyList").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$("#btn_listOK").unbind("click");
		});
	}

	// 担保物
	function chooseGuaranty(_optType) {
		$("#relationMainOrCompanyList").modal({
			keyboard : true
		});
		$.zjm_optAdd.initGuaranty(); // 担保物
		$("#btn_listOK").click(
				function() { // 弹出列表点击确定，将选中的企业名称填入以下几个位置：
					var selectContent = $("#table_relationMainOrCompany")
							.bootstrapTable('getSelections');
					if (!!selectContent && selectContent.length >= 1) {
						$("#relationMainOrCompanyList").modal("hide");

						var optName = [],optNameId=[];
						$.each(selectContent, function(v,item) {
							optName.push(item.optName);
							optNameId.push(item.optGuaranty_ID)
						})
						$("input[name='optName']").val(optName.join(','))
						$("input[name='optGuarantyIds']").val(optNameId.join(','))
						// if (selectContent[0].clientTypeID == '01') {
						// $("input[name='optName']").val(
						// selectContent[0].optName); // 页面显示权属人名称
						// } else {
						// $("input[name='optName']").val(
						// selectContent[0].optName); // 页面显示权属人名称
						// }
						// 担保物id
//						$("input[name='optGuaranty_ID']").val(
//								selectContent[0].optGuaranty_ID);// 4.
//						// danbaid
//						$("input[name='client_ID']").val(
//								selectContent[0].client_ID);// 4. 权属人id
					} else {
						$("#pleaseSelectOne").modal({
							keyboard : true
						});
					}
				});
		$("#relationMainOrCompanyList").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$("#btn_listOK").unbind("click");
		});
	}
	// 担保物列表展示数据
	function initGuaranty() {
		$("#selectListLabel").text("选择权反担保物");
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
				field : 'projectName',
				title : '客户名称',
				align : 'center',
				formatter : function(value, row, index) {
					return row.projectName;
				}
			}/*, {
				field : 'loadSum',
				title : '项目金额（万元）',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.loadSum;
				}
			}, {
				field : 'fundChinese',
				title : '资金方',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.fundChinese;
				}
			}, {
				field : 'fundName',
				title : '资金方子机构',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.fundName;
				}
			}, {
				field : 'subBankName',
				title : '合作机构',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.subBankName;
				}
			}*/, {
				field : "optTypeName",
				title : '反担保物类型',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.optTypeName;
				}
			}, {
				field : "optName",
				title : '反担保物名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.optName;
				}
			}, {
				field : "ownerName",
				title : '权属人名称',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.ownerName;
				}
			}, {
				field : "optValue",
				title : ' 抵押（质押）价值（万）',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.optValue;
				}
			}, {
				field : "optPeriod",
				title : ' 抵押金额（万）',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.optPeriod;
				}
			}, {
				field : "optPeriod",
				title : ' 抵押金额（万）',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return row.optPeriod;
				}
			}, {
				field : 'loadBeginDate',
				title : '起始日期',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return tool.parseDate(row.loadBeginDate, '');
				}
			}, {
				field : 'delayEndDate',
				title : '到期日期',
				align : 'center',
				sortable : "true",
				formatter : function(value, row, index) {
					return tool.parseDate(row.delayEndDate, '');
				}
			}], // end columns
			detailView : false,
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 设置为 true 会在表格底部显示分页条
			paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
			sortable : true, // 是否启用排序
			sortOrder : "asc", // 排序方式
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 30, // 每页的记录行数（*）
			pageList : [ 30, 50, 100, 200, 500 ], // 可供选择的每页的行数（*）
			url : "/optGuarantyAction/selectOptGuarantyPageTables",// 这个接口需要处理bootstrap///selectCompanyClientPageTables
			// table传递的固定参数
			queryParamsType : '', // 默认值为 'limit' ,在默认情况下
			// 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams : function(params) {
				$.extend(params, {
					"queryCondition" : {
						"clientTypeID" : "01",
						"client_ID" : $("input[name='client_ID']").val() || '',
						'mark':"1"
					},
					
				});
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

	/**
	 * 保证措施管理 --- 新增 --新增 -- 权属人
	 */
	function addPerson(_optType) {
		if (_optType == '01') {// 企业类型权属人
			$("#optGuarantyAdd_page")
					.load(
							"/optGuarantyAction/chooseProjectPage",
							{
								"flag" : "01"
							},
							function() {
								$("#companyOwnerAdd").modal({
									keybord : true
								});
								$(".btn_submit")
										.click(
												function() {
													zjm.init();
													/** 注册编辑验证引擎 */
													zjm.validata({
														formId : "form_company"
													});
													if ($("#form_company")
															.validationEngine(
																	"validate")) {
														var jsonObj = $(
																"#form_company")
																.serializeJson();
														var formData = JSON
																.stringify(jsonObj);

														if (!zjm
																.ajaxValidata(
																		"clientName",
																		"/selectAddClientNameIsExist",
																		formData,
																		"权属人名称重复！")) {
															return false;
														}

														$
																.ajax({
																	type : 'POST',
																	url : "/insertOneClientInfo",
																	data : formData,
																	async : false,
																	contentType : 'application/json; charset=UTF-8',
																	dataType : 'json',
																	success : function(
																			data) {
																		$(
																				"#companyOwnerAdd")
																				.modal(
																						"hide");
																		var selectContent = data.obj;
																		console
																				.info(
																						"data.obj",
																						data.obj);
																		if (selectContent.clientTypeID == '01') {
																			$(
																					"input[name='ownerName']")
																					.val(
																							selectContent.clientName); // 页面显示权属人名称
																		} else {
																			$(
																					"input[name='ownerName']")
																					.val(
																							selectContent.personName); // 页面显示权属人名称
																		}
																		$(
																				"input[name='clientTypeID']")
																				.val(
																						selectContent.clientTypeID);// 1.权属人类型：
																		// 01
																		// 企业
																		// ，02
																		// 、03
																		// 个人
																		$(
																				"input[name='personNum']")
																				.val(
																						selectContent.personNum);// 3.
																		// 身份证号
																		$(
																				"input[name='client_ID']")
																				.val(
																						selectContent.client_ID);// 4.
																		// 权属人id
																		$(
																				"input[name='certificateCode']")
																				.val(
																						selectContent.certificateCode);// 2.
																		// 统一社会信用码
																		$(
																				"input[name='otherLegalPerson']")
																				.val(
																						selectContent.legalPerson); // 法定代表人
																		$(
																				"input[name='otherLegalPhone']")
																				.val(
																						selectContent.phoneOne); // 法人联系方式
																		$(
																				"input[name='otherLegalAddress']")
																				.val(
																						selectContent.workAddress); // 住所
																		// (法人住所)
																		$(
																				"input[name='otherPostCode']")
																				.val(
																						selectContent.zipCode); // 邮编
																		$(
																				"input[name='otherFax']")
																				.val(
																						selectContent.fax); // 传真
																		$(
																				"input[name='otherPersonPhone']")
																				.val(
																						selectContent.phone); // 手机号
																		$(
																				"input[name='otherPersonAddress']")
																				.val(
																						selectContent.houseAddress); // 现住地址
																	}
																});
														$("#companyOwnerAdd")
																.on(
																		"hidden.bs.modal",
																		function(
																				e) {// 解除事件绑定
																			$(
																					".btn_submit")
																					.unbind(
																							"click");
																		});
													}
												})

							})
		} else {
			$("#optGuarantyAdd_page")
					.load(
							"/optGuarantyAction/chooseProjectPage",
							{
								"flag" : "2"
							},
							function() {
								$("#personOwnerAdd").modal({
									keybord : true
								});
								$(".btn_submit")
										.click(
												function() {
													zjm.init();
													/** 注册编辑验证引擎 */
													zjm.validata({
														formId : "form_company"
													});
													if ($("#form_company")
															.validationEngine(
																	"validate")) {
														var jsonObj = $(
																"#form_company")
																.serializeJson();
														var formData = JSON
																.stringify(jsonObj);
														if (!zjm
																.ajaxValidata(
																		"personName",
																		"/selectPersonNameIsExist",
																		formData,
																		"权属人名称重复！")) {
															return;
														}
														$
																.ajax({
																	type : 'POST',
																	url : "/insertOneClientInfo",
																	data : formData,
																	async : false,
																	contentType : 'application/json; charset=UTF-8',
																	dataType : 'json',
																	success : function(
																			data) {
																		$(
																				"#personOwnerAdd")
																				.modal(
																						"hide");
																		var selectContent = data.obj;
																		console
																				.info(
																						"data.obj",
																						data.obj);
																		if (selectContent.clientTypeID == '01') {
																			$(
																					"input[name='ownerName']")
																					.val(
																							selectContent.clientName); // 页面显示权属人名称
																		} else {
																			$(
																					"input[name='ownerName']")
																					.val(
																							selectContent.personName); // 页面显示权属人名称
																		}
																		$(
																				"input[name='clientTypeID']")
																				.val(
																						selectContent.clientTypeID);// 1.权属人类型：
																		// 01
																		// 企业
																		// ，02
																		// 、03
																		// 个人
																		$(
																				"input[name='personNum']")
																				.val(
																						selectContent.personNum);// 3.
																		// 身份证号
																		$(
																				"input[name='client_ID']")
																				.val(
																						selectContent.client_ID);// 4.
																		// 权属人id
																		$(
																				"input[name='certificateCode']")
																				.val(
																						selectContent.certificateCode);// 2.
																		// 统一社会信用码
																		$(
																				"input[name='otherLegalPerson']")
																				.val(
																						selectContent.legalPerson); // 法定代表人
																		$(
																				"input[name='otherLegalPhone']")
																				.val(
																						selectContent.phoneOne); // 法人联系方式
																		$(
																				"input[name='otherLegalAddress']")
																				.val(
																						selectContent.workAddress); // 住所
																		// (法人住所)
																		$(
																				"input[name='otherPostCode']")
																				.val(
																						selectContent.zipCode); // 邮编
																		$(
																				"input[name='otherFax']")
																				.val(
																						selectContent.fax); // 传真
																		$(
																				"input[name='otherPersonPhone']")
																				.val(
																						selectContent.phone); // 手机号
																		$(
																				"input[name='otherPersonAddress']")
																				.val(
																						selectContent.houseAddress); // 现住地址
																	}
																});
													}
												})
								$("#personOwnerAdd").on("hidden.bs.modal",
										function(e) {// 解除事件绑定
											$(".btn_submit").unbind("click");
										});
							})
		}

	}

	/**
	 * 保证措施管理 --- 权属人类型
	 */
	function ownerType() {
		$(".ownerInput").val("");
	}

	/**
	 * 保证措施管理 --- 新增 --- 下一步
	 */
	function addOptGuarantyNext(optObj) {

		zjm.init();
		/** 注册编辑验证引擎 */
		zjm.validata({
			formId : "form_baseOne"
		});
		if ($("#form_baseOne").validationEngine("validate")) {
			tool.disabled("#btn_addOptGuarantyNext");
		} else {
			tool.undisabled("#btn_addOptGuarantyNext"); // 下一步按钮 可用
			return;
		} //
		$(".baseOne").hide(); // 原基础页面隐藏
		$(".baseTwo").show(); // 下一步页面，展开
		$("#addOptGuarantyNextPage").load(
				"/optGuarantyAction/addOptGuarantyNextPage",
				{
					"guarantyTypeID" : optObj.guarantyTypeID,
					"optTypeID" : optObj.optTypeID,
					"clientID" : optObj.clientID
				},
				function() {

					$(".ownerName").text(optObj.ownerName);// 权属人名称
					$("#ownerName").val(optObj.ownerName);// 权属人名称 -- 赋值给隐藏域
					$("#clientID").val(optObj.clientID);
					$("#apply_ID").val(optObj.apply_ID);
					$("input[name='guarantyTypeName']").val(
							optObj.guarantyTypeName);
					$("input[name='optTypeName']").val(optObj.optTypeName);
					$("#guarantyTypeID").val(optObj.guarantyTypeID);// 保证方式 ID
					$("#guarantyTypeName").val(optObj.guarantyTypeName); // 保证方式名称
					$("#optTypeID").val(optObj.optTypeID); // 反担保物类型 ID
					$("#optTypeName").val(optObj.optTypeName); // 保证方式名称
					
					/** 担保方式为： 企业信用时 需要赋值的信息* */
					$("#legalPersonText").text(optObj.legalPerson); // 法定代表人
					$("#phoneOneText").text(optObj.phoneOne); // 法人联系方式
					$("#workAddressText").text(optObj.workAddress); // 住所 (法人住所)
					$("#zipCodeText").text(optObj.zipCode); // 邮编
					$("#faxText").text(optObj.fax); // 传真

					/** 担保方式为： 个人信用时 需要赋值的信息* */
					$("#phoneText").text(optObj.phone); // 手机号
					$("#houseAddressText").text(optObj.houseAddress); // 现住地址

					if (optObj.clientTypeID == '01') { // 权属人类型为：企业
						$(".clientType").text('统一社会信用代码：');
						$(".codeNum").text(optObj.certificateCode);
					} else { // 个人客户
						$(".clientType").text('身份证号码：');
						$(".codeNum").text(optObj.personNum);
					}

				})

	} // end addOptGuarantyNext

	/**
	 * 保证措施管理 --- 新增 --- 上一步操作 按钮操作
	 */
	function previousStep() {
		tool.undisabled("#btn_addOptGuarantyNext");
		$(".baseOne").show();
		$(".baseTwo").hide();
	}

	/**
	 * 保证措施管理 --- 新增 --- 下一步--- 保存 按钮
	 */
	function addSumbit() {
		/** 注册编辑验证引擎 */
		zjm.init();
		// $.zjm.rules = $.zjm_optAdd.rules();
		zjm.validata({
			formId : "form_baseTwo"
		});

		/*
		 * if($("#pictureDIV").children().length > 0){
		 * $("#pictureValid").removeClass("validate[required]"); }else{
		 * $("#pictureValid").addClass("validate[required]"); }
		 */

		if ($("#form_baseTwo").validationEngine("validate")) {
			// tool.disabled("#btn_addOptGuaranty");
			var queryContainer_form = $("#form_baseTwo");
			var formData = JSON.stringify(queryContainer_form.serializeJson());
			$.ajax({
				type : 'POST',
				url : '/optGuarantyAction/insertOneOptGuarantyInfo',
				data : formData,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj) {
						window.parent.closeMenu('add_OptGuaranty');
					} else {
						alert("保存失败...");
					}
				}
			});

		} else {
			// tool.undisabled("#btn_addOptGuaranty"); // 下一步按钮 可用
			return;
		}
	}

	// 选择现有反担保物进行保存
	function addSave() {
		/** 注册编辑验证引擎 */
		zjm.init();
		// $.zjm.rules = $.zjm_optAdd.rules();
		zjm.validata({
			formId : "form_baseOne"
		});

		/*
		 * if($("#pictureDIV").children().length > 0){
		 * $("#pictureValid").removeClass("validate[required]"); }else{
		 * $("#pictureValid").addClass("validate[required]"); }
		 */

		if ($("#form_baseOne").validationEngine("validate")) {
			// tool.disabled("#btn_addOptGuaranty");
			var queryContainer_form = $("#form_baseOne");
			var formData = JSON.stringify(queryContainer_form.serializeJson());
			$.ajax({
				type : 'POST',
				url : '/optGuarantyAction/insertOneOptGuarantyInfoByExisting',
				data : formData,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj) {
						window.parent.closeMenu('add_OptGuaranty');
					} else {
						alert("保存失败...");
					}
				}
			});

		} else {
			tool.undisabled("#btn_addOptGuaranty"); // 下一步按钮 可用
			return;
		}
	}

	/**
	 * 保证措施管理 --- 新增 --- 下一步--- 保存并继续添加 按钮
	 */
	function addSumbitAndAgain() {
		/** 注册编辑验证引擎 */
		zjm.init();
		// $.zjm.rules = $.zjm_optAdd.rules();
		zjm.validata({
			formId : "form_baseTwo"
		});

		/*
		 * if($("#pictureDIV").children().length > 0){
		 * $("#pictureValid").removeClass("validate[required]"); }else{
		 * $("#pictureValid").addClass("validate[required]"); }
		 */

		if ($("#form_baseTwo").validationEngine("validate")) {
			// tool.disabled("#btn_addOptGuaranty");
			var queryContainer_form = $("#form_baseTwo");
			var formData = JSON.stringify(queryContainer_form.serializeJson());

			$.ajax({
				type : 'POST',
				url : '/optGuarantyAction/insertOneOptGuarantyInfo',
				data : formData,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj) {
						$(".baseOne").show(); // 原基础页展开
						$(".baseTwo").hide(); // 下一步页面,隐藏
						tool.undisabled("#btn_addOptGuarantyNext"); // 下一步按钮 可用
						window.parent.closeMenu('add_OptGuaranty');
					} else {
						alert("保存失败...");
					}
				}
			});

		} else {
			tool.undisabled("#btn_addOptGuaranty"); // 下一步按钮 可用
			return;
		}
	}

	function rules() {
		var allRules = {
			"isHavaFile" : {
				"func" : function(field, rules, i, options) {
					console.info(field);

					return false;
				},
				"alertText" : "各业务品种的授信金额之和与授信总金额不相等",
			},
		};
		return allRules;
	}

})(jQuery, this);

$(function() {

	/**
	 * 保证措施管理 --- 新增-- 反担保类型 字段 默认隐藏
	 */
	$("#btn_optTypesDIV").hide();

	/**
	 * 保证措施管理 --- 新增 --选择 项目名称
	 */
	$("#btn_chooseProj").click(function() {
		$.zjm_optAdd.chooseProj();
	})
	
	

	/**
	 * 保证措施管理 -- 新增 -- 保证方式处理
	 */
	$("#btn_guarantyTypes").change(
			function() {
				var _optionText = $("#btn_guarantyTypes").find(
						'option:selected').text();// 获取下拉框默认选中文本 text
				var _val = $("#btn_guarantyTypes").val(); // 获取下拉框默认选中的值 value
				$.zjm_optAdd.guarantyType(_optionText, _val);
			})

	/**
	 * 保证措施管理 --- 新增 --选择 权属人
	 */
	$("#btn_choosePerson").click(function() {
		var _optType = $("input[name='optType']:checked").val(); // 权属人类型
		$.zjm_optAdd.choosePerson(_optType);
	})

	/**
	 * 保证措施管理 --- 新增 --新增 -- 权属人
	 */
	$("#btn_addPerson").click(function() {
		var _optType = $("input[name='optType']:checked").val(); // 权属人类型
		// setTimeout('$.zjm_optAdd.addPerson('+_optType+')',5000);
		$.zjm_optAdd.addPerson(_optType);
	})

	/**
	 * 保证措施管理 --- 权属人类型
	 */
	$(".ownerTypes").change(function() {
		$.zjm_optAdd.ownerType();
	})

	/**
	 * 保证措施管理 --- 新增 --新增 -- 下一步
	 */
	$("#btn_addOptGuarantyNext").click(
			function() {

				var optObj = {
					ownerName : $("input[name='ownerName']").val(), // 权属人名称
					clientTypeID : $("input[name='clientTypeID']").val(), // 类型
					certificateCode : $("input[name='certificateCode']").val(), // 统一社会信用码
					personNum : $("input[name='personNum']").val(), // 身份证号
					clientID : $("input[name='client_ID']").val(), // 客户编号
					apply_ID : $("input[name='apply_ID']").val(), // apply_ID
					guarantyTypeID : $("#btn_guarantyTypes").val(), // 保证方式 ID
					guarantyTypeName : $("#btn_guarantyTypes").find(
							"option:selected").text(), // 保证方式名称
					optTypeID : $("#btn_optTypes").val(), // 反担保物类型 ID
					optTypeName : $("#btn_optTypes").find("option:selected")
							.text(), // 保证方式名称
					legalPerson : $("input[name='otherLegalPerson']").val(),// 法定代表人
					phoneOne : $("input[name='otherLegalPhone']").val(),// /法人联系方式
					workAddress : $("input[name='otherLegalAddress']").val(),// 住所
					// (法人住所)
					zipCode : $("input[name='otherPostCode']").val(),// 邮编
					fax : $("input[name='otherFax']").val(), // 传真

					phone : $("input[name='otherPersonPhone']").val(), // 个人手机号
					houseAddress : $("input[name='otherPersonAddress']").val()
				// 个人住址

				}

				$.zjm_optAdd.addOptGuarantyNext(optObj);

			})
	/**
	 * 保证措施管理 --- 新增 --- 关闭 按钮操作
	 */
	$("#btn_close").click(function() {
		window.parent.closeMenu('add_OptGuaranty');
	})

	/**
	 * 保证措施管理 --- 新增 --- 上一步 按钮操作
	 */
	$("#btn_previousStep").click(function() {
		$.zjm_optAdd.previousStep();
	})

	/**
	 * 保证措施管理 --- 新增 --- 下一步--- 保存 按钮
	 */
	$("#btn_addOptGuaranty").click(function() {
		$.zjm_optAdd.addSumbit();
	})

	$("#btn_addOptGuarantySave").click(function() {
		$.zjm_optAdd.addSave();
	})

	/**
	 * 保证措施管理 --- 新增 --- 下一步--- 保存并继续添加 按钮
	 */
	$("#btn_addOptGuarantyAgain").click(function() {
		$.zjm_optAdd.addSumbitAndAgain();
	})

	/**
	 * 新增 & 选择切换
	 */
	$('.nav-tabs li').click(function() {
		if ($(this).hasClass('active')) {
			// console.log('1223')
			return;
		}
		if ($(this).index() == 0) {
			// 新增功能
			$('#guarantyWrap').hide();
			$('#guarantyTypeDIV').show();
			$('#guarantyTypeDIV select').addClass('validate[required,maxSize[50]]')
			$('#btn_optTypesDIV select').addClass('validate[required]');
			$('#guarantyWrap input').removeClass('validate[required]')
			$('#btn_addOptGuarantySave').hide();
			$('#btn_addOptGuarantyNext').show()
			$('#OptGuarantyPage').html('新增保证措施')
			$(".highQuota").append("<div>"+
                                   "<label class='col-sm-2 control-label no-padding-right' for='form-input'>"+
	                               " 	<i class='icon-asterisk orange'></i>是否有最高保证额： "+
	                               " </label>"+
	                               " <div class='radio'>"+
	                               "     <label style='margin-top:-10px;'>"+
	                               "         <input type='radio' name='isGuarantyMaxSum' onchange='GuarantyMaxSum(this.value)' value='1' class='ace' checked='checked'>"+
	                               "         <span class='lbl'>是</span>"+
	                               "    </label>"+
	                               "    <label style='margin-top:-10px;'>"+
	                               "        <input type='radio' name='isGuarantyMaxSum' onchange='GuarantyMaxSum(this.value)' value='0' class='ace'>"+
	                               "        <span class='lbl'>否</span>"+
	                               "    </label>"+
	                               " </div>"+
                                   "</div>")
            $(".addBtnPerson").append("<button class='btn btn-xs btn-info' type='button' id='btn_addPerson' name='button'>新增</button>")
		} else {
		
			$('#btn_optTypesDIV select').removeClass('validate[required]');
			$('#btn_optTypesDIV').hide();
			// 选择功能
			$('#guarantyTypeDIV select').removeClass('validate[required,maxSize[50]]')
			$('#guarantyTypeDIV').hide();
			$('#guarantyWrap').show();
			$('#guarantyWrap input').addClass('validate[required]')
			$('#btn_addOptGuarantySave').show();
			$('#btn_addOptGuarantyNext').hide()
			$('#OptGuarantyPage').html('选择保证措施');
			$(".highQuota").children("div").remove()
			$(".addBtnPerson").children("button").remove()

		}
		$('#form_baseOne')[0].reset()
		$('.formError').hide()
		zjm.init();
	})

	/**
	 * 选择担保物
	 */
	$("#btn_chooseGuaranty").click(function() {

		var _btn_guarantyTypes = $('#btn_guarantyTypes').val(); // 保证方式
		var _client_ID = $("input[name='client_ID']").val()// 权属人
		console.log(_btn_guarantyTypes, _client_ID)

		var _optType = $("input[name='optType']:checked").val(); // 权属人类型
		$.zjm_optAdd.chooseGuaranty(_optType);
	})

});
