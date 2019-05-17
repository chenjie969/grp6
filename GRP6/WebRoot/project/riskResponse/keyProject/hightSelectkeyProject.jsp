<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ include file="/common_timestamp.jsp" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script>
 <div class="modal fade" id="keyProjectSelect" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">高级查询</h4>
                  </div>
                  <div class="modal-body">

                <form class="form-horizontal" role="form" id="keyProjectSelect_form">

 						  <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">项目类型： </label>
                             <div class="col-sm-5">
                              		  <select id="projectName" class="selectList  col-md-12 "  name=projectName >  		
											<option value="">&nbsp;请选择</option>                                    
											<c:forEach items="${applyTypeList}" var="applyType">
												<option value="${applyType.dicTypeName}">${applyType.dicTypeName}</option>
											</c:forEach>
					 				 </select>
                             </div>
                          </div>
                          <div class="space-4"></div>
                          
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-input">所属区域： </label>
                             <div class="col-sm-5">
                              		  <select id="fullAreaName" class="selectList  col-md-12 "  name="fullAreaName" >  		
											<option value="">&nbsp;请选择</option>                                    
											<c:forEach items="${areaTypeList}" var="areaType">
												<option value="${areaType.dicTypeName}">${areaType.dicTypeName}</option>
											</c:forEach>
					 				 </select>
                             </div>
                          </div>

                          <div class="space-4"></div>
                          <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-1">关联关系： </label>
                              <div class="col-sm-4">
                                  <input type="text" name="relationMainName" id="relationMainName"  class="col-xs-10 col-sm-11   validate[maxSize[50]]" />
                              </div>
                          </div>
                      <form>

                  </div>
                  <div class="modal-footer">
                      <button class="btn btn-primary btn_submit" type="button">
                          <i class="icon-search bigger-110"></i>查询
                      </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                          <i class="icon-remove bigger-110"></i>关闭
                    </button>
      		</div>
       </div>
    </div>
 </div>
