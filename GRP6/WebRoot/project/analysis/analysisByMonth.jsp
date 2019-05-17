<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<script src="<%=path %>/plugins/echarts/echarts.min.js?v=<%=vardate%>"></script>
<style media="screen">
			table tr th,td{
				text-align: center;
			}

			table thead tr th{
				background-color: #f9f2c3 !important;
				color: #963!important;
			}
</style>

<div class="page-content">	
 	<div class="space-4"></div>
      <div class="col-sm-12">
	      <div class="form-group col-sm-3" style="margin-bottom:0px;">
	   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">选择年份： </label>
         	<div class="col-sm-8">
				<div class="input-group">
					<input class="form-control date-picker validate[required]" value="${wheresql}" type="text" name="yearMonth" id="id-date-range-picker" data-date-format="yyyy"/>
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
			</div>
		 </div>
		 <div class="col-sm-12 hr hr-dotted"></div>
		  
      </div>
      
    
     
	<div class="space-6"></div>		
	<div class="row">		 
    	<div class="col-sm-6">
	      <%@ include file="/project/analysis/analysisByMonth1.jsp"%>   
	  	</div>
		  <div class="col-sm-6">
		      <%@ include file="/project/analysis/analysisByMonth2.jsp"%>   
		  </div>
    </div>
    <div class="space-20"></div>
    <div class="row">
    	<div class="col-sm-6">
	      <%@ include file="/project/analysis/analysisByMonth3.jsp"%>   
	  </div>
      <div class="col-sm-6">
	      <%@ include file="/project/analysis/analysisByMonth4.jsp"%>   
	  </div>
    </div>
     
   
	  
 
</div>
​<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/project/analysis/analysis2.js?v=<%=vardate%>"></script>                      
<script src="<%=path %>/js/zjm_echart.js?v=<%=vardate%>"></script>
