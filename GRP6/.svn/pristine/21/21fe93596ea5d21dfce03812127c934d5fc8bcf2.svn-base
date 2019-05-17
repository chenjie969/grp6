<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<div class="modal fade" id="viewBillRec" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看开票银行</h4>
      </div>
      <div class="modal-body">
			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">开票银行： <span class="grey" >${billRec.billBank }</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">票面金额：<span class="grey" >${billRec.billSum }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">票据期限：<span class="grey" >${billRec.period }</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">起止日期：
								<span class="grey" >
									<fmt:formatDate value="${billRec.beginDate }" pattern="yyyy-MM-dd"/>
									至
									<fmt:formatDate value="${billRec.beginDate }" pattern="yyyy-MM-dd"/>
								</span>
							</h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">敞口金额：<span class="grey" >${billRec.creditSum }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey" >${empty billRec.remark ? "（空）": billRec.remark}</span></h5>
						</div>
					</div>
				</div>
			</div>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					