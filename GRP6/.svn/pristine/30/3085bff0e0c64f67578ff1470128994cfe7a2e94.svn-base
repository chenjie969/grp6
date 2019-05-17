// 定义函数
(function($,z){
	$.zjm_employeeBasicInfo = {		
		updateEmployeeBasicInfo:updateEmployeeBasicInfo//修改员工基本信息			
	};	
		
	/* 修改员工基本信息 更新员工基本信息*/
	function updateEmployeeBasicInfo(user_uid,user_name){
		$("#employeeUpdate_page").load(
				"/oa/staffCase/selectEmployeeEditPage",{"user_uid":user_uid,"user_name":user_name},function(response,status,xhr){
					$("#updateBasicInfoModal").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#updateBasicInfo_Form").validationEngine("validate")){
							var queryContainer_form = $("#updateBasicInfo_Form");					
								$.ajax({type:'POST',url:'/oa/staffCase/updateOneemployeeInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	
									if(data.obj==1){							        	
											$("#updateBasicInfoModal").modal("hide");
											window.location.reload();
							        	}else{
											alert("保存失败！");
										}
							        }
								});
						
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}

})(jQuery, this); // 定义函数 end
$(function () {	
	// 修改 	 
	$("#btn_updateBasicInfo").click(function(){
		var user_uid =$("#user_uid").val();
		var staffcase_Id=$("#staffcase_Id").val();
		var user_name =$("#user_name").val();
		$.zjm_employeeBasicInfo.updateEmployeeBasicInfo(user_uid,user_name)
	});		
}); 

