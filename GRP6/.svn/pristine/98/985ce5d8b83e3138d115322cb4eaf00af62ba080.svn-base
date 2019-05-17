<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />

	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<input type="hidden" name="entityID" class="entityID" value="${entityID }" id="entityID">
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
                <div class="tabbable">
                  	<ul class="nav nav-tabs" id="myTab">
                       <li class="active">
                           <a data-toggle="tab" href="#ok" id="relieveList">
                               	可选文档模版
                           </a>
                       </li>

                       <li>
                           <a data-toggle="tab" href="#no" id="disposeList">
                            	已生成文档
                           </a>
                       </li>
                  	</ul>
        			<div class="tab-content">
	                      <div id="ok" class="tab-pane in active">
	                          <div class="page-header">
	                              	<button class="btn btn-sm btn-info btn_refresh" id="relieve_refresh" >重置列表</button>
	                             	&nbsp;&nbsp;
	                          </div>
								<div class="table-responsive"  id="loadinfo">
									 <table id="release-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
	                      <div id="no" class="tab-pane">
	                          	<div class="page-header">
	                              	<button class="btn btn-sm btn-info btn_refresh" id="document_upload">上传</button>
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
	
	<%@ include file="/common_foot.jsp" %>
	<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
	
	<script src="<%=path %>/sys/dataBaseVindicate/docMould/docMould.js?v=<%=vardate%>"></script>
	
	
	<script type="text/javascript" src="<%=path %>/sys/dataBaseVindicate/documentList/documentList.js?v=<%=vardate%>"></script>
	
	<%@ include file="/sys/dataBaseVindicate/documentList/documentDel.jsp" %>
	<%@ include file="/sys/dataBaseVindicate/documentList/success.jsp" %>

	