<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="materialModelInfo_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看客户资料清单模板</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="">
      	 	
			<div class="form-group ">
				<label class="col-sm-4  control-label no-padding-right" >客户资料清单模板名称： </label>
				<label class="col-sm-8 grey">
					 ${materialModel.materialModelName}
				</label>
			</div>
			
             <div class="form-group">
			   	<label class="col-sm-4 control-label no-padding-right" >业务品种： </label>
		        <label class="col-sm-7 grey">
					${materialModel.busiTypeNameList}
				</label>
	         </div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" >适用客户类型： </label>
				<label class="col-sm-8 grey">
					${materialModel.clientTypeName}
				</label>
			</div>
			
			<div class="form-group ">
				<label class="col-sm-4  control-label no-padding-right" >版本号： </label>
				<label class="col-sm-8 grey ">
					 V&nbsp;&nbsp;${materialModel.versionNumber}
				</label>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" >清单状态： </label>
				<label class="col-sm-8 grey">
				     <c:if test="${materialModel.status}">启用</c:if>
				     <c:if test="${!materialModel.status}">禁用</c:if>
				</label>
			</div>
			
			<div class="form-group ">
				<label class="col-sm-4  control-label no-padding-right">备注： </label>
				<label class="col-sm-7 grey">
					${materialModel.remark}
				</label>	
			</div>
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					