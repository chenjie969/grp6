<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
</script>
<div class="modal fade bs-example-modal-sm" id="viewBusiSort" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看业务品种</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   <div class="col-sm-offset-1">
			<h5 class="col-sm-12">业务品种名称：<span class="grey ztb_view_busisortname"></span></h5>
			<h5 class="col-sm-12">所属业务大类：<span class="grey ztb_view_busiClass"></span></h5>
			<h5 class="col-sm-12">对应监管机构业务品种编号：<span class="grey ztb_view_unificationid"></span></h5>
			<h5 class="col-sm-12">是否缺省：<span class="grey ztb_view_isDefault" id="isDefault"></span></h5>
			<h5 class="col-sm-12">状态：<span class="grey ztb_view_iseable" id="iseable"></span></h5>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
