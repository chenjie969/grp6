/**
*保证措施管理--新增--保证方式：抵押--机器设备
*@author: wuhn
* 2017年7月14日 10:23:51
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
		isUseOther:isUseOther, // 是否存在第三方使用人
		initPage : initPage, // 初始化进入-- 是否存在第三方 和 第三方权属人类型处理
		initPageView:initPageView // // 初始化进入-- 是否存在第三方 和 第三方权属人类型处理 --- 查看页面
	};
	
	
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

					$("input[name='otherOwnerID']").val(selectContent[0].client_ID);//权属人id
					$("input[name='otherCreditCode']").val(selectContent[0].certificateCode);// 统一社会信用代码
					$("input[name='otherLegalPerson']").val(selectContent[0].legalPerson); //法定代表人
					$("input[name='otherLegalPhone']").val(selectContent[0].phoneOne); //法人联系方式
					$("input[name='otherLegalAddress']").val(selectContent[0].workAddress); //住所 (法人住所) 
					$("input[name='otherPersonNum']").val(selectContent[0].personNum); //身份证号码(自然人)
					$("input[name='otherPersonPhone']").val(selectContent[0].phone); //手机号(自然人)
					$("input[name='otherPersonAddress']").val(selectContent[0].houseAddress); //现住地址(自然人)
					$("input[name='otherPostCode']").val(selectContent[0].zipCode); //邮编
					$("input[name='otherFax']").val(selectContent[0].zipCode); //传真
					
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
	 * 是否存在第三方使用人 
	 */
	function isUseOther(radioValue){
		if(radioValue == 1){ //存在
			$("#isUseOtherDIV").show();
			$("#otherUseName").addClass("validate[required,maxSize[50]]");
		}else{
			$("#isUseOtherDIV").hide();
			$("#otherUseName").removeClass("validate[required,maxSize[50]]");
			$(".isUseOtherInput").val("");
		}
	}
	
	
	/**
	 *  初始化进入-- 是否存在第三方 和 第三方权属人类型处理
	 *  是否存在第三方 isOther
	 *  第三方权属人类型 otherType
	 */
	function initPage(isOther,otherType){
		if(isOther == 1){
			if(otherType == '01'){
				$(".person").hide();
				$(".legalPerson").show();
			}else{
				$(".person").show();
				$(".legalPerson").hide();
			}
		}else{
			$("#isHaveOtherDIV").hide();
		}
	}
	
	
	
	/**
	 * 初始化进入-- 是否存在第三方 和 第三方权属人类型处理
	 */
	function initPageView(initObj){

		if(initObj.isOther.indexOf('是') > -1){
			$("#isHaveOtherDIV").show();
			if(initObj.otherType.indexOf('法人') > -1){
				$(".legal_Type").show();
				$(".person_Type").hide();
			}else{
				$(".legal_Type").hide();
				$(".person_Type").show();
			}
		}else{
			$("#isHaveOtherDIV").hide();
		}
		
		if(initObj.isUseOther.indexOf('是') > -1){
			$("#isUseOtherDIV").show();
		}else{
			$("#isUseOtherDIV").hide();
		}
		
		switch (initObj.sortNum) {
			case '第一位':
				$(".prefixOne").hide();
				$(".prefixTwo").hide();
				$(".prefixThree").hide();
				break;
			case '第二位':
				$(".prefixOne").show();
				$(".prefixTwo").hide();
				$(".prefixThree").hide();
				break;
			case '第三位':
				$(".prefixOne").show();
				$(".prefixTwo").show();
				$(".prefixThree").hide();
				break;
			case '第四位':
				$(".prefixOne").show();
				$(".prefixTwo").show();
				$(".prefixThree").show();
				break;
			default:
				break;
		}
	}
	
	
})(jQuery,this);



$(function(){

	/**
	 *  是否代理人 
	 */
 
	var radioValue=$("input[name='isProxy']:checked").val();
	$.zjm_DYlandGuaranty.isProxy(radioValue);
	
	
	/**
	 * 我公司抵押权顺位
	 */
	var _val =$('#pledgeOrder option:selected').text();
	$.zjm_DYlandGuaranty.choosePledgeOrder(_val);
	
	
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
	 *  是否代理人 isProxy
	 */
	$(".isProxy").change(function(){
		var radioValue=$("input[name='isProxy']:checked").val();
		$.zjm_DYlandGuaranty.isProxy(radioValue);
	})
	
	/**
	 *  我公司抵押权顺位
	 */
	$("#pledgeOrder").change(function(){
		var _val =$('#pledgeOrder option:selected').text();
		$.zjm_DYlandGuaranty.choosePledgeOrder(_val);
	})
	
	/**
	 *  初始化进入-- 是否存在第三方 和 第三方权属人类型处理
	 */
	var isOther=$("input[name='isOther']:checked").val();
	var otherType=$("input[name='otherType']:checked").val();
	$.zjm_DYlandGuaranty.initPage (isOther,otherType);
	
	var radioValue=$("input[name='isUseOther']:checked").val();
	$.zjm_DYlandGuaranty.isUseOther(radioValue);
	
	
	
	/**
	 *  初始化进入-- 是否存在第三方 和 第三方权属人类型处理
	 */
	var isOther=$("#isOther").text(); //是否存在第三方
	var otherType=$("#otherType").text(); //第三方权属人类型
	var isUseOther=$("#isUseOther").text(); //是否存在第三方使用人
	var sortNum=$("#sortNum").text(); //我公司抵押权顺位
	var initObj={
			isOther:isOther,
			otherType:otherType,
			isUseOther:isUseOther,
			sortNum:sortNum
	}
	
	$.zjm_DYlandGuaranty.initPageView (initObj);
	
	
})