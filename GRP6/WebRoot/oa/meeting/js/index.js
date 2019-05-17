/**
 * 保证措施管理---js
 * author: lancepro
 * 2017年7月11日 15:25:25
 */

(function ($, z) {





})(jQuery, this);

$(function () {
    /**
     * 文档加载的时候 读取
     */


    $("#calendar").fullCalendar({
        locale: 'zh-cn',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        // slotDuration: moment.duration(1, 'hours'),
        slotMinutes: 60,
        minTime: '08:00:00',
        maxTime: '18:00:00',
        views: {
            basic: {
                // options apply to basicWeek and basicDay views
            },
            agenda: {
                // options apply to agendaWeek and agendaDay views
            },
            week: {
                // options apply to basicWeek and agendaWeek views
            },
            day: {
                // options apply to basicDay and agendaDay views
            }
        },
        events: {
            url: '/oa/meeting/meetingEventArray',
            data: function () { // a function that returns an object
                return {
                    meetingRoomID: $(".meeting-room.active").attr("id")
                };
            }
        },
        eventRender: function (event, element) {
            var date = moment(event.start).format("YYYY年MM月DD日")
            var start = moment(event.start).format("HH:mm");
            var end = moment(event.end).format("HH:mm");
            var createTime = moment(event.createTime).format("YYYY年MM月DD日 HH:mm:ss");
            var statuss = event.updateTime;
            var statusss = '';
            if(statuss='0'){
            	statusss = '待审核';
            }else if(statuss='1'){
            	statusss = '通过';
            }else if(statuss='3'){
            	statusss = '未通过';
            }else{
            	statusss = '撤销';
            }
            var remark=event.remark;
            if(typeof(remark)=='undifined' || remark==null){
            	remark="";
            }
            var outMembers = event.outMembers;
            if(typeof(outMembers)=='undifined' || outMembers==null){
            	outMembers="";
            }
            element.qtip({
                content: '<b>会议名称：&nbsp;' + event.title + '</b>' + '<br><br><b>会议室:&nbsp;</b> ' + event.meetingRoom + 
                '<br><br><b>日期:&nbsp;</b> ' + date + '<br><br><b>时间:&nbsp;</b> ' + start + ' - ' + end + 
                '<br><br><b>会议主持人:&nbsp;</b> ' + event.compereName +'<br><br><b>出席人员:&nbsp;</b> ' + event.membersNameList +
                '<br><br><b>外部出席人员:&nbsp;</b> ' + outMembers+'<br><br><b>主要议题:&nbsp;</b> ' + event.subject +'<br><br><b>备注:&nbsp;</b>'+ remark+
                '<br><br><b>附件:&nbsp;</b>' + event.fileNme + '<br><br><b>会议室管理员:&nbsp;</b>'+ event.managerNameList+
                '<br><br><b>申请人:&nbsp;</b>'+event.createUserName + '<br><br><b>申请时间:&nbsp;</b>' + createTime + '<br><br><b>审核状态:&nbsp;</b>' +statusss
            })
        },
    })
    ;
    $("[href='#tab_meeting_record']").on("click", function () {
        var $meetingRecord = $("#tab_meeting_record");
        if (!$meetingRecord.hasClass("initialized")) {
            $meetingRecord.load("/oa/meeting/meetingRecord", function () {
                $meetingRecord.addClass("initialized")
                initRecordPage();
            });

        }
    })
    $(".meeting-room").on("click", function () {
        var $this = $(this);
        if (!$this.is(".active")) {
            $this.addClass("active").siblings(".meeting-room").removeClass("active");
            $("#calendar").fullCalendar('refetchEvents')
        }
    })
    $("#active_apply_modal").on("click", function () {
        $("#applyModal").load("/oa/meeting/applyModal", function () {
        	initModal();
            $("#add_meeting").modal({keyboard: true});
            $("#add_meeting").on("hidden.bs.modal", function () {
                $(this).data('bs.modal', null);
                $("#calendar").fullCalendar('refetchEvents')
            })
        })
    })
});

