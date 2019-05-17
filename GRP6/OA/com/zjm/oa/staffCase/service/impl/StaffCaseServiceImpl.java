package com.zjm.oa.staffCase.service.impl;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.db.map.Hr_staffCaseMapper;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.staffCase.service.StaffCaseService;
import com.zjm.sys.db.map.Sys_post_userMapper;
import com.zjm.sys.post.service.PostService;

@Service("staffCaseService")
@Transactional
public class StaffCaseServiceImpl implements StaffCaseService {
	@Resource
	private Hr_staffCaseMapper hr_staffCaseMapper;
	@Resource
	private Sys_post_userMapper sys_post_userMapper;
	@Resource
	private PostService postService;

	@Resource
	private Hr_staffCaseMapper staffCaseMapper;
	@Resource
	private SysDicDataService sysDicDataService;
	/**
	 * 查看列表
	 */
	public PageTable<Hr_staffCase> selectStaffCaseTables(PageTable<Hr_staffCase> pageTable) {
		Map<String,String> minzuMap = sysDicDataService.selectDicTypeDicMap("","0d9eb537552f4965a6013edb8deb5fd7");
		//政治面貌
		Map<String,String> ZhengzhiMap = sysDicDataService.selectDicTypeDicMap("","de47b08fe98446dda0928d31d4fd4246");
		//婚姻状况
		Map<String,String> MarriageMap = sysDicDataService.selectDicTypeDicMap("","c703889e4187459e9c5fd74f8d1ad743");
		// 籍贯
	//	Map<String,String> BirthpalceMap = sysDicDataService.selectDicTypeDicMap("","ab653dd759ff4f229a91dbce1a5dcadc");
		// 员工类型
		Map<String,String> ygMap = sysDicDataService.selectDicTypeDicMap("","8bdedd1a6a474c3aafe2d7b51c9b84d8");
		// 学历
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicMap("","1d5c390cc0ac4a8ab77270ef0debe823");
		//职称 
		Map<String,String> ZhichengMap = sysDicDataService.selectDicTypeDicMap("","96c78db0fb224f37a740ea6561566968");
		List<Hr_staffCase> list = hr_staffCaseMapper.selectStaffCaseTables(pageTable);
		//System.out.println(JSON.toJSONString(BirthpalceMap));
		for (Hr_staffCase hr_staffCase : list) {
//			if(hr_staffCase.getStaffBirthplace()!=null && !hr_staffCase.getStaffBirthplace().equals("")){
//				hr_staffCase.setStaffBirthplaceName(BirthpalceMap.get(hr_staffCase.getStaffBirthplace()));
//			
//			}
			if(hr_staffCase.getStaffNational()!=null && !hr_staffCase.getStaffNational().equals("")){
				hr_staffCase.setStaffNationalNmae(minzuMap.get(hr_staffCase.getStaffNational()));
			}
			
			if(hr_staffCase.getStaffEducation()!=null && !hr_staffCase.getStaffEducation().equals("")){
				hr_staffCase.setStaffEducationName(EducationMap.get(hr_staffCase.getStaffEducation()));
			}			
			if(hr_staffCase.getStaffPolitical()!=null && !hr_staffCase.getStaffPolitical().equals("")){
				hr_staffCase.setStaffPoliticalName(ZhengzhiMap.get(hr_staffCase.getStaffPolitical()));
			}
			if(hr_staffCase.getStaffTitle()!=null && !hr_staffCase.getStaffTitle().equals("")){
				hr_staffCase.setStaffTitleName(ZhichengMap.get(hr_staffCase.getStaffTitle()));
			}
			if(hr_staffCase.getStaffMarriage()!=null && !hr_staffCase.getStaffMarriage().equals("")){
				hr_staffCase.setStaffMarriageName(MarriageMap.get(hr_staffCase.getStaffMarriage()));
			}
			if(hr_staffCase.getStaffType()!=null && !hr_staffCase.getStaffType().equals("")){
				hr_staffCase.setStaffTypeName(ygMap.get(hr_staffCase.getStaffType()));
			}
		}
		Long total = hr_staffCaseMapper.selectStaffCaseTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 * 根据员工id查出该员工
	 */	
	@Override
	public Hr_staffCase selectOneStaffCaseInfo(Hr_staffCase hr_staffCase) {
		
		Map<String,String> minzuMap = sysDicDataService.selectDicTypeDicNoEableMap("","0d9eb537552f4965a6013edb8deb5fd7");
		//政治面貌
		Map<String,String> ZhengzhiMap = sysDicDataService.selectDicTypeDicNoEableMap("","de47b08fe98446dda0928d31d4fd4246");
		//婚姻状况
		Map<String,String> MarriageMap = sysDicDataService.selectDicTypeDicNoEableMap("","c703889e4187459e9c5fd74f8d1ad743");
		// 籍贯
		//Map<String,String> BirthpalceMap = sysDicDataService.selectDicTypeDicNoEableMap("","ab653dd759ff4f229a91dbce1a5dcadc");
		// 员工类型
		Map<String,String> ygMap = sysDicDataService.selectDicTypeDicNoEableMap("","8bdedd1a6a474c3aafe2d7b51c9b84d8");
		// 学历
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");
		//职称 
		Map<String,String> ZhichengMap = sysDicDataService.selectDicTypeDicNoEableMap("","96c78db0fb224f37a740ea6561566968");
		Hr_staffCase hrstaffcase=hr_staffCaseMapper.selectOneStaffCaseInfo(hr_staffCase);
//			if(hrstaffcase.getStaffBirthplace()!=null){
//				hrstaffcase.setStaffBirthplaceName(BirthpalceMap.get(hrstaffcase.getStaffBirthplace()));
//				System.out.println(hrstaffcase.getStaffBirthplaceName());
//			}
			if(hrstaffcase.getStaffNational()!=null){
				hrstaffcase.setStaffNationalNmae(minzuMap.get(hrstaffcase.getStaffNational()));
			}
			
			if(hrstaffcase.getStaffEducation()!=null){
				hrstaffcase.setStaffEducationName(EducationMap.get(hrstaffcase.getStaffEducation()));
			}
			if(hr_staffCase.getStaffPolitical()!=null){
				hr_staffCase.setStaffPoliticalName(ZhengzhiMap.get(hr_staffCase.getStaffPolitical()));
			}
			if(hr_staffCase.getStaffTitle()!=null){
				hr_staffCase.setStaffTitleName(ZhichengMap.get(hr_staffCase.getStaffTitle()));
			}
			if(hr_staffCase.getStaffMarriage()!=null){
				hr_staffCase.setStaffMarriageName(MarriageMap.get(hr_staffCase.getStaffMarriage()));
			}
			if(hr_staffCase.getStaffType()!=null){
				hr_staffCase.setStaffTypeName(ygMap.get(hr_staffCase.getStaffType()));
			}
		return hrstaffcase;
	}
	/**
	 * 判断名称是否重复
	 */
	public Boolean selectStaffCaseNameIsExist(String wheresql) {
		if (hr_staffCaseMapper.selectStaffCaseNameIsExist(wheresql) == 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 更新
	 */
	public Boolean updateOneStaffCaseInfo(Hr_staffCase hr_staffCase) {
		
		Map<String,String> minzuMap = sysDicDataService.selectDicTypeDicNoEableMap("","0d9eb537552f4965a6013edb8deb5fd7");
		//政治面貌
		Map<String,String> ZhengzhiMap = sysDicDataService.selectDicTypeDicNoEableMap("","de47b08fe98446dda0928d31d4fd4246");
		//婚姻状况
		Map<String,String> MarriageMap = sysDicDataService.selectDicTypeDicNoEableMap("","c703889e4187459e9c5fd74f8d1ad743");
		// 籍贯
		//Map<String,String> BirthpalceMap = sysDicDataService.selectDicTypeDicNoEableMap("","ab653dd759ff4f229a91dbce1a5dcadc");
		// 员工类型
		Map<String,String> ygMap = sysDicDataService.selectDicTypeDicNoEableMap("","8bdedd1a6a474c3aafe2d7b51c9b84d8");
		// 学历
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");
		//职称 
		Map<String,String> ZhichengMap = sysDicDataService.selectDicTypeDicNoEableMap("","96c78db0fb224f37a740ea6561566968");
//			if(hr_staffCase.getStaffBirthplace()!=null && !hr_staffCase.getStaffBirthplace().equals("")){
//				hr_staffCase.setStaffBirthplaceName(BirthpalceMap.get(hr_staffCase.getStaffBirthplace()));
//				System.out.println(hr_staffCase.getStaffBirthplaceName());
//			}
			if(hr_staffCase.getStaffNational()!=null && !hr_staffCase.getStaffBirthplace().equals("")){
				hr_staffCase.setStaffNationalNmae(minzuMap.get(hr_staffCase.getStaffNational()));
			}
			
			if(hr_staffCase.getStaffEducation()!=null && !hr_staffCase.getStaffEducation().equals("")){
				hr_staffCase.setStaffEducationName(EducationMap.get(hr_staffCase.getStaffEducation()));
			}	
			if(hr_staffCase.getStaffPolitical()!=null && !hr_staffCase.getStaffPolitical().equals("")){
				hr_staffCase.setStaffPoliticalName(ZhengzhiMap.get(hr_staffCase.getStaffPolitical()));
			}
			if(hr_staffCase.getStaffTitle()!=null && !hr_staffCase.getStaffTitle().equals("")){
				hr_staffCase.setStaffTitleName(ZhichengMap.get(hr_staffCase.getStaffTitle()));
			}
			if(hr_staffCase.getStaffMarriage()!=null && !hr_staffCase.getStaffMarriage().equals("")){
				hr_staffCase.setStaffMarriageName(MarriageMap.get(hr_staffCase.getStaffMarriage()));
			}
			if(hr_staffCase.getStaffType()!=null && !hr_staffCase.getStaffType().equals("")){
				hr_staffCase.setStaffTypeName(ygMap.get(hr_staffCase.getStaffType()));
			}
		if (hr_staffCaseMapper.updateOneStaffCaseInfo(hr_staffCase) == 1) {
			return true;
		} else {
			return false;
		}
	}
	public Boolean updateOneDismissonInfo(Hr_staffCase hr_staffCase){
		
		Map<String,String> minzuMap = sysDicDataService.selectDicTypeDicNoEableMap("","0d9eb537552f4965a6013edb8deb5fd7");
		//政治面貌
		Map<String,String> ZhengzhiMap = sysDicDataService.selectDicTypeDicNoEableMap("","de47b08fe98446dda0928d31d4fd4246");
		//婚姻状况
		Map<String,String> MarriageMap = sysDicDataService.selectDicTypeDicNoEableMap("","c703889e4187459e9c5fd74f8d1ad743");
		// 籍贯
	//	Map<String,String> BirthpalceMap = sysDicDataService.selectDicTypeDicNoEableMap("","ab653dd759ff4f229a91dbce1a5dcadc");
		// 员工类型
		Map<String,String> ygMap = sysDicDataService.selectDicTypeDicNoEableMap("","8bdedd1a6a474c3aafe2d7b51c9b84d8");
		// 学历
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");
		//职称 
		Map<String,String> ZhichengMap = sysDicDataService.selectDicTypeDicNoEableMap("","96c78db0fb224f37a740ea6561566968");
//		if(hr_staffCase.getStaffBirthplace()!=null && !hr_staffCase.getStaffBirthplace().equals("")){
//			hr_staffCase.setStaffBirthplaceName(BirthpalceMap.get(hr_staffCase.getStaffBirthplace()));
//			System.out.println(hr_staffCase.getStaffBirthplaceName());
//		}
		if(hr_staffCase.getStaffNational()!=null && !hr_staffCase.getStaffBirthplace().equals("")){
			hr_staffCase.setStaffNationalNmae(minzuMap.get(hr_staffCase.getStaffNational()));
		}
		
		if(hr_staffCase.getStaffEducation()!=null && !hr_staffCase.getStaffEducation().equals("")){
			hr_staffCase.setStaffEducationName(EducationMap.get(hr_staffCase.getStaffEducation()));
		}	
		if(hr_staffCase.getStaffPolitical()!=null && !hr_staffCase.getStaffPolitical().equals("")){
			hr_staffCase.setStaffPoliticalName(ZhengzhiMap.get(hr_staffCase.getStaffPolitical()));
		}
		if(hr_staffCase.getStaffTitle()!=null && !hr_staffCase.getStaffTitle().equals("")){
			hr_staffCase.setStaffTitleName(ZhichengMap.get(hr_staffCase.getStaffTitle()));
		}
		if(hr_staffCase.getStaffMarriage()!=null && !hr_staffCase.getStaffMarriage().equals("")){
			hr_staffCase.setStaffMarriageName(MarriageMap.get(hr_staffCase.getStaffMarriage()));
		}
		if(hr_staffCase.getStaffType()!=null && !hr_staffCase.getStaffType().equals("")){
			hr_staffCase.setStaffTypeName(ygMap.get(hr_staffCase.getStaffType()));
		}
		if (hr_staffCaseMapper.updateOneDismissonInfo(hr_staffCase) == 1) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 插入
	 */
	@Override
	public Boolean insertOneStaffCaseInfo(Hr_staffCase hr_staffCase, User userSession) {
	
	
		
		hr_staffCase.setUnit_uid(userSession.getUnit_uid());
		Integer io=0;
		try {
			io = hr_staffCaseMapper.insertOneStaffCaseInfo(hr_staffCase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(io==1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public PageTable selectContractBirthdayPageTable(PageTable pageTable) {
		List<Hr_staffCase> staffCaseList = staffCaseMapper.selectContractBirthdayList(pageTable);
		List<Hr_staffCase> retStaffCaseList = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date now = new Date();
		String year = df.format(now).substring(0,5);
		
		if (staffCaseList != null) {
			for (Hr_staffCase staffCase : staffCaseList) {
				if (staffCase == null) {
					continue;
				}
				Date borndate = staffCase.getBorndate();
				Date contractdate = staffCase.getStaffEndContractDate();
				if (borndate != null && !"".equals(borndate)) {
					String birthday = df.format(borndate);
					String birthMd = birthday.substring(5, birthday.length());
					
					Date newBirthday = null;
					try {
						newBirthday = df.parse(year+birthMd);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					int days = 0;
					if (now.getTime() > newBirthday.getTime()) {
						calendar.setTime(newBirthday);
						calendar.add(Calendar.YEAR, 1);
						
						//得到两个日期相差的天数   
						days = ((int) (calendar.getTime().getTime() / 1000) - (int) (now.getTime() / 1000)) / 3600 / 24;
					} else {
						//得到两个日期相差的天数   
						days = ((int) (newBirthday.getTime() / 1000) - (int) (now.getTime() / 1000)) / 3600 / 24;
					}
					staffCase.setBirthdays(days+1);
				}
				
				/**
				 *计算合同到期日 
				 */
				if (contractdate != null && !"".equals(contractdate)) {
					int days = 0;
					//得到两个日期相差的天数   
					days = ((int) (contractdate.getTime() / 1000) - (int) (now.getTime() / 1000)) / 3600 / 24;
					staffCase.setContractDays(days+1);
				}
				retStaffCaseList.add(staffCase);
			}

			
		}
			
		pageTable.setRows(retStaffCaseList);
		pageTable.setTotal(staffCaseMapper.selectContractBirthdayCount(pageTable));
		return pageTable;
	}
	@Override
	public Hr_staffCase selectOneStaffCaseInfo1(Hr_staffCase hr_staffCase) {
		
		
		
		return hr_staffCaseMapper.selectOneStaffCaseInfo1(hr_staffCase);
	}
	@Override
	public Boolean deleteOneStaffCaseInfo(Hr_staffCase hr_staffCase) {
	 if(hr_staffCaseMapper.deleteOneStaffCaseInfo(hr_staffCase)==1){
		 return true;
	 }
		return false;
	}
	@Override
	public Boolean disMission(Hr_staffCase hrstaffCase) {
		
		return null;
	}
	



}