<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<link href="<%=path %>/plugins/qtip/jquery.qtip.min.css?v=<%=vardate%>" rel="stylesheet" type="text/css" />
<%@ include file="/common_foot.jsp" %>
<div class="page-content"><!--begin页面内容  -->
						<div class="page-header"><!--begin页头部分 -->
						    	<h5>项目办理</h5>
						</div><!-- /.page-header end 页头部分-->

						<div class="row"><!--begin 响应式行  -->
							<div class="col-xs-12"><!--begin 响应式列  -->
								<!-- PAGE CONTENT BEGINS -->
							    <!--这里放置右边的核心内容  -->
								<div class="widget-main">
                                    <div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
                                        <ul class="wizard-steps" id="state">
                                            <li data-target="#step1" id="1" class="active">
                                                <span class="step">1</span>
                                                <span class="title">受理</span>
                                            </li>

                                            <li data-target="#step2" id="2"  class="">
                                                <span class="step">2</span>
                                                <span class="title">尽职调查</span>
                                            </li>

                                            <li data-target="#step3" id="3" class="">
                                                <span class="step">3</span>
                                                <span class="title">风险审核</span>
                                            </li>

                                            <li data-target="#step4" id="4">
                                                <span class="step">4</span>
                                                <span class="title">上会／审批</span>
                                            </li>
                                            <li data-target="#step5" id="5">
                                                <span class="step">5</span>
                                                <span class="title">签约</span>
                                            </li>
                                            <li data-target="#step6" id="6">
                                                <span class="step">6</span>
                                                <span class="title">放款</span>
                                            </li>
                                            <li data-target="#step7" id="7">
                                                <span class="step">7</span>
                                                <span class="title">放款复核</span>
                                            </li>
                                            <li data-target="#step8" id="8">
                                                <span class="step">8</span>
                                                <span class="title">保后监管</span>
                                            </li>
                                            <li data-target="#step9" id="9">
                                                <span class="step">9</span>
                                                <span class="title">逾期代偿</span>
                                            </li>
                                            <li data-target="#step10" id="10">
                                                <span class="step">10</span>
                                                <span class="title">追偿</span>
                                            </li>
											<li data-target="#step11" id="11">
                                                <span class="step">11</span>
                                                <span class="title">项目结案</span>
                                            </li>
                                        </ul>
                                        <hr>
                                        <div class="row">
                                            <h5 class="col-sm-3" id="projectBH">项目编号：<span class="grey">2017001</span></h5>
                                            <h5 class="col-sm-3" id="projectName">项目名称：<span class="grey">${entityName}</span></h5>
                                            <h5 class="col-sm-3 text-danger red">限办：5天（剩余1天）</h5>

                                        </div>
                                        <hr>
                                         <div class="row">
                                            <h5 class="col-sm-3"><b id="stateText">受理</b></h5>
                                        </div>
                                        <div class="col-sm-12">
											<div class="table-responsive"  id="loadinfo">
												 <table id="transact-table" style="font-size:13px !important;"></table>  
						                    </div>
						                </div>
						                 
                                    </div>

								</div><!-- end widget-main -->
							</div><!-- /.col --><!--end 响应式列  -->
						</div><!-- /.row --><!--end 响应式行  -->
						
						<div class="page-header">
		                 	<h5 class="">流程图</h5>
                        </div>
                        <div class="row">
			                <div class="col-sm-12">
								<img id="img_page" >
			                    </img>
			                    <div id="div_img_page" >
			                    </div>
			                </div>
		                </div>
					</div><!-- /.page-content --><!--end页面内容  -->
<div id="projTransact_page"></div>
<script src="<%=path %>/plugins/qtip/jquery.qtip.pack.js?v=<%=vardate%>"></script>



<script src="<%=path %>/gbpm/processTransact/projTransact.js?v=<%=vardate%>"></script>