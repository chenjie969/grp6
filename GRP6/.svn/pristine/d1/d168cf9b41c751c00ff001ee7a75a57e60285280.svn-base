(function($,z){
	$.zjm_riskAppraise = {
		//addMeetingSummary:addMeetingSummary
		
	};
	//var riskScheme_ID = "d7239f80d2a74802a7f454ff10055c9a";
	zjm.validata({formId:"riskAppraise_form"});
	$("#btn_insertOneRiskAppraise").click(function(){
		var queryContainer_form = $("#riskAppraise_form");
		if(queryContainer_form.validationEngine("validate")){
		$.ajax({type:'POST',
				url:'/project/riskAppraise/updateOneRiskAppraise',
				data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
		        	if(data.obj==true){
		        		window.location.reload();
					}else{
						alert("保存失败！");
						tool.undisabled("#btn_insertOneRiskAppraise");
					}
				}
		});
		}
	});
		
})(jQuery, this);

$(function () {

	//关闭风险管理委员会评议
	$("#btn_colseOneRiskAppraise").click(function(){
		window.parent.closeMenu('录入风委会评议表'+$("#riskScheme_ID").val());
	});	

});

