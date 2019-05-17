(function ($, z) {
    $.zjm_meetingRoomAdd = {
        initFileList:initFileList // 初始化文件列表
    };

    
    function initFileList (){
	  $.get("/optGuarantyAction/selectProFilesListByEntityID?entityID=" + $("#pledgeFile").val(), function (data) {
      	$("#pictureDIV_realize").empty();
      	if (data.obj) {
      		$.each(data.obj,function(k,v){
      			var aHref=["<div id='"+v.projectFiles_ID+"DIV_realize'><a href='"+v.pathFile+"' target='_blank'>"+v.sourceFileName+"</a>",
      				'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
      				 "<br/><div>"].join('');	
      			$("#pictureDIV_realize").append(aHref);
      		})
          }
      })
    }
    
    
})(jQuery, this); // end zjm_meetingRoomAdd





$(function () {
	/**
	 * 初始化加载列表
	 */
	$.zjm_meetingRoomAdd.initFileList();
})