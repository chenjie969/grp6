<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>" />
<style>
	table{
		font-size:14px;
		text-align:center;
	}
	table thead th{
		text-align:center;
	}
	.box-follow{
		width:150px;
	}
</style>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
						<div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                            <i class="iconfont icon-gongwen orange"></i>
                       	     待办审批
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-8">
							<table id="waitProjectTask-table" style="font-size: 13px !important;">
							</table>
                       		<div class="space-4"></div>
							<li class="clearfix">
                                <a href="javascript:void(0)" onclick="window.parent.openMenu('riskScheme','riskScheme','待办审批','/project/riskResponse/index/waitTaskPageTable.jsp','','0')"><span class="vbar orange pull-right">更多>></span></a>
                            </li>
                      </div><!-- /widget-main -->
                  </div><!-- /widget-body -->
              </div><!-- /widget-box -->
          </div>
          
			<div class="col-sm-6">
				<div class="widget-box transparent" id="recent-box">
					<div class="widget-header">
						<h4 class="lighter smaller">
							<i class="iconfont icon-oa orange"></i>
								最新工作进度
						</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main padding-8">
							<table id="table_newestRiskScheme" style="font-size: 13px !important;"></table>
							<div class="space-4"></div>
							<a href="javascript:void(0)" id="btn_viewMoreNewestRiskScheme"><span class="vbar orange pull-right">更多>></span></a>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
			</div>
			<div class="col-sm-12 hr hr32 hr-dotted"></div>
          <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                            <i class="icon-screenshot orange bigger-120"></i>
                            进度跟踪
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
                       		<div class="col-sm-12">
                               	<c:forEach items="${riskSchemeList}" var="riskScheme">
                                   	<div class="box-follow" onclick="window.parent.openMenu('${riskScheme.nodeID}','','${riskScheme.nodeNames}','/project/riskResponse/index/riskSchemeTable.jsp','&nodeID=${riskScheme.nodeID}','1')">
                           				<div style="font-size:15px;color:#337ab7 ">${riskScheme.riskSchemeNum}</div>
                           				<div>${riskScheme.nodeNames}</div>
                           			</div>
								</c:forEach>
                             </div>
                      </div><!-- /widget-main -->
                  </div><!-- /widget-body -->
              </div><!-- /widget-box -->
          </div>
          <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                            <i class="iconfont icon-notice orange bigger-120"></i>
                            	工作进度提醒
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
                        	<div class="box-follow btn_workReminder" data-classtype="harfMonth">
                				<div style="font-size:15px;color:#337ab7">${harfMonth }</div>
                				<div>半月未提交</div>
                			</div>
                			<div class="box-follow btn_workReminder" data-classtype="oneMonth">
                				<div style="font-size:15px;color:#337ab7">${oneMonth }</div>
                				<div>一月未提交</div>
                			</div>
                			<div class="box-follow btn_workReminder" data-classtype="twoMonth">
                				<div style="font-size:15px;color:#337ab7">${twoMonth }</div>
                				<div>两月以上未提交</div>
                			</div>
                      </div><!-- /widget-main -->
                  </div><!-- /widget-body -->
              </div><!-- /widget-box -->
          </div>
			<div class="space-8 col-sm-12"></div>
			 <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                       <span class ="currentYear"></span>
                            	<!-- 年担保压降额及预测 -->年担保在保余额按月份统计
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
							<!-- <img style="width:80%;margin-left:10%;" src="/assets/images/1.jpg"/> -->
                      	 <%--  <%@ include file="/project/analysis/analysisByYears4.jsp"%> --%>
                      	  <%@ include file="/project/riskResponse/index/guarantySumDrop.jsp"%>
                      	</div><!-- /widget-main -->
                  	 </div><!-- /widget-body -->
              	</div><!-- /widget-box -->
         	 </div> 
         	 <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                       <span class ="currentYear"></span>
                            	<!-- 年担保压降额及预测 -->年委贷委贷余额按月份统计
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
							<!-- <img style="width:80%;margin-left:10%;" src="/assets/images/1.jpg"/> -->
                      	 <%--  <%@ include file="/project/analysis/analysisByYears4.jsp"%> --%>
                      	  <%@ include file="/project/riskResponse/index/entrustGuarantySumDrop.jsp"%>
                      	</div><!-- /widget-main -->
                  	 </div><!-- /widget-body -->
              	</div><!-- /widget-box -->
         	 </div> 
         	 <%-- <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                         <span class ="currentYear"></span>
                            	年五级分类各担保余额压降比例
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
								  <%@ include file="/project/riskResponse/index/fiveClassification.jsp"%>
								  
							<!-- <img style="width:60%;margin-left:20%;" src="/assets/images/2.jpg"/>
                      	 -->
                      	</div><!-- /widget-main -->
                  	 </div><!-- /widget-body -->
              	</div><!-- /widget-box -->
         	 </div> --%>
         	 <div class="space-12 col-sm-12"></div>
         	 <%-- <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                         <span class ="currentYear"></span>   
                             	年担保集团各公司清收清欠占比
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
                         	<%@ include file="/project/riskResponse/index/eachCompany.jsp"%>
                         	
                         	<!-- <img style="width:50%;margin-left:25%;" src="/assets/images/3.jpg"/> -->
                      	</div><!-- /widget-main -->
                  	 </div><!-- /widget-body -->
              	</div><!-- /widget-box -->
         	 </div> --%>
         	 <%-- <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                       <span class ="currentYear"></span>
                            	年清收清欠类型占比
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
                         	<!-- <img style="width:60%;margin-left:20%;" src="/assets/images/4.jpg"/> -->
                         	<%@ include file="/project/riskResponse/index/costCompare.jsp"%>
                      	</div><!-- /widget-main -->
                  	 </div><!-- /widget-body -->
              	</div><!-- /widget-box -->
         	 </div>
         	 <div class="col-sm-12 hr hr32 hr-dotted"></div>
         	  --%>
