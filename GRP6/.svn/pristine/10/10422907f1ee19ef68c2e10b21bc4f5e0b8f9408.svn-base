<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <table style="font-size:13px;text-align:center;" id="no" 
                                         data-toggle="table"                                                                             
                                         data-striped="true">
                                      <thead>
                                        <tr >
                                            <th>年份</th>
                                            <th>新增笔数(笔)</th>
                                            <th>无代偿解除笔数(笔)</th>
                                            <th>代偿解除笔数(笔)</th>
                                            <th>在保笔数(笔)</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${countLists}" var="countList"  varStatus="status">  
									   		 <tr>  
											     <td>${countList.analysisYears}年</td>  
											     <td>
												       <c:if test="${countList.projCount eq null}">0</c:if>
												       ${countList.projCount}
											     </td>
											      <td>
												       <c:if test="${countList.normolCount eq null}">0</c:if>
												       ${countList.normolCount}
											     </td>
											      <td>
												       <c:if test="${countList.replaceCount eq null}">0</c:if>
												       ${countList.replaceCount}
											     </td>
											     <td>
												       <c:if test="${countList.guarantyCount eq null}">0</c:if>
												       ${countList.guarantyCount}
											     </td>
									   		 </tr>  
					   				</c:forEach>  
                                     
                                   </tbody>
                </table> <!-- end table -->


			 
