package com.zjm.crm.materialTree.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_materialDetailMapper;
import com.zjm.crm.db.map.Crm_materialTreeMapper;
import com.zjm.crm.db.model.Crm_materialDetail;
import com.zjm.crm.db.model.Crm_materialTree;
import com.zjm.crm.materialDetail.service.MaterialDetailService;
import com.zjm.crm.materialTree.service.MaterialTreeService;
import com.zjm.util.Tool;
@Service("meterialTreeService")
@Transactional
public class MaterialTreeServiceImpl implements  MaterialTreeService{
	@Resource
	private Crm_materialTreeMapper crm_materialTreeMapper;
	@Resource
	private LogService logService;
	@Resource
	private Crm_materialDetailMapper crm_materialDetailMapper;
	@Resource
	private MaterialDetailService materialDetailService;
	
    /**
     *查询所有客户资料类型
     */
	public List<Crm_materialTree> selectMaterialTreeList(String whereSql) {
		List<Crm_materialTree> materialTreeList = new ArrayList<>();
		materialTreeList = crm_materialTreeMapper.selectMaterialTreeList(whereSql);
		for (Crm_materialTree crm_materialTree : materialTreeList) {
			crm_materialTree.setMaterialTreeLevel(getTreeLevel(crm_materialTree));
		}
		return materialTreeList;
	}
	
	
	//获取资料类型树层级
	public static Integer getTreeLevel(Crm_materialTree crm_materialTree) {
		if(null !=  crm_materialTree.getMaterialTreeFullCode()){
			return contain(crm_materialTree.getMaterialTreeFullCode(),"/");
		}else{			
			return 0;
		}
	}
	
	/**
	 * 判断string包含string2 的个数
	 * @param string
	 * @param string2
	 * @return
	 */
	public static Integer contain(String string, String string2){
		int i = string.length() - string.replace(string2, "").length();
		Integer i2 = i / string2.length();
		return i2;
	}

    /**
     * 新增客户资料类型
     */
	public Boolean insertOneMaterialTree(User user, Crm_materialTree crm_materialTree) {
		crm_materialTree.setMaterialTree_ID(Tool.createUUID32());
		crm_materialTree.setUnit_uid(user.getUnit_uid());
		crm_materialTree.setUnit_uidName(user.getUnit_uidName());
		crm_materialTree.setUpdateUserName(user.getUser_name());		
		String materialTreeFullCode = "";
		//判断是否为根几点下的节点:
		if(crm_materialTree.getMaterialModel_ID().equals(crm_materialTree.getPmaterialTree_ID())){//是:
			materialTreeFullCode = crm_materialTree.getMaterialTree_ID();
		}else{//否:
			//根据materialTree_ID获取客户资料类型信息,获取materialTreeFullCode
			String  whereSql = " and materialTree_ID = \'"+crm_materialTree.getPmaterialTree_ID()+"\'";//根据	父客户资料类型树ID作为客户资料类型id查询
			Crm_materialTree materialTree = crm_materialTreeMapper.selectOneMaterialTreeByWhereSql(whereSql);
			materialTreeFullCode =materialTree.getMaterialTreeFullCode()+crm_materialTree.getMaterialTree_ID();
		}		
		crm_materialTree.setMaterialTreeFullCode(materialTreeFullCode+"/");
		
		
		if(crm_materialTreeMapper.insertOneMaterialTree(crm_materialTree)==1){
			if (null == crm_materialTree.getOrder_id()) {
				String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
				wheresql = wheresql + " and pmaterialTree_ID = \'" + crm_materialTree.getPmaterialTree_ID() +"\' ORDER BY  case when order_id is null then 1 else 0 end ,order_id" ;
				List<Crm_materialTree>  materialTreeList = crm_materialTreeMapper.selectMaterialTreeList(wheresql);
				for(int i = 0 ; i < materialTreeList.size() ; i++) {
					Crm_materialTree materialTree = materialTreeList.get(i);
					materialTree.setOrder_id((i+1)+"");
					crm_materialTreeMapper.updateOneaterialTree(materialTree);
				}
			}
			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料类型ID="+crm_materialTree.getMaterialTree_ID());
			return true;
		}
		else{
			return false;
		}
	}

