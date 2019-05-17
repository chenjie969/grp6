<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="socialRelationViewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看社会关系</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
      	
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									姓名：<span class="grey">
									<c:choose><c:when test="${empty hrstaffRelation.socialName}">（空）</c:when>
								<c:otherwise>${hrstaffRelation.socialName}</c:otherwise>
							</c:choose>										
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									性别：<span class="grey">${hrstaffRelation.socialSex}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									与之关系：<span class="grey">${hrstaffRelation.socialType}</span>
								</h5>
							</div>
						</div>
										
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									所在城市：<span class="grey">
										<c:choose><c:when test="${empty hrstaffRelation.socialAddress}">（空）</c:when>
								<c:otherwise>${hrstaffRelation.socialAddress}</c:otherwise>
							</c:choose>	
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									工作单位：<span class="grey">
											<c:choose><c:when test="${empty hrstaffRelation.socialUnits}">（空）</c:when>
								<c:otherwise>${hrstaffRelation.socialUnits}</c:otherwise>
							</c:choose>	
									
								</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									职务：<span class="grey">
													<c:choose><c:when test="${empty hrstaffRelation.socialDuty}">（空）</c:when>
								<c:otherwise>${hrstaffRelation.socialDuty}</c:otherwise>
							</c:choose>	
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">
															<c:choose><c:when test="${empty hrstaffRelation.socialNotes}">（空）</c:when>
								<c:otherwise>${hrstaffRelation.socialNotes}</c:otherwise>
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
