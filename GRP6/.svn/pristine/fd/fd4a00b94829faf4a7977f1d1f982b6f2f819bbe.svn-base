<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
$('.date-picker').attr("value",tool.parseDate(new Date().getTime()));//设置默认日期为当前日期
/**
 *获取下拉框值;
 */
function getSelectText2 (v){
    var  selectID = v.id;
    var selectName = selectID.replace(/List/, "Name");
　    document.getElementById(selectName).value=v.options[v.options.selectedIndex].text;
};
/**
 * 动态删除行;
 */
function delAdd(v){
	var rowNum = $("#table1").find("tr").length;
	 if(rowNum != 2){
		var  delID= v.id;
		var tr = $("#tr"+delID);
		var tr = document.getElementById("tr"+delID);
	    tr.parentNode.removeChild(tr);
		$(this).parent('tr').remove();
	} 
	
	
	
	
};
</script>
<div class="page-content">

    <!-- <input type="hidden" id="multiAppleAddPage" class="pageType" name="multiAppleAddPage" value="1"> -->
  
    <div class="row">
		<div class="col-xs-12">
		
	<form class="form-horizontal" role="form" id="applyAdd_form1">
          
    <input type="hidden" id="projectType1" class="" name="projectType" value="多笔"><!--单笔/多笔/关联/综合授信  -->
    <input type="hidden" id="busiDetails1" class="" name="busiDetails" ><!-- 获取申请明细详情冗余字段 -->		 			
    <input type="hidden" id="rowNum1" class="" name="rowNum" value="1" ><!--计算添加按钮点击次数即:行数 -->		 			
    <input type="hidden" id="departName1" name="departName" ><!--经办机构名称 -->		 			
    <input type="hidden" id="departID1" name="departID" ><!--经办机构id -->		 			
    <input type="hidden" id="createManName1" name="createManName" ><!--经办人 -->		 			
    <input type="hidden" id="createManID1" name="createManID" ><!--经办人id -->		 			
    <input type="hidden" id="amanName1" name="amanName" >	 <!--A角 -->		 			
     <input type="hidden" id="amanID1" name="amanID" >	 <!--A角id -->	
     <input type="hidden" id="bmanName1" name="bmanName" >	 <!--B角人 -->		 			
     <input type="hidden" id="bmanID1" name="bmanID" >	 <!--B角id -->
    <input type="hidden" id="projectStageID1" name="projectStageID" >	 <!--项目阶段id -->		 			
    <input type="hidden" id="projectStageName1" name="projectStageName" >	 <!--项目阶段名称 -->		 			
 	 			
				 
   
        
        
        
         <div class="space-4"></div>
         <div class="form-group">
			<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务性质： </label>
			<div class="col-md-6">
				<input type="hidden" id="busiNatureName1" class="busiNatureName" name="busiNatureName" >
					<select id="busiNatureList1" class="selectList col-sm-6 col-md-6 validate[required]"  name="busiNatureID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${busiNatureList}" var="busiNature">
								<option value="${busiNature.dicTypeID}">${busiNature.dicTypeName}</option>
							</c:forEach>
				    </select>
			</div>
      	</div>

           <div class="space-4"></div>
            <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>客户类型： </label>
				<div class="col-md-6">
					<input type="hidden" id="clientTypeName1" class="clientTypeName" name="clientTypeName" >					
					 <select id="clientTypeList1" class="selectList col-sm-6 col-md-6 validate[required]"  name="clientTypeID"  >		
								<option value="" >&nbsp;请选择</option>
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
				
				    <input type="hidden" id="clientName11" name="clientName11"/><!-- 用于添加是遍历使用 -->
					<input type="hidden" id="clientID11" name="client_ID11" ><!-- 用于添加是遍历使用 -->
				   
					<input type="text" id="clientName1" placeholder="请选择客户名称" name="clientName" class="col-md-5 col-sm-6 validate[required]" readonly="readonly"/>
					<input type="hidden" id="clientID1" name="client_ID" ><!-- 用于新增插入时保存于apply中使用 -->
	                
	                <div class="col-md-7 col-sm-6">
	                	<button class="btn btn-xs btn-info" type="button" name="button" id="selectClient1" data-toggle="modal" data-target="#select">选择已有</button>
	          		 </div>
				</div>
			</div>

          <div class="space-4"></div>
          <div class="form-group">
          <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称： </label>
			<div class="col-md-10">
            <input type="text"  id="projectName1" name="projectName" class="col-md-5 col-sm-6 validate[required,maxSize[50]] " />
			<input type="hidden" id="clientGUID1" name="clientGUID"/><!-- 客户唯一标示 -->
			</div>
          </div>
           <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input">项目来源： </label>
				<div class="col-md-6">
	                 	<input type="hidden" id="projectSourceName1" class="projectSourceName" name="projectSourceName" >
						<select id="projectSourceList1" class="selectList col-sm-6 col-md-6 "  name="projectSourceID"  >		
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
			   <label class="col-md-2 control-label no-padding-right" for="form-input">来源说明： </label>
	           <div class="col-md-6">
	               <textarea class="col-md-12 col-sm-8 limited validate[maxSize[250]]" id="sourceDesc1" name="sourceDesc" rows="5"></textarea>
	           </div>
	           <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制250个字符</span>
	            </div>
			</div>


             <!-- <div class="space-4"></div>
             <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">贷款(担保)用途： </label>
                 <div class="col-md-6">
                     <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="loadUsed" name="loadUsed" rows="5"></textarea>
                 </div>

                 <div class="col-md-8 col-sm-8">
                     <span class="light-grey" style="float:right;">限制2000个字符</span>
                 </div>
			 </div>
 
            <div class="space-4"></div>
            <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">还款计划和来源： </label>
                  <div class="col-md-6">
                      <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="repaymentPlan1" name="repaymentPlan" rows="5"></textarea>
                  </div>
                  <div class="col-md-8 col-sm-8">
                      <span class="light-grey" style="float:right;">限制2000个字符</span>
                  </div>
			</div>

            <div class="space-4"></div>
            <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">拟提供的保证措施： </label>
	             <div class="col-md-6">
	                 <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="provideGuaranty1" name="provideGuaranty" rows="5"></textarea>
	             </div>
	             <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制2000个字符</span>
	             </div>
		   </div>

           <div class="space-4"></div>
           <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">备注： </label>
	            <div class="col-md-6">
	                <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="otherDesc1" name="otherDesc" rows="5"></textarea>
	            </div>
	
	            <div class="col-md-8 col-sm-8">
	                <span class="light-grey" style="float:right;">限制2000个字符</span>
	            </div>
		    </div>-->

            <div class="space-4"></div>
            <div class="col-md-12 col-sm-12">
	             <h4 class="col-md-offset-1 header smaller lighter blue">
	             		业务申请明细
	             <button type="button" name="button" class="btn btn-minier btn-warning pull-right btn_tableAdd" id="multiApplyAdd">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
	            </button>
	           </h4>
	           <div class="col-md-offset-1">
	             
	            <table  id="table1" class="table table-hover table-striped" >	
	            
				 			<thead>
					 			 <tr >
						         	 <th><i class="icon-asterisk orange"></i>项目类型 </th>
						         	 <th>合作机构 </th>
						             <th><i class="icon-asterisk orange"></i>业务品种</th>
						           <!--   <th>绿色通道 </th> -->
						             <th><i class="icon-asterisk orange"></i>申请金额（万元）</th>
						             <th><i class="icon-asterisk orange"></i>申请期限（月）</th>
						             <th>操作</th>
					             </tr>
				             </thead>				             
				             <tr id="tr11">
				              <td style="border:1px solid #ddd;">				              		
				              		  <input type="hidden" id="projectTypeName1" class="" name="projectTypeName11" >	
									  <select id="projectTypeList1" class="selectList  validate[required]"  name="projectTypeID11"  >		
												<option value="">&nbsp;请选择</option>
												<c:forEach items="${projectTypeList}" var="projectType">
													<option value="${projectType.dicTypeID}">${projectType.dicTypeName}</option>
												</c:forEach>
									  </select>
				              </td>
				              <td style="border:1px solid #ddd;">        
				                  <div class="col-md-12 col-lg-12">
				              		<div class="col-md-12 input-group cooperationTree1">
										<input  type="text"  class="form-control " autoField="bankID11"   id="cooperationTree1"  value="" dataValue="" name="bankName11"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
						    		</div>
						    	 </div>
				              </td>
							  <td style="border:1px solid #ddd;">
							  	<div class="col-md-12 col-lg-12">
							  		<div class="col-md-12 input-group busiSortDicTree1">
										<input  type="text"  class="form-control validate[required]" autoField="busiTypeID11"   id="busiSortDicTree1"  value="" dataValue="" name="busiTypeName11"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
						   			</div>
						   		</div>
							  </td>
							 <%--  <td style="border:1px solid #ddd;">							  
							  		<input type="hidden" id="greenChannelName1" class="greenChannelName dynamicAdd"  name="greenChannelName11" >
									<select id="greenChannelList1" class="selectList "  name="greenChannelID11"  >		
											<option value="">&nbsp;请选择</option>
											<c:forEach items="${greenChannelList}" var="greenChannel">
												<option value="${greenChannel.dicTypeID}">${greenChannel.dicTypeName}</option>
											</c:forEach>
								    </select>								    
							  </td> --%>
							  <td style="border:1px solid #ddd;">
							 		 <input type="text" style="width:100%;" class="validate[required,maxSize[18],custom[number]]" id="applySum1"  name="applySum11" />
							  </td>
							  <td style="border:1px solid #ddd;">
							  		<input type="text" style="width:100%;"  class="validate[required,maxSize[6],custom[integer]]"  id="periodMonth1" name="periodMonth11"/>							     				  
							  </td>				     			            
							
					          <td style="border:1px solid #ddd;">
						          <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
						              <button  type="button" class="btn btn-xs btn-danger " onClick='delAdd(this)'  id="11">
						                  <i class="icon-trash bigger-120"></i>
						              </button>
						          </div>
					           </td>
			               </tr>			               
	           </table>
	           </div>
          </div>
            
            <div class="col-md-12 col-sm-12 space-12"></div>
            <div class="form-group">
			  	<label class="col-md-2 control-label no-padding-right" for="form-field-1">经办部门： </label>
				  <div class="col-md-6">				  			
						<div class="col-md-6 col-sm-6 input-group allDepartsTree1">
							<input  type="text"  class="form-control" autoField="departID11"   id="allDepartsTree1"  value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="departName11"  readonly="readonly"/>
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
						<div class="col-md-6 col-sm-6 input-group txt_id1">
							<input  type="text"  class="form-control " autoField="createManID11"   id="txt_id1"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createManName11"  readonly="readonly"/>
							
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
						<div class="col-md-6 col-sm-6 input-group amanTree1">
							<input  type="text"  class="form-control " autoField="amanID11"   id="amanTree1"  value="" dataValue="" name="amanName11"  readonly="readonly"/>
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
						<div class="col-md-6 col-sm-6 input-group bmanTree1">
							<input  type="text"  class="form-control " autoField="bmanID11"   id="bmanTree1"  value="" dataValue="" name="bmanName11"  readonly="readonly"/>
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
					<div class="input-group col-md-6 col-sm-6">
						<input class="form-control date-picker validate[custom[date]]" id="createDate1" name="createDate" type="text" value="" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
        </form>
      
       <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_applyAdd" type="button" value="1" ><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      <!--  <button class="btn btn-primary btn_agreeAdd" type="button" value="1" ><i class="icon-ok bigger-110"></i>同意立项</button>
		        &nbsp; &nbsp; &nbsp; -->
		       <button class="btn btn_colse" type="button"><i class="icon-remove bigger-110 "></i>关闭</button>
      		</div>
      </div>
 </div>
 </div>
</div>

<script src="<%=path %>/project/apply/applyAdd.js?v=<%=vardate%>"></script>
