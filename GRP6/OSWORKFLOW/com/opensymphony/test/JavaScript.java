package com.opensymphony.test;

import java.util.List;

import javax.script.ScriptEngine;  
import javax.script.ScriptEngineManager;  
import javax.script.ScriptException; 

public class JavaScript {
	ScriptEngineManager factory = new ScriptEngineManager();  
    ScriptEngine engine = factory.getEngineByName("JavaScript");  
      
    public boolean getMathValue(List<ParamToMap> map,String option){  
    	boolean b = false;  
        try {  
            for(int i=0; i<map.size();i++){  
                ParamToMap mapj = map.get(i);  
                option = option.replaceAll(mapj.getKey(), mapj.getValue());  
            }  
            b = (Boolean)engine.eval(option);  
            //d = Double.parseDouble(o.toString());  
        } catch (ScriptException e) {  
            System.out.println("无法识别表达式");  
        }  
        return b;  
    }  
}
