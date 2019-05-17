<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="signAnnounceView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">签收</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="col-sm-offset-1 col-sm-10">
				<!-- <div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">客户类型：<span class="grey">企业客户</span></h5>
					</div>
				</div> -->
				<div class="col-sm-12">
					<div class="row" style=" text-align: center;">
						<h5 class="col-sm-12"><span class="grey" style="line-height:26px;">${message.title}</span></h5>
					</div>
				</div>
				<div class="col-sm-12 col-xs-12">
					<div class="row">
						<h5 class="col-sm-12"><span class="grey" style="line-height:26px; ">${message.content}</span></h5>
					</div>
				</div>
				<div class="col-sm-12">
					<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>信息</label>
					<div class="row col-sm-10">
						 ${message.createUserName}  发布于 <fmt:formatDate value="${message.createDateTime}" pattern="yyyy-MM-dd"/>
						 |审核人:  
						 <c:if test="${message.createUserName eq null}">（空）</c:if>
						 <c:if test="${message.createUserName ne null}">
							${message.createUserName} 
						 </c:if> 
						 | 修改于 <fmt:formatDate value="${message.updateDateTime}" pattern="yyyy-MM-dd"/>
						 |分类: ${message.messageTypeName}
					</div>
				</div>
				
				
				<div class="col-sm-12">
					<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>范围</label>
					<div class="row col-sm-10">
						 <c:if test="${message.receiveUserNameList eq null}">（空）</c:if>
						 <c:if test="${message.receiveUserNameList ne null}">
							${message.receiveUserNameList}
						</c:if>
					</div>
				</div>
				
				<div class="col-sm-12" id="div_fileList">
					<label class="col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>附件列表</label>
					<div class="col-sm-12">
						<table id="fileList" style="font-size:13px !important;" class="col-sm-12"></table>
					</div>
				</div>
				
				<%-- <div class="col-sm-12">
					<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>抄送</label>
					<div class="row col-sm-10">
						<c:if test="${message.duplicateUserNameList eq null}">（空）</c:if>
						 <c:if test="${message.duplicateUserNameList ne null}">
							${message.duplicateUserNameList}
						 </c:if> 
					</div>
				</div> --%>
				<%-- <div class="col-sm-12">
					<div class="row col-sm-12">
					<br/>	<br/>
						<div class="tabbable">
							<ul class="nav nav-tabs" id="detailTab">
								<li class="active">
									<a data-toggle="tab" href="#viewDetail" id="draftTab">
										查阅情况
									</a>
								</li>
								<li>
									<a data-toggle="tab" href="#signDetail" id="signTab">
										签收人员
									</a>
								</li>
								<li>
									<a data-toggle="tab" href="#noSignDetail" id="noSignTab">
										未签收人员
									</a>
								</li>
							</ul>
							<div class="tab-content" style="height:120px;">
								<div id="viewDetail" class="tab-pane in active">
									<div class="col-sm-12">
										<label class="row col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>共<font  style="font-weight:bold;color:red;">${megUser.readCount}</font>人已查阅</label>
										<label class="row col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>已查阅人员</label>
										<div class="row col-sm-12">
											${message.readUserNameList}
										</div>
									</div>
								</div>
								<div id="signDetail" class="tab-pane">
									<div class="col-sm-12">
										<label class="row col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>共<font style="font-weight:bold;color:red;">${megUser.signedCount}</font>人已签收</label>
										<label class="row col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>未签收人员</label>
										<div class="row col-sm-12">
											${message.signedUserNameList}
										</div>
									</div>
								</div>
								<div id="noSignDetail" class="tab-pane">
									<div class="col-sm-12">
										<label class="row col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>共<font style="font-weight:bold;color:red;">${megUser.noSignCount}</font>人未签收</label>
										<label class="row col-sm-12 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>未签收人员</label>
										<div class="row col-sm-12">
											${message.noSignUserNameList}
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div> --%>
				
			</div>
			
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>签收</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					