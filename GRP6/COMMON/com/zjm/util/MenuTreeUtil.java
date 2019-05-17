package com.zjm.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zjm.common.db.model.SysDicData;

public class MenuTreeUtil {
	/**
	 * 建立树菜单
	 * @param sys_modulesList 菜单集合（不是树）
	 * @return 有样式的树的html字符串
	 */
    public static String buildTreeHtml(List<SysDicData> sys_modulesList){  
    	StringBuffer html = new StringBuffer();
        for (int i=0;i<sys_modulesList.size();i++) { 
        	SysDicData node=sys_modulesList.get(i);
            if ("9cf65ae4911a4e7bac532be9e492af23".equals(node.getPid())||"361afd038b914df597e546e2625ff9c4".equals(node.getPid())||"ac0f1a8e29964a808e5a26509222171b".equals(node.getPid())||"88196758091d4b80949f917355845716".equals(node.getPid())) { 
            	boolean childrenHas=false;
            	List<SysDicData> children = getChildren(sys_modulesList,node);  
            	if(!children.isEmpty())childrenHas=true;
            	if(i==0){
            		html.append("\r\n<li id='menu"+node.getId()+"' class='active' >"); 
            	}else{
            		html.append("\r\n<li id='menu"+node.getId()+"' >"); 
            	}           	
            	html.append("\r\n<a ");
            	html.append("  style='cursor:pointer;'  onclick=\"openMenu('menu"+node.getId()+"','menu0','"+node.getName()+"','"+(StringUtils.isNotBlank(node.getUrl())?node.getUrl().trim():"noset")+"','','"+node.getIsReload()+"')\" ");       		    	
            	if(childrenHas)html.append(" target='mainFrame' class='dropdown-toggle' "); 
            	html.append(" >"); 
            	if(StringUtils.isNotEmpty(node.getIcon()))html.append("\r\n<i class= "+ node.getIcon()+" ></i>"); 
            	html.append("\r\n<span class='menu-text'>" + node.getName()+ "</span>"); 
            	if(childrenHas)html.append("<b class='arrow icon-angle-down'></b>");
            	html.append("</a>");
                build(sys_modulesList,node,html);  
                html.append("</li>");
            }  
        }  
        return html.toString();  
    }  
    private static void build(List<SysDicData> sys_modulesList,SysDicData node,StringBuffer html){  
        List<SysDicData> children = getChildren(sys_modulesList,node); 
        if (!children.isEmpty()) {  
            html.append("\r\n<ul class='submenu'>");
            for (SysDicData child : children) {  
            	boolean childrenHas=false;
            	List<SysDicData> children2 = getChildren(sys_modulesList,child);
            	if(!children2.isEmpty())childrenHas=true;
            	html.append("\r\n<li id='menu"+child.getId()+"' >"); 
            	html.append("\r\n<a ");
        		html.append("  style='cursor:pointer;' onclick=\"openMenu('menu"+child.getId()+"','menu"+child.getPid()+"','"+child.getName()+"','"+(StringUtils.isNotBlank(child.getUrl())?child.getUrl().trim():"noset")+"','','"+child.getIsReload()+"')\" ");
            	if(childrenHas)html.append(" target='mainFrame' class='dropdown-toggle' "); 
            	html.append(" >"); 
            	if (!"9cf65ae4911a4e7bac532be9e492af23".equals(node.getPid())||!"361afd038b914df597e546e2625ff9c4".equals(node.getPid())||!"ac0f1a8e29964a808e5a26509222171b".equals(node.getPid())||!"88196758091d4b80949f917355845716".equals(node.getPid()))html.append("\r\n<i class='icon-double-angle-right' ></i>"); 
            	html.append("\r\n<span class='menu-text'>");
            	if(StringUtils.isNotEmpty(child.getIcon())){
            		html.append("\r\n<i class= "+ child.getIcon()+" ></i>&nbsp;&nbsp;"+child.getName());
            	}else{
            		html.append(child.getName()); 
            	}
            	html.append("</span>"); 
            	if(childrenHas)html.append("<b class='arrow icon-angle-down'></b>");
            	html.append("</a>");
                build(sys_modulesList,child,html);  
                html.append("</li>");  
            } 
            html.append("\r\n</ul>");
        }   
    }  
    private static List<SysDicData> getChildren(List<SysDicData> sys_modulesList,SysDicData node){  
        List<SysDicData> children = new ArrayList<SysDicData>();  
        String id = node.getId();  
        for (SysDicData child : sys_modulesList) {
            if(id==child.getPid()||id.equals(child.getPid())){  
                children.add(child);               
            }  
        }  
        return children;  
    }

}
