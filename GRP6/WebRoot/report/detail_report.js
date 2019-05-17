(function($,d){
	$.zjm_reportSelect = {
			getSelectText:getSelectText,
			
	};
	function getSelectText(selectType){
		var dateType = tool.getUrlParam('dateType');//统计时间类型
		var formType = '';
		var pageType = '';
		var dateTypeID = '';
		
		 if('beginAndEnd' ==dateType){//起始日期-到期日期
			 formType = 'reportSelect_form_beginAndEnd';
			 pageType = 'reportSelect_beginAndEnd';
			// dateTypeID = 'dateTypeID_beginAndEnd';
		 }else if("yearMonth" ==dateType){//统计年月
			 formType = 'reportSelect_form_yearMonth';
			 pageType = 'reportSelect_yearMonth';
			 //dateTypeID = 'dateTypeID_yearMonth';
		 }else if("endDate" == dateType){//统计日期(单个日期)
			 formType = 'reportSelect_form_endDate';
			 pageType = 'reportSelect_endDate';
			// dateTypeID = 'dateTypeID_endDate';
		 }else if("endDateAndGroup" == dateType){//统计日期(单个日期)
			 formType = 'reportSelect_form_endDate_group';
			 pageType = 'reportSelect_endDate_group';
			// dateTypeID = 'dateTypeID_endDate_group';
		 }else if("yearMonthAndGroup" == dateType){//统计年月-分组
			 formType = 'reportSelect_form_yearMonth_group';
			 pageType = 'reportSelect_yearMonth_group';
			 //dateTypeID = 'dateTypeID_yearMonth_group';
		 }else if("yearAndGroup" == dateType){//统计年-分组
			 formType = 'reportSelect_form_year_group';
			 pageType = 'reportSelect_year_group';
			// dateTypeID = 'dateTypeID_year_group';
		 }else if("beginAndEndGroup" == dateType){//统计年月日-分组
			 formType = 'reportSelect_form_beginAndEnd_group';
			 pageType = 'reportSelect_beginAndEnd_group';
			// dateTypeID = 'dateTypeID_beginAndEnd_group';
		 }
		
	
	$("#report_page").load("/report/returnReportSelectPage",{"pageType":pageType},function(response,status,xhr){ 
		
		$("#"+pageType).modal({keyboard:true});//显示页面;
		if('default'==selectType){
			$(".btn_close").hide();
		}
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
		//$('#'+dateTypeID).attr("value",dateType);
		 //设置页面默认值---end
		$("#btn_close").attr("disabled",true); 
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
				//var dateType = $('#'+dateTypeID).val();
				var endyearsql = $("#endyearsql").val();
				var dataJurisdictionSql = $("#wheresql").val();
				dataJurisdictionSql = dataJurisdictionSql.replace(/\%/g,'%25');
				var isGuarantyOrg = "and pp.guarantorsName in (\'担保集团本部\',\'中瑞\',\'中泽\',\'中小微\')";
				isGuarantyOrg = isGuarantyOrg.replace(/\%/g,'%25');
				
				iframW.location.href = actionUrl+"file="+file
				  +"&begindatesql="+begindatesql
				  +"&enddatesql="+enddatesql
				  +"&endyearmonthsql="+endyearmonthsql
				  +"&groupTypeName="+groupTypeName
				  +"&endyearsql="+endyearsql
				  +"&dataJurisdictionSql="+dataJurisdictionSql
				  +"&isGuarantyOrg="+isGuarantyOrg
				 // +"&dateType="+dateType
				  ;
				$("#report_iframe").load(function(){
				    var mainheight = $(this).contents().find("#_page_1").height();
				    $(this).height(mainheight);
				    $("#reportSelect").show();
				});
				
				$("#"+pageType).modal("hide");
				
			}
		});
		
		$("#"+pageType).on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	 
	});
	}
})(jQuery,this);
$(function() {
	
	$.zjm_reportSelect.getSelectText("default");//第一次加载
	$("#reportSelect").click(function(){
		
		$("#reportSelect").hide();
		$.zjm_reportSelect.getSelectText("select");//查询加载
	});
	
});		