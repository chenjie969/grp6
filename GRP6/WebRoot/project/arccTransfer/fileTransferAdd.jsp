<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addFileTransfer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">档案移交</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="addFileTransfer_form">
			<input type="hidden" name="arcDirectory_ID" value="${arcDirectory_ID }">		
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>接收人： </label>
				<div class="col-sm-8">
					<div class="input-group select_user_tree_roles col-sm-8"> 
						<input class="form-control validate[required]" autoField=receiveUserID name="receiveUserName" 
							id="select_user_tree_roles" type="text" value="${proCheckReport.checkUserName}" dataValue="${proCheckReport.checkUserID}" />
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110  "></i>
						</span>
							
					</div>
						<!-- <input type="text" class="col-sm-8 validate[required]" name="contractName" id="contractName"/> -->
				</div>
			</div>

		</form>
      </div>
      
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>

    </div>
  </div>
</div>
					

<script type="text/javascript">
	
	$.ajax({type:'POST',
		url:'/sys/dic/selectDepartsUserTree',
		data:JSON.stringify({}),
		contentType:'application/json,charset=UTF-8',
		dataType:'json',
		success:function(data) {
			debugger
			$("#select_user_tree_roles").selectTreeWidgets({
				width : "54%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
		}
	});
</script>					






