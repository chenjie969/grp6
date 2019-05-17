<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="widget-box transparent">
<div class="widget-header widget-header-flat">
	<h4 class="lighter">
		按合作机构统计
	</h4>

	<div class="widget-toolbar" style="height:37px;">
		<a href="#" data-action="collapse" style="margin-top:11px;">
			<i class="icon-chevron-up"></i>
		</a>
	</div>
</div>

<div class="widget-body">
	<div class="widget-main no-padding">
		<table class="table table-striped table-bordered table-hover">
			<thead class="thin-border-bottom">
				<tr>
					<th rowspan="2">
						<i class="icon-caret-right yellow"></i>
						合作机构
					</th>

					<th colspan="3">
						<i class="icon-caret-right yellow"></i>
						年初在保余额
					</th>

					<th colspan="3">
						<i class="icon-caret-right yellow"></i>
						本年新增
					</th>
					<th colspan="3">
						<i class="icon-caret-right yellow"></i>
						无代偿解除
					</th>
					<th colspan="3">
						<i class="icon-caret-right yellow"></i>
						代偿解除
					</th>
					<th colspan="3">
						<i class="icon-caret-right yellow"></i>
						在保余额
					</th>
				</tr>
				<tr>
					<th>户数</th>
					<th>笔数</th>
					<th>在保余额(万元)</th>
					<th>户数</th>
					<th>笔数</th>
					<th>担保金额(万元)</th>
					<th>户数</th>
					<th>笔数</th>
					<th>正常解除金额(万元)</th>
					<th>户数</th>
					<th>笔数</th>
					<th>代偿总额(万元)</th>
					<th>户数</th>
					<th>笔数</th>
					<th>在保余额(万元)</th>
				</tr>
			</thead>

			<tbody>
				 <c:forEach items="${bankNameLists}" var="bankList"  varStatus="status">  
					   		<tr>  						     
						     <c:forEach items="${bankList}" var="bankValue"  varStatus="statusSumList">  
							     <td>${bankValue}
							     </td>  
							     
						     </c:forEach>
					   		 </tr>  
				</c:forEach>  				  
			</tbody>
		</table>
	</div><!-- /widget-main -->
</div><!-- /widget-body -->
</div><!-- /widget-box -->