	package com.zjm.crm.financeAnayze.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.joda.time.Years;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_reportSy;
import com.zjm.crm.db.model.Crm_reportXjl;
import com.zjm.crm.db.model.Crm_reportZcfz;
import com.zjm.crm.reportSy.service.ReportSyService;
import com.zjm.crm.reportXjl.service.ReportXjlService;
import com.zjm.crm.reportZcfz.service.ReportZcfzService;
import com.zjm.util.CustomDispatchServlet;

/**
 * @description   主要财务指标分析
 * @company http://www.igit.com.cn/  
 * @author wuhn	
 * @date 2017年8月17日 下午4:05:10
*/
@Controller
@RequestMapping(value="/financeAnayzeAcion")
public class FinanceAnayzeAcion {
	
	@Resource
	private ClientService  clientService; //客户表service
	
	@Resource
	private ReportZcfzService reportZcfzService; //资产负债service
	
	@Resource
	private  ReportXjlService reportXjlService;// 现金流 service
	
	@Resource
	private ReportSyService  reportSyService;//损益表 service
	
	
	/**
	 * @description	 财务指标分析页面
	 * @author wuhn
	 * @date 2017年8月18日 上午10:32:00
	 */
	@RequestMapping(value="/financeCompute")
	public ModelAndView  financeCompute(FinanceAnayzeVo financeAnayzeVo){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		computeFinanceNorm(modeAndView,financeAnayzeVo);//计算财务指标
		modeAndView.setViewName("/crm/client/companyFinance/finance/financeAnalyze");
		return modeAndView;
	}

	
	/**
	 * @description	  计算财务指标
	 * @author wuhn
	 * @date 2017年8月18日 上午10:31:52
	 */
	private void computeFinanceNorm(ModelAndView modeAndView, FinanceAnayzeVo financeAnayzeVo) {
		//获取客户信息
		getClientInfo(financeAnayzeVo,modeAndView);
		//根据月份获取 资产负债表
		List<Crm_reportZcfz> zcfzList = getCrm_reportZcfzInfo(financeAnayzeVo);
		//获取损益表
		List<Crm_reportSy> syList = getCrm_reportSyInfo(zcfzList,financeAnayzeVo);
		//获取现金流量表
		List<Crm_reportXjl> xjlList = getCrm_reportXjlInfo(zcfzList,financeAnayzeVo);
		
		//计算偿债能力
		repayMoney(modeAndView,financeAnayzeVo,zcfzList,syList,xjlList);
		
	}
	
