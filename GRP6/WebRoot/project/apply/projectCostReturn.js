(function($,z){
	$.zjm_projectCostReturn = {
			getSelectText : getSelectText,//获取下拉框值;
			closeProjectCostReturnAddPage:closeProjectCostReturnAddPage,//关闭新增页面
			initCostReturnTable:initCostReturnTable,
			projectCostReturnAdd:projectCostReturnAdd,
//			viewCompanyClient : viewCompanyClient,//查看企业客户详情;
//			viewPersonClient : viewPersonClient,//查看个人客户详情;
			projectCostReturnEdit : projectCostReturnEdit,
			projectDelayDel:projectDelayDel,
	};
	
	function closeProjectCostReturnAddPage(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu('projectCostReturn'+project_ID);
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
   };
   
   function initfundChineseTree(pValue){
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
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllFundListTree',data:JSON.stringify({"pbanksortid":pbankSortID,"banksortid":pbankSortID}),contentType:'application/json; charset=UTF-8',dataType:'json',
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
	function projectCostReturnAdd(){
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"projectCostRetuen_form"
		});
		tool.disabled(".btn_projectCostReturnAdd");
		if($("#projectCostRetuen_form").validationEngine("validate")){
			var queryContainer_form = $("#projectCostRetuen_form");
			$.ajax({type:'POST',url:'/project/costReturn/insertOneCostReturn',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$.zjm_projectCostReturn.closeProjectCostReturnAddPage();
					window.location.reload();
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_projectCostReturnAdd");
		}	
	
	}
//	//初始化企业客户参数;
//    var initCompanyData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
//		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
//		   {field : 'clientName',title : '客户名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
//						+ row.clientName + '</a>' ]
//						.join('');
//			},
//			//企业名称绑定事件
//			events : {
//				'click .btn_client_view' : function(
//						e, value, row, index) {
//					$.zjm_projectAfter.viewCompanyClient(row);
//							
//				},
//			}
//		},
//		{field : 'legalPerson',title : '法定代表人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.legalPerson;}},
//		{field : 'certificateCode',title : '统一社会信用代码',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.certificateCode;}},
//		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
//	];
//    //初始化个人客户(经营型)
//	var initPersonData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
//		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
//		   {field : 'personName',title : '申请人姓名',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
//						+ row.personName + '</a>' ]
//						.join('');
//			},
//			//企业名称绑定事件
//			events : {
//				'click .btn_client_view' : function(
//						e, value, row, index) {
//					$.zjm_projectAfter.viewPersonClient(row);
//							
//				},
//			}
//		},
//		{field : 'personNum',title : '身份证号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.personNum;}},
//		{field : 'clientName',title : '经营实体名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientName;}},
//		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
//	];
//	//初始化个人客户(消费型 )
//	var initXPersonData =[{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
//		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
//		   {field : 'personName',title : '申请人姓名',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
//						+ row.personName + '</a>' ]
//						.join('');
//			},
//			//企业名称绑定事件
//			events : {
//				'click .btn_client_view' : function(
//						e, value, row, index) {
//					$.zjm_projectAfter.viewPersonClient(row);
//							
//				},
//			}
//		},
//		{field : 'personNum',title : '身份证号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.personNum;}},
//		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
//	];
//	

	
	
	/**初始化-债权-列表***/
	function initCostReturnTable(){
		$('#projectCostReturn_table').bootstrapTable('destroy');
		$('#projectCostReturn_table').bootstrapTable({
			method: 'post',
			columns: [	
				//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"costTypeName",title: '费用名称',align: 'center',formatter: function (value, row, index) { return row.costTypeName;}},
						{field:"returnCostSum",title: '金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.returnCostSum;}},
						{field:"returnCostDate",title: '退费时间',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.returnCostDate);}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
							return [
								   //'<button class="btn_projectPay_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								    '<button class="btn_projectPay_edit btn btn-xs btn-info"    href="javascript:void(0)" title="修改"  data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
								   
								    ].join('');
						},
						events:{
							'click .btn_projectPay_edit': function(e, value, row, index) {
								$.zjm_projectCostReturn.projectCostReturnEdit(row);
							},
							'click .btn_projectPay_del': function(e, value, row, index) {
								$.zjm_projectCostReturn.projectPayDel(row);
							}
						}
					}
				],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"returnCostDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/costReturn/selectProjectCostReturnPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
//				 var queryCondition ={"project_ID":$("#project_ID").val()}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	//退款列表修改
	function projectCostReturnEdit(row){
		$("#projectCostReturn_page").load("/project/costReturn/returnProjectCostReturnEditPage",{"costReturn_ID":row.costReturn_ID},function(response,status,xhr){				
			$("#projectCostReturnEditPage").modal({keyboard:true});
			zjm.init();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				zjm.validata({
					formId:"projectCostReturnEdit_form"
				});
				
				if($("#projectCostReturnEdit_form").validationEngine("validate")){
					//$("#projectDelayEditPage").modal("hide");
						var queryContainer_form = $("#projectCostReturnEdit_form");
						$.ajax({type:'POST',url:'/project/costReturn/updateOneCostReturn',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#projectCostReturnEditPage").modal("hide");
								window.location.reload();
//								$.zjm_projectPayDelay.initPayTable();
//								$.zjm_projectPayDelay.initDelayTable();
							}else{
								alert("退费修改失败！");
							}
						}
						});
						
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectCostReturnEditPage").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	
	}
	
	//债权列表-单个删除;
	function projectDelayDel(row){
		$("#projectDelay_page").load("/common_del.jsp",{},function(response,status,xhr){
			$("#common_del").modal({keyboard:true});
			$("#delModalLabel").text("删除");//标题;
			$("#delMessage").text("确定要删除所选数据吗?");//提示信息;		
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/project/delOneCreditorEdit',data:JSON.stringify({"creditorId":row.creditorId,"projectId":row.projectId}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==true){
							$('#projectCostReturn_table').bootstrapTable('remove', {
								field: 'creditorId',
								values: [row.creditorId]
							});
							$("#common_del").modal("hide");
//							$.zjm_projectAfter.initPayTable();
							$.zjm_projectCostReturn.initCostReturnTable();
						}else{
							alert("删除失败！");
						}
			        }
				});
			});
			
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	
//	/** 查看 企业客户信息 查看客户信息 客户详情**/
//	function viewCompanyClient(row){
//		window.parent.openMenu('view_companyClient'+row.client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type=view');
//	};
//	/***查看 个人客户信息 ***/
//	function viewPersonClient(row){
//		window.parent.openMenu('view_personClient'+row.client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+row.clientTypeID+'&type='+'view');
//	}
	}
})(jQuery, this);

$(function (){
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});

	$.zjm_projectCostReturn.initCostReturnTable();
	//下拉框改变触发
	$(".selectList").change(function(){	
		var selectID=$(this).attr("id");	//获取当前下拉框的id;	
		$.zjm_projectCostReturn.getSelectText(selectID);
	});
	
	$(".btn_projectCostReturnAdd").click(function(){
		$.zjm_projectCostReturn.projectCostReturnAdd();
	});
	$("#btn_closeProjectCostReturnAdd").click(function(){
		$.zjm_projectCostReturn.closeProjectCostReturnAddPage();
	});
	
});

