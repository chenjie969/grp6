<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<style>
	table{
		font-size:13px !important;
		text-align: center;
		width: 80%;
	}
	table thead tr th{
		border:1px solid #ddd;
		text-align: center;
	};
	table tbody tr td{
		border:1px solid #ddd;
		text-align: center;
	};
	
</style>

<div class="page-content">
	<div class="page-header">
		<c:if test="${empty comming }">
			<h4>复核放款</h4>
		</c:if>
		<c:if test="${!empty comming }">
			<h4>放款详情</h4>
		</c:if>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<h4 class="header smaller lighter blue">
				项目信息
			</h4>
			<h5 style="line-height: 26px;"class="col-sm-6">
				申请金额：<span class="grey">${empty project.loadSum ? "（空）":project.loadSum}万元</span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-6">
				申请期限：<span class="grey">${empty project.periodMonthDay ? "（空）":project.periodMonthDay}</span>
			</h5>
			<c:choose>
				<c:when test="${project.busiClass eq '01' }">
					<h5 style="line-height: 26px;"class="col-sm-6">
					申请担保费率：<span class="grey">${empty project.guarantyRate ? "（空）":project.guarantyRate}</span>
					</h5>
				</c:when>
				<c:otherwise>
					<h5 style="line-height: 26px;"class="col-sm-6">
					申请委贷利率：<span class="grey">${empty project.bankRate ? "（空）":project.bankRate}</span>
					</h5>
				</c:otherwise>
			</c:choose>
			
			<h5 style="line-height: 26px;"class="col-sm-6">
				金融服务费率：<span class="grey">${empty project.serviceRate ? "（空）":project.serviceRate}</span>
			</h5>
		</div>
		
		<div class="col-sm-12">
			<h4 class="header smaller lighter blue">
				放款情况
			</h4>
			<h5 style="line-height: 26px;"class="col-sm-6">
				项目金额：<span class="grey">${empty project.loadSum ? "（空）":project.loadSum}万元</span>
			</h5>
			<h5 style="line-height: 26px;"class="col-sm-6">
				期限：<span class="grey">${empty project.periodMonthDay ? "（空）":project.periodMonthDay}</span>
			</h5>
			<c:choose>
				<c:when test="${project.busiClass eq '01'}">
					<h5 style="line-height: 26px;"class="col-sm-6">
						担保费率：<span class="grey">${empty project.guarantyRate ? "（空）":project.guarantyRate}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						贷款利率：<span class="grey">${empty project.bankRate ? "（空）":project.bankRate}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-12">
						评审费率：<span class="grey">${empty project.reviewRate ? "（空）":project.reviewRate}</span>
					</h5>
				</c:when>
				<c:otherwise>
					<h5 style="line-height: 26px;"class="col-sm-6">
						委贷利率：<span class="grey">${empty project.bankRate ? "（空）":project.bankRate}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						罚息利率：<span class="grey">${empty project.punishRate ? "（空）":project.punishRate}</span>
					</h5>
				</c:otherwise>
			</c:choose>
			<h5 style="line-height: 26px;"class="col-sm-12">
				金融服务费率：<span class="grey">${empty project.serviceRate ? "（空）":project.serviceRate}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">起始日期：<span class="grey">
				<c:choose>
					<c:when test="${empty project.loadBeginDate}">（空）</c:when>
					<c:otherwise><fmt:formatDate value="${project.loadBeginDate}" pattern="yyyy-MM-dd"/></c:otherwise>
				</c:choose>
			</span></h5>
			<h5 style="line-height: 26px;" class="col-sm-6">结束日期：<span class="grey">
				<c:choose>
					<c:when test="${empty project.loadEndDate}">（空）</c:when>
					<c:otherwise><fmt:formatDate value="${project.loadEndDate}" pattern="yyyy-MM-dd"/></c:otherwise>
				</c:choose>
			</span></h5>
		</div>
	</div>
	<%-- <c:if test="${empty meetingDetailList }">
		<div class="row">
			<div class="col-xs-12">
				暂无记录!
			</div>
		</div>
	</c:if> 
	<c:forEach items="${meetingDetailList}" var="meetingDetail" varStatus="loanStatus">
		<div class="row">
			<!-- 决议同意担保情况  begin -->
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">${loanStatus.index+1}、决议同意担保情况 </h4> 
						<div class="widget-toolbar action-buttons" style="height:37px;">
							<a href="#" data-action="collapse" style="margin-top:10px;">
								<i class="icon-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
							<div class="widget-main no-padding">
								<h5 style="line-height: 26px;" class="col-sm-6">业务品种：<span class="grey">
										${empty meetingDetail.busiTypeName || meetingDetail.busiTypeName eq "" ?"(空)":meetingDetail.busiTypeName}
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">放款机构：<span class="grey">
										${empty meetingDetail.bankName || meetingDetail.bankName eq "" ?"(空)":meetingDetail.bankName}
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意担保金额：<span class="grey">
										<c:choose>
											<c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.agreeSum}"/>万元</c:otherwise>
										</c:choose>
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意期限：<span class="grey">
										${empty meetingDetail.periodMonthDay || meetingDetail.periodMonthDay eq "" ? "(空)":meetingDetail.periodMonthDay}
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意评审费率：<span class="grey">
										
										<c:choose>
											<c:when test="${empty meetingDetail.reviewRate || meetingDetail.reviewRate eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.reviewRate}"  pattern="#0.00"/>‰</c:otherwise>
										</c:choose>
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意担保费率：<span class="grey">
										<c:choose>
											<c:when test="${empty meetingDetail.guarantyRate || meetingDetail.guarantyRate eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyRate}" pattern="#0.00"/>%</c:otherwise>
										</c:choose>
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-12">同意保证金比例：<span class="grey">
										<c:choose>
											<c:when test="${empty meetingDetail.bzScale || meetingDetail.bzScale eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.bzScale}"  pattern="#0.00"/>%</c:otherwise>
										</c:choose>
									</span></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 决议同意担保情况 end -->
			<!-- 实际放款情况  begin -->
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">实际放款情况</h4>
						<div class="widget-toolbar" style="height:37px">
							<a href="#" data-action="collapse" style="margin-top:11px;"><i class="icon-chevron-up"></i></a>
						</div>
						<c:if test="${urlParam.type eq 'edit' }">
							<a href="#" class="pull-right" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
							id="${meetingDetail.meetingDetail_ID}" onclick="$.zjm_singleLoanReview.confirmLoan(this.id)">
								<i class="icon-edit bigger-110 orange"></i>
								<span class="bigger-110 no-text-shadow orange">确认已放款</span>
							</a>
						</c:if>
					</div> 
					<c:forEach items="${ meetingDetail.projectList }" var="project" varStatus="proStatus">
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
							<div class="widget-main no-padding">
								<div class="widget-box">
									<div class="widget-header">
										<h5>放款单编号：<span class="grey">
											${empty project.loadCode || project.loadCode eq "" ?"":project.loadCode}
										</span></h5>
										<c:if test="${urlParam.type eq 'edit' }">
											<a href="#" class="pull-right"  style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
												id="${project.project_ID}" onclick="$.zjm_singleLoanReview.cancelLoanConfirm(this.id)">
												<i class="icon-reply-all bigger-110 orange"></i>
												<span class="bigger-110 no-text-shadow orange">撤销</span>
											</a>
										</c:if>
									</div>
									<div class="widget-body" style="border:1px solid #ccc;" id="ulPictureFile">
											<div class="widget-main">
												<div class="row">
													<h5 style="line-height: 26px;" class="col-sm-6">业务品种：<span class="grey">
														${empty project.busiTypeName || project.busiTypeName eq "" ?"(空)":project.busiTypeName}
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">放款机构：<span class="grey">
														${empty project.bankName || project.bankName eq "" ?"(空)":project.bankName}
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">放款金额：<span class="grey">
														<c:choose>
															<c:when test="${empty project.loadSum || project.loadSum eq 0}">（空）</c:when>
															<c:otherwise><fmt:formatNumber value="${project.loadSum}"/>万元</c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">
														${empty project.periodMonthDay || project.periodMonthDay eq "" ? "(空)":project.periodMonthDay}
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">担保起始日期：<span class="grey">
														<c:choose>
															<c:when test="${empty project.loadBeginDate}">（空）</c:when>
															<c:otherwise><fmt:formatDate value="${project.loadBeginDate}" pattern="yyyy-MM-dd"/></c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">担保到期日期：<span class="grey">
														<c:choose>
															<c:when test="${empty project.loadEndDate}">（空）</c:when>
															<c:otherwise><fmt:formatDate value="${project.loadEndDate}" pattern="yyyy-MM-dd"/></c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">借据起始日期：<span class="grey">
														<c:choose>
															<c:when test="${empty project.billBeginDate}">（空）</c:when>
															<c:otherwise><fmt:formatDate value="${project.billBeginDate}" pattern="yyyy-MM-dd"/></c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">借据到期日期：<span class="grey">
														<c:choose>
															<c:when test="${empty project.billEndDate}">（空）</c:when>
															<c:otherwise><fmt:formatDate value="${project.billEndDate}" pattern="yyyy-MM-dd"/></c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-12">放款凭证扫描件：<span class="grey">
														<c:forEach items="${project.projectfilesList }" var="projectfiles" varStatus="status11">
															
															<c:choose>
																	<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
																		<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
																		&nbsp;&nbsp;<a title="下载" onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)"><i class="icon-download-alt bigger-120 "></i></a> 
																		<c:if test="${urlParam.type eq 'edit' }">
																			&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_singleLoanReview.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
																		</c:if>							
																	</c:when>
																	<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
																	
																		<a href="#" class="btn_opfile_viewer_img" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}">${projectfiles.sourceFileName }</a>
																		 <img class="hide" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}" alt="${projectfiles.sourceFileName}" title="${projectfiles.sourceFileName}">
																		 &nbsp;&nbsp;
																		<a title="下载" onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">
																			<i class="icon-download-alt bigger-120 "></i>
																		</a> 
																		<c:if test="${urlParam.type eq 'edit' }">
																			&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_singleLoanReview.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
																		</c:if>
																	</c:when>
																	<c:otherwise>
																		<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
																		<c:if test="${urlParam.type eq 'edit' }">
																			&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_singleLoanReview.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
																		</c:if>
																	</c:otherwise>
																</c:choose>
															<br>
														</c:forEach>
													</span></h5>
												</div>
											</div>
										</div>
									</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<c:if test="${empty meetingDetail.projectList}">
						<div class="widget-body">
							<h5 style="line-height: 26px;" class="col-sm-12"><span class="grey">当前无记录!</span></h5>
							<!-- <div class="widget-body-inner" stryle="display: block;">
								<div class="widget-main no-padding">
									<div class="widget-box">
										<div class="widget-body" style="border:1px solid #ccc;">
											<div class="widget-main">
												<div class="row">
													<h5 style="line-height: 26px; color: gray;text-align: center;" >
														暂无数据！
													</h5>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div> -->
						</div>
					</c:if>
					
				</div>
			</div>
			<!-- 实际放款情况  end -->
			<!-- 实际收费情况  begin -->
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">收费情况</h4>
						<div class="widget-toolbar" style="height:37px">
							<a href="#" data-action="collapse" style="margin-top:11px;"><i class="icon-chevron-up"></i></a>
						</div>
						<c:if test="${urlParam.type eq 'edit' }">
							<a href="#" class="pull-right"  style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
								id="${meetingDetail.meetingDetail_ID}" onclick="$.zjm_singleLoanReview.confirmFee(this.id)">
								<i class="icon-edit bigger-110 orange"></i>
								<span class="bigger-110 no-text-shadow orange">确认收费</span>
							</a>
						</c:if>
					</div> 
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
							<div class="widget-main no-padding">
								<div class="widget-box">
									<!-- <div class="widget-header">
										<a href="#" class="pull-right"  style="margin-right:10px;line-height:37px;display:block;text-decoration:none;cursor: default;">
											单位：元			
										</a>
									</div> -->
									<div class="widget-body" style="border:1px solid #ccc;">
										<div class="widget-main">
												<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
													<thead>
														<tr>
															<th>费用类型</th>
															<!-- <th>费率</th> -->
															<th>对应放款</th>
															<th>应收（元）</th>
															<th>预收（元）</th>
															<th>退费（元）</th>
															<th>实收（元）</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${ meetingDetail.costList }" var="cost">
															<tr>
																<td>${cost.costTypeName }</td>
																<td>${cost.loanAgreeSum }</td>
																<td><fmt:formatNumber value="${cost.mustCostSum }"/></td>
																<td><fmt:formatNumber value="${cost.preCostSum }"/></td>
																<td><fmt:formatNumber value="${cost.returnCostSum }"/></td>
																<td><fmt:formatNumber value="${cost.factCostSum }"/></td>
															</tr>
														</c:forEach>
														
														
														<c:if test="${empty meetingDetail.costList }">
															<tr>
																<td colspan="6">暂无记录！</td>
															</tr>
														</c:if>
													</tbody>
												</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			<!-- 实际收费情况  end -->
				
		</div>
		<div class="space-16"></div>
	</c:forEach> --%>
</div>
<div id="singleLoanReview_page"></div>
<%@ include file="/common_message.jsp" %>
<script src="<%=path %>/project/loan/singleLoanReview/singleLoanReview.js?v=<%=vardate%>"></script>
<%@ include file="/project/opt/imgUpload/delPicture.jsp" %>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/plugins/viewer/viewer.min.js"></script>
<script>     
	 $(function() {
		$(".btn_opfile_viewer_img").click(function() {
		 	var viewer = new Viewer(document.getElementById("ulPictureFile"), { 
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				viewer.destroy();
			});
		});
	}); 
</script>
