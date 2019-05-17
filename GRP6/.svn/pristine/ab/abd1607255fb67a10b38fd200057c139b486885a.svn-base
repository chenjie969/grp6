(function($,d) {
	window.tool = {
		dialog : newWindow,
		urlParam :getUrlParam,
		off:delNode,//关闭一行
		off_Up:delNode_Up,//关闭一行
		sort : sort, //排序功能
		disabled : disabled, //设置按钮为不可用状态
		undisabled : undisabled, //设置按钮为可用状态
		dateFormat:dateFormat,//日期格式化
		getUrlParam:getUrlParam,//获取url中的参数
		parseDate:parseDate ,// 日期转换函数 yyyy-MM-dd
		parseYearsDate:parseYearsDate ,// 日期转换函数 yyyy
		parseYearsMonthDate:parseYearsMonthDate,//日期转换函数 yyyy-MM
		parseDateDetail:parseDateDetail ,// 日期转换 yyyy-MM-dd hh:mm:ss
		isNull:isNull , //判断是否是null ,若是null 返回""
		beforeSend:beforeSend , //ajax 请求前显示"数据加载中，请稍后..."
		complete:complete, //ajax 请求完成移除"数据加载中，请稍候..."
		getSelectText : getSelectText//获取下拉框值;
	};
	
	
	/**
	 * 创建一个弹出窗口
	 */
	function newWindow(option){
		var showid;
		defParam = {
				title:"窗口",
				showid:"",
				bgiframe : !0,
				modal : !0,
				resizable : !1,
				width:"650",
			    //heigth:"400",
				draggable : false,
				show : {
					effect : 'drop',
					direction : 'up'
				},
				hide : {
					effect : 'drop',
					direction : 'down'
				},
				close:function(event, ui){
					$("body").append("<div style='display:none;' id="+ showid +"></div>");
					$(this).dialog('destroy').remove(); 
				}
		}
		defParam = $.extend(defParam,option);
		showid =  defParam.showid;
		$(document.getElementById(showid)).addClass("winDialogContent");
		return $(document.getElementById(defParam.showid)).dialog(defParam);
	}
	
	
	/**
	 * 一个删除的动画
	 */
	function delNode(nodeID){
		var nodeID = $("#"+nodeID);
		nodeID.animate({  
			  marginLeft:parseInt(nodeID.css('marginLeft'),10)==0 ? nodeID.outerWidth() : 0  
		 },"fast",function(){
			 nodeID.slideUp("fast", function() {
					nodeID.remove();
		     });
		 }); 
	}
	
	/**
	 * 向上关闭
	 */
	function delNode_Up(nodeID){
		var nodeID = $("#"+nodeID);
		nodeID.slideUp("fast", function() {
			nodeID.remove();
		});
	}
	
	/**
	 * 从一个href中提取参数 
	 */
	function getUrlParam(name){
		 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
         var r = window.location.search.substr(1).match(reg);
         if (r != null) return unescape(r[2]); return null;
	}
	
	/**
	 * 排序的功能
	 */
	function sort(){
		var A = document.getElementById("OrderContent");
		var B = document.getElementById("OrderContent");
		$("#btn_moveUp").click(function () {
			for (var B = 1; B < A.length; B++) {
				if (A.options[B].selected) {
					if (!A.options.item(B - 1).selected) {
						var D = A.options[B].text, C = A.options[B].value;
						A.options[B].text = A.options[B - 1].text;
						A.options[B].value = A.options[B - 1].value;
						A.options[B].selected = false;
						A.options[B - 1].text = D;
						A.options[B - 1].value = C;
						A.options[B - 1].selected = true;
					}
				}
			}
			sortResult();
		});
		$("#btn_moveDown").click(function () {
			for (var B = A.length - 2; B >= 0; B--) {
				if (A.options[B].selected) {
					if (!A.options[B + 1].selected) {
						var D = A.options[B].text, C = A.options[B].value;
						A.options[B].text = A.options[B + 1].text;
						A.options[B].value = A.options[B + 1].value;
						A.options[B].selected = false;
						A.options[B + 1].text = D;
						A.options[B + 1].value = C;
						A.options[B + 1].selected = true;
					}
				}
			}
			sortResult();
		});
		$("#btn_moveTop").click(function () {
			var D = [];
			for (var C = A.options.length - 1; C >= 0; C--) {
				if (A.options[C].selected) {
					D.push(A.options[C]);
					A.remove(C);
				}
			}
			var B = 0;
			for (var E = D.length - 1; E >= 0; E--) {
				var F = new Option(D[E].text, D[E].value);
				F.selected = true;
				A.options.add(F, B++);
			}
			sortResult();
		});
		$("#btn_moveBottom").click(function () {
			var C = [];
			for (var B = A.options.length - 1; B >= 0; B--) {
				if (A.options[B].selected) {
					C.push(A.options[B]);
					A.remove(B);
				}
			}
			for (var D = C.length - 1; D >= 0; D--) {
				var E = new Option(C[D].text, C[D].value);
				E.selected = true;
				A.options.add(E);
			}
			sortResult();
		});
		
		function sortResult(){
			var E = "";
			for (var C = 0; C < A.length; C++) {
				E += A.options[C].value + ",";
				//A.options[C].selected = true;
			}
			var E = E.substring(0, E.length - 1);
			$("#tableFileIds").val(E);
		}
	}
	/**
	 * 设置按钮为不可用状态
	 */
	function disabled(idorclass){
		$(idorclass).attr("disabled", true); 
	}
	/**
	 * 设置按钮为可用状态
	 */
	function undisabled(idorclass){
		$(idorclass).attr("disabled", false);
	}
	
	/***
	 * 格式化日期
	 * @param now
	 * @param mask
	 * @returns
	 */
	function dateFormat(now,mask){
        var d = new Date(Date.parse(now));
        var zeroize = function (value, length)
        {
            if (!length) length = 2;
            value = String(value);
            for (var i = 0, zeros = ''; i < (length - value.length); i++)
            {
                zeros += '0';
            }
            return zeros + value;
        };
     
        return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
        {
            switch ($0)
            {
                case 'd': return d.getDate();
                case 'dd': return zeroize(d.getDate());
                case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
                case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
                case 'M': return d.getMonth() + 1;
                case 'MM': return zeroize(d.getMonth() + 1);
                case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
                case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
                case 'yy': return String(d.getFullYear()).substr(2);
                case 'yyyy': return d.getFullYear();
                case 'h': return d.getHours() % 12 || 12;
                case 'hh': return zeroize(d.getHours() % 12 || 12);
                case 'H': return d.getHours();
                case 'HH': return zeroize(d.getHours());
                case 'm': return d.getMinutes();
                case 'mm': return zeroize(d.getMinutes());
                case 's': return d.getSeconds();
                case 'ss': return zeroize(d.getSeconds());
                case 'l': return zeroize(d.getMilliseconds(), 3);
                case 'L': var m = d.getMilliseconds();
                    if (m > 99) m = Math.round(m / 10);
                    return zeroize(m);
                case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
                case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
                case 'Z': return d.toUTCString().match(/[A-Z]+$/);
                // Return quoted strings with the surrounding quotes removed
                default: return $0.substr(1, $0.length - 2);
            }
        });
    };
    
    /**
	 * 获取url中的参数
	 */
	function getUrlParam(name){
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
	}
	 function getSelectText(selectID){
	    	 var type = document.getElementById(selectID);     	
		 	 var pindex  = type.selectedIndex;
		 	 // 获取选中的下拉框的值(value)
		　　	 var pValue  =  type.options[pindex].value;　
		　　	 // 获取选中的下拉框的值(key)
		　　	 var pText = type.options[pindex].text;
		　　	 var selectName = selectID.replace(/List/, "Name");
		　　    document.getElementById(selectName).value=pText;
	 }
	
	
	/**
	 * 时间/日期格式转换 
	 * @param date  json格式的时间串 (1970年1月1日至今的毫米数)
	 * @returns  yyyy-MM-dd 格式字符串
	 * @author: wuhn
	 * @Date: 2017年5月10日 14:47:16
	 */
	function parseDate(date){
		if(date == null || date== ''){
			return '';
		}
		 var jsonDateStr = date.toString();//此处用到toString（）是为了让传入的值为字符串类型，目的是为了避免传入的数据类型不支持.replace（）方法
         try {
             var k = parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10);
             if (k < 0) {
            	 return null;
             }
             var date = new Date(parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10));
             var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
             var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
             return date.getFullYear() + "-" + month + "-" + day ;
         }
         catch (ex) {
             return "时间格式转换错误";
         }
	}
	/**
	 * 时间/日期格式转换 
	 * @param date  json格式的时间串 (1970年1月1日至今的毫米数)
	 * @returns  yyyy 格式字符串
	 * @author:zhangkeyao
	 * @Date: 2017年7月31日 15:32:16
	 */
	function parseYearsDate(date){
		if(date == null || date== ''){
			return '';
		}
		var jsonDateStr = date.toString();//此处用到toString（）是为了让传入的值为字符串类型，目的是为了避免传入的数据类型不支持.replace（）方法
		try {
			var k = parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10);
			if (k < 0) {
				return null;
			}
			var date = new Date(parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10));			
			return date.getFullYear();
		}
		catch (ex) {
			return "时间格式转换错误";
		}
	}
	function parseYearsMonthDate(date){
		if(date == null || date== ''){
			return '';
		}
		var jsonDateStr = date.toString();//此处用到toString（）是为了让传入的值为字符串类型，目的是为了避免传入的数据类型不支持.replace（）方法
		try {
			var k = parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10);
			
			if (k < 0) {
				return null;
			}
			var date = new Date(parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10));	
			var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
			return date.getFullYear() + "-" + month;
		}
		catch (ex) {
			return "时间格式转换错误";
		}
	}
	
	/**
	 * 时间/日期格式转换 
	 * @param date  json格式的时间串 (1970年1月1日至今的毫米数)
	 * @returns  yyyy-MM-dd hh:mm:ss  格式字符串
	 * @author: wuhn
	 * @Date: 2017年5月10日 14:46:56
	 */
	function parseDateDetail(date){
		if(date == null || date== ''){
			return '';
		}
		 var jsonDateStr = date.toString();//此处用到toString（）是为了让传入的值为字符串类型，目的是为了避免传入的数据类型不支持.replace（）方法
         try {
             var k = parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10);
             if (k < 0) {
            	 return null;
             }
             var date = new Date(parseInt(jsonDateStr.replace("/Date(", "").replace(")/", ""), 10));
             var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
             var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
	         var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	         var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	         var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	         var milliseconds = date.getMilliseconds();
             return date.getFullYear() + "-" + month + "-" + day  + " " + hours + ":" + minutes + ":" + seconds;
         }
         catch (ex) {
             return "时间格式转换错误";
         }
	}
	
	/**
	 * null值 处理
	 * @param value --传入对象值 , replaceValue -- 替换值
	 * @author: wuhn
	 * @Date: 2017年5月16日 16:37:42
	 */
	function isNull(value,replaceValue){
		if(value === null || value === ''){
			return replaceValue;
		}else{
			return value;
		}	
	}
	
	
	/**
	 * ajax 请求前显示"数据加载中，请稍后..."
	 * @param XMLHttpRequest
	 * @returns
	 */
	function beforeSend(XMLHttpRequest){
		//获取浏览器页面可见高度和宽度
		var _PageHeight = document.documentElement.clientHeight,
		  _PageWidth = document.documentElement.clientWidth;
		//计算loading框距离顶部和左部的距离（loading框的宽度为215px，高度为61px）
		var _LoadingTop = _PageHeight > 61 ? (_PageHeight - 61) / 2 : 0,
		  _LoadingLeft = _PageWidth > 265 ? (_PageWidth - 265) / 2 : 0;
		var htmlContainer = ['<div id="showResult" style="position:absolute;left:0;width:100%;'+
		'height:100%;top:0;background:#f3f8ff;opacity:0.8;filter:alpha(opacity=80);z-index:900000;">'+
		'<div style="position: absolute; cursor1: wait; left: ' + _LoadingLeft + 'px; top:' + _LoadingTop + 'px;'+
		' width: 265px; height: 57px; line-height: 57px; padding-left: 95px; padding-right: 5px;'+
		' background: #fff url(/assets/images/loading.gif) no-repeat scroll 36px 11px; border: 2px solid #95B8E7;'+
		' color: #696969; font-family:\'Microsoft YaHei\';">数据加载中，请等待...</div></div>'];

		if($("#showResult").length <= 0 ){
			$("body").append(htmlContainer.join(''));
		}
	}
	/**
	 * ajax 请求完成移除"数据加载中，请稍候..."
	 * @param XMLHttpRequest
	 * @param textStatus
	 * @returns
	 */
	function complete(XMLHttpRequest, textStatus){
		$("#showResult").remove();
	}
	
})(jQuery,this);

(function($){  
    $.fn.serializeJson=function(){  
        var serializeObj={};  
        var array=this.serializeArray();  
        var str=this.serialize();  
        $(array).each(function(){  
            if(serializeObj[this.name]){  
                if($.isArray(serializeObj[this.name])){  
                    serializeObj[this.name].push(this.value);  
                }else{  
                    serializeObj[this.name]=[serializeObj[this.name],this.value];  
                }  
            }else{  
                serializeObj[this.name]=this.value;   
            }  
        });  
        return serializeObj;  
    };  
})(jQuery);  
