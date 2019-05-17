<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="dutyReleaseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">责任解除确认</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="dutyRelease_form">
      	 	<input type="hidden" name="project_ID" id="project_ID" value="${project.project_ID}">
			<input type="hidden" name="apply_ID" id="apply_ID" value="${project.apply_ID}">
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">项目编号： </label>
				<div class="col-sm-10">
					<c:choose>
				    	<c:when test="${empty project.projectCode}">
				    		<input type="text" name="projectCode" class="col-sm-10" id="projectCode" value="（空）" 
								style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
						</c:when>
				    	<c:otherwise>
				    		<input type="text" name="projectCode" class="col-sm-10" id="projectCode" value="${project.projectCode}" 
								style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
						</c:otherwise>
				    </c:choose>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">项目名称： </label>
				<div class="col-sm-10">
					<c:choose>
				    	<c:when test="${empty project.projectName}">
				    		<input type="text" name="projectName" class="col-sm-10" id="projectName" value="（空）" 
								style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
						</c:when>
				    	<c:otherwise>
				    		<input type="text" name="projectName" class="col-sm-10" id="projectName" value="${project.projectName}" 
								style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
						</c:otherwise>
				    </c:choose>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">业务品种： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
						    <c:choose>
						    	<c:when test="${empty project.busiTypeName}">
						    		<input type="text" name="busiTypeName" class="col-sm-10" id="busiTypeName" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input type="text" name="busiTypeName" class="col-sm-12 " value="${project.busiTypeName}" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
		        	</div>
		    	</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">合作机构： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<c:choose>
						    	<c:when test="${empty project.bankName}">
						    		<input type="text" name="bankName" class="col-sm-10" id="bankName" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input type="text" name="bankName" class="col-sm-12 " value="${project.bankName}" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">放款单编号： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<c:choose>
						    	<c:when test="${empty project.loadCode}">
						    		<input type="text" name="loadCode" class="col-sm-10" id="loadCode" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input class="form-control" type="text" name="loadCode" value="${project.loadCode}"
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
			
			
			<div class="form-group col-sm-6">
				<input type="hidden" name="loadSum" value="${project.loadSum}"/>
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">放款金额： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
					    	<c:choose>
			                	<c:when test="${empty project.loadSum}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
			                	<c:otherwise>
									<input type="text" value="<fmt:formatNumber value="${project.loadSum}" pattern="###,###.######万元"/>" 
										 class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
			                </c:choose>
						</div>
		        	</div>
		    	</div>
			</div>
			
			<div class="form-group col-sm-6">
				<input type="hidden" id="guarantySum-input" name="guarantySum" value="${project.guarantySum}"/>
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">在保余额： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
							<c:choose>
			                	<c:when test="${empty project.guarantySum}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
			                	<c:otherwise>
									<input type="text" value="<fmt:formatNumber value="${project.guarantySum}" pattern="###,###.######万元"/>" 
										 class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
			                </c:choose>
						</div>
		        	</div>
		    	</div>
			</div>
			<div class="form-group col-sm-6">
				<input type="hidden" name="guarantyDutySum" value="${project.guarantyDutySum}"/>
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">责任金额： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
							<c:choose>
			                	<c:when test="${empty project.guarantyDutySum}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
			                	<c:otherwise>
									<input type="text" value="<fmt:formatNumber value="${project.guarantyDutySum}" pattern="###,###.######万元"/>" 
										 class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
			                </c:choose>
						</div>
		        	</div>
		    	</div>
			</div>
			
			<div class="form-group col-sm-6">
				<input type="hidden" name="guarantyDutyResSum" id="guarantyDutyResSum-input" value="${project.guarantyDutyResSum}"/>
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">责任余额： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
							<c:choose>
			                	<c:when test="${empty project.guarantyDutyResSum}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
			                	<c:otherwise>
									<input type="text" value="<fmt:formatNumber value="${project.guarantyDutyResSum}" pattern="###,###.######万元"/>" 
										 class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
			                </c:choose>
						</div>
		        	</div>
		    	</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">合同起始日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<c:choose>
						    	<c:when test="${empty project.loadBeginDate}">
						    		<input type="text"  class="col-sm-10" id="loadBeginDate" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input type="text" name="loadBeginDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadBeginDate}"/>"
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">合同到期日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<c:choose>
						    	<c:when test="${empty project.loadEndDate}">
						    		<input type="text"  class="col-sm-10" id="loadEndDate" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input type="text" name="loadEndDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.loadEndDate}"/>"
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">借据起始日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<c:choose>
						    	<c:when test="${empty project.billBeginDate}">
						    		<input type="text" name="billBeginDate" class="col-sm-10" id="billBeginDate" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input type="text" name="billBeginDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.billBeginDate}"/>"
										class="col-sm-8 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">借据到期日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<c:choose>
						    	<c:when test="${empty project.billEndDate}">
						    		<input type="text" name="billEndDate" class="col-sm-10" id="billEndDate" value="（空）" 
										style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
						    	<c:otherwise>
						    		<input type="text" name="billEndDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.billEndDate}"/>"
										class="col-sm-8 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
						    </c:choose>
						</div>
					</div>
				</div>
			</div>
			
	<div class="total-div">
		
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>解除方式：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
			        		<input type="hidden" id="freeMethodName" name="freeMethodName" class="freeMethodName">
							<select class="col-xs-10 col-sm-12 freeMethodID validate[required]" id="freeMethodID" name="freeMethodID">
                                  <c:forEach var="freeMethod" items="${freeMethodList}" varStatus="status">
                                      <option value="${freeMethod.dicTypeID}">${freeMethod.dicTypeName}</option>
                                 </c:forEach>
                             </select>
						</div>	
					</div>
				</div>
			</div>
			
			<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
			
			<div class="form-group col-sm-6">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>解除日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control col-sm-8 date-picker validate[required,custom[date]]" type="text" id="freeDate" data-date-format="yyyy-mm-dd" name="freeDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
 			
 			<div class="normalFreeSum-div">
 			
 				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>正常还款： </label>
					<div class="col-sm-8">
					    <div class="row">
					    	<div class="col-sm-10">
								<input type="text" id="normalFreeSum-input" name="normalFreeSum" class="col-sm-8 validate[required]">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>
				
				<div class="form-group  col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>解除类型：</label>
					<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-10">
				        		<input type="hidden" id="freeTypeName" name="freeTypeName" class="freeTypeName">
								<select class="col-xs-10 col-sm-12 freeTypeID validate[required]" id="freeTypeID" name="freeTypeID">
	                                  <c:forEach var="freeType" items="${freeTypeList}" varStatus="status">
	                                      <option value="${freeType.dicTypeID}">${freeType.dicTypeName}</option>
	                                 </c:forEach>
	                            </select>
							</div>	
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">其中： </label>
				</div>
	            <div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">还款本金：</label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="normalCapitalSum-input" name="normalCapitalSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div> 
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">还款利息：</label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="normalInterestSum-input" name="normalInterestSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>               
            </div>                
 			
 			
 			<div class="replaceFreeSum-div">
 				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>代偿金额： </label>
					<div class="col-sm-8">
					    <div class="row">
					    	<div class="col-sm-10">
								<input type="text" id="replaceFreeSum-input" class="col-sm-8 validate[required]" name="replaceFreeSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>
				<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">其中（分类一）： </label>
					
				</div>
				
	            <div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">代偿本金：</label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="replaceCapitalSum-input" name="replaceCapitalSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div> 
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">代偿利息：</label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="replaceInterestSum-input" name="replaceInterestSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>
				
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">代偿其他费用： </label>
					<div class="col-sm-8">
					    <div class="row">
					    	<div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="replaceOtherSum-input" name="replaceOtherSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>
				<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">其中（分类二）： </label>
				</div>
				
	            <div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">自有资金代偿：</label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="selfReplaceSum-input" name="selfReplaceSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div> 
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">准备金冲抵：</label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" class="col-sm-8 " id="dangerReplaceSum-input" name="dangerReplaceSum">
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>
				               
            </div>
    </div>
            
		 </form>
      </div>
      
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>确认责任解除</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>

    </div>
  </div>
