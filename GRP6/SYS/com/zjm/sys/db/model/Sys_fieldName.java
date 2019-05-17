package com.zjm.sys.db.model;

import java.io.Serializable;

/**
 */
public class Sys_fieldName implements Serializable{
	private static final long serialVersionUID = 1L;
	private String fieldID;
	private String listID;
	private String field;
	private String fieldName;
	
	
	public String getFieldID() {
		return fieldID;
	}
	public void setFieldID(String fieldID) {
		this.fieldID = fieldID;
	}
	public String getListID() {
		return listID;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
