package com.zjm.pro.arcMove.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.pro.arcMove.service.ArcMoveService;
import com.zjm.pro.db.model.Pro_arcMove;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/arcMove")
public class arcMoveAction {
	
	@Resource
	private ArcMoveService arcMoveService;
	@Resource
	private SysDicDataService sysDicDataService;
	@Resource
	private DicTypeService dicTypeService;
	
	public void  initSelect(ModelAndView mv){
		List<C_dictype> projectSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='cb2b7adef9c740daa4c43fda3d4d4d11'");//获取分类处置划分下拉框;
		mv.getModelMap().put("projectSourceList",projectSourceList);
		
		List<C_dictype> arcTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='8369e90fea71447083326eba9fceb5a7'");//获取档案类别下拉框;
		mv.getModelMap().put("arcTypeList",arcTypeList);
		
		
	}
	/**
	 * 档案分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_arcMove> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		//根据业务ID(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			wheresql.append(" and apply_ID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		//根据档案记录ID(arcMoveRec_ID)
		if(pageTable.getQueryCondition().getArcMoveRec_ID() != null && !"".equals(pageTable.getQueryCondition().getArcMoveRec_ID())){
			wheresql.append(" and arcMoveRec_ID = \'"+pageTable.getQueryCondition().getArcMoveRec_ID()+"\'");
		}
		
		//根据状态值(status)
		if(pageTable.getQueryCondition().getIsMove() != null && !"".equals(pageTable.getQueryCondition().getIsMove())){
			wheresql.append(" and isMove = "+pageTable.getQueryCondition().getIsMove());
		}
		return wheresql.toString();		
	}
	
	/**
	 * 获取档案移交记录table
	 * selectArcMovePageTable
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectArcMovePageTable")
	@ResponseBody
	public AjaxRes selectArcMovePageTable(@RequestBody PageTable<Pro_arcMove> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = arcMoveService.selectArcMovePageTables(pageTable);		
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 
	 * @Title: returnArcAddPage   
	 * @Description: 跳转到档案新增页面
	 * @param: @param entityID
	 * @param: @return      
	 * @return: ModelAndView      
	 * @throws
	 */
	@RequestMapping(value="/returnArcAddPage")
	public ModelAndView returnArcAddPage(Pro_arcMove pro_arcMove){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("pro_arcMove",pro_arcMove);
		initSelect(mv);//获取下拉框
		mv.setViewName("/project/arcMove/arcMoveDetail/arcMoveDetailAdd");
		return mv;
	}
	
	/**
	 * 新增单个档案信息
	 * @param pro_arcMove
	 * @return
	 */
	@RequestMapping(value="/insertOneArcMove", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneArcMove(@RequestBody Pro_arcMove pro_arcMove){
		Boolean b = false;	
		if(pro_arcMove  != null){
			try {
				b = arcMoveService.insertOneArcMoveInfo(SystemSession.getUserSession(), pro_arcMove);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 批量新增单个档案信息
	 * @param pro_arcMove
	 * @return
	 */
	@RequestMapping(value="/insertArcMoves", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertArcMoves(@RequestBody Pro_arcMove pro_arcMove){
		Boolean b = false;	
		if(pro_arcMove  != null){
			try {
				b = arcMoveService.insertArcMoves(SystemSession.getUserSession(), pro_arcMove);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 移交档案-更新新增档案状态为已移交
	 * @param pro_arcMove
	 * @return
	 */
	@RequestMapping(value="/turnArcMove", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes turnArcMove(@RequestBody Pro_arcMove pro_arcMove){
		Boolean b = false;	
		if(pro_arcMove  != null){
			try {
				b = arcMoveService.turnArcMove(SystemSession.getUserSession(), pro_arcMove);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 删除单个档案信息
	 * @param pro_arcMove
	 * @return
	 */
	@RequestMapping(value="/delOneArcMove", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOneArcMove(@RequestBody Pro_arcMove pro_arcMove){
		Boolean b = false;	
		if(pro_arcMove  != null){
			try {
				b = arcMoveService.deleteOneArcMoveInfo(SystemSession.getUserSession(), pro_arcMove);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	
	//跳转到列表删除页面
	@RequestMapping(value="/returnArcMoveDelPage")
	public ModelAndView returnArcMoveDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/common_del");
		return mv;
	}
	/**
	 * 跳转到确认接收页面
	 * @param arcMoveRec
	 * @return
	 */
	@RequestMapping(value="/returnArcMoveAcceptPage")
	public ModelAndView returnArcMoveAcceptPage(Pro_arcMove arcMove){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("arcMove",arcMove);
		mv.setViewName("/project/arcMove/arcMoveList/arcMoveAccept");
		return mv;
	}
	/**
	 * 确认接收
	 * @param pro_arcMove
	 * @return
	 */
	@RequestMapping(value="/arcMoveAccept", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes arcMoveAccept(@RequestBody Pro_arcMove pro_arcMove){
		Boolean b = false;	
		if(pro_arcMove  != null){
			try {
				b = arcMoveService.arcMoveAccept(SystemSession.getUserSession(), pro_arcMove);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 跳转到批量新增档案页面
	 * @param pro_arcMove
	 * @return
	 */
	@RequestMapping(value="/returnArcAddsPage")
	public ModelAndView returnArcAddsPage(Pro_arcMove pro_arcMove){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("pro_arcMove",pro_arcMove);
		initSelect(mv);//获取下拉框
		mv.setViewName("/project/arcMove/arcMoveDetail/arcMoveDetailAdds");
		return mv;
	}
	/**
	 * 获取档案类别树
	 * @return
	 */
	@RequestMapping(value="/selectArcMoveTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectArcMoveTree(String id){
		//List<SysDicData> list=sysDicDataService.selectModulesDicList("");
		String ids="f1ab5bf4aa3948e690e808d9127e7d6b/09293ecfcb5e43e4b32e875c5ea8d587";
		List<SysDicData> list=sysDicDataService.selectMultiLevelSortDicNoEableList("",ids);
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		//mapList.add(map);
		for (SysDicData info : list) {
			map = new HashMap<String, Object>();
			map.put("id", info.getId());
			map.put("pId", info.getPid());
			map.put("name", info.getName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
}
