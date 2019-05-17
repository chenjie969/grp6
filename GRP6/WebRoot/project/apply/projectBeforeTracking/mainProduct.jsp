<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="page-header"><!--begin页头部分 -->
            <h5>产品流程：${productInstance.productName}</h5>
          </div><!-- /.page-header end 页头部分-->
            <!-- 产品实例id -->
	       <input type="hidden"  id="isAdmin" value="${sessionUser.isAdmin}">
	       <input type="hidden"  id="role_uids" value="${sessionUser.role_uids}">
          <input type="hidden" id="productInstance_ID" class="" value="${productInstance.productInstance_ID}">
          <!--   产品id -->
          <input type="hidden" id="productID_01" class=""  value="${productInstance.productID}">
          <!-- 正在运行节点id -->
          <input type="hidden" id="runNode_ID" class="" name="runNode_ID" value="${runNode.runNode_ID}">
          <!-- 创建人ID -->
          <input type="hidden" id="createUserID" class=""  value="${productInstance.createUserID}">
          <!-- 创建人名称-->
          <input type="hidden" id="createUserName" class=""  value="${productInstance.createUserName}">
          <!-- 业务类型-->
          <input type="hidden" id="entityTypeID" class=""  value="${productInstance.entityType}">
          <input type="hidden"  id="userID" value="${sessionUser.user_uid}">
          <input type="hidden"  id="userName" value="${sessionUser.user_name}">
          <input type="hidden"  id="productNodeListLength" value="${fn:length(productNodeList)}">
            <div class="row"><!--begin 响应式行  -->
              <div class="col-xs-12"><!--begin 响应式列  -->
                <!-- PAGE CONTENT BEGINS -->
                  <!--这里放置右边的核心内容  -->
                <div class="widget-main">
                    <div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
                      <ul class="wizard-steps" id="state">
                        <!-- <li data-target="#step1" id="1" class="complete">
                          <span class="step">1</span>
                          <span class="title">受理</span>
                        </li> -->
               			<c:forEach items="${productNodeList}" var="productNode" varStatus="status">
                        <%--  <!-- 产品节点id -->
                        <input type="hidden" id="productNode_ID+${productNode.productNode_ID}+" class="" value="${productNode.productNode_ID}">
                        <input type="hidden" id="nodeID+${productNode.nodeID}+" class="" value="${productNode.nodeID}"> --%>
                        <c:if test="${productNode.nodeSort lt runNode.nodeSort}"> <!-- 已经完成的节点   -->           
                            <li data-target="#step1" id="${productNode.nodeSort}" value="${productNode.productNode_ID}" class="complete" style="cursor: pointer;">
                              <span class="step">${status.index+1}</span>
                              <span class="title">${productNode.nodeNames}</span>
                            </li>
                        </c:if>
                        <c:if test="${productNode.nodeSort eq runNode.nodeSort}"> <!-- 正在运行节点  -->           
                           <li data-target="#step1" id="${productNode.nodeSort}" value="${productNode.productNode_ID}" class="active" style="cursor: pointer;">
                             <span class="step">${status.index+1}</span>
                             <span class="title">${productNode.nodeNames}</span>
                           </li>
                        </c:if>
                        <c:if test="${productNode.nodeSort gt runNode.nodeSort}" > <!-- 未执行节点   -->           
                           <li data-target="#step1" id="${productNode.nodeSort}" value="${productNode.productNode_ID}" class="notActive" style="cursor: pointer;">
                           		<span class="step">${status.index+1}</span>
	                            <span class="title">${productNode.nodeNames}</span>
                           </li>
                        </c:if>
                         <%-- <li data-target="#step1" id="${status.index}" >
                           <span class="step">${status.index}</span>
                           <span class="title">${productNode.nodeName}</span>
                         </li> --%>
                        </c:forEach>
                                            
                                            

                                        
                   	</ul>
                    <hr>
                    <div class="row">
                        <h5 class="col-sm-3" id="busiCode">项目编号：<span class="grey">${apply.busiCode}</span></h5>
                        <h5 class="col-sm-5" id="projectName">项目名称：<span class="grey sprojectName">${apply.projectName}</span></h5>
                          
                        <%-- <h5 class="col-sm-4" id="clientName">客户名称：<span class="grey"><a class="btn_client_view" href="javascript:void(0)" >${client.clientName}</a></span></h5>
                         --%>
                        <h5 class="col-sm-4 red" id="" >
                                                                                                限办：<span id="nodeLimitDay"></span>天
                              <span id="nodeOverDay"></span>
                        </h5>
                        
                        <h5 class="col-sm-12" style="text-align:right;" id="clientName">
                          <button class=" btn-success btn-xs btn_client_view">查看客户信息</button>
                          &nbsp;&nbsp;
                          <button class=" btn-success btn-xs btn_project_view">查看项目信息</button>
                          &nbsp;&nbsp;
                          <button class=" btn-success btn-xs btn_projectState" style="position:relative;">项目动态</button>
                          <c:if test="${number!='0'}">
                          <span class="badge badge-danger" style="position:absolute;top:-7px;right:2px;">${number}</span>
                          </c:if>
                            <!-- <a class="btn_client_view" style="text-decoration:underline;" href="javascript:void(0)" >查看客户信息</a>
                          
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <a class="btn_projectState" style="text-decoration:underline;" href="javascript:void(0)" >项目动态</a> -->
                          
                        </h5>
                        
                        <input type="hidden" id="apply_ID" class="apply_ID"  value="${apply.apply_ID}"><!-- 正在运行节点id -->
                        <input type="hidden" id="client_ID" class="client_ID"  value="${client.client_ID}"><!-- 客户id -->
                        <input type="hidden" id="clientTypeID" class="clientTypeID"  value="${client.clientTypeID}"><!--  客户类型id-->
  						<input  type="hidden"   id="user_uid"  value="${sessionUser.user_uid}" name="user_uid"  />
	                    </div>
	                    <hr>
	                    <div class="row">
	                        <h5 class="col-sm-8">流程节点名称：<span id="stateText">${runNode.nodeNames}</span></h5>
	                        <c:if test="${productInstance.isReturn}"><h5 class="col-sm-12">退回原因：<span class="grey">${productInstance.returnDesc}</span></h5></c:if>
	                    </div>
	                    <div class="row">
	                      <div class="col-sm-12 table-responsive"  id="loadinfo">
	                         <table id="transact-table" style="font-size:13px !important;"></table>  
	                      </div>
	                    </div>
                 	</div>
                  <hr>
                  <div class="row-fluid wizard-actions">
                    <button class="btn btn-warning btn_stopProcessPage" >
                      <i class="icon-power-off"></i>
                          提前终止流程
                    </button>
                    <c:if test="${runNode.nodeSort != 1 && (!productInstance.isReturn || (productInstance.isReturn && productInstance.returnType != '01'))}">
                      <button class="btn btn-info btn_returnBefore" >
                        <i class="icon-arrow-left"></i>
                             退回
                      </button>
                    </c:if>
                    <c:if test="${!productInstance.isReturn || productInstance.returnType != '01'}">
                      <button class="btn btn-info btn-next btn_returnNext" data-last="Finish ">
                             提交下一环节
                        <i class="icon-arrow-right icon-on-right"></i>
                      </button>
                    </c:if>
                    <c:if test="${productInstance.isReturn && productInstance.returnType == '01'}">
                      <button class="btn btn-info btn-next" id="btn_returnBackNode" data-last="Finish ">
                             重新提交到退回环节
                        <i class="icon-arrow-right icon-on-right"></i>
                      </button>
                    </c:if>
                    
                  </div>

                </div><!-- end widget-main -->
              </div><!-- /.col --><!--end 响应式列  -->
            </div><!-- /.row --><!--end 响应式行  -->