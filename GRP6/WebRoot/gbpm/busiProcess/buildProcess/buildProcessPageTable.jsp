<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<ul class="nav nav-tabs" id="myTab">
									<li class="active">
										<a data-toggle="tab" href="#processInstanceActive" >活动中的实例</a>
									</li>
									<li>
										<a data-toggle="tab" href="#processInstanceStop">已结束的实例</a>
									</li>
								</ul>
								<div class="tab-content">
									<div id="processInstanceActive" class="tab-pane in active">
										<div class="row">
		                                    <div class="col-sm-12">
												<div class="table-responsive"   id="loadinfo">
		                                            <table id="postActive-table" style="font-size:13px !important;"></table>
		                                        </div>
		                                    </div>
										</div>
									</div>
									<div id="processInstanceStop" class="tab-pane">
										<div class="row">
		                                    <div class="col-sm-12">
												<div class="table-responsive"   id="loadinfo">
		                                            <table id="postStop-table" style="font-size:13px !important;"></table>
		                                        </div>
		                                    </div>
										</div>
									</div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
<%@ include file="/common_foot.jsp" %>
	<script src="buildProcess.js?v=<%=vardate%>"></script>
