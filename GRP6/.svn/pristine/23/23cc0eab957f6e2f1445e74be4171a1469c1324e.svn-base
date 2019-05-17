<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<style>
	.subjectView:hover {text-decoration: none;}
</style>
 <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">评审会20070001</h5>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                    <fmt:formatDate pattern="YYYY年MM月dd日"
                                                    value="${meeting.meetingDateTime}"/>
                                </li>

                                <li>
                            </ul>

                            <hr/>
                            <div class="price blue">
                                    <h4 style="text-align:center;"><a href="#" class="subjectView"> ${meeting.meetingRoomName}</a></h4>
                            </div>
                            <!-- <hr/>
                            <div class="price blue">
                              <h4 style="text-align:center;">
                                  	<a href="#" class="subjectView1">查看评审项目详细信息</a>
								</h4>
                            </div> -->
                            
                        </div>

                        <div style="height:44px;">
                            <a href="#" class="btn btn-block btn-warning view">
                                <i class="icon-zoom-in bigger-110"></i>
                                <span>查看</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>




<c:if test="${empty meetings}">
    <div class="row">
        <h5 class="text-center">没有符合条件的记录</h5>
    </div>
</c:if>
