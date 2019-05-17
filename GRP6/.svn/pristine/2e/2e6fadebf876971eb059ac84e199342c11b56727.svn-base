(function($,d) {
	$.zjm_analysis = {
			initData:initData
	};
	function initData(wheresql){
		$('#id-date-range-picker').attr("value",tool.parseYearsDate(new Date().getTime()));//yyyy.fromat("yyyy")	
		
		$.post("/project/analysis/analysisOfMonthSum",
				{"wheresql":wheresql},				
				function(data){
					var id = 'analysisOfMonthSum';
					var titleArray=new Array('新增金额(万元)','无代偿解除金额(万元)','代偿解除金额(万元)','在保余额(万元)');					
					//$.zjm_echart.barVertical(id,titleArray,data);
					$.zjm_echart.lineStandard(id,titleArray,data);
					
				}
		);		
		$.post("/project/analysis/analysisEchartsOfMonthCount",
				{"wheresql":wheresql},				
				function(data){
					var id = 'analysisEchartsOfMonthCount';
					var titleArray=new Array('新增笔数(笔)','代偿解除笔数(笔)','无代偿解除笔数(笔)','在保笔数(笔)');					
					//$.zjm_echart.barVertical(id,titleArray,data);
					$.zjm_echart.lineStandard(id,titleArray,data);
					
				}
		);
		  $("#id-date-range-picker").attr("value",wheresql);		
	}	
})(jQuery,this);
$(function(){
	/*注册日期控件点击事件-只选择年月*/
	$('.date-picker').datepicker({
		language: "zh-CN",
	    todayHighlight: true,
	    autoclose: true,
	    startView: 'years',
	    maxViewMode:'years',
	    minViewMode:'years'
	}).next().on(ace.click_event, function(){$(this).prev().focus();});
	
	  var wheresql=$("#id-date-range-picker").val();
	
	  $.zjm_analysis.initData(wheresql);
	
	  $("#id-date-range-picker").bind("change",function(){		 
		  var wheresql=$("#id-date-range-picker").val();	
		  window.location.assign("/project/analysis/analysisByMonth?wheresql="+wheresql);//加载表格数据;
		  
	  });
	
});