<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="realizeOptGuarantyPageView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看已落实保证措施</h4>
			</div>

			<div class="modal-body">
				<div>
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
						是否已落实： <span class="grey" id="isWorkables"></span>
					</h5>
				</div>
			
				
				 <div>
					<h4 class="header smaller lighter blue">保证措施落实详情</h4>
				</div>
				
					<div class="row col-sm-offset-1">
						<h5 class="col-sm-12">
							抵（质）押登记部门： <span class="grey" id="pledgeDepart">${opt.pledgeDepart }</span>
						</h5>
						<h5 class="col-sm-12">
							<input type="hidden" name="pledgeFile" id="pledgeFile" value="${opt.pledgeFile }">
							抵（质）押登记证明文件： <span class="grey">
							<br><br>
							<div id="pictureDIV_realize" class=""></div>
						</span></h5>
						<h5 class="col-sm-12">
							抵（质）押登记期限： <span class="grey" id="optBeginDate"><fmt:formatDate value="${opt.optBeginDate }" pattern="yyyy-MM-dd"/></span>
										   <span>~</span>
										   <span class="grey" id="optEndDate"><fmt:formatDate value="${opt.optEndDate }" pattern="yyyy-MM-dd"/></span>
						</h5>
						<h5 class="col-sm-12">
							份数： <span class="grey" id="pledgeFileCount">${opt.pledgeFileCount }</span>
						</h5>
						<%-- <h5 class="col-sm-12">
							原件存档接收人： <span class="grey" id="receivePerson">${opt.receivePerson }</span>
						</h5> --%>
						<h5 class="col-sm-6">
							登记经办人： <span class="grey" id="realizeUserName">${opt.realizeUserName }</span>
						</h5>
						<h5 class="col-sm-6">
							经办日期： <span class="grey" id="realizeDate"><fmt:formatDate value="${opt.realizeDate }" pattern="yyyy-MM-dd"/></span>
						</h5>
					</div> 
				

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class="icon-remove bigger-110"></i> 关闭
				</button>
			</div>
		</div>
	</div>
</div>
<div id="optGuarantyAdd_page"></div>
	
		<%@ include file="/project/opt/imgUpload/optUpload_realizeView.jsp" %>
	
	