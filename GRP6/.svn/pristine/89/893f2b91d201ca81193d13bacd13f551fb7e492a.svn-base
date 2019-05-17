(function($,z){
	$.zjm_clientDataIndex = {
		initDate:initDate,//初始化函数
	};
	
	//初始化函数;
	function initDate(){		
		var uploadParam = {
			 	"isFile":false,
				"clientFileType":"",
				"name":"",
				"fileOneType":"clientFiles",//客户附件
				"fileTwoType":"05",//附件上传入口分类
				"clientID":$("#client_ID").val(),//客户id
				"projectID":""//项目id

		};
		$("#clientMaterialIndex").load("/client/clientMaterial/clientMaterialNeedSubmit",uploadParam,function(){
         }
		);
	};
})(jQuery, this);
$(function () {		
	var type = tool.getUrlParam('type');	
	
	if(type == 'view'){
		$(".btn_add").hide();//上传按钮;
		$(".deleteOneClientFile").hide();//删除按钮;
	}
	 //初始化图片附件页面;
	$(".clientMaterial").click(function(){		
		var type = tool.getUrlParam('type');	
		if(type == 'view'){
			$(".btn_add").hide();//上传按钮;
			$(".deleteOneClientFile").hide();//删除按钮;
		}
		$.zjm_clientDataIndex.initDate();
		
	});
	
	
	
	
});

