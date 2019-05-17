<%@ include file="/common_timestamp.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectCostReturnEditPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">退回费用修改</h4>
      </div>
      <!--   展期登记修改页面 -->
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectCostReturnEdit_form" >
				<input type="hidden" id="costReturn_ID" name="costReturn_ID" value="${costReturn.costReturn_ID}">
				<input type="hidden" id="apply_ID" name="apply_ID" value="${costReturn.apply_ID}">
		    	
		    <div class="space-4"></div>	
           <div class="form-group col-sm-6">
                  <label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>退费类型： </label>
                  <label class="col-sm-8 grey">
                     	<input type="hidden" id="costTypeName" name="costTypeName" class="costTypeName"> 
						<select class="col-sm-4 validate[required] costTypeID" id="costTypeID" name="costTypeID">
							<c:forEach var="costType" items="${costTypeList}" varStatus="status">
								<option <c:if test="${costReturn.costTypeID eq costType.dicTypeID}">selected="selected"</c:if> value="${costType.dicTypeID}">${costType.dicTypeName}</option>
							</c:forEach>
						</select>
                  </label>
              </div>
          	<div class="space-4"></div>	
           	<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退回金额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="returnCostSum"	 id="returnCostSum" value="<fmt:formatNumber value="${costReturn.returnCostSum}" pattern="###.######"/>"/>
						<span class="midden col-sm-4" style="line-height:28px;">万元</span>
				</div>
			</div>
			<!-- <div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div> -->	
			<div class="space-4"></div>
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退回日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="delayBeginDate" type="text" value="<fmt:formatDate value="${costReturn.returnCostDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>" data-date-format="yyyy-mm-dd" />
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
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>

<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){
		$('.returnCostDate').focus();
	});
	$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
	$(".costTypeID").on("change", function () {
		$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
    })
</script>
					