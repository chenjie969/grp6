(function($,z){
	$.zjm_arcMoveDetail = {
			initTable:initTable,//初始化列表
			initColumns:initColumns,//初始化列表项
			delOneArcMove:delOneArcMove,//列表单个删除;
			returnArcAddPage:returnArcAddPage,//新增档案;
			returnArcAddsPage:returnArcAddsPage,//批量新增档案;
			turnArcMove:turnArcMove//移交档案;
			
	};
	
	/**初始化列表***/
	function initTable(){
		$('#arcMoveDetail_table').bootstrapTable('destroy');
		$('#arcMoveDetail_table').bootstrapTable({
			method: 'post',
			columns: initColumns(),
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			       /* html.push('<p><b>序号:</b> ' + index+1 + '</p>');*/
			        
			    return html;
			},
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
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/arcMove/selectArcMovePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={
						 "apply_ID":$("#apply_ID").val(),
						 "arcMoveRec_ID":$("#arcMoveRec_ID").val()
				 }; 
				// $.extend(queryCondition,data);
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
		
	};
	
	/**初始化列表项***/
	function initColumns(){
		var columns = [
			//{field:'checked',checkbox:true,display:'none',align:'center',formatter: function (value, row, index) {return ;}},//<c:if test="${'+row.isOriginal+' eq 1}"> checked="checked" </c:if>
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return ['<span class="index" name="index">'+(index+1)+'</span> <input type="hidden" id="arcMove_ID" name="arcMove_ID'+index+'" value='+row.arcMove_ID+'>'];}},
			{field:'arcTypeName',title:'档案类别',sortable : "true",align:'center',formatter: function (value, row, index) {return  '<span name="arcTypeName'+index+'">'+row.arcTypeName+'</span> ';}},
			{field:'fileTitleName',title:'文件标题（内容）',align:'center',sortable : "true",formatter: function (value, row, index) {return  '<span name="fileTitleName'+index+'">'+row.fileTitleName+'</span>';}},
				
			
			];
			
		if('edit'==$("#type1").val() && 'add' == $("#operationType").val()){
			columns.push(
					{field:'pageCount',title:'<i class="icon-asterisk orange"></i>页数',width:'110px',align:'center',sortable : "true",formatter: function (value, row, index) {return '<input type="text" style="width:100%;" value="'+row.pageCount+'" class="validate[required,maxSize[6],custom[number]]" id="pageCount'+index+'"  name="pageCount'+index+'" />';}},
					{field:'pageNumber',title:'<i class="icon-asterisk orange"></i>页码',width:'160px',align:'center',sortable : "true",formatter: function (value, row, index) {return '<input type="text" style="width:30%;" value='+row.pageNumber+' class="validate[required,maxSize[6],custom[number]]" id="pageNumber'+index+'"  name="pageNumber'+index+'" />&nbsp;至&nbsp;<input type="text" value='+row.pageNumberEnd+' style="width:30%;" class="validate[required,maxSize[18],custom[number]]" id="pageNumberEnd'+index+'"  name="pageNumberEnd'+index+'" /> ';}},
					{field:'isOriginal',title:'<i class="icon-asterisk orange"></i>是否原件',align:'center',sortable : "true",formatter: function (value, row, index) {
						if(row.isOriginal==0){
							return '<div  style="width:85px;"><label><input type="radio" name="isOriginal'+index+'" value="1"  class="ace form-field-radio"   /><span class="lbl">是</span></label>&nbsp;&nbsp;<label><input  type="radio" name="isOriginal'+index+'" value="0"   class="ace form-field-radio"  checked="checked"/><span class="lbl">否</span></label></div>'
						}else{
							return '<div  style="width:85px;"><label><input type="radio" name="isOriginal'+index+'" value="1" class="ace form-field-radio"   checked="checked"  /><span class="lbl">是</span></label>&nbsp;&nbsp;<label><input  type="radio" name="isOriginal'+index+'" value="0" class="ace form-field-radio"  /><span class="lbl">否</span></label></div>'
						}
						;}},		
					{field:'isAll',title:'<i class="icon-asterisk orange"></i>是否全部移交',align:'center',sortable : "true",formatter: function (value, row, index) {
						if(row.isAll==1){
							return '<div  style="width:85px;"><label><input type="radio" name="isAll'+index+'" value="1"  class="ace form-field-radio"    checked="checked" /><span class="lbl">是</span></label>&nbsp;&nbsp;<label><input  type="radio" name="isAll'+index+'" value="0" class="ace form-field-radio"  /><span class="lbl">否</span></label></div>'
						}else{
							return '<div  style="width:85px;"><label><input type="radio" name="isAll'+index+'"  value="1"  class="ace form-field-radio"   /><span class="lbl">是</span></label>&nbsp;&nbsp;<label><input  type="radio" name="isAll'+index+'" class="ace form-field-radio" value="0" checked="checked"/><span class="lbl">否</span></label></div>'
						}
						;}},
					{field:'remark',title:'备注',align:'center',sortable :"true",formatter: function (value, row, index) {return '<input type="text" style="width:100%;" value="'+row.remark+'" class="validate[maxSize[200]]" id="remark'+index+'"  name="remark'+index+'" />';}},
					{field:'status',title:'状态',align:'center',sortable : "true",formatter: function (value, row, index) {return row.status;}},					
					{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<a class="btn_arcMove_del  btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></a>'
					].join('');
				},
				events:{
					'click .btn_arcMove_del': function(e, value, row, index) {
						$.zjm_arcMoveDetail.delOneArcMove(row);
					}
				}
			});
		}else{
			columns.push(
					{field:'pageCount',title:'页数',width:'110px',align:'center',sortable : "true",formatter: function (value, row, index) {return row.pageCount;}},
					{field:'pageNumber',title:'页码',width:'160px',align:'center',sortable : "true",formatter: function (value, row, index) {return row.pageNumber +'至'+row.pageNumberEnd ;}},
					{field:'isOriginal',title:'是否原件',align:'center',sortable : "true",formatter: function (value, row, index) {return (row.isOriginal==1) ?'是':'否';}},	
					{field:'isAll',title:'是否全部移交',align:'center',sortable : "true",formatter: function (value, row, index) {return (row.isAll==1) ?'是':'否';}},	
					{field:'remark',title:'备注',align:'center',sortable :"true",formatter: function (value, row, index) {return row.remark;}},
					{field:'status',title:'状态',align:'center',sortable : "true",formatter: function (value, row, index) {return row.status;}}
					);
		}
			
		
			
		
		return columns;
		
	};
	
		
	//新增档案
	function returnArcAddPage(){
		var arcMoveRec_ID = $("#arcMoveRec_ID").val();
		var apply_ID = $("#apply_ID").val();
		$("#arMoveIndex_page").load("/project/arcMove/returnArcAddPage",{"apply_ID":apply_ID,"arcMoveRec_ID":arcMoveRec_ID},function(response,status,xhr){
			$("#arcMoveDetailAdd").modal({keyboard:true});
			
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"arcMoveDetailAdd_form"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#arcMoveDetailAdd_form");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/arcMove/insertOneArcMove",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#arcMoveDetailAdd").modal("hide");
								$.zjm_arcMoveDetail.initTable();
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#arcMoveDetailAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	};
	
	//移交档案
	function turnArcMove(detailsCount){
		
		$("#arcMoveDetails").val(getArcMoveDetails(detailsCount));
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"arcMoveDetail_form"
		});		
		tool.disabled("#btn_turnArcMove");		
		if($("#arcMoveDetail_form").validationEngine("validate")){
			var queryContainer_form = $("#arcMoveDetail_form");
			$.ajax({type:'POST',url:'/project/arcMove/turnArcMove',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					window.location.reload();
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled("#btn_turnArcMove");
		}	
	};
	//获取要提交的数据
	function getArcMoveDetails (detailsCount){
		var rowNum =parseInt(detailsCount);	
		var arcMoveDetails = "";			
			for(var i=0;i<rowNum;i++){
			    arcMoveDetails += $("input[name='arcMove_ID"+i+"']").val()+",";						
			    //arcMoveDetails += $("span[name='arcTypeName"+i+"']").text()+",";						
				//arcMoveDetails += $("span[name='fileTitleName"+i+"']").text()+",";
				arcMoveDetails += $("input[name='pageCount"+i+"']").val()+",";
				arcMoveDetails += $("input[name='pageNumber"+i+"']").val()+",";
				arcMoveDetails += $("input[name='pageNumberEnd"+i+"']").val()+",";
				arcMoveDetails += $("input[name='isOriginal"+i+"']:checked").val()+",";
				arcMoveDetails += $("input[name='isAll"+i+"']:checked").val()+",";
				arcMoveDetails += $("input[name='remark"+i+"']").val()+",";
				arcMoveDetails += ";";			
			}
			return arcMoveDetails;
	};
	
	
	/*列表单个删除*/
	function delOneArcMove(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除所选数据吗?");//提示信息;
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/arcMove/delOneArcMove',data:JSON.stringify({"arcMove_ID":row.arcMove_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#arcMoveDetail_table').bootstrapTable('remove', {
							field: 'arcMove_ID',
							values: [row.arcMove_ID]
						});
						$("#common_del").modal("hide");
						$.zjm_arcMoveDetail.initTable();
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
	//批量新增档案
	function returnArcAddsPage(){
		var arcMoveRec_ID = $("#arcMoveRec_ID").val();
		var apply_ID = $("#apply_ID").val();
		$("#arMoveIndex_page").load("/project/arcMove/returnArcAddsPage",{"apply_ID":apply_ID,"arcMoveRec_ID":arcMoveRec_ID},function(response,status,xhr){
			$("#arcMoveDetailAdds").modal({keyboard:true});			
			$.zjm_zTreeObjLeft.initTree("arcMoveTree","mod_uids","mod_names","/project/arcMove/selectArcMoveTree");			
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				var arcMoveDetails = getTreeCheckedDetails("arcMoveTree")				
				$("#arcMoveDetailsTreeChecked").val(arcMoveDetails);
				if($("#arcMoveDetailAdds_form").validationEngine("validate")){
					var queryContainer_form = $("#arcMoveDetailAdds_form");
					$.ajax({type:'POST',url:'/project/arcMove/insertArcMoves',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#arcMoveDetailAdds").modal("hide");
								$.zjm_arcMoveDetail.initTable();
							}else{
								alert("保存失败！");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			
			});
			$("#arcMoveDetailAdds").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	};
	
	//获取树节点选中的数据
	function getTreeCheckedDetails(treeID){
			var arcMoveDetails = "";			
			var fun_idsArr = new Array();
			var treeObj = $.fn.zTree.getZTreeObj(treeID);
			var nodes = treeObj.getCheckedNodes(true);
			for(var i=0;i<nodes.length;i++){				
				if("f21e4d5d1cec4d298e503b51a9c5f7e3" == nodes[i].pId){//管理类
					arcMoveDetails +='管理类,'
					arcMoveDetails +=nodes[i].pId+",";//档案类别ID
					arcMoveDetails +=nodes[i].name+",";//文件标题（内容）
					arcMoveDetails +=nodes[i].id+",";//文件标题（内容）ID
					arcMoveDetails += ";";	
					
				}
				if("aae12b57078f4e7191392f2f5212d78a" == nodes[i].pId){//要件类
					arcMoveDetails +='要件类,'
					arcMoveDetails +=nodes[i].pId+",";//档案类别ID
					arcMoveDetails +=nodes[i].name+",";//文件标题（内容）
					arcMoveDetails +=nodes[i].id+",";//文件标题（内容）ID
					arcMoveDetails += ";";	
				}
				if("264166596e1d41439f359de9eddd5fe1" == nodes[i].pId){//权证类
					arcMoveDetails +='要件类,'
					arcMoveDetails +=nodes[i].pId+",";//档案类别ID	
					arcMoveDetails +=nodes[i].name+",";//文件标题（内容）
					arcMoveDetails +=nodes[i].id+",";//文件标题（内容）ID
					arcMoveDetails += ";";	
				}
				
	        }
			return arcMoveDetails;
	};
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	var operationType = $("#operationType").val();//获取实现办理类型:接收操作
	var type = $("#type1").val();//获取实现办理类型:查看操作
	
	if('accept' == operationType && 'edit' == type || ('view' == type )){
		$("#btn_returnArcAddPage").hide();//查看时隐藏新增档案按钮
		$("#btn_returnArcAddsPage").hide();//查看时隐藏批量添加按钮
		$("#btn_turnArcMove").hide();//查看时隐藏移交档案按钮
	}
	$.zjm_arcMoveDetail.initTable(type);
	//新增档案;
	$("#btn_returnArcAddPage").click(function(){
		$.zjm_arcMoveDetail.returnArcAddPage();
	});
	//批量新增档案;
	$("#btn_returnArcAddsPage").click(function(){
		$.zjm_arcMoveDetail.returnArcAddsPage();
	});
	
	//移交档案
	$("#btn_turnArcMove").click(function(){
		var tableLength = $(".index").length;
		var arcMoveDetailTable = $('#arcMoveDetail_table').bootstrapTable();
		$.zjm_arcMoveDetail.turnArcMove(tableLength);
	});
	
});

