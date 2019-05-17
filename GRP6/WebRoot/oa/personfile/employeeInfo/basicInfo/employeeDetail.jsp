<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
 <%@ include file="/common_foot.jsp" %>
<div class="page-content">
<input type="hidden" id="staffcase_Id" class="staffcase_Id" value="${hrstaffCase.staffcase_Id}" />
<input type="hidden" id="user_uid" name="user_uid" value="${hrstaffCase.user_uid}">
	<div class="col-xs-12"><!--begin 响应式列  -->
	<%@ include file="/oa/personfile/employeeInfo/basicInfo/employeeHead.jsp"%>
								<!-- PAGE CONTENT BEGINS -->
							        <!--这里放置右边的核心内容  -->
                                    <div class="tabbable tabs-right row">
										<ul class="nav nav-tabs col-sm-2 pull-right" id="myTab3">
											<li class="active">
												<a data-toggle="tab" href="#one"  id="basicInfo">
													基本情况
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#two" id="transfer">
 													岗位变动情况
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#three" id="education">
 													教育背景
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#four" id="resume">
 													工作简历
												</a>
											</li>
											<li>
											<a data-toggle="tab" href="#five" id="socialRelation">
 													社会关系
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#six" id="rewards">
 													奖惩记录
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#seven" id="jobStatus">
 													职务情况
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#eight" id="trainingRecord">
 													培训记录
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#nine" id="warrantyRecord">
 													担保记录
												</a>
											</li>
											     <li>
												<a data-toggle="tab" href="#ten" id="laborContract">
 													劳务合同
												</a>
											</li>
											     <li>
												<a data-toggle="tab" href="#eleven" id="socialInsurance">
 													社保缴纳
												</a>
											</li>
											     <li>
												<a data-toggle="tab" href="#twelve" id="medical">
 													体检记录
												</a>
											</li>
										</ul><!-- /.col-sm-2 -->
										<div class="tab-content col-sm-9"   style="border:none;">
												<div id="one" class="tab-pane in active">
                									<%@ include file="/oa/personfile/employeeInfo/basicInfo/basicInfo/index.jsp"%>
												</div>
												<div id="two" class="tab-pane">													
												</div>
												<div id="three" class="tab-pane">												 
												</div>	                                                   
                                                <div id="four" class="tab-pane">												
												</div>											
                                                <div id="five" class="tab-pane">                                               	
												</div>
                                                <div id="six" class="tab-pane">                                                   
                                                 
												</div>
                                            	<div id="seven" class="tab-pane">                                              
												</div>
                                                <div id="eight" class="tab-pane">                                           
											</div>
											 <div id="nine" class="tab-pane">                                               
            										
											</div>
											 <div id="ten" class="tab-pane">                                                   
            									<%-- <%@ include file="/oa/personfile/employeeInfo/basicInfo/laborContract/index.jsp" %>   --%>
											</div>
											 <div id="eleven" class="tab-pane">                                                   
            										<%--  <%@ include file="/oa/personfile/employeeInfo/basicInfo/socialInsurance/index.jsp" %>	 --%>
											</div>
											 <div id="twelve" class="tab-pane">                                                   
            										 <%-- <%@ include file="/oa/personfile/employeeInfo/basicInfo/medical/index.jsp" %>	 --%>
											</div>
										
										</div><!-- /.row -->

							</div><!-- /.col --><!--end 响应式列  -->
	</div>
</div>
<div id="manager_page"></div>
<div id="employeeUpdate_page"></div>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/basicInfo/update.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/transfer/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/resume/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/socialRelation/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/rewardsPunishment/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/jobStatus/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/trainingRecord/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/socialInsurance/index.js?v=<%=vardate%>"></script>
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/medical/index.js?v=<%=vardate%>"></script>   
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/warrantyRecord/index.js?v=<%=vardate%>"></script>   
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/educationBackground/index.js?v=<%=vardate%>"></script> 
<script type="text/javascript" src="<%=path %>/oa/personfile/employeeInfo/basicInfo/laborContract/index.js?v=<%=vardate%>"></script> 