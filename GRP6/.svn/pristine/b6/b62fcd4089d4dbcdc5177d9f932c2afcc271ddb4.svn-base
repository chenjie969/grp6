<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

					<div class="page-content">
						<%--调整 index.jsp页面 :
							1、左上按钮(div class="header blue") 调整到 div class="page-content"下 ,
							2、class属性由 "header blue" 调整为 "page-header" 。
						 --%>
						<div class="page-header">
							<button class="btn btn-info btn-sm" id=refresh></i>重置列表</button>
						</div>
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4 class="lighter smaller">合作机构</h4>
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
                                         	<table id="cooperation-table" style="font-size:13px !important;"></table>
                                        </div>
                                    </div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
<div id="creditConditionsPage"></div>
<%@ include file="/common_foot.jsp" %>

	<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
	<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
<%-- 	<script src="<%=path %>/sys/modules/index.js?v=<%=vardate%>"></script> --%>
		<script src="<%=path %>/cooperation/creditConditions/creditConditions.js?v=<%=vardate%>"></script>


	
	<%@ include file="/cooperation/creditConditions/creditConditionsDetail.jsp" %>
	
	
	
	