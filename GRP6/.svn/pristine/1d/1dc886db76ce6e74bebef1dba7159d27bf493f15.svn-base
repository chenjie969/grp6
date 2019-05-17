<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp"%>
<div class="page-content" style="position: relative;z-index: 1041;">
	<div class="row">
		<div class="col-xs-12">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active" data-str='add'><a data-toggle="tab" href="#ok"
						id="relieveList"> 新增 </a></li>

					<li data-str='choose'><a data-toggle="tab" href="#no" id="disposeList"> 选择 </a></li>
				</ul>
				<div class="tab-content">
					<!-- PAGE CONTENT BEGINS -->
					<!-- <div class="row"> -->
					<div id="div_basicInfo" class="baseOne">
						<!-- div_basicInfo 开始-->
						<form class="form-horizontal" role="form" id="form_baseOne">
							<div class="page-header">
								<h5 id='OptGuarantyPage'>新增保证措施</h5>
							</div>
							
							<div class="space-4"></div>
							<div class="form-group highQuota">
                                  <div>
                                  	<label class="col-sm-2 control-label no-padding-right" for="form-input">
	                                  	<i class="icon-asterisk orange"></i>是否有最高保证额： 
	                                  </label>
	                                  <div class="radio">
	                                      <label style="margin-top:-10px;">
	                                          <input type="radio" name="isGuarantyMaxSum" onchange="GuarantyMaxSum(this.value)" value="1" class="ace" checked="checked">
	                                          <span class="lbl">是</span>
	                                      </label>
	                                      <label style="margin-top:-10px;">
	                                          <input type="radio" name="isGuarantyMaxSum" onchange="GuarantyMaxSum(this.value)" value="0" class="ace">
	                                          <span class="lbl">否</span>
	                                      </label>
	                                  </div>
                                  </div>
							</div>
							
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right"
									for="form-input"><i class="icon-asterisk orange"></i>项目名称：
								</label>
								<div class="col-sm-8 col-lg-4">
									<input type="text" placeholder="请选择项目"
										class="col-sm-8 validate[required]"
										value="${apply.projectName }" readonly="readonly"
										name="clientName" />
									<%-- validate[required] --%>
									<%-- <input type="hidden" name="client_ID"/> --%>
									<input type="hidden" name="apply_ID" value="${apply_ID }" />
									<%-- 客户申请记录ID --%>
									<div class="col-sm-4 ">
										<c:if test="${apply eq null }">
											<button class="btn btn-xs btn-info" type="button"
												id="btn_chooseProj" name="button" data-toggle="modal"
												data-target="#select">选择</button>
										</c:if>
									</div>
								</div>
							</div>

							<%-- 担保方式为： 企业信用相关隐藏提交的信息 --%>
							<input type="hidden" name="otherLegalPerson" id=""> <input
								type="hidden" name="otherLegalPhone" id=""> <input
								type="hidden" name="otherLegalAddress" id=""> <input
								type="hidden" name="otherPostCode" id=""> <input
								type="hidden" name="otherFax" id=""> <input
								type="hidden" name="otherPersonPhone" id=""> <input
								type="hidden" name="otherPersonAddress" id="">


							<div class="space-4"></div>
							<div class="form-group" id="guarantyTypeDIV">
								<label class="col-sm-2 control-label no-padding-right"
									for="form-field-1"> <i class="icon-asterisk orange"></i>保证方式：
								</label>
								<div class="col-sm-4  col-lg-4">
									<input type="hidden" name="guarantyTypeName"> <select
										name="guarantyTypeID"
										class="col-xs-6 col-sm-6 validate[required,maxSize[50]]"
										id="btn_guarantyTypes">
										<option value="">请选择</option>
										<c:forEach var="bz" items="${baozhengList}">
											<option value="${bz.dicTypeID }">${bz.dicTypeName }</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="space-4"></div>
							<div class="form-group" id="btn_optTypesDIV">
								<label class="col-sm-2 control-label no-padding-right"
									for="form-field-1"> <i class="icon-asterisk orange"></i>反担保类型：
								</label>
								<div class="col-sm-4 col-lg-4">
									<input type="hidden" name="optTypeName" id="optTypeName">
									<select class="col-xs-6 col-sm-6  validate[required]"
										id="btn_optTypes" name="optTypeID">
										<option value="">请选择</option>
									</select>
								</div>
							</div>

							<div class="space-4"></div>
							<div class="form-group ownerType">
								<label class="col-sm-2 control-label no-padding-right"
									for="form-input"><i class="icon-asterisk orange"></i>权属人类型：
								</label>
								<div class="radio">
									<label style="margin-top: -10px;"> <input type="radio"
										name="optType" class="ace ownerTypes" id="optType01"
										value="01" checked="checked"> <span class="lbl">法人</span>
									</label> <label style="margin-top: -10px;"> <input
										type="radio" name="optType" id="optType02"
										class="ace ownerTypes" value="02"> <span class="lbl">自然人</span>
									</label>
								</div>
							</div>

							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right"
									for="form-field-1"> <i class="icon-asterisk orange"></i>权属人：
								</label>
								<div class="col-sm-8  col-lg-4">
									<input type="text" placeholder="请选择客户"
										class="col-sm-8 ownerInput validate[required] "
										readonly="readonly" name="ownerName" /> <input type="hidden"
										name="clientTypeID" class="ownerInput" />
									<%-- 权属人类型  validate[required]--%>
									<input type="hidden" name="certificateCode" class="ownerInput" />
									<%-- 统一社会信用代码 --%>
									<input type="hidden" name="personNum" class="ownerInput" />
									<%-- 身份证号码 --%>
									<input type="hidden" name="client_ID" class="ownerInput" />
									<%-- 客户编号 (客户id) --%>

									<div class="col-sm-4 ">
										<button class="btn btn-xs btn-info" type="button"
											id="btn_choosePerson" name="button" data-toggle="modal"
											data-target="#select">选择</button>
										<div style="display:inline-block;" class="addBtnPerson">
										<button class="btn btn-xs btn-info" type="button"
											id="btn_addPerson" name="button">新增</button></div>
									</div>
								</div>
							</div>
						<input type="hidden" name="optGuaranty_ID" class="ownerInput" />
						<input type="hidden" name="optGuarantyIds" class="ownerInput" />
						<div class="form-group" id="guarantyWrap" style="display: none;">
						    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>担保物： </label>
						    <div class="col-sm-8  col-lg-4">
						        <input type="text"  placeholder="请选择担保物" class="col-sm-8 ownerInput" readonly="readonly" name="optName"/>
										<div class="col-sm-4 ">
												<button class="btn btn-xs btn-info" type="button" id="btn_chooseGuaranty" name="button" data-toggle="modal" data-target="#select">选择</button>
										</div>
						    </div>
						</div> 
						</form>
					</div>
					<!-- div_basicInfo 结束-->
					<div class="baseTwo" style="display: none;"
						id="addOptGuarantyNextPage">
						<%-- <%@ include file="/project/opt/optManager/DYlandGuaranty.jsp" %> --%>
					</div>

					<div class="space-30"></div>
					<div class="clearfix form-actions">
							<div class="col-sm-offset-3 col-sm-9">
								<!-- 下一步页面   返回上一步   默认隐藏 -->
								<button class="btn btn-primary baseTwo" type="button"
									id="btn_previousStep" style="display: none;">
									<i class="icon-arrow-left bigger-110"></i>上一步
								</button>
								&nbsp; &nbsp; &nbsp;
								<!-- 基本信息页面保存 -->
								<button class="btn btn-primary baseOne" type="button"
									id="btn_addOptGuarantyNext">
									<i class="icon-arrow-right bigger-110"></i>下一步
								</button>
								<%-- 选择的 保存功能 --%>
								<button class="btn btn-primary" type="button"
									id="btn_addOptGuarantySave" style="display: none">
									<i class="icon-ok bigger-110"></i>保存
								</button>
								&nbsp; &nbsp; &nbsp;
								<!-- 下一步页面保存  默认隐藏 -->
								<button class="btn btn-primary baseTwo" type="button"
									id="btn_addOptGuaranty" style="display: none">
									<i class="icon-ok bigger-110"></i>保存
								</button>
								&nbsp; &nbsp; &nbsp;
								<!--下一步页面   保存并继续添加显示  -->
								<button class="btn btn-primary baseTwo" type="button"
									id="btn_addOptGuarantyAgain" style="display: none">
									<i class="icon-plus bigger-110"></i>保存并继续添加
								</button>
								&nbsp; &nbsp; &nbsp;
								<%-- 关闭按钮 基本信息页面 和 下一步页面公用 --%>
								<button class="btn " type="button" id="btn_close">
									<i class="icon-remove bigger-110"></i>关闭
								</button>
								
							</div>
						</div>
				</div>
			</div>
			<!-- </div> -->
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</div>
<!-- /.page-content -->

<div id="optGuarantyAdd_page"></div>
<%@ include file="/common_message.jsp"%>
<%@ include file="/project/opt/optManager/clientList.jsp"%>
<%@ include file="/common_foot.jsp"%>
<script src="<%=path%>/project/opt/optManager/optGuarantyAdd.js?v=<%=vardate%>"></script>
<script>
	function GuarantyMaxSum(e){
		$("input[name=clientName]").val("")
	}
</script>	









