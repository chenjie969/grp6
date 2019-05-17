package com.zjm.pro.assetSealUp.web;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.assetSealUp.service.AssetSealUpService;
import com.zjm.pro.db.model.Pro_assetSealUp;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

import sql.BaseProcessor;


@Controller
@RequestMapping(value = "/project/assetSealUp")
public class AssetSealUpAction {
	@Resource
	private AssetSealUpService assetSeaulUpService;	
	@Resource
	private ProjectService projectService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private BaseProcessor baseProcessor;
    /**
     * 资产查封信息页面
     * @param project_ID
     * @return
     */
	@RequestMapping(value="/openAssetSealUpPage")
	public ModelAndView openAssetSealUpPage(String assetSealUp_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		if (assetSealUp_ID != null && !"".equals(assetSealUp_ID)) {
			Pro_assetSealUp proSeaulUp = assetSeaulUpService.selectOneSealUpInfo(" and assetSealUp_ID = \'"+assetSealUp_ID+"\'");
			mv.getModelMap().put("proSeaulUp", proSeaulUp);
		}
		//单位名称
		List<C_dictype> guarantyOrgList = dicTypeService.selectAllDicTypeList(" and dicTypePID='78ae83f6524d458dbbd522324c80723d'");
		mv.getModelMap().put("guarantyOrgList",guarantyOrgList);
		mv.setViewName("/project/lawAssetSealUp/assetSealUp");
		return mv;		
	}

	/**
	 * 新增资产查封信息表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/insertOrUpdateOneSealUpInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOrUpdateOneSealUpInfo(@RequestBody Pro_assetSealUp proSeaulUp){
		AjaxRes ar=new AjaxRes();
		try{
			if (proSeaulUp != null && proSeaulUp.getAssetSealUp_ID() != null && !"".equals(proSeaulUp.getAssetSealUp_ID())) {
				ar.setSucceed ( assetSeaulUpService.updateOneSealUpInfo(SystemSession.getUserSession(), proSeaulUp));
			} else {
				ar.setSucceed ( assetSeaulUpService.insertOneSeaulUp(SystemSession.getUserSession(), proSeaulUp));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 资产查封明细
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectProSeaulUpPageTables")
	@ResponseBody
	public AjaxRes selectProSeaulUpPageTables(@RequestBody PageTable<Pro_assetSealUp> pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable = assetSeaulUpService.selectProSeaulUpPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 资产查封明细
	 * @param pageTable
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/baseProcessor")
	public AjaxRes baseProcessor() throws SQLException{
		AjaxRes ar =new AjaxRes();
		baseProcessor.executeQuery("select * from user where id=1", null);
		return ar;
	}
	
	private String queryCondition(PageTable<Pro_assetSealUp> pageTable){
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		
		if (pageTable.getSearchText() != null && !"".equals(pageTable.getSearchText())) {
			sb.append(" and ( ");
			sb.append(" plaintiff like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or defendant like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or projectNameList like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or `group` like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" ) ");
		}
		return sb.toString();
	}
	
	
}
