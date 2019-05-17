<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="costStandardView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看收费标准</h4>
			</div>
			<div class="modal-body">
      
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									费用名称：<span class="grey">&nbsp;${costStandard.costName}
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									费用类型名称：<span class="grey">&nbsp;${costStandard.costTypeName}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									费率：<span class="grey">&nbsp;${costStandard.costRate}</span>
								</h5>
							</div>
						</div>
						
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									费率单位：<span class="grey">&nbsp;${costStandard.costUnit}</span>
								</h5>
							</div>
						</div>
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									计算规则：<span class="grey">&nbsp;${costStandard.culate}</span>
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
