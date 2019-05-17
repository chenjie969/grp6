<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="highOptQueryPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">高级查询</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="form_highOptQuery">
      	 	
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
					<label class="col-sm-3 control-label no-padding-right" for="form-input">经办人：</label><%-- 已和贵洲确认取值,保证措施信息创建人 --%>
					<div class="col-sm-8">
					<div class="col-sm-6 input-group txt_id1">
						<input  type="text"  class="form-control col-sm8" autoField=""   id="txt_id1"  value="" dataValue="" name="updateUserName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
					</div>				
			</div>
			
			<%-- 已和李坤明 确认，取消经办部门查询条件  --%>
		<%-- 	<div class="form-group">
			  	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">经办部门： </label> 已和贵洲确认，取值保证措施信息创建部门
				  <div class="col-sm-8">				  			
						<div class="col-md-6 col-sm-6 input-group allDepartsTree1">
							<input  type="text"  class="form-control" autoField="depart_uid"   id="allDepartsTree1"  value="" dataValue="" name="departName11"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>				  
			</div> --%>
			
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-input">是否已落实： </label>
               <div class="col-sm-5">
                   <select class="col-sm-11" id="form-field-select-1" name="isWorkable">
                       <option value=""></option>
                       <option value="1">是</option>
                        <option value="0">否</option>
                   </select>
               </div>
            </div>
            
		 </form>
      </div>
	      <div class="modal-footer ">
	        <button type="button" class="btn btn-primary btn_submit" id="btn_submit" > <i class='icon-search bigger-110'></i>查询</button>
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
								
