<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="isshow_countIf" value="isshow_countIf" scope="page"></c:set>
<%-- 
<c:if test="${statscondition == 'all' || fn:contains(statscondition,'统计期间') }">
	<c:set var="isshow_countIf" value="isshow_countIf" scope="page"></c:set>
</c:if>
<c:if test="${statscondition != 'all' || !fn:contains(statscondition,'统计期间') }">
	<c:set var="isshow_countIf" value="" scope="page"></c:set>
</c:if> 
--%>
<form id="reportCountIf_form" autocomplete="off" method="post" action="/report/returnReportDefaultviewer.action">
	<input type="hidden" name="file" value="${file}"/>
	<input type="hidden" name="statscondition" value="${statscondition}"/>
	<input type="hidden" name="datename" value="${datename}"/>
	<input type="hidden" name="othersqlconditionsql" id="othersqlcondition_s"/>
	<input type="hidden" name="unitnamesql" value="${UserSession.unitname}"  />
	<ul class="countIf clearfix">
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'统计期间') }">
			<li class="countIf-item bod1">
				<span class="countIf-item-t">${datename}${dateName }&nbsp;</span>
				<span class="countIf-item-c">
					<input type="text" class="date_input_s requiredField selectDate validate[required]" 
					style="width:102px" name="begindatesql" value="${begindate}">
					至
					<input type="text" class="date_input_s requiredField selectDate validate[required]" 
					style="width:102px" name="enddatesql" value="${enddate}">
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'统计年月') }">
			<li class="countIf-item bod1">
				<span class="countIf-item-t">${datename}${dateName }&nbsp;</span>
				<span class="countIf-item-c">
					<input type="text" class="date_input requiredField selectYearMonth validate[required]" 
					 name="endyearmonthsql" value="${endyearmonth}">
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'截止日期') }">
			<li class="countIf-item bod1">
				<span class="countIf-item-t">${datename}${dateName }&nbsp;</span>
				<span class="countIf-item-c">
					<input type="text" class="date_input requiredField selectDate validate[required]" 
					 name="enddatesql" value="${enddate}">
				</span>
			</li>
		</c:if>
		<%-- <c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'合作放款机构') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">合作放款机构</span>
				<span class="countIf-item-c">
					<input type="text" name="fullBankCodesql" marking="report" autoField="fullBankCode_name" id="bankSort_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'业务品种') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">业务品种</span>
				<span class="countIf-item-c">
					<input type="text" name="fullBusiTypeCodesql" marking="report" autoField="fullBusiTypeCode_name" id="busiSort_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'业务性质') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">业务性质</span>
				<span class="countIf-item-c">
					<select name="busiPropIDsql" class="select_text_style" style="">
						<option value="">请选择</option>
						<c:forEach items="${busiNatureMap}" var="busiNature" >
							<option value="${busiNature.key}">${busiNature.value}</option>
						</c:forEach>
					</select> 
					<input type="hidden"  mark='report' id="busiPropID_text" />
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'项目类型') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">项目类型</span>
				<span class="countIf-item-c">
					<select name="projTypeIDsql" class="select_text_style" style="">
						<option value="">请选择</option>
						<c:forEach items="${projTypeMap}" var="projType" >
							<option value="${projType.key}">${projType.value}</option>
						</c:forEach>
					</select> 
					<input type="hidden"  mark='report' id="projTypeID_text" />
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'区域') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">区域</span>
				<span class="countIf-item-c">
					<input type="text" name="fullAreaCodesql" marking="report" autoField="fullAreaCode_name" id="areaSort_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'经办机构') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">经办机构</span>
				<span class="countIf-item-c">
					<input type="text" name="fullDepartCodesql" marking="report" autoField="fullDepartCode_name" id="departSort_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'A角') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">A角</span>
				<span class="countIf-item-c">
					<input type="text" name="amanIDsql" autoField="amanID_name" marking="report" id="amanID_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'B角') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">B角</span>
				<span class="countIf-item-c">
					<input type="text" name="bmanIDsql" autoField="bmanID_name" marking="report" id="bmanID_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'C角') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">C角</span>
				<span class="countIf-item-c">
					<input type="text" name="cmanIDsql" autoField="cmanID_name" marking="report" id="cmanID_select"/>
				</span>
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'期限长短') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">担保期限长短</span>
				<span class="countIf-item-c">
					<select name="" class="select_text_style" style="" id="CperiodType_select">
						<option value="">请选择</option>
						<c:forEach items="${cperiodTypeList}" var="cperiodType" >
							<option minVal="${cperiodType.minPeriodValue}" maxVal="${cperiodType.maxPeriodValue}"
									itemName="${cperiodType.periodDescri}"
									isInMin="${cperiodType.isincludemin}" isInMax="${cperiodType.isincludemax}">
								${cperiodType.periodDescri}
							</option>
						</c:forEach>
					</select>
					<input type="hidden" name="guaraPeriodMonthsMinsql" id="CperiodType_minVal"/>
					<input type="hidden" name="guaraPeriodMonthsMaxsql" id="CperiodType_maxVal"/>
					<input type="hidden" name="monthsMinEqualsql" id="CperiodType_isInMin"/>
					<input type="hidden" name="monthsMaxEqualsql" id="CperiodType_isInMax"/>
					
					<input type="hidden" mark="report" id="CperiodType_name"/>
				</span> 
			</li>
		</c:if>
		<c:if test="${fn:contains(statscondition,'all') || fn:contains(statscondition,'担保金额大小') }">
			<c:if test="${statscondition != 'all'}">
				<c:set var="isshow_countIf" value="" scope="page"></c:set>
			</c:if>
			<li class="countIf-item bod1 ${isshow_countIf }">
				<span class="countIf-item-t">担保金额大小</span>
				<span class="countIf-item-c">
					<select name="" class="select_text_style" id="CguaraSumSet_select">
						<option value="">请选择</option>
						<c:forEach items="${cguaraSumSetList}" var="cguaraSumSet" >
							<option minVal="${cguaraSumSet.minGuaraSum}" maxVal="${cguaraSumSet.maxGuaraSum}"
									itemName="${cguaraSumSet.guaraSumDescr}"
									isInMin="${cguaraSumSet.isincludemin}" isInMax="${cguaraSumSet.isincludemax}">
								${cguaraSumSet.guaraSumDescr}
							</option>
						</c:forEach>
					</select>
					<input type="hidden" name="guaraSumMinsql" id="CguaraSumSet_minVal"/>
					<input type="hidden" name="guaraSumMaxsql" id="CguaraSumSet_maxVal"/>
					<input type="hidden" name="sumMinEqualsql" id="CguaraSumSet_isInMin"/>
					<input type="hidden" name="sumMaxEqualsql" id="CguaraSumSet_isInMax"/>
					
					<input type="hidden" mark="report" id="CguaraSumSet_name"/>
				</span>
			</li>
		</c:if> --%>
		<c:if test="${statscondition == 'all'}">
			<div class="fold-filter" id="fold-filter-line">
				<div class="fold-filter-line" id="fold-countIf-part">
					<span id="fold-countIf">展开</span>
				</div>
			</div>
		</c:if>
		<div>&nbsp;</div>
		<li class="countIf-item">
			<span class="countIf-item-t w50 tr">
				<input type="button" value="提交" class="btn_ok_s clearfix" id="submitReport_">
				&nbsp;&nbsp;&nbsp;&nbsp;
			</span>
			<span class="countIf-item-c w50 tl">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="关闭" class="btn-style-close clearfix" id="btn_close">
			</span>
		</li>
	</ul>
</form>	