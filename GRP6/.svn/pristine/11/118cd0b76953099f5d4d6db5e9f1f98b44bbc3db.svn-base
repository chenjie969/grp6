(function($,z){
	$.zjm_socialRelation= {
			initTable:initTable,//初始化列表
			viewsocialRelation:viewsocialRelation,//查看社会关系
			editsocialRelation:editsocialRelation,//修改社会关系
			addsocialRelation:addsocialRelation,//添加社会关系
			loadPage:loadPage//加载页面
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#socialRelation-table").bootstrapTable('destroy');
		$('#socialRelation-table').bootstrapTable({
			method: 'get',		
			columns: [{field:"socialName",title: '姓名',align: 'center',formatter: function (value, row, index) {return row.socialName;}}, 
				{field:"socialSex",title: '性别',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialSex;}},
				{field:"socialAge",title: '年龄',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialAge;}},
				{field:"socialType",title: '与之关系',align: 'center',formatter: function (value, row, index) { return row.socialType;}},
				{field:"socialAddress",title: '所在城市',align: 'center',formatter: function (value, row, index) { return row.socialAddress;}},
				{field:"socialUnits",title: '工作单位',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.socialUnits;}},			
				{field:"socialDuty",title: '职务',align: 'center',formatter: function (value, row, index) { return row.socialDuty;}},	
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button title ="查看" class="btn_relation_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button  title ="修改" class="btn_relation_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button title ="查看"  class="btn_relation_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_relation_view': function(e, value, row, index) {
						$.zjm_socialRelation.viewsocialRelation(row);
					},
					'click .btn_relation_edit': function(e, value, row, index) {
						$.zjm_socialRelation.editsocialRelation(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
				
					var socialAge = row.socialAge;
					if(socialAge == null ||socialAge ==''){						
						socialAge="（空）";
					}
					var socialAddress = row.socialAddress;
					if(socialAddress == null ||socialAddress ==''){						
						socialAddress="（空）";
					}		
					var socialUnits = row.socialUnits;
					if(socialUnits == null ||socialUnits ==''){						
						socialUnits="（空）";
					}	
					var socialDuty = row.socialDuty;
					if(socialDuty == null ||socialDuty ==''){						
						socialDuty="（空）";
					}	
					var html = [];
					html.push('<p><b>姓名:</b> ' + row.socialName + '</p>');
					html.push('<p><b>性别:</b> ' + row.socialSex + '</p>');
					html.push('<p><b>年龄:</b> ' + socialAge + '</p>');
					html.push('<p><b>与之关系:</b> ' + row.socialType + '</p>');
					html.push('<p><b>所在城市:</b> ' + socialAddress + '</p>');
					html.push('<p><b>工作单位:</b> ' + socialUnits + '</p>');
					html.push('<p><b>职务:</b> ' + socialDuty + '</p>');
					
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/oa/socialRelation/selectRelationListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort				
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort				
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					 return params;
				},
				
				sidePagination: "server",   //分页方式：分页，server服务端分页（*）          
						
		});
	}
	/**添加*/
	function addsocialRelation(staffcase_Id){
		$("#employeeUpdate_page").load(
				"/oa/socialRelation/selectRelationAddPage",{"staffcase_Id":staffcase_Id},function(response,status,xhr){
					$("#addSocialRelaViewModal").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#addSocialRela_Form").validationEngine("validate")){
							var queryContainer_form = $("#addSocialRela_Form");
						$.ajax({type:'POST',url:'/oa/socialRelation/insertOneRelationInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#addSocialRelaViewModal").modal("hide");
											$.zjm_socialRelation.initTable(staffcase_Id);
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
	function viewsocialRelation(row){
		$("#employeeUpdate_page").load(
				"/oa/socialRelation/selectRelationViewPage",{"socialID":row.socialID},function(response,status,xhr){
					$("#socialRelationViewModal").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function editsocialRelation(row){
		$("#employeeUpdate_page").load(
				"/oa/socialRelation/selectRelationEditPage",{"socialID":row.socialID},function(response,status,xhr){
					$("#updateSocialRelaModal").modal({keyboard:true});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#updateSocialRela_Form").validationEngine("validate")){
						
							var queryContainer_form = $("#updateSocialRela_Form");
								$.ajax({type:'POST',url:'/oa/socialRelation/updateOneRelationInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#updateSocialRelaModal").modal("hide");
											$.zjm_socialRelation.initTable($("#staffcase_Id").val());
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
		$("#five").load("/oa/socialRelation/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){		
			$.zjm_socialRelation.initTable(staffcase_Id);
			$("#btn_socialRelaAdd").click(function(){
				$.zjm_socialRelation.addsocialRelation(staffcase_Id);
			});
		});
	}
	
})(jQuery, this);
	$(function () {	
		$("#socialRelation").click(function(){	
			var socialID=$("#socialID").val();
			$.zjm_socialRelation.loadPage();
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
						$.zjm_socialRelation.initTable();
					}else{
						alert("保存失败！");
						$.zjm_socialRelation.initTable();
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

