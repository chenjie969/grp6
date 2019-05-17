<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>

<div class="page-content">   
      <div class="row">
		<div class="col-xs-12">
		<%-- <h4 class="header smaller lighter blue">
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
                 <h5 class="col-sm-12">业务品种：<span class="grey">${project.busiTypeName}</span></h5>
                 <h5 class="col-sm-6">资金来源：<span class="grey">${apply.fundSource}</span></h5>
                 <h5 class="col-sm-6">资金方子机构：<span class="grey">${apply.fundName}</span></h5>
                 <h5 class="col-sm-6">项目金额：
                 <span class="grey"><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">
                <c:choose>
                 	<c:when test="${project.busiClass eq '01' }">
                 		在保余额：
                 	</c:when>
                 	<c:otherwise>
                 		委贷余额：
                 	</c:otherwise>
                 </c:choose>
                 <span class="grey"><fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">开始日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></span></h5>
                 <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadEndDate}"/></span></h5>
				 <h5 class="col-sm-6">期限：<span class="grey">${project.periodMonthDay}</span></h5>
                
			</div>
		
		<div class="col-sm-12 space-20"></div>
			<h4 class="header smaller lighter blue">
				逾期情况
	  		</h4>
	  		<div class="col-sm-12">
				<div class="table-responsive">
					<table id="projectOver_table" style="font-size:13px !important;"></table>  
			   </div>
			</div>
				
				
		<%-- <form class="form-horizontal" role="form" id="projectOverRgister_form">
	         <input type="hidden" id="project_ID" class="" name="project_ID" value="${project.project_ID}">
	         <input type="hidden" id="apply_ID" class="" name="applyID" value="${project.apply_ID}">
		 
		   <div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>逾期金额： </label>
	             <div class="col-md-10">
	                 <input disabled="disabled" type="text" class="col-md-2 col-lg-1 validate[required,maxSize[18],custom[number]]"  id="overSum" name="overSum"  value="<fmt:formatNumber value="${project.overSum}" pattern="###.######"/>" />
	                 <span class="col-md-10 col-lg-11" style="line-height:28px;">万元</span>
	             </div>
			</div> --%>
		   
		   <!-- <div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>逾期余额： </label>
	             <div class="col-md-10">
	                 <input type="text" id="overplusSum" name="overplusSum" class="col-md-2 col-lg-1 validate[required,maxSize[18],custom[number]]" />
	                 <span class="col-md-10 col-lg-11" style="line-height:28px;">万元</span>
	             </div>
			</div> -->
		   
			
			<%-- <div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上报日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]" id="overDate" name="overDate" type="text" disabled="disabled" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${project.overDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
			
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>逾期日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]" id="overFactDate" name="overFactDate" type="text" disabled="disabled" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${project.overFactDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
			
		
			<div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">逾期原因： </label>
	             <div class="col-md-10">
	                 <textarea class="col-sm-7 limited  validate[maxSize[2000]]" rows="5"  name="overDesc" id="overDesc" disabled="disabled"  >${project.overDesc}</textarea>											
					<div class="col-sm-7 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
	             </div>
			</div> 
			
		  
        
		
           
     
       
        </form>--%>
    <!--     <div class="space-20"></div>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary " id="btn_insertOneOver" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		       <button class="btn btn_colse" id="btn_colseInsertOneOver" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div> -->     
     </div>
    </div>
</div>
<%-- <%@ include file="/common_foot.jsp" %> --%>
<script src="<%=path %>/project/apply/factPayRegister.js?v=<%=vardate%>"></script> 