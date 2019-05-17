<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

<style>
    #titleStyle{
        color:;
        font-size: 9;
        font-family:'微软不雅黑','微软雅黑','黑体',sans-serif;
    }
</style>
<div class="page-content">   
      <div class="row">
		<div class="col-xs-12">
                   <h4 class="header smaller lighter blue">
						 项目信息
		  		   </h4>
			<div class="col-sm-12">
                 <h5 class="col-sm-12">项目名称：<span class="grey">${project.projectName}</span></h5>
                 <h5 class="col-sm-6">业务品种：<span class="grey">${project.busiTypeName}</span></h5>
                 <h5 class="col-sm-6">放款机构：<span class="grey">${project.bankName}</span></h5>
                 <h5 class="col-sm-6">项目金额：
                 <span class="grey"><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">在保余额：
                 <span class="grey"><fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">开始日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></span></h5>
                 <%-- <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadEndDate}"/></span></h5> --%>
                 <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.delayEndDate}"/></span></h5>
				<h5 class="col-sm-6">期限：<span class="grey">${project.periodMonthDay}</span></h5>
                 
			</div>
	         
      <div class="clearfix form-actions">
      
          <h4 class="header smaller lighter blue">
							 展期情况记录
				  </h4>
	      <table border="1" width="100%">
				  <tr id="titleStyle">
				  	<th style="text-align:center ;" data-field="9">序号</th>
				    <th style="text-align:center ;" data-field="9">展期金额</th>
				    <th style="text-align:center ;" data-field="9">期限</th>
				    <th style="text-align:center ;" data-field="9">展期起始日期</th>
				    <th style="text-align:center ;" data-field="9">展期到期日期</th>
				    <th style="text-align:center ;" data-field="9">展期担保费率</th>
				  </tr>
	      	<c:forEach items="${delayList}" var="delay" varStatus="loanStatus">
					  <tr>
					  	<td style="text-align:center ;">
					  		${ status.index + 1}
						</td>
					    <td style="text-align:center ;"><c:choose>
								<c:when test="${empty delay.delaySum || delaySum eq 0}">（空）</c:when>
								<c:otherwise><fmt:formatNumber value="${delay.delaySum}"/>万元</c:otherwise>
							</c:choose>
						</td>
					    <td style="text-align:center ;">
					    	${empty delay.delayMonthDay || delay.delayMonthDay eq "" ?"(空)":delay.delayMonthDay}
					    </td>
					    <td style="text-align:center ;"><c:choose>
								<c:when test="${empty delay.delayBeginDate}">（空）</c:when>
								<c:otherwise><fmt:formatDate value="${delay.delayBeginDate}" pattern="yyyy-MM-dd"/></c:otherwise>
						</c:choose>
						</td>
					    <td style="text-align:center ;"><c:choose>
								<c:when test="${empty delay.delayEndDate}">（空）</c:when>
								<c:otherwise><fmt:formatDate value="${delay.delayEndDate}" pattern="yyyy-MM-dd"/></c:otherwise>
							</c:choose>
						</td>
					    <td style="text-align:center ;"><c:choose>
								<c:when test="${empty delay.delayRate || delay.delayRate eq 0}">（空）</c:when>
								<c:otherwise><fmt:formatNumber value="${delay.delayRate}"  pattern="#0.00"/>％</c:otherwise>
							</c:choose>
						</td>
					  </tr>
			</c:forEach>
			<c:if test="${empty delayList}">
				<div class="widget-body" style="border:1px solid #ccc;">
				<div class="widget-main">
				<div class="row">
					<h5 style="line-height: 26px; color: gray;text-align: center;" >
						暂无数据！
					</h5>
				</div>
				</div>
				</div>
				</c:if>
			</table>
      </div>     
     </div>
    </div>
</div>
 <div id="projectDelay_page"/>

<%-- <%@ include file="/common_foot.jsp" %>
<%@ include file="/common_del.jsp" %> --%>