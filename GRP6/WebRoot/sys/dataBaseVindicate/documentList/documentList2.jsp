<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />

	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<input type="hidden" name="entityID" class="entityID" value="${docVo.entityID}" id="entityID">
	<input type="hidden" name="documentCode" class="documentCode" value="${docVo.documentCode}" id="documentCode">
	<input type="hidden" name="flowID" class="flowID" value="${docVo.productInstanceID}" id="flowID">
	<input type="hidden" name="stepID" class="stepID" value="${docVo.nodeID}" id="stepID">
	<input type="hidden" name="taskID" class="taskID" value="${docVo.taskID}" id="taskID">
	<div class="page-content">
	
	<div class="page-header">
		<h4 id="taskName">${docVo.taskName }</h4>
	</div>
	
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
                	<div class="tabbable">
							<h4 class="header smaller lighter blue">可选文档模版</h4>
	                          <div class="page-header">
	                              	<button class="btn btn-sm btn-info btn_refresh" id="relieve_refresh" >重置列表</button>
	                             	&nbsp;&nbsp;
	                          </div>
								<div class="table-responsive"  id="loadinfo">
									 <table id="release-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>

                 <div class="space-20"> </div>
				<h4 class="header smaller lighter orange">已生成文档</h4>

                 <div id="no" class="tab-pane in active">
	                          	<div class="page-header">
	                              	<button class="btn btn-sm btn-info btn_refresh" id="avatar">上传</button>
	                              	<button class="btn btn-sm btn-info btn_refresh" id="dispose_refresh">重置列表</button>
	                          	</div>
	                          	<div class="table-responsive"  id="loadinfo">
									 <table id="dispose-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
	              <!-- <hr />  
				 <button class="btn btn-info btn_returnBack pull-right" data-last="Finish ">
				     <i class="icon-arrow-right icon-on-left"></i>
				     返回								
				 </button>  -->
				
				 <div class="space-30"></div>
				 <div class="clearfix form-actions">
					<div class="col-sm-offset-3 col-sm-9">
						&nbsp; &nbsp; &nbsp;
						
						<button class="btn " type="button" id="btn_close">
							<i class="icon-remove bigger-110"></i>关闭
						</button>
					</div>
				</div>
				
				     
               </div> <!-- /.col-xs-12 -->            
          </div><!-- /.row -->
	</div><!-- /.page-content -->
	
	<div id="optDispose_page"></div>
	
	
	
	
	<script type="text/javascript" src="<%=path %>/sys/dataBaseVindicate/documentList/documentList2.js?v=<%=vardate%>"></script>
	
	<%@ include file="/sys/dataBaseVindicate/documentList/documentDel.jsp" %>
	<%@ include file="/sys/dataBaseVindicate/documentList/success.jsp" %>
	
	<%@ include file="/sys/dataBaseVindicate/documentList/documentUpload.jsp" %>
	