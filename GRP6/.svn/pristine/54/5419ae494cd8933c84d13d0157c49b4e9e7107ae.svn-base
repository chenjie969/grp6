package com.zjm.util;

import java.security.MessageDigest;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.CharUtils;

/**
 * 
 * @author mashuo  add 20170418
 *
 */
public class Tool {
	//创建标准uuid，格式为：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx (8-4-4-4-12) 
	public static String createUUID(){
		return java.util.UUID.randomUUID().toString();
	}
	//创建uuid 去除中杠
	public static String createUUID32(){
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}
	//创建uuid Long 返回此 UUID 的 128 位值中的最高有效 64 位
	public static Long createUUIDLong(){
		return java.util.UUID.randomUUID().getMostSignificantBits();
	}	

	// MD5加密
	public static  String MD5(String s) {
		if (s == null || s.equals("")) {
			return s;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}


	/**
	 * 将包含模型的list按照特定模型元素转化成Map形式，做字典表用
	 * <p>
	 * Title: parseNumDict
	 * </p>
	 * 
	 * @param list
	 * @param key
	 * @param value
	 * @return   Map<String, String>   key是Long时调用此方法
	 */
	public static  Map<String, String> parseSStrDict(List<?> list, String key, String value) {
		Map<String, String> map = new  TreeMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			try {				
				map.put(new String(BeanUtils.getProperty(list.get(i), key)),
						BeanUtils.getProperty(list.get(i), value));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return map;
	}
	/**
	 * 得到request对象
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();	
		return request;
	}
	/**
	 * 客户端真实IP地址的方法：
	 */
	public static String getIpAddr(HttpServletRequest request) {  
		String ip="";
		if(request!=null){
			ip = request.getHeader("x-forwarded-for");  
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
				ip = request.getHeader("Proxy-Client-IP");  
			}  
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
				ip = request.getHeader("WL-Proxy-Client-IP");  
			}  
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
				ip = request.getRemoteAddr();  
			}  
		}
		return ip;  
	}  
	/**
	 * 返回 消耗时间
	 * @param start_date
	 * @param finish_date
	 * @param limit_date
	 * @return
	 */
	public static String returnTotalDateMessage(Date start_date,Date finish_date){

		if(start_date!=null && !start_date.equals("")){
			//已完成的步骤
			if(finish_date!=null && !finish_date.equals("")){
				Calendar cal = Calendar.getInstance(); 
				cal.setTime(start_date);
				Date data= cal.getTime();

				Calendar finishcal = Calendar.getInstance(); 
				finishcal.setTime(finish_date);
				Date finishDate=finishcal.getTime();

				Long minute= (finishDate.getTime()-data.getTime())/(1000*60);
				return returnLimitDateMessageEndNoExceed(minute);
			}
			//未完成的步骤
			if(finish_date==null || finish_date.equals("")){
				Date sysTime = new Date();
				Calendar cal = Calendar.getInstance(); 
				cal.setTime(start_date);
				Date data= cal.getTime();

				Calendar finishcal = Calendar.getInstance(); 
				finishcal.setTime(sysTime);
				Date finishDate=finishcal.getTime();
				Long minute= (finishDate.getTime()-data.getTime())/(1000*60);
				return returnLimitDateMessageEndNoExceed(minute);
			}
		}
		return null;
	}



	/*

	//返回已完成的步骤提前完成的提示
	private static String returnLimitDateMessageEndNoExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return ""+day+"天"+day_hour+"小时";
			}else{
				return ""+hour+"小时"+hour_minute+"分钟";
			}

		}else{
			return ""+minute+"分钟";
		}
	}

	//返回已完成的步骤超出时间完成的提示
	private static String returnLimitDateMessageEndExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "<label style='color: #e25353;'>超时"+day+"天"+day_hour+"小时</label>";
			}else{
				return "<label style='color: #e25353;'>超时"+hour+"小时"+hour_minute+"分钟</label>";
			}

		}else{
			return "<label style='color: #e25353;'>超时"+minute+"分钟</label>";
		}
	}


	//返回未完成的步骤超出限办时间的提示
	private static String returnLimitDateMessageNoEndExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "<label style='color: #e25353;'>超时"+day+"天"+day_hour+"小时</label>";
			}else{
				return "<label style='color: #e25353;'>超时"+hour+"小时"+hour_minute+"分钟</label>";
			}

		}else{
			return "<label style='color: #e25353;'>超时"+minute+"分钟</label>";
		}
	}

	//返回未完成的步骤未超出限办时间的提示
	private static String returnLimitDateMessageNoEndNoExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "剩余时间："+day+"天"+day_hour+"小时";
			}else{
				return "剩余时间："+hour+"小时"+hour_minute+"分钟";
			}

		}else{
			return "剩余时间："+minute+"分钟";
		}
	}*/



















	/**
	 * 返回 超出限办的时间     限办时间的单位为天或小时
	 * @param start_date 开始时间
	 * @param finish_date 结束时间
	 * @param limitDate  限办时间
	 * @param limitDateUnit 限办时间单位
	 * @return
	 */
	public static String returnLimitDateMessage(Timestamp start_date,
			Timestamp finish_date, Integer limitDate, String limitDateUnit) {
		if(start_date!=null && !start_date.equals("")){
			if(limitDate!=null && !limitDate.equals("") && !limitDate.equals("null") && limitDateUnit!=null && !limitDateUnit.equals("") && !limitDateUnit.equals("null")){
				Calendar cal = Calendar.getInstance(); 
				cal.setTime(start_date);
				if(limitDateUnit.equals("小时")){
					cal.add(Calendar.HOUR_OF_DAY, limitDate);
				}
				if(limitDateUnit.equals("天")){
					cal.add(Calendar.DAY_OF_MONTH, limitDate);
				}
				Date data= cal.getTime();
				//已完成的步骤
				if(finish_date!=null && !finish_date.equals("")){
					Calendar finishcal = Calendar.getInstance(); 
					finishcal.setTime(finish_date);
					Date finishDate=finishcal.getTime();
					Long minute= (finishDate.getTime()-data.getTime())/(1000*60);
					if(minute<=0){
						cal.setTime(start_date);
						data= cal.getTime();
						minute= (finishDate.getTime()-data.getTime())/(1000*60);
						return returnLimitDateMessageEndNoExceed(minute);
					}else{
						return returnLimitDateMessageEndExceed(minute);
					}
				}
				//未完成的步骤
				if(finish_date==null || finish_date.equals("")){
					Date sysTime = new Date();
					Calendar finishcal = Calendar.getInstance(); 
					finishcal.setTime(sysTime);
					Date finishDate=finishcal.getTime();
					Long minute= (finishDate.getTime()-data.getTime())/(1000*60);
					if(minute<=0){
						minute= (data.getTime()-finishDate.getTime())/(1000*60);
						return returnLimitDateMessageNoEndNoExceed(minute);
					}else{
						return returnLimitDateMessageNoEndExceed(minute);

					}
				}

			}
		}
		return null;
	}
	//返回未完成的步骤超出限办时间的提示
	private static String returnLimitDateMessageNoEndExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "<br/>(<label style='color: #e25353;'>超时"+day+"天"+day_hour+"小时</label>)";
			}else{
				return "<br/>(<label style='color: #e25353;'>超时"+hour+"小时"+hour_minute+"分钟</label>)";
			}

		}else{
			return "<br/>(<label style='color: #e25353;'>超时"+minute+"分钟</label>)";
		}
	}

	//返回未完成的步骤未超出限办时间的提示
	private static String returnLimitDateMessageNoEndNoExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "<br/>(剩余时间："+day+"天"+day_hour+"小时)";
			}else{
				return "<br/>(剩余时间："+hour+"小时"+hour_minute+"分钟)";
			}

		}else{
			return "<br/>(剩余时间："+minute+"分钟)";
		}
	}

	//返回已完成的步骤提前完成的提示
	private static String returnLimitDateMessageEndNoExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "<br/>用时"+day+"天"+day_hour+"小时完成";
			}else{
				return "<br/>用时"+hour+"小时"+hour_minute+"分钟完成";
			}

		}else{
			return "<br/>用时"+minute+"分钟完成";
		}
	}

	//返回已完成的步骤超出时间完成的提示
	private static String returnLimitDateMessageEndExceed(Long minute) {
		if(minute>=60){
			Long hour=minute/60;
			Long hour_minute=minute%60;
			if(hour>=24){
				Long day=hour/24;
				Long day_hour=hour%24;
				return "<br/>(<label style='color: #e25353;'>超时"+day+"天"+day_hour+"小时</label>)";
			}else{
				return "<br/>(<label style='color: #e25353;'>超时"+hour+"小时"+hour_minute+"分钟</label>)";
			}

		}else{
			return "<br/>(<label style='color: #e25353;'>超时"+minute+"分钟</label>)";
		}
	}




	//识别是否乱码
	public static boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = 0 ;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!CharUtils.isAscii(c)) {
				if (!isChinese(c)) {
					count = count + 1;
				}
				chLength++; 
			}
		}
		float result = count / chLength ;
		if (result > 0.4) {
			return true;
		} else {
			return false;
		}
	}
	//判断是否是中文
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}
	/**
	 * 转换中文防止中文乱码()	
	 * @param msg
	 * @return
	 */
	public static String toChinese(String msg){
		String tempMsg = msg;
		if(tempMsg==null || tempMsg.equals("null")){
			return "";
		}
		if(isMessyCode(tempMsg)){
			try {
				return new String(tempMsg.getBytes("ISO8859-1"), "UTF-8");
			} catch (Exception e) {
				System.out.println("转换失败!!!");
			}
		}
		return tempMsg ; 
	}
	/**
	 * 去除字符串前后空格
	 * @param string
	 * @return
	 */
    public static String formatString(String string){
    	String trim = "";
    	if(null != string){
    		trim = string.trim();
    	}
    	return trim;
    }
    /**
     * 通过 期限.月+期限.天     获取 期限.月天
     * @param periodMonth
     * @param periodDay
     * @return
     */
    public static String getPeriodMonthDay(Integer periodMonth,Integer periodDay){
    	String periodMonthDay = "";
    	if(null != periodMonth && 0 != periodMonth){	
			periodMonthDay +=periodMonth+"个月";
			
		}
		if(null != periodDay && 0 != periodDay){		
			periodMonthDay +=periodDay+"天";					
		}
		return periodMonthDay;
    }
    
    
    
}
