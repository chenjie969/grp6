<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common_timestamp.jsp" %>
	<div class="page-content">
	<div class="page-header">
		<h4>录入总办会纪要</h4>
		
	</div>
		<div class="row">
			<div class="col-xs-12">
                 <form class="form-horizontal" role="form" id="meetingSummary_form">
      	        <input type="hidden" id="meetingSummary_ID" class="" name="meetingSummary_ID" value="${meetingSummary.meetingSummary_ID}">
	           <input type="hidden" id="apply_ID" name="apply_ID" value="${meetingSummary.apply_ID}">
	           <div class="space-4"></div>
					<div class="form-group col-sm-6">
					 <c:if test="${'edit' eq urlParam.type}">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"
					for="form-input"><i class="icon-asterisk orange"></i>编号：</label>
					
					<div class="col-sm-8">
						<input type="text" name="meetingCode" id="meetingCode"  class="col-sm-6 validate[required,maxSize[50]]" value="${meetingSummary.meetingCode}" />
						<span class="midden col-sm-5" style="line-height:28px;"></span>
					</div>
					</c:if>
					<c:if test="${'view' eq urlParam.type }">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"
					for="form-input">编号：</label>
					<label class="col-sm-8 grey">${meetingSummary.meetingCode}</label>
					</c:if>
					
              </div>
      		 <div class="form-group col-sm-6">
      		  <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1" for="form-input">
				<i class="icon-asterisk orange"></i>签发人：</label>
				
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group signUserName">
								<input  type="text"  class="form-control validate[required]" id="signUserName" name="signUserName" autoField="juryUserUids" readonly="readonly" value="${meetingSummary.signUserName}"/>
								<span class="input-group-addon midden">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1" for="form-input">签发人：</label>
							    <label class="col-sm-8 grey">${meetingSummary.signUserName}</label>
							</c:if>
			</div>
			
 			<div class="form-group col-sm-6">
 			  <c:if test="${'edit' eq urlParam.type}">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>时间： </label>
		       
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-6 no-padding-right">
							<div class="input-group">
								<input class="form-control  validate[required]" type="text"  id="datetime-picker" data-date-format="yyyy-mm-dd hh:ii" name="meetingDateTimeStr" value="<fmt:formatDate value="${meetingSummary.meetingDateTime }" pattern="yyyy-MM-dd HH:mm" type="both"/>"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							<label class="col-sm-4 control-label no-padding-right" for="form-input">时间： </label>
							   <label class="col-sm-8 grey"><fmt:formatDate value="${meetingSummary.meetingDateTime }" pattern="yyyy-MM-dd HH:mm" type="both"/></label>
							</c:if>
 			</div>
 			
 			<div class="form-group col-sm-6">
 			 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>主持：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group compereUserName">
								<input  type="text"  class="form-control validate[required]" id="compereUserName" name="compereUserName" autoField="juryUserUids2" readonly="readonly" value="${meetingSummary.compereUserName}"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1">主持：</label>
							   <label class="col-sm-8 grey">${meetingSummary.compereUserName}</label>
							
							</c:if>
			</div>
			
			<div class="form-group col-sm-6">
			 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>出席：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-6 ">
							<div class="input-group userNameList">
								<input  type="text"  class="form-control validate[required,maxSize[500]]" id="userNameList" name="userNameList" autoField="juryUserUids3" readonly="readonly" value="${meetingSummary.userNameList}"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							 <label class="col-sm-4 control-label no-padding-right" for="form-field-1">出席：</label>
							   <label class="col-sm-8 grey">${meetingSummary.userNameList}</label>
							</c:if>
			</div>
			
			<div class="form-group col-sm-6">
			 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>缺席：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group absenceUserNameList">
								<input  type="text"  class="form-control validate[required,maxSize[500]]" id="absenceUserNameList" name="absenceUserNameList" autoField="juryUserUids4" readonly="readonly" value="${meetingSummary.absenceUserNameList}"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1">缺席：</label>
							   <label class="col-sm-8 grey">${meetingSummary.absenceUserNameList}</label>
							 
							</c:if>
			</div>
			
			<div class="form-group  col-sm-6">
			 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>列席：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group attendUserNameList">
								<input  type="text"  class="form-control validate[required,maxSize[500]]" id="attendUserNameList" name="attendUserNameList" autoField="juryUserUids5" readonly="readonly" value="${meetingSummary.attendUserNameList}"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							 <label class="col-sm-4 control-label no-padding-right" for="form-field-1">列席：</label>
							   <label class="col-sm-8 grey">${meetingSummary.attendUserNameList}</label>
							
							</c:if>
			</div>
			
			<div class="form-group col-sm-6 ">
			 <c:if test="${'edit' eq urlParam.type}">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>记录：</label>
				
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group recordUserName">
								<input  type="text"  class="form-control validate[required]" id="recordUserName" name="recordUserName" autoField="juryUserUids6" readonly="readonly" value="${meetingSummary.recordUserName}"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${'view' eq urlParam.type }">
							  <label class="col-sm-4 control-label no-padding-right" for="form-field-1">记录：</label>
							   <label class="col-sm-8 grey">${meetingSummary.recordUserName}</label>
							  
							</c:if>
			</div>
			
			<div class="form-group">
				   <label class="col-sm-2 control-label no-padding-right" for="form-field-1">会议主要内容及议定事项： </label>
		         <c:if test="${'edit' eq urlParam.type}">
		           <div class="col-sm-10">
		               <textarea class="col-sm-9 limited validate[maxSize[2000]]" rows="6" id="mainContent"  name="mainContent" >${meetingSummary.mainContent=="null"?"(空)":meetingSummary.mainContent}</textarea>
		           	<div class="col-sm-9 no-padding-right">
		                <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
		           </c:if>
		           <c:if test="${'view' eq urlParam.type }">
							    <label class="col-sm-8 grey">${meetingSummary.mainContent=="null"?"(空)":meetingSummary.mainContent}</label>
							
							
							</c:if>
			</div>
			
		 </form> 
		 
		 <div class="space-20"></div>
		 <c:if test="${'view' ne urlParam.type }">
	      <div class="clearfix form-actions">
				<div class="col-md-offset-4 col-md-8">
				 
			       <button class="btn btn-primary " id="btn_insertOneMeetSummary" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
			        &nbsp; &nbsp; &nbsp;
			       <button class="btn btn_colse" id="btn_colseOneMeetSummary" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
	            
	            </div>
	      </div>
      	</c:if>       
		</div>
		</div>
	</div>

<div id="meetingSummary_page"></div>

<%@ include file="/common_del.jsp"%> <!-- 公共提示框 -->

<script src="<%=path%>/project/meetingSummary/meetingSummary.js?v=<%=vardate%>"></script>
<script type="text/javascript">

$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#signUserName").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple : false,//是否多选
			data : data.obj//数据源
		});
		
    }
});
$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#compereUserName").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple :false,//是否多选
			data : data.obj//数据源
		});
		
    }
});
$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#userNameList").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple : true,//是否多选
			data : data.obj//数据源
		});
		
    }
});
$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#absenceUserNameList").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple : true,//是否多选
			data : data.obj//数据源
		});
		
    }
});
$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#attendUserNameList").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple : true,//是否多选
			data : data.obj//数据源
		});
		
    }
});
$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
	success:function(data) {		
		$("#recordUserName").selectTreeWidgets({
			width : "87%",//设置控件宽度
			multiple : false,//是否多选
			data : data.obj//数据源
		});
		
    }
});
/*注册日期控件点击事件*/
$('#datetime-picker').datetimepicker({language:"zh",autoclose:true,minuteStep:10}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script>
