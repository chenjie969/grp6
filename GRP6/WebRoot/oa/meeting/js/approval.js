$(function () {
    $("#myTab").on("click", "a", function () {
        var $this = $(this);
        /*var keyword = $("input.search-query").val().trim();*/
        if ($this.is("[href='#one']")) {
            var $tabPane = $("#one");
            $tabPane.load("/oa/meeting/approvalList?approvalStatus=0&keyword=" + "", function (data) {
                updateNumberBadge('0');
            })
        } else if ($this.is("[href='#two']")) {
            var $tabPane = $("#two");
            $tabPane.load("/oa/meeting/approvalList?approvalStatus=1&keyword=" + "", function (data) {
            	updateNumberBadge('1');
            })
        } else if ($this.is("[href='#three']")) {
            var $tabPane = $("#three");
            $tabPane.load("/oa/meeting/approvalList?approvalStatus=3&keyword=" + "", function (data) {
            	updateNumberBadge('3');
            })
        }
    }).find("[href='#one']").click();
    //初始化
    $("#one").load("/oa/meeting/approvalList?approvalStatus=0&keyword=" + "", function (data) {
        updateNumberBadge('0');
    })
    $("#two").load("/oa/meeting/approvalList?approvalStatus=1&keyword=" + "", function (data) {
    	updateNumberBadge('1');
    });
    
    $("#three").load("/oa/meeting/approvalList?approvalStatus=3&keyword=" + "", function (data) {
        updateNumberBadge('3');
    });
    
    
    //查看
    $(".tab-content").on("click","a.subjectView", function () {
        $("#meetingView").load("/oa/meeting/view?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
            $("#view_meeting").modal({keyboard: true});
        })
    })
    
    
    $(".tab-content").on("click", "a.view", function () {
        $("#meetingView").load("/oa/meeting/view?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
            $("#view_meeting").modal({keyboard: true});
        })
    })
    //通过
    $(".tab-content").on("click", "a.approve", function () {
        var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
        $("#meetingView").load("/oa/meeting/showApprovalModalPage",{},function(response,status,xhr){
        	$("#passAuditModal").modal({keyboard:true});
			tool.undisabled("#confirm");
	        $("#confirm").click(function(){
		        $.ajax({
		            type: 'POST',
		            url: '/oa/meeting/approve',
		            data: JSON.stringify({meeting_ID: meetingID}),
		            contentType: 'application/json; charset=UTF-8',
		            dataType: 'json',
		            success: function (data) {
		                if (data.obj === true) {
		                	$("#passAuditModal").modal("hide");
		                    $meeting.remove();
		                    //$("#pleaseSelectOne #message").text("操作成功");
		                    //$("#pleaseSelectOne").modal({keyboard: true});
		                    $("#one").load("/oa/meeting/approvalList?approvalStatus=0&keyword=" + "", function (data) {
		                        updateNumberBadge('0');
		                    })
		                    $("#two").load("/oa/meeting/approvalList?approvalStatus=1&keyword=" + "", function (data) {
		                    	updateNumberBadge('1');
		                    });
		                    
		                    $("#three").load("/oa/meeting/approvalList?approvalStatus=3&keyword=" + "", function (data) {
		                        updateNumberBadge('3');
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
    //拒绝
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
                        url: '/oa/meeting/reject',
                        data: JSON.stringify($form.serializeJson()),
                        contentType: 'application/json; charset=UTF-8',
                        dataType: 'json',
                        success: function (data) {
                            if (data.obj === true) {
                            	$("#rejectModal").modal("hide");
                                $("#pleaseSelectOne #message").text("操作成功");
                                $("#pleaseSelectOne").modal({keyboard: true});
                                updateNumberBadge();
                                $meeting.remove();
                                $("#one").load("/oa/meeting/approvalList?approvalStatus=0&keyword=" + "", function (data) {
                                    updateNumberBadge('0');
                                })
                                $("#two").load("/oa/meeting/approvalList?approvalStatus=1&keyword=" + "", function (data) {
                                	updateNumberBadge('1');
                                });
                                
                                $("#three").load("/oa/meeting/approvalList?approvalStatus=3&keyword=" + "", function (data) {
                                    updateNumberBadge('3');
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
    	$("#meetingView").load("/oa/meeting/showDelModalPage",{},function(response,status,xhr){
    		$("#delAuditModal").modal({keyboard:true});
			tool.undisabled("#confirm");
	        $("#confirm").click(function(){
				tool.disabled("#confirm");
			    $.ajax({
		            type: 'POST',
		            url: '/oa/meeting/delApproval',
		            data: JSON.stringify({meeting_ID: meetingID}),
		            contentType: 'application/json; charset=UTF-8',
		            dataType: 'json',
		            success: function (data) {
		                if(data.obj===true){
							$("#delAuditModal").modal("hide");
							$meeting.remove();
							$("#one").load("/oa/meeting/approvalList?approvalStatus=0&keyword=" + "", function (data) {
						        updateNumberBadge('0');
						    })
						    $("#two").load("/oa/meeting/approvalList?approvalStatus=1&keyword=" + "", function (data) {
						    	updateNumberBadge('1');
						    });
						    
						    $("#three").load("/oa/meeting/approvalList?approvalStatus=3&keyword=" + "", function (data) {
						        updateNumberBadge('3');
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
        // var keyword = $("input.search-query").val().trim();
        var $tabPane = $(".tab-pane.active");
        $("a[href='#" + $tabPane.attr("id") + "'").click();
    })
})

function updateNumberBadge(approvalStatus) {
    if ("0" === approvalStatus) {
        var number = $("#one").find("div.meeting").length;
        if (number) {
            $("a[href='#one'] span").text(number).show();
        } else {
            $("a[href='#one'] span").text(0).show();
        }
    } else if ("1" === approvalStatus) {
        var number = $("#two").find("div.meeting").length;
        if (number) {
            $("a[href='#two'] span").text(number).show();
        } else {
            $("a[href='#two'] span").text(0).show();
        }
    } else if ("3" === approvalStatus) {
        var number = $("#three").find("div.meeting").length;
        if (number) {
            $("a[href='#three'] span").text(number).show();
        } else {
            $("a[href='#three'] span").text(0).show();
        }
    }

}    
/*function updateNumberBadge(); {
    var number = $("#one").find("div.meeting").length;
    if (number) {
        $("a[href='#one'] span").text(number).show();
    } else {
        $("a[href='#one'] span").hide();
    }
}*/