	/**
	 * @description	计算偿债能力，  总资产周转次数，  流动资产周转次数，  净利润率，  净资产收益率	，  盈余现金保障倍数
	 * @author wuhn
	 * @date 2017年8月18日 下午5:15:59
	 */
	private void repayMoney(ModelAndView modeAndView,FinanceAnayzeVo financeAnayzeVo, List<Crm_reportZcfz> zcfzList, List<Crm_reportSy> syList,
			List<Crm_reportXjl> xjlList) {
		
		List<FinanceAnayzeVo> fList=new ArrayList<>();
		for(int x=0;x< zcfzList.size() ; x++){
			Crm_reportZcfz zcfzInfo = zcfzList.get(x);
			Crm_reportSy syInfo = syList.get(x);
			Crm_reportXjl xjlInfo = xjlList.get(x);
			java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
			String yearMonth = zcfzInfo.getYearMonth();
			financeAnayzeVo.setYearMonth(yearMonth);
			String reportTypeName = zcfzInfo.getReportTypeName();
			financeAnayzeVo.setReportTypeName(reportTypeName);
			//1、  资产负债率=  负债总额 / 资产总额 × 100%	
			Double assetsSum = zcfzInfo.getAssetsSum(); 
			Double liabilitiesSum = zcfzInfo.getLiabilitiesSum();
	//		String args1= (assetsSum==null ||assetsSum.equals(0D)||liabilitiesSum == null)?"--":df.format((liabilitiesSum/assetsSum)*100)+"%";
			//计算比例
			String args1 = commonCompute(assetsSum,liabilitiesSum,"percent");
			financeAnayzeVo.setArgs1(args1);
		//	modeAndView.getModel().put("f"+x, financeAnayzeVo);
			
			//2、流动比率 = 流动资产合计 / 流动负债合计 × 100%	
			Double currentAssetsSum = zcfzInfo.getCurrentAssetsSum();
			Double currentLiabilitiesSum = zcfzInfo.getCurrentLiabilitiesSum();
		//	String args2=(currentLiabilitiesSum == null || currentLiabilitiesSum.equals(0D) || currentAssetsSum == null)?"--":df.format((currentAssetsSum/currentLiabilitiesSum)*100)+"%";
			String args2 = commonCompute(currentLiabilitiesSum, currentAssetsSum,"percent");
			financeAnayzeVo.setArgs2(args2);
			
			//3、速动比率 = 速动资产 / 流动负债 × 100%	
			//速动比率=（流动资产-存货-预付帐款）/流动负债
			Double stock = zcfzInfo.getStock()==null?0D:zcfzInfo.getStock();//存货
		//	Double prepaidAccount=zcfzInfo.getPrepaidAccount()==null?0D:zcfzInfo.getPrepaidAccount();//预付帐款
			Double dusong= currentAssetsSum-stock;
			String args3 = commonCompute(currentLiabilitiesSum, dusong, "percent");
			financeAnayzeVo.setArgs3(args3);
			
			//4、已获利息倍数 = 息税前利润总额 / 利息支出	
			//(净利润+利息费用+所得税费用)/利息费用
			Double profitSum =syInfo==null || syInfo.getProfitSum()==null?0D:syInfo.getProfitSum();//损益表 利润总额
			Double sds=	syInfo==null || syInfo.getIncomeTax()==null?0D:syInfo.getIncomeTax();//损益表  所得税
			Double 	xjl		 =xjlInfo==null||xjlInfo.getProfitCashPayment()==null?0D:xjlInfo.getProfitCashPayment();//现金流     分配股利、利润或偿付利息所支付的现金	
			String args4 = commonCompute(sds, profitSum+xjl, "sb");
			financeAnayzeVo.setArgs4(args4);
			
			//5、总资产周转率 = 营业收入额 / 平均资产总额	
			// 总资产周转率=销售收入/总资产
			Double mainIncome=	syInfo==null || syInfo.getMainIncome()==null?0D:syInfo.getMainIncome(); // 损益表 主营业务收入
			Double pingjun=	assetsSum; // 总资产
			String args5 = commonCompute(pingjun, mainIncome, "sb");
			financeAnayzeVo.setArgs5(args5);
			
			//6、流动资产周转率 = 营业收入 / 流动资产平均余额	
			String args6 = commonCompute(currentAssetsSum, mainIncome, "sb");
			financeAnayzeVo.setArgs6(args6);
			
			//7、应收账款周转次数 = （ 营业收入 / N × 12 ） / [ （ 期初应收账款余额 + 期末应收账款余额 ） / 2 ]	
			Double accountsReceivable= zcfzInfo.getAccountsReceivable()==null?0D:zcfzInfo.getAccountsReceivable();//应收账款
			String str = yearMonth.substring(yearMonth.lastIndexOf("年")+1, yearMonth.lastIndexOf("月"));
			/*Double o1=mainIncome/Double.valueOf(str)*12;
			Double o2=(accountsReceivable+accountsReceivable)/2;*/
			String args7 = commonCompute(accountsReceivable, mainIncome, "sb");
			financeAnayzeVo.setArgs7(args7);
				
			//8、存货周转次数 = （ 当期营业收入 / N × 12 ） / 当期存货	
		//	o1=	mainIncome/Double.valueOf(str)*12;
			String args8 =commonCompute(stock, mainIncome, "sb");
			financeAnayzeVo.setArgs8(args8);
			
			//9、净利润率 = 净利润 / 主营业务收入 × 100%	
			Double netProfit =syInfo==null || syInfo.getNetProfit()==null?0D:syInfo.getNetProfit(); //净利润
			String args9 = commonCompute(mainIncome, netProfit, "percent");
			financeAnayzeVo.setArgs9(args9);
			
			//10、净资产收益率 = 净利润 / 净资产 × 100%	
			Double owerRigtSum2 = zcfzInfo.getOwerRigtSum();
			Double OwerRigtSum = owerRigtSum2==null?0D:owerRigtSum2;// 所有者权益合计	 净利润
			String args10 = commonCompute(OwerRigtSum, netProfit, "percent");
			financeAnayzeVo.setArgs10(args10);
			
			//11、盈余现金保障倍数 ＝ 经营现金净流量 / 净利润	
			Double activitiesNetCashFlow =xjlInfo==null|| xjlInfo.getActivitiesNetCashFlow()==null?0D:xjlInfo.getActivitiesNetCashFlow();//    经营活动产生的现金流量净额	
			String args11 = commonCompute(netProfit, activitiesNetCashFlow, "sb");
			financeAnayzeVo.setArgs11(args11);
			
			//12、毛利率=（主营业务收入-主营业务成本）/主营业务收入×100%	
	//		Double mainCost=syInfo==null || syInfo.getMainCost()==null?0D:syInfo.getMainCost(); //主营业务成本 
			Double mainOperatingProfit=syInfo==null || syInfo.getMainOperatingProfit()==null?0D:syInfo.getMainOperatingProfit(); //主营业务利润
			String args12 = commonCompute(mainIncome, mainOperatingProfit, "percent");
			financeAnayzeVo.setArgs12(args12);
			
			//13、总资产报酬率=（利润总额 + 利息支出） / 平均资产总额 x 100%	
			Double lrze=	syInfo==null || syInfo.getProfitSum()==null?0D:syInfo.getProfitSum(); //损益表利润总额
			Double incomeTax=syInfo == null || syInfo.getIncomeTax()==null?0D:syInfo.getIncomeTax();// 减 : 所得税	
			String args13 = commonCompute( assetsSum , xjl +lrze, "percent");
			financeAnayzeVo.setArgs13(args13);
			
			//14、主营业务收入增长率 = （ 本期主营业务收入 / N × 12 - 上年主营业务收入 ） / 上年主营业务收入 × 100%	
			//主营业务收入增长率=（本期主营业务收入-上期主营业务收入）/上期主营业务收入*100%
		
			String  wheresql=" and client_ID='"+zcfzInfo.getClient_ID()+"'";
			String  yearMonths=	zcfzInfo.getYearMonth(); //报表年月
			String  reportTypeUuid = zcfzInfo.getReportTypeUuid();//报表类型id
			String  reprotTypeName =zcfzInfo.getReportTypeName();// 报表类型名称
			String time = yearMonths.substring(yearMonths.indexOf("年")+1,yearMonths.lastIndexOf("月"));
			if(reprotTypeName.contains("月报")){
				String yue=yearMonths.substring(yearMonths.indexOf("年")+1);
				int i=	Integer.valueOf(time)-1;
				String result=i+"";
				if(String.valueOf(i).length()<2){
					result="0"+i;
				}
				yearMonths= yearMonths.replace(yue, result+"月");
				wheresql+=" and yearMonth='"+yearMonths+"'  and reportTypeUuid='"+reportTypeUuid+"'";
			}else{
				String nian=yearMonths.substring(0,yearMonths.indexOf("年"));
				int j=	Integer.valueOf(nian)-1;
				String strs=	yearMonths.substring(yearMonths.indexOf("年")+1);
				wheresql+=" and  yearMonth='"+(j+"年"+strs)+"'  and reportTypeUuid='"+reportTypeUuid+"'";
			}
			
			Crm_reportSy prevSyInfo = reportSyService.selectOneReportSyWhereSql(wheresql);
			Double prevMainIncome=prevSyInfo==null|| prevSyInfo.getMainIncome()==null?0D:prevSyInfo.getMainIncome();//上一期主营业务收入
			String args14 = commonCompute(prevMainIncome, mainIncome-prevMainIncome, "percent");
			financeAnayzeVo.setArgs14(args14);
			
			//15、主营业务利润增长率 = （ 本期营业利润 / N × 12 - 上年营业利润 ） / 上年营业利润 × 100%	
			Double prevMainOperatingProfit= prevSyInfo==null || prevSyInfo.getMainOperatingProfit()==null?0D:prevSyInfo.getMainOperatingProfit();//营业利润
			String args15 = commonCompute(prevMainOperatingProfit, mainOperatingProfit-prevMainOperatingProfit, "percent");
			financeAnayzeVo.setArgs15(args15);
			
			//16、净资产增长率=（期末净资产 - 期初净资产）/ 期初净资产） × 100%	
			Crm_reportZcfz prevZcfzInfo = reportZcfzService.selectOneReportZcfzWhereSql(wheresql);
			Double prevOwerRigtSum =prevZcfzInfo==null || prevZcfzInfo.getOwerRigtSum() ==null?0D: prevZcfzInfo.getOwerRigtSum();
			String args16 = commonCompute(prevOwerRigtSum, OwerRigtSum-prevOwerRigtSum, "percent");
			financeAnayzeVo.setArgs16(args16);
			
			//17、总资产增长率=（年末资产总额 - 年初资产总额）/年初资产总额×100%	
			Double prevAssetsSum = prevZcfzInfo == null || prevZcfzInfo.getAssetsSum() == null? 0D:prevZcfzInfo.getAssetsSum();
			String args17 = commonCompute(prevAssetsSum, assetsSum-prevAssetsSum, "percent");
			financeAnayzeVo.setArgs17(args17);
			
			
			fList.add(financeAnayzeVo);
			financeAnayzeVo =new FinanceAnayzeVo();
		}
		
		for (int x=0; x<fList.size(); x++) {
			modeAndView.getModel().put("f"+x, fList.get(x));
		}
		
	}

	
	/**
	 * 计算公用方法
	 */
	private String commonCompute(Double o1, Double o2,String flag) {
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#,###.##");  
		String arg="";
		if("percent".equals(flag)){
			arg= (o1==null ||o1.equals(0D)||(o2 == null || o2.equals(0D)))?"--":df.format((o2/o1)*100)+"%";
		}else{
			arg= (o1==null ||o1.equals(0D)||(o2 == null || o2.equals(0D)))?"--":df.format((o2/o1));
		}
		return arg;
	}


