(function($,z){
	$.zjm_relationMainAdd = {
			initEditRelationMain:initEditRelationMain, 	//初始化修改页面数据
			initViewRelationMain:initViewRelationMain,	//初始化查看页面数据
			initTable:initTable,//初始化列表
			projectTypeSelect:projectTypeSelect,
			viewCompanyClient:viewCompanyClient,//客户详情查看
			addMainCompany:addMainCompany,//从企业列表中选择一个企业作为主体客户
			addRelationCompany:addRelationCompany,	//从企业列表中选择多个关联企业，并添加到下拉选择框中	
			addRelationMain:addRelationMain,	//将页面上的关联主体信息保存至数据库
			submitform:submitform	//提交form表单，功能函数
	};

	/**初始化 企业客户信息列表***/
	function initTable(){
		$("#companyClient-table").bootstrapTable('destroy');
		$('#companyClient-table').bootstrapTable({
			method: 'get',
//			singleSelect : true,// 单选checkbox
			columns : [
					{
						field : 'checked',
						checkbox : true,
						align : 'center',
						formatter : function(value, row, index) {
							return ;
						}
					},
					{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
					{
						field : "clientName",
						title : '企业名称',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							return [ '<a class="btn_client_view" href="javascript:void(0)">'
									+ row.clientName + '</a>' ]
									.join('');
						},
						//企业名称绑定事件
						events : {
							'click .btn_client_view' : function(
									e, value, row, index) {
								$.zjm_relationMainAdd.viewCompanyClient(row);
										
							},
						}
					},
					{
						field : "fullAreaName",
						title : '所属区域',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							var  areaCode= row.fullAreaName;
							if(areaCode == null){
								areaCode="<空>";
							}
							return areaCode;
						}
					},
					{
						field : "fullTradeName",
						title : '所属行业',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							return row.fullTradeName;
						}
					},
					{
						field : "natureName",
						title : '企业性质',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							return row.natureName;
						}
					},
					{
						field : "legalPerson",
						title : '法定代表人',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							return row.legalPerson;
						}
					},
					{
						field : "contactOne",
						title : '联系人',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							return row.contactOne;
						}
					},
					{
						field : "phoneOne",
						title : '联系方式',
						align : 'center',
						sortable : "true",
						formatter : function(value, row, index) {
							return row.phoneOne;
						}
					}
				], //end columns
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>企业名称:</b> ' + row.clientName + '</p>');
			        html.push('<p><b>所属区域:</b> ' + tool.isNull(row.fullAreaName,"") + '</p>');
			        html.push('<p><b>所属行业:</b> ' + tool.isNull(row.fullTradeName,"") + '</p>');
			        html.push('<p><b>企业性质:</b> ' + tool.isNull(row.natureName,"") + '</p>');
			        html.push('<p><b>法定代表人:</b> ' + tool.isNull(row.legalPerson,"") + '</p>');
			        html.push('<p><b>联系人:</b> ' + tool.isNull(row.contactOne,"") + '</p>');
			        html.push('<p><b>联系方式:</b> ' + tool.isNull(row.phoneOne,"") + '</p>');
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
	
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type=view');
	}
	
	/**修改页面，初始化数据**/
	function initEditRelationMain(mid){
		$.ajax({type:'POST',url:'/selectOneRelationMainById',data:JSON.stringify({"relationMain_ID":mid}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				var relationMain = data.obj;
				$("#mainName").val(relationMain.relationMainName);
				/*$("#guarantySum").val(relationMain.guarantySum);
				$("#guarantyEntrustSum").val(relationMain.guarantyEntrustSum);*/
				$("#creditorSum").val(relationMain.creditorSum);
				/*$("#entrustSum").val(relationMain.entrustSum);*/
				$("#addMainForm textarea").val(relationMain.remark);
				$(relationMain.cmlist).each(function(index,cm){
					$("#relationCompany").append("<option value='"+cm.client_ID+"'>"+cm.clientName+"</option>");
				});
				$("#relationMain_ID").val(relationMain.relationMain_ID);	//这个是隐藏项
				$("#clientID").val(relationMain.clientID);
				$("#beforeMainClientID").val(relationMain.clientID);
				$("#clientName").val(relationMain.clientName);
				$("#clientGUID").val(relationMain.clientGUID);
				$("#relationTypeName").val(relationMain.relationTypeName);
				//设置关联类型下拉选择框 
				$(".relationTypeID").find("option").each(function(index,opt){
					if($(opt).val() == relationMain.relationTypeID){
						$(opt).prop("selected",true);
					}
				});
				$("#projectTypeName").val(relationMain.projectTypeName);
				//设置项目类型名称下拉选择框 
				$(".projectTypeID").find("option").each(function(index,opt){
					if($(opt).val() == relationMain.projectTypeID){
						$(opt).prop("selected",true);
					}
				});
				
				var realyProjectTypeName = $(".projectTypeID").find("option:selected").text();//防止只有projectTypeName 为空但是有projectTypeID 的情况
				$("#projectTypeName").val(realyProjectTypeName);
			}
		});
	}
	/**查看页面，初始化数据**/
	function initViewRelationMain(mid){
		/*$.ajax({type:'POST',url:'/selectOneRelationMainById',data:JSON.stringify({"relationMain_ID":mid}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				var relationMain = data.obj;
				$("#relationMain_ID").val(relationMain.relationMain_ID);	//这个是隐藏项
				$("#mainName").val(relationMain.relationMainName).attr("readonly",true);
				$("#addMainForm textarea").val(relationMain.remark).attr("readonly",true);
				$(relationMain.cmlist).each(function(index,cm){
					$("#relationCompany").append("<option value='"+cm.client_ID+"'>"+cm.clientName+"</option>");
				});
				$(".buttonDiv").hide();		//隐藏保存按钮
				
			}
		});*/
	}
	
	/**
	 * 添加主体客户
	 */
	function addMainCompany(){
		$.zjm_relationMainAdd.initTable();//初始化列表
		$("#relationMainLabel").text("选择主体客户");
		$("#companyList").modal({keyboard:true});
		$(".btn_add").click(function(){
			var selectContent = $("#companyClient-table").bootstrapTable('getSelections');
			if(selectContent.length != 1){
				$("#pleaseSelectOne").modal({keyboard:true});
			}else{
				$("#clientID").val(selectContent[0].client_ID);
				$("#clientName").val(selectContent[0].clientName);
				$("#clientGUID").val(selectContent[0].clientGUID);
				// 同时更改关联企业中的主体客户
				var beforeID = $("#beforeMainClientID").val();	//获取之前的主体客户ID
				$("#relationCompany option[value='"+beforeID+"']").remove();	//删除关联企业列表中之前的主体客户
				$("#relationCompany").prepend("<option value='"+selectContent[0].client_ID+"'>"+selectContent[0].clientName+"</option>");
				$("#beforeMainClientID").val(selectContent[0].client_ID);	//更新记录的旧主体客户ID
				
				$("#companyList").modal("hide");
			}
		});
		$("#companyList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_add").unbind("click");
		});
	}
	
	/**添加关联企业**/
	function addRelationCompany(){
		$.zjm_relationMainAdd.initTable();//初始化列表
		$("#relationMainLabel").text("选择关联企业");
		$("#companyList").modal({keyboard:true});
		$(".btn_add").click(function(){
			var selectContent = $("#companyClient-table").bootstrapTable('getSelections');
			if(selectContent.length == 0){
				$("#pleaseSelectOne").modal({keyboard:true});
			}else{
				for(var i=0;i<selectContent.length;i++){
					var flag = true;
					$("#relationCompany option").each(function(index,option){		//遍历已选关联企业select
						if($(option).val()==selectContent[i].client_ID){
							flag = false;		//如果table中勾选的企业已经存在于已选关联企业select中，置标志位flag=FALSE
						}
					});
					if(flag){		//flag为FALSE时，说明有重复，不追加option元素
						$("#relationCompany").append("<option value='"+selectContent[i].client_ID+"'>"+selectContent[i].clientName+"</option>");
					}
				}
				$("#companyList").modal("hide");
			}
		});
		$("#companyList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_add").unbind("click");
		});
	}
	
	/**将页面上的关联主体信息保存至数据库**/
	function addRelationMain(){
		zjm.init();
		zjm.validata({formId:"addMainForm"});
		tool.disabled(".btn_submit");
		/*后台发送请求 , 根据打开页面时是否接收了relationMain_ID，分为 新增 和 修改 两种操作，分别发送不同的ajax请求*/
		var url = "";
		if(tool.getUrlParam('relationMain_ID') == null){	//新增操作，要校验主体名重复
			url = "/insertOneRelationMain";
			if($("#addMainForm").validationEngine("validate")){
				if(zjm.ajaxValidata("mainName","/isExistMainName",JSON.stringify($("#addMainForm").serializeJson()),"该主体名已存在！")){
					$.zjm_relationMainAdd.submitform(url);
				}else{
					tool.undisabled(".btn_submit");
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		}else{				//修改操作
			url = "/updateOneRelationMain";
			if($("#addMainForm").validationEngine("validate")){
				alert(JSON.stringify($("#addMainForm").serializeJson()));
				if(zjm.ajaxValidata("mainName","/isExistMainName",JSON.stringify($("#addMainForm").serializeJson()),"该主体名已存在！")){
					$.zjm_relationMainAdd.submitform(url);
				}else{
					tool.undisabled(".btn_submit");
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		}
		
	}
	/* 提交Form表单，处理提交数据*/
	function submitform(url){
		/*将select中所有的option遍历，取value和text，拼接成字符串，传递给action*/	
		var ids = "";
		var names = "";
		$("#relationCompany option").each(function(index,op){
			ids += $(op).val()+",";
			names += $(op).text()+",";
		});
		$("#clientIDs").val(ids);
		$("#clientNames").val(names);
		$.ajax({type:'POST',url:url,data:JSON.stringify($("#addMainForm").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					if(tool.getUrlParam('type')=="add"){
						window.parent.closeMenu('relationMainAdd');
					}else if(tool.getUrlParam('type')=="edit"){
						window.parent.closeMenu('relationMainEdit'+tool.getUrlParam('relationMain_ID'));
					}
				}else{
					alert("保存失败！");		//暂时弹窗提示，随后要改成跳转到错误页面
				}
			}
		});
	}
	
	function projectTypeSelect(btnclass,url,datas){
		$.ajax({type:'POST',url:url,data:JSON.stringify(datas),async:false,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$("."+btnclass).empty();
			if(data.obj!=null)
			$.each(data.obj, function(key1, value1){
				$.each(value1, function(key2, value2){
					if(key2=='504eb19d1e4440deb70934ee195c559e'){
						$("."+btnclass).append("<option selected value='"+key2+"'>"+value2+"</option>");
					}else{
						$("."+btnclass).append("<option value='"+key2+"'>"+value2+"</option>");
					}
				});
			});
	        }
		});
	}
	
	
})(jQuery, this); 

