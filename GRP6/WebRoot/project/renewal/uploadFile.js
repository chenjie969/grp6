(function($,z){
	$.zjm_planLoanAndPay = {
	//	autoAddPlanPay:autoAddPlanPay
			delFiles:delFiles//删除附件
	};
	
	
	
	//删除附件
	function delFiles(projectFiles_ID){
//	    $("#pictureFileDelModule").modal({keyboard: true});
//	    $(".btn_submit").click(function () {
//	        tool.disabled(".btn_submit");
	        $.ajax({
	            type: 'POST',
	            url: '/pro/contractdoc/deleteOneInfoByProFiles_ID',
	            data: {"projectFiles_ID":projectFiles_ID},
	            dataType: 'json',
	            success: function (data) {
	                if (data.obj) {
	                    tool.undisabled(".btn_submit");
	                    $("#pictureFileDelModule").modal("hide");
	                  
	                	window.location.reload();
	                } else {
	                    alert("删除失败！");
	                    tool.undisabled(".btn_submit");
	                }
	            }
	        });
//	    });
	    $("#pictureFileDelModule").on("hidden.bs.modal", function (e) {//解除事件绑定
	        $(".btn_submit").unbind("click");
	    });
	
	}
	/**
	 * 自动生成还款计划
	 */
	function autoAddPlanPay(loanPlan_ID){
		var apply_ID = $("#hidden_applyID").val();
		$("#page_planLoanAndPay").load("/project/loanPlan/showAutoAddPlanPayPage",{"loanPlan_ID":loanPlan_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#planPayAutoAdd").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_planPayAutoAdd"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_planPayAutoAdd");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({
						type: "post", 
						url: "/project/loanPlan/autoAddValidata",	//自动添加还款计划时校验,如果通过,后台继续生成还款计划,不再继续发送请求
						contentType:'application/json; charset=UTF-8',
						dataType: 'json',
						data:JSON.stringify(queryContainer_form.serializeJson()),
						cache:false, 
						async:false, 
						success: function(resultdata){ 
							if(resultdata.obj.validata){	//验证通过, 继续判断是否保存成功
								if(resultdata.obj.save){
									$("#planPayAutoAdd").modal("hide");
									window.location.reload();
								}else{
									alert("保存失败！");
									tool.undisabled("#btn_submit");
								}
							}else{	//验证失败, 显示错误提示信息
								var fieldID = resultdata.obj.fieldID;
								var errorInfo = resultdata.obj.errorInfo;
								$("#"+fieldID).validationEngine("showPrompt",errorInfo,"error");
								tool.undisabled("#btn_submit");
							}
						} 
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#planPayAutoAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 生成《委托担保申请书》、填写反担保措施管理
	 */
	$(".btn_addIntentionLetter").click(function(){
		var applyID = $("#hidden_applyID").val();
		$("#page_intentionLetter").load("/project/delay/showMouldTypePage",{"fileType":"03","applyID":applyID},function(response,status,xhr){
			$("#selectMouldType").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_selectMouldType"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_selectMouldType");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/renewal/generateDocumentTwo",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#selectMouldType").modal("hide");
								window.location.reload();
								alert("生成成功！");
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#selectMouldType").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 删除一条担保意向函
	 */
//	$("btn_addIntentionLetter1").click(function(){
//		var entityID = $(this).attr("data-entityID");
//		$("#common_del").modal({keyboard:true});
//		$("#delModalLabel").text("删除提示");
//		$("#delMessage").text("是否删除此担保意向函？");
//		tool.undisabled(".btn_submit");
//		$(".btn_submit").click(function(){
//				tool.disabled(".btn_submit");
//				$.ajax({type:'POST',url:"/project/intentionLetter/deleteOneIntentionLetter",data:JSON.stringify({"intentionLetter_ID":entityID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
//		        	if(data.obj){
//						$("#common_del").modal("hide");
//						window.location.reload();
//					}else{
//						alert("删除失败！");
//						tool.undisabled(".btn_submit");
//					}
//		        }
//			});
//		});
//		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
//			$(".btn_submit").unbind("click");
//		});
//	});
	/**
	 *   生成经理办公会评议项目情况简表（Ⅰ/Ⅱ）
	 */
	$("#btn_addIntentionLetter3").click(function(){
		var flowID = $("#hidden_flowID").val();
		var applyID = $("#hidden_applyID").val();
//		$("#btn_addIntentionLetter3").click(function(){
//				tool.disabled("btn_addIntentionLetter3");
//				window.location.href="/project/renewal/manageReviewExport?applyID="+applyID+"&flowID="+flowID;
				$.ajax({
					type:'POST',
					url:"/project/renewal/manageReviewExport",
					data:JSON.stringify({"entityID":applyID,"flowID":flowID}),
					contentType:'application/json; charset=UTF-8',
			        dataType: 'json',
					success:function(data) {
						if(data.obj){
							window.location.reload();
						}else{
							alert("删除失败！");
							tool.undisabled("btn_addIntentionLetter3");
						}
					}
			});
		//});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
	/**
	 *   生成《拟推荐上会项目清单（Ⅰ/Ⅱ）》
	 */
	$("#btn_addIntentionLetter2").click(function(){
		var flowID = $("#hidden_flowID").val();
		var applyID = $("#hidden_applyID").val();
//		$("#btn_addIntentionLetter2").click(function(){
				//tool.disabled("btn_addIntentionLetter2");
				//window.location.href="/project/renewal/meetingExport?applyID="+applyID;
				$.ajax({
					type:'POST',
					url:"/project/renewal/meetingExport",
					data:JSON.stringify({"entityID":applyID,"flowID":flowID}),
					contentType:'application/json; charset=UTF-8',
			        dataType: 'json',
					success:function(data) {
						if(data.obj){
//							$("#common_del").modal("hide");
							window.location.reload();
						}else{
							alert("删除失败！");
							tool.undisabled("btn_addIntentionLetter2");
						}
		        }
			});
		//});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
	
	/**
	 *   生成项目评议委员会评审通过项目情况简表(Ⅰ)
	 */
	$("#btn_addIntentionLetter4").click(function(){
		var flowID = $("#hidden_flowID").val();
		var applyID = $("#hidden_applyID").val();
//		$("#btn_addIntentionLetter4").click(function(){
//				tool.disabled("btn_addIntentionLetter4");
//				window.location.href="/project/renewal/reviewCommitteeExport?applyID="+applyID+"&flowID="+flowID;
				$.ajax({
					type:'POST',
					url:"/project/renewal/reviewCommitteeExport",
					data:JSON.stringify({"entityID":applyID,"flowID":flowID}),
					contentType:'application/json; charset=UTF-8',
			        dataType: 'json',
					success:function(data) {
						if(data.obj){
//							$("#common_del").modal("hide");
							window.location.reload();
						}else{
							alert("删除失败！");
							tool.undisabled("btn_addIntentionLetter4");
						}
		        }
			});
//		});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
	
	/**
	 * 提交申请
	 *//*
	$(".btn_startProcess").click(function(){
		var intentionLetter_ID = $(this).attr("data-entityID");
		var meetingDetail_ID = $(this).attr("data-meetingDetailID");
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").text("确认使用此担保意向函发起一个子流程吗？");
		$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:"/project/intentionLetter/updateStatus",contentType:'application/json; charset=UTF-8',dataType:'json',
						data:JSON.stringify({"intentionLetter_ID":intentionLetter_ID,"meetingDetail_ID":meetingDetail_ID,"status":"待审批"}),success:function(data) {
		        	if(data.obj){
						$("#common_del").modal("hide");
						window.location.reload();
					}else{
						alert("提交申请失败！");
						tool.undisabled(".btn_submit");
					}
		        }
			});
		});
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});*/
	
	
	 //加载续保续贷相关附件
    function reloadAttachment(fileType){
    	console.log("1122211");
    	var applyID = $("#hidden_applyID").val();
    	console.log(fileType);
    	console.log(applyID);
    	//var fileType="003";
    	console.log("data-"+fileType);
        $.get("/project/renewal/showManageReviewExportPage?fileType="+fileType+"&entityID=" + applyID, function (data) {
            $("#attachmentsDIV").empty();
            if (data.obj) {
            	var i = 0;
            	var aHref;
                $.each(data.obj, function (k, v) {
                	i++;
                	if ("docx" == v.extend || v.extend ==  'doc' || v.extend ==  'pdf' || v.extend ==  'xlsx' || v.extend ==  'xls' || v.extend ==  'ppt' || v.extend ==  'pptx') {
                		aHref = ["<div id='" + v.projectFiles_ID + "DIV'>"
                			+i+"、"+
            				"<a href='javascript:void(0)' onclick='window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref=+"+v.pathFile+"&domextend="+v.extend+"\')'>" + v.sourceFileName + "</a>",
        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        					"<a href='javascript:void(0)' onclick='window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName=+"+v.sourceFileName+"&filePath="+v.pathFile+"\')'>下载</a>",
        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        					"<a href='javascript:void(0)' onclick='$.zjm_renewalFiles.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
                        "<br/><div>"].join('');
					}else{
						aHref = ["<div id='" + v.projectFiles_ID + "DIV'>"
                			+i+"、"+
        					"<a href='javascript:void(0)' onclick='window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName=+"+v.sourceFileName+"&filePath="+v.pathFile+"\')'>" + v.sourceFileName + "</a>",
        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        					"<a href='javascript:void(0)' onclick='$.zjm_renewalFiles.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
                        "<br/><div>"].join('');
					}
                    $("#attachmentsDIV").append(aHref);
                })
            
            }
        })
    }
});

