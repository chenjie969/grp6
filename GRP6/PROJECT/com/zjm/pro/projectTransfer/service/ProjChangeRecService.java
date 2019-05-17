package com.zjm.pro.projectTransfer.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_projChangeRec;

public interface ProjChangeRecService {
	
	Boolean insertOneProjChangeRec(Pro_projChangeRec  projChangeRec ,User user);

	PageTable<Pro_projChangeRec>  selectProjChangeRecPageTable(PageTable<Pro_projChangeRec> pageTable);

	Pro_projChangeRec selectOneProjChangeRec(String projChangeRec_ID);

	Boolean updateOneProjChangeRec(Pro_projChangeRec projChangeRec);
	

}
