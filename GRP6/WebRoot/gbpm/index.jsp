<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>" />
<style>
	label{
		font-size:14px !important;
	}
</style>
		<div class="page-content"><!--begin页面内容  -->
						<input  type="hidden"   id="user_uid"  value="${sessionUser.user_uid}" name="user_uid"  />
						<div class="row"><!--begin 响应式行  -->
							<div class="col-xs-12"><!--begin 响应式列  -->

                                <div class="space-20"></div>

                                <div class="width-30" style="height:200px;background-color:#83ce76;float:left;margin-left:2.5%;">

                                    <div class="col-sm-3 no-padding-right">
                                        <div style="text-align:center;">
                                            <i class="iconfont icon-yue bigger-700 white" style="margin-top:50px;font-size:500%;"></i>
                                        </div>
                                        <p class="bigger-110 white" style="margin-top:15px;text-align:center;">本月发生</p>
                                    </div>
                                    <div class="col-sm-9 white  no-padding" style="margin-top:60px;">
                                     <label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('insertProjectByMonth','','本月新增项目','/project/index/insertProjectByMonth.jsp');">增加：</label>
                                     <label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('insertProjectByMonth','','本月新增项目','/project/index/insertProjectByMonth.jsp');"><fmt:formatNumber value="${monthIndex.loadSum}" pattern="###,###.######"/>&nbsp;万元<br>${monthIndex.loadNum}&nbsp;笔</label>
                                     <label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('guarantyProjectByMonth','','本月还款情况','/project/index/returnProjectByMonth.jsp');">减少：</label>
                                     <label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('guarantyProjectByMonth','','本月还款情况','/project/index/returnProjectByMonth.jsp');"><fmt:formatNumber value="${monthIndex.returnSum}" pattern="###,###.######"/>&nbsp;万元<br>${monthIndex.returnNum}&nbsp;笔</label>
                                    </div>

                                </div>
                                
                                <div class="width-30" style="height:200px;background-color:#ffaa25;float:left;margin-left:2.5%;">
                                    <div class="col-sm-3 no-padding-right">
                                        <div style="text-align:center;">
                                            <i class="iconfont icon-nian white" style="margin-top:50px;font-size:500%;"></i>
                                        </div>
                                        <p class="bigger-110 white" style="margin-top:15px;text-align:center;">本年发生</p>
                                    </div>

                                    <div class="col-sm-9 white  no-padding" style="margin-top:60px;">
                                      <label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('insertProjectByYear','','本年新增项目','/project/index/insertProjectByYear.jsp');">增加：</label>
                                      <label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('insertProjectByYear','','本年新增项目','/project/index/insertProjectByYear.jsp');"><fmt:formatNumber value="${yearIndex.loadSum}" pattern="###,###.######"/>&nbsp;万元<br>${yearIndex.loadNum}&nbsp;笔</label>
                                      <label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('returnProjectByYear','','本年还款情况','/project/index/returnProjectByYear.jsp');">减少：</label>
                                      <label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('returnProjectByYear','','本年还款情况','/project/index/returnProjectByYear.jsp');"><fmt:formatNumber value="${yearIndex.returnSum}" pattern="###,###.######"/>&nbsp;万元<br>${yearIndex.returnNum}&nbsp;笔</label>
                                    </div>

                                </div>
                                
                                <div class="width-30" style="height:200px;background-color:#6fb3e0;float:left;margin-left:2.5%;">

                                    <div class="col-sm-3 no-padding-right">
                                        <div style="text-align:center;">
                                            <i class="iconfont icon-heji bigger-700 white" style="margin-top:50px;font-size:500%;"></i>
                                        </div>
                                        <p class="bigger-110 white" style="margin-top:15px;text-align:center;">截止累计</p>
                                    </div>

                                    <div class="col-sm-9 white  no-padding" style="margin-top:34px;">
	                                   	<label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('insertProjectByTotal','','累计新增项目','/project/index/insertProjectByTotal.jsp');">增加：</label>
                                   	 	<label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('insertProjectByTotal','','累计新增项目','/project/index/insertProjectByTotal.jsp');"><fmt:formatNumber value="${totalIndex.loadSum}" pattern="###,###.######"/>&nbsp;万元<br>${totalIndex.loadNum}&nbsp;笔</label>
	                                    <label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('guarantyProjectByMonth','','累计还款情况','/project/index/returnProjectByMonth.jsp');">减少：</label>
                                     	<label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('returnProjectByTotal','','累计减少项目','/project/index/returnProjectByTotal.jsp');"><fmt:formatNumber value="${totalIndex.returnSum}" pattern="###,###.######"/>&nbsp;万元<br>${totalIndex.returnNum}&nbsp;笔</label>
	                                    <label class="col-sm-4 no-padding-right" style="text-align:right;cursor:pointer" onclick="window.parent.openMenu('guarantyProjectByMonth','','累计余额情况','/project/index/guarantyProjectByYear.jsp')">余额：</label>
                                     	<label class="col-sm-8 no-padding" style="cursor:pointer" onclick="window.parent.openMenu('guarantyProject','','累计余额情况','/project/index/guarantyProjectByYear.jsp');"><fmt:formatNumber value="${totalIndex.guarantySum}" pattern="###,###.######"/>&nbsp;万元<br>${totalIndex.guarantyNum}&nbsp;笔</label>
                                    
                                    </div>

                                </div>


                                <div class="col-sm-12 hr hr32 hr-dotted"></div>

                                <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="iconfont icon-gongwen orange"></i>
                                                业务流
                                            </h4>

                                            <div class="widget-toolbar no-border">
                                                <ul class="nav nav-tabs" id="recent-tab">
                                                    <li class="active">
                                                        <a data-toggle="tab" href="#one">待办业务</a>
                                                    </li>

                                                    <li>
                                                        <a data-toggle="tab" href="#two">待办审批</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-4">
                                                <div class="tab-content padding-8 overflow-visible">
                                                    <div id="one" class="tab-pane active">
														<table id="waitProjectTask-table" style="font-size: 13px !important;">
														</table>
                                                   		<div class="space-4"></div>
														<li class="clearfix">
                                                             <a href="javascript:void(0)" onclick="window.parent.openMenu('menuc69ce5891b6948c181c1c8fff329b9c9','menu5539d41c2bda473e918397fd3940fee3','待办业务','/gbpm/product/waitTask/waitTaskPageTable.jsp','','0')"><span class="vbar orange pull-right">更多>></span></a>
                                                        </li>
                                                    </div>
                                                    <div id="two" class="tab-pane">
                                                   		<table id="waitTaskApprove-table" style="font-size: 13px !important;">
														</table>
                                                   		<div class="space-4"></div>
														<li class="clearfix">
                                                             <a href="javascript:void(0)" onclick="window.parent.openMenu('gworkFlow8a106be913a4a39ad3c48946509ea16','menu2c14b0491e854b17b78cf5696f60662b','待办审批','gworkFlow/waitTask/waitTaskPageTable.jsp','','1')"><span class="vbar orange pull-right">更多>></span></a>
                                                        </li>
                                                    </div><!-- member-tab -->
                                                </div>
                                            </div><!-- /widget-main -->
                                        </div><!-- /widget-body -->
                                    </div><!-- /widget-box -->
                                </div><!-- /span -->

                                <!-- <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="iconfont icon-gongwen orange"></i>
                                                业务审批流
                                            </h4>

                                            <div class="widget-toolbar no-border">
                                                <ul class="nav nav-tabs" id="recent-tab">
                                                    <li class="active">
                                                        <a data-toggle="tab" href="#three">待办任务</a>
                                                    </li>

                                                    <li>
                                                        <a data-toggle="tab" href="#four">已办任务</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-4">
                                                <div class="tab-content padding-8 overflow-visible">
                                                    <div id="three" class="tab-pane active">
														
                                                    </div>
                                                    <div id="four" class="tab-pane">
                                                   		<table id="finishTaskApprove-table" style="font-size: 13px !important;">
														</table>
                                                   		<div class="space-4"></div>
														<li class="clearfix">
                                                            <a href="javascript:void(0)" onclick="window.parent.openMenu('menu88a3eaf79ba04e0fbddc9b645728620a','menu2c14b0491e854b17b78cf5696f60662b','已办审批','gbpm/busiProcess/finishTask/finishTaskPageTable.jsp','','1')"><span class="vbar orange pull-right">更多>></span></a>
                                                        </li>
                                                    </div>member-tab
                                                </div>
                                            </div>/widget-main
                                        </div>/widget-body
                                    </div>/widget-box
                                    
                                </div> --><!-- /span -->

                                <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="iconfont icon-oa orange"></i>
                                                OA工作流
                                            </h4>

                                            <div class="widget-toolbar no-border">
                                                <ul class="nav nav-tabs" id="recent-tab">
                                                    <li class="active">
                                                        <a data-toggle="tab" href="#five">待办任务</a>
                                                    </li>

                                                    <li>
                                                        <a data-toggle="tab" href="#six">已办任务</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-4">
                                                <div class="tab-content padding-8 overflow-visible">
                                                    <div id="five" class="tab-pane active">
															<table id="waitTaskOA-table" style="font-size: 13px !important;">
															</table>
                                                       		<div class="space-4"></div>
															<li class="clearfix">
                                                                <a href="javascript:void(0)" onclick="" ><span class="vbar orange pull-right">更多>></span></a>
                                                            </li>
                                                    </div>
                                                    <div id="six" class="tab-pane">
                                                   		<table id="finishTaskOA-table" style="font-size: 13px !important;">
														</table>
                                                   		<div class="space-4"></div>
														<li class="clearfix">
                                                            <a href="javascript:void(0)" onclick="" ><span class="vbar orange pull-right">更多>></span></a>
                                                        </li>
                                                    </div><!-- member-tab -->
                                                </div>
                                            </div><!-- /widget-main -->
                                        </div><!-- /widget-body -->
                                    </div><!-- /widget-box -->
                                    
                                </div><!-- /span -->
                                <div class="col-sm-12 hr hr16 hr-dotted"></div>
                                <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="icon-eye-open orange "></i>
                                                项目监控
                                            </h4>

                                            <div class="widget-toolbar no-border">
                                                <ul class="nav nav-tabs" id="recent-tab">
                                                    <li class="active">
                                                        <a data-toggle="tab" href="#seven">预警与提醒</a>
                                                    </li>

                                                    <li>
                                                        <a data-toggle="tab" href="#projectDynamic">项目动态</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-4">
                                                <div class="tab-content padding-8 overflow-visible">
                                                    <div id="seven" class="tab-pane active">
                                                    	<div class="col-sm-12">
                                                    			
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-success btn-xs" style="height:60px;" onclick="window.parent.openMenu('meetingPro','meetingPro','即将上会','/project/index/myEvaluItems.jsp','','0')">
                                                    					<i class="icon-legal icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.meetingPro}</span>
                                                    					<%-- <c:if test="${indexData.meetingPro!=0}"><span class="badge badge-danger white">${indexData.meetingPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 class="row" style="text-align:center;">即将上会</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-yellow btn-xs" style="height:60px;" onclick="window.parent.openMenu('noExpireProject','','未到期项目','/project/index/noExpireProject.jsp');">
                                                    					<i class="icon-umbrella icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.noExpirePro}</span>
                                                    					<%-- <c:if test="${indexData.meetingPro!=0}"><span class="badge badge-danger white">${indexData.meetingPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 class="row" style="text-align:center;">未到期项目</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-primary btn-xs" style="height:60px;" onclick="window.parent.openMenu('expireProject','','即将到期项目','/project/index/expireProject.jsp');">
                                                    					<i class="icon-calendar icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.expirePro}</span>
                                                    					<%-- <c:if test="${indexData.expirePro!=0}"><span class="badge badge-danger white">${indexData.expirePro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 style="text-align:center;">即将到期</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-purple btn-xs" style="height:60px;" onclick="window.parent.openMenu('extendProject','','展期项目','/project/index/extendProject.jsp');">
                                                    					<i class="icon-unlink icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.extendPro}</span>
                                                    					<%-- <c:if test="${indexData.meetingPro!=0}"><span class="badge badge-danger white">${indexData.meetingPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 class="row" style="text-align:center;">展期项目</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-warning btn-xs" style="height:60px;" onclick="window.parent.openMenu('overProject','','逾期项目','/project/index/overProject.jsp');">
                                                    					<i class="icon-calendar-empty icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.overPro}</span>
                                                    					<%-- <c:if test="${indexData.overPro!=0}"><span class="badge badge-danger white">${indexData.overPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 class="row" style="text-align:center;">逾期不代偿</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-xs" style="height:60px;" onclick="window.parent.openMenu('replaceProject','','代偿项目','/project/index/replaceProject.jsp');">
                                                    					<i class="icon-tags icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.replacePro}</span>
                                                    					<%-- <c:if test="${indexData.replacePro!=0}"><span class="badge badge-danger white">${indexData.replacePro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 style="text-align:center;">逾期代偿</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-light btn-xs" style="height:60px;" onclick="window.parent.openMenu('endProject','','终止项目','/project/index/endProject.jsp');">
                                                    					<i class="icon-power-off icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.endPro}</span>
                                                    					<%-- <c:if test="${indexData.meetingPro!=0}"><span class="badge badge-danger white">${indexData.meetingPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 class="row" style="text-align:center;">终止项目</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-info btn-xs" style="height:60px;" onclick="window.parent.openMenu('checkProject','','保后检查项目','/project/index/checkProject.jsp');">
                                                    					<i class="icon-wrench icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.checkPro}</span>
                                                    					<%-- <c:if test="${indexData.checkPro!=0}"><span class="badge badge-danger white">${indexData.checkPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 style="text-align:center;">保后检查</h5>
                                                    			</div>
                                                    			<div class="box-camera">
                                                    				<a href="#" class="btn btn-app btn-pink btn-xs" style="height:60px;" onclick="window.parent.openMenu('riskProject','','风险项目','/project/index/riskProject.jsp');">
                                                    					<i class="icon-lightbulb icon"></i>
                                                    					<span class="badge badge-danger white">${indexData.riskPro}</span>
                                                    					<%-- <c:if test="${indexData.riskPro!=0}"><span class="badge badge-danger white">${indexData.riskPro}</span></c:if> --%>
                                                    				</a>
                                                    				<h5 style="text-align:center;">风险项目</h5>
                                                    			</div>
                                                   			</div>
                                                   		</div>
                                              			<div id="projectDynamic" class="tab-pane">
	                                           		 		<ul  class="item-list">
																<c:forEach items="${proMessageList}" var="proMessage">
		                                                      		<li class="item-orange clearfix proMessage" id="${proMessage.apply_ID}">
		                                                              <label class="inline">
		                                                              	<a href="#" class="blue " >
		                                                                  	<span class="lbl">${proMessage.projectName}</span>
	                                                                 	</a>
		                                                              </label>
		
		                                                              <label class="inline pull-right" style="margin-right:6%;">
	                                                             		<a href="#">
	                                                                  		<span class="lbl badge badge-danger">${proMessage.messageNumber}</span>
	                                                                  	</a>
		                                                              </label>
		                                                          </li>
		                                                          <hr class="hr2">
																</c:forEach>
			                                                    <li class="clearfix">
			                                                       	<a href="javascript:void(0)" onclick="window.parent.openMenu('menu93fb8b6af0614bef9d2bef3b07418df0','menu5afe4feb86e1488b9794c64f5afbe192','业务跟踪','/project/apply/projectBeforeTracking/projectBeforeTracking.jsp','','1')"><span class="vbar orange pull-right">更多>></span></a>
			                                                    </li>
			                                                </ul>
	                                                    </div><!-- member-tab -->
                                                    </div>
                                            </div><!-- /widget-main -->
                                        </div><!-- /widget-body -->
                                    </div><!-- /widget-box -->
                                    
                                </div><!-- /span -->
                                
                                <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="icon-screenshot orange bigger-110"></i>
                                                进度跟踪
                                            </h4>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-12">
                                               <div class="col-sm-12">
                                               		<c:forEach items="${applyList}" var="apply">
                                                       	<div class="box-follow" onclick="window.parent.openMenu('${apply.projectStageID}','','${apply.projectStageName}','/project/apply/projectBeforeTracking/projectBeforeTracking.jsp','&projectStageID=${apply.projectStageID}','1')">
                                               				<div style="font-size:15px;color:#337ab7 ">${apply.applyNum}</div>
                                               				<div>${apply.projectStageName}</div>
                                               			</div>
													</c:forEach>
                                              	</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

								<div class="col-sm-12 hr hr16 hr-dotted"></div>
                                <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="iconfont icon-notice orange" style="font-size:120%;"></i>
                                                公司通知
                                            </h4>
                                            <div class="widget-toolbar no-border">
                                                <ul class="nav nav-tabs" id="recent-tab">
                                                    <li class="active">
                                                        <a data-toggle="tab" href="#companyInform">公司通知</a>
                                                    </li>

                                                    <li>
                                                        <a data-toggle="tab" href="#companyPublic">公司公示</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-4">
                                                <div class="tab-content padding-8 overflow-visible">
                                                    <div id="companyInform" class="tab-pane active">

                                                        <ul  class="item-list">
                                                        	<c:forEach items="${informList}" var="message">
	                                                        	<li class="item-orange clearfix">
	                                                                <label class="inline">
	                                                                	<a href="#" class="blue messageView" id="${message.messageId}">
	                                                                    	<span class="lbl">${message.title}</span>
	                                                                    </a>
	                                                                </label>
	                                                                <div class="pull-right action-buttons">
	                                                                    <a href="#" class="blue messageView" id="${message.messageId}">
	                                                                        <i class="icon-zoom-in orange bigger-130"></i>
	                                                                    </a>
	                                                                    <span class="vbar"></span>
	                                                                </div>
	                                                                <label class="inline pull-right" style="margin-right:6%;">
	                                                                    <span class="lbl"><fmt:formatDate value="${message.updateDateTime}" pattern="yyyy-MM-dd"/></span>
	                                                                </label>
	                                                            </li>
	                                                            <hr class="hr2">
															</c:forEach>

                                                            <li class="clearfix">
                                                                <a href="javascript:void(0)" onclick="window.parent.openMenu('menu56e2ec70d9a443c58a0b1b98112d1dae','','我的信息','/oa/announce/myAnnounceTable','','0')"><span class="vbar orange pull-right">更多>></span></a>
                                                            </li>
                                                        </ul>

                                                    </div>

                                                    <div id="companyPublic" class="tab-pane">
                                                        <ul  class="item-list">
															<c:forEach items="${publicityList}" var="message">
	                                                        	<li class="item-orange clearfix">
	                                                                <label class="inline">
	                                                                	<a href="#" class="blue messageView" id="${message.messageId}">
	                                                                    	<span class="lbl">${message.title}</span>
                                                                    	</a>
	                                                                </label>
									
	                                                                <div class="pull-right action-buttons">
	                                                                    <a href="#" class="blue messageView" id="${message.messageId}">
	                                                                        <i class="icon-zoom-in orange bigger-130"></i>
	                                                                    </a>
	
	                                                                    <span class="vbar"></span>
	                                                                </div>
	
	                                                                <label class="inline pull-right" style="margin-right:6%;">
	                                                                    <span class="lbl"><fmt:formatDate value="${message.updateDateTime}" pattern="yyyy-MM-dd"/></span>
	                                                                </label>
	
	                                                            </li>
	                                                            <hr class="hr2">
															</c:forEach>
															
                                                            <li class="clearfix">
                                                               	<a href="javascript:void(0)" onclick="window.parent.openMenu('menu56e2ec70d9a443c58a0b1b98112d1dae','','我的信息','/oa/announce/myAnnounceTable','','0')"><span class="vbar orange pull-right">更多>></span></a>
                                                            </li>
                                                        </ul>
                                                    </div><!-- member-tab -->

                                                </div>
                                            </div><!-- /widget-main -->
                                        </div><!-- /widget-body -->
                                    </div><!-- /widget-box -->
                                </div><!-- /span -->

                                <div class="col-sm-6">
                                    <div class="widget-box transparent" id="recent-box">
                                        <div class="widget-header">
                                            <h4 class="lighter smaller">
                                                <i class="iconfont icon-xinxi orange" style="font-size:120%;"></i>
                                                信息中心
                                            </h4>
                                            <div class="widget-toolbar no-border">
                                                <ul class="nav nav-tabs" id="recent-tab">
                                                	<c:forEach items="${messageList}" var="message" varStatus="status">
	                                                	<li <c:if test="${status.first}">class="active"</c:if>>
	                                                        <a data-toggle="tab" href="#${message.id}">${message.name}</a>
	                                                    </li>
                                                	</c:forEach>
                                                </ul>
                                            </div>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main padding-4">
                                                <div class="tab-content padding-8 overflow-visible">
                                                	<c:forEach items="${messageList}" var="message" varStatus="status">
	                                                	<div id="${message.id}" class="tab-pane 
	                                                		<c:if test="${status.first}">
															   active
															</c:if>
															" >
	                                                        <ul  class="item-list">
	                                                            <c:forEach items="${indexData.messageMap[message.id]}" var="message">
		                                                        	<li class="item-orange clearfix">
		                                                                <label class="inline">
		                                                                	<a href="#" class="blue messageView" id="${message.messageId}">
		                                                                   		<span class="lbl">${message.title}</span>
	                                                                   		</a>
		                                                                </label>
										
		                                                                <div class="pull-right action-buttons">
		                                                                    <a href="#" class="blue messageView" id="${message.messageId}">
		                                                                        <i class="icon-zoom-in orange bigger-130"></i>
		                                                                    </a>
		
		                                                                    <span class="vbar"></span>
		                                                                </div>
		
		                                                                <label class="inline pull-right" style="margin-right:6%;">
		                                                                    <span class="lbl"><fmt:formatDate value="${message.updateDateTime}" pattern="yyyy-MM-dd"/></span>
		                                                                </label>
		
		                                                            </li>
		                                                            <hr class="hr2">
																</c:forEach>
																
	
	                                                            <li class="clearfix">
	                                                                <a href="javascript:void(0)" onclick="window.parent.openMenu('menu56e2ec70d9a443c58a0b1b98112d1dae','','我的信息','/oa/announce/myAnnounceTable','','0')"><span class="vbar orange pull-right">更多>></span></a>
	                                                            </li>
	                                                        </ul>
	
	                                                    </div>
                                                	</c:forEach>
                                                    </div><!-- member-tab -->
                                                </div>
                                            </div><!-- /widget-main -->
                                        </div><!-- /widget-body -->
                                    </div><!-- /widget-box -->
                                </div><!-- /span -->
                                <!-- PAGE CONTENT BEGINS -->


							</div><!-- /.col --><!--end 响应式列  -->
						</div><!-- /.row --><!--end 响应式行  -->
						<div id="info_page"></div>
<script src="<%=path %>/gbpm/index.js?v=<%=vardate%>>"></script>