$.zjm_upload = {
			"initUpload" : initUpload, //初始化上传功能
			"activateUploadBuild":activateUploadBuild//激活上传组件基本的
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
			// 只允许选择图片文件。
			accept: {
				title: 'Images',
				extensions: 'gif,jpg,jpeg,bmp,png',
				mimeTypes: 'image/*'
			}
		});


		// 当有文件被添加进队列的时候 
		uploader.on( 'fileQueued', function( file ) {
			var $li = $(
		            '<div id="' + file.id + '" class="file-item thumbnail">' +
		                '<img>' +
		                '<div class="info">' + file.name + '</div>' +
		                '<button class="remove-this" style="font-size:120%;background:rgba(255,255,255,0);color:#fff;position:absolute;left:75px;top:55px;" dataID="' + file.id + '" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'+
		            '</div>'
		            ),
		        $img = $li.find('img');
		    // $list为容器jQuery实例
		    $list.append( $li );

		    // 创建缩略图
		    // 如果为非图片文件，可以不用调用此方法。
		    // thumbnailWidth x thumbnailHeight 为 100 x 100
		    uploader.makeThumb( file, function( error, src ) {
		        if ( error ) {
		            $img.replaceWith('<span>不能预览</span>');
		            return;
		        }
		        $img.attr( 'src', src );
		    }, "110", "110" );
		});
		//移除文件队列
		$(".uploader-list").on('click',".remove-this", function() {
		    uploader.removeFile($(this).attr("dataID"),true);
		    $("#"+$(this).attr("dataID")).remove();
		})
		// 文件上传过程中创建进度条实时显示。 
		uploader.on( 'uploadProgress', function( file, percentage ) {
			 var $li = $( '#'+file.id ),
		        $percent = $li.find('.progress span');
		    // 避免重复创建
		    if ( !$percent.length ) {
		        $percent = $('<p class="progress"><span></span></p>')
		                .appendTo( $li )
		                .find('span');
		    }
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
			$( '#'+file.id ).addClass('upload-state-done');
		});
		//当文件上传出错时触发
		uploader.on( 'uploadError', function( file ) {
			var $li = $( '#'+file.id ),
			$error = $li.find('div.error');
			// 避免重复创建
			if ( !$error.length ) {
				$error = $('<div class="error"></div>').appendTo( $li );
			}
			$error.text('上传失败');
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
			//$.zjm_upload.initTable(defParam);
		});
	}
	
	
