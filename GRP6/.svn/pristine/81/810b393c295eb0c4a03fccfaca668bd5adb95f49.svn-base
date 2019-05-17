<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <table style="font-size:13px;text-align:center;" id="no" 
                                         data-toggle="table"                                                                             
                                         data-striped="true">
                                      <thead>
                                        <tr >
                                            <th>月份</th>
                                            <th>新增笔数(笔)</th>
                                            <th>无代偿解除笔数(笔)</th>
                                            <th>代偿解除笔数(笔)</th>
                                            <th>在保笔数(笔) </th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${countLists}" var="countList"  varStatus="status">  
									   		 <tr>  
											     <td>${status.index+1}月</td>  
											     <c:forEach items="${countList}" var="countValue"  varStatus="statusSumList">  
												     <td>${countValue}</td>  
											     </c:forEach>
									   		 </tr>  
					   				</c:forEach>  
                                     
                                   </tbody>
                </table> <!-- end table -->


			 
