<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="disposeOptGuarantyPage" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">保证措施处置</h4>
			</div>

			<div class="modal-body">
				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">保证措施摘要</h4>
				</div>
				<div class="row col-sm-offset-1">
					<h5 class="col-sm-6">
						项目编号： <span class="grey" id="busiCode">BJAJ00258</span>
					</h5>
					<h5 class="col-sm-6">
						项目名称： <span class="grey" id="projectName">北京市农业融资担保有限公司</span>
					</h5>
					<h5 class="col-sm-6">
						保证方式： <span class="grey"  id="guarantyTypeName"></span>
					</h5>
					<h5 class="col-sm-12">
						反担保物类型： <span class="grey" id="optTypeName"></span>
					</h5>
					<h5 class="col-sm-6">
						权属人： <span class="grey" id="ownerName"></span>
					</h5>
					<h5 class="col-sm-6">
						评估价值（万元）： <span class="grey" id="assessValue">出让</span><span>万元</span>
					</h5>
					<h5 class="col-sm-6">
						抵（质）押率： <span class="grey" id="coverageRatio"></span><span>%</span>
					</h5>
					<h5 class="col-sm-6">
						抵（质）押价值： <span class="grey" id="optValue"></span><span>万元</span>
					</h5>
					<h5 class="col-sm-6">
						是否已落实： <span class="grey isWorkable" id="isWorkable"></span>
					</h5>
				</div>

				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">保证措施落实详情</h4>
				</div>

				<div class="row col-sm-offset-1">
					<h5 class="col-sm-12">
						抵（质）押登记部门： <span class="grey" id="pledgeDepart"></span>
					</h5>
					<h5 class="col-sm-12">
							<input type="hidden" name="pledgeFile" id="pledgeFile" value="${opt.pledgeFile }">
							抵（质）押登记证明文件： <span class="grey">
							<br><br>
							<div id="pictureDIV_realize" class=""></div>
						</span></h5>
					<h5 class="col-sm-12">
						抵（质）押登记期限： <span class="grey" id="optBeginDate"></span><span>~</span><span class="grey" id="optEndDate"></span>
					</h5>
					<h5 class="col-sm-12">
						份数： <span class="grey" id="pledgeFileCount"></span>
					</h5>
					<!-- <h5 class="col-sm-12">
						原件存档接收人： <span class="grey" id="receivePerson"></span>
					</h5> -->
					<h5 class="col-sm-6">
						登记经办人： <span class="grey" id="realizeUserName"></span>
					</h5>
					<h5 class="col-sm-6">
						经办日期： <span class="grey" id="realizeDate"></span>
					</h5>

				</div>
				

				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">反担保物处置</h4>
				</div>
				<form class="form-horizontal" role="form" id="form_disposeOptGuarantyPage">
					
					<input class="col-sm-4 " type="hidden" name="optGuaranty_ID" value="" id="optGuaranty_ID">
					<input class="col-sm-4 " type="hidden" name="isDispose" value="1" id="isDispose">
					
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>处置方式：</label>
						<div class="col-sm-8">
							<input type="hidden" name="disposeTypeName" id="disposeTypeName" value="${opt.disposeTypeName }">
							<select class="col-sm-4 validate[required]" id="disposeTypeID" name="disposeTypeID">
								<option value="">请选择</option>
								<c:forEach var="cz" items="${chuzhiList }">
									<option value="${cz.dicTypeID }" <c:if test="${opt.disposeTypeID == cz.dicTypeID }">selected='selected'</c:if>>${cz.dicTypeName }</option>
								</c:forEach>	
							</select>
						</div>
					</div>

					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>处置变现金额：</label>
						<div class="col-sm-8">
							<input type="text" id="disposeSum" class="col-sm-3 validate[required,custom[number],maxSize[18]]"  name="disposeSum" value="<fmt:formatNumber  value="${opt.disposeSum }" pattern="####.######"/>"/> 
							<span style="line-height: 28px;">&nbsp;&nbsp;万元</span>
						</div>

					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>冲抵变现金额：</label>
						<div class="col-sm-8">
							<input type="text" id="chargeAgainstSum" class="col-sm-3 validate[required,custom[number],maxSize[18]]" name="chargeAgainstSum" value="<fmt:formatNumber  value="${opt.chargeAgainstSum }" pattern="####.######"/>"/> 
							<spanstyle="line-height: 28px;">&nbsp;&nbsp;万元</span>
						</div>
					</div>
				
				
				<c:if test="${opt.disposeUserName ne null && opt.disposeUserName ne ''}">	
					<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control validate[required]" autoField="disposeUserId"   id="txt_id1"  value="${opt.disposeUserName }" dataValue="${opt.disposeUserId}" name="disposeUserName"  readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
					</div>
				</c:if>	
				
				<c:if test="${opt.disposeUserName eq null || opt.disposeUserName eq ''}">	
					<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control" autoField="disposeUserId"   id="txt_id1"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="disposeUserName"  readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
					</div>
				</c:if>	
				
				
					

					<c:if test="${opt.disposeDate eq null }">
						<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"> <i class="icon-asterisk orange"></i>处置日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-5">
								<input class="form-control date-picker validate[required,custom[date]]" id="disposeDate" type="text" data-date-format="yyyy-mm-dd"  name="disposeDate"/>
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						</div>
					</c:if>
					
					<c:if test="${opt.disposeDate ne null }">
						<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"> <i class="icon-asterisk orange"></i>处置日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-5">
								<input class="form-control date-picker validate[required,custom[date]]"  type="text" data-date-format="yyyy-mm-dd" value="<fmt:formatDate value="${opt.disposeDate }" pattern="yyyy-MM-dd"/>"  name="disposeDate"/>
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						</div>
					</c:if>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">备注： </label>
						<div class="col-sm-8">
							<textarea class="col-sm-10 limited  validate[maxSize[2000]]" id="form-field-9" name="guaranteeRemark" rows="5">${opt.guaranteeRemark }</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey" style="float: right;">限制2000个字符</span>
							</div>
						</div>
					</div>

				</form>

			</div>

			<div class="modal-footer">
				<button class="btn btn-primary" type="button" id="btn_submit">
					<i class="icon-ok bigger-110"></i> 保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class="icon-remove bigger-110"></i> 关闭
				</button>
			</div>


		</div>
	</div>
</div>
<div id="optGuarantyAdd_page"></div>
<script>
	//选中的 反担保物名称赋值给隐藏域
	$("#disposeTypeID").change(function(){
		var disposeTypeName = $("#disposeTypeID").find("option:selected").text();
		$("#disposeTypeName").val(disposeTypeName);
	})
</script>
			<%@ include file="/project/opt/imgUpload/optUpload_realizeView.jsp" %>
	
