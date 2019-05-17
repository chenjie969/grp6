<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="viewProjectBillInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看票据信息</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   	<div class="col-sm-offset-1">
				<h5 class="col-sm-12">票据类型：<span class="grey">${bill.billTypeName }</span></h5>
				<%-- <h5 class="col-sm-12">票据编号：<span class="grey">${bill.billCode }</span></h5> --%>
				<h5 class="col-sm-12">开票名称：<span class="grey">${bill.billTitle }</span></h5>
				<h5 class="col-sm-12">纳税人识别号：<span class="grey">${empty bill.taxCode?"（空）":bill.taxCode }</span></h5>
				<h5 class="col-sm-12">票据金额：<span class="grey">
					<c:choose>
						<c:when test="${empty bill.billSum }">（空）</c:when>
						<c:otherwise><fmt:formatNumber value="${bill.billSum}" pattern="###,###.##"> </fmt:formatNumber> 元</c:otherwise>
					</c:choose>
				</span></h5>
				<h5 class="col-sm-12">开具日期：<span class="grey">
					<c:choose>
						<c:when test="${empty bill.billDate }">（空）</c:when>
						<c:otherwise><fmt:formatDate value='${bill.billDate }' pattern='yyyy-MM-dd' type='date'/></c:otherwise>
					</c:choose>
				</span></h5>
				<h5 class="col-sm-12">地址：<span class="grey">${empty bill.address?"（空）":bill.address }</span></h5>
				<h5 class="col-sm-12">电话：<span class="grey">${empty bill.phone?"（空）":bill.phone }</span></h5>
				<h5 class="col-sm-12">开户行：<span class="grey">${empty bill.openBank?"（空）":bill.openBank }</span></h5>
				<h5 class="col-sm-12">开户账号：<span class="grey">${empty bill.accountNum?"（空）":bill.accountNum }</span></h5>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
