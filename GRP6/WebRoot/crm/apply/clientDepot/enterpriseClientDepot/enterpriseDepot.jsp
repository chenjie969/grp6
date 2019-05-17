<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<button type="button" class="btn btn-sm btn-info" id="btn_enterpriseDepotAdQuery">高级查询</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_refreshEnterpriseDepotTable">重置列表</button>
							<button type="button" class="btn btn-sm btn-info" id="btn_enterpriseDepot_agreeToAccept">同意受理，转入受理申请</button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="enterpriseDepot_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<script src="<%=path %>/crm/apply/clientDepot/enterpriseClientDepot/enterpriseDepot.js?v=<%=vardate%>"></script>

	