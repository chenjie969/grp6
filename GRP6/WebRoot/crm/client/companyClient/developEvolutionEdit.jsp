<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="developEvolutionEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改企业发展沿革</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="developEvolutionEdit_form">
				<input type="hidden" name="managerinfoId">
				<input type="hidden" name="client_ID">
				<!-- 在 Crm_managerInfoMapper.xml中对更新时做了 !=null 判断，所以可以不设置隐藏域保存数据
				<input type="hidden" name="productdesc">
				<input type="hidden" name="stockstructure">
				<input type="hidden" name="legalpersoninfo">
				<input type="hidden" name="controlpersoninfo">
				<input type="hidden" name="otherstockinfo">
				<input type="hidden" name="managerinfo">
				<input type="hidden" name="employeeinfo">
				<input type="hidden" name="unitUid">
				<input type="hidden" name="updateusername">
				<input type="hidden" name="updatedatetime"> -->
				<div class="form-group">
					<div class="col-sm-1 col-xs-1"></div><!-- 占位用 -->
					<textarea rows="20" class="col-sm-10 col-xs-10 validate[maxSize[2000]]" name="developevolution" id="developevolution_text"></textarea>
					<div class="col-sm-1 col-xs-1"></div><!-- 占位用 -->
					<div class="col-sm-11 col-xs-11 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				