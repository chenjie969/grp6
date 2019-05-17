<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="hightSelectEmployee"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">高级查询</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form"
					id="hightSelectEmployee_Form">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">姓名： </label>
						<div class="col-sm-8">
							<input type="text"
								class="col-xs-6 col-sm-6 ztb_edit_user_name validate[maxSize[50]]"
								name="queryCondition.user_name" id="user_name" value="${hrstaffCase.user_name}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">员工编号： </label>
						<div class="col-sm-8">
							<input type="text"
								class="col-xs-6 col-sm-6 ztb_edit_user_bh  "
								name="user_bh" id="edit_user_uid" value="${hrstaffCase.user_bh}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">性别： </label>
						<div class="col-sm-8">
						<input type="text"
								class="col-xs-6 col-sm-6 ztb_edit_sex "
								name="sex" id="edit_sex" value="${hrstaffCase.sex}" />
							<div class="input-group  col-xs-6 col-sm-6 fullAreaCode">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">生日： </label>
						<div class="col-sm-8">
							<input type="text"
								class="form-control date-picker  ztb_add validate[maxSize[50]]"
								name="borndate" id="id-date-picker-1"
								data-date-format="yyyy-mm-dd" readonly /> <span
								class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">民族： </label>
						<div class="col-sm-8">
							<input type="hidden" name="staffNational"> <select
								name="staffNational"
								class="col-xs-6 col-sm-6 validate[maxSize[20]]"
								id="btn_staffNational">
								<option value="">请选择</option>
								<c:forEach var="mz" items="${minzuList}">
									<option value="${mz.dicTypeID }">${mz.dicTypeName }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">籍贯： </label>
						<div class="col-sm-8">
							<select name="staffBirthplace"
								class="col-xs-6 col-sm-6 validate[maxSize[50]]"
								id="btn_staffBirthplacel">
								<option value="">请选择</option>
								<c:forEach var="cs" items="${BirthpalceList}">
									<option value="${cs.dicTypeID }">${cs.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">身份证号： </label>
						<div class="col-sm-8">
							<input type="text"
								class="col-xs-6 col-sm-6 ztb_edit_staffDocuments validate[maxSize[50]]"
								name="staffDocuments" id="staffDocuments"
								value="${hrstaffCase.staffDocuments}" />
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">政治面貌： </label>
						<div class="col-sm-8">
							<select name="staffPolitical"
								class="col-xs-6 col-sm-6 validate[maxSize[50]]"
								id="btn_staffPolitical">
								<option value="">请选择</option>
								<c:forEach var="zz" items="${ZhengzhiList}">
									<option value="${zz.dicTypeID }">${zz.dicTypeName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">婚姻状况： </label>
						<div class="col-sm-8">
							<select name="staffMarriage"
								class="col-xs-6 col-sm-6 validate[maxSize[50]]"
								id="btn_staffMarriage">
								<option value="">请选择</option>
								<c:forEach var="hy" items="${MarriageList}">
									<option value="${hy.dicTypeID }">${hy.dicTypeName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">员工类型： </label>
						<div class="col-sm-8">
							<select name="staffTitle"
								class="col-xs-6 col-sm-6 validate[maxSize[50]]"
								id="btn_staffTitle">
								<option value="">请选择</option>
								<c:forEach var="yg" items="${ygList}">
									<option value="${yg.dicTypeID }">${yg.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">学历： </label>
						<div class="col-sm-8">
							<select name="staffEducation"
								class="col-xs-6 col-sm-6 validate[maxSize[50]]"
								id="btn_staffEducation">
								<option value="">请选择</option>
								<c:forEach var="xl" items="${EducationList}">
									<option value="${xl.dicTypeID }">${xl.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">职称： </label>
						<div class="col-sm-8">
							<input type="text"
								class="col-xs-6 col-sm-6 ztb_edit_staffTitle "
								name="staffTitle" id="edit_staffTitle"
								value="${hrstaffCase.staffTitle}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">年龄段： </label>
						<div class="col-sm-8">
							<input type="text" class="col-xs-6 col-sm-6 ztb_edit_ "
								name="" id="" value="" />
							<p class="col-sm-1">-</p>
							<input type="text" class="col-xs-6 col-sm-6 ztb_edit_ " name=""
								id="" value="" /> <span
								style="line-height: 28px; margin-left: 1em;"> </span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">出生日期： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="borndate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>

							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="borndate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">劳动合同到期： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="staffStartContractDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>

							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="staffEndContractDate" id="id-date-picker-2"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">转正日期： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="staffRegularizedDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>

							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="staffRegularizedDate" id="id-date-picker-2"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">已休年假： </label>
						<div class="col-sm-8">
							<input type="text"
								class="col-xs-6 col-sm-6 ztb_edit_staffYearHoliday validate[30]"
								name="staffYearHoliday" id="edit_staffYearHoliday"
								value="${hrstaffCase.staffYearHoliday}" /> <span
								style="line-height: 28px; margin-left: 1em;"> </span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input">加入本单位时间： </label>
						<div class="col-sm-8">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="joinWorkDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>

							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">
								<input type="text"
									class="form-control date-picker  ztb_add validate[custom[date]]"
									name="joinWorkDate" id="id-date-picker-2"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">毕业院校： </label>
						<div class="col-sm-8">
							<input type="text" class=" col-xs-6 col-sm-6 ztb_add"
								name="staffGraduateInstitutions" id="staffGraduateInstitutions"
								value="${hrstaffCase.staffGraduateInstitutions}" />
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-search bigger-110'></i>查询
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
