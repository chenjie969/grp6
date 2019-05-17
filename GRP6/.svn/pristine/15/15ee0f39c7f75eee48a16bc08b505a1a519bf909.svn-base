<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="personApplyAdQuery" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">高级查询</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="personApply_advancedQuery_form">
      	 	<input type="hidden" name="clientType" value="01">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">申请人姓名： </label>
				<div class="col-sm-9">
					<div class="row">
					    <div class="col-sm-10">
							<input type="text" name="clientName" class="col-sm-12 validate[maxSize[50]]"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">身份证号码： </label>
				<div class="col-sm-9">
				    <div class="row">
					    <div class="col-sm-10">
							<input type="text" name="certificateCode" class="col-sm-12">
						</div>
			        </div>
		    	</div>
			</div>
			<!-- <div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">手机： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control validate[maxSize[50]]" type="text" name="phone"/>
								<span class="input-group-addon">
									<i class="icon-phone bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">固定电话： </label>
				<div class="col-sm-9">
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
			</div> -->
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">业务品种：</label>
				<div class="col-sm-9">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectBusSort">
								<input  type="text"  class="form-control  " autoField="busiTypeID"  id="selectBusSort"  name="busiTypeName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">申请金额： </label>
				<div class="col-sm-9">
					<input type="text" name="applySumLow" class="col-xs-10 col-sm-3 validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-1" style="line-height:28px;"> - </span>
					<input type="text" name="applySumHigh" class="col-xs-10 col-sm-3 validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-3" style="line-height:28px;">万元	</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">申请期限：</label>
				<div class="col-sm-9">
					<span class="col-sm-10 no-padding-left">
						<input type="text" name="periodMonthLow" class="col-sm-3 validate[maxSize[5],custom[integer]]" style="width: 70px;"/>
						<span class="midden col-sm-1" style="line-height:28px;"> - </span>
						<input type="text" name="periodMonthHigh"  class="col-sm-3 validate[maxSize[5],custom[integer]]" style="width: 70px;"/>
						<span class="midden col-sm-3" style="line-height:28px;">个月</span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">合作机构：</label>
				<div class="col-sm-9">
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
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">客户来源：</label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-10">
			        		<input type="hidden" id="clientSourceName" name="clientSourceName" class="ztb_add_clientSourceName">
							<select class="col-sm-12 select_clientSource  btn_ztb_select "  name="clientSourceID" class_name="ztb_add_clientSourceName" id="select_clientSource"></select>
						</div>	
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">接待部门：</label>
				<div class="col-sm-9">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectReception">
								<input  type="text"  class="form-control  " autoField="receiveDeapartID"   id="selectReception" name="receiveDeapartName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">接待人：</label>
				<div class="col-sm-9">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectReceptionist">
								<input  type="text"  class="form-control  " autoField="receiveUserID"   id="selectReceptionist" name="receiveUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input">接待日期： </label>
		        <div class="col-sm-9">
					<div class="row">
						<div class="col-sm-4 no-padding-right">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" name="receiveDateLow" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<span class="midden col-sm-1" style="line-height:28px;"> - </span>
						<div class="col-sm-4 no-padding-left">
							<div class="input-group">
								<input class="form-control date-picker validate[custom[date]]" type="text"  data-date-format="yyyy-mm-dd" name="receiveDateHigh" />
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
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-search bigger-110'></i>查询</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					