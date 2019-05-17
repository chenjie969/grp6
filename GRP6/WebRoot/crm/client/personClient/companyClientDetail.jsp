<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<!-- <input type="hidden" id="client_ID" value="" /> -->
	<input type="hidden" id="client_ID" class="client_ID" value="" />
	<div class="col-xs-12"><!--begin 响应式列  -->
								<!-- PAGE CONTENT BEGINS -->
							        <!--这里放置右边的核心内容  -->
                                    <div class="tabbable tabs-right row">
										<ul class="nav nav-tabs col-sm-2 pull-right" id="myTab3">
											<li class="active">
												<a data-toggle="tab" href="#one">
													企业基本情况
												</a>
											</li>

											<li>
												<a data-toggle="tab" href="#two" id="mangerInfo">
 													股东背景及主要管理人员
												</a>
											</li>

											<li>
												<a data-toggle="tab" href="#three">
													企业财务状况
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#four">
													企业发展沿革
												</a>
											</li>
                                            <li>
												<a class="btn_relationClient" data-toggle="tab" href="#five">
													<span >关联企业</span>
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#six">
													信用信息及银企往来情况
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#seven">
													图片附件
												</a>
											</li>
                                            <li>
												<a data-toggle="tab" href="#eight">
													文档附件
												</a>
											</li>
										</ul><!-- /.col-sm-2 -->

										<div class="tab-content col-sm-9"   style="border:none;">
												<div id="one" class="tab-pane in active">
                									<%@ include file="/crm/client/companyClient/clientBasicInfo.jsp"%>
												</div>
												<div id="two" class="tab-pane">
                                                    <h4 class="header smaller lighter blue">
            											股权信息
            											<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="stockAdd"> 
            												<i class="icon-edit bigger-110"></i>
            												<span class="bigger-110 no-text-shadow">添加</span>
            											</button>
            										</h4>
													<div class="table-responsive"   id="stockMessageList">
														<table id="stockMessage-table" style="font-size:13px !important;"></table>
									                </div>
                                                    <br>
                                                    <div class="row" style="margin:0;">
		           											<span class="ztb_view_managerinfoId" style="display: none;"></span> <%-- 股东主要管理人员信息 id --%>
		           											<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="history">
		           												<i class="icon-edit bigger-110"></i>
		           												<span class="bigger-110 no-text-shadow">修改</span>
		           											</button>
	                                                        <blockquote class="pull-left">
	                                                            <h4 class="header smaller lighter blue">股权结构历史沿革：</h4>
	                                                            <small style="font-size:13px;" id="stockStructure" class="ztb_view_stockstructure  validate[required,maxSize[2000]]">
	                                                            </small>
	                                                        </blockquote>
                                                    </div>

            										<br>
                                                    <h4 class="header smaller lighter blue">
            											股东背景及主要管理人员分析
            											<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="mainManager">
            												<i class="icon-edit bigger-110"></i>
            												<span class="bigger-110 no-text-shadow">修改</span>
            											</button>
            										</h4>
                                                    <br>
                                                    <div class="row" style="margin:0;">
                                                        <div class="col-xs-12">
                                                            <blockquote class="pull-left">
                                                                <h5 class="smaller">法定代表人及其配偶情况：</h5>

                                                                <small style="font-size:13px;" class="ztb_view_legalpersoninfo  validate[required,maxSize[2000]]">
                                                                </small>
                                                            </blockquote>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row" style="margin:0;">
                                                        <div class="col-xs-12">
                                                            <blockquote class="pull-left">
                                                                <h5 class="smaller">实际控制人及其配偶情况（包含从业经历）：</h5>

                                                                <small style="font-size:13px;" class="ztb_view_controlpersoninfo  validate[required,maxSize[2000]]">
                                                                </small>
                                                            </blockquote>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row" style="margin:0;">
                                                        <div class="col-xs-12">
                                                            <blockquote class="pull-left">
                                                                <h5 class="smaller">其他股东情况：</h5>

                                                                <small style="font-size:13px;" class="ztb_view_otherstockinfo  validate[required,maxSize[2000]]">
                                                                </small>
                                                            </blockquote>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row" style="margin:0;">
                                                        <div class="col-xs-12">
                                                            <blockquote class="pull-left">
                                                                <h5 class="smaller">公司主要高管人员情况：</h5>

                                                                <small style="font-size:13px;" class="ztb_view_managerinfo  validate[required,maxSize[2000]]">
                                                                </small>
                                                            </blockquote>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row" style="margin:0;">
                                                        <div class="col-xs-12">
                                                            <blockquote class="pull-left">
                                                                <h5 class="smaller">公司员工概况：</h5>

                                                                <small style="font-size:13px;" class="ztb_view_employeeinfo  validate[required,maxSize[2000]]">
                                                                </small>
                                                            </blockquote>
                                                        </div>
                                                    </div>
												</div>

												<div id="three" class="tab-pane">
                                                    <div class="tabbable">
            											<ul class="nav nav-tabs" id="myTab">
            												<li class="active">
            													<a data-toggle="tab" href="#balance">
            														资产负债表
            													</a>
            												</li>

            												<li>
            													<a data-toggle="tab" href="#income">
            														损益表
            													</a>
            												</li>
                                                            <li>
            													<a data-toggle="tab" href="#cash-flow">
            														现金流表
            													</a>
            												</li>
                                                            <li>
            													<a data-toggle="tab" href="#finance">
            														主要财务指标分析
            													</a>
            												</li>
                                                            <li>
            													<a data-toggle="tab" href="#property">
            														主要资产情况分析
            													</a>
            												</li>
                                                            <li>
            													<a data-toggle="tab" href="#liabilities">
            														主要负债情况分析
            													</a>
            												</li>
                                                            <li>
            													<a data-toggle="tab" href="#profit">
            														收入利润情况分析
            													</a>
            												</li>

            											</ul>

            											<div class="tab-content">
            												<div id="balance" class="tab-pane in active">
                                                                <div class="table-responsive"   id="assetDebtList">
									                			</div>
            												</div>
            												<div id="income" class="tab-pane">
            												</div>
            												<div id="cash-flow" class="tab-pane">
            												</div>
            												<div id="finance" class="tab-pane">
            												</div>
            												<div id="property" class="tab-pane">
            												</div>
            												<div id="liabilities" class="tab-pane">
            												</div>
            												<div id="profit" class="tab-pane">
            												</div>
            											</div>
            										</div>
												</div>
                                                <div id="four" class="tab-pane">
													<%@ include file="/crm/client/companyClient/developEvolution.jsp"%>
												</div>
                                                <div id="five" class="tab-pane">
                                                    <%@ include file="/crm/client/relationClient/relationClient.jsp"%>
												</div>
                                                <div id="six" class="tab-pane">
                                                    <%@ include file="/crm/client/creditInfo/creditInfo.jsp"%>
												</div>
                                                <div id="seven" class="tab-pane">
                                                    <div class="row-fluid">
                    									<ul class="ace-thumbnails">
                    										<li>
                    											<a href="../../../assets/images/gallery/image-1.jpg" title="Photo Title" data-rel="colorbox">
                    												<img alt="150x150" src="../../../assets/images/gallery/thumb-1.jpg" />
                    												<div class="tags">
                    													<span class="label-holder">
                    														<span class="label label-info">breakfast</span>
                    													</span>

                    													<span class="label-holder">
                    														<span class="label label-danger">fruits</span>
                    													</span>

                    													<span class="label-holder">
                    														<span class="label label-success">toast</span>
                    													</span>

                    													<span class="label-holder">
                    														<span class="label label-warning arrowed-in">diet</span>
                    													</span>
                    												</div>
                    											</a>

                    											<div class="tools">
                    												<a href="#">
                    													<i class="icon-link"></i>
                    												</a>

                    												<a href="#">
                    													<i class="icon-paper-clip"></i>
                    												</a>

                    												<a href="#">
                    													<i class="icon-pencil"></i>
                    												</a>

                    												<a href="#">
                    													<i class="icon-remove red"></i>
                    												</a>
                    											</div>
                    										</li>
                    									</ul>
                    								</div>
												</div>
                                                <div id="eight" class="tab-pane">
                                                    <h4 class="header smaller lighter blue">
            											附件
            											<button type="button" name="button" class="btn btn-minier btn-warning pull-right">
            												<i class="icon-edit bigger-110"></i>
            												<span class="bigger-110 no-text-shadow">添加</span>
            											</button>
            										</h4>
											</div><!-- /.col-sm-10 -->
										</div><!-- /.row -->

							</div><!-- /.col --><!--end 响应式列  -->
</div>

<script src="<%=path %>/crm/client/companyClient/companyClientDetail.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/stockMessage/stockMessage.js?v=<%=vardate%>"></script><%--股权信息 js --%>
<script type="text/javascript">
	$(function(){
		var client_ID = tool.getUrlParam('client_ID');
		$('#client_ID').val(client_ID);
	});
</script>