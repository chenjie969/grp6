

	/*var defParam = {
			"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
			"btn_PickID" : "pickfiles",//选择附件按钮ID
			"btn_UploadID" : "uploadfiles",//上传按钮ID
			"uploadURL" : "/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"clientFiles",
				"fileTwoType":"01",
				"clientID":"1",
				"pageFilesID":"",
				"projectID":""
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/selectAllFilesList"//加载附件列表数据地址
	};

	$.zjm_upload.initUpload(defParam);*/	




$.zjm_upload = {
			"initUpload" : initUpload, //初始化上传功能
			"activateUploadBuild":activateUploadBuild,//激活上传组件基本的
			"initTable":initTable,//初始化附件列表
			"initViewTable":initViewTable,	//初始化查看页面的列表
			"delFile":delFile//删除附件
	};
	var uploader;
	/**
	 * 初始化上传按钮
	 */
	function initUpload(param){
		var defParam = {
				"uploadFileList" : "",//待上传的附件列表ID
				"uploadConsoleList" : "",//错误信息提示div ID
				"btn_PickID" : "",//选择附件按钮ID
				"btn_UploadID" : "",//上传按钮ID
				"uploadURL" : "",//上传的地址 
				"uploadParam" : {
					"fileOneType":"",//附件表分类
					"fileTwoType":"",//附件上传入口分类
					"clientID":"",//客户id
					"projectID":"",//项目id
					"uuid":""//文件uuid
				},//上传附加参数
				"fileList" : "",//待上传的附件列表ID
				"fileListURL" : "",//加载附件列表数据地址
				"mimeTypes":""//限定上传附件类型
		};
		defParam = $.extend(true,defParam,param);
		$.zjm_upload.activateUploadBuild(defParam);
	}
	
	/**
	 * 激活上传组件  基本的basic
	 */
	function activateUploadBuild(defParam){
		uploader = new plupload.Uploader({
			runtimes : 'html5,flash,silverlight,html4',
			browse_button : defParam.btn_PickID, // you can pass in id...
			//container: document.getElementById('container'), // ... or DOM Element itself
			url : defParam.uploadURL,
			filters : {
				max_file_size : '1000mb',
				mime_types: defParam.mimeTypes
			},
			chunk_size: '5mb',
			flash_swf_url : '/js/Moxie.swf',// Flash settings
			silverlight_xap_url : '/js/Moxie.xap',// Silverlight settings
			multipart_params: defParam.uploadParam,//参数
			init: {
				PostInit: function() {
					document.getElementById(defParam.uploadFileList).innerHTML='';
					document.getElementById(defParam.btn_UploadID).onclick = function() {
						uploader.start();
					}; 
				},
				FilesAdded: function(up, files) {
					plupload.each(files, function(file) {
						document.getElementById(defParam.uploadFileList).innerHTML += '<div id="' + file.id + '">'+ file.name + ' (' + plupload.formatSize(file.size) + ') <b><button type="button" class="btn btn-xs btn-danger" onclick="uploader.removeFile(\''+file.id+'\');" ><i class="icon-trash bigger-120"></i></button></b></div>';
					});
				},
				FilesRemoved: function(up, files) {
					plupload.each(files, function(file) {
						$("#"+file.id).remove();
					});
				},
				UploadProgress: function(up, file) {
					document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
					/*if($("#"+file.id).length>0){
						document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
					}
					if(file.percent==100){
						if($("#"+file.id).length>0){
							$("#"+file.id).remove();
						}
					}*/
				},
				Error: function(up, err) {
					var htmlContainer = ['<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 错误信息 </label>'+
						'<div class="col-sm-9" id="'+defParam.uploadConsoleList+'">'+
						'</div>'];

						if($("#"+defParam.uploadConsoleList).length <= 0 ){
							$("#"+defParam.uploadConsoleList+"Div").append(htmlContainer.join(''));
						}
					document.getElementById(defParam.uploadConsoleList).innerHTML += "\n" + err.code + ": " + err.message;
				},
				BeforeUpload: function(up, file) {
					$.ajax({type:'POST',url:"/sys/dic/selectOneUUID",data:{},async:false,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj!=null)
							// 初始化以后添加
							uploader.settings.multipart_params.uuid = data.obj;
				        }
					});
				}
			}
		});
		uploader.init();
		
	}
	/**初始化可操作性列表***/
	function initTable(defParam){
		$("#"+defParam.fileList).bootstrapTable('destroy');
		$("#"+defParam.fileList).bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"sourceFileName",title: '附件名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.sourceFileName;}}, 
				{field:"fileSize",title: '附件大小',align: 'center',sortable:"true",formatter: function (value, row, index) { return Math.ceil(row.fileSize/1024) +"&nbsp;KB";}},
				{field:"uploadDateTime",title: '上传时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.uploadDateTime,"yyyy-MM-dd HH:mm");}},
				{field:"uploadManName",title: '上传人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.uploadManName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					if(row.extend == 'docx' || row.extend == 'doc' || row.extend == 'pdf' || row.extend == 'xlsx' || row.extend == 'xls' || row.extend == 'ppt' || row.extend == 'pptx'){
						return ['<button type="button" class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-info" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentEditPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-pencil bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else if(row.extend == 'jpeg' || row.extend == 'png' || row.extend == 'gif' || row.extend == 'jpg'){
						return ['<button type="button" class="btn btn-xs btn-warning btn_opfile_viewer" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>'+
							'<img class="hide" data-original="'+row.pathFile+'" src="'+row.pathFile+'" alt="'+row.sourceFileName+'">'+
							'</button>',
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else if(row.extend == 'swf' ){
						return [/*'<button type="button" class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else if(row.extend == 'mp4' ){
						return [/*'<button type="button" class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else {
						return ['<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}
				},
				events:{
					'click .btn_opfile_del': function(e, value, row, index) {
						var modalID = $(this).parents("div.modal").attr("id");
						$.zjm_upload.delFile(row,defParam,defParam.uploadParam.fileOneType,modalID);
					},
					'click .btn_opfile_viewer': function(e, value, row, index) {
						var viewer = new Viewer(document.getElementById(defParam.fileList), {
						    url: 'data-original'
						});
						viewer.show();
						$(".viewer-close").click(function(){
							viewer.destroy();
						});
					}
				}
				}],
				detailView: false,
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortName: "updateDateTime",
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 5,      //每页的记录行数（*）
				pageList: [10,15,20],  //可供选择的每页的行数（*）
				url: defParam.fileListURL,//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"uploadParam":defParam.uploadParam});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				onLoadSuccess:function(data){
					$("#div_fileList").show();
					if(data.rows.length==0){
						$("#div_fileList").hide();
					}
				}
		});
	}
	
	/**初始化查看页面列表***/
	function initViewTable(defParam){
		$("#"+defParam.fileList).bootstrapTable('destroy');
		$("#"+defParam.fileList).bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"sourceFileName",title: '附件名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.sourceFileName;}}, 
				{field:"fileSize",title: '附件大小',align: 'center',sortable:"true",formatter: function (value, row, index) { return Math.ceil(row.fileSize/1024) +"&nbsp;KB";}},
				{field:"uploadDateTime",title: '上传时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.uploadDateTime,"yyyy-MM-dd HH:mm");}},
				{field:"uploadManName",title: '上传人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.uploadManName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					if(row.extend == 'docx' || row.extend == 'doc' || row.extend == 'pdf' || row.extend == 'xlsx' || row.extend == 'xls' || row.extend == 'ppt' || row.extend == 'pptx'){
						return ['<button type="button" class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
					}else if(row.extend == 'jpeg' || row.extend == 'png' || row.extend == 'gif' || row.extend == 'jpg'){
						return ['<button type="button" class="btn btn-xs btn-warning btn_opfile_viewer" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>'+
							'<img class="hide" data-original="'+row.pathFile+'" src="'+row.pathFile+'" alt="'+row.sourceFileName+'">'+
							'</button>',
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
					}else if(row.extend == 'swf' ){
						return [/*'<button type="button" class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
					}else if(row.extend == 'mp4' ){
						return [/*'<button type="button" class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
							'<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
					}else {
						return ['<button type="button" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
					}
				},
				events:{
					'click .btn_opfile_viewer': function(e, value, row, index) {
						var viewer = new Viewer(document.getElementById(defParam.fileList), {
						    url: 'data-original'
						});
						viewer.show();
						$(".viewer-close").click(function(){
							viewer.destroy();
						});
					}
				}
				}],
				detailView: false,
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortName: "updateDateTime",
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 5,      //每页的记录行数（*）
				pageList: [10,15,20],  //可供选择的每页的行数（*）
				url: defParam.fileListURL,//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"uploadParam":defParam.uploadParam});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				onLoadSuccess:function(data){
					$("#div_fileList").show();
					if(data.rows.length==0){
						$("#div_fileList").hide();
					}
				}
		});
	}
	
	/**删除*/
	function delFile(row,defParam,fileOneType,modalID){		//此处 fileOneType 一定为 oaFiles
		var datas = {"fileID":row.files_ID,
					"filePath":row.pathFile,
					"fileOneType":fileOneType};
		$("#delmodule").modal({keyboard:true});
		var zindex = parseInt($("#"+modalID).css("z-index"));
		$("#delmodule").css("z-index",zindex+50);
		$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		$("#btn_delFiles").click(function(){
			tool.disabled("#btn_delFiles");
			$.ajax({type:'POST',url:'/crm/filesUpload/delectOneFilesInfo',data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
		        		tool.undisabled("#btn_delFiles");
						$("#delmodule").modal("hide");
						$.zjm_upload.initTable(defParam);
					}else{
						alert("删除失败！");
						tool.undisabled("#btn_delFiles");
					}
		        }
			});
		});	
		$("#delmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $("#btn_delFiles").unbind("click");
		});
	}

	
	
	
