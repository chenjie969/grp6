<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
						<div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add_departs" >添加下级部门</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_update_departs" >修改部门</button>
							<!-- <button type="button" name="button" class="btn btn-sm btn-info" id="btn_view_departs" >查看部门</button> -->
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_delete" >删除部门</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add_users" >添加用户</button>
							<!-- <button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort_post" >分配岗位</button> -->
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_set_leader" >设置部门负责人</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort_departs" >部门同级顺序调整</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort_users" >用户顺序调整</button>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4>组织结构设置</h4>
                                            </div>
                                            <div class="widget-body">
                                                <div class="widget-main padding-8">
                                                    <ul id="departSetTree" class="ztree ztree_style"></ul>
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
						
					<div id="setDepartLeader"></div>
					</div><!-- /.page-content -->
					
<%@ include file="/common_foot.jsp" %>

	<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
	<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/sys/users/index.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/plugins/jquery/jquery.md5.js?v=<%=vardate%>"></script>
	<%@ include file="/sys/departs/add.jsp" %>
	<%@ include file="/sys/departs/edit.jsp" %>
	<%@ include file="/sys/departs/departs_msg.jsp" %>
	
	<%@ include file="/sys/users/add.jsp" %>
	<%@ include file="/sys/users/edit.jsp" %>
	<%@ include file="/sys/users/view.jsp" %>
	<%@ include file="/sys/users/del.jsp" %>
	<%@ include file="/sys/users/setPost.jsp" %><%--设置岗位 --%>
	<%@ include file="/sys/sort/sort.jsp" %>
