<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addProjectBillInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">登记票据信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_addProjectBillInfo">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 票据类型： </label>
				<div class="col-sm-9">
					<select class="col-xs-10 col-sm-6 validate[required]">
						<option value="">请选择</option>
						<c:forEach items="${billTypeList }" var="billType">
							<option value="${billType.dicTypeID }">${billType.dicTypeName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 票据编号： </label>
				<div class="col-sm-9">
					<input type="text"  class="col-xs-10 col-sm-6 validate[required,maxSize[50]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 票据金额： </label>
				<div class="col-sm-9">
					<input type="text"  class="col-xs-9 col-sm-5 validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-3" style="line-height:28px;">万元	</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 开具人： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class=" col-sm-7 ">
							<div class="input-group createUser">
								<input  type="text"  class="form-control validate[required] " autoField="amanID"   id="createUser"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="amanName"  readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 开具日期： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-7">
							<div class="input-group">
								<input  type="text" class="form-control date-picker validate[required,custom[date]]" name="createDateTime"  id="createDate" data-date-format="yyyy-mm-dd" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 备注： </label>
				<div class="col-sm-8">
					<textarea class="col-sm-12 validate[maxSize[200]]" rows="5" name="remark" ></textarea>
				</div>
				<div class="col-sm-11 ">
				    <span class="light-grey" style="float:right;">限制250个字符</span>
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
					