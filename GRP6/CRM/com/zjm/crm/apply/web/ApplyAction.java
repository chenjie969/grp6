package com.zjm.crm.apply.web;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.apply.service.ApplyService;
import com.zjm.crm.db.model.Crm_apply;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/apply")
public class ApplyAction {

	@Resource
	private ApplyService applyService;
	@Resource
	private DicTypeService dicTypeService;
	
	/**
	 * 显示页面-企业申请列表
	 */
	@RequestMapping(value="/enterpriseApplyTable")
	public ModelAndView enterpriseApplyTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/enterprise/enterpriseApply/enterpriseApply");
		return mv;
	}
	
	/**
	 * 显示页面-个人申请列表
	 */
	@RequestMapping(value="/personApplyTable")
	public ModelAndView personApplyTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/person/personApply/personApply");
		return mv;
	}
	
	/**
	 * 显示页面-客户储备库
	 */
	@RequestMapping(value="/showClientDepot")
	public ModelAndView showClientDepot(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/clientDepot/clientDepot");
		return mv;
	}
	
	/**
	 * 查询申请分页列表 
	 */
	@RequestMapping(value="/selectApplyPageTable")
	@ResponseBody
	public AjaxRes selectApplyPageTable(@RequestBody PageTable<Crm_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询企业表
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = applyService.selectApplyPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Crm_apply> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		//根据权限查看用户可查看到的数据sql
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByRole(pageTable.getQueryCondition().getUser_uid(),RolesDataAccreditUtil.PRO_APPLY_RECEIVE_SQL_STR,"");
			if( null != sql){
				wheresql.append(sql);
			}
		}
		
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and clientName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		//高级查询功能
		//共用查询条件
		if( null != pageTable.getQueryCondition().getClientName() && !"".equals(pageTable.getQueryCondition().getClientName())){
			wheresql.append(" and clientName like \'%"+pageTable.getQueryCondition().getClientName().trim()+"%\'");
		}
		if( null != pageTable.getQueryCondition().getBusiTypeID() && !"".equals(pageTable.getQueryCondition().getBusiTypeID())){
			wheresql.append(" and busiTypeID = \'"+pageTable.getQueryCondition().getBusiTypeID()+"\'");
		}
		if( null != pageTable.getQueryCondition().getClientSourceID() && !"".equals(pageTable.getQueryCondition().getClientSourceID())){
			wheresql.append(" and clientSourceID = \'"+pageTable.getQueryCondition().getClientSourceID()+"\'");
		}
		if( null != pageTable.getQueryCondition().getCooperationID() && !"".equals(pageTable.getQueryCondition().getCooperationID())){
			wheresql.append(" and cooperationID = \'"+pageTable.getQueryCondition().getCooperationID()+"\'");
		}
		if( null != pageTable.getQueryCondition().getApplySumLow() && !"".equals(pageTable.getQueryCondition().getApplySumLow())){
			wheresql.append(" and applySum >= "+pageTable.getQueryCondition().getApplySumLow());
		}
		if( null != pageTable.getQueryCondition().getApplySumHigh() && !"".equals(pageTable.getQueryCondition().getApplySumHigh())){
			wheresql.append(" and applySum <= "+pageTable.getQueryCondition().getApplySumHigh());
		}
		if( null != pageTable.getQueryCondition().getPeriodMonthLow() && !"".equals(pageTable.getQueryCondition().getPeriodMonthLow())){
			wheresql.append(" and periodMonth >= "+pageTable.getQueryCondition().getPeriodMonthLow());
		}
		if( null != pageTable.getQueryCondition().getPeriodMonthHigh() && !"".equals(pageTable.getQueryCondition().getPeriodMonthHigh())){
			wheresql.append(" and periodMonth <= "+pageTable.getQueryCondition().getPeriodMonthHigh());
		}
		if( null != pageTable.getQueryCondition().getReceiveDeapartID() && !"".equals(pageTable.getQueryCondition().getReceiveDeapartID())){
			wheresql.append(" and receiveDeapartID = \'"+pageTable.getQueryCondition().getReceiveDeapartID()+"\'");
		}
		if( null != pageTable.getQueryCondition().getReceiveUserID() && !"".equals(pageTable.getQueryCondition().getReceiveUserID())){
			wheresql.append(" and receiveUserID = \'"+pageTable.getQueryCondition().getReceiveUserID()+"\'");
		}
		if( null != pageTable.getQueryCondition().getReceiveDateLow() && !"".equals(pageTable.getQueryCondition().getReceiveDateLow())){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and receiveDate >= \'"+format.format(pageTable.getQueryCondition().getReceiveDateLow())+"\'");
		}
		if( null != pageTable.getQueryCondition().getReceiveDateHigh() && !"".equals(pageTable.getQueryCondition().getReceiveDateHigh())){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and receiveDate <= \'"+format.format(pageTable.getQueryCondition().getReceiveDateHigh())+"\'");
		}
		//企业独有查询条件
		if( null != pageTable.getQueryCondition().getContact() && !"".equals(pageTable.getQueryCondition().getContact())){
			wheresql.append(" and contact like \'%"+pageTable.getQueryCondition().getContact().trim()+"%\'");
		}
		//个人独有查询条件
		if( null != pageTable.getQueryCondition().getCertificateCode() && !"".equals(pageTable.getQueryCondition().getCertificateCode())){
			wheresql.append(" and certificateCode like \'%"+pageTable.getQueryCondition().getCertificateCode().trim()+"%\'");
		}
		//列表排序功能
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql.append(" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
		}else{
			wheresql.append(" ORDER BY applyNum DESC ");
		}
		return wheresql.toString();
	}
	
	/**
	 * 显示页面-企业咨询登记-添加
	 */
	@RequestMapping(value="/enterpriseApplyAddPage")
	public ModelAndView enterpriseApplyAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/enterprise/enterpriseApply/enterpriseApplyAdd");
		return mv;
	}
	
	/**
	 * 显示页面-个人咨询登记-添加
	 */
	@RequestMapping(value="/personApplyAddPage")
	public ModelAndView personApplyAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/person/personApply/personApplyAdd");
	
		return mv;
	}
	
	/**
	 * 执行操作-新增
	 */
	@RequestMapping(value="/insertOneApply")
	@ResponseBody
	public AjaxRes insertOneApply(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		apply.setUnit_uid(user.getUnit_uid());
		apply.setUnit_uidName(user.getUnit_uidName());
		apply.setUpdateUserName(user.getUser_name());
		ar.setSucceed(applyService.insertOneApply(user,apply));
		return ar;
	}
	
	/**
	 * 显示页面-企业咨询登记-查看
	 */
	@RequestMapping(value="/enterpriseApplyViewPage")
	public ModelAndView enterpriseApplyViewPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/crm/apply/enterprise/enterpriseApply/enterpriseApplyView");
		return mv;
	}
	

	/**
	 * App-咨询登记-查看
	 */
	@RequestMapping(value="/applyViewApp")
	@ResponseBody
	public AjaxRes applyViewApp(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		ar.setSucceed(apply);
		return ar;
	}
	
	/**
	 * 显示页面-企业储备库-查看
	 */
	@RequestMapping(value="/enterpriseDepotViewPage")
	public ModelAndView enterpriseDepotViewPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/crm/apply/clientDepot/enterpriseClientDepot/enterpriseDepotView");
		return mv;
	}
	
	/**
	 * 显示页面-个人咨询登记-查看
	 */
	@RequestMapping(value="/personApplyViewPage")
	public ModelAndView personApplyViewPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/crm/apply/person/personApply/personApplyView");
		return mv;
	}
	
	/**
	 * 显示页面-个人储备库-查看
	 */
	@RequestMapping(value="/personDepotViewPage")
	public ModelAndView personDepotViewPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/crm/apply/clientDepot/personClientDepot/personDepotView");
		return mv;
	}
	
	/**
	 * 显示页面-企业咨询登记-修改
	 */
	@RequestMapping(value="/enterpriseApplyEditPage")
	public ModelAndView enterpriseApplyEditPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			apply = applyService.selectOneApply(apply);
			mv.getModelMap().put("apply", apply);
			List<C_dictype> clientSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");
			mv.getModelMap().put("clientSourceList", clientSourceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/crm/apply/enterprise/enterpriseApply/enterpriseApplyEdit");
		return mv;
	}
	
	/**
	 * 显示页面-企业储备库-修改
	 */
	@RequestMapping(value="/enterpriseDepotEditPage")
	public ModelAndView enterpriseDepotEditPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		List<C_dictype> clientSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");
		mv.getModelMap().put("clientSourceList", clientSourceList);
		mv.setViewName("/crm/apply/clientDepot/enterpriseClientDepot/enterpriseDepotEdit");
		return mv;
	}
	
	/**
	 * 显示页面-个人咨询登记-修改
	 */
	@RequestMapping(value="/personApplyEditPage")
	public ModelAndView personApplyEditPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		List<C_dictype> clientSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");
		mv.getModelMap().put("clientSourceList", clientSourceList);
		mv.setViewName("/crm/apply/person/personApply/personApplyEdit");
		return mv;
	}
	
	/**
	 * 显示页面-个人储备库-修改
	 */
	@RequestMapping(value="/personDepotEditPage")
	public ModelAndView personDepotEditPage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		apply = applyService.selectOneApply(apply);
		mv.getModelMap().put("apply", apply);
		List<C_dictype> clientSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");
		mv.getModelMap().put("clientSourceList", clientSourceList);
		mv.setViewName("/crm/apply/clientDepot/personClientDepot/personDepotEdit");
		return mv;
	}
	
	/**
	 * 执行操作-更新
	 */
	@RequestMapping(value="/updateOneApply")
	@ResponseBody
	public AjaxRes updateOneApply(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		apply.setUnit_uid(user.getUnit_uid());
		apply.setUpdateUserName(user.getUser_name());
		try{
			ar.setSucceed(applyService.updateOneApply(user,apply));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-企业咨询登记-删除
	 */
	@RequestMapping(value="/enterpriseApplyDelPage")
	public ModelAndView enterpriseApplyDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/enterprise/enterpriseApply/enterpriseApplyDel");
		return mv;
	}
	
	/**
	 * 显示页面-企业储备库-删除
	 */
	@RequestMapping(value="/enterpriseDepotDelPage")
	public ModelAndView enterpriseDepotDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/clientDepot/enterpriseClientDepot/enterpriseDepotDel");
		return mv;
	}
	
	/**
	 * 显示页面-个人咨询登记-删除
	 */
	@RequestMapping(value="/personApplyDelPage")
	public ModelAndView personApplyDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/person/personApply/personApplyDel");
		return mv;
	}
	
	/**
	 * 显示页面-个人储备库-删除
	 */
	@RequestMapping(value="/personDepotDelPage")
	public ModelAndView personDepotDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/clientDepot/personClientDepot/personDepotDel");
		return mv;
	}
	
	/**
	 * 执行操作-删除
	 */
	@RequestMapping(value="/deleteOneApply")
	@ResponseBody
	public AjaxRes deleteOneApply(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(applyService.deleteOneApply(SystemSession.getUserSession(),apply));
		return ar;
	}
	
	/**
	 * 显示页面-同意受理，转入受理申请
	 */
	@RequestMapping(value="/showAgreePage")
	public ModelAndView showAgreePage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/agreeToAccept");
		return mv;
	}
	
	/**
	 * 执行操作-同意受理，转入受理申请
	 */
	@RequestMapping(value="/agreeToAccept")
	@ResponseBody
	public AjaxRes agreeToAccept(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		apply.setUnit_uid(user.getUnit_uid());
		apply.setUpdateUserName(user.getUser_name());
		ar.setSucceed(applyService.agreeToAccept(user,apply));
		return ar;
	}
	
	/**
	 * 显示页面-不同意受理，转入客户储备库
	 */
	@RequestMapping(value="/showDisagreePage")
	public ModelAndView showDisagreePage(Crm_apply apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/disagreeToAccept");
		mv.getModelMap().put("apply", apply);
		return mv;
	}
	
	/**
	 * 执行操作-不同意受理，转入客户储备库
	 */
	@RequestMapping(value="/disagreeToAccept")
	@ResponseBody
	public AjaxRes disagreeToAccept(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		apply.setUnit_uid(user.getUnit_uid());
		apply.setUpdateUserName(user.getUser_name());
		ar.setSucceed(applyService.disagreeToAccept(user,apply));
		return ar;
	}
	
	/**
	 * 判断客户名称是否重复(这个不用了)
	 */
	@RequestMapping(value="/isExistClientName")
	@ResponseBody
	public AjaxRes isExistClientName(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(applyService.isExistClientName(apply));
		return ar;
	}
	
	/**
	 * 根据企业名称判断是否是黑名单企业
	 */
	@RequestMapping(value="/isExistBadClient")
	@ResponseBody
	public AjaxRes isExistBadClient(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(applyService.isExistBadClient(apply));
		return ar;
	}
	
	/**
	 * 根据身份证号码判断是否是黑名单个人
	 */
	@RequestMapping(value="/isExistBadPerson")
	@ResponseBody
	public AjaxRes isExistBadPerson(@RequestBody Crm_apply apply){
		AjaxRes ar = new AjaxRes();
		apply.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(applyService.isExistBadPerson(apply));
		return ar;
	}
	
	/**
	 * 显示页面-企业咨询登记-高级查询
	 */
	@RequestMapping(value="/enterpriseApplyAdQuery")
	public ModelAndView enterpriseApplyAdQuery(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/enterprise/enterpriseApply/enterpriseApplyAdQuery");
		return mv;
	}
	
	/**
	 * 显示页面-个人咨询登记-高级查询
	 */
	@RequestMapping(value="/personApplyAdQuery")
	public ModelAndView personApplyAdQuery(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/person/personApply/personApplyAdQuery");
		return mv;
	}
	
	/**
	 * 显示页面-企业储备库-高级查询
	 */
	@RequestMapping(value="/enterpriseDepotAdQuery")
	public ModelAndView enterpriseDepotAdQuery(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/clientDepot/enterpriseClientDepot/enterpriseDepotAdQuery");
		return mv;
	}
	
	/**
	 * 显示页面-个人储备库-高级查询
	 */
	@RequestMapping(value="/personDepotAdQuery")
	public ModelAndView personDepotAdQuery(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/apply/clientDepot/personClientDepot/personDepotAdQuery");
		return mv;
	}
	
	//---------------记录添加------------------------
	/**
	 * 查询企业记录分页列表 
	 */
	@RequestMapping(value="/selectRegisterPageTable")
	@ResponseBody
	public AjaxRes selectRegisterPageTable(@RequestBody PageTable<Crm_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = applyService.selectRegisterPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
}
