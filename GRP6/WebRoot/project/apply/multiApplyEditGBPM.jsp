<style>
	table{
	font-size:13px;
	border:1px solid #ddd;
	}
	table tr th{
	border:1px solid #ddd;
	text-align: center;
	};
</style>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>

<script type="text/javascript">
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
       <div class="page-header">
       	<h4>申请登记信息</h4>
       </div>
      <div class="row">
		<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="applyEdit_from1">
		<input type="hidden" id="" class="pageType" name="" value="1"><!-- 页面标识:0:单笔页面,1:多笔页面,2:集团关联页面 -->
		    <input type="hidden" id="apply_ID1" class="" name="apply_ID" value="${applyDetail.apply_ID}">
			<input type="hidden" id="projectType1" class="" name="projectType" value="多笔"><!--单笔/多笔/关联/综合授信  -->
			<input type="hidden" id="rowNum1" class="" name="rowNum" value="${fn:length(applyDetailList)}" ><!--计算添加按钮点击次数即:行数 -->	
            <input type="hidden" id="busiDetails1" class="" name="busiDetails" ><!-- 获取申请明细详情冗余字段 -->
		    <input type="hidden" id="projectStageID1" name="projectStageID" value="${applyDetail.projectStageID}">	 <!--项目阶段id -->		 			
		    <input type="hidden" id="projectStageName1" name="projectStageName" value="${applyDetail.projectStageName}">	 <!--项目阶段名称 -->		 			
			<input type="hidden" id="departName1" name="departName" value="${applyDetail.departName}"><!--经办机构名称 -->		 			
   		    <input type="hidden" id="departID1" name="departID" value="${applyDetail.departID}"><!--经办机构id -->				
            <input type="hidden" id="createManName1" name="createManName" value="${applyDetail.createManName}"><!--经办人 -->		 			
    		<input type="hidden" id="createManID1" name="createManID" value="${applyDetail.createManID}"><!--经办人id -->	
    		<input type="hidden" id="amanName1" name="amanName" value="${applyDetail.amanName}">	 <!--A角 -->		 			
		    <input type="hidden" id="amanID1" name="amanID" value="${applyDetail.amanID}">	 <!--A角id -->	
		    <input type="hidden" id="bmanName1" name="bmanName" value="${applyDetail.bmanName}">	 <!--B角人 -->		 			
		    <input type="hidden" id="bmanID1" name="bmanID" value="${applyDetail.bmanID}">	 <!--B角id -->
    		
    		<input type="hidden" id="clientTypeID1" name="clientTypeID" value="${applyDetail.clientTypeID}"><!--客户类型 -->	
       		<input type="hidden" id="clientGUID1" name="clientGUID" value="${applyDetail.clientGUID}"><!-- 客户唯一标示 -->
         <div class="space-4"></div>
         <div class="form-group">
			<label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务性质： </label>
			<div class="col-md-6">
				<input type="hidden" id="busiNatureName1" class="busiNatureName" name="busiNatureName" value="${applyDetail.busiNatureName}">
					<select id="busiNatureList1" class="selectList col-sm-6 col-md-6 validate[required]" onchange='getSelectText2(this)' name="busiNatureID"  >		
							<option value="">&nbsp;请选择</option>
							<c:forEach items="${busiNatureList}" var="busiNature">
								<option value="${busiNature.dicTypeID}" <c:if test="${applyDetail.busiNatureID eq busiNature.dicTypeID}"> selected="selected"</c:if>  >${busiNature.dicTypeName}</option>
							</c:forEach>
				    </select>
			</div>
      	</div>


        
            <div class="space-4"></div>
            <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>客户名称： </label>
				<div class="col-md-10">
				
				    <input type="hidden" id="clientName11" name="clientName11" value="${applyDetail.clientName}"/><!-- 用于添加是遍历使用 -->
					<input type="hidden" id="clientID11" name="client_ID11" value="${applyDetail.client_ID}"><!-- 用于添加是遍历使用 -->					
					<input type="text" id="clientName1" name="clientName"  value="${applyDetail.clientName}" class="col-md-5 col-sm-6" />
	                <input type="hidden" id="clientID1"  name="client_ID" value="${applyDetail.client_ID}">
	                <div class="col-md-7 col-sm-6">
	                	<button class="btn btn-xs btn-info" type="button" name="button" id="selectClient1" data-toggle="modal" data-target="#select">选择已有</button>
	          		 </div>
				</div>
			</div>

          <div class="space-4"></div>
          <div class="form-group">
          <label class="col-md-2 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称： </label>
			<div class="col-md-10">
            <input type="text" id="projectName1" name="projectName" value="${applyDetail.projectName}" class="col-md-5 col-sm-6" />
			</div>
          </div>

           <div class="space-4"></div>
           <div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-input">项目来源： </label>
				<div class="col-md-6">
	                 	<input type="hidden" id="projectSourceName1" class="projectSourceName" name="projectSourceName" value="${applyDetail.projectSourceName}">
						<select id="projectSourceList1" class="selectList col-sm-6 col-md-6 validate[required]" onchange='getSelectText2(this)'   name="projectSourceID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${projectSourceList}" var="projectSource">
									<option value="${projectSource.dicTypeID}"  <c:if test="${applyDetail.projectSourceID eq projectSource.dicTypeID}"> selected="selected"</c:if> >${projectSource.dicTypeName}</option>
								</c:forEach>
					    </select>
				</select>
				</div>
          </div>

        <%--   <div class="space-4"></div>
           <div class="form-group">
			   <label class="col-md-2 control-label no-padding-right" for="form-input">来源说明： </label>
	           <div class="col-md-6">
	               <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="sourceDesc1" name="sourceDesc" rows="5">${applyDetail.sourceDesc}</textarea>
	           </div>
	           <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制250个字符</span>
	            </div>
			</div>
     

		 
             <div class="space-4"></div>
             <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">贷款(担保)用途： </label>
                 <div class="col-md-6">
                     <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="loadUsed1" name="loadUsed" rows="5">${applyDetail.loadUsed}</textarea>
                 </div>
                 <div class="col-md-8 col-sm-8">
                     <span class="light-grey" style="float:right;">限制2000个字符</span>
                 </div>
			 </div>

            <div class="space-4"></div>
            <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">还款计划和来源： </label>
                  <div class="col-md-6">
                      <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="repaymentPlan1" name="repaymentPlan" rows="5">${applyDetail.repaymentPlan}</textarea>
                  </div>
                  <div class="col-md-8 col-sm-8">
                      <span class="light-grey" style="float:right;">限制2000个字符</span>
                  </div>
			</div>

            <div class="space-4"></div>
            <div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">拟提供的保证措施： </label>
	             <div class="col-md-6">
	                 <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="provideGuaranty1" name="provideGuaranty" rows="5">${applyDetail.provideGuaranty}</textarea>
	             </div>
	             <div class="col-md-8 col-sm-8">
	                 <span class="light-grey" style="float:right;">限制2000个字符</span>
	             </div>
		   </div>

           <div class="space-4"></div>
           <div class="form-group">
	   	    <label class="col-md-2 control-label no-padding-right" for="form-input">备注： </label>
	            <div class="col-md-6">
	                <textarea class="col-md-12 col-sm-8 limited validate[maxSize[2000]]" id="otherDesc1" name="otherDesc" rows="5">${applyDetail.otherDesc}</textarea>
	            </div>
	
	            <div class="col-md-8 col-sm-8">
	                <span class="light-grey" style="float:right;">限制2000个字符</span>
	            </div>
		    </div>--%>
			<div class="space-4"></div>
            <div class="col-md-12 col-sm-12">
	             <h4 class=" col-md-offset-1 header smaller lighter blue">
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
						            <!--  <th>绿色通道 </th> -->
						             <th><i class="icon-asterisk orange"></i>申请金额（万元）</th>
						             <th><i class="icon-asterisk orange"></i>申请期限（月）</th>
						             <th>操作</th>
					             </tr>
				             </thead>
				           <c:forEach items="${applyDetailList}" var="applyDetail" varStatus="listCount">	
				       
				           		<input type="hidden" id="applyDetail_ID1${listCount.count}" class="" name="applyDetail_ID1${listCount.count}" value="${applyDetail.applyDetail_ID}">		             		             
				             
				             <tr id="tr1${listCount.count}" >
				              <td style="border:1px solid #ddd;">				              		
				              		  <input type="hidden" id="projectTypeName${listCount.count}" class="" name="projectTypeName1${listCount.count}" value="${applyDetail.projectTypeName}">	
									  <select id="projectTypeList${listCount.count}" class="  validate[required]" onchange='getSelectText2(this)' name="projectTypeID1${listCount.count}"  >		
												<option value="">&nbsp;请选择</option><!-- 项目类型  -->
												<c:forEach items="${projectTypeList}" var="projectType">
													<option value="${projectType.dicTypeID}" <c:if test="${applyDetail.projectTypeID eq projectType.dicTypeID}"> selected="selected"</c:if> >${projectType.dicTypeName}</option>
												</c:forEach>
									  </select>
				              </td>
				              <td style="border:1px solid #ddd;">        
				                  <div class="col-md-12 col-lg-12">
				              		<div class="col-md-12 input-group cooperationTree1${listCount.count}"><!-- 合作机构 -->
										<input  type="text"  class="form-control " autoField="bankID1${listCount.count}"   id="cooperationTree1${listCount.count}"  value="${applyDetail.bankName}" dataValue="${applyDetail.bankID}" name="bankName1${listCount.count}"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
						    		</div>
						    	 </div>
				              </td>
							  <td style="border:1px solid #ddd;">
							  	<div class="col-md-12 col-lg-12">
							  		<div class="col-md-12 input-group busiSortDicTree1${listCount.count}"><!-- 业务品种 -->
										<input  type="text"  class="form-control validate[required]" autoField="busiTypeID1${listCount.count}"   id="busiSortDicTree1${listCount.count}"  value="${applyDetail.busiTypeName}" dataValue="${applyDetail.busiTypeID}" name="busiTypeName1${listCount.count}"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
						   			</div>
						   		</div>
							  </td>
							 <%--  <td style="border:1px solid #ddd;">							  
							  		<input type="hidden" id="greenChannelName${listCount.count}" class="greenChannelName "  name="greenChannelName1${listCount.count}" value="${applyDetail.greenChannelName}">
									<select id="greenChannelList${listCount.count}" class=" " onchange='getSelectText2(this)' name="greenChannelID1${listCount.count}"  value="${applyDetail.greenChannelName}">		
											<option value="">&nbsp;请选择</option><!-- 绿色通道  -->
											<c:forEach items="${greenChannelList}" var="greenChannel">
												<option value="${greenChannel.dicTypeID}"  <c:if test="${applyDetail.greenChannelID eq greenChannel.dicTypeID}"> selected="selected"</c:if>>${greenChannel.dicTypeName}</option>
											</c:forEach>
								    </select>								    
							  </td> --%>
							  <td style="border:1px solid #ddd;">
							 		 <input type="text" style="width:100%;" class="validate[required,maxSize[18],custom[number]]" id="applySum1${listCount.count}"  name="applySum1${listCount.count}" value="<fmt:formatNumber value="${applyDetail.applySum}" pattern="###.######"/>"/>
							  </td>
							  <td style="border:1px solid #ddd;">
							  		<input type="text" style="width:100%;"  class="validate[required,maxSize[6],custom[integer]]"  id="periodMonth1${listCount.count}" name="periodMonth1${listCount.count}" value="${applyDetail.periodMonth}"/>							     				  
							  </td>				     			            
							 		     			      
					          <td style="border:1px solid #ddd;">
						          <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
						              <button  type="button" class="btn btn-xs btn-danger " onClick='delAdd(this)'  id="1${listCount.count}">
						                  <i class="icon-trash bigger-120"></i>
						              </button>
						          </div>
					           </td>
			               </tr>	
			               </c:forEach> 
			               		               
	           </table>
	           </div>
          </div>
            <div class="space-4"></div>
            <div class="form-group">
			  	<label class="col-md-2 control-label no-padding-right" for="form-field-1">经办部门： </label>
				  <div class="col-md-6">				  
						<div class="col-sm-6 col-md-6 input-group allDepartsTree1">
							<input  type="text"  class="form-control" autoField="departID11"   id="allDepartsTree1"  value="${applyDetail.departName}" dataValue="${applyDetail.departID}" name="departName"  readonly="readonly"/>
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
						<div class="col-sm-6 col-md-6 input-group txt_id1">
							<input  type="text"  class="form-control " autoField="createManID11"   id="txt_id1"  value="${applyDetail.createManName}" dataValue="${applyDetail.createManID}" name="createManName11"  readonly="readonly"/>
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
								<input  type="text"  class="form-control " autoField="amanID11"   id="amanTree1"  value="${applyDetail.amanName}" dataValue="${applyDetail.amanID}" name="amanName11"  readonly="readonly"/>
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
							<input  type="text"  class="form-control " autoField="bmanID11"   id="bmanTree1"  value="${applyDetail.bmanName}" dataValue="${applyDetail.bmanID}" name="bmanName11"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
			</div>	
        <div class="space-4"></div>
			<div class="form-group">
		   	    <label class="col-md-2 control-label no-padding-right" for="form-input">受理日期： </label>
	         	<div class="col-md-10">
					<div class="input-group col-md-4 col-sm-6">
						<input class="form-control date-picker" id="createDate1" name="createDate" type="text" value="<fmt:formatDate value="${applyDetail.createDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"  data-date-format="yyyy-mm-dd"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
        </form>
      <div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_applyUpdate" type="button" value="1"><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      
		       <button class="btn btn_colse" type="button" value="1"><i class="icon-remove bigger-110 "></i>关闭</button>
            </div>
      </div>      
     </div>
    </div>
</div>
<%-- ​<%@ include file="/common_foot.jsp" %> --%>
<%@ include file="/project/apply/clientList.jsp" %>
<script src="<%=path %>/project/apply/applyEdit.js?v=<%=vardate%>"></script>