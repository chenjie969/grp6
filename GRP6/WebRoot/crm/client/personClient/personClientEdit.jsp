<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><div class="modal fade bs-example-modal-sm" id="editPersonClientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改申请人基本信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal row" role="form" id="edit_personClientForm">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID ztb_edit" value="" />
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>客户编号： </label>
				<div class="col-sm-10">
					<input  type="text" class="col-sm-4 ztb_edit_clientBH validate[required,maxSize[10]]"  name="clientBH" id="edit_clientBH" value="" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>申请人姓名： </label>
				<div class="col-sm-8">
					<input type="text" name="personName" id="edit_personName"  class="col-sm-12 ztb_edit_personName ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>身份证号码： </label>
				<div class="col-sm-8">
					<input type="text" name="personNum" id="edit_personNum"  class="col-sm-10 ztb_edit_personNum ztb_edit validate[required,minSize[18],maxSize[18]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>性别： </label>
				<div class="col-sm-8">
					<div class="radio" id="sex" >
						<label>
							<input  name="sex"  type="radio" class="ace" value="男" checked/>
							<span class="lbl">男</span>
						</label>
					   <label>
							<input  name="sex"  type="radio" class="ace" value="女"/>
							<span class="lbl">女</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
   				<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>	
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">婚姻状况： </label>
				<div class="col-sm-8">
					<select class="col-sm-8 col-md-4 ztb_edit_maritalStatus ztb_edit" select="true"  name="maritalStatus" id="edit_maritalStatus" readonly="readonly">
						<option value="未婚">未婚</option>
						<option value="已婚">已婚</option>
						<option value="离异">离异</option>
					</select>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">年龄： </label>
				<div class="col-sm-8">
					<input type="text" name="age" id="edit_age"  class="col-sm-8 col-md-4 ztb_edit_age ztb_edit validate[custom[number],maxSize[6]]"/>
					<span class="midden col-sm-4 " style="line-height:28px;">岁</span>
				</div>
			</div> 
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">户口所在地： </label>
				<div class="col-sm-8">
					<input type="text" name="domicile" id="edit_domicile"  class="col-sm-12 ztb_edit_domicile ztb_edit validate[maxSize[25]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">家庭人数： </label>
				<div class="col-sm-8">
					<input type="text" name="familyNum" id="edit_familyNum"  class="col-sm-4 ztb_edit_familyNum ztb_edit validate[custom[number],maxSize[6]]" />
					<span class="midden col-sm-8" style="line-height:28px;">人</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">就业人数： </label>
				<div class="col-sm-8">
					<input type="text" name="workNum" id="edit_workNum"  class="col-sm-4 ztb_edit_workNum ztb_edit validate[custom[number],maxSize[6]]" />
					<span class="midden col-sm-8" style="line-height:28px;">人</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
   				<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-input">家庭收入主要来源：</label>
				<div class="col-sm-10">
					<textarea class="col-sm-10 limited ztb_edit ztb_edit_incomeSource validate[maxSize[250]]"  name="incomeSource"	 id="edit_incomeSource"></textarea>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">教育程度：</label>
				<div class="col-sm-8">
					<input type="hidden" name="education" id="education"  class="ztb_edit_education"/>
					<select class="col-sm-10 col-md-7  ztb_edit_education select_education  btn_ztb_select"  class_name="ztb_edit_education" id="select_education" readonly="readonly">
					</select>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">职位： </label>
				<div class="col-sm-8">
					<input type="text" name="position" id="edit_position"  class="col-sm-12 col-md-6 ztb_edit_position ztb_edit validate[maxSize[50]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">工作单位： </label>
				<div class="col-sm-8">
					<input type="text" name="workUnit" id="edit_workUnit"  class="col-sm-12 ztb_edit_workUnit ztb_edit validate[maxSize[50]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">单位邮编： </label>
				<div class="col-sm-8">
					<input type="text" name="unitPost" id="edit_unitPost"  class="col-sm-12 col-md-6 ztb_edit_unitPost ztb_edit validate[maxSize[25]]" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-input">单位地址： </label>
				<div class="col-sm-10">
					<textarea class="col-sm-10 limited ztb_edit ztb_edit_unitAddress validate[maxSize[50]]"  name="unitAddress"	 id="edit_unitAddress" ></textarea>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">税后收入： </label>
				<div class="col-sm-8">
					<input type="text" name="monthIncome" id="edit_monthIncome"  class="col-sm-8 col-md-4 ztb_edit_monthIncome ztb_edit validate[custom[number],maxSize[10]]" />
					<span class="midden col-md-2 col-sm-4" style="line-height:28px;">元</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">单位电话： </label>
				<div class="col-sm-8">
					<input type="text" name="unitPhone" id="edit_unitPhone "  class="col-sm-12 col-md-6 ztb_edit_unitPhone ztb_edit validate[maxSize[25]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">现住房性质： </label>
				<div class="col-sm-8">
					<input type="hidden" name="houseNature" id="houseNature"  class="ztb_edit_houseNature"/>
					<select class="col-sm-10  ztb_edit_houseNature select_house btn_ztb_select"  class_name="ztb_edit_houseNature" id="select_house" readonly="readonly">
					</select>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">住房面积： </label>
				<div class="col-sm-8">
					<input type="text" name="houseArea" id="edit_houseArea"  class="col-sm-6 col-md-4 ztb_edit_houseArea ztb_edit validate[custom[number],maxSize[50]]" />
					<span class="midden col-md-2 col-sm-4" style="line-height:28px;">㎡</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">住址邮编： </label>
				<div class="col-sm-8">
					<input type="text" name="housePost" id="edit_housePost"  class="col-sm-8 col-md-4 ztb_edit_housePost ztb_edit validate[custom[number],maxSize[6]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">手机号： </label>
				<div class="col-sm-8">
					<input type="text" name="phone" id="edit_phone"  class="col-sm-10 ztb_edit_phone ztb_edit validate[custom[number],maxSize[20]]" />
				</div>
			</div>
			<!-- <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">现住房性质： </label>
				<div class="col-sm-8">
					<input type="hidden" name="houseNature" id="houseNature"  class="ztb_edit_houseNature"/>
					<select class="col-sm-10  ztb_edit_houseNature select_house btn_ztb_select"  class_name="ztb_edit_houseNature" id="select_house" readonly="readonly">
					</select>
				</div>
			</div> -->
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">住宅电话： </label>
				<div class="col-sm-8">
					<input type="text" name="houseTel" id="edit_houseTel"  class="col-sm-12 col-md-7 ztb_edit_houseTel ztb_edit validate[custom[number],maxSize[10]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
   				<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
            </div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-input">现住地址： </label>
				<div class="col-sm-10">
					<textarea class="col-sm-10 limited ztb_edit ztb_edit_houseAddress validate[maxSize[50]]"  name="houseAddress"	 id="edit_houseAddress" ></textarea>
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

 
<script type="text/javascript">
$("#edit_personNum").blur(function(){  // 失去焦点  
	var persoNum = $('#edit_personNum').val();
	 if(persoNum=='' || persoNum.length != 18){
	 	return false;
	 }else{
		 var date = new Date();
		 var year = date.getFullYear(); 
		 var birthday_year = parseInt(persoNum.substr(6,4));
		 var userage= year - birthday_year;
		 $('#edit_age').val(userage); 
		 return false;
	}
})
</script>
