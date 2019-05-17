<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="addtransferModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">添加岗位变动记录</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="addtransfer_Form">
				 <input type="hidden" id="staffcase_Id" name="staffcase_Id" value="${hrstaffPosts.staffcase_Id}"/>
							<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>调动原因：</label>
						<div class="col-sm-9">

							<textarea class="col-sm-10 limited  ztb_edit_postsReason validate[required,maxSize[50]]" rows="5" name="postsReason" id="edit_postsReason" >${hrstaffPosts.postsReason}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制50个字符</span>
							</div>
							
						</div>
					</div>
			<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">变动前部门： </label>
						<div class="col-sm-9">
							<div class="col-md-6 col-sm-6 input-group allDepartsTree1">
								<input type="text" class="form-control " autoField="agoPostsDep" id="allDepartsTree1" value="${hrstaffPosts.agoPostsDep}"
									dataValue="${hrstaffPosts.agoPostsDep}" name="departName1"  /> <span class="input-group-addon "> <i
									class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">变动后部门： </label>
						<div class="col-sm-9">
							<div class="col-md-6 col-sm-6 input-group allDepartsTree2">
								<input type="text" class="form-control" autoField="nowPostsDep" id="allDepartsTree2" value="${hrstaffPosts.nowPostsDep}" name="departName2"
									/> <span class="input-group-addon "> <i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>变动前职位: </label>
						<div class="col-sm-9">
							<input type="text" name="agoPosts" id="agoPosts" class="col-sm-10 ztb_add validate[required]" value="${hrstaffPosts.agoPosts}" >
						</div>
					</div>	
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>变动后职位:</label>
						<div class="col-sm-9">
							<input type="text" name="nowPosts" id="nowPosts" class=" col-sm-10 ztb_add validate[required]" value="${hrstaffPosts.nowPosts}" /> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">变动前薪金:</label>
						<div class="col-sm-9">
							<input type="text" name="agoSalary" id="agoSalary" class="col-sm-4 ztb_add validate[custom[number],maxSize[50]]" value="${hrstaffPosts.agoSalary}" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">变动后薪金:</label>
						<div class="col-sm-9">
							<input type="text" name="nowSalary" id="nowSalary" class=" col-sm-4 ztb_add validate[custom[number],maxSize[50]]" value="${hrstaffPosts.nowSalary}"/> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">变动日期: </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-10" style="float: left;">
								<input type="text" class="form-control date-picker  validate[custom[date]]" name="changePostsDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" value="${hrstaffPosts.changePostsDate}" /> 
							<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
	
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
