<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<script type="text/javascript" charset="utf-8" src="<%=path %>/oa/info/ueEdit/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path %>/oa/info/ueEdit/ueditor.all.min.js"> </script>
<script type="text/javascript">
window.UEDITOR_HOME_URL = "/oa/info/ueEdit/"
</script>
 <script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/oa/info/uploadFiles/fileup.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>       
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=path %>/oa/info/ueEdit/lang/zh-cn/zh-cn.js"></script>				
	<!-- 这个页面对应的是商机管理下的企业咨询登记 -->
	<div class="page-content">
	
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
             		        <div class="row">
                                    <div class="col-sm-3">
										
										<div class="widget-box">
                                            <div class="widget-header">
                                                <h4 class="lighter smaller">信息中心</h4>
                                            </div>
                                            <div class="widget-body">
                                                <div class="widget-main padding-8">
                                                	<input type="hidden" value="b4cb8bf303974996ac4df5e87cf30ac0"  id="currentTreeId">
                                                	<input type="hidden" value="1"  id="treeLevel">
                                                    <ul id="menuSetTree" class="ztree"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-9">
                                    
									   <div class="row">
					                     <div class="col-sm-12">
											<div class="page-header">
												<button type="button" class="btn btn-sm btn-info" id="btn_addAnnounce">新增</button>&nbsp;
										  	    <!-- <button type="button" class="btn btn-sm btn-info" id="btn_batchDelete">删除所选</button>&nbsp;
												<button type="button" class="btn btn-sm btn-info" id="btn_submitCheck">提交审核</button>&nbsp; -->
											</div>
					                     </div>
					                     <div class="col-sm-12">
											<div class="table-responsive">
											<!-- 下面的table就是对应的数据列表 -->
												<table id="announce_table" style="font-size:13px !important;">
												</table>  
					                        </div>
					                     </div>
									   </div>
             
                                         	<!-- <table id="draft_table" style="font-size:13px !important;"></table>    -->
                                       
                                    </div>
								</div>
 
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="info_page"></div>

<%@ include file="/common_message.jsp" %>
<%@ include file="/oa/info/tree_msg.jsp" %>
<%@ include file="/oa/info/sort.jsp" %>
<%@ include file="/oa/info/edit.jsp" %>
<%@ include file="/oa/info/tree_child_msg.jsp" %>
<%@ include file="/oa/info/announcement/announce/announceAddChildrenOrgView.jsp" %>
             

<style type="text/css">
        .dropdown-menu {
		    z-index: 1100;
		}
         body{ overflow: auto !important;} .modal{ overflow: auto !important;}
    </style>
<script src="<%=path %>/plugins/iconpicker/js/iconPicker.js?v=<%=vardate%>"></script>

<script type="text/javascript" src="<%=path %>/sys/listSet/listSetColumns.js?v=<%=vardate%>"></script>
<script src="<%=path %>/oa/info/announcement/announce.js?v=<%=vardate%>"></script>
