<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade" id="costPreToPlanPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">调整收入计划</h4>
      </div>
      <div class="modal-body" id="form_submitToNext">
		<form class="form-horizontal" role="form" id="submitToNext_form">
			<input type="hidden" name="costPre_ID" id="costPre_ID" value="${costPre.costPre_ID}">
			<input type="hidden" name="preCostSum"  id="preCostSum"  value="${costPre.preCostSum}"><!--预收金额 -->
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">费用类型</label>
				<label class="col-sm-8" for="form-field-1">${costPre.costTypeName} </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">预收费用:</label>
				<label class="col-sm-8" for="form-field-1">
				    <fmt:formatNumber value="${costPre.preCostSum}" pattern="###,###.##"/>元
				</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>期次： </label>
				<div class="col-sm-8">
					<input type="text" id = "costCount" class="col-sm-6 validate[required,custom[integer],maxSize[2]]]" id="costCount"/>
				</div>
			</div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>首次收入日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" id="planFactTableDate0" name="planFactTableDate0"
								 	id="planFactTableDate0"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
		</form>
      </div>
      <div class="modal-body" style="display:none;" id="form_submitToLast">
		<form class="form-horizontal" role="form" id="submitToLast_form">
		        <input type="hidden" name="costPre_ID" id="costPre_ID" value="${costPre.costPre_ID}">
		        <input type="hidden" name="rowNum" id="rowNum" value=""><!-- 表格行数 -->
		        <input type="hidden" name="planFactTableData" id="planFactTableData" value=""> <!-- 拼接要提交的数据的字符串 -->
				<table id="table" class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
				<thead>
					<tr>
						<th>期次</th>
						<th>确认收入金额（元）</th>
						<th>计划收入日期</th>
					</tr>
				</thead>
				 <tbody>
						
					        
						
				</tbody>
			</table> 
		</form>
      </div>
      <div class="modal-footer" id="div_submitToNext">
		<button type="button" class="btn btn-primary " id="btn_submitToNext"><i class='icon-ok bigger-110'></i>下一步</button>
		<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
		
      </div>
      <div class="modal-footer" style="display:none;"  id="div_submitToLast">
		<button type="button" class="btn btn-primary " id="btn_submitToLast"><i class='icon-ok bigger-110'></i>上一步</button>
		<button type="button" class="btn btn-primary " id="btn_submitCostPlanToFact" ><i class='icon-ok bigger-110'></i>确定</button>
		
      </div>
    </div>
  </div>
</div>
<script src="<%=path%>/project/cost/costPreToCostFact.js?v=<%=vardate%>"></script>

<!-- 
<script type="text/javascript">
$(function() {
	
	$("#btn_submitToNext").click(function(){//点击下一步			
			 $("#div_submitToNext").hide();
			 $("#div_submitToLast").show();
	});
	$("#div_submitToLast").click(function(){	//点击上一步	
		 $("#div_submitToLast").hide();
		 $("#div_submitToNext").show();
		/*  $("#top_notice").attr("style", "display:block;");//第2种方法   */
	});
});	
	 
</script>-->
