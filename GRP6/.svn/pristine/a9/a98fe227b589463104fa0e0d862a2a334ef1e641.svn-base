<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
<div class="page-content" style="padding-bottom:100px;">
      <div class="row">
		<div class="col-xs-12">
		 		<!-- 业务ID-->
                 <input type="hidden" id="apply_ID"  value="${arcMoveRec.apply_ID}">
                 <input type="hidden" id="arcMoveRec_ID" value="${arcMoveRec.arcMoveRec_ID}">
                 <input type="hidden" id="operationType" value="${arcMoveRec.operationType}">
                 <input type="hidden" id="type1" value="${arcMoveRec.type}">
				
				<div class="col-sm-12">
				 		<ul class="nav nav-tabs " id="myTab3">
							<li class="active">
								<a data-toggle="tab" href="#arcMoveList">
									文件目录
								</a>
							</li>
							<li>
								<a data-toggle="tab" href="#arcMoveDetail" class="pictureFile" id="personPictureFile">
									移交清单
								</a>
							</li>
						</ul>
						<div class="tab-content col-sm-12"  >
							   <div id="arcMoveList" class="tab-pane in active">
	           					 <%@ include file="/project/arcMove/arcMoveList/arcMoveListTable.jsp"%>
	           					 
								</div>
								<div id="arcMoveDetail" class="tab-pane">
									<%@ include file="/project/arcMove/arcMoveDetail/arcMoveDetailTable.jsp"%>
								</div>
						</div>
				 
				</div>
					
   		 </div>			
	</div>
</div><!-- /.page-content --><!--end页面内容  -->
		
<div id="arMoveIndex_page" ></div>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/project/suggest/projectSuggest/projectSuggest.js?v=<%=vardate%>"></script>
