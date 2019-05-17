<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<table style="font-size:13px;text-align:center;" id="no" 
                                         data-toggle="table"                                                                             
                                         data-striped="true">
                     <thead>
                           <tr >
                                <th>月份</th>
                                <th>新增金额(万元)</th>
                                <th>无代偿解除(万元)</th>
                                <th>代偿解除(万元)</th>
                                <th>在保余额(万元) </th>
                           </tr>
                     </thead>
                     <tbody>
                        <c:forEach items="${sumLists}" var="sumList"  varStatus="status">  
					   		<tr>  
						     <td>${status.index+1}月</td>  
						     <c:forEach items="${sumList}" var="sumValue"  varStatus="statusSumList">  
							     <td>
							     <fmt:formatNumber value="${sumValue}" pattern="###,###.######"> </fmt:formatNumber>
							     </td>  
							     
						     </c:forEach>
					   		 </tr>  
					   </c:forEach>  
                     </tbody>
</table> 