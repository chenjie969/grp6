<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade bs-example-modal-sm" id="laborContractView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看劳动合同</h4>
      </div>
      <div class="modal-body">	
      	<div class="row">
			<div class="col-sm-offset-1 col-sm-10">
				<div class="col-sm-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height: 26px;">
							签订起止日期：<span class="grey">
							<fmt:formatDate value='${laborContract.laborContractStartDate ==""? "（空）":laborContract.laborContractStartDate}' pattern='yyyy-MM-dd'/> 至 
							<fmt:formatDate value='${laborContract.laborContractEndDate ==""? "（空）":laborContract.laborContractEndDate }' pattern='yyyy-MM-dd'/>
							</span>
						</h5>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height: 26px;">
							签订期限：<span class="grey">${laborContract.laborContractPeriod ==""? "（空）":laborContract.laborContractPeriod}年</span>
						</h5>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height: 26px;">
							劳动合同类型：<span class="grey">${laborContract.laborContractType ==""? "（空）":laborContract.laborContractType}</span>
						</h5>
					</div>
				</div>
					<div class="col-sm-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height: 26px;">
							签订日期：<span class="grey"><fmt:formatDate value='${laborContract.laborContractDate ==""? "（空）":laborContract.laborContractDate}' pattern='yyyy-MM-dd'/></span>
						</h5>
					</div>
				</div>					
				<div class="col-sm-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height: 26px;">
							备注：<span class="grey">${laborContract.laborContractNotes =="" ? "（空）" :laborContract.laborContractNotes}</span>
						</h5>
					</div>
				</div>
							
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
