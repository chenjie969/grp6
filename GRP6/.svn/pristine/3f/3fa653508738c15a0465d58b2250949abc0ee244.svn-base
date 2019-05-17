(function($,z){
	$.zjm_projectAfter = {
			initTree :initTree,//初始化树下拉框;
			getSelectText : getSelectText,//获取下拉框值;
			addMainCompany:addMainCompany,//选择客户
			colseProjectAfterAddPage:colseProjectAfterAddPage,//关闭新增页面
			initClientTable:initClientTable,
			projectAfterAdd:projectAfterAdd,
			viewCompanyClient : viewCompanyClient,//查看企业客户详情;
			viewPersonClient : viewPersonClient,//查看个人客户详情;
			
	};
	function initTree(busiClass){
		//获取创建人下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
				$("#amanNameTree").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				
	        }
	        });
		//获取创建人下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#bmanNameTree").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			
		}
		});
		//获取创建部门下拉树;
		$.ajax({type:'POST',url:'/selectAllDepartsListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){		
			$("#allDepartsTree").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			
        }
        });
		//获取业务品种下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({"busiClass":busiClass}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data){	
				$("#busiSortDicTree").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
			}
		});
		//获取合作机构下拉树;
		$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data){	
				$("#cooperationTree").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
			}
		});
		
	
	};
	function getSelectText(selectID){
   	 var type = document.getElementById(selectID);     	
	 	 var pindex  = type.selectedIndex;
	 	
	 	 // 获取选中的下拉框的值(value)
	　　	 var pValue  =  type.options[pindex].value;　
	　　	 // 获取选中的下拉框的值(key)
	　　	  
	　　	  initfundChineseTree(pValue);
	　　	 var pText = type.options[pindex].text;
	　　	 
	　　	 var selectName = selectID.replace(/List/, "Name");
	　　    document.getElementById(selectName).value=pText;
	    if(type.id == "fundTypeList"){
		　　    if('41035961f6674ebcb34139c0e68bbe83'==pValue){
		　　    	 $(".fundNameGroup").children("div").remove();
		　　    	 $(".fundNameGroup").append(
		　　    			 "<div class='col-md-6'> "+
						 "	<div class='col-sm-6 col-md-6 input-group fundNameTree'> "+
						 "	     <input  type='text'  class='form-control validate[required]' autoField='fundNameID'   id='fundNameTree' click='fundNameTreeClick()' value='' dataValue='' name='fundName'  /> "+
						 "	     <span class='input-group-addon'> "+
						 "		   <i class='icon-caret-down bigger-110'></i> "+
						 "	     </span> "+
						 "   </div> "+
						 "</div> "
		　　    			 )
		　　    }else{
		　　    	 $(".fundNameGroup").children("div").remove();
		　　    	 $(".fundNameGroup").append(
		　　    			 "<div class='col-md-10'>"+
			             "	<input type='text' id='fundName' name='fundName'  class='col-md-5 col-sm-6 validate[required,maxSize[50]]' />"+
	    				 "</div>"
		　　    			 )
		　　    }
	　　    }
   };
   
   function initfundChineseTree(pValue){
	   var busiClass = $("#busiClass").val();
	   var pbankSortID = '';
	    //$("#fundChineseTree").val("");
	   if(pValue !== null || pValue !== undefined || pValue !== ''){
		   if('6bfe4484ca634faa9ceb3f7648547842'==pValue){//银行
			   pbankSortID = 'e7e282ee61b249eba0f64161fee6ff45';
		   }else if('9137331cd9c7455dbe3d3c0a662b06a6'==pValue){//个人
			   pbankSortID = '819ec5cb4d2640348dc3d06a78d4f08c';
		   }else if('41035961f6674ebcb34139c0e68bbe83'==pValue){//非银行
			   pbankSortID = '49618632db614f99a7e45c4f09c50c18';
		   }
		   //获取资金方下拉树;
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllFundListTree',data:JSON.stringify({"pbanksortid":pbankSortID,"banksortid":pbankSortID,"busiClass":busiClass, "fundType":"01"}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){
					$("#fundChineseTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
	   }
	   
   }
	function projectAfterAdd(){
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"projectAfterAdd_form"
		});
		tool.disabled(".btn_projectAfterAdd");
		if($("#projectAfterAdd_form").validationEngine("validate")){
			var queryContainer_form = $("#projectAfterAdd_form");
			$.ajax({type:'POST',url:'/project/project/insertOneProjectAfter',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$.zjm_projectAfter.colseProjectAfterAddPage();
					
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_projectAfterAdd");
		}	
	
	}
	//初始化企业客户参数;
    var initCompanyData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		   {field : 'clientName',title : '客户名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
						+ row.clientName + '</a>' ]
						.join('');
			},
			//企业名称绑定事件
			events : {
				'click .btn_client_view' : function(
						e, value, row, index) {
					$.zjm_projectAfter.viewCompanyClient(row);
							
				},
			}
		},
		{field : 'legalPerson',title : '法定代表人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.legalPerson;}},
		{field : 'certificateCode',title : '统一社会信用代码',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.certificateCode;}},
		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
	];
    //初始化个人客户(经营型)
	var initPersonData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		   {field : 'personName',title : '申请人姓名',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
						+ row.personName + '</a>' ]
						.join('');
			},
			//企业名称绑定事件
			events : {
				'click .btn_client_view' : function(
						e, value, row, index) {
					$.zjm_projectAfter.viewPersonClient(row);
							
				},
			}
		},
		{field : 'personNum',title : '身份证号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.personNum;}},
		{field : 'clientName',title : '经营实体名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientName;}},
		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
	];
	//初始化个人客户(消费型 )
	var initXPersonData =[{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		   {field : 'personName',title : '申请人姓名',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
						+ row.personName + '</a>' ]
						.join('');
			},
			//企业名称绑定事件
			events : {
				'click .btn_client_view' : function(
						e, value, row, index) {
					$.zjm_projectAfter.viewPersonClient(row);
							
				},
			}
		},
		{field : 'personNum',title : '身份证号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.personNum;}},
		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
	];
	
	/**初始化 客户信息列表***/
	function initClientTable(initData,url,clientTypeID){
		$("#client-table").bootstrapTable('destroy');
		$('#client-table').bootstrapTable({
			method: 'get',
			columns :initData, //end columns
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : true,//单选
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: url,//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":clientTypeID}});
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
	};
	
	function addMainCompany(clientType){
		if("个人客户（经营性）" == clientType){
			$.zjm_projectAfter.initClientTable(initPersonData,"/selectPersonClientPageTables","02");//初始化个人客户列表
		}else if("个人客户（消费性）"==clientType){
			$.zjm_projectAfter.initClientTable(initXPersonData,"/selectPersonClientPageTables","03");//初始化个人客户列表
		}else {
			$.zjm_projectAfter.initClientTable(initCompanyData,"/selectCompanyClientPageTables","01");//初始化企业客户列表
		}
		$("#clientList_ID").text("选择客户");
		$("#clientList").modal({keyboard:true});
		$(".btn_add").click(function(){
			var selectContent = $("#client-table").bootstrapTable('getSelections');		
			if("01" != selectContent[0].clientTypeID ){//个人客户			
				$("#clientID").val(selectContent[0].client_ID);
				$("#clientName").val(selectContent[0].personName);
				$("#projectName").val(selectContent[0].personName);
				$("#clientGUID").val(selectContent[0].clientGUID);
				$("#clientList").modal("hide");
			}else {//企业客户	
				$("#clientID").val(selectContent[0].client_ID);
				$("#clientName").val(selectContent[0].clientName);
				$("#projectName").val(selectContent[0].clientName);
				$("#clientGUID").val(selectContent[0].clientGUID);
				$("#clientList").modal("hide");
			}
			
		});
		$("#clientList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_add").unbind("click");
		});
	
	}
	function colseProjectAfterAddPage(){
		window.parent.closeMenu('projectAfterAdd_page');
	}
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type=view');
	};
	/***查看 个人客户信息 ***/
	function viewPersonClient(row){
		window.parent.openMenu('view_personClient'+row.client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+row.clientTypeID+'&type='+'view');
	}
	
})(jQuery, this);

$(function (){
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});

	 //初始化单笔业务
	window.onload = floaddata;
	function floaddata(){
		$.zjm_projectAfter.initTree($("#busiClass").val());	
	}
	
	//下拉框改变触发
	$(".selectList").change(function(){	
		var selectID=$(this).attr("id");	//获取当前下拉框的id;	
		$.zjm_projectAfter.getSelectText(selectID);
	});
	
	
	//选择客户
	$("#selectClient").click(function(){
		var clientType = $("#clientTypeName").val();//获取客户类型;
		$.zjm_projectAfter.addMainCompany(clientType);
	});
	
	
	$(".btn_projectAfterAdd").click(function(){
		$.zjm_projectAfter.projectAfterAdd();
	});
	$("#btn_closeProjectAfterAdd").click(function(){
		$.zjm_projectAfter.colseProjectAfterAddPage();
	});
	
	
	
	
});

