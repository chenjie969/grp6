package com.zjm.oa.message.web;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.db.model.User;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.common.service.OaFileService;
import com.zjm.oa.db.model.Oa_message;
import com.zjm.oa.message.service.MessageService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value="/oa/announce")
public class MessageAction {

	@Resource
	private SysDicDataService  sysDicDataService;
	
	@Resource
	
	private MessageService  announceService;
	
	@Resource
	private DicTypeService   dicTypeService;
	
	@Resource
	private OaFileService oaFileService;
	
	/**
	 *  信息中心--左侧 树形结构
	 */
	@RequestMapping(value="/selectAllInfoListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllInfoListTree(){
		List<SysDicData> list=sysDicDataService.selectMultiLevelSortDicNoEableList("","f1ab5bf4aa3948e690e808d9127e7d6b/b4cb8bf303974996ac4df5e87cf30ac0/");//multilevelsortid
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (SysDicData info : list) {
			map = new HashMap<String, Object>();
			map.put("id", info.getId());
			map.put("pId", info.getPid());
			map.put("name", info.getName());
			map.put("unitUid", info.getUnit_uid());
			map.put("isDefault", info.getIsDefault());
			mapList.add(map);
			map.put("open", true);
		}
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * 显示页面-信息发布
	 */
	@RequestMapping(value="/announceTable")
	public ModelAndView announceTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/announce");
		return mv;
	}
	/**
	 * 显示页面-信息审核
	 */
	@RequestMapping(value="/auditAnnounceTable")
	public ModelAndView auditAnnounceTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/audit_announce");
		return mv;
	}
	/**
	 * 显示页面-我的信息
	 */
	@RequestMapping(value="/myAnnounceTable")
	public ModelAndView myAnnounceTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/my_announce");
		return mv;
	}
	
	/**
	 * 查询信息列表
	 */
	@RequestMapping(value="/selectAnnouncePageTable")
	@ResponseBody
	public AjaxRes selectAnnouncePageTable(@RequestBody PageTable<Oa_message> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = announceService.selectAnnouncePageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable<Oa_message> pageTable){
		if(pageTable==null){
			return "";
		}
		String sql = "";
		if(pageTable.getQueryCondition().getMessageTypeId() != null && ! "".equals(pageTable.getQueryCondition().getMessageTypeId() ) ){
			sql = sql + "AND messageTypeId = \'"+pageTable.getQueryCondition().getMessageTypeId() +"\'";
		}
		if(pageTable.getQueryCondition().getMessageTypePID() != null && pageTable.getQueryCondition().getMessageTypePID() != ""){
			sql = sql + "AND messageTypePID = \'"+pageTable.getQueryCondition().getMessageTypePID() +"\'";
		}
		if(pageTable.getQueryCondition().getStatus() != null && ! "".equals(pageTable.getQueryCondition().getStatus())){
			sql = sql + "AND approvalStatus = \'"+pageTable.getQueryCondition().getStatus() +"\'";
		}
		if(pageTable.getSearchText() != null && !"".equals(pageTable.getSearchText())){
			sql = sql +" AND  ( title like \'%"+pageTable.getSearchText()+"%\'";
			sql = sql +" OR messageTypeName like \'%"+pageTable.getSearchText()+"%\' )";
		}
		
		return sql;
	}
	/**
	 * 分页查询"已审核"数据
	 */
	@RequestMapping(value="/selectAnnounceYesCheckPageTable")
	@ResponseBody
	public AjaxRes selectAnnounceYesCheckPageTable(@RequestBody PageTable<Oa_message> pageTable){
		AjaxRes ar = new AjaxRes();
		String sql = "";
		if(pageTable.getQueryCondition().getMessageTypeId() != null && pageTable.getQueryCondition().getMessageTypeId() != ""){
			sql = sql + "AND m.messageTypeId = \'"+pageTable.getQueryCondition().getMessageTypeId() +"\'";
		}
		if(pageTable.getSearchText() != null && !"".equals(pageTable.getSearchText())){
			sql = sql +" AND  ( m.title like \'%"+pageTable.getSearchText()+"%\'";
			sql = sql +" OR m.messageTypeName like \'%"+pageTable.getSearchText()+"%\' )";
		}
		if(pageTable.getQueryCondition().getStatus() != null && pageTable.getQueryCondition().getStatus() != ""){
			if("01".equals(pageTable.getQueryCondition().getStatus() )){  //未签收
				sql = sql + "AND m.noSignUserNameList  like \'%"+ SystemSession.getUserSession().getUser_name()+"%\'";
			}else if("02".equals(pageTable.getQueryCondition().getStatus())){
				sql = sql + "AND m.signedUserNameList  like  \'%"+ SystemSession.getUserSession().getUser_name()+"%\'";
			}
			
		}
		sql = sql + "AND m.approvalStatus  = \'04\'";
		sql = sql + " AND  m.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid() +"\'";
		String sql2hao2=sql;
		sql = sql + " ORDER BY m.updateDateTime DESC";
		sql = sql + " LIMIT "+pageTable.getPageNumber()+","+pageTable.getPageSize()+"";
		List<Oa_message> messageList=null;
		try {
			messageList = announceService.selectMessageList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Oa_message> list = new ArrayList<Oa_message>();
		for (Oa_message message : messageList) {
			String noSignStr = "0";
			String yesSignStr = "0";
			
			if( message.getNoSignUserIdList() != null){
				noSignStr = message.getNoSignUserIdList().split(",").length+"";
			}
			if(message.getSignedUserIdList() != null){
				yesSignStr = message.getSignedUserIdList().split(",").length+"";
			}
		
			message.setNoSignCount(noSignStr);
			message.setSignedCount(yesSignStr);
			list.add(message);
		}
		pageTable.setRows(list); 
		pageTable.setTotal(announceService.selectTable_Count(sql2hao2));
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 分页查询,我的信息----"待签收,已签收,所有"的数据
	 */
	@RequestMapping(value="/selectAnnounceSignPageTable")
	@ResponseBody
	public AjaxRes selectAnnounceSignPageTable(@RequestBody PageTable<Oa_message> pageTable){
		AjaxRes ar = new AjaxRes();
		String sql = "";
		if(pageTable.getQueryCondition().getMessageTypeId() != null && pageTable.getQueryCondition().getMessageTypeId() != ""){
			sql = sql + "AND m.messageTypeId = \'"+pageTable.getQueryCondition().getMessageTypeId() +"\'";
		}
		if(pageTable.getQueryCondition().getMessageTypePID() != null && pageTable.getQueryCondition().getMessageTypePID() != ""){
			sql = sql + "AND m.messageTypePID = \'"+pageTable.getQueryCondition().getMessageTypePID() +"\'";
		}
		if(pageTable.getQueryCondition().getStatus() != null && pageTable.getQueryCondition().getStatus() != ""){
			if("01".equals(pageTable.getQueryCondition().getStatus() )){  //未签收
				sql = sql + "AND m.noSignUserIDList  like \'%"+ SystemSession.getUserSession().getUser_uid()+"%\'";
				sql = sql + " AND m.isSign = \'1\'";
			}else if("02".equals(pageTable.getQueryCondition().getStatus())){
				sql = sql + "AND m.signedUserIDList  like  \'%"+ SystemSession.getUserSession().getUser_uid()+"%\'";
				sql = sql + " AND m.isSign = \'1\'";
			}
			
		}else{
			
				sql = sql + "AND m.receiveUserNameList  like \'%"+ SystemSession.getUserSession().getUser_name()+"%\'";
		}
		if(pageTable.getSearchText() != null && !"".equals(pageTable.getSearchText())){
			sql = sql +" AND ( m.title like \'%"+pageTable.getSearchText()+"%\'";
			sql = sql +" OR m.messageTypeName like \'%"+pageTable.getSearchText()+"%\' )";
		}
		if(pageTable.getQueryCondition().getTitleName() != null &&  !"".equals(pageTable.getQueryCondition().getTitleName())){
			sql = sql +" AND m.title  like \'%"+pageTable.getQueryCondition().getTitleName()+"%\'";
		}
		if(pageTable.getQueryCondition().getCreateUserName() != null &&  !"".equals(pageTable.getQueryCondition().getCreateUserName())){
			sql = sql + "  AND m.createUserName like \'%"+pageTable.getQueryCondition().getCreateUserName()+"%\'";
		}
		if( pageTable.getQueryCondition().getCreateDateStart() != null && !"".equals(pageTable.getQueryCondition().getCreateDateStart())){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			sql = sql +"  AND m.createDateTime >= \'"+format.format(pageTable.getQueryCondition().getCreateDateStart())+"\'";
		}
		if(  pageTable.getQueryCondition().getCreateDateEnd() != null && !"".equals(pageTable.getQueryCondition().getCreateDateEnd())){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			sql = sql +" AND m.createDateTime <= \'"+format.format(pageTable.getQueryCondition().getCreateDateEnd().getTime()+24*3600*1000)+"\'";
		}
		sql = sql + " AND m.approvalStatus  = \'04\'";
		
		sql = sql + " AND  m.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid() +"\'";
		String sql2hao2=sql;
		sql = sql + " ORDER BY m.updateDateTime DESC";
		sql = sql + " LIMIT "+pageTable.getPageNumber()+","+pageTable.getPageSize()+"";
		List<Oa_message> messageList = announceService.selectMessageList(sql);
		List<Oa_message> list = new ArrayList<Oa_message>();
		//如果是全部,查询"签收"或"未签收"状态
		if(pageTable.getQueryCondition().getStatus() == null || "".equals(pageTable.getQueryCondition().getStatus()) ){
			
			for (Oa_message message : messageList) {
				
				if(message.getIsSign() == "1" || "1".equals(message.getIsSign())){
					//默认设置为"未签收"
					 message.setUserIsSignStatus("未签收");
					if(message.getSignedUserIdList() != null && !"".equals(message.getSignedUserIdList())){
						String[] signedArr = message.getSignedUserIdList().split(",");
						for(int i=0 ; i<signedArr.length; i++){
							if(signedArr[i].equals(SystemSession.getUserSession().getUser_uid())){
								message.setUserIsSignStatus("已签收");//已签收
								break;
							}
							
						}
						
					}
					
				}else{
					//设置状态为,无需签收
					message.setUserIsSignStatus("---");
				}
				
				list.add(message);
			}
			
			pageTable.setRows(list); 
			pageTable.setTotal(announceService.selectTable_Count(sql2hao2));
		}else{
			pageTable.setRows(messageList); 
			pageTable.setTotal(announceService.selectTable_Count(sql2hao2));
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示页面-信息发布--新增
	 */
	@RequestMapping(value="/announceAddPage")
	public ModelAndView announceAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/announce/announceAdd");
		mv.getModelMap().put("messageId", Tool.createUUID32());		//打开新增页面时,返回一个UUID作为主键备用,方便上传附件的挂靠
		return mv;
	}
	/**
	 * 显示页面-信息审核--审核退回
	 */
	@RequestMapping(value="/announceAuditReturnPage")
	public ModelAndView announceAuditReturnPage( Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		message = announceService.selectOneAnnounce(message);
		message.setApprovalUserId(SystemSession.getUserSession().getUser_uid());
		message.setApprovalUserName(SystemSession.getUserSession().getUser_name());
		mv.getModelMap().put("message", message);
		mv.setViewName("/oa/info/announcement/announce/announceAuditReturn");
		return mv;
	}
	
	/**
	 * 执行操作-新增
	 */
	@RequestMapping(value="/insertOneAnnounce")
	@ResponseBody
	public AjaxRes insertOneAnnounce(@RequestBody Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		ar.setSucceed(announceService.insertOneAnnounce(user,message));
		ar.setCode(message.getMessageId());
		return ar;
	}
	/**
	 * 执行操作-信息发布---提交审核
	 */
	@RequestMapping(value="/updateStatusToNoCheck")
	@ResponseBody
	public AjaxRes updateStatusToNoCheck(@RequestBody Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		try{
			ar.setSucceed(announceService.updateStatusToNoCheck(user,message));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 执行操作--信息审核---确定审核通过
	 */
	@RequestMapping(value="/updateStatusToYesCheck")
	@ResponseBody
	public AjaxRes updateStatusToYesCheck(@RequestBody Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		try{
			ar.setSucceed(announceService.updateStatusToYesCheck(user,message));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 执行操作---我的信息---确定签收通过
	 */
	@RequestMapping(value="/updateStatusToYesSign")
	@ResponseBody
	public AjaxRes updateStatusToYesSign(@RequestBody Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		try{
			ar.setSucceed(announceService.updateStatusToYesSign(user,message));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 执行操作--信息审核---审核退回
	 */
	@RequestMapping(value="/updateStatusToBounced")
	@ResponseBody
	public AjaxRes updateStatusToBounced(@RequestBody Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		try{
			ar.setSucceed(announceService.updateStatusToBounced(user,message));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 
	 * 显示审核页面-- 
	 */
	@RequestMapping(value="/announceAuditViewPage")
	public ModelAndView announceAuditViewPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		message = announceService.selectOneAnnounce(message);
		mv.getModelMap().put("message", message);
		mv.setViewName("/oa/info/announcement/announce/announceAudit");
		return mv;
	}
	/**
	 * 显示页面---信息发布---查看
	 */
	@RequestMapping(value="/draftAnnounceViewPage")
	public ModelAndView draftAnnounceViewPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		message = announceService.selectOneAnnounce(message);
		mv.getModelMap().put("message", message);
		mv.setViewName("/oa/info/announcement/announce/draftAnnounceView");
		return mv;
	}
	/**
	 * 显示"立即签收"页面-信息登记-查看
	 */
	@RequestMapping(value="/signAnnounceViewPage")
	public ModelAndView signAnnounceViewPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Oa_message messageObj = announceService.selectOneAnnounce(message);
		mv.getModelMap().put("message", messageObj);
		mv.getModelMap().put("megUser", message);
		mv.setViewName("/oa/info/announcement/announce/signAnnounceView");
		return mv;
	}
	/**
	 * 显示"立即签收"页面-信息登记-查看
	 */
	@RequestMapping(value="/announceViewPage")
	public ModelAndView announceViewPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Oa_message messageObj = announceService.selectOneAnnounce(message);
		mv.getModelMap().put("message", messageObj);
		mv.getModelMap().put("megUser", message);
		mv.setViewName("/oa/info/announcement/announce/allAnnounceView");
		return mv;
	}
	/**
	 * 显示"立即签收"页面-信息登记-查看
	 */
	@RequestMapping(value="/signedAnnounceViewPage")
	public ModelAndView signedAnnounceViewPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		message = announceService.selectOneAnnounce(message);
		mv.getModelMap().put("message", message);
		mv.setViewName("/oa/info/announcement/announce/yesSignAnnounceView");
		return mv;
	}
	/**
	 * 显示"立即签收"页面-信息登记-查看
	 */
	@RequestMapping(value="/bouncedAnnounceViewPage")
	public ModelAndView bouncedAnnounceViewPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		message = announceService.selectOneAnnounce(message);
		mv.getModelMap().put("message", message);
		mv.setViewName("/oa/info/announcement/announce/bouncedAnnounceView");
		
		return mv;
	}
	/**
	 * 显示页面-同意审核
	 */
	@RequestMapping(value="/showAgreeAuditPage")
	public ModelAndView showAgreeAuditPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/agreeToAcceptAudit");
		return mv;
	}
	/**
	 * 显示页面-同意审批
	 */
	@RequestMapping(value="/showAgreeCheckPage")
	public ModelAndView showAgreeCheckPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/agreeToAcceptCheck");
		return mv;
	}
	/**
	 * 显示页面-同意删除
	 */
	@RequestMapping(value="/showAgreePage")
	public ModelAndView showAgreePage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/agreeToAccept");
		return mv;
	}
	/**
	 * 显示页面-同意删除
	 */
	@RequestMapping(value="/showAgreeSignPage")
	public ModelAndView showAgreeSignPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/agreeToAcceptSign");
		return mv;
	}
	
	/**
	 * 显示页面--高级查询
	 */
	@RequestMapping(value="/yesSignAnnounceAdQuery")
	public ModelAndView yesSignAnnounceAdQuery(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/announce/announceAdQuery");
		return mv;
	}
	
	/**
	 * 显示页面--选择分布范围
	 */
	@RequestMapping(value="/selectPublicScopePage")
	public ModelAndView selectPublicScopePage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/announce/selectPublicScopeView");
		return mv;
	}
	
	
	/**
	 * 显示页面--添加下级
	 */
	@RequestMapping(value="/announceaddChildrenOrgPage")
	public ModelAndView announceaddChildrenOrgPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/announce/announceAddChildrenOrgView");
		return mv;
	}
	
	/**
	 * 显示页面--同级排序
	 */
	@RequestMapping(value="/announceSortPage")
	public ModelAndView announceSortPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/info/announcement/announce/sort");
		return mv;
	}
	/**
	 * 显示"修改公告"页面-
	 */
	@RequestMapping(value="/announceEditPage")
	public ModelAndView announceEditPage(Oa_message message){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		message.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		message = announceService.selectOneAnnounce(message);
		List<C_dictype> templetList = dicTypeService.selectAllDicTypeList(" and dicTypePID='e32e5c0892e44514bb0d80bec38e3e58'");
		mv.getModelMap().put("message", message);
		mv.getModelMap().put("templetList", templetList);
		mv.setViewName("/oa/info/announcement/announce/announceEditView");
		return mv;
	}
	
	
	/**
	 * 
	 * 执行操作-删除
	 */
	@RequestMapping(value="/deleteAnnounceByIds")
	@ResponseBody
	public AjaxRes deleteAnnounceByIds(HttpServletRequest request, @RequestBody Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		message.setUnitUid(user.getUnit_uid());
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		Boolean delFlag = announceService.deleteAnnounceByIds(rootPath,user,message);
		ar.setSucceed(delFlag);
		return ar;
	}
	/**
	 * 执行操作-更新
	 */
	@RequestMapping(value="/updateOneAnnounce")
	@ResponseBody
	public AjaxRes updateOneAnnounce( Oa_message message){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		message.setUnitUid(user.getUnit_uid());
		message.setUnitUidName(user.getUnit_uidName());
		message.setUpdateUserName(user.getUser_name());
		ar.setSucceed(announceService.updateOneAnnounce(user,message));
		ar.setCode(message.getMessageId());
		return ar;
	}
	
	/**
	 * 查询某一消息已上传的附件  
	 * xuyz
	 */
	@RequestMapping(value="/selectUploadedFilesPageTables")
	@ResponseBody
	public AjaxRes selectUploadedFilesPageTables(@RequestBody PageTable pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable = oaFileService.selectUploadedFilesPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
}
