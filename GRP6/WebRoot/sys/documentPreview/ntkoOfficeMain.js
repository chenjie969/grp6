// 请勿修改，否则可能出错
var userAgent = navigator.userAgent, rMsie = /(msie\s|trident.*rv:)([\w.]+)/, rFirefox = /(firefox)\/([\w.]+)/, rOpera = /(opera).+version\/([\w.]+)/, rChrome = /(chrome)\/([\w.]+)/, rSafari = /version\/([\w.]+).*(safari)/;
var browser;
var version;
var ua = userAgent.toLowerCase();

function uaMatch(ua) {
	var match = rMsie.exec(ua);
	if (match != null) {
		return {
			browser : "IE",
			version : match[2] || "0"
		};
	}
	var match = rFirefox.exec(ua);
	if (match != null) {
		return {
			browser : match[1] || "",
			version : match[2] || "0"
		};
	}
	var match = rOpera.exec(ua);
	if (match != null) {
		return {
			browser : match[1] || "",
			version : match[2] || "0"
		};
	}
	var match = rChrome.exec(ua);
	if (match != null) {
		return {
			browser : match[1] || "",
			version : match[2] || "0"
		};
	}
	var match = rSafari.exec(ua);
	if (match != null) {
		return {
			browser : match[2] || "",
			version : match[1] || "0"
		};
	}
	if (match != null) {
		return {
			browser : "",
			version : "0"
		};
	}
}
var browserMatch = uaMatch(userAgent.toLowerCase());
if (browserMatch.browser) {
	browser = browserMatch.browser;
	version = browserMatch.version;
}
// document.write(browser);
/**
 * 谷歌浏览器事件接管
 * 
 */
function OnComplete2(type, code, html) {
	// alert(type + " 保存成功!!! ");
	// alert(code + " 保存成功!!! ");
	// alert(html + " 保存成功!!! ");
	// alert("SaveToURL成功回调");
	if (html === "true") {
		alert("文档保存成功!");
	} else {
		alert("文档保存失败!");
	}

}

/**
 * 打开表单数据之前 调用
 * 
 * @param type
 * @param code
 * @param html
 */
function OnComplete(type, code, html) {
	// alert(type);
	// alert(code);
	// alert(html + " >> 打开表单数据之前 调用 >>> BeginOpenFromURL成功回调 ");
	// alert("BeginOpenFromURL成功回调 >>> 打开表单数据之前 调用 ");
}
function OnAddTemplate(a,b,c)// 执行完AddTemplateFromURL方法才会执行这个
{
	var TANGER_OCX_OBJ = document.getElementById("TANGER_OCX");
	//TANGER_OCX_OBJ.ShowTipMessage("xxxx", "xxxx");
	var BookMarkName = "zhengWen";
	// TANGER_OCX_OBJ.activedocument.Bookmarks.exists(BookMarkName)
	// TANGER_OCX_OBJ.activedocument.Bookmarks.count
	var markCount = TANGER_OCX_OBJ.activedocument.Bookmarks.count;
	
	//TANGER_OCX_OBJ.ActiveDocument.Application.Selection.HomeKey(6);// 光标定位到文件头
	if (!TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists(BookMarkName)) {
		alert("Word 模板中不存在名称为：\"" + BookMarkName + "\"的书签！请联系管理员!");
		return;
	}
	var bkmkObj = TANGER_OCX_OBJ.ActiveDocument.BookMarks.Item(BookMarkName);
	var saverange = bkmkObj.Range
	saverange.Paste();
	TANGER_OCX_OBJ.ActiveDocument.Bookmarks.Add(BookMarkName, saverange);
	
	var doc = TANGER_OCX_OBJ.ActiveDocument;
	var curSel = doc.Application.Selection;
	curSel.HomeKey(6); //跳转到文档开头
	
//	doc.BookMarks("wenjiantoubu").Range.Text = "NTKO OFFICE文档控件";
//	doc.BookMarks("wenhao").Range.Text = "111-111-111";
//	doc.BookMarks("biaoti").Range.Text = "关于采用NTKO OFFICE文档控件的决定";
//	doc.BookMarks("danwei").Range.Text = "尊敬的用户:";
//	doc.BookMarks("Notekeyword").Range.Text = "痕迹保留 电子印章 手写签名 复杂模板套红 电子政务 同意采用 文档管理";
//	doc.BookMarks("Publishto").Range.Text = "各合作伙伴和用户单位";
	markOtherInfo();
	TANGER_OCX_SetMarkModify(true);
}
// 当文档打开时的回调
function OnComplete3(str, doc) {
	// saved属性用来判断文档是否被修改过,文档打开的时候设置成ture,当文档被修改,自动被设置为false,该属性由office提供.
	TANGER_OCX_OBJ.activeDocument.saved = true;

	// TANGER_OCX_OBJ.SetReadOnly(true,"");

	// TANGER_OCX_OBJ.ActiveDocument.Protect(1,true,"123");

	// 获取文档控件中打开的文档的文档类型
	switch (TANGER_OCX_OBJ.doctype) {
	case 1:
		fileType = "Word.Document";
		fileTypeSimple = "wrod";
		break;
	case 2:
		fileType = "Excel.Sheet";
		fileTypeSimple = "excel";
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
		fileTypeSimple = "wps";
		break;
	case 7:
		fileType = "Kingsoft Sheet";
		fileTypeSimple = "et";
		break;
	default:
		fileType = "unkownfiletype";
		fileTypeSimple = "unkownfiletype";
	}

	// 初始化修订功能参数(修订的参数需要再文档加载完成之后设置)
	initMarkConfig(curUserName, domModel);
	// alert("ondocumentopened成功回调 >>> 当文档打开时的回调");
}

