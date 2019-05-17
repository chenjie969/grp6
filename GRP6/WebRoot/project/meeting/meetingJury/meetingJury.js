(function($,z){
	$.zjm_meetingJury = {
		initTable:initTable,//初始化列表
		addMeetingJury:addMeetingJury,
		editMeetingJury:editMeetingJury,
		delMeetingJury:delMeetingJury
	};
	
	/**初始化列表***/
	function initTable(data){
		$('#meetingJury_table').bootstrapTable('destroy');
		$('#meetingJury_table').bootstrapTable({
			method: 'post',
			columns:[	{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'userName',title:'评委姓名',align:'center', sortable:'true',formatter: function (value, row, index) {return row.userName;}},
						{field:'juryStatus',title:'状态',align:'center', sortable:'true',formatter: function (value, row, index) {return row.juryStatus=="01"?"启用":"禁用";}},
						{title: '操 作 ',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_meetingJury_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_meetingJury_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_meetingJury_edit': function(e, value, row, index) {
									$.zjm_meetingJury.editMeetingJury(row);
								},
								'click .btn_meetingJury_del': function(e, value, row, index) {
									$.zjm_meetingJury.delMeetingJury(row);
								}
							}
						}
					],
			detailView: false,
			/*detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>评委姓名：</b> ' + row.proType + '</p>');
			        html.push('<p><b>是否禁用：</b> ' + row.proType + '</p>');
			    return html;
			},*/
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			url: "/pro/meetingJury/selectMeetingJuryPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={}; 
				 $.extend(queryCondition,data);
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/**
	 * 添加评委
	 */
	function addMeetingJury(row){
		$("#meetingJury_page").load("/pro/meetingJury/showJuryAddPage",{},function(response,status,xhr){
			$("#addMeetingJury").modal({keyboard:true});
			/*获取部门用户下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectMeetingJury").selectTreeWidgets({
						width : "87%",//设置控件宽度
						multiple : true,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			tool.undisabled(".btn_submit");
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_addMeetingJury"});
			$(".btn_submit").click(function(){
				var queryContainer_form = $("#form_addMeetingJury");
				if(queryContainer_form.validationEngine("validate")){
					tool.disabled(".btn_submit");
					$.ajax({type:'POST',url:'/pro/meetingJury/addMeetingJury',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==true){
								$("#addMeetingJury").modal("hide");
								$.zjm_meetingJury.initTable();
							}else{
								alert("添加评委失败！");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addMeetingJury").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 修改评委状态
	 */
	function editMeetingJury(row){
		$("#meetingJury_page").load("/pro/meetingJury/showJuryEditPage",{"meetingJury_ID":row.meetingJury_ID},function(response,status,xhr){
			$("#editMeetingJury").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_editMeetingJury"});
			$(".btn_submit").click(function(){
				var queryContainer_form = $("#form_editMeetingJury");
				if(queryContainer_form.validationEngine("validate")){
					tool.disabled(".btn_submit");
					$.ajax({type:'POST',url:'/pro/meetingJury/editMeetingJury',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==true){
								$("#editMeetingJury").modal("hide");
								$.zjm_meetingJury.initTable();
							}else{
								alert("修改评委失败！");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addMeetingJury").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/*列表单个删除*/
	function delMeetingJury(row){		
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除该评委吗?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/pro/meetingJury/delMeetingJury',data:JSON.stringify({"meetingJury_ID":row.meetingJury_ID,"userName":row.userName}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$("#common_del").modal("hide");
						$.zjm_meetingJury.initTable();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	
		
})(jQuery, this);

$(function () {

	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
  		$.zjm_meetingJury.initTable();
	};
	
	/**
	 * 添加评委
	 */
	$("#btn_addMeetingJury").click(function(){
		$.zjm_meetingJury.addMeetingJury();
	});
	
	
});

