<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="setVoteJuryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">设置表决评委</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
				
					<input type="hidden" id="juryIDList_temp"> 
					<input type="hidden" id="juryNameList_temp">
					
					<div class="widget-box col-sm-5" style="height: 240px;">
						<div class="widget-header">
							<h4>选择人员</h4>
						</div>
						<div class="widget-body" style="height: 200px; OVERFLOW: auto;">
							<div class="widget-main padding-8">
								<ul id="voteJurySetTree" class="ztree"></ul>
							</div>
						</div>
					</div>
					<div class="widget-box col-sm-offset-1 col-sm-4" style="height: 240px;">
						<div class="widget-header">
							<h4>已选人员</h4>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-8" style="height: 200px; OVERFLOW: auto;">
								<div id="voteJuryName"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btn_okSetVoteJury" > <i class='icon-ok bigger-110'></i>确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
      </div>
    </div>
  </div>
</div>

