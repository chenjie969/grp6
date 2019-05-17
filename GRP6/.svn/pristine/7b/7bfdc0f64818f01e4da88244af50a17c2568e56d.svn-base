(function($,z){
	$.zjm_projectFinishRegister = {
		initPayTable:initPayTable,//初始化-还款-列表
		projectFinishLoss:projectFinishLoss,//核销损失
		projectFinishRegister:projectFinishRegister,//项目完结保存
		colseFinishRegister:colseFinishRegister,//关闭项目完结页面
		
	};
//	window.parent.openMenu('loan','','查看企业咨询情况','/crm/apply/showCrmApplyViewPage','&apply_ID='+row.apply_ID+'&clientType=01',0);
	
	/**初始化-还款-列表***/
	function initPayTable(){
		
		$('#projectPay_table').bootstrapTable('destroy');
		$('#projectPay_table').bootstrapTable({
			method: 'post',
			columns: [	
				        //{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"loadSum",title: '担保金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
						{field:"normalCapitalSum",title: '无代偿解除金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return  tool.isNull(row.normalCapitalSum,"0");}},
						{field:"replaceCapitalSum",title: '代偿解除金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return  tool.isNull(row.replaceCapitalSum,"0");}},
						{field:"returnCapitalSum",title: '追回金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.isNull(row.returnCapitalSum,"0") ;}},
						{field:"notReturnCapitalSum",title: '未追回金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return  tool.isNull(row.returnCapitalSum,"0");}},
						{field:"badSum",title: '损失金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return  tool.isNull(row.badSum,"0");}},
						{field:"badDate",title: '核销日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.badDate);}},
						
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
									   //'<button class="btn_projectPay_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									    '<button class="btn_projectFinish_Loss btn btn-xs btn-info"    href="javascript:void(0)" title="核销损失"  data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
									    ].join('');
							},
							events:{
								'click .btn_projectFinish_Loss': function(e, value, row, index) {
									$.zjm_projectFinishRegister.projectFinishLoss(row);
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
			sortName:"badDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"project_ID":$("#project_ID").val()}; 
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
	//核销损失：
	function projectFinishLoss(){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("提示");//标题;
		$("#delMessage").html("确定要核销损失吗?<p style='color:red'>注 : 此操作是不可恢复的!</p>");//提示信息;		
		tool.undisabled(".btn_submit");
		
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/project/projectFinishLoss',data:JSON.stringify({"project_ID":$("#project_ID").val(),"badSum":$("#badSum").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$("#common_del").modal("hide");
						window.location.reload();
						//$.zjm_projectPayDelayOver.initPayTable();
					}else{
						alert("核销损失失败！");
					}
		        }
			});
		});
		
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	
	}
	//项目完结
	function projectFinishRegister(){
		if($("#projectFinish_form").validationEngine("validate")){
			var queryContainer_form = $("#projectFinish_form");
			$.ajax({type:'POST',url:'/project/project/projectFinishRegister',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					$.zjm_projectFinishRegister.colseFinishRegister();
				}else{
					alert("项目完结失败！");
				}
			}
			});
			
		}else{
			tool.undisabled("#btn_projectFinishRegister");
		}
	
	}
	function colseFinishRegister(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu("openProjectFinish"+project_ID);
	}
	
	
})(jQuery, this);

$(function () {
	
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$('#freeDate').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#txt_id1").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
	
		//$.zjm_projectFinishRegister.initPayTable();
		
     //项目完结：
    $("#btn_projectFinishRegister").click(function(){
    	$.zjm_projectFinishRegister.projectFinishRegister();
    });
		
    //关闭项目完结页面：
    $("#btn_colseFinishRegister").click(function(){
    	$.zjm_projectFinishRegister.colseFinishRegister();
    });
    
    //核销损失：
    $("#btn_projectFinishLoss").click(function(){
    	$.zjm_projectFinishRegister.projectFinishLoss();
    });
    
});

