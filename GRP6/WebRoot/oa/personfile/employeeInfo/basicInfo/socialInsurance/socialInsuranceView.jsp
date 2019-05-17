<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade bs-example-modal-sm" id="socialInsuranceView" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看社保缴纳情况</h4>
			</div>
			<div class="modal-body">
				
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									缴纳年月：<span class="grey">${socialInsurance.socialInsuranceDate == ""? "（空）":socialInsurance.socialInsuranceDate}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									养老：<span class="grey">${socialInsurance.socialInsurancePension == ""? "（空）":socialInsurance.socialInsurancePension}元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									工伤：<span class="grey">${socialInsurance.socialInsuranceInjury ==""? "（空）":socialInsurance.socialInsuranceInjury}元</span>
								</h5>
							</div>
						</div>
										
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									医疗：<span class="grey">${socialInsurance.socialInsuranceMedical ==""? "（空）":socialInsurance.socialInsuranceMedical}元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									生育：<span class="grey">${socialInsurance.socialInsuranceFertility ==""? "（空）":socialInsurance.socialInsuranceFertility}元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									失业：<span class="grey">${socialInsurance.socialInsuranceUnemploy ==""? "（空）":socialInsurance.socialInsuranceUnemploy}元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									小计：<span class="grey">${socialInsurance.socialInsuranceCum ==""? "（空）":socialInsurance.socialInsuranceCum}元</span>
								</h5>
							</div>
						</div>
								<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">&nbsp;${socialInsurance.socialInsuranceNotes ==""? "（空）":socialInsurance.socialInsuranceNotes}</span>
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
