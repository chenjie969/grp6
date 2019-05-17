function initRecordPage() {
    $("#tab_meeting_record").on("click", "#recordTabs a", function () {
        var $this = $(this);
        /*var keyword = $("input.search-query").val().trim();*/
        if ($this.is("[href='#one']")) {
            var $tabPane = $("#one");
            $tabPane.load("/pro/meeting/applyRecordList?approvalStatus=01&keyword=" + "", function (data) {
                updateNumberBadge("01");
            })
            
        } else if ($this.is("[href='#two']")) {
            var $tabPane = $("#two");
            $tabPane.load("/pro/meeting/applyRecordList?approvalStatus=02&keyword=" + "", function (data) {
                updateNumberBadge("02");
            })
        } else if ($this.is("[href='#three']")) {
            var $tabPane = $("#three");
            $tabPane.load("/pro/meeting/applyRecordList?approvalStatus=03&keyword=" + "", function (data) {
                updateNumberBadge("03");
            })
        }
    }).find("[href='#one']").click();
    
    
    $("#one").load("/pro/meeting/applyRecordList?approvalStatus=01&keyword=" + "", function (data) {
        updateNumberBadge("01");
    });
    $("#two").load("/pro/meeting/applyRecordList?approvalStatus=02&keyword=" + "", function (data) {
        updateNumberBadge("02");
    });
    $("#three").load("/pro/meeting/applyRecordList?approvalStatus=03&keyword=" + "", function (data) {
        updateNumberBadge("03");
    });
    
    $("#tab_meeting_record").on("click", "a.subjectView", function () {
        $("#meetingView").load("/pro/meeting/approvalView?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
        	$("#myModalLabel").text("申请记录详情");
        	$("#view_meeting").modal({keyboard: true});
        	//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    })
    
    //详细项目名称
    $("#tab_meeting_record").on("click", "a.subjectView1", function () {
        $("#meetingView").load("/pro/meeting/proNameView?proName="+$(this).parents("div.meeting").attr("data-meeting-proName").trim()
        		,function () {
        	$("#view_proName").modal({keyboard: true});
        })
    })
    
    
    $("#tab_meeting_record").on("click", "a.view", function () {
        $("#meetingView").load("/pro/meeting/approvalView?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
        	$("#myModalLabel").text("申请记录详情");
        	$("#view_meeting").modal({keyboard: true});
        	//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    })
    //撤销申请记录
    $("#tab_meeting_record").on("click", "a.cancel", function () {
    	var $meeting = $(this).parents("div.meeting");
    	var meetingID = $meeting.attr("data-meeting-id").trim();
    	$("#meetingView").load("/pro/meeting/showMeetApprovalRejectPage",{},function(response,status,xhr){
    		$("#rejectMeetApproval").modal({keyboard:true});
			tool.undisabled(".btn_submitis");
	        $(".btn_submitis").click(function(){
				tool.disabled(".btn_submit");
		        $.ajax({
		            type: 'POST',
		            url: '/pro/meeting/revokeApplyRecord',
		            data: JSON.stringify({meeting_ID: meetingID}),
		            contentType: 'application/json; charset=UTF-8',
		            dataType: 'json',
		            success: function (data) {
		                /*if (data.obj >0 ) {
		                    $meeting.remove();
		                    //updateNumberBadge("01");
		                    $("#pleaseSelectOne #message").text("操作成功");
		                    $("#pleaseSelectOne").modal({keyboard: true});
		                }*/
		                if(data.obj){
							$("#rejectMeetApproval").modal("hide");
							$meeting.remove();
							$("#one").load("/pro/meeting/applyRecordList?approvalStatus=01&keyword=" + "", function (data) {
						        updateNumberBadge("01");
						    });
						    $("#two").load("/pro/meeting/applyRecordList?approvalStatus=02&keyword=" + "", function (data) {
						        updateNumberBadge("02");
						    });
						    $("#three").load("/pro/meeting/applyRecordList?approvalStatus=03&keyword=" + "", function (data) {
						        updateNumberBadge("03");
						    });
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submitis");
						}
		            }
		        });
	        });
	        $("#rejectMeetApproval").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submitis").unbind("click");
			});
    	});
    })
    
    //删除
    $("#tab_meeting_record").on("click", "a.delete", function () {
    	var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
    	$("#meetingView").load("/pro/meeting/showDelModalPage",{},function(response,status,xhr){
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
		                    $("#one").load("/pro/meeting/applyRecordList?approvalStatus=01&keyword=" + "", function (data) {
		                        updateNumberBadge("01");
		                    });
		                    $("#two").load("/pro/meeting/applyRecordList?approvalStatus=02&keyword=" + "", function (data) {
		                        updateNumberBadge("02");
		                    });
		                    $("#three").load("/pro/meeting/applyRecordList?approvalStatus=03&keyword=" + "", function (data) {
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
    
    $("#tab_meeting_record").on("click", "#search_form button", function () {
        // var keyword = $("input.search-query").val().trim();
        var $tabPane = $("#tab_meeting_record  .tab-pane.active");
        $("a[href='#" + $tabPane.attr("id") + "'").click();
    })
}

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