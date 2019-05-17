(function($,z){
	$.zjm_transfer = {
			initTable:initTable,//初始化列表
			transferAdd:transferAdd,// 岗位变动情况添加
			transferEdit:transferEdit,// 岗位变动情况修改
			transferView:transferView,// 岗位变动情况查看
			loadPage:loadPage//加载页面			
	};

	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#transfer-table").bootstrapTable('destroy');
		$('#transfer-table').bootstrapTable({
			method: 'get',
			columns: [{field:"postsReason",title: '调动原因',align: 'center',formatter: function (value, row, index) {return row.postsReason;}}, 
				{field:"agoPostsDep",title: '变动前部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.agoPostsDepNmae;}},
				{field:"agoPosts",title: '变动前职位',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.agoPosts;}},
				{field:"agoSalary",title: '变动前薪金',align: 'center',formatter: function (value, row, index) { return row.agoSalary+"元";}},
				{field:"changePostsDate",title: '变动日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.changePostsDate);}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button  title ="查看" class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button  title ="修改" class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button title ="查看" class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_transfer.transferView(row);
					},
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_transfer.transferEdit(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					
					var agoPostsDepNmae = row.agoPostsDepNmae;
					if(agoPostsDepNmae == null){
						
						agoPostsDepNmae="（空）";
					}
					var agoSalary = row.agoSalary;
					if(agoSalary == null){
						
						agoSalary="（空）";
					}
					var changePostsDate= tool.parseDate(tool.isNull(row.changePostsDate,""));
					changePostsDate=changePostsDate==""?'（空）':changePostsDate;
					
					
					var html = [];
					html.push('<p><b>调动原因:</b> ' + row.postsReason + '</p>');
					html.push('<p><b>变动前部门:</b> ' + agoPostsDepNmae + '</p>');
					html.push('<p><b>变动前职位:</b> ' + row.agoPosts + '</p>');
					html.push('<p><b>变动前薪金:</b> ' + agoSalary + "元"+'</p>');
					html.push('<p><b>变动日期:</b> ' + changePostsDate + '</p>');
					return html;
				},				
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
				url: "/oa/staffPosts/selectPostListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort				
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					 return params;
				},
				
				sidePagination: "server",   //分页方式：分页，server服务端分页（*）          
				
		});
	}
	/**添加*/
	function transferAdd(staffcase_Id){
		$("#employeeUpdate_page").load(
				"/oa/staffPosts/selectPostsAddPage",{"staffcase_Id":staffcase_Id},function(response,status,xhr){
					$("#addtransferModal").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#addtransfer_Form").validationEngine("validate")){
							var queryContainer_form = $("#addtransfer_Form");	
						
								$.ajax({type:'POST',url:'/oa/staffPosts/insertOnePostsInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									if(data.obj==1){
										$("#addtransferModal").modal("hide");
										$.zjm_transfer.initTable(staffcase_Id);
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
						$("#allDepartsTree1").selectTreeWidgets({
							width : "46%",//设置控件宽度
							multiple : false,//是否多选
							data : data.obj//数据源
						});
						$("#allDepartsTree2").selectTreeWidgets({
							width : "46%",//设置控件宽度 
							
							multiple : false,//是否多选
							data : data.obj//数据源
						});
					
					
					}
					});
					
			        });
					
					
				}
	
		
	/**查看*/
	function transferView(row){
		$("#employeeUpdate_page").load(
				"/oa/staffPosts/selectPostViewPage",{"postsID":row.postsID},function(response,status,xhr){
					$("#transferModal").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function transferEdit(row){
		$("#employeeUpdate_page").load(
				"/oa/staffPosts/selectPostEditPage",{"postsID":row.postsID},function(response,status,xhr){
					$("#updatetransferModal").modal({keyboard:true});
					zjm.init();
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#updatetransfer_Form").validationEngine("validate")){
							var queryContainer_form = $("#updatetransfer_Form");
								$.ajax({type:'POST',url:'/oa/staffPosts/updateOnePostInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									
							        	if(data.obj==1){
											$("#updatetransferModal").modal("hide");
											$.zjm_transfer.initTable($("#staffcase_Id").val());
										
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
						$("#allDepartsTree1").selectTreeWidgets({
							width : "46%",//设置控件宽度
							multiple : false,//是否多选
							data : data.obj//数据源
						});
						$("#allDepartsTree2").selectTreeWidgets({
							width : "46%",//设置控件宽度 
							
							multiple : false,//是否多选
							data : data.obj//数据源
						});
					
					
					}
					});
				
			        });
					
					
				}
	
				
	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		$("#two").load("/oa/staffPosts/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){		
			$.zjm_transfer.initTable(staffcase_Id);
			$("#btn_tranferAdd").click(function(){
			
				$.zjm_transfer.transferAdd(staffcase_Id);
			});
		});
	}

})(jQuery, this);
	$(function () {
		$("#transfer").click(function(){	
			var postsID=$("#postsID").val();
			$.zjm_transfer.loadPage();
		});	
		
		$("#btn_sort").click(function(){
			$("#sortop").modal({keyboard:true});
			zjm.dataSortVal("/sys/roles/selectRolesListJSON",{});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"Hr_staffPosts","tableFileName":"postsID","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==1){
						$("#sortop").modal("hide");
						$.zjm_transfer.initTable();
					}else{
						alert("保存失败！");
						$.zjm_transfer.initTable();
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

