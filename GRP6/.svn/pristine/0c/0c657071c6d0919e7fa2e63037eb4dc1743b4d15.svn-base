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
	ReportParam rp5 = (ReportParam)request.getAttribute("reportParam");
%>
 <div class="modal fade" id="reportSelect_year_group" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close btn_close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">统计条件</h4>
                  </div>
                  <div class="modal-body">

             <form class="form-horizontal" role="form" id="reportSelect_form_year_group">
                 <div class="space-4"></div>
                  <div class="form-group" >
                  <div>
	   				  <label class="col-sm-3 control-label no-padding-right " for="form-input">统计年： </label>
	   			      <div class="col-sm-9 ">
					   <div class="input-group col-sm-4 ">
							<input  type="text" class="form-control date-picker3" name="endyearsql"  id="endyearsql" data-date-format="yyyy" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
					   </div>
	   			     </div>
   				    </div>
   				 </div>
   				 <div class="space-20"></div>
                  <div class="form-group" >
	                  <div >
		   				  <label class="col-sm-3 control-label no-padding-right " for="form-input">分组类型： </label>
		   			      <div class="col-sm-9 ">
						   <div class="input-group col-sm-4 ">
								 <select class="col-sm-12 validate[required] " id="groupTypeName" name="groupTypeName"  >		
  											<option value="pp.busiTypeName" selected="selected">业务品种</option>
											<option value="pp.bankName">合作机构</option>
											<option value="pad.departName">业务部门</option>
											<option value="pad.AreaCodeName">所属区域</option>
											<option value="pp.amanName">项目经理A角</option>
											<option value="pp.bmanName">项目经理B角</option>
											<option value="pp.cmanName">风控评审人</option>
							     </select>
						   </div>
		   			     </div>
	   				  </div>
                </div>
                 
                
                
                
            </form>
                  </div>
                  <div class="modal-footer">
                      <button class="btn btn-primary btn_submit" type="button" data-statsCondition='<%=JSON.toJSON(rp5) %>'>
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