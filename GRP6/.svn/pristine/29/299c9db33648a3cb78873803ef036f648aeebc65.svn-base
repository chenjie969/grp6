<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
					
						<input type="hidden" name="materialModel_ID" id="materialModel_ID" value="${materialModel.materialModel_ID}">	
						<input type="hidden" name="materialTree_ID" id="materialTree_ID">	
						
						<div class="page-header"><!--begin页头部分 -->
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addMaterialTree" >添加客户资料类型</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_editMaterialTree" >修改</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_delMaterialTree" >删除</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sortMaterialTree" >同级顺序调整</button>
						</div><!-- /.page-header end 页头部分-->
									
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4>客户资料类型设置</h4>
                                            </div>
                                            <div class="widget-body">
                                                <div class="widget-main padding-8">
                                                    <ul id="materialTree" class="ztree ztree_style"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-9">
                                    	<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addMaterialDetail" >添加资料名称</button>
                                    	<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sortMaterialDetail" >调整资料名称顺序</button>
										<div class="table-responsive"   id="loadinfo">
                                            <table id="test-table" style="font-size:13px !important;"></table>
                                        </div>
                                    </div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
					<div id="materialTreeSet_Page"></div>
					
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/common_del.jsp" %>
<style type="text/css">
       .dropdown-menu {
	    z-index: 1100;
	}
        body{ overflow: auto !important;} .modal{ overflow: auto !important;}
</style>
<script src="<%=path %>/crm/client/clientMaterialSet/materialTree.js?v=<%=vardate%>"></script>
