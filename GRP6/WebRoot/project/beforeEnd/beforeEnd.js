(function($,z){
	$.zjm_beforeEnd = {
		initFactLoanTable:initFactLoanTable,	//实际放款情况
		addBeforeEnd:addBeforeEnd,
		customRules:customRules
	};
	
	var applyID = $("#hidden_applyID").val();
	
	/**初始化实际放款列表***/
	function initFactLoanTable(){
		$('#table_factLoan').bootstrapTable('destroy');
		$('#table_factLoan').bootstrapTable({
			method: 'post',
			columns: [	//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
//						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"",title: '笔',align: 'center',formatter: function (value, row, index) { return "第"+(index+1)+"笔";}},
						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"loadSum",title: '放款金额（万元）',align: 'center',formatter: function (value, row, index) { return row.loadSum;}},
						{field:"loadBeginDate",title: '担保起始日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.loadBeginDate);}},
						{field:"loadEndDate",title: '担保到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.loadEndDate);}},
						{field:"billBeginDate",title: '借据起始日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.billBeginDate);}},
						{field:"billEndDate",title: '借据到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.billEndDate);}},
						{field:"beforeEndSum",title: '提前到期金额',align: 'center',formatter: function (value, row, index) { return row.beforeEndSum;}},
						{field:"beforeEndDate",title: '提前到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.beforeEndDate);}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if(!row.isBeforeEnd){
									return '<a class="btn_beforeEnd_view" href="javascript:void(0)">提前到期</a>';
								}
							},
							events:{
								'click .btn_beforeEnd_view': function(e, value, row, index) {
									$.zjm_beforeEnd.addBeforeEnd(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>笔数：</b> ' + "第"+(index+1)+"笔" + '</p>');
			        html.push('<p><b>项目编号：</b> ' + row.projectCode + '</p>');
			        html.push('<p><b>业务品种：</b> ' + row.busiTypeName + '</p>');
			        html.push('<p><b>放款机构：</b> ' + row.bankName + '</p>');
			        html.push('<p><b>放款子机构：</b> ' + row.subBankName + '</p>');
			        html.push('<p><b>放款金额：</b> ' + row.loadSum + '万元</p>');
			        html.push('<p><b>担保起始日期：</b> ' + tool.parseDate(row.loadBeginDate) + '</p>');
			        html.push('<p><b>担保到期日期：</b> ' + tool.parseDate(row.loadEndDate) + '</p>');
			        html.push('<p><b>借据起始日期：</b> ' + tool.parseDate(row.billBeginDate) + '</p>');
			        html.push('<p><b>借据到期日期：</b> ' + tool.parseDate(row.billEndDate) + '</p>');
				    if(row.isBeforeEnd){
				    	html.push('<p><b>提前到期金额：</b> ' + row.beforeEndSum + '万元</p>');
				    	html.push('<p><b>提前到期日期：</b> ' + tool.parseDate(row.beforeEndDate) + '</p>');
				    	html.push('<p><b>提前到期原因：</b> ' + tool.isNull(row.beforeEndDesc,"（空）") + '</p>');
				    }
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**
	 * 提前到期确认
	 */
	function addBeforeEnd(row){
		$("#beforeEnd_page").load("/project/project/showBeforeEndAddPage",{"project_ID":row.project_ID},function(response,status,xhr){
			$("#beforeEndAdd").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_beforeEndAdd"});
			$.zjm.rules = customRules();	
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_beforeEndAdd");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/project/updateBeforeEndInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#confirmLoan").modal("hide");
								$.zjm_reviewLoan.initPlanLoanTable();
								$.zjm_reviewLoan.initFactLoanTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#beforeEndAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	function customRules(){
		var allRules = {
			"isLessThanLoanSum":{
				"func":function(field,rules,i,options){
					var loadSum = Number($("#loadSum").text());
					var beforeEndSum = Number($("#beforeEndSum").val());
					if(loadSum >= beforeEndSum){		
						return true;
					}else{
						return false;
					}
				},
				"alertText": "提前到期金额不能超过实际放款金额",
			}
		};
		return allRules;
	}
	
})(jQuery, this);

$(function () {
	
	$.zjm_beforeEnd.initFactLoanTable();
	
});

