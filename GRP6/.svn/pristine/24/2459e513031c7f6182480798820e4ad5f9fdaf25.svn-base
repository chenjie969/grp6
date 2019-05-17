
$.templateUpload = {
			"initUpload" : initUpload, //初始化上传功能
			"activateUploadBuild":activateUploadBuild,//激活上传组件基本的
			"initTable":initTable,//初始化附件列表
			"delFile":delFile//删除附件
	};
	
	
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
					"uuid":"",//文件uuid
					"mouldName":$("#mouldName").val(),//文档模版名称
					"mouldTypeID":$("#select_mouldType").val(),//文档模版类型ID
					"mouldTypeName":$("#mouldTypeName").val()//文档模版类型
					
				},//上传附加参数
				"fileList" : "",//待上传的附件列表ID
				"fileListURL" : "",//加载附件列表数据地址
				"mimeTypes":""//限定上传附件类型
		};
		defParam = $.extend(true,defParam,param);
		$.templateUpload.activateUploadBuild(defParam);
	}
	
	/**
	 * 激活上传组件  基本的basic
	 */
	function activateUploadBuild(defParam){
		var uploader;
		var $list=$("#"+defParam.uploadFileList);   //这几个初始化全局的百度文档上没说明，好蛋疼。  
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
			var mouldName = $("#mouldName").val();
			var mouldTypeName = $("#mouldTypeName").val();
			if(mouldName == ""){
				$("#pleaseSelectOne").modal({keyboard:true});
				$("#message").html("文档编号不能为空");
				return;
			}

			if(mouldTypeName == "" || mouldTypeName == " 请选择"){
				$("#pleaseSelectOne").modal({keyboard:true});
				$("#message").html("请选择文档模版类型");
				return;
			}
			
			console.info('uploader',uploader.options.formData);
			var fordata={
				"mouldName":$("#mouldName").val(),
				"mouldTypeID":$("#select_mouldType").val(),
				"mouldTypeName":$("#mouldTypeName").val()
			};
			$.extend(uploader.options.formData,fordata);
			console.info('formData',uploader.options.formData);

			uploader.upload();  
			
	    }); 
		//当所有文件上传结束时触发
		uploader.on( 'uploadFinished', function() {
			$.templateUpload.initTable(defParam);
		});
		
	}
	/**初始化列表***/
	function initTable(defParam){
		$("#"+defParam.fileList).bootstrapTable('destroy');
		$("#"+defParam.fileList).bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"mouldName",title: '文档编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.mouldName;}}, 
				{field:"oldMouldName",title: '文档名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.oldMouldName;}}, 
				{field:"mouldTypeName",title: '文档模板类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.mouldTypeName;}}, 
				{field:"fileSize",title: '文档大小',align: 'center',sortable:"true",formatter: function (value, row, index) { return (row.fileSize/1024).toFixed(2)+'KB';}},
				{field:"uploadDateTime",title: '上传时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.uploadDateTime,"yyyy-MM-dd HH:mm");}},
				{field:"uploadManName",title: '上传人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.uploadManName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					
					
					if(row.extend == 'docx' || row.extend == 'doc' || row.extend == 'pdf' || row.extend == 'xlsx' || row.extend == 'xls' || row.extend == 'ppt' || row.extend == 'pptx'){
						return ['<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.mouldPath+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn btn-xs btn-info" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentEditPage?domhref='+row.mouldPath+'&domextend='+row.extend+'\')"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.oldMouldName+'&filePath='+row.mouldPath+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else if(row.extend == 'jpeg' || row.extend == 'png' || row.extend == 'gif' || row.extend == 'jpg'){
						return ['<button class="btn btn-xs btn-warning btn_opfile_viewer" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>'+
							'<img class="hide" data-original="'+row.mouldPath+'" src="'+row.mouldPath+'" alt="'+row.oldMouldName+'">'+
							'</button>',
							'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.oldMouldName+'&filePath='+row.mouldPath+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else if(row.extend == 'swf' ){
						return [/*'<button class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
							'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.oldMouldName+'&filePath='+row.mouldPath+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else if(row.extend == 'mp4' ){
						return [/*'<button class="btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',*/
							'<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.oldMouldName+'&filePath='+row.mouldPath+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}else {
						return ['<button class="btn btn-xs btn-warning" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.oldMouldName+'&filePath='+row.mouldPath+'\')"><i class="icon-download-alt bigger-120"></i></button>',
							'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
					}
				},
				events:{
					'click .btn_opfile_del': function(e, value, row, index) {
						$.templateUpload.delFile(row,defParam,defParam.uploadParam.fileOneType);
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
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
						html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
						html.push('<p><b>文档名称:</b> ' + row.mouldName + '</p>');
						html.push('<p><b>文档编号:</b> ' + row.oldMouldName + '</p>');
						html.push('<p><b>文档模板类型:</b> ' + row.mouldTypeName + '</p>');
						html.push('<p><b>文档大小:</b> ' + (row.fileSize/1024).toFixed(2)+'kb' + '</p>');
						html.push('<p><b>上传时间:</b> ' + tool.parseDate(row.uploadDateTime) + '</p>');
						html.push('<p><b>上传人:</b> ' + row.uploadManName + '</p>');
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
				pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
				url: defParam.fileListURL,//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"uploadParam":defParam.uploadParam});
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
	
	
	
	/**删除*/
	function delFile(row,defParam,fileOneType){
		var datas;
		if(fileOneType=="clientFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="projFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="reportFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType == 'docMould'){
			datas={"fileID":row.docMouldID,"filePath":row.mouldPath,"fileOneType":fileOneType};
		} 
		$("#filesUpload_page").load(
				"/crm/filesUpload/selectFilesDelPage",{},function(response,status,xhr){
					$("#delmodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/crm/filesUpload/delectOneFilesInfo',data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#delmodule").modal("hide");
									$.templateUpload.initTable(defParam);
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

	
	$("#select_mouldType").change(function(){
		var optName=$("#select_mouldType").find("option:selected").text();
		$("#mouldTypeName").val(optName);
	})
	
	
	