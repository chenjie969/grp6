package com.zjm.pro.analysis.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.pro.analysis.service.AnalysisService;
import com.zjm.pro.db.map.AnalysisMapper;
import com.zjm.pro.db.model.EChart;
import com.zjm.pro.db.model.Pro_project;

@Service("analysisService")
@Transactional
public class AnalysisServiceImpl implements AnalysisService {
    
	//申请表mapper
	@Resource
	private AnalysisMapper analysisMapper;
	
	/**
	 * 1-12月统计金额(表格)
	 * @param wheresql (年份)
	 */
	public ArrayList<ArrayList<Double>> analysisTableOfMonthSum(String whereSql) {
			StringBuffer wheresql =new StringBuffer();			 
			wheresql.append(" SELECT ");
			wheresql.append(" project.delayBeginDate AS delayBeginDate,");
			wheresql.append(" SUM(IFNULL(project.loadSum,0)) AS loadSum,");
			wheresql.append(" SUM(IFNULL(project.replaceCapitalSum,0)) AS replaceCapitalSum,");
			wheresql.append(" SUM(IFNULL(project.normalCapitalSum,0)) AS normalCapitalSum,");
			wheresql.append(" SUM(IFNULL(project.guarantySum,0)) AS guarantySum");
			wheresql.append(" FROM");
			wheresql.append(" pro_project project");		  
			wheresql.append(" WHERE 1=1 AND YEAR(project.delayBeginDate) = \'"+whereSql+"\'");		  
			wheresql.append(" GROUP BY MONTH(project.delayBeginDate) ");		  
			
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());	
			
