$(function () {
    $("#myTab").on("click", "a", function () {
        var $this = $(this);
       /* var keyword = $("input.search-query").val().trim();*/
        if ($this.is("[href='#one']")) {
            var $tabPane = $("#one");
            $tabPane.load("/pro/meeting/meetingApprovalList?approvalStatus=01&keyword=" + "", function (data) {
                updateNumberBadge("01");
            })
        } else if ($this.is("[href='#two']")) {
            var $tabPane = $("#two");
            $tabPane.load("/pro/meeting/meetingApprovalList?approvalStatus=02&keyword=" + "", function (data) {
            	updateNumberBadge("02");
            })
        } else if ($this.is("[href='#three']")) {
            var $tabPane = $("#three");
            $tabPane.load("/pro/meeting/meetingApprovalList?approvalStatus=03&keyword=" + "", function (data) {
            	updateNumberBadge("03");
            })
        }
    }).find("[href='#one']").click();
    
    $("#one").load("/pro/meeting/meetingApprovalList?approvalStatus=01&keyword=" + "", function (data) {
        updateNumberBadge("01");
    });
    $("#two").load("/pro/meeting/meetingApprovalList?approvalStatus=02&keyword=" + "", function (data) {
    	updateNumberBadge("02");
    });
    $("#three").load("/pro/meeting/meetingApprovalList?approvalStatus=03&keyword=" + "", function (data) {
    	updateNumberBadge("03");
    });
    
    //查看
    $(".tab-content").on("click", "a.subjectView", function () {
        $("#meetingApprovalView").load("/pro/meeting/approvalView?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
        	$("#myModalLabel").text("审批信息详情");
        	$("#view_meeting").modal({keyboard: true});
        	//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    })
    //详细项目名称
    $(".tab-content").on("click", "a.subjectView1", function () {
        $("#meetingApprovalView").load("/pro/meeting/proNameView?proName="+$(this).parents("div.meeting").attr("data-meeting-proName").trim()
        		,function () {
        	$("#view_proName").modal({keyboard: true});
        })
    })
    
    $(".tab-content").on("click", "a.view", function () {
        $("#meetingApprovalView").load("/pro/meeting/approvalView?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
        	$("#myModalLabel").text("审批信息详情");
        	$("#view_meeting").modal({keyboard: true});
        	//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    })
    
    $(".tab-content").on("click", "a.approve", function () {
        var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
        
        $("#meetingApprovalView").load("/pro/meeting/showApprovalModalPage",{},function(response,status,xhr){
        	$("#passAuditModal").modal({keyboard:true});
			tool.undisabled("#confirm");
	        $("#confirm").click(function(){
        
		        $.ajax({
		            type: 'POST',
		            url: '/pro/meeting/approveMeeting',
		            data: JSON.stringify({meeting_ID: meetingID}),
		            contentType: 'application/json; charset=UTF-8',
		            dataType: 'json',
		            success: function (data) {
		                if (data.obj >0) {
		                    //$meeting.remove();
		                    //$("#pleaseSelectOne #message").text("操作成功");
		                    //$("#pleaseSelectOne").modal({keyboard: true});
		                    
		                    $("#passAuditModal").modal("hide");
		                    $meeting.remove();
		                    $("#one").load("/pro/meeting/meetingApprovalList?approvalStatus=01&keyword=" + "", function (data) {
		                        updateNumberBadge("01");
		                    });
		                    $("#two").load("/pro/meeting/meetingApprovalList?approvalStatus=02&keyword=" + "", function (data) {
		                    	updateNumberBadge("02");
		                    });
		                    $("#three").load("/pro/meeting/meetingApprovalList?approvalStatus=03&keyword=" + "", function (data) {
		                    	updateNumberBadge("03");
		                    });
		                }
		            }
		        });
	        });
	        $("#passAuditModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $("#confirm").unbind("click");
			});
        });
        
    })
    
    $(".tab-content").on("click", "a.reject", function () {
        var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
        $("#rejectModal [name='meeting_ID']").val(meetingID);
        $("#rejectModal").modal({keyboard: true});
        var $form = $("#meeting_reject_form");
        $('#rejectModal').on('shown.bs.modal', function (e) {
            $form.validationEngine();
            $("#reject_submit").on("click", function () {
                if ($form.validationEngine("validate")) {
                    $.ajax({
                        type: 'POST',
                        url: '/pro/meeting/rejectApproval',
                        data: JSON.stringify($form.serializeJson()),
                        contentType: 'application/json; charset=UTF-8',
                        dataType: 'json',
                        success: function (data) {
                            if (data.obj > 0) {
                                //$("#pleaseSelectOne #message").text("操作成功");
                                //$("#pleaseSelectOne").modal({keyboard: true});
                                
                                $("#rejectModal").modal("hide");
    		                    $meeting.remove();
    		                    $("#one").load("/pro/meeting/meetingApprovalList?approvalStatus=01&keyword=" + "", function (data) {
    		                        updateNumberBadge("01");
    		                    });
    		                    $("#two").load("/pro/meeting/meetingApprovalList?approvalStatus=02&keyword=" + "", function (data) {
    		                    	updateNumberBadge("02");
    		                    });
    		                    $("#three").load("/pro/meeting/meetingApprovalList?approvalStatus=03&keyword=" + "", function (data) {
    		                    	updateNumberBadge("03");
    		                    });
                            }
                        }
                    });
                }
                return false;
            })
        }).on('hidden.bs.modal', function (e) {
            $form.validationEngine('detach');
            $form[0].reset();
            $(this).data('bs.modal', null);
        })

    })
    
    //删除
    $(".tab-content").on("click", "a.delete", function () {
    	var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
    	$("#meetingApprovalView").load("/pro/meeting/showDelModalPage",{},function(response,status,xhr){
    		$("#delAuditModal").modal({keyboard:true});
			tool.undisabled("#confirm");
	        $("#confirm").click(function(){
				tool.disabled("#confirm");
			    $.ajax({
		            type: 'POST',
		            url: '/pro/meeting/delApproval',
		            data: JSON.stringify({meeting_ID: meetingID}),
		            contentType: 'application/json; charset=UTF-8',
		            dataType: 'json',
		            success: function (data) {
		                if(data.obj>0){
							$("#delAuditModal").modal("hide");
		                    $meeting.remove();
		                    $("#one").load("/pro/meeting/meetingApprovalList?approvalStatus=01&keyword=" + "", function (data) {
		                        updateNumberBadge("01");
		                    });
		                    $("#two").load("/pro/meeting/meetingApprovalList?approvalStatus=02&keyword=" + "", function (data) {
		                    	updateNumberBadge("02");
		                    });
		                    $("#three").load("/pro/meeting/meetingApprovalList?approvalStatus=03&keyword=" + "", function (data) {
		                    	updateNumberBadge("03");
		                    });
						}else{
							alert("删除失败！");
							tool.undisabled("#confirm");
						}
		            }
		        });
	        });
	        $("#delAuditModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $("#confirm").unbind("click");
			});
    	});
    })
    
    $("#search_form").on("click", "button", function () {
        var $tabPane = $(".tab-pane.active");
        $("a[href='#" + $tabPane.attr("id") + "'").click();
    })
})

/*function updateNumberBadge() {
    var number = $("#one").find("div.meeting").length;
    if (number) {
        $("a[href='#one'] span").text(number).show();
    } else {
        $("a[href='#one'] span").hide();
    }
}*/

function updateNumberBadge(approvalStatus) {
    if ("01" === approvalStatus) {
        var number = $("#one").find("div.meeting").length;
        if (number) {
            $("a[href='#one'] span").text(number).show();
        } else {
            $("a[href='#one'] span").text(0).show();
        }
    } else if ("02" === approvalStatus) {
        var number = $("#two").find("div.meeting").length;
        if (number) {
            $("a[href='#two'] span").text(number).show();
        } else {
            $("a[href='#two'] span").text(0).show();
        }
    } else if ("03" === approvalStatus) {
        var number = $("#three").find("div.meeting").length;
        if (number) {
            $("a[href='#three'] span").text(number).show();
        } else {
            $("a[href='#three'] span").text(0).show();
        }
    }

}