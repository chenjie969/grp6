function initRecordPage() {
	/*var keyword = $("input.search-query").val().trim();*/
    $("#tab_meeting_record").on("click", "#recordTabs a", function () {
        var $this = $(this);
        if ($this.is("[href='#one']")) {
            var $tabPane = $("#one");
            $tabPane.load("/oa/meeting/applyRecordList?approvalStatus=0&keyword=" + "", function (data) {
                updateNumberBadge("0");
            })
        } else if ($this.is("[href='#two']")) {
            var $tabPane = $("#two");
            $tabPane.load("/oa/meeting/applyRecordList?approvalStatus=1&keyword=" + "", function (data) {
                updateNumberBadge("1");
            })
        } else if ($this.is("[href='#three']")) {
            var $tabPane = $("#three");
            $tabPane.load("/oa/meeting/applyRecordList?approvalStatus=3&keyword=" + "", function (data) {
                updateNumberBadge("3");
            })
        }
    }).find("[href='#one']").click();
    
    //初始化
    $("#one").load("/oa/meeting/applyRecordList?approvalStatus=0&keyword=" + "", function (data) {
        updateNumberBadge('0');
    })
    $("#two").load("/oa/meeting/applyRecordList?approvalStatus=1&keyword=" + "", function (data) {
    	updateNumberBadge('1');
    });
    $("#three").load("/oa/meeting/applyRecordList?approvalStatus=3&keyword=" + "", function (data) {
        updateNumberBadge('3');
    });
    
    //查看
    $("#tab_meeting_record").on("click","a.subjectView", function () {
        $("#meetingView").load("/oa/meeting/view?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
            $("#view_meeting").modal({keyboard: true});
        })
    })
    
    $("#tab_meeting_record").on("click", "a.view", function () {
        $("#meetingView").load("/oa/meeting/view?meeting_ID=" + $(this).parents("div.meeting").attr("data-meeting-id").trim(), function () {
            $("#view_meeting").modal({keyboard: true});
        })
    })

    $("#tab_meeting_record").on("click", "a.cancel", function () {
        var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
        
        $("#meetingView").load("/oa/meeting/showRefuseModalPage",{},function(response,status,xhr){
    		$("#refuseAuditModal").modal({keyboard:true});
			tool.undisabled("#confirm");
	        $("#confirm").click(function(){
				tool.disabled("#confirm");
        
		        $.ajax({
		            type: 'POST',
		            url: '/oa/meeting/cancel',
		            data: JSON.stringify({meeting_ID: meetingID}),
		            contentType: 'application/json; charset=UTF-8',
		            dataType: 'json',
		            success: function (data) {
		                /*if (data.obj === true) {
		                    $meeting.remove();
		                    updateNumberBadge("0");
		                    $("#pleaseSelectOne #message").text("操作成功");
		                    $("#pleaseSelectOne").modal({keyboard: true});
		
		                }*/
		            	if(data.obj===true){
							$("#refuseAuditModal").modal("hide");
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
	        $("#refuseAuditModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $("#confirm").unbind("click");
			});
    	});
    })
    
    //删除
    $("#tab_meeting_record").on("click", "a.delete", function () {
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

    $("#tab_meeting_record").on("click", "#search_form button", function () {
        // var keyword = $("input.search-query").val().trim();
        var $tabPane = $("#tab_meeting_record  .tab-pane.active");
        $("a[href='#" + $tabPane.attr("id") + "'").click();
    })
}

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