			HashMap<Integer, Double> loadSumMap= new HashMap<>();
	        HashMap<Integer, Double> replaceCapitalSumMap= new HashMap<>();
	        HashMap<Integer, Double> normalCapitalSumMap= new HashMap<>();
	        HashMap<Integer, Double> guarantySumMap= new HashMap<>();
			for (Pro_project pro_project : projectList) {
				pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getDelayBeginDate()));//periodMonth 用此字段表示统计月份;				
				loadSumMap.put(pro_project.getPeriodMonth(), pro_project.getLoadSum());
	        	replaceCapitalSumMap.put(pro_project.getPeriodMonth(), pro_project.getReplaceCapitalSum());
	        	normalCapitalSumMap.put(pro_project.getPeriodMonth(), pro_project.getNormalCapitalSum());
	        	guarantySumMap.put(pro_project.getPeriodMonth(), pro_project.getGuarantySum());				
			}	        	       
			 ArrayList<ArrayList<Double>>  SumLists=  new ArrayList<>();  
		        for (int i =1; i <= 12; i++) {
		        	ArrayList<Double>  SumList=  new ArrayList<>();		        	
		        	Double loadSum = loadSumMap.get(i);
		        	Double replaceCapitalSum = replaceCapitalSumMap.get(i);
		        	Double normalCapitalSum = normalCapitalSumMap.get(i);
		        	Double guarantySum = guarantySumMap.get(i);       	        	      			        	
		        	SumList.add(null == loadSum ? 0D:loadSum);//新增金额
		        	SumList.add(null == normalCapitalSum ? 0D:normalCapitalSum);//无代偿解除金额
		        	SumList.add(null == replaceCapitalSum ? 0D:replaceCapitalSum);//代偿解除金额
		        	SumList.add(null == guarantySum ? 0D:guarantySum);//在保余额;
		        	
		        	SumLists.add(SumList);
		        
				}   
			
		return SumLists;
	}
	/**
	 * 1-12月统计金额(折线图)
	 * @param wheresql (年份)
	 */
	public EChart analysisOfMonthSum(String whereSql) {
			
			StringBuffer wheresql =new StringBuffer();			 
			wheresql.append(" SELECT ");
			wheresql.append(" project.delayBeginDate AS delayBeginDate,");
			wheresql.append(" SUM(IFNULL(project.loadSum,0)) AS loadSum,");
			wheresql.append(" SUM(IFNULL(project.replaceCapitalSum,0)) AS replaceCapitalSum,");
			wheresql.append(" SUM(IFNULL(project.normalCapitalSum,0)) AS normalCapitalSum,");
			wheresql.append(" SUM(IFNULL(project.guarantySum,0)) AS guarantySum");
			wheresql.append(" FROM");
			wheresql.append(" pro_project project");		  
			wheresql.append(" WHERE 1=1 AND YEAR(project.delayBeginDate) = \'"+whereSql+"\'");		  
			wheresql.append(" GROUP BY MONTH(project.delayBeginDate) ");		  			
			
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());				
			HashMap<Integer, Double> loadSumMap= new HashMap<>();
	        HashMap<Integer, Double> replaceCapitalSumMap= new HashMap<>();
	        HashMap<Integer, Double> normalCapitalSumMap= new HashMap<>();
	        HashMap<Integer, Double> guarantySumMap= new HashMap<>();			
	        
	        for (Pro_project pro_project : projectList) {
	        	pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getDelayBeginDate()));//periodMonth 用此字段表示统计月份;
	        	loadSumMap.put(pro_project.getPeriodMonth(), pro_project.getLoadSum());
	        	normalCapitalSumMap.put(pro_project.getPeriodMonth(), pro_project.getNormalCapitalSum());
	        	replaceCapitalSumMap.put(pro_project.getPeriodMonth(), pro_project.getReplaceCapitalSum());
	        	guarantySumMap.put(pro_project.getPeriodMonth(), pro_project.getGuarantySum());
	        	
			}
	        List<String> loadSumList= new ArrayList<>();
	        List<String> replaceCapitalSumList= new ArrayList<>();
	        List<String> normalCapitalSumList= new ArrayList<>();
	        List<String> guarantySumList= new ArrayList<>();	
	        List<String> nameList = new ArrayList<>();
	        EChart echart=new EChart();
	        for (int i =1; i <= 12; i++) {	
	        	nameList.add(i+"月");//获取1-12月字符串;
	        	loadSumList.add(null == loadSumMap.get(i) ? "0":formatDoubleToString(loadSumMap.get(i)));//新增金额
	        	normalCapitalSumList.add(null == normalCapitalSumMap.get(i) ? "0":formatDoubleToString(normalCapitalSumMap.get(i)));//无代偿解除金额
	        	replaceCapitalSumList.add(null == replaceCapitalSumMap.get(i) ? "0":formatDoubleToString(replaceCapitalSumMap.get(i)));//代偿解除金额
	        	guarantySumList.add(null == guarantySumMap.get(i) ? "0":formatDoubleToString(guarantySumMap.get(i)));//在保余额;
	        
			}   
	        echart.setNameStr(nameList.toArray(new String[12]));
	        echart.setLoadSumStr(loadSumList.toArray(new String[12]));
	        echart.setNormalCapitalSumStr(normalCapitalSumList.toArray(new String[12]));
        	echart.setReplaceCapitalSumStr(replaceCapitalSumList.toArray(new String[12]));
        	echart.setGuaraSumStr(guarantySumList.toArray(new String[12]));
		
	return echart;
   }
	
	/**
	 * 1-12月统计笔数(表格)
	 * @param wheresql (年份)
	 */
	public ArrayList<ArrayList<Integer>> analysisTableOfMonthCount(String whereSql) {
		StringBuffer wheresql =new StringBuffer("");
		HashMap<Integer, Integer> loadCountMap= new HashMap<>();
		HashMap<Integer, Integer> normalCapitalCountMap= new HashMap<>();
        HashMap<Integer, Integer> replaceCapitalCountMap= new HashMap<>();
        HashMap<Integer, Integer> guarantyCountMap= new HashMap<>();        
		
        wheresql.append(" SELECT ");//查询新增笔数;
		wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
	    wheresql.append(" COUNT(project.project_ID) AS projCount ");
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" WHERE 1=1 AND YEAR(project.delayBeginDate) = \'"+whereSql+"\'");	
		wheresql.append(" GROUP BY MONTH(project.delayBeginDate) ");		
		List<Pro_project> LoadProjectList = analysisMapper.selectDynamicProject(wheresql.toString());				
		for (Pro_project pro_project : LoadProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getDelayBeginDate()));//periodMonth 用此字段表示统计月份;
			loadCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());
		}
		wheresql =new StringBuffer(" SELECT ");//笔数(无代偿解除)
		/*wheresql.append(" project.freeDate as freeDate,");
	    wheresql.append(" COUNT(project.project_ID) AS projCount");
		wheresql.append(" FROM pro_project project");
		wheresql.append(" WHERE YEAR(project.freeDate) = \'"+whereSql+"\'");	
		wheresql.append(" GROUP BY MONTH(project.freeDate)");*/
		
		wheresql.append(" factPay.payDate AS freeDate , ");
		wheresql.append(" COUNT(DISTINCT factPay.project_ID) AS projCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_factPay factPay ");
		wheresql.append(" WHERE 1=1 AND YEAR(factPay.payDate) =\'"+whereSql+"\' ");	
		wheresql.append(" GROUP BY MONTH(factPay.payDate) ");
				
		
		List<Pro_project> normalProjectList = analysisMapper.selectDynamicProject(wheresql.toString());	
		for (Pro_project pro_project : normalProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getFreeDate()));//periodMonth 用此字段表示统计月份;
			normalCapitalCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());//获取笔数(无代偿解除)
		}
		wheresql =new StringBuffer(" SELECT ");
		wheresql.append(" pro_replace.replaceDate as replaceDate,");
		wheresql.append(" COUNT(DISTINCT pro_replace.project_ID) AS projCount ");
		wheresql.append(" FROM pro_replace pro_replace");
		wheresql.append(" WHERE 1=1 AND  YEAR(pro_replace.replaceDate) = \'"+whereSql+"\'");			
		wheresql.append(" GROUP BY MONTH(pro_replace.replaceDate)");
		
		List<Pro_project> replaceCapitalProjectList = analysisMapper.selectDynamicProject(wheresql.toString());	
		
		for (Pro_project pro_project : replaceCapitalProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getReplaceDate()));//periodMonth 用此字段表示统计月份;
			replaceCapitalCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());//获取笔数(代偿解除)
		}
		 
		wheresql =new StringBuffer(" SELECT ");
		wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
		wheresql.append(" COUNT(project.project_ID) AS projCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_project project ");
		wheresql.append(" WHERE 1=1 AND project.freeDate IS NULL AND YEAR(project.delayBeginDate) = \'"+whereSql+"\' ");
		wheresql.append(" GROUP BY MONTH(project.delayBeginDate) ");
        List<Pro_project> guarantyProjectList = analysisMapper.selectDynamicProject(wheresql.toString());	
		
		for (Pro_project pro_project : guarantyProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getDelayBeginDate()));//periodMonth 用此字段表示统计月份;
			guarantyCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());//获取笔数(在保余额)
		}
		
		
		
		ArrayList<ArrayList<Integer>>  countLists=  new ArrayList<>();  
        for (int i =1; i <= 12; i++) {
        	ArrayList<Integer>  countList=  new ArrayList<>();
        	countList.add(null == loadCountMap.get(i) ? 0:loadCountMap.get(i));//新增笔数
        	countList.add(null == normalCapitalCountMap.get(i) ? 0:normalCapitalCountMap.get(i));//无代偿解除笔数
        	countList.add(null == replaceCapitalCountMap.get(i) ? 0:replaceCapitalCountMap.get(i));//代偿解除笔数
        	countList.add(null == (guarantyCountMap.get(i)) ? 0:(guarantyCountMap.get(i)));//在保笔数;      	
        	countLists.add(countList);
       
		}   		
		return countLists;
	}

	/**
	 * double格式化类型方法
	 * @author zky
	 * @param onedouble
	 * @time : 2017-7-31
	 * 
	 * @return
	 */
	private String formatDoubleToString(Double onedouble){
		String onetypedouble = "";
		if(onedouble!=null && onedouble!=0){
			DecimalFormat df = new DecimalFormat("###.######");
			onetypedouble = df.format(onedouble);
		}else{
			onetypedouble = "0";
		}
		return onetypedouble;
	}
	
	/**
	 * 截取日期获取日期月份,并将其转换为Integer类型
	 * @author zky
	 *  @time : 2017-7-31
	 */
	private Integer formatDateMonthToInteger(Date oneDate){
		if(null != oneDate){
			String string =new SimpleDateFormat("yyyy-MM-dd").format(oneDate);
			String ss = string.substring(5,7);//获取月份
			return Integer.parseInt(ss);
		}else{
			String string =new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String ss = string.substring(5,7);//获取月份
			return Integer.parseInt(ss);
		}
	
	}
	/**
	 * 截取日期获取日期年份,并将其转换为Integer类型
	 * @author zky
	 *  @time : 2017-7-31
	 */
	private Integer formatDateYearToInteger(Date oneDate){
		if(null != oneDate){
			String string =new SimpleDateFormat("yyyy-MM-dd").format(oneDate);
			String ss = string.substring(0,4);//获取年份
			return Integer.parseInt(ss);
		}else{
			String string =new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String ss = string.substring(0,4);//获取年份
			return Integer.parseInt(ss);
		}
		
		
	}
	/**
	 * 1-12月统计笔数(折线图)
	 */
	public EChart analysisEchartsOfMonthCount(String whereSql) {
		StringBuffer wheresql =new StringBuffer("");
		HashMap<Integer, Integer> loadCountMap= new HashMap<>();
		HashMap<Integer, Integer> normalCapitalCountMap= new HashMap<>();
        HashMap<Integer, Integer> replaceCapitalCountMap= new HashMap<>();
        HashMap<Integer, Integer> guarantyCountMap= new HashMap<>();        
		wheresql.append(" SELECT ");//查询新增笔数;
		wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
	    wheresql.append(" COUNT(project.project_ID) AS projCount ");
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" WHERE 1=1 AND YEAR(project.delayBeginDate) = \'"+whereSql+"\'");	
		wheresql.append(" GROUP BY MONTH(project.delayBeginDate) ");		
		List<Pro_project> LoadProjectList = analysisMapper.selectDynamicProject(wheresql.toString());				
		for (Pro_project pro_project : LoadProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getDelayBeginDate()));//periodMonth 用此字段表示统计月份;
			loadCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());
		}
		wheresql =new StringBuffer(" SELECT ");
		
		/*wheresql.append(" project.freeDate as freeDate,");
	    wheresql.append(" COUNT(project.project_ID) AS projCount");
		wheresql.append(" FROM pro_project project");
		wheresql.append(" WHERE YEAR(project.freeDate) = \'"+whereSql+"\'");	
		wheresql.append(" GROUP BY MONTH(project.freeDate)");*/
		
		wheresql.append(" factPay.payDate AS freeDate ,");
		wheresql.append(" COUNT(DISTINCT factPay.project_ID) AS projCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_factPay factPay ");
		wheresql.append(" WHERE 1=1 AND YEAR(factPay.payDate) =\'"+whereSql+"\' ");	
		wheresql.append(" GROUP BY MONTH(factPay.payDate) ");
		
		List<Pro_project> normalProjectList = analysisMapper.selectDynamicProject(wheresql.toString());	
		for (Pro_project pro_project : normalProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getFreeDate()));//periodMonth 用此字段表示统计月份;
			normalCapitalCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());//获取笔数(无代偿解除)
		}
		wheresql =new StringBuffer(" SELECT ");
		wheresql.append(" pro_replace.replaceDate as replaceDate,");
		wheresql.append(" COUNT(DISTINCT pro_replace.project_ID) AS projCount");
		wheresql.append(" FROM pro_replace pro_replace");
		wheresql.append(" WHERE 1=1 AND  YEAR(pro_replace.replaceDate) = \'"+whereSql+"\'");			
		wheresql.append(" GROUP BY MONTH(pro_replace.replaceDate)");
		List<Pro_project> replaceCapitalProjectList = analysisMapper.selectDynamicProject(wheresql.toString());	
		for (Pro_project pro_project : replaceCapitalProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getReplaceDate()));//periodMonth 用此字段表示统计月份;
			replaceCapitalCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());//获取笔数(代偿解除)
		}
		wheresql =new StringBuffer(" SELECT ");
		wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
		wheresql.append(" COUNT(project.project_ID) AS projCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_project project ");
		wheresql.append(" WHERE 1=1 AND project.freeDate IS NULL AND YEAR(project.delayBeginDate) = \'"+whereSql+"\' ");
		wheresql.append(" GROUP BY MONTH(project.delayBeginDate) ");
		List<Pro_project> guarantyProjectList = analysisMapper.selectDynamicProject(wheresql.toString());	
		
		for (Pro_project pro_project : guarantyProjectList) {
			pro_project.setPeriodMonth(formatDateMonthToInteger(pro_project.getDelayBeginDate()));//periodMonth 用此字段表示统计月份;
			guarantyCountMap.put(pro_project.getPeriodMonth(), pro_project.getProjCount());//获取笔数(在保余额)
		}
		
		
		
		List<String> loadSumList= new ArrayList<>();
		List<String> normalCapitalSumList= new ArrayList<>();
        List<String> replaceCapitalSumList= new ArrayList<>();
        List<String> guarantySumList= new ArrayList<>();	
        List<String> nameList = new ArrayList<>();
        
		EChart echart=new EChart();
        for (int i =1; i <= 12; i++) {
        	nameList.add(i+"月");//获取1-12月字符串;
        	loadSumList.add(null == loadCountMap.get(i) ? "0":loadCountMap.get(i)+"");//新增笔数
        	normalCapitalSumList.add(null == normalCapitalCountMap.get(i) ? "0":normalCapitalCountMap.get(i)+"");//无代偿解除笔数
        	replaceCapitalSumList.add(null == replaceCapitalCountMap.get(i) ? "0":replaceCapitalCountMap.get(i)+"");//代偿解除笔数
        	guarantySumList.add(null == (guarantyCountMap.get(i)) ? "0":(guarantyCountMap.get(i))+"");//在保笔数;      	
        
		}  
        echart.setNameStr(nameList.toArray(new String[12]));
        echart.setLoadSumStr(loadSumList.toArray(new String[12]));
        echart.setNormalCapitalSumStr(normalCapitalSumList.toArray(new String[12]));
    	echart.setReplaceCapitalSumStr(replaceCapitalSumList.toArray(new String[12]));
    	echart.setGuaraSumStr(guarantySumList.toArray(new String[12]));
		return echart;
	}

    /**
     * 根据业务品种分类统计
     * @author zky
     * @time :2017-8-1
     * @return
     */
	public ArrayList<ArrayList<String>>  analysisByClassOfBusiType() {		 
		String whereSql = " project.busiTypeName ";//根据业务品种进行分类查询;
		ArrayList<ArrayList<String>> lists = analysisByClassByWhereSql(whereSql);
		return lists;
	}
	/**
     * 根据业务部门分类统计
     * @author zky
     * @time :2017-8-1
     * @return
     */
	public ArrayList<ArrayList<String>> analysisByClassOfDepartMent() {
		String whereSql = " applydetail.departName ";//根据业务品种进行分类查询;
		ArrayList<ArrayList<String>> lists = analysisByClassByWhereSql(whereSql);
		return lists;
	}
	/**
     * 根据合作机构分类统计
     * @author zky
     * @time :2017-8-1
     * @return
     */
	public ArrayList<ArrayList<String>> analysisByClassOfBankName() {
		String whereSql = "  project.bankName ";//根据合作机构分类统计
		ArrayList<ArrayList<String>> lists = analysisByClassByWhereSql(whereSql);
		return lists;
	}
	
	/**
     * 根据部门经理统计
     * @author zky
     * @time :2017-8-2
     * @return
     */
	public ArrayList<ArrayList<String>> analysisByClassOfAMan() {
		String whereSql = " applydetail.amanName ";//根据部门经理进行分类查询;
		ArrayList<ArrayList<String>> lists = analysisByClassByWhereSql(whereSql);
		return lists;
	}
	/**
	 * 根据不同的分类条件进行查询
	 * @param 业务品种或合作机构或项目经理或业务部门
	 * @return ArrayList<ArrayList<String>>
	 */
	private ArrayList<ArrayList<String>> analysisByClassByWhereSql(String whereSql){
		ArrayList<ArrayList<String>>  lists=  new ArrayList<>();
		List<Pro_project> guarantyProjectBeforeList  = new ArrayList<>();//统计年初在保list
		List<Pro_project> loadProjectList = new ArrayList<>();//统计本年新增list
		List<Pro_project> normalProjectList  = new ArrayList<>();//统计无代偿解除list
		List<Pro_project> replaceSumProjectList  = new ArrayList<>();//统计代偿解除list
		List<Pro_project> guarantyProjectList  = new ArrayList<>();//统计在保list
		
		if(whereSql.indexOf("project") != -1){//按业务品种或合作机构分类查询
			guarantyProjectBeforeList= analysisGuarantySumByClassBefore(whereSql);
			loadProjectList = analysisLoadSumByClass(whereSql);
			normalProjectList = analysisNormalSumByClass(whereSql);
			replaceSumProjectList = analysisReplaceSumByClass(whereSql);
			guarantyProjectList = analysisGuarantySumByClass(whereSql);
		}else if(whereSql.indexOf("applydetail") != -1){//按项目经理或业务部门分类查询
			guarantyProjectBeforeList= analysisGuarantySumByClassBefore2(whereSql);
			loadProjectList = analysisLoadSumByClass2(whereSql);
			normalProjectList = analysisNormalSumByClass2(whereSql);
			replaceSumProjectList = analysisReplaceSumByClass2(whereSql);
			guarantyProjectList = analysisGuarantySumByClass2(whereSql);
		}
		
		
		Integer sise = guarantyProjectBeforeList.size();
		
		for (int i = 0; i < sise; i++) {
			ArrayList<String> list = new ArrayList<String>();
			//获取分类名称
			if(whereSql.indexOf("busiTypeName") != -1){//按业务品种分类				
				list.add(null == guarantyProjectBeforeList.get(i).getBusiTypeName()? "" : guarantyProjectBeforeList.get(i).getBusiTypeName());				
			}else if(whereSql.indexOf("bankName") != -1){//按合作机构分类
				list.add(null == guarantyProjectBeforeList.get(i).getBankName()? "" : guarantyProjectBeforeList.get(i).getBankName());				
			}else if(whereSql.indexOf("amanName") != -1){//按部门经理分类
				list.add(null == guarantyProjectBeforeList.get(i).getAmanName()? "" : guarantyProjectBeforeList.get(i).getAmanName());				
			}else if(whereSql.indexOf("departName") != -1){//业务部门分类
				list.add(null == guarantyProjectBeforeList.get(i).getDepartName()? "" : guarantyProjectBeforeList.get(i).getDepartName());				
			}	
			//年初在保余额
			list.add(null == guarantyProjectBeforeList.get(i).getClientCount()? "0" : guarantyProjectBeforeList.get(i).getClientCount()+"");
			list.add(null == guarantyProjectBeforeList.get(i).getProjCount()? "0" : guarantyProjectBeforeList.get(i).getProjCount()+"");
			list.add(null == formatDoubleToString(guarantyProjectBeforeList.get(i).getGuarantySum())? "0" : formatDoubleToString(guarantyProjectBeforeList.get(i).getGuarantySum()));
			//本年新增担保金额
			list.add(null == loadProjectList.get(i).getClientCount()? "0" : loadProjectList.get(i).getClientCount()+"");
			list.add(null == loadProjectList.get(i).getProjCount()? "0" : loadProjectList.get(i).getProjCount()+"");
			list.add(null == formatDoubleToString(loadProjectList.get(i).getLoadSum())? "0" : formatDoubleToString(loadProjectList.get(i).getLoadSum()));
			//无代偿解除金额
			list.add(null == normalProjectList.get(i).getClientCount()? "0" : normalProjectList.get(i).getClientCount()+"");
			list.add(null == normalProjectList.get(i).getProjCount()? "0" : normalProjectList.get(i).getProjCount()+"");
			list.add(null == formatDoubleToString(normalProjectList.get(i).getNormalCapitalSum())? "0" : formatDoubleToString(normalProjectList.get(i).getNormalCapitalSum()));			
			//代偿解除金额
			list.add(null == replaceSumProjectList.get(i).getClientCount()? "0" : replaceSumProjectList.get(i).getClientCount()+"");
			list.add(null == replaceSumProjectList.get(i).getProjCount()? "0" : replaceSumProjectList.get(i).getProjCount()+"");
			list.add(null == formatDoubleToString(replaceSumProjectList.get(i).getReplaceCapitalSum())? "0" : formatDoubleToString(replaceSumProjectList.get(i).getReplaceCapitalSum()));
			//在保余额
			list.add(null == guarantyProjectList.get(i).getClientCount()? "0" : guarantyProjectList.get(i).getClientCount()+"");
			list.add(null == guarantyProjectList.get(i).getProjCount()? "0" : guarantyProjectList.get(i).getProjCount()+"");
			list.add(null == formatDoubleToString(guarantyProjectList.get(i).getGuarantySum())? "0" : formatDoubleToString(guarantyProjectList.get(i).getGuarantySum()));
			
			lists.add(list);
			
		}		
		return lists;
	
	}
	
	
	
	/**
	 * 根据业务品种分类统计:统计年初在保余额
	 * @param 业务品种或合作机构
	 * @return
	 */
	private List<Pro_project> analysisGuarantySumByClassBefore(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+", ");
		wheresql.append(" tab2.guarantySum, ");
		wheresql.append(" tab2.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM");
		wheresql.append(" pro_project project ");
		wheresql.append(" LEFT JOIN  (SELECT SUM(IFNULL(project.guarantySum,0)) AS guarantySum, ");
		wheresql.append(" COUNT(project.project_ID) AS projCount, ");
		wheresql.append(" COUNT(tab1.client_ID) AS clientCount, ");                 
		wheresql.append(" "+whereSql+" ");
		wheresql.append(" FROM  pro_project project ");
		wheresql.append(" LEFT JOIN ( SELECT  COUNT(applydetail.client_ID) AS clientCount, ");
		wheresql.append(" project.project_ID AS project_ID, ");
		wheresql.append(" applydetail.client_ID AS client_ID ");			 
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" LEFT JOIN pro_applydetail applydetail ON project.applyDetail_ID = applydetail.applyDetail_ID");	 
		wheresql.append(" WHERE 1=1 ");		
		wheresql.append(" GROUP BY "+whereSql+",applydetail.client_ID)tab1 ON  tab1.project_ID=project.project_ID");
	    wheresql.append(" WHERE 1=1 AND  "+whereSql+" IS NOT NULL AND  "+whereSql+" != '' "); 
		wheresql.append(" AND  YEAR(project.delayBeginDate) <= YEAR(NOW())-1 ");	
		wheresql.append(" AND  project.freeDate IS NULL ");	
		wheresql.append(" GROUP BY  "+whereSql+" )tab2  ON ");
		if(whereSql.indexOf("busiTypeName") != -1){//按业务品种分类;
			wheresql.append(" tab2.busiTypeName ");	 
		}else if(whereSql.indexOf("bankName") != -1){//按合作机构分类;
			wheresql.append(" tab2.bankName ");	
		}		
		wheresql.append(" = "+whereSql+" ");	 
		wheresql.append(" GROUP BY "+whereSql+" "); 
		wheresql.append(" ORDER BY "+whereSql+" "); 
		List<Pro_project> guarantySumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());
		
		return guarantySumProjectList;
	}
	
	/**
	 * 根据业务品种分类统计:统计年初在保余额
	 * @param 部门经理或业务部门
	 * @return
	 */
	private List<Pro_project> analysisGuarantySumByClassBefore2(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+" , ");
		wheresql.append(" tab1.guarantySum, ");
		wheresql.append(" tab1.projCount, ");
		wheresql.append(" COUNT(applydetail.client_ID) AS clientCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail ");		  
		wheresql.append(" LEFT JOIN ( ");	  
		wheresql.append(" SELECT  ");		      
		wheresql.append(" SUM(project.guarantySum) guarantySum, ");
		wheresql.append(" COUNT(DISTINCT project.project_ID) AS projCount, "); 
		wheresql.append(" "+whereSql+" ");		       
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail  ");
	    wheresql.append(" LEFT JOIN pro_project project ON project.applyDetail_ID = applydetail.applyDetail_ID ");
	    wheresql.append(" WHERE 1=1 AND  YEAR(project.delayBeginDate) <= YEAR(NOW())-1  ");
	    wheresql.append(" AND project.freeDate IS NULL  ");
	    wheresql.append(" GROUP BY "+whereSql+" )tab1 ON ");  
	    if(whereSql.indexOf("amanName") != -1){//按业务经理分类查询    	
	    	wheresql.append(" tab1.amanName ");	
	    }else if(whereSql.indexOf("departName") != -1){//按业务部门分类查询
	        wheresql.append(" tab1.departName ");	
	    }
	    wheresql.append("  = "+whereSql+" ");		    
	    wheresql.append(" WHERE 1=1 AND "+whereSql+" IS NOT NULL ");
	    wheresql.append(" GROUP BY "+whereSql+" ");
	    
		List<Pro_project> guarantySumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());		
		return guarantySumProjectList;
	}
	/**
	 * 
	 * 根据业务品种分类统计:统计本年新增
	 * @param 业务品种或合作机构
	 * @return
	 */
	private List<Pro_project> analysisLoadSumByClass(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+" , ");
		wheresql.append(" tab2.loadSum, ");
		wheresql.append(" tab2.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM");
		wheresql.append(" pro_project project ");
		wheresql.append(" LEFT JOIN  (SELECT SUM(IFNULL(project.loadSum,0)) AS loadSum, ");
		wheresql.append(" COUNT(project.project_ID) AS projCount, ");
		wheresql.append(" COUNT(tab1.client_ID) AS clientCount, ");                 
		wheresql.append(" "+whereSql+"  ");
		wheresql.append(" FROM  pro_project project ");
		wheresql.append(" LEFT JOIN ( SELECT  COUNT(applydetail.client_ID) AS clientCount, ");
		wheresql.append(" project.project_ID AS project_ID, ");
		wheresql.append(" applydetail.client_ID AS client_ID ");			 
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" LEFT JOIN pro_applydetail applydetail ON project.applyDetail_ID = applydetail.applyDetail_ID");	 
		wheresql.append(" WHERE 1=1 ");		
		wheresql.append(" GROUP BY "+whereSql+" ,applydetail.client_ID)tab1 ON  tab1.project_ID=project.project_ID");
		wheresql.append(" WHERE 1=1 AND  "+whereSql+"  IS NOT NULL AND  "+whereSql+" !=''"); 
		wheresql.append(" AND  YEAR(project.delayBeginDate) = YEAR(NOW()) ");	
		wheresql.append(" GROUP BY  "+whereSql+" )tab2  ON");
		
		if(whereSql.indexOf("busiTypeName") != -1){//按业务品种分类;
			wheresql.append(" tab2.busiTypeName ");	 
		}else if(whereSql.indexOf("bankName") != -1){//按合作机构分类;
			wheresql.append(" tab2.bankName ");	
		}	 	    
		wheresql.append("  = "+whereSql+"  ");	 		
		wheresql.append(" GROUP BY "+whereSql+"  "); 		
		wheresql.append(" ORDER BY "+whereSql+"  ");		
		List<Pro_project> loadSumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());		
		return loadSumProjectList;
	}
	/**
	 * 
	 * 根据业务品种分类统计:统计本年新增
	 * @param 部门经理或业务部门
	 * @return
	 */
	private List<Pro_project> analysisLoadSumByClass2(String whereSql){
		
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+", ");
		wheresql.append(" tab1.loadSum, ");
		wheresql.append(" tab1.projCount, ");
		wheresql.append(" COUNT(applydetail.client_ID) AS clientCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail ");		  
		wheresql.append(" LEFT JOIN ( ");		  
		wheresql.append(" SELECT 	 ");	      
		wheresql.append(" SUM(project.loadSum) loadSum, ");
		wheresql.append(" COUNT(DISTINCT project.project_ID) AS projCount,  ");
		wheresql.append(" "+whereSql+"	 ");	       
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail  ");
		wheresql.append(" LEFT JOIN pro_project project ON project.applyDetail_ID = applydetail.applyDetail_ID ");		    
		wheresql.append(" WHERE 1=1 AND  YEAR(project.delayBeginDate) = YEAR(NOW()) ");	  		  
		wheresql.append(" GROUP BY "+whereSql+"	 )tab1 ON ");	
		if(whereSql.indexOf("amanName") != -1){
			wheresql.append("  tab1.amanName ");
			
		}else if(whereSql.indexOf("departName") != -1){
			wheresql.append("  tab1.departName ");
		}
		
		wheresql.append("  = "+whereSql+" ");
		
		wheresql.append("  WHERE 1=1 AND "+whereSql+" IS NOT NULL 	 ");
		wheresql.append(" GROUP BY "+whereSql+" ");

		  
		List<Pro_project> loadSumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());		
		return loadSumProjectList;
	}
	/**
	 * 
	 * 根据业务品种分类统计:统计无代偿解除
	 * normalCapitalSum(解除本金)
	 * @param 业务品种或合作机构
	 * @return
	 */
	private List<Pro_project> analysisNormalSumByClass(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		/*wheresql.append(" "+whereSql+" , ");
		wheresql.append(" tab2.normalCapitalSum, ");
		wheresql.append(" tab2.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM");
		wheresql.append(" pro_project project ");
		wheresql.append(" LEFT JOIN  (SELECT SUM(IFNULL(project.normalCapitalSum,0)) AS normalCapitalSum, ");
		wheresql.append(" COUNT(project.project_ID) AS projCount, ");
		wheresql.append(" COUNT(tab1.client_ID) AS clientCount, ");                 
		wheresql.append(" "+whereSql+"  ");
		wheresql.append(" FROM  pro_project project ");
		wheresql.append(" LEFT JOIN ( SELECT  COUNT(applydetail.client_ID) AS clientCount, ");
		wheresql.append(" project.project_ID AS project_ID, ");
		wheresql.append(" applydetail.client_ID AS client_ID ");			 
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" LEFT JOIN pro_applydetail applydetail ON project.applyDetail_ID = applydetail.applyDetail_ID");	 
		wheresql.append(" WHERE 1=1 ");		
		wheresql.append(" GROUP BY "+whereSql+" ,applydetail.client_ID)tab1 ON  tab1.project_ID=project.project_ID");
		wheresql.append(" WHERE 1=1 AND  "+whereSql+"  IS NOT NULL AND  "+whereSql+" !=''"); 
		wheresql.append(" AND  project.freeDate IS NOT NULL ");	
		wheresql.append(" GROUP BY  "+whereSql+"  )tab2  ON  ");*/
		wheresql.append(" "+whereSql+"  , ");	
		wheresql.append(" tab2.normalCapitalSum, ");	
		wheresql.append(" tab2.projCount,  ");	
		wheresql.append(" tab2.clientCount ");	 
		wheresql.append(" FROM ");	
		wheresql.append(" pro_project project  ");	
		wheresql.append(" LEFT JOIN  ( ");	
		wheresql.append(" SELECT SUM(IFNULL(factpay.payCapitalSum,0)) AS normalCapitalSum, ");	 		 
		wheresql.append(" COUNT(DISTINCT factpay.project_ID) AS projCount,	 ");		 
		wheresql.append(" COUNT(DISTINCT tab1.client_ID) AS clientCount,  ");	 		                 
		wheresql.append(" "+whereSql+"   ");			 
		wheresql.append(" FROM  pro_project project  ");			 
		wheresql.append(" LEFT JOIN (  ");	
		wheresql.append(" SELECT  COUNT(applydetail.client_ID) AS clientCount, ");	
		wheresql.append(" project.project_ID AS project_ID,	 ");		    
		wheresql.append(" applydetail.client_ID AS client_ID  ");				    
		wheresql.append(" FROM   pro_factpay factpay  ");	
		wheresql.append(" LEFT JOIN pro_project project ON project.project_ID = factpay.project_ID  ");	
		wheresql.append(" LEFT JOIN pro_applydetail applydetail	 ");			    
		wheresql.append(" ON project.applyDetail_ID = applydetail.applyDetail_ID  ");				    	    
		wheresql.append(" WHERE 1=1 GROUP BY  "+whereSql+",applydetail.client_ID ");			 		 
		wheresql.append(" ) tab1 ON  tab1.project_ID=project.project_ID ");	
		wheresql.append(" LEFT JOIN pro_factpay factpay ON factpay.project_ID = project.project_ID ");			 
		wheresql.append("  WHERE 1=1 AND  "+whereSql+"  IS NOT NULL AND  "+whereSql+" !='' ");	
		wheresql.append(" AND  project.freeDate IS NOT NULL  ");	
		wheresql.append(" GROUP BY  "+whereSql+"  ");	
		wheresql.append(" )tab2   ON  ");	
		if(whereSql.indexOf("busiTypeName") != -1){//按业务品种分类;
			wheresql.append(" tab2.busiTypeName ");	 
		}else if(whereSql.indexOf("bankName") != -1){//按合作机构分类;
			wheresql.append(" tab2.bankName ");	
		}	
		wheresql.append(" = "+whereSql+"  ");	 
		
		wheresql.append(" GROUP BY "+whereSql+"  "); 
		wheresql.append(" ORDER BY "+whereSql+"  ");		
		List<Pro_project> normalSumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());		
		return normalSumProjectList;
	}
	/**
	 * 
	 * 根据业务品种分类统计:统计无代偿解除
	 * normalCapitalSum(解除本金)
	 * @param 部门经理或业务部门
	 * @return
	 */
	private List<Pro_project> analysisNormalSumByClass2(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+", ");
		wheresql.append(" tab1.payCapitalSum as normalCapitalSum, ");
		wheresql.append(" tab1.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail ");
		wheresql.append(" LEFT JOIN ( ");
		wheresql.append(" SELECT  ");    
	    wheresql.append(" SUM(factpay.payCapitalSum) payCapitalSum, ");
	    wheresql.append(" COUNT(DISTINCT factpay.project_ID) AS projCount, ");    
	    wheresql.append(" "+whereSql+"   ");  
	    wheresql.append(" FROM ");
	    wheresql.append(" pro_applydetail applydetail  ");
	    wheresql.append(" LEFT JOIN pro_project project ON project.applyDetail_ID = applydetail.applyDetail_ID ");
	    wheresql.append(" LEFT JOIN  pro_factpay factpay ON project.project_ID = factpay.project_ID ");    
	    wheresql.append(" GROUP BY "+whereSql+" )tab1 ON ");
	    if(whereSql.indexOf("amanName") != -1){//按项目经理分类;
			wheresql.append("  tab1.amanName ");
		}else if(whereSql.indexOf("departName") != -1){//按业务部门分类
			wheresql.append("  tab1.departName ");
		}	    
	    wheresql.append("  =  "+whereSql+" LEFT JOIN ( ");
	    wheresql.append(" SELECT ");
	    wheresql.append(" COUNT(DISTINCT applydetail.client_ID ) AS clientCount, ");
	    wheresql.append(" "+whereSql+" ");
	    wheresql.append(" FROM ");
	    wheresql.append(" pro_factpay factpay ");  
	    wheresql.append(" LEFT JOIN pro_project project ON factpay.project_ID = project.project_ID ");
	    wheresql.append(" LEFT JOIN pro_applydetail applydetail  ON applydetail.applyDetail_ID = project.applyDetail_ID ");
	    wheresql.append(" GROUP BY "+whereSql+" )tab2 ON "); 
	    if(whereSql.indexOf("amanName") != -1){////按项目经理分类;
			wheresql.append(" tab2.amanName ");
		}else if(whereSql.indexOf("departName") != -1){//按业务部门分类
			wheresql.append(" tab2.departName ");
		}
	    
	    wheresql.append(" = "+whereSql+" WHERE 1=1 AND "+whereSql+" IS NOT NULL  ");
	    wheresql.append(" GROUP BY "+whereSql+" ");

		  
		List<Pro_project> normalSumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());		
		return normalSumProjectList;
	}
	/**
	 * 根据业务品种分类统计:统计在保余额
	 * @param 合作机构或业务品种
	 * @return
	 */
	private List<Pro_project> analysisGuarantySumByClass(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+", ");
		wheresql.append(" tab2.guarantySum, ");
		wheresql.append(" tab2.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM");
		wheresql.append(" pro_project project ");
		wheresql.append(" LEFT JOIN  (SELECT SUM(IFNULL(project.guarantySum,0)) AS guarantySum, ");
		wheresql.append(" COUNT(project.project_ID) AS projCount, ");
		wheresql.append(" COUNT(tab1.client_ID) AS clientCount, ");                 
		wheresql.append(" "+whereSql+" ");
		wheresql.append(" FROM  pro_project project ");
		wheresql.append(" LEFT JOIN ( SELECT  COUNT(applydetail.client_ID) AS clientCount, ");
		wheresql.append(" project.project_ID AS project_ID, ");
		wheresql.append(" applydetail.client_ID AS client_ID ");			 
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" LEFT JOIN pro_applydetail applydetail ON project.applyDetail_ID = applydetail.applyDetail_ID");	 
		wheresql.append(" WHERE 1=1 ");		
		wheresql.append(" GROUP BY "+whereSql+",applydetail.client_ID)tab1 ON  tab1.project_ID=project.project_ID");
	    wheresql.append(" WHERE 1=1 AND  "+whereSql+" IS NOT NULL AND  "+whereSql+" != '' "); 
		wheresql.append(" AND  project.freeDate IS NULL ");	
		wheresql.append(" GROUP BY  "+whereSql+" )tab2  ON ");
		if(whereSql.indexOf("busiTypeName") != -1){//按业务品种分类;
			wheresql.append(" tab2.busiTypeName ");	 
		}else if(whereSql.indexOf("bankName") != -1){//按合作机构分类;
			wheresql.append(" tab2.bankName ");	
		}		
		wheresql.append(" = "+whereSql+" ");	 
		wheresql.append(" GROUP BY "+whereSql+" "); 
		wheresql.append(" ORDER BY "+whereSql+" "); 
		List<Pro_project> guarantySumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());
		
		return guarantySumProjectList;
	}
	/**
	 * 根据业务品种分类统计:统计在保余额
	 * @param 部门经理或业务部门
	 * @return
	 */
	private List<Pro_project> analysisGuarantySumByClass2(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+", ");
	    wheresql.append(" tab1.guarantySum, ");
	    wheresql.append(" tab1.projCount, ");
	    wheresql.append(" tab2.clientCount ");
	    wheresql.append(" FROM ");
	    wheresql.append(" pro_applydetail applydetail "); 
	    wheresql.append(" LEFT JOIN ( ");
	    wheresql.append(" SELECT  ");    
	    wheresql.append(" SUM(project.guarantySum) guarantySum, ");
	    wheresql.append(" COUNT(DISTINCT project.project_ID) AS projCount, ");    
	    wheresql.append(" "+whereSql+"  ");   
	    wheresql.append(" FROM ");
	    wheresql.append(" pro_applydetail applydetail  ");
	    wheresql.append(" LEFT JOIN pro_project project ON project.applyDetail_ID = applydetail.applyDetail_ID   ");   
	    wheresql.append(" AND project.freeDate IS NULL  ");
	    wheresql.append(" GROUP BY "+whereSql+"  )tab1 ON ");
	    if(whereSql.indexOf("amanName") != -1){
			wheresql.append("  tab1.amanName ");
			
		}else if(whereSql.indexOf("departName") != -1){
			wheresql.append("  tab1.departName ");
		}
	    wheresql.append(" = "+whereSql+" ");
	    wheresql.append(" LEFT JOIN ( ");
	    wheresql.append(" SELECT  ");     
	    wheresql.append(" SUM(project.guarantySum) guarantySum, ");
	    wheresql.append(" COUNT(applydetail.client_ID) AS clientCount,   ");   
	    wheresql.append(" "+whereSql+"    ");   
	    wheresql.append(" FROM ");
	    wheresql.append(" pro_project  project   ");
	    wheresql.append(" LEFT JOIN pro_applyDetail applyDetail ON project.applyDetail_ID = applydetail.applyDetail_ID  ");  
	    wheresql.append(" WHERE 1=1 AND project.freeDate IS NULL  ");   
	    wheresql.append(" GROUP BY "+whereSql+"  )tab2 ON ");
	    if(whereSql.indexOf("amanName") != -1){
			wheresql.append("  tab2.amanName ");
			
		}else if(whereSql.indexOf("departName") != -1){
			wheresql.append("  tab2.departName ");
		}
	    wheresql.append(" = "+whereSql+" ");
	    wheresql.append(" WHERE 1=1 AND "+whereSql+" IS NOT NULL  ");
	    wheresql.append(" GROUP BY "+whereSql+" ");
		  

		  
		List<Pro_project> guarantySumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());
		
		return guarantySumProjectList;
	}
	/**
	 * 根据业务品种分类统计:统计代偿金额
	 * @param 业务品种或合作机构
	 * @return
	 */
	private List<Pro_project> analysisReplaceSumByClass(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		wheresql.append(" "+whereSql+", ");
		wheresql.append(" tab2.replaceCapitalSum,");
		wheresql.append(" tab2.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM pro_project project ");
		wheresql.append(" LEFT JOIN (SELECT ");
		wheresql.append(" SUM(IFNULL(pro_replace.replaceCapitalSum,0)) AS replaceCapitalSum,"); 
		wheresql.append(" COUNT(DISTINCT pro_replace.project_ID) AS projCount, ");
		wheresql.append(" COUNT(DISTINCT tab1.client_ID) AS clientCount,"+whereSql+"  ");
		wheresql.append(" FROM  pro_project project ");
		wheresql.append(" LEFT JOIN ");
		wheresql.append(" (SELECT COUNT(applydetail.client_ID) AS clientCount, ");
		wheresql.append(" project.project_ID AS project_ID,	");	    
		wheresql.append(" applydetail.client_ID AS client_ID ");			    
		wheresql.append(" FROM  pro_replace pro_replace ");
		wheresql.append(" LEFT JOIN pro_project project ON project.project_ID = pro_replace.project_ID ");
		wheresql.append(" LEFT JOIN pro_applydetail applydetail	");		    
		wheresql.append(" ON project.applyDetail_ID = applydetail.applyDetail_ID ");			    	    
		wheresql.append(" WHERE 1=1 GROUP BY  "+whereSql+"  ,");	    
		wheresql.append(" applydetail.client_ID )tab1 ON tab1.project_ID=project.project_ID"); 
		wheresql.append(" LEFT JOIN pro_replace pro_replace ON pro_replace.project_ID = project.project_ID");
		wheresql.append(" WHERE 1=1 AND  "+whereSql+"  IS NOT NULL AND  "+whereSql+"  !='' "); 
		wheresql.append(" GROUP BY  "+whereSql+" ) tab2 ON ");
		if(whereSql.indexOf("busiTypeName") != -1){//按业务品种分类;
			wheresql.append(" tab2.busiTypeName ");	 
		}else if(whereSql.indexOf("bankName") != -1){//按合作机构分类;
			wheresql.append(" tab2.bankName ");	
		}	
		wheresql.append(" = "+whereSql+"  ");	   
		
		wheresql.append(" GROUP BY "+whereSql+"  ");
		wheresql.append(" ORDER BY "+whereSql+"  ");

		List<Pro_project> replaceSumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());
		
		return replaceSumProjectList;
	}
	
	/**
	 * 根据业务品种分类统计:统计代偿金额
	 * @param 部门经理或业务部门
	 * @return
	 */
	private List<Pro_project> analysisReplaceSumByClass2(String whereSql){
		StringBuffer wheresql =new StringBuffer(" SELECT ");		
		
		wheresql.append(" applydetail.applyDetail_ID, ");
		wheresql.append(" "+whereSql+", ");
		wheresql.append(" tab1.replaceCapitalSum, ");
		wheresql.append(" tab1.projCount, ");
		wheresql.append(" tab2.clientCount ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail ");
		wheresql.append(" LEFT JOIN ( ");
		wheresql.append(" SELECT ");     
		wheresql.append(" SUM(pro_replace.replaceCapitalSum) replaceCapitalSum, ");
		wheresql.append(" COUNT(DISTINCT pro_replace.project_ID) AS projCount, ");    
		wheresql.append(" "+whereSql+"  ");   
		wheresql.append(" FROM ");
		wheresql.append(" pro_applydetail applydetail  ");
		wheresql.append(" LEFT JOIN pro_project project ON project.applyDetail_ID = applydetail.applyDetail_ID ");
		wheresql.append(" LEFT JOIN  pro_replace pro_replace ON project.project_ID = pro_replace.project_ID ");  
		wheresql.append(" GROUP BY "+whereSql+"  )tab1 ON");
		if(whereSql.indexOf("amanName") != -1){
			wheresql.append("  tab1.amanName ");
			
		}else if(whereSql.indexOf("departName") != -1){
			wheresql.append("  tab1.departName ");
		}
		wheresql.append(" = "+whereSql+" ");
		wheresql.append(" LEFT JOIN ( ");
		wheresql.append(" SELECT ");
		wheresql.append(" COUNT(DISTINCT applydetail.client_ID ) AS clientCount, ");
		wheresql.append(" "+whereSql+" ");
		wheresql.append(" FROM ");
		wheresql.append(" pro_replace pro_replace  ");
		wheresql.append(" LEFT JOIN pro_project project ON pro_replace.project_ID = project.project_ID ");
		wheresql.append(" LEFT JOIN pro_applydetail applydetail  ON applydetail.applyDetail_ID = project.applyDetail_ID ");
		wheresql.append(" GROUP BY "+whereSql+"   )tab2 ON ");
		if(whereSql.indexOf("amanName") != -1){
			wheresql.append("  tab2.amanName ");
			
		}else if(whereSql.indexOf("departName") != -1){
			wheresql.append("  tab2.departName ");
		}
		
		wheresql.append("  = "+whereSql+" ");
		
		wheresql.append(" WHERE 1=1 AND "+whereSql+" IS NOT NULL  ");
		wheresql.append(" GROUP BY "+whereSql+" ");
		List<Pro_project> replaceSumProjectList = analysisMapper.selectDynamicProject(wheresql.toString());
		
		return replaceSumProjectList;
	}
	
		/**
	     * 按年份统计金额(表格)
	     * @return
	     */
		public ArrayList<Pro_project> analysisTableOfYearsSum() {		    
				StringBuffer wheresql =new StringBuffer();			 
				wheresql.append(" SELECT ");
				wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
				wheresql.append(" SUM(IFNULL(project.loadSum,0)) AS loadSum, ");
				wheresql.append(" (SELECT SUM(IFNULL(pro_replace.replaceCapitalSum,0))");				
				wheresql.append(" FROM pro_replace pro_replace WHERE YEAR(pro_replace.replaceDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
				wheresql.append(" FROM pro_project project) AND YEAR(pro_replace.replaceDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(pro_replace.replaceDate) ");				
				wheresql.append(" ) AS replaceCapitalSum, ");					
				wheresql.append(" (SELECT SUM(IFNULL(factPay.payCapitalSum,0)) ");
				wheresql.append(" FROM pro_factPay factPay WHERE YEAR(factPay.payDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
				wheresql.append(" FROM pro_project project) AND YEAR(factPay.payDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(factPay.payDate) ");
				wheresql.append(" ) AS normalCapitalSum ,");
				wheresql.append(" (   SELECT SUM(IFNULL(project1.guarantySum,0)) ");
				wheresql.append(" FROM pro_project project1 WHERE YEAR(project1.delayBeginDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate "); 
				wheresql.append(" FROM pro_project project) AND YEAR(project1.delayBeginDate) = YEAR(project.delayBeginDate) "); 
				wheresql.append("  AND project1.freeDate IS NULL ");
				wheresql.append(" GROUP BY YEAR(project1.delayBeginDate) "); 
				wheresql.append(" ) AS guarantySum  ");
				wheresql.append(" FROM");
				wheresql.append("  pro_project project");
				wheresql.append(" GROUP BY YEAR(project.delayBeginDate)");
			 
				
				/*wheresql.append(" project.loadBeginDate AS loadBeginDate,");
				wheresql.append(" SUM(IFNULL(project.loadSum,0)) AS loadSum,");
				wheresql.append(" SUM(IFNULL(project.replaceCapitalSum,0)) AS replaceCapitalSum,");
				wheresql.append(" SUM(IFNULL(project.normalCapitalSum,0)) AS normalCapitalSum,");
				wheresql.append(" SUM(IFNULL(project.guarantySum,0)) AS guarantySum");
				wheresql.append(" FROM");
				wheresql.append(" pro_project project");		
				wheresql.append(" GROUP BY YEAR(project.loadBeginDate) ");		  
				wheresql.append(" ORDER BY  project.loadBeginDate ");*/				
				/**
				 *按年统计-- 获取年份:新增放款金额,无代偿解除金额,代偿解除金额;
				 */
				List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());	
				
				ArrayList<Pro_project>  SumLists=  new ArrayList<>();
				for (Pro_project pro_project : projectList) {
					
					pro_project.setAnalysisYears(formatDateYearToInteger(pro_project.getDelayBeginDate()));
					Double loadSum = null == pro_project.getLoadSum()? 0d : pro_project.getLoadSum();//放款金额
					Double normalCapitalSum = null == pro_project.getNormalCapitalSum()? 0d : pro_project.getNormalCapitalSum();//无代偿解除;
					Double replaceCapitalSum = null == pro_project.getReplaceCapitalSum() ? 0d :  pro_project.getReplaceCapitalSum();//代偿解除;					
					pro_project.setGuarantyDutySum(loadSum-normalCapitalSum-replaceCapitalSum);	//获取在保余额;				
					SumLists.add(pro_project);
				}				 
			return SumLists;
	    }
		
		/**
	     * 按年份统计笔数(表格)
	     * @return
	     */
		public ArrayList<Pro_project> analysisTableOfYearsCount() {
			
			    StringBuffer wheresql =new StringBuffer(" SELECT ");
			    wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
			    wheresql.append(" IFNULL (COUNT(DISTINCT project.project_ID),0) AS projCount, ");
			    wheresql.append(" (SELECT IFNULL (COUNT(DISTINCT pro_replace.project_ID),0) ");				
			    wheresql.append(" FROM pro_replace pro_replace WHERE YEAR(pro_replace.replaceDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			    wheresql.append(" FROM pro_project project) AND YEAR(pro_replace.replaceDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(pro_replace.replaceDate) ");			
			    wheresql.append(" ) AS replaceCount, ");					
			    wheresql.append(" ( SELECT IFNULL (COUNT(DISTINCT factPay.project_ID),0) ");				
			    wheresql.append(" FROM pro_factPay factPay WHERE YEAR(factPay.payDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			    wheresql.append(" FROM pro_project project) AND YEAR(factPay.payDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(factPay.payDate)	");			
			    wheresql.append(" ) AS normolCount, ");
			    wheresql.append(" ( SELECT IFNULL (COUNT(project1.project_ID),0) ");				
			    wheresql.append(" FROM pro_project project1 WHERE YEAR(project1.delayBeginDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			    wheresql.append(" FROM pro_project project) AND YEAR(project1.delayBeginDate) = YEAR(project.delayBeginDate) ");				
			    wheresql.append(" AND project1.freedate IS NULL ");
			    wheresql.append(" GROUP BY YEAR(project1.delayBeginDate)	");			
			    wheresql.append(" ) AS guarantyCount");				
			    wheresql.append(" FROM ");
			    wheresql.append(" pro_project project ");
			    wheresql.append("  GROUP BY YEAR(project.delayBeginDate) ");
			    /**
			     *按年统计-- 获取年份:新增放款笔数,无代偿解除笔数,代偿解除笔数;
			     */
			    List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());				
				
			    ArrayList<Pro_project>   countLists=  new ArrayList<>();
				for (Pro_project pro_project : projectList) {					
					pro_project.setAnalysisYears(formatDateYearToInteger(pro_project.getLoadBeginDate()));
					countLists.add(pro_project);
				}		
			return countLists;
		}
		
		/**
		 *  按年份统计金额(折线图)
		 * @param
		 * @return
		 */
		public EChart analysisOfYearsSum() {			
			StringBuffer wheresql =new StringBuffer(" SELECT ");			 
			wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
			wheresql.append(" SUM(IFNULL(project.loadSum,0)) AS loadSum, ");
			wheresql.append(" (SELECT SUM(IFNULL(pro_replace.replaceCapitalSum,0))");				
			wheresql.append(" FROM pro_replace pro_replace WHERE YEAR(pro_replace.replaceDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			wheresql.append(" FROM pro_project project) AND YEAR(pro_replace.replaceDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(pro_replace.replaceDate) ");				
			wheresql.append(" ) AS replaceCapitalSum, ");					
			wheresql.append(" (SELECT SUM(IFNULL(factPay.payCapitalSum,0)) ");
			wheresql.append(" FROM pro_factPay factPay WHERE YEAR(factPay.payDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			wheresql.append(" FROM pro_project project) AND YEAR(factPay.payDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(factPay.payDate) ");
			wheresql.append(" ) AS normalCapitalSum ,");
			wheresql.append(" (   SELECT SUM(IFNULL(project1.guarantySum,0)) ");
			wheresql.append(" FROM pro_project project1 WHERE YEAR(project1.delayBeginDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate "); 
			wheresql.append(" FROM pro_project project) AND YEAR(project1.delayBeginDate) = YEAR(project.delayBeginDate) "); 
			wheresql.append("  AND project1.freeDate IS NULL ");
			wheresql.append(" GROUP BY YEAR(project1.delayBeginDate) "); 
			wheresql.append(" ) AS guarantySum  ");
			wheresql.append(" FROM");
			wheresql.append("  pro_project project ");
			wheresql.append(" GROUP BY YEAR(project.delayBeginDate) ");
			/**
			 *按年统计-- 获取年份:新增放款金额,无代偿解除金额,代偿解除金额;
			 */
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());	
			List<String> nameList = new ArrayList<>();//年份字符串list
			List<String> loadSumList= new ArrayList<>();//新增金额字符串list
			List<String> normalCapitalSumList= new ArrayList<>();//无代偿金额字符串list
	        List<String> replaceCapitalSumList= new ArrayList<>();//代偿金额字符串list
	        List<String> guarantySumList= new ArrayList<>();//在保余额字符串list
	        EChart echart=new EChart();
			for (Pro_project pro_project : projectList) {
				nameList.add(formatDateYearToInteger(pro_project.getLoadBeginDate())+"年");
				loadSumList.add(null == pro_project.getLoadSum() ? "0" : formatDoubleToString(pro_project.getLoadSum()));
				normalCapitalSumList.add(null==pro_project.getNormalCapitalSum() ? "0" : formatDoubleToString(pro_project.getNormalCapitalSum()));
				replaceCapitalSumList.add(null==pro_project.getReplaceCapitalSum() ? "0" : formatDoubleToString(pro_project.getReplaceCapitalSum()));
				guarantySumList.add(null == pro_project.getGuarantySum() ? "0" : formatDoubleToString(pro_project.getGuarantySum()));
			
			}
			Integer size = projectList.size();
		    echart.setNameStr(nameList.toArray(new String[size]));
	        echart.setLoadSumStr(loadSumList.toArray(new String[size]));
	        echart.setNormalCapitalSumStr(normalCapitalSumList.toArray(new String[size]));
        	echart.setReplaceCapitalSumStr(replaceCapitalSumList.toArray(new String[size]));
        	echart.setGuaraSumStr(guarantySumList.toArray(new String[size]));
			return echart;
		}
		
		
		/**
		 * 按年份统计笔数(折线图)
		 * @param
		 * @return
		 */
		public EChart analysisEchartsOfYearsCount() {
			    StringBuffer wheresql =new StringBuffer(" SELECT ");
			    wheresql.append(" project.delayBeginDate AS delayBeginDate, ");
			    wheresql.append(" IFNULL (COUNT(DISTINCT project.project_ID),0) AS projCount, ");
			    wheresql.append(" (SELECT IFNULL (COUNT(DISTINCT pro_replace.project_ID),0) ");				
			    wheresql.append(" FROM pro_replace pro_replace WHERE YEAR(pro_replace.replaceDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			    wheresql.append(" FROM pro_project project) AND YEAR(pro_replace.replaceDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(pro_replace.replaceDate) ");			
			    wheresql.append(" ) AS replaceCount, ");					
			    wheresql.append(" ( SELECT IFNULL (COUNT(DISTINCT factPay.project_ID),0) ");				
			    wheresql.append(" FROM pro_factPay factPay WHERE YEAR(factPay.payDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			    wheresql.append(" FROM pro_project project) AND YEAR(factPay.payDate) = YEAR(project.delayBeginDate) GROUP BY YEAR(factPay.payDate)	");			
			    wheresql.append(" ) AS normolCount, ");
			    wheresql.append(" ( SELECT IFNULL (COUNT(project1.project_ID),0) ");				
			    wheresql.append(" FROM pro_project project1 WHERE YEAR(project1.delayBeginDate) IN (SELECT YEAR(project.delayBeginDate) AS delayBeginDate ");
			    wheresql.append(" FROM pro_project project) AND YEAR(project1.delayBeginDate) = YEAR(project.delayBeginDate) ");				
			    wheresql.append(" AND project1.freedate IS NULL ");
			    wheresql.append(" GROUP BY YEAR(project1.delayBeginDate)	");			
			    wheresql.append(" ) AS guarantyCount");				
			    wheresql.append(" FROM ");
			    wheresql.append(" pro_project project ");
			    wheresql.append("  GROUP BY YEAR(project.delayBeginDate) ");
			    /**
			     *按年统计-- 获取年份:新增放款笔数,无代偿解除笔数,代偿解除笔数;
			     */
			    List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());
			    List<String> nameList = new ArrayList<>();//年份字符串list
				List<String> loadCountList= new ArrayList<>();//新增笔数字符串list
				List<String> normalCapitalCountList= new ArrayList<>();//无代偿笔数字符串list
		        List<String> replaceCapitalCountList= new ArrayList<>();//代偿笔数字符串list
		        List<String> guarantyCountList= new ArrayList<>();//在保笔数字符串list
		        EChart echart=new EChart();
				for (Pro_project pro_project : projectList) {
					nameList.add(formatDateYearToInteger(pro_project.getLoadBeginDate())+"年");
					loadCountList.add(null == pro_project.getProjCount() ? "0" : pro_project.getProjCount()+"");
					normalCapitalCountList.add(null==pro_project.getNormolCount() ? "0" : pro_project.getNormolCount()+"");
					replaceCapitalCountList.add(null==pro_project.getReplaceCount() ? "0" : pro_project.getReplaceCount()+"");
					guarantyCountList.add(null == pro_project.getGuarantyCount() ? "0" : pro_project.getGuarantyCount()+"");
				
				}
				Integer size = projectList.size();
			    echart.setNameStr(nameList.toArray(new String[size]));
		        echart.setLoadSumStr(loadCountList.toArray(new String[size]));
		        echart.setNormalCapitalSumStr(normalCapitalCountList.toArray(new String[size]));
	        	echart.setReplaceCapitalSumStr(replaceCapitalCountList.toArray(new String[size]));
	        	echart.setGuaraSumStr(guarantyCountList.toArray(new String[size]));
				return echart;
		}
		/**
		 * 统计2018年担保集团各公司清收清欠占比
		 * 
		 */
		public EChart analysisOfEachCompany() {
			Calendar ca = Calendar.getInstance();
			StringBuffer wheresql =new StringBuffer(" SELECT ");
//				wheresql.append(" pa.guarantyOrgName,  ");
			wheresql.append(" cd.dicTypeName as oprationCompanyName,  ");
			wheresql.append(" (SUM(IFNULL(tab1.payCapitalSum, 0)) + SUM(IFNULL(tab1.payInterestSum, 0)) + SUM(IFNULL(tab2.returnSum, 0))) AS clearSum ");
			wheresql.append(" FROM pro_project pp  ");
			wheresql.append(" LEFT JOIN pro_apply pa ON pa.apply_ID = pp.apply_ID ");
			wheresql.append(" LEFT JOIN ( SELECT SUM(IFNULL(pfp.payInterestSum,0)) payInterestSum,SUM(IFNULL(pfp.payCapitalSum,0)) payCapitalSum,pfp.project_ID ");
			wheresql.append("  FROM pro_factpay pfp ");
			wheresql.append("  LEFT JOIN  pro_project pp1 ON pfp.project_ID = pp1.project_ID ");
			wheresql.append(" WHERE pp1.busiClass = '02' AND DATE_FORMAT(pfp.payDate ,'%Y') = '"+ca.get(Calendar.YEAR)+"'  GROUP BY pfp.project_ID ");
			wheresql.append(" ) tab1 ON pp.project_ID = tab1.project_ID ");
			wheresql.append(" LEFT JOIN ( SELECT SUM(IFNULL(prd.returnSum,0)) returnSum,prd.projectID ");
			wheresql.append(" FROM pro_returndetail prd ");
			wheresql.append(" LEFT JOIN  pro_project pp2 ON prd.projectID = pp2.project_ID ");
			wheresql.append(" WHERE pp2.busiClass = '01' AND DATE_FORMAT(prd.returnDate ,'%Y') = '"+ca.get(Calendar.YEAR)+"' GROUP BY prd.projectID  ");
			wheresql.append(" ) tab2 ON pp.project_ID = tab2.projectID ");
			wheresql.append(" LEFT JOIN( SELECT SUM(IFNULL(pcf.`factCostSum`,0)) factCostSum, ");
			wheresql.append(" pcf.apply_ID  FROM Pro_costFact pcf ");
			wheresql.append(" WHERE pcf.`costTypeName` = '担保费' ");
			wheresql.append(" GROUP BY pcf.apply_ID  ");
			wheresql.append(" )tab3 ON tab3.apply_ID = pa.`apply_ID` ");
			wheresql.append(" LEFT JOIN c_dictype cd on cd.dicTypeID = pa.oprationCompanyID ");
//			wheresql.append(" WHERE pa.guarantyOrgName IS NOT NULL ");
//			wheresql.append(" GROUP BY pa.guarantyOrgName ");
//			wheresql.append(" WHERE pa.oprationCompanyID IS NOT NULL ");
//			wheresql.append("  AND pa.oprationCompanyID in " //后期需要修改成 根据报送机构查询，目前先根据担保公司的报送机构来查。
//					+ "('3d7ee9e05896409b93fe4533bdef48e1','59414797e42b4f9ea5e94840cf21d7b3','df94685bdcb245da8a9974036a490b01') ");
			wheresql.append(" GROUP BY pa.oprationCompanyID ");
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());		    
	        EChart echart=new EChart();
			List<EChart> echartList=new ArrayList<EChart>();
			List<String> nameList = new ArrayList<>();//跟公司字符串list
			List<String> sumList=new ArrayList<String>();
			for (Pro_project pro_project : projectList) {
				nameList.add(pro_project.getOprationCompanyName());
				sumList.add(null == pro_project.getClearSum()? "0" : pro_project.getClearSum()+"");
				echart=new EChart();
				echart.setName(pro_project.getOprationCompanyName());
				echart.setValue(null == pro_project.getClearSum()? "0" : pro_project.getClearSum()+"");
				echartList.add(echart);
			}
			if(projectList.size()!=0){
				Integer size=projectList.size();
				echart=new EChart();
				echart.setNameStr(nameList.toArray(new String[size]));
				echart.setGuaraSumStr(sumList.toArray(new String[size]));//清收清欠总金额
				echart.setEchartList(echartList);
			}
			/*for (Pro_project pro_project : projectList) {
				nameList.add(pro_project.getGuarantyOrgName());
				guarantySumList.add(null == pro_project.getClearSum()? "0" : pro_project.getClearSum()+"");
			}
			Integer size = projectList.size();
		    echart.setNameStr(nameList.toArray(new String[size]));
        	echart.setGuaraSumStr(guarantySumList.toArray(new String[size]));//清收清欠总金额*/
			return echart;
		}
		
		/**
		 *五级分类在保余额
		 */
		public EChart analysisOfFiveClass() {
			//拼接查询当前年在保余额sql
			StringBuffer wheresql2 =new StringBuffer(" SELECT ");
			wheresql2.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum,0)) AS guarantySum ");
			wheresql2.append(" FROM c_dicType  dic ");
			wheresql2.append(" LEFT JOIN (SELECT cc1.riskLevelID,(SUM(IFNULL(pp.loadSum,0))-SUM(IFNULL(tab1.payCapitalSum,0))-SUM(IFNULL(tab2.replaceCapitalSum,0))) AS guarantySum,pa.clientGUID  ");
			wheresql2.append(" FROM pro_project pp ");
			wheresql2.append(" LEFT JOIN  pro_apply  pa ON pp.apply_ID=pa.apply_ID ");
			wheresql2.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID`=pa.`client_ID` ");
			wheresql2.append(" LEFT JOIN (SELECT pfp.project_ID,SUM(IFNULL(pfp.payCapitalSum,0)) AS payCapitalSum ");
			wheresql2.append(" FROM pro_factpay pfp  WHERE 	1=1 AND YEAR(pfp.payDate) <=  DATE_FORMAT(NOW(), '%Y') ");
			wheresql2.append(" GROUP BY pfp.project_ID  ");
			wheresql2.append(" )tab1 ON tab1.project_ID =  pp.project_ID ");
			wheresql2.append(" LEFT JOIN (SELECT pre.project_ID, SUM(IFNULL(pre.replaceCapitalSum,0)) AS replaceCapitalSum  ");
			wheresql2.append(" FROM pro_replace pre  ");
			wheresql2.append(" WHERE 	1=1 AND YEAR(pre.`replaceDate`)  <= DATE_FORMAT(NOW(), '%Y') ");
			wheresql2.append(" GROUP BY pre.project_ID ");
			wheresql2.append(" )tab2 ON tab2.project_ID =  pp.project_ID ");
			wheresql2.append("  WHERE pp.busiClass= '01' AND YEAR(pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y') ");
			wheresql2.append(" GROUP BY cc1.riskLevelID ");
			wheresql2.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
			wheresql2.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
			wheresql2.append(" GROUP BY dic.dicTypeName ");
			wheresql2.append(" ORDER BY  dic.order_id  ");
			
			//拼接查询当前年在保余额sql 2
//			StringBuffer wheresqlF2 =new StringBuffer(" SELECT ");
//			wheresqlF2.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum, 0)) AS guarantySum ");
//			wheresqlF2.append(" FROM c_dicType dic ");
//			wheresqlF2.append(" LEFT JOIN ( SELECT cc1.riskLevelID,pp.guarantySum AS guarantySum,pa.clientGUID ");
//			wheresqlF2.append(" FROM pro_project pp ");
//			wheresqlF2.append(" LEFT JOIN pro_apply pa ON pp.apply_ID = pa.apply_ID ");
//			wheresqlF2.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID` = pa.`client_ID` ");
//			wheresqlF2.append(" WHERE pp.busiClass = '01' AND AND YEAR (pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y') ");
//			wheresqlF2.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
//			wheresqlF2.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
//			wheresqlF2.append(" GROUP BY dic.dicTypeName ");
//			wheresqlF2.append(" ORDER BY  dic.order_id  ");
			
			
	        //拼接查询当上一年在保余额sql
			StringBuffer wheresql3 =new StringBuffer(" SELECT ");
			wheresql3.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum,0)) AS guarantySum ");
			wheresql3.append(" FROM c_dicType  dic ");
			wheresql3.append(" LEFT JOIN (SELECT cc1.riskLevelID,(SUM(IFNULL(pp.loadSum,0))-SUM(IFNULL(tab1.payCapitalSum,0))-SUM(IFNULL(tab2.replaceCapitalSum,0))) AS guarantySum,pa.clientGUID  ");
			wheresql3.append(" FROM pro_project pp ");
			wheresql3.append(" LEFT JOIN  pro_apply  pa ON pp.apply_ID=pa.apply_ID ");
			wheresql3.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID`=pa.`client_ID` ");
			wheresql3.append(" LEFT JOIN (SELECT pfp.project_ID,SUM(IFNULL(pfp.payCapitalSum,0)) AS payCapitalSum ");
			wheresql3.append(" FROM pro_factpay pfp  WHERE 	1=1 AND YEAR(pfp.payDate) <=  DATE_FORMAT(NOW(), '%Y')-1 ");
			wheresql3.append(" GROUP BY pfp.project_ID  ");
			wheresql3.append(" )tab1 ON tab1.project_ID =  pp.project_ID ");
			wheresql3.append(" LEFT JOIN (SELECT pre.project_ID, SUM(IFNULL(pre.replaceCapitalSum,0)) AS replaceCapitalSum  ");
			wheresql3.append(" FROM pro_replace pre  ");
			wheresql3.append(" WHERE 	1=1 AND YEAR(pre.`replaceDate`)  <= DATE_FORMAT(NOW(), '%Y')-1 ");
			wheresql3.append(" GROUP BY pre.project_ID ");
			wheresql3.append(" )tab2 ON tab2.project_ID =  pp.project_ID ");
			wheresql3.append("  WHERE pp.busiClass= '01' AND YEAR(pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y')-1 ");
			wheresql3.append(" GROUP BY cc1.riskLevelID ");
			wheresql3.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
			wheresql3.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
			wheresql3.append(" GROUP BY dic.dicTypeName ");
			wheresql3.append(" ORDER BY  dic.order_id  ");
			
			
//			StringBuffer wheresqlF3 =new StringBuffer(" SELECT ");
//			wheresqlF3.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum, 0)) AS guarantySum ");
//			wheresqlF3.append(" FROM c_dicType dic ");
//			wheresqlF3.append(" LEFT JOIN ( SELECT cc1.riskLevelID,pp.guarantySum AS guarantySum,pa.clientGUID ");
//			wheresqlF3.append(" FROM pro_project pp ");
//			wheresqlF3.append(" LEFT JOIN pro_apply pa ON pp.apply_ID = pa.apply_ID ");
//			wheresqlF3.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID` = pa.`client_ID` ");
//			wheresqlF3.append(" WHERE pp.busiClass = '01' AND AND YEAR (pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y')-1 ");
//			wheresqlF3.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
//			wheresqlF3.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
//			wheresqlF3.append(" GROUP BY dic.dicTypeName ");
//			wheresqlF3.append(" ORDER BY  dic.order_id  ");
			
			
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql2.toString());//获取当前年情况
			List<Pro_project> projectList1 = analysisMapper.selectDynamicProject(wheresql3.toString());//获取上一年情况
		    List<String> nameList = new ArrayList<>();//跟公司字符串list
	        List<String> guaraSumList= new ArrayList<>();//在保金额字符串list
	        List<String> guaraSumList2= new ArrayList<>();//在保金额字符串list
	        DecimalFormat decimalFormat = new DecimalFormat("######.######");  
	        EChart echart=new EChart();
			for (Pro_project pro_project : projectList) {
				nameList.add(pro_project.getDicTypeName());
				guaraSumList.add(null == pro_project.getGuarantySum() ? "0" : decimalFormat.format(pro_project.getGuarantySum())+"");
			}
			for (Pro_project pro_project : projectList1) {
				guaraSumList2.add(null == pro_project.getGuarantySum() ? "0" : decimalFormat.format(pro_project.getGuarantySum())+"");
			}
			Integer size = projectList.size();
		    echart.setNameStr(nameList.toArray(new String[size]));
        	echart.setGuaraSumStr(guaraSumList.toArray(new String[size]));
        	echart.setGuaraSumStr2(guaraSumList2.toArray(new String[size]));
			return echart;
		}
		
		/**
		 * 清收清欠费用占比
		 */
		public EChart analysisOfCostCompare() {
			StringBuffer wheresql =new StringBuffer(" SELECT ");
			wheresql.append(" SUM(IFNULL(tab1.payCapitalSum,0)) payCapitalSum, ");
			wheresql.append(" SUM(IFNULL(tab1.payInterestSum,0)) payInterestSum, ");
			wheresql.append(" SUM(IFNULL(tab2.returnSum,0)) returnSum, ");
			wheresql.append(" SUM(IFNULL(tab3.factCostSum,0)) factCostSum ");
			wheresql.append(" FROM pro_project pp  ");
			wheresql.append(" LEFT JOIN pro_apply pa ON pa.apply_ID = pp.apply_ID ");
			wheresql.append(" LEFT JOIN ( ");
			wheresql.append(" SELECT SUM(IFNULL(pfp.payInterestSum,0)) payInterestSum,SUM(IFNULL(pfp.payCapitalSum,0)) payCapitalSum,pfp.project_ID ");
			wheresql.append(" FROM pro_factpay pfp ");
			wheresql.append(" LEFT JOIN  pro_project pp1 ON pfp.project_ID = pp1.project_ID ");
			wheresql.append(" WHERE pp1.busiClass='02' GROUP BY pfp.project_ID ");
			wheresql.append(" ) tab1 ON pp.project_ID = tab1.project_ID ");
			wheresql.append(" LEFT JOIN ( ");
			wheresql.append(" SELECT SUM(IFNULL(prd.returnSum,0)) returnSum,prd.projectID ");
			wheresql.append(" FROM pro_returndetail prd ");
			wheresql.append(" LEFT JOIN  pro_project pp2 ON prd.projectID = pp2.project_ID ");
			wheresql.append(" WHERE pp2.busiClass='01' GROUP BY prd.projectID  ");
			wheresql.append(" ) tab2 ON pp.project_ID = tab2.projectID ");
			wheresql.append(" LEFT JOIN(SELECT SUM(IFNULL(pcf.`factCostSum`,0)) factCostSum,pcf.apply_ID FROM Pro_costFact pcf ");
			wheresql.append("  WHERE pcf.`costTypeName` = '担保费' GROUP BY pcf.apply_ID   ");
			wheresql.append(" )tab3 ON tab3.apply_ID = pa.`apply_ID` ");
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());
			List<String> nameList = new ArrayList<>();//跟公司字符串list
			List<String> guarantyCountList= new ArrayList<>();//在保笔数字符串list
			List<String> sumList=new ArrayList<String>();
			List<EChart> echartList=new ArrayList<EChart>();
			EChart echart=new EChart();
			nameList.add("委贷本金");
			nameList.add("委贷利息");
			nameList.add("代偿清收");
			nameList.add("保费清收");
			sumList.add(null == projectList.get(0).getPayCapitalSum()? "0" : projectList.get(0).getPayCapitalSum()+"");//委贷本金
			sumList.add(null == projectList.get(0).getPayInterestSum()? "0" : projectList.get(0).getPayInterestSum()+"");//委贷利息
			sumList.add(null == projectList.get(0).getReturnSum()? "0" : projectList.get(0).getReturnSum()+"");//代偿清收
			sumList.add(null == projectList.get(0).getFactCostSum()? "0" : projectList.get(0).getFactCostSum()+"");//保费清收
			
			for (int i = 0; i < 4 ; i++) {
				echart=new EChart();
				echart.setName(nameList.get(i));
				echart.setValue(sumList.get(i));
				echartList.add(echart);
			}
			
			if(nameList.size()!=0){
				Integer size=nameList.size();
				echart=new EChart();
				echart.setNameStr(nameList.toArray(new String[size]));
				echart.setGuaraSumStr(sumList.toArray(new String[size]));//清收清欠总金额
				echart.setEchartList(echartList);
			}
			return echart;
		}
		
		/**
		 * 清收清欠费用占比jchen 2018-4-17
		 */
		public EChart analysisOfCostCompareF() {
			Calendar ca = Calendar.getInstance();
			StringBuffer wheresql =new StringBuffer(" SELECT ");
			wheresql.append(" SUM(IFNULL(tab1.payCapitalSum,0)) payCapitalSum, ");
			wheresql.append(" SUM(IFNULL(tab2.returnSum,0)) returnSum, ");
			wheresql.append(" SUM(IFNULL(tab3.factCostSum,0)) factCostSum ");
			wheresql.append(" FROM pro_project pp  ");
			wheresql.append(" LEFT JOIN pro_apply pa ON pa.apply_ID = pp.apply_ID ");
			wheresql.append(" LEFT JOIN ( ");
			wheresql.append(" SELECT (SUM(IFNULL(pfp.payInterestSum,0)) + SUM(IFNULL(pfp.payCapitalSum,0))) payCapitalSum,pfp.project_ID ");
			wheresql.append(" FROM pro_factpay pfp ");
			wheresql.append(" LEFT JOIN  pro_project pp1 ON pfp.project_ID = pp1.project_ID ");
			wheresql.append(" WHERE pp1.busiClass='02' AND DATE_FORMAT(pfp.payDate ,'%Y') = '"+ca.get(Calendar.YEAR)+"' GROUP BY pfp.project_ID ");
			wheresql.append(" ) tab1 ON pp.project_ID = tab1.project_ID ");
			wheresql.append(" LEFT JOIN ( ");
			wheresql.append(" SELECT SUM(IFNULL(prd.returnSum,0)) returnSum,prd.projectID ");
			wheresql.append(" FROM pro_returndetail prd ");
			wheresql.append(" LEFT JOIN  pro_project pp2 ON prd.projectID = pp2.project_ID ");
			wheresql.append(" WHERE pp2.busiClass='01'  AND DATE_FORMAT(prd.returnDate ,'%Y') = '"+ca.get(Calendar.YEAR)+"' GROUP BY prd.projectID  ");
			wheresql.append(" ) tab2 ON pp.project_ID = tab2.projectID ");
			wheresql.append(" LEFT JOIN(SELECT SUM(IFNULL(pcf.`factCostSum`,0)) factCostSum,pcf.apply_ID FROM Pro_costFact pcf ");
			wheresql.append("  WHERE pcf.`costTypeName` = '担保费' GROUP BY pcf.apply_ID   ");
			wheresql.append(" )tab3 ON tab3.apply_ID = pa.`apply_ID` ");
			List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql.toString());
			List<String> nameList = new ArrayList<>();//跟公司字符串list
			List<String> guarantyCountList= new ArrayList<>();//在保笔数字符串list
			List<String> sumList=new ArrayList<String>();
			List<EChart> echartList=new ArrayList<EChart>();
			EChart echart=new EChart();
			nameList.add("委贷清收");
			nameList.add("代偿清收");
			nameList.add("保费清收");
			sumList.add(null == projectList.get(0).getPayCapitalSum()? "0" : projectList.get(0).getPayCapitalSum()+"");//委贷本金
			sumList.add(null == projectList.get(0).getReturnSum()? "0" : projectList.get(0).getReturnSum()+"");//代偿清收
			sumList.add(null == projectList.get(0).getFactCostSum()? "0" : projectList.get(0).getFactCostSum()+"");//保费清收
			
			for (int i = 0; i < 3 ; i++) {
				echart=new EChart();
				echart.setName(nameList.get(i));
				echart.setValue(sumList.get(i));
				echartList.add(echart);
			}
			
			if(nameList.size()!=0){
				Integer size=nameList.size();
				echart=new EChart();
				echart.setNameStr(nameList.toArray(new String[size]));
				echart.setGuaraSumStr(sumList.toArray(new String[size]));//清收清欠总金额
				echart.setEchartList(echartList);
			}
			return echart;
		}
		
		
		/**
		 * 2017年担保压降额及预测
		 */
		public EChart analysisOfGuarantySumDrop() {
			List<String> nameList = new ArrayList<>();//12月份字符串list
			List<String> guaraSumList= new ArrayList<>();//在保金额字符串list
			EChart echart=new EChart();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	        Date date = new Date();
	        String thisYear =  sdf.format(date);
	        String whereYearMonth = "";
	        Calendar calendar = Calendar.getInstance();
	        int countMonth = calendar.get(Calendar.MONTH)+1;
	        
			for (int i = 1; i <= countMonth; i++) {
				StringBuffer wheresql2 =new StringBuffer(" SELECT ");
				if(i<10){
					whereYearMonth = thisYear+"-0"+i;
				}else{
					 whereYearMonth = thisYear+"-"+i;
				}
				wheresql2.append(" SUM((IFNULL(pp.loadSum,0)-IFNULL(tab1.payCapitalSum,0)-IFNULL(tab2.replaceCapitalSum,0))) AS guarantySum ");
				wheresql2.append(" FROM pro_project pp ");
				wheresql2.append(" LEFT JOIN (  ");
				wheresql2.append(" SELECT pfp.project_ID,SUM(IFNULL(pfp.payCapitalSum,0)) AS payCapitalSum  ");
				wheresql2.append(" FROM pro_factpay pfp ");
				wheresql2.append(" WHERE 	1=1 AND DATE_FORMAT(pfp.payDate,'%Y-%m') <= \'"+whereYearMonth+"\'");
				wheresql2.append(" GROUP BY pfp.project_ID ");
				wheresql2.append(" )tab1 ON tab1.project_ID =  pp.project_ID ");
				wheresql2.append(" LEFT JOIN ( ");
				wheresql2.append(" SELECT pre.project_ID,SUM(IFNULL(pre.replaceCapitalSum,0)) AS replaceCapitalSum ");
				wheresql2.append(" FROM pro_replace pre ");
				wheresql2.append(" WHERE 	1=1 AND DATE_FORMAT(pre.replaceDate,'%Y-%m') <= \'"+whereYearMonth+"\'");
				wheresql2.append("  GROUP BY pre.project_ID  ");
				wheresql2.append(" )tab2 ON tab2.project_ID =  pp.project_ID ");
				wheresql2.append(" LEFT JOIN  pro_apply  pa ON pp.apply_ID=pa.apply_ID ");
				wheresql2.append(" where pp.busiClass = '01'  and (pp.finishDate is null or DATE_FORMAT(pp.finishDate,'%Y-%m' ) > \'"+whereYearMonth+"\') ");
				wheresql2.append("and DATE_FORMAT(pp.reportDate,'%Y-%m' ) <= \'"+whereYearMonth+"\' ");
			    List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql2.toString());
			    nameList.add(i+"月");
			    guaraSumList.add(null == projectList.get(0).getGuarantySum() ? "0" : projectList.get(0).getGuarantySum()+"");
			   
			}
			
			//设置y的最大值最小值
			Double min = Double.valueOf(guaraSumList.get(0));
			Double max = Double.valueOf(guaraSumList.get(0));
