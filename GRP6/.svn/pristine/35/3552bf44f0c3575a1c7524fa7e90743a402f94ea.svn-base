<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="rewardsPunishmentViewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看奖惩记录</h4>
      </div>
      <div class="modal-body">      
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									类型：<span class="grey">
							<c:choose><c:when test="${empty rewardPunishment.rewardsType}">（空）</c:when>
								<c:otherwise>${rewardPunishment.rewardsType}</c:otherwise>
							</c:choose>									
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									结果：<span class="grey">
									<c:choose><c:when test="${empty rewardPunishment.rewardsResults}">（空）</c:when>
								<c:otherwise>${rewardPunishment.rewardsResults}</c:otherwise>
							</c:choose>	
								</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									事由：<span class="grey">
										<c:choose><c:when test="${empty rewardPunishment.rewardsReason}">（空）</c:when>
								<c:otherwise>${rewardPunishment.rewardsReason}</c:otherwise>
							</c:choose>	
								</span>
								</h5>
							</div>
						</div>										
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">
												<c:choose><c:when test="${empty rewardPunishment.rewardsNotes}">（空）</c:when>
								<c:otherwise>${rewardPunishment.rewardsNotes}</c:otherwise>
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
