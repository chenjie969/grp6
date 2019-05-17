<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="add_shareClientModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">授权共享人</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_ShareClientForm">
			<input type="hidden" name="client_ID" id="clientID" value="">
			<input type="hidden" name="clientShare_ID" id="clientShare_ID" value="${clientShare.clientShare_ID}">
			<input type="hidden" name="userIDs" id="userIDs" value="${clientShare.userIDs}">
			<input type="hidden" name="userNames" id="userNames" value="${clientShare.userNames}">
			<div class="form-group " >
				<div class="col-sm-6">
					<div class="widget-box" style="max-height:500px;OVERFLOW: auto; ">
						<div class="widget-header">
                            <h4>选择人员</h4>
                        </div>
                        <div class="widget-body" style="min-height:200px;">
                            <div class="widget-main padding-8">
                                <ul id="userSetTree" class="ztree"></ul>
                            </div>
                        </div>
                    </div>
				</div>
				<div class="col-sm-6">
					<div class="widget-box" style="max-height:500px;OVERFLOW: auto; "
					>
						<div class="widget-header">
                            <h4>已选人员</h4>
                        </div>
                        <div class="widget-body">
                            <div class="widget-main padding-8" style="min-height:200px;">
                            	<div id="userName"></div>
                            </div>
                        </div>
                    </div>
            	</div>
			</div>
			
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					