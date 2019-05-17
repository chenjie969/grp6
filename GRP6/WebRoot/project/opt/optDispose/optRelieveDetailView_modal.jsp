<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="relieveOptGuaranty_Page" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看已解除保证措施</h4>
			</div>

			<div class="modal-body">
				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">保证措施摘要</h4>
				</div>
				<div class="row col-sm-offset-1">
					<div id="optRelieveDetail_page"></div>		
		
				</div>

				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">保证措施登记落实</h4>
				</div>

				<div class="row col-sm-offset-1">
					<h5 class="col-sm-12">
						抵（质）押登记部门： <span class="grey" id="pledgeDepart">${opt.pledgeDepart }</span>
					</h5>
					<h5 class="col-sm-12">
						抵（质）押登记证明文件编号: <span class="grey" id="pledgeFile">${opt.pledgeFile }</span>
					</h5>
					<h5 class="col-sm-12">
						抵（质）押登记期限： <span class="grey" id="optBeginDate"><fmt:formatDate value="${opt.optBeginDate }" pattern="yyyy-MM-dd"/></span>
									   <span>~</span>
									   <span class="grey" id="optEndDate"><fmt:formatDate value="${opt.optEndDate }" pattern="yyyy-MM-dd"/></span>
					</h5>
					<h5 class="col-sm-12">
						份数： <span class="grey" id="pledgeFileCount">${opt.pledgeFileCount }</span>
					</h5>
					<h5 class="col-sm-12">
						原件存档接收人： <span class="grey" id="receivePerson">${opt.receivePerson }</span>
					</h5>
					<h5 class="col-sm-6">
						登记经办人： <span class="grey" id="realizeUserName">${opt.realizeUserName }</span>
					</h5>
					<h5 class="col-sm-6">
						经办日期： <span class="grey" id="realizeDate"><fmt:formatDate value="${opt.realizeDate }" pattern="yyyy-MM-dd"/></span>
					</h5>
				</div>

				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">保证措施解除</h4>
				</div>
				<form class="form-horizontal" role="form" id="form_relieveOptGuaranty">
					 <input class="col-sm-4 " type="hidden" name="optGuaranty_ID" value="" id="optGuaranty_ID">
					 <input class="col-sm-4 " type="hidden" name="isFree" value="1" >

			<div class="row col-sm-offset-1">
				<h5 class="col-sm-12">
					登记经办人： <span class="grey" id="realizeUserName">${opt.freeUserName }</span>
				</h5>
				<h5 class="col-sm-12">
					经办日期： <span class="grey" id="realizeDate"><fmt:formatDate value="${opt.freeDate }" pattern="yyyy-MM-dd"/></span>
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
