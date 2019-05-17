<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content">   
      <div class="row">
		<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="projectAfterAdd_form">
		   <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务类型： </label>
				<div class="col-md-6">
						<select id="projectType" class=" col-sm-6 col-md-6 validate[required] "  name="projectType"  >		
							<c:forEach items="${projectTypeList}" var="projectType">
								<option value="${projectType.dicTypeName}">${projectType.dicTypeName}</option>
							</c:forEach>
					    </select>
				</select>
				</div>
          </div>

        </form>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary" type="button"  id= "btn_projectAfterAdd" value="0"><i class="icon-ok bigger-110"></i>下一步</button>
		      </div>
      </div>     
     </div>
    </div>
</div>
<%@ include file="/common_foot.jsp" %>
<script type="text/javascript" src="<%=path %>/project/apply/projectAfterTracking.js?v=<%=vardate%>"></script>
	
