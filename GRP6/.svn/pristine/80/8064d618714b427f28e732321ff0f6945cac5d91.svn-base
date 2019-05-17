(function($,z){
	$.zjm_creditManager = {
		initTable:initTable,	//初始化列表
		initFundsApplyPage:initFundsApplyPage,	//初始化用款申请模态窗口页面
		viewFundsDetail:viewFundsDetail,	//查看某一授信项下的用款明细	
		rules:rules,	//自定义校验规则
	};
	var resList = [];	
	
	/**初始化主体列表***/
	function initTable(data){
		$('#table_creditManager').bootstrapTable('destroy');
		$('#table_creditManager').bootstrapTable({
			method: 'post',
			singleSelect : true,// 单选checkbox
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"relationID",title: '授信项目类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationID==""?"企业客户":"集团/关联客户";}},
						{field:"busiCode",title: '授信项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
						{field:"projectName",title: '授信项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.projectName;}},
						{field:"creditBeginDate",title: '授信生效日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.creditBeginDate);}},
						{field:"creditEndDate",title: '授信到期日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.creditEndDate);}},
//						{field:"clientBH",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index) { return "流动资金";}},
						{field:"agreeSum",title: '授信额度（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.agreeSum;}},
//						{field:"clientBH",title: '授信期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return "12个月";}},
						{field:"usedSum",title: '已用额度（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.usedSum;}},
						{field:"usableSum",title: '可用额度（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return (row.agreeSum-row.usedSum);}},
						{field:"creditStatus",title: '状态',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.creditStatus=="01"?"已生效":"已失效"}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" title="用款明细" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_creditApply_view': function(e, value, row, index) {
									$.zjm_creditManager.viewFundsDetail(row);
								}
							}
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName: "updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/credit/selectCreditApplyPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"creditStatus":"00"};
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
//        		$.zjm_creditManager.mergeCells();
        	}
		});
	}
	
	function rules (){
		var allRules = {
			"lessThanUsableSum":{
				"func":function(field,rules,i,options){
					console.info(resList);
					var projectApplySum = $("#input_applySum").val();
					if($("#hidden_isBusiLimit").val()==0||$("#hidden_isBlend").val()==1){	//没有业务品种限制，或允许额度混用时，申请金额不超过授信项下总可用额度
						if(projectApplySum <= Number($("#hidden_usableSum").val())){
							return true;
						}else{
							return false;
						}
					}else{	//有业务品种限制且额度不混用，业务品种一定是个下拉框，合作机构显示状态不确定
						var index = $("#select_busiType").children("option:selected").attr("data-index");	//当前选中的业务品种
						if(index==undefined){
							return false;
						}
						var basList = resList[index].basList;	//该业务品种下合作机构的集合
						if($("#div_bank_select").is(":visible")){		//如果合作机构显示的是下拉框, 说明该业务品种下只有固定的合作机构,项目申请金额不超过对应业务与合作机构的可用金额
							var projectBankID = $("#div_bank_select select").children("option:checked").val();	//当前显示的是下拉框,取选中项的值
							for(var i=0; i<basList.length; i++){
								if(projectBankID==basList[i].bankID){	
									if(projectApplySum <= basList[i].usableSum){
										return true;
									}else{
										return false;
									}
								}
							}
						}
						/*如果合作机构显示的是树,授信明细表格中可能有两种情况:
						 * 	1.该业务品种只有一条信息,且合作机构为空;
						 *  2.该业务品种有多条信息,其中一条为空*/
						else{
							if(basList.length==1){	//第1种情况
								if(projectApplySum <= basList[0].usableSum){
									return true;
								}else{
									return false;
								}
							}else{	//第2种情况
								var projectBankID = $("#tree_bank").next("input").val();	//取树的隐藏域中的值(合作机构的ID)
								if(projectBankID==""){		//项目中没有选合作机构, 申请金额小于该业务品种的总可用金额
									if(projectApplySum <= resList[index].resUsableSum){
										return true;
									}else{
										return false;
									}
								}else{		//项目中选择了合作机构
									for(var i=0; i<basList.length; i++){	//遍历该业务品种下的合作机构集合
										if(projectBankID==basList[i].bankID){	//如果匹配到了.申请金额小于对应的可用金额
											if(projectApplySum <= basList[i].usableSum){
												return true;
											}else{
												return false;
											}
										}	
									}
									//如果遍历结束仍没有匹配到,说明项目申请中的合作机构不在授信的合作机构中,申请金额小于该业务品种授信总可用金额
									if(projectApplySum <= resList[index].resUsableSum){
										return true;
									}else{
										return false;
									}
								}
							}
						}
					}
				},
				"alertText": "项目申请金额不能超过可用金额",
			}
		};
		return allRules;
	};
	
	/**
	 * 加载用款申请窗口时执行的函数
	 */
	function initFundsApplyPage(selectContent){
		$("#creditManager_page").load("/project/credit/showFundsApplyAddPage",{"apply_ID":selectContent[0].apply_ID},function(response,status,xhr){
			$("#fundsApplyAdd").modal({keyboard:true});
			/*监视 所有下拉框的选项变化，即时把option的text写到隐藏input中
			 	<select name="...ID"></select>
			 	<input type="hidden" name="...Name"/>*/
			$("select[name]").change(function(){
				var s1 = $(this).attr("name");
				var s2 = $(this).children("option:selected").text();
				var s3 = s1.replace(/ID/,"Name");
				$("input[name='"+s3+"']").val(s2);
			});
			/*客户名称下拉框要单独设置*/
			$("select[name='client_ID']").change(function(){
				var clientName = $(this).children("option:selected").text();
				$(this).next("input").val(clientName);
				$("#input_projectName").val(clientName);
			});
			/*获取业务品种下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#tree_busiType").selectTreeWidgets({
						width : "40%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			/*获取合作机构下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#tree_bank").selectTreeWidgets({
						width : "40%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			/*获取创建部门下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectAllDepartsTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectCreateDepart").selectTreeWidgets({
						width : "40%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			/*获取创建人下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectCreateUser").selectTreeWidgets({
						width : "40%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			/*注册日期控件点击事件*/
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			/*设置日期初始值，默认为当天*/
			$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));
			
			var detailList = JSON.parse($("#hidden_detailList").val());		//将json字符串转成json对象
			if(detailList.length>0){
				/*对业务品种去重后产生一个新的数组 busiIDArr[]*/
				var tmp = {},busiIDArr = [];
				for (var i = 0; i < detailList.length; i++) {
			        if (!tmp[detailList[i].busiTypeID]) {
			            tmp[detailList[i].busiTypeID] = true;
			            busiIDArr.push(detailList[i].busiTypeID);
			        }
			    }
				/*把集合数据再次封装成一个对象数组的形式
				 * 参考  /GRP6/WebRoot/project/credit/apply/creditApplyAdd.js :第510行
				 * */
				resList = [];	
				for(var i=0; i<busiIDArr.length; i++){
					var res = new Object();
					var resAgreeSum = 0;
					var resUsableSum = 0;
					var basList = [];
					res.busiID = busiIDArr[i];
					for(var j=0; j<detailList.length; j++){
						if(busiIDArr[i]==detailList[j].busiTypeID){
							res.busiName = detailList[j].busiTypeName;
							var bas = new Object();
							bas.agreeSum = Number(detailList[j].agreeSum);
							bas.bankName = detailList[j].bankName;
							bas.bankID   = detailList[j].bankID;
							bas.usableSum = Number(detailList[j].agreeSum)-Number(detailList[j].usedSum);
							resAgreeSum += Number(bas.agreeSum);
							resUsableSum += Number(bas.usableSum);
							basList.push(bas);
						}
					}
					res.resAgreeSum = resAgreeSum;
					res.resUsableSum = resUsableSum;
					res.basList = basList;
					resList.push(res);
				}
				//生成项目申请页面的业务品种下拉选择框
				var busiOpts = "<option value=''>请选择</option>";
				for(var i=0; i<resList.length; i++){
					busiOpts += "<option value='"+resList[i].busiID+"' data-index='"+i+"'>"+resList[i].busiName+"</option>";
				}
				$("#select_busiType").empty().append(busiOpts);
				//给业务品种下拉框绑定改变事件，根据业务品种决定合作机构的显示方式
				$("#select_busiType").change(function(){
					var index = $(this).children("option:selected").attr("data-index");
					if(index==null){
						$("#div_bank_tree").show(function(){
							$("#tree_bank").attr({"name":"bankName","autoField":"bankID"})
						});
						$("#div_bank_select").hide(function(){
							$("#div_bank_select select").removeAttr("name");
							$("#div_bank_select select").next("input").removeAttr("name");
						});
						return ;
					}
					var basList = resList[index].basList;
					var bankOpts = "";
					var noBankFlag = false;
					for(var i=0; i<basList.length; i++){
						if(basList[i].bankID==""){
							noBankFlag = true;
							break;
						}else{
							bankOpts += "<option value='"+basList[i].bankID+"'>"+basList[i].bankName+"</option>";
						}
					}
					if(noBankFlag){		//没有指定合作机构，显示树
						$("#div_bank_tree").show(function(){
							$("#tree_bank").attr({"name":"bankName","autoField":"bankID"})
						});
						$("#div_bank_select").hide(function(){
							$("#div_bank_select select").removeAttr("name");
							$("#div_bank_select select").next("input").removeAttr("name");
						});
					}else{				//有合作机构，显示下拉框
						$("#div_bank_tree").hide(function(){
							$("#tree_bank").removeAttr("name autoField");
						});
						$("#div_bank_select").show(function(){
							$("#div_bank_select select").attr("name","bankID");
							$("#div_bank_select select").next("input").attr("name","bankName");
						});
						$("#div_bank_select select").empty().append(bankOpts);
						$("#div_bank_select select").next("input").val($("#div_bank_select select").children("option").eq(0).text());	//设置与合作机构下拉框绑定的隐藏域的值（合作机构名称）
					}
				});
			}
			
			$.zjm.rules = $.zjm_creditManager.rules();
			$(".btn-submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_fundsApply"});
				tool.disabled(".btn-submit");
				var queryContainer_form = $("#form_fundsApply");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/credit/insertOneCreditProjectApply',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
							if(data.obj){
								$("#fundsApplyAdd").modal("hide");
								$.zjm_creditManager.initTable();
							}else{
								tool.undisabled(".btn-submit");
							}
				        }
					});
				}else{
					tool.undisabled(".btn-submit");
				}
			});
			$("#fundsApplyAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn-submit").unbind("click");
			});
		});
	}
	
	/**
	 * 查看某一授信项下的用款明细
	 */
	function viewFundsDetail(row){
		window.parent.openMenu('view_fundsDetailFor'+row.apply_ID,'','用款明细','/project/credit/showFundsDetailPage','&apply_ID='+row.apply_ID);
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_creditManager.initTable();
	};

	/**
	 * 必须且只能先选中一条授信项后，才能点击用款申请
	 */
	$("#btn_fundsApply").click(function(){
		var selectContent = $("#table_creditManager").bootstrapTable('getSelections');
		if(selectContent.length != 1){
			$("#message").text("请选择一条数据，然后再操作！");
			$("#pleaseSelectOne").modal({keyboard:true});
		}else{
			if(selectContent[0].creditStatus=="01"){
				$.zjm_creditManager.initFundsApplyPage(selectContent);
			}else{
				$("#message").text("该授信项已失效，不能再申请用款！");
				$("#pleaseSelectOne").modal({keyboard:true});
			}
		}
	});
	
	/**
	 * 修改选中授信项的状态
	 */
	$("#btn_changeCreditStatus").click(function(){
		var selectContent = $("#table_creditManager").bootstrapTable('getSelections');
		if(selectContent.length != 1){
			$("#message").text("请选择一条数据，然后再操作！");
			$("#pleaseSelectOne").modal({keyboard:true});
		}else{
			$("#creditManager_page").load("/project/credit/showChangeStatusPage",{"apply_ID":selectContent[0].apply_ID},function(response,status,xhr){
				$("#changeStatus").modal({keyboard:true});
				$(".btn_submit").click(function(){
					$.ajax({type:'POST',url:'/project/credit/changeCreditStatus',data:JSON.stringify($("#form_changeStatus").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
							if(data.obj){
								$("#changeStatus").modal("hide");
								$.zjm_creditManager.initTable();
							}else{
								tool.undisabled(".btn-submit");
							}
				        }
					});
				});
				$("#changeStatus").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn-submit").unbind("click");
				});
			});
		}
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_creditManagerAdQuery").click(function(){
		$("#creditManager_page").load("/project/credit/showCreditManagerAdQueryPage",{},function(response,status,xhr){
			$("#creditManagerAdQuery").modal({keyboard:true});
			$(".btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_creditManagerAdQuery"});
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_creditManagerAdQuery");
				if(queryContainer_form.validationEngine("validate")){
					var data = queryContainer_form.serializeJson();
					$.zjm_creditManager.initTable(data);
					$("#creditManagerAdQuery").modal("hide");
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#creditManagerAdQuery").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 重置列表
	 */
	$("#btn_refreshTable").click(function(){
		$.zjm_creditManager.initTable();
	});
	
});

