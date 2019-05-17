<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common_timestamp.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />

	<div class="page-content">
	<div class="page-header">
		<h4>录入风委会评议表</h4>
		
	</div>
		<div class="row">
			<div class="col-xs-12">
                 <form class="form-horizontal" role="form" id="riskAppraise_form">
      	        <input type="hidden" id="riskAppraise_ID"  name="riskAppraise_ID" value="${riskAppraise.riskAppraise_ID}">
	           <input type="hidden" id="riskScheme_ID" name="riskScheme_ID" value="${riskAppraise.riskScheme_ID}">
	           <div class="space-4"></div>
					<div class="form-group ">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"
					for="form-input">议题名称：</label>
					<label class="col-sm-8 grey">${riskScheme.title}</label>
              </div>
			
			<div class="form-group ">
			 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-md-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>呈报单位： </label>
		        <div class="col-md-5">
					  <select id="reportUnitList" class="col-sm-6 col-md-6 validate[required]" name="reportUnit">		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${reportUnitList}" var="reportUnitType">
									<option value="${reportUnitType.dicTypeName}" <c:if test="${reportUnitType.dicTypeName eq riskAppraise.reportUnit }">selected="selected"</c:if>>${reportUnitType.dicTypeName}</option>
								</c:forEach>
					  </select>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							   <label class="col-md-4 control-label no-padding-right" for="form-input">呈报单位： </label>
							    <label class="col-sm-8 grey">${riskAppraise.reportUnit}</label>
							</c:if>
				
			</div>
      		 <div class="form-group">
      		 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1" for="form-input">
				<i class="icon-asterisk orange"></i>汇报人：</label>
				<div class="col-sm-5">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group reportUserIDList">
								<input  type="text"  class="form-control validate[required]" id="reportUserIDList" name="reportUserNameList" autoField="reportUserIDList" readonly="readonly" value="${riskAppraise.reportUserNameList}"/>
								<span class="input-group-addon midden">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1" for="form-input">汇报人：</label>
							    <label class="col-sm-8 grey">${riskAppraise.reportUserNameList}</label>
							</c:if>
			</div>
			 <div class="form-group">
			       <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>汇报日期：
				</label>
							<div class="col-sm-5">
								<div class="input-group col-sm-6">
									<input class="form-control date-picker validate[required,custom[date]]"
										type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="reportDate" value="<fmt:formatDate value="${riskAppraise.reportDate}" pattern="yyyy-MM-dd" type="both"/>"/> 
									<span class="input-group-addon input-group-addon1"> 
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							</c:if>
				               <c:if test="${'view' eq urlParam.type }">
				               <label class="col-sm-4 control-label no-padding-right" for="form-input">汇报日期：
				               </label>
							    <label class="col-sm-8 grey"><fmt:formatDate value="${riskAppraise.reportDate}" pattern="yyyy-MM-dd" type="both"/></label>
							</c:if>
						</div>
				<div class="form-group">
				 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>评议结果：</label>
				<div class="col-sm-5">
					<div class="row">
						<div class="col-sm-8">
							<select class="col-sm-6"  name="appraiseResult" >
								<option value="同意" <c:if test="${riskAppraise.appraiseResult eq '同意'}">selected="selected"</c:if>>同意</option>
								<option value="否决" <c:if test="${riskAppraise.appraiseResult eq '否决'}">selected="selected"</c:if>>否决</option>
								<option value="附条件同意" <c:if test="${riskAppraise.appraiseResult eq '附条件同意'}">selected="selected"</c:if>>附条件同意</option>
							</select>
						</div>	
					</div>
				</div>
				</c:if>
				            <c:if test="${'view' eq urlParam.type }">
				            <label class="col-sm-4 control-label no-padding-right" for="form-field-1">评议结果：</label>
						 <label class="col-sm-8 grey">${riskAppraise.appraiseResult}</label>
							</c:if>
			</div>
			     <div class="form-group">
				   <label class="col-sm-4 control-label no-padding-right" for="form-field-1"></i>评议意见及建议：</label>
		         <c:if test="${'edit' eq urlParam.type}">
		           <div class="col-sm-6">
		               <textarea class="col-sm-8 limited validate[maxSize[2000]]" rows="6" id="appraiseDesc"  name="appraiseDesc" >${riskAppraise.appraiseDesc}</textarea>
		           	<div class="col-sm-8 no-padding-right">
		                <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
		           </c:if>
		           <c:if test="${'view' eq urlParam.type }">
							    <label class="col-sm-8 grey">${riskAppraise.appraiseDesc=="null"?"(空)":riskAppraise.appraiseDesc}</label>
							</c:if>
			</div>

		 </form> 
			
			<div class="form-group" >
				<h4 class="header smaller lighter green">
	                   附件
	            </h4>
				<div id="thelist" class="uploader-list"></div>
				 <c:if test="${'view' ne urlParam.type }">
				<div id="picker" class="col-xs-2">选择文件</div>
				<button id="ctlBtn" class="btn btn-default">开始上传</button>
				</c:if>
				<table id="fileList" style="font-size:13px !important;"></table>
			</div> 
		 <div class="space-20"></div>
		 <c:if test="${'view' ne urlParam.type }">
	      <div class="clearfix form-actions">
				<div class="col-md-offset-4 col-md-8">
			       <button class="btn btn-primary " id="btn_insertOneRiskAppraise" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
			        &nbsp; &nbsp; &nbsp;
			       <button class="btn btn_colse" id="btn_colseOneRiskAppraise" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
	            
	            </div>
	      </div>
      	</c:if>       
		</div>
		</div>
	</div>


<%@ include file="/common_del.jsp"%> <!-- 公共提示框 -->
<div id="filesUpload_page"></div>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/project/riskAppraise/fileupv.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script src="<%=path%>/project/riskAppraise/riskAppraise.js?v=<%=vardate%>"></script>
<script type="text/javascript">
$(function () {
var defParam = {
		"uploadFileList" : "thelist",//待上传的附件列表div ID
		//"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
		"btn_PickID" : "picker",//选择附件按钮ID
		"btn_UploadID" : "ctlBtn",//上传按钮ID
		"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
		"uploadParam" : {
			"fileOneType":"projFiles",//附件表分类
			"fileTwoType":"06",//附件上传入口分类
			"clientID":"",//客户id
			"projectID":"",//项目id
			"fileFlag":"06",
			"entityID":$("#riskAppraise_ID").val(),
			"uuid":""//文件uuid
		},//上传附加参数
		"fileList" : "fileList",//已上传的附件列表Table ID
		"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载附件列表数据地址
		"mimeTypes":[
			{title : "", extensions : "*"},
			]//限定上传附件类型
};

//刷新附件列表
$.zjm_upload.initTable(defParam);
$.zjm_upload.initUpload(defParam);
$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#reportUserIDList").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple : true,//是否多选
			data : data.obj//数据源
		});
		
    }
});

/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
/*设置日期初始值，默认为当天*/
$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));


});
</script>
