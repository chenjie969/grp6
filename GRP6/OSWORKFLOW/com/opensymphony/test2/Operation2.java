package com.opensymphony.test2;

public class Operation2 {

	public boolean conversion(String expression,Double a) {

		boolean r=false;
		if(null==a){
			
		}
		String rep2 = expression.replaceAll("a", a+"");
//		String rep2 = rep1.replaceAll("b", b+"");
		String[] str = rep2.split(" ");
		String s = "";
		StringBuffer sBuffer = new StringBuffer("");
		for (String strspl : str) {
			if(strspl.contains(">")||strspl.contains("<")||strspl.contains("=")){
				if(strspl.contains(">")){
					String[] s1 = strspl.split(">");
					Double d1 = Calculator.conversion(s1[0]);
					if(d1>Double.parseDouble(s1[s1.length-1]))
						sBuffer.append("true");
					else
						sBuffer.append("false");
				}
				if(strspl.contains("<")){
					String[] s2 = strspl.split("<");
					Double d2 = Calculator.conversion(s2[0]);
					if(d2<Double.parseDouble(s2[s2.length-1]))
						sBuffer.append("true");
					else
						sBuffer.append("false");
				}
				if(strspl.contains("=")){
					String[] s3 = strspl.split("=");
					Double d3 = Calculator.conversion(s3[0]);
					if(d3==Double.parseDouble(s3[s3.length-1]))
						sBuffer.append("true");
					else
						sBuffer.append("false");
				}
			}else{
				s = strspl;
			}
			
		}
		if(sBuffer.toString().contains("true")){
			r=true;
		}
		return r;
	}

//	private boolean result(String s, StringBuffer sBuffer) {
//		boolean b = false;
//		if(""!=s){
//			if(s.equals("||")&&sBuffer.toString().contains("true"))
//				b = true;
//			else if(s.equals("&&")&&sBuffer.toString().contains("false"))
//				b = false;
//			else if(s.equals("&&")&&!sBuffer.toString().contains("false"))
//				b = true;
//		}
//		return b;
//		
//	}

}
