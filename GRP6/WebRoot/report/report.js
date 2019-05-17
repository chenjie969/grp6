/**
 * 此处设置页面所需要的事件
 */
(function($,z){
	$.zjm_report = {
			init : init,
			loadReport : loadReport,
			reportCountIf : reportCountIf	// 统计条件
	};
	
	function init(){
		
		/**
		 * 必填字段
		 * 使用方法: class="requiredField"
		 */
//		$(".requiredField").after("<span class='requiredField_style'> *</span>");
		$(".requiredField").css("border","1px solid red");
		
		$(".selectDate").datepicker(
				{  
					  showMonthAfterYear: true, // 月在年之后显示  
					  changeMonth: true,   // 允许选择月份  
					  changeYear: true,   // 允许选择年份  
					  dateFormat:'yy-mm-dd',  // 设置日期格式  
					  closeText:'关闭',   // 只有showButtonPanel: true才会显示出来  
					  duration: 'fast',  //关闭效果
					  showAnim:'fadeIn',  //打开效果
//					  showOn:'button',   // 在输入框旁边显示按钮触发，默认为：focus。还可以设置为both  
//					  buttonImage: 'images/commons/calendar.gif',   // 按钮图标  
//					  buttonImageOnly: true,        // 不把图标显示在按钮上，即去掉按钮  
//					  buttonText:'选择日期',  //
					  showButtonPanel: true,  
					  showOtherMonths: true,
					  maxDate : null,
					  minDate: null,
					  yearRange : "c-50:c+50",
					  onClose : function(dateText, inst){
//						  alert(dateText+"ok"+inst);
//						  $(this).datepicker('hide');
					  }
//					  appendText: '(yyyy-mm-dd)',  //
					}		
				);
		
		$(".selectYearMonth").datepicker(
				{  
					  showMonthAfterYear: true, // 月在年之后显示  
					  changeMonth: true,   // 允许选择月份  
					  changeYear: true,   // 允许选择年份  
					  dateFormat:'yy-mm',  // 设置日期格式  
					  closeText:'关闭',   // 只有showButtonPanel: true才会显示出来  
					  duration: 'fast',  //关闭效果
					  showAnim:'fadeIn',  //打开效果
					  showButtonPanel: true,  
					  showOtherMonths: true,
					  maxDate : null,
					  minDate: null,
					  yearRange : "c-50:c+50",
					  onClose : function(dateText, inst){
					  }
					}		
				);
	}
	/**
	 * 统计条件
	 */
	function reportCountIf(e){
		var statsCondition = $(e.target).attr("data-statsCondition");
		var jsonToParam = $.parseJSON(statsCondition);
		$("#reportCountIfPage").load(
				"/report/window_returnFinancingReportCountry.action",
				jsonToParam,
				function(response,status,xhr){
					$.zjm_report.init();
					//注册  合作银行 下拉框树
					$.post(
							"/sys/returnAllBankSortList.action",
							{},
							function(sort){
								$("#bankSort_select").selectTreeWidgets({
									width : "210px",
									data : sort.bankSortList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//注册  法院 下拉框树
					$.post(
							"/sys/returnCourtSortList.action",
							{},
							function(courtSort){
								$("#courtSort_select").selectTreeWidgets({
									width : "210px",
									data : courtSort.courtSortList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					
					//注册  建委 下拉框树
					$.post(
							"/sys/returnConstructionSortList.action",
							{},
							function(constructionSort){
								$("#constructionSort_select").selectTreeWidgets({
									width : "210px",
									data : constructionSort.constructionSortList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//注册  业务品种 下拉框树
					$.post(
							"/sys/returnOneTypeBusiSort.action",
							{},
							function(sort){
								$("#busiSort_select").selectTreeWidgets({
									width : "210px",
									data : sort.oneTypeBusiSortList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//注册  业务部门 下拉框树
					$.post(
							"/sys/returnAllDepartSortList.action",
							{},
							function(sort){
								$("#departSort_select").selectTreeWidgets({
									width : "210px",
									data : sort.departList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//注册  区域下拉框树
					$.post(
							"/sys/returnAreaDicList.action",
							{},
							function(sort){
								$("#areaSort_select").selectTreeWidgets({
									width : "210px",
									data : sort.sysAreaSortList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//A角
					$.post(
							"/sys/returnDepartUserTree.action",
							{},
							function(sort){
								$("#amanID_select").selectTreeWidgets({
									width : "210px",
									data : sort.treeModelList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//B角
					$.post(
							"/sys/returnDepartUserTree.action",
							{},
							function(sort){
								$("#bmanID_select").selectTreeWidgets({
									width : "210px",
									data : sort.treeModelList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					//C角
					$.post(
							"/sys/returnDepartUserTree.action",
							{},
							function(sort){
								$("#cmanID_select").selectTreeWidgets({
									width : "210px",
									data : sort.treeModelList,
									isParentUp : true,
									isRequired : false
								});
							},
							"json"
					);
					
					// 设置 担保期限长短
					$("#CperiodType_select").selectmenu({
					 change: function( event, data ) {
							$("#CperiodType_minVal").val(data.item.minVal);
							$("#CperiodType_maxVal").val(data.item.maxVal);
							$("#CperiodType_isInMin").val(data.item.isInMin);
							$("#CperiodType_isInMax").val(data.item.isInMax);
							$("#CperiodType_name").val(data.item.itemName);
						 }
					});
					
					// 设置 担保金额大小
					 $("#CguaraSumSet_select").selectmenu({
						 change: function( event, data ) {
							$("#CguaraSumSet_minVal").val(data.item.minVal);
							$("#CguaraSumSet_maxVal").val(data.item.maxVal);
							$("#CguaraSumSet_isInMin").val(data.item.isInMin);
							$("#CguaraSumSet_isInMax").val(data.item.isInMax);
							$("#CguaraSumSet_name").val(data.item.itemName);
						 }
					});
					
					//折叠统计条件
					$("#fold-countIf-part").click(function(){
						if($(".isshow_countIf").is(":hidden")){
							$("#fold-countIf").html("收起");
						}else{
							$("#fold-countIf").html("展开");
						}
						$(".isshow_countIf").each(function(index,element){
							//if(index > 1){
								$(element).toggle();
							//}
						});
					});
					$("#reportCountIf_form").validationEngine("attach",{
						promptPosition : "topRight", // 设置提示框的位置
						 //可选的值:TopRight,TopLeft,BottomRight,BottomLeft,CenterRight,CenterLeft,Inline,
						scroll : false, // 设置是否开启卷轴,定位带错误的第一个提示处
						validateNonVisibleFields:true,//是否验证不可见的元素
						promptPosition:"topRight:27,5", 
						maxErrorsPerField:true,//单个元素显示错误提示的最大数量，值设为数值。默认 false 表示不限制。
						autoPositionUpdate:true,//是否自动调整提示层的位置
						binded:false//是否绑定即时验证   如果希望只在表单提交时验证设置参数为true
					});//绑定表单验证
					
					
					
					//打开弹出窗口
					tool.dialog({
						title:"统计条件",
						showid:"reportCountIfPage",
						position: [158,60] //调整弹出窗口的显示位置
					});
					$("#btn_close").click(function(){
						$("#reportCountIfPage").dialog("close");
					});
					
					
					/*$("select[name='projectHeaderA']").change(function(e){
						if($(e.target).val() !== ''){
							$("#projectHeaderA_text").val($(e.target).find("option:selected").text());
						}
					});
					
					$("select[name='projectHeaderB']").change(function(e){
						if($(e.target).val() !== ''){
							$("#projectHeaderB_text").val($(e.target).find("option:selected").text());
						}
					});
					
					$("select[name='projectHeaderC']").change(function(e){
						if($(e.target).val() !== ''){
							$("#projectHeaderC_text").val($(e.target).find("option:selected").text());
						}
					});
					*/
					
					$("select[name='busiPropID']").change(function(e){
						if($(e.target).val() !== ''){
							$("#busiPropID_text").val($(e.target).find("option:selected").text());
						}
					});
					$("select[name='projTypeID']").change(function(e){
						if($(e.target).val() !== ''){
							$("#projTypeID_text").val($(e.target).find("option:selected").text());
						}
					});
					
					/**
					 * 提交报表统计条件
					 */
					$(".btn_ok_s").click(function(){
						var reportCountIf_form = $("#reportCountIf_form");
						var saveCountIfName = reportCountIf_form.find("input[mark='report']");
//						console.log(saveCountIfName.size());
						var sqlcondition = new Array();
						saveCountIfName.each(function(index,e){
							var v = $(e).val();
							if(v !== ''){
								sqlcondition.push(v);
							}
						});
						$("#othersqlcondition_s").val(sqlcondition.join(","));
						reportCountIf_form.submit();
					});
				}
		);
	}
	
	/**
	 * 序列化表单数据
	 */
	function serializeFormData(formID){
		var formData = "";
		var form = document.getElementById(formID);
		if(form){
			var inputAll = $(form).find("input,select");
			inputAll.each(function(index,e){
				var thisType = this.type;
				if(thisType === "text" || thisType === "hidden" || thisType === "select-multiple" || thisType === "select-one"){
					var thisElement = $(e);
					var thisName = thisElement.attr("name");
					var thisValue = thisElement.val();
					if(typeof thisName !== "undefined" && thisValue !== '' ){
						//判断是日期格式
						var regExp = /^(\d{4})-(\d{2})-(\d{2})$/;
						if(regExp.test(thisValue) && RegExp.$2<=12 && RegExp.$3<=31){
							thisValue = "\'" + thisValue + "\'"
						}else{
							thisValue = "\'\'";
						}
						formData += thisName +"=" +thisValue + "&";
						
					}
				}
			});
			return formData.substring(0,formData.length-1);
		}else{
			return formData;
		}
	}
	
	/**
	 * 加载报表
	 */
	function loadReport(){
		/*$("#reportDisplayPage").load(
				"/reportviewer?file=reportXML/detail_apply.xml",
				{},
				function(){
					
				}
		);*/
	}

})(jQuery, this);


$(function(){
//	$.zjm_report.loadReport();
	$("#reportCountIf").click(function(e){
		$.zjm_report.reportCountIf(e);
	});
	
});