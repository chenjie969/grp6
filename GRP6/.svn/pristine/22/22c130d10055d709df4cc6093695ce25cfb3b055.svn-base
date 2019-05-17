(function($,z){
	$.zjm_meetingResolution = {
		initTable:initTable, //初始化列表
		addMeetingResolution:addMeetingResolution,  //添加评审会决议
		addMeetingReso:addMeetingReso,
		viewMeetResolution:viewMeetResolution   //查看
	};
	
	var applyID = $("#applyID").val();
	/**初始化列表***/
	/*function initTable(){
		$("#meetingResolution_table").bootstrapTable('destroy');
		$('#meetingResolution_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',width:'10%',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"resolutionCode",title: '决议编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.resolutionCode;}},
					{field:"meetingCode",title: '评审会编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingCode;}},
					{field:"shouldJury",title: '参会人数',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.shouldJury;}},
					{field:"senseJury",title: '实到人数',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.senseJury;}},
					{field:"passJury",title: '通过人数',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.passJury;}},
					{field:"signed",title: '签批决议',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.signed;}},
					{field:"processControl",title: '过程控制',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.processControl;}},
					{field:"loanConditions",title: '放款条件',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.loanConditions;}},
					{field:"feeStandard",title: '收费标准',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.feeStandard;}},
					{field:"otherMatters",title: '其他事项',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.otherMatters;}},
					{field:"controlType",title: '保后监控',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.controlType;}},
					{field:"monitoredAsking",title: '在保监控要求',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.monitoredAsking;}},
					{field:"resolutionResult",title: '决议结果',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.resolutionResult;}},
					
					{field:"meetingDate",title: '上会日期',align: 'center',sortable:"true",formatter: function (value, row, index) { 
						return moment(row.meetingDate).format("YYYY年MM月DD日 ");}},
					
					{field:"meetingResolution_uuid",width:'8%',title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_meetingResolution.viewDicNode(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>节点名称:</b> ' + row.nodeNames + '</p>');
			        if (row.remark != null && typeof(row.remark)!= undefined && row.remark != '') { 
			        	html.push('<p><b>备注:</b> ' + row.remark + '</p>'); 
			        }else{
			        	html.push('<p><b>备注:</b> -</p>');
			        }
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/pro/meetingResolution/selectMeetingResolutionByApplyIDPageTable?applyID="+applyID,//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				// $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
	}*/
	
	
	
	function initTable(){
		$("#meetingResolution_table").bootstrapTable('destroy');
		$('#meetingResolution_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"syllable1",title: '客户名称',align: 'center',sortable:"true",formatter: function (value, row, index) {return "王富贵";}},
					{field:"syllable2",title: '放款机构',align: 'center',sortable:"true",formatter: function (value, row, index) {return "中国人民银行";}},
					{field:"syllable3",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index){return "房地产";}},
					{field:"syllable4",title: '担保金额',align: 'center',sortable:"true",formatter: function (value, row, index){return "2000万元";}},
					{field:"syllable5",title: '担保期限',align: 'center',sortable:"true",formatter: function (value, row, index){return "15个月";}},
					{field:"syllable6",title: '担保年费率',align: 'center',sortable:"true",formatter: function (value, row, index){return "5%";}},
					{field:"syllable7",title: '履约保证金比例',align: 'center',sortable:"true",formatter: function (value, row, index){return "7%";}},
					
					{field:"meetingResolution_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_meetingResolution.viewMeetResolution(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>客户名称:</b> ' + "王富贵" + '</p>');
				    html.push('<p><b>放款机构:</b> ' + "中国人民银行" + '</p>');
				    html.push('<p><b>业务品种:</b> ' + "房地产" + '</p>');
				    html.push('<p><b>担保金额:</b> ' + "2000万元" + '</p>');
				    html.push('<p><b>担保期限:</b> ' + "15个月" + '</p>');
				    html.push('<p><b>担保年费率:</b> ' + "5%" + '</p>');
				    html.push('<p><b>履约保证金比例:</b> ' + "7%" + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/pro/meetingResolution/selectMeetResoByApplyIDPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				// $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
	
	
	//查看
	
	function viewMeetResolution(row){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetingResolutionViewPage?applyID="+applyID,{},function(response,status,xhr){
			$("#viewMeetingResolution").modal({keyboard:true});
			
		});
	}
	
	
	//添加评审会决议
	function addMeetingResolution(){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetResolutionAddPage?applyID="+applyID,{},function(response,status,xhr){
			$("#add_meetResolution").modal({keyboard:true});
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"meetResolution_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#meetResolution_form");
				if($(queryContainer_form).validationEngine("validate")){
						//if(zjm.ajaxValidata("add_add_meetReso","/gbpm/dicNode/isExistNodeNames",JSON.stringify(queryContainer_form.serializeJson()),"节点名称重复！")){
							$.ajax({type:'POST',url:'/pro/meetingResolution/insertOneMeetingResolution',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#add_meetResolution").modal("hide");
										$.zjm_meetingResolution.initTable();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
						/*}else{
							tool.undisabled(".btn_submit");
						}*/
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#add_meetResolution").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//添加评审会决议
	function addMeetingReso(){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetingResoAddPage?applyID="+applyID,{},function(response,status,xhr){
			$("#add_meetingReso").modal({keyboard:true});
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"meetResolution_form"});
			tool.undisabled(".btn_submit");
		});
	}
	
	/*$("#meetingCode").click(function(){
		$.ajax({
			type:'POST',
			url:'/pro/meeting/selectMeetingByApplyID',
			data:{'applyID':applyID},
			contentType:'application/json; charset=UTF-8',
			dataType:'json',
			success:function(data) {
				var meetingList = data.meetingList;
				if(meetingList){
					for(var i=0;i<meetingList.length;i++){
						console.log(meetingList[i]);
					}
				}
				<option value="myobj[i].ClassId">myobj[i].ClassStr </option>
			}
		});
	})*/
	

})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_meetingResolution.initTable();
	};
	
	$("#btn_addMeetingResolution").click(function(){
		$.zjm_meetingResolution.addMeetingResolution();
	});
	$("#btn_addMeetingReso").click(function(){
		$.zjm_meetingResolution.addMeetingReso();
	});
	
});
