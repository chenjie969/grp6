(function($,z){
	$.zjm_reportZcfz = {
			initData:initData,//初始化数据
			initReportZcfzTable:initReportZcfzTable,//初始化资产负债表
			viewReportZcfz:viewReportZcfz,//查看资产负债表;
			openReportZcfzEditPage:openReportZcfzEditPage,//打开修改资产负债表页面;
			openReportZcfzAddPage:openReportZcfzAddPage,//打开新增资产负债表页面;
			addReportZcfz:addReportZcfz,//新增资产负债表信息;
			closeReportZcfzAddPage:closeReportZcfzAddPage,//关闭新增资产负债表页面;
			closeReportSyInfoPage:closeReportSyInfoPage,//关闭资产负债表新增页面;
			closeReportSyEditPage :closeReportSyEditPage,//关闭资产负债修改页面;
			closeReportZcfzComparePage :closeReportZcfzComparePage,//关闭资产负债对比页面;
			reportZcfzCompare : reportZcfzCompare,//选择两期资产负债报表对比;
			updateReportZcfx :updateReportZcfx,//更新资产负债表;
			deleteReportZcfz :deleteReportZcfz,//删除资产负债表信息;
			count :count,//计算合计;
			
			rules : rules,//页面验证规则
			getSelectText : getSelectText,//获取下拉框的值
			
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
		
		$.zjm_reportZcfz.initReportZcfzTable();
		
		
		
		//加载资产负债表 
		/*$("#reportZcfzList").load("/crm/client/companyFinance/reportZcfz/reportZcfzList.jsp",
			function(){
		         $.zjm_reportZcfz.initReportZcfzTable();
            }
		);*/
	};
	
	
	
	//页面验证规则
	function rules (){
		var allRules = {
				//判断资产总计 与 负债及所有者权益合计 是否相等
				"isEquality":{
					"func":function(field,rules,i,options){
						var piabilitiesOwerRigtSum=Number($("#piabilitiesOwerRigtSum").val()); 
						var assetsSum=Number($("#assetsSum").val());
						if(assetsSum == piabilitiesOwerRigtSum){
							return true;
						}else{
							return false;
						}
					},
					"alertText": "请验证： 资产总计与负债及所有者权益合计是否相等",
				     "alertTextOk": "可以使用"
				},
		};
		return allRules;
	
	};

	/**初始化列表项**/
	function initColumn(){
		var columns = [{field : 'checked',title:'reportZcfz_ID',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
						{field : 'index',title : '序号',align : 'center',formatter : function(value, row, index) {return index + 1;}},
						{field:'reportTypeName',title:'类别',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.reportTypeName;}},
						{field:'yearMonth',title:'年月',align: 'center',sortable:"true",formatter: function (value, row, index) {					
							return [ '<a class="btn_reportZcfz_view" href="javascript:void(0)">'
								+ row.yearMonth + '</a>' ].join('');
							
						},
						//年月绑定事件
						events : {
							'click .btn_reportZcfz_view' : function(
									e, value, row, index) {
								$.zjm_reportZcfz.viewReportZcfz(row);
										
							},
						}
						}];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title : '操作',align : 'center',
						formatter : function(value, row, index) {
							return [
									'<button class="btn_reportZcfz_view btn btn-xs btn-warning" id="btn_reportZcfz_view" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_reportZcfz_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_reportZcfz_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
									.join('');
						},
						events : {
							'click .btn_reportZcfz_view' : function(
									e, value, row, index) {
								$.zjm_reportZcfz.viewReportZcfz(row);
										
							},
							'click .btn_reportZcfz_edit' : function(
									e, value, row, index) {
								$.zjm_reportZcfz.openReportZcfzEditPage(row);
										
							},
							'click .btn_reportZcfz_del' : function(
									e, value, row, index) {
								$.zjm_reportZcfz.deleteReportZcfz(row);
										
							}
						}
			
			});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title : '操作',align : 'center',
				formatter : function(value, row, index) {
					return [
							'<button class="btn_reportZcfz_view btn btn-xs btn-warning" id="btn_reportZcfz_view" title="查看"  href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_reportZcfz_view': function(e, value, row, index) {
									$.zjm_reportZcfz.viewReportZcfz(row);
								}
							}
						});
		}
		return columns;
	}
	
	
	
	
	
	/**初始化资产负债列表***/
	function initReportZcfzTable(){		
		$("#reportZcfz-table").bootstrapTable('destroy');
		$('#reportZcfz-table').bootstrapTable({
			method: 'get',
			columns: initColumn() ,
					
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
			url: "/reportZcfz/selectReportZcfzPageTables",//这个接口需要处理bootstrap table传递的固定参数
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
	
	
	/** 客户详情  资产负债列表 添加资产负债列表**/
	function openReportZcfzAddPage(client_ID){		
		window.parent.openMenu('openReportZcfzAddPage'+client_ID,'','添加资产负债报表','/reportZcfz/openReportZcfzAddPage','&client_ID='+client_ID,1);
	};	
	/** 客户详情  资产负债列表 选择两期资产负债报表对比;**/
	function reportZcfzCompare(client_ID){		
	 var e = $('#reportZcfz-table').bootstrapTable('getSelections');//获取选中的列;
	   if(e.length === 2){
		   var reportZcfz_IDArry=[];
			$.map(e,function(row){
				reportZcfz_IDArry.push(row.reportZcfz_ID);
			  }				
			);
			reportZcfz_IDArry.push(client_ID);
			window.parent.openMenu('reportZcfzCompare'+client_ID,'','两期资产负债对比','/reportZcfz/reportZcfzCompare','&reportZcfz_IDArry='+reportZcfz_IDArry,1);
	   }else{
		   $("#selectTwoReportmodule").modal({keyboard:true});
	   }
		
	};	
	/** 客户详情   资产负债列表 查看资产负债列表信息 **/
	function viewReportZcfz(row){
		window.parent.openMenu('viewReportZcfz'+row.reportZcfz_ID,'','查看资产负债详情','/reportZcfz/selectReportZcfzViewPage','&reportZcfz_ID='+row.reportZcfz_ID+'&type='+'view',1);
	};
	
	/** 客户详情  资产负债列表 打开修改资产负债列表信息**/
	function openReportZcfzEditPage(row){
		window.parent.openMenu('openReportZcfzEditPage'+row.reportZcfz_ID,'',' 修改资产负债详情','/reportZcfz/openReportZcfzEditPage','&reportZcfz_ID='+row.reportZcfz_ID+'&type='+'edit',1);
	
	};	
	
	/*关闭新增资产负债表页面*/
	function closeReportZcfzAddPage(client_ID){
		window.parent.closeMenu('openReportZcfzAddPage'+client_ID);
		
	};
	/*关闭资产负债表查看页面*/
	function closeReportSyInfoPage(reportZcfz_ID){
		window.parent.closeMenu('viewReportZcfz'+reportZcfz_ID);
		
	};
	/*关闭资产负债表修改页面*/
	function closeReportSyEditPage(reportZcfz_ID){
		window.parent.closeMenu('openReportZcfzEditPage'+reportZcfz_ID);
		
	};
	/*关闭资产负债表对比页面*/
	function closeReportZcfzComparePage(client_ID){
		window.parent.closeMenu('reportZcfzCompare'+client_ID);
		//$.zjm_reportXjl.initData(client_ID);
		
	};
	
	//新增新增资产负债表;
	function  addReportZcfz(client_ID){		
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"add_reportZcfzForm"
		});
		$.zjm.rules = $.zjm_reportZcfz.rules();
		tool.disabled(".btn_addReportZcfz");
		if($("#add_reportZcfzForm").validationEngine("validate")){
			var queryContainer_form = $("#add_reportZcfzForm");
			$.ajax({type:'POST',url:'/reportZcfz/insertOneReportZcfzInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$("#successMessage").modal({keyboard:true});																																																									$("#successMessage").modal({keyboard:true});
					$(".btn_colse").click(function(){	
						
						$.zjm_reportZcfz.initData(client_ID);
		        		$.zjm_reportZcfz.closeReportZcfzAddPage(client_ID);
					});
					
	        		
				}else{
					alert("保存失败！");
				}
	        }
		});
			
		}else{
			tool.undisabled(".btn_addReportZcfz");
		}	
	};
	//更新资产负债表信息;
	function  updateReportZcfx(client_ID,reportZcfz_ID){
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"update_reportZcfzForm"
		});
		$.zjm.rules = $.zjm_reportZcfz.rules();
		
		tool.disabled("#btn_updateReportZcfx");
		
		if($("#update_reportZcfzForm").validationEngine("validate")){
			var queryContainer_form = $("#update_reportZcfzForm");
			$.ajax({type:'POST',url:'/reportZcfz/updateOneReportZcfzInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$.zjm_reportZcfz.initData(client_ID);
	        		$.zjm_reportZcfz.closeReportSyEditPage(reportZcfz_ID);					
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_updateReportZcfx");
		}	
		
	};
	
	
	/**删除资产负债表信息;*/
	function deleteReportZcfz(row){
		$("#delReportmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/reportZcfz/delectOneReportZcfzInfo',data:JSON.stringify({"reportZcfz_ID":row.reportZcfz_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#reportZcfz-table').bootstrapTable('remove', {
							field: 'reportZcfz_ID',
							values: [row.reportZcfz_ID]
						});
						$("#delReportmodule").modal("hide");
						$.zjm_reportZcfz.initData();
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
	function count(classString){
	/*	var  currentAssetsSum =0;//流动资产合计
		var  longtermInvestSum =0;//长期投资合计	
		var  fixedAssetsSum =0;//固定资产合计	
		var  fixedAssetsValue =0;//固定资产净值	
		var  intangibleAssetsSum =0;//无形资产及其他资产合计		
		var  assetsSum =0;//资产总计
		
		 $(".currentAssets").each(function(){
				currentAssetsSum =currentAssetsSum+Number($(this).val());//流动资产合计;		
		 });    
	   
	    $(".longtermInvest").each(function(){
	    	longtermInvestSum =longtermInvestSum+Number($(this).val());//长期投资合计			
	    }); 
	    fixedAssetsValue=Number($(".fixedAssetsOldValue").val())-Number($(".fixedAssetsDepreciation").val())
	    $("#fixedAssetsValue").attr("value",fixedAssetsValue);//计算固定资产净值
	    
	    $(".fixedAssets").each(function(){	    	
	    	fixedAssetsSum =fixedAssetsSum+Number($(this).val());//固定资产合计		
	    }); 
	    
	    fixedAssetsSum = fixedAssetsSum+fixedAssetsValue;
	    
        $(".intangibleAssets").each(function(){
	    	
	    	intangibleAssetsSum =intangibleAssetsSum+Number($(this).val());//无形资产及其他资产合计		
	    });	    
	    $("#currentAssetsSum").attr("value",currentAssetsSum);//资产负债合计赋值	  
	    $("#longtermInvestSum").attr("value",longtermInvestSum);//流动负债合计
	    $("#fixedAssetsSum").attr("value",fixedAssetsSum);//固定资产合计
	    $("#intangibleAssetsSum").attr("value",intangibleAssetsSum);//无形资产及其他资产合计		    
	    $("#assetsSum").attr("value",currentAssetsSum+currentLiabilitiesSum+longtermInvestSum+fixedAssetsSum+intangibleAssetsSum);//资产总计;		
		

	    
	    
        var  currentLiabilitiesSum =0;//流动负债合计	
        var  longtermLiabilitiesSum =0;//长期负债合计	
        var  liabilitiesSum =0;//负债合计
        var  deferredTax =Number($("#deferredTax").val());//递延税款贷项
		
        $(".currentLiabilitiesSum").each(function(){
	    	currentLiabilitiesSum =currentLiabilitiesSum+Number($(this).val());//流动负债合计			
	    }); 
        $(".longtermLiabilitiesSum").each(function(){
        	longtermLiabilitiesSum =longtermLiabilitiesSum+Number($(this).val());//长期负债合计			
        }); 
       
        
	    $("#currentLiabilitiesSum").attr("value",currentLiabilitiesSum);//流动负债合计
	    $("#longtermLiabilitiesSum").attr("value",longtermLiabilitiesSum);//长期负债合计
	    $("#liabilitiesSum").attr("value",longtermLiabilitiesSum+currentLiabilitiesSum+deferredTax);//负债合计=流动负债合计+长期负债合计+递延税款贷项
	    
	    */
		
	    var  sum = 0;
		var cutLength = classString.indexOf("Sum")+3//获取计算类型sum;
		var  sumStr = classString.substring(0,cutLength);
		 $("."+sumStr).each(function(){	 
			//alert(Number($(this).val()));
			if(!isNaN(Number($(this).val()))){
				sum =sum+(Number($(this).val()));//计算合计
			}
			
			
	     }); 
		$("#"+sumStr).attr("value",sum.toFixed(2));//为计算合计赋值		    
		
		var piabilitiesOwerRigtSum = 0;//负债及所有者权益合计
		piabilitiesOwerRigtSum=Number($(".piabilitiesOwerRigtSum1").val())+Number($(".piabilitiesOwerRigtSum2").val());	
		$("#piabilitiesOwerRigtSum").attr("value",piabilitiesOwerRigtSum.toFixed(2));//负债及所有者权益合计

		var  fixedAssetsValue =0;//固定资产净值
		var fixedAssetsOldValue = Number($(".fixedAssetsOldValue").val());
		var fixedAssetsDepreciation = Number($(".fixedAssetsDepreciation").val());
		if(!isNaN(fixedAssetsOldValue) && !isNaN(fixedAssetsDepreciation)){			
			fixedAssetsValue=Number($(".fixedAssetsOldValue").val())-Number($(".fixedAssetsDepreciation").val());
		}
		
		
		
	    $("#fixedAssetsValue").attr("value",fixedAssetsValue.toFixed(2));//计算固定资产净值		
	    var fixedAssetsValue = Number($("#fixedAssetsValue").val()).toFixed(2);
		var fixedAssetsDevalue= Number($("#fixedAssetsDevalue").val()).toFixed(2);
		var fixedAssetsAmount =fixedAssetsValue-fixedAssetsDevalue;
		$("#fixedAssetsAmount").attr("value",fixedAssetsAmount);//固定资产净额
	    
		
		var assetsSum = 0 ;//资产总计 
		$(".assetsSum").each(function(){
			if(!isNaN(Number($(this).val()))){
				assetsSum =assetsSum+Number($(this).val());//资产总计 
			}
	     });
		$("#assetsSum").attr("value",assetsSum.toFixed(2));//资产总计 
		
		
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
	
	 
		 	/*var type = $('.reportTypeList');
		    var pindex  =  type.selectedIndex;
		    var pValue  =  type.options[pindex].value;　
		    var pText   =  type.options[pindex].text;
		    alert("pTextpText"+pText);
		    $('.reportTypeName').attr("value",pText);*/
		    
		    
	  
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
        minViewMode:'months'}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	//$.zjm_reportZcfz.initData(client_ID);
	$(".btn_Zcfz").click(function(){
			$.zjm_reportZcfz.initData(client_ID);
			var type = tool.getUrlParam('type');//获取路径类型:查看/修改
			if(type == 'view'){
				$("#btn_openReportZcfzAddPage").hide();
				/*$('#reportZcfz-table').bootstrapTable('hideColumn','reportZcfzID');*/
			}
			
	});	
	//刷新资产负债表列表
	$("#btn_refreshReportZcfz").click(function(){
		$.zjm_reportZcfz.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportZcfzAddPage").hide();
			$('#reportZcfz-table').bootstrapTable('hideColumn','reportZcfzID');
		}		
	});	
	
	
	
	
	
	
	//打开新增资产负债报表;
	$("#btn_openReportZcfzAddPage").click(function(){
		$.zjm_reportZcfz.openReportZcfzAddPage(client_ID)
	});
	//关闭资产负债表查看页面
	$("#btn_closeReportSyInfoPage").click(function(){
		var reportZcfz_ID = $("#reportZcfz_ID").val();
		$.zjm_reportZcfz.closeReportSyInfoPage(reportZcfz_ID)
	});
	//关闭资产负债表修改页面
	$("#btn_closeReportSyEditPage").click(function(){
		var reportZcfz_ID = $("#reportZcfz_ID").val();
		$.zjm_reportZcfz.closeReportSyEditPage(reportZcfz_ID)
	});
	
	//关闭资产负债表新增页面
	$("#btn_closeReportZcfzAddPage").click(function(){
		$.zjm_reportZcfz.closeReportZcfzAddPage(client_ID)
	});
	
	//关闭资产负债表对比页面
	$("#btn_closeReportZcfzComparePage").click(function(){
		var client_ID = $("#client_ID").val();
		
		$.zjm_reportZcfz.closeReportZcfzComparePage(client_ID)
	});
	
	
	
	//选择两期资产负债报表对比;
	$("#btn_reportZcfzCompare").click(function(){
		$.zjm_reportZcfz.reportZcfzCompare(client_ID)
	});
	
	
	
	
	/*//选择两期资产负债报表对比;
	$("#closeReportSyInfoPage").click(function(){
		var client_ID = $("#client_ID").val();
		$.zjm_reportZcfz.closeReportSyInfoPage(client_ID)
	});
	*/
	
	
	
	//新增资产负债报表
	$(".btn_addReportZcfz").click(function(){
		$.zjm_reportZcfz.addReportZcfz(client_ID)
	});
	
	//更新资产负债报表
	$(".btn_updateReportZcfx").click(function(){
		var client_ID = $("#client_ID").val();
		var reportZcfz_ID = $("#reportZcfz_ID").val();
		$.zjm_reportZcfz.updateReportZcfx(client_ID,reportZcfz_ID)
	});
	
	
	
	//为输入框添加点击事件;mouseleave
	$(".countInput").keyup(function(){
		var classString=$(this).attr("class");	//获取class字符串;
		$.zjm_reportZcfz.count(classString)
	});
	
	//下拉框改变触发
	$("#reportTypeList").change(function(){
		$.zjm_reportZcfz.getSelectText();
	});
	
	
	
	
	
	
	
});

