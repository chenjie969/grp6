(function($, window, document, undefined) {
	//定义分页类
	function Paging(element, options) {
		this.element = element;
		//传入形参
		this.options = {
			pageNo: options.pageNo||1,
			totalPage: options.totalPage,
			totalSize:options.totalSize,
			callback:options.callback
		};
		//根据形参初始化分页html和css代码
		this.init();
	}
	//对Paging的实例对象添加公共的属性和方法
	Paging.prototype = {
		constructor: Paging,
		init: function() {
			this.creatHtml();
			this.bindEvent();
		},
		creatHtml: function() {
			var me = this;
			var content = "";
			var current = me.options.pageNo;
			var total = me.options.totalPage;
			var totalNum = me.options.totalSize;
			content += "<ul class='pagination'>";
//			content +=  "<li><a href='javascript:void(0)' class='clickable' id='firstPage'>首页</a></li>";
			content +=  "<li><a href='javascript:void(0)' class='clickable' id='prePage'>上一页</a></li>";
			//总页数小于等于7时候
			if(total <= 7) {
				for(var i = 1; i < total + 1; i++) {
					if(current == i) {
						content += "<li class='active'><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
					} else {
						content += "<li><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
					}
				}
			//页面总数等于8的时候
			}else {	//页面总数大于等于9的时候
				if(current < 5) {	//当前页数小于5时显示右边的省略号	1,2,3,4,5,...,10
					for(var i = 1; i < 6; i++) {
						if(current == i) {
							content += "<li class='active'><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
						} else {
							content += "<li><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
						}
					}
					content += "<li><a>. . .</a></li>";
					content += "<li><a href='javascript:void(0)' class='clickable'>"+total+"</a></li>";
				} else if(current > total-4){	//判断页码在末尾的时候显示左边的省略号	1,...6,7,8,9,10
					content += "<li><a href='javascript:void(0)' class='clickable'>1</a></li>";
					content += "<li><a>. . .</a></li>";
					for(var i = total-4; i < total + 1; i++) {
						if(current == i) {
							content += "<li class='active'><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
						} else {
							content += "<li><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
						}
					}
				} else {	//页码在中间, 显示两边的省略号 	1,...,4,5,6,...,10
					content += "<li><a href='javascript:void(0)' class='clickable'>1</a></li>";
					content += "<li><a>. . .</a></li>";
					for(var i = current - 1; i < current + 2; i++) {
						if(current == i) {
							content += "<li class='active'><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
						} else {
							content += "<li><a href='javascript:void(0)' class='clickable'>" + i + "</a></li>";
						}
					}
					content += "<li><a>. . .</a></li>";
					content += "<li><a href='javascript:void(0)' class='clickable'>"+total+"</a></li>";
				}
			} 
			content += "<li><a href='javascript:void(0)' class='clickable' id='nextPage'>下一页</a></li>";
//			content += "<li><a href='javascript:void(0)' class='clickable' id=\"lastPage\">尾页</a></li>";
			content += "</ul>";
			content += "<span class='col-sm-12'>共"+total+"页，共"+totalNum+"条记录</span>";
			me.element.html(content);
		},
		//添加页面操作事件
		bindEvent: function() {
			var me = this;
			me.element.off('click', 'a');
			me.element.on('click', 'a.clickable', function() {
				var num = $(this).html();
				var id=$(this).attr("id");
				if(id == "prePage") {
					if(me.options.pageNo == 1) {
						me.options.pageNo = 1;
					} else {
						me.options.pageNo = +me.options.pageNo - 1;
					}
				} else if(id == "nextPage") {
					if(me.options.pageNo == me.options.totalPage) {
						me.options.pageNo = me.options.totalPage
					} else {
						me.options.pageNo = +me.options.pageNo + 1;
					}
 
				} /*else if(id =="firstPage") {
					me.options.pageNo = 1;
				} else if(id =="lastPage") {
					me.options.pageNo = me.options.totalPage;
				}*/else{
					me.options.pageNo = +num;
				}
//				me.creatHtml();
				if(me.options.callback) {
					me.options.callback(me.options.pageNo);
				}
			});
		}
	};
	//通过jQuery对象初始化分页对象
	$.fn.paging = function(options) {
		return new Paging($(this), options);
	}
})(jQuery, window, document);