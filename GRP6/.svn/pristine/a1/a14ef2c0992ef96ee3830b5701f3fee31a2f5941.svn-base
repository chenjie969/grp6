

function appendToolBarToContainer(container,docuModel){
	if(docuModel === "edit"){
		//工具栏操作按钮
		container.append(createrToolBarButton(container));
		//文件操作按钮
		container.append(createrFileTitleButton());
		//关闭文件 按钮
		container.append(createrCloseFileButton());
		//保存文件按钮
		container.append(createrFileSaveButton());
		//历史版本
		//container.append(createrHistoryButton());
		//页面设置
		container.append(createrPageSetButton());
		//打印
		container.append(createrPrintButton());
		//操作日志
		//container.append(createrLogButton());
		container.append(createrFileEditButton());
		container.append(createrSaveMarkButton());
		container.append(createrNotSaveMarkButton());
		container.append(createrShowMarkButton());
		container.append(createrHideMarkButton());
		//文件套红
		container.append(createrFileRedPrintingButton(container));
		//container.append(createrInsertPictureButton());
		//container.append(createrDigitalButton());
		//container.append(createrDigitalSignetButton());
		//container.append(createrFullWriteButton());
		//container.append(createrFullSketchButton());
		//container.append(createrInsertWriteButton());
		//container.append(createrInsertSignetButton());
		//container.append(createrInsertSignetToServiceButton());
		
		//container.append(createrFileSaveButton);
	}
	if(docuModel === "view"){
//		container.parent().hide();
		//工具栏操作按钮
		container.append(createrToolBarButton(container));
		//文件操作按钮
		container.append(createrFileTitleButton());
		//关闭文件(查看页面) 按钮
		container.append(createrCloseFileButtonForView());
		//页面设置
		container.append(createrPageSetButton());
		//打印
		container.append(createrPrintButton());
	}
}



/**
 * 创建按钮的容器
 * @returns
 */
function createButtonContainer(parameter){
	var defaultParmeter = {
		"class" : "navItem"	
	}
	defaultParmeter = $.extend(defaultParmeter,parameter);
	return $("<li>",defaultParmeter);
}

/**
 * 创建a标签
 * @param parameter
 * @returns
 */
function createATag(parameter){
	var defaultParmeter = {
		"href" : "javascript:void(0);",
		"class" : "navItem_a"	
	}
	defaultParmeter = $.extend(defaultParmeter,parameter);
	return $("<a>",defaultParmeter);
}

/**
 * 创建一个  折叠 工具栏 按钮 按钮
 */
