
$.zjm_upload = {
			"initUpload" : initUpload, //初始化上传功能
			"initColumn":initColumn,
			"activateUploadBuild":activateUploadBuild,//激活上传组件基本的
			"initTable":initTable,//初始化附件列表
			"delFile":delFile//删除附件
	};
	

	/**
	 * 初始化上传按钮
	 */
var defParam;
	function initUpload(param){
		defParam = {
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
		var uploader;
		var $list=$("#"+defParam.uploadFileList);  
	    var $btn =$("#"+defParam.btn_UploadID);   //开始上传 
		uploader = WebUploader.create({ 
			// swf文件路径 
			//swf: 'https://cdn.staticfile.org/webuploader/0.1.5/Uploader.swf', 
			// 文件接收服务端。 
			server: defParam.uploadURL, 
			formData:defParam.uploadParam,
			// 选择文件的按钮。可选。 
			// 内部根据当前运行是创建，可能是input元素，也可能是flash. 
			pick: '#'+defParam.btn_PickID, 
			// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！ 
			resize: false,
			chunked :true,
			chunkRetry :5,
			fileSingleSizeLimit:1048576000,
		    accept: defParam.mimeTypes
		});


		// 当有文件被添加进队列的时候 
		uploader.on( 'fileQueued', function( file ) {
			$list.append( '<div id="' + file.id + '" class="item">' 
					+ '<h4 class="info">' + file.name + '<button class="btn btn-xs btn-danger remove-this" dataID="' + file.id + '" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'+ '</h4>' 
					+ '<p class="state">等待上传...</p>' 
					+ '</div>' ); 
			
		});
		//移除文件队列
		$(".uploader-list").on('click',".remove-this", function() {
		    uploader.removeFile($(this).attr("dataID"),true);
		    $("#"+$(this).attr("dataID")).remove();
		})
		// 文件上传过程中创建进度条实时显示。 
		uploader.on( 'uploadProgress', function( file, percentage ) {
			var $li = $( '#'+file.id ), 
			$percent = $li.find('.progress .progress-bar'); 
			// 避免重复创建 
			if ( !$percent.length ) { 
				$percent = $('<div class="progress progress-striped active">' 
						+ '<div class="progress-bar" role="progressbar" style="width: 0%">' 
						+ '</div>' + '</div>'
				).appendTo( $li ).find('.progress-bar'); 
			} $li.find('p.state').text('上传中'); 
			$percent.css( 'width', percentage * 100 + '%' ); 
		});
		//某个文件开始上传前触发，一个文件只会触发一次
		uploader.on( 'uploadStart', function( file ) {
			$.ajax({type:'POST',url:"/sys/dic/selectOneUUID",data:{},async:false,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj!=null)
					// 初始化以后添加
					uploader.options.formData.uuid = data.obj;
		        }
			});
		});
		//当文件上传成功时触发
		uploader.on( 'uploadSuccess', function( file ) {
		    $( '#'+file.id ).find('p.state').text('已上传');
		});
		//当文件上传出错时触发
		uploader.on( 'uploadError', function( file ) {
		    $( '#'+file.id ).find('p.state').text('上传出错');
		});
		//不管成功或者失败，文件上传完成时触发
		uploader.on( 'uploadComplete', function( file ) {
		    $( '#'+file.id ).find('.progress').fadeOut();
		});
		//点击上传按钮开始上传
		$btn.on( 'click', function() {  
	        uploader.upload();  
	    }); 
		//当所有文件上传结束时触发
		uploader.on( 'uploadFinished', function() {
			$.zjm_upload.initTable(defParam);
		});
		
	}
	function initColumn(){
					var columns = [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"sourceFileName",title: '附件名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.sourceFileName;}}, 
						{field:"fileSize",title: '附件大小',align: 'center',sortable:"true",formatter: function (value, row, index) { return (row.fileSize/1024).toFixed(2)+'KB';}},
						/*{field:"uploadDateTime",title: '上传时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.dateFormat(row.uploadDateTime,"yyyy-MM-dd HH:mm");}},*/
						{field:"uploadDateTime",title: '上传时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.uploadDateTime);}},
						{field:"uploadManName",title: '上传人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.uploadManName;}},
					  ];
							var type = tool.getUrlParam('type');//获取路径类型:查看/修改
							if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
								columns.push({title : '操作',align : 'center',formatter : function(value, row, index) {
									if(row.extend == 'docx' || row.extend == 'doc' || row.extend == 'pdf' || row.extend == 'xlsx' || row.extend == 'xls' || row.extend == 'ppt' || row.extend == 'pptx'){
										return ['<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
											'<button class="btn btn-xs btn-info" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentEditPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-pencil bigger-120"></i></button>',
											'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
											'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
									}else if(row.extend == 'jpeg' || row.extend == 'png' || row.extend == 'gif' || row.extend == 'jpg'){
										return ['<button class="btn btn-xs btn-warning btn_opfile_viewer" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>'+
											'<img class="hide" data-original="'+row.pathFile+'" src="'+row.pathFile+'" alt="'+row.sourceFileName+'">'+
											'</button>',
											'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
											'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
									}else if(row.extend == 'swf' ){
										return [/*'<button class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
											'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
											'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
									}else if(row.extend == 'mp4' ){
										return [/*'<button class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
											'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
											'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
									}else {
										return ['<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
											'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
									}
								},
							 events:{
								'click .btn_opfile_del': function(e, value, row, index) {
									$.zjm_upload.delFile(row,defParam,defParam.uploadParam.fileOneType);
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
						});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title : '操作',align : 'center',formatter : function(value, row, index){ 
				if(row.extend == 'docx' || row.extend == 'doc' || row.extend == 'pdf' || row.extend == 'xlsx' || row.extend == 'xls' || row.extend == 'ppt' || row.extend == 'pptx'){
					return ['<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
						'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
				}else if(row.extend == 'jpeg' || row.extend == 'png' || row.extend == 'gif' || row.extend == 'jpg'){
					return ['<button class="btn btn-xs btn-warning btn_opfile_viewer" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>'+
						'<img class="hide" data-original="'+row.pathFile+'" src="'+row.pathFile+'" alt="'+row.sourceFileName+'">'+
						'</button>',
						'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
				}else if(row.extend == 'swf' ){
					return [
						'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
				}else if(row.extend == 'mp4' ){
					return [
						'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
				}else {
					return [
						'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>'].join('');
				}
			}, events:{'click .btn_opfile_viewer': function(e, value, row, index) {
				var viewer = new Viewer(document.getElementById(defParam.fileList), {
				    url: 'data-original'
				});
				viewer.show();
				$(".viewer-close").click(function(){
					viewer.destroy();
				});
			}
		}
	 });
	}
	return columns;
};
	
	/**初始 化开户信息 列表***/
	function initTable(defParam){
		//alert("初始 化开户信息 列表============"+row.client_ID);
		$("#"+defParam.fileList).bootstrapTable('destroy');
		$("#"+defParam.fileList).bootstrapTable({
			method: 'get',
			columns : initColumn(),
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>账户类别:</b> ' + row.accounttype + '</p>');
			        html.push('<p><b>开户行:</b> ' + row.bankname + '</p>');
			        html.push('<p><b>账号:</b> ' + row.accountnumber + '</p>');
			        html.push('<p><b>账户余额（万元）:</b> ' + row.accountsum + '</p>');
			    return html;
			},
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		//	pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: defParam.fileListURL,//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"uploadParam":defParam.uploadParam});
				return params;
			},// queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			         
			});
		
		
		
	}

	/**删除*/
	function delFile(row,defParam,fileOneType){
		var datas;
		if(fileOneType=="clientFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="projFiles"){
			datas={"fileID":row.projectFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="reportFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		} 
		$("#filesUpload_page").load("/crm/filesUpload/selectFilesDelPage",{},function(response,status,xhr){
					$("#delmodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/crm/filesUpload/delectOneFilesInfo',data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj){
									$("#delmodule").modal("hide");
									window.location.reload();
									$.zjm_upload.initTable(defParam);
								}else{
									alert("删除失败！");
								}
					        }
						});
					});
					$("#delmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
						 $(".btn_submit").unbind("click");
					});
				}
		);
	}

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	