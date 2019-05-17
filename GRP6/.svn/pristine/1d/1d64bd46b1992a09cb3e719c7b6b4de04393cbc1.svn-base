<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<div class="modal fade bs-example-modal-sm" id="stopProjectInfo_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">否决详情</h4>
      </div>
      <div class="modal-body">
         <form class="form-horizontal" role="form">
			 <input type="hidden" name="apply_ID" class="apply_ID" value="${apply.apply_ID}">
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">项目名称： </label>
                <label class="col-sm-9 grey">
                   	  ${apply.projectName}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">项目编号：</label>
                <label class="col-sm-9 grey">
                   	  ${apply.busiCode}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">否决日期：</label>
                <label class="col-sm-9 grey">
                   	   <fmt:formatDate value="${apply.stopDate}" pattern="yyyy-MM-dd"/> 
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">否决类型：</label>
                <label class="col-sm-9 grey">
                   	  ${apply.stopTypeName}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">否决原因：</label>
                <label class="col-sm-9 grey">
                   	  ${apply.stopDesc}
                </label>
			</div>
		</form>	
      </div>
      <div class="modal-footer">                   
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
