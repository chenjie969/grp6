<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
/**
 *获取下拉框值;
 */
function getSelectText2 (v){
    var  selectID = v.id;
    var selectName = selectID.replace(/List/, "Name");
　    document.getElementById(selectName).value=v.options[v.options.selectedIndex].text;
};
</script>
<div class="modal fade bs-example-modal-sm" id="arcMoveDetailAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog " role="document">
    <div class="modal-content">
    <!-- 新增档案页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增档案</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="arcMoveDetailAdd_form" >
			    <input type="hidden" id="apply_ID" name="apply_ID" value="${pro_arcMove.apply_ID}">
			    <input type="hidden" id="arcMoveRec_ID" name="arcMoveRec_ID" value="${pro_arcMove.arcMoveRec_ID}">
           	<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>档案类别： </label>
				<div class="col-sm-8">
				      <input type="hidden" id="arcTypeName" class="" name="arcTypeName">
					  <select id="arcTypeList" class="selectList col-sm-6 col-md-6 validate[required]" onchange='getSelectText2(this)' name="arcTypeID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${arcTypeList}" var="arcType">
									<option value="${arcType.dicTypeID}">${arcType.dicTypeName}</option>
								</c:forEach>
					  </select>
				</div>
			</div>
           	<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>文件标题（内容）： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8 validate[required,maxSize[200],]"   name="fileTitleName" id="fileTitleName" value="" />
				</div>
			</div>
           	<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>页数： </label>
				<div class="col-sm-8">
					<input  type="text" style="width:4em;" class="validate[required,maxSize[5],custom[number]]"   name="pageCount" id="pageCount" value="" />
				</div>
			</div>
           	<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>页码： </label>
				<div class="col-sm-8">
					<div class="col-md-12 no-padding-left">
						<input  type="text" style="width:4em;" class="validate[required,maxSize[5],custom[number]]"   name="pageNumber" id="pageNumber" value="" />
						 &nbsp;至&nbsp;
						<input  type="text" style="width:4em;" class="validate[required,maxSize[5],custom[number]]"   name="pageNumberEnd" id="pageNumberEnd" value="" />
					 </div>
				</div>
			</div>
           	<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">是否原件： </label>
				<div class="col-sm-8">
					<div class="radio">
						<label >
							<input type="radio" name="isOriginal" class="ace form-field-radio" checked="checked"    value="1"/>
							<span class="lbl">是</span>
						</label>
						<label>
							<input  type="radio" name="isOriginal" class="ace form-field-radio"  value="0" />
							<span class="lbl">否</span>
						</label>
					</div>
					
				</div>
			</div>
           	<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">是否全部移交： </label>
				<div class="col-sm-8">
				<div class="radio">
						<label >
							<input type="radio" name="isAll" class="ace form-field-radio" checked="checked"  value="1"/>
							<span class="lbl">是</span>
						</label>
						<label>
							<input  type="radio" name="isAll" class="ace form-field-radio"  value="0" />
							<span class="lbl">否</span>
						</label>
					   </div>
				</div>
			</div>
	     
					
			<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right" for="form-input"> 备注：</label>									   	    
		         	<div class="col-sm-8">
						<textarea class="col-sm-9 limited   validate[maxSize[2000]]" rows="5"  name="remark" id="remark" ></textarea>							
					    <span class="col-sm-5 light-grey col-sm-push-5">限制输入字数2000个</span>
					</div>
			</div>
			
				

		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary " id="btn_submit"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					