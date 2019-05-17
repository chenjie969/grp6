<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="viewCostInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看水电气费缴纳情况</h4>
      </div>
      <div class="modal-body">
			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">年月： <span class="grey" >${costInfo.intYear }年${costInfo.intMonth }月</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">电费：<span class="grey" >${costInfo.electricCost }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">水费：<span class="grey" >${costInfo.waterCost }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">其他费用：<span class="grey" >${costInfo.otherCost }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">小计：<span class="grey" >${costInfo.costSum }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey" >${empty costInfo.remark ? "（空）": costInfo.remark}</span></h5>
						</div>
					</div>
				</div>
			</div>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					