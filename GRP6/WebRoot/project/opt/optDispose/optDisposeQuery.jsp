<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="optDisposeQuery" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">高级查询</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="form_disposeQuery">

				<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">项目编号： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-sm-10">
							<input type="text" name="busiCode" class="col-sm-12 validate[maxSize[50]]"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">项目名称： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
							<input type="text" name="projectName" class="col-sm-12 validate[maxSize[50]]">
						</div>
			        </div>
		    	</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">权属人： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
							<input type="text" name="ownerName" class="col-sm-12 validate[maxSize[50]]">
						</div>
			        </div>
		    	</div>
			</div>
			
			<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">保证方式： </label>
					<div class="col-sm-8  col-lg-4">
						<input type="hidden" name="guarantyTypeName">
						<select name="guarantyTypeID"  class=" col-sm-12 " id="btn_guarantyTypes">
							<option value="">请选择</option>
							<c:forEach var="bz"  items="${baozhengList}">
								<option value="${bz.dicTypeID }">${bz.dicTypeName }</option>
							</c:forEach>
					</select>
				</div>
			</div>
						
			<div class="space-4"></div>
			<div class="form-group" id="btn_optTypesDIV">
			    <label class="col-sm-3 control-label no-padding-right" for="form-field-1">反担保类型： </label>
			    <div class="col-sm-8 col-lg-4">
			    	<input type="hidden" name="optTypeName" id="optTypeName">
			        <select class="col-xs-6 col-sm-12  " id="btn_optTypes" name="optTypeID">
						<option value="">请选择</option>
					</select>
			    </div>
			</div>
			
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-input">经办人： </label>
			   	<div class="col-sm-6">
			        <div class="col-sm-12 input-group selectCreateUser"> <%-- 取值： 处置操作经办人 --%>
						<input  type="text"  class="form-control" autoField="disposeUserId"   id="selectCreateUser"  
							value="" dataValue="" name="disposeUserName" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input">处置日期： </label>
		        <div class="col-sm-9">
					<div class="row">
						<div class="col-sm-4 no-padding-right">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" name="disposeBeginDate" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<span class="midden col-sm-1" style="line-height:28px;">~</span>
						<div class="col-sm-4 no-padding-left">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" name="disposeEndDate" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			<div class="form-group col-sm-12 col-xs-12" style="height:80px"></div>
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-search bigger-110'></i>查询</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					
					
					
	<script>
	
	$("#btn_optTypesDIV").hide();
	
	/**
	 *  保证方式处理
	 */
	$("#btn_guarantyTypes").change(function(){
		var _optionText =$("#btn_guarantyTypes").find('option:selected').text();//获取下拉框默认选中文本 text
		var _val= $("#btn_guarantyTypes").val(); // 获取下拉框默认选中的值 value
		guarantyType(_optionText,_val);
	})
	
	
	/**
	 * 保证措施管理--- 新增-- 保证方式处理
	 */
	function guarantyType(_optionText,_val){
		if(_val == 'c0b07f297c6f4e23981d9e1fed84c5f9'){ // 质押 
			$("#btn_optTypesDIV").show();
			$.ajax({ // 获取 保证方式为： 质押  时的反担保物类型 字段
				type : 'POST',
				url : "/selectDicTypeSelectJSONKeyValue",
				data : JSON.stringify({"dicTypePID" : '686f264405e549b299a7ed815ea289d6'}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#btn_optTypes").empty();
					$("#btn_optTypes").append("<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("#btn_optTypes").append("<option value='" + key2 + "'>"+ value2 + "</option>");
						});
					});
				}
			});
		}else if( _val == '596d424eb6594b1485ecc724a2533c1c'){ //抵押
			$("#btn_optTypesDIV").show();
			$.ajax({ // 获取 保证方式为： 抵押 时的反担保物类型 字段  
				type : 'POST',
				url : "/selectDicTypeSelectJSONKeyValue",
				data : JSON.stringify({"dicTypePID" : '12b5eece874947de8e692a31939cda44'}),
				async : false,
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#btn_optTypes").empty();
					$("#btn_optTypes").append("<option value=''>&nbsp;请选择</option>");
					$.each(data.obj, function(key1, value1) {
						$.each(value1, function(key2, value2) {
							$("#btn_optTypes").append("<option value='" + key2 + "'>"+ value2 + "</option>");
						});
					});
				}
			});
		}else{
			$("#btn_optTypes").removeClass("validate[required]"); // 取消验证
			$("#btn_optTypesDIV").hide();
		}
	}
	
</script>
									