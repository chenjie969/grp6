<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
					<input type="hidden" id="lastTableDictypeID">
					<div class="page-content">
						<%--调整 index.jsp页面 :
							1、左上按钮(div class="header blue") 调整到 div class="page-content"下 ,
							2、class属性由 "header blue" 调整为 "page-header" 。
						 --%>
						<div class="page-header">
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add" >添加下级机构 </button>
							<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort" >同级顺序调整</button>
							<button class="btn btn-info btn-sm" id=refresh></i>重置列表</button>
							<!-- <button  onclick="haha()" id="haha" class="btn btn-sm btn-info">全屏</button>
							<button  onclick="shabi()" id="shabi" class="btn btn-sm btn-info" style="display: none;">关闭全屏</button> -->
						</div>
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-sm-3">
										
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4 class="lighter smaller">合作机构设置</h4>
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
<div id="cooperationPage"></div>					
<%@ include file="/common_foot.jsp" %>

	<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
	<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/cooperation/cooperationSet/cooperation.js?v=<%=vardate%>"></script>
	
	<%@ include file="/cooperation/cooperationSet/cooperationAdd.jsp" %>
	<%@ include file="/cooperation/cooperationSet/cooperationEdit.jsp" %>
	<%@ include file="/cooperation/cooperationSet/cooperationView.jsp" %>
	<%@ include file="/cooperation/cooperationSet/cooperationDel.jsp" %>
	<%@ include file="/cooperation/cooperationSet/failDel.jsp"%>
	<%@ include file="/cooperation/cooperationSet/isDefaultDel.jsp"%>
	<%@ include file="/sys/sort/sort.jsp" %> <%-- 排序是公共页面 --%>
	
<script type="text/javascript">
	function haha(){
		var element = parent.document.documentElement;
		 if(element.requestFullscreen) {
		    element.requestFullscreen();
		  } else if(element.mozRequestFullScreen) {
		    element.mozRequestFullScreen();
		  } else if(element.webkitRequestFullscreen) {
		    element.webkitRequestFullscreen();
		  } else if(element.msRequestFullscreen) {
		    element.msRequestFullscreen();
		  }
		 $("#haha").hide(1000);
		 $("#shabi").show(1000);
	}
	
	function shabi(){
		 var de = parent.document;
	     if (de.exitFullscreen) {
	         de.exitFullscreen();
	     } else if (de.mozCancelFullScreen) {
	         de.mozCancelFullScreen();
	     } else if (de.webkitCancelFullScreen) {
	         de.webkitCancelFullScreen();
	     }
	     $("#haha").show(1000);
		 $("#shabi").hide(1000);
	}

</script>
	
	