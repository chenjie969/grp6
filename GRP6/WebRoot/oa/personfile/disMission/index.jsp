<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>	
	<div class="page-content">
		<div class="row" style="display:block" id="dimissionPage">
			<div class="col-xs-12">
				<div class="page-header">
					
				</div>
                <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo"> 
						 <table id="personfileDimission" style="font-size:13px !important;"></table>  
                    </div>
                </div>
			</div>

         </div>
	</div><!-- /.page-content -->
	<div id="disMisssion_page"></div>
	<script type="text/javascript" src="<%=path %>/oa/personfile/disMission/index.js?v=<%=vardate%>"></script>
	

