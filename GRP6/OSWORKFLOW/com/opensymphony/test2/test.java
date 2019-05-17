package com.opensymphony.test2;

import com.alibaba.fastjson.JSONObject;

import jatools.formatter.DecimalFormat;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operation operation = new Operation();
		double a = -1;
		double b = 60;
		String formula = "a>0";
		System.out.println(operation.conversion(formula, a,null));
		
//		JSONObject json = new JSONObject();
//		JSONObject jsondata = new JSONObject();
//		jsondata.put("keyId", "123");
//		jsondata.put("userId", "cmiei39944ind");
//		jsondata.put("approveResult","PASS");
//		json.put("data", jsondata);
		//System.out.println(json.toJSONString());
		
		
//		DecimalFormat df2 =new DecimalFormat("#.00");  
//		String str = df2.format("200.32255");
//		System.out.println(str);
//		Operation2 operation2 = new Operation2();
//		double a2 = 70;
//		String formula2 = "a-30>0 ";
//		System.out.println(operation2.conversion(formula2, a2));
	}

}
