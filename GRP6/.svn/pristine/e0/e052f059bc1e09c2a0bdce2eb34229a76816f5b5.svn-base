<style>
	table{
	font-size:13px;
	border:1px solid #ddd;
	}
	table tr th{
	border:1px solid #ddd;
	text-align: center;
	};

</style>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

<div class="page-content">

	 <div class="page-header"><!-- 页头 -->
	   <h5>项目申请登记</h5>
	 </div>
	<input type="hidden" id="client_ID" value="" />
	<input type="hidden" id="operate" value="edit" />
	<div class="row">
		<div class="col-xs-12"><!--begin 响应式列  -->
	            
	            
	            
	            <div class="tabbable" >
					<ul class="nav nav-tabs " id="myTab3">
						<li class="active">
							<a data-toggle="tab" href="#singleApplyAdd" id="btn_openSingleApplyAdd" >
								单笔业务
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#multiApplyAdd" id="btn_openMultiApplyAdd" >
								多笔业务
							</a>
						</li>
                        <li>
							<a data-toggle="tab" href="#relationMainApplyAdd" id="btn_relationMainApplyAdd">
								集团/关联项目
							</a>
						</li>
					</ul><!-- /.col-sm-2 -->
	
					<div class="tab-content">
							<div id="singleApplyAdd" class="tab-pane in active">
								<%-- <%@ include file="/project/apply/singleApplyAdd.jsp"%> --%>
							</div>
	                         <div id="multiApplyAdd" class="tab-pane" >
									<%-- <%@ include file="/project/apply/multiApplyAdd.jsp"%>  --%>
							</div>
	                        <div id="relationMainApplyAdd" class="tab-pane">
								<%--  <%@ include file="/project/apply/multiApplyAdd.jsp"%>  --%>
							</div>
						</div><!-- /.col-sm-10 -->
					</div><!-- /.row -->
	
	
		</div><!-- /.col --><!--end 响应式列  -->
	</div>
</div>

<%-- <%@ include file="/crm/client/pictureFile/uploadModel.jsp" %>图片附件选择页面 --%>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/project/apply/clientList.jsp" %>
<script src="<%=path %>/project/apply/applyPageIndex.js?v=<%=vardate%>"></script>





