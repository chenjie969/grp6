(function($,z){
	$.zjm_educationBackground = {
			initTable:initTable,//初始化列表
			viewEduBack:viewEduBack,//查看教育背景
			editEduBack:editEduBack,//修改教育背景
			addEduBack:addEduBack,//添加教育背景
			loadPage:loadPage//加载页面
			
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#educationBackground-table").bootstrapTable('destroy');
		$('#educationBackground-table').bootstrapTable({
			method: 'get',
			columns: [{title: '起止年月',align: 'center',formatter: function (value, row, index) {return row.educationStartDate+"至"+row.educationEndDate;}}, 
				{field:"educationSchool",title: '学校',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.educationSchool;}},
				{field:"educationAddress",title: '地点',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.educationAddress;}},
				{field:"educationRecordName",title: '学历',align: 'center',formatter: function (value, row, index) { return row.educationRecordName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button  title ="查看" class="btn_viewEduBack_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button title ="修改" class="btn_editEduBack_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button title ="查看" class="btn_viewEduBack_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_viewEduBack_view': function(e, value, row, index) {
						$.zjm_educationBackground.viewEduBack(row);
					},
					'click .btn_editEduBack_edit': function(e, value, row, index) {
						$.zjm_educationBackground.editEduBack(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var educationRecordName = row.educationRecordName;
					if(educationRecordName == null){	
						educationRecordName="（空）";
					}
					var html = [];
					html.push('<p><b>起止年月:</b> ' +row.educationStartDate+"至"+row.educationEndDate + '</p>');
					html.push('<p><b>学校:</b> ' + row.educationSchool + '</p>');
					html.push('<p><b>地点:</b> ' + row.educationAddress + '</p>');
					html.push('<p><b>学历:</b> ' + educationRecordName + '</p>');
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/oa/educationBackground/selectEduListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort	
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					 return params;
				},
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	}

	/**添加*/
	function addEduBack(staffcase_Id){
		$("#employeeUpdate_page").load(
				"/oa/educationBackground/educationBackgroundAddPage",{"staffcase_Id":staffcase_Id},function(response,status,xhr){
			
					$("#addEduBackModal").modal({keyboard:true});	
				$('.date-pickeryear').datepicker({
						language: "zh-CN",
					    todayHighlight: true,
					    autoclose: true,
					    startView: 'months',
					    maxViewMode:'years',
					    minViewMode:'months'
					}).next().on(ace.click_event, function(){$(this).prev().focus();});
			
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#eduBackAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#eduBackAdd_Form");							
								$.ajax({type:'POST',url:'/oa/educationBackground/insertOneEducationInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {							        	
									if(data.obj==1){
											$("#addEduBackModal").modal("hide");	
											$.zjm_educationBackground.initTable(staffcase_Id);
										}else{
											alert("保存失败！");
										}
							        }
								});

						}else{						
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
		
	/**查看*/
	function viewEduBack(row){
		
		$("#employeeUpdate_page").load(
				"/oa/educationBackground/selectEducationViewPage",{"educationID":row.educationID},function(response,status,xhr){
					$("#educationBackgroundModal").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function editEduBack(row){
		$("#employeeUpdate_page").load(
				"/oa/educationBackground/selecteducationBackgroundEditPage",{"educationID":row.educationID},function(response,status,xhr){
					$("#updateEduModal").modal({keyboard:true});
			$('.date-pickeryear').datepicker({
						language: "zh-CN",
					    todayHighlight: true,
					    autoclose: true,
					    startView: 'months',
					    maxViewMode:'years',
					    minViewMode:'months'
					}).next().on(ace.click_event, function(){$(this).prev().focus();});					
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){						
						tool.disabled(".btn_submit");
						if($("#updateEduBack_Form").validationEngine("validate")){
							var queryContainer_form = $("#updateEduBack_Form");						
								$.ajax({type:'POST',url:'/oa/educationBackground/updateOneEducationInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#updateEduModal").modal("hide");
											$.zjm_educationBackground.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
										}
							        }
								});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	function loadPage(){	
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#three").load("/oa/educationBackground/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){		
			$.zjm_educationBackground.initTable(staffcase_Id);
			$("#btn_addEduBack").click(function(){
				$.zjm_educationBackground.addEduBack(staffcase_Id);
			});
		});
	}
	
})(jQuery, this);
	$(function () {		
		$("#education").click(function(){	
			var educationID=$("#educationID").val();
			$.zjm_educationBackground.loadPage();
		});	
		$("#btn_sort").click(function(){
			$("#sortop").modal({keyboard:true});
			zjm.dataSortVal("/sys/roles/selectRolesListJSON",{});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"sys_roles","tableFileName":"role_uid","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==1){
						$("#sortop").modal("hide");
						$.zjm_educationBackground.initTable();
					}else{
						alert("保存失败！");
						$.zjm_educationBackground.initTable();
					}
				}
				});
			});
			$(".btn_reset").click(function () {
				zjm.dataSortVal("/sys/roles/selectRolesListJSON",{});
			});
			$("#sortop").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_reset").unbind("click");
				$(".btn_submit").unbind("click");
				$("#btn_moveUp").unbind("click");
				$("#btn_moveDown").unbind("click");
				$("#btn_moveTop").unbind("click");
				$("#btn_moveBottom").unbind("click");
			});
		});
	});

