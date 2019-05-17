(function($,z){
	$.zjm_creditApplyAdd = {
		initPage:initPage,	//初始化页面
		isBusiLimit:isBusiLimit,	// 判断是否有品种限制
		addTableRow:addTableRow,	// 业务品种表格添加一行
		initCompanyTable:initCompanyTable,	//初始化企业客户列表
		initRelationMainTable:initRelationMainTable,	//初始化关联主体列表
		submitCreditForm:submitCreditForm,	//	提交授信表单（第一个表单）
		submitProjectForm:submitProjectForm,	//提交项目表单（第二个表单）
		rules:rules,	//自定义校验规则
		selectOrTree:selectOrTree,	//判断项目申请页的业务品种和合作机构的显示方式
		tableDataToObject:tableDataToObject,	//业务限制表格数据转换成对象
	};
	
	var isSubmitForm1Succeed = false;		//设置全局变量，判断第一个表单是否提交成功
	var resList=[];		//如果授信项有业务品种限制，并且有跟随的项目时，将限制明细表格封装成一个对象的数组，方便项目的业务品种和申请金额的校验
	
	/**
	 * 初始化页面，判断页面显示内容
	 */
	function initPage(){
		isBusiLimit();
		$("#div_addProject").hide();
		initSelectTree();
		addTableRow();
		$.zjm.rules = rules();	
	}
	
	/**
	 * 初始化各个下拉选择树
	 */
	function initSelectTree(){
		/*获取业务品种下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectBusiType_project").selectTreeWidgets({
					width : "47%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*获取合作机构下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectCooperation_project").selectTreeWidgets({
					width : "47%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*获取创建部门下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectAllDepartsTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectCreateDepart").selectTreeWidgets({
					width : "47%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*获取创建人下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectCreateUser").selectTreeWidgets({
					width : "47%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		/*设置日期初始值，默认为当天*/
		$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));
	}
	
	/**
	 * 业务品种表格添加一行
	 */
	function addTableRow(){
		var rowIndex = $("#hidden_rowIndex").val();
		$("#hidden_rowIndex").val(Number(rowIndex)+1);		//新增一行，行标加1
		$("#table_busiLimit").append("<tr>"+
									"	<td style='border:1px solid #ddd;'><!-- 业务品种 -->"+
									"		<div class='col-md-12 col-lg-12'>"+
									"			<div class='col-md-12 input-group selectBusiType_credit_busiLimit"+rowIndex+"'>"+
									"				<input  type='text'  class='form-control validate_busiType tdinput' autoField='busiTypeID_credit_busiLimit"+rowIndex+"' id='selectBusiType_credit_busiLimit"+rowIndex+"'  name='busiTypeName_credit_busiLimit"+rowIndex+"' readonly='readonly'/>"+
									"				<span class='input-group-addon '>"+
									"					<i class='icon-caret-down bigger-110'></i>"+
									"				</span>"+
									"			</div>"+
									"		</div>"+
									"	</td>"+
									"	<td style='border:1px solid #ddd;'><!-- 授信额度 -->"+
									"		<input type='text' style='width:80%;' class='validate_applySum tdinput' name='applySum_credit_busiLimit"+rowIndex+"'/>"+
									"	</td>"+
									"	<td style='border:1px solid #ddd;'><!-- 合作机构 -->"+
									"		<div class='col-md-12 col-lg-12'>"+
									"			<div class='col-md-12 input-group selectCooperation_credit_busiLimit"+rowIndex+"'>"+
									"				<input  type='text'  class='form-control tdinput validate[custom[noRepetition]]' autoField='cooperationID_credit_busiLimit"+rowIndex+"' id='selectCooperation_credit_busiLimit"+rowIndex+"' name='cooperationName_credit_busiLimit"+rowIndex+"'  readonly='readonly'/>"+
									"				<span class='input-group-addon '>"+
									"					<i class='icon-caret-down bigger-110'></i>"+
									"				</span>"+
									"			</div>"+
									"		</div>"+
									"	</td>"+	     			            
									"	<td style='border:1px solid #ddd;'><!-- 操作 -->"+
									"	    <button type='button' class='btn btn-xs btn-danger delBusiTableRow'>"+
									"	        <i class='icon-trash bigger-120'></i>"+
									"	    </button>"+
									"	</td>"+
									"</tr>");
		//为新添加的行设置业务品种下拉选择树	
		$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectBusiType_credit_busiLimit"+rowIndex).selectTreeWidgets({
					width : "88%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		//为新添加的行设置合作机构下拉选择树	
		$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectCooperation_credit_busiLimit"+rowIndex).selectTreeWidgets({
					width : "88%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
	}
	
	/**
	 * 初始化企业客户列表
	 */
	function initCompanyTable(){
		$("#selectListLabel").text("选择企业客户");
		$("#table_relationMainOrCompany").bootstrapTable('destroy');
		$('#table_relationMainOrCompany').bootstrapTable({
			method: 'post',
			singleSelect : true,// 单选checkbox
			columns : [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return index+1;}},
					{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
					{field : "clientName",title : '企业名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientName;}},
					{field : "legalPerson",title : '法定代表人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.legalPerson;}},
					{field : "certificateCode",title : '社会信用代码',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.certificateCode;}},
					{field : "createUserName",title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}}
				], //end columns
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/selectCompanyClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":"01"}});
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
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
	        showExport: false,                     //是否显示导出
	        exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/**
	 * 初始化关联主体列表
	 */
	function initRelationMainTable(){
		$("#selectListLabel").text("选择关联主体");
		$("#table_relationMainOrCompany").bootstrapTable('destroy');
		$('#table_relationMainOrCompany').bootstrapTable({
			method: 'post',
			singleSelect : true,// 单选checkbox
			columns: [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 		
					{field:"relationMainName",title: '主体名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationMainName;}},
					{field:"relationType",title: '关系类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationType=="01"?"集团关系":"关联关系";}},
					{field:"clientName",title: '主体客户',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.clientName;}},
					{field:"clientList",title: '关联企业',align: 'center',formatter: function (value, row, index) {
							var list = row.cmlist;
							var clientList = "";
							$(list).each(function(index,client){
								clientList += client.clientName + "<br/>";
							});
							return clientList;
						}},
					{field:"unit_uidName",title: '机构名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}},
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/selectRelationMainPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
		/*	queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":"01"}});
				return params;
			},*///前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
	        showExport: false,                     //是否显示导出
	        exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/**
	 * 判断是否有品种限制
	 */
	function isBusiLimit(){
		var val=$('input:radio[name="isBusiLimit"]:checked').val();
		if(val==1){	//有品种限制
			$("#div_busiLimit_true").show();
			if($("#table_busiLimit").find("tr").length>2){
				$("#div_isBlend").show(function(){
					$("#radio_isBlend_true").prop("checked",true);
				});
			}else{
				$("#div_isBlend").hide(function(){
					$("#div_isBlend input:radio[name='isBlend']").removeAttr("checked");
				});
			}
//			$("#div_busiLimit_false").hide();
		}else{	//没有品种限制
			$("#div_busiLimit_true").hide();
			$("#div_isBlend").hide(function(){
				$("#div_isBlend input:radio[name='isBlend']").removeAttr("checked");
			});
//			$("#div_busiLimit_false").show();
		}
	}
	
	/**
	 * 提交授信表单（第一个表单），使用ajax同步提交方式
	 */
	function submitCreditForm(source){
		/*提交表单时判断 限制品种与合作机构 单选项*/
		var val=$('input:radio[name="isBusiLimit"]:checked').val();
		if(val==0){	//没有品种限制，清空品种限制表格，防止数据误提交
			$("#hidden_busiTableDate").val("");
			$("#table_busiLimit tbody").empty();
			addTableRow();
		}else{	//有品种限制，读取表格数据，拼接到隐藏域;添加js校验属性
			$("#hidden_busiTableDate").val(busiLimitTableHandler());
			$("#table_busiLimit input.validate_busiType").addClass("validate[required,custom[noRepetition]]");
			$("#table_busiLimit input.validate_applySum").addClass("validate[required,custom[number],maxSize[18]]");
		}
		
		/*注册编辑验证引擎*/
		zjm.validata({formId:"form1_creditAdd"});
		tool.disabled("#btn_submitForm1");
		var queryContainer_form = $("#form1_creditAdd");
		if(queryContainer_form.validationEngine("validate")){
			/*在这里要判断表单1是否已提交过，根据隐藏域applyID是否有值判断，未提交过发送insertOneCreditApply方法，提交过就发送updateOneCreditApply方法
			var apply_ID = $("#hidden_applyID").val();
			var url = "";
			if(apply_ID != "" && apply_ID != null){
				url = "/project/credit/updateOneCreditApply";
			}else{
				url = "/project/credit/insertOneCreditApply";
			}*/
			$.ajax({type:'POST',async:false,url:"/project/credit/insertOneCreditApply",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj != null){
						$("#hidden_parentApplyID").val(data.obj);	//表单2隐藏值
						/*$("#form1SubmitFlag").val("true");*/
						isSubmitForm1Succeed = true;
						if(source=="submit1"){		//点击第一个页面的保存按钮并保存成功后，关闭页面，
							window.parent.closeMenu('add_creditApply');
						}
					}else{
						alert("保存失败！");
						tool.undisabled("#btn_submitForm1");
					}
		        }
			});
		}else{
			tool.undisabled("#btn_submitForm1");
		}
	}
	
	/**
	 * 提交项目表单（第二个表单）
	 */
	function submitProjectForm(){
		/*if($("#form1SubmitFlag").val()=="false"){	//该值为false，则第一个表单没有提交过，先提交第一个表单
			submitCreditForm("submit2");
		}*/
		/*注册编辑验证引擎*/
		zjm.validata({formId:"form2_projectAdd"});
		tool.disabled("#btn_submitForm2");
		var queryContainer_form = $("#form2_projectAdd");
		if(queryContainer_form.validationEngine("validate")){
			submitCreditForm("submit2");	//先提交第一个表单，设置点击来源是第二页的保存按钮
			if(isSubmitForm1Succeed){		//第一个表单同步方式提交，提交成功后，才提交第二个表单
				/*提交第二个表单前，将第一个表单中的经办部门，经办人，受理日期的内容填入到表单二的隐藏域中*/
				$("#hidden_departID").val($("#selectCreateDepart").next("input").val()).attr("name","departID");
				$("#hidden_departName").val($("#selectCreateDepart").val()).attr("name","departName");
				$("#hidden_createManID").val($("#selectCreateUser").next("input").val()).attr("name","createManID");
				$("#hidden_createManName").val($("#selectCreateUser").val()).attr("name","createManName");
				$("#hidden_createDate").val($("#date-picker-1").val()).attr("name","createDate");
				$.ajax({type:'POST',url:"/project/credit/insertOneCreditProjectApply",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj){	//保存成功，关闭页面
							window.parent.closeMenu('add_creditApply');
						}else{
							alert("保存2失败");
						}
					}
				});
			}
		}else{
			tool.undisabled("#btn_submitForm2");
		}
	}
	
	/**
	 * 限制品种与合作机构选择“是”，处理授信申请明细表格数据
	 */
	function busiLimitTableHandler(){
		var rowNum = $("#table_busiLimit").find("tr").length;	//表格行数，含表头th一行，实际数据行数应减一
		var colNum = $("#table_busiLimit").find("th").length;	//表格列数，含末尾操作一列，实际数据列数应减一
		var tableDate = "";
		for(var i=1; i<rowNum; i++){
			for(var j=0; j<colNum-1; j++){
				var tdinput = $("#table_busiLimit tr:eq("+i+") td:eq("+j+") .tdinput");
				tableDate += $(tdinput).val()+",";
				if(typeof $(tdinput).next().val() != "undefined"){
					tableDate += $(tdinput).next().val();
					if(j < colNum-2){
						tableDate += ",";
					}
				}
			}
			tableDate += ";";
		}
		return tableDate;
	}
	
	/**
	 * 页面验证规则，授信明细表里各业务品种的授信金额之和不能超过授信总金额
	 */
	function rules (){
		var allRules = {
			"isExceed":{
				"func":function(field,rules,i,options){
					var sum = 0;
					$("#table_busiLimit input.validate_applySum").each(function(index,a){
						sum += Number($(a).val());
					});
					if(sum == 0 || sum == Number($("#input_applyTotalSum").val())){		//sum==0,表示没有授信明细表格，不用校验该项
						return true;
					}else{
						return false;
					}
				},
				"alertText": "各业务品种的授信金额之和与授信总金额不相等",
			},
			
			"noRepetition":{
				"func":function(field,rules,i,options){
					for(var i=0; i<resList.length; i++){	//判断同一业务品种下是否有相同的合作机构，有的话校验不通过
						var basList = resList[i].basList;
						if(basList.length==1){
							continue;
						}else{
							var bankIDArr = new Array();
							var arrl = basList.length;
							for(var j=0; j<basList.length; j++){
								bankIDArr[j] = basList[j].bankID;
							}
							var bankIDStr = JSON.stringify(bankIDArr);
							var strl = bankIDStr.length;
							if(strl <= (4+(arrl-1)*3-(arrl-2)*32)){		//根据数组长度与转换成的字符串长度的比较，判断是否有两个空的合作机构
								return false
							}else{
								for (var j=0; j < bankIDArr.length; j++) {
									if (bankIDArr[j] != "" && bankIDStr.indexOf(bankIDArr[j]) != bankIDStr.lastIndexOf(bankIDArr[j])){
										return false;
									}
								};
							}
						}
					}
					return true;
				},
				"alertText": "业务品种与合作机构不能重复",
			},
			
			"lessThanCredit":{
				"func":function(field,rules,i,options){
					var projectApplySum = Number($("#applySum_project").val());		//项目申请时的申请金额
					if($('input:radio[name="isBusiLimit"]:checked').val()==0||$("#div_isBlend input[type='radio']:checked").val()==1){	//没有业务品种限制,或额度可以混用时,项目申请金额不能超过授信总金额
						if(projectApplySum<=Number($("#input_applyTotalSum").val())){
							return true;
						}else{
							return false;
						}
					}else{		//有业务品种限制
						var index = $("#div_busiType_select select").children("option:selected").attr("data-index");	//当前选中的业务品种
						if(index==undefined){
							return false;
						}
						var basList = resList[index].basList;	//该业务品种下合作机构的集合
						if($("#div_bank_select").is(":visible")){		//如果合作机构显示的是下拉框, 说明该业务品种下只有固定的合作机构,授信金额与表格中对应金额比较即可
							var projectBankID = $("#div_bank_select select").children("option:checked").val();	//当前显示的是下拉框,取选中项的值
							for(var i=0; i<basList.length; i++){
								if(projectBankID==basList[i].bankID){	
									if(projectApplySum <= basList[i].applySum){
										return true;
									}else{
										return false;
									}
								}
							}
						}
						/*如果合作机构显示的是树,授信明细表格中可能有两种情况:
						 * 	1.该业务品种只有一条信息,且合作机构为空;
						 *  2.该业务品种有多条信息,其中一条为空*/
						else{	
							if(basList.length==1){	//第1种情况
								if(projectApplySum <= basList[0].applySum){
									return true;
								}else{
									return false;
								}
							}else{	//第2种情况
								var projectBankID = $("#selectCooperation_project").next("input").val();	//取树的隐藏域中的值(合作机构的ID)
								if(projectBankID==""){		//项目中没有选合作机构, 申请金额小于该业务品种的总金额
									if(projectApplySum <= resList[index].resApplySum){
										return true;
									}else{
										return false;
									}
								}else{		//项目中选择了合作机构
									for(var i=0; i<basList.length; i++){	//遍历该业务品种下的合作机构集合
										if(projectBankID==basList[i].bankID){	//如果匹配到了.申请金额小于对应的授信金额
											if(projectApplySum <= basList[i].applySum){
												return true;
											}else{
												return false;
											}
										}	
									}
									//如果遍历结束仍没有匹配到,说明项目申请中的合作机构不在授信的合作机构中,申请金额小于该业务品种授信总金额
									if(projectApplySum <= resList[index].resApplySum){
										return true;
									}else{
										return false;
									}
								}
							}
						}
					}
				},
				"alertText": "项目申请金额不能超过授信金额",
			}
		};
		return allRules;
	};
	
	/**
	 * 
	 */
	function tableDataToObject(){
		/*将表格数据先封装到一个二维数组中, 因为有隐藏域, 每一个单元格在数组中占2个元素的位置
		 * 对应关系: 	tArray[i][0] 业务品种名称;	tArray[i][1] 业务品种ID
		 * 			tArray[i][2] 申请金额;		tArray[i][0] undefined
		 * 			tArray[i][0] 合作机构名称;	tArray[i][0] 合作机构ID
		 * */
		var rowNum = $("#table_busiLimit").find("tr").length;	//表格行数，含表头th一行，实际数据行数应减一
		var tArray = new Array();  //先声明一维
		for(var i=0; i<rowNum-1; i++){
			tArray[i]=new Array();  //声明二维，每一个一维数组里面的一个元素都是一个数组；
			for(var j=0; j<6; j+=2){
				var tdinput = $("#table_busiLimit tr:eq("+(i+1)+") td:eq("+(j/2)+") .tdinput");
				tArray[i][j] = $(tdinput).val();
				tArray[i][j+1] = $(tdinput).next("input").val();
			}
		}
		
		//将业务品种 tArray[i][1]作为一个数组, 去重后产生一个新数组 busiIDArr[]
		var tmp = {},busiIDArr = [];
		for (var i = 0, j = tArray.length; i < j; i++) {
	        if (!tmp[tArray[i][1]]) {
	            tmp[tArray[i][1]] = true;
	            busiIDArr.push(tArray[i][1]);
	        }
	    }
		
		/*把表格数据再次封装成一个对象数组的形式
		 * 格式为:  {	busiName:"固定资产贷款担保",
		 * 			busiID:"e4f6aef2e020417ca540780175a3bc79",
		 * 			resApplySum:300
		 * 			basList: [ {bankName:"浦发银行",
		 * 						bankID:"c0d5770187b44216b2d15722cba058f6",
		 * 						applySum:100},
		 * 					   {bankName:"工商银行",
		 * 						bankID:"d6b1c54aa37c433d9d5a1473af33a6b2",
		 * 						applySum:200}
		 * 					 ]
		 * 		  }
		 * */
		resList = [];	//清空结果集数组
		for(var i=0; i<busiIDArr.length; i++){
			var res = new Object();
			var resApplySum = 0;
			var basList = [];
			res.busiID = busiIDArr[i];
			for(var j=0; j<tArray.length; j++){
				if(busiIDArr[i]==tArray[j][1]){
					res.busiName = tArray[j][0];
					var bas = new Object();
					bas.applySum = Number(tArray[j][2]);
					bas.bankName = tArray[j][4];
					bas.bankID   = tArray[j][5];
					resApplySum += Number(bas.applySum);
					basList.push(bas);
				}
			}
			res.resApplySum = resApplySum;
			res.basList = basList;
			resList.push(res);
		}
	}
	/**
	 * 判断第二页 项目申请的业务品种的显示方式（下拉框或者树结构）  
	 */
	function selectOrTree(){
		if($('input:radio[name="isBusiLimit"]:checked').val()==0){	//没有业务品种限制，显示树结构，隐藏下拉框
			$("#div_busiType_tree").show(function(){
				$("#selectBusiType_project").addClass("validate[required]").attr({"name":"busiTypeName","autoField":"busiTypeID"});
			});
			$("#div_busiType_select").hide(function(){
				$("#div_busiType_select select").removeClass("validate[required]").removeAttr("name");
				$("#div_busiType_select select").next("input").removeAttr("name");
			});
		}else{		//有业务品种限制，显示下拉框，隐藏树结构
			$("#div_busiType_tree").hide(function(){
				$("#selectBusiType_project").removeClass("validate[required]").removeAttr("name autoField");
			});
			$("#div_busiType_select").show(function(){
				$("#div_busiType_select select").addClass("validate[required]").attr("name","busiTypeID");
				$("#div_busiType_select select").next("input").attr("name","busiTypeName");
			});
			
			//生成项目申请页面的业务品种下拉选择框
			var busiOpts = "<option value=''>请选择</option>";
			for(var i=0; i<resList.length; i++){
				busiOpts += "<option value='"+resList[i].busiID+"' data-index='"+i+"'>"+resList[i].busiName+"</option>";
			}
			$("#div_busiType_select select").empty().append(busiOpts);
			
			//给业务品种下拉框绑定改变事件，根据业务品种决定合作机构的显示方式
			$("#div_busiType_select select").change(function(){
				var index = $(this).children("option:selected").attr("data-index");
				if(index==null){
					$("#div_bank_tree").show(function(){
						$("#selectCooperation_project").attr({"name":"bankName","autoField":"bankID"})
					});
					$("#div_bank_select").hide(function(){
						$("#div_bank_select select").removeAttr("name");
						$("#div_bank_select select").next("input").removeAttr("name");
					});
					return ;
				}
				var basList = resList[index].basList;
				var bankOpts = "";
				var noBankFlag = false;
				for(var i=0; i<basList.length; i++){
					if(basList[i].bankID==""){
						noBankFlag = true;
						break;
					}else{
						bankOpts += "<option value='"+basList[i].bankID+"'>"+basList[i].bankName+"</option>";
					}
				}
				if(noBankFlag){		//没有指定合作机构，显示树
					$("#div_bank_tree").show(function(){
						$("#selectCooperation_project").attr({"name":"bankName","autoField":"bankID"})
					});
					$("#div_bank_select").hide(function(){
						$("#div_bank_select select").removeAttr("name");
						$("#div_bank_select select").next("input").removeAttr("name");
					});
				}else{				//有合作机构，显示下拉框
					$("#div_bank_tree").hide(function(){
						$("#selectCooperation_project").removeAttr("name autoField");
					});
					$("#div_bank_select").show(function(){
						$("#div_bank_select select").attr("name","bankID");
						$("#div_bank_select select").next("input").attr("name","bankName");
					});
					$("#div_bank_select select").empty().append(bankOpts);
					$("#div_bank_select select").next("input").val($("#div_bank_select select").children("option").eq(0).text());	//设置与合作机构下拉框绑定的隐藏域的值（合作机构名称）
				}
			});
		}
	}
})(jQuery, this);

$(function () {
	
	/**
	 * 文档加载的时候 读取
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_creditApplyAdd.initPage();
	};
	
	//监视 是否有品种限制 单选变化
	$('input:radio[name="isBusiLimit"]').change(function(){
		$.zjm_creditApplyAdd.isBusiLimit();
	});
	
	/**监视 所有下拉框的选项变化，即时把option的text写到隐藏input中
	 	<select name="...ID"></select>
	 	<input type="hidden" name="...Name"/>
	 */
	$("select[name]").change(function(){
		var s1 = $(this).attr("name");
		var s2 = $(this).children("option:selected").text();
		var s3 = s1.replace(/ID/,"Name");
		$("input[name='"+s3+"']").val(s2);
	});
	//授信项下项目申请登记页面的客户名称，client_ID和clientName,命名不一致，需要单独处理，且项目名称也要随之改变
	$("select[name='client_ID']").change(function(){
		var clientName = $(this).children("option:selected").text();
		$(this).next("input").val(clientName);
		$("#input_projectName").val(clientName);
	});
	
	// 下一步, 需要第一个页面先通过JS校验，才能跳转到第二个页面
	$("#btn_nextStep").click(function(){
		/*提交表单时判断 限制品种与合作机构 单选项*/
		var val=$('input:radio[name="isBusiLimit"]:checked').val();
		if(val==1){	//有品种限制，添加表格js校验属性
			$("#table_busiLimit input.validate_busiType").addClass("validate[required,custom[noRepetition]]");
			$("#table_busiLimit input.validate_applySum").addClass("validate[required,custom[number],maxSize[18]]");
		}else{	//没有品种限制，删除表格js校验属性
			$("#table_busiLimit input.validate_busiType").removeClass("validate[required,custom[noRepetition]]");
			$("#table_busiLimit input.validate_applySum").removeClass("validate[required,custom[number],maxSize[18]]");
		}
		$.zjm_creditApplyAdd.tableDataToObject();
		/*注册编辑验证引擎*/
		zjm.validata({formId:"form1_creditAdd"});
		if($("#form1_creditAdd").validationEngine("validate")){
			$("#div_addProject").show();
			$("#div_basicInfo").hide();
			$("#btn_nextStep").hide();
			$("#btn_previousStep").show();
			$("#btn_submitForm1").hide();
			$("#btn_submitForm2").show();
			$.zjm_creditApplyAdd.selectOrTree();
		}
	});
	
	// 上一步
	$("#btn_previousStep").click(function(){
		$("#div_addProject").hide();
		$("#div_basicInfo").show();
		$("#btn_nextStep").show();
		$("#btn_previousStep").hide();
		$("#btn_submitForm1").show();
		$("#btn_submitForm2").hide();
		/*$("#form1SubmitFlag").val("false");*/
	});
	
	//添加业务品种限制
	$("#btn_addBusiLimit").click(function(){
		var rowNum = $("#table_busiLimit").find("tr").length;
		//table_busiLimit至少有一行数据，点击添加行时，就会有两行数据，满足是否混用的条件，故直接显示
		$("#div_isBlend").show(function(){
			$('#radio_isBlend_true').prop('checked',true);
		});
		$.zjm_creditApplyAdd.addTableRow();
	});
	
	//删除一行业务品种限制
	$("#table_busiLimit tbody").on("click","button.delBusiTableRow",function(){
		// 删除前先取行数，如果小于等于两行，删除后就只剩表头一行，就要立即新增一个空行
		var rowNum = $("#table_busiLimit").find("tr").length;
		$(this).parent().parent().remove();
		if(rowNum <= 2){
			$.zjm_creditApplyAdd.addTableRow();
		}
		// 由于rowNum是删除行前的总行数，如果删除前小于等于3行，即删除后小于等于2行，说明是单一业务品种，不显示 是否混用 选项
		if(rowNum<=3){
			$("#div_isBlend").hide(function(){
				$("#div_isBlend input:radio[name='isBlend']").removeAttr("checked");
			});
		}
	});
	
	//点击“选择已有”，根据授信客户类型，分别弹出企业客户列表和关联主体列表
	$("#btn_showCompanyList").click(function(){
		$("#relationMainOrCompanyList").modal({keyboard:true});
		var type = $("#select_creditClientType option:selected").val();
		if(type=="single"){
			$.zjm_creditApplyAdd.initCompanyTable();
		}else if(type=="relation"){
			$.zjm_creditApplyAdd.initRelationMainTable();
		}
		$("#btn_listOK").click(function(){	//弹出列表点击确定，将选中的企业名称填入以下几个位置：	
			var selectContent = $("#table_relationMainOrCompany").bootstrapTable('getSelections');
			if(selectContent.length != 1){
				$("#pleaseSelectOne").modal({keyboard:true});
			}else{
				$("#relationMainOrCompanyList").modal("hide");
				$("input[name='clientName']").val(selectContent[0].clientName);	//1.授信项目信息-客户名称（不可修改）
				$("input[name='clientGUID']").val(selectContent[0].clientGUID);	// 客户唯一标识GUID	
																				// 隐藏input 授信项目信息-客户ID 单一法人企业ID:client_ID；主体企业ID：clientID
				$("input[name='projectName']").val(selectContent[0].clientName);//2.授信项目信息-授信项目名称
				$("input[name='projectName_project']").val(selectContent[0].clientName);//3.下一页 授信项下项目申请登记-项目名称
				//4.下一页 授信项下项目申请登记-客户名称（下拉框）
				/*判断是单一法人企业还是关联主体，如果是单一法人企业，客户名称不可修改;如果是关联主体，默认选中关联主体企业，可下拉选其他关联企业*/
				$("#select_relationCompany").empty();
				if(type=="relation"){
					$("#select_relationCompany").append("<option value='"+selectContent[0].clientID+"'>"+selectContent[0].clientName+"</option>");
					$.ajax({type:'POST',url:'/selectOneRelationMainById',data:JSON.stringify({"relationMain_ID":selectContent[0].relationMain_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {	
							$(data.obj.cmlist).each(function(index,client){
								$("#select_relationCompany").append("<option value='"+client.client_ID+"'>"+client.clientName+"</option>")
							});
				        }
					});
					$("input[name='client_ID']").val(selectContent[0].clientID);
					$("input[name='relationID']").val(selectContent[0].relationMain_ID);
					$("input[name='relationName']").val(selectContent[0].relationMainName);
				}else if(type=="single"){
					$("#select_relationCompany").append("<option value='"+selectContent[0].client_ID+"'>"+selectContent[0].clientName+"</option>");
					$("input[name='client_ID']").val(selectContent[0].client_ID);	
				}
			}
		});
		$("#relationMainOrCompanyList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $("#btn_listOK").unbind("click");
		});
	});
	
	//关闭按钮
	$("#btn_close").click(function(){
		window.parent.closeMenu('add_creditApply');
	});
	
	//点击 授信申请（第一页）的保存按钮
	$("#btn_submitForm1").click(function(){
		$.zjm_creditApplyAdd.submitCreditForm("submit1");
	});
	
	//点击 授信项下项目申请登记（第二页）的保存按钮
	$("#btn_submitForm2").click(function(){
		$.zjm_creditApplyAdd.submitProjectForm();
	});
	
});

