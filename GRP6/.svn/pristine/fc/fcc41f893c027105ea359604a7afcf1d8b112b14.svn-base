<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
							<div class="page-header">
								<button type="button" name="button" id="btn_add" class="btn btn-sm btn-info" >新建流程模板</button>
								<button type="button" name="button" id="btn_importAdd" class="btn btn-sm btn-info" >导入流程模板</button>
								<button type="button" name="button" id="btn_deployList_add" class="btn btn-sm btn-info" >启动流程</button>
							</div>
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4 class="lighter smaller">流程分类</h4>
                                            </div>
                                            <div class="widget-body">
                                                <div class="widget-main padding-8">
                                                    <ul id="menuSetTree" class="ztree ztree_style"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-9">
										<div class="table-responsive"   id="loadinfo">
                                            <table id="definition-table" style="font-size:13px !important;"></table>
                                        </div>
                                    </div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
					<div id="processDefinition_page"></div>
<%@ include file="/common_foot.jsp" %>
	<script src="processDefinitionList.js?v=<%=vardate%>"></script>
	<script src="processDefinitionDeployList.js?v=<%=vardate%>"></script>
<%@ include file="/gbpm/processDefinition/processDefinitionConfig.jsp" %>