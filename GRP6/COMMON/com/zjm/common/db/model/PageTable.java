package com.zjm.common.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zjm.crm.db.model.UploadParam;

public class PageTable<T> implements Serializable {
	private List<T> rows;;      //所有记录数据,List<T>表示List是虚拟的类，不能直接实例化，但是可以实例化他的子类，他的最常用实现类ArrayList
	private Long   total;    //所有记录数
	private Long   pageNumber;//记录的开始位置,即相当于记录的游标位置
	private Long   pageSize;    //每页显示行数
	private String wheresql;    //有时候需要传入sql where条件
	private String sortName;//排序字段名称
	private String sortOrder;//排序方式   asc 正序  desc 倒序 
	
	public PageTable() {
		this.total = 0L;      //所有记录数，初始为0
		this.pageNumber=1L;   //缺省定位在第一行
		this.pageSize=30L; 		//缺省显示30行，此处改造成调用系统参数的service，取得系统设定的显示限行。
		this.rows = new ArrayList<T>();//实例化List
		this.sortOrder="asc";
	}
	
	
	private String searchText;
	
	
	
	private QueryCondition queryCondition=new QueryCondition();//列表筛选条件
	private UploadParam uploadParam=new UploadParam();//附件列表参数
	private String wheresql2;
	private String wheresql3;
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getPageNumber() {
		return (pageNumber-1)*pageSize;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public String getWheresql() {
		if(wheresql==null){
			wheresql="";
		}
		return wheresql;
	}

	public void setWheresql(String wheresql) {
		this.wheresql = wheresql;
	}

	public String getSearchText() {
		
		return searchText;
	}

	public void setSearchText(String searchText) {
		//搜索框功能
	       //当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
	       /*if (null != searchText) {
	           try {
	        	   System.out.println(searchText);
	               searchText = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
	               System.out.println(searchText);
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	       }*/
		this.searchText = searchText;
	}

	public QueryCondition getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(QueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public UploadParam getUploadParam() {
		return uploadParam;
	}

	public void setUploadParam(UploadParam uploadParam) {
		this.uploadParam = uploadParam;
	}

	public String getWheresql3() {
		return wheresql3;
	}

	public void setWheresql3(String wheresql3) {
		this.wheresql3 = wheresql3;
	}

	public String getWheresql2() {
		return wheresql2;
	}

	public void setWheresql2(String wheresql2) {
		this.wheresql2 = wheresql2;
	}
	
	
	
}
