<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="newFileDataModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增档案资料</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="newFileDataModal_form">
      		 <input type="hidden" name="apply_ID"  value="${apply_ID }"/>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"><i class="icon-asterisk orange"></i>档案类别：</label>
				<div class="col-sm-8">
					<input type="hidden" id="arcTypeName" name="arcTypeName" class="arcTypeName"> 
					<select class="col-xs-8 validate[required] arcTypeID" id="arcTypeID" name="arcTypeID">
						<c:forEach var="dicType" items="${dicTypeList}" varStatus="status">
							<option value="${dicType.dicTypeID}">${dicType.dicTypeName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
				
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>文件标题： </label>
				<div class="col-sm-8">
						<input type="text" class="col-sm-8 validate[required]" name="fileTitle" id="fileTitle"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">页数： </label>
				<div class="col-sm-8">
						<input type="number" class="col-sm-2" name="pageCount" id="pageCount"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">是否原件： </label>
				<div class="col-sm-8">
						<input type="radio" checked="checked" class="" name="isOldArc" id="isOldArc" value="1"/>是
						&nbsp;
						<input type="radio" class="" name="isOldArc" id="isOldArc" value="0"/>否
				</div>
			</div>
					

				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">备注： </label>
					<div class="col-sm-8">
						<textarea class="col-xs-8 validate[maxSize[100]]" name="remark"
								rows="5"></textarea>
						<div class="col-xs-8 no-padding-right">
							<span class="light-grey" style="float: right">限制200个字符</span>
						</div>
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
	$('.arcTypeName').attr("value",$('.arcTypeID option:selected').text());
	$(".arcTypeID").on("change", function () {
		$('.arcTypeName').attr("value",$('.arcTypeID option:selected').text());
    })
</script>					






