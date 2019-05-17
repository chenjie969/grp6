<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
$('.date-picker').attr("value",tool.parseDate(new Date().getTime()));//设置默认日期为当前日期
$(".selectList").change(function(){	
	var selectID=$(this).attr("id");	//获取当前下拉框的id;	
	tool.getSelectText(selectID);
}); 

</script> 
<div class="modal fade bs-example-modal-sm" id="stopProcess_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">否决项目</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="stopProcess_form">
			 <input type="hidden" name="apply_ID" class="apply_ID" value="${apply.apply_ID}">
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">项目名称： </label>
                <label class="col-sm-9 grey">
                   	  ${apply.projectName}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">项目编号：</label>
                <label class="col-sm-9 grey">
                   	  ${apply.busiCode}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i> 否决日期： </label>
					<div class="col-sm-9">
						<div class="input-group col-sm-6">
							<input  type="text" class="form-control date-picker  validate[required,custom[date]]" name="stopDate"  id="id-date-picker-1" data-date-format="yyyy-mm-dd" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>否决类型： </label>
				<div class="col-sm-9">
					<input type="hidden" id="stopTypeName" class="clientTypeName" name="stopTypeName" >
						  <select id="stopTypeList" class="selectList col-sm-6 col-md-6 validate[required]" name="stopTypeID" >  		
									<option value="">&nbsp;请选择</option>                                    
									<c:forEach items="${stopTypeList}" var="stopType">
										<option value="${stopType.dicTypeID}">${stopType.dicTypeName}</option>
									</c:forEach>
						    </select>
				</div>
			</div>
		        <div class="form-group ">
					   <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>否决原因： </label>
			           <div class="col-sm-9">
			               <textarea class="col-sm-10 limited validate[required,maxSize[250]]" rows="5" id="stopDesc"  name="stopDesc" ></textarea>
			           	<div class="col-sm-10 no-padding-right">
			                 <span class="light-grey" style="float:right;">限制250个字符</span>
			            </div>
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