function createrToolBarButton(container){
	var btn_a = createATag({
					"text" : "<<隐藏常用操作",
					"href" : "javascript:void(0);",
					"style" : "font-weight: bold;",
					"click" : function(e){
						container.parent().hide().append(createrShowToolBarButton(container)).css("width","25px").show();
						container.hide();
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  显示工具栏 按钮
 */
function createrShowToolBarButton(container){
	var btn_a = createATag({
					"text" : "",
					"href" : "javascript:void(0);",
					"style" : "font-weight: bold;",
					"click" : function(){
						$("#btn_ToolBarShow").remove();
						container.parent().css("width","110px").show();
						container.show();
					}
				});
	btn_a.html(">><br/>显<br/>示<br/>常<br/>用<br/>操<br/>作");
	return createButtonContainer({
		"id" : "btn_ToolBarShow"
	}).append(btn_a);
}



/**
 * 创建一个  文件操作 按钮
 */
function createrFileTitleButton(){
	var btn_a = createATag({
					"text" : "文件操作",
					"href" : "javascript:void(0);",
					"style" : "font-weight: bold;"
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  关闭文件 按钮
 */
function createrCloseFileButton(){
	var btn_a = createATag({
					"text" : "关闭文件",
					"href" : "javascript:void(0);",
					"click" : function(e){
						closeFile();
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  关闭文件(查看页面) 按钮
 */
function createrCloseFileButtonForView(){
	var btn_a = createATag({
					"text" : "关闭文件",
					"href" : "javascript:void(0);",
					"click" : function(e){
						window.close();
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  保存文件 按钮
 */
function createrFileSaveButton(){
	var btn_a = createATag({
					"text" : "保存文件",
					"href" : "javascript:void(0);",
					"click" : function(e){
						saveFileToUrl();
					}
				});
	return createButtonContainer().append(btn_a);
}


/**
 * 创建一个  历史版本 按钮
 */
function createrHistoryButton(){
	var btn_a = createATag({
					"text" : "历史版本",
					"href" : "javascript:void(0);",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}


/**
 * 创建一个  页面设置 按钮
 */
function createrPageSetButton(){
	var btn_a = createATag({
					"text" : "页面设置",
					"href" : "javascript:void(0);",
					"click" : function(e){
						pageSet();
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  打印 按钮
 */
function createrPrintButton(){
	var btn_a = createATag({
					"text" : "打印",
					"href" : "javascript:void(0);",
					"click" : function(e){
						printDoc();
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  操作日志 按钮
 */
function createrLogButton(){
	var btn_a = createATag({
					"text" : "操作日志",
					"href" : "javascript:void(0);",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  文件编辑 按钮
 */
function createrFileEditButton(){
	var btn_a = createATag({
					"text" : "文件编辑",
					"href" : "javascript:void(0);",
					"style" : "font-weight: bold;"
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  保留痕迹 按钮
 */
function createrSaveMarkButton(){
	var btn_a = createATag({
					"text" : "保留痕迹",
					"href" : "javascript:void(0);",
					"click" : function(e){
						TANGER_OCX_SetReviewMode(true);
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  不留痕迹 按钮
 */
function createrNotSaveMarkButton(){
	var btn_a = createATag({
					"text" : "不留痕迹",
					"href" : "javascript:void(0);",
					"click" : function(e){
						TANGER_OCX_SetReviewMode(false);
					}
				});
	return createButtonContainer().append(btn_a);
}


/**
 * 创建一个  显示痕迹 按钮
 */
function createrShowMarkButton(){
	var btn_a = createATag({
					"text" : "显示痕迹",
					"href" : "javascript:void(0);",
					"click" : function(e){
						TANGER_OCX_ShowRevisions(true);
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  隐藏痕迹 按钮
 */
function createrHideMarkButton(){
	var btn_a = createATag({
					"text" : "隐藏痕迹",
					"href" : "javascript:void(0);",
					"click" : function(e){
						TANGER_OCX_ShowRevisions(false);
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  文件套红 按钮
 */
function createrFileRedPrintingButton(container){
	var btn_a = createATag({
					"text" : "文件套红",
					"href" : "javascript:void(0);",
					"click" : function(e){
//						TANGER_OCX_DoPaiBan("http://127.0.0.1:88/unitdata/unit_1/accessory/o_19mcqm3o11ufh1ndp1v5k1ounkdnb.docx?v=1");
//						TANGER_OCX_DoPaiBan("http://127.0.0.1:88/unitdata/unit_1/accessory/default.docx?v=123");
//						TANGER_OCX_DoPaiBan("http://127.0.0.1:88//unitdata/unit_1/accessory/o_19mel2jdr1mi1eiamr515h58adb.docx")
						createrFileRedSelectPage(container);
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  插入图片 按钮
 */
function createrInsertPictureButton(){
	var btn_a = createATag({
					"text" : "插入图片",
					"href" : "javascript:void(0);",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  电子认证 按钮
 */
function createrDigitalButton(){
	var btn_a = createATag({
					"text" : "电子认证",
					"href" : "javascript:void(0);",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  验证签名及印章 按钮
 */
function createrDigitalSignetButton(){
	var btn_a = createATag({
					"text" : "验证签名及印章",
					"href" : "javascript:void(0);",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  全屏手写签名 按钮
 */
function createrFullWriteButton(){
	var btn_a = createATag({
					"text" : "全屏手写签名",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  全屏手工绘图 按钮
 */
function createrFullSketchButton(){
	var btn_a = createATag({
					"text" : "全屏手工绘图",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  插入手写签名 按钮
 */
function createrInsertWriteButton(){
	var btn_a = createATag({
					"text" : "插入手写签名",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  插入手工绘图 按钮
 */
function createrInsertSketchButton(){
	var btn_a = createATag({
					"text" : "插入手工绘图",
					"click" : function(e){
						
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  加盖电子印章 按钮
 */
function createrInsertSignetButton(){
	var btn_a = createATag({
					"text" : "加盖电子印章",
					"click" : function(e){
						AddSignFromLocal("-5936309161");
					}
				});
	return createButtonContainer().append(btn_a);
}

/**
 * 创建一个  加盖电子印章(从服务器) 按钮
 */
function createrInsertSignetToServiceButton(){
	var btn_a = createATag({
					"text" : "",
					"click" : function(e){
						alert("ok >>> 加盖电子印章(从服务器) ");
					}
				});
	btn_a.html("加盖电子印章<br>(从服务器)");
	return createButtonContainer().append(btn_a);
}

//***************************************************************
// 创建选择页面  begin
//***************************************************************

/**
 * 创建套红模板选择界面
 */
function createrFileRedSelectPage(container){
	window.showModalDialog(
			"/oa/window_returnReadFileList.action",
			window,
			"dialogHeight: 300px; dialogWidth:600px; dialogTop: 200px; dialogLeft: 166px; edge: Raised;center: Yes; help: Yes; resizable: Yes; status: Yes;"
			);
	
//	createrOfficeSelectPage("selectReadFileTemplate").load(
//		"/oa/window_returnReadFileList.action",
//		{},
//		function(response,status,xhr){
//			document.getElementById("selectReadFileTemplate").innerHTML = response;
//			/**
//			 * 注册编辑页面弹出事件
//			 */
//			var dialogMe = tool.dialog({
//				title:"选择套红模板",
//				showid:"selectReadFileTemplate",
//				width:"600"
//			});
//			
//			$("input[name='annexID']:radio").click(function(e){
//				var me = $(e.target);
//				var annexURL = me.val();
//				dialogMe.dialog("close");
//				TANGER_OCX_DoPaiBan(annexURL);
//			});
//			
//		}
//	);
}

/**
 * 创建选择页面的容器
 * @param nodeID
 * @returns
 */
function createrOfficeSelectPage(nodeID){
	var selecContainertPage = $("<div>",{
		"id" : nodeID,
		"style" : "display:none;"
	});
	if($("#" + nodeID).length <= 0 ){
		$("body").append(selecContainertPage);
	}
	return selecContainertPage;
}

/**
 * 替换其他标签
 * @returns
 */
function markOtherInfo(){
	$.post(
		"/oa/loadOaDocInfo.action",
		{
			"cgsDocs.docuid" : $("#customToolBar").attr("data-oadocuid")
		},
		function(data){
			//console.log(data);
			//发文编号
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("faWenBianHao")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("faWenBianHao").Range.Text = data.docbh;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("faWenBianHao").Range.Text = "";
				}
			}
			//签发人
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("qianFaRen")) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("qianFaRen").Range.Text = "";
			}
			//当前日期(大写)
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("curDateUpper")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("curDateUpper").Range.Text = getCurDateUpper();
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("curDateUpper").Range.Text = "";
				}
			}
			//主题词
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("zhuTiCi")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("zhuTiCi").Range.Text = data.mainword;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("zhuTiCi").Range.Text = "";
				}
			}
			//抄送
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("chaoSong")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("chaoSong").Range.Text = data.othersenddepart;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("chaoSong").Range.Text = "";
				}
			}
			//当前日期(数字)
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("curDateSmall")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("curDateSmall").Range.Text = getCurDateSmall();
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("curDateSmall").Range.Text = "";
				}
			}
			//份数
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("fenShu")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("fenShu").Range.Text = data.copynum;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("fenShu").Range.Text = "1";
				}
			}
			//部门
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("buMen")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("buMen").Range.Text = data.departName;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("buMen").Range.Text = "";
				}
			}
			//发送部门
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("faSongBuMen")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("faSongBuMen").Range.Text = data.departName;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("faSongBuMen").Range.Text = "";
				}
			}
			//当前年份
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("curYear")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("curYear").Range.Text = getCurYear() + "年";
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("curYear").Range.Text = "";
				}
			}
			//主送
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("zhuSong")) {
				try {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("zhuSong").Range.Text = data.mainsenddepart;
				} catch (e) {
					TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("zhuSong").Range.Text = "";
				}
			}
			/*//抄报
			if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists("chaoBao")) {
				TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item("chaoBao").Range.Text = data.othermainsenddepart;
			}*/
			
		}
	);
	
}

/**
 * 将当前日期转换为大写
 * @returns {String}
 */
function getCurDateUpper(){
	var today=new Date();  
    var chinese = ['〇', '一', '二', '三', '四', '五', '六', '七', '八', '九'];  
    var y = today.getFullYear().toString();  
    var m = (today.getMonth()+1).toString();  
    var d = today.getDate().toString();  
    var result = "";  
    for (var i = 0; i < y.length; i++) {  
        result += chinese[y.charAt(i)];  
    }  
    result += "年";  
    if (m.length == 2){  
        if (m.charAt(0) == "1"){  
            result += ("十" + chinese[m.charAt(1)] + "月");  
        }  
    }else{  
        result += (chinese[m.charAt(0)] + "月");  
    }
    if(d.length == 2) {  
        result += (chinese[d.charAt(0)] + "十" + chinese[d.charAt(1)] + "日");  
    }else{  
        result += (chinese[d.charAt(0)] + "日");  
    } 
    return result;
}

/**
 * 获取当前日期数字小写的
 */
function getCurDateSmall(){
	var d = new Date(); 
	var y = d.getFullYear(); //获取当前年份 
	var m = d.getMonth()+1; //获取当前月份（0——11） 
	var t = d.getDate(); //日
	return y + "年" + m + "月" + t + "日";
}

/**
 * 获取当前年份
 */
function getCurYear(){
	var d = new Date(); 
	var y = d.getFullYear(); //获取当前年份 
	return y;
}

//***************************************************************
//创建选择页面  end
//***************************************************************

