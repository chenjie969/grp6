package com.zjm.crm.clientMaterial.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_clientfiles;
import com.zjm.crm.db.model.Crm_materialDetail;
import com.zjm.crm.db.model.Crm_materialModel;
import com.zjm.crm.db.model.Crm_materialTree;
import com.zjm.crm.db.model.Crm_oldClientName;
import com.zjm.crm.db.model.UploadParam;
import com.zjm.crm.filesUpload.service.FilesUploadService;
import com.zjm.crm.materialDetail.service.MaterialDetailService;
import com.zjm.crm.materialModel.service.MaterialModelService;
import com.zjm.crm.materialTree.service.MaterialTreeService;
import com.zjm.crm.oldClientName.service.OldClientNameService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller  
@RequestMapping(value="/client/clientMaterial")
public class ClientMaterialAction {

	@Resource
	private ClientService clientService;
	
	@Resource
	private MaterialTreeService materialTreeService;
	@Resource
	private MaterialModelService materialModelService;
	@Resource
	private MaterialDetailService materialDetailService;
	//附件上传service
	@Resource
	private FilesUploadService filesUploadService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private OldClientNameService oldClientNameService;	
		
		
	
	//客户资料清单
	@RequestMapping(value="/clientMaterialNeedSubmit")
	public ModelAndView clientMaterialNeedSubmit(UploadParam uploadParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		Client client = new Client();
		Crm_materialModel materialModel = new Crm_materialModel();
		
		List<Crm_materialTree> allMaterialTreeList  = new ArrayList<>();
		List<Crm_materialTree> materialTreeList  = new ArrayList<>();
		if(null != uploadParam.getClientID()){
			client= clientService.selectOneClientByWheresql(" and client_ID = \'"+uploadParam.getClientID()+"\'");
			//获取用户曾用名
			String wheresql = " and client_ID = \'" + client.getClient_ID() + "\'";
			String oldClientName = "";
			List<Crm_oldClientName> oldClientNames = oldClientNameService.selectOldClientNameList(wheresql);
			if (oldClientNames !=null) {
				for (Crm_oldClientName crm_oldClientName : oldClientNames) {
					oldClientName = oldClientName + crm_oldClientName.getOldClientName()+ ",";
				}
				client.setOldClientName(oldClientName);
			}
			
			if("01".equals(client.getClientTypeID()) ){//企业客户;
				uploadParam.setClientFileType("dd8413aadf0945abb1ce600aa8fe45c8");
				String whereSql = " and clientTypeID = 01 and status = 1 ";
				materialModel = materialModelService.selectOneMaterialModelByWheresql(whereSql);//查询企业客户模板
			}else{//个人客户;
				uploadParam.setClientFileType("dac960048cac4e44ac58ac574c07d125");
				String whereSql = " and clientTypeID != 01  and status = 1 ";
				materialModel = materialModelService.selectOneMaterialModelByWheresql(whereSql);//查询个人客户模板
			}
		}
		if(null != materialModel){
			String materialModel_ID = " and materialModel_ID = \'"+materialModel.getMaterialModel_ID()+"\' order by order_id ";
			//获取所有客户资料类型:
			allMaterialTreeList = materialTreeService.selectMaterialTreeList(materialModel_ID);
			
			for (Crm_materialTree crm_materialTree : allMaterialTreeList) {//遍历客户资料类型
				if(crm_materialTree.getMaterialTreeLevel() == 1){//第一级:
					materialTreeList.add(crm_materialTree);//获取客户资料类型下的子类型
					String pmaterialTree_ID = " and pmaterialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\' order by order_id ";
					List<Crm_materialTree> selectMaterialTreeList = materialTreeService.selectMaterialTreeList(pmaterialTree_ID);
					crm_materialTree.setMaterialTreeList(selectMaterialTreeList);//将子类型下放在父类型中;
				}
			}
			for (Crm_materialTree crm_materialTree : materialTreeList) {//遍历父客户资料类型,获取资料类型下的客户资料清单明细
				
				String  materialTree_ID = " and materialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\' order by order_id ";
				
				List<Crm_materialDetail> materialDetailList = materialDetailService.selectMaterialDetailListByWheresql(materialTree_ID);
				
				for (Crm_materialDetail crm_materialDetail : materialDetailList) {//遍历客户资料清單明細,获取资料清單明細下的客户附件明细
					StringBuffer whereSql = new StringBuffer();
					whereSql.append(" and client_ID = \'"+uploadParam.getClientID()+"\'");
					whereSql.append(" and materialDetail_ID = \'"+crm_materialDetail.getMaterialDetail_ID()+"\'");
					whereSql.append(" and isFile = false ");
					List<Crm_clientfiles> clientfilesList = filesUploadService.selectPictureFilesList(whereSql.toString());
					crm_materialDetail.setClientfilesList(clientfilesList);
				}
				crm_materialTree.setMaterialDetailList(materialDetailList);//将客户资料名称放在父客户资料类型中
				
				//遍历子客户资料类型,获取所有客户资料名称:
				if(null !=crm_materialTree.getMaterialTreeList()){
					List<Crm_materialTree> materialTreeChildList = crm_materialTree.getMaterialTreeList();
					
					for (Crm_materialTree crm_materialTree2 : materialTreeChildList) {
						
						String  materialTree_ID2 = " and materialTree_ID = \'"+crm_materialTree2.getMaterialTree_ID()+"\' order by order_id";
						List<Crm_materialDetail> materialDetailChildList = materialDetailService.selectMaterialDetailListByWheresql(materialTree_ID2);
						
						for (Crm_materialDetail materialDetail : materialDetailChildList) {
							StringBuffer whereSql2 = new StringBuffer();
							whereSql2.append(" and client_ID = \'"+uploadParam.getClientID()+"\'");
							whereSql2.append(" and materialDetail_ID = \'"+materialDetail.getMaterialDetail_ID()+"\'");
							whereSql2.append(" and isFile = false ");
							List<Crm_clientfiles> clientfilesList = filesUploadService.selectPictureFilesList(whereSql2.toString());
							materialDetail.setClientfilesList(clientfilesList);
							
						}
						crm_materialTree2.setMaterialDetailList(materialDetailChildList);
					}
				}
				
				
			}
			
			
			
		}
		mv.setViewName("/crm/client/clientMaterial/clientMaterialNeedSubmit");
		mv.getModelMap().put("client",client);
		//mv.getModelMap().put("maxTreeLevel",maxTreeLevel);
		mv.getModelMap().put("materialTreeList",materialTreeList);
		return mv;
	}
	/**
	 * 客户资料清单配置页面
	 * @return
	 */
	@RequestMapping(value="/selectClientMaterialPage")
	public ModelAndView selectClientMaterialPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/clientMaterialSet/clientMaterialPage");
		return mv;
	}
	
	/**
	 * returnMaterialModelAddPage
	 * @return
	 */
	@RequestMapping(value="/returnMaterialModelAddPage")
	public ModelAndView returnMaterialModelAddPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		
		wheresql=wheresql+" and dicTypePID = \'"+"2624e18b06c34fdabd0df26d51eca41c"+"\'";
		List<C_dictype> clientTypeList = dicTypeService.selectAllDicTypeList(wheresql);
		
		mv.getModel().put("clientTypeList", clientTypeList);
		
		mv.setViewName("/crm/client/clientMaterialSet/materialModelAdd");
		return mv;
	}
	
	/**
	 *新增一条客户资料清单模板
	 */
	@RequestMapping(value="/insertOneMaterialModel")
	@ResponseBody
	public AjaxRes insertOneMaterialModel(@RequestBody Crm_materialModel crm_materialModel){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			b = materialModelService.insertOneMaterialModel(SystemSession.getUserSession(), crm_materialModel);
			if(b){
			   b = true;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 新增/判断客户资料清单模板是否存在
	 */
	@RequestMapping(value="/isExistMaterialModelName")
	@ResponseBody
	public AjaxRes isExistMaterialModelName (@RequestBody Crm_materialModel crm_materialModel){
		AjaxRes ar = new AjaxRes();
		crm_materialModel.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			ar.setSucceed(materialModelService.isExistMaterialModelName(crm_materialModel));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 分页查询客户资料清单模板列表
	 */
	@RequestMapping(value="/selectMaterialModelPageTable")
	@ResponseBody
	public AjaxRes selectMaterialModelPageTable(@RequestBody PageTable<Crm_materialModel> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = materialModelService.selectMaterialModelPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryConditionSql(PageTable<Crm_materialModel> pageTable) {
		if(pageTable==null){
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and materialModelName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		if ( null != pageTable.getQueryCondition() && null!= pageTable.getQueryCondition().getStatus() && null != pageTable.getQueryCondition().getStatus()) {
			wheresql.append(" and status = 1 ");
		}
		return wheresql.toString();
	}
	
	
	/**
	 * 跳转到客户资料清单修改页面
	 */
	@RequestMapping(value="/returnClientMaterialEditPage")
	public ModelAndView returnClientMaterialEditPage(Crm_materialModel crm_materialModel){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Crm_materialModel materialModel = new Crm_materialModel();
		if(null != crm_materialModel.getMaterialModel_ID()){
			String  materialModel_ID = " and materialModel_ID = \'"+crm_materialModel.getMaterialModel_ID()+"\'";
			materialModel  = materialModelService.selectOneMaterialModelByWheresql(materialModel_ID);
		}
		mv.getModelMap().put("materialModel",materialModel);
		mv.setViewName("/crm/client/clientMaterialSet/materialModelEdit");
		return mv;
	}
	/**
	 * 跳转到客户资料清单查看页面
	 */
	@RequestMapping(value="/returnMaterialViewPage")
	public ModelAndView returnMaterialViewPage(Crm_materialModel crm_materialModel){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Crm_materialModel materialModel = new Crm_materialModel();
		if(null != crm_materialModel.getMaterialModel_ID()){
			String  materialModel_ID = " and materialModel_ID = \'"+crm_materialModel.getMaterialModel_ID()+"\'";
			materialModel  = materialModelService.selectOneMaterialModelByWheresql(materialModel_ID);
		}
		mv.getModelMap().put("materialModel",materialModel);
		mv.setViewName("/crm/client/clientMaterialSet/materialModelInfo");
		return mv;
	}
	
	/**
	 * updateOneMaterialModel
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/updateOneMaterialModel")
	@ResponseBody
	public AjaxRes updateOneMaterialModel(@RequestBody Crm_materialModel crm_materialModel){
		AjaxRes ar = new AjaxRes();
		if(null != crm_materialModel.getMaterialModel_ID()){
			Boolean b = materialModelService.updateOneMaterialModel(SystemSession.getUserSession(),crm_materialModel);
			ar.setSucceed(b);
		}
		return ar;
	}
	@RequestMapping(value="/setMaterialModule")
	public ModelAndView setMaterialModule(Crm_materialModel crm_materialModel){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Crm_materialModel materialModel = new Crm_materialModel();
				 
		try {
			String  materialModel_ID = " and materialModel_ID = \'"+crm_materialModel.getMaterialModel_ID()+"\'";
			materialModel  = materialModelService.selectOneMaterialModelByWheresql(materialModel_ID);
			mv.getModel().put("materialModel", materialModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/crm/client/clientMaterialSet/materialTreeSet");
		return mv;
	}
	
	/**returnMaterialModelCopyPage
	 * 跳转到客户资料清单copy页面
	 */
	@RequestMapping(value="/returnMaterialModelCopyPage")
	public ModelAndView returnMaterialModelCopyPage(Crm_materialModel crm_materialModel){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Crm_materialModel materialModel = new Crm_materialModel();
		if(null != crm_materialModel.getMaterialModel_ID()){
			String  materialModel_ID = " and materialModel_ID = \'"+crm_materialModel.getMaterialModel_ID()+"\'";
			materialModel  = materialModelService.selectOneMaterialModelByWheresql(materialModel_ID);
		}
		mv.getModelMap().put("materialModel",materialModel);
		mv.setViewName("/crm/client/clientMaterialSet/materialModelCopy");
		return mv;
	}
	
	
	
	/**
	 *  拷贝客户资料清单
	 */
	@RequestMapping(value="/copyMaterialModel")
	@ResponseBody
	public AjaxRes copyMaterialModel(@RequestBody Crm_materialModel crm_materialModel){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			b = materialModelService.copyMaterialModel(SystemSession.getUserSession(), crm_materialModel);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
}
