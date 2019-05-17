<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="modal fade bs-example-modal-sm" id="addRewardPunishModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加奖惩记录</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="addRewardPunish_Form">	
		              
            	 <input type="hidden" id="staffcase_Id" name="staffcase_Id" value="${rewardPunishment.staffcase_Id}"/>
	         <div class="form-group ">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">类型： </label>
			        <div class="col-sm-9">
						<select class="col-sm-10  ztb_add select_rewardsType btn_ztb_select validate[required]"   name="rewardsType" class_name="ztb_edit_rewardsType" id="select_rewardsType">
						<option value="奖励">奖励</option>
						<option value="惩罚">惩罚</option>
						</select>
					</div>
	         </div>				
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>结果：</label>
						<div class="col-sm-9">
							<input type="text" name="rewardsResults" id="rewardsResults"  value="${rewardPunishment.rewardsResults}" class="col-sm-10 ztb_add validate[required,maxSize[50]]" />	
						</div>
					</div>  
					
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>事由：</label>
						<div class="col-sm-9">
							<input type="text" name="rewardsReason" id="rewardsReason" value="${rewardPunishment.rewardsReason}" class="col-sm-10 ztb_add validate[required,maxSize[50]]" />	
						</div>
					</div> 
						<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>日期： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">
										
								<input
									class="form-control date-picker validate[required,custom[date]]"
									id="rewardsDate" name="rewardsDate" type="text"
									value="${rewardPunishment.rewardsDate}" data-date-format="yyyy-mm-dd"/>
									<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
							<div class="col-sm-9">
							<textarea class="col-sm-10 limited  ztb_edit_rewardsNotes validate[maxSize[250]]" rows="5" name="rewardsNotes" id="edit_rewardsNotes">${rewardPunishment.rewardsNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制输入字数250个</span>
							</div>
					</div>
					</div>               
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