	/**
	 * @description	 获取现金流量表的信息
	 * @author wuhn
	 * @date 2017年8月18日 下午4:03:52
	 */
	private List<Crm_reportXjl> getCrm_reportXjlInfo(List<Crm_reportZcfz> zcfzList,FinanceAnayzeVo financeAnayzeVo) {
		List<Crm_reportXjl> list =new ArrayList<>();
		for (Crm_reportZcfz zcfz : zcfzList) {
			String  wheresql=" and client_ID='"+financeAnayzeVo.getClient_ID()+"'";
			wheresql+=" and yearMonth= '"+zcfz.getYearMonth()+"'  and reportTypeUuid='"+zcfz.getReportTypeUuid()+"'";
			Crm_reportXjl info = reportXjlService.selectOneReportXjlWhereSql(wheresql);
			list.add(info);
		}
		return list;
	}


	/**
	 * @description	获取损益表信息
	 * @author wuhn
	 * @date 2017年8月18日 下午3:57:23
	 */
	private List<Crm_reportSy> getCrm_reportSyInfo(List<Crm_reportZcfz> zcfzList,FinanceAnayzeVo financeAnayzeVo) {
		List<Crm_reportSy>  list=new ArrayList<>();
		for (Crm_reportZcfz zcfz : zcfzList) {
			String  wheresql=" and client_ID='"+financeAnayzeVo.getClient_ID()+"'";
			wheresql+=" and yearMonth= '"+zcfz.getYearMonth()+"'  and  reportTypeUuid='"+zcfz.getReportTypeUuid()+"'";
			Crm_reportSy info = reportSyService.selectOneReportSyWhereSql(wheresql);
			list.add(info);
		}
		return list;
	}


