<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<ul class="toolTitle">
		<li class="toolTitleItem">
			<a href="${exportUrl}?reportedBegindate=${reportedBegindate}&reportedEnddate=${reportedEnddate}">导出上报Excel</a>
		</li>
		<c:if test="${isShowCountIf != false }">
			<li class="toolTitleItem" style="width: 100px">
				<a href="javascript:void(0);" class="reportedCountIf" data-loadExportDataUrl="${loadExportDataUrl}">统计条件</a>
			</li>
		</c:if>
	</ul>
</div>