var TANGER_OCX_OBJ;//控件对象
var IsFileOpened;      //控件是否打开文档
var fileType ;
var fileTypeSimple;
//var activeuser;//当前用户

var activeuser,domModel;


/**
 * 初始化 加载文档
 * @param fileUrl 文件路径
 * @param curUserName 当前用户名
 * @param domModel 文档模式 , 查看 : view 编辑 : edit
 */
function intializePage(fileUrl,curUserName,domModel)
{
	//设置当前文档操作人
	this.activeuser = curUserName;
	//设置当前文档模式 , 查看 还是 编辑
	this.domModel = domModel;
	//初始化控件对象
	initTANGER_OCX_OBJ();
	//初始化菜单
	initMenuStart(domModel);
	//初始化自定义工具栏
	initCustomToolBar(domModel);
	//打开文档
	NTKO_OCX_OpenDoc(fileUrl);
}

/**
 * 初始化控件对象
 */
function initTANGER_OCX_OBJ(){
	TANGER_OCX_OBJ = document.all("TANGER_OCX");
	TANGER_OCX_OBJ.AddDocTypePlugin(".pdf","PDF.NtkoDocument","4.0.0.2","ntkooledocall.cab",51,true);
}

/**
 * 打开文档
 * @param fileUrl 文件路径
 */
function NTKO_OCX_OpenDoc(fileUrl)
{
	var types = getFileDocumentTypeByUrl(fileUrl);
	if((types != null) && (types !== "")){
		TANGER_OCX_OBJ.BeginOpenFromURL(fileUrl,true,"",types);
	}else{
		TANGER_OCX_OBJ.BeginOpenFromURL(fileUrl);
	}
	
}

/**
 * 常用的ProgID有：
		Word文档：				“Word.Document”
		PowerPoint幻灯片：		“PowerPoint.Show”
		Excel工作表：				“Excel.Sheet”
		Excel图表： 				"Excel.Chart"
		Visio画图： 				"Visio.Drawing"
		MS Project项目：			"MSProject.Project"
		WPS2003文档：			"WPSFile.4.8001"
		WPS2005文档：			"WPS.Document"
		金山电子表2003：		"ET.Sheet.1.80.01.2001"
		金山电子表2005,2007：		"ET.WorkBook"

 * @param fileUrl
 */
function getFileDocumentTypeByUrl(fileUrl){
	var typeS = "";
	var typeArr = ["doc","docx","xls","xlsx","ppt","pptx"];
	for(type in typeArr){
		var typeItem = typeArr[type];
		if(fileUrl.indexOf("." + typeItem) > 0){
//			fileUrl.match(/src=\"([^\"]*)\"/)[1];
			if(typeItem === "doc" || typeItem === "docx"){
				typeS = "Word.Document";
			}else if(typeItem === "xls" || typeItem === "xlsx"){
				typeS = "Excel.Sheet";
			}else if(type === "ppt" || typeItem === "pptx"){
				typeS = "PowerPoint.Show";
			}else{
				
			}
		}
	}
	return typeS;
}

/**
 * 文档打开之后 的回调函数
 */
function documentOpened(){
	//saved属性用来判断文档是否被修改过,文档打开的时候设置成ture,当文档被修改,自动被设置为false,该属性由office提供.
	TANGER_OCX_OBJ.activeDocument.saved = true;
	
	//TANGER_OCX_OBJ.SetReadOnly(true,"");
	
	//TANGER_OCX_OBJ.ActiveDocument.Protect(1,true,"123");
	
	//获取文档控件中打开的文档的文档类型
	switch (TANGER_OCX_OBJ.doctype){
		case 1:
			fileType = "Word.Document";
			fileTypeSimple = "wrod";
			break;
		case 2:
			fileType = "Excel.Sheet";
			fileTypeSimple="excel";
			break;
		case 3:
			fileType = "PowerPoint.Show";
			fileTypeSimple = "ppt";
			break;
		case 4:
			fileType = "Visio.Drawing";
			break;
		case 5:
			fileType = "MSProject.Project";
			break;
		case 6:
			fileType = "WPS Doc";
			fileTypeSimple="wps";
			break;
		case 7:
			fileType = "Kingsoft Sheet";
			fileTypeSimple="et";
			break;
		default :
			fileType = "unkownfiletype";
			fileTypeSimple="unkownfiletype";
	}
	
	//初始化修订功能参数(修订的参数需要再文档加载完成之后设置)
	initMarkConfig(activeuser,domModel);
	//console.log(activeuser+ "  " +domModel);
//	alert("ondocumentopened成功回调     >>>  当文档打开时的回调");
}