	/**
	 * @description	获取资产负债表信息
	 * @author wuhn
	 * @date 2017年8月18日 下午3:52:01
	 */
	private List<Crm_reportZcfz> getCrm_reportZcfzInfo(FinanceAnayzeVo financeAnayzeVo) {
		String str = financeAnayzeVo.getReportZcfz_ID();
		str = "'"+StringUtils.join(str.split(","), "','")+"'";
		StringBuffer sb= new StringBuffer();
		sb.append(" and  reportZcfz_ID in ("+str+")");
	//	sb.append(" and yearMonth ='"+financeAnayzeVo.getYearMonth()+"'");
		sb.append(" and  client_ID = '"+financeAnayzeVo.getClient_ID()+"'" );
		sb.append(" order by yearMonth desc");
		List<Crm_reportZcfz> zcfzList = reportZcfzService.selectReportZcfzByList(sb.toString());
		return zcfzList;
	}


	/**
	 * @description	获取客户信息
	 * @author wuhn
	 * @date 2017年8月18日 下午3:45:13
	 */
	private void getClientInfo(FinanceAnayzeVo financeAnayzeVo,ModelAndView modeAndView) {
		Client client=new Client();
		client.setClient_ID(financeAnayzeVo.getClient_ID());
		client= clientService.selectOneClientInfo(client);
		modeAndView.getModel().put("client", client);
	}
}
