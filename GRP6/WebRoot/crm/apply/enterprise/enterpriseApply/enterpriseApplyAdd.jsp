<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addEnterpriseApply" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">企业咨询业务登记</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_enterpriseApply_form">
      	 	<input type="hidden" name="clientType" value="01">
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>企业名称： </label>
				<div class="col-sm-10">
					<input type="text" name="clientName" class="col-sm-10 validate[required,maxSize[50]]" id="add_clientName"/>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>联系人： </label>
				<div class="col-sm-8">
				    <div class="row">
				    <div class="col-sm-10">
						<input type="text" name="contact" class="col-sm-12 validate[required,maxSize[10]]">
					</div>
		        </div>
		    </div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>手机： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control validate[required,maxSize[11],minSize[11]]" type="text" name="phone"/>
								<span class="input-group-addon">
									<i class="icon-phone bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">固定电话： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control validate[maxSize[50]]" type="text" name="telephone"/>
								<span class="input-group-addon">
									<i class="icon-phone bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectBusSort">
								<input  type="text"  class="form-control validate[required] " autoField="busiTypeID"  id="selectBusSort"  name="busiTypeName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">合作机构：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectBank">
								<input  type="text"  class="form-control" autoField="cooperationID"   id="selectBank"  name="cooperationName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>申请金额： </label>
				<div class="col-sm-8">
					<input type="text" name="applySum" class="col-xs-10 col-sm-6 validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>申请期限：</label>
				<div class="col-sm-8">
					<span class="col-sm-10 no-padding-left">
						<input type="text" name="periodMonth" class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;"/>&nbsp;个月&nbsp;
						<input type="text" name="periodDay"  class="validate[maxSize[5],custom[integer]]" style="width: 70px;" value="0"/>&nbsp;天
					</span>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户来源：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
			        		<input type="hidden" id="clientSourceName" name="clientSourceName" class="ztb_add_clientSourceName">
							<select class="col-sm-12 select_clientSource  btn_ztb_select validate[required]"  name="clientSourceID" class_name="ztb_add_clientSourceName" id="select_clientSource"></select>
						</div>	
					</div>
				</div>
			</div>
			<!-- <div class="form-group  col-sm-6  hidden-xs" style="height:29px"></div> -->
			<div class="form-group  col-sm-6">
				<label class="col-sm-offset-2 col-sm-10 grey">（注：申请期限为整月时，天可以不填写）</label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">来源说明： </label>
				<div class="col-sm-10">
					<textarea rows="3" name="clientSourceDesc" class="col-sm-10 validate[maxSize[50]]"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制50个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">贷款用途： </label>
				<div class="col-sm-10">
					<textarea rows="5" name="loadUsed" class="col-sm-10 validate[maxSize[2000]]"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">还款计划与来源： </label>
				<div class="col-sm-10">
					<textarea rows="5" name="repaymentPlan" class="col-sm-10 validate[maxSize[2000]]"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">拟提供的&nbsp;&nbsp;&nbsp;&nbsp;<br/>保证措施： </label>
				<div class="col-sm-10">
					<textarea rows="5" name="provideGuaranty" class="col-sm-10 validate[maxSize[2000]]"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>接待部门：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectReception">
								<input  type="text"  class="form-control validate[required] " autoField="receiveDeapartID"   id="selectReception"  
									value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="receiveDeapartName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>接待人：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectReceptionist">
								<input  type="text"  class="form-control validate[required] " autoField="receiveUserID"   id="selectReceptionist"  
									value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="receiveUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>接待日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="receiveDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			<div class="form-group col-sm-12 col-xs-12" style="height:80px"></div>
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
<!--       		<span class="title2 hide">还可以输入<sp	an>140</span>字</span>
			<textarea name="text" id="textarea" cols="30" rows="10" oninput="font_siz()"></textarea> 
      <script type="text/javascript">
      	$("#textarea").focusin(function () {
			$(".title").addClass("hide");
			$(".title2").removeClass("hide")
		});
		$("#textarea").focusout(function() {
			$(".title").removeClass("hide");
			$(".title2").addClass("hide")
		});
		function font_siz() {
			var num = $("#textarea").val().length;
			if(num<140){
				 $(".title2").html('还可以输入'+ '<span></span>' + '字');
				var all = $(".title2 span").text();
				$(".title2 span").text(140-num);
			}else{
				 $(".title2").html('已超出'+ '<span>0</span>' + '字');
				var all = $(".title2 span").text();
				$(".title2 span").text(Math.abs(140-num));
			}		 
		}
      </script> -->
    </div>
  </div>
</div>
<!-- <script type="text/javascript">
	$(document).ready(function(){
	    $("#addEnterpriseApply").draggable();//为模态对话框添加拖拽
	});
</script> -->
					