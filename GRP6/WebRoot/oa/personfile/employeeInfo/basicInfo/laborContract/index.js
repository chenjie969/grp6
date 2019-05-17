(function($,z){
	$.zjm_laborContract = {
			initTable:initTable,//初始化列表
			laborContractAdd:laborContractAdd,//添加劳务合同
			laborContractView:laborContractView,//查看劳务合同情况	
			laborContractEdit:laborContractEdit,//修改劳务合同
			loadPage:loadPage//加载页面
				
	};
	//增加
	function laborContractAdd(){
		$("#manager_page").load("/oa/laborContract/showLaborContractAdd",{},function(response,status,xhr){
			$("#laborContractAdd").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"laborContractAdd_Form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				var staffcase_Id = $("#staffcase_Id").val();
				$("#staffcaseId").val(staffcase_Id);
				var user_uid = $("#user_uid").val();
				$("#user_uid").val(user_uid);
				tool.disabled(".btn_submit");
				if($("#laborContractAdd_Form").validationEngine("validate")){
					var queryContainer_form = $("#laborContractAdd_Form");
					$.ajax({type:'POST',url:'/oa/laborContract/insertOneLaborContract',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#laborContractAdd").modal("hide");
								$.zjm_laborContract.initTable(staffcase_Id);
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
				$("#laborContractAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
		});
	}
	//更新
	function laborContractEdit(row){
		$("#manager_page").load("/oa/laborContract/selectOneContract",{"laborContractID":row.laborContractID,"operationType":"update"},function(response,status,xhr){
			$("#laborContractUpdate").modal({keyboard:true});
			// 注册编辑验证引擎
			zjm.validata({formId:"laborContractUpdate_Form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#laborContractUpdate_Form").validationEngine("validate")){
					var queryContainer_form = $("#laborContractUpdate_Form");
					$.ajax({type:'POST',url:'/oa/laborContract/updateOneContract',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#laborContractUpdate").modal("hide");
								$.zjm_laborContract.initTable($("#staffcase_Id").val());
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
				$("#laborContractUpdate").on("hidden.bs.modal", function (e) {
					 $(".btn_submit").unbind("click");
				});
			});
		});
	}
       //查询合同
	function laborContractView(row){
		$("#manager_page").load("/oa/laborContract/selectOneContract",{"laborContractID":row.laborContractID,"operationType":"veiw"},function(response,status,xhr){
			$("#laborContractView").modal({keyboard:true});
		});
	}
	
	
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#laborContract_table").bootstrapTable('destroy');
		$('#laborContract_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}}, 
				{title: ' 签订起止日期',align: 'center',formatter: function (value, row, index) {return tool.parseDate(row.laborContractStartDate)+"至"+tool.parseDate(row.laborContractEndDate);}}, 
				{title: '签订期限(年)',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.laborContractPeriod ;}},
				{title: '劳动合同类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.laborContractType;}},
				{title: '签订日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.laborContractDate);}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button class="btn_laborContract_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_laborContract_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button class="btn_laborContract_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_laborContract_view': function(e, value, row, index) {
						$.zjm_laborContract.laborContractView(row);
					},
					'click .btn_laborContract_edit': function(e, value, row, index) {
						$.zjm_laborContract.laborContractEdit(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>签订起止日期:</b> ' + tool.parseDate(row.laborContractStartDate)+"至"+tool.parseDate(row.laborContractEndDate) + '</p>');
					html.push('<p><b>签订期限(年):</b> ' + row.laborContractPeriod + '</p>');
					html.push('<p><b>劳动合同类型:</b> ' + row.laborContractType + '</p>');
					html.push('<p><b>签订日期:</b> ' + tool.parseDate(row.laborContractDate) + '</p>');
					
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/laborContract/selectContractTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server"
				
		});
	}
	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#ten").load("/oa/laborContract/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){
			$.zjm_laborContract.initTable(staffcase_Id);
			$("#btn_laborContractAdd").click(function(){				
				$.zjm_laborContract.laborContractAdd(staffcase_Id);
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$("#laborContract").click(function(){
		
		$.zjm_laborContract.loadPage();
	});
	
	$("#btn_laborContractAdd").click(function(){
		$.zjm_laborContract.laborContractAdd();
	});
});