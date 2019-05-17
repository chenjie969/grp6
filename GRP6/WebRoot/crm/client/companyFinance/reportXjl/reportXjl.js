(function($,z){
	$.zjm_reportXjl = {
			initData:initData,//初始化数据
			initReportXjlTable:initReportXjlTable,//初始化现金流报表列表
			viewReportXjl:viewReportXjl,//查看现金流报表;
			openReportXjlEditPage:openReportXjlEditPage,//打开修改现金流报表;
			openReportXjlAddPage :openReportXjlAddPage,//打开新增现金流报表页面;
			addReportXjl:addReportXjl,//新增现金流报表;
			reportXjlCompare : reportXjlCompare,//选择两期现金流报表对比;
			closeReportXjlAddPage:closeReportXjlAddPage,//关闭现金流新增页面;
			closeReportXjlInfoPage:closeReportXjlInfoPage,//关闭现金流报表查看页面;
			closeReportXjlUpdatePage:closeReportXjlUpdatePage,//关闭现金流报表修改页面
			closeReportXjlComparePage:closeReportXjlComparePage,//关闭现金流报表对比页面
			updateReportXjl :updateReportXjl,//更新现金流表信息
			deleteReportXjl :deleteReportXjl,//删除现金流量表信息;
			count :count,//计算合计;
			getSelectText:getSelectText,//获取下拉框text值;
			
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
		
		$.zjm_reportXjl.initReportXjlTable();
		
		/*//加载现金流                                     
		$("#reportXjlList").load("/crm/client/companyFinance/reportXjl/reportXjlList.jsp",
			function(){
		         $.zjm_reportXjl.initReportXjlTable();
            }
		);
		*/
	}
	/**初始化列表项**/
	function initColumn(){
		var columns = [{field : 'checked',title:'client_ID',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
			{field : 'index',title : '序号',align : 'center',formatter : function(value, row, index) {return index + 1;}},
			{field:'reportTypeName',title:'类别',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.reportTypeName;}},
			
			{field:'yearMonth',title:'年月',align: 'center',sortable:"true",formatter: function (value, row, index) {
				return [ '<a class="btn_reportXjl_view" href="javascript:void(0)">'
					+ row.yearMonth + '</a>' ].join('');
			},
			//年月绑定事件
			events : {
				'click .btn_reportXjl_view' : function(
						e, value, row, index) {
					$.zjm_reportXjl.viewReportXjl(row);
							
				},
			}
			}];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title : '操作',align : 'center',
				formatter : function(value, row, index) {
					return [
							'<button class="btn_reportXjl_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_reportXjl_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_reportXjl_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_reportXjl_view' : function(
							e, value, row, index) {
						$.zjm_reportXjl.viewReportXjl(row);
								
					},
					'click .btn_reportXjl_edit' : function(
							e, value, row, index) {
						$.zjm_reportXjl.openReportXjlEditPage(row);
								
					},
					'click .btn_reportXjl_del' : function(
							e, value, row, index) {
						$.zjm_reportXjl.deleteReportXjl(row);
								
					}
				}
			
			});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title : '操作',align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_reportXjl_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_reportXjl_view': function(e, value, row, index) {
									$.zjm_reportXjl.viewReportXjl(row);
								}
							}
						});
		}
		return columns;
	}
	
	/**初始化现金流报表列表***/
	function initReportXjlTable(){
		$("#reportXjl-table").bootstrapTable('destroy');
		$('#reportXjl-table').bootstrapTable({
			method: 'get',
			columns:initColumn(),
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
			//url: "/selectPersonClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			url: "/reportXjl/selectReportXjlPageTables",//这个接口需要处理bootstrap table传递的固定参数
			
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
	
	
	/** 客户详情  现金流列表  打开添加现金流列表页面**/
	function openReportXjlAddPage(client_ID){
		window.parent.openMenu('openReportXjlAddPage'+client_ID,'','添加现金流报表','/reportXjl/openReportXjlAddPage','&client_ID='+client_ID,1);
	};	
	
	/** 客户详情  现金流列表 选择两期现金流报表对比;**/
	function reportXjlCompare(client_ID){
		 var e = $('#reportXjl-table').bootstrapTable('getSelections');//获取选中的列;
		   if(e.length === 2){
			   var reportXjl_IDArry=[];
				$.map(e,function(row){
					reportXjl_IDArry.push(row.reportXjl_ID);
				  }				
				);
				
				reportXjl_IDArry.push(client_ID);
				window.parent.openMenu('reportXjlCompare'+client_ID,'','两期现金流表对比','/reportXjl/reportXjlCompare','&reportXjl_IDArry='+reportXjl_IDArry,1);
		   }else{
			   $("#selectTwoReportmodule").modal({keyboard:true});
		   }
		
		//window.parent.openMenu('reportXjlCompare'+client_ID,'','两期现金流对比','/crm/client/companyFinance/reportXjl/reportXjlCompare.jsp','&client_ID='+client_ID,1);
	};	
	/** 客户详情   现金流列表 查看现金流列表信息 **/
	function viewReportXjl(row){
		window.parent.openMenu('viewReportXjl'+row.reportXjl_ID,'','查看现金流详情','/reportXjl/selectReportXjlViewPage','&reportXjl_ID='+row.reportXjl_ID+'&type='+'view',1);
	
	};
	
	/** 客户详情  现金流列表 修改现金流列表信息**/
	function openReportXjlEditPage(row){
		window.parent.openMenu('openReportXjlEditPage'+row.reportXjl_ID,'','修改现金流详情','/reportXjl/openReportXjlEditPage','&reportXjl_ID='+row.reportXjl_ID+'&type='+'edit',1);
	};	
	
	/**关闭新增现金流页面**/
	function closeReportXjlAddPage(client_ID){
		window.parent.closeMenu('openReportXjlAddPage'+client_ID);
		
	};
	/**关闭现金流页面查看**/
	function closeReportXjlInfoPage(reportXjl_ID){
		window.parent.closeMenu('viewReportXjl'+reportXjl_ID);
		
	};
	/**关闭现金流更新页面**/
	function closeReportXjlUpdatePage(reportXjl_ID){		
		window.parent.closeMenu('openReportXjlEditPage'+reportXjl_ID);
		
	};
	/**关闭现金流对比页面**/
	function closeReportXjlComparePage(client_ID){		
		window.parent.closeMenu('reportXjlCompare'+client_ID);
		
	};
	
	//新增现金流报表;
	function  addReportXjl(client_ID){		
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"add_reportXjlForm"
		});
		tool.disabled(".btn_addReportXjl");
		if($("#add_reportXjlForm").validationEngine("validate")){
			var queryContainer_form = $("#add_reportXjlForm");
			$.ajax({type:'POST',url:'/reportXjl/insertOneReportXjlInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$("#successMessage").modal({keyboard:true});
					$(".btn_colse").click(function(){						
						$.zjm_reportXjl.initData(client_ID);	
		        		$.zjm_reportXjl.closeReportXjlAddPage(client_ID);
						
					});	
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_addReportXjl");
		}	
	};
	//更新现金流表信息;
	function  updateReportXjl(client_ID,reportXjl_ID){
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"update_reportXjlForm"
		});
		tool.disabled("#btn_updateReportXjl");
		
		if($("#update_reportXjlForm").validationEngine("validate")){
			var queryContainer_form = $("#update_reportXjlForm");
			$.ajax({type:'POST',url:'/reportXjl/updateOneReportXjlInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					
					$.zjm_reportXjl.initData(client_ID);
	        		$.zjm_reportXjl.closeReportXjlUpdatePage(reportXjl_ID);					
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_updateReportXjl");
		}	
		
	};
	/**删除现金流表信息;*/
	function deleteReportXjl(row){
		$("#delReportmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/reportXjl/delectOneReportXjlInfo',data:JSON.stringify({"reportXjl_ID":row.reportXjl_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#reportXjl-table').bootstrapTable('remove', {
							field: 'reportXjl_ID',
							values: [row.reportXjl_ID]
						});
						$("#delReportmodule").modal("hide");
						$.zjm_reportXjl.initData();
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
	//计算合计
	function count(classString){
		    var  sum = 0;
			var cutLength = classString.indexOf("-");//获取计算类型sum;
			var  sumStr = classString.substring(0,cutLength);
			 $("."+sumStr+"-").each(function(){	        	
				 if(!isNaN(Number($(this).val()))){
					 sum =sum+Number($(this).val());//计算合计
				 }
		     }); 			 
			$("#"+sumStr).attr("value",sum.toFixed(2));//为合计合计赋值			
			//经营活动产生的现金流量净额=经营现金流入小计-经营现金流出小计
			var activitiesNetCashFlow = Number($("#operatingCashSum").val())-Number($("#operatingCashFlow").val());
			$("#activitiesNetCashFlow").attr("value",activitiesNetCashFlow.toFixed(2));
			//投资活动产生的现金流量净额=投资现金流入小计-投资现金流出小计
			var investmentActivities = Number($("#inflowsOfCash").val())-Number($("#cashOutflow").val());
			$("#investmentActivities").attr("value",investmentActivities.toFixed(2));
			//筹资活动产生的现金流量净额=筹资现金流入小计-筹资现金流出小计
			var netCashFlow = Number($("#financingCashFlows").val())-Number($("#cashfFlowFinancing").val());
			$("#netCashFlow").attr("value",netCashFlow.toFixed(2));
			
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
	
	
	
	$(".btn_Xjl").click(function(){
		$.zjm_reportXjl.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportXjlAddPage").hide();
			$('#reportXjl-table').bootstrapTable('hideColumn','reportXjlID');
		}
		
	});	
	//刷新现金流表列表
	$("#btn_refreshReportXjl").click(function(){
		$.zjm_reportXjl.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportXjlAddPage").hide();
			$('#reportXjl-table').bootstrapTable('hideColumn','reportXjlID');
		}
		
	});	

	
	
	
	
	//打开新增现金流报表页面;
	$("#btn_openReportXjlAddPage").click(function(){
		$.zjm_reportXjl.openReportXjlAddPage(client_ID)
	});
	
	
	//新增现金流报表;
	$("#btn_addReportXjl").click(function(){
		$.zjm_reportXjl.addReportXjl(client_ID)
	});
	//关闭新增现金流页面
	$("#closeReportXjlAddPage").click(function(){
		$.zjm_reportXjl.closeReportXjlAddPage(client_ID)
	});
	//关闭现金流查看页面
	$("#closeReportXjlInfoPage").click(function(){
		var reportXjl_ID = $("#reportXjl_ID").val();
		$.zjm_reportXjl.closeReportXjlInfoPage(reportXjl_ID)
	});
	//关闭现金流表更新页面
	$("#closeReportXjlUpdatePage").click(function(){
		var reportXjl_ID = $("#reportXjl_ID").val();
		$.zjm_reportXjl.closeReportXjlUpdatePage(reportXjl_ID)
	});
	//关闭现金流表对比页面
	$("#btn_closeReportXjlComparePage").click(function(){
		var client_ID = $("#client_ID").val();
		$.zjm_reportXjl.closeReportXjlComparePage(client_ID)
	});
	
	//更新现金流表;
	$(".btn_updateReportXjl").click(function(){
		var client_ID = $("#client_ID").val();
		var reportXjl_ID = $("#reportXjl_ID").val();
		$.zjm_reportXjl.updateReportXjl(client_ID,reportXjl_ID)
	});
	
	//选择两期现金流报表对比;
	$("#btn_reportXjlCompare").click(function(){
		$.zjm_reportXjl.reportXjlCompare(client_ID)
	});
	

	$(".countInput").keyup(function(){//为输入框添加点击事件;
		var classString=$(this).attr("class");	//获取class字符串;
		$.zjm_reportXjl.count(classString)
	});
	
	//下拉框改变触发
	$("#reportTypeList").change(function(){
		$.zjm_reportXjl.getSelectText();
	});
	
	
	
});

