<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	table{
	font-size:13px;
	border:1px solid #ddd;
	text-align: center;
	}
	table tr th{
	border:1px solid #ddd;
	text-align: center;
	};
</style>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

<script type="text/javascript">
/**
 *获取下拉框值;
 */
function getSelectText2 (v){
    var  selectID = v.id;
    var selectName = selectID.replace(/List/, "Name");
　    document.getElementById(selectName).value=v.options[v.options.selectedIndex].text;
};
</script>

<div class="page-content">   
      <!--  <input type="hidden" id="singleAppleAddPage" class="pageType" name="singleAppleAddPage" value="0">
     
       -->
     
      <div class="row">
		<div class="col-xs-12">
             <h4 class="header smaller lighter blue">
						 项目信息
		  	</h4>
			<div class="col-sm-12">
                 <h5 class="col-sm-12">项目名称：<span class="grey">${project.projectName}</span></h5>
                 <h5 class="col-sm-6">业务品种：<span class="grey">${project.busiTypeName}</span></h5>
                 <h5 class="col-sm-6">放款机构：<span class="grey">${project.bankName}</span></h5>
                 <h5 class="col-sm-6">项目金额：
                 <span class="grey"><fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"> </fmt:formatNumber>
				  &nbsp;万元</span>
				  </h5>
                 <h5 class="col-sm-6">期限：<span class="grey">${project.periodMonthDay}</span></h5>
                 <h5 class="col-sm-6">开始日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/></span></h5>
                 <h5 class="col-sm-6">结束日期：<span class="grey"><fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadEndDate}"/></span></h5>
			</div>
                  
                  
				 <div class="col-sm-12 space-20"></div>
	             <h4 class="header smaller lighter blue">
							 核销损失
				  </h4>
				<div class="col-sm-12">
				<!-- 	<div class="table-responsive">
						<table id="projectPay_table" style="font-size:13px !important;"></table>  
				   </div> -->
	                   <table  class="table table-hover table-striped" >	
				 			<thead>
					 			 <tr >
						         	 <th>担保金额（万元） </th>
						         	 <th>无代偿解除金额（万元）</th>
						             <th>代偿解除金额（万元）</th>
						             <th>追回金额（万元）</th>
						             <th>未追回金额（万元）</th>
						             <th>损失金额（万元）</th>
						             <th>核销日期</th>
						             <th>操作</th>
					             </tr>
				             </thead>				             
				             <tr >
				              <td style="border:1px solid #ddd;"><!-- 担保金额（万元） -->
				              <fmt:formatNumber value="${project.loadSum}" pattern="###,###.######"> </fmt:formatNumber>
				              </td>
				              <td style="border:1px solid #ddd;"><!-- 无代偿解除金额（万元） -->
				              <fmt:formatNumber value="${project.normalCapitalSum}" pattern="###,###.######"> </fmt:formatNumber>
				              </td>
							  <td style="border:1px solid #ddd;"><!-- 代偿解除金额（万元） -->
							  <fmt:formatNumber value="${project.replaceCapitalSum}" pattern="###,###.######"> </fmt:formatNumber>
							  </td>
							  <td style="border:1px solid #ddd;"><!-- 追回金额（万元） -->
							  <fmt:formatNumber value="${project.returnCapitalSum}" pattern="###,###.######"> </fmt:formatNumber>
							  </td>
							  <td style="border:1px solid #ddd;"><!-- 未追回金额（万元） -->
							  <fmt:formatNumber value="${project.replaceCapitalSum-project.returnCapitalSum}" pattern="###,###.######"> </fmt:formatNumber>
							  </td>				     			            
							  <td style="border:1px solid #ddd;"><!-- 损失金额（万元） -->
							   <fmt:formatNumber value="${project.badSum}" pattern="###,###.######"> </fmt:formatNumber>
							  </td>	
							  <input type="hidden" id="badSum" class="" name=""  value="${project.replaceCapitalSum-project.returnCapitalSum}"  >
							  <td style="border:1px solid #ddd;">
							  <fmt:formatDate value="${project.badDate}" pattern="yyyy-MM-dd"/>
							 
							  </td>				     			            
					          <td style="border:1px solid #ddd;">
					          <c:if test="${project.badDate==null && project.replaceCapitalSum-project.returnCapitalSum !=0}">
					          	   <a href="javascript:void(0) " class="" id = "btn_projectFinishLoss">核销损失</a>
					          </c:if>
					          </td>
			               </tr>			               
	                 </table>
		     </div>
				
				
				
				
				
	<!-- 	 <div class="col-sm-12 space-20"></div>
           <h4 class="header smaller lighter blue">
				 还款情况
	  		</h4>
	     -->
		<form class="form-horizontal" role="form" id="projectFinish_form">
	         <input type="hidden" id="project_ID" class="" name="project_ID" value="${project.project_ID}">
	         <%-- <input type="hidden" id="apply_ID" class="" name="apply_ID" value="${project.apply_ID}"> --%>
		   <div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目完结方式： </label>
	             <div class="col-md-6">
	                       <input type="hidden" id="finishTypeName" class="finishTypeName" name="finishTypeName" >
	                    <select id="finishTypeList" class="selectList col-sm-6 col-md-6 validate[required]" onchange='getSelectText2(this)'  name="finishTypeID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${finishTypeList}" var="finishType">
									<option value="${finishType.dicTypeID}">${finishType.dicTypeName}</option>
								</c:forEach>
					    </select>
	             </div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>完结日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]"  name="finishDate" id="finishDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
	       <div class="space-4"></div>
           <div class="form-group">
	           	<label class="col-md-2 control-label no-padding-right" for="form-field-1">经办人： </label>		
					<div class="col-md-6">
						<div class="col-md-6 col-sm-6 input-group txt_id1">
							<input  type="text"  class="form-control" autoField="finishUserID"   id="txt_id1"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="finishUserName"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
				</div>	
			</div>
			<div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">项目评价： </label>
	             <div class="col-md-10">
	                 <textarea class="col-sm-7 limited  validate[maxSize[2000]]" rows="5"  name="projAppraisal" id="projAppraisal" ></textarea>											
					<div class="col-sm-7 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
	             </div>
			</div>
			
		  
        
		
           
     
       
        </form>
        <div class="space-20"></div>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary " id="btn_projectFinishRegister" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		       <button class="btn " type="button" id = "btn_colseFinishRegister"><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div>     
     </div>
    </div>
</div>
<div id="projectFinishRegister_page"></div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/project/projectFinish/projectFinishRegister.js?v=<%=vardate%>"></script> 