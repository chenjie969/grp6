(function($,z){
	$.zjm_warrantyRecord= {
			initTable:initTable,//初始化列表
			guaranteeEdit:guaranteeEdit,//修改担保记录
			guaranteeView:guaranteeView,//查看担保记录
			guaranteeAdd:guaranteeAdd,//添加担保记录
			loadPage:loadPage//加载页面
			
	};
	/**初始化列表***/
	function initTable(staffcase_Id,user_uid){
		$("#guarantee-table").bootstrapTable('destroy');
		$("#guarantee-table").bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
				{title: '担保日期',align: 'center',formatter: function (value, row, index) {return tool.parseDate(row.guaranteeDate);}}, 
				{title: '保证人',align: 'center',formatter: function (value, row, index) { return row.guaranteeMan;}},
				{title: '所在单位',align: 'center',formatter: function (value, row, index) { return row.guaranteeUnits;}},
				{title: '联系方式',align: 'center',formatter: function (value, row, index) { return row.guaranteeTEL;}},
				{title: '备注',align: 'center',formatter: function (value, row, index) { return row.guaranteeNotes;}},
				{title: '担保内容描述',align: 'center',formatter: function (value, row, index) { return row.guaranteeDesc;}},			
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var type =tool.getUrlParam('type');
					if(type=='edit'){
							return ['<button class="btn_guarantee_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_guarantee_edit btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>'].join('');
					}else{
							return ['<button class="btn_guarantee_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					}
					
				},
				events:{
					'click .btn_guarantee_view': function(e, value, row, index) {
						$.zjm_warrantyRecord.guaranteeView(row);
					},
					'click .btn_guarantee_edit': function(e, value, row, index) {
						$.zjm_warrantyRecord.guaranteeEdit(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>担保日期:</b> ' + tool.parseDate(row.guaranteeDate) + '</p>');
					html.push('<p><b>保证人:</b> ' + row.guaranteeMan + '</p>');
					html.push('<p><b>所在单位:</b> ' + row.guaranteeUnits + '</p>');
					html.push('<p><b>联系方式:</b> ' + row.guaranteeTEL+ '</p>');
					html.push('<p><b>备注:</b> ' + row.guaranteeNotes + '</p>');
					html.push('<p><b>担保内容描述:</b> ' + row.guaranteeDesc + '</p>');
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: false,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/guarantee/selectGuaranteeTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				queryParams: function(params) {
					$.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id,"user_uid":user_uid}});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	}
	/**添加*/
	function guaranteeAdd(){
		$("#manager_page").load(
				"/oa/guarantee/showGuaranteeAdd",{},function(response,status,xhr){
					$("#guaranteeAdd").modal({keyboard:true});
					/*注册编辑验证引擎*/
					zjm.validata({formId:"guaranteeAdd_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function() { var staffcase_Id = $("#staffcase_Id").val();
					$("#staffcaseId").val(staffcase_Id);
						tool.disabled(".btn_submit");
						if($("#guaranteeAdd_Form").validationEngine("validate")){
							var queryContainer_form = $("#guaranteeAdd_Form");
								$.ajax({type:'POST',url:'/oa/guarantee/insertOneGuarantee',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj){
											$("#guaranteeAdd").modal("hide");
											$.zjm_warrantyRecord.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
							        }
								});
							}else{
								tool.undisabled(".btn_submit");
							}
							$("#guaranteeAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
								 $(".btn_submit").unbind("click");
							});
						});
					});
				}
	/**查看*/
	function guaranteeView(row){
		$("#manager_page").load("/oa/guarantee/selectOneGuarantee",{"guaranteeID":row.guaranteeID,"operationType":"veiw"},function(response,status,xhr){
					$("#guaranteeView").modal({keyboard:true});
				});
	}
	/**修改*/
	function guaranteeEdit(row){
		$("#manager_page").load("/oa/guarantee/selectOneGuarantee",{"guaranteeID":row.guaranteeID,"operationType":"update"},function(response,status,xhr){
					$("#guaranteeUpdate").modal({keyboard:true});
					zjm.validata({formId:"guaranteeUpdate_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#guaranteeUpdate_Form").validationEngine("validate")){
							var queryContainer_form = $("#guaranteeUpdate_Form");
								$.ajax({type:'POST',url:'/oa/guarantee/updateOneGuarantee',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj){
											$("#guaranteeUpdate").modal("hide");
											$.zjm_warrantyRecord.initTable($("#staffcase_Id").val());
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
							        }
								});
						}else{
							tool.undisabled(".btn_submit");
						}
						$("#guaranteeUpdate").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
						});
					});
				});
			}
	function loadPage(){
		var type =tool.getUrlParam('type');
		var  staffcase_Id=$("#staffcase_Id").val();
		var  user_uid=$("#user_uid").val();
		$("#nine").load("/oa/guarantee/loadPage",{"staffcase_Id":staffcase_Id,"type":type},function(){
			$.zjm_warrantyRecord.initTable(staffcase_Id,user_uid);
			$("#btn_guaranteeAdd").click(function(){				
				$.zjm_warrantyRecord.guaranteeAdd(staffcase_Id,user_uid);
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$("#warrantyRecord").click(function(){
		$.zjm_warrantyRecord.loadPage();
	});
	$("#btn_guaranteeAdd").click(function(){				
		$.zjm_warrantyRecord.guaranteeAdd(staffcase_Id,user_uid);
	});
});