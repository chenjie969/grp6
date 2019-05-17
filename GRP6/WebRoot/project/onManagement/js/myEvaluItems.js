$(function () {
    $("#myTab").on("click", "a", function () {
        var $this = $(this);
        /*if ($this.is("[href='#one']")) {
            var $tabPane = $("#one");
            $tabPane.load("/pro/meeting/myMeetingList?currentStatus=waiting", function (data) {
                updateNumberBadge("waiting");
            })
        } else if ($this.is("[href='#two']")) {
            var $tabPane = $("#two");
            $tabPane.load("/pro/meeting/myMeetingList?currentStatus=running", function (data) {
            	updateNumberBadge("running");
            })
        } else if ($this.is("[href='#three']")) {
            var $tabPane = $("#three");
            $tabPane.load("/pro/meeting/myMeetingList?currentStatus=over", function (data) {
            	updateNumberBadge("over");
            })
        }*/
       $("#one").load("/pro/meeting/myMeetingList",'', function (data) {
               updateNumberBadge();
       })
        
    }).find("[href='#one']").click();
    
    $("#one").load("/pro/meeting/myMeetingList",'', function (data) {
        updateNumberBadge();
    });
    
    //查看
    $(".tab-content").on("click","a.subjectView", function () {
        $("#meetingView").load("/pro/meeting/showOneEvaluItemsViewPage",
        		{'meeting_ID': $(this).parents("div.meeting").attr("data-meeting-id").trim()}, function () {
            $("#viewEvaluItems").modal({keyboard: true});
            $("#myModalLabel").text("查看我的评审会");
          //弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    });
    
    //查看项目详细信息
    //查看
    $(".tab-content").on("click","a.subjectView1", function () {
        $("#meetingView").load("/pro/meeting/showProViewPage",
        		{'meeting_ID': $(this).parents("div.meeting").attr("data-meeting-id").trim()}, function () {
            $("#view_proName").modal({keyboard: true});
          //弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    });
    
    
    
    
    $(".tab-content").on("click", "a.view", function () {
        $("#meetingView").load("/pro/meeting/showOneEvaluItemsViewPage",
        		{'meeting_ID': $(this).parents("div.meeting").attr("data-meeting-id").trim()}, function () {
            $("#viewEvaluItems").modal({keyboard: true});
            $("#myModalLabel").text("查看我的评审会");
          //弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
        })
    })
})

function updateNumberBadge() {
      var number = $("#one").find("div.meeting").length;
      if (number) {
           $("a[href='#one'] span").text(number).show();
      } else {
           $("a[href='#one'] span").text(0).show();
      }
    /*if ("waiting" === currentStatus) {
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
    }*/
}

