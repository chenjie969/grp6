<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});

function setCostTypeName(){
	var type = document.getElementById('costStandardList');     	
	 var pindex  = type.selectedIndex;
	 // 获取选中的下拉框的值(value)
　	 var pValue  =  type.options[pindex].value;　
　	 // 获取选中的下拉框的值(key)
　	 var pText = type.options[pindex].text;
　    document.getElementById('costTypeName').value=pText;
}

</script>

<div class="modal fade bs-example-modal-sm" id="costStandardAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加收费标准</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="costStandardAdd_Form"> 
             <input type="hidden" id="costTypeName" name="costTypeName"/>
                 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>费用名称：</label>
						<div class="col-sm-9">
							<input type="text" name="costName" id="costName"  class="col-sm-8 validate[required,maxSize[50]]" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>费用类型名称：</label>
						<div class="col-sm-9">
				  			<select id="costStandardList" onchange="setCostTypeName()"  class="selectList col-sm-6 col-md-6 validate[required]"  name="costTypeID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${costStandardList}" var="costStandardLevel">
								<option value="${costStandardLevel.dicTypeID}">${costStandardLevel.dicTypeName}</option>
							</c:forEach>
				  			</select> 
						</div>
					</div>  
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>费率：</label>
						<div class="col-sm-9">
							<input type="text" name="costRate" id="costRate"  class="col-sm-8 validate[required,custom[number],maxSize[10]]" />
						</div>
					</div> 
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>费率单位：</label>
						<div class="col-sm-9">
							<select class="col-sm-8 select_clientSource  validate[required]"  name="costUnit"  id="select_costUnit">
									<option value="%">%</option>
									<option value="‰">‰</option>
							</select> 
						</div>
					</div>
					  
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>计算规则：</label>
						<div class="col-sm-9">
							<select class="col-sm-8 select_clientSource  validate[required]"  name="culate"  id="select_culate">
									<option value="按担保金额的一定比例收取">按担保金额的一定比例收取</option>
									<option value="按担保金额及期限计算收取">按担保金额及期限计算收取</option>
							</select>	
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

					