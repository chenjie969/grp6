/**
 * 保证措施管理---js
 * author: wuhn
 * 2017年7月11日 15:25:25
 */

(function($,z){
	window.optManager={
		refreshTable:refreshTable,
	};
	
	function refreshTable(){
		$.zjm_optManager.initTable();
	}
	
	$.zjm_optManager = {
		initTable:initTable,	//初始化列表
		mergeCells:mergeCells,	//合并单元格
		addOptGuaranty:addOptGuaranty,	//保证措施管理 --- 新增 保证措施
		chooseProj:chooseProj,	//保证措施管理 --- 新增 --选择 项目名称
		choosePerson:choosePerson,	//保证措施管理 --- 新增 --选择 权属人
		addPerson:addPerson,	//保证措施管理 --- 新增 --新增 -- 权属人
		realizeOptGuaranty:realizeOptGuaranty,//保证措施管理 -- 落实 保证措施	
		relieveOptGuaranty:relieveOptGuaranty,//保证措施管理 -- 解除 保证措施	
		disposeOptGuaranty:disposeOptGuaranty,//保证措施管理 -- 处置 保证措施	
		deleteOptGuaranty:deleteOptGuaranty ,//保证措施管理 -- 删除所选
		highOptQuery:highOptQuery ,//保证措施管理 -- 高级查询
		optGuarantyView:optGuarantyView , // 查看 一条保证措施
		optGuarantyEdit:optGuarantyEdit , // 修改一条保证措施
		optGuarantyDel:optGuarantyDel ,  // 删除一条保证措施
		executeDel:executeDel, // 具体执行删除的函数
		common_Content:common_Content, //公共部分内部函数 
		guarantyType:guarantyType, //保证方式处理
		isWorkableView:isWorkableView, // 保证措施管理 -- 查看落实   担保措施
		returnOptSum:returnOptSum
		
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#optManager_table').bootstrapTable('destroy');
		$('#optManager_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return }},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'busiCode',title:'项目编号',sortable:"true",align:'center',formatter: function (value, row, index) {return row.busiCode;}},
						{field:'projectName',title:'项目名称',sortable:"true",align:'center',formatter: function (value, row, index) {return row.projectName;}},
						{field:'guarantySum',title:'余额',sortable:"true",align:'center',formatter: function (value, row, index) {return row.guarantySum;}},
						{field:'hzbankName',title:'合作方',sortable:"true",align:'center',formatter: function (value, row, index) {return row.hzbankName ;}},
						{field:'subBankName',title:'合作方子机构',sortable:"true",align:'center',formatter: function (value, row, index) {return row.subBankName ;}},
						{field:'fundChinese',title:'资金方名称',sortable:"true",align:'center',formatter: function (value, row, index) {return row.fundChinese;}},
						{field:'fundName',title:'资金方子机构',sortable:"true",align:'center',formatter: function (value, row, index) {return row.fundName;}},
						{field:'loadBeginDate',title:'起始日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.loadBeginDate) ;}},
						{field:'delayEndDate',title:'到期日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.delayEndDate) ;}},
						{field:'guarantyTypeName',title:'保证方式',sortable:"true",align:'center',formatter: function (value, row, index) {return row.guarantyTypeName;}},
						{field:'optTypeName',title:'反担保物类型',sortable:"true",align:'center',formatter: function (value, row, index) {return row.optTypeName;}},
						{field:'ownerName',title:'权属人',align:'center',formatter: function (value, row, index) {return row.ownerName;}},
						{field:'assessValue',title:'评估价值<br>（万元）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.assessValue;}},
						{field:'coverageRatio',title:'抵（质）押率<br>（%）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.coverageRatio==null?'-':row.coverageRatio.toFixed(2);}},
						{field:'optValue',title:'抵（质）押价值<br>（万元）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.optValue ;}},
						{
							field : 'isWorkable',
							title : '是否已落实',
							sortable : "true",
							align : 'center',
							formatter : function(value, row, index) {
								 if(row.isWorkable == 1){
									 return ['<a href=javascript:void(0) id="isWorkable" title="查看落实详情">是</a>'].join('');
								 }else{
									 return '否';
								 }
							},
							events:{
								'click #isWorkable':function(e, value, row, index){
									$.zjm_optManager.isWorkableView(row);
								}
							}
						},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button title="查看" class="btn_optGuaranty_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
										'<button title="修改"  class="btn_optGuaranty_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
										'<button title="删除"   class="btn_optGuaranty_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ].join('');
							},
							events:{
								'click .btn_optGuaranty_view': function(e, value, row, index) {
									$.zjm_optManager.optGuarantyView(row);
								},
								'click .btn_optGuaranty_edit': function(e,value, row , index){
									$.zjm_optManager.optGuarantyEdit(row);
								},
								'click .btn_optGuaranty_del' : function(e,value, row ,index ){
									$.zjm_optManager.optGuarantyDel(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>项目编号：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>保证方式：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>反担保物类型：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>权属人：</b> ' + row.ownerName + '</p>');
				    html.push('<p><b>评估价值：</b> ' + tool.isNull(row.assessValue,'（空）') +'万元'+ '</p>');
				    html.push('<p><b>抵（质）押率：</b> ' + tool.isNull(row.coverageRatio,'（空）') +'%'+ '</p>');
				    html.push('<p><b>抵（质）押价值：</b> ' + tool.isNull(row.optValue,'（空）') +'万元'+'</p>');
				    html.push('<p><b>是否已落实：</b> ' + (row.isWorkable==1?'是':'否') + '</p>');
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/optGuarantyAction/selectOptGuarantyPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"isFree":0,"isDispose":0,"apply_ID":$("#apply_ID").val(),"mark":"2"};
			//	var queryCondition = {};
				$.extend(queryCondition,data);
				$.extend(params, {"queryCondition":queryCondition});
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
            exportDataType: "basic",              //basic', 'all', 'selected'
            	
        	onLoadSuccess: function () {
//        		$.zjm_creditApply.mergeCells();
        	}
		});
	}
	
	/**
	 * 合并单元格 
	 */
	function mergeCells(){
		$('#optManager_table').bootstrapTable('mergeCells', {
            index: 2,
            field: 'creditBH',
            rowspan: 2,
        });
	}
	
	/**
	 * 新增 担保措施
	 */
	function addOptGuaranty(){
		/*$("#optGuaranty_page").load("/optGuarantyAction/addOptGuarantyPage",{},function(response,status,xhr){
			$("#optGuarantyAddPage").modal({keyboard:true}); 
			注册日期控件点击事件
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
		});	*/
		var apply_ID=	$("#apply_ID").val()?$("#apply_ID").val():'';
		window.parent.openMenu('add_OptGuaranty','','新增保证措施','/optGuarantyAction/addOptGuarantyPage','&type=edit&apply_ID='+apply_ID);
		
	}
	
	/**
	 * 公共部分内部函数 
	 */
	function common_Content(selectValue){
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		/**获取创建人 下拉树 */
		$.ajax({
			type : 'POST',
			url : '/sys/dic/selectDepartsUserTree',
			data : JSON.stringify({}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				
				$("#txt_id2").selectTreeWidgets({
					width : "26%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj
				//数据源
				});
				
				// 原档案接收人，下拉树
				$("#txt_id1").selectTreeWidgets({
					width : "26%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj
				//数据源
				});
			}
		});
		
		
		//经办部门下拉树
		$.ajax({
			type : 'POST',
			url : '/selectAllDepartsListTree',
			data : JSON.stringify({}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$("#allDepartsTree1").selectTreeWidgets({
					width : "46%",// 设置控件宽度
					multiple : false,// 是否多选
					data : data.obj
				// 数据源
				});
			}
		});
		
		$("#optGuaranty_ID").val(selectValue[0].optGuaranty_ID);
		$("#busiCode").text(selectValue[0].busiCode == null?'（空）':selectValue[0].busiCode);
		$("#projectName").text(selectValue[0].projectName== null?'（空）':selectValue[0].projectName);
		$("#guarantyTypeName").text(selectValue[0].guarantyTypeName== null?'（空）':selectValue[0].guarantyTypeName);
		$("#optTypeName").text(selectValue[0].optTypeName== null?'（空）':selectValue[0].optTypeName);
		$("#ownerName").text(selectValue[0].ownerName== null?'（空）':selectValue[0].ownerName);
		$("#assessValue").text(selectValue[0].assessValue== null?'（空）':selectValue[0].assessValue);
		$("#coverageRatio").text(selectValue[0].coverageRatio== null?'（空）':selectValue[0].coverageRatio);
		$("#optValue").text(selectValue[0].optValue== null?'（空）':selectValue[0].optValue);
		$("#isWorkables").text(selectValue[0].isWorkable == 1?'是':'否');

		$(".isWorkable").text(selectValue[0].isWorkable == 1?'是':'否');

		//保证措施落实部分字段赋值
		$("#pledgeDepart").text(selectValue[0].pledgeDepart== null?'（空）':selectValue[0].pledgeDepart);
		$("#pledgeFile").text(selectValue[0].pledgeFile== null?'（空）':selectValue[0].pledgeFile);
		$("#optBeginDate").text(selectValue[0].optBeginDate== null?'（空）':tool.parseDate(selectValue[0].optBeginDate));
		$("#optEndDate").text(selectValue[0].optEndDate== null?'（空）':tool.parseDate(selectValue[0].optEndDate));
		$("#pledgeFileCount").text(selectValue[0].pledgeFileCount== null?'（空）':selectValue[0].pledgeFileCount);
		$("#receivePerson").text(selectValue[0].receivePerson== null?'（空）':selectValue[0].receivePerson);
		$("#realizeUserName").text(selectValue[0].realizeUserName== null?'（空）':selectValue[0].realizeUserName);
		$("#realizeDate").text(selectValue[0].realizeDate== null?'（空）':tool.parseDate(selectValue[0].realizeDate));
		
	}
	
	/**
	 * 保证措施管理 -- 落实 保证措施
	 */
	function realizeOptGuaranty(){
		var selectValue = $('#optManager_table').bootstrapTable('getSelections');
		if(selectValue.length != 1){
			$("#pleaseSelectOne").modal({keyboard:true});
			return;
		}	
		$("#optGuaranty_page").load("/optGuarantyAction/realizeOptGuarantyPage",{"optGuaranty_ID":selectValue[0].optGuaranty_ID},function(response,status,xhr){
			$("#realizeOptGuarantyPage").modal({keyboard:true}); 
			
			//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");	

			
			$.zjm_optManager.common_Content(selectValue);
			
		
			//经办日期默认设置为当前日期
			var nowTime= tool.parseDate(new Date().getTime());
			$("#realizeDate").val(nowTime);
			
			$("#btn_submit").click(function(){
				/** 注册编辑验证引擎 */
				zjm.init();
				zjm.validata({ formId : "form_realizeOptGuaranty" });
				
				/*if($("#pictureDIV_realize").children().length > 0){
					$("#pledgeFileValid").removeClass("validate[required]");
				}else{
					$("#pledgeFileValid").addClass("validate[required]");
				}*/
				
				
				if ($("#form_realizeOptGuaranty").validationEngine("validate")) {
					var form_realizeOptGuaranty=$("#form_realizeOptGuaranty");
					var formData=JSON.stringify(form_realizeOptGuaranty.serializeJson());
					$.ajax({
						type:'POST',
						url:'/optGuarantyAction/updateOneOptGuarantyInfo',
						data:formData ,
						contentType: 'application/json; charset=UTF-8',
						dataType:'json' ,
						success : function(data) {
							if(data.obj){
								$("#realizeOptGuarantyPage").modal("hide");
								$.zjm_optManager.initTable();
							}else{
								alert("保存失败...");
							}
						}
					});
				}else{
					tool.undisabled("#btn_submit"); // 保存按钮可用
					return ;
				}
				
			})
			
			
		});
	}
	
	/**
	 * 保证措施管理 -- 解除 保证措施	
	 */
	function relieveOptGuaranty(){
		var selectValue = $('#optManager_table').bootstrapTable('getSelections');
		if(selectValue.length != 1){
			$("#pleaseSelectOne").modal({keyboard:true});
			return;
		}
		
		$("#optGuaranty_page").load("/optGuarantyAction/relieveOptGuarantyPage",{"optGuaranty_ID":selectValue[0].optGuaranty_ID},function(response,status,xhr){
			$("#relieveOptGuarantyPage").modal({keyboard:true}); 
			
			//解除日期默认设置为当前日期
			var nowTime= tool.parseDate(new Date().getTime());
			$("#freeDate").val(nowTime);
			$.zjm_optManager.common_Content(selectValue);

			$("#btn_submit").click(function(){
				/** 注册编辑验证引擎 */
				zjm.init();
				zjm.validata({ formId : "form_relieveOptGuaranty" });
				if ($("#form_relieveOptGuaranty").validationEngine("validate")) {
					var form_realizeOptGuaranty=$("#form_relieveOptGuaranty");
					var formData=JSON.stringify(form_realizeOptGuaranty.serializeJson());
					$.ajax({
						type:'POST',
						url:'/optGuarantyAction/updateOneOptGuarantyInfo',
						data:formData ,
						contentType: 'application/json; charset=UTF-8',
						dataType:'json' ,
						success : function(data) {
							if(data.obj){
								$("#relieveOptGuarantyPage").modal("hide");
								$.zjm_optManager.initTable();
							}else{
								alert("保存失败...");
							}
						}
					});
				}else{
					tool.undisabled("#btn_submit"); // 保存按钮可用
					return ;
				}
				
			})
			
		});
	}
	
	/**
	 * 保证措施管理 -- 处置 保证措施	
	 */
	function disposeOptGuaranty(){
		var selectValue = $('#optManager_table').bootstrapTable('getSelections');
		if(selectValue.length != 1){
			$("#pleaseSelectOne").modal({keyboard:true});
			return;
		}
		
		$("#optGuaranty_page").load("/optGuarantyAction/disposeOptGuarantyPage",{"optGuaranty_ID":selectValue[0].optGuaranty_ID},function(response,status,xhr){
			$("#disposeOptGuarantyPage").modal({keyboard:true}); 
			
			//处置日期默认设置为当前日期
			var nowTime= tool.parseDate(new Date().getTime());
			$("#disposeDate").val(nowTime);
			
			$.zjm_optManager.common_Content(selectValue);
			
			$("#btn_submit").click(function(){
				/** 注册编辑验证引擎 */
				zjm.init();
				zjm.validata({ formId : "form_disposeOptGuarantyPage" });
				if ($("#form_disposeOptGuarantyPage").validationEngine("validate")) {
					var form_realizeOptGuaranty=$("#form_disposeOptGuarantyPage");
					var formData=JSON.stringify(form_realizeOptGuaranty.serializeJson());
					$.ajax({
						type:'POST',
						url:'/optGuarantyAction/updateOneOptGuarantyInfo',
						data:formData ,
						contentType: 'application/json; charset=UTF-8',
						dataType:'json' ,
						success : function(data) {
							if(data.obj){
								$("#disposeOptGuarantyPage").modal("hide");
								$.zjm_optManager.initTable();
							}else{
								alert("保存失败...");
							}
						}
					});
				}else{
					tool.undisabled("#btn_submit"); // 保存按钮可用
					return ;
				}
				
			})
		
		
		});
	}
	
	/**
	 * 保证措施管理 -- 删除所选
	 */
	function deleteOptGuaranty(){
		var selectValue = $('#optManager_table').bootstrapTable('getSelections');
		if(selectValue.length < 1){
			$("#pleaseSelectOne").modal({keyboard:true});
			return ;
		}
		$("#optGuaranty_page").load("/optGuarantyAction/deleteOptGuarantyPage",{},function(response,status,xhr){
			$("#deleteOptGuarantyPage").modal({keyboard:true}); 
			$.each(selectValue,function(key,value){
				$.zjm_optManager.executeDel(value);
			});
		});
	}
	
	//打开退保证金页面
	function returnOptSum(){		
		var selectContent = $('#optManager_table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var apply_ID = $('#optManager_table').bootstrapTable('getSelections')[0].apply_ID;			
			window.parent.openMenu('returnOptSum'+apply_ID,'','退保证金','/project/project/projectReturnOptSumPage','&apply_ID='+apply_ID,1);				
		 	} 
	}
	
	/**
	 * 保证措施管理 -- 高级查询
	 */
	function highOptQuery (){
		$("#optGuaranty_page").load("/optGuarantyAction/highOptQueryPage",{},function(response,status,xhr){
			$("#highOptQueryPage").modal({keyboard:true}); 
			
			/**获取创建人 下拉树 */
			$.ajax({
				type : 'POST',
				url : '/sys/dic/selectDepartsUserTree',
				data : JSON.stringify({}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					// 原档案接收人，下拉树
					$("#txt_id1").selectTreeWidgets({
						width : "26%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj
					//数据源
					});
				}
			});
			
			
			//经办部门下拉树
			$.ajax({
				type : 'POST',
				url : '/selectAllDepartsListTree',
				data : JSON.stringify({}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#allDepartsTree1").selectTreeWidgets({
						width : "46%",// 设置控件宽度
						multiple : false,// 是否多选
						data : data.obj
					// 数据源
					});
				}
			});
			
			$("#btn_submit").click(function(){
				if($("#form_highOptQuery").validationEngine("validate")){
					var condition = $("#form_highOptQuery").serializeJson();
					$("#highOptQueryPage").modal("hide");
					$.zjm_optManager.initTable(condition);	
				}
			})
			
			
		});
	}
	
	/**
	 * 查看 一条担保措施
	 */
	function optGuarantyView(row){
		window.parent.openMenu('view_OptGuaranty'+row.optGuaranty_ID,'','查看保证措施','/optGuarantyAction/selectOneOptGuarantyInfo',
				'&apply_ID='+row.apply_ID+'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+
				'&optGuaranty_ID='+row.optGuaranty_ID+"&depositTypeId="+row.depositTypeId+'&pageFlag=view'
			);
		
	}
	
	/**
	 * 编辑 一条担保措施
	 */
	function optGuarantyEdit(row){
	//	window.parent.openMenu('view_creditApply_'+row.apply_ID,'','查看授信申请信息','/project/credit/viewOneCreditApply','&apply_ID='+row.apply_ID);
		window.parent.openMenu('update_OptGuaranty'+row.optGuaranty_ID,'','修改保证措施','/optGuarantyAction/updateOptGuarantyPage',
				'&apply_ID='+row.apply_ID+'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+
				'&optGuaranty_ID='+row.optGuaranty_ID+'&pageFlag=edit'+'&type=edit'
				);
	}
	
	/**
	 * 删除 一条担保措施
	 */
	function optGuarantyDel(row){
		$("#optGuaranty_page").load("/optGuarantyAction/deleteOptGuarantyPage",{},function(response,status,xhr){
			$("#deleteOptGuarantyPage").modal({keyboard:true}); 
			$.zjm_optManager.executeDel(row);
		});
	}
	
	/**
	 * 保证措施管理 --- 新增 --选择 项目名称
	 */
	function chooseProj(){
		alert("新增 --选择 项目名称");
	}
	
	/**
	 * 保证措施管理 --- 新增 --选择 权属人
	 */
	function choosePerson(){
		alert("新增 --选择 权属人");
	}
	
	/**
	 * 保证措施管理 --- 新增 --新增 -- 权属人
	 */
	function addPerson(){
		alert("新增 --新增 -- 权属人");
	}
	
	/**
	 * 具体执行删除操作的函数
	 */
	function executeDel(row){
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/optGuarantyAction/deleteOneOptGuarantyInfo',
				data: {'optGuaranty_ID':row.optGuaranty_ID},
//				contentType : 'application/json; charset=UTF-8',
				contentType : 'application/x-www-form-urlencoded',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$("#deleteOptGuarantyPage").modal("hide");
						$.zjm_optManager.initTable()
					} else {
						$("#failDel").modal({keyboard:true});
					}
				}
			});
		});
		$("#deleteOptGuarantyPage").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}
	
	
	
	/**
	 * 保证措施管理--- 新增-- 保证方式处理
	 */
	function guarantyType(_optionText,_val){
		alert(_optionText,_val);
		if(_val == '4efae31cb89847b598faf3a05273f0fa' || _val == '6305ed68f1674830ad65b420109c6340' ){ //保证方式为: 企业信用 、个人信用
			$(".ownerType").hide(); // 权属人类型隐藏
			if(_val == '4efae31cb89847b598faf3a05273f0fa'){
				$("#optType02").val("01");
			}else{
				$("#optType01").val("02");
			}
		}else{
			$(".ownerType").show();
			$("#optType02").val("02");
			$("#optType01").val("01");
		}
		
		if(_val == 'c0b07f297c6f4e23981d9e1fed84c5f9'){ // 质押 
			$("#btn_optTypes").addClass("validate[required]"); //保证方式为：质押 给反担保类型 字段 增加必填验证
			$("#btn_optTypesDIV").show();
			$.ajax({ // 获取 保证方式为： 质押  时的反担保物类型 字段
				type : 'POST',
				url : "/selectDicTypeSelectJSONKeyValue",
				data : JSON.stringify({"dicTypePID" : '686f264405e549b299a7ed815ea289d6'}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#btn_optTypes").empty();
					$("#btn_optTypes").append("<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("#btn_optTypes").append("<option value='" + key2 + "'>"+ value2 + "</option>");
						});
					});
				}
			});
		}else if( _val == '596d424eb6594b1485ecc724a2533c1c'){ //抵押
			$("#btn_optTypes").addClass("validate[required]"); //保证方式为：抵押  给反担保类型 字段 增加必填验证
			$("#btn_optTypesDIV").show();
			$.ajax({ // 获取 保证方式为： 抵押 时的反担保物类型 字段  
				type : 'POST',
				url : "/selectDicTypeSelectJSONKeyValue",
				data : JSON.stringify({"dicTypePID" : '12b5eece874947de8e692a31939cda44'}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#btn_optTypes").empty();
					$("#btn_optTypes").append("<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("#btn_optTypes").append("<option value='" + key2 + "'>"+ value2 + "</option>");
						});
					});
				}
			});
		}else{
			$("#btn_optTypes").removeClass("validate[required]"); // 取消验证
			$("#btn_optTypesDIV").hide();
			$("#btn_optTypes").find("option:selected").text("");//隐藏的时候将文本内容清空
			$("#btn_optTypes").find("option:selected").val("");//隐藏的时候，将value也清空
		}
	}
	
	
	/**
	 * 保证措施管理 -- 查看落实   担保措施
	 */
	function isWorkableView(row){
		$("#optGuaranty_page").load("/optGuarantyAction/realizeOptGuarantyPage",
				{"optGuaranty_ID":row.optGuaranty_ID,"relieveFlag":"realizeView"},function(response,status,xhr){
			
			var selectValue=[];
			selectValue[0]=row;
			$.zjm_optManager.common_Content(selectValue);
			$("#realizeOptGuarantyPageView").modal({keyboard:true}); 
		});
			
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
		$.zjm_optManager.initTable();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	
	
	/**
	 * 新增担保措施
	 */
	$("#btn_addOptGuaranty").click(function(){
		// window.parent.openMenu('add_optManager','','授信申请登记','/project/credit/showCreditApplyAddPage','');
		$.zjm_optManager.addOptGuaranty();
	});
	
	/**
	 * 保证措施管理 -- 落实 保证措施	
	 */
	$("#btn_realizeOptGuaranty").click(function(){
		$.zjm_optManager.realizeOptGuaranty();
	});
	
	/**
	 * 保证措施管理 -- 解除 保证措施
	 */
	$("#btn_relieveOptGuaranty").click(function(){
		$.zjm_optManager.relieveOptGuaranty();
	});
	
	/**
	 * 保证措施管理 -- 处置 保证措施
	 */
	$("#btn_disposeOptGuaranty").click(function(){
		$.zjm_optManager.disposeOptGuaranty();
	});
	
	/**
	 * 保证措施管理 -- 删除所选
	 */
	$("#btn_deleteOptGuaranty").click(function(){
		$.zjm_optManager.deleteOptGuaranty();
	});
	
	/**
	 * 保证措施管理 -- 高级查询
	 */
	$("#btn_highOptQuery").click(function(){
		$.zjm_optManager.highOptQuery();
	});
	
	/**
	 * 重置列表
	 */
	$("#btn_refresh").click(function(){
		$.zjm_optManager.initTable();
	});
	
	/**
	 * 保证措施管理 --- 新增 --选择 项目名称
	 */
	$("#btn_chooseProj").click(function(){
		$.zjm_optManager.chooseProj();
	});
	
	/**
	 * 保证措施管理 --- 新增 --选择 权属人
	 */
	$("#btn_choosePerson").click(function(){
		$.zjm_optManager.choosePerson();
	});
	
	/**
	 * 保证措施管理 --- 新增 --新增 -- 权属人
	 */
	$("#btn_addPerson").click(function(){
		$.zjm_optManager.addPerson();
	});
	
	/**
	 *  保证方式处理
	 */
	$("#btn_guarantyTypes").change(function(){
		var _optionText =$("#btn_guarantyTypes").find('option:selected').text();//获取下拉框默认选中文本 text
		var _val= $("#btn_guarantyTypes").val(); // 获取下拉框默认选中的值 value
		$.zjm_optManager.guarantyType(_optionText,_val);
	});
	
	/**
	 * 保证措施管理 --- 退回保证金
	 */
	$("#btn_returnOptSum").click(function(){
		$.zjm_optManager.returnOptSum();
	});
	
});

