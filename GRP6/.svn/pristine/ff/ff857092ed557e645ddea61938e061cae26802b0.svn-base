<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp" %>
<script type="text/javascript">
function getSelectText2 (v){
/* 	var value= $("#"+v +"").val();
	alert(value); */
	 var value= $("#"+v +" option:selected").val();
	var name= $("#"+v +" option:selected").text(); 

};


</script>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal" role="form" id="checkDetail_Form">
			<input type="hidden" name="applyID" id="applyID" value="${apply.apply_ID}"/>
			<input type="hidden" name="checkReport_ID"  id="checkReport_ID" value="${proCheckReport.checkReport_ID}"/>
			<input type="hidden" name="checkPlan_ID"  id="checkPlan_ID" value="${proCheckReport.checkPlan_ID}"/>
			<input type="hidden" name="project_ID"  id="project_ID" value="${proCheckReport.project_ID}"/>
			<%-- <input type="hidden" name="riskLevelID"  id="riskLevelID" value="${riskLevelRec.riskLevelID}"/> --%>
			<input type="hidden" name="client_ID"  id="client_ID" value="${riskLevelRec.client_ID}"/>
			<input type="hidden" name="updateUserName"  id="updateUserName" value="${sessionUser.user_name}"/>
			<h4 class="header smaller lighter blue">项目基本情况</h4>
 			<div class="form-group col-sm-6">				
				<label class="col-sm-2 control-label no-padding-right">项目编号：</label>
				<label class="col-sm-10 grey" >${apply.busiCode}</label>
			</div>
			 <div class="form-group col-sm-6">
					<label class="col-sm-2 control-label no-padding-right">项目名称：</label>
					<label class="col-sm-10 grey">${apply.projectName}</label>
				</div>
				
						
				<div class="form-group"></div> 
				
				<div class="space-20"></div>
				<h4 class="header smaller lighter blue">检查情况</h4>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right">检查日期：</label>
				<div class="col-sm-10">
					<div class="input-group col-sm-3" style="float: left;">
						
									<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="checkdate" 
										value="<fmt:formatDate value='${proCheckReport.checkdate}' pattern='yyyy-MM-dd' type='date'/>"/>													
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
				</div>
				</div>
				 <div class="form-group">					
					<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>检查方式： </label>
					<div class="col-md-10">
							<input type="hidden" id="checkTypeName" class="checkTypeName" name="checkTypeName" >
							<select id="checkTypeID" class="col-sm-3 col-md-3 selectList validate[required]" onchange='getSelectText2(this.id)'   name="checkTypeID"  >		
									<option value="">&nbsp;请选择</option>
									<c:forEach items="${checkTypeList}" var="checkType">
										<option value="${checkType.dicTypeID}" <c:if test="${proCheckReport.checkTypeID eq checkType.dicTypeID}"> selected="selected"</c:if>  >${checkType.dicTypeName}</option>
									</c:forEach>
						    </select>
					</div>
					
				</div> 
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right">检查人员：</label>
					<div class="col-sm-10">
						<div class="row">
						<div class="col-xs-10 col-sm-3 ">
							<div class="input-group select_user_tree_roles">
								<input class="form-control" autoField=checkUserID name="checkUserName" id="select_user_tree_roles" type="text" value="${proCheckReport.checkUserName}" dataValue="${proCheckReport.checkUserID}" />
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110  "></i>
								</span>
							
							</div>
						</div>
					</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right">受访人员：</label>
					<div class="col-sm-10">
						<input type="text" class="col-sm-3" id="form-input-readonly" name="respondents" value="${proCheckReport.respondents}">
					</div>
				</div>
				
				<div class="space-20"></div>
				<h4 class="header smaller lighter blue">跟踪调查内容</h4>
				
				<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">担保贷款的用途、还息及纳税检查： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="guarantyDesc" rows="2">${proCheckReport.guarantyDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
	
				
					<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">投资项目完成情况调查： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="projectDesc" rows="2">${proCheckReport.projectDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
		
					<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">重大经营管理事项调查： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="managerDesc" rows="2">${proCheckReport.managerDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
		
				
				<div class="col-sm-12">
					<h5 class="header smaller lighter orange">风险关注事项</h5>
					
						<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">财务报表是否明显不实： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="reportDesc" rows="2">${proCheckReport.reportDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
						<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">应收帐款有无大幅增加、收回拖延： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="accountDesc" rows="2">${proCheckReport.accountDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
					
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">存货是否较大、有无突然增加： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="stockDesc" rows="2">${proCheckReport.stockDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">银行债务有无大量增加： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="debtDesc" rows="2">${proCheckReport.debtDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
					
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">资产负债结构有无重大变化： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="assetDesc" rows="2">${proCheckReport.assetDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
			
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">流动比远低于正常值： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="currentRatioDesc" rows="2">${proCheckReport.currentRatioDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
					
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">成本上升或利润下降： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="capitalizedDesc" rows="2">${proCheckReport.capitalizedDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
					
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">短借长用情况是否显著： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="borrowDesc" rows="2">${proCheckReport.borrowDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">货币资金余额是否不断下降： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="monetaryDesc" rows="2">${proCheckReport.monetaryDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
		
				
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">拖延支付利息或费用： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="costDesc" rows="2">${proCheckReport.costDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">其它： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="otherDesc" rows="2">${proCheckReport.otherDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
				</div> 
				
				<div class="col-sm-12">
					<h5 class="header smaller lighter orange">反担保措施检查</h5>
					
					<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">抵押物是否出租、转租、赠予，形态是否完整，价值、权属有无变动等： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="mortgageDesc" rows="2">${proCheckReport.mortgageDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">反担保企业资产、信用、财务等状况有无恶化、反担保能力有无下降： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="enterpriseAssetsDesc" rows="2">${proCheckReport.enterpriseAssetsDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
			<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">反担保个人有无经济诉讼案件、大额财产有无变化： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="personAssetsDesc" rows="2">${proCheckReport.personAssetsDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
							<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">其它： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="otherOptDesc" rows="2">${proCheckReport.otherOptDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
				
				</div>
				
				<div class="col-sm-12">
					<h5 class="header smaller lighter orange">还贷情况检查</h5>
					
					
								<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">还贷情况检查： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="payDesc" rows="2">${proCheckReport.payDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div> 
				</div>
				
				<div class="col-sm-11 ">
					<h5 class="header smaller lighter orange">风险等级评价</h5>
					<div class="form-group col-sm-6">
						<label class="col-sm-3 control-label no-padding-right">原风险评级：</label>
						<div class="col-sm-9">
							<input type="hidden" id="riskLevelName"  class="riskLevelName" name="riskLevelName" >
							<select id="riskLevelID" class="col-sm-4 " onchange='getSelectText3(this.id)'   name="riskLevelID"  >		
									<option value="">&nbsp;请选择</option>
									<c:forEach items="${riskLevelList}" var="riskLevel">
										<option value="${riskLevel.dicTypeID}" <c:if test="${proCheckReport.riskLevelID eq riskLevel.dicTypeID}"> selected="selected"</c:if>  >${riskLevel.dicTypeName}</option>
									</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-3 control-label no-padding-right"><i class="icon-asterisk orange"></i>拟调整风险评级：</label>
	
						<div class="col-sm-9">
							<input type="hidden" id="newRiskLevelName"  class="newRiskLevelName" name="newRiskLevelName" >
							<select id="newRiskLevelID" class="col-sm-4 selectList " onchange='getSelectText2(this.id)'   name="newRiskLevelID"  >		
									<option value="">&nbsp;请选择</option>
									<c:forEach items="${newRiskLevelList}" var="newRiskLevel">
										<option value="${newRiskLevel.dicTypeID}" <c:if test="${proCheckReport.newRiskLevelID eq newRiskLevel.dicTypeID}"> selected="selected"</c:if>  >${newRiskLevel.dicTypeName}</option>
									</c:forEach>
						    </select>
						</div>
						
						</div>
						
								<div class="form-group edit_creditResult">
					<label style="line-height:30px;" class="col-sm-11 col-sm-offset-1  no-padding-right">调整风险评级说明： </label>
					<br/>
					<div class="col-sm-11 col-sm-offset-1">
						<textarea class="col-sm-7 validate[maxSize[200]]"   name="riskLevelDesc" rows="5">${proCheckReport.riskLevelDesc}</textarea>
						<div class="col-sm-7 no-padding-right">
							<span class="light-grey" style="float:right">限制200个字符</span>
						</div>
					</div>
				</div>
					
				</div>
			</form>
		</div>
	</div>
	<div class="space-10"></div>
		<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-primary btn_submit" id="btn_submit222">
					<i class="icon-ok bigger-110">保存</i>
				</button>
				&nbsp;&nbsp;&nbsp;
	
				<!-- <button class="btn btn-default btn-close" id="btn-close">
					<i class="icon-remove bigger-110 ">关闭22</i>
				</button> -->
				
			</div>
	</div>
</div>

<%@ include file="/common_foot.jsp" %>
<script type="text/javascript" src="<%=path%>/project/afterCheck/checkDetail.js?v=<%=vardate%>"></script>