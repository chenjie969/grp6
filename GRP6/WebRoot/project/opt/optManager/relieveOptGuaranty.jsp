<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="relieveOptGuarantyPage" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">保证措施解除</h4>
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
					<h4 class="header smaller lighter blue">保证措施解除</h4>
				</div>
				<form class="form-horizontal" role="form" id="form_relieveOptGuaranty">
					 <input class="col-sm-4 " type="hidden" name="optGuaranty_ID" value="" id="optGuaranty_ID">
					 <input class="col-sm-4 " type="hidden" name="isFree" value="1" >

					
					
					
					<c:if test="${opt.freeUserName eq null }">
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control " autoField="freeUserID"   id="txt_id1"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="freeUserName"  readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
						</div>
					</c:if>
					
					<c:if test="${opt.freeUserName ne null }">
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control " autoField="freeUserID"   id="txt_id1"  value="${opt.freeUserName }" dataValue="${opt.freeUserID}" name="freeUserName"  readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
						</div>
					</c:if>
					
					
					<c:if test="${opt.freeDate eq null }">
						<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>解除日期${opt.freeDate }：</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-5">
								<input class="form-control date-picker" id="freeDate" type="text" data-date-format="yyyy-mm-dd" name="freeDate" value="${opt.freeDate }"/>
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						</div>
					</c:if>
					
					<c:if test="${opt.freeDate ne null }">
						<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>解除日期：</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-5">
								<input class="form-control date-picker"  type="text" data-date-format="yyyy-mm-dd" name="freeDate" value="<fmt:formatDate value="${opt.freeDate }" pattern="yyyy-MM-dd"/>"/>
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						</div>
					</c:if>
					
					

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
	
		<%@ include file="/project/opt/imgUpload/optUpload_realizeView.jsp" %>
	