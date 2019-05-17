(function($,z){
	$.zjm_mustChargeAdd = {
			addTableRow:addTableRow,
	};
	
	/**
	 * 收费信息新增一行
	 */
	function addTableRow(){
		$(".table_chargeInfo tbody").append('	<tr>'+	
										'	<td style="border:1px solid #ddd;"><!-- 费用类别 -->'+		
										'		<select class="validate[required] col-sm-12 costTypeList">'+
										' 		</select>'+
										'	</td>	'+
										'	<td style="border:1px solid #ddd;"><!-- 费率 -->'+		
										'		<input type="text" style="width:80%;" class="tdinput">	%'+
										'	</td>	'+
										'	<td style="border:1px solid #ddd;"><!-- 应收金额（万元）-->'+		
										'		<input type="text" style="width:80%;" class="tdinput">'+	
										'	</td>'+
										'	<td style="border:1px solid #ddd;"><!-- 操作 -->	'+    
										'		<button type="button" class="btn btn-xs btn-danger delChargeInfoRow">'+	        
										'			<i class="icon-trash bigger-120"></i>	 '+   
										'		</button>	'+
										'	</td>'+
										'</tr>');
		//费用类别下拉框
		zjm.dataViewValSelect("costTypeList", "/selectDicTypeListJSON", {"dicTypePID" : '386a21c7b12a45c88a70e462fb0cfdc7'});/*获取项目类型下拉框，按class属性赋值*/
	}
	
	
})(jQuery, this);


	$("#btn_addMustChargeInfo").click(function(){
		$.zjm_mustChargeAdd.addTableRow();
	});
	
	//删除一行收费信息
	$(".table_chargeInfo tbody").on("click","button.delChargeInfoRow",function(){
		// 删除前先取行数，如果小于等于两行，删除后就只剩表头一行，就要立即新增一个空行
		var rowNum = $(".table_chargeInfo").find("tr").length;
		$(this).parent().parent().remove();
		if(rowNum <= 2){
			$.zjm_mustChargeAdd.addTableRow();
		}
	});
	
	/*获取创建部门下拉选择树*/
	$.ajax({type:'POST',url:'/sys/dic/selectAllDepartsTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
		success:function(data) {		
			$("#createDepart").selectTreeWidgets({
				width : "89%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
	    }
	});
	
	/*获取创建人下拉选择树*/
	$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
		success:function(data) {		
			$("#createUser").selectTreeWidgets({
				width : "89%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
	    }
	});
	
	/*注册日期控件点击事件*/
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	/*设置日期初始值，默认为当天*/
	$("#createDate").attr("value",tool.parseDate(new Date().getTime()));