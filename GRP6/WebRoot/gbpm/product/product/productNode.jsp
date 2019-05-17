<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
					
						<input type="hidden" name="product_ID" id="product_ID" value="${product.product_ID}">	
						<input type="hidden" name="productNodeID" id="productNodeID">	
						<div class="page-header"><!--begin页头部分 -->
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addProductNode" >添加节点</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addMuchProductNode" >批量添加节点</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_editProductNode" >修改节点</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_delProductNode" >删除节点</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sortProductNode" >调整节点顺序</button>
						</div><!-- /.page-header end 页头部分-->
									
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4>节点设置</h4>
                                            </div>
                                            <div class="widget-body">
                                                <div class="widget-main padding-8">
                                                    <ul id="menuSetTree" class="ztree ztree_style"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-9">
                                    	<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addNodeTask" >添加节点任务</button>
                                    	<button type="button" name="button" class="btn btn-sm btn-info" id="btn_addMuchNodeTask" >批量添加节点任务</button>
                                    	<button type="button" name="button" class="btn btn-sm btn-info" id="btn_nodeTaskSort" >调整节点任务顺序</button>
										<div class="table-responsive"   id="loadinfo">
                                            <table id="test-table" style="font-size:13px !important;"></table>
                                        </div>
                                    </div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
					<div id="loadPage"></div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/common_del.jsp" %>

	<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
	<script src="<%=path %>/gbpm/product/product/productNode.js?v=<%=vardate%>"></script>
