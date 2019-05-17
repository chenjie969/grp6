<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="realizeOptGuarantyPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">保证措施落实</h4>
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
					<h5 class="col-sm-6">
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
					<h5 class="col-sm-12">
						是否已落实： <span class="grey isWorkable" id="isWorkables"></span>
					</h5>
				</div>

				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">保证措施登记落实</h4>
				</div>

				<form class="form-horizontal" role="form" id="form_realizeOptGuaranty">
						 <input class="col-sm-4 " type="hidden" name="optGuaranty_ID" value="" id="optGuaranty_ID">
						 <input class="col-sm-4 " type="hidden" name="isWorkable" value="1">
				
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"> <i class="icon-asterisk orange"></i>抵（质）押登记部门：
						</label>
						<div class="col-sm-8">
							 <input class="col-sm-4 validate[required,maxSize[50]]" name="pledgeDepart" value="${opt.pledgeDepart }">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">抵（质）押登记证明文件：
						</label>
						<div class="col-sm-8">
							<input type=hidden id="pledgeFile" name="pledgeFile" class="col-sm-5" value="${opt.pledgeFile }"/>
							<div class="col-sm-12">
							  	<button class="btn btn-xs btn-info" type="button" name="button" id="avatar">
		                                                                            上传
	                            </button>
	                            <div id="pictureDIV_realize" class=""></div>
							</div>
						</div>

					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"> <i class="icon-asterisk orange"></i>抵（质）押登记期限：
						</label>
						<div class="col-md-8">
							<div class="input-group col-sm-5" style="float: left;">
								<input class="form-control date-picker validate[required,maxSize[50],custom[date]]" id="optBeginDate" name="optBeginDate" type="text" 
									value="<fmt:formatDate value="${opt.optBeginDate }" pattern="yyyy-MM-dd"/>"	data-date-format="yyyy-mm-dd" />
									 <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
								
							</div>
							<span class="col-sm-1" style="float: left; line-height: 34px;">~</span>
							<div class="input-group col-sm-5">
								<input class="form-control date-picker validate[required,maxSize[50],custom[date],gt[optBeginDate]]" id="optEndDate" name="optEndDate" type="text" 
									value="<fmt:formatDate value="${opt.optEndDate }" pattern="yyyy-MM-dd"/>"	data-date-format="yyyy-mm-dd" /> 
									<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>份数：</label>
						<div class="col-sm-8">
							<input type="number" id="form-field-1" class="col-sm-3 validate[required,custom[number],maxSize[5]]" min="1" name="pledgeFileCount" value="${opt.pledgeFileCount }"/>
						</div>
					</div>

					
					<%-- <c:if test="${opt.receivePerson eq null  }">
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>原件存档接收人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id2">
								<input  type="text"  class="form-control " autoField=""   id="txt_id2"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="receivePerson"  readonly="readonly"/>
								
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
					</div>
					</c:if>
					
					<c:if test="${opt.realizeUserName ne null  }">
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>原件存档接收人：</label>
							<div class="col-md-6">
								<div class="col-md-6 col-sm-6 input-group txt_id2">
									<input  type="text"  class="form-control " autoField=""   id="txt_id2"  value="${opt.receivePerson }" dataValue="${sessionUser.user_uid}" name="receivePerson"  readonly="readonly"/>
									
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
								</div>
							</div>				
						</div>
					</c:if> --%>
					
					
					
					<c:if test="${opt.realizeUserName eq null  }">
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control " autoField="realizeUserID"   id="txt_id1"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="realizeUserName"  readonly="readonly"/>
								
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
					</div>
					</c:if>
					
					<c:if test="${opt.realizeUserName ne null  }">
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control " autoField="realizeUserID"   id="txt_id1"  value="${opt.realizeUserName }" dataValue="${opt.realizeUserID }" name="realizeUserName"  readonly="readonly"/>
								
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
					</div>
					</c:if>
						
					
					
					<c:if test="${opt.realizeDate eq  null }">
						<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"> <i class="icon-asterisk orange"></i>经办日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-5">
								<input class="form-control date-picker validate[required,maxSize[50],custom[date]]" id="realizeDate" 
								     value="<fmt:formatDate value="${opt.realizeDate }" pattern="yyyy-MM-dd"/>"	type="text" data-date-format="yyyy-mm-dd" name="realizeDate"/> 
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						</div>
					</c:if>
					
					<c:if test="${opt.realizeDate ne  null }">
						<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"> <i class="icon-asterisk orange"></i>经办日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-5">
								<input class="form-control date-picker validate[required,maxSize[50],custom[date]]" 
								     value="<fmt:formatDate value="${opt.realizeDate }" pattern="yyyy-MM-dd"/>"	type="text" data-date-format="yyyy-mm-dd" name="realizeDate"/> 
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						</div>
					</c:if>
					<div class="form-group" style="height: 100px"></div>

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

	<%@ include file="/project/opt/imgUpload/optUpload_realize.jsp" %>

