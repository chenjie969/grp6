<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="editAnnounce" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改信息</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal" role="form" id="edit_annouce_form">
      	 	<input type="hidden" name="approvalStatus" value="${message.approvalStatus}"/>
			<input type="hidden" name="createUserId" value="${message.createUserId}"/>
			<input type="hidden" name="createUserName" value="${message.createUserName}"/>
			<input type="hidden" name="createDateTime" value="${message.createDateTime}"/>
	        <input type="hidden" name="messageId" value="${message.messageId }">
        	<input type="hidden" name="messageTypePID" id="hidden_messageTypePID" value="${message.messageTypePID }">	
      	 	<input type="hidden" name="messageTypePName" id="hidden_messageTypePName" value="${message.messageTypePName }">	
	    	
	    	<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>信息标题： </label>
				<div class="col-sm-10">
					<div class="row">
					    <div class="col-sm-12">
							<input type="text" name="title" class=" col-sm-10  validate[required,maxSize[50]]" id="title" value ="${message.title}"/>
						</div>
			        </div>
				</div>
			</div>
			
      	 	<div class="form-group col-sm-6">
      	 		<!-- 信息分类名称 -->
      	 		<label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>信息类型：</label>
				<div class="col-sm-8">
					<div class="col-sm-12 input-group select_messageType">
						<input  type="text"  class="form-control validate[required]" dataValue="${message.messageTypeId}" value="${message.messageTypeName}" autoField="messageTypeId" id="select_messageType"  name="messageTypeName" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>	
			
			<div class="form-group col-sm-6" >
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>发布范围： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group messageTypeId select_publicScope">
								<input  type="text"  class="form-control validate[required]" value="${message.receiveUserNameList}" autoField="receiveUserIdList" dataValue="${message.receiveUserIdList}" id="select_publicScope"  name="receiveUserNameList" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">内容模板：</label>
				<div class="col-sm-6">
					<select class="col-sm-8 select_templet  btn_ztb_select "  name="templetId" class_name="ztb_add_templetType" id="select_templet">
						<option value="">请选择</option>
						<c:forEach items="${templetList }" var="templet">
							<option value="${templet.dicTypeID }" <c:if test="${templet.dicTypeID == message.templetId}">selected</c:if>>${templet.dicTypeName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">信息内容：</label>
				<div class="col-sm-10">
					<div class="row">
						<div class="col-sm-12">
				 			<input type="hidden" id="content" name="" class="ztb_add_content">
							<div id="ueditor" >
							    <textarea id="editor" name="content" type="text/plain" style="width:97%;height:300px;">${message.content}</textarea>
							</div >
						</div>
					</div>
				</div>
			</div>
			
		 	<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>文件上传： </label>
				<button type="button" class="btn btn-sm btn-primary" id="btn_uploadfiles"> <i class='icon-search bigger-110'></i>选择文件</button>
			</div>
			<div id="div_fileList"  class="form-group">
				<div class="col-sm-12">
					<table id="fileList" style="font-size:13px !important;"></table>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" id="btn_save" > <i class='icon-cloud-download bigger-110'></i>暂存</button>
      	<button type="button" class="btn btn-primary btn_submit_audit" > <i class='icon-ok bigger-110'></i>提交审核</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="/oa/info/uploadFiles/filesUpModal.jsp" %>
<%@ include file="/oa/info/uploadFiles/filesDel.jsp" %>
<script type="text/javascript">

    //实例化编辑器
     //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    
    
 </script>
