(function($,z){
	$.zjm_reportSy = {
			initData:initData,//初始化数据
			initReportSyTable:initReportSyTable,//初始化损益报表列表
			viewReportSy:viewReportSy,//查看损益报表;
			openReportSyEditPage:openReportSyEditPage,//修改损益报表;
			openReportSyAddPage:openReportSyAddPage,//打开新增损益报表页面;
			addReportSy:addReportSy,//新增损益报表;
			reportSyCompare : reportSyCompare,//选择两期损益报表对比;
			closeReportSyAddPage:closeReportSyAddPage,//关闭损益表新增页面;
			closeReportSyInfoPage:closeReportSyInfoPage,//关闭损益表查看页面;			
			closeReportSyUpdatePage:closeReportSyUpdatePage,//关闭损益表更新页面;
			closeReportSyComparePage:closeReportSyComparePage,//关闭损益表对比页面;
			updateReportSy :updateReportSy,//更新损益表信息;
			deleteReportSy :deleteReportSy,//删除损益表信息;
			getSelectText:getSelectText,//获取下拉框text值;
			count:count,//计算
			
	};
	
	/**
	 * 初始化数据
	 * @param client_ID
	 * @returns
	 */
	function initData(client_ID){
		zjm.init();		
		//zjm.dataViewValSelect("select_reportTypeUuid", "/selectDicTypeListJSON", {"dicTypePID" : '5048855d72fe4364af60245c3a4cb2d1'});/*获取报表类型下拉框*/		
		
		//获取客户名称和编号;
		//zjm.dataViewText("view_", "/selectOneCompanyClientInfo", {"client_ID" : client_ID},'');
		
		$.zjm_reportSy.initReportSyTable();
		
		/*$("#reportSyList").load("/crm/client/companyFinance/reportSy/reportSyList.jsp"
			,{},function(){
				$.zjm_reportSy.initReportSyTable();
            }
		);*/
		
	};
	
	/**初始化列表项**/
	function initColumn(){
		var columns = [{field : 'checked',title:'reportSy_ID',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
						{field : 'index',title : '序号',align : 'center',formatter : function(value, row, index) {return index + 1;}},
						{field:'reportTypeName',title:'类别',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.reportTypeName;}},
						{field:'yearMonth',title:'年月',align: 'center',sortable:"true",formatter: function (value, row, index) {
							return [ '<a class="btn_reportSy_view" href="javascript:void(0)">'
								+ row.yearMonth + '</a>' ].join('');
						},
						//年月绑定事件
						events : {
							'click .btn_reportSy_view' : function(
									e, value, row, index) {
								$.zjm_reportSy.viewReportSy(row);
										
							},
						}
						}];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title : '操作',align : 'center',
							formatter : function(value, row, index) {
								return [
										'<button class="btn_reportSy_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
										'<button class="btn_reportSy_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
										'<button class="btn_reportSy_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
										.join('');
							},
							events : {
								'click .btn_reportSy_view' : function(e, value, row, index) {$.zjm_reportSy.viewReportSy(row);									},
								'click .btn_reportSy_edit' : function(e, value, row, index) {$.zjm_reportSy.openReportSyEditPage(row);															},
								'click .btn_reportSy_del' : function(e, value, row, index) {$.zjm_reportSy.deleteReportSy(row);															}
							}				
						});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title : '操作',align : 'center',
				formatter : function(value, row, index) {
					return [
							'<button class="btn_client_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_client_view': function(e, value, row, index) {
									$.zjm_reportSy.viewReportSy(row);
								}
							}
						});
		}
		return columns;
	}
	
	
	/**初始化损益报表列表***/
	function initReportSyTable(){		
		$("#reportSy-table").bootstrapTable('destroy');
		$('#reportSy-table').bootstrapTable({
			method: 'get',
			columns: initColumn(),
			/*detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>客户名称:</b> ' + row.clientName + '</p>');
			        html.push('<p><b>业务品种:</b> ' + row.fullTradeName + '</p>');
			    return html;
			},*/
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			//url: "/selectCompanyClientsPageTables?queryCondition.mod_uid="+nodeid,//这个接口需要处理bootstrap table传递的固定参数
			url: "/reportSy/selectReportSyPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"client_ID":$(".client_ID").val()}});
				return params;
			},
			//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			rictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
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
	};
	
	
	/** 客户详情  损益表列表 添加损益表列表**/
	function openReportSyAddPage(client_ID){		
		window.parent.openMenu('openReportSyAddPage'+client_ID,'','添加损益报表','/reportSy/openReportSyAddPage','&client_ID='+client_ID,1);	
	};	
	/** 客户详情  损益表列表 选择两期损益报表对比;**/
	function reportSyCompare(client_ID){
		 var e = $('#reportSy-table').bootstrapTable('getSelections');//获取选中的列;
		   if(e.length === 2){
			   var reportSy_IDArry=[];
				$.map(e,function(row){
					reportSy_IDArry.push(row.reportSy_ID);
				  }				
				);
				reportSy_IDArry.push(client_ID);
				window.parent.openMenu('reportSyCompare'+client_ID,'','两期损益表对比','/reportSy/reportSyCompare','&reportSy_IDArry='+reportSy_IDArry,1);
		   }else{
			   $("#selectTwoReportmodule").modal({keyboard:true});
		   }
	
	};	
	/** 客户详情   损益表列表 查看损益表列表信息 **/
	function viewReportSy(row){		
		window.parent.openMenu('viewReportSy'+row.reportSy_ID,'','查看损益表详情','/reportSy/selectReportSyViewPage','&reportSy_ID='+row.reportSy_ID+'&type='+'view',1);
	};
	/** 客户详情  损益表列表 修改损益表列表信息**/
	function openReportSyEditPage(row){		
		window.parent.openMenu('openReportSyEditPage'+row.reportSy_ID,'','修改损益表详情','/reportSy/openReportSyEditPage','&reportSy_ID='+row.reportSy_ID+'&type='+'edit',1);	
	};	
	
	/**关闭新增损益表页面**/
	function closeReportSyAddPage(client_ID){
		window.parent.closeMenu('openReportSyAddPage'+client_ID);
		
	};
	/**关闭更新损益表页面**/
	function closeReportSyUpdatePage(reportSy_ID){
		
		window.parent.closeMenu('openReportSyEditPage'+reportSy_ID);
		
	};
	/**关闭损益表对比页面**/
	function closeReportSyComparePage(client_ID){		
		window.parent.closeMenu('reportSyCompare'+client_ID);
		
	};
	
	/**关闭查看损益表页面**/
	function closeReportSyInfoPage(reportSy_ID){
		window.parent.closeMenu('viewReportSy'+reportSy_ID);
		
	};
	
	
	//新增损益报表;
	function  addReportSy(client_ID){		
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"add_reportSyForm"
		});
		tool.disabled(".btn_addReportSy");
		if($("#add_reportSyForm").validationEngine("validate")){
			var queryContainer_form = $("#add_reportSyForm");
			$.ajax({type:'POST',url:'/reportSy/insertOneReportSyInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$("#successMessage").modal({keyboard:true});
					$(".btn_colse").click(function(){						
						$.zjm_reportSy.initData(client_ID);
		        		$.zjm_reportSy.closeReportSyAddPage(client_ID);	
					});	
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_addReportSy");
		}	
	};
	//更新损益表信息;
	function  updateReportSy(client_ID,reportSy_ID){
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"update_reportSyForm"
		});
		tool.disabled("#btn_updateReportSy");
		
		if($("#update_reportSyForm").validationEngine("validate")){
			var queryContainer_form = $("#update_reportSyForm");
			$.ajax({type:'POST',url:'/reportSy/updateOneReportSyInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$.zjm_reportSy.initData(client_ID);
	        		$.zjm_reportSy.closeReportSyUpdatePage(reportSy_ID);					
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_addReportSy");
		}	
		
	};

	/**删除损益表信息;*/
	function deleteReportSy(row){
		$("#delReportmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/reportSy/delectOneReportSyInfo',data:JSON.stringify({"reportSy_ID":row.reportSy_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#reportSy-table').bootstrapTable('remove', {
							field: 'reportSy_ID',
							values: [row.reportSy_ID]
						});
						$("#delReportmodule").modal("hide");
						$.zjm_reportSy.initData();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delReportmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	//获取下拉框的text值;
	function getSelectText(){
		
	 	 var type = document.getElementById("reportTypeList");
	 	 var pindex  =  type.selectedIndex;
	 	 	// 获取选中的下拉框的值(value)
	　　	 var pValue  =  type.options[pindex].value;　
	　　	   // 获取选中的下拉框的选项(key)
	　　   var pText   =  type.options[pindex].text;	
	     //给隐藏域typeName赋值[next]
	　　  document.getElementById("reportTypeName").value=pText;
    };
    
	function count(classString){
		var mainOperatingProfit = 0;//主营业务利润
		var operatingProfit = 0;//三、营业利润
		var profitSum = 0;//三、营业利润
		var mainIncome =Number($("#mainIncome").val());
		
		var otherBusiProfit =Number($("#otherBusiProfit").val());
		
		 $(".mainOperatingProfit").each(function(){
			 mainOperatingProfit =mainOperatingProfit+Number($(this).val());//主营业务利润
		 }); 
		 //三、营业利润
		 $(".operatingProfit").each(function(){
			 operatingProfit =operatingProfit+Number($(this).val());//主营业务利润
		 }); 
		 //、利润总额
		 $(".profitSum").each(function(){
			 profitSum =profitSum+Number($(this).val());//利润总额
		 }); 
		 
		 mainOperatingProfit = (Number(mainIncome)-Number(mainOperatingProfit));
		 
		 $("#mainOperatingProfit").attr("value",mainOperatingProfit);//主营业务利润
		 
		 var annualProfitLoss =Number($("#annualProfitLoss").val());
		var busiExpenditure =Number($("#busiExpenditure").val());
		 var profitSum2= ((mainOperatingProfit+otherBusiProfit-operatingProfit)+profitSum+annualProfitLoss)-busiExpenditure;
		 $("#profitSum").attr("value",profitSum2);//利润总额
		
		 $("#operatingProfit").attr("value",mainOperatingProfit+otherBusiProfit-operatingProfit);//主营业务利润
		
		 var incomeTax =Number($("#incomeTax").val());
		 $("#netProfit").attr("value",Number(profitSum2)-Number(incomeTax));//主营业务利润
		 
		
	}
	
	
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 列表信息
	 */
	 /*注册日期控件点击事件-只选择年月*/
	$('#pickerYearsMonths').datepicker({
		language: "zh-CN",
        todayHighlight: true,
        autoclose: true,
        startView: 'months',
        maxViewMode:'years',
        minViewMode:'months'
	}).next().on(ace.click_event, function(){$(this).prev().focus();});
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	
	$(".btn_Sy").click(function(){
		$.zjm_reportSy.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportSyAddPage").hide();
			$('#reportSy-table').bootstrapTable('hideColumn','reportSyID');
		}
		
	});	
	//刷新损益表列表
	$("#btn_refreshReportSy").click(function(){
		$.zjm_reportSy.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportSyAddPage").hide();
			$('#reportSy-table').bootstrapTable('hideColumn','reportSyID');
		}
		
	});	


	
	//打开新增损益报表页面;
	$("#btn_openReportSyAddPage").click(function(){
		$.zjm_reportSy.openReportSyAddPage(client_ID)
	});
	//关闭新增损益表页面
	$("#closeReportSyAddPage").click(function(){
		
		$.zjm_reportSy.closeReportSyAddPage(client_ID)
	});
	//关闭更新损益表页面
	$("#closeReportSyUpdatePage").click(function(){
		var reportSy_ID = $("#reportSy_ID").val();
		$.zjm_reportSy.closeReportSyUpdatePage(reportSy_ID)
	});
	//关闭查看损益表页面
	$("#closeReportSyInfoPage").click(function(){
		var reportSy_ID = $("#reportSy_ID").val();
		$.zjm_reportSy.closeReportSyInfoPage(reportSy_ID)
	});
	//关闭损益表对比页面
	$("#btn_closeReportSyComparePage").click(function(){
		var client_ID = $("#client_ID").val();
		$.zjm_reportSy.closeReportSyComparePage(client_ID)
	});
	
	//选择两期损益报表对比;
	$("#btn_reportSyCompare").click(function(){
		$.zjm_reportSy.reportSyCompare(client_ID)
	});

	//新增损益报表;
	$(".btn_addReportSy").click(function(){
		$.zjm_reportSy.addReportSy(client_ID)
	});
	//更新损益报表;
	$(".btn_updateReportSy").click(function(){
		var client_ID = $("#client_ID").val();
		var reportSy_ID = $("#reportSy_ID").val();
		$.zjm_reportSy.updateReportSy(client_ID,reportSy_ID)
	});
	//下拉框改变触发
	$("#reportTypeList").change(function(){
		$.zjm_reportSy.getSelectText();
	});
	
	//为输入框添加点击事件;
	$(".countInput").keyup(function(){
		var classString=$(this).attr("class");	//获取class字符串;
		$.zjm_reportSy.count(classString)
	});
	
});