//			echart.setMax("5710000");
//			echart.setMin("5690000");
			for(int i = 1 ;i<guaraSumList.size();i++){
				Double gsm = Double.valueOf(guaraSumList.get(i));
				if(gsm>max){
					echart.setMax(String.valueOf(Math.ceil(gsm)));
					max = gsm;
				}
				if(gsm<min){
					echart.setMin(String.valueOf(Math.floor(gsm)));
					min = gsm;
				}
			}
			
			echart.setNameStr(nameList.toArray(new String[12]));
			echart.setGuaraSumStr(guaraSumList.toArray(new String[12]));
			return echart;
		}
		
		/**
		 * 按业务大类统计
		 */
		@Override
		public EChart busiClassStatistics() {
			//拼接查询当前年在保余额sql
			StringBuffer wheresql2 =new StringBuffer(" SELECT ");
			wheresql2.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum,0)) AS guarantySum ");
			wheresql2.append(" FROM c_dicType  dic ");
			wheresql2.append(" LEFT JOIN (SELECT cc1.riskLevelID,(SUM(IFNULL(pp.loadSum,0))-SUM(IFNULL(tab1.payCapitalSum,0))-SUM(IFNULL(tab2.replaceCapitalSum,0))) AS guarantySum,pa.clientGUID  ");
			wheresql2.append(" FROM pro_project pp ");
			wheresql2.append(" LEFT JOIN  pro_apply  pa ON pp.apply_ID=pa.apply_ID ");
			wheresql2.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID`=pa.`client_ID` ");
			wheresql2.append(" LEFT JOIN (SELECT pfp.project_ID,SUM(IFNULL(pfp.payCapitalSum,0)) AS payCapitalSum ");
			wheresql2.append(" FROM pro_factpay pfp  WHERE 	1=1 AND YEAR(pfp.payDate) <=  DATE_FORMAT(NOW(), '%Y') ");
			wheresql2.append(" GROUP BY pfp.project_ID  ");
			wheresql2.append(" )tab1 ON tab1.project_ID =  pp.project_ID ");
			wheresql2.append(" LEFT JOIN (SELECT pre.project_ID, SUM(IFNULL(pre.replaceCapitalSum,0)) AS replaceCapitalSum  ");
			wheresql2.append(" FROM pro_replace pre  ");
			wheresql2.append(" WHERE 	1=1 AND YEAR(pre.`replaceDate`)  <= DATE_FORMAT(NOW(), '%Y') ");
			wheresql2.append(" GROUP BY pre.project_ID ");
			wheresql2.append(" )tab2 ON tab2.project_ID =  pp.project_ID ");
			wheresql2.append("  WHERE pp.busiClass= '01' AND YEAR(pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y') ");
			wheresql2.append(" GROUP BY cc1.riskLevelID ");
			wheresql2.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
			wheresql2.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
			wheresql2.append(" GROUP BY dic.dicTypeName ");
			wheresql2.append(" ORDER BY  dic.order_id  ");
			
			//拼接查询当前年在保余额sql 2
//			StringBuffer wheresqlF2 =new StringBuffer(" SELECT ");
//			wheresqlF2.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum, 0)) AS guarantySum ");
//			wheresqlF2.append(" FROM c_dicType dic ");
//			wheresqlF2.append(" LEFT JOIN ( SELECT cc1.riskLevelID,pp.guarantySum AS guarantySum,pa.clientGUID ");
//			wheresqlF2.append(" FROM pro_project pp ");
//			wheresqlF2.append(" LEFT JOIN pro_apply pa ON pp.apply_ID = pa.apply_ID ");
//			wheresqlF2.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID` = pa.`client_ID` ");
//			wheresqlF2.append(" WHERE pp.busiClass = '01' AND AND YEAR (pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y') ");
//			wheresqlF2.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
//			wheresqlF2.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
//			wheresqlF2.append(" GROUP BY dic.dicTypeName ");
//			wheresqlF2.append(" ORDER BY  dic.order_id  ");
			
			
	        //拼接查询当上一年在保余额sql
			StringBuffer wheresql3 =new StringBuffer(" SELECT ");
			wheresql3.append(" dic.dicTypeName,SUM(IFNULL(tab3.guarantySum,0)) AS guarantySum ");
			wheresql3.append(" FROM c_dicType  dic ");
			wheresql3.append(" LEFT JOIN (SELECT cc1.riskLevelID,(SUM(IFNULL(pp.loadSum,0))-SUM(IFNULL(tab1.payCapitalSum,0))-SUM(IFNULL(tab2.replaceCapitalSum,0))) AS guarantySum,pa.clientGUID  ");
			wheresql3.append(" FROM pro_project pp ");
			wheresql3.append(" LEFT JOIN  pro_apply  pa ON pp.apply_ID=pa.apply_ID ");
			wheresql3.append(" LEFT JOIN crm_client cc1 ON cc1.`client_ID`=pa.`client_ID` ");
			wheresql3.append(" LEFT JOIN (SELECT pfp.project_ID,SUM(IFNULL(pfp.payCapitalSum,0)) AS payCapitalSum ");
			wheresql3.append(" FROM pro_factpay pfp  WHERE 	1=1 AND YEAR(pfp.payDate) <=  DATE_FORMAT(NOW(), '%Y')-1 ");
			wheresql3.append(" GROUP BY pfp.project_ID  ");
			wheresql3.append(" )tab1 ON tab1.project_ID =  pp.project_ID ");
			wheresql3.append(" LEFT JOIN (SELECT pre.project_ID, SUM(IFNULL(pre.replaceCapitalSum,0)) AS replaceCapitalSum  ");
			wheresql3.append(" FROM pro_replace pre  ");
			wheresql3.append(" WHERE 	1=1 AND YEAR(pre.`replaceDate`)  <= DATE_FORMAT(NOW(), '%Y')-1 ");
			wheresql3.append(" GROUP BY pre.project_ID ");
			wheresql3.append(" )tab2 ON tab2.project_ID =  pp.project_ID ");
			wheresql3.append("  WHERE pp.busiClass= '01' AND YEAR(pp.delayBeginDate) <= DATE_FORMAT(NOW(), '%Y')-1 ");
			wheresql3.append(" GROUP BY cc1.riskLevelID ");
			wheresql3.append(" ) tab3 ON tab3.riskLevelID = dic.`dicTypeID` ");
			wheresql3.append(" WHERE dic.`dicTypePID`='50f858be37284937af4e6a8d3c9bee4b' ");
			wheresql3.append(" GROUP BY dic.dicTypeName ");
			wheresql3.append(" ORDER BY  dic.order_id  ");
			return null;
		}
		
		
		@Override
		public EChart analysisOfEntrustGuarantySumDrop() {
			List<String> nameList = new ArrayList<>();//12月份字符串list
			List<String> guaraSumList= new ArrayList<>();//在保金额字符串list
			EChart echart=new EChart();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	        Date date = new Date();
	        String thisYear =  sdf.format(date);
	        String whereYearMonth = "";
	        Calendar calendar = Calendar.getInstance();
	        int countMonth = calendar.get(Calendar.MONTH)+1;
	        
			for (int i = 1; i <= countMonth; i++) {
				StringBuffer wheresql2 =new StringBuffer(" SELECT ");
				if(i<10){
					whereYearMonth = thisYear+"-0"+i;
				}else{
					 whereYearMonth = thisYear+"-"+i;
				}
				wheresql2.append(" SUM((IFNULL(pp.loadSum,0)-IFNULL(tab1.payCapitalSum,0))) AS guarantySum ");
				wheresql2.append(" FROM pro_project pp ");
				wheresql2.append(" LEFT JOIN (  ");
				wheresql2.append(" SELECT pfp.project_ID,SUM(IFNULL(pfp.payCapitalSum,0)) AS payCapitalSum  ");
				wheresql2.append(" FROM pro_factpay pfp ");
				wheresql2.append(" WHERE 	1=1 AND DATE_FORMAT(pfp.payDate,'%Y-%m') <= \'"+whereYearMonth+"\'");
				wheresql2.append(" GROUP BY pfp.project_ID ");
				wheresql2.append(" )tab1 ON tab1.project_ID =  pp.project_ID ");
				wheresql2.append(" LEFT JOIN  pro_apply  pa ON pp.apply_ID=pa.apply_ID ");
				wheresql2.append(" where pp.busiClass = '02'  and (pp.finishDate is null or DATE_FORMAT(pp.finishDate,'%Y-%m' ) > \'"+whereYearMonth+"\') ");
				wheresql2.append("and DATE_FORMAT(pp.reportDate,'%Y-%m' ) <= \'"+whereYearMonth+"\' ");
			    List<Pro_project> projectList = analysisMapper.selectDynamicProject(wheresql2.toString());
			    nameList.add(i+"月");
			    guaraSumList.add(null == projectList.get(0).getGuarantySum() ? "0" : projectList.get(0).getGuarantySum()+"");
			   
			}
			//设置y的最大值最小值
			Double min = Double.valueOf(guaraSumList.get(0));
			Double max = Double.valueOf(guaraSumList.get(0));
//			echart.setMax("550000");
//			echart.setMin("450000");
			for(int i = 1 ;i<guaraSumList.size();i++){
				Double gsm = Double.valueOf(guaraSumList.get(i));
				if(gsm>=max){
					echart.setMax(String.valueOf(Math.ceil(gsm+100000)));
					max = gsm;
				}
				if(gsm<min){
					echart.setMin(String.valueOf(Math.floor(gsm)));
					min = gsm;
				}
			}
			echart.setNameStr(nameList.toArray(new String[12]));
			echart.setGuaraSumStr(guaraSumList.toArray(new String[12]));
			return echart;
			
		}
		
	
	
	
}
