<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 页面加载提示  begin -->
<div id="showPageLoading" style="display:none;position:absolute;left:0;width:100%;height:100%;top:0;background:#f3f8ff;opacity:0.8;filter:alpha(opacity=80);z-index:990000;"><div id="showPageLoadingChild" style="display:none;position: absolute; cursor1: wait; left: 550.5px; top:285px; width: 265px; height: 57px; line-height: 57px; padding-left: 95px; padding-right: 5px; background: #fff url(/assets/images/loading.gif) no-repeat scroll 36px 11px; border: 2px solid #95B8E7; color: #696969; font-family:'Microsoft YaHei';">页面加载中，请等待...</div></div>

<script type="text/javascript">
	//获取浏览器页面可见高度和宽度
	var _PageHeight = document.documentElement.clientHeight,
	  _PageWidth = document.documentElement.clientWidth;
	//计算loading框距离顶部和左部的距离（loading框的宽度为215px，高度为61px）
	var _LoadingTop = _PageHeight > 61 ? (_PageHeight - 61) / 2 : 0,
	  _LoadingLeft = _PageWidth > 265 ? (_PageWidth - 265) / 2 : 0;
	
	var showPageLoadingChild= document.getElementById("showPageLoadingChild");
	showPageLoadingChild.style.left=_LoadingLeft+'px';
	 showPageLoadingChild.style.top=_LoadingTop+'px';
	 var showPageLoading= document.getElementById("showPageLoading");
	 showPageLoading.style.display='block';
	 showPageLoadingChild.style.display='block';

	//判断页面是否加载完毕，如果加载完毕，就删除加载信息的DIV
	document.onreadystatechange=function (){
		try{
			if (document.readyState == "complete") {

		     	delPageLoadingNode("showPageLoading");
		    }
	    }catch(e){
	    	alert("页面加载失败");
	    }
	}
	//删除指定的DIV
	function delPageLoadingNode(nodeId){
	  try{
		  var div =document.getElementById(nodeId);
		  if(div !==null){
			  div.parentNode.removeChild(div);
			  div=null;
			  //CollectGarbage();
		  }
	  }catch(e){
	  	   alert("删除ID为"+nodeId+"的节点出现异常");
	  }
	} 
</script>
<!-- 页面加载提示  end -->

<!-- basic styles -->
<link rel="stylesheet" href="<%=path %>/assets/css/ztb.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/bootstrap.min.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/font-awesome.min.css?v=<%=vardate%>" />
<!--[if IE 7]>
	  <link rel="stylesheet" href="<%=path %>/assets/css/font-awesome-ie7.min.css?v=<%=vardate%>" />
<![endif]-->
<!-- page specific plugin styles -->
<link rel="stylesheet" href="<%=path %>/assets/css/jquery-ui-1.10.3.custom.min.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/chosen.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/bootstrap-datetimepicker.min.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/bootstrap-duallistbox.min.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/bootstrap-timepicker.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/daterangepicker.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/colorpicker.css?v=<%=vardate%>" />
		
<!-- fonts -->
<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" /> -->
<!-- <link rel="stylesheet" href="<%=path %>/assets/font/fonts-googleapis.css?v=<%=vardate%>" /> -->
<!-- ace styles -->
<link rel="stylesheet" href="<%=path %>/assets/css/ace.min.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-rtl.min.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-skins.min.css?v=<%=vardate%>" />

<link rel="stylesheet" href="<%=path %>/assets/css/chl.css?v=<%=vardate%>" />
<!-- ztb define --->
<%-- <link rel="stylesheet" href="<%=path %>/plugins/zTree/3.5/zTreeStyle.css"> --%>
<link rel="stylesheet" href="<%=path %>/plugins/ztree/zTreeStyle.css?v=<%=vardate%>" type="text/css">
<!--[if lte IE 8]>
	  <link rel="stylesheet" href="<%=path %>/assets/css/ace-ie.min.css?v=<%=vardate%>" />
<![endif]-->
<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="<%=path %>/assets/js/ace-extra.min.js?v=<%=vardate%>"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="<%=path %>/assets/js/html5shiv.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/assets/js/respond.min.js?v=<%=vardate%>"></script>
<![endif]-->

<link rel="stylesheet" href="<%=path %>/plugins/bootstraptable/bootstrap-table.css?v=<%=vardate%>">

<link type="text/css" rel="stylesheet" href="<%=path %>/plugins/validationEngine/validationEngine.jquery.css?v=<%=vardate%>">

<link href="<%=path %>/plugins/iconpicker/css/icon-picker.css?v=<%=vardate%>" media="all" rel="stylesheet" type="text/css" />

<!-- 日期控件样式  chenyang -->
<link rel="stylesheet" href="<%=path %>/assets/css/datepicker.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/bootstrap-timepicker.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/daterangepicker.css?v=<%=vardate%>" />

<style type="text/css">
        body {
		    background-color: #fff; 
		}
    </style>
