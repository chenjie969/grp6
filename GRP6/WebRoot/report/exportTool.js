(function($,d){
	var reportedCountIf = $(".reportedCountIf");
	reportedCountIf.click(function(e){
		var loadExportDataUrl = $(e.target).attr("data-loadExportDataUrl");
		var hzgxw_reportedPage = $("#hzgxw_reportedPage");
		hzgxw_reportedPage.load(
			"/report/window_reportedCountIfPage.action",
			{},
			function(response,status,xhr){
				document.getElementById("hzgxw_reportedPage").innerHTML = response;
				/**
				 * 注册编辑页面弹出事件
				 */
				var dialogMe = tool.dialog({
					title:"统计条件",
					showid:"hzgxw_reportedPage",
					width:"500",
					position: [158,60] //调整弹出窗口的显示位置
				});
				/**
				 * 关闭弹出窗口
				 */
				$("#btn_close").click(function(){
					dialogMe.dialog("close");
				});
				
				
				$(".selectDate").datepicker({
					  showMonthAfterYear: true, // 月在年之后显示  
					  changeMonth: true,   // 允许选择月份  
					  changeYear: true,   // 允许选择年份  
					  dateFormat:'yy-mm-dd',  // 设置日期格式  
					  closeText:'关闭',   // 只有showButtonPanel: true才会显示出来  
					  duration: 'fast',  //关闭效果
					  showAnim:'fadeIn',  //打开效果
					  showButtonPanel: true, 
					  showOtherMonths: true,
					  maxDate : null,
					  minDate: null,
					  yearRange : "c-100:c+100"
				});
				
				$("#submitReported_CountIf").click(function(){
					var reported_begindate = $("#reported_begindate").val();
					var reported_enddate = $("#reported_enddate").val();
					window.location.href = loadExportDataUrl + "?reportedBegindate=" + reported_begindate + "&reportedEnddate=" + reported_enddate;
				});
				
			}
		);
	});
})(jQuery,this);