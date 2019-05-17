(function($,d) {
	$.zjm = {
		rules:{}
	};
	
	window.zjm = {
		init : finit,
		ztree: newTree,
		validata: validataEngine,
		network:netaddress,
		ajaxValidata:ajaxValidata,
		dataViewText:dataViewText,
		dataViewVal:dataViewVal,
		dataSortVal:dataSortVal,
		dataViewValSelect:dataViewValSelect,
		loadReportView : loadReportView, // 加载报表
		dataColumnsVal:dataColumnsVal
		
	};
	
	/**
	 * 初始化
	 */
	function finit(){
		var t = this;
		/**
		 * 必填字段
		 * 使用方法: class="requiredField"
		 */
		$(".requiredField").css("border","1px solid red")
		/**
		 * 只读字段
		 */
		$(".readField").after("<label class='readField_style'>只读</label>");
		/*$(".selectDate").datepicker(
			{  
			  showMonthAfterYear: true, // 月在年之后显示  
			  changeMonth: true,   // 允许选择月份  
			  changeYear: true,   // 允许选择年份  
			  dateFormat:'yy-mm-dd',  // 设置日期格式  
			  closeText:'关闭',   // 只有showButtonPanel: true才会显示出来  
			  duration: 'fast',  //关闭效果
			  showAnim:'fadeIn',  //打开效果
			  showButtonPanel: true,  
			  showOtherMonths: true ,
			  maxDate : null,
			  minDate: null,
			  yearRange : "c-100:c+100"
			}		
		);*/
		$('textarea[class*=autosize]').autosize({append: "\n"});
		
		
		$(".btn_ztb_select").change(function (e) {
			$("."+$(e.target).attr("class_name")).val($(e.target).find("option:selected").text());
		});
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
	}
	
	/**
	 * 加载页面树形结构
	 * domObj,url,extraData
	 */
	function newTree(parameter){
		defParam = {
				nodeId:"",
				url:"",
				extraData:{}
		};
		if(typeof parameter === "object"){
			defParam = $.extend(defParam,parameter);
		};
		return initZtree(defParam.nodeId,defParam.url,defParam.extraData);
	}
	
	/**
	 * 初始化验证引擎
	 * 参数: formId 表单id ; option 可选参数
	 */
	function validataEngine(parameter){
		defParam = {
				formId:"",
				valiParam:{
					promptPosition : "topRight", // 设置提示框的位置
					//可选的值:TopRight,TopLeft,BottomRight,BottomLeft,CenterRight,CenterLeft,Inline,
					scroll : true, // 设置是否开启卷轴,定位带错误的第一个提示处
					validateNonVisibleFields:true,//是否验证不可见的元素
					promptPosition:"topRight:27,5", 
					maxErrorsPerField:true,//单个元素显示错误提示的最大数量，值设为数值。默认 false 表示不限制。
					autoPositionUpdate:true,//是否自动调整提示层的位置
					binded:true//是否绑定即时验证   如果希望只在表单提交时验证设置参数为true
				},
				option:{}
		};
		if(typeof parameter === "object"){
			defParam = $.extend(defParam,parameter);
		};
		var valiForm = $(document.getElementById(defParam.formId));
		valiForm.validationEngine('hide');//隐藏改元素及元素内的提示
		return valiForm.validationEngine("attach", defParam.valiParam);//绑定表单验证
	}
	
	/**
	 * 获取网络资源url
	 */
	function netaddress(){
		return window.location.href;
	}
	/**
	 * ajax post 验证 返回  true or false
	 * fieldID:控件id
	 * url:地址
	 * data:提交数据  例 {"id":value}
	 * errorInfo:错误提示信息
	 */
	function ajaxValidata(fieldID,url,datas,errorInfo){
		var resultValue;
		$.ajax({
			type: "post", 
			url: url,
			contentType:'application/json; charset=UTF-8',
			dataType: 'json',
			data:datas,
			cache:false, 
			async:false, 
			success: function(resultdata){ 
				if(resultdata.obj){
//					$("#"+fieldID).validationEngine("showPrompt","验证通过！","pass");		//2017/10/21 xuyz注释, 
					resultValue= resultdata.obj;
				}else{
					$("#"+fieldID).validationEngine("showPrompt",errorInfo,"error");
					resultValue= resultdata.obj;
				}
			} 
		});
		return resultValue;
	}
	
	/**
	 * post 获取数据填充至页面指定class的元素中
	 * url:地址
	 * data:提交数据  例 {"id":value}
	 * formatdatas:日期格式化字段集合
	 */
	function dataViewText(prefix,url,datas,formatdatas){
		$.ajax({type:'POST',url:url,data:JSON.stringify(datas),async:false,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			if(data.obj!=null)
			$.each(data.obj, function(key, value){ 
        		if(typeof value == "object"){
        			for(var key2 in value){
        				if(formatdatas.indexOf(key2)>-1){
        					$(".ztb_"+prefix+key2).text(tool.parseDate(value[key2]));
        				}else{
        					$(".ztb_"+prefix+key2).text(value[key2]);
        				}
        			}
        		}else{
        			if(formatdatas.indexOf(key)>-1){
        				$(".ztb_"+prefix+key).text(tool.parseDate(value));
        			}else{
        				$(".ztb_"+prefix+key).text(value);
        			}
        		}
			});
	        }
		});
	}
	/**
	 * post 获取数据填充至页面指定class的控件中
	 * url:地址
	 * data:提交数据  例 {"id":value}
	 * formatdatas:日期格式化字段集合
	 */
	function dataViewVal(prefix,url,datas,formatdatas){
		$.ajax({type:'POST',url:url,data:JSON.stringify(datas),async:false,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			if(data.obj!=null)
			$.each(data.obj, function(key, value){ 
        		if(typeof value == "object"){
        			for(var key2 in value){
        				if(formatdatas.indexOf(key2)>-1){
        					$(".ztb_"+prefix+key2).val(tool.parseDate(value[key2]));
        				}else{
        					$(".ztb_"+prefix+key2).val(value[key2]);
        				}
        			}
        		}else{
        			if(formatdatas.indexOf(key)>-1){
        				$(".ztb_"+prefix+key).val(tool.parseDate(value));
        			}else{
        				$(".ztb_"+prefix+key).val(value);
        			}
        		}
			});
	        }
		});
	}
	
	
	/**
	 * post 获取数据填充至页面指定class的控件中 排序使用
	 * url:地址
	 * data:提交数据  例 {"id":value}
	 */
	function dataSortVal(url,datas){
		$.ajax({type:'POST',url:url,data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	        	$(".ztb_sort").empty();
	        	if(data.obj!=null)
				$.each(data.obj, function(key1, value1){
					$.each(value1, function(key2, value2){
					$(".ztb_sort").append("<option value='"+key2+"'>"+value2+"</option>");
					}); 
				}); 
	        }
		});
	}
	
	/**
	 * post 获取数据填充至页面指定class的控件中 select 下拉框
	 * btnclass:控件class
	 * url:地址
	 * data:提交数据  例 {"id":value}
	 */
	function dataViewValSelect(btnclass,url,datas){
		$.ajax({type:'POST',url:url,data:JSON.stringify(datas),async:false,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$("."+btnclass).empty();
			$("."+btnclass).append("<option value=''>&nbsp;请选择</option>");
			if(data.obj!=null)
			$.each(data.obj, function(key1, value1){
				$.each(value1, function(key2, value2){
					$("."+btnclass).append("<option value='"+key2+"'>"+value2+"</option>");
				});
			});
	        }
		});
	}
	
	/**
	 * post 获取数据填充至页面指定class的控件中 columns使用
	 * url:地址
	 * data:提交数据  例 {"id":value}
	 */
	function dataColumnsVal(url,datas,btnClass){
		$.ajax({type:'POST',url:url,data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	        	$("."+btnClass).empty();
	        	if(data.obj!=null)
				$.each(data.obj, function(key1, value1){
					$.each(value1, function(key2, value2){
					$("."+btnClass).append("<option value='"+key2+"'>"+value2+"</option>");
					}); 
				}); 
	        }
		});
	}
	
	/**
	 * 加载报表 "data-" ""
	 */
	function loadReportView(str,actionUrl,iframW,condition){
		//alert(str);
		//var $target = $(e.target);
		//var getParam = getNodeSubmitParam($target);
		var reportParam ={"reportParam":condition}
		iframW.location.href = actionUrl +"file="+str+"&"+reportParam;
		$("#report_iframe").load(function(){
		    var mainheight = $(this).contents().find("#_page_1").height();
		    $(this).height(mainheight);
		});	
	}
	
	/**
	 * 获取要提交的参数
	 */
	function getNodeSubmitParam($target){
		//生成唯一标识
		var timestamp = new Date().getTime();
		var $newNodeID = "report-"+timestamp;
		//设置nodeID
		$target.attr("id",$newNodeID);
		//获取dom节点
		var jDom = document.getElementById($newNodeID);
		//获取dom节点属性
		var domAttrMap = jDom.attributes;
		var paramJson = new Array();
		for(var i = 0 ; i < domAttrMap.length; i++){
			var paramArray = new Array();
			var attrItem = domAttrMap[i];
			var attrName = attrItem.name;
			var attrValue = attrItem.value;
			var isDataFormat = attrName.indexOf("data-");
			if(isDataFormat !== -1){
				var paramKey = attrName.substr(5,(attrName.length-5));
				paramArray.push("\"" + paramKey + "\"");
				paramArray.push("\"" + cnCode(attrValue) + "\"");
				paramJson.push(paramArray.join(":"));
			}
		}
		return $.parseJSON("{" + paramJson.join(",") + "}");//.serializeArray();
	}
	
	
	//	判断是否包含中文 并且 编译中文
	function cnCode(str){
		var reg = /[^\x00-\xff]/ig;//判断是否存在中文和全角字符
		var strcn = $.trim(str);
		if (reg.test(strcn)) {
	        return encodeURI(encodeURI(strcn));
	    }else{
	    	return strcn;
	    }
	}
	
	
	
	
	
})(jQuery,this);