    /**
     *  添加时判断客户资料类型名称是否重复
     */
	public Boolean isExistMaterialTree(String wheresql) {
		return crm_materialTreeMapper.isExistMaterialTree(wheresql)>0;
	}

     /**
      * 根据条件查询单个客户资料类型
      */
	public Crm_materialTree selectOneMaterialTreeByWhereSql(String materialTree_ID) {
		return crm_materialTreeMapper.selectOneMaterialTreeByWhereSql(materialTree_ID);
	}
   
     /**
      * 修改单个客户资料类型
      */
	public Boolean updateOneaterialTree(User user, Crm_materialTree crm_materialTree) {
		Boolean b = false;
		crm_materialTree.setUnit_uid(user.getUnit_uid());
		crm_materialTree.setUnit_uidName(user.getUnit_uidName());
		crm_materialTree.setUpdateUserName(user.getUser_name());
		Integer returnResult = crm_materialTreeMapper.updateOneaterialTree(crm_materialTree);
		if(returnResult>0){
			//修改客户资料名称中的客户资料类型名称:
			String whereSql = " and materialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\'";
			List<Crm_materialDetail> materialDetailList = materialDetailService.selectMaterialDetailListByWheresql(whereSql);
		    for (Crm_materialDetail crm_materialDetail : materialDetailList) {
		    	crm_materialDetail.setMaterialTreeName(crm_materialTree.getMaterialTreeName());
		    	materialDetailService.updateOneMaterialDetail(user,crm_materialDetail);
			}
			logService.insertOneOperatorLogInfo(user,"客户资料清单", "修改", "修改一条客户资料类型表信息ID="+crm_materialTree.getMaterialTree_ID());
		    b = true;
		}
		return b;
	}

    /**
     * 删除单个客户资料类型
     */
	public Boolean deleteOneMaterialTree(User user, Crm_materialTree crm_materialTree) {
		Boolean b = false;
		//根据materialTree_ID删除单个客户资料类型;
		Integer returnResult=0;
		//根据pmaterialTree_ID删除多个客户资料类型;
		Integer returnResult2=0;
		try {
			String wheresql = " and materialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\'";
			returnResult = crm_materialTreeMapper.deleteOneMaterialTreeBySql(wheresql);
			//删除节点下所有的资料名称
			crm_materialDetailMapper.deleteOneMaterialDetailBySql(wheresql);
			
			/*删除此节点下的所有节点*/
			String pmaterialTree_ID = " and pmaterialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\'";
			
			List<Crm_materialTree> materialTreeList = crm_materialTreeMapper.selectMaterialTreeList(pmaterialTree_ID);
			for (Crm_materialTree crm_materialTree2 : materialTreeList) {
				String wheresql1 = " and materialTree_ID = \'"+crm_materialTree2.getMaterialTree_ID()+"\'";
				crm_materialDetailMapper.deleteOneMaterialDetailBySql(wheresql1);
			}
			returnResult2 = crm_materialTreeMapper.deleteOneMaterialTreeBySql(pmaterialTree_ID);
			
			
			logService.insertOneOperatorLogInfo(user,"客户资料清单", "删除", "删除一条客户资料类型信息ID="+crm_materialTree.getMaterialTree_ID());
			logService.insertOneOperatorLogInfo(user,"客户资料清单", "删除", "删除多个客户资料类型信息PID="+crm_materialTree.getMaterialTree_ID());
		    b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b ; 
	
	}

     //查询多个客户资料类型
	public List<Crm_materialTree> selectMaterialTreeByWhereSqL(String wheresql) {
		return crm_materialTreeMapper.selectMaterialTreeList(wheresql);
	}
	
	
	
	
	
	
	

}
