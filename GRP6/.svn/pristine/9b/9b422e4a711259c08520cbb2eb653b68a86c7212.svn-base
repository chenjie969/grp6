<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zjm.crm.report.model.ReportParam"%>		
<%@ page import="com.alibaba.fastjson.JSON"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});

</script> -->
<% 
	ReportParam rp2 = (ReportParam)request.getAttribute("reportParam");
%>
 <div class="modal fade" id="reportSelect_beginAndEnd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close btn_close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">统计条件</h4>
                  </div>
                  <div class="modal-body">

             <form class="form-horizontal" role="form" id="reportSelect_form_beginAndEnd">
             <input  type="hidden" class="" name="dateType"  id="dateType"/>
							
                 <div class="space-4"></div>
                  <div class="form-group" >
                  
                  <div>
	   				   <label class="col-sm-3 control-label no-padding-right " for="form-input">统计期间： </label>
	   			      <div class="col-sm-9  " >
		   			   <div class="input-group col-sm-4 " style="float:left;">
							<input  type="text" class="form-control date-picker  " name="begindatesql"  id="begindatesql" data-date-format="yyyy-mm-dd" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
					    </div>
						
					   <p class="col-sm-1  ">-</p>
					   <div class="input-group col-sm-4 ">
							<input  type="text" class="form-control date-picker   " name="enddatesql"  id="enddatesql" data-date-format="yyyy-mm-dd" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
					   </div>
	   			     </div>
   				  </div>
   					
                </div>
                 
                
                
                
            </form>
                  </div>
                  <div class="modal-footer">
                      <button class="btn btn-primary btn_submit" type="button" data-statsCondition='<%=JSON.toJSON(rp2) %>'>
                          <i class="icon-search bigger-110"></i>查询
                      </button>
                    <button type="button" class="btn btn-default btn_close" data-dismiss="modal">
                          <i class="icon-remove bigger-110"></i>关闭
                    </button>
      		</div>
       </div>
    </div>
 </div>
<script type="text/javascript">
		$(".btn_close").click(function(){
			$("#reportSelect").show();
		});
</script>