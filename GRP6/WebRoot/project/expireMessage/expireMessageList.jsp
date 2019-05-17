<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	<style>
		.table th, .table td {
		vertical-align: middle!important;
		}
	</style>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<button type="button" id="btn_addOptGuaranty" class="btn btn-sm btn-info" data-toggle="modal" data-target="#edit">出具到期/逾期催收通知函</button>
						</div>
						<h5><b>金融机构实际放款情况：</b></h5>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="expireMessage_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
	
<div id="optGuaranty_page"></div>
<div id="clientList_page"></div>
	
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/opt/optManager/failDel.jsp" %>

<script src="<%=path %>/project/expireMessage/expireMessage.js?v=<%=vardate%>"></script>

	