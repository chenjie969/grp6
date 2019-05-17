$.zjm_pictureFile = {
				"initUpload" : initUpload, //初始化上传功能
				"activateUploadBuild":activateUploadBuild,//激活上传组件基本的
				"deleteOnePictureFile":deleteOnePictureFile,
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
						"isFile":"",
						"clientFileType":"",
						"fileOneType":"",//附件表分类
						"fileTwoType":"",//附件上传入口分类
						"clientID":"",//客户id
						"projectID":""//项目id
					},//上传附加参数
					"fileList" : "",//待上传的附件列表ID
					"fileListURL" : "",//加载附件列表数据地址
					"mimeTypes":""//限定上传附件类型
			};
			defParam = $.extend(true,defParam,param);
			$.zjm_pictureFile.activateUploadBuild(defParam);
		}
		
		/**
		 * 激活上传组件  基本的basic
		 */
		function activateUploadBuild(defParam){
			console.log(defParam.mimeTypes);
			uploader = new plupload.Uploader({
				runtimes : 'html5,flash,silverlight,html4',
				browse_button : defParam.btn_PickID, // you can pass in id...
				//container: document.getElementById('container'), // ... or DOM Element itself
				url : defParam.uploadURL,
				filters : {
					max_file_size : '100mb',
					mime_types: defParam.mimeTypes
				},
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
							document.getElementById(defParam.uploadFileList).innerHTML += '<div id="' + file.id + '">'+ file.name + ' (' + plupload.formatSize(file.size) + ') <b><button class="btn btn-xs btn-danger" onclick="uploader.removeFile(\''+file.id+'\');" ><i class="icon-trash bigger-120"></i></button></b></div>';
						});
					},
					FilesRemoved: function(up, files) {
						plupload.each(files, function(file) {
							$("#"+file.id).remove();
						});
					},
					UploadProgress: function(up, file) {
						document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
					},
					Error: function(up, err) {
						var htmlContainer = ['<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 错误信息 </label>'+
							'<div class="col-sm-9" id="'+defParam.uploadConsoleList+'">'+
							'</div>'];

							if($("#"+defParam.uploadConsoleList).length <= 0 ){
								$("#"+defParam.uploadConsoleList+"Div").append(htmlContainer.join(''));
							}
						document.getElementById(defParam.uploadConsoleList).innerHTML += "\n" + err.code + ": " + err.message;
					}
				}
			});
			uploader.init();
			
		}
		//删除图片文件;
		function deleteOnePictureFile(clientFiles_ID,pathFile,clientID,fileTwoType){
			var datas={"fileID":clientFiles_ID,"filePath":pathFile,"clientID":clientID,"fileOneType":"clientFiles"};
			$("#pictureFileDelModule").modal({keyboard:true});
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/crm/filesUpload/delectOneFilesInfo',data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj){
			        		tool.undisabled(".btn_submit");
							$("#pictureFileDelModule").modal("hide");
							if("05" == fileTwoType){
								$.zjm_clientDataIndex.initDate();//客户资料清单
							}else{
								$.zjm_pictureFileIndex.initDate();
							}
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
			        }
				});
			});
			$("#pictureFileDelModule").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			
		};