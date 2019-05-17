<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.table_refundInfo{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	.table_refundInfo tr th,.table_refundInfo tr td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	};
</style>
<div class="modal fade" id="refundAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">新增退费</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="form_addMustCost">
					
					<div class="space-4"></div>
					<div class="form-group">
						<h5 class="col-sm-offset-1 col-sm-10 header lighter">
							退费信息
							<button type="button" class="btn btn-minier btn-warning pull-right" id="btn_addMustChargeInfo">
								<i class="icon-edit bigger-110"></i>
								<span class="bigger-110 no-text-shadow">添加</span>
							</button>
						</h5>
						<div class="col-sm-offset-1 col-sm-10">
							<table class="table table-hover table-striped table_refundInfo">
					 			<thead>
									<tr>
										<th><i class="icon-asterisk orange"></i>费用类别</th>
										<th>原收费金额（元） </th>
										<th><i class="icon-asterisk orange"></i>退费金额（元）</th>
										<th>退费后金额（元） </th>
										<th style="width:80px">操作</th>
									</tr>
								</thead>
								<tbody>
									<!-- <tr>	
										<td style="border:1px solid #ddd;">		
											<select class="validate[required] col-sm-12">		
												<option value="">&nbsp;请选择</option>
												<option value="">预收评审费</option>
												<option value="">评审费</option>
												<option value="">担保费</option>
												<option value="">保证金</option>
												<option value="">其他费用</option>
									 		</select>
										</td>	
										<td style="border:1px solid #ddd;">		
											<input type="text" style="width:80%;" class="tdinput">	%
										</td>	
										<td style="border:1px solid #ddd;">		
											<input type="text" style="width:80%;" class="tdinput">	
										</td>
										<td style="border:1px solid #ddd;">	    
											<button type="button" class="btn btn-xs btn-danger delBusiTableRow">	        
												<i class="icon-trash bigger-120"></i>	    
											</button>	
										</td>
									</tr> -->
								</tbody>	
							</table>
						</div>
					</div>
					
					<div class="space-4"></div>
					<div class="form-group">
			   	    	<label class="col-sm-2 control-label no-padding-right" for="form-input">备注： </label>
						<div class="col-sm-9">
						    <textarea class="col-sm-12  limited validate[maxSize[250]]"  rows="5" name="sourceDesc"></textarea>
						</div>
						<div class="col-sm-11 ">
						    <span class="light-grey" style="float:right;">限制250个字符</span>
						</div>
					</div>
					
					<div class="space-4"></div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办部门： </label>
						<div class="col-sm-8">
							<div class="row">
								<div class=" col-sm-12 ">
									<div class="input-group createDepart">
										<input  type="text"  class="form-control validate[required] " autoField="departID"   id="createDepart"  value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="departName"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="space-4"></div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办人： </label>
						<div class="col-sm-8">
							<div class="row">
								<div class=" col-sm-12 ">
									<div class="input-group createUser">
										<input  type="text"  class="form-control validate[required] " autoField="amanID"   id="createUser"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="amanName"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="space-4"></div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>登记日期： </label>
						<div class="col-sm-8">
							<div class="row">
								<div class="col-sm-12">
									<div class="input-group">
										<input  type="text" class="form-control date-picker validate[required,custom[date]]" name="createDateTime"  id="createDate" data-date-format="yyyy-mm-dd" />
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-primary" data-dismiss="modal"> <i class='icon-ok bigger-110'></i>保存</button>
				<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
			</div>
		</div>
	</div>
</div>
<%@ include file="/common_timestamp.jsp" %>
<script src="<%=path %>/project/finance/projectCost/refundAdd.js?v=<%=vardate%>"></script>	
	