package com.zjm.pro.suggest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.map.Pro_suggestMapper;
import com.zjm.pro.db.model.Pro_suggest;
import com.zjm.pro.suggest.service.ProjectSuggestService;
import com.zjm.util.Tool;

@Service("projectSuggestService")
@Transactional
public class ProjectSuggestServiceImpl implements ProjectSuggestService {
	    //项目意见表mapper
		@Resource
		private Pro_suggestMapper pro_suggestMapper;
		@Resource
		private LogService logService;
		 @Resource
		 private Pro_projectfilesMapper pro_projectfilesMapper;
		/**
		 * 插入一个项目意见信息
		 * @param 
		 * @return
		 */         
		public Boolean insertOneSuggestInfo(User user, Pro_suggest suggest) {
			Boolean b = false;
			Integer resultInt=null;
			
			if(null !=suggest.getSuggest_ID()&& !"".equals(suggest.getSuggest_ID())){//不为空，修改：
				Pro_suggest	oldSuggest = pro_suggestMapper.selectOneSuggestByWhereSql(" and suggest_ID = \'"+suggest.getSuggest_ID()+"\'");
				oldSuggest.setSuggestContent(suggest.getSuggestContent());
				resultInt = pro_suggestMapper.updateOneSuggestInfo(oldSuggest);
				if(1==resultInt){
					 logService.insertOneOperatorLogInfo(user,"项目意见", "修改", "项目意见表信息");
						b=true;
					}
			}else{//为空，新增：
				suggest.setSuggest_ID(Tool.createUUID32());//项目意见表id;
				suggest.setUpdateUserName(user.getUser_name());//设置更新人名称;
				suggest.setUnit_uid(user.getUnit_uid());//设置担保机构id
				suggest.setSuggestUserID(user.getUser_uid());	//填写意见人ID
				suggest.setSuggestUserName(user.getUser_name());//	填写意见人名称
				resultInt = pro_suggestMapper.insertOneSuggestInfo(suggest);
				if(1==resultInt){
					 logService.insertOneOperatorLogInfo(user,"项目意见", "新增", "项目意见表信息");
						b=true;
					}
			}
			return b;
		}
        
		public Pro_suggest selectOneSuggestByWhereSql(String wheresql) {
			Pro_suggest suggest= new Pro_suggest();
			try {
				suggest = pro_suggestMapper.selectOneSuggestByWhereSql(wheresql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggest;
		}

		@Override
		public Boolean updateOneSuggestInfo(User user, Pro_suggest suggest) {
			return pro_suggestMapper.updateOneSuggestInfo(suggest)>0;
		}
		/**
		 * 根据wheresql查询项目意见信息list
		 * @param wheresql:
		 * @return
		 */
		public List<Pro_suggest> selectSuggestListByWhereSql(String wheresql) {
			List<Pro_suggest> suggestList = pro_suggestMapper.selectSuggestListByWhereSql(wheresql);
			for (Pro_suggest pro_suggest : suggestList) {
				PageTable pageTable=new PageTable<>();
				String wheresql2="";
				wheresql2=wheresql2+" and entityID =\'"+pro_suggest.getEntityID()+"\' ";
				wheresql2=wheresql2+" and taskID =\'"+pro_suggest.getTaskID()+"\' ";
				pageTable.setWheresql(wheresql2);
				 List fileList = pro_projectfilesMapper.selectProjectFilesPageTables(pageTable);
				 pro_suggest.setFilesList(fileList);
			}
			
			
			return suggestList;
		}
         /**
          * 删除单个意见表信息
          */
   		public Boolean deleteOneSuggestInfo(User user, Pro_suggest suggest) {
   			Boolean b = false;
   			Integer reurnInt = pro_suggestMapper.deleteOneSuggestByWhereSql(" and suggest_ID = \'"+suggest.getSuggest_ID()+"\'");
			if(reurnInt>0){
				b=true;
			}
   			return b;
		}
}