/**
 * 初始化 菜单 状态
 * @param domModel 文档模式 查看还是编辑
 */
function initMenuStart(domModel){
	if(domModel === "view"){
		//设置只读
		setReadOnly(true); 
		//禁止新建功能
		setFileNewButton(false);
		//禁止打开
		setFileOpenButton(false);
		//禁止保存
		setFileSaveButton(false);
		//禁止另存为
		setFileSaveAsButton(false);
		//禁止标题栏
		setTitlebar(false);
		//菜单栏
		setMenubar(true);
		//状态栏
		setStatusbar(false);
		//工具栏
		setToolbars(false);
	}else if(domModel === "edit"){
		//设置只读
		setReadOnly(false); 
		//禁止新建功能
		setFileNewButton(false);
		//禁止打开
		setFileOpenButton(false);
		//禁止保存
		setFileSaveButton(true);
		//禁止另存为
		setFileSaveAsButton(false);
		//禁止标题栏
		setTitlebar(true);
		//菜单栏
		setMenubar(true);
		//状态栏
		setStatusbar(true);
		//工具栏
		setToolbars(true);
	}
	
}

/**
 * 设置文档状态, 只读 或者 可编辑
 * @param booleanVal (true : 只读(文档保护状态) ; false : 可编辑 )
 */
function setReadOnly(booleanVal){
	TANGER_OCX_OBJ.SetReadOnly (booleanVal,""); 
}

/**
 * 设置 文件 > 新建 功能
 * @param booleanVal
 */
function setFileNewButton(booleanVal){
	TANGER_OCX_OBJ.FileNew = booleanVal;
}

/**
 * 设置 文件 > 打开 功能 
 * @param booleanVal
 */
function setFileOpenButton(booleanVal){
	TANGER_OCX_OBJ.FileOpen = booleanVal;
}

/**
 * 设置 文件 > 保存 功能
 * @param booleanVal
 */
function setFileSaveButton(booleanVal){
	TANGER_OCX_OBJ.FileSave = booleanVal;
}

/**
 * 设置 文件 > 另存为 功能
 * @param booleanVal
 */
function setFileSaveAsButton(booleanVal){
	TANGER_OCX_OBJ.FileSaveAs = booleanVal;
}

/**
 * 设置 标题栏 功能
 * @param booleanVal
 */
function setTitlebar(booleanVal){
	TANGER_OCX_OBJ.Titlebar = booleanVal;
}

/**
 * 设置 菜单栏 功能
 * @param booleanVal
 */
function setMenubar(booleanVal){
	TANGER_OCX_OBJ.Menubar = booleanVal;
}

/**
 * 设置 状态栏 功能
 * @param booleanVal
 */
function setStatusbar(booleanVal){
	TANGER_OCX_OBJ.Statusbar = booleanVal;
}

/**
 * 设置 工具栏 功能
 * @param booleanVal
 */
function setToolbars(booleanVal){
	TANGER_OCX_OBJ.Toolbars = booleanVal;
}



/**
 * 初始化自定义工具栏
 * @param domModel 文档模式 查看还是编辑
 */
function initCustomToolBar(domModel){
	var customToolBar = $("#customToolBar");
	appendToolBarToContainer(customToolBar,domModel);
}






/**
 * 初始化修订功能参数
 * @param domModel 文档模式 查看还是编辑
 * @returns
 */
function initMarkConfig(curUserName,domModel){
	if(domModel === "view"){
		//设置修订开关 
		TANGER_OCX_SetReviewMode(false);
		//隐藏修改痕迹
		TANGER_OCX_ShowRevisions(false);
	}else if(domModel === "edit"){
		//设置修订开关 
		TANGER_OCX_SetReviewMode(true);
		//设置当前痕迹用户
		TANGER_OCX_SetDocUser(curUserName);
		//TODO 
		//进入或退出痕迹保留状态
		//TANGER_OCX_SetMarkModify(true);
		//隐藏修改痕迹
		TANGER_OCX_ShowRevisions(false);
	}else{
		
	}
}

