<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<table style="font-size:13px;text-align:center;" id="no" 
                                         data-toggle="table"                                                                             
                                         data-striped="true">
                     <thead>
                           <tr >
                                <th>年份</th>
                                <th>新增金额(万元)</th>
                                <th>无代偿解除(万元)</th>
                                <th>代偿解除(万元)</th>
                                <th>在保余额(万元) </th>
                           </tr>
                     </thead>
                     <tbody>
                        <c:forEach items="${sumLists}" var="sumList"  varStatus="status">  
					   		<tr>
						     <td>${sumList.analysisYears}年</td>
						     <td>
						     <c:if test="${sumList.loadSum eq null}">0</c:if>
						     <fmt:formatNumber value="${sumList.loadSum}" pattern="###,###.######"> </fmt:formatNumber>  </td>
						     <td>
						      <c:if test="${sumList.normalCapitalSum eq null}">0</c:if>
						     <fmt:formatNumber value="${sumList.normalCapitalSum}" pattern="###,###.######"> </fmt:formatNumber>  </td>
						     <td>			     
						      <c:if test="${sumList.replaceCapitalSum eq null}">0</c:if>
						     <fmt:formatNumber value="${sumList.replaceCapitalSum}" pattern="###,###.######"> </fmt:formatNumber>  </td>
						     <td>
						      <c:if test="${sumList.guarantySum eq null}">0</c:if>
						     <fmt:formatNumber value="${sumList.guarantySum}" pattern="###,###.######"> </fmt:formatNumber>  </td>
					   		 </tr> 
					   </c:forEach>  
                     </tbody>
</table> 