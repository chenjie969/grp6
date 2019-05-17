package com.zjm.pro.tracking.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_finishNode;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.db.model.Gbpm_runNode;
import com.zjm.gbpm.finishNode.service.FinishNodeService;
import com.zjm.gbpm.finishTask.service.FinishTaskService;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.gbpm.productNode.service.ProductNodeService;
import com.zjm.gbpm.runNode.service.RunNodeService;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.pro.tracking.service.ProductTrackingService;

@Service("productTrackingService")
@Transactional
public class ProductTrackingServiceImpl implements ProductTrackingService {
	
	@Resource
	private ProductNodeService productNodeService;
	@Resource
	private NodeTaskService nodeTaskService;
	
	@Resource
	private RunNodeService runNodeService;
	@Resource
	private RunTaskService runTaskService;
	
	@Resource
	private FinishNodeService finishNodeService;
	
	@Resource
	private FinishTaskService finishTaskService;
	
	
	/**
     * 根据产品id 获取产品节点；
     * @param productID
     * @return
     */
	public List<Gbpm_productNode> selectProductNodeListByID(User user,String productID) {
//		Gbpm_product product = new Gbpm_product();
//		product.setProduct_ID(productID);
//		product.setUnit_uid(user.getUnit_uid());
		String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
		wheresql = wheresql + " and productID = \'" + productID +"\' ORDER BY nodeSort ASC";
		List<Gbpm_productNode> productNodeList = productNodeService.selectProductNodeListByProductID(wheresql);
		return productNodeList;
	}
	/**
	 * 获取正在运行节点信息；
	 * @param 产品实例id
	 */
	public Gbpm_runNode selectRunningNodeByProductInstanceID(User user, String productInstanceID) {
		Gbpm_runNode oneRunNode = runNodeService.selectOneRunNodeByWhereSql(" and (isDelete IS NULL OR isDelete != 1) and productInstanceID = \'"+productInstanceID+"\'");
		return oneRunNode;
	}
	
	/**
	 * 获取正在执行的节点的任务列表
	 */
	public PageTable selectRunningNodeTaskTable(PageTable pageTable) {
		 // 根据实例id和节点顺序获取正在运行节点信息
		String whereSql =pageTable.getWheresql();
		Gbpm_runNode oneRunNode = runNodeService.selectOneRunNodeByWhereSql(whereSql);
		//根据运行节点id查找运行中任务事项；taskTypeID
		pageTable.setWheresql(" and runNodeID = \'"+oneRunNode.getRunNode_ID()+"\'");
		pageTable.setWheresql(pageTable.getWheresql());
		
//		pageTable.setWheresql(pageTable.getWheresql()+"	and  runTask.taskTypeID = \'"+"c0c17294d6ea464c874f2ae7c7bc9150"+"\'");
		PageTable runningNodeTaskTable =  runTaskService.selectRunningNodeTaskTable(pageTable);
		return runningNodeTaskTable;
	}

	/**
	 * 获取已经完成的节点的任务列表
	 */
	public PageTable selectFinishNodeTaskTable(PageTable pageTable) {
		 // 根据实例id和节点顺序获取已经完成的节点信息
		String whereSql =pageTable.getWheresql();
		Gbpm_finishNode finishNode = finishNodeService.selectOneFinishNodeByWhereSql(whereSql);
		//根据已经完成节点id查找任务事项;
		pageTable.setWheresql("	and runNodeID = \'"+finishNode.getFinishNode_ID()+"\'");
		/*pageTable.setWheresql(pageTable.getWheresql()+"	and finishTask.taskTypeID = \'"+"c0c17294d6ea464c874f2ae7c7bc9150"+"\'");*/
		
		pageTable.setWheresql(pageTable.getWheresql());
		
		
		PageTable finishNodeTaskTable =  finishTaskService.selectFinishNodeTaskTable(pageTable);
		return finishNodeTaskTable;
	}
	/**
	 * 获取未执行的节点的任务列表
	 */
	public PageTable selectNotRunNodeTaskTable(PageTable pageTable) {
		 // 根据实例id和节点顺序获取未执行的节点信息
		String whereSql =pageTable.getWheresql();
		 Gbpm_productNode oneProduct = productNodeService.selectOneProductNodeInfo(whereSql);
		//根据节点id查找任务事项;
		pageTable.setWheresql("	and productNodeID = \'"+oneProduct.getProductNode_ID()+"\'");
		pageTable.setWheresql(pageTable.getWheresql());
		
		/*pageTable.setWheresql(pageTable.getWheresql()+"	and taskmanager.taskTypeID = \'"+"c0c17294d6ea464c874f2ae7c7bc9150"+"\'");*/
		
		PageTable nodeTaskTable =  nodeTaskService.selectNodeTaskPageTable(pageTable);
		return nodeTaskTable;
	}
	
