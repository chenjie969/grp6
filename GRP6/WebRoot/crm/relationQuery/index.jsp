<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%--关联查询 --%>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
           <form class="form-horizontal col-sm-7" role="form" style="margin-top:50px;" id="queryClientFrom">
           		<div class="form-group">
                     <label class="col-sm-2 control-label no-padding-right" for="form-input">查询类型：</label>
                     <div class="col-sm-10">
                        <select class="col-sm-6" name="queryType">
                        	<option value="01">名称</option>
                        	<option value="02">证件号码</option>
                        	<option value="03">手机号码（固话）</option>
						</select>
                     </div>
              	</div>
              	<div class="form-group">
                     <label class="col-sm-2 control-label no-padding-right" for="form-input">查询内容：</label>
                     <div class="col-sm-10">
                         <input  type="text" class="col-sm-6 validate[required]" name="queryContent" id="queryContent" value="" />
                     </div>
              	</div>
              	<div class="space-10"></div>
              	<div class="clearfix form-actions">
                     <div class="col-sm-8 col-sm-offset-4" >
                         <button class="btn btn-primary btn-query" type="button">
                    		<i class="icon-search bigger-110"></i>查询</button>
                     </div>
              	</div>
            </form>
            <div class="col-sm-5" style="margin-top:50px;border:1px solid rgba(122,179,240,0.3);background:rgba(122,179,240,0.1);padding-bottom:5px;">
                <h5 class="text-danger">说明：</h5>
                <span style="line-height:20px;font-size:12px;" class="grey">
                    1.&nbsp;&nbsp;通过名称查询企业客户名称（关联企业、反担保企业）、法定代表人名称、实际控制人名称、高级管理人员名称、保证人名称、个人客户名称和配偶名称。<br/>
                    2.&nbsp;&nbsp;通过证件号码查询企业信用代码证、法定代表人身份证号、实际控制人身份证号、高级管理人员身份证号、个人客户身份证号和配偶身份证号。<br/>
                    3.&nbsp;&nbsp;通过手机号码（固话）查询个人客户电话、配偶电话和保证人电话。<br/>
                    4.&nbsp;&nbsp;重复客户只显示一条。
                </span>
       		</div>
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<div class="tabbable" id="table" style="display:none">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#company" id="companyTab">
								企业<!-- &nbsp;&nbsp;<span class="badge badge-danger">30</span> -->
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#person" id="personTab">
								个人<!-- &nbsp;&nbsp;<span class="badge badge-danger">20</span> -->
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="company" class="tab-pane in active">
							<div class="row" style="display:block">
								<div class="col-xs-12">
									<div class="table-responsive"  id="loadCompanyInfo">
										<table id="companyClient-table" style="font-size:13px !important;"></table> 
									</div>
								</div>
							</div>
						</div>
						<div id="person" class="tab-pane">
							<div class="row" style="display:block">
								<div class="col-xs-12">
									<div class="table-responsive"  id="loadPersonInfo">
										<table id="personClient-table" style="font-size:13px !important;"></table> 
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
	
</div><!-- /.page-content -->

<%@ include file="/common_foot.jsp" %>
		<script src="<%=path %>/crm/relationQuery/index.js?v=<%=vardate%>"></script>
	
	
	