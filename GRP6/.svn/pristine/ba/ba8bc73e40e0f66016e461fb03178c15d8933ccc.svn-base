$(function () {
    $("#myTab").on("click", "a", function () {
        var $this = $(this);
        /*var keyword = $("input.search-query").val().trim();*/
        if ($this.is("[href='#one']")) {
            var $tabPane = $("#one");
            $tabPane.load("/oa/meeting/myMeetingList?currentStatus=waiting&keyword=" + "", function (data) {
                updateNumberBadge("waiting");
            })
        } else if ($this.is("[href='#two']")) {
            var $tabPane = $("#two");
            $tabPane.load("/oa/meeting/myMeetingList?currentStatus=running&keyword=" + "", function (data) {
            	updateNumberBadge("running");
            })
        } else if ($this.is("[href='#three']")) {
            var $tabPane = $("#three");
            $tabPane.load("/oa/meeting/myMeetingList?currentStatus=over&keyword=" + "", function (data) {
            	updateNumberBadge("over");
            })
        }
    }).find("[href='#one']").click();
    
    $("#one").load("/oa/meeting/myMeetingList?currentStatus=waiting&keyword=" + "", function (data) {
        updateNumberBadge("waiting");
    });
    $("#two").load("/oa/meeting/myMeetingList?currentStatus=running&keyword=" + "", function (data) {
        updateNumberBadge("running");
    });
    $("#three").load("/oa/meeting/myMeetingList?currentStatus=over&keyword=" + "", function (data) {
        updateNumberBadge("over");
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
    $(".tab-content").on("click", "a.approve", function () {
        var $meeting = $(this).parents("div.meeting");
        var meetingID = $meeting.attr("data-meeting-id").trim();
        $.ajax({
            type: 'POST',
            url: '/oa/meeting/approve',
            data: JSON.stringify({meeting_ID: meetingID}),
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (data) {
                if (data.obj === true) {
                    $meeting.remove();
                    updateNumberBadge();
                    $("#pleaseSelectOne #message").text("操作成功");
                    $("#pleaseSelectOne").modal({keyboard: true});

                }
            }
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
                        url: '/oa/meeting/reject',
                        data: JSON.stringify($form.serializeJson()),
                        contentType: 'application/json; charset=UTF-8',
                        dataType: 'json',
                        success: function (data) {
                            if (data.obj === true) {
                                $meeting.remove();
                                $("#rejectModal").modal("hide");
                                $("#pleaseSelectOne #message").text("操作成功");
                                $("#pleaseSelectOne").modal({keyboard: true});

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
    $("#search_form").on("click", "button", function () {
        // var keyword = $("input.search-query").val().trim();
        var $tabPane = $(".tab-pane.active");
        $("a[href='#" + $tabPane.attr("id") + "'").click();
    })
})

function updateNumberBadge(currentStatus) {
    /*var number = $("#one").find("div.meeting").length;
    if (number) {
        $("a[href='#one'] span").text(number).show();
    } else {
        $("a[href='#one'] span").hide();
    }*/
    
    
    if ("waiting" === currentStatus) {
        var number = $("#one").find("div.meeting").length;
        if (number) {
            $("a[href='#one'] span").text(number).show();
        } else {
            $("a[href='#one'] span").text(0).show();
        }
    } else if ("running" === currentStatus) {
        var number = $("#two").find("div.meeting").length;
        if (number) {
            $("a[href='#two'] span").text(number).show();
        } else {
            $("a[href='#two'] span").text(0).show();
        }
    } else if ("over" === currentStatus) {
        var number = $("#three").find("div.meeting").length;
        if (number) {
            $("a[href='#three'] span").text(number).show();
        } else {
            $("a[href='#three'] span").text(0).show();
        }
    }
}