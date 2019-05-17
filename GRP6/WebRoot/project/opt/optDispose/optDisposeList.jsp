<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<style>
	.table th, .table td {
	vertical-align: middle!important;
}
</style>
	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
                <div class="tabbable">
                  	<ul class="nav nav-tabs" id="myTab">
                       <li class="active">
                           <a data-toggle="tab" href="#ok" id="relieveList">
                               	已解除
                           </a>
                       </li>

                       <li>
                           <a data-toggle="tab" href="#no" id="disposeList">
                            	已处置
                           </a>
                       </li>
                  	</ul>
        			<div class="tab-content">
	                      <div id="ok" class="tab-pane in active">
	                          <div class="page-header">
									<button class="btn btn-sm btn-info" id="btn_release">撤销解除</button>
	                              	<button class="btn btn-sm btn-info" id="btn_hightSelectOpt">高级查询</button>
	                              	<button class="btn btn-sm btn-info btn_refresh" id="relieve_refresh" >重置列表</button>
	                             	&nbsp;&nbsp;
	                          </div>
								<div class="table-responsive"  id="loadinfo">
									 <table id="release-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
	                      <div id="no" class="tab-pane">
	                          	<div class="page-header">
	                          		<button class="btn btn-sm btn-info" id="btn_dispose">撤销处置</button>
									<button class="btn btn-sm btn-info" id="btn_hightSelectDispose">高级查询</button>
	                              	<button class="btn btn-sm btn-info btn_refresh" id="dispose_refresh">重置列表</button>
	                          	</div>
	                          	<div class="table-responsive"  id="loadinfo">
									 <table id="dispose-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
                  </div>
              </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	<div id="optDispose_page"></div>
	
	<script type="text/javascript" src="<%=path %>/project/opt/optDispose/optDispose.js?v=<%=vardate%>"></script>

	<%@ include file="/common_message.jsp"%>
	<%@ include file="/project/opt/optDispose/optRelease.jsp" %>
	<%@ include file="/project/opt/optDispose/optDispose.jsp" %>
	<%@ include file="/project/opt/optDispose/optDisposeQuery.jsp" %>
	