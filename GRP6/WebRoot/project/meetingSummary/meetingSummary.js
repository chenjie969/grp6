(function($,z){
	$.zjm_meetingSummary = {
		//addMeetingSummary:addMeetingSummary
		
	};
	
	zjm.validata({formId:"meetingSummary_form"});
	$("#btn_insertOneMeetSummary").click(function(){
		var queryContainer_form = $("#meetingSummary_form");
		if(queryContainer_form.validationEngine("validate")){
		$.ajax({type:'POST',
				url:'/project/meetingSummary/updateOneMeetSummary',
				data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
		        	if(data.obj==true){
		        		window.location.reload();
					}else{
						alert("保存失败！");
						tool.undisabled("#btn_insertOneMeetSummary");
					}
				}
		});
		}
	});
		
})(jQuery, this);

$(function () {

	//关闭总办会纪要页面
	$("#btn_colseOneMeetSummary").click(function(){
		window.parent.closeMenu('担保风险部录入总办会纪要'+$("#apply_ID").val());
	});	

});

