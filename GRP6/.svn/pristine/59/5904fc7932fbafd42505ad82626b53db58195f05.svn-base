<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content"><!--begin页面内容  -->
			<!-- PAGE CONTENT BEGINS -->
           <form class="form-horizontal" role="form" id="edit_clientRuleForm">
           	    <h3 class="header smaller lighter blue">
	               <div class="radio" >
	                   <label class="lighter blue">
	                       <input name="ruleType" type="radio" class="ace" value="01" id="autoBuild"
		                       <c:if test="${clientCode.ruleType  == '01' }">checked</c:if>
	                       /> 
	                       <span class="lbl "> 共同生成规则</span>
	                   </label>
	               </div>
	            </h3>

				<div class="space-8"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-input">&nbsp;</label>
					<div class="col-sm-10">
							<label>
								<input type="text" name="commonWord" class="autoBuild" 
								value="${clientCode.commonWord eq '' ? '字号': clientCode.commonWord}"
								onfocus="javascript:if(this.value=='字号')this.value='';" onblur="javascript:if(this.value=='')this.value='字号';"/>
								<span style="font-size:14px;">+4位序号</span>
							</label>
					</div>
				</div>
				<div class="space-8"></div>
				<h3 class="header smaller lighter blue">
	               <div class="radio">
	                   <label class="lighter blue">
	                       <input name="ruleType" type="radio" class="ace" value="02" id="eachBuild" 
	                       	<c:if test="${clientCode.ruleType  == '02' }">checked</c:if>
							/>
	                       <span class="lbl ">各自生成规则</span>
	                   </label>
	               </div>
	          	</h3>
				
				<div class="form-group" >
					<label class="col-sm-2 control-label no-padding-right" for="form-input">企业客户编号：</label>
					<div class="col-sm-10 ">
						<input type="text" name="companyWord" class="eachBuild" 
						value="${clientCode.companyWord  eq '' ? '字号': clientCode.companyWord}" 
						onfocus="javascript:if(this.value=='字号')this.value='';" onblur="javascript:if(this.value=='')this.value='字号';"/>
						<span style="font-size:14px;">
							+4位序号
						</span>
					</div>
				</div>
				<div class="space-8"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-input">个人（经营性）编号：</label>
					<div class="col-sm-10">
						<input type="text" name="operateWord" class="eachBuild"
						 value="${clientCode.operateWord eq '' ? '字号': clientCode.operateWord}" 
						onfocus="javascript:if(this.value=='字号')this.value='';" onblur="javascript:if(this.value=='')this.value='字号';"/>
						<span style="font-size:14px;">
							+4位序号
						</span>
					</div>
				</div>
				<div class="space-8"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-input">个人（消费性）编号：</label>
					<div class="col-sm-10">
						<input type="text" name="consumeWord" class="eachBuild" 
						value="${clientCode.consumeWord eq '' ? '字号': clientCode.consumeWord}"
						 onfocus="javascript:if(this.value=='字号')this.value='';" onblur="javascript:if(this.value=='')this.value='字号';"/>
						<span style="font-size:14px;">
							+4位序号
						</span>
					</div>
				</div>

				<div class="space-8"></div>
				<h3 class="header smaller lighter blue">
                    <div class="radio" >
                        <label class="lighter blue">
                            <input name="ruleType" type="radio" class="ace" value="03" id="handWork"
                            	<c:if test="${clientCode.ruleType  == '03' }">checked</c:if>
                            />
                            <span class="lbl ">手工录入</span>
                        </label>
                    </div>
                </h3>
                <div class="space-16"></div>
             <!--保存按纽 -->
             <div class="clearfix form-actions">
             	<div class="col-sm-9 col-sm-offset-4">
					<button class="btn btn-primary btn_submit" type="button">
						<i class="icon-ok bigger-110"></i>
						保存
					</button>
					&nbsp; &nbsp; &nbsp;
					<button class="btn" type="button" id="btn_closePage">
						<i class="icon-remove bigger-110"></i>
						关闭
					</button>
				</div>
             </div>
				
		    </form>
		</div><!-- /.col --><!--end 响应式列  -->

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_succeed.jsp" %>
<script src="<%=path %>/sys/parameter/clientCode.js?v=<%=vardate%>"></script>

<script type="text/javascript">
	$('input[name="ruleType"]').change( function(){
		$.zjm_clientRule.radioChange();
	});
	
</script>