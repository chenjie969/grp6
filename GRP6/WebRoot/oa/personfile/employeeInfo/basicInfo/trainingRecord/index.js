(function($,z){
	$.zjm_trainRecord= {
			initTable:initTable,//初始化列表
			trainingView:trainingView,//查看培训记录
			trainingEdit:trainingEdit,//修改培训记录
			trainingAdd:trainingAdd,//添加培训记录
			loadPage:loadPage//加载页面

	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#trainRecord-table").bootstrapTable('destroy');
		$('#trainRecord-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}}, 
				{title: '年度',align: 'center',formatter: function (value, row, index) {return row.trainingYear;}}, 
				{title: '培训名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.trainingName;}},
				{title: '期间',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.trainingPeriod;}},
				{title: '费用(元)',align: 'center',formatter: function (value, row, index) { return row.trainingFees;}},
				{title: '备注',align: 'center',formatter: function (value, row, index) { return row.trainingNotes;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button class="btn_training_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_training_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button class="btn_training_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_training_view': function(e, value, row, index) {
						$.zjm_trainRecord.trainingView(row);
					},
					'click .btn_training_edit': function(e, value, row, index) {
						$.zjm_trainRecord.trainingEdit(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>年度:</b> ' + row.trainingYear+ '</p>');
					html.push('<p><b>培训名称:</b> ' + row.trainingName + '</p>');
					html.push('<p><b>期间:</b> ' + row.trainingPeriod + '</p>');
					html.push('<p><b>费用:</b> ' + row.trainingFees + '</p>');
					html.push('<p><b>备注:</b> ' + row.trainingNotes + '</p>');
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/training/selectTrainingTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				queryParams: function(params) {
					$.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	};
		
	/**添加*/
	function trainingAdd(){
		$("#manager_page").load("/oa/training/showTrainingAdd",{},function(response,status,xhr){
			$("#trainingAdd").modal({keyboard:true});
					/*注册编辑验证引擎*/
					zjm.validata({formId:"trainingAdd_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						var staffcase_Id = $("#staffcase_Id").val();
						$("#staffcaseId").val(staffcase_Id);
						tool.disabled(".btn_submit");
						if($("#trainingAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#trainingAdd_Form");
								$.ajax({type:'POST',url:'/oa/training/insertOneTraining',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj){
											$("#trainingAdd").modal("hide");
											$.zjm_trainRecord.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
						        }
							});
						}else{
							tool.undisabled(".btn_submit");
						}
					$("#trainingAdd").on("hidden.bs.modal", function (e) {
						 $(".btn_submit").unbind("click");
					});
				});
			});
		}
	/**查看*/
	function trainingView(row){
		$("#manager_page").load("/oa/training/selectOneTraining",{"trainingID":row.trainingID,"operationType":"view"},function(response,status,xhr){
					$("#trainingView").modal({keyboard:true});
				});
	}
	/**修改*/
	function trainingEdit(row){
		$("#manager_page").load("/oa/training/selectOneTraining",{"trainingID":row.trainingID,"operationType":"update"},function(response,status,xhr){
					$("#trainingUpdate").modal({keyboard:true});
					zjm.validata({formId:"trainingUpdate_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#trainingUpdate_Form").validationEngine("validate")){
							var queryContainer_form = $("#trainingUpdate_Form");
								$.ajax({type:'POST',url:'/oa/training/updateOneTraining',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj){
											$("#trainingUpdate").modal("hide");
											$.zjm_trainRecord.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
							        }
								});
						}else{
							tool.undisabled(".btn_submit");
						}
						$("#trainingUpdate").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
					});
				});
		});
	}
	
	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#eight").load("/oa/training/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){
			$.zjm_trainRecord.initTable(staffcase_Id);
			$("#btn_trainingAdd").click(function(){				
				$.zjm_trainRecord.trainingAdd(staffcase_Id);
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$("#trainingRecord").click(function(){
		
		$.zjm_trainRecord.loadPage();
	});
	
	$("#btn_trainingAdd").click(function(){
		$.zjm_trainRecord.trainingAdd();
	});
});