<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
					<input type="hidden" id="lastTableDictypeID">	
					<div class="page-content">
						<div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add" >添加下级多级字典</button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort" >同级顺序调整</button>
							<button class="btn btn-info btn-sm" id=refresh></i>重置列表</button>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4 class="lighter smaller">多级字典设置</h4>
                                            </div>
                                            <div class="widget-body">
                                                <div class="widget-main padding-8">
                                                    <ul id="menuSetTree" class="ztree"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-9">
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
	<%-- <script src="<%=path %>/sys/modules/index.js?v=<%=vardate%>"></script> --%>
		 <script src="<%=path %>/sys/dataBaseVindicate/multiLevelSort/index.js?v=<%=vardate%>"></script>

	<%@ include file="/sys/dataBaseVindicate/multiLevelSort/add.jsp" %>
	<%@ include file="/sys/dataBaseVindicate/multiLevelSort/edit.jsp" %>
	<%@ include file="/sys/dataBaseVindicate/multiLevelSort/view.jsp" %>
	<%@ include file="/sys/dataBaseVindicate/multiLevelSort/del.jsp" %>
	<%@ include file="/sys/dataBaseVindicate/multiLevelSort/isDefaultDel.jsp" %>
	<%@ include file="/sys/sort/sort.jsp" %> <%-- 排序是公共页面 --%>
	
	
	