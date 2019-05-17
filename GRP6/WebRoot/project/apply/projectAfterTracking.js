(function($,z){
	$.zjm_projectTracking = {
			initColumns:initColumns,
			initProjectTalble:initProjectTalble,//初始化列表
			transact:transact,//办理
			editModule:editModule,//客户列表修改
			delModule:delModule,//客户列表删除
			hightSelect:hightSelect,//高级查询
			editProjectAfter:editProjectAfter,//保后跟踪修改页面
			projectAfterAdd:projectAfterAdd,//新增保后
			openFactPayRegister:openFactPayRegister,
			openProjectDelay:openProjectDelay,
			openProjectOverRegister:openProjectOverRegister,
			openProjectReplaceAndReturn:openProjectReplaceAndReturn,//代偿登记
			openProjectLawsuit:openProjectLawsuit,//项目诉讼登记
			openAssetSealUp:openAssetSealUp,//资产查封信息
			openProjectFinish:openProjectFinish,//打开项目完结页面
			viewProjectInfo:viewProjectInfo,//查看项目详情
			initfundChineseTree:initfundChineseTree,//初始化资金方下拉树
			openProjectTransfer:openProjectTransfer,//打开项目移交页面
			projectCreditor:projectCreditor,//债权
			projectUrgeLetter:projectUrgeLetter,
			costReturn:costReturn,//退回保费
			projectSelect:projectSelect, //选择业务类型页面
			
	};
		
	function initColumns(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
//			{field:'0',title:'标识',align:'center',formatter: function (value, row, index) {return 
//				'<span class="label label-sm label-danger arrowed arrowed-in-right ">'+'逾期'+'</span>';
//			}},
			{field:'pa.guarantyOrgName',title:'承保机构',align:'center',sortable : "true",formatter: function (value, row, index) {return row.guarantyOrgName;}},
			{field:'pa.hostAreaName',title:'承办地区',align:'center',sortable : "true",formatter: function (value, row, index) {return row.hostAreaName;}},
			{field : "pp.projectName",title : '项目名称',align : 'center',sortable : "true",formatter : function(value, row, index) {
				return ['<a class="btn_project_view" href="javascript:void(0)">'+ row.projectName + '</a>' ].join('');},
				//客户名称绑定事件
				events : {
					'click .btn_project_view' : function(e, value, row, index) {
						$.zjm_projectTracking.viewProjectInfo(row.apply_ID ,row.project_ID);
					},
				}
			},
			{field:'pp.busiTypeName',title:'业务品种',align:'center',sortable : "true",formatter: function (value, row, index) {return row.busiTypeName;}},
			{field:'pp.guarantySum',title:'余额（万元）',align:'center',sortable : "true",formatter: function (value, row, index) {return row.guarantySum;}},
			{field:'pp.bankName',title:'合作机构',align:'center',sortable : "true",formatter: function (value, row, index) {return row.bankName;}},
//合作子机构	
			{field:'pp.subBankName',title:'合作子机构（或个人）',align:'center',sortable : "true",formatter: function (value, row, index) {return row.subBankName;}},
//资金来源		
			{field:'pa.fundSource',title:'资金来源',align:'center',sortable : "true",formatter: function (value, row, index) {return row.fundSource;}},
			{field:'pa.fundChinese',title:'资金方名称',align:'center',sortable : "true",formatter: function (value, row, index) {return row.fundChinese;}},
			{field:'pa.fundName',title:'资金方子机构',align:'center',sortable : "true",formatter: function (value, row, index) {return row.fundName;}},
			
			{field:'pp.loadBeginDate',title:'起始日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.loadBeginDate,'');}},
			{field:'pp.delayEndDate',title:'到期日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.delayEndDate,'');}},
			{field:'pa.oprationCompanyName',title:'报送机构',align:'center',sortable : "true",formatter: function (value, row, index) {return row.oprationCompanyName;}},
			{field:'pa.attributionName',title:'属地划分',align:'center',sortable : "true",formatter: function (value, row, index) {return row.attributionName;}},
			{field:'pp.projectCode',title:'项目编号',align:'center',sortable : "true",formatter: function (value, row, index) {return row.projectCode;}},
//			{field:'pp.projectName',title:'项目名称',align:'center',sortable : "true",formatter: function (value, row, index) {
//				return ['<a class="btn_project_edit" href="javascript:void(0)">'+row.projectName+'</a>'].join('');
//				},
//				events:{
//					'click .btn_project_edit': function(e, value, row, index) {
//						$.zjm_projectTracking.editModule(row);
//					},
//				}
//			},
			{field:'pp.loadSum',title:'项目金额（万元）',align:'center',sortable : "true",formatter: function (value, row, index) {return row.loadSum;}},
			{field:'pp.periodMonthDay',title:'期限',align:'center',sortable : "true",formatter: function (value, row, index) {return row.periodMonthDay;}},
			{field:'pp.amanName',title:'A角',align:'center',sortable : "true",formatter: function (value, row, index) {return row.amanName;}},
			{field:'pp.bmanName',title:'B角',align:'center',sortable : "true",formatter: function (value, row, index) {return row.bmanName;}},
			//{field:'reviewManName',title:'风控评审人',align:'center',formatter: function (value, row, index) {return row.reviewManName;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					//'<button class="btn_modules_edit btn btn-xs btn-pink" title="项目办理" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-edit bigger-120"></i></button>',
					'<button class="btn_projectAfter_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
					
					
					].join('');
				},
				events:{
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_projectTracking.editModule(row);
					},
					'click .btn_projectAfter_edit': function(e, value, row, index) {
						$.zjm_projectTracking.editProjectAfter(row);
					}
				}
			}
		];
		return columns;
		
	}	
	
	/**初始化列表***/
	function initProjectTalble(condition){
		$("#package-table").bootstrapTable('destroy');
		$('#package-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			       // html.push('<p><b>序号:</b> ' + tool.isNull(row.clientBH,"") + '</p>');
			        html.push('<p><b>承保机构:</b> ' + tool.isNull(row.guarantyOrgName,"") + '</p>');
			        html.push('<p><b>承办地区:</b> ' + tool.isNull(row.hostAreaName,"") + '</p>');
			        html.push('<p><b>项目名称:</b> ' + tool.isNull(row.projectName,"") + '</p>');
			        html.push('<p><b>业务品种:</b> ' + tool.isNull(row.busiTypeName,"") + '</p>');
			        html.push('<p><b>余额（万元）:</b> ' + tool.isNull(row.guarantySum,"") + '</p>');
			        html.push('<p><b>合作机构:</b> ' + tool.isNull(row.bankName,"") + '</p>');
			        //合作子机构
			        html.push('<p><b>合作子机构:</b> ' + tool.isNull(row.subBankName,"") + '</p>');
			        //资金来源
			        html.push('<p><b>资金来源:</b> ' + tool.isNull(row.fundSource,"") + '</p>');
			        html.push('<p><b>资金方:</b> ' + tool.isNull(row.fundChinese,"") + '</p>');
			        html.push('<p><b>资金方名称:</b> ' + tool.isNull(row.fundName,"") + '</p>');
			        html.push('<p><b>起始日期:</b> ' + tool.parseDate(row.loadBeginDate,'') + '</p>');
			        html.push('<p><b>到期日期:</b> ' + tool.parseDate(row.delayEndDate,'') + '</p>');
			        html.push('<p><b>报送机构:</b> ' + tool.isNull(row.oprationCompanyName,"") + '</p>');
			        html.push('<p><b>属地划分:</b> ' + tool.isNull(row.attributionName,"") + '</p>');
			        html.push('<p><b>项目编号:</b> ' + tool.isNull(row.projectCode,"") + '</p>');
			        html.push('<p><b>项目金额（万元）:</b> ' + tool.isNull(row.loadSum,"") + '</p>');
			        html.push('<p><b>期限:</b> ' + tool.isNull(row.periodMonthDay,"") + '</p>');
			        html.push('<p><b>A角:</b> ' + tool.isNull(row.amanName,"") + '</p>');
			        html.push('<p><b>B角:</b> ' + tool.isNull(row.bmanName,"") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			sortName: "pp.loadBeginDate",     //默认排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				//简单查询的时候将高级查询的条件注释掉
				if(params.searchText != undefined){
					condition = undefined;
				}
				var queryCondition={"clientTypeID":$(".clientTypeID").val()};
				$.extend(params,{"queryCondition":condition,"wheresql":" and pp.finishDate is null and pp.busiClass='01'"});
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
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	}
	
	//查看项目详情
    function viewProjectInfo(apply_ID,project_ID){
		window.parent.openMenu('viewProjectInfo'+apply_ID,'','项目详情','/project/projectDetail/viewProjectInfo','&apply_ID='+apply_ID+'&type='+'view'+'&project_ID='+project_ID);
    }

	/***办理***/
	function transact(){
		var selectContent = $('#package-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{  
        	window.parent.openMenu('projectDeal'+selectContent.apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+selectContent.apply_ID,1);
        }
	}
	
	/***修改***/
	function editModule(row){
		window.parent.openMenu('projectDeal'+row.apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+row.apply_ID,1);
	}
	
	/***保后跟踪修改页面***/
	function editProjectAfter(row){
		$("#projectAfter_page").load("/project/project/returnProjectAfterEditPage",{"apply_ID":row.apply_ID,"project_ID":row.project_ID},function(response,status,xhr){
			$("#projectAfterEdit_page").modal({keyboard:true});
			
			//获取业务品种下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){		
					$("#busiSortDicTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
					
				}
			});//获取业务品种下拉树end;
			//获取合作机构下拉树;
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){	
					$("#cooperationTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});//获取合作机构下拉树end;
			//获取创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#amanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
		     });
			//获取创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#bmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取业务品种下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){		
					$("#busiSortDicTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取合作机构下拉树;
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){	
					$("#cooperationTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
					
				}
			});
			//获取资金方下拉树;
			/*$("[name='fundTypeID']").val()
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllFundListTree',data:JSON.stringify({"pbanksortid":,"banksortid":}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){
					$("#fundChineseTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});*/
			initfundChineseTree($("[name='fundTypeID']").val(), $("#busiClass").val());
			zjm.init();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"projectAfter_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#projectAfter_form");
				if(queryContainer_form.validationEngine("validate")){
						$.ajax({type:'POST',url:'/project/project/updateProjectAfter',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#projectAfterEdit_page").modal("hide");
									//$.zjm_projectTracking.initColumns();//客户需求:修改后手动刷新
								}else{
									alert("保存失败！");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
			});
			$("#projectAfterEdit_page").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//根据所选的资金方类型 确定资金方下拉树
	function initfundChineseTree(pValue, busiClass){
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
				$.ajax({type:'POST',url:'/crm/cooperation/selectAllFundListTree',data:JSON.stringify({"pbanksortid":pbankSortID,"banksortid":pbankSortID, "busiClass":busiClass, "fundType":"01"}),contentType:'application/json; charset=UTF-8',dataType:'json',
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
	
	
	
	
	/**删除***/
	function delModule(row){
		$("#delPersonClientmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#package-table').bootstrapTable('remove', {
							field: 'client_ID',
							values: [row.client_ID]
						});
						$.zjm_projectTracking.initProjectTalble();
						$("#delPersonClientmodule").modal("hide");
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delPersonClientmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**高级查询**/
	function hightSelect(){
		$("#projectAfter_page").load("/project/project/projectAfterSelectPage",'',function(response,status,xhr){
			$("#projectAfterSelect").modal({keyboard:true});
			//获取业务品种下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){		
					$("#busiSortDicTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
					
				}
			});//获取业务品种下拉树end;
			//获取合作机构下拉树;
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){	
					$("#cooperationTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});//获取合作机构下拉树end;
			//获取资金方下拉树;
			//获取资金方下拉树;
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllFundListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){
					$("#fundTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取资金方下拉树end;
			//获取创建部门下拉树;
			$.ajax({type:'POST',url:'/selectAllDepartsListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){		
				$("#allDepartsTree").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				
	        }
	        });//获取创建部门下拉树end;
			
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){//点击查询按钮	
				if($("#projectAfterSelect_form").validationEngine("validate")){
					var condition = $("#projectAfterSelect_form").serializeJson();
					$("#projectAfterSelect").modal("hide");
					initProjectTalble(condition);	
				}
			});
			$("#projectAfterSelect").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			
			

		});
	}
	function projectAfterAdd(projectType){
	
		window.parent.openMenu('projectAfterAdd_page','',projectType+'新增历史项目','/project/project/returnProjectAfterAddPage','&projectType='+projectType,1);	
		window.parent.closeMenu('projectTypeSelect_page');
		//$("#projectAfter_page").load("/project/project/returnProjectAfterAddPage","",function(){});
	}
	
	function openFactPayRegister(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('openFactPayRegister'+project_ID,'','还款登记','/project/project/openFactPayRegisterPage','&project_ID='+project_ID,1);				
		 	} 
	}
	
	//打开债权页面
	function projectCreditor(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('projectCreditor'+project_ID,'','债权登记','/project/project/projectCreditorPage','&project_ID='+project_ID,1);				
		 	} 
	}
	
	//打开退费页面
	function costReturn(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('costReturn'+project_ID,'','退回保费','/project/project/projectCostReturnPage','&project_ID='+project_ID,1);				
		 	} 
	}
	
	//打开催告函页面
	function projectUrgeLetter(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('projectUrgeLetter'+project_ID,'','催告函','/project/project/projectUrgeLetterPage','&project_ID='+project_ID,1);				
		 	} 
	}
	
	/**
	 * 展期登记
	 * @returns
	 */
	function openProjectDelay(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('openProjectDelay'+project_ID,'','展期','/project/project/openProjectDelayPage','&project_ID='+project_ID,1);				
		} 
	}
	function openProjectOverRegister(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;
			window.parent.openMenu('openProjectOverRegister'+project_ID,'','逾期确认','/project/project/openProjectOverRegisterPage','&project_ID='+project_ID,1);				
		} 
	}
	//代偿与追偿
	function openProjectReplaceAndReturn(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('openProjectReplace'+project_ID,'','代偿与追偿','/project/project/openProjectReplaceAndReturnPage','&project_ID='+project_ID,1);				
		} 
	}
	//项目诉讼登记
	function openProjectLawsuit(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('openProjectLawsuit'+project_ID,'','项目诉讼登记','/project/projectLawsuit/openProjectLawsuitPage','&project_ID='+project_ID,1);				
		} 
	}
	//资产清查登记
	function openAssetSealUp(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('openAssetSealUp'+project_ID,'','资产查封信息','/project/assetSealUp/openAssetSealUpPage','&project_ID='+project_ID,1);				
		} 
	}
	//打开项目完结页面
	function openProjectFinish(){
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) {//选择一项目
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;
		}else{
			var guarantySum = $('#package-table').bootstrapTable('getSelections')[0].guarantySum;
			if(typeof(guarantySum) == 'undefined' || 0 != guarantySum){
				$("#pleaseSelectOne").modal({keyboard:true});
				$("#message").text("余额不为0，不能完结！")
				return false;  
			}else{
				var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
				window.parent.openMenu('openProjectFinish'+project_ID,'','项目完结','/project/project/openProjectFinish','&project_ID='+project_ID,1);				
				
			}
		} 
	}
	
	//打开项目移交界面
	function openProjectTransfer(){		
		var selectContent = $('#package-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#package-table').bootstrapTable('getSelections')[0].project_ID;			
			window.parent.openMenu('openProjectTransfer'+project_ID,'','项目移交','/project/projChangeRec/openProjectTransfer','&project_ID='+project_ID,1);				
		} 
	}
	
	//打开业务类型选择页面
	function projectSelect(){
		window.parent.openMenu('projectTypeSelect_page','','选择业务类型','/project/project/projectTypeSelectPage', 1);	
	}
	
	
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		$.zjm_projectTracking.initProjectTalble();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	};
	/**
	 * 办理
	 */
	$("#btn_transact").click(function(){
		$.zjm_projectTracking.transact();
	});

	/**
	 * 删除
	 */
	$("#btn_deleteOfSelected").click(function(){
		$.zjm_projectTracking.deleteOfSelected();
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_projectTracking.hightSelect();
	});
	
	$("#btn_refresh").click(function(){
		$.zjm_projectTracking.initProjectTalble();
	});
	//打开新增保后项目页面
	$("#btn_projectAfterAdd").click(function(){
		var projectType = $("#projectType").val();
		$.zjm_projectTracking.projectAfterAdd(projectType);
	});
	//打开还款登记页面
	$("#btn_openFactPayRegister").click(function(){
		$.zjm_projectTracking.openFactPayRegister();
	});
	//打开项目完结页面
	$("#btn_openProjectFinish").click(function(){
		$.zjm_projectTracking.openProjectFinish();
	});
	//打开展期页面
	$("#btn_openProjectDelay").click(function(){
		$.zjm_projectTracking.openProjectDelay();
	});
	
	//打开逾期确认页面
	$("#btn_openProjectOverRegister").click(function(){
		$.zjm_projectTracking.openProjectOverRegister();
	});
	//打开代偿与追偿页面
	$("#btn_openProjectReplaceAndReturn").click(function(){
		$.zjm_projectTracking.openProjectReplaceAndReturn();
	});

	//打开项目诉讼登记页面
	$("#btn_openProjectLawsuit").click(function(){
		$.zjm_projectTracking.openProjectLawsuit();
	});
	//打开资产清查信息页面
	$("#btn_openAssetSealUp").click(function(){
		$.zjm_projectTracking.openAssetSealUp();
	});
	$(".selectList").change(function(){	
		alert();
		var selectID=$(this).attr("id");	//获取当前下拉框的id;	
		alert(selectID);
		tool.getSelectText(selectID);
	});
	
	//打开项目移交页面
	$("#btn_transfer").click(function(){
		$.zjm_projectTracking.openProjectTransfer();
	});
	
	//打开债权页面
	$("#btn_projectCreditor").click(function(){
		$.zjm_projectTracking.projectCreditor();
	});
	
	//打开退费页面
	$("#btn_costReturn").click(function(){
		$.zjm_projectTracking.costReturn();
	});
	//打开催告函页面
	$("#btn_isUrgeLetter").click(function(){
		$.zjm_projectTracking.projectUrgeLetter();
	});
	//打开选择业务类型页面
	$("#btn_projectTypeSelect").click(function(){
		$.zjm_projectTracking.projectSelect();
	});
});