$(function () {
	/**
	 * 文档加载的时候读取页面传来的relationMain_ID
	 * relationMain_ID = null，说明是新增页面
	 * 否则是修改页面，要加载主体已有信息
	 */
	window.onload = floaddata;
	var type = tool.getUrlParam('type');
	function floaddata() {
		zjm.dataViewValSelect("relationTypeID", "/selectDicTypeListJSON", {"dicTypePID" : 'e01df7a312004925ba2b6aec987ba4a9'});/*获取关系类型下拉框*/
		$.zjm_relationMainAdd.projectTypeSelect("projectTypeID", "/selectDicTypeListJSON", {"dicTypePID" : '7262e0635f4a49dfa4b03a9619ad4c19'});/*获取项目类型名称下拉框*/
		if(type=="edit"){
			$.zjm_relationMainAdd.initEditRelationMain(tool.getUrlParam('relationMain_ID'));
			$("#closeRelationMainAdd").click(function(){
				window.parent.closeMenu('relationMainEdit'+tool.getUrlParam('relationMain_ID'));
			});
		}/*else if(type=="view"){
			$.zjm_relationMainAdd.initViewRelationMain(tool.getUrlParam('relationMain_ID'));
			$("#closeRelationMainAdd").click(function(){
				window.parent.closeMenu('relationMainView'+tool.getUrlParam('relationMain_ID'));
			});
		}*/else{
			$("#closeRelationMainAdd").click(function(){
				window.parent.closeMenu('relationMainAdd');
			});
		}
	};
	
	/**
	 * 弹出模态窗显示企业列表-选择关联企业
	 */
	$("#selectCompany").click(function(){
		$.zjm_relationMainAdd.addRelationCompany();
	});
	/**
	 * 弹出模态窗显示企业列表-选择主体客户
	 */
	$("#selectMain").click(function(){
		$.zjm_relationMainAdd.addMainCompany();
	});
	
	/**
	 * 删除选中的关联企业, 如果是主体客户则不能删除
	 */
	$("#deleteCompany").click(function(){
		var beforeID = $("#beforeMainClientID").val();
		$("#relationCompany option:selected").each(function(){
			if($(this).val()!=beforeID){
				$(this).remove();
			}
		});
	});
	
	/**
	 * 点击保存，将表单数据更新到数据库
	 */
	$(".btn-submit").click(function(){
		$.zjm_relationMainAdd.addRelationMain();
	});
	
	/**
	 * 监视关系类型下拉框的取值变化，每次改变后将option的文本内容复制到隐藏域中
	 */
	$(".relationTypeID").change(function () {  
        var ss = $(this).children('option:selected').text();
        $("#relationTypeName").val(ss);
	});

	/**
	 * 监视项目类型名称下拉框的取值变化，每次改变后将option的文本内容复制到隐藏域中
	 */
	$(".projectTypeID").change(function () {  
        var ss = $(this).children('option:selected').text();
        $("#projectTypeName").val(ss);
	});
});

