(function($,z){
	$.zjm_meetingArrange = {
		initTable:initTable,
		initArrangingAdd:initArrangingAdd,
		addTableData:addTableData,
		tableOperation:tableOperation,
		setVoteJury:setVoteJury,
		addArrangedApply:addArrangedApply
	};
	
	/**初始化列表***/
	function initTable(tableID){
		$('#'+tableID).bootstrapTable('destroy');
		$('#'+tableID).bootstrapTable({
			method: 'post',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"applyMeetingDate",title: '申请上会日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.applyMeetingDate);}},
						{field:"busiCode",title: '项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
						{field:"projectName",title: '项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { 
							return [ '<a class="btn_proApply_view" href="javascript:void(0)">'+ row.projectName + '</a>' ].join('');},
							events:{
								'click .btn_proApply_view' : function(e, value, row, index) {
									$.zjm_meetingArrangeIndex.viewApplyInfo(row);
								}
							}
						},
						{field:"",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeNameList.replace(",","，<br/>");}},
						{field:"applySum",title: '申请金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applySum;}},
						{field:"operationDepartName",title: '申请部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operationDepartName;}},
						{field:"applyMeetingUserName",title: '申请人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applyMeetingUserName;}},
						{field:"meetingSubmitDate",title: '提交日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.meetingSubmitDate);}},
						{title:"操作",align: 'center',formatter:function(value,row,index){
								return '<button type="button" class="btn_proApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>';
							},
							events:{
								'click .btn_proApply_view': function(e, value, row, index) {
									$.zjm_meetingArrangeIndex.viewApplyInfo(row);
								}
							}
						}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName: "applyMeetingDate",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/meetingArrange/selectWaitingArrangeApplyPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
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
	
	/**************************meetingArrangeAdd********************************/
	/**
	 * 初始化安排上会新增页面
	 */
	function initArrangingAdd(selectContent){
		$("#userIDList_add").val("");	//清空已选评委的隐藏域
		$("#userNameList_add").val("");
		$.zjm_zTreeJury.initTreeOne("userSetTree", "userIDList_add", "userNameList_add","/pro/meetingJury/selectEnableJuryTree","add");
		$("#table_arrangingApply_add tbody").empty();
		addTableData(selectContent,false,"add");
	}
	
	/**
	 * 添加安排中的申请表格数据
	 */
	function addTableData(selectContent,isNewAdd,type){
		$("#noApplyTip_"+type).remove();
		var rowIndex = $("#tableRowIndex_"+type).val();
		for(var i=0,length=selectContent.length;i<length;i++,rowIndex++){
			var tr=	"<tr>"+
					"	<td><input type='checkbox' class='tdCheckbox_"+type+"' data-trIndex='"+rowIndex+"'/></td>"+
					"	<td>"+selectContent[i].busiCode+"</td>"+
					"	<td><a class='btn_proApply_view' href='javascript:void(0)' data-applyID='"+selectContent[i].apply_ID+"'>"+selectContent[i].projectName+"</a></td>"+
					"	<td>"+selectContent[i].operationDepartName+"</td>"+
					"	<td>"+selectContent[i].amanName+"</td>"+
					"	<td>"+ (selectContent[i].bmanName==null?'':selectContent[i].bmanName) +"</td>"+
					"	<td>"+ (selectContent[i].reviewManName==null?'':selectContent[i].reviewManName) +"</td>"+
					"	<td class='votableJury_"+type+"' id='votableJury_"+rowIndex+"_"+type+"'></td>"+
					"	<td style='display:none;'>" +
					"		<input type='hidden' id='tdVoteJuryID_"+rowIndex+"_"+type+"' class='tdVoteJuryIDList_"+type+" validate[required]'>" +
					"		<input type='hidden' id='tdVoteJuryName_"+rowIndex+"_"+type+"' class='tdVoteJuryNameList_"+type+" validate[required]'>" +
					"		<input type='hidden' id='tdApplyID_"+rowIndex+"_"+type+"' class='tdApplyID_"+type+"' value='"+selectContent[i].apply_ID+"'>" +
					"	</td>"+
					"	<td><a href='javascript:void(0)' class='trMoveUp'>上移</a>  <a href='javascript:void(0)' class='trMoveDown'>下移</a>  <a href='javascript:void(0)' class='trDelete'>撤销</a></td>"+
					"</tr>"
			$("#table_arrangingApply_"+type+" tbody").append(tr);
			//如果是新增加的项目, 设置表决评委单元格和隐藏域
			if(isNewAdd){
				$("#votableJury_"+rowIndex+"_"+type).text($("#userNameList_"+type).val().replace(/,/g,"，"));
				$("#tdVoteJuryID_"+rowIndex+"_"+type).val($("#userIDList_"+type).val());
				$("#tdVoteJuryName_"+rowIndex+"_"+type).val($("#userNameList_"+type).val());
			}
		}
		$("#tableRowIndex_"+type).val(rowIndex);
		tableOperation(type);
	}
	
	/**
	 * 表格操作 
	 */
	function tableOperation(type){
		//上移
		$(".trMoveUp").click(function(){
			var $tr = $(this).parents("tr"); 
			if ($tr.index() != 0) { 
//				$tr.fadeOut(100).fadeIn(100); 
				$tr.prev().before($tr); 
    		} 
		});
		//下移 
		var $down = $(".trMoveDown");
		var len = $down.length; 
		$down.click(function() { 
			var $tr = $(this).parents("tr"); 
		    if ($tr.index() != len - 1) { 
//		    	$tr.fadeOut(100).fadeIn(100); 
		    	$tr.next().after($tr); 
		    } 
		}); 
		//撤销
		$(".trDelete").click(function(){
			$(this).parents("tr").remove();
			//如果移除后tbody中没有数据, 显示一行提示信息
			if($("#table_arrangingApply_"+type+" tbody").find("tr").length==0){
				$("#table_arrangingApply_"+type+" tbody").append("<tr id='noApplyTip_"+type+"'><td colspan='9'>请至少选择一个项目！</td></tr>");
			}
		});
		//复选框单选功能
		$(".tdCheckbox_"+type).click(function(){
			if($(this).is(':checked')){  
				$(".tdCheckbox_"+type).prop('checked',false);
				$(this).prop('checked',true);
			}
		});
	}
	
	/**
	 * 设置表决评委
	 */
	function setVoteJury(type){
		var selectContent = $('.tdCheckbox_'+type+':checked');
		var zindex = parseInt($("#proMeeting_"+type).css("z-index"));

		if(typeof(selectContent) == 'undefined' || selectContent.length == 0) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").text("请先选择表格中的一个项目！");
			$("#pleaseSelectOne").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		}else{
			var trIndex = selectContent.attr("data-trIndex");
			/*设置二层弹窗的样式*/
			$("#setVoteJuryModal").modal({keyboard:true});
			$("#setVoteJuryModal").css("z-index",zindex+50);
			$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
			/*设置二层弹窗的树结构*/
			$("#juryIDList_temp").val($("#tdVoteJuryID_"+trIndex+"_"+type).val());
			$.zjm_zTreeJury.initTreeTwo("voteJurySetTree", "juryIDList_temp", "juryNameList_temp","/pro/meetingJury/selectEnableJuryTree");
			/*设置二层弹窗的确定按钮*/
			$("#btn_okSetVoteJury").click(function(){
				$("#tdVoteJuryID_"+trIndex+"_"+type).val($("#juryIDList_temp").val());
				$("#tdVoteJuryName_"+trIndex+"_"+type).val($("#juryNameList_temp").val());
				$("#votableJury_"+trIndex+"_"+type).text($("#juryNameList_temp").val().replace(/,/g,"，"));
				$("#setVoteJuryModal").modal("hide");
			});
			$("#setVoteJuryModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $("#btn_okSetVoteJury").unbind("click");
			});
		}
	}
	
	/**
	 * 新增上会项目
	 */
	function addArrangedApply(type){
		/*设置二层弹窗的样式*/
		var zindex = parseInt($("#proMeeting_add").css("z-index"));
		$("#waitingApplyList").modal({keyboard:true});
		$("#waitingApplyList").css("z-index",zindex+50);
		$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		/*初始化申请列表*/
		$.zjm_meetingArrange.initTable("table_waitingApplyList");
		$("#btn_addMeetApply").click(function(){
			var selectContent = $("#table_waitingApplyList").bootstrapTable('getSelections');	//获取被选中的申请
			var idsStr = $(".tdApplyID_"+type).map(function(){return $(this).val();}).get().join(",");	//获取到已经在表格中的申请ID
			for(var i=selectContent.length-1;i>=0;i--){
				var tmpID = selectContent[i].apply_ID;
			    if(idsStr.indexOf(tmpID) != -1){
			    	selectContent.splice(i,1);
			    }
			}
			$.zjm_meetingArrange.addTableData(selectContent,true,type);	//isNewAdd=true,设置新增行的表决评委和隐藏单元格内容
			$("#waitingApplyList").modal("hide");
		});
		$("#waitingApplyList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $("#btn_addMeetApply").unbind("click");
		});
	}
	
})(jQuery, this);

$(function () {
	
	$.zjm_meetingArrange.initTable("table_waitingArrangeApply");
	
	/**
	 * 主页面"安排上会"按钮
	 */
	$("#btn_arrangeMeeting").click(function(){
		var selectContent = $('#table_waitingArrangeApply').bootstrapTable('getSelections');
		if(typeof(selectContent) == 'undefined' || selectContent.length == 0) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").text("请至少选择一条数据，然后再操作！")
			return false;  
		}else{
			$("#proMeeting_add").modal({keyboard:true});
			$("#userName_add").empty();		//清空已选人员列表
			$.zjm_meetingArrange.initArrangingAdd(selectContent);
			tool.undisabled("#btn_submit_add");
			$("#btn_submit_add").click(function(){
				var rowNum = $("#table_arrangingApply_add tbody").find("tr").length;	//表格行数
				var meetingApplyList = new Array();  
				for(var i=0; i<rowNum; i++){
					var idList = $("#table_arrangingApply_add tbody tr:eq("+i+") .tdVoteJuryIDList_add").val();
					var nameList = $("#table_arrangingApply_add tbody tr:eq("+i+") .tdVoteJuryNameList_add").val();
					var applyID = $("#table_arrangingApply_add tbody tr:eq("+i+") .tdApplyID_add").val();
					var tmap = {"idList":idList,"nameList":nameList,"applyID":applyID,"order":i};
					meetingApplyList.push(tmap);
				}
				/*注册编辑验证引擎*/
				$.zjm.rules = $.zjm_meetingArrangeIndex.rules();	
				zjm.validata({formId:"form_proMeeting_add"});
				tool.disabled("#btn_submit_add");
				var queryContainer_form = $("#form_proMeeting_add");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/meetingArrange/insertOneMeeting",data:JSON.stringify($.extend(queryContainer_form.serializeJson(),{"mapList":meetingApplyList})),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#proMeeting_add").modal("hide");
								$.zjm_meetingArrange.initTable("table_waitingArrangeApply");
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit_add");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit_add");
				}
			});
			$("#proMeeting_add").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit_add").unbind("click");
			});
		}
	});
	

	/**
	 * 设置某项目的表决评委
	 */
	$("#btn_setVotingJury_add").click(function(){
		$.zjm_meetingArrange.setVoteJury("add");
	});
	
	/**
	 * 新增安排上会项目
	 */
	$("#btn_addArrangedApply_add").click(function(){
		$.zjm_meetingArrange.addArrangedApply("add");
	});
})

