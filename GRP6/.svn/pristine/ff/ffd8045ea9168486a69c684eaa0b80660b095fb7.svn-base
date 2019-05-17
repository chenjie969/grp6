(function($,z){
	$.zjm_singleLoanReview = {
			confirmLoan:confirmLoan,//确认已放款
			cancelLoanConfirm:cancelLoanConfirm,//撤销放款
			confirmFee:confirmFee,//确认收费
			delFiles:delFiles,//删除附件
	};
	//确认已放款
	function confirmLoan(meetingDetail_ID){
		$("#singleLoanReview_page").load("/project/project/showConfirmLoanPage",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#loanConfirm").modal({keyboard:true});
			//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
			/*注册编辑验证引擎*/
			zjm.validata({formId:"loanConfirm_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				var notLoanSum = isOrNotNull($("#notLoanSum").val());//未放款金额
				var loadSum = isOrNotNull($("#loadSum_input").val());//本次放款金额
				if(loadSum - notLoanSum > 0){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("本次放款金额不能大于未放款金额！");
		        	return false;
					//alert("本次放款金额不能大于未放款金额！");
					//return;
				}
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#loanConfirm_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/project/addConfirmLoan',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#loanConfirm").modal("hide");
										window.location.reload();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#loanConfirm").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//撤销放款
	function cancelLoanConfirm(project_ID){
		$("#singleLoanReview_page").load("/project/project/showCancelLoanConfirmPage",{},function(response,status,xhr){
			$("#cancelLoanConfirm").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/project/cancelLoanConfirm',data:JSON.stringify({"project_ID":project_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#cancelLoanConfirm").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#cancelLoanConfirm").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//确认收费
	function confirmFee(meetingDetail_ID){
		window.parent.openMenu('confirmFee'+meetingDetail_ID,'','确认收费情况','/project/project/showConfirmFeePage',
				'&meetingDetail_ID='+meetingDetail_ID,2);
	}
	
	//删除附件
	function delFiles(projectFiles_ID){
	    $("#pictureFileDelModule").modal({keyboard: true});
	    $(".btn_submit").click(function () {
	        tool.disabled(".btn_submit");
	        $.ajax({
	            type: 'POST',
	            url: '/pro/contractdoc/deleteOneInfoByProFiles_ID',
	            data: {"projectFiles_ID":projectFiles_ID},
	            dataType: 'json',
	            success: function (data) {
	                if (data.obj) {
	                    tool.undisabled(".btn_submit");
	                    $("#pictureFileDelModule").modal("hide");
	                  
	                	window.location.reload();
	                } else {
	                    alert("删除失败！");
	                    tool.undisabled(".btn_submit");
	                }
	            }
	        });
	    });
	    $("#pictureFileDelModule").on("hidden.bs.modal", function (e) {//解除事件绑定
	        $(".btn_submit").unbind("click");
	    });
	
	}
	
	//判空
	function isOrNotNull(str){
		if(str==null ||typeof(str)==undefined || str==''){
			str=0;
		}
		return parseFloat(str).toFixed(4);
	}
	
	
})(jQuery, this);

$(function () {
	
});
