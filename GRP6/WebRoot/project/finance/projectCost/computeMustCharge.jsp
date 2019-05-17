<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.table-selfmake{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed;
	}
	.table-selfmake tr th,.table-selfmake tr td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle !important;
	};
</style>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<h4 class="header smaller lighter blue col-sm-12">项目信息</h4>
			    <div class="row" style="margin:0;">
			         <h5 class="col-sm-4">项目编号：<span class="grey">XMBH00001</span></h5>
			         <h5 class="col-sm-4">项目名称：<span class="grey">A公司</span></h5>
			         <h5 class="col-sm-4">委托合同编号：<span class="grey">XMBH201707000001</span></h5>
			         <h5 class="col-sm-4">同意金额：<span class="grey">2,000.00万元</span></h5>
			         <input type="hidden" id="hidden_agreeSum" value="20000000"/>
			         <h5 class="col-sm-4">同意期限	：<span class="grey">13个月</span></h5>
			         <input type="hidden" id="hidden_agreeMonth" value="13"/>
			         <h5 class="col-sm-4">月利率：<span class="grey">0.5%（年利率：6%）</span></h5>
			         <h5 class="col-sm-4">担保范围：<span class="grey">100% 本金担保</span></h5>
			         <h5 class="col-sm-4">还款方式：<span class="grey">等额本息（按月） <a>查看还款计划</a></span></h5>
			    </div><br>
			    <div class="col-sm-11">
					<table class="table table-hover table-striped table-selfmake">
			 			<thead>
							<tr>
								<th><input type="checkbox" id="checkAllCompute"/></th>
								<th>费用类型</th>
								<th>费率（%）</th>
								<th>缴费次数</th>
							</tr>
						</thead>
						<tbody id="tbody_compute">
							<tr>
								<td><input type="checkbox" class="computeItem" rowIndex="1"/></td>
								<td>预收评审费<input type="hidden" id="hidden_costType1" value="预收评审费"/></td>
								<td>0.5<input type="hidden" id="hidden_rate1" value="0.005"/></td>
								<td><select class="select_payTimes" style="width:50px" id="select_payTimes1"></select>&nbsp;&nbsp;次</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="computeItem" rowIndex="2"/></td>
								<td>评审费<input type="hidden" id="hidden_costType2" value="评审费"/></td>
								<td>0.5<input type="hidden" id="hidden_rate2" value="0.005"/></td>
								<td><select class="select_payTimes" style="width:50px" id="select_payTimes2"></select>&nbsp;&nbsp;次</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="computeItem" rowIndex="3"/></td>
								<td>担保费<input type="hidden" id="hidden_costType3" value="担保费"/></td>
								<td>1.5<input type="hidden" id="hidden_rate3" value="0.015"/></td>
								<td><select class="select_payTimes" style="width:50px" id="select_payTimes3"></select>&nbsp;&nbsp;次</td>
							</tr>
						</tbody>	
					</table>
				</div>
				<div class="col-sm-12">
					<label class="col-sm-2 control-label no-padding-right align-right" for="firstPayDate">首次缴费日期： </label>
					<div class="col-sm-2">
						<div class="input-group">
							<input type="text" class="form-control date-picker validate[required,custom[date]]" name="createDateTime" id="firstPayDate" data-date-format="yyyy-mm-dd">
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-sm-6 align-center">
						<button type="button" class="btn btn-info btn-sm" id="btn_computePayment"> <i class="icon-ok bigger-110"></i>应收计算</button>&nbsp;&nbsp;
						<button type="button" class="btn btn-info btn-sm" id="btn_clearResult"> <i class="icon-repeat bigger-110"></i>重置</button>
					</div>
				</div>
				
			    <h4 class="header smaller lighter blue col-sm-12">输出结果</h4>
			    <div class="row" style="margin:0;">
			        <h5 class="col-sm-4">总支付利息：<b><span class="red" id="totalInterest">同意金额*同意期限*利率</span></b></h5>
			        <h5 class="col-sm-4">本息合计：<b><span class="red" id="principalPlusInterest">同意金额*同意期限*利率+同意金额</span></b></h5>
		        </div>
		        <h5 class="col-sm-4">应收费用信息如下：</h5>
				<div class="col-sm-11">
					<table class="table table-hover table-striped table-selfmake">
			 			<thead>
							<tr>
								<th><input type="checkbox" id="checkAllResult"/></th>
								<th>序号</th>
								<th>费用类型</th>
								<th>费率（%）</th>
								<th>缴费日期</th>
								<th>应收金额（元）</th>
							</tr>
						</thead>
						<tbody id="tbody_result">
							<tr class="msgTr">
								<td colspan="6">没有数据</td>
							</tr>
							<c:forEach begin="0" end="9" var="index"> 
								<tr id="tr${index }" style="display:none" class="dataTr">
									<td><input type="checkbox" class="resultItem"/></td>
									<td>${index+1 }</td>
									<td id="tr${index }td2"></td>
									<td id="tr${index }td3"></td>
									<td>
										<div class="input-group">
											<input type="text" id="payDate${index }" class="form-control date-picker validate[required,custom[date]]" name="createDateTime" data-date-format="yyyy-mm-dd">
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</td>
									<td><input type="text" id="paySum${index }" class="col-sm-12"/></td>
								</tr>
							</c:forEach>
						</tbody>	
					</table>
				</div>
				<div class="col-sm-12 align-center resultButton" style="display:none">
					<button type="button" class="btn btn-info btn-sm">生成缴费通知单</button>&nbsp;&nbsp;
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->
