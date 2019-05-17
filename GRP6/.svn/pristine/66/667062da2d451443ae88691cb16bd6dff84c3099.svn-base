<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.table_busiLimit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	.table_busiLimit tr th,.table_busiLimit tr td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	};
	/* 关于css选择器
		原来的写法是  .table_busiLimit tr th,td， 这样写是不对的。
	
		#div1 p,span 是表示 选择#div 下的 p 元素 和全部 span元素(包括非#div下 和#div下的）
	 */
</style>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>


	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<!-- <div class="row"> -->
 					<!-- <input type="hidden" id="form1SubmitFlag" value="false">	第一个表单是否提交过的标识，默认为false，表单1保存成功置为true，点击返回上一步置为false -->
 					
 					<!-- 第一个表单，授信申请登记的基本信息 -->
                    <form class="form-horizontal" role="form" id="form1_creditAdd">
                    	<!-- <input type="hidden" name="apply_ID" id="hidden_applyID">		默认为空，表单1保存成功后填入返回的主键ID，当再次提交表单1时，根据此值是否为空，判断是新增还是修改操作。 -->
					<div id="div_basicInfo">	<!-- div_basicInfo 开始-->
						<div class="page-header">
							<h5>授信申请</h5>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
					   		<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>授信客户类型： </label>
							<div class="col-sm-6 col-lg-4">
								<select class="col-sm-6" id="select_creditClientType">
									<option value="single">企业客户</option>
									<option value="relation">集团/关联客户</option>
								</select>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>授信客户名称： </label>
							<div class="col-sm-10  col-lg-8">
								<input type="text"  placeholder="请选择客户" class="col-sm-5 validate[required]" readonly="readonly" name="clientName"/>
								<input type="hidden" name="client_ID"/>
								<input type="hidden" name="clientGUID"/>
								<input type="hidden" name="relationID"/>
								<input type="hidden" name="relationName"/>
                                <div class="col-sm-7 ">
                                    <button class="btn btn-xs btn-info" type="button" id="btn_showCompanyList" name="button" data-toggle="modal" data-target="#select">从企业库中选择</button>
                                </div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>授信项目名称： </label>
						    <div class="col-sm-10 col-lg-8">
						        <input type="text"  class="col-sm-5 validate[required,maxSize[100]]" name="projectName"/>
						    </div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
					   		<label class="col-sm-2 control-label no-padding-right" for="form-input">授信项目类型： </label>
							<div class="col-sm-6 col-lg-4">
								<select class="col-sm-6"  name="creditTypeID">
									<option value="">请选择</option>
									<c:forEach items="${creditTypeList }" var="creditType">
										<option value="${creditType.dicTypeID }">${creditType.dicTypeName }</option>
									</c:forEach>
								</select>
								<input type="hidden" name="creditTypeName">
							</div>
						</div>
					
					<!-- <div id="div_busiLimit_false"> -->
						<div class="space-4"></div>
						<div class="form-group">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>授信总额度： </label>
						    <div class="col-sm-10  col-lg-8">
						        <input type="text" class="col-sm-3 validate[required,custom[isExceed],custom[number],maxSize[18]]" name="applySum" id="input_applyTotalSum"/>
						        <span class="col-sm-2" style="line-height:28px;">万元</span>
						    </div>
						</div>
					<!-- </div> -->
						
						<div class="space-4"></div>
						<div class="form-group">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1">授信起始日期： </label>
						    <div class="col-sm-6">
								<div class="input-group col-sm-6 col-lg-4">
									<input class="form-control date-picker validate[custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="creditBeginDate"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1">授信结束日期： </label>
						    <div class="col-sm-6">
								<div class="input-group col-sm-6 col-lg-4">
									<input class="form-control date-picker validate[custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="creditEndDate"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>循环使用授信额度： </label>
							<div class="col-sm-9">
								<div class="radio">
									<label>
										<input type="radio" name="isLoopCredit" checked="checked" class="ace form-field-radio" value="1"/>
										<span class="lbl">是</span>
									</label>
									<label>
										<input  type="radio" name="isLoopCredit" class="ace form-field-radio"  value="0" />
										<span class="lbl">否</span>
									</label>
								</div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>限制品种与合作机构： </label>
							<div class="col-sm-9">
								<div class="radio">
									<label>
										<input type="radio" name="isBusiLimit" class="ace form-field-radio" value="1"/>
										<span class="lbl">是</span>
									</label>
									<label>
										<input type="radio" name="isBusiLimit" checked="checked" class="ace form-field-radio"  value="0" />
										<span class="lbl">否</span>
									</label>
								</div>
							</div>
						</div> 
						
						<div class="col-sm-11" id="div_busiLimit_true">
							<h5 class="col-sm-offset-1 col-lg-8 header smaller lighter blue">
								授信明细
								<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_addBusiLimit">
									<i class="icon-edit bigger-110"></i>
									<span class="bigger-110 no-text-shadow">添加</span>
								</button>
							</h5>
							<div class="col-sm-offset-1 col-lg-8">
								<table  id="table_busiLimit" class="table table-hover table-striped table_busiLimit">
									<input type="hidden" id="hidden_busiTableDate" name="busiTableDate">	<!-- 隐藏域，存储拼接的表格内容，传递后台 -->	
									<input type="hidden" id="hidden_rowIndex" value="1">		<!-- 隐藏域，存储新增行的编号，每增加一行，此值加1 -->
						 			<thead>
										<tr>
											<th><i class="icon-asterisk orange"></i>业务品种</th>
											<th><i class="icon-asterisk orange"></i>授信额度（万元）</th>
											<th>合作机构 </th>
											<th style="width:80px">操作</th>
										</tr>
									</thead>
									<tbody></tbody>	
								</table>
							</div>
						
							<div class="space-4"></div>
							<div class="form-group col-sm-12" id="div_isBlend" style="display:none">
								<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>是否额度混用： </label>
								<div class="col-sm-9">
									<div class="radio">
										<label>
											<input type="radio" name="isBlend" id="radio_isBlend_true" class="ace form-field-radio" value="1"/>
											<span class="lbl">是</span>
										</label>
										<label>
											<input  type="radio" name="isBlend"	 class="ace form-field-radio"  value="0" />
											<span class="lbl">否</span>
										</label>
									</div>
								</div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
					   		<label class="col-sm-2 control-label no-padding-right" for="form-input">经办部门： </label>
			       			<div class="col-sm-6 col-lg-4">
								<div class="col-sm-6 input-group selectCreateDepart">
									<input  type="text"  class="form-control" autoField="departID"   id="selectCreateDepart"  
										value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="departName" readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
	
						<div class="space-4"></div>
						<div class="form-group">
						   	<label class="col-sm-2 control-label no-padding-right" for="form-input">经办人： </label>
						   	<div class="col-sm-6 col-lg-4">
						        <div class="col-sm-6 input-group selectCreateUser">
									<input  type="text"  class="form-control" autoField="createManID"   id="selectCreateUser"  
										value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createManName" readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
								</div>
							</div>
         				</div>
	
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-input">受理日期： </label>
			         		<div class="col-sm-6">
								<div class="input-group col-sm-6 col-lg-4">
									<input class="form-control date-picker validate[custom[date]]" id="date-picker-1" type="text" data-date-format="yyyy-mm-dd" name="createDate"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>	<!-- div_basicInfo 结束-->
					</form>
					
					<!-- 第二个表单，与授信申请绑定的一个具体项目的新增信息 -->
					<form class="form-horizontal" role="form" id="form2_projectAdd">		
						<input type="hidden" name="parentApply_ID" id="hidden_parentApplyID">	<!-- 默认为空，表单1保存成功后填入返回的主键ID，提交表单2时，新插入的项目申请凭此字段与授信申请产生联系。 -->			
						<input type="hidden"  id="hidden_departID">
						<input type="hidden"  id="hidden_departName">
						<input type="hidden"  id="hidden_createManID">
						<input type="hidden"  id="hidden_createManName">
						<input type="hidden"  id="hidden_createDate">
					<div id="div_addProject">	<!-- div_addProject 开始-->	
						<div class="page-header">
							<h5>授信项下项目申请登记</h5>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
						   	<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务性质： </label>
					        <div class="col-sm-6 col-lg-4">
								<select class="col-sm-6 validate[required]" name="busiNatureID">
									<option value="">请选择</option>
									<c:forEach items="${busiNatureList }" var="busiNature">
										<option value="${busiNature.dicTypeID }">${busiNature.dicTypeName }</option>
									</c:forEach>
								</select>
								<input type="hidden" name="busiNatureName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
					   		<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>项目类型： </label>
							<div class="col-sm-6 col-lg-4">
								<select class="col-sm-6 validate[required]" name="projectTypeID">
									<option value="">请选择</option>
									<c:forEach items="${projectTypeList }" var="projectType">
										<option value="${projectType.dicTypeID }">${projectType.dicTypeName }</option>
									</c:forEach>
								</select>
								<input type="hidden" name="projectTypeName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>客户名称： </label>
							<div class="col-sm-10 col-lg-8">
								<select id="select_relationCompany"  class="col-sm-5  validate[required]" name="client_ID"></select>
								<input type="hidden" name="clientName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称： </label>
							<div class="col-sm-10 col-lg-8">
								<input type="text"  class="col-sm-5  validate[required,maxSize[100]]" name="projectName" id="input_projectName"/>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
						   	<label class="col-sm-2 control-label no-padding-right" for="form-input">项目来源： </label>
					        <div class="col-sm-6 col-lg-4">
								<select class="col-sm-6" name="projectSourceID">
									<option value="">请选择</option>
									<c:forEach items="${projectSourceList }" var="projectSource">
										<option value="${projectSource.dicTypeID }">${projectSource.dicTypeName }</option>
									</c:forEach>
								</select>
								<input type="hidden" name="projectSourceName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
				   	    	<label class="col-sm-2 control-label no-padding-right" for="form-input">来源说明： </label>
							<div class="col-sm-6">
							    <textarea class="col-sm-12  limited validate[maxSize[250]]"  rows="5" name="sourceDesc"></textarea>
							</div>
							<div class="col-sm-8 ">
							    <span class="light-grey" style="float:right;">限制250个字符</span>
							</div>
						</div>
											
						<div class="space-4"></div>
						<div class="form-group">
						   	<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务品种： </label>
				        	<!-- 授信项没有业务品种限制，此处是树 -->
					        <div class="col-sm-6 col-lg-4" id="div_busiType_tree">
								<div class="col-sm-6 input-group selectBusiType_project">
									<input  type="text"  class="form-control" autoField="tree_busiTypeID"  id="selectBusiType_project"  name="tree_busiTypeName" readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
								</div>
							</div>
							<!-- 授信项有业务品种限制，此处是下拉选择框 -->
							<div class="col-sm-6 col-lg-4" id="div_busiType_select">
								<select class="col-sm-6" name="select_busiTypeID"></select>
								<input type="hidden" name="select_busiTypeName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
						   	<label class="col-sm-2 control-label no-padding-right" for="form-input">绿色通道： </label>
					        <div class="col-sm-6 col-lg-4">
								<select class="col-sm-6" name="greenChannelID">
									<option value="">请选择</option>
									<c:forEach items="${greenChannelList }" var="greenChannel">
										<option value="${greenChannel.dicTypeID }">${greenChannel.dicTypeName }</option>
									</c:forEach>
								</select>
								<input type="hidden" name="greenChannelName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>申请金额： </label>
						    <div class="col-sm-10  col-lg-8">
						        <input type="text" class="col-sm-3 validate[required,custom[number],maxSize[18],custom[lessThanCredit]]" name="applySum" id="applySum_project"/>
						        <span class="col-sm-2" style="line-height:28px;">万元</span>
						    </div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>申请期限： </label>
						    <div class="col-sm-10  col-lg-8">
						        <div class="col-sm-6 no-padding-left">
						            <input type="text" style="width:8em;" class="validate[required,maxSize[5],custom[integer]]" name="periodMonth"/>
						    		&nbsp;&nbsp;个月&nbsp;&nbsp;
									<input type="text" style="width:8em;" class="validate[required,maxSize[5],custom[integer]]" name="periodDay" value="0"/>
					                &nbsp;&nbsp;天&nbsp;
						        </div>
						    </div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
					   		<label class="col-sm-2 control-label no-padding-right" for="form-input">合作机构： </label>
					   		<!-- 授信项没有业务品种限制，或有业务品种限制但该业务下没有合作机构限制时，此处是树 -->
				        	<div class="col-sm-6 col-lg-4" id="div_bank_tree">
								<div class="col-sm-6 input-group selectCooperation_project">
									<input  type="text"  class="form-control" autoField="bankID"   id="selectCooperation_project"  name="bankName" readonly="readonly"/>
									<span class="input-group-addon ">
										<i class="icon-caret-down bigger-110"></i>
									</span>
								</div>
							</div>
							<!-- 授信项有业务品种限制，根据业务品种与合作机构的对应关系，生成此处下拉选择框 -->
							<div class="col-sm-6 col-lg-4" id="div_bank_select" style="display:none">
								<select class="col-sm-6" name="select_bankID">
									<option value="">请选择</option>
								</select>
								<input type="hidden" name="select_bankName">
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
			   	 		   <label class="col-sm-2 control-label no-padding-right" for="form-input">贷款(担保)用途： </label>
							<div class="col-sm-6">
							    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="loadUsed"></textarea>
							</div>
							<div class="col-sm-8 ">
							    <span class="light-grey" style="float:right;">限制2000个字符</span>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-input">还款计划和来源： </label>
							<div class="col-sm-6">
							    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="repaymentPlan"></textarea>
							</div>
							<div class="col-sm-8  ">
							    <span class="light-grey" style="float:right;">限制2000个字符</span>
							</div>
						</div>
	
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right" for="form-input">拟提供的保证措施： </label>
							<div class="col-sm-6">
							    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="provideGuaranty"></textarea>
							</div>
							<div class="col-sm-8 ">
							    <span class="light-grey" style="float:right;">限制2000个字符</span>
							</div>
						</div>
	
						<div class="space-4"></div>
						<div class="form-group">
				   	    	<label class="col-sm-2 control-label no-padding-right" for="form-input">备注： </label>
							<div class="col-sm-6">
							    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="otherDesc"></textarea>
							</div>
							<div class="col-sm-8 ">
							    <span class="light-grey" style="float:right;">限制2000个字符</span>
							</div>
						</div>
					</div>	<!-- div_addProject 结束-->
					</form>	
					<!-- 保存按纽 -->
					<div class="clearfix form-actions">
						<div class="col-sm-offset-3 col-sm-9">
							<button class="btn btn-primary" type="button" id="btn_previousStep" style="display:none;">
								<i class="icon-arrow-left bigger-110"></i>返回上一步
							</button>
							<button class="btn btn-primary hide" type="button" id="btn_nextStep">
								<i class="icon-arrow-right bigger-110"></i>继续完善本次用款申请
							</button>
							&nbsp; &nbsp; &nbsp;
							<!-- 保存1 -->
							<button class="btn btn-primary" type="button" id="btn_submitForm1">
								<i class="icon-ok bigger-110"></i>保存<!-- 并退出 -->
							</button>
							<!-- 保存2 -->
							<button class="btn btn-primary" type="button" id="btn_submitForm2" style="display:none">
								<i class="icon-ok bigger-110"></i>保存并退出
							</button>
							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="button" id="btn_close">
								<i class="icon-remove bigger-110"></i>关闭
							</button>
						</div>
					</div>
				<!-- </div> -->
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/credit/apply/clientList.jsp" %>
<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/project/credit/apply/creditApplyAdd.js?v=<%=vardate%>"></script>