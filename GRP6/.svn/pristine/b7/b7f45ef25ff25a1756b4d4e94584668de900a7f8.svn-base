package com.zjm.pro.optGuaranty.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_optGuarantyMapper;
import com.zjm.pro.db.model.Pro_optGuaranty;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.optGuaranty.service.OptGuarantyService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
*  @description 保证措施 ServiceImpl
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年7月3日 下午7:50:26
*/
@Service(value="optGuarantyService")
public class OptGuarantyServiceImpl implements OptGuarantyService {
	
	@Resource
	private Pro_optGuarantyMapper  pro_optGuarantyMapper;
	
	@Resource
	private LogService  logService; // 日志接口
	
	@Resource
	private ProjectfilesService  projectfilesService;
	
	/**
	 * @description	添加一条保证措施信息
	 * @author wuhn
	 * @date 2017年7月3日 下午7:29:41
	 */
	public  Boolean insertOneOptGuarantyInfo(User user,Pro_optGuaranty optGuaranty) {
		optGuaranty.setUnit_uid(user.getUnit_uid());
		optGuaranty.setUnit_uidName(user.getUnit_uidName());
		optGuaranty.setUpdateUserName(user.getUser_name());
		optGuaranty.setVersions("v1");
		if(optGuaranty.getGuarantyTypeName().equals("个人信用")){
			optGuaranty.setOptName("个人信用");
		}
		String optGuaranty_ID = optGuaranty.getOptGuaranty_ID();
		Pro_optGuaranty guaranty = null;
		String applyIds = optGuaranty.getApply_ID();
		String[] applyId = applyIds.split(",");
		String appDetailId = optGuaranty.getApplyDetail_ID();
		try {
			if(""!=optGuaranty_ID&&null!=optGuaranty_ID){
				guaranty = pro_optGuarantyMapper.selectOneOptGuarantyInfo(optGuaranty_ID);
			}
			int v2 = 0;
			for (int i = 0; i < applyId.length; i++) {
				//首次新增，手动输入担保信息
				if(guaranty == null){
	//				//主版本id
					String v1Id = Tool.createUUID32();
					optGuaranty.setOptGuaranty_ID(v1Id);
					optGuaranty.setApply_ID("");//主版本不关联项目id
					optGuaranty.setApplyDetail_ID("");
					//先新增一条主版本数据
					int info = pro_optGuarantyMapper.insertOneOptGuarantyInfo(optGuaranty);
					if(info > 0){
						Pro_optGuaranty optGuarnNew = new Pro_optGuaranty();
						BeanUtils.copyProperties(optGuaranty, optGuarnNew, Pro_optGuaranty.class);
						//再新增一条副版本数据
						optGuarnNew.setOptGuaranty_ID(Tool.createUUID32());
						optGuarnNew.setApply_ID(applyId[i]);//福版本关联项目id
						optGuarnNew.setApplyDetail_ID(appDetailId);
						optGuarnNew.setVersions("v2");
						optGuarnNew.setVersionsId(v1Id);
						v2 = pro_optGuarantyMapper.insertOneOptGuarantyInfo(optGuarnNew);
					}
				}else{//选择一条担保措施进行新增
					Pro_optGuaranty optGuarnNewTwo = new Pro_optGuaranty();
					BeanUtils.copyProperties(optGuaranty, optGuarnNewTwo, Pro_optGuaranty.class);
					optGuarnNewTwo.setVersionsId(optGuaranty.getOptGuaranty_ID());
					optGuarnNewTwo.setVersions("v2");
	//				optGuarantynew.setVersionsId(optGuaranty.getOptGuaranty_ID());
					optGuarnNewTwo.setOptGuaranty_ID(Tool.createUUID32());
					v2 = pro_optGuarantyMapper.insertOneOptGuarantyInfo(optGuarnNewTwo);
				}
			}
			if(v2>0){
				logService.insertOneOperatorLogInfo(user, "担保措施", "添加", "添加一条反担保措施");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * @description   保证措施ID   optGuaranty_ID 删除保证措施信息
	 * @author wuhn
	 * @date 2017年7月3日 下午7:26:41
	 */
	public	Boolean deleteOneOptGuarantyInfo(User user,String optGuaranty_ID) {
		try {
			int info = pro_optGuarantyMapper.deleteOneOptGuarantyInfo(optGuaranty_ID);
			if(info > 0){
				logService.insertOneOperatorLogInfo(user, "担保措施", "删除", "删除一条反担保措施");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
    
    /**
     * @description	 保证措施ID   optGuaranty_ID 动态修改 保证措施信息
     * @author wuhn
     * @date 2017年7月3日 下午7:27:44
     */
	public	Boolean updateOneOptGuarantyInfo(User user,Pro_optGuaranty optGuaranty) {
		optGuaranty.setUpdateUserName(user.getUser_name());
		try {
			int info = pro_optGuarantyMapper.updateOneOptGuarantyInfo(optGuaranty);
			if(info > 0){
				logService.insertOneOperatorLogInfo(user, "担保措施", "修改", "修改担保措施");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

    /**
     * @description 保证措施ID   optGuaranty_ID 获取保证措施信息
     * @author wuhn
     * @date 2017年7月3日 下午7:27:25
     */
	public	Pro_optGuaranty selectOneOptGuarantyInfo(String optGuaranty_ID) {
		return pro_optGuarantyMapper.selectOneOptGuarantyInfo(optGuaranty_ID);
	}
    
    /**
     * @description  查询保证措施分页列表
     * @author wuhn
     * @date 2017年7月3日 下午7:38:24
     */
	public	PageTable<Pro_optGuaranty>  selectOptGuarantyPageTables(PageTable<Pro_optGuaranty>  pageTable) {
		List<Pro_optGuaranty> list = new ArrayList<>();
		try {
			list = pro_optGuarantyMapper.selectOptGuarantyPageTables(pageTable);
			for (Pro_optGuaranty opt : list) {
				List<Pro_projectfiles> fileList = projectfilesService.selectProFilesListByEntityID(new User(), opt.getOptGuaranty_ID()+"_realize");
				opt.setFilesList(fileList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count=0;
		try {
			count = pro_optGuarantyMapper.selectOptGuarantyPageTables_Count(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageTable.setTotal(Long.valueOf(count)); //总记录数
		pageTable.setRows(list); // 分页记数
		return pageTable;
	}
    
    /**
     * @description   计算保证措施 分页列表 总记录数
     * @author wuhn
     * @date 2017年7月3日 下午7:38:57
     */
	public	int selectOptGuarantyPageTables_Count(PageTable<Pro_optGuaranty>  pageTable) {
		return pro_optGuarantyMapper.selectOptGuarantyPageTables_Count(pageTable);
	}


	@Override
	public List<Pro_optGuaranty> selectOptGuarantyByWheresql(String whereSql) {
		return	pro_optGuarantyMapper.selectOptGuarantyByWheresql(whereSql);
	}
	
	@Override
	public int insertOptGuarantyInfo(User userSession, Pro_optGuaranty optGuaranty) {
		return pro_optGuarantyMapper.insertOneOptGuarantyInfo(optGuaranty);
	}


	@Override
	public String getGuaranteeRemarkByWheresql(String wheresql) {
		return pro_optGuarantyMapper.getGuaranteeRemarkByWheresql(wheresql);
	}
}
