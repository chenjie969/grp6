(function($,z){
	$.zjm_jobStatus = {
			initTable:initTable,//初始化列表
			addJobStatus:addJobStatus,//添加职务情况
			viewJobStatus:viewJobStatus,//查看职务情况
			editJobStatus:editJobStatus,//修改职务情况		
			loadPage:loadPage//加载页面
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#jobStatus-table").bootstrapTable('destroy');
		$('#jobStatus-table').bootstrapTable({
			method: 'get',
			columns: [{field:"dutyName",title: '职务名称',align: 'center',formatter: function (value, row, index) {return row.dutyName;}}, 
				{field:"dutyDepGID",title: '所属部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.dutyDepGIDName;}},
				{field:"dutySuperior",title: '直接上级',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.dutySuperior;}},
				{field:"superiorLV",title: '职位等级',align: 'center',formatter: function (value, row, index) { return row.superiorLV;}},
				{field:"dutyDirection",title: '晋升方向',align: 'center',formatter: function (value, row, index) { return row.dutyDirection;}},
				{field:"dutySalary",title: '薪资标准',align: 'center',formatter: function (value, row, index) { return row.dutySalary+"元";}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button title ="查看" class="btn_duty_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button title ="修改" class="btn_duty_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button title ="查看" class="btn_duty_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_duty_view': function(e, value, row, index) {
						$.zjm_jobStatus.viewJobStatus(row);
					},
					'click .btn_duty_edit': function(e, value, row, index) {
						$.zjm_jobStatus.editJobStatus(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
				
					var dutyDepGIDName = row.dutyDepGIDName;
					if(dutyDepGIDName == null || dutyDepGIDName==''){						
						dutyDepGIDName="（空）";
					}
					var dutySuperior = row.dutySuperior;
					if(dutySuperior == null || dutySuperior==''){						
						dutySuperior="（空）";
					}
					var superiorLV = row.superiorLV;
					if(superiorLV == null || superiorLV==''){						
						superiorLV="（空）";
					}
					var dutyDirection = row.dutyDirection;
					if(dutyDirection == null || dutyDirection==''){						
						dutyDirection="（空）";
					}
					var dutySalary = row.dutySalary;
					if(dutySalary == null || dutySalary==''){						
						dutySalary="（空）";
					}
					var html = [];
					html.push('<p><b>职务名称:</b> ' + row.dutyName + '</p>');
					html.push('<p><b>所属部门:</b> ' + dutyDepGIDName + '</p>');
					html.push('<p><b>直接上级:</b> ' + dutySuperior + '</p>');
					html.push('<p><b>职位等级:</b> ' + superiorLV + '</p>');
					html.push('<p><b>晋升方向:</b> ' + dutyDirection + '</p>');
					html.push('<p><b>薪资标准:</b> ' + dutySalary +"元"+ '</p>');
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式				
				url: "/oa/staffDuty/selectDutyListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort				
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					 return params;
				},
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	}

	/**添加*/
	function addJobStatus(staffcase_Id){
		$("#employeeUpdate_page").load(
				"/oa/staffDuty/selectDutyAddPage",{"staffcase_Id":staffcase_Id},function(response,status,xhr){
					$("#jobAddModal").modal({keyboard:true});
					
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#jobAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#jobAdd_Form");

								$.ajax({type:'POST',url:'/oa/staffDuty/insertOneDutyInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#jobAddModal").modal("hide");
											$.zjm_jobStatus.initTable(staffcase_Id);
										}else{
											alert("保存失败！");
										}
							        }
								});
							
						}else{
							tool.undisabled(".btn_submit");
						}
					});
					//获取所属部门的树
					
					$.ajax({type:'POST',url:'/selectAllDepartsListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						$("#allDepartsTree3").selectTreeWidgets({
							width : "46%",//设置控件宽度
							multiple : false,//是否多选
							data : data.obj//数据源
						});					
					}
					});
				}
		);
	}
	/**查看*/
	function viewJobStatus(row){
		$("#employeeUpdate_page").load(
				"/oa/staffDuty/selectDutyViewPage",{"dutyID":row.dutyID},function(response,status,xhr){
					$("#jobStatusViewModal").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function editJobStatus(row){
		$("#employeeUpdate_page").load(
				"/oa/staffDuty/selectDutyEditPage",{"dutyID":row.dutyID},function(response,status,xhr){
					$("#jobUpdateModal").modal({keyboard:true});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#jobUpdate_Form").validationEngine("validate")){
							var queryContainer_form = $("#jobUpdate_Form");
								$.ajax({type:'POST',url:'/oa/staffDuty/updateOneDutyInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#jobUpdateModal").modal("hide");
											$.zjm_jobStatus.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
										}
							        }
								});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
					//获取创建部门的树
					
					$.ajax({type:'POST',url:'/selectAllDepartsListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						$("#allDepartsTree3").selectTreeWidgets({
							width : "46%",//设置控件宽度
							multiple : false,//是否多选
							data : data.obj//数据源
						});	
					
					
					}
					});
				}
		);
	}
	
	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#seven").load("/oa/staffDuty/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){
			$.zjm_jobStatus.initTable(staffcase_Id);
			$("#btn_jobStatusAdd").click(function(){				
				$.zjm_jobStatus.addJobStatus(staffcase_Id);
			});
		});
	}
	
	
})(jQuery, this);

	$(function () {		
		$("#jobStatus").click(function(){
			var dutyID=$("#dutyID").val();
			$.zjm_jobStatus.loadPage();
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
						$.zjm_jobStatus.initTable();
					}else{
						alert("保存失败！");
						$.zjm_jobStatus.initTable();
					}
				}
				});
			});
			$(".btn_reset").click(function () {
				zjm.dataSortVal("/sys/roles/selectRolesListJSON",{});
			});
		
		});
	});

