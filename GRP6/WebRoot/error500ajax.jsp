<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="page-content">
</div>
<div class="modal fade" id="module500" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">系统提示</h4>
      </div>
      <div class="modal-body">
          <div class="col-sm-12">
              <img class="col-sm-3 col-sm-push-5" src="../assets/images/error3.png">
          </div>
          <h3 class="text-primary" style="text-align:center;">未找到页面!</h3>
          <h5 style="text-align:center;">您访问的页面出现错误，请联系管理员</h5>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
			<i class="icon-remove bigger-110"></i>关闭
        </button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
$(function () {
	$("#module500").modal({keyboard:true});
});
</script>