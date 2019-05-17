		
<%@ page import="com.zjm.crm.report.model.ReportParam"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common_head.jsp" %>
​<%@ include file="/common_foot.jsp" %>
<style>
<!--
div#header {
	position: absolute;
	top: 0;
	left: 0;
	padding: 3px 3px 3px 3px;
	width: 100%;
	height: 30px; 
}

.active-page {
	border: solid 2 blue
}

body>div#header {
	position: fixed;
}

div#_container_div {
	height: 100%;
	overflow: auto;
}

BUTTON {
	padding: 0px;
	margin: 0px;
}

.toolbutton {
	width: 25px;
	height: 25px;
	background-repeat: no-repeat center center;
	margin: 0px;
	padding-left: 0px;
	padding-right: 0px"> 
-->
}
</style>

<script>
	function doZoom(z) {
		if (z.indexOf('-') == -1)
			jatoolsbar.zoomTo(z);
		else if (z == '-100')
			jatoolsbar.fitWholePage();
		else if (z == '-200')
			jatoolsbar.fitPageWidth();
		zoomChooser.value = z;
	}
   
	function zoom(how) {

		val = null;
		items = new Array(15, 30, 50, 75, 100, 125, 200, 300, 350, 400);
		z = jatoolsbar.currentScale;
		f = false;
		if (how == '+') {
			z++;
			for (i = 0; i < items.length; i++) {
				if (items[i] > z) {
					z = items[i];
					f = true;
					break;
				}
			}
		} else {
			z--;
			for (i = items.length - 1; i >= 0; i--) {
				if (items[i] < z) {
					z = items[i];
					f = true;
					break;
				}
			}
		}
		if (f) {
			doZoom(z + '');
		}
	}
	var jatoolsbar = null;
	$().ready(
			function() {
				var pageChanged = function() {
					$('#_page_info')
							.html(
									jatoolsbar.currentPage + "/"
											+ jatoolsbar.pageCount);
				};
				jatoolsbar = new Jatoolsbar({
					container : '#_container_div',
					listeners : [ pageChanged ]
				});

				jatoolsbar.firstPage();

			});
	function reportSelect(){//重新加载页面；
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
		
		
	$("#reportCountIfPage").load("/report/returnReportSelectPage",{"pageType":pageType},function(response,status,xhr){ 
		 
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
				//var iframW =$("#report_iframe2").contentWindow;
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
				    location.reload();
				});
				
				$("#"+pageType).modal("hide");
				
			}
		});
		
		$("#"+pageType).on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	 
	});
		
	};
</script>
<jatools:container id="_container"
	style='margin:0;zoom:100%;height:100%;width:100%;overflow:auto;border:medium none thin threedhighlight inset;background:#808080' />
<%-- <% 
	ReportParam rp10 = (ReportParam)request.getAttribute("reportParam");
	System.out.println("******************"+rp.getBegindatesql());
	System.out.println("*********begindatesql*********"+request.getAttribute("begindatesql"));
%> --%><!-- style="z-index:999;position: 0;" -->
<div id='header' class="report_tools" style="z-index:999;">
	<ul class="tools">
		<li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.exportAs("xls")'>
				<img alt="导出成Excel" src="<%=path %>/report/img/x.png" width="22px">
			</span>
		</li>
		<%-- <li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.exportAs("rtf")'>
				<img alt="导出成Word" src="<%=path %>/report/img/w.png" width="22px">
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.exportAs("pdf")'>
				<img alt="导出成PDF" src="<%=path %>/report/img/pdf_2.png" width="22px">
			</span>
		</li> --%>
		<li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.firstPage()'>
				<img alt="第一页" src='<%=path %>/tools/images/first.gif' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.previousPage()'>
				<img alt="上一页" src='<%=path %>/tools/images/previous.gif' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-pageCount" id='_page_info'></span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.nextPage()'>
				<img alt="下一页" src='<%=path %>/tools/images/next.gif' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='jatoolsbar.lastPage()'>
				<img alt="最后一页" src='<%=path %>/tools/images/last.gif' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='zoom("-")' title='缩小'>
				<img alt="缩小" src='<%=path %>/report/img/min_2.png' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='zoom("+")'>
				<img alt="放大" src='<%=path %>/report/img/mout_2.png' width="22px"/>
			</span>
		</li>
		<!-- <li class="tools-item">
			<select size="1" class="selectScale" name="zoomChooser" onchange='doZoom(zoomChooser.value)'>
				<option value="15">15%</option>
				<option value="30">30%</option>
				<option value="50">50%</option>
				<option value="75">75%</option>
				<option value="100" selected>100%</option>
				<option value="125">125%</option>
				<option value="200">200%</option>
				<option value="300">300%</option>
				<option value="350">350%</option>
				<option value="400">400%</option>
				<option value="-100">整页</option>
				<option value="-200">页宽</option>
			</select>
		</li> -->
		<li class="tools-item">
			<span class="tools-icon" onclick='doZoom("100")'>
				<img title="原始大小" src='<%=path %>/tools/images/zoom100.gif' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='doZoom("-100")'>
				<img title="整页显示" src='<%=path %>/tools/images/zoom100.gif' width="22px"/>
			</span>
		</li>
		<li class="tools-item">
			<span class="tools-icon" onclick='doZoom("-200")'>
				<img title="按页宽度" src='<%=path %>/tools/images/zoom100.gif' width="22px"/>
			</span>
		</li>
		<%-- <li class="tools-item-text">data-statsCondition='<%=JSON.toJSON(rp10) %>'
			<!-- <span class="tools-text" id="reportCountIf" > -->
			<span  id="reportCountIf"  onclick='reportSelect()' >
				统计条件
			</span>
		</li> --%>
		<!-- <li class="tools-item-text">
			<span  id="rrr" onclick='reportSelect()' >
				统计条件123
			</span>
		</li> -->
	</ul>
</div>


<%
	_container.writeOut();
%>

