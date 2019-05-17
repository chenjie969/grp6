<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="modal fade bs-example-modal-sm" id="add_meetingReso" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel" align="center">评审会决议</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="updateBasicInfo_Form">
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">客户名称： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12" name="staffDocuments" id="staffDocuments" placeholder="客户名称"/>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" style="line-height: 28px;">&nbsp;</label>
					</div>
					
					
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">放款机构： </label>
						<div class="col-sm-8">
						
							<input type="text" class="col-sm-12 " name="user_name" id="user_name" placeholder="放款机构"/>
						</div>
					</div>
					
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">业务品种： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-12" name="user_bh"  id="edit_user_uid" placeholder="业务品种"/>
						</div>
					</div>
					
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">担保金额： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-10"  name="user_name" id="user_name" placeholder="担保金额"/>
								<span class="light-grey pull-right" >万元</span>
						</div>
					</div>
					
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">担保期限： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-10" name="user_bh"  id="edit_user_uid" placeholder="担保期限"/>
								<span class="light-grey pull-right" >个月</span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">担保年费率： </label>
						<div class="col-sm-8">
						
							<input type="text" class="col-sm-10 "  name="user_name" id="user_name" placeholder="担保年费率"/>
								<span class="light-grey pull-right" >%</span>
						</div>
					</div>
					
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">履约保证金比例： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-10" name="user_bh" id="edit_user_uid" placeholder="履约保证金比例"/>
								<span class="light-grey pull-right" >%</span>
						</div>
					</div>
					
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">评审费率： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-10" name="staffDocuments" id="staffDocuments" placeholder="评审费率"/>
								<span class="light-grey pull-right" >‰</span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" style="line-height: 28px;">&nbsp;</label>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">参会委员：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="参会委员"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制100个字符</span>
							</div> -->
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">外部专家：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="外部专家"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制100个字符</span>
							</div> -->
						</div>
					</div>
					
					<!-- <div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-input">会员投票结果： </label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-4" name="staffDocuments" placeholder="会员投票结果"/>
								反对<input type="text" class="col-sm-3" name="staffDocuments" placeholder="参会会员投票结果"/>票
								再议<input type="text" class="col-sm-3" name="staffDocuments" placeholder="参会会员投票结果"/>票
								<span class="light-grey pull-right" >同意_票，反对_票，再议_票</span>
						</div>
					</div> -->
					<!-- <div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" style="line-height: 28px;">&nbsp;</label>
					</div> -->
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">会员投票结果：</label>
						<div class="col-sm-10">
							<input type="text" class="col-sm-8" name="staffDocuments" placeholder="会员投票结果"/>
							<div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >同意_票，反对_票，再议_票</span>
							</div>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">反担保措施：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="反担保措施"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制500个字符</span>
							</div> -->
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">业务部门意见：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="业务部门意见"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制100个字符</span>
							</div> -->
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">风险部门意见：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="风险部门意见"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制100个字符</span>
							</div> -->
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">总经理意见：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="总经理意见"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制100个字符</span>
							</div> -->
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" for="form-input">董事长（或授权人）意见：</label>
						<div class="col-sm-10">
							<textarea class="col-sm-8 limited" rows="4" name="" id="" placeholder="董事长（或授权人）意见"></textarea>
							<!-- <div class="col-sm-8 no-padding-right">
								<span class="light-grey pull-right" >限制100个字符</span>
							</div> -->
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
