(function($,z){
	$.zjm_medical= {
			initTable:initTable,//初始化列表
			medicalAdd:medicalAdd,//添加提检记录
			medicalView:medicalView,//查看体检纪律
			medicalEdit:medicalEdit,//修改体检记录
			loadPage:loadPage//加载页面
	
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#medical-table").bootstrapTable('destroy');
		$('#medical-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
				{title: '体检日期',align: 'center',formatter: function (value, row, index) {return tool.parseDate(row.medicalDate);}}, 
				{title: '体检费用(元)',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.medicalFees ;}},
				{title: '体检情况',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.medicalInfo;}},
				{title: '体检医疗机构',align: 'center',formatter: function (value, row, index) { return row.medicalAgencies;}},
				{title: '备注',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.medicalNotes;}},			
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button class="btn_medical_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_medical_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button class="btn_medical_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_medical_view': function(e, value, row, index) {
						$.zjm_medical.medicalView(row);
					},
					'click .btn_medical_edit': function(e, value, row, index) {
						$.zjm_medical.medicalEdit(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>体检日期:</b> ' + tool.parseDate(row.medicalDate) + '</p>');
					html.push('<p><b>体检费用:</b> ' + row.medicalFees + '</p>');
					html.push('<p><b>体检情况:</b> ' + row.medicalInfo + '</p>');
					html.push('<p><b>体检医疗机构:</b> ' + row.medicalAgencies + '</p>');
					html.push('<p><b>备注:</b> ' + row.medicalNotes + '</p>');	
					
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/medical/selectMedicalTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort	
				queryParams: function(params) {
					$.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					return params;
				},
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	};
	
	/**添加*/
	function medicalAdd(){	
		$("#manager_page").load("/oa/medical/showMedicalAdd",{},function(response,status,xhr){
					$("#medicalAdd").modal({keyboard:true});
					/*注册编辑验证引擎*/
					zjm.validata({formId:"medicalAdd_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						var staffcase_Id = $("#staffcase_Id").val();
						$("#staffcaseId").val(staffcase_Id);
						tool.disabled(".btn_submit");
						if($("#medicalAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#medicalAdd_Form");
								$.ajax({type:'POST',url:'/oa/medical/insertOneMedical',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
									success:function(data) {
							        	if(data.obj){
											$("#medicalAdd").modal("hide");
											$.zjm_medical.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
							        }
								});
							}else{
								tool.undisabled(".btn_submit");
							}
						$("#medicalAdd").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
						});
					});
				});
			}
	/**查看体检记录*/
	function medicalView(row){
		$("#manager_page").load("/oa/medical/selectOneMedical",{"medicalID":row.medicalID,"operationType":"view"},function(response,status,xhr){
			$("#medicalView").modal({keyboard:true});
		});
	}
	/**修改*/
	function medicalEdit(row){
		$("#manager_page").load("/oa/medical/selectOneMedical",{"medicalID":row.medicalID,"operationType":"update"},function(response,status,xhr){
					$("#medicalUpdate").modal({keyboard:true});
					// 注册编辑验证引擎
					zjm.validata({formId:"medicalUpdate_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#medicalUpdate_Form").validationEngine("validate")){
							var queryContainer_form = $("#medicalUpdate_Form");
								$.ajax({type:'POST',url:'/oa/medical/updateOneMedical',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj){
											$("#medicalUpdate").modal("hide");
											$.zjm_medical.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
							        }
								});
						}else{
							tool.undisabled(".btn_submit");
						}
						$("#medicalUpdate").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
					});
				});
		});
	}

	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#twelve").load("/oa/medical/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){
			$.zjm_medical.initTable(staffcase_Id);
			$("#btn_medicalAdd").click(function(){				
				$.zjm_medical.medicalAdd(staffcase_Id);
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$("#medical").click(function(){
		
		$.zjm_medical.loadPage();
	});
	
	$("#btn_medicalAdd").click(function(){
		$.zjm_medical.medicalAdd();
	});
});