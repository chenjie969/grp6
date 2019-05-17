<!-- <style>
  #reportSelect div{
 	position: relative;
    left: 594px;
    top: 47px;
  }
    
</style> -->
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
​<%@ include file="/common_foot.jsp" %>
<%@page import="com.zjm.sys.util.RolesDataAccreditUtil" %>
<%@page import="com.zjm.util.SystemSession" %>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy" var="currentYear"/>
<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM" var="currentYearMonth"/>
<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="currentDate"/>

<c:set var="beginYearDate" value="${currentYear}-01-01" scope="page"></c:set>

<!-- <style type="text/css">
			/*主要样式*/
			.subNavBox{width:20%;border:solid 1px #e5e3da; float: left;/* margin:100px auto; */}
			.subNav{border-bottom:solid 1px #e5e3da;cursor:pointer;/* font-weight:bold; */font-size:14px;color:rgb(102, 102, 102);line-height:28px;padding-left:10px;background:url(img/jiantou1.jpg) no-repeat;background-position:95% 50%}
			.subNav:hover{color:#277fc2;}
			.currentDd{color:#277fc2}
			.currentDt{background-image:url(img/jiantou.jpg);}
			.navContent{display: none;border-bottom:solid 1px #e5e3da;}
			.navContent li a{display:block;/* width:100%; */heighr:28px;text-align:left;padding-left: 25px;font-size:14px;line-height:28px;color:#333}
			.navContent li a:hover{color:#fff;background-color:#277fc2}
			.currentItem{color:#fff;background-color:#277fc2}
</style>
		 -->
<html>
	<head>
		<title>担保集团报表</title>
		<link href="report.css" rel="stylesheet">
		<script type="text/javascript" src="report.js"></script>
		<%-- <link href="<%=path %>/report/report_display.css?v=<%=vardate%>" rel="stylesheet"> --%>
		<script type="text/javascript" src="/report/detail_report.js"></script>
		<!-- <script type="text/javascript" >
			$(function() {
				var dateType = tool.getUrlParam('dateType');//统计时间类型
				var formType = '';
				var pageType = '';
				var dateTypeID = '';
				
				 if('beginAndEnd' ==dateType){//起始日期-到期日期
					 formType = 'reportSelect_form_beginAndEnd';
					 pageType = 'reportSelect_beginAndEnd';
					 dateTypeID = 'dateTypeID_beginAndEnd';
				 }else if("yearMonth" ==dateType){//统计年月
					 formType = 'reportSelect_form_yearMonth';
					 pageType = 'reportSelect_yearMonth';
					 dateTypeID = 'dateTypeID_yearMonth';
				 }else if("endDate" == dateType){//统计日期(单个日期)
					 formType = 'reportSelect_form_endDate';
					 pageType = 'reportSelect_endDate';
					 dateTypeID = 'dateTypeID_endDate';
				 }else if("endDateAndGroup" == dateType){//统计日期(单个日期)
					 formType = 'reportSelect_form_endDate_group';
					 pageType = 'reportSelect_endDate_group';
					 dateTypeID = 'dateTypeID_endDate_group';
				 }else if("yearMonthAndGroup" == dateType){//统计年月-分组
					 formType = 'reportSelect_form_yearMonth_group';
					 pageType = 'reportSelect_yearMonth_group';
					 dateTypeID = 'dateTypeID_yearMonth_group';
				 }else if("yearAndGroup" == dateType){//统计年-分组
					 formType = 'reportSelect_form_year_group';
					 pageType = 'reportSelect_year_group';
					 dateTypeID = 'dateTypeID_year_group';
				 }else if("beginAndEndGroup" == dateType){//统计年月日-分组
					 formType = 'reportSelect_form_beginAndEnd_group';
					 pageType = 'reportSelect_beginAndEnd_group';
					 dateTypeID = 'dateTypeID_beginAndEnd_group';
				 }
				
				
			$("#report_page").load("/report/returnReportSelectPage",{"pageType":pageType},function(response,status,xhr){ 
				 
				$("#"+pageType).modal({keyboard:true});//显示页面;
				 /*注册日期控件点击事件:年月日*/
				$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});	
				 /*注册日期控件点击事件:年月*/
				/*注册日期控件点击事件-只选择年月----start*/
				$('.date-picker2').datepicker({
					language: "zh-CN",
			        todayHighlight: true,
			        autoclose: true,
			        startView: 'months',
			        maxViewMode:'years',
			        minViewMode:'months'
				}).next().on(ace.click_event, function(){$(this).prev().focus();});
				/*注册日期控件点击事件-只选择年月----end*/
				/*注册日期控件点击事件-只选择年----start*/
				$('.date-picker3').datepicker({
					language: "zh-CN",
			        todayHighlight: true,
			        autoclose: true,
			        startView: 'years',
			        maxViewMode:'years',
			        minViewMode:'years'
				}).next().on(ace.click_event, function(){$(this).prev().focus();});
				/*注册日期控件点击事件-只选择年----end*/
				
				 //设置页面默认值---start
				var newDate = new Date();
				newDate.setDate(1);
				var begindatesql = tool.parseDate(newDate.getTime());
				$('#begindatesql').attr("value",begindatesql);//yyyy-mm-dd .fromat("yyyy-MM-dd")
				$('#enddatesql').attr("value",tool.parseDate(new Date().getTime()));//yyyy-mm-dd .fromat("yyyy-MM-dd")
				$('#endyearmonthsql').attr("value",tool.parseYearsMonthDate(new Date().getTime()));//yyyy-mm .fromat("yyyy-MM")
				$('#endyearmonthsql2').attr("value",tool.parseYearsMonthDate(new Date().getTime()));//yyyy-mm .fromat("yyyy-MM")
				$('#endyearsql').attr("value",tool.parseYearsDate(new Date().getTime()));//yyyy .fromat("yyyy")
				$('#'+dateTypeID).attr("value",dateType);
				
				 //设置页面默认值---end
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(e){//点击查询按钮		
					if($("#"+formType).validationEngine("validate")){
						var queryContainer_form = $("#"+formType);
						
						var reportParam = queryContainer_form.serializeJson();						
						var file = "reportXML/clientDetail.xml";
						var actionUrl = "/report/returnReportDefaultviewer2?";
						var iframW = document.getElementById("report_iframe").contentWindow;
						var reportParam ={"reportParam":reportParam}
						var file = tool.getUrlParam('file');//获取报表名称
						var begindatesql = $("#begindatesql").val();
						var enddatesql = $("#enddatesql").val();
						var endyearmonthsql = $("#endyearmonthsql").val();
						var groupTypeName = $("#groupTypeName").val();
						var dateType = $('#'+dateTypeID).val();
						var endyearsql = $("#endyearsql").val();
						
						iframW.location.href = actionUrl+"file="+file
						  +"&begindatesql="+begindatesql
						  +"&enddatesql="+enddatesql
						  +"&endyearmonthsql="+endyearmonthsql
						  +"&groupTypeName="+groupTypeName
						  +"&endyearsql="+endyearsql
						  +"&dateType="+dateType
						  ;
						$("#report_iframe").load(function(){
						    var mainheight = $(this).contents().find("#_page_1").height();
						    $(this).height(mainheight);
						});
						
						$("#"+pageType).modal("hide");
						
					}
				});
				
				$("#"+pageType).on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			 
			});
		}
		)		
		</script> -->
		
	</head>
	<body>
		<input type="hidden"  id="user_uid" value="${sessionScope.sessionUser.user_uid }"  >
		<%
			String userId = SystemSession.getRealUserSession().getUser_uid();
			String wheresql =  RolesDataAccreditUtil.appendProSqlByABC(userId, "pp.");
		%>
		<input type="hidden" id="wheresql" value="<%=wheresql%>">
		
				<div class="loadReportView" data-file="reportXML/clientDetail.xml">
				<!-- 列表结束 -->
				</div> <!-- style="position: relative;left: 594px;top: 25px;display:none;width:100px;" -->
				<div id="reportSelect"  style="position: relative;left: 594px;top: 25px;display:none;width:100px;">
					<button class="tools-item-text" style="color: #FF2D2D;">
						统计条件
					</button>
				</div>
				<!-- 报表显示区域 -->
				<div class="">
					&nbsp;
					<iframe id="report_iframe" class="report-display-c" scrolling="yes"></iframe>
				</div>
				
				
				
				<div id="report_page"></div>
				<!-- 报表显示区域end -->
				
               
    </body>
	<%-- <body>
		<div class="show-classify bd-inner">
			<div class="show-classify-find clearfix">
				<div class="report">
					<div class="report-content">
						<!-- 列表 -->
						<div class="subNavBox">
						<div class="subNav loadReportView"  
								data-file="reportXML/clientDetail.xml" 
								data-beginDate="${beginYearDate}" data-endDate="${currentDate}" 
								data-statsCondition="统计期间,合作放款机构,业务品种,经办机构,A角,B角,C角,期限长短,担保金额大小,业务性质,项目类型,区域" 
								data-unituid="${UserSession.unit_uid}" data-dateName="统计期间">
								客户明细表
						</div>
						
						
						</div>	
						<div class="loadReportView" data-file="reportXML/clientDetail.xml">
						<!-- 列表结束 -->
						</div> 
						<!-- 报表显示区域 -->
						<div class="report-display">
							&nbsp;
							<iframe id="report_iframe" class="report-display-c" scrolling="yes"></iframe>
						</div>
						<!-- 报表显示区域end -->
					</div>
				</div>
			</div>
		</div>
	</body> --%>
	
	
</html>

<%-- <%@ include file="/report/reportSelect_beginAndEnd.jsp"%><!-- 报表查询页面_统计区间 -->	
<%@ include file="/report/reportSelect_yearMonth.jsp"%><!-- 报表查询页面_按年月 -->	
<%@ include file="/report/reportSelect_endDate.jsp"%><!-- 报表查询页面_统计日期 -->	
<%@ include file="/report/reportSelect_yearMonth_group.jsp"%><!-- 报表查询页面_统年月 -->
<%@ include file="/report/reportSelect_year_group.jsp"%><!-- 报表查询页面_统年 -->
<%@ include file="/report/reportSelect_beginAndEnd_group.jsp"%><!-- 报表查询页面_统年 月日-分组-->
 --%>