function publishashtml(type, code, html) {
	// alert(html);
	// alert("Onpublishashtmltourl成功回调");
}

function publishaspdf(type, code, html) {
	// alert(html);
	// alert("Onpublishaspdftourl成功回调");
}

/**
 * 另存为 回调
 * 
 * @param type
 * @param code
 * @param html
 */
function saveasotherurl(type, code, html) {
	// alert(html);
	// alert("SaveAsOtherformattourl成功回调");
}

function dowebget(type, code, html) {
	// alert(html);
	// alert("OnDoWebGet成功回调");
}
function webExecute(type, code, html) {
	// alert(html);
	// alert("OnDoWebExecute成功回调");
}

function webExecute2(type, code, html) {
	// alert(html);
	// alert("OnDoWebExecute2成功回调");
}

/**
 * 监听保存按钮
 * 
 * @param TANGER_OCX_str
 * @param TANGER_OCX_obj
 */
function FileCommand(TANGER_OCX_str, TANGER_OCX_obj) {

	// 保存
	if (TANGER_OCX_str == 3) {
		// alert("不能保存！");
		TANGER_OCX_OBJ.CancelLastCommand = true;
		saveFileToUrl();
	}
	// 关闭
	if (TANGER_OCX_str == 2) {
		// 全屏状态时，关闭文档的话无法关闭控件的窗口，即窗口还是悬浮在jsp页面上方，所以的先设置空间的窗口为非全屏状态。
		TANGER_OCX.FullScreenMode = false;
		window.close();
	}
}

/**
 * 定制 菜单 回调
 * 
 * @param menuPos
 * @param submenuPos
 * @param subsubmenuPos
 * @param menuCaption
 * @param menuID
 */
function CustomMenuCmd(menuPos, submenuPos, subsubmenuPos, menuCaption, menuID) {
	// alert("第" + menuPos +","+ submenuPos +","+ subsubmenuPos
	// +"个菜单项,menuID="+menuID+",菜单标题为\""+menuCaption+"\"的命令被执行.");
}

