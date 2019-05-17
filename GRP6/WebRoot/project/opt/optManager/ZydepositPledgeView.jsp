<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	table.table_busiLimit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	table.table_busiLimit tr th,td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	}
	
</style>
		
		<%@ include file="/common_timestamp.jsp" %>
		<%@ include file="/common_head.jsp" %>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
				<div id="divTwo">	<!-- divTwo 开始-->
					<c:if test="${opt.relieveFlag ne '01' && opt.relieveFlag ne '02'}">
						<div class="page-header">
							<h5>查看存单详情</h5>
						</div>
					</c:if>
					
						<c:if test="${opt.relieveFlag eq '01' || opt.relieveFlag eq '02'}">
							<div class="page-header">
								<h5>查看已<c:if test="${opt.relieveFlag eq '01'}">解除</c:if><c:if test="${opt.relieveFlag eq '02'}">处置</c:if>保证措施</h5>
							</div>
	                        <div class="form-group col-sm-12">
	                             <h5 class="header smaller lighter blue">
	                             	保证措施信息
	                             </h5>	                              
							 </div>
						</c:if>		

						<form class="form-horizontal" role="form" id="form_baseTwo">
							 	  <input type="hidden"  id="ownerName" name="ownerName" value="${opt.clientName }">
                                  <input type="hidden"  id="clientID" name="clientID" value="${opt.clientID }">
                                  <input type="hidden"  id="apply_ID" name="apply_ID" value="${opt.apply_ID }"> 
                                  <input type="hidden"  id="guarantyTypeID" name="guarantyTypeID" value="${opt.guarantyTypeID }">
                                  <input type="hidden"  id="guarantyTypeName" name="guarantyTypeName" value="${opt.guarantyTypeName }">
                                  <input type="hidden"  id="optTypeID" name="optTypeID" value="${opt.optTypeID }">
                                  <input type="hidden"  id="optTypeName" name="optTypeName" value="${opt.optTypeName }">
                                  <input type="hidden"  id="optGuaranty_ID" name="optGuaranty_ID" value="${opt.optGuaranty_ID }">
                          
                          
                          <div class="col-sm-offset-1 col-sm-10">
  							 <c:if test="${opt.clientTypeID eq '01' }">      
								<h5 class="col-sm-6" style="line-height:26px;">权属人：<span class="grey">${opt.clientName }</span></h5>
								<h5 class="col-sm-6" style="line-height:26px;">统一社会信用代码：<span class="grey">${opt.otherCreditCode }</span></h5>
							 </c:if> 
							 <c:if test="${opt.clientTypeID ne '01' }">   	
								<h5 class="col-sm-6" style="line-height:26px;">权属人：<span class="grey">${opt.personName }</span></h5>
								<h5 class="col-sm-6" style="line-height:26px;">身份证号码：<span class="grey">${opt.otherPersonNum }</span></h5>
							 </c:if>	
							 
                           		<h5 class="col-sm-6" style="line-height:26px;">开户银行/公司名称：<span class="grey">${opt.bankName }</span></h5>
                           		<h5 class="col-sm-6" style="line-height:26px;">存单类型：<span class="grey">${opt.depositType }</span></h5>
                           		<h5 class="col-sm-6" style="line-height:26px;">存单号：<span class="grey">${opt.depositCode }</span></h5>
                           		<h5 class="col-sm-6" style="line-height:26px;">户名：<span class="grey">${opt.depositName }</span></h5>
                           		<h5 class="col-sm-6" style="line-height:26px;">账号：<span class="grey">${opt.depositAccounts }</span></h5>
                           		<h5 class="col-sm-6" style="line-height:26px;">存入日期：<span class="grey">
                           			<fmt:formatDate value="${opt.depositDate }" pattern="yyyy-MM-dd"/></span></h5>
                           			
                           		<h5 class="col-sm-6" style="line-height:26px;">存入期限：<span class="grey">${opt.depositPeriod }</span></h5>
                           		<h5 class="col-sm-6" style="line-height:26px;">存入金额：<span class="grey">
                           		 <fmt:formatNumber value="${opt.depositSum }" pattern="###,###.######"/>万元</span></h5>
                           		 
                           		<h5 class="col-sm-6" style="line-height:26px;">年利率：<span class="grey">
                           			<fmt:formatNumber value="${opt.yearScale }" pattern="###.##"/>%</span></h5>
                           			
							
								<h5 class="col-sm-6" style="line-height:26px;">评估价值：<span class="grey">
									<fmt:formatNumber value="${opt.assessValue }" pattern="###,###.######"/>万元</span></h5>
								<h5 class="col-sm-6" style="line-height:26px;">质押率：<span class="grey">
									<fmt:formatNumber value="${opt.coverageRatio }" pattern="###.##"/>%</span></h5>
								<h5 class="col-sm-6" style="line-height:26px;">质押价值：<span class="grey">
									<fmt:formatNumber value="${opt.optValue }" pattern="###,###.######"/>万元</span></h5>
								<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey">${opt.disposeRemark }</span></h5>
								<h5 class="col-sm-12" style="line-height:26px;">是否需要登记：<span class="grey">
									<c:if test="${opt.isRegister == 1 }">是</c:if>
									<c:if test="${opt.isRegister == 0 }">否</c:if>
								</span></h5>
								<h5 class="col-sm-12" style="line-height:26px;">保证措施附件：<span class="grey">
									       	  <%@ include file="/project/opt/optManager/opt_btn_View.jsp" %>
								</span></h5>
                  
                		  </div>         
                              
							
                        </form>
					</div>
					
						<c:if test="${opt.relieveFlag eq '01'}"><%-- 已解除措施加载 --%>
							<c:if test="${opt.isFree eq 1 }">
								<%@ include file="/project/opt/optDispose/common_RelieveDetail.jsp" %>
							</c:if>	
					   </c:if>
						<c:if test="${opt.relieveFlag eq '02'}"><%-- 已处置措施加载 --%>
							<c:if test="${opt.isDispose eq 1 }">
								<%@ include file="/project/opt/optDispose/common_DisposeDetail.jsp" %>
							</c:if>
						</c:if>
					
					
				</div>
			</div>
		</div>
						
	
	<%@ include file="/project/opt/optManager/common_optView.jsp" %>
	<script src="<%=path%>/project/opt/optManager/ZydepositPledgeView.js?v=<%=vardate%>"></script>

	<script type="text/javascript">
		// 注册日期控件点击事件
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
	</script>

	<%@ include file="/project/opt/imgUpload/optUploadView.jsp" %>
	
				<%@ include file="/project/opt/imgUpload/optUpload_realizeView.jsp" %>
		
	