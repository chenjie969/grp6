<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="viewRelationMain" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看关联主体</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   <div class="col-sm-12">
				<h5 class="col-sm-5" align="right">主体名称：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_relationMainName"></h5>
				<h5 class="col-sm-5" align="right">关系类型：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_relationType"></h5>
				<h5 class="col-sm-5" align="right">主体客户：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_clientName"></h5>
				<h5 class="col-sm-5" align="right">关联企业：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_relationCompany"></h5>
				<h5 class="col-sm-5" align="right">项目类型名称：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_projectType"></h5>
				<!-- <h5 class="col-sm-5" align="right">机构名称：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_unit_uidName"></h5> -->
				<h5 class="col-sm-5" align="right">备注：</h5>
				<h5 class="grey col-sm-7 " align="left" id="view_remark" style="line-height:26px;"></h5>
				<!-- <h5 class="col-sm-5" align="right">保外债权人融资金额(亿元)：</h5>
				<h5 class="grey col-sm-7 " align="left" id="view_creditorSum" style="line-height:26px;"></h5> -->
				<!-- <h5 class="col-sm-4" align="right"><b>2015 年1月末：</b></h5>
				<h5 class="col-sm-8" align="right" style="height:23px;"></h5>
				<h5 class="col-sm-5" align="right">担保余额(亿元)：</h5>
				<h5 class="grey col-sm-7 " align="left" id="view_guarantySum"></h5>
				<h5 class="col-sm-5" align="right">担保集团委贷余额(亿元)：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_guarantyEntrustSum"></h5>
				<h5 class="col-sm-5" align="right">融投系委贷余额(亿元)：</h5>
				<h5 class="grey col-sm-7" align="left" id="view_entrustSum"></h5>
				 -->
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