var classid = 'C9BC4DFF-4248-4a3c-8A49-63A7D317F404';
if (browser == "IE") {
	document.write('<!-- 用来产生编辑状态的ActiveX控件的JS脚本-->   ');
	document.write('<!-- 因为微软的ActiveX新机制，需要一个外部引入的js-->   ');
	document
			.write('<object id="TANGER_OCX" classid="clsid:A64E3073-2016-4baf-A89D-FFE1FAA10EC2"');
	document
			.write('codebase="ofctnewclsid.cab#version=5,0,2,9" width="100%">   ');
	document.write('<param name="IsUseUTF8URL" value="-1">   ');
	document.write('<param name="IsUseUTF8Data" value="-1">   ');
	document.write('<param name="BorderStyle" value="1">   ');
	document.write('<param name="BorderColor" value="14402205">   ');
	document.write('<param name="TitlebarColor" value="15658734">   ');
	document.write('<param name="isoptforopenspeed" value="0">   ');

	document.write('<param name="MakerCaption" value="中投保信息技术有限公司">');
	document
			.write('<param name="MakerKey" value="F48CEAABD466549955A67D6E57A66D07667E1494">');
	document.write('<param name="ProductCaption" value="专用Office控件"> ');
	document
			.write('<param name="ProductKey" value="B4D3329D5D726E9BD440E95ECADF4D5C31B32012">');

	document.write('<param name="TitlebarTextColor" value="0">   ');
	document.write('<param name="MenubarColor" value="14402205">   ');
	document.write('<param name="MenuButtonColor" VALUE="16180947">   ');
	document.write('<param name="MenuBarStyle" value="3">   ');
	document.write('<param name="MenuButtonStyle" value="7">   ');
	// document.write('<param name="WebUserName" value="NTKO"> ');
	document.write('<param name="Caption" value="OFFICE文档控件">   ');
	document
			.write('<SPAN STYLE="color:red">不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</SPAN>   ');
	document.write('</object>');

	document.getElementById("TANGER_OCX").setAttribute("height",
			returnBrowserVisibleHeight());
	document.getElementById("TANGER_OCX").setAttribute("width",
			returnBrowserVisibleWidth());

} else if (browser == "firefox") {
	document
			.write('<object id="TANGER_OCX" type="application/ntko-plug"  codebase="ofctnewclsid.cab#version=5,0,2,9" width="100%" ForOnSaveToURL="OnComplete2" ForOnSaveAsOtherFormatToURL="OnComplete2" ForOnBeginOpenFromURL="OnComplete" ForOndocumentopened="documentOpened"');
	document.write('ForOnpublishAshtmltourl="publishashtml"');
	document.write('ForOnpublishAspdftourl="publishaspdf"');
	document.write('ForOnAddTemplateFromURL="OnAddTemplate"');
	document.write('ForOnSaveAsOtherFormatToUrl="saveasotherurl"');
	document.write('ForOnDoWebGet="dowebget"');
	document.write('ForOnDoWebExecute="webExecute"');
	document.write('ForOnDoWebExecute2="webExecute2"');
	document.write('ForOnFileCommand="FileCommand"');
	document.write('ForOnCustomMenuCmd2="CustomMenuCmd"');
	document.write('_IsUseUTF8URL="-1"   ');

	document.write('_MakerCaption="中投保信息技术有限公司"');
	document.write('_MakerKey="F48CEAABD466549955A67D6E57A66D07667E1494"');
	document.write('_ProductCaption="专用Office控件" ');
	document.write('_ProductKey="B4D3329D5D726E9BD440E95ECADF4D5C31B32012"');

	document.write('_IsUseUTF8Data="-1"   ');
	document.write('_BorderStyle="1"   ');
	document.write('_BorderColor="14402205"   ');
	document.write('_MenubarColor="14402205"   ');
	document.write('_MenuButtonColor="16180947"   ');
	document.write('_MenuBarStyle="3"  ');
	document.write('_MenuButtonStyle="7"   ');
	// document.write('_WebUserName="NTKO" ');
	document.write('clsid="{A64E3073-2016-4baf-A89D-FFE1FAA10EC2}" >');
	document
			.write('<SPAN STYLE="color:red">尚未安装浏览器Office插件。请点击下载浏览器Office插件并刷新或者重新启动浏览器. <a href="/documentPreview/NTKOsetup.exe">下载Office文档插件</a><BR/>检查所安装的的office是否为简化版本，建议缷载简化版本，重新安装完整版本的office。</SPAN>   ');
	document.write('</object>   ');

	document.getElementById("TANGER_OCX").setAttribute("height",
			returnBrowserVisibleHeight());
} else if (browser == "chrome") {

	document
			.write('<object id="TANGER_OCX" clsid="{A64E3073-2016-4baf-A89D-FFE1FAA10EC2}"  ForOnSaveToURL="OnComplete2" ForOnSaveAsOtherFormatToURL="OnComplete2" ForOnBeginOpenFromURL="OnComplete" ForOndocumentopened="documentOpened"');
	document.write('ForOnpublishAshtmltourl="publishashtml"');
	document.write('ForOnpublishAspdftourl="publishaspdf"');
	document.write('ForOnSaveAsOtherFormatToUrl="saveasotherurl"');
	document.write('ForOnDoWebGet="dowebget"');
	document.write('ForOnDoWebExecute="webExecute"');
	document.write('ForOnDoWebExecute2="webExecute2"');
	document.write('ForOnFileCommand="FileCommand"');
	document.write('ForOnCustomMenuCmd2="CustomMenuCmd"');
	document.write('ForOnAddTemplateFromURL="OnAddTemplate"');

	document.write('_MakerCaption="中投保信息技术有限公司"');
	document.write('_MakerKey="F48CEAABD466549955A67D6E57A66D07667E1494"');
	document.write('_ProductCaption="专用Office控件" ');
	document.write('_ProductKey="B4D3329D5D726E9BD440E95ECADF4D5C31B32012"');

	document
			.write('codebase="ofctnewclsid.cab#version=5,0,2,9" width="100%" type="application/ntko-plug" ');
	document.write('_IsUseUTF8URL="-1"   ');
	document.write('_IsUseUTF8Data="-1"   ');
	document.write('_BorderStyle="1"   ');
	document.write('_BorderColor="14402205"   ');
	document.write('_MenubarColor="14402205"   ');
	document.write('_MenuButtonColor="16180947"   ');
	document.write('_MenuBarStyle="3"  ');
	document.write('_MenuButtonStyle="7"   ');
	// document.write('_WebUserName="NTKO" ');
	document.write('_Caption="OFFICE文档控件">    ');
	document
			.write('<SPAN STYLE="color:red">尚未安装浏览器Office插件。请点击下载浏览器Office插件并刷新或者重新启动浏览器. <a href="/documentPreview/NTKOsetup.exe">下载Office文档插件</a><BR/>检查所安装的的office是否为简化版本，建议缷载简化版本，重新安装完整版本的office。</SPAN>   ');
	document.write('</object>');

	document.getElementById("TANGER_OCX").setAttribute("height",
			returnBrowserVisibleHeight());
} else if (Sys.opera) {
	alert("sorry,ntko web印章暂时不支持opera!");
} else if (Sys.safari) {
	alert("sorry,ntko web印章暂时不支持safari!");
}