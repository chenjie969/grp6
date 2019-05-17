<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<style>
	.table th, .table td {
	vertical-align: middle!important;
}
</style>
	<input type="hidden" name="client_ID" class="client_ID" value="">
	<input type="hidden" name="clientTypeID" class="clientTypeID" value="02">
	<input type="hidden" name="apply_ID" class="apply_ID" value="${apply_ID }" id="apply_ID">
	
	<div class="page-content">
		<div class="row" style="display:block" id="personClientPage">
			<div class="col-xs-12">
                <div class="tabbable">
                  	<ul class="nav nav-tabs" id="myTab">
                       <li class="active">
                           <a data-toggle="tab" href="#ok" id="zaiku">
                               	在库记录
                           </a>
                       </li>

                     <!--   <li>
                           <a data-toggle="tab" href="#no" id="jiechu">
                            	借出记录
                           </a>
                       </li>
                       <li>
                           <a data-toggle="tab" href="#chukujilu" id="chuku">
                            	出库记录
                           </a>
                       </li> -->
                  	</ul>
        			<div class="tab-content">
	                      <div id="ok" class="tab-pane in active">
	                          <div class="page-header">
									<button class="btn btn-sm btn-info" id="btn_ruku">入库</button>
	                            <!--   	<button class="btn btn-sm btn-info" id="btn_jiechu">借出</button>
	                              	<button class="btn btn-sm btn-info btn_refresh" id="btn_chuku" >出库</button> -->
	                              	<button class="btn btn-sm btn-info btn_refresh" id="btn_zaiku_refresh" >重置列表</button>
	                             	&nbsp;&nbsp;
	                          </div>
								<div class="table-responsive"  id="loadinfo">
									 <table id="pledgeManager_table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
	                      <!-- <div id="no" class="tab-pane">
	                          	<div class="page-header">
	                          		<button class="btn btn-sm btn-info" id="btn_guihuan">归还</button>
	                              	<button class="btn btn-sm btn-info btn_refresh" id="btn_jiechu_refresh">重置列表</button>
	                          	</div>
	                          	<div class="table-responsive"  id="loadinfo">
									 <table id="loanStock_table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div>
	                       <div id="chukujilu" class="tab-pane">
	                          	<div class="page-header">
	                          		<button class="btn btn-sm btn-info" id="btn_chexiao">撤销</button>
	                              	<button class="btn btn-sm btn-info btn_refresh" id="btn_chuku_refresh">重置列表</button>
	                          	</div>
	                          	<div class="table-responsive"  id="loadinfo">
									 <table id="out_table" style="font-size:13px !important;"></table>  
			                    </div>
	                      </div> -->
                  </div>
              </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	<div id="pledgeManager_page"></div>
	
	
	<script src="<%=path %>/project/opt/pledgeManager/pledgeManager.js?v=<%=vardate%>"></script>

	<%@ include file="/common_message.jsp"%>
	<%@ include file="/project/opt/optDispose/optRelease.jsp" %>
	<%@ include file="/project/opt/optDispose/optDispose.jsp" %>
	<%@ include file="/project/opt/optDispose/optDisposeQuery.jsp" %>
	