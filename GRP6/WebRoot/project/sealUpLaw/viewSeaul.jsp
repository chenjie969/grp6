<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="viewSeaulModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看资产查封</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">						
								<h5 class="col-sm-12" style="line-height: 26px;">	
								案件序号：
								<span class="grey">
										<c:choose><c:when test="${empty SeaulUp.serialNum}">（空）</c:when>
								<c:otherwise>${SeaulUp.serialNum}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
								申请人：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.applyPerson}">（空）</c:when>
								<c:otherwise>${SeaulUp.applyPerson}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
			
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									执行标的：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.targetSum}">（空）</c:when>
								<c:otherwise>${SeaulUp.targetSum}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
								资产保全方式：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.propertyType}">（空）</c:when>
								<c:otherwise>${SeaulUp.propertyType}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									是否立案：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.isRecordName}">（空）</c:when>
								<c:otherwise>${SeaulUp.isRecordName}</c:otherwise>
							</c:choose>
							</span>
							
							
								</h5>
							</div>
						</div>
					
						
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									案号：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.recordNum}">（空）</c:when>
								<c:otherwise>${SeaulUp.recordNum}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							</div>
						</div>
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									受理法院：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.lawCourt}">（空）</c:when>
								<c:otherwise>${SeaulUp.lawCourt}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							</div>
						</div>
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									执行依据：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.executeBasis}">（空）</c:when>
								<c:otherwise>${SeaulUp.executeBasis}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							</div>
						</div>	
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
								负责法院或其他备注信息：<span class="grey">
											<c:choose><c:when test="${empty SeaulUp.remark}">（空）</c:when>
								<c:otherwise>${SeaulUp.remark}</c:otherwise>
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
