<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="updateEduModal"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改教育背景</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="updateEduBack_Form">
					<input type="hidden" id="educationID" name="educationID"
						value="${hrstaffEdu.educationID}" />
								<div class="form-group">					
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>起止年月： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">									
								<input class="form-control date-pickeryear validate[required] "   name="educationStartDate"  id="educationStartDate" type="text" 
							 data-date-format="yyyy-mm"	value="${hrstaffEdu.educationStartDate}"
								 readonly/>
                <span class="input-group-addon">
                    <i class="icon-calendar bigger-110"></i>
                </span>
								
							</div>
							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">							
							<input class="form-control date-pickeryear validate[required] "   name="educationEndDate"  id="educationEndDate"
							 type="text" data-date-format="yyyy-mm"	
							 value="${hrstaffEdu.educationEndDate}"
								 readonly/>
                <span class="input-group-addon">
                    <i class="icon-calendar bigger-110"></i>
                </span>	
							</div>
						</div>
					</div>		
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">学校： </label>
						<div class="col-sm-9">
							<input type="text" name="educationSchool" id="educationSchool"
								class=" col-sm-10 ztb_add validate[required,maxSize[50]]"
								value="${hrstaffEdu.educationSchool}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">地点： </label>
						<div class="col-sm-9">
							<input type="text" name="educationAddress" id="educationAddress"
								class="col-sm-10 ztb_add validate[required,maxSize[50]]"
								value="${hrstaffEdu.educationAddress}" />
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">学历： </label>
						<div class="col-sm-9">
							<select name="educationRecord"
								class="col-xs-6 col-sm-6 validate[maxSize[32]]"
								id="educationRecord" >
								<option value="">请选择</option>
								<c:forEach var="xl" items="${EducationMap}">
									<option value="${xl.key}" <c:if test="${xl.key eq  hrstaffEdu.educationRecord}">selected="selected"</c:if>>${xl.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
						<div class="col-sm-9">
							<textarea
								class="col-sm-10 limited  ztb_edit_busiScope validate[maxSize[2000]]"
								rows="5" name="educationNotes" id="edit_educationNotes">${hrstaffEdu.educationNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制250个字符</span>
							</div>
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