/**
 * 打开或者关闭修订模式
 * @param boolvalue
 */
function TANGER_OCX_SetReviewMode(boolvalue)
{
	try{
		TANGER_OCX_OBJ.ActiveDocument.TrackRevisions = boolvalue;
	}catch(error){
		//console.log("打开或者关闭修订模式" + error);
	}
}

/**
 * 设置当前Office的用户名（痕迹的用户名)
 * @param cuser
 */
function TANGER_OCX_SetDocUser(curUserName){
	try{
		with(TANGER_OCX_OBJ.ActiveDocument.Application){
			UserName = curUserName;
		}
	}catch(error){
		//console.log("设置当前Office的用户名" + error);
	}
}

/**
 * 进入或退出痕迹保留状态，调用上面的两个函数
 * @param boolvalue
 */
function TANGER_OCX_SetMarkModify(boolvalue){
	TANGER_OCX_SetReviewMode(boolvalue);
	TANGER_OCX_EnableReviewBar(!boolvalue);
}

/**
 * 显示/不显示修订文字
 * @param boolvalue
 */
function TANGER_OCX_ShowRevisions(boolvalue){
	TANGER_OCX_OBJ.ActiveDocument.ShowRevisions = boolvalue;
}

/**
 * 允许或禁止显示修订工具栏和工具菜单（保护修订）
 * @param boolvalue
 */
function TANGER_OCX_EnableReviewBar(boolvalue){
	try{
		TANGER_OCX_OBJ.ActiveDocument.CommandBars("Reviewing").Enabled = boolvalue;
		TANGER_OCX_OBJ.ActiveDocument.CommandBars("Track Changes").Enabled = boolvalue;
		TANGER_OCX_OBJ.IsShowToolMenu = boolvalue;	//关闭或打开工具菜单
	}catch(error){
		//console.log("允许或禁止显示修订工具栏和工具菜单" + error);
	}
}


/**
 * 保存文档
 */
function saveFileToUrl(){
	var myUrl = document.getElementById("myForm").action ;
	//var fileName = document.getElementsByName("domname").value;
	var fileextend = $("#domextend").val();//tool.getUrlParam('domextend');//
	//$("#domhref").val(tool.getUrlParam('domhref'));
	//$("#domextend").val(tool.getUrlParam('domextend'));
	var saveformat;
	var result;
	if(!TANGER_OCX_OBJ.activeDocument.saved){
		switch (TANGER_OCX_OBJ.doctype){
			case 1:
				fileType = "Word.Document";
				break;
			case 2:
				fileType = "Excel.Sheet";
				break;
			case 3:
				fileType = "PowerPoint.Show";
				break;
			case 4:
				fileType = "Visio.Drawing";
				break;
			case 5:
				fileType = "MSProject.Project";
				break;
			case 6:
				fileType = "WPS Doc";
				break;
			case 7:
				fileType = "Kingsoft Sheet";
				break;
			default :
				fileType = "unkownfiletype";
		}
		
		//解决单元格出于激活状态时保存不了数据的问题 modified by lx 20100914
		var appName = new String(TANGER_OCX_OBJ.ActiveDocument.Application.Name);
		if ( (appName.toUpperCase()).indexOf("EXCEL") > -1) //EXCEL
		{
			TANGER_OCX_OBJ.Activedocument.ActiveSheet.select();
		}
		
		if(fileextend!="xls" && fileextend!="xlsx"){
			result = TANGER_OCX_OBJ.SaveToURL(
				myUrl,//提交到的url地址
				"fileStream",//文件域的id，类似<input type=file id=upLoadFile 中的id
				"",        //与控件一起提交的参数如："p1=a&p2=b&p3=c"
				"filename",    //上传文件的名称，类似<input type=file 的value
				"myForm"    //与控件一起提交的表单id，也可以是form的序列号，这里应该是0.
			);
		}else{
			if(fileextend=="xls"){
				saveformat=7;
			}
			if(fileextend=="xlsx"){
				saveformat=5;
			}
			result = TANGER_OCX_OBJ.SaveAsOtherFormatToURL(
				saveformat,
				myUrl,//提交到的url地址
				"fileStream",//文件域的id，类似<input type=file id=upLoadFile 中的id
				"",        //与控件一起提交的参数如："p1=a&p2=b&p3=c"
				"filename",    //上传文件的名称，类似<input type=file 的value
				"myForm"    //与控件一起提交的表单id，也可以是form的序列号，这里应该是0.
			);
		}
//		result=trim(result);
//		document.all("statusBar").innerHTML="服务器返回信息:"+result;
//		console.log("===="+result);
//		window.close();
		return result;
	}
}


