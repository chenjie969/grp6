package com.zjm.pro.CheckReports.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.pro.checkReport.service.CheckReportService;
import com.zjm.pro.db.map.Pro_checkReportMapper;
import com.zjm.pro.db.model.Pro_checkReport;
@Service("checkReportService")
@Transactional
public class CheckReportServiceImpl implements CheckReportService{
	
	@Resource
	private CheckReportService checkReportService;
	@Resource
	private Pro_checkReportMapper pro_checkReportMapper;
	@Override
	public Boolean updateOneCheckReportInfo(Pro_checkReport pro_checkReport) {
		if(pro_checkReportMapper.updateOneCheckReportInfo(pro_checkReport)==1){
			return true;
		}
		return false;
	}
	@Override
	public Pro_checkReport selectOneCheckReportInfo(String  checkPlan_ID) {
		
		return pro_checkReportMapper.selectOneCheckReportInfo(checkPlan_ID);
	}
	@Override
	public Boolean insertOneCheckReport(Pro_checkReport pro_checkReport) {
		if(pro_checkReportMapper.insertOneCheckReport(pro_checkReport)==1){
			return true;
		}
		return false;
	}

}
