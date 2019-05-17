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
        			<div class="page-header">
        				
						<button class="btn btn-sm btn-info" id="btn_openAssetSealUp" >资产查封</button>
						<button class="btn btn-sm btn-info" id="btn_refresh" >重置列表</button>
					</div>
                  	<ul class="nav nav-tabs" id="myTab">
                       <li class="active">
                           <a data-toggle="tab" href="#ok" id="assetSealUp1List">
                               	查封资产明细
                           </a>
                       </li>

                       <li>
                           <a data-toggle="tab" href="#no" id="assetSealUp2List">
                            	被查封资产明细
                           </a>
                       </li>
                  	</ul>
        			<div class="tab-content">
	                      <div id="ok" class="tab-pane in active">
								<div class="table-responsive"  id="loadinfo">
									 <table id="assetSealUp1-table" style="font-size:13px !important;"></table>  
			                    </div>
				          </div>
				        
	                      
	                      <div id="no" class="tab-pane">
								<div class="table-responsive"  id="loadinfo">
									 <table id="assetSealUp2-table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
                  </div>
              </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
		<!-- <div id="projectLaw_page"></div> -->
	<script type="text/javascript" src="<%=path %>/project/lawAssetSealUp/assetSealUp.js?v=<%=vardate%>"></script>
	<%@ include file="/common_message.jsp"%>
	<%-- <script type="text/javascript" src="<%=path %>/project/lawsuit/projectLawEdit.jsp"></script>
	 --%>
	