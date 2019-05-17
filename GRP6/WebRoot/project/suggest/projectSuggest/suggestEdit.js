$.zjm_suggestEdit = {
			"initUpload" : initUpload, //初始化上传功能
			"activateUploadBuild":activateUploadBuild,//激活上传组件基本的
			"initTable":initTable,//初始化附件列表
			"osdelFile":osdelFile//删除附件
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
					"projectID":""//项目id
				},//上传附加参数
				"fileList" : "",//待上传的附件列表ID
				"fileListURL" : "",//加载附件列表数据地址
				"mimeTypes":""//限定上传附件类型
		};
		defParam = $.extend(true,defParam,param);
		$.zjm_suggestEdit.activateUploadBuild(defParam);
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
	/**初始化列表***/
	function initTable(defParam){
		$("#"+defParam.fileList).bootstrapTable('destroy');
		$("#"+defParam.fileList).bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"sourceFileName",title: '附件名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.sourceFileName;}}, 
				{field:"fileSize",title: '附件大小',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.fileSize/1024;}},
				{field:"uploadDateTime",title: '上传时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDateDetail(row.uploadDateTime);}},
				{field:"uploadManName",title: '上传人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.uploadManName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					//return ['<input type="button" class="btn btn-xs btn-danger btn_osopfile_del" href="javascript:void(0)"><i class="danger icon-trash bigger-120"></i></input>'].join('');
					//return ['<input type="button" class="btn_osopfile_del" value="删除" />'].join('');
					return ['<a href="#"><i class="red icon-trash bigger-120 btn_osopfile_del"></i></a>'].join('');
				},
				events:{
					'click .btn_osopfile_del': function(e, value, row, index) {
						$.zjm_suggestEdit.osdelFile(row,defParam,defParam.uploadParam.fileOneType);
					}/*,
					'click .btn_opfile_viewer': function(e, value, row, index) {
						var viewer = new Viewer(document.getElementById(defParam.fileList), {
						    url: 'data-original'
						});
						viewer.show();
						$(".viewer-close").click(function(){
							viewer.destroy();
						});
					}*/
				}
				}],
				detailView: false,
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: false,      //是否启用排序
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
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
				showColumns: false,     //是否显示所有的列
				showRefresh: false,     //是否显示刷新按钮
				minimumCountColumns: 2,    //最少允许的列数
				clickToSelect: false,    //是否启用点击选中行
				searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
				showToggle: false,//是否显示详细视图和列表视图的切换按钮
				showPaginationSwitch:false,
				showExport: false,                     //是否显示导出
				exportDataType: "basic"              //basic', 'all', 'selected'

		});
	}
	
	
	
	/**删除*/
	function osdelFile(row,defParam,fileOneType){
		var datas;
		if(fileOneType=="clientFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="projFiles"){
			datas={"fileID":row.projectFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="reportFiles"){
			datas={"fileID":row.clientFiles_ID,"filePath":row.pathFile,"clientID":row.client_ID,"fileOneType":fileOneType};
		}else if(fileOneType=="osFiles"){
			datas={"fileID":row.files_ID,"filePath":row.pathFile,"projectID":row.projectID,"fileOneType":fileOneType};
		} 
		$("#ostaskSugget").modal("hide");
		$("#filesUpload_page").load("/crm/filesUpload/selectFilesDelPage",{},function(response,status,xhr){
					$("#delmodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/crm/filesUpload/delectOneFilesInfo',data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#delmodule").modal("hide");
									$("#ostaskSugget").modal({keyboard:true});
									$.zjm_suggestEdit.initTable(defParam);
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

	
	
	
