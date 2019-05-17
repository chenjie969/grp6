<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="materialModelCopy_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">复制客户资料类型</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="materialModelCopy_form">
      	 <%-- 	<input type="hidden" name="product_ID"  value="${materialModel.product_ID}"> --%>
      	 <input type="hidden" name="materialModel_ID"  value="${materialModel.materialModel_ID}">
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户资料清单模板名称： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="materialModelName" id="add_materialModelName" class="col-xs-12  validate[required,maxSize[50]]" value="${materialModel.materialModelName}"/>
						</div>
			        </div>
				</div>
			</div>
			
             <div class="form-group">
			   	<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种： </label>
		        <div class="col-sm-8">
					<div class="col-md-6 col-sm-6 input-group busiSortDicTree">
							<input  type="text"  class="form-control validate[required]" autoField="busiTypeIDList"   id="busiSortDicTree"  value="${materialModel.busiTypeNameList}" dataValue="${materialModel.busiTypeIDList}" name="busiTypeNameList"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
				    </div>
				</div>
	         </div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>适用客户类型： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
					    	<input type="hidden" id=clientTypeName  name="clientTypeName" value="${materialModel.clientTypeName}">
							<select id="clientTypeList" class="selectList col-xs-10 validate[required]" name="clientTypeID"  value="${materialModel.clientTypeID}">
								<option value="">&nbsp;请选择</option>
								<option value="01" <c:if test="${materialModel.clientTypeID eq '01'}"> selected="selected"</c:if>>企业客户</option>
								<option value="02" <c:if test="${materialModel.clientTypeID eq '02'}"> selected="selected"</c:if>>个人客户</option>
							</select>
						</div>
			        </div>
				</div>
			</div>
			
			
			
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>版本号： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="versionNumber" class="col-xs-12 validate[required,custom[number],maxSize[5]]" value="${materialModel.versionNumber}"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>清单状态： </label>
				<div class="col-sm-8">
					<div class="radio" id="" >
						<label>
							<input  name="status"  type="radio" class="ace" value="true" <c:if test="${materialModel.status}">checked</c:if>/>
							<span class="lbl">启用</span>
						</label>
					   <label>
							<input  name="status"  type="radio" class="ace" value="false"  <c:if test="${!materialModel.status}">checked</c:if>/>
							<span class="lbl">禁用</span>
						</label>                                    
					</div>
				</div>
			</div>
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right "  for="form-field-1">备注： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-12 validate[maxSize[250]]"   name="remark" rows="5">${materialModel.remark}</textarea>
							<div class="col-xs-12 no-padding-right">
								<span class="light-grey" style="float:right">限制250个字符</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					