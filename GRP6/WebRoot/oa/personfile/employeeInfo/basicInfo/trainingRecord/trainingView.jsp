<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="trainingView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看培训记录</h4>
      </div>
      <div class="modal-body">
				
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									年度：<span class="grey">&nbsp;${training.trainingYear ==""? "（空）":training.trainingYear}</span>年
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									培训名称：<span class="grey">&nbsp;${training.trainingName ==""? "（空）":training.trainingName}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									期间：<span class="grey">&nbsp;${training.trainingPeriod ==""? "（空）":training.trainingPeriod}</span>
								</h5>
							</div>
						</div>
										
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									费用：<span class="grey">${training.trainingFees ==""? "（空）":training.trainingFees}元</span>
								</h5>
							</div>
						</div>
								<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">&nbsp;${training.trainingNotes ==""? "（空）":training.trainingNotes}</span>
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
