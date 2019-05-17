<%@ include file="/common_timestamp.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectReplaceEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <!-- 代偿信息修改页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改代偿信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectReplaceEdit_form" >
			        	 <input type="hidden" id="apply_ID" name="apply_ID" value="${replace.apply_ID}">
					     <input type="hidden" id="project_ID" name="project_ID" value="${replace.project_ID}">
					     <input type="hidden" id="replace_ID" name="replace_ID" value="${replace.replace_ID}">
           	<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>代偿金额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[required,maxSize[18],custom[number]]"   name="replaceSum"	 id="replaceSum"
					 value="<fmt:formatNumber value="${replace.replaceSum}" pattern="###.######"/>" />
						<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>确认代偿还款： </label>
				<div class="col-sm-8">
					<select id = "isUseRepay" name = "isUseRepay" class="col-sm-8 validate[required] selectList">
						<option value="">请选择</option>
						<option value="0" <c:if test="${replace.isUseRepay == 0}">selected='selected'</c:if> >强制代偿</option>
						<option value="1" <c:if test="${replace.isUseRepay == 1}">selected='selected'</c:if>>代偿还款</option> 
					</select>
				</div>
			</div>
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>上报日期： </label>
		         	<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="replaceDate"	 
									id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${replace.replaceDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	            </div>
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>代偿日期： </label>
				<div class="col-sm-8">
					<div class="row">
							<div class="col-sm-12">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="replaceFactDate"	 
									id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${replace.replaceFactDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>
	            
	            
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">其中： </label>
				<div class="col-sm-8">
				</div>
			</div>
			<div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>	
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">代偿本金： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="replaceCapitalSum"	 id="replaceCapitalSum" 
					value="<fmt:formatNumber value="${replace.replaceCapitalSum}" pattern="###.######"/>" />
						<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">准备金冲抵： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="dangerReplaceSum"	 id="dangerReplaceSum"  
					value="<fmt:formatNumber value="${replace.dangerReplaceSum}" pattern="###.######"/>"  />
						<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">代偿利息： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="replaceInterestSum"	 id="replaceInterestSum"  
					value="<fmt:formatNumber value="${replace.replaceInterestSum}" pattern="###.######"/>"  />
						<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">自有资金代偿： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="selfReplaceSum"	 id="selfReplaceSum"  
					value="<fmt:formatNumber value="${replace.selfReplaceSum}" pattern="###.######"/>"  />
						<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">代偿其他： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8   validate[maxSize[18],custom[number]]"   name="replaceOtherSum"	 id="replaceOtherSum"  
					value="<fmt:formatNumber value="${replace.replaceOtherSum}" pattern="###.######"/>" />
						<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" for="form-input">备注： </label>
				<textarea class="col-sm-10 col-sm-offset-1 validate[maxSize[2000]]" rows="8" cols="80" name="remark" id="remark" >${replace.remark}</textarea>
			</div>
			<div class="form-group"></div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					