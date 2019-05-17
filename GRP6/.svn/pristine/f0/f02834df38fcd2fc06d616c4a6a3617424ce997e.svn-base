<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<script type="text/javascript">
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
	
}); 
$('.date-picker').attr("value",tool.parseDate(new Date().getTime()));//设置默认日期为当前日期

/**
 * 获取下拉框值;
 */
function getSelectText2 (v){
    var  selectID = v.id;
    var selectName = selectID.replace(/List/, "Name");
　    document.getElementById(selectName).value=v.options[v.options.selectedIndex].text;
};
/**
 * 删除动态添加的行
 */
function delAdd(v){
	var rowNum = $("#table2").find("tr").length;
	 if(rowNum != 2){/* 数据多于一行时,可以删除; */
		var  delID= v.id;
		var tr = $("#tr"+delID);
		var tr = document.getElementById("tr"+delID);
	    tr.parentNode.removeChild(tr);
		$(this).parent('tr').remove();
	}
};
	
	
</script>
<div class="page-content">   
	<input type="hidden" id="clientTypeName2" class="clientTypeName" name="clientTypeName" value="集团/关联客户">  
   
   
   
     <div class="row">
		<div class="col-xs-12">
		
		<form class="form-horizontal" role="form" id="applyAdd_form2">
		    <input type="hidden" id="projectType2" class="" name="projectType" value="关联"><!--单笔/多笔/关联/综合授信  -->
	   		 <input type="hidden" id="rowNum2" class="" name="rowNum" value="1" >	 <!--计算添加按钮点击次数即:行数 -->		 			
			 <input type="hidden" id="busiDetails2" class="" name="busiDetails" >	 <!-- 获取申请明细详情冗余字段 -->		 					 
			 <input type="hidden" id="departName2" name="departName" >	 <!--经办机构名称 -->		 			
		     <input type="hidden" id="departID2" name="departID" >	 <!--经办机构id -->		 			
		     <input type="hidden" id="createManName2" name="createManName" >	 <!--经办人 -->		 			
		     <input type="hidden" id="createManID2" name="createManID" >	 <!--经办人id -->	
		     <input type="hidden" id="amanName2" name="amanName" >	 <!--A角 -->		 			
		      <input type="hidden" id="amanID2" name="amanID" >	 <!--A角id -->	
		      <input type="hidden" id="bmanName2" name="bmanName" >	 <!--B角 -->		 			
		      <input type="hidden" id="bmanID2" name="bmanID" >	 <!--B角id -->	
		     <input type="hidden" id="projectStageID2" name="projectStageID" >	 <!--项目阶段id -->		 			
   			 <input type="hidden" id="projectStageName2" name="projectStageName" >	 <!--项目阶段名称 -->		 			
		     <input type="hidden" id="clientTypeID2" name="clientTypeID" value="集团/关联客户">	 <!--客户类型 -->	
         
         
         
         <div class="space-4"></div>
         <div class="form-group">
			<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务性质： </label>
			<div class="col-md-6">
				<input type="hidden" id="busiNatureName2" class="busiNatureName" name="busiNatureName" >
					<select id="busiNatureList2" class="selectList col-sm-6 col-md-6 validate[required]"  name="busiNatureID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${busiNatureList}" var="busiNature">
								<option value="${busiNature.dicTypeID}">${busiNature.dicTypeName}</option>
							</c:forEach>
				    </select>
			</div>
      	</div>
		
            <div class="space-4"></div>
            <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>主体名称： </label>
				<div class="col-md-10">
				     <input type="hidden" id="clientName12" name="clientName21"/><!-- 用于添加时候遍历使用 -->
					 <input type="hidden" id="clientID12" name="client_ID21" ><!-- 用于添加时候遍历使用 -->
				     <input type="hidden" id="clientName2" name="clientName"/>
					 <input type="hidden" id="clientID2" name="client_ID" />
				     
					<input type="text" id="relationName2" name="relationName" placeholder="请选择主体名称" class="col-md-5 col-sm-6 validate[required]" readonly="readonly"/>
	                <input type="hidden" id="relationID2" name="relationID" >
	                <div class="col-md-7 col-sm-6">
	                	<button class="btn btn-xs btn-info" type="button" name="button"  id="selectClient2" data-toggle="modal" data-target="#select">选择已有</button>
	          		 </div>
				</div>
			</div>

          <div class="space-4"></div>
          <div class="form-group">
          <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称： </label>
			<div class="col-md-10">
	            <input type="text" id="projectName2" name="projectName"  class="col-md-5 col-sm-6 validate[required,maxSize[2000]]" />
				<input type="hidden" id="clientGUID2" name="clientGUID"/><!-- 客户唯一标示 -->
			</div>
          </div>

          <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input">项目来源： </label>
				<div class="col-md-6">
	                 	<input type="hidden" id="projectSourceName2" class="projectSourceName" name="projectSourceName" >
						<select id="projectSourceList2" class="selectList col-sm-6 col-md-6 "  name="projectSourceID"  >		
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
	               <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="sourceDesc2"  name="sourceDesc" rows="5"></textarea>
	           </div>
	           <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制250个字符</span>
	            </div>
			</div>
			

             <!-- <div class="space-4"></div>
             <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">贷款(担保)用途： </label>
                 <div class="col-md-6">
                     <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="loadUsed2" name="loadUsed" rows="5"></textarea>
                 </div>

                 <div class="col-md-8 col-sm-8">
                     <span class="light-grey" style="float:right;">限制2000个字符</span>
                 </div>
			 </div>

            <div class="space-4"></div>
            <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">还款计划和来源： </label>
                  <div class="col-md-6">
                      <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="repaymentPlan2" name="repaymentPlan" rows="5"></textarea>
                  </div>
                  <div class="col-md-8 col-sm-8">
                      <span class="light-grey" style="float:right;">限制2000个字符</span>
                  </div>
			</div>

            <div class="space-4"></div>
            <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">拟提供的保证措施： </label>
	             <div class="col-md-6">
	                 <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="provideGuaranty2"  name="provideGuaranty" rows="5"></textarea>
	             </div>
	             <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制2000个字符</span>
	             </div>
		   </div>

           <div class="space-4"></div>
           <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">备注： </label>
	            <div class="col-md-6">
	                <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="otherDesc2" name="otherDesc" rows="5"></textarea>
	            </div>
	
	            <div class="col-md-8 col-sm-8">
	                <span class="light-grey" style="float:right;">限制2000个字符</span>
	            </div>
		    </div> -->

            <div class="space-4"></div>
            <div class="col-md-12 col-sm-12">
	             <h4 class="col-md-offset-1 header smaller lighter blue">
	             		业务申请明细
	             <button type="button" name="button" class="btn btn-minier btn-warning pull-right btn_tableAdd" id="relationMainApplyAdd">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
	            </button>
	           </h4>
	           <div class="col-md-offset-1">
	            <table  id="table2" class="table table-hover table-striped" name="relationApllyTable">			 			
				 			<thead>
					 			 <tr>
						         	 <th><i class="icon-asterisk orange"></i>项目类型</th>
						         	 <!-- <th><i class="icon-asterisk orange"></i>客户名称</th> -->
						         	 <th>合作机构 </th>
						             <th><i class="icon-asterisk orange"></i>业务品种</th>
						            <!--  <th>绿色通道 </th> -->
						             <th><i class="icon-asterisk orange"></i>申请金额（万元）</th>
						             <th><i class="icon-asterisk orange"></i>申请期限（月）</th>
						             <th>操作</th>
					             </tr>
				             </thead>				             
				             <tr id="tr21">
				              <td style="border:1px solid #ddd;">
				               <input type="hidden" id="projectTypeName2" class="projectTypeName" name="projectTypeName21" >
									  <select id="projectTypeList2" class="selectList   validate[required]"  name="projectTypeID21"  >		
												<option value="">&nbsp;请选择</option>
												<c:forEach items="${projectTypeList}" var="projectType">
													<option value="${projectType.dicTypeID}">${projectType.dicTypeName}</option>
												</c:forEach>
									  </select>
				              </td>
				             <!--  <td style="border:1px solid #ddd;">
				            	   <input type="hidden" id="clientName2" name="clientName21" >
				            	  <select id="clientList2"  class="selectList validate[required]" name="client_ID21">
				            	 		 <option value="">&nbsp;请选择</option>
				            	  </select>
				             			
				              </td> -->
							  <td style="border:1px solid #ddd;">
							      <div class="col-md-12 col-lg-12">
							 		 <div class="col-md-12 input-group cooperationTree2">
										<input  type="text"  class="form-control" autoField="bankID21"   id="cooperationTree2"  value="" dataValue="" name="bankName21"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
						    		</div>
						         </div>
							  </td>
							  <td style="border:1px solid #ddd;">
							        <div class="col-md-12 col-lg-12">
								 		<div class="col-md-12 input-group busiSortDicTree2">
											<input  type="text"  class="form-control validate[required]" autoField="busiTypeID21"   id="busiSortDicTree2"  value="" dataValue="" name="busiTypeName21"  readonly="readonly"/>
											<span class="input-group-addon ">
												<i class="icon-caret-down bigger-110"></i>
											</span>
							   			</div>
						   			</div>
							  </td>
							 <%--  <td style="border:1px solid #ddd;">
							  		<input type="hidden" id="greenChannelName2" class="greenChannelName" name="greenChannelName21" >
									<select id="greenChannelList2" class="selectList "  name="greenChannelID21"  >		
											<option value="">&nbsp;请选择</option>
											<c:forEach items="${greenChannelList}" var="greenChannel">
												<option value="${greenChannel.dicTypeID}">${greenChannel.dicTypeName}</option>
											</c:forEach>
								    </select>
							  </td> --%>
							  <td style="border:1px solid #ddd;">
							  		<input type="text" style="width:100%;" class="validate[required,maxSize[18],custom[number]]" id="applySum2" name="applySum21" />
							  </td>
							 <!--  <td style="width:150px;border:0px solid #ddd;flaot:left;" >							  							    
							  		<input type="text" style="width:40px;float:left" id="periodMonth2"  class="" name="periodMonth"  />
							  		<p style="float:left;line-height:28px;">个月</p>
							  		<input type="hidden" style="width:40px;float:left"  id="periodDay2"  class="" name=""  />
							  		<p style="float:left;line-height:28px;">天</p>			  
							     
							  </td>-->		     			            					         
							  <td style="border:1px solid #ddd;" >	
							  						  							    
							  		<input type="text" style="width:100%;"  class="validate[required,maxSize[6],custom[integer]]"  id="periodMonth2" name="periodMonth21"/>
							     
							  </td>				     			            					         
					          <td style="border:1px solid #ddd;">
						          <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
						              <button type="button" class="btn btn-xs btn-danger"  onClick='delAdd(this)' id='21'>
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
						<div class="col-md-6 col-sm-6 input-group allDepartsTree2">
							<input  type="text"  class="form-control" autoField="departID22"   id="allDepartsTree2"  value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="departName22"  readonly="readonly"/>
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
						<div class="col-md-6 col-sm-6 input-group txt_id2">
							<input  type="text"  class="form-control " autoField="createManID22"   id="txt_id2"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createManName22"  readonly="readonly"/>
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
						<div class="col-md-6 col-sm-6 input-group amanTree2">
							<input  type="text"  class="form-control " autoField="amanID22"   id="amanTree2"  value="" dataValue="" name="amanName22"  readonly="readonly"/>
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
						<div class="col-md-6 col-sm-6 input-group bmanTree2">
							<input  type="text"  class="form-control " autoField="bmanID22"   id="bmanTree2"  value="" dataValue="" name="bmanName22"  readonly="readonly"/>
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
						<input class="form-control date-picker validate[custom[date]]" id="createDate2" type="text" name="createDate"  data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
        </form>
        <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_applyAdd" type="button" value="2"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      <!--  <button class="btn btn-primary btn_agreeAdd"  type="button" value="2"><i class="icon-ok bigger-110"></i>同意立项</button>
		        &nbsp; &nbsp; &nbsp; -->
		       <button class="btn btn_colse" type="button "><i class="icon-remove bigger-110 " ></i>关闭</button>
      		</div>
   		</div>
  	</div>
   </div>
</div>
<script src="<%=path %>/project/apply/applyAdd.js?v=<%=vardate%>"></script>