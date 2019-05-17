(function($,z){
	$.zjm_hetong = {
			contractdocAdd:contractdocAdd,//文档添加
			contractdocUpdate:contractdocUpdate,//修改合同
			contractdocDel:contractdocDel,//删除合同信息
			uploadFiles:uploadFiles,//附件上传
			delFiles:delFiles, //删除附件
			initTable:initTable		 //初始化列表  
	};
	var apply_ID = tool.getUrlParam('entityID');
	var type = tool.getUrlParam('type');
	if(apply_ID==null || apply_ID ==undefined || apply_ID==""){
		apply_ID = $("#applyID").val();
		type =  $("#type").val();
	}
	console.log("apply_ID:"+apply_ID+"     type："+type);
	function initColumns(){
		var columns = [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"contractCode",title: '合同编号',align: 'center',formatter: function (value, row, index) { return row.contractCode;}},
						{field:"contractName",title: '合同名称',align: 'center',formatter: function (value, row, index) { return row.contractName;}},
						{field:"contractTypeName",title: '合同类型',align: 'center',formatter: function (value, row, index) { return row.contractTypeName;}},
						{field:"contractBeginDate",title: '合同起始日期',align: 'center',formatter: function (value, row, index) { return  tool.parseDate(row.contractBeginDate);}},
						{field:"contractEndDate",title: '合同到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.contractEndDate);}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark;}},
						{field:"filename",title: '电子合同',align: 'center',formatter: function (value, row, index) {
							
								var filename = row.filename;
								if(filename==null || typeof(filename)==undefined || filename==''){
									return '';
								}else{
									var extendsss = row.projectfiles.extend;
									if(type=='edit'){
										if(extendsss == 'docx' || extendsss == 'doc' || extendsss == 'pdf' || extendsss == 'xlsx' || extendsss == 'xls' || extendsss == 'ppt' || extendsss == 'pptx'){
											return [
												'<a class="" href="javascript:void(0)" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.contractPath+'&domextend='+extendsss+'\')">'+tool.isNull(row.filename,"")+'</a> &nbsp;&nbsp;&nbsp;',
												'<a class="a_contra_upload" href="javascript:void(0)">下载</a> &nbsp;&nbsp;&nbsp;',
												"<a href='javascript:void(0)' class='a_contra_del' title='删除附件' name='"+tool.isNull(row.projectfiles.projectFiles_ID,"")+"'>删除</a>"].join('');
										}else if(extendsss == 'jpeg' || extendsss == 'png' || extendsss == 'gif' || extendsss == 'jpg'){
											return [
												"<a href='#' class='btn_opfile_viewer_img' data-original='"+row.projectfiles.pathFile+"' src='"+row.projectfiles.pathFile+"'>"+row.filename+"</a>",
											   "<img class='hide' data-original='"+row.projectfiles.pathFile+"' src='"+row.projectfiles.pathFile+"' alt='"+row.projectfiles.sourceFileName+"' title='"+row.projectfiles.sourceFileName+"'>",
											 
												'&nbsp;&nbsp;&nbsp;<a class="a_contra_upload" title="下载" href="javascript:void(0)">下载</a> &nbsp;&nbsp;&nbsp;',
												"<a href='javascript:void(0)' class='a_contra_del' title='删除附件' name='"+tool.isNull(row.projectfiles.projectFiles_ID,"")+"'>删除</a>"].join('');
										}else {
											return ['<a class="a_contra_upload" href="javascript:void(0)">'+tool.isNull(row.filename,"")+'</a> &nbsp;&nbsp;&nbsp;',
												"<a href='javascript:void(0)' class='a_contra_del' title='删除附件' name='"+tool.isNull(row.projectfiles.projectFiles_ID,"")+"'>删除</a>"].join('');
										}
									}else{
										if(extendsss == 'docx' || extendsss == 'doc' || extendsss == 'pdf' || extendsss == 'xlsx' || extendsss == 'xls' || extendsss == 'ppt' || extendsss == 'pptx'){
											return [
												'<a class="" href="javascript:void(0)" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.contractPath+'&domextend='+extendsss+'\')">'+tool.isNull(row.filename,"")+'</a>&nbsp;&nbsp;&nbsp;',
												'<a class="a_contra_upload" href="javascript:void(0)">下载</a> '
												].join('');
										}else if(extendsss == 'jpeg' || extendsss == 'png' || extendsss == 'gif' || extendsss == 'jpg'){
											return [
												"<a href='#' class='btn_opfile_viewer_img' data-original='"+row.projectfiles.pathFile+"' src='"+row.projectfiles.pathFile+"'>"+row.filename+"</a>",
												   "<img class='hide' data-original='"+row.projectfiles.pathFile+"' src='"+row.projectfiles.pathFile+"' alt='"+row.projectfiles.sourceFileName+"' title='"+row.projectfiles.sourceFileName+"'>",
												 
												'&nbsp;&nbsp;<a class="a_contra_upload" title="下载" href="javascript:void(0)">下载</a>'].join('');
										}else {
											return ['<a class="a_contra_upload" href="javascript:void(0)">'+tool.isNull(row.filename,"")+'</a>'].join('');
										}
									}
									
								}
								
							},
							events:{
						
								'click .a_contra_upload': function(e, value, row, index) {
								window.parent.open("/crm/filesUpload/selectOneFilesDownload?fileName="+row.filename+"&filePath="+row.contractPath+"");
								},
								'click .a_contra_del':function(e,value,row,index){
									$.zjm_hetong.delFiles(row,e);
								},
								'click .btn_opfile_viewer_img': function(e, value, row, index) {
									var viewer = new Viewer(document.getElementById("loadinfo222"), {
									    url: 'data-original'
									});
									viewer.show();
									$(".viewer-close").click(function(){
										viewer.destroy();
									});
								}
							}
							
							
						},
					];
		if(type=='edit'){
			columns.push(
					{title: '操作',align: 'center',formatter:function(value,row,index){
							if(row.filename==null || typeof(row.filename) == undefined || row.filename ==''){
								return [
									'<button class="btn_record_upload btn btn-xs btn-purple" title="附件上传" href="javascript:void(0)"><i class="icon-cloud-upload bigger-120"></i></button>',
									'&nbsp;<button class="btn_record_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>',
									'&nbsp;<button class="btn_record_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							}else{
								return [
									'<button class="btn_record_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>',
									'&nbsp;<button class="btn_record_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							}
						
						},
						events:{
							'click .btn_record_edit': function(e, value, row, index) {
								$.zjm_hetong.contractdocUpdate(row);
							},
							'click .btn_record_del': function(e, value, row, index) {
								$.zjm_hetong.contractdocDel(row);
							},
							'click .btn_record_upload': function(e, value, row, index) {							
								$.zjm_hetong.uploadFiles(row);
							},
						}
					}	
			);
		}
		return columns;
	}
	
	/**文档初始化列表***/
	function initTable(apply_ID){
		$('#heTong_table').bootstrapTable('destroy');
		$('#heTong_table').bootstrapTable({
			method: 'post',
			columns:initColumns(),
			detailView: false,
			detailFormatter:function(index, row){
				var contractBeginDate = row.contractBeginDate;
				if(contractBeginDate==null || typeof(contractBeginDate)==undefined){
					contractBeginDate = "（空）";
				}else{
					contractBeginDate = moment(contractBeginDate).format("YYYY-MM-DD")
				}
				var contractEndDate = row.contractEndDate;
				if(contractEndDate==null || typeof(contractEndDate)==undefined){
					contractEndDate = "（空）";
				}else{
					contractEndDate = moment(contractEndDate).format("YYYY-MM-DD")
				}
			    var html = [];
			        html.push('<p><b>序号：</b> ' + (index+1) + '</p>');
			        html.push('<p><b>合同编号：</b> ' + tool.isNull(row.contractCode,"") + '</p>');
			        html.push('<p><b>合同名称：</b> ' + tool.isNull(row.contractName,"") + '</p>');
			        html.push('<p><b>合同类型：</b> ' + tool.isNull(row.contractTypeName,"") + '</p>');
			        html.push('<p><b>合同起始日期：</b> ' + contractBeginDate + '</p>');
			        html.push('<p><b>合同到期日期：</b> ' + contractEndDate + '</p>');
			        html.push('<p><b>备注：</b> ' + tool.isNull(row.remark,"") + '</p>');
			        html.push('<p><b>电子合同：</b> ' + tool.isNull(row.filename,"") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/pro/contractdoc/selectContractListPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":apply_ID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）

	});
	}

/**删除合同信息*/
function contractdocDel(row){
	$("#HeTong_page").load("/pro/contractdoc/seclectOneContractDel",{},function(response,status,xhr){
		$("#delContractDoc").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/pro/contractdoc/delOneContractInfo',data:JSON.stringify({"contractDoc_ID":row.contractDoc_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {
					if(data.obj){
						$("#delContractDoc").modal("hide");
						window.location.reload();
					}else{
						alert("删除失败！");
						tool.undisabled(".btn_submit");
					}
				}
			});
		});
		$("#delContractDoc").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	});
}

//修改合同
function contractdocUpdate(row){
	$("#HeTong_page").load("/pro/contractdoc/showContractdocUpdatePage",{"contractDoc_ID":row.contractDoc_ID},function(response,status,xhr){
		$("#updateContractDoc").modal({keyboard:true});
		/*注册编辑验证引擎*/
		zjm.validata({formId:"updateContractDoc_form"});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#updateContractDoc_form");
			if($(queryContainer_form).validationEngine("validate")){
						$.ajax({type:'POST',url:'/pro/contractdoc/updateOneContractdoc',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#updateContractDoc").modal("hide");
									window.location.reload();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
							}
						});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#updateContractDoc").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	});
}

	//添加合同
	function contractdocAdd(){
		$("#HeTong_page").load("/pro/contractdoc/showContractdocAddPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#addContractDoc").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addContractDoc_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addContractDoc_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/pro/contractdoc/addOneContractdoc',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addContractDoc").modal("hide");
										window.location.reload();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addContractDoc").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//上传附件
	function  uploadFiles(row){
		 var contractDoc_ID=row.contractDoc_ID;
		 var apply_ID=row.apply_ID;
	        var defParam = {
	            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
	            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
	            "btn_PickID": "pickfiles",//选择附件按钮ID
	            "btn_UploadID": "upload",//上传按钮ID
	            "uploadURL": "/pro/contractdoc/insertOneFilesUpload",//上传的地址
	            "uploadParam": {
	                "isFile": false,
	                "clientFileType": '',
	                "fileOneType": "projFiles",//附件表分类 -->项目附件
	                "fileTwoType": "02",//附件上传入口分类
	                "clientID": "",//客户id
	                "projectID": "",//项目id
	                "entityID":contractDoc_ID,
	                "apply_ID":apply_ID,
	                "fileFlag":"optFlag" // 附件来源标记
	            },//上传附加参数
	            "fileList": "fileList",//已上传的附件列表Table ID
	            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
	            "mimeTypes": [{title: "图片", extensions: "*"}] /* //限定上传附件类型  */
	        };
	        $("#uploadfiles").modal({keyboard: true});
	        $.zjm_contractDocUpload.initUpload(defParam);
	        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
	            uploader.destroy();
	            $("#pickfiles").unbind("click");
	            window.location.reload();
	        });
	    	
	}
	//删除附件
	function delFiles(obj,e){
		var projectFiles_ID=e.target.name;
		
	    $("#pictureFileDelModule").modal({keyboard: true});
	    $(".btn_submit").click(function () {
	        tool.disabled(".btn_submit");
	        $.ajax({
	            type: 'POST',
	            url: '/pro/contractdoc/deleteOneInfoByProFiles_ID',
	            data: {"projectFiles_ID":projectFiles_ID},
	            dataType: 'json',
	            success: function (data) {
	                if (data.obj) {
	                    tool.undisabled(".btn_submit");
	                    $("#pictureFileDelModule").modal("hide");
	                  
	                	window.location.reload();
	                } else {
	                    alert("删除失败！");
	                    tool.undisabled(".btn_submit");
	                }
	            }
	        });
	    });
	    $("#pictureFileDelModule").on("hidden.bs.modal", function (e) {//解除事件绑定
	        $(".btn_submit").unbind("click");
	    });
	
	}
	

})(jQuery, this);

$(function () {	
	var apply_ID = tool.getUrlParam('entityID');
//	console.log(apply_ID);
	if(apply_ID==null || apply_ID == undefined || apply_ID==""){
		apply_ID = $("#applyID").val();
	}
	$("#apply_ID").val(apply_ID);
	$.zjm_hetong.initTable(apply_ID);
	$("#btn_addHetTong").click(function (){
		$.zjm_hetong.contractdocAdd();
	});

	
});

