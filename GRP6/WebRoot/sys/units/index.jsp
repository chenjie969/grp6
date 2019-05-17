<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
							<div class="page-header">
								<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add" >添加下级机构</button>
								<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort" >同级顺序调整</button>
							</div>
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4>机构设置</h4>
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
                                            
                                        </div>
                                    </div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
<%@ include file="/common_foot.jsp" %>
	<script src="<%=path %>/plugins/jquery/jquery.md5.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/sys/units/index.js?v=<%=vardate%>"></script>

	<%@ include file="/sys/units/add.jsp" %>
	<%@ include file="/sys/units/edit.jsp" %>
	<%@ include file="/sys/units/view.jsp" %>
	<%@ include file="/sys/units/units_msg.jsp" %>
	<%@ include file="/sys/sort/sort.jsp" %>