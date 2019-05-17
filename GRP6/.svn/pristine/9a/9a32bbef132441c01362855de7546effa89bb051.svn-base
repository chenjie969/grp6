<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="jurySuggestTabView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="overflow: auto">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">评委表决结果</h4>
      </div>
      <div class="modal-body">
      	<form class="form-horizontal" role="form">
      		<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">项目编号：</label>
				<label class="col-sm-8" id="viewProjectCode"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">项目名称：</label>
				<label class="col-sm-8" id="viewProjectName"></label>
			</div>
	      	<div class="tabbable">
	      		<h5 class="col-sm-12 header smaller lighter blue">评委表决结果</h5>
				<ul class="nav nav-tabs">
					<c:forEach items="${userNameList }" var="userName" varStatus="tabHeader">
						<li <c:if test="${tabHeader.index==0 }">class="active"</c:if>>	
							<a data-toggle="tab" href="#tab${tabHeader.index }">
								${userName }
							</a>
						</li>
					</c:forEach>
					<%-- <c:forEach items="${jurySuggestList }" var="jurySuggest" varStatus="tabHeader">
						<li <c:if test="${tabHeader.index==0 }">class="active"</c:if>>	
							<a data-toggle="tab" href="#tab${tabHeader.index }">
								${jurySuggest.userName }
							</a>
						</li>
					</c:forEach> --%>
				</ul>
				<div class="tab-content">
					<c:forEach items="${userNameList }" var="userName" varStatus="tabContent">
						<c:set var="flag" value="true"></c:set>
						<div id="tab${tabContent.index }" class="tab-pane <c:if test='${tabContent.index==0 }'>in active</c:if>">
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right" for="meetingRoomID">评委结论：</label>
								<c:forEach items="${jurySuggestList }" var="jurySuggest" varStatus="tabContent">
									<c:if test="${userName==jurySuggest.userName }">
										<label class="col-sm-9">${jurySuggest.suggestResultName }</label>
										<c:set var="flag" value="false"></c:set>
									</c:if>
								</c:forEach>
								<c:if test="${flag=='true' }">
									<label class="col-sm-9">（空）</label>
								</c:if>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right">评委意见：</label>
								<c:forEach items="${jurySuggestList }" var="jurySuggest" varStatus="tabContent">
									<c:if test="${userName==jurySuggest.userName }">
										<label class="col-sm-9">${empty jurySuggest.suggestContent?"（空）":jurySuggest.suggestContent }</label>
									</c:if>
								</c:forEach>
								<c:if test="${flag=='true' }">
									<label class="col-sm-9">（空）</label>
								</c:if>
							</div>
						</div>
					</c:forEach>
					<%-- <c:forEach items="${jurySuggestList }" var="jurySuggest" varStatus="tabContent">
						<div id="tab${tabContent.index }" class="tab-pane <c:if test='${tabContent.index==0 }'>in active</c:if>">
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right" for="meetingRoomID">评委结论：</label>
								<label class="col-sm-9">${jurySuggest.suggestResultName }</label>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right">评委意见：</label>
								<label class="col-sm-9">${empty jurySuggest.suggestContent?"（空）":jurySuggest.suggestContent }</label>
							</div>
						</div>
					</c:forEach> --%>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
