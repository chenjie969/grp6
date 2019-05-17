<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	
<div class="page-content">
	<div class="page-header">
		<h4>指定A、B角</h4>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
           	<input type="hidden" id="taskName" value="${apply.taskName }">
           	<input type="hidden" id="type" value="${apply.type }">
           	<div class="editDiv">
				<form class="form-horizontal" role="form" id="form_setABman">
					<input type="hidden" name="apply_ID" id="apply_ID" value="${apply.apply_ID }">
					<div class="space-4"></div>
					<div class="form-group">
					   	<label class="col-sm-2 control-label no-padding-right" for="form-input">指定A角： </label>
					   	<div class="col-sm-10">
					        <div class="col-sm-4 input-group selectAman">
								<input  type="text"  class="form-control validate[required]" autoField="amanID" dataValue="${apply.amanID }"  id="selectAman" value="${apply.amanName }" name="amanName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
	      				</div>
					<div class="space-4"></div>
					<div class="form-group">
					   	<label class="col-sm-2 control-label no-padding-right" for="form-input">指定B角： </label>
					   	<div class="col-sm-10">
					        <div class="col-sm-4 input-group selectBman">
								<input  type="text"  class="form-control validate[required]" autoField="bmanID"  dataValue="${apply.bmanID }"  id="selectBman" value="${apply.bmanName }" name="bmanName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
	      				</div>
				</form>
           	</div>
           	
			<div class="form-group col-xs-12" style="height:20px"></div>
			
           	<div class="viewDiv">
           		<form class="form-horizontal">
           			<div class="form-group">
           				<label class="col-sm-2 control-label no-padding-right">项目A角：</label>
						<label class="col-sm-2 no-padding-right grey">${apply.amanName }</label>
           			</div>
           			<div class="form-group">
           				<label class="col-sm-2 control-label no-padding-right">项目B角：</label>
						<label class="col-sm-2 no-padding-right grey">${apply.bmanName }</label>
           			</div>
           		</form>
           	</div>
				
		</div><!-- /.col -->
	</div><!-- /.row -->
	<div class="space-20"></div>
	<!-- 保存按纽 -->
	<div class="clearfix form-actions editDiv">
		<div class="col-sm-offset-2 col-sm-10">
			<button class="btn btn-primary" type="button" id="btn_submit">
				<i class="icon-ok bigger-110"></i>保存
			</button>
			&nbsp; &nbsp; &nbsp;
			<button class="btn btn-default btn_close" type="button">
				<i class="icon-remove bigger-110"></i>关闭
			</button>
		</div>
	</div>
	
	<div class="clearfix form-actions viewDiv">
		<div class="col-sm-offset-2 col-sm-10">
			<button class="btn btn-default btn_close" type="button">
				<i class="icon-remove bigger-110"></i>关闭
			</button>
		</div>
	</div>
</div><!-- /.page-content -->

<script type="text/javascript">
$(function () {
	
	var type = $("#type").val();

	$(".btn_close").click(function(){
		window.parent.closeMenu($("#taskName").val()+$("#apply_ID").val());
	});
	
	if(type=="edit"){
		$(".editDiv").show();
		$(".viewDiv").hide();
		
		/*获取部门用户下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectAman").selectTreeWidgets({
					width : "33%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				$("#selectBman").selectTreeWidgets({
					width : "33%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		
		$("#btn_submit").click(function(){
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_setABman"});
			tool.disabled("#btn_submit");
			var queryContainer_form = $("#form_setABman");
			if(queryContainer_form.validationEngine("validate")){
				$.ajax({type:'POST',url:"/project/apply/updateApplySetABMan",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj){	//保存成功，关闭页面
							window.parent.closeMenu($("#taskName").val()+$("#apply_ID").val());
						}else{
							alert("保存失败");
							tool.undisabled("#btn_submit");
						}
					}
				});
			}else{
				tool.undisabled("#btn_submit");
			}
		});
	}else if(type=="view"){
		$(".editDiv").hide();
		$(".viewDiv").show();
	}
});
</script>

	