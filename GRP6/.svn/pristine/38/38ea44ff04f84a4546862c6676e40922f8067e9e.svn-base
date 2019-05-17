<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="jobStatusViewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看职务情况</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">						
								<h5 class="col-sm-12" style="line-height: 26px;">
									职务名称：<span class="grey">
										<c:choose><c:when test="${empty hrstaffDuty.dutyName}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.dutyName}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									所属部门：<span class="grey">
											<c:choose><c:when test="${empty hrstaffDuty.dutyDepGIDName}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.dutyDepGIDName}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									直接上级：<span class="grey">
											<c:choose><c:when test="${empty hrstaffDuty.dutySuperior}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.dutySuperior}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									职务等级：<span class="grey">
											<c:choose><c:when test="${empty hrstaffDuty.superiorLV}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.superiorLV}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									晋升方向：<span class="grey">
											<c:choose><c:when test="${empty hrstaffDuty.dutyDirection}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.dutyDirection}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									薪资标准：<span class="grey">
											<c:choose><c:when test="${empty hrstaffDuty.dutySalary}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.dutySalary}</c:otherwise>
							</c:choose>
							</span>元
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">
											<c:choose><c:when test="${empty hrstaffDuty.dutyNotes}">（空）</c:when>
								<c:otherwise>${hrstaffDuty.dutyNotes}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							</div>
						</div>
									
					</div>
				</div>
      
      
      
      
      
      </div>
      <div class="modal-footer">
       
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
