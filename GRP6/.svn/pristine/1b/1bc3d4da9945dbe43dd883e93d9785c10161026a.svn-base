<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<!-- <div class="page-content">	 -->	

 <div class="page-header"><!--begin页头部分 -->	
	    	
	    <c:if test="${client.clientTypeID eq '01'}">
	    	<h5>客户名称：
	    		<span class="">${client.clientName}</span>
				<span style="margin-left:2em;" class="grey">客户编号：
					<span class="">
						<c:if test="${client.clientBH eq null}">
						  （空）
						</c:if>
						${client.clientBH}
					</span>					
				</span>		
			</h5>
		</c:if>
		 <c:if test="${client.clientTypeID ne '01'}">
	    	<h5>申请人：
	    		<span class="">${client.personName}</span>
	    		&nbsp;
		    	<span class="">${client.clientName}</span>
				<span style="margin-left:2em;" class="grey">客户编号：
					<span class="">
						<c:if test="${client.clientBH eq null}">
						  （空）
						</c:if>
						${client.clientBH}
					</span>					
				</span>		
			</h5>
			
		
		</c:if>	
		<h5 >曾用名称：
    		<span class=" grey">
    			<c:if test="${client.oldClientName eq null or client.oldClientName == ''}">
    			(空)
    			</c:if> 
    			 ${client.oldClientName} 
    		</span>
    	</h5>
 </div> 
<div class="col-sm-12" style="margin-top:10px;" id="">
<table class="table table-bordered " style="font-size: 13px" id="">
    <%-- <input type="hidden" name="client_ID" id="client_ID" value="${reportSy.client_ID}"  />
    <input type="hidden" name="unit_uid" id="unit_uid" value="${reportSy.unit_uid}"  />
    <input type="hidden" name="reportSy_ID" id="reportSy_ID" value="${reportSy.reportSy_ID}"  />
    
     --%>
    
    <tr>
        <h5  style="text-align: center;">客户需要提供的资料清单</h5>
    </tr>
    
    <thead>
        <tr>
            <th style="text-align: center;">序号</th>
			<th style="text-align: center;">文件名称</th>
            <th style="text-align: center;">资料类型</th>
			
        </tr>
    </thead>
    <tbody align="left">
        
		       
		       <c:forEach items="${materialTreeList}" var="materialTree" >
		       
		       		   <c:if test="${materialTree.materialTreeLevel eq 1 }"><!-- 一级节点 -->
					        <tr>
					             <td style="font-weight: bolder;" colspan="2">
					              ${materialTree.materialTreeName}
					              </td>
					              
								<td style="font-weight: bolder;"></td>
					        </tr>
						  <c:if test="${materialTree.materialDetailList ne null}"><!-- 一级节点下客户资料名称 -->
				              <c:forEach items="${materialTree.materialDetailList}" var="materialDetail" varStatus="materialDetailStatus">
				                      <tr>
				                         <td style="font-weight: bolder;"></td>
							             <td style="font-weight: bolder;">
							               &nbsp;&nbsp;&nbsp;&nbsp; ${materialDetailStatus.count}.&nbsp;&nbsp; ${materialDetail.materialName}
							             <button id="${materialDetail.materialDetail_ID}" class="btn_add" name="activeUpload" ><i class="icon-plus-sign bigger-120 red"></i></button><!-- 附件上传按钮 -->
							               <c:if test="${materialDetail.clientfilesList ne null}"> <%-- 如果存在附件则进行遍历 --%>
										        <c:forEach items="${materialDetail.clientfilesList}" var="clientfiles" varStatus="status">
										             <div style="border:1px solid #ccc;display:inline-block;" id="${clientfiles.pathFile}">
													     <img style="width:30px;height:30px;" class="btn_opfile_viewer" id="${clientfiles.pathFile}" data-original="${clientfiles.pathFile}" src="${clientfiles.pathFile}" alt="${clientfiles.sourceFileName}" title="${clientfiles.sourceFileName}">
													     <button  class="deleteOneClientFile" id="${clientfiles.clientFiles_ID}" name="${clientfiles.pathFile}">	
																<i class="icon-trash bigger-110 red"></i>
														 </button>
												    </div>
										        </c:forEach>
										   </c:if>
							              
							              </td>
										<td >${materialDetail.materialType}</td>
							        </tr>
							        
							   </c:forEach>
			              </c:if>      
					        
					        
			           </c:if>
		           <c:if test="${materialTree.materialTreeList ne null}"><!-- 一级节点 下子节点-->
		              <c:forEach items="${materialTree.materialTreeList}" var="materialTreeChild" varStatus="status">
		                      <tr>
		                         <td style="font-weight: bolder;"></td>
					             <td style="font-weight: bolder;">
					              ${materialTreeChild.materialTreeName}
					              </td>
								<td style="font-weight: bolder;"></td>
					        </tr>
					        
					         <c:if test="${materialTreeChild.materialDetailList ne null}"><!-- 一级节点下客户资料名称 -->
				              <c:forEach items="${materialTreeChild.materialDetailList}" var="materialDetailChild" varStatus="materialDetailChildStatus">
				                      <tr>
				                         <td style="font-weight: bolder;"></td>
							             <td style="font-weight: bolder;">
							              &nbsp;&nbsp;&nbsp;&nbsp;
							               ${materialDetailChildStatus.count}.&nbsp;&nbsp; ${materialDetailChild.materialName}
							                <button id="${materialDetailChild.materialDetail_ID}" class="btn_add" name="activeUpload" ><i class="icon-plus-sign bigger-120 red"></i></button>
							               <c:if test="${materialDetailChild.clientfilesList ne null}">
										        <c:forEach items="${materialDetailChild.clientfilesList}" var="clientfilesChild" varStatus="status">
										             <div style="border:1px solid #ccc;display:inline-block;" id="${clientfilesChild.pathFile}">
													     <img style="width:30px;height:30px;" class="btn_opfile_viewer" id="${clientfilesChild.pathFile}" data-original="${clientfilesChild.pathFile}" src="${clientfilesChild.pathFile}" alt="${clientfilesChild.sourceFileName}" title="${clientfilesChild.sourceFileName}">
													     <button  class="deleteOneClientFile" id="${clientfilesChild.clientFiles_ID}" name="${clientfilesChild.pathFile}">	
																<i class="icon-trash bigger-110 red"></i>
														 </button>
												    </div>
										        </c:forEach>
									       </c:if>
							              </td>
										<td >${materialDetailChild.materialType}</td>
							        </tr>
							   </c:forEach>
			              </c:if>      
					        
					   </c:forEach>
		           </c:if>
		           
		           
		           
		           
		           
		           
		       
				     <%--   <c:if test="${materialTree.materialTreeLevel ne 3 }">
					        <tr>
					            
					              <td style="font-weight: bolder;" colspan="2">
					               <c:if test="${materialTree.materialTreeLevel eq 2 }">
					              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
					              ${materialTree.materialTreeName}
					              </td>
					              
								<td style="font-weight: bolder;"></td>
					        </tr>
			           </c:if>
				      
			          <c:if test="${materialTree.materialTreeLevel eq 3 }">
				       <tr>
					         <td style="font-weight: bolder;"></td>
							 <td>${materialTree.materialTreeName}</td>
							 
							 
							 
							 <td style="font-weight: bolder;"></td>
			        	</tr>
				      </c:if> --%>
						      
					<%--  <c:if test="${materialTree.materialDetailList ne null}"><!--  -->
					   <c:forEach items="${materialTree.materialDetailList}" var="materialDetail" varStatus="status">
						<tr>
				            <td  style="font-weight: bolder;"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  ${status.count}.&nbsp;&nbsp;${materialDetail.materialName}
							  <button id="${materialDetail.materialDetail_ID}" class="btn_add" name="activeUpload" ><i class="icon-plus-sign bigger-120 red"></i></button>
							   <!--  -->
							   <c:if test="${materialDetail.clientfilesList ne null}">
							        <c:forEach items="${materialDetail.clientfilesList}" var="clientfiles" varStatus="status">
							             <div style="border:1px solid #ccc;display:inline-block;" id="${clientfiles.pathFile}">
										     <img style="width:30px;height:30px;" class="btn_opfile_viewer" id="${clientfiles.pathFile}" data-original="${clientfiles.pathFile}" src="${clientfiles.pathFile}" alt="${clientfiles.sourceFileName}" title="${clientfiles.sourceFileName}">
										     <button  class="deleteOneClientFile" id="${clientfiles.clientFiles_ID}" name="${clientfiles.pathFile}">	
													<i class="icon-trash bigger-110 red"></i>
											 </button>
									    </div>
							        </c:forEach>
							   </c:if>
							
							</td>
							<td>${materialDetail.materialType}</td>
			           </tr> 
			          </c:forEach>      
			     </c:if>  --%>
		           
			 </c:forEach>  				        
    </tbody>
