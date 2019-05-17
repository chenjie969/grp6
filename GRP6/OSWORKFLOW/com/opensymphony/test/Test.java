package com.opensymphony.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.workflow.Workflow;

import sql.BaseProcessor;
import sql.BeanListProcessor;
import sql.BeanProcessor;
import sql.ColumnListProcessor;
import sql.MapListProcessor;
import sql.ResultSetProcessor;
import sql.sqlson;
import sql.user;
import sql.zbuser;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = 200;
//		double b = 1;
//		
		String formula = "a - 100 > 0";
		System.out.println(Calculator.conversion(formula));
//		String s = "fn";
//		String s2 = "f";
//		String s3 = "cf";
//		System.out.println(s.contains(s2));
		
//		String s2 = s.substring(0,s.length());
//		if(s2.equals("cf")){
//			System.out.println(s.substring(2,s.length()));
//		}else{
//			System.out.println(s.substring(1,s.length()));
//		}
//		System.out.println();
//		// 获取方法名
//		String setMethodName = (s.charAt(0) - 32) + s.substring(1);
//		System.out.println(setMethodName);
//		try {
//			//Class c =  Class.forName("sql.province");
//		
//			BeanProcessor s = new BeanProcessor(user.class);
//			//MapListProcessor s = new MapListProcessor();
//			Object a = s.executeQuery("select * from user where id = 1",s, null);
//			System.out.println(a);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
//		String jsonStr = "{\"data\": [{\"id\": 1,\"userName\": 1,\"provinceId\": 1}, {\"id\": 2,\"userName\": 2,\"provinceId\": 2}, {\"id\": 3,\"userName\": 3,\"provinceId\": 3}]}";
//		String userStr = JSON.parseObject(jsonStr).getString("data");
//		List<user> studentList1 = JSON.parseArray(userStr,user.class);
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		
//		try {
//			System.out.println(df.parse("2019-04-28 15:49:23"));
//		} catch (ParseException e) {	
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//JSONArray jsonArray = JSONArray.fromObject(json);
		//JSONObject param = json.getJSONObject("data");
		//JSONArray array = JSONArray.1
//		for (int i = 0; i < array.size(); i++ ){
//			
//        }

//		catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		List<ParamToMap> all = new ArrayList<ParamToMap>();
//		all.add(new ParamToMap("a", a+""));
//		all.add(new ParamToMap("b", b+""));
//		JavaScript js = new JavaScript();
//		
//		System.out.println(js.getMathValue(all, formula));
	}	
	
	// 测试运行流程，创建流程实例
	// ApplicationContext cxt = new ClassPathXmlApplicationContext(
	// "classpath:/spring/applicationContext.xml");
	// Workflow wf = (Workflow) cxt.getBean("workflow");
	// long id=0;
	// try {
	// //id = wf.initialize("bankload", 100, null);//返回流程实例的id
	//
	//
	// //测试执行一个动作
	// Map map=new HashMap();
	//// wf.doAction(id, 10101601, map);
	// Map<String,Long> rolemap=new HashMap();
	// //wf.doAction(id, 10101601, map,rolemap);
	//
	// System.out.println("success!!!");
	//
	// } catch (Exception e) {
	// System.out.println("error:" + e);
	// }//end catch
	
}
