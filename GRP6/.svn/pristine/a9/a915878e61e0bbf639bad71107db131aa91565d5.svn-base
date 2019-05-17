<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
				<%-- 操作日志 --%>
					<div class="page-content">
							<div class="page-header col-sm-12">
						   	 	<label class="col-sm-3 col-md-2 control-label no-padding-right" for="form-input" style="text-align:right;line-height:34px;">选择日期： </label>
					         	<div class="col-md-3">
									<div class="row" >
										<div class="col-sm-12">
											<div class="input-group">
												<input class="form-control date-range-picker" readonly="readonly" type="text" name="date-range-picker" id="id-date-range-picker-1" data-date-format="yyyy-mm-dd"/>
												<span class="input-group-addon">
													<i class="icon-calendar bigger-110"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
							
									<button class="btn btn-info btn-sm" id="search"><i class="icon-search"></i>查询</button>
									<button class="btn btn-info btn-sm" id=refresh></i>重置列表</button>
               					
               						<button class="btn btn-default btn-sm pull-right" id="clearAll" >清空日志</button>
               					
               				</div>
             			
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-12">
										<div class="table-responsive"   id="loadinfo">
                                            <table id="test-table" style="font-size:13px !important;"></table>
                                        </div>
                                    </div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
<%@ include file="/common_foot.jsp" %>

	<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
	<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/sys/log/operationLog/index.js?v=<%=vardate%>"></script>
	<%@ include file="/sys/log/operationLog/view.jsp" %>
	<%@ include file="/sys/log/operationLog/del.jsp" %>
	<%@ include file="/sys/log/operationLog/delAll.jsp" %>
	