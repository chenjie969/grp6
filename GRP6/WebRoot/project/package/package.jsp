<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>

	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
                <div class="tabbable">
                  	<ul class="nav nav-tabs" id="myTab">
                       <li class="active">
                           <a data-toggle="tab" href="#ok"  id="waitPackage">
                               	待打包项目
                           </a>
                       </li>

                       <li>
                           <a data-toggle="tab" href="#no"  id="alreadyPackage">
                            	已打包项目
                           </a>
                       </li>
                  	</ul>
        			<div class="tab-content">
	                      <div id="ok" class="tab-pane in active">
	                          <div class="page-header">
									<button class="btn btn-sm btn-info" id="btn_projectPackage">打包所选</button>
	                              	<button class="btn btn-sm btn-info" id="btn_delPackageBus">移出打包车</button>
	                             	&nbsp;&nbsp;
	                          </div>
								<div class="table-responsive"  id="loadinfo">
									 <table id="package-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
	                      <div id="no" class="tab-pane">
	                          	<div class="page-header">
									<button class="btn btn-sm btn-info" id="btn_delPackage">撤销打包</button>
	                              	<button class="btn btn-sm btn-info" id="btn_agreeProject">同意立项</button>
	                             <!-- 	<button class="btn btn-sm btn-info">不予立项</button> -->
	                          	</div>
	                          	<div class="table-responsive"  id="loadinfo">
									 <table id="packageEnd-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
                  </div>
              </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
		<div id="projectPackage_page"></div>
		<div id="nodeTaskModal_page"></div>
		
	</div><!-- /.page-content -->
	<script type="text/javascript" src="<%=path %>/project/package/package.js?v=<%=vardate%>"></script>
	<script type="text/javascript" src="<%=path %>/project/setNodeTask/nodeTaskModal.js?v=<%=vardate%>"></script>
	
	<%@ include file="/common_message.jsp"%>
	<%@ include file="/common_del.jsp"%>
	
	<%@ include file="/project/apply/selectProductModal.jsp" %><!-- 同意立项-选择流程页面 -->
	