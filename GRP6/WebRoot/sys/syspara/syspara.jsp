<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
    
	<div class="page-content">
		<div class="row">
                <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo">
						 <table id="syspara-table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	<div id="sysparaModal"></div>
<script type="text/javascript" src="<%=path %>/sys/syspara/syspara.js?v=<%=vardate%>"></script>