<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade bs-example-modal-sm" id="medicalView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看体检记录</h4>
			</div>
			<div class="modal-body">
      
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									体检日期：<span class="grey">&nbsp;
									<fmt:formatDate value='${medical.medicalDate ==""? "（空）":medical.medicalDate}' pattern='yyyy-MM-dd'/>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									体检费用：<span class="grey">&nbsp;${medical.medicalFees}元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									体检情况：<span class="grey">&nbsp;${medical.medicalInfo =="" ? "（空）":medical.medicalInfo}</span>
								</h5>
							</div>
						</div>
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									体检医疗机构：<span class="grey">&nbsp;${medical.medicalAgencies ==""? "（空）":medical.medicalAgencies}</span>
								</h5>
							</div>
						</div>					
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">&nbsp;${medical.medicalNotes ==""? "（空）":medical.medicalNotes}</span>
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
