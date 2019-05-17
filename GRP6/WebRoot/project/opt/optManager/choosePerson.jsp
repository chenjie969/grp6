<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade" id="choosePersonAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新增</h4>
			</div>
			<div class="modal-body">

				<form class="form-horizontal" role="form" id="optGuarantyAdd_form">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称：
						</label>
						<div class="col-sm-9">
							<input type="text" id="form-field-1" placeholder="请选择客户名称" class="col-sm-6 validate[required,maxSize[50]]" /> 
							<div class="col-sm-6">
								<button class="btn btn-xs btn-info" type="button" id="btn_chooseProj" name="button">选择</button>
							</div>

						</div>
					</div>

					<div class="space-4"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>保证方式：
						</label>
						<div class="col-sm-4">
							<select class="col-xs-10 col-sm-11 validate[required,maxSize[50]]" id="form-field-select-1">
								<option value="">请选择</option>
								<c:forEach var="bz"  items="${baozhengList}">
									<option value="${bz.dicTypeID }">${bz.dicTypeName }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="space-4"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>反担保类型：</label>
						<div class="col-sm-4">
							<select class="col-xs-10 col-sm-11  validate[required,maxSize[50]]" id="form-field-select-1">
								<option value="">请选择</option>
								<c:forEach var="opt"  items="${optTypeList }">
									<option value="${opt.dicTypeID }">${opt.dicTypeName }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="space-4"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>权属人类型：</label>
						<div class="radio">
							<label style="margin-top: -10px;"> 
								<input type="radio" name="form-field-radio" class="ace validate[required,maxSize[50]]" value="法人" checked="checked">
								 <span class="lbl">法人</span>
							</label> 
							<label style="margin-top: -10px;"> <input type="radio" name="form-field-radio" class="ace" value="自然人">
								 <span class="lbl">自然人</span>
							</label>
						</div>
					</div>

					<div class="space-4"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> <i class="icon-asterisk orange"></i>权属人：
						</label>
						<div class="col-sm-9">
							<input type="text" id="form-field-1" placeholder="请选择客户名称" class="col-sm-6 validate[required,maxSize[50]]" />
							<div class="col-sm-6">
								<button class="btn btn-xs btn-info" type="button" id="btn_choosePerson" name="button">选择</button>
								<button class="btn btn-xs btn-info" type="button" id="btn_addPerson" name="button">新增</button>
							</div>

						</div>
					</div>
				<form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" type="button" data-toggle="modal" data-target="#next" id="btn_addOptGuarantyNext">
					<i class="icon-arrow-right bigger-110"></i> 下一步
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class="icon-remove bigger-110"></i> 关闭
				</button>
			</div>
		</div>
	</div>
</div>
<div id="optGuarantyAdd_page"></div>
