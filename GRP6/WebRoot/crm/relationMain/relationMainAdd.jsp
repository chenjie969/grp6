<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div style="height:100px"></div>
                <div class="row">    
                     <form class="form-horizontal" role="form" id="addMainForm">
                     	<input type="hidden" name="relationMain_ID" id="relationMain_ID">		
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								<i class="icon-asterisk orange"></i>主体名称：
							</label>
							<div class="col-sm-4 col-xs-12">
								<input type="text" name="relationMainName" id="mainName"  class="col-xs-10 col-sm-8 validate[required,maxSize[50]]"/>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								<i class="icon-asterisk orange"></i>关系类型：
							</label>
							<div class="col-sm-4 col-xs-12">
								<select class="col-xs-10 col-sm-8 validate[required] relationTypeID" name="relationTypeID"></select>
							</div>
							<input type="hidden" id="relationTypeName" name="relationTypeName">
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								<i class="icon-asterisk orange"></i>主体客户：
							</label>
							<div class="col-sm-4 col-xs-12">
								<input type="text" name="clientName" id="clientName" class="col-sm-8 col-xs-10 validate[required]" readonly="readonly">
								<input type="hidden" name="clientID" id="clientID">
								<input type="hidden" name="clientGUID" id="clientGUID">
								<input type="hidden" id="beforeMainClientID">
								<div class="col-sm-4 buttonDiv">
									<button type="button" id="selectMain" class="btn btn-xs btn-info">从企业库中选择</button>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-2">关联企业： </label>
							<div class="col-sm-8">
								<select id="relationCompany" multiple="multiple"  class="col-sm-8 col-xs-10"></select>
								<div class="col-sm-4 buttonDiv">
									<button type="button" id="selectCompany" class="btn btn-xs btn-info">从企业库中选择</button>
									<br/><br/>	
									<button type="button" id="deleteCompany" class="btn btn-xs btn-info" style="width:100px">删除关联企业</button>
								</div>
							</div>
							<!-- 以下两个隐藏input向action传递关联企业的id和name -->
							<input type="hidden" name="clientIDs" id="clientIDs">	
							<input type="hidden" name="clientNames" id="clientNames">
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								2015 年1月末担保余额(亿元)：
							</label>
							<div class="col-sm-4 col-xs-12">
								<input type="text" name="guarantySum" id="guarantySum"  class="col-xs-10 col-sm-8 validate[custom[number],maxSize[50]]"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								2015年1月末担保集团委贷余额(亿元)：
							</label>
							<div class="col-sm-4 col-xs-12">
								<input type="text" name="guarantyEntrustSum" id="guarantyEntrustSum"  class="col-xs-10 col-sm-8 validate[custom[number],maxSize[50]]"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								2015年1月末融投系委贷余额(亿元)：
							</label>
							<div class="col-sm-4 col-xs-12">
								<input type="text" name="entrustSum" id="entrustSum"  class="col-xs-10 col-sm-8 validate[custom[number],maxSize[50]]"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								保外债权人融资金额(亿元)：
							</label>
							<div class="col-sm-4 col-xs-12">
								<input type="text" name="creditorSum" id="creditorSum"  class="col-xs-10 col-sm-8 validate[custom[number],maxSize[50]]"/>
							</div>
						</div> -->
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">
								项目类型名称：
							</label>
							<div class="col-sm-4 col-xs-12">
								<select class="col-xs-10 col-sm-8  projectTypeID" name="projectTypeID"></select>
							</div>
							<input type="hidden" id="projectTypeName" name="projectTypeName">
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-2">备注：</label>
							<div class="col-sm-8">
								<textarea class="col-sm-8 col-xs-10 autosize-transition ztb_edit_description validate[maxSize[250]]" name="remark" style="resize: vertical;height:200px;"></textarea>
								<div class="col-sm-8 col-xs-10 no-padding-right">
									<span class="light-grey" style="float:right">限制250个字符</span>
								</div>
							</div>
							<!-- <span class="col-xs-10 col-sm-6" id="view_remark"></span> -->
						</div>
					</form>
				 </div>
				<div class="clearfix form-actions">
                    <div class="col-sm-8 col-sm-offset-4" >
						<button type="button" name="button" class="btn btn-primary btn-submit buttonDiv" id="saveRelationMainAdd">
							<i class="icon-ok bigger-110"></i>保存
						</button>
						&nbsp;&nbsp;&nbsp;
						<button type="button" name="button" class="btn btn-default" id="closeRelationMainAdd">
							<i class="icon-remove bigger-110"></i>关闭
						</button>
                    </div>
                </div> 
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

	<%@ include file="/crm/relationMain/companyList.jsp" %>
		<%@ include file="/common_message.jsp" %>

	<script src="<%=path %>/crm/relationMain/relationMainAdd.js?v=<%=vardate%>"></script>
