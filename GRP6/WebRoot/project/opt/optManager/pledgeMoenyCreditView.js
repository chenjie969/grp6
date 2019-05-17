/**
*保证措施管理--新增--保证方式：抵押--土地
*@author: wuhn
* 2017年7月8日 22:44:31
*  (function($,z){ ... })(jQuery,this);
*/

(function($,z){
	$.zjm_DYlandGuaranty={
		isHaveOther:isHaveOther,// 是否存在第三方
		chooseOwnerType:chooseOwnerType,// 是否存在第三方 -- 是 -- 第三方权属人类型
		choosePropOwner:choosePropOwner,// 是否存在第三方 -- 是 --- 选择权属人 
		isProxy:isProxy,// 是否代理人
		landValueCount:	landValueCount,//抵押土地抵押价值  计算
		initOwnerTable:initOwnerTable, // 是否存在第三方 -- 是 --- 选择权属人  -- 初始化权属人 企业客户  选择列表
		initOwnerPersonTable:initOwnerPersonTable, // 是否存在第三方 -- 是 --- 选择权属人  -- 初始化权属人 个人客户 选择列表
		choosePledgeOrder:choosePledgeOrder, // 我公司抵押权顺位
		submitOptGuaranty:submitOptGuaranty ,// 修改页面-- 保存按钮 
		closeMenu:closeMenu,  // 修改页面 -- 关闭按钮 
		isMarried:isMarried, // 是否已婚
		/*getDepositTypeName:getDepositTypeName// 获取保证金类型名字 
*/	};
	
	/**
	 * 是否存在第三方
	 */
	function  isHaveOther(_val){
		if(_val == '1'){
			$(".legalPersonInput").addClass("validate[required,maxSize[50]]"); //默认显示权属人类型为:法人;给法定代表人 等5个字段添加验证属性
			$("#isHaveOtherDIV").show();
		}else{
			$(".legalPersonInput").removeClass("validate[required,maxSize[50]]"); //移除 法人 验证属性
			$(".personInput").removeClass("validate[required,maxSize[50]]"); //移除  自然人 验证属性
			$(".personInput").val("");//清空自然人文本框内容
			$(".legalPersonInput").val("");//清空 法人文本框内容
			$("#otherOwner").val("");//清空 权属人本框内容
			$("#otherOwnerID").val("");//清空隐藏权属人id本框内容
			$("#isHaveOtherDIV").hide();
		}
	}
	
	/**
	 *  是否存在第三方 -- 是 -- 第三方权属人类型
	 */
	function  chooseOwnerType(_val){
		
		if(_val == '01'){ //企业
			$(".person").hide();
			$(".legalPerson").show();
			
			$(".personInput").removeClass("validate[required,maxSize[50]]");// 移除自然人的验证属性
			$(".personInput").val("");//清空自然人文本框内容
			$("#otherOwner").val(""); // 权属人 字段清空
			$("#otherOwnerID").val("");//清空隐藏权属人id本框内容
			$(".legalPersonInput").addClass("validate[required,maxSize[50]]"); //添加法人验证信息
			
		}else if(_val == '03'){ //自然人
			$(".legalPerson").hide();
			$(".person").show();
			
			$(".legalPersonInput").removeClass("validate[required,maxSize[50]]");// 移除法人 的验证属性
			$(".legalPersonInput").val("");//清空 法人 文本框内容
			$("#otherOwner").val(""); // 权属人 字段清空
			$("#otherOwnerID").val("");//清空隐藏权属人id本框内容
			$(".personInput").addClass("validate[required,maxSize[50]]"); //添加自然人验证信息
			
		}
	}
	
	/**
	 *   是否存在第三方 -- 是 --- 选择权属人 
	 */
	function  choosePropOwner(radioValue){
		$("#relationMainOrCompanyList").modal({keyboard:true});
		if(radioValue == '01'){ //权属人类型 01  企业客户
			$.zjm_DYlandGuaranty.initOwnerTable();
		}else{ // 02 ，03  个人客户
			$.zjm_DYlandGuaranty.initOwnerPersonTable();
		}
		
		$("#btn_listOK").click(function(){	//弹出列表点击确定，将选中的企业名称填入以下几个位置：	
			var selectContent = $("#table_relationMainOrCompany").bootstrapTable('getSelections');
			if(selectContent.length != 1){
				$("#pleaseSelectOne").modal({keyboard:true});
			}else{
					$("#relationMainOrCompanyList").modal("hide");
					$("input[name='otherOwner']").val(selectContent[0].clientName);	//权属人名称
					
					if( selectContent[0].clientTypeID == '01'){
						$("input[name='otherOwner']").val(selectContent[0].clientName);	//权属人名称
					}else{
						$("input[name='otherOwner']").val(selectContent[0].personName);	//权属人名称
					} 

				
				}
			});
		$("#relationMainOrCompanyList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $("#btn_listOK").unbind("click");
		});
	}
	
	/**
	 *   是否代理人
	 */
	function  isProxy(_val){
		if(_val == '1'){
			$("#isProxyDIV").show();
		}else{
			$("#isProxyDIV").hide();
			$(".proxyInput").val("");
		}	
	}
	
	/**
	 * 抵押土地抵押价值  计算
	 */
	function  landValueCount(){
		
	}
	
	/**
	 *  -- 初始化权属人 企业客户 选择列表
	 */
	function initOwnerTable(){
		$("#selectListLabel").text("选择权属人");
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
	 *  选择权属人  -- 初始化权属人 个人客户 选择列表
	 */
	function initOwnerPersonTable(){
		$("#selectListLabel").text("选择权属人");
		$("#table_relationMainOrCompany").bootstrapTable('destroy');
		$('#table_relationMainOrCompany').bootstrapTable({
			method: 'post',
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
			} ], //end columns
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
				 $.extend(params, {"queryCondition":{"clientTypeID":"02,03"}});
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
	 * 我公司抵押权顺位 
	 */
	function  choosePledgeOrder(_val){
		switch (_val) {
		case "第一位":
			$(".prefixOne").hide();
			$(".prefixTwo").hide();
			$(".prefixThree").hide();
			$(".prefixOneInput").val("");
			$(".prefixTwoInput").val("");
			$(".prefixThreeInput").val("");
			$("#actualValue").val("");//我公司抵押顺位实际余值
			break;
		case "第二位":
			$(".prefixOne").show();
			$(".prefixTwo").hide();
			$(".prefixThree").hide();
			$(".prefixTwoInput").val("");
			$(".prefixThreeInput").val("");
			break;
		case "第三位":
			$(".prefixOne").show();
			$(".prefixTwo").show();
			$(".prefixThree").hide();
			$(".prefixThreeInput").val("");
			break;
		case "第四位":
			$(".prefixOne").show();
			$(".prefixTwo").show();
			$(".prefixThree").show();
			break;
		default:
			break;
		}
	}
	
	/**
	 * 修改页面-- 保存按钮 
	 */
	function submitOptGuaranty(optGuaranty_ID){
		/** 注册编辑验证引擎 */
		zjm.init();
		zjm.validata({ formId : "form_baseTwo" });
		if ($("#form_baseTwo").validationEngine("validate")) {
				tool.disabled("#btn_updateptGuaranty");
			var queryContainer_form=$("#form_baseTwo");
			var formData = JSON.stringify(queryContainer_form.serializeJson());
			$.ajax({
				type:'POST',
				url:'/optGuarantyAction/updateOneOptGuarantyInfo',
				data:formData ,
				contentType: 'application/json; charset=UTF-8',
				dataType:'json' ,
				success:function(data){
					if(data.obj){
						window.parent.closeMenu('update_OptGuaranty'+optGuaranty_ID);
					}else{
						alert("保存失败...");
					}
				} 
			});
			
		}else{
			tool.undisabled("#btn_updateptGuaranty"); // 下一步按钮 可用
			return ;
		}	
	}
	
	/**
	 * 修改页面 -- 关闭按钮 
	 */
	function closeMenu(optGuaranty_ID){
		window.parent.closeMenu('update_OptGuaranty'+optGuaranty_ID);
	}
	
	/**
	 * 是否已婚
	 */
	function isMarried (val){
		if(val == '1'){
			$("#isMarriedDIV").show();
			$(".marriedInput").addClass('validate[required,maxSize[50]]');
		}else{
			$("#isMarriedDIV").hide();
			$(".marriedInput").removeClass('validate[required,maxSize[50]]');
			$(".marriedInput").val("");
		}
	}
	
/*	function getDepositTypeName(){
		var depositTypeId = $("#depositTypeId").val();
		alter(depositTypeId);
		$.ajax({
			type:'POST',
			url:'/selectOneDicTypeInfo',
			data: '{"dicTypeID","'+depositTypeId+'"}',
			contentType: 'application/json; charset=UTF-8',
			dataType:'json' ,
			success:function(data){
				if(data.obj){
					console.log(data.obj);
				}
			} 
		});
	}
	*/
})(jQuery,this);



$(function(){
	
	
	
	var isProxy=	$("input[name='isMarried']:checked").val();
	if(isProxy == 0){
		$("#isMarriedDIV").hide();
	}else{
		$(".marriedInput").addClass('validate[required,maxSize[50]]');
	}
	/**
	 * 是否存在第三方 -- 是 -- 第三方权属人类型 -- 自然人 -- 隐藏
	 */
	$(".person").hide();
	
	/**
	 *  是否存在第三方 
	 */
	$(".isOther").change(function(){ 
		var radioValue=$("input[name='isOther']:checked").val();
		$.zjm_DYlandGuaranty.isHaveOther(radioValue);
	})
	
	/**
	 *  是否存在第三方 -- 是 -- 第三方权属人类型
	 */
	$(".otherType").change(function(){ 
		var radioValue=$("input[name='otherType']:checked").val();
		$.zjm_DYlandGuaranty.chooseOwnerType(radioValue);
	})
	
	/**
	 *  是否存在第三方 -- 是 --- 选择权属人 
	 */
	$("#btn_ChooseOwnerType").click(function(){
		var radioValue=$("input[name='otherType']:checked").val();
		$.zjm_DYlandGuaranty.choosePropOwner(radioValue);
	})
	
	/**
	 *  是否已婚
	 */
	$(".isMarried").change(function(){
		var radioValue=$("input[name='isMarried']:checked").val();
		$.zjm_DYlandGuaranty.isMarried (radioValue);
	})
	
	/**
	 * 修改页面-- 保存按钮 
	 */
	$("#btn_updateptGuaranty").click(function(){
		var optGuaranty_ID=$("#optGuaranty_ID").val();
		$.zjm_DYlandGuaranty.submitOptGuaranty(optGuaranty_ID);
	})
	
	/**
	 *  修改页面 -- 关闭按钮 
	 */
	$("#btn_close").click(function(){
		var optGuaranty_ID=$("#optGuaranty_ID").val();
		$.zjm_DYlandGuaranty.closeMenu(optGuaranty_ID);
	})
	
	
	//获取并设置保证金
	var depositTypeId = $("#depositTypeId").val();
	$.ajax({
		type:'POST',
		url:'/selectOneDicTypeInfo',
		data:'{"dicTypeID":"'+depositTypeId+'"}',
		contentType: 'application/json; charset=UTF-8',
		dataType:'json' ,
		success:function(data){
			if(data.obj){
				$("#dic_depositTypeName").html(data.obj.dicTypeName);
			}
		} 
	});
	
})