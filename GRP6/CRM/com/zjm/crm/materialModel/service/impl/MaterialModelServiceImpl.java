package com.zjm.crm.materialModel.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_materialDetailMapper;
import com.zjm.crm.db.map.Crm_materialModelMapper;
import com.zjm.crm.db.map.Crm_materialTreeMapper;
import com.zjm.crm.db.model.Crm_materialDetail;
import com.zjm.crm.db.model.Crm_materialModel;
import com.zjm.crm.db.model.Crm_materialTree;
import com.zjm.crm.materialModel.service.MaterialModelService;
import com.zjm.util.Tool;
@Service("materialModelService")
@Transactional
public class MaterialModelServiceImpl implements  MaterialModelService{
	@Resource
	private Crm_materialModelMapper crm_materialModelMapper;
	@Resource
	private Crm_materialTreeMapper crm_materialTreeMapper;
	@Resource
	private Crm_materialDetailMapper crm_materialDetailMapper;
	@Resource
	private LogService logService;
	
	public Crm_materialModel selectOneMaterialModelByWheresql(String whereSql) {
		Crm_materialModel   materialModel = new Crm_materialModel();
		materialModel =	crm_materialModelMapper.selectOneMaterialModel(whereSql);
		return materialModel;
	}
   
	/**
	 * 新增客户资料清单模板
	 */
	public Boolean insertOneMaterialModel(User user, Crm_materialModel crm_materialModel) {
		crm_materialModel.setMaterialModel_ID(Tool.createUUID32());
		crm_materialModel.setUnit_uid(user.getUnit_uid());
		crm_materialModel.setUnit_uidName(user.getUnit_uidName());
		crm_materialModel.setUpdateUserName(user.getUser_name());
		
		if(crm_materialModelMapper.insertOneMaterialModel(crm_materialModel)==1){
			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料模板ID="+crm_materialModel.getMaterialModel_ID());
			return true;
		}
		else{
			return false;
		}
	}
    /**
	 * 判断客户资料清单模板是否存在
     */
	public Boolean isExistMaterialModelName(Crm_materialModel crm_materialModel) {
		if (crm_materialModelMapper.isExistMaterialModelName(crm_materialModel) == 0) {
			return true;
		}
		return false;
	}
   /**
    * 查询客户资料清单模板分页列表
    */
	public PageTable<Crm_materialModel> selectMaterialModelPageTable(PageTable<Crm_materialModel> pageTable) {
		pageTable.setRows(crm_materialModelMapper.selectMaterialModelPageTable(pageTable));
		pageTable.setTotal(crm_materialModelMapper.selectMaterialModelPageTable_Count(pageTable));
		return pageTable;
	}
    /**
     * 修改客户资料清单模板
     */
	public Boolean updateOneMaterialModel(User user, Crm_materialModel crm_materialModel) {
		Integer returnInt = 0;
		Boolean b = false;
		returnInt  = crm_materialModelMapper.updateOneMaterialModel(crm_materialModel);
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "修改", "修改客户资料模板ID="+crm_materialModel.getMaterialModel_ID());
			b = true;
			
		}
		return b;
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
     * 拷贝客户资料模板
     */
	public Boolean copyMaterialModel(User user, Crm_materialModel crm_materialModel) {
		Boolean b = false;
		Integer returnInt= 0;
		Integer returnInt1 =0;
		Integer returnInt2 = 0;
		Integer returnInt3 = 0;
		Integer returnInt4 = 0;
		String whereSql = " and  materialModel_ID = \'"+crm_materialModel.getMaterialModel_ID()+"\'";
		Crm_materialModel oldMaterialModel = crm_materialModelMapper.selectOneMaterialModel(whereSql);
		//拷贝新客户资料模板
		crm_materialModel.setMaterialModel_ID(Tool.createUUID32());
		crm_materialModel.setUnit_uid(oldMaterialModel.getUnit_uid());
		crm_materialModel.setUnit_uidName(oldMaterialModel.getUnit_uidName());
		crm_materialModel.setUpdateUserName(user.getUser_name());
		crm_materialModel.setUpdateDateTime(new Date());
		
		 returnInt = crm_materialModelMapper.insertOneMaterialModel(crm_materialModel);
		if(returnInt>0){//拷贝成功
			//copyMaterialTree(user,oldMaterialModel,crm_materialModel);//拷贝客户资料类型
			//根据模板id在资料类型表中进行查询:
			String whereSql1 = " and  pmaterialTree_ID = \'"+oldMaterialModel.getMaterialModel_ID()+"\'"; //查询根节点下的节点 	
			List<Crm_materialTree> materialTreeList = crm_materialTreeMapper.selectMaterialTreeList(whereSql1);  
			//遍历查询结果
			for (Crm_materialTree crm_materialTree : materialTreeList) {
				String oldMaterialTree_ID = crm_materialTree.getMaterialTree_ID();
				//拷贝新的客户资料类型
				crm_materialTree.setMaterialTree_ID(Tool.createUUID32());
				crm_materialTree.setMaterialModel_ID(crm_materialModel.getMaterialModel_ID());//新的MaterialModel_ID
				crm_materialTree.setPmaterialTree_ID(crm_materialModel.getMaterialModel_ID());
				crm_materialTree.setMaterialTreeFullCode(crm_materialTree.getMaterialTree_ID()+"/");
				
				 returnInt1 = crm_materialTreeMapper.insertOneMaterialTree(crm_materialTree);
				if(returnInt1>0){
					String whereSql3 = " and  materialTree_ID = \'"+oldMaterialTree_ID+"\'";
					List<Crm_materialDetail> oldMaterialDetailList = crm_materialDetailMapper.selectMaterialDetailList(whereSql3);
					for (Crm_materialDetail materialDetail : oldMaterialDetailList) {
						
						materialDetail.setMaterialTree_ID(crm_materialTree.getMaterialTree_ID());
						materialDetail.setMaterialDetail_ID(Tool.createUUID32());
						materialDetail.setMaterialModel_ID(crm_materialTree.getMaterialModel_ID());
						 returnInt2 = crm_materialDetailMapper.insertOneMaterialDetail(materialDetail);
			    		if(returnInt2>0){
			    			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料类型ID="+materialDetail.getMaterialTree_ID());
			    		}
						
					}
					
					logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料模板ID="+crm_materialTree.getMaterialTree_ID());
				}
				
				//以类型id为父id 查询所有子类型
				String whereSql2 = " and  pmaterialTree_ID = \'"+oldMaterialTree_ID+"\'"; //查询根节点下的节点 
				
				List<Crm_materialTree> materialTreeList2 = crm_materialTreeMapper.selectMaterialTreeList(whereSql2);  
				//遍历查询结果:
				for (Crm_materialTree crm_materialTree2 : materialTreeList2) {
					
					String materialTreeFullCode3 = crm_materialTree2.getMaterialTreeFullCode().replace(oldMaterialTree_ID, crm_materialTree.getMaterialTree_ID());
					crm_materialTree2.setMaterialTreeFullCode(materialTreeFullCode3);
					
					String oldMaterialTree_ID2 = crm_materialTree2.getMaterialTree_ID();
					
					crm_materialTree2.setMaterialTree_ID(Tool.createUUID32());
					crm_materialTree2.setMaterialModel_ID(crm_materialTree.getMaterialModel_ID());//新的MaterialModel_ID
					crm_materialTree2.setPmaterialTree_ID(crm_materialTree.getMaterialTree_ID());
					
					String materialTreeFullCode2 = crm_materialTree2.getMaterialTreeFullCode().replace(oldMaterialTree_ID2,crm_materialTree2.getMaterialTree_ID());
					
					crm_materialTree2.setMaterialTreeFullCode(materialTreeFullCode2);
					
					 returnInt3 = crm_materialTreeMapper.insertOneMaterialTree(crm_materialTree2);
					if(returnInt3>0){
						
						String whereSql3 = " and  materialTree_ID = \'"+oldMaterialTree_ID2+"\'";//以materialTree_ID为条件查询Crm_materialDetail表数据
						List<Crm_materialDetail> oldMaterialDetailList = crm_materialDetailMapper.selectMaterialDetailList(whereSql3);
						for (Crm_materialDetail crm_materialDetail : oldMaterialDetailList) {
							
							crm_materialDetail.setMaterialTree_ID(crm_materialTree2.getMaterialTree_ID());
							crm_materialDetail.setMaterialDetail_ID(Tool.createUUID32());
							crm_materialDetail.setMaterialModel_ID(crm_materialTree2.getMaterialModel_ID());
							 returnInt4 = crm_materialDetailMapper.insertOneMaterialDetail(crm_materialDetail);
				    		if(returnInt4>0){
				    			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料类型ID="+crm_materialTree.getMaterialTree_ID());
				    		}
							
						}
						
						logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料类型ID="+crm_materialTree2.getMaterialTree_ID());
					}
				}
			}
			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料模板ID="+crm_materialModel.getMaterialModel_ID());
			b =  true;
			
		}
		return b;
	}
	
    /**
     * @param user
     * @param oldMaterialModel
     * @param newMaterialModel
     */
    public void copyMaterialTree(User user,Crm_materialModel oldMaterialModel,Crm_materialModel newMaterialModel){
    	String whereSql = " and  materialModel_ID = \'"+oldMaterialModel.getMaterialModel_ID()+"\'";  	
    	List<Crm_materialTree> materialTreeList = crm_materialTreeMapper.selectMaterialTreeList(whereSql);    	
    	for (Crm_materialTree crm_materialTree : materialTreeList) {
    		
    		String oldMaterialTree_ID = crm_materialTree.getMaterialTree_ID();
    		
    		crm_materialTree.setMaterialTree_ID(Tool.createUUID32());
    		crm_materialTree.setMaterialModel_ID(newMaterialModel.getMaterialModel_ID());
    		String materialTreeFullCode = crm_materialTree.getMaterialTreeFullCode().replace(oldMaterialModel.getMaterialModel_ID(),newMaterialModel.getMaterialModel_ID());
    		materialTreeFullCode.replace(oldMaterialTree_ID, crm_materialTree.getMaterialTree_ID());
    		crm_materialTree.setMaterialTreeFullCode(materialTreeFullCode);
    		
    		Integer returnInt = crm_materialTreeMapper.insertOneMaterialTree(crm_materialTree);
    		if(returnInt>0){
    			copyMaterialDetail(user,crm_materialTree);//拷贝客户资料类型
    			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料类型ID="+crm_materialTree.getMaterialTree_ID());
    		}
		}
    	return;
    			 
    }
    //拷贝客户资料名称
	public  void copyMaterialDetail(User user,Crm_materialTree crm_materialTree){
		String whereSql = " and  materialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\'";
		List<Crm_materialDetail> oldMaterialDetailList = crm_materialDetailMapper.selectMaterialDetailList(whereSql);
		for (Crm_materialDetail crm_materialDetail : oldMaterialDetailList) {
			crm_materialDetail.setMaterialDetail_ID(Tool.createUUID32());
			crm_materialDetail.setMaterialTree_ID(crm_materialTree.getMaterialTree_ID());
			crm_materialDetail.setMaterialModel_ID(crm_materialTree.getMaterialModel_ID());
			Integer returnInt = crm_materialDetailMapper.insertOneMaterialDetail(crm_materialDetail);
			if(returnInt>0){
    			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料名称ID="+crm_materialDetail.getMaterialDetail_ID());
    		}
		}
		return;
	}

}
