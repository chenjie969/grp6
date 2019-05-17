(function($,d) {
	$.zjm_analysis = {
			initData:initData
	};
	function initData(){
		
		$.post("/project/analysis/analysisByBusiType",
				{analysisType:"years"},				
				function(data){
					var id = 'analysisByBusiType';
					var titleArray=new Array('在保金额(万元)','笔数(笔)','户数(户)');					
					//$.zjm_echart.barVertical(id,titleArray,data);
					$.zjm_echart.lineStandard(id,titleArray,data);
					
				}
		);
		
		$.post("/project/analysis/analysisByClientType",
				{analysisType:"years"},				
				function(data){
					var id ='analysisByClientType';
					var titleArray=new Array('担保金额');
					$.zjm_echart.pieStandard(id,titleArray,data);
				}
		);
		
		$.post("/project/analysis/analysisByDepart",
				{analysisType:"years"},				
				function(data){
					var id ='analysisByDepart';
					var titleArray=new Array('在保金额(万元)','笔数(笔)','户数(户)');	
					$.zjm_echart.barVertical(id,titleArray,data);
				}
		);	
		
		/*$("#analysisByDepart2").load("",function(){
			
		});
		$("#analysisByDepart2").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});*/
		
		
	}
	
	
})(jQuery,this);
$(function(){
	$.zjm_analysis.initData();
	
	$(".analysisType").click(function(){
		var analysisType = $(this).attr("id");
		
		if("years" == analysisType){
			$("#analysisTitleType").text("历年累计");
			$("#yearsi").removeClass("invisible");
			$("#monthsi").addClass("invisible");
		}else{
			$("#analysisTitleType").text("本年发生");
			$("#monthsi").removeClass("invisible");
			$("#yearsi").addClass("invisible");
		}
		
		$.zjm_analysis.initData();
	});
});