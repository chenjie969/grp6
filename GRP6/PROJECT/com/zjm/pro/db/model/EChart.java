package com.zjm.pro.db.model;
import java.io.Serializable;
import java.util.List;

/**
 * 首页图表pojo
 * @author zhangkeyao
 */
public class EChart implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;//名称
	private String[] nameStr;//统计分类字符串集合
	private String guaraSum;//金额
	private String[] guaraSumStr;//金额字符串集合
	private String[] guaraSumStr2;//金额字符串集合
	private Integer projCount;//笔数
	private Integer[] projCountStr;//笔数字符串集合
	private Integer clientCount;//户数
	private Integer[] clientCountStr;//户数字符串集合
	private String value;//金额 饼图用
	private List<EChart> echartList;//
	
	private String[] loadSumStr;//新增金额/笔数字符串集合
	private String[] normalCapitalSumStr;//无代偿金额/笔数字符串集合
	private String[] replaceCapitalSumStr;//代偿金额/笔数字符串集合
	
	private String max;
	private String min;
	
	//====================get/set========================
	
	public String getName() {
		return name;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getNameStr() {
		return nameStr;
	}
	public void setNameStr(String[] nameStr) {
		this.nameStr = nameStr;
	}
	public String getGuaraSum() {
		return guaraSum;
	}
	public void setGuaraSum(String guaraSum) {
		this.guaraSum = guaraSum;
	}
	public String[] getGuaraSumStr() {
		return guaraSumStr;
	}
	public void setGuaraSumStr(String[] guaraSumStr) {
		this.guaraSumStr = guaraSumStr;
	}
	public Integer getProjCount() {
		return projCount;
	}
	public void setProjCount(Integer projCount) {
		this.projCount = projCount;
	}
	public Integer[] getProjCountStr() {
		return projCountStr;
	}
	public void setProjCountStr(Integer[] projCountStr) {
		this.projCountStr = projCountStr;
	}
	public Integer getClientCount() {
		return clientCount;
	}
	public void setClientCount(Integer clientCount) {
		this.clientCount = clientCount;
	}
	public Integer[] getClientCountStr() {
		return clientCountStr;
	}
	public void setClientCountStr(Integer[] clientCountStr) {
		this.clientCountStr = clientCountStr;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<EChart> getEchartList() {
		return echartList;
	}
	public void setEchartList(List<EChart> echartList) {
		this.echartList = echartList;
	}
	public String[] getLoadSumStr() {
		return loadSumStr;
	}
	public void setLoadSumStr(String[] loadSumStr) {
		this.loadSumStr = loadSumStr;
	}
	public String[] getNormalCapitalSumStr() {
		return normalCapitalSumStr;
	}
	public void setNormalCapitalSumStr(String[] normalCapitalSumStr) {
		this.normalCapitalSumStr = normalCapitalSumStr;
	}
	public String[] getReplaceCapitalSumStr() {
		return replaceCapitalSumStr;
	}
	public void setReplaceCapitalSumStr(String[] replaceCapitalSumStr) {
		this.replaceCapitalSumStr = replaceCapitalSumStr;
	}
	public String[] getGuaraSumStr2() {
		return guaraSumStr2;
	}
	public void setGuaraSumStr2(String[] guaraSumStr2) {
		this.guaraSumStr2 = guaraSumStr2;
	}
	
	
}

