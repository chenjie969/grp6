<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});

function setRiskLevelName(){
	var type = document.getElementById('riskLevelList');     	
	 var pindex  = type.selectedIndex;
	 // 获取选中的下拉框的值(value)
　	 var pValue  =  type.options[pindex].value;　
　	 // 获取选中的下拉框的值(key)
　	 var pText = type.options[pindex].text;
　    document.getElementById('riskLevelName').value=pText;
}

/*添加项目分类处置划分 */
function setDivisionName(){
	var type = document.getElementById('divisionNameList');     	
	 var pindex  = type.selectedIndex;
	 // 获取选中的下拉框的值(value)
　	 var pValue  =  type.options[pindex].value;　
　	 // 获取选中的下拉框的值(key)
　	 var pText = type.options[pindex].text;
　    document.getElementById('divisionName').value=pText;
}


</script>

<div class="modal fade bs-example-modal-sm" id="AddRiskLevel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加风险等级评定</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="AddRiskLevel_Form"> 
			<input type="hidden" name="riskLevelName" id="riskLevelName"/>
			<input type="hidden" name="client_ID" id="client_ID" value="${client_ID}"/>
		 	<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-input"><i class="icon-asterisk orange"></i>风险等级：</label>
					<div class="col-sm-8">
						 <select id="riskLevelList" onchange="setRiskLevelName()" class="selectList col-sm-6 col-md-6 validate[required]"  name="riskLevelID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${riskLevelList}" var="riskLevel">
								<option value="${riskLevel.dicTypeID}">${riskLevel.dicTypeName}</option>
							</c:forEach>
				  		</select>
					</div>
			</div>
			
			<div class="form-group">
			<input type="hidden" name="divisionName" id="divisionName"/>
					<label class="col-sm-4 control-label no-padding-right"
						for="form-input"><i class="icon-asterisk orange"></i>项目分类处置划分：</label>
					<div class="col-sm-8">
						 <select id="divisionNameList" onchange="setDivisionName()" class="selectList col-sm-6 col-md-6 validate[required]"  name="divisionID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${divisionNameList}" var="riskLevel">
								<option value="${riskLevel.dicTypeID}">${riskLevel.dicTypeName}</option>
							</c:forEach>
				  		</select>
					</div>
			</div>
			<div class="form-group">
 			<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>评定日期： </label>
				<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-7">
								<div class="input-group">
									<input  type="text" class="form-control date-picker validate[required,custom[date]]" 
									name="changeDateTime" id="id-date-picker-1"  data-date-format="yyyy-mm-dd"  value = "<fmt:formatDate pattern="yyyy-MM-dd" value="${riskLevel.changeDateTime}" />" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
 			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"
					for="form-input">评定说明：</label>
				<div class="col-sm-8">
					<textarea class="col-sm-10 limited   validate[maxSize[2000]]" rows="5" name="riskLevelIDDesc" id="riskLevelIDDesc"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey pull-right">最多允许输入字符2000个</span>
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

