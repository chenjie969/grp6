<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

<!-- <script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script> -->

<div class="page-content">   
      <!--  <input type="hidden" id="singleAppleAddPage" class="pageType" name="singleAppleAddPage" value="0">
     
       -->
     
      <div class="row">
		<div class="col-xs-12">
	            <%--  <h4 class="header smaller lighter blue">
							 项目摘要
				  </h4>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right">项目名称：</label>
                             <label class="col-sm-10   grey">
                                    	  ${project.projectName}
                             </label>
                  </div>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right">项目金额：</label>
                             <label class="col-sm-10   grey">
                             <fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"> </fmt:formatNumber>
									  &nbsp;万元
                             </label>
                  </div>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right"> 放款机构：</label>
                             <label class="col-sm-10   grey">
                            ${project.bankName}
                             </label>
                  </div>
                   <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right">业务品种：</label>
                             <label class="col-sm-10   grey">
                            ${project.busiTypeName}
                             </label>
                  </div>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right">期限：</label>
                             <label class="col-sm-10   grey">
                              ${project.periodMonthDay}
                             </label>
                  </div>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right"></label>
                             <label class="col-sm-10   grey">
                             &nbsp;
                             </label>
                  </div>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right">起始日期：</label>
                             <label class="col-sm-10   grey">
                            <fmt:formatDate value="${project.loadBeginDate}" pattern="yyyy-MM-dd"/> 
                             </label>
                  </div>
				  <div class="form-group col-sm-6">
                             <label class="col-sm-2  no-padding-right" style="text-align:right">结束日期：</label>
                             <label class="col-sm-10   grey">
                            <fmt:formatDate value="${project.loadEndDate}" pattern="yyyy-MM-dd"/> 
                             </label>
                  </div> --%>
             <h4 class="header smaller lighter blue">
						 项目信息
		  	</h4>
			<div class="col-sm-12">
                 <h5 class="col-sm-12">项目名称：<span class="grey">${project.projectName}</span></h5>
                 <h5 class="col-sm-6">业务品种：<span class="grey">${project.busiTypeName}</span></h5>
                 <%-- <h5 class="col-sm-6">放款机构：<span class="grey">${project.bankName}</span></h5> --%>
                 <h5 class="col-sm-6">放款机构：<span class="grey">${apply.fundChinese}</span></h5><!-- 放款机构数据抽取从资金方抽取 -->
                 <h5 class="col-sm-6">项目金额：
                 <span class="grey"><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">
                 <c:if test="${project.busiClass=='01'}">在保余额：</c:if>
                 <c:if test="${project.busiClass=='02'}">委贷余额：</c:if>
                 <span class="grey"><fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">开始日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></span></h5>
                 <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.delayEndDate}"/></span></h5>
				 <h5 class="col-sm-6">期限：<span class="grey">${project.periodMonthDay}</span></h5>
                 
			</div>
                  
                  
				 <div class="col-sm-12 space-20"></div>
	             <h4 class="header smaller lighter blue">
							 退费情况记录
				  </h4>
				<div class="col-sm-12">
					<div class="table-responsive">
						<table id="projectCostReturn_table" style="font-size:13px !important;"></table>  
				   </div>
				</div>
		 <div class="col-sm-12 space-20"></div>
           <h4 class="header smaller lighter blue">
				 退费情况
	  		</h4>
	    
		<form class="form-horizontal" role="form" id="projectCostRetuen_form">
        	<input type="hidden" id="project_ID" class="" name="project_ID" value="${project.project_ID}">
         	<input type="hidden" id="apply_ID" class="" name="apply_ID" value="${project.apply_ID}">
        
           <div class="space-4"></div>
           <div class="form-group">
					<label class="col-md-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>费用类型：</label>
					<div class="col-sm-9">
						<input type="hidden" id="costTypeName" name="costTypeName" class="costTypeName"> 
						<select class="col-sm-4 validate[required] costTypeID" id="costTypeID" name="costTypeID">
							<c:forEach var="costType" items="${costTypeList}" varStatus="status">
								<option value="${costType.dicTypeID}">${costType.dicTypeName}</option>
							</c:forEach>
						</select>
					</div> 
			</div>
          
		   <div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>退费金额： </label>
	             <div class="col-md-10">
	                 <input type="text" id="returnCostSum" name="returnCostSum" class="col-sm-4 validate[required]" />
	                 <span class="col-md-10 col-lg-11" style="line-height:28px;">万元</span>
	             </div>
			</div>
			
			<!-- <div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上报日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]"  name="payDate" id="payDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div> -->
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退费日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]"  name="returnCostDate" id="returnCostDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
        </form>
        <div class="space-20"></div>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_projectCostReturnAdd" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      <!--  <button class="btn btn-primary btn_agreeAdd" type="button" value="0"><i class="icon-ok bigger-110"></i>同意立项</button>
		        &nbsp; &nbsp; &nbsp; -->
		       <button class="btn btn_colse" id="btn_closeProjectCostReturnAdd" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div>     
     </div>
    </div>
</div>
<div id="projectCostReturn_page"></div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/project/apply/projectCostReturn.js?v=<%=vardate%>"></script> 
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>

<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){
		$('.returnCostDate').focus();
	});
	$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
	$(".costTypeID").on("change", function () {
		$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
    })
</script>