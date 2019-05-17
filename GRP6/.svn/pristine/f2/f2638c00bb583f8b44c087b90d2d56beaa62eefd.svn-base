(function($,z){
	$.zjm_resume = {
			initTable:initTable,//初始化列表
			addResume:addResume,//添加工作简历
			viewResume:viewResume,//查看工作简历
			editResume:editResume,//修改简历
			loadPage:loadPage//加载页面	
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#resume-table").bootstrapTable('destroy');
		$('#resume-table').bootstrapTable({
			method: 'get',
			columns: [{title: '起止年月',align: 'center',formatter: function (value, row, index) {return row.jobStartDate+"至"+row.jobEndDate;}}, 
				{field:"jobUnits",title: '工作单位',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.jobUnits;}},
				{field:"jobAddress",title: '地点',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.jobAddress;}},
				{field:"jobposts",title: '职务',align: 'center',formatter: function (value, row, index) { return row.jobposts;}},
				{field:"jobNotes",title: '备注',align: 'center',formatter: function (value, row, index) { return row.jobNotes;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button title ="查看" class="btn_resume_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button  title ="修改" class="btn_resume_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button title ="查看" class="btn_resume_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_resume_view': function(e, value, row, index) {
						$.zjm_resume.viewResume(row);
					},
					'click .btn_resume_edit': function(e, value, row, index) {
						$.zjm_resume.editResume(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){	
					var jobAddress = row.jobAddress;
			
					if(jobAddress == null ||jobAddress ==''){						
	
						jobAddress="（空）";
					}
					var jobNotes = row.jobNotes;
	
					if(jobNotes == null ||jobNotes ==''){						
				
						jobNotes="（空）";
					}	
						
					var html = [];
					html.push('<p><b>起止年月:</b> ' + row.jobStartDate+"至"+row.jobEndDate + '</p>');
					html.push('<p><b>工作单位:</b> ' + row.jobUnits + '</p>');
					html.push('<p><b>地点:</b> ' + jobAddress + '</p>');
					html.push('<p><b>职务:</b> ' + row.jobposts + '</p>');
					html.push('<p><b>备注:</b> ' + jobNotes + '</p>');
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）						
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式			
				url: "/oa/job/selectResumeListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort				
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					 return params;
				},
				
				sidePagination: "server",   //分页方式：分页，server服务端分页（*）          
		});
	}
	/**添加*/
	function addResume(staffcase_Id){
		$("#employeeUpdate_page").load(
				"/oa/job/selectJobAddPage",{"staffcase_Id":staffcase_Id},function(response,status,xhr){
					$("#addResumeModal").modal({keyboard:true});	
					$('.date-pickerMonth').datepicker({
						language: "zh-CN",
					    todayHighlight: true,
					    autoclose: true,
					    startView: 'months',
					    maxViewMode:'years',
					    minViewMode:'months'
					}).next().on(ace.click_event, function(){$(this).prev().focus();});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");			
						if($("#addResume_Form").validationEngine("validate")){
							var queryContainer_form = $("#addResume_Form");		
							
								$.ajax({type:'POST',url:'/oa/job/insertOneJobInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#addResumeModal").modal("hide");	
											$.zjm_resume.initTable(staffcase_Id);
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
	function viewResume(row){
		$("#employeeUpdate_page").load(
				"/oa/job/selectJobViewPage",{"jobID":row.jobID},function(response,status,xhr){
					$("#resumeViewModal").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function editResume(row){
		$("#employeeUpdate_page").load(
				"/oa/job/selectJobEditPage",{"jobID":row.jobID},function(response,status,xhr){
					$("#updateResumeModal").modal({keyboard:true});				
					tool.undisabled(".btn_submit");
					$('.date-pickerMonth').datepicker({
						language: "zh-CN",
					    todayHighlight: true,
					    autoclose: true,
					    startView: 'months',
					    maxViewMode:'years',
					    minViewMode:'months'
					}).next().on(ace.click_event, function(){$(this).prev().focus();});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#updateResume_Form").validationEngine("validate")){							
							var queryContainer_form = $("#updateResume_Form");
								$.ajax({type:'POST',url:'/oa/job/updateOnePostInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#updateResumeModal").modal("hide");
											$.zjm_resume.initTable($("#staffcase_Id").val());
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
		$("#four").load("/oa/job/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){		
			$.zjm_resume.initTable(staffcase_Id);
			$("#btn_resumeAdd").click(function(){
				$.zjm_resume.addResume(staffcase_Id);
			});
		});
	}

})(jQuery, this);
	$(function () {
		$("#resume").click(function(){	
			var jobID=$("#jobID").val();
			$.zjm_resume.loadPage();
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
						$.zjm_resume.initTable();
					}else{
						alert("保存失败！");
						$.zjm_resume.initTable();
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

