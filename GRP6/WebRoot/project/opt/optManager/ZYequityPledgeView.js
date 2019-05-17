(function($){
	$.ZYequityPledgeEdit={
			initTable:initTable, //初始化股权信息
			isOtherStock:isOtherStock, // 是否其他公司股权
			chooseStock:chooseStock, // 选择股权所在企业
			addStock:addStock // 添加 股权所在企业
	}
	
	/**
	 *初始化股权信息 
	 */
	function initTable(client_ID){
		$.zjm_stockMessage.initStockMessageTable(client_ID);
	}
	
	/**
	 * 是否其他公司股权
	 */
	function isOtherStock(radioValue){
		if(radioValue == 1){
			$("#btnDIV").show();
			$(".legalPersonInput").val("");
			$.zjm_stockMessage.initStockMessageTable("");
		}else{
			$.zjm_stockMessage.initStockMessageTable("");
			$("#btnDIV").hide();
		}
	}
	
	/**
	 * 选择股权所在企业
	 */
	function chooseStock(){
		$("#relationMainOrCompanyList").modal({keyboard:true});
		$.zjm_optAdd.initOwnerTypeTable(); //企业
		$("#selectListLabel").text("选择股权所在公司");
		$("#btn_listOK").click(function(){	//弹出列表点击确定，将选中的企业名称填入以下几个位置：	
			var selectContent = $("#table_relationMainOrCompany").bootstrapTable('getSelections');
			if(selectContent.length != 1){
				$("#pleaseSelectOne").modal({keyboard:true});
			}else{
					$("#relationMainOrCompanyList").modal("hide");
					console.info(selectContent[0]);
					$(".otherOwner").val(selectContent[0].clientName);	//股权所在企业全称
					$(".otherType").val(selectContent[0].clientTypeID);// 1.权属人类型： 01 企业 ，02 、03 个人
					$(".otherOwnerID").val(selectContent[0].client_ID);//4. 权属人id
					$(".otherCreditCode").val(selectContent[0].certificateCode);//2. 统一社会信用码
					$(".otherLegalPerson").val(selectContent[0].legalPerson); //法定代表人
					$(".otherLegalPhone").val(selectContent[0].phoneOne); //法人联系方式
					$(".otherLegalAddress").val(selectContent[0].workAddress); //住所 (法人住所) 
					$(".otherPostCode").val(selectContent[0].zipCode); //邮编
					$(".otherFax").val(selectContent[0].fax); //传真
					$("#clientIDText").text(selectContent[0].client_ID);
					$(".client_ID").val(selectContent[0].client_ID);
				
					$.ZYequityPledgeEdit.initTable(selectContent[0].client_ID);
				}
			});
		$("#relationMainOrCompanyList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $("#btn_listOK").unbind("click");
		});
	}
	
	/**
	 *  添加 股权所在企业
	 */
	function addStock(){
		$("#myModalLabel").text("添加公司信息");
		alert("3333");
		$("#ZYequityPledgeEdit_page").load("/optGuarantyAction/chooseProjectPage?t="+Math.random(),{"flag":"01"},function(){
			$("#companyOwnerAdd").modal({keybord:true});
			$(".btn_submit").click(function(){
				zjm.init();
				/** 注册编辑验证引擎 */
				zjm.validata({ formId : "form_company" });
				if ($("#form_company").validationEngine("validate")) {
					var jsonObj = $("#form_company").serializeJson();
					var formData= JSON.stringify(jsonObj);
					if(!zjm.ajaxValidata("clientName","/selectAddClientNameIsExist",formData,"权属人名称重复！")){
						return false;
					}
					
					$.ajax({ 
						type : 'POST',
						url : "/insertOneClientInfo",
						data : formData,
						async : false,
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							$("#companyOwnerAdd").modal("hide");
							var selectContent = data.obj;
							console.info("data.obj",data.obj);
							$("input[name='otherOwner']").val(selectContent.clientName);	//页面显示权属人名称
							$("input[name='otherType']").val(selectContent.clientTypeID);//
							$("input[name='clientTypeID']").val(selectContent.client_ID);//4. 企业id
							$("input[name='otherCreditCode']").val(selectContent.certificateCode);//2. 统一社会信用码
							$("input[name='otherLegalPerson']").val(selectContent.legalPerson); //法定代表人
							$("input[name='otherLegalPhone']").val(selectContent.phoneOne); //法人联系方式
							$("input[name='otherLegalAddress']").val(selectContent.workAddress); //住所 (法人住所) 
							$("input[name='otherPostCode']").val(selectContent.zipCode); //邮编
							$("input[name='otherFax']").val(selectContent.fax); //传真
							$("#clientIDText").text(selectContent.client_ID);
							$(".client_ID").val(selectContent.client_ID);
						
							$.ZYequityPledgeEdit.initTable(selectContent.client_ID);
						}
					});
				}	
			})
			
		})
		$("#companyOwnerAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	
	
	
})(jQuery)


$(function(){
	/**
	 * 初始化的时候执行
	 */
	var client_ID=$("#clientIDText").text();
	$.ZYequityPledgeEdit.initTable(client_ID);
	
	/**
	 *  是否其他公司股权
	 */
	$(".isCompanyStock").change(function(){
		var radioValue=$("input[name='isCompanyStock']:checked").val();
		$.ZYequityPledgeEdit.isOtherStock(radioValue);
	})
	
	/**
	 *  选择股权所在企业
	 */
	$("#btn_ChooseOwnerType").click(function(){
		$.ZYequityPledgeEdit.chooseStock();
	})
	
	/**
	 *  添加 股权所在企业
	 */
	$("#btn_addStock").click(function(){
		$.ZYequityPledgeEdit.addStock();
	})
	
	
})