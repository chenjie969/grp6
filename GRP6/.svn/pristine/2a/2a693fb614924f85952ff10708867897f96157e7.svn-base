(function($,z){
	$.zjm_proDelay = {
		proDelayAdd:proDelayAdd,  //展期
		proDelayEdit:proDelayEdit, //修改
		proDelayDel:proDelayDel //删除
	};
	
	//展期
	function proDelayAdd(project_ID,loadSum){
		$("#proDelay_page").load("/project/delay/showProDelayAddPage",{"project_ID":project_ID},function(response,status,xhr){
			$("#addProDelay").modal({keyboard:true});
			$.get("/project/loan/getAttachments?entityID=" + project_ID, function (data) {
                $("#attachmentsDIV").empty();
                if (data.obj) {
                    $.each(data.obj, function (k, v) {
                        var aHref = ["<div id='" + v.projectFiles_ID + "DIV'><a href='" + v.pathFile + "' target='_blank'>" + v.sourceFileName + "</a>",
                            '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                            "<a href='javascript:void(0)' onclick='$.zjm_loanAttachment.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
                            "<br/><div>"].join('');
                        $("#attachmentsDIV").append(aHref);
                    })
                }
            });
            
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addProDelay_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				var delaySum_add = isOrNotNull($("#delaySum_add").val());
				var isZreo = parseFloat(loadSum) - parseFloat(delaySum_add);
				if(isZreo<0){
					alert("放款余额必须大于或等于展期本金！");
					return;
				}
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addProDelay_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/delay/addOneDelayInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addProDelay").modal("hide");
										window.location.reload();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addProDelay").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//修改
	function proDelayEdit(delay_ID,loadSum){
		$("#proDelay_page").load("/project/delay/showProDelayEditPage",{"delay_ID":delay_ID},function(response,status,xhr){
			$("#editProDelay").modal({keyboard:true});
			
			$.get("/project/loan/getAttachments?entityID=" + $("#projectID").val(), function (data) {
		        $("#attachmentsDIV").empty();
		        if (data.obj) {
		            $.each(data.obj, function (k, v) {
		                var aHref = ["<div id='" + v.projectFiles_ID + "DIV'><a href='" + v.pathFile + "' target='_blank'>" + v.sourceFileName + "</a>",
		                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
		                    "<a href='javascript:void(0)' onclick='$.zjm_loanAttachment.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
		                    "<br/><div>"].join('');
		                $("#attachmentsDIV").append(aHref);
		            })
		        }
		    });
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"editProDelay_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				var delaySum_edit = isOrNotNull($("#delaySum_edit").val());
				var isZreo = parseFloat(loadSum) - parseFloat(delaySum_edit);
				if(isZreo<0){
					alert("放款余额必须大于或等于展期本金！");
					return;
				}
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#editProDelay_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/delay/updateProDelay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#editProDelay").modal("hide");
										window.location.reload();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editProDelay").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//删除
	function proDelayDel(delay_ID){
		$("#proDelay_page").load("/project/delay/showProDelayDelPage",{},function(response,status,xhr){
			$("#delProDelay").modal({keyboard:true});
			
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/delay/delProDelay',data:JSON.stringify({"delay_ID":delay_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delProDelay").modal("hide");
							//$.zjm_dicNode.initTable();
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delProDelay").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
	function isOrNotNull(str){
		if(str==null ||typeof(str)==undefined || str==''){
			str=0;
		}
		return parseFloat(str).toFixed(4);
	}
	
	
})(jQuery, this);

$(function () {
	//展期按钮
	/*$("#btn_proDelayAdd").click(function(){
		$.zjm_proDelayDaa.proDelayAdd();
	});
	//修改
	$("#btn_proDelayEdit").click(function(){
		$.zjm_proDelay.proDelayEdit();
	});
	//删除
	$("#btn_proDelayDel").click(function(){
		$.zjm_proDelay.proDelayDel();
	});*/
});
