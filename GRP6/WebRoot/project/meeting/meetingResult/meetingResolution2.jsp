<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common_timestamp.jsp" %>

<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">
				业务信息
			</h4>
					<input type="hidden" id="apply_ID" value="${apply.apply_ID }">
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务编号：<span class="grey">${apply.busiCode}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目名称：<span class="grey">${apply.projectName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务性质：<span class="grey">${apply.busiNatureName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						类别：<span class="grey">${apply.projectType}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						申请金额(万元)：<span class="grey"><fmt:formatNumber value="${apply.applySum}" pattern="###,###.######"> </fmt:formatNumber></span></h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						A角：<span class="grey">${apply.amanName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
					    B角：<span class="grey">${apply.bmanName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						风控评审人：<span class="grey">${apply.reviewManName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-12">
						经办部门：<span class="grey">${apply.departName}</span>
					</h5>
			<div class="space-16 col-sm-12"></div>
			<h4 class="header smaller lighter blue">
				初审档案
			</h4>
			<div class="table-responsive" id="loadinfo222">
				<table id="firstTrial_table" style="font-size: 13px !important;"></table>
			</div>
			
			
			<div class="space-16 col-sm-12"></div>
			<h4 class="header smaller lighter blue">
				复审档案
			</h4>
			<div class="table-responsive" id="loadinfo222">
				<table id="secondTrial_table" style="font-size: 13px !important;"></table>
			</div>
			
			<div class="space-16 col-sm-12"></div>
			<h4 class="header smaller lighter blue">
				评审基本信息
				<c:if test="${'view' ne type }">
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_updateMeetingResolution_Meeting">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">修改</span>
				</button>
				</c:if>
			</h4>
			<input type="hidden" id="meetingResolution_ID" name="meetingResolution_ID" value="${meetingResolution.meetingResolution_ID }">
			<input type="hidden" id="apply_ID" name="apply_ID" value="${meetingResolution.apply_ID }">
			<h5 style="line-height: 26px;"class="col-sm-12">
				决议编号：<span class="grey">${meetingResolution.resolutionCode}</span>
			</h5>
			<h5  style="line-height: 26px;"class="col-sm-12">
				评审会编号：<span class="grey">${meetingResolution.meetingCode}</span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				上会日期：<span class="grey"><fmt:formatDate value="${meetingResolution.meetingDate}" pattern="yyyy-MM-dd"/></span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				表决评委：<span class="grey">${meetingResolution.userNameList}</span>
			</h5>
			<h5  style="line-height: 26px;"class="col-sm-12">
				列席人员：<span class="grey">${meetingResolution.otherUserNameList}</span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				评委投票结果：
				<span class="grey">
				参会应到人数：${meetingResolution.shouldJury}人&nbsp;&nbsp;&nbsp;&nbsp;
				参会实到人数：${meetingResolution.senseJury}人&nbsp;&nbsp;&nbsp;&nbsp;
				决议通过人数：${meetingResolution.passJury}人</span>
			</h5>
			<div class="space-16 col-sm-12"></div>	
			<h4 class="header smaller lighter blue">
				批准担保情况
				<c:if test="${'view' ne type }">
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addMeetingDetail">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
				</button>
				</c:if>
			</h4>
			<c:forEach items="${meetingDetailList}" var="meetingDetail">
				<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header">
						<h5>${meetingDetail.busiTypeName} | <c:choose>
										<c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"> </fmt:formatNumber>&nbsp;万元</c:otherwise>
									</c:choose> | ${meetingDetail.periodMonthDay}| ${meetingDetail.bankName}</h5>
						<c:if test="${'view' ne type }">
						<div class="widget-toolbar">
							<a class="" onclick="$.zjm_meetingResolution.meetingDetailEdit(this.id);" href="#" id="${meetingDetail.meetingDetail_ID}">
								<i class="icon-edit btn_meet_edit" ></i>
							</a>
							<a class="" href="#" onclick="$.zjm_meetingResolution.meetingDetailDel(this.id);" id="${meetingDetail.meetingDetail_ID}">
								<i class="icon-trash red " ></i>
							</a>
						</div>
						</c:if>
					</div>
	
					<div class="widget-body">
						<div class="widget-main">
							<div class="row">
								<h5 style="line-height: 26px;" class="col-sm-6">业务品种：<span class="grey">${meetingDetail.busiTypeName==""?"(空)":meetingDetail.busiTypeName}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">合作机构：<span class="grey">${meetingDetail.bankName==""?"(空)":meetingDetail.bankName}</span></h5>
								
								<h5 style="line-height: 26px;" class="col-sm-6">担保金额：<span class="grey">
								<c:choose>
										<c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"> </fmt:formatNumber>&nbsp;万元</c:otherwise>
									</c:choose></span></h5>
								
								<h5 style="line-height: 26px;" class="col-sm-6">担保期限：<span class="grey">${meetingDetail.periodMonthDay==""?"(空)":meetingDetail.periodMonthDay}</span></h5>
								
								<h5 style="line-height: 26px;" class="col-sm-6">担保责任范围：<span class="grey">${meetingDetail.guarantyScope==""?"(空)":meetingDetail.guarantyScope}&nbsp;&nbsp;
								<c:choose>
										<c:when test="${empty meetingDetail.guarantyScale || meetingDetail.guarantyScale eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyScale}" pattern="###,###.######"> </fmt:formatNumber>&nbsp;%</c:otherwise>
									</c:choose></span></h5>
								
								<h5 style="line-height: 26px;" class="col-sm-6">责任金额：<span class="grey">
								<c:choose>
										<c:when test="${empty meetingDetail.guarantyDutySum || meetingDetail.guarantyDutySum eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyDutySum}" pattern="###,###.######"> </fmt:formatNumber>&nbsp;万元</c:otherwise>
									</c:choose></span></h5>
								
								<h5 style="line-height: 26px;" class="col-sm-6">评审费率：<span class="grey">
                                    <c:choose>
										<c:when test="${empty meetingDetail.reviewRate || meetingDetail.reviewRate eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.reviewRate}"  pattern="####,###.######"/>‰</c:otherwise>
									</c:choose></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">担保费率：<span class="grey">
								<c:choose>
										<c:when test="${empty meetingDetail.guarantyRate || meetingDetail.guarantyRate eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyRate}"  pattern="####,###.######"/>%</c:otherwise>
									</c:choose></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">保证金比例：<span class="grey">
								<c:choose>
										<c:when test="${empty meetingDetail.bzScale || meetingDetail.bzScale eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.bzScale}"  pattern="####,###.######"/>%</c:otherwise>
									</c:choose></span></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="space-16 col-sm-12"></div>
			<h4 class="header smaller lighter blue">
				决议内容
				<c:if test="${'view' ne type }">
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_updateMeetingResolution">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">修改</span>
				</button>
				</c:if>
			</h4>
			<h5 style="line-height: 26px;"class="col-sm-12">
				评审决议：<span class="grey"><pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"><c:choose><c:when test="${empty meetingResolution.signed }">（空）</c:when><c:otherwise> ${meetingResolution.signed }</c:otherwise></c:choose>
				<%-- ${meetingResolution.signed==""?"(空)":meetingResolution.signed} --%></pre></span>
			</h5>
			<h5  style="line-height: 26px;"class="col-sm-12">
				保证措施：<span class="grey"><pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"><c:choose><c:when test="${empty meetingResolution.optDesc }">（空）</c:when><c:otherwise> ${meetingResolution.optDesc }</c:otherwise></c:choose>
				<%-- ${meetingResolution.optDesc==""?"(空)":meetingResolution.optDesc} --%></pre></span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				过程控制：<span class="grey"><pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"><c:choose><c:when test="${empty meetingResolution.processControl }">（空）</c:when><c:otherwise> ${meetingResolution.processControl }</c:otherwise></c:choose>
				<%-- ${meetingResolution.processControl==""?"(空)":meetingResolution.processControl} --%></pre></span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				放款条件：<span class="grey"><pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"><c:choose><c:when test="${empty meetingResolution.loanConditions }">（空）</c:when><c:otherwise> ${meetingResolution.loanConditions }</c:otherwise></c:choose>
				<%-- ${meetingResolution.loanConditions==""?"(空)":meetingResolution.loanConditions} --%></pre></span>
			</h5>
			<h5  style="line-height: 26px;"class="col-sm-12">
				其他事项：<span class="grey"><pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"><c:choose><c:when test="${empty meetingResolution.otherMatters }">（空）</c:when><c:otherwise> ${meetingResolution.otherMatters }</c:otherwise></c:choose>
				<%-- ${meetingResolution.otherMatters==""?"(空)":meetingResolution.otherMatters} --%></pre></span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				保后监管周期：<span class="grey"><c:choose><c:when test="${empty meetingResolution.controlTypeName }">（空）</c:when><c:otherwise> ${meetingResolution.controlTypeName }</c:otherwise></c:choose>
				<%-- ${meetingResolution.controlTypeName==""?"(空)":meetingResolution.controlTypeName} --%></span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-12">
				在保监管要求：<span class="grey"><pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"><c:choose><c:when test="${empty meetingResolution.monitoredAsking }">（空）</c:when><c:otherwise> ${meetingResolution.monitoredAsking }</c:otherwise></c:choose>
				<%-- ${meetingResolution.monitoredAsking==""?"(空)":meetingResolution.monitoredAsking} --%></pre></span>
			</h5>
			<h5  style="line-height: 26px;"class="col-sm-12">
				决议结果：<span class="grey"><c:choose><c:when test="${empty meetingResolution.resolutionResultName }">（空）</c:when><c:otherwise> ${meetingResolution.resolutionResultName }</c:otherwise></c:choose>
				<%-- ${meetingResolution.resolutionResultName==""?"(空)":meetingResolution.resolutionResultName} --%></span>
			</h5>	
		</div>
	</div>
	<!-- <div class="space-16"></div>
	<div class="clearfix form-actions">
        <div class="col-sm-offset-4 col-sm-8">
		<button class="btn btn-primary" type="button"><i class="icon-location-arrow bigger-110"></i>生成Word</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn" type="button" id="btn_close"><i class="icon-remove bigger-110 "></i>关闭</button>
       
        
   
      </div>
</div>/.page-content -->
</div>
<div id="meetingResolution_page"></div>
<%-- <%@ include file="/common_foot.jsp" %>

<%@ include file="/common_del.jsp" %>
<%@ include file="/project/meetResolution/meetingResolution/resolutionContent/resolutionContentEdit.jsp" %>
<%@ include file="/project/meetResolution/meetingResolution/meetingDetail/meetingDetailAdd.jsp"%> 
<%@ include file="/project/meetResolution/meetingResolution/meetingDetail/meetingDetailDel.jsp"%> 
<%@ include file="/project/meetResolution/meetingResolution/meetingDetail/meetingDetailEdit.jsp"%>
<%@ include file="/project/meetResolution/meetingResolution/reviewInfo/reviewInfoEdit.jsp"%> --%>
<script src="<%=path %>/project/meetResolution/meetingResolution/meetingResolution.js?v=<%=vardate%>"></script>

							
									
									