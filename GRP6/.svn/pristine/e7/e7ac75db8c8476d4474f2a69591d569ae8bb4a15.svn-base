(function($,z){
	$.zjm_socialInsurance= {
			initTable:initTable,//初始化列表
			socialInsuranceView:socialInsuranceView,//查看社保情况
			socialInsuranceEdit:socialInsuranceEdit,//修改社保情况
			socialInsuranceAdd:socialInsuranceAdd,//添加社保
			loadPage:loadPage//加载页面
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#socialInsurance-table").bootstrapTable('destroy');
		$('#socialInsurance-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
				{title: '缴纳年月',align: 'center',formatter: function (value, row, index) {return row.socialInsuranceDate;}}, 
				{title: '养老(元)',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialInsurancePension; }},
				{title: '工伤(元)',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialInsuranceInjury;}},
				{title: '医疗(元)',align: 'center',formatter: function (value, row, index) { return row.socialInsuranceMedical ;}},
				{title: '生育(元)',align: 'center',formatter: function (value, row, index) { return row.socialInsuranceFertility ;}},
				{title: '失业(元)',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialInsuranceUnemploy;}},			
				{title: '小计(元)',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialInsuranceCum ;}},			
				{title: '备注',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialInsuranceNotes ;}},			
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button class="btn_socialInsurance_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_socialInsurance_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button class="btn_socialInsurance_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_socialInsurance_view': function(e, value, row, index) {
						$.zjm_socialInsurance.socialInsuranceView(row);
					},
					'click .btn_socialInsurance_edit': function(e, value, row, index) {
						$.zjm_socialInsurance.socialInsuranceEdit(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>缴纳年月:</b> ' + tool.parseDate(row.socialInsuranceDate) + '</p>');
					html.push('<p><b>养老:</b> ' + row.socialInsurancePension + '</p>');
					html.push('<p><b>工伤:</b> ' + row.socialInsuranceInjury + '</p>');
					html.push('<p><b>医疗:</b> ' + row.socialInsuranceMedical+ '</p>');
					html.push('<p><b>生育:</b> ' + row.socialInsuranceFertility + '</p>');
					html.push('<p><b>失业:</b> ' + row.socialInsuranceUnemploy + '</p>');
					html.push('<p><b>小计:</b> ' + row.socialInsuranceCum + '</p>');
					html.push('<p><b>备注:</b> ' + row.socialInsuranceNotes + '</p>');		
					
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/socialInsurance/selectSocialInsuranceTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				queryParams: function(params) {
					$.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					return params;
				},
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	}
	
	
	/**添加*/
	function socialInsuranceAdd(){
		$("#manager_page").load("/oa/socialInsurance/showSocialInsuranceAdd",{},function(response,status,xhr){
					$("#socialInsuranceAdd").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						var staffcase_Id = $("#staffcase_Id").val();
						$("#staffcaseId").val(staffcase_Id);
						tool.disabled(".btn_submit");
						if($("#socialInsuranceAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#socialInsuranceAdd_Form");
								$.ajax({type:'POST',url:'/oa/socialInsurance/insertOneSocialInsurance',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj){
											$("#socialInsuranceAdd").modal("hide");
											$.zjm_socialInsurance.initTable(staffcase_Id);
									
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
								  }
						    });
							
						}else{
							tool.undisabled(".btn_submit");
						}
						$("#socialInsuranceAdd").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
						});
					});
				});
			}
	
	
	
	
	/**查看*/
	function socialInsuranceView(row){
		$("#manager_page").load("/oa/socialInsurance/selectOneSocialInsurance",{"socialInsuranceID":row.socialInsuranceID,"operationType":"view"},
			function(response,status,xhr){
				$("#socialInsuranceView").modal({keyboard:true});
		});
	}
	/**修改*/
	function socialInsuranceEdit(row){
		$("#manager_page").load("/oa/socialInsurance/selectOneSocialInsurance",{"socialInsuranceID":row.socialInsuranceID,"operationType":"update"},function(response,status,xhr){
					$("#socialInsuranceUpdate").modal({keyboard:true});
					zjm.init();
					// 注册编辑验证引擎
					zjm.validata({formId:"socialInsuranceUpdate_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#socialInsuranceUpdate_Form").validationEngine("validate")){
							var queryContainer_form = $("#socialInsuranceUpdate_Form");
							$.ajax({type:'POST',url:'/oa/socialInsurance/updateOneSocialInsurance',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj){
									$("#socialInsuranceUpdate").modal("hide");
									$.zjm_socialInsurance.initTable($("#staffcase_Id").val());
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								 }
						        }
							});
						}else{
							tool.undisabled(".btn_submit");
						}
						$("#socialInsuranceUpdate").on("hidden.bs.modal", function (e) {
								 $(".btn_submit").unbind("click");
						});
					});
			});
		}
	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#eleven").load("/oa/socialInsurance/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){
			$.zjm_socialInsurance.initTable(staffcase_Id);
			$("#btn_socialInsuranceAdd").click(function(){				
				$.zjm_socialInsurance.socialInsuranceAdd(staffcase_Id);
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$("#socialInsurance").click(function(){
		
		$.zjm_socialInsurance.loadPage();
	});
	
	$("#btn_socialInsuranceAdd").click(function(){
		$.zjm_socialInsurance.socialInsuranceAdd();
	});
});