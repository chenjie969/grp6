<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

<div class="page-content">   
      <div class="row">
		<div class="col-xs-12">
		
		
		<div class="col-sm-12 space-20"></div>
		<h4 class="header smaller lighter blue">
				项目破产登记
	  		</h4>
		<form class="form-horizontal" role="form" id="bankruptcy_form">
	          <input type="hidden" id="bankruptcyId" class="" name="bankruptcyId" value="${bankruptcy.bankruptcyId}">
				 
				 <div class="form-group ">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-input"><i class="icon-asterisk orange"></i>是否关联诉讼/查封： </label>
				<div class="col-sm-10">
					<label class="radio-inline"> <input type="radio"
						value="1" name="isConSuit"
						<c:if test="${bankruptcy.lawSuitId != null}"> checked</c:if>>关联诉讼
					</label> 
					<label class="radio-inline"> <input type="radio"
						value="2" name="isConSuit"
						<c:if test="${bankruptcy.assetSealId != null && (bankruptcy.lawSuitId == null || bankruptcy.lawSuitId eq '')}"> checked</c:if>>关联查封
					</label>
					<label class="radio-inline"> <input type="radio"
						value="0" name="isConSuit"
						<c:if test="${(bankruptcy.lawSuitId == null || bankruptcy.lawSuitId == '') && (bankruptcy.assetSealId == null || bankruptcy.assetSealId == '')}"> checked</c:if>>不关联
					</label> 
				</div>
			 </div>
				<div class="form-group" id="div-lawSuit" style="display:none">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-input"><i class="icon-asterisk orange"></i>诉讼信息：
					</label>
					<div class="col-sm-8 col-lg-4">
						<input type="text" placeholder="请选择诉讼信息"
							class="col-sm-8 validate[required]"
							value="${bankruptcy.lawSuitName}" readonly="readonly"
							name="lawSuitName" id="lawSuitName"/>
						<input type="hidden" id="lawSuitId" name="lawSuitId" value="${bankruptcy.lawSuitId}" />
						<div class="col-sm-4 ">
								<button class="btn btn-xs btn-info" type="button"
									id="btn_chooseSuit" name="button" data-toggle="modal"
									data-target="#select">选择</button>
						</div>
					</div>
				</div>
				<div class="form-group" id="div-assetSealUp" style="display:none">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-input"><i class="icon-asterisk orange"></i>查封信息：
					</label>
					<div class="col-sm-8 col-lg-4">
						<input type="text" placeholder="请选择查封信息"
							class="col-sm-8 validate[required]"
							value="${bankruptcy.assetSealName}" readonly="readonly"
							name="assetSealName" id="assetSealName"/>
						<input type="hidden" name="assetSealId" id="assetSealId" value="${bankruptcy.assetSealId}" />
						<div class="col-sm-4 ">
								<button class="btn btn-xs btn-info" type="button"
									id="btn_chooseAsset" name="button" data-toggle="modal"
									data-target="#select">选择</button>
						</div>
					</div>
				</div>
			
				 <div class="form-group ">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-input">破产登记类型： </label>
					<div class="col-sm-8">
						<label class="radio-inline"> <input type="radio"
							value="01" name="obligorType"
							<c:if test="${bankruptcy.obligorType == '01' || bankruptcy.obligorType == null}"> checked</c:if>>作为破产债务人
						</label>
						<label class="radio-inline"> <input type="radio"
							value="02" name="obligorType"
							<c:if test="${bankruptcy.obligorType == '02'}"> checked</c:if>>作为破产连带债务人
						</label> 
					</div>
				</div>
			 
			 <div class="form-group">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-input"><i class="icon-asterisk orange"></i>项目名称：
				</label>
				<div class="col-sm-8 col-lg-4">
					<input type="text" placeholder="请选择项目"
						class="col-sm-8 validate[required]"
						value="${bankruptcy.projectNameList}" readonly="readonly"
						name="projectNameList" />
					<input type="hidden" name="projectIDList" value="${bankruptcy.projectIDList}" />
					<%-- 客户申请记录ID --%>
					<div class="col-sm-4 ">
						<c:if test="${projectIDList eq null }">
							<button class="btn btn-xs btn-info" type="button"
								id="btn_chooseProj" name="button" data-toggle="modal"
								data-target="#select">选择</button>
						</c:if>
					</div>
				</div>
			</div>
 
 			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>涉及集团及所属公司： </label>
	             <div class="col-md-10">
	                 <select id="guarantyOrgList" class="col-sm-5 validate[required]"  name="affiliateGroup"  >		
						<option value="">&nbsp;请选择</option>
						<c:forEach items="${guarantyOrgList}" var="guarantyOrg">
							<option value="${guarantyOrg.dicTypeName}" <c:if test="${bankruptcy.affiliateGroup eq guarantyOrg.dicTypeName}"> selected="selected"</c:if>>${guarantyOrg.dicTypeName}</option>
						</c:forEach>
				    </select>
	             </div>
			</div>
 				
			 <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>案号： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-2 col-lg-2 validate[maxSize[18]]"  id="recordNum" name="recordNum" value="${bankruptcy.recordNum}" />
	                 <span class="col-md-10 col-lg-10" style="line-height:28px;"></span>
	             </div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>原告： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-2 col-lg-2 validate[required,maxSize[18]]"  id="plaintiff" name="plaintiff"   value="${bankruptcy.plaintiff}"  />
	                 <span class="col-md-10 col-lg-10" style="line-height:28px;"></span>
	             </div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>被告： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-2 col-lg-2 validate[required,maxSize[50]]"  id="defendant" name="defendant"   value="${bankruptcy.defendant}" />
	                 <span class="col-md-10 col-lg-10" style="line-height:28px;"></span>
	             </div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>涉诉金额： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-10 col-lg-2 validate[required,maxSize[18],custom[number]]"  id="lawsuitSum" name="lawsuitSum"  value="${bankruptcy.lawsuitSum}" />
	                 <span class="col-md-2 col-lg-10" style="line-height:28px;">万元</span>
	             </div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-input">管辖法院所属区域： </label>
				<div class="col-sm-2">
					<label class="radio-inline"> <input type="radio"
						value="省内" name="province"
						<c:if test="${bankruptcy.province == '省内'}"> checked</c:if>>省内
					</label>
					<label class="radio-inline"> <input type="radio"
						value="省外" name="province"
						<c:if test="${bankruptcy.province != '省内'}"> checked</c:if>>省外
					</label> 
				</div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>管辖法院（机构）： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-2 col-lg-2 validate[required,maxSize[50]]"  id="lawCourt" name="lawCourt"   value="${bankruptcy.lawCourt}" />
	                 <span class="col-md-10 col-lg-10" style="line-height:28px;"></span>
	             </div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">承办法官： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-2 col-lg-2 validate[maxSize[18]]"  id="undertakeJudge" name="undertakeJudge"   value="${bankruptcy.undertakeJudge}" />
	                 <span class="col-md-10 col-lg-10" style="line-height:28px;"></span>
	             </div>
			</div>
	        <div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>起诉时间： </label>
	         	<div class="col-md-5">
					<div class="input-group col-md-4">
						<input class="form-control date-picker validate[required,custom[date]]" id="lawsuitDate" name="lawsuitDate" type="text" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${bankruptcy.lawsuitDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
	        <div class="form-group ">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-input">是否工作组： </label>
				<div class="col-sm-2">
					<label class="radio-inline"> <input type="radio"
						value="1" name="ifWorkingGroup"
						<c:if test="${bankruptcy.ifWorkingGroup != '0'}"> checked</c:if>>是
					</label> <label class="radio-inline"> <input type="radio"
						value="0" name="ifWorkingGroup"
						<c:if test="${bankruptcy.ifWorkingGroup == '0'}"> checked</c:if>>否
					</label>
				</div>
			</div>
	        <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">执行依据编号： </label>
	             <div class="col-md-10">
	                 <input type="text" class="col-md-2 col-lg-2 validate[maxSize[30]]"  id="executionBasisNum" name="executionBasisNum"   value="${bankruptcy.executionBasisNum}" />
	                 <span class="col-md-10 col-lg-10" style="line-height:28px;"></span>
	             </div>
			</div>
			<div class="form-group">
                  <label class="col-sm-2 control-label no-padding-right" for="form-input">执行依据种类： </label>
                 <div class="col-sm-5">
                     <select id="executionBasisType" class="selectList  col-md-4 "  name="executionBasisType" value="${bankruptcy.executionBasisType}"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${executionBasisTypeList}" var="executionBasisType">
								<option value="${executionBasisType.dicTypeName}" <c:if test="${bankruptcy.executionBasisType eq executionBasisType.dicTypeName}"> selected="selected"</c:if>>${executionBasisType.dicTypeName}</option>
							</c:forEach>
					</select>
                 </div> 
            </div>
              <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">财产查控情况(首封)： </label>
	             <div class="col-md-10">
	                 <textarea class="col-sm-7 limited  validate[maxSize[2000]]" rows="5"  name="firstSeal" id="firstSeal" >${bankruptcy.firstSeal}</textarea>											
					<div class="col-sm-7 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
	             </div>
			</div>
			
			<div class="space-4"></div>
           <div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">财产查控情况(轮候)： </label>
	             <div class="col-md-10">
	                 <textarea class="col-sm-7 limited  validate[maxSize[2000]]" rows="5"  name="waiting" id="waiting" >${bankruptcy.waiting}</textarea>											
					<div class="col-sm-7 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
	             </div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>破产程序类型： </label>
	             <div class="col-md-10">
	             	 <select id="bankruptcyType" class="  col-md-4 "  name="bankruptcyType" value="${bankruptcy.bankruptcyType}"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${bankruptcyTypeList}" var="bankruptcyType">
								<option value="${bankruptcyType.dicTypeName}" <c:if test="${bankruptcy.bankruptcyType eq bankruptcyType.dicTypeName}"> selected="selected"</c:if>>${bankruptcyType.dicTypeName}</option>
							</c:forEach>
					 </select>
	             </div>
			</div>
			 <div class="form-group ">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-input">是否申报债权： </label>
				<div class="col-sm-2">
					<label class="radio-inline"> <input type="radio"
						value="1" name="isClaimsDeclarate"
						<c:if test="${bankruptcy.isClaimsDeclarate != '0'}"> checked</c:if>>是
					</label> <label class="radio-inline"> <input type="radio"
						value="0" name="isClaimsDeclarate"
						<c:if test="${bankruptcy.isClaimsDeclarate == '0'}"> checked</c:if>>否
					</label>
				</div>
			</div>
			<div class="form-group">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">备注： </label>
	             <div class="col-md-10">
	                 <textarea class="col-sm-7 limited  validate[maxSize[2000]]" rows="5"  name="remark" id="remark" >${bankruptcy.remark}</textarea>											
					<div class="col-sm-7 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
	             </div>
			</div>
           <div class="form-group " id="div-fundDeduction">
	           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1">资产扣划情况： </label>
	             <div class="col-md-10">
	                 <textarea class="col-sm-7 limited  validate[maxSize[2000]]" rows="5"  name="fundDeduction" id="fundDeduction" >${bankruptcy.fundDeduction}</textarea>											
					<div class="col-sm-7 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
	             </div>
			</div>
        </form>
        <div class="space-20"></div>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary " id="btn_insertOneBankruptcy" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		       <button class="btn btn_colse" id="btn_colseOneBankruptcy" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div>     
     </div>
    </div>
</div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/project/opt/optManager/clientList.jsp"%>
<%@ include file="/project/lawAssetSealUp/lawSuitList.jsp"%>
<%@ include file="/project/lawsuit/assetSealUpList.jsp"%>
<script type="text/javascript" src="<%=path %>/project/lawBankruptcy/bankruptcy.js?v=<%=vardate%>"></script>
	