<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(".selectList").change(function(){	
	var selectID=$(this).attr("id");	//获取当前下拉框的id;	
	tool.getSelectText(selectID);
}); 
</script> 
<div class="modal fade" id="materialModelAdd_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增客户资料模板</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="materialModelAdd_Form">
      	 
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户资料清单模板名称： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="materialModelName" id="add_materialModelName" class="col-xs-12  validate[required,maxSize[50]]" />
						</div>
			        </div>
				</div>
			</div>
			
             <div class="form-group">
			   	<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种： </label>
		        <div class="col-sm-8">
					<div class="col-md-6 col-sm-6 input-group busiSortDicTree">
							<input  type="text"  class="form-control validate[required]" autoField="busiTypeIDList"   id="busiSortDicTree"  value="" dataValue="" name="busiTypeNameList"  readonly="readonly"/>
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
					    	<input type="hidden" id=clientTypeName  name="clientTypeName" >
							<select id="clientTypeList" class="selectList col-xs-10 validate[required]" name="clientTypeID" >
								<option value="">&nbsp;请选择</option>
								<%-- <c:forEach items="${clientTypeList}" var="clientType">
									<option value="${clientType.dicTypeID}">${clientType.dicTypeName}</option>
								</c:forEach> --%>
								<option value="01">企业客户</option>
								<option value="02">个人客户</option>
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
							<input type="text" name="versionNumber" class="col-xs-12 validate[required,custom[number],maxSize[5]]" />
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>清单状态： </label>
				<div class="col-sm-8">
					<div class="radio" id="" >
						<label>
							<input  name="status"  type="radio" class="ace" value="true" checked/>
							<span class="lbl">启用</span>
						</label>
					   <label>
							<input  name="status"  type="radio" class="ace" value="false" />
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
							<textarea class="col-xs-12 validate[maxSize[250]]"   name="remark" rows="5"></textarea>
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
        <button type="button" class="btn btn-primary " id="btn_materialModelAdd"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					