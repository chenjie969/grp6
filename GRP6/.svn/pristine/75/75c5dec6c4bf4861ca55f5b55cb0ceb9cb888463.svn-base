<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<div class="modal fade" id="viewGuarantyRec" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看对外担保</h4>
      </div>
      <div class="modal-body">
			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">对外担保单位： <span class="grey" >${guarantyRec.guarantyUnit }</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">担保金额：<span class="grey" >${guarantyRec.guarantySum }万元</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">票据期限：<span class="grey" >${guarantyRec.period }</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">起止日期：
								<span class="grey" >
									<fmt:formatDate value="${guarantyRec.beginDate }" pattern="yyyy-MM-dd"/>
									至
									<fmt:formatDate value="${guarantyRec.beginDate }" pattern="yyyy-MM-dd"/>
								</span>
							</h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">互保企业：<span class="grey" >${empty guarantyRec.eachOther ? "（空）": guarantyRec.eachOther}</span></h5>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey" >${empty guarantyRec.remark ? "（空）": guarantyRec.remark}</span></h5>
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
					