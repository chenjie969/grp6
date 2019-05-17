<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<a class="menu-toggler" id="menu-toggler" href="#"> 
	<span class="menu-text"></span> 
</a>
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed');}catch(e){}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success" onclick="getMenu(1)" title="业务管理">
				<i class="icon-desktop"></i>
			</button>
			<button class="btn btn-warning" onclick="getMenu(3)" title="流程管理">
				<i class="icon-sitemap"></i>
			</button>
			<button class="btn btn-info" onclick="getMenu(2)" title="OA管理">
				<i class="icon-group"></i>
			</button>
			<button class="btn btn-danger" onclick="getMenu(4)" title="系统管理">
				<i class="icon-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> 
			<span class="btn btn-info"></span>
			<span class="btn btn-warning"></span> 
			<span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list" id="menu_li_id">
	</ul>
	<!-- /.nav-list -->
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed');}catch(e){}
	</script>
</div>
<!-- /.sidebar -->