	/**
	 * 获取未执行节点限办天数
	 */
	public Gbpm_productNode selectNotActiveNodeLimitDay(String wheresql) {
		Gbpm_productNode oneProductNode = productNodeService.selectOneProductNodeInfo(wheresql);
		return oneProductNode;
	}
	/**
	 * 获取正在执行节点限办天数
	 */
	public Gbpm_runNode selectRunNodeLimitDay(String whereSql) {
		Gbpm_runNode oneRunNode = runNodeService.selectOneRunNodeByWhereSql(whereSql);
		if(null != oneRunNode && oneRunNode.getLimitDay()!=null){
			try {
				Integer limitDay =  Integer.valueOf(oneRunNode.getLimitDay());//获取限办天数,
				//获取分配时间与现在时刻相差天数;
				long differentDays = differentDaysByMillisecond2(oneRunNode.getAssignDateTime(),new Date());
				long differentDay  = (limitDay-differentDays);//获取剩余天数;
				if(differentDay>= 0){//未超过限办天数
					Integer differentDs=(Integer.parseInt(String.valueOf(differentDay)));
					oneRunNode.setOverDay("剩余"+differentDs.toString()+"天");
				}else{//已超过限办天数
					oneRunNode.setOverDay("超时"+Math.abs(differentDay)+"天");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return oneRunNode;
	}
	
	/**
	 * 获取已完成节点限办天数
	 */
	public Gbpm_finishNode selectFinishNodeLimitDay(String whereSql) {
		
		Gbpm_finishNode finishNode =finishNodeService.selectOneFinishNodeByWhereSql(whereSql);
		if(null != finishNode && null != finishNode.getLimitDay()){
			try {
				Integer limitDay =  Integer.valueOf(finishNode.getLimitDay());//获取限办天数,
				//获取分配时间与现在时刻相差天数;
				long differentDays = differentDaysByMillisecond2(finishNode.getAssignDateTime(),finishNode.getUpdateDateTime());
				long differentDay  = (limitDay-differentDays);//获取剩余天数;
				
				//long differentDays2 = differentDaysByMillisecond2("2017-9-4","2017-9-9");
				if(differentDay>= 0){//未超过限办天数
					finishNode.setOverDay("按时完成");
				}else{//已超过限办天数
					finishNode.setOverDay("超时"+Math.abs(differentDay)+"天");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return finishNode;
	}
	
	/**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
	 * @throws ParseException 
     */
	 public static int differentDaysByMillisecond(Date date1,Date date2) throws ParseException{
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String date1String = simpleDateFormat.format(date1);
			String date2String = simpleDateFormat2.format(date2);
			Date DateFormat1 = simpleDateFormat.parse(date1String);
			Date DateFormat2 = simpleDateFormat.parse(date2String);
	        int days = (int) ((DateFormat1.getTime() - DateFormat2.getTime()) / (1000*3600*24));
	        return days;
	 }
	 /**
	  * 通过时间秒毫秒数判断两个时间的间隔(除去周末)
	  * @param startDate
	  * @param endDate
	  * @return
	  * @throws ParseException 
	  */
	 public long differentDaysByMillisecond2(Date date1,Date date2) throws ParseException{SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String startDate = simpleDateFormat.format(date1);
			String endDate = simpleDateFormat2.format(date2);
	        GregorianCalendar endGC=new GregorianCalendar();
			 long times,days1=0l;
			 try {
				 times = sd.parse(endDate).getTime() - sd.parse(startDate).getTime();
				 long days=times/(1000*24*60*60);
				 days1= (days/7)*5;
				 long days2=days%7;
				 endGC.setTime(sd.parse(endDate));
				 int weekDay=endGC.get(Calendar.DAY_OF_WEEK);
				 if(weekDay==1){
					 days1+=days2>2?days2-2:0;
				 }else if(weekDay==7){
					 days1+=days2>1?days2-1:0;
				 }else if(weekDay-1<days2){
					 days1+=days2-2;
				 }else if(weekDay-1>days2){
					 days1+=days2;
				 }else if(weekDay-1==days2){
					 days1+=weekDay-1;
				 }
			 } catch (ParseException e) {
				 e.printStackTrace();
			 }
			 return days1;
	 }
	
	
	
}
