<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
function sum(){
	var sum = 0;
	var agreeSum = $("#agreeSum").val();
	var guarantyScale = $("#guarantyScale").val();
	sum = Number(agreeSum) * Number(guarantyScale)/100;
	$("#guarantyDutySum").val(sum)
}
</script>
<div class="modal modal_wapper fade bs-example-modal-lg" id="meetDetailAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加批准担保情况</h4>
			</div>
			 
			 <div class="col-sm-12">
				<div class="table-responsive">
					
			   </div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="meetDetailAdd_form">
					<input type="hidden" name="apply_ID" value="${meetingDetail.apply_ID }">
					<input type="hidden" id="meetingResolutionID" name="meetingResolution_ID" value="${meetingDetail.meetingResolution_ID}">
					<%-- <table  id="table1" class="table table-hover table-striped" >
					<thead>
			 			 <tr >
				         	 <th width="10%" style="text-align: center;">序号</th>
				         	 <th width="15%" style="text-align: center;">项目编号 </th>
				             <th width="20%" style="text-align: center;">业务品种</th>
				             <th width="20%" style="text-align: center;">申请金额（万元）</th>
				             <th width="15%" style="text-align: center;">申请期限</th>
				             <th width="20%" style="text-align: center;">合作机构</th>
			             </tr>
		             </thead>	
					<c:forEach items="${applyDetailList}" var="applyDetail" varStatus="status">
						<tr>
							<td style="border:1px solid #ddd;text-align: center;">
							<input type="radio" name="applyDetail_ID" class="validate[required]" value="${applyDetail.applyDetail_ID}"/>&nbsp;${status.count}</td>
							<td style="border:1px solid #ddd;text-align: center;">${applyDetail.projectCode }</td>
							<td style="border:1px solid #ddd;text-align: center;">${applyDetail.busiTypeName }</td>
							<td style="border:1px solid #ddd;text-align: center;">${applyDetail.applySum }<fmt:formatNumber value='${applyDetail.applySum}' pattern='############'/></td>
							<td style="border:1px solid #ddd;text-align: center;">${applyDetail.periodMonthDay }</td>
							<td style="border:1px solid #ddd;text-align: center;">${applyDetail.bankName }</td>
						</tr>
					</c:forEach>
					</table>  --%> 
					
					
					<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"
				 for="form-field-1"><i class="icon-asterisk orange"></i>产品明细：</label>
				<div class=" col-sm-8 ">
				<div class="input-group">
						<select class="col-sm-8 col-md-8 validate[required]" name="applyDetail_ID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${applyDetailList}" var="applyDetail">
									<option value="${applyDetail.applyDetail_ID}">${applyDetail.busiTypeName}---${applyDetail.bankName}---${applyDetail.applySum}万元</option>
								</c:forEach>
					  </select>
					</div>
				</div>
			</div>
					
				<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"
				 for="form-field-1"><i class="icon-asterisk orange"></i>业务品种：</label>
				<div class=" col-sm-4 ">
				<div class="input-group busiSortDicTree">
						<input  type="text"  class="form-control validate[required]" autoField="busiTypeID" id="busiSortDicTree" name="busiTypeName" value="${meetingDetail.busiTypeName}" dataValue="${meetingDetail.busiTypeID}"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保金额： </label>
				<div class="col-sm-5">
					<input type="text" name="agreeSum" id="agreeSum" onchange="sum();" class="col-xs-6 col-sm-6 validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保期限： </label>
				<div class="col-sm-4">
					<input type="text" name="periodMonth" class="col-xs-3 col-sm-3 validate[required,custom[integer],maxSize[18]]" />
					<span class="midden col-sm-3" style="line-height:28px;">个月</span>
					<input type="text" name="periodDay" class="col-xs-3 col-sm-3 validate[custom[integer],maxSize[18]]" />
					<span class="midden col-sm-3" style="line-height:28px;">天</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>放款机构：</label>
				<div class=" col-sm-4">
					<div class="input-group selectBank">
						<input  type="text"  class="form-control validate[required]" autoField="bankID" id="selectBank" name="bankName" value="${meetingDetail.bankName}" dataValue="${meetingDetail.bankID}"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保责任范围：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<select class="col-sm-6"  name="guarantyScope">
								<option value="本金担保" <c:if test="${meetingDetail.guarantyScope=='本金担保' }">selected="selected"</c:if>>本金担保</option>
								<option value="本息担保" <c:if test="${meetingDetail.guarantyScope=='本息担保' }">selected="selected"</c:if>>本息担保</option>
							</select>
							<input type="text" name="guarantyScale"id="guarantyScale" onchange="sum();" class="col-xs-3 col-sm-3 validate[required,custom[number],maxSize[18]]" />
					       <span class="midden col-sm-3" style="line-height:28px;">%</span>
						</div>	
						
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"for="form-input">责任金额： </label>
				<div class="col-sm-5">
					<input type="text" name="guarantyDutySum"id="guarantyDutySum" class="col-xs-10 col-sm-6 validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"
							for="form-input">评审费率：</label>
						<div class="col-sm-4">
							<input type="text" name="reviewRate" id="reviewRate"  class="col-sm-8 validate[custom[number],maxSize[10]]" />
							<span class="midden col-sm-4 " style="line-height:28px;">‰</span>
						</div>
					</div> 
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">担保费率：</label>
						<div class="col-sm-4">
							<input type="text" name="guarantyRate" id="guarantyRate"  class="col-sm-8 validate[custom[number],maxSize[10]]" />
							<span class="midden col-sm-4 " style="line-height:28px;">%</span>
						</div>
					</div> 
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">保证金比例：</label>
						<div class="col-sm-4">
							<input type="text" name="bzScale" id="bzScale"  class="col-sm-8 validate[custom[number],maxSize[10]]" />
							<span class="midden col-sm-4 " style="line-height:28px;">%</span>
						</div>
					</div> 	
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-ok bigger-110'></i>保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>