<%-- 			<div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                            <i class="iconfont icon-gongwen orange"></i>
                       	     待办审批
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-8">
							<table id="waitProjectTask-table" style="font-size: 13px !important;">
							</table>
                       		<div class="space-4"></div>
							<li class="clearfix">
                                <a href="javascript:void(0)" onclick="window.parent.openMenu('riskScheme','riskScheme','待办审批','/project/riskResponse/index/waitTaskPageTable.jsp','','0')"><span class="vbar orange pull-right">更多>></span></a>
                            </li>
                      </div><!-- /widget-main -->
                  </div><!-- /widget-body -->
              </div><!-- /widget-box -->
          </div>
          
			<div class="col-sm-6">
				<div class="widget-box transparent" id="recent-box">
					<div class="widget-header">
						<h4 class="lighter smaller">
							<i class="iconfont icon-oa orange"></i>
								最新工作进度
						</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main padding-8">
							<table id="table_newestRiskScheme" style="font-size: 13px !important;"></table>
							<div class="space-4"></div>
							<a href="javascript:void(0)" id="btn_viewMoreNewestRiskScheme"><span class="vbar orange pull-right">更多>></span></a>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
			</div>
			<div class="col-sm-12 hr hr32 hr-dotted"></div>
          <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                            <i class="icon-screenshot orange bigger-120"></i>
                            进度跟踪
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
                       		<div class="col-sm-12">
                               	<c:forEach items="${riskSchemeList}" var="riskScheme">
                                   	<div class="box-follow" onclick="window.parent.openMenu('${riskScheme.nodeID}','','${riskScheme.nodeNames}','/project/riskResponse/index/riskSchemeTable.jsp','&nodeID=${riskScheme.nodeID}','1')">
                           				<div style="font-size:15px;color:#337ab7 ">${riskScheme.riskSchemeNum}</div>
                           				<div>${riskScheme.nodeNames}</div>
                           			</div>
								</c:forEach>
                             </div>
                      </div><!-- /widget-main -->
                  </div><!-- /widget-body -->
              </div><!-- /widget-box -->
          </div>
          <div class="col-sm-6">
             	<div class="widget-box transparent" id="recent-box">
                    <div class="widget-header">
                        <h4 class="lighter smaller">
                            <i class="iconfont icon-notice orange bigger-120"></i>
                            	工作进度提醒
                        </h4>
                     </div>
                     <div class="widget-body">
                         <div class="widget-main padding-4">
                        	<div class="box-follow btn_workReminder" data-classtype="harfMonth">
                				<div style="font-size:15px;color:#337ab7">${harfMonth }</div>
                				<div>半月未提交</div>
                			</div>
                			<div class="box-follow btn_workReminder" data-classtype="oneMonth">
                				<div style="font-size:15px;color:#337ab7">${oneMonth }</div>
                				<div>一月未提交</div>
                			</div>
                			<div class="box-follow btn_workReminder" data-classtype="twoMonth">
                				<div style="font-size:15px;color:#337ab7">${twoMonth }</div>
                				<div>两月以上未提交</div>
                			</div>
                      </div><!-- /widget-main -->
                  </div><!-- /widget-body -->
              </div><!-- /widget-box -->
          </div> --%>
		</div><!-- /.col-xs-12-->
	</div><!-- /.row -->
</div><!-- /.page-content -->
<div id="projectList_page"></div>
<div id="approvalRecord_page"></div>
<script type="text/javascript">
var myDate = new Date();  
  //获取当前年份(4位)  
$(".currentYear").text(myDate.getFullYear());
</script>
<script src="<%=path%>/project/riskResponse/keyProject/keyProject.js?v=<%=vardate%>"></script>
<script src="<%=path %>/project/analysis/analysis3.js?v=<%=vardate%>"></script>                      
<script src="<%=path %>/project/riskResponse/index/riskAnalysis.js?v=<%=vardate%>"></script>                      
