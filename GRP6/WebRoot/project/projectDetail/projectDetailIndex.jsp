<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<%-- <script src="<%=path %>/crm/client/companyClient/companyClientDetail.js?v=<%=vardate%>"></script> --%>
<div class="page-content">
	<!-- <input type="hidden" id="client_ID" value="" /> -->
	<input type="hidden" id="apply_ID" class="" value="${apply.apply_ID}" />
	<input type="hidden" id="project_ID" class="" value="${project.project_ID}" />
	
	
	<div class="col-xs-12"><!--begin 响应式列  -->
								<!-- PAGE CONTENT BEGINS -->
							        <!--这里放置右边的核心内容  -->
                                    <div class="tabbable tabs-right row">
										<ul class="nav nav-tabs col-sm-2 pull-right" id="myTab3">
											<li class="active">
												<a data-toggle="tab" href="#one" id="btn_projectBasicInfo">
													基本信息
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#two">
													调查报告
												</a>
											</li>
                                            <li>
												<a  data-toggle="tab" href="#three" id="btn_resolutionReview">
													评审决议
												</a>
											</li>
											 <li>
												<a data-toggle="tab" href="#four" id = "btn_contractInfo">
													合同信息
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#five" id = "btn_guarantyList" >
 													保证措施
												</a>
											</li>
										<!-- 	<li>
												<a data-toggle="tab" href="#six">
													收费情况
												</a>
											</li> -->
											<li>
												<a data-toggle="tab" href="#six" id="btn_loanInfo">
													放款信息
												</a>
											</li>
											<!-- <li>
												<a data-toggle="tab" href="#eight">
													保后检查
												</a>
											</li> -->
											<li>
												<a data-toggle="tab" href="#seven" id="btn_reimDetailInfo">
													还款记录
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#eight" id="btn_proDelayInfo">
													展期情况
												</a>
											</li>
											<li>
												<a data-toggle="tab" href="#nine" id="btn_overDueInfo">
													逾期情况
												</a>
											</li>
											<li >
												<a data-toggle="tab" href="#ten" id="btn_replaceAndReturnInfo">
													代偿与追偿
												</a>
											</li>
											<li >
												<a data-toggle="tab" href="#eleven" id="btn_replacePros">
													核销损失
												</a>
											</li>
											
											<!-- <li >
												<a data-toggle="tab" href="#twelve" id="btn_projectAppraisal">
													项目评价
												</a>
											</li> -->
										</ul><!-- /.col-sm-2 -->
										

										<div class="tab-content col-sm-9"   style="border:none;z-index:inherit;">
											<div id="one" class="tab-pane in active">
											</div>
											<div id="two" class="tab-pane ">
												调查报告
											</div>	
											<div id="three" class="tab-pane">
												<!-- 评审决议 -->
											</div> 
											<div id="four" class="tab-pane">
												<!-- 合同信息 -->
											</div> 
											<div id="five" class="tab-pane">
												<!-- 保证措施 -->
											</div> 
											<div id="six" class="tab-pane">
												<!-- 还款记录 -->
											</div> 
											<div id="seven" class="tab-pane">
												<!-- 还款记录-->
											</div> 
											<div id="eight" class="tab-pane">
												<!-- 展期情况-->
											</div> 
											<div id="nine" class="tab-pane">
												<!-- 逾期情况-->
											</div> 
											<div id="ten" class="tab-pane">
												<!-- 代偿与追偿-->
											</div> 
											<div id="eleven" class="tab-pane">
												<!-- 核销损失-->
											</div> 
											<!-- <div id="twelve" class="tab-pane">
												项目评价
											</div>  -->
										</div><!-- /.row -->

							</div><!-- /.col --><!--end 响应式列  -->
	</div>

</div>
<div id="projectDetailInfo_page"></div>
<script src="<%=path %>/project/projectDetail/projectDetailInfo.js?v=<%=vardate%>"></script>
