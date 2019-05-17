package com.zjm.gworkFlow.flowBuild.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.gworkFlow.db.map.OsGworkflowInstanceMapper;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowInstanceService;

@Service("osGworkflowInstanceService")
@Transactional
public class OsGworkflowInstanceServiceImpl implements OsGworkflowInstanceService {
	@Resource
	OsGworkflowInstanceMapper osGworkflowInstanceMapper ;

	@Override
	public void executeSQL(String sql) {
		osGworkflowInstanceMapper.executeSql(sql);
	}

	@Override
	public OsGworkflowInstance selectOne(OsGworkflowInstance instance, String type) {
		if(type.endsWith("business"))
			return osGworkflowInstanceMapper.getOneByBusiness(instance);
		else if(type.endsWith("entryId"))
			return osGworkflowInstanceMapper.getOneByEntryId(instance);
		else
			return null;
	}

}
