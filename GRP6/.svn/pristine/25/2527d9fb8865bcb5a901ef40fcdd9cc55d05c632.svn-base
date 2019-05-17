<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h4 class="header smaller lighter blue">
	基本信息
	<c:if test="${type=='edit'}">
		<button type="button" name="button"
			class="btn btn-minier btn-warning pull-right"
			id="btn_updateBasicInfo">
			<i class="icon-edit bigger-110"></i> <span
				class="bigger-110 no-text-shadow">修改</span>
		</button>
	</c:if>
</h4>
<input value="${hrstaffCase.user_uid}" name="user_id" id="user_id"
	type="hidden" />
<input value="${hrstaffCase.user_name}" name="user_name" id="user_name"
	type="hidden" />
<div class="row" style="margin: 0;">
	<h5 class="col-sm-4">
		性别：<span> <c:choose>
				<c:when test="${empty hrstaffCase.sex}">（空）</c:when>
				<c:otherwise>
					${hrstaffCase.sex}
				</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-4">
		民族：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffNational}">（空）</c:when>
				<c:otherwise>
					${minzuMap[hrstaffCase.staffNational]}
				</c:otherwise>
			</c:choose> 
		</span>
	</h5>
	<h5 class="col-sm-6">
		身份证号：<span>
		 <c:choose>
				<c:when test="${empty hrstaffCase.staffDocuments}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffDocuments}</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-12">
		出生日期：<span> <c:choose>
				<c:when test="${empty hrstaffCase.borndate}">（空）</c:when>
				<c:otherwise>
					<fmt:formatDate value="${hrstaffCase.borndate}"
						pattern="yyyy-MM-dd" />
				</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-4">
		婚姻状况：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffMarriage}">（空）</c:when>
				<c:otherwise>${MarriageMap[hrstaffCase.staffMarriage]}</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-8">
		政治面貌：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffPolitical}">（空）</c:when>
				<c:otherwise>${ZhengzhiMap[hrstaffCase.staffPolitical]}</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-4">
		籍贯：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffBirthplace}">（空）</c:when>
				<c:otherwise> ${hrstaffCase.staffBirthplace}</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-8">
		户口所在地：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffAccountLocation}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffAccountLocation}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-4">
		户籍性质：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffCensus}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffCensus}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-4">
		试用期：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffPeriod}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffPeriod}</c:otherwise>
			</c:choose></span>&nbsp;月
	</h5>
	<h5 class="col-sm-4">
		学历：<span><c:choose>
				<c:when test="${empty hrstaffCase.staffEducation}">（空）</c:when>
				<c:otherwise>
					${EducationMap[hrstaffCase.staffEducation]}
				</c:otherwise>
			</c:choose> </span>
	</h5>
	<h5 class="col-sm-4">
		职称：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffTitle}">（空）</c:when>
				<c:otherwise>
					 ${ZhichengMap[hrstaffCase.staffTitle]}
				</c:otherwise>
			</c:choose>
		</span>
	</h5>
	<h5 class="col-sm-8">
		毕业院校：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffGraduateInstitutions}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffGraduateInstitutions}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-4">
		员工类型：<span>
		<c:choose>
			<c:when test="${empty hrstaffCase.staffType}">（空）</c:when>
				<c:otherwise>${ygMap[hrstaffCase.staffType]}</c:otherwise>
			</c:choose>
		 </span>
	</h5>
	<h5 class="col-sm-8">
		职务：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffDuty}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffDuty}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-12">
		家庭电话：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffHomeTEL}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffHomeTEL}</c:otherwise>
			</c:choose> 
		</span>
	</h5>
	<h5 class="col-sm-12">
		邮编：<span><c:choose>
				<c:when test="${empty hrstaffCase.staffHomeZIP}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffHomeZIP}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-4">
		电子邮件：<span> <c:choose>
				<c:when test="${empty hrstaffCase.email}">（空）</c:when>
				<c:otherwise>${hrstaffCase.email}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-8">
		手机号：<span> <c:choose>
				<c:when test="${empty hrstaffCase.mobilphone}">（空）</c:when>
				<c:otherwise>${hrstaffCase.mobilphone}</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-4">
		分机号：<span> <c:choose>
				<c:when test="${empty hrstaffCase.subphone}">（空）</c:when>
				<c:otherwise>${hrstaffCase.subphone}</c:otherwise>
			</c:choose></span>&nbsp;
	</h5>
	<h5 class="col-sm-8">
		家庭详细地址：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffHomeADR}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffHomeADR}</c:otherwise>
			</c:choose></span>&nbsp;
	</h5>
	<h5 class="col-sm-12">
		劳动合同：<span></span>
		<c:choose>
				<c:when test="${empty hrstaffCase.staffStartContractDate}">（空）</c:when>
				<c:otherwise><fmt:formatDate value="${hrstaffCase.staffStartContractDate}"
			pattern="yyyy-MM-dd" /></c:otherwise>
			</c:choose>
		
		至
		<c:choose>
				<c:when test="${empty hrstaffCase.staffEndContractDate}">（空）</c:when>
				<c:otherwise><fmt:formatDate value="${hrstaffCase.staffEndContractDate}"
			pattern="yyyy-MM-dd" /></c:otherwise>
			</c:choose>
		
	</h5>
	<h5 class="col-sm-12">
		转正日期：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffRegularizedDate}">（空）</c:when>
				<c:otherwise>
					<fmt:formatDate value="${hrstaffCase.staffRegularizedDate}"
						pattern="yyyy-MM-dd" />
				</c:otherwise>
			</c:choose></span>
	</h5>
	<h5 class="col-sm-4">
		已休年假：<span> <c:choose>
				<c:when test="${empty hrstaffCase.staffYearHoliday}">（空）</c:when>
				<c:otherwise>${hrstaffCase.staffYearHoliday}</c:otherwise>
			</c:choose></span>&nbsp;天
	</h5>
	<h5 class="col-sm-4">
		备注：<span> <c:choose>
				<c:when test="${empty hrstaffCase.remark}">（空）</c:when>
				<c:otherwise>${hrstaffCase.remark}</c:otherwise>
			</c:choose></span>
	</h5>
</div>
<div id="employeeBasicInfo_page"></div>





