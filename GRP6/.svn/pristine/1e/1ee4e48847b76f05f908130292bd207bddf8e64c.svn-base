<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="nodeTaskModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">设置${productNode.nodeNames}节点任务事项办理人</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="nodeTaskForm">
				<input type="hidden" name="entityID" id="entityID"  >
				<input type="hidden" name="entityName" id="entityName"  >
				<input type="hidden" name="entityType" id="entityType"  >
				<input type="hidden" name="productID" id="productID" >
				<input type="hidden" name="nodeTaskIDS" id="nodeTaskIDS" >
				<input type="hidden" name="productName" value="${product.productName}" >
				<input type="hidden" name="nodeSort" id="nodeSort" >
				<input type="hidden" name="isAutoAssign" id="isAutoAssign" value="${productNode.isAutoAssign}">
				<input type="hidden" name="productInstance_ID" id="productInstanceID" >
				<input type="hidden" name="nodeTaskID" value="13491e6a65b04305a7df5368196607a4" >
				<input type="hidden" name="handleUserID" value="8edc126b3060498b8c52a19ad430a907" >
				<input type="hidden" name="handleUserName" value="tip" >
				<input type="hidden" id="departLeaderID" value="${departs.leve1_user_id}" >
				<input type="hidden" id="departLeaderName" value="${departs.leve1_user_name}" >
				<input type="hidden" id="amanID" value="${apply.amanID}" >
				<input type="hidden" id="amanName" value="${apply.amanName}" >
				<input type="hidden" id="bmanID" value="${apply.bmanID}" >
				<input type="hidden" id="bmanName" value="${apply.bmanName}" >
				<input type="hidden" id="reviewManID" value="${apply.reviewManID}" >
				<input type="hidden" id="reviewManName" value="${apply.reviewManName}" >
				<%-- <input type="hidden" id="reviewManID" value="${apply.legalManID}" >
				<input type="hidden" id="reviewManName" value="${apply.legalManName}" > --%>
				<h5 style="margin-left:2em;">项目名称：
					<span class="grey sProjectName" ></span>
					<span style="margin-left:3em;">流程名称：</span>
					<span class="grey" >${product.productName}</span>
					<span style="margin-left:3em;">节点名称：</span>
					<span class="grey" >${productNode.nodeNames}</span>
				</h5>
				<div class="table-responsive">
					<table id="nodeTask_table" style="font-size:13px !important;"></table>
                </div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>提交</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">

/**
 *获取下拉框值;
 */
function getSelectText(v){
    var  selectID = v.id;
    var selectName = selectID.replace(/List/, "Name");
　    document.getElementById(selectName).value=v.options[v.options.selectedIndex].text;
};

</script>
					