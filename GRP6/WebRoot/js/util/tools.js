
	
/**
 * 把json数据转换为select
 * 需要传进来的参数顺序   节点 标识 名字 (class名字,或者id名字)|| json数据
 * 依据实例化一个普通的下拉菜单为美化的chosen控件,并赋值
 * 使用方法:$.setSelectNode(要实例化控件的对象,json数据源,设置选中项(可选项))
 */
jQuery.setSelectNode = function(domObj,data,selected){
//	var domObj;
//	var selectID = $("#"+nodeName);
//	var selectClass = $("."+nodeName);
//	if(selectID.length > 0){
//		domObj = selectID;
//	}else{
//		domObj = selectClass;
//	}
	domObj.empty();//清空select下拉框
	domObj.append("<option value='' >请选择</option>");
	for(var i in data){
		if(data[i].show === false){
		}else{
			domObj.append("<option value=\'" + data[i].id + "\' >" + data[i].name + "</option>");//动态添加Option子项
		}
    }
//	$("#"+nodeName).val(selected);
	domObj.val(selected);
	/*domObj.chosen({
		width:"210px",
		no_results_text:"请选择",//无搜索结果显示的文本
		allow_single_deselect:true,//是否允许取消选择
		max_selected_options:10//当select为多选时，最多选择个数
	});*/
//	domObj.trigger("liszt:updated");
};

//清除表单数据
jQuery.clearForm = function(objE){//objE为form表单
	$(objE).find(':input').each(
		function(){
			switch(this.type){
				case 'passsword':
				case 'select-multiple':
				case 'select-one':
				case 'text':
				case 'textarea':
					$(this).val('');
				 	break;
				case 'checkbox':
				case 'radio':
					this.checked = false;
			}
		}	
	)};
	
	
	
	/**
	 * 此方法为 自定义的 jquery 全局函数 (待优化:命名空间重复的问题)
	 * 依据 key 值 获取json对象对应的value
	 * 使用方法: $.getJsonVal(要查找的json对象,查找的key)
	 */
	jQuery.getJsonVal = function(Json,Key){
//		console.log(Json);
		if(Json != '' ){
			for(var i in Json){
				if(Json[i].id === Key){
					return Json[i].name;
				}
			}
		}
	}
	
	/**
	 * 获取验证所需的附加参数
	 */
	jQuery.returnExtraDataValiData =function(){  
	    alert("直接继承方式不一样");  
	}  
	
	
	
	/**
	 * 实例化一个弹出窗口
	 */
	jQuery.newPopupPage = function(id,optional){
		var defaults = {
					dialogClass : "dialogtitlebg",
					bgiframe : !0,
					modal : !0,
					resizable : !1,
					width : 600,
					draggable : true,
					show : {
						effect : 'drop',
						direction : 'up'
					},
					hide : {
						effect : 'drop',
						direction : 'down'
					}
		};
		defaults = $.extend(defaults,optional);
		$(id).dialog(defaults);
	}
	
	/**
	 * 必填字段
	 * 使用方法: class="requiredField"
	 */
	$(".requiredField").after("<label class='requiredField_style'> *</label>");
	
	/**
	 * 只读字段
	 */
	$(".readField").after("<label class='readField_style'>只读</label>");
	
