package com.zjm.crm.materialDetail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_materialDetailMapper;
import com.zjm.crm.db.model.Crm_materialDetail;
import com.zjm.crm.filesUpload.service.FilesUploadService;
import com.zjm.crm.materialDetail.service.MaterialDetailService;
import com.zjm.util.Tool;
@Service("materialDetailService")
@Transactional
public class MaterialDetailServiceImpl implements  MaterialDetailService{
	@Resource
	private Crm_materialDetailMapper crm_materialDetailMapper;
	@Resource
	private LogService logService;
	//附件上傳
	@Resource
	private FilesUploadService filesUploadService;
	
	

	public List<Crm_materialDetail> selectMaterialDetailListByWheresql(String whereSql) {
		List<Crm_materialDetail> materialDetailList = crm_materialDetailMapper.selectMaterialDetailList(whereSql);
		/*StringBuffer whereSql2 = new StringBuffer();
		whereSql.append(" and client_ID = \'"+uploadParam.getClientID()+"\'");
		whereSql.append(" and fileType = \'"+uploadParam.getFileTwoType()+"\'");
		whereSql.append(" and isFile = false ");
	
		List<Crm_clientfiles> pictureFilesList = filesUploadService.selectPictureFilesList(whereSql2.toString());*/
			
		return materialDetailList;
	}


    /**
     * 新增一条客户资料
     */
	public Boolean insertOneMaterialDetail(User user, Crm_materialDetail crm_materialDetail) {
		crm_materialDetail.setMaterialDetail_ID(Tool.createUUID32());
		crm_materialDetail.setUnit_uid(user.getUnit_uid());
		crm_materialDetail.setUnit_uidName(user.getUnit_uidName());
		crm_materialDetail.setUpdateUserName(user.getUser_name());		
		if(crm_materialDetailMapper.insertOneMaterialDetail(crm_materialDetail)==1){
			
			if (null == crm_materialDetail.getOrder_id()) {
				String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
				wheresql = wheresql + " and materialTree_ID = \'" + crm_materialDetail.getMaterialTree_ID() +"\' ORDER BY  case when order_id is null then 1 else 0 end ,order_id" ;
				List<Crm_materialDetail>  materialDetailList = crm_materialDetailMapper.selectMaterialDetailList(wheresql);
				for(int i = 0 ; i < materialDetailList.size() ; i++) {
					Crm_materialDetail materialDetail = materialDetailList.get(i);
					materialDetail.setOrder_id((i+1)+"");
					crm_materialDetailMapper.updateOneMaterialDetail(materialDetail);
				}
			}
			logService.insertOneOperatorLogInfo(user, "客户资料清单设置", "添加", "添加客户资料ID="+crm_materialDetail.getMaterialDetail_ID());
			return true;
		}
		else{
			return false;
		}
	}

    /**
     * 获取客户资料列表
     */
	public PageTable<Crm_materialDetail> selectMaterialDetailPageTable(PageTable<Crm_materialDetail> pageTable) {
		List<Crm_materialDetail> materialDetailList = null;
		try {
			materialDetailList = crm_materialDetailMapper.selectMaterialDetailPageTable(pageTable);
			Long total = crm_materialDetailMapper.selectMaterialDetailPageTable_Count(pageTable);
			pageTable.setRows(materialDetailList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

    /**
     * 根据输入条件查询一个客户资料清单
     */
   	public Crm_materialDetail selectOneMaterialDetailByWheresql(String materialDetail_ID) {
		return crm_materialDetailMapper.selectOneMaterialDetailByWheresql(materialDetail_ID);
	}

    /**
     * 删除一个客户资料清单
     */
	public Boolean deleteOneMaterialDetail(User user, Crm_materialDetail crm_materialDetail) {
		Boolean b = false;
		String wheresql = " and materialDetail_ID = \'"+crm_materialDetail.getMaterialDetail_ID()+"\'";
		//根据materialDetail_ID删除一条客户资料清单;
		Integer returnResult = crm_materialDetailMapper.deleteOneMaterialDetailBySql(wheresql);
		if(returnResult== 1 ){
			logService.insertOneOperatorLogInfo(user,"客户资料清单", "删除", "删除一条客户资料清单表信息ID="+crm_materialDetail.getMaterialDetail_ID());
		    b = true;
		}
		return b ; 
	}

    /**
     * 更新一个客户资料
     */
	public Boolean updateOneMaterialDetail(User user, Crm_materialDetail crm_materialDetail) {
		Boolean b = false;
		crm_materialDetail.setUnit_uid(user.getUnit_uid());
		crm_materialDetail.setUnit_uidName(user.getUnit_uidName());
		crm_materialDetail.setUpdateUserName(user.getUser_name());
		Integer returnResult = crm_materialDetailMapper.updateOneMaterialDetail(crm_materialDetail);
		if(returnResult>0){
			logService.insertOneOperatorLogInfo(user,"客户资料清单", "修改", "修改一条客户资料表信息ID="+crm_materialDetail.getMaterialDetail_ID());
		    b = true;
		}
		return b;
	}
	        
	
	
    
	

}
