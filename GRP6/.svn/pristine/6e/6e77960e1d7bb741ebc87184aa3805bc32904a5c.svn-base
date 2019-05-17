<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="putStockPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">入库</h4>
			</div>
	
	<span id="optGuaranty_IDS" style="display: none;">${optGuaranty_IDS}</span>
			<div class="modal-body">
				<!-- <div class="row col-sm-offset-1"></div> -->
					<div class="table-responsive"  id="loadinfo">
						<table id="opt_table" style="font-size:13px !important;"></table>  
                    </div>
					
					
		
			<div class="space-20"></div>		
		
				<form class="form-horizontal" role="form" id="form_putStock">
						 <input class="col-sm-4 " type="hidden" name="isWorkable" value="1">
						 <input class="col-sm-4 " type="hidden" name="optGuaranty_ID" value="${optGuaranty_IDS}" id="optGuaranty_ID">
					
					
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right" for="form-input"> <i class="icon-asterisk orange"></i>经办人：</label>
						<div class="col-md-6">
							<div class="col-md-6 col-sm-6 input-group txt_id1">
								<input  type="text"  class="form-control " autoField=""   id="txt_id1"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="putStockUserName"  readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>				
					</div>
					
					
						<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right"
								for="form-input"> <i class="icon-asterisk orange"></i>经办日期：
							</label>
							<div class="col-sm-8">
								<div class="input-group col-sm-5">
									<input class="form-control date-picker validate[required,maxSize[50],custom[date]]" id="putStockDate" 
									     value="<fmt:formatDate value="${opt.putStockDate }" pattern="yyyy-MM-dd"/>"	type="text" data-date-format="yyyy-mm-dd" name="putStockDate"/> 
									<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
								</div>
							</div>
						</div>
				</form>
			</div>

			<div class="modal-footer">
				<button class="btn btn-primary" type="button" id="btn_putStock">
					<i class="icon-ok bigger-110"></i> 保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class="icon-remove bigger-110"></i> 关闭
				</button>
			</div>
			
			
		</div>
	</div>
</div>
<div id="optGuarantyAdd_page"></div>


	<script src="<%=path %>/project/opt/pledgeManager/putStock.js?v=<%=vardate%>"></script>

