<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="modal fade bs-example-modal-sm" id="updateBasicInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改基本信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="updateBasicInfo_Form">
					 <input type="hidden" id="user_name" name="user_name" value="${hrstaffCase.user_name}">
					 <input type="hidden" id="user_uid" name="user_uid" value="${hrstaffCase.user_uid}">					
					  <input type="hidden" id="staffcase_Id" name="staffcase_Id" value="${hrstaffCase.staffcase_Id}">
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>员工姓名: </label>
						<div class="col-sm-8">
						<h5>
							<span style="margin-left:2em;"></span>
    		<span class="grey">${hrstaffCase.user_name}</span>
								
		</h5>
							
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">员工编号： </label>
						<div class="col-sm-8">
						<h5>
						<span style="margin-left:2em;">
				<span class="grey">${hrstaffCase.user_bh}</span>				
			</span></h5>						
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>性别： </label>
						<div class="col-sm-10">
							<label class="radio-inline"> <input type="radio" value="男" name="sex" <c:if test="${hrstaffCase.sex != '女'}"> checked</c:if>>男
							</label> <label class="radio-inline"> <input type="radio" value="女" name="sex" <c:if test="${hrstaffCase.sex == '女'}"> checked</c:if>>女
							</label>

						</div>
					</div>
						<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>身份证号： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffDocuments validate[required,minSize[18],maxSize[18]]" name="staffDocuments" id="staffDocuments" value="${hrstaffCase.staffDocuments}" />
						</div>
					</div>
				<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">民族： </label>
						<div class="col-sm-8">					
						<input type="hidden" name="staffNational">
						   <select name="staffNational"  class="col-xs-6 col-sm-6 validate[maxSize[32]]" id="btn_staffNational">
									<option value="">请选择</option>
									<c:forEach var="mz" items="${minzuMap}">
										<option  value="${mz.key}" <c:if test="${mz.key eq  hrstaffCase.staffNational}">selected="selected"</c:if>>${mz.value}</option>						
									</c:forEach>	
							</select>				
						</div>
					</div>	
				
				<!-- 	<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" style="line-height: 28px;">&nbsp;</label>
					</div> -->
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">出生日期： </label>
						<div class="col-sm-10">
							<div class="input-group col-sm-4" style="float: left;">
							<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="borndate" 
										value="<fmt:formatDate value='${hrstaffCase.borndate}' pattern='yyyy-MM-dd' type='date'/>"/>													
								
									 <span class="input-group-addon">
									
									 <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">婚姻状况： </label>
						<div class="col-sm-8">
						<select name="staffMarriage"  class="col-xs-6 col-sm-6 validate[maxSize[32]]" id="btn_staffMarriage">
									<option value="">请选择</option>
						<c:forEach var="hy" items="${MarriageMap}">
									<option value="${hy.key}"  <c:if test="${hy.key eq  hrstaffCase.staffMarriage}">selected="selected"</c:if>>${hy.value}</option>						
								</c:forEach>	
							</select>
							
							
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">政治面貌： </label>
						<div class="col-sm-8">					
								<select name="staffPolitical"  class="col-xs-6 col-sm-6 validate[maxSize[32]]" id="btn_staffPoliticalName">
									<option value="">请选择</option>
									<c:forEach var="zz"  items="${ZhengzhiMap}">
										<option value="${zz.key}" <c:if test="${zz.key eq  hrstaffCase.staffPolitical}">selected="selected"</c:if>>${zz.value}</option>
									</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">籍贯： </label>
						<div class="col-sm-8">
							<%-- <select name="staffBirthplace"  class="col-xs-6 col-sm-6 validate[maxSize[32]]" id="btn_staffBirthplace">
									<option value="">请选择</option>
									<c:forEach var="jg"  items="${BirthpalceMap}">
										<option value="${jg.key}" <c:if test="${jg.key eq  hrstaffCase.staffBirthplace}">selected="selected"</c:if>>${jg.value}</option>
									</c:forEach>
							</select> --%>
						<input type="text" class="col-sm-12 ztb_edit_staffAccountLocation validate[maxSize[50]] " name="staffBirthplace" id="staffBirthplace" value="${hrstaffCase.staffBirthplace}" />
							
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">户口所在地： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffAccountLocation validate[maxSize[50]] " name="staffAccountLocation" id="staffHomeADR" value="${hrstaffCase.staffAccountLocation}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">户籍性质： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffCensus validate[maxSize[100]]" name="staffCensus" id="staffCensus" value="${hrstaffCase.staffCensus}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">试用期： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-4 ztb_edit_staffPeriod validate[custom[number],maxSize[6]]" name="staffPeriod" id="staffPeriod" value="${hrstaffCase.staffPeriod}" /> <span
								style="line-height: 28px; margin-left: 1em;"> 月</span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">学历： </label>
						<div class="col-sm-8">
							<select name="staffEducation"  class="col-xs-6 col-sm-6 validate[maxSize[32]]" id="btn_staffEducation">
									<option value="">请选择</option>
									<c:forEach var="xl"  items="${EducationMap}">
										<option value="${xl.key}" <c:if test="${xl.key eq  hrstaffCase.staffEducation}">selected="selected"</c:if>>${xl.value}</option>
									</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">职称： </label>
						<div class="col-sm-8">
								<select name="staffTitle"  class="col-xs-6 col-sm-6 validate[maxSize[32]]" id="btn_staffTitle">
									<option value="">请选择</option>
									<c:forEach var="zc"  items="${ZhichengMap}">
										<option value="${zc.key}" <c:if test="${zc.key eq  hrstaffCase.staffTitle}">selected="selected"</c:if>>${zc.value}</option>
									</c:forEach>
							</select>							
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">毕业院校： </label>
						
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffGraduateInstitutions validate[maxSize[25]]" name="staffGraduateInstitutions" id="staffGraduateInstitutions" value="${hrstaffCase.staffGraduateInstitutions}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">邮编： </label>
						
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffHomeZIP validate[maxSize[6]]" name="staffHomeZIP" id="staffHomeZIP" value="${hrstaffCase.staffHomeZIP}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">参加工作时间： </label>
						<div class="col-sm-10">
								<div class="input-group col-sm-4" style="float: left;">
								<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="startWorkDate" 
										value="<fmt:formatDate value='${hrstaffCase.startWorkDate}' pattern='yyyy-MM-dd' type='date'/>"/>
							 <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
						<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">加入本单位时间： </label>
						<div class="col-sm-10">
								<div class="input-group col-sm-4" style="float: left;">
								<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="joinWorkDate" 
										value="<fmt:formatDate value='${hrstaffCase.joinWorkDate}' pattern='yyyy-MM-dd' type='date'/>"/>
							 <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>员工类型： </label>
						<div class="col-sm-8">
									<select name="staffType"  class="col-xs-6 col-sm-6 validate[required,maxSize[32]]" id="btn_staffTypeName">
									<option value="">请选择</option>
									<c:forEach var="yg"  items="${ygMap}">
									
										<option  value="${yg.key}" <c:if test="${hrstaffCase.staffType eq yg.key }">selected="selected"</c:if>>${yg.value}</option>
									</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">职务： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffDuty validate[maxSize[10]]"  name="staffDuty" id="staffDuty" value="${hrstaffCase.staffDuty}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right " for="form-input">家庭电话： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_staffHomeTEL validate[minSize[11],maxSize[11]]" name="staffHomeTEL" id="staffHomeTEL" value="${hrstaffCase.staffHomeTEL}" />
						</div>
					</div>
						<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right " for="form-input">电子邮件： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_email validate[maxSize[11]]" name="email" id="email" value="${hrstaffCase.email}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right " for="form-input">手机号： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_mobilphone validate[maxSize[11]]" name="mobilphone" id="mobilphone" value="${hrstaffCase.mobilphone}" />
						</div>
					</div>

					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">分机号： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12 ztb_edit_subphone validate[minSize[11],maxSize[11]] " name="subphone" id="subphone" value="${hrstaffCase.subphone}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">家庭详细地址：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-10 limited  ztb_edit_staffHomeADR validate[maxSize[50]]" rows="5" name="staffHomeADR" id="staffHomeADR">${hrstaffCase.staffHomeADR}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right" >限制50个字符</span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">备注：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-10 limited  ztb_edit_remark validate[maxSize[50]]" rows="5" name="remark" id="remark" >${hrstaffCase.remark}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right" >限制50个字符</span>
							</div>
							
						</div>
					</div>
				<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">劳动合同起始日期： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-10" style="float: left;">
									<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="staffStartContractDate" 
										value="<fmt:formatDate value='${hrstaffCase.staffStartContractDate}' pattern='yyyy-MM-dd' type='date'/>"/>
							 <span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
								
							
							</div>
							
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">劳动合同到期日期： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-10" style="float: left;">
								<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="staffEndContractDate" 
										value="<fmt:formatDate value='${hrstaffCase.staffEndContractDate}' pattern='yyyy-MM-dd' type='date'/>"/>
							 <span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
							</div>
						</div>
					</div>
						<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">转正日期： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-10" style="float: left;">
								<input class="form-control date-picker validate[custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="staffRegularizedDate" 
										value="<fmt:formatDate value='${hrstaffCase.staffRegularizedDate}' pattern='yyyy-MM-dd' type='date'/>"/>
							 <span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
							</div>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right " for="form-input">已休年假： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 ztb_add validate[custom[number],maxSize[2]]" name="staffYearHoliday" id="staffYearHoliday"  value="${hrstaffCase.staffYearHoliday}"/> <span
								style="line-height: 28px; margin-left: 1em;"> 天 </span>
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-ok bigger-110'></i>保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
