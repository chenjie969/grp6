<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>

    <link rel="stylesheet" href="/js/fixedTable.css">
    <script src="/js/fixedTable.js"></script>
    
	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
				<div class="page-header">
					<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addOnePersonClient" >新增个人</button>
					<!-- <button type="button" name="button" class="btn btn-sm btn-info" id="btn_projectDetaiil">业务明细</button> -->
					&nbsp;&nbsp;
					<button type="button" name="button" class="btn btn-sm btn-info" id="btn_deleteOfSelected" >删除所选</button>
					<button type="button" name="button" class="btn btn-sm btn-info" id="btn_hightSelect" >高级查询</button>
					<button type="button" name="button" class="btn btn-sm btn-info" id="btn_refresh" >重置列表</button>
					<button type="button" name="button" class="btn btn-sm btn-info" id="btn_synchro" >同步到项目</button>
					<div class="btn-group">
						<button data-toggle="dropdown" class="btn btn-sm dropdown-toggle btn-info" style="border-width:4px;">
							其它操作
							<span class="icon-caret-down icon-on-right"></span>
						</button>
	
						<ul class="dropdown-menu dropdown-default">
							<!-- <li>
								<a href="#">栏目定义</a>
							</li> -->
							<li>
								<a href="javascript:void(0)" id="btn_clientShare">授权共享人</a>
							</li>
						<!-- 	分类线条<li class="divider"></li> -->
							<li>
								<a href="javascript:void(0)" id="btn_returnBlackList" >转入黑名单</a>
							</li>
							<li>
								<a href="javascript:void(0)" id="btn_listSet">自定义列表栏目</a>
							</li>
							
						</ul>
					</div>
				</div>
                <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo">
						 <table id="personClient-table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
                
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
		<div  style="display:none" id="projectDetailPage">
			<%@ include file="/crm/client/projectDetail/projectDetail.jsp"%>
            <div id="p_backList" class="col-sm-12">
				<button class="btn btn-info" id="btn_p_backList"><i class="icon-chevron-left">返回</i></button>
			</div>
         </div>
		<div id="shareClient_page"></div>
		<!-- <div id="listSetColumns_page"></div> -->
	</div><!-- /.page-content -->
	<script type="text/javascript" src="<%=path %>/crm/client/clientShare/treeUser.js?v=<%=vardate%>"></script>
	<script type="text/javascript" src="<%=path %>/crm/client/personClient/personClient.js?v=<%=vardate%>"></script>
	<script type="text/javascript" src="<%=path %>/sys/listSet/listSetColumns.js?v=<%=vardate%>"></script>
	<%@ include file="/sys/listSet/listSetColumns.jsp" %>
	<%@ include file="/sys/listSet/listSet_warning.jsp" %>
	<%@ include file="/crm/client/personClient/personClientAdd.jsp" %>
	<%@ include file="/crm/client/personClient/personClientDel.jsp" %>
	<%@ include file="/crm/client/personClient/badClientAdd.jsp" %>	
	<%@ include file="/crm/client/personClient/hightSelectPersonClient.jsp" %>	
	<%@ include file="/crm/client/personClient/personClientSynchro.jsp" %>	
	<%@ include file="/crm/client/personClient/Sychrno.jsp" %>		
	<%@ include file="/common_message.jsp"%>
	
		<%@ include file="/crm/client/companyClient/syncSuccess.jsp"%>
	