/**
 * 页面关闭之前的事件
 */
function onPageClose(){
	if(!TANGER_OCX_OBJ.activeDocument.saved)
	{
		if(confirm( "文档修改过,还没有保存,是否需要保存?"))
		{
			var returnResault = saveFileToUrl();
			TANGER_OCX_OBJ.CancelLastCommand = true;
			//alert("文档保存成功!");
		}
	}
}

//设置页面布局
function pageSet(){
 	try{
 		
 		if(TANGER_OCX_OBJ.ActiveDocument != null){
 			TANGER_OCX_OBJ.ShowDialog(5); //设置页面布局
 		}
	}catch(err){
		//console.log(err);
		if(err.number!=-2147467260){
			//alert(td_lang.global.error + err.number + ":" + err.description);
		}
	}finally{
		
	}
}

//打印文档
function printDoc(){
	try{
		if(TANGER_OCX_OBJ.ActiveDocument != null){
			 TANGER_OCX_OBJ.printout(true);
		}
	}catch(err){
	   if(err.number!=-2147467260){
		   alert(td_lang.global.error + err.number + ":" + err.description);
	   }
	}finally{
		
	}
}

/**
 * 关闭文件
 * @returns {String}
 */
function closeFile(){
	if(!TANGER_OCX_OBJ.activeDocument.saved){
		if(confirm( "文档修改过,还没有保存,是否离开此页面?")){
			window.close();
		}
		//return "保存数据后再关闭!";
	}else{
		window.close();
	}
}

/**
 * 将 url 指定的模板文件插入到当前文档的头部(可用于简单的套红)
 * @param URL
 */
function TANGER_OCX_DoTaoHong(URL){
	try{
		TANGER_OCX_OBJ.ActiveDocument.Application.Selection.HomeKey(6);
		TANGER_OCX_OBJ.AddTemplateFromURL(URL);
	}catch(error){
		
	};
};



/**
 * 将当前编辑的文档插入到URL指定的模板文件的”BookMarkName”书签位置(可用于稍微复杂的套红)
 * @param URL
 */
function TANGER_OCX_DoPaiBan(URL,data){
	try{
		//选择对象当前文档的所有内容
		var curSel = TANGER_OCX_OBJ.ActiveDocument.Application.Selection;
		TANGER_OCX_SetMarkModify(false);
		curSel.WholeStory();
		curSel.Cut();
		//插入模板
//		TANGER_OCX_OBJ.AddTemplateFromURL(URL);
		TANGER_OCX_OBJ.AddTemplateFromURL(URL);
		if(browser == "IE")
		{
			OnAddTemplate("","","");
		}

	}catch(error){
			//alert("错误：" + err.number + ":" + err.description);
	};
}



