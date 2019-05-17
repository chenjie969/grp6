(function($,d) {
	$.zjm_analysis = {
			initData:initData
	};
	function initData(){
		$('#id-date-range-picker').attr("value",tool.parseYearsDate(new Date().getTime()));//yyyy.fromat("yyyy")	
		
		$.post("/project/analysis/analysisOfYearsSum",
				{},				
				function(data){
					var id = 'analysisOfYearsSum';
					var titleArray=new Array('新增金额(万元)','无代偿解除金额(万元)','代偿解除金额(万元)','在保余额(万元)');					
					$.zjm_echart.lineStandard(id,titleArray,data);
					
				}
		);		
		$.post("/project/analysis/analysisEchartsOfYearsCount",
				{},				
				function(data){
					var id = 'analysisEchartsOfYearsCount';
					var titleArray=new Array('新增笔数(笔)','代偿解除笔数(笔)','无代偿解除笔数(笔)','在保笔数(笔)');					
					$.zjm_echart.lineStandard(id,titleArray,data);
					
				}
		);
	}	
})(jQuery,this);
$(function(){
	/*注册日期控件点击事件-只选择年月*/
	
	  $.zjm_analysis.initData();
	
});