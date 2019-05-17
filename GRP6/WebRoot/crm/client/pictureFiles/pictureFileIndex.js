(function($,z){
	$.zjm_pictureFileIndex = {
		initDate:initDate,//初始化函数
	};
	
	//初始化函数;
	function initDate(){		
		var uploadParam = {
			 	"isFile":false,
				"clientFileType":"",
				"name":"",
				"fileOneType":"clientFiles",//客户附件
				"fileTwoType":"02",//附件上传入口分类
				"clientID":$("#client_ID").val(),//客户id
				"projectID":""//项目id

		};
		$("#pictureFileIndex").load("/crm/filesUpload/selectPictureFileList",uploadParam,function(){
         }
		);
	};
})(jQuery, this);
$(function () {		
	var type = tool.getUrlParam('type');	
	if(type == 'view'){
		$(".activeUpload_Div").hide();//上传按钮;
		$(".delete_image").hide();//删除按钮;
	}
	 //初始化图片附件页面;
	$(".pictureFile").click(function(){		
		$.zjm_pictureFileIndex.initDate();
		
	});
	
	
	
	
});