function TANGER_OCX_DoPaiBanFuZa(URL1,URL2){
	try{
		TANGER_OCX_SetMarkModify(false);//暂时退出痕迹保留状态
		var doc = TANGER_OCX_OBJ.ActiveDocument;
		var curSel = doc.Application.Selection;
		curSel.HomeKey(6); //跳转到文档开头
		//插入模板头部
		TANGER_OCX_OBJ.AddTemplateFromURL(URL1);
		//拷贝正文书签格式
		doc.BookMarks("zhengwen").Select();
		curSel.CopyFormat();
		//选择到尾部
		curSel.EndKey(6,1);
		curSel.PasteFormat();
		doc.BookMarks("zhengwen").Select();		
		curSel.Delete();
		//删除段落标记
		curSel.Delete(1,1);	
		curSel.EndKey(6); //跳转到文档尾部
		//插入模板尾部
		TANGER_OCX_OBJ.AddTemplateFromURL(URL2);
		//设置其他书签
		//*

		doc.BookMarks("wenjiantoubu").Range.Text = "NTKO OFFICE文档控件";
		doc.BookMarks("wenhao").Range.Text = "111-111-111";
		doc.BookMarks("biaoti").Range.Text = "关于采用NTKO OFFICE文档控件的决定";
		doc.BookMarks("danwei").Range.Text = "尊敬的用户:";
		doc.BookMarks("Notekeyword").Range.Text = "痕迹保留 电子印章 手写签名 复杂模板套红 电子政务 同意采用 文档管理";
		doc.BookMarks("Publishto").Range.Text = "各合作伙伴和用户单位";
		doc.BookMarks("PublishUnit").Range.Text = "软航科技产品部";
		doc.BookMarks("PublisDate").Range.Text = "2004年3月28日";
		//*/		
		TANGER_OCX_SetMarkModify(true); //进入痕迹保留状态
	}
	catch(err)
	{
		alert("错误：" + err.number + ":" + err.description);
	};
}


//从本地增加印章文档指定位置
function AddSignFromLocal(key){
//	TANGER_OCX_OBJ.AddSignFromLocal(activeuser, "", true, 0, 0, key);
	/**
	 * 参数说明：
	 *	secSignOnj：必须的参数，必须是AddSecSignOcx方法返回的签章对象。
	 *	username：字符串。必须的参数。标识签章用户；
	 *	PrintMode：整数0-2，签章的打印属性。0=不打印，1=打印灰色，2=打印原始。默认值是0.
	 *	IsUseCertificate：布尔型，true 或者false。可选参数。指明签章时是否使用数字证书。默认值是false。
	 *	IsLocked：布尔型，true 或者false。可选参数。指明签章时是否锁定印章，默认值是false。
	 *	IsCheckDocChange：布尔型，true 或者false。可选参数。指明签章是否检查文档改变，默认值是true。
	 *	IsShowUI：布尔型，true 或者false。可选参数。指明签章时是否显示以上签章设定对话框选项，默认值是true。
	 *	Signpass：字符串。可选参数。指明签章文件的口令。如果指明了此参数，且口令正确，将不提示用户输入签章的口令。
	 *	IsAddComment：布尔型，true 或者false。可选参数。指明签章时是否允许用户输入批注。默认值是true。
	 *	SignIndex：整形。-1,0-9。EKEY中的印章位置号。如果传入-1或者省略该参数，则提示用户选择EKEY中的印章位置。
	 *	
	 */
	try{
		var TANGER_OCX_OBJ = document.getElementById("TANGER_OCX");
		TANGER_OCX_OBJ.AddSecSignFromEkey("",activeuser,2,false,false,true,false,"123456",true,"1");
//		OpenFromEkey("123456",0);
	}catch(error){
		alert(error);
	}
	
	
	/*
	if(TANGER_OCX_OBJ.IsNTKOSecSignInstalled())
	{
		try
		{
			alert("Type:");
			
			TANGER_OCX_OBJ.AddSecSignFromLocal(activeuser, "", true, 0, 0, 1);
		}
		catch(e)
		{
	 		alert("ERROR:"+e);
	 	}
	}
        
     else
    	 {
    	 	try{
    	 		alert(2);
    	 	TANGER_OCX_OBJ.AddSignFromLocal(activeuser, "", true, 0, 0, key);
    	 	}catch(e){
    	 		alert("ERROR2:"+e);
    	 	}
    	 }
    */
        
}


//***************************************************
//		页面检测的方法  begin
//***************************************************
/**
 * 获取浏览器可视高度
 */
function returnBrowserVisibleHeight(){
//	var clientHeight = document.documentElement.clientHeight;
//	return clientHeight + "px";
	return $(document).height();
}

/**
 * 获取浏览器可视宽度
 * @returns {String}
 */
function returnBrowserVisibleWidth(){
//	var clientWidth = document.documentElement.clientWidth; 
//	return clientWidth + "px";
	if(domModel === "view"){
		return $(document).width();
	}else if(domModel === "edit"){
		return $(document).width()-150;
	}else{
		return $(document).width();
	}
	
}

//***************************************************
//		页面检测的方法  end
//***************************************************


