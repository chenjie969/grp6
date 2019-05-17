(function($,z){
	$.zjm_rewardsPunishment = {
			initTable:initTable,//初始化列表
			addRewardsPunishment:addRewardsPunishment,//添加奖惩记录
			viewRewardPunish:viewRewardPunish,//查看奖惩记录
			editRewardPunish:editRewardPunish,//修改奖惩记录
			loadPage:loadPage//加载

	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		$("#rewardsPunishment-table").bootstrapTable('destroy');
		$('#rewardsPunishment-table').bootstrapTable({
			method: 'get',			
			columns: [{field:"rewardsType",title: '类型',align: 'center',formatter: function (value, row, index) {return row.rewardsType;}}, 
				{field:"rewardsResults",title: '结果',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.rewardsResults;}},
				{field:"rewardsReason",title: '事由',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.rewardsReason;}},
				{field:"rewardsDate",title: '日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.rewardsDate);}},
				{field:"rewardsNotes",title: '备注',align: 'center',formatter: function (value, row, index) { return row.rewardsNotes;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button title ="查看" class="btn_rewards_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button title ="修改" class="btn_rewards_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button  title ="查看" class="btn_rewards_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_rewards_view': function(e, value, row, index) {
						$.zjm_rewardsPunishment.viewRewardPunish(row);
					},
					'click .btn_rewards_edit': function(e, value, row, index) {
						$.zjm_rewardsPunishment.editRewardPunish(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					
				
					var rewardsNotes = row.rewardsNotes;
					if(rewardsNotes == null || rewardsNotes=='' ){						
						rewardsNotes="（空）";
					}
					
					var html = [];
					html.push('<p><b>类型:</b> ' + row.rewardsType + '</p>');
					html.push('<p><b>结果:</b> ' +row.rewardsResults + '</p>');
					html.push('<p><b>事由:</b> ' + row.rewardsReason + '</p>');
					html.push('<p><b>日期:</b> ' + tool.parseDate(row.rewardsDate) + '</p>');
					html.push('<p><b>备注:</b> ' + rewardsNotes + '</p>');
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/oa/rewards/selectRewardsListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort	
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
					 return params;
				},
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	}
	/**添加*/
	function addRewardsPunishment(staffcase_Id){
		$("#employeeUpdate_page").load(
				"/oa/rewards/selectRewardsAddPage",{"staffcase_Id":staffcase_Id},function(response,status,xhr){
					$("#addRewardPunishModal").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#addRewardPunish_Form").validationEngine("validate")){
							var queryContainer_form = $("#addRewardPunish_Form");
							
								$.ajax({type:'POST',url:'/oa/rewards/insertOneRewardsferInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#addRewardPunishModal").modal("hide");
											$.zjm_rewardsPunishment.initTable(staffcase_Id);

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
	function viewRewardPunish(row){
		$("#employeeUpdate_page").load(
				"/oa/rewards/selectRewardsViewPage",{"rewardsID":row.rewardsID},function(response,status,xhr){
					$("#rewardsPunishmentViewModal").modal({keyboard:true});
				}
		);
	}
	/**修改*/
	function editRewardPunish(row){
		$("#employeeUpdate_page").load(
				"/oa/rewards/selectRewardsEditPage",{"rewardsID":row.rewardsID},function(response,status,xhr){
					$("#updateRewardsPunishModal").modal({keyboard:true});
					zjm.init();
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#updateRewardsPunish_Form").validationEngine("validate")){
							
							var queryContainer_form = $("#updateRewardsPunish_Form");
								$.ajax({type:'POST',url:'/oa/rewards/updateOneRewardsInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#updateRewardsPunishModal").modal("hide");
											$.zjm_rewardsPunishment.initTable($("#staffcase_Id").val());

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
		$("#six").load("/oa/rewards/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){		
			$.zjm_rewardsPunishment.initTable(staffcase_Id);

			$("#btn_RewardPunAdd").click(function(){
				$.zjm_rewardsPunishment.addRewardsPunishment(staffcase_Id);
			});
		});
	}

})(jQuery, this);
	$(function () {	
		$("#rewards").click(function(){	
			var rewardsID=$("#rewardsID").val();
			$.zjm_rewardsPunishment.loadPage();
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
						$.zjm_rewardsPunishment.initTable(staffcase_Id);
					}else{
						alert("保存失败！");
						$.zjm_rewardsPunishment.initTable(staffcase_Id);
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

