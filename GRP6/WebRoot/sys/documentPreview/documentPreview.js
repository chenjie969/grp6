var TANGER_OCX_OBJ;//控件对象
var IsFileOpened;      //控件是否打开文档
var fileType ;
var fileTypeSimple;
var activeuser;//当前用户

/**
 * 初始化文档
 * @param fileUrl
 */
function intializePage(fileUrl,username)
{
	activeuser = username;
	TANGER_OCX_OBJ = document.all("TANGER_OCX");
	TANGER_OCX_OBJ.AddDocTypePlugin(".pdf","PDF.NtkoDocument","4.0.0.2","ntkooledocall.cab",51,true);
//	initCustomMenus();
	NTKO_OCX_OpenDoc(fileUrl);
}

/**
 * 设置只读模式
 */
function zjmSetReadonly(){
	TANGER_OCX_OBJ.SetReadOnly (false,""); 
	//禁止新建功能
	TANGER_OCX_OBJ.FileNew = false;
	//禁止打开
	TANGER_OCX_OBJ. FileOpen  = false;
	//禁止保存
	TANGER_OCX_OBJ.FileSave = false;
	//禁止另存为
	TANGER_OCX_OBJ.FileSaveAs = false;
	//禁止标题栏
	TANGER_OCX_OBJ.Titlebar = false;
	//菜单栏
	TANGER_OCX_OBJ.Menubar = true;
	//状态栏
	TANGER_OCX_OBJ. Statusbar = false;
	//工具栏
	TANGER_OCX_OBJ. Toolbars = false;
	//切换文档状态 true : 不可编辑 
//	TANGER_OCX_SetReadOnly(true);
}

/**
 * 设置文件打开或关闭
 * @param bool
 */
function setFileOpenedOrClosed(bool)
{
	IsFileOpened = bool;
	fileType = TANGER_OCX_OBJ.DocType ;
}

//接管 谷歌或者火狐
function FileCommand(TANGER_OCX_str,TANGER_OCX_obj){
	//保存按钮
	if (TANGER_OCX_str == 3){
		saveFileToUrl();
		TANGER_OCX_OBJ.CancelLastCommand = true;
	}
	//关闭按钮
	if (TANGER_OCX_str == 2){
		window.close();
	}
}


/**
 * 页面关闭之前的事件(移动至页面)
 */
/*function onPageClose()
{
	if(!TANGER_OCX_OBJ.activeDocument.saved)
	{
		if(confirm( "文档修改过,还没有保存,是否需要保存?"))
		{
			saveFileToUrl();
		}
	}
}*/

/**
 * 打开文档
 * @param fileUrl
 */
function NTKO_OCX_OpenDoc(fileUrl)
{
	TANGER_OCX_OBJ.BeginOpenFromURL(fileUrl);
}

//监听文档 移动至页面

/*
谷歌浏览器事件接管
*/
function OnComplete2(type,code,html)
{
	saveFileToUrl();
	TANGER_OCX_OBJ.CancelLastCommand = true;
	
	if(html){
		//window.close();
		alert("文档保存成功!");
	}else{
		alert("文档保存失败!");
		//window.close();
	}
//	alert("SaveToURL成功回调");
	
}


/**
 * 保存文档
 */
function saveFileToUrl(){
	var myUrl = document.getElementById("myForm").action ;
	var fileName = document.getElementsByName("domname").value;
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
		
		
		
		result = TANGER_OCX_OBJ.SaveToURL(
			myUrl,//提交到的url地址
			"fileStream",//文件域的id，类似<input type=file id=upLoadFile 中的id
			"",        //与控件一起提交的参数如："p1=a&p2=b&p3=c"
			"filename",    //上传文件的名称，类似<input type=file 的value
			"myForm"    //与控件一起提交的表单id，也可以是form的序列号，这里应该是0.
		);
//		result=trim(result);
//		document.all("statusBar").innerHTML="服务器返回信息:"+result;
//		console.log("===="+result);
//		window.close();
		return result;
	}
}

//设置当前Office的用户名（痕迹的用户名
function TANGER_OCX_SetDocUser(cuser)
{
	with(TANGER_OCX_OBJ.ActiveDocument.Application)
	{
		UserName = cuser;
	}
}


//允许或禁止显示修订工具栏和工具菜单（保护修订）
function TANGER_OCX_EnableReviewBar(boolvalue)
{
	try{
		TANGER_OCX_OBJ.ActiveDocument.CommandBars("Reviewing").Enabled = boolvalue;
		TANGER_OCX_OBJ.ActiveDocument.CommandBars("Track Changes").Enabled = boolvalue;
		TANGER_OCX_OBJ.IsShowToolMenu = boolvalue;	//关闭或打开工具菜单
	}catch(error){
		
	}
}

//打开或者关闭修订模式
function TANGER_OCX_SetReviewMode(boolvalue)
{
	TANGER_OCX_OBJ.ActiveDocument.TrackRevisions = boolvalue;
}

//进入或退出痕迹保留状态，调用上面的两个函数
function TANGER_OCX_SetMarkModify(boolvalue)
{
	TANGER_OCX_SetReviewMode(boolvalue);
	TANGER_OCX_EnableReviewBar(!boolvalue);
}

//显示/不显示修订文字
function TANGER_OCX_ShowRevisions(boolvalue)
{
	TANGER_OCX_OBJ.ActiveDocument.ShowRevisions = boolvalue;
}