</table>
</div>
<!-- ​</div> -->
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/pictureFiles/pictureFile.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">
$(function () {
	$("[name='activeUpload']").click(function(){
		var materialDetail_ID ="";//客户资料清单类型id;
		materialDetail_ID = $(this).attr("id"); 
		var defParam = {
				"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
				"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
				"btn_PickID" : "pickfiles",//选择附件按钮ID
				"btn_UploadID" : "uploadfiles",//上传按钮ID
				"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
				"uploadParam" : {
					"isFile":false,
					"materialDetail_ID":materialDetail_ID,
					"fileOneType":"clientFiles",//附件表分类
					"fileTwoType":"05",//附件上传入口分类
					"clientID":$("#client_ID").val(),//客户id
					"projectID":""//项目id
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
				"mimeTypes":[{title : "图片", extensions : "jpg,gif,png,jpeg"}]
					 /* //限定上传附件类型  */
		};
		$("#uploadfiles").modal({keyboard:true});		
		$.zjm_pictureFile.initUpload(defParam);
		$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
			$.zjm_clientDataIndex.initDate();
			uploader.destroy();  
			$("#pickfiles").unbind("click"); 
		}); 
	});
	//查看图片附件;
	$(".btn_opfile_viewer").click(function(){
		var viewer_ID  = $(this).attr("id");
		var viewer = new Viewer(document.getElementById(viewer_ID), {
		    url: 'data-original'
		});
		$(".viewer-close").click(function(){
			viewer.hide();
			viewer.destroy();
		});
	});
	//删除图片附件;
	$(".deleteOneClientFile").click(function(){
		var clientFiles_ID  = $(this).attr("id");
		var pathFile  = $(this).attr("name");	
		var  clientID = $("#client_ID").val();
		var  fileTwoType ="05";
		$.zjm_pictureFile.deleteOnePictureFile(clientFiles_ID,pathFile,clientID,fileTwoType);
		
	});
	var type = tool.getUrlParam('type');
	if(type == 'view'){
		$(".btn_add").hide();//上传按钮;
		$(".deleteOneClientFile").hide();//删除按钮;
	}
	
	
});

</script>