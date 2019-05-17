<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="educationBackgroundModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看教育背景</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									起止年月：<span class="grey">
									${hrstaffEdu.educationStartDate}
									至	${hrstaffEdu.educationEndDate}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									学校：<span class="grey">
									<c:choose><c:when test="${empty hrstaffEdu.educationSchool}">（空）</c:when>
								<c:otherwise>${hrstaffEdu.educationSchool}</c:otherwise>
							</c:choose></span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									地点：<span class="grey">	<c:choose><c:when test="${empty hrstaffEdu.educationAddress}">（空）</c:when>
								<c:otherwise>${hrstaffEdu.educationAddress}</c:otherwise>
							</c:choose></span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									学历：<span class="grey">
										<c:choose><c:when test="${empty hrstaffEdu.educationRecordName}">（空）</c:when>
								<c:otherwise>${hrstaffEdu.educationRecordName}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
				<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">
										<c:choose><c:when test="${empty hrstaffEdu.educationNotes}">（空）</c:when>
								<c:otherwise>${hrstaffEdu.educationNotes}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">

				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