</div>
<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {//时间控件
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){//时间聚焦
		$('#freeDate').focus();
	});
	
	$('#qBeginTime').datepicker({  
	    todayBtn : "linked",  
	    autoclose : true,  
	    todayHighlight : true,  
	    endDate : new Date()  
	}).on('changeDate',function(e){  
	    var startTime = e.date;  
	    $('#qEndTime').datepicker('setStartDate',startTime);  
	});
	
	var guarantySum = $("#guarantySum-input").val();
	if(guarantySum==null || guarantySum==""){
		guarantySum=0;
	}
	if(parseFloat(guarantySum)==0){
		$('.total-div').hide();
		$("#replaceFreeSum-input").removeClass("validate[required]");
		$("#normalFreeSum-input").removeClass("validate[required]");
		$("#freeTypeID").removeClass("validate[required]");
		$("#freeMethodID").removeClass("validate[required]");
		$("#freeDate").removeClass("validate[required,custom[date]]");
	}else{
		if($('.freeMethodID').val()=='3d08a203ab804ddf80e8d3c827bd98ae'){//无代偿解除
			$('.normalFreeSum-div').show();
			$('.replaceFreeSum-div').hide();
			$("#replaceFreeSum-input").removeClass("validate[required]");
			$("#normalFreeSum-input").addClass("validate[required]");
			$("#freeTypeID").addClass("validate[required]");
		}else{//代偿解除
			$('.normalFreeSum-div').hide();
			$('.replaceFreeSum-div').show();
			$("#replaceFreeSum-input").addClass("validate[required]");
			$("#normalFreeSum-input").removeClass("validate[required]");
			$("#freeTypeID").removeClass("validate[required]");
		}
	}
	
	
	
	$('.freeMethodName').attr("value",$('.freeMethodID option:selected').text());
	$(".freeMethodID").on("change", function () {//无代偿解除与代偿解除   的隐藏与现实切换
		if($('.freeMethodID').val()=='3d08a203ab804ddf80e8d3c827bd98ae'){//
			$('.normalFreeSum-div').show();
			$('.replaceFreeSum-div').hide();
			$("#replaceFreeSum-input").removeClass("validate[required]");
			$("#normalFreeSum-input").addClass("validate[required]");
			$("#freeTypeName").addClass("validate[required]");
		}else{
			$('.normalFreeSum-div').hide();
			$('.replaceFreeSum-div').show();
			$("#replaceFreeSum-input").addClass("validate[required]");
			$("#normalFreeSum-input").removeClass("validate[required]");
			$("#freeTypeName").removeClass("validate[required]");
		}
		$('.freeMethodName').attr("value",$('.freeMethodID option:selected').text());
    })
    
	$('.freeTypeName').attr("value",$('.freeTypeID option:selected').text());
	$(".freeTypeID").on("change", function () {//解除类型
		$('.freeTypeName').attr("value",$('.freeTypeID option:selected').text());
    })
</script>					
					