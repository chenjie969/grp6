<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});

$('.date-picker').attr("value",tool.parseDate(new Date().getTime()));//设置默认日期为当前日期

</script>
<div class="page-content">   
      <!--  <input type="hidden" id="singleAppleAddPage" class="pageType" name="singleAppleAddPage" value="0">
     
       -->
     
      <div class="row">
		<div class="col-xs-12">

		
		<form class="form-horizontal" role="form" id="applyAdd_form0">
         
          <input type="hidden" id="projectType0" class="" name="projectType" value="单笔"><!--是否单笔业务  -->
          <input type="hidden" id="rowNum0" class="" name="rowNum" value="1" >	 <!--计算添加按钮点击次数即:行数 -->		 			
   		  <input type="hidden" id="busiDetails0" class="" name="busiDetails" >	 <!-- 获取申请明细详情冗余字段 -->		 			
          <input type="hidden" id="departName0" name="departName" >	 <!--经办机构名称 -->		 			
	      <input type="hidden" id="departID0" name="departID" >	 <!--经办机构id -->		 			
	      <input type="hidden" id="createManName0" name="createManName" >	 <!--经办人 -->		 			
	      <input type="hidden" id="createManID0" name="createManID" >	 <!--经办人id -->	
	      <input type="hidden" id="amanName0" name="amanName" >	 <!--A角 -->		 			
	      <input type="hidden" id="amanID0" name="amanID" >	 <!--A角id -->	
	      <input type="hidden" id="bmanName0" name="bmanName" >	 <!--B角 -->		 			
	      <input type="hidden" id="bmanID0" name="bmanID" >	 <!--B角id -->	
          <input type="hidden" id="projectStageID0" name="projectStageID" >	 <!--项目阶段id -->		 			
    	  <input type="hidden" id="projectStageName0" name="projectStageName" >	 <!--项目阶段名称 -->
    	  <input type="hidden" id="clientGUID0" name="clientGUID"/><!-- 客户唯一标示 -->		 			
		
         
         
         <div class="space-4"></div>
         <div class="form-group">
			<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务性质： </label>
			<div class="col-md-6">
				<input type="hidden" id="busiNatureName0" class="busiNatureName" name="busiNatureName" >
					<select id="busiNatureList0" class="selectList col-sm-6 col-md-6 validate[required]"  name="busiNatureID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${busiNatureList}" var="busiNature">
								<option value="${busiNature.dicTypeID}">${busiNature.dicTypeName}</option>
							</c:forEach>
				    </select>
			</div>
      	</div>

        <div class="space-4"></div>
        <div class="form-group">
		   	<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>项目类型： </label>
	        <div class="col-md-6">
	       		  <input type="hidden" id="projectTypeName0" class="projectTypeName" name="projectTypeName01" >
				  <select id="projectTypeList0" class="selectList col-sm-6 col-md-6 validate[required]"  name="projectTypeID01"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${projectTypeList}" var="projectType">
								<option value="${projectType.dicTypeID}">${projectType.dicTypeName}</option>
							</c:forEach>
				  </select>
			</div>
         </div>

          <div class="space-4"></div>
            <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>客户类型： </label>
				<div class="col-md-6">
					<input type="hidden" id="clientTypeName0" class="clientTypeName" name="clientTypeName" >
					  <select id="clientTypeList0" class="selectList col-sm-6 col-md-6 validate[required]"  name="clientTypeID" >  		
								<option value="">&nbsp;请选择</option>                                    
								<c:forEach items="${clientTypeList}" var="clientType">
									<option value="${clientType.dicTypeID}">${clientType.dicTypeName}</option>
								</c:forEach>
					  </select>
				</div>
           </div>
            <div class="space-4"></div>
            <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>客户名称： </label>
				<div class="col-md-10">
					  <input type="hidden" id="clientName10" name="clientName01"/><!-- 用于添加时候遍历使用 -->
					  <input type="hidden" id="clientID10" name="client_ID01" ><!-- 用于添加时候遍历使用 -->
				   
					<input type="text" id="clientName0"  name="clientName"  placeholder="请选择客户名称" class="col-md-5 col-sm-6 validate[required]" readonly="readonly"/>
	                <input type="hidden" id="clientID0"  name="client_ID" >
	                <div class="col-md-7 col-sm-6">           
	                	<button class="btn btn-xs btn-info" type="button" name="button" id="selectClient0" data-toggle="modal" data-target="#select">选择已有</button>
	          		 </div>
				</div>
			</div>

          <div class="space-4"></div>
          <div class="form-group">
          <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称： </label>
			<div class="col-md-10">
            <input type="text" id="projectName0" name="projectName"  class="col-md-5 col-sm-6 validate[required,maxSize[50]]" />
			 
			</div>
          </div>

           <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input">项目来源： </label>
				<div class="col-md-6">
	                 	<input type="hidden" id="projectSourceName0" class="projectSourceName" name="projectSourceName" >
						<select id="projectSourceList0" class="selectList col-sm-6 col-md-6 "  name="projectSourceID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${projectSourceList}" var="projectSource">
									<option value="${projectSource.dicTypeID}">${projectSource.dicTypeName}</option>
								</c:forEach>
					    </select>
				</select>
				</div>
          </div>
          
          <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>结息方式： </label>
				<div class="col-md-6">
	                 	<input type="hidden" id="interestMethodName0" class="interestMethodName" name="interestMethodName01" >
						<select id="interestMethodList0" class="selectList col-sm-6 col-md-6 validate[required]"  name="interestMethodID01"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${interestMethodList}" var="interestMethod">
									<option value="${interestMethod.dicTypeID}">${interestMethod.dicTypeName}</option>
								</c:forEach>
					    </select>
				</select>
				</div>
          </div>

          <div class="space-4"></div>
           <div class="form-group">
			   <label class="col-md-2 control-label no-padding-right" for="form-input">来源说明： </label>
	           <div class="col-md-6">
	               <textarea class="col-md-12 col-sm-8 limited validate[maxSize[250]]" rows="5" id="sourceDesc0"  name="sourceDesc"></textarea>
	           </div>
	           <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制250个字符</span>
	            </div>
			</div>
		<div class="space-4"></div>
           <div class="form-group">
			   <label class="col-md-2 control-label no-padding-right" for="form-input">借款用途及还款来源： </label>
	           <div class="col-md-6">
	               <textarea class="col-md-12 col-sm-8 limited validate[maxSize[250]]" rows="5" id="applySumUse0"  name="applySumUse"></textarea>
	           </div>
	           <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制100个字符</span>
	            </div>
			</div>
             <div class="space-4"></div>
              <div class="form-group">
			   	<label class="col-md-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种： </label>
		        <div class="col-md-6">
					<div class="col-md-6 col-sm-6 input-group busiSortDicTree0">
							<input  type="text"  class="form-control validate[required]" autoField="busiTypeID01"   id="busiSortDicTree0"  value="" dataValue="" name="busiTypeName01"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
				    </div>
				</div>
	           </div>
		<%-- <div class="space-4"></div>
           <div class="form-group">
			   <label class="col-md-2 control-label no-padding-right" for="form-input">绿色通道： </label>
				<div class="col-md-6">
						<input type="hidden" id="greenChannelName0" class="greenChannelName01" name="greenChannelName01" >
						<select id="greenChannelList0" class="selectList col-sm-6 col-md-6 "  name="greenChannelID01"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${greenChannelList}" var="greenChannel">
									<option value="${greenChannel.dicTypeID}">${greenChannel.dicTypeName}</option>
								</c:forEach>
					    </select>
				</div>
           </div> --%>
		   <div class="space-4"></div>
           <div class="form-group">
           	 <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>申请金额： </label>
             <div class="col-md-10">
                 <input type="text" id="applySum0" name="applySum01" class="col-md-2 col-lg-1 validate[required,maxSize[18],custom[number]]" />
                 <span class="col-md-10 col-lg-11" style="line-height:28px;">万元</span>
             </div>
			</div>
			<div class="space-4"></div>
            <div class="form-group">
              <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>申请期限： </label>
				 <div class="col-md-10">
	                 <div class="col-md-6 no-padding-left">
	                  <input type="text" id="periodMonth0" class="validate[required,maxSize[6],custom[integer]]" name="periodMonth01"  style="width:4em;" />
	                   &nbsp;个月&nbsp;
	                  <input type="text" id="periodDay0" class="validate[required,maxSize[6],custom[integer]]" name="periodDay" value="0" style="width:4em;" />
	                   &nbsp;天&nbsp;
	                 </div>
              	 </div>
		   </div>

		    <div class="space-4"></div>
		    <div class="form-group" id="cooperation">
		   		<label class="col-md-2 control-label no-padding-right" for="form-field-1">合作机构： </label>
		        <div class="col-md-6">
					<div class="col-sm-6 col-md-6 input-group cooperationTree0">
							<input  type="text"  class="form-control " autoField="bankID01"   id="cooperationTree0"  value="" dataValue="" name="bankName01"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
				    </div>
				</div>
           	</div>

            <!--  <div class="space-4"></div>
             <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">贷款(担保)用途： </label>
                 <div class="col-md-6">
                     <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="loadUsed0" name="loadUsed" rows="5"></textarea>
                 </div>
                 <div class="col-md-8 col-sm-8">
                     <span class="light-grey" style="float:right;">限制2000个字符</span>
                 </div>
			 </div>

            <div class="space-4"></div>
            <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">还款计划和来源： </label>
                  <div class="col-md-6">
                      <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="repaymentPlan0" name="repaymentPlan" rows="5"></textarea>
                  </div>
                  <div class="col-md-8 col-sm-8 ">
                      <span class="light-grey" style="float:right;">限制2000个字符</span>
                  </div>
			</div>

            <div class="space-4"></div>
            <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">拟提供的保证措施： </label>
	             <div class="col-md-6">
	                 <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="provideGuaranty0" name="provideGuaranty" rows="5"></textarea>
	             </div>
	             <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制2000个字符</span>
	             </div>
		   </div>

           <div class="col-md-12 space-12"></div>
           <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">备注： </label>
	            <div class="col-md-6">
	                <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="otherDesc0" name="otherDesc" rows="5"></textarea>
	            </div>
	
	            <div class="col-md-8 col-sm-8">
	                <span class="light-grey" style="float:right;">限制2000个字符</span>
	            </div>
		    </div> -->

            <div class="space-4"></div>
            <div class="form-group">
			  	<label class="col-md-2 control-label no-padding-right" for="form-field-1">经办部门： </label>
				  <div class="col-md-6">				  
						<div class="col-sm-6 col-md-6 input-group allDepartsTree0">
							<input  type="text"  class="form-control" autoField="departID00"   id="allDepartsTree0"  value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="departName00"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
			</div>
            <div class="space-4"></div>
           	<div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1">经办人： </label>		
					<div class="col-md-6">
						<div class="col-md-6 col-sm-6 input-group txt_id0">
							<input  type="text"  class="form-control " autoField="createManID00"   id="txt_id0"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createManName00"  readonly="readonly"/>
							
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
			</div>
            <div class="space-4"></div>
           	<div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1">A角： </label>		
					<div class="col-md-6">
						<div class="col-md-6 col-sm-6 input-group amanTree0">
							<input  type="text"  class="form-control " autoField="amanID00"   id="amanTree0"  value="" dataValue="" name="amanName00"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
			</div>
            <div class="space-4"></div>
           	<div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1">B角： </label>		
					<div class="col-md-6">
						<div class="col-md-6 col-sm-6 input-group bmanTree0">
							<input  type="text"  class="form-control " autoField="bmanID00"   id="bmanTree0"  value="" dataValue="" name="bmanName00"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
			</div>
		
        <div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">受理日期： </label>
	         	<div class="col-md-6">
					<div class="input-group col-sm-6 col-md-6">
						<input class="form-control date-picker validate[custom[date]]" id="createDate0" name="createDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
        </form>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_applyAdd" type="button"  value="0"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      <!--  <button class="btn btn-primary btn_agreeAdd" type="button" value="0"><i class="icon-ok bigger-110"></i>同意立项</button>
		        &nbsp; &nbsp; &nbsp; -->
		       <button class="btn btn_colse" type="button" ><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div>     
     </div>
    </div>
</div>
<script src="<%=path %>/project/apply/applyAdd.js?v=<%=vardate%>"></script>