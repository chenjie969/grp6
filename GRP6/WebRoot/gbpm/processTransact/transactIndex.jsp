<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp"%>
<link href="<%=path%>/plugins/qtip/jquery.qtip.min.css?v=<%=vardate%>" rel="stylesheet" type="text/css" />
<%@ include file="/common_foot.jsp"%>
<div class="page-content">
	<!--begin页面内容  -->
	<!-- /.page-header end 页头部分-->
	<c:if test="${entityType=='04'}">
		<h4 class="header smaller lighter orange">
			<i class="icon-tasks"></i> 发票申请
		</h4>
		<div class="col-sm-12">
			<!-- <img src="../assets/images/gallery/oa.png" alt="" style="width: 50%; height: 50; margin-left: 20%;"> -->
		</div>

		<div class="col-sm-12 space-20"></div>
		<h4 class="header smaller lighter green">
			<i class="icon-paper-clip"></i> 附件
		</h4>
		<div class="col-sm-12">
			<button class="btn btn-sm btn-info" type="button" name="button">上传</button>
		</div>


		<div class="col-sm-12 space-20"></div>
		<h4 class="header smaller lighter blue">
			<i class="icon-comments-alt"></i> 意见区
		</h4>
		<div class="col-sm-12">
			<textarea class="col-sm-10" rows="8" cols="80" placeholder="请输入意见"></textarea>
			<div class="col-sm-10 no-padding-right" style="text-align: right;">
				<span class="light-grey">限制2000个字符</span>
			</div>
		</div>
	</c:if>
	<c:if test="${entityType!='04'}">
		<div class="col-sm-12 space-20"></div>
		<div class="col-sm-12">
			<h5 class="col-sm-5" id="projectName">项目名称：<span class="grey">${entityName}</span></h5>
		</div>
		<h4 class="header smaller lighter orange">
			<i class="icon-tasks"></i>任务事项
		</h4>
		<div class="col-sm-12">
			<!-- PAGE CONTENT BEGINS -->
			<ul class="nav nav-tabs">
				<c:forEach items="${taskFormList}" var="taskFormInfo" varStatus="status">
					<li <c:if test="${status.index==0}"> class="active btn_taskForm"</c:if> 
					<c:if test="${status.index!=0}"> class="btn_taskForm"</c:if> 
					style="cursor:pointer;"
					href-data="${taskFormInfo.taskUrl}?apply_ID=${entityID}&entityID=${entityID}&taskID=${taskID}&type=edit&productInstanceID=${processInstanceID}"
					>
						<a data-toggle="tab"  >${taskFormInfo.taskName}</a>
					</li>
				</c:forEach>
			</ul>
			<div class="row">
	            <div class="col-sm-12">
					<div id="loadFormInfoPage"></div>
	            </div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
	</c:if>
	<div class="col-sm-12 space-20"></div>
	<h4 class="header smaller lighter purple">
		<i class="icon-sitemap"></i> 流程跟踪
	</h4>
	<div class="row">
		<div class="col-sm-12" >
			<img id="img_page" ></img>
			<div id="div_img_page" ></div>
		</div>
	</div>

</div>
<!-- /.page-content -->
<br/><br/><br/><br/><br/>
<div class="modal-footer" style="left: 0; position: fixed; bottom: 0; width: 100%; z-index: 100;">
	<div class="col-sm-4"></div>
	<div class="col-sm-8">
		<button class="btn btn-prev" style="float: right; margin-left: 5px;" id="btn_taskStop">
			<i class="icon-power-off"></i>提前终止
		</button>

		<!-- <button class="btn btn-prev" style="float: right;" id="btn_taskReturn">
			<i class="icon-arrow-left"></i>退回
		</button> -->

		<button class="btn btn-success" style="float: right;" id="btn_taskTransact">
			<i class="icon-arrow-right"></i>办结,提交下一步
		</button>
	</div>



</div>


<div id="transact_page"></div>
<script src="<%=path%>/plugins/qtip/jquery.qtip.pack.js?v=<%=vardate%>"></script>
<script src="<%=path%>/gbpm/processTransact/transactIndex.js?v=<%=vardate%>"></script>
<%@ include file="/common_message.jsp"%>