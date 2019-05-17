package com.zjm.gworkFlow.flowBuild.service.Impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gworkFlow.db.map.OsGworkflowProjsuggestMapper;
import com.zjm.gworkFlow.db.map.Os_gworkflow_filesMapper;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;
import com.zjm.gworkFlow.db.model.Os_gworkflow_files;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowFilesService;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowProjsuggestService;
import com.zjm.util.Tool;

/** 
 * osworkflow意见表
 * @author mashuo add 20170928
 */
@Service("osGworkflowProjsuggestService")
@Transactional
public class OsGworkflowProjsuggestServiceImpl implements OsGworkflowProjsuggestService{

	@Resource
	private OsGworkflowProjsuggestMapper osGworkflowProjsuggestMapper;
	@Resource
	private Os_gworkflow_filesMapper os_gworkflow_filesMapper;

	/**
	 * 取得一条意见信息
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public OsGworkflowProjsuggest selectOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest,User userSession){
		osGworkflowProjsuggest.setUnit_uid(userSession.getUnit_uid());
		osGworkflowProjsuggest.setUser_uid(userSession.getUser_uid());
		OsGworkflowProjsuggest suggest=osGworkflowProjsuggestMapper.selectOneOsGworkflowProjsuggest(osGworkflowProjsuggest);
		if(suggest == null){
			suggest=new OsGworkflowProjsuggest();
			suggest.setOpsuggest_ID(Tool.createUUID32());
			suggest.setStepID(osGworkflowProjsuggest.getStepID());
			suggest.setStepName(osGworkflowProjsuggest.getStepName());
			suggest.setFlowID(osGworkflowProjsuggest.getFlowID());
			suggest.setHistoryID(osGworkflowProjsuggest.getHistoryID());
			suggest.setProjectID(osGworkflowProjsuggest.getProjectID());

			suggest.setUnit_uid(userSession.getUnit_uid());
			suggest.setUser_uid(userSession.getUser_uid());
			suggest.setUser_name(userSession.getUser_name());
			suggest.setDepart_uid(userSession.getDepart_uid());
			suggest.setDepart_name(userSession.getDepart_name());
			if(osGworkflowProjsuggestMapper.insertOneOsGworkflowProjsuggest(suggest) == 1){
				return suggest;
			}else{
				return null;
			}
		}else{
			return suggest;
		}

	}

	/**
	 * 保存意见信息
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public Boolean updateOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest,User userSession){
		osGworkflowProjsuggest.setUnit_uid(userSession.getUnit_uid());
		osGworkflowProjsuggest.setUser_uid(userSession.getUser_uid());
		Integer count = osGworkflowProjsuggestMapper.selectSuggestIsExist(osGworkflowProjsuggest);
		if(count == 0){
			osGworkflowProjsuggest.setOpsuggest_ID(Tool.createUUID32());
			osGworkflowProjsuggest.setUnit_uid(userSession.getUnit_uid());
			osGworkflowProjsuggest.setUser_uid(userSession.getUser_uid());
			osGworkflowProjsuggest.setUser_name(userSession.getUser_name());
			osGworkflowProjsuggest.setDepart_uid(userSession.getDepart_uid());
			osGworkflowProjsuggest.setDepart_name(userSession.getDepart_name());

			if(osGworkflowProjsuggestMapper.insertOneOsGworkflowProjsuggest(osGworkflowProjsuggest) == 1){
				return true;
			}else{
				return false;
			}
		}else{
			if(osGworkflowProjsuggestMapper.updateOneOsGworkflowProjsuggest(osGworkflowProjsuggest) == 1){
				return true;
			}else{
				return false;
			}
		}
	}




	/**
	 *  查询一个流程的所有用户意见
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public List<OsGworkflowProjsuggest> selectAllOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest,User userSession){
		List<OsGworkflowProjsuggest> list=osGworkflowProjsuggestMapper.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest);
		for(int i=0;i<list.size();i++){
			
			PageTable pageTable=new PageTable<>();
			String wheresql="";
			wheresql=wheresql+" and historyID =\'"+list.get(i).getHistoryID()+"\' ";
			wheresql=wheresql+" and projectID =\'"+list.get(i).getProjectID()+"\' ";
			wheresql=wheresql+" and flowID =\'"+list.get(i).getFlowID()+"\' ";
			wheresql=wheresql+" and stepID =\'"+list.get(i).getStepID()+"\' ";
			pageTable.setWheresql(wheresql);
			List<Os_gworkflow_files> filelist=os_gworkflow_filesMapper.selectAllOsGworkflowFilesPageTables(pageTable);
			list.get(i).setFilesList(filelist);
		}
		



		return list;
	}


}

