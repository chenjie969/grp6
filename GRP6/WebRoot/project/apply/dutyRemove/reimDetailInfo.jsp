<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>


<div class="page-content">   
     <div class="page-header">
     	<h4>还款详情</h4>
     </div>
      <div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">
				 放款信息
				 <c:if test="${type eq 'edit' }">
					<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_dutyRemove">
						<i class="icon-edit bigger-110"></i>
						<span class="bigger-110 no-text-shadow">责任解除</span>
					</button>
				</c:if>
		  	</h4>
			<input type="hidden"  id="project_ID" value="${project.project_ID}">
			<input type="hidden"  id="type_input" value="${type}">
			<input type="hidden"  id="isFree-detail" value="${project.isFree}">
			<input type="hidden"  id="apply_ID" value="${project.apply_ID}">
			<input type="hidden"  id="guarantySum-detail" value="${project.guarantySum}">
			<input type="hidden"  id="guarantyDutyResSum-detail" value="${project.guarantyDutyResSum}">
			<div class="col-sm-12">
                <h5 class="col-sm-12">项目编号：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.projectCode}">（空）</c:when>
				    	<c:otherwise>${project.projectCode}</c:otherwise>
				    </c:choose>
                </span></h5>
                <h5 class="col-sm-12">项目名称：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.projectName}">（空）</c:when>
				    	<c:otherwise>${project.projectName}</c:otherwise>
				    </c:choose>
                </span></h5>
                <h5 class="col-sm-6">资金来源：
	                <span class="grey"><c:choose>
	                	<c:when test="${empty apply.fundSource}">（空）</c:when>
	                	<c:otherwise>${apply.fundSource}</c:otherwise>
	                </c:choose></span>
                </h5>
                <h5 class="col-sm-6">资金方子机构：
	                <span class="grey"><c:choose>
	                	<c:when test="${empty apply.fundName}">（空）</c:when>
	                	<c:otherwise>${apply.fundName}</c:otherwise>
	                </c:choose></span>
                </h5>
                
                <h5 class="col-sm-12">业务品种：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.busiTypeName}">（空）</c:when>
				    	<c:otherwise>${project.busiTypeName}</c:otherwise>
				    </c:choose>
                </span></h5>
                <%-- <h5 class="col-sm-6">合作机构：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.bankName}">（空）</c:when>
				    	<c:otherwise>${project.bankName}</c:otherwise>
				    </c:choose>
                </span></h5> --%>
               <%--  <h5 class="col-sm-12">放款单编号：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.loadCode}">（空）</c:when>
				    	<c:otherwise>${project.loadCode}</c:otherwise>
				    </c:choose>
                </span></h5> --%>
                <h5 class="col-sm-6">放款金额：
	                <span class="grey">
	               	<c:choose>
	                	<c:when test="${empty project.loadSum}">（空）</c:when>
	                	<c:otherwise><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"/>万元</c:otherwise>
	                </c:choose></span>
                </h5>
                <h5 class="col-sm-6">
                    <c:choose>
                    	<c:when test="${project.busiClass eq '01'}">
                    		在保余额：
                    	</c:when>
                    	<c:otherwise>
                    		委贷余额：
                    	</c:otherwise>
                    </c:choose>
                	<span class="grey">
                	<c:choose>
	                	<c:when test="${empty project.guarantySum}">（空）</c:when>
	                	<c:otherwise><fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######"/>万元</c:otherwise>
	                </c:choose></span>
                </h5>
              <%--   <h5 class="col-sm-6">责任金额：
                	<span class="grey"><c:choose>
	                	<c:when test="${empty project.guarantyDutySum}">（空）</c:when>
	                	<c:otherwise><fmt:formatNumber value="${project.guarantyDutySum}" pattern="###,###.######"/>万元</c:otherwise>
	                </c:choose></span>
                </h5>
                <h5 class="col-sm-6">责任余额：
                	<span class="grey"><c:choose>
	                	<c:when test="${empty project.guarantyDutyResSum}">（空）</c:when>
	                	<c:otherwise><fmt:formatNumber value="${project.guarantyDutyResSum}" pattern="###,###.######"/>万元</c:otherwise>
	                </c:choose></span>
                </h5> --%>
                <h5 class="col-sm-6">起始日期：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.loadBeginDate}">（空）</c:when>
				    	<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></c:otherwise>
				    </c:choose>
                </span></h5>
                <h5 class="col-sm-6">到期日期：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.loadEndDate }">（空）</c:when>
				    	<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadEndDate}"/></c:otherwise>
				    </c:choose>
                </span></h5>
               <%--  <h5 class="col-sm-6">借据起始日期：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.billBeginDate}">（空）</c:when>
				    	<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${project.billBeginDate}"/></c:otherwise>
				    </c:choose>
                </span></h5>
                <h5 class="col-sm-6">借据到期日期：<span class="grey">
                	<c:choose>
				    	<c:when test="${empty project.billEndDate }">（空）</c:when>
				    	<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${project.billEndDate}"/></c:otherwise>
				    </c:choose>
                </span></h5> --%>
			</div>
			
			<div class="col-sm-12 space-20"></div>
            <div>
				<h4 class="header smaller lighter blue">
					还款情况
					<c:if test="${type eq 'edit' }">
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_partialPayment">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">部分还款</span>
						</button>
					</c:if>
				</h4>
				<div class="col-sm-12">
					<div class="table-responsive">
						<table id="partialPayment_table" style="font-size:13px !important;"></table>  
					</div>
				</div>
			</div>
			
			<%--< div class="col-sm-12 space-20"></div>
			<div class = "compen_destory">
				<h4 class="header smaller lighter blue">
					代偿情况
					<c:if test="${type eq 'edit' }">
						<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_partialCompen">
							<i class="icon-edit bigger-110"></i>
							<span class="bigger-110 no-text-shadow">部分代偿</span>
						</button>
					</c:if>
				</h4>
				<div class="col-sm-12">
					<div class="table-responsive">
						<table id="partialCompen_table" style="font-size:13px !important;"></table>  
					</div>
				</div>
			</div>  --%>
     	</div>
    </div>
    <div id="dutyRemove_page"></div>
    <div id="compen_page"></div>
    <div id="compen_addPage"></div>
    <div id="payment_page"></div>
    <div id="payment_addPage"></div>
    <div id="payment_viewPage"></div>
</div>

<%-- <%@ include file="/common_foot.jsp" %>  --%>
<%@ include file="/common_message.jsp" %> 
<script src="<%=path %>/project/apply/dutyRemove/reimDetailInfo.js?v=<%=vardate%>"></script> 
