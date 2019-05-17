/** 
* @author 作者 E-mail: zhongzk@bjsurong.com
* @version 创建时间：Dec 8, 2011 10:33:59 PM 
* 类说明： 
*/ 
package com.opensymphony.workflow.spi.ibatis;

import java.util.*;

public class PropertyData {
        private String globalKey;
        private String itemKey;
        private int itemType;
        private String stringValue;
        private Date dateValue;
        private String dataValue;
        private Float floatValue;
        private java.math.BigDecimal numberValue;
        
        public String getDataValue() {
                return dataValue;
        }
        
        public void setDataValue(String dataValue) {
                this.dataValue = dataValue;
        }
        
        public Date getDateValue() {
                return dateValue;
        }
        
        public void setDateValue(Date dateValue) {
                this.dateValue = dateValue;
        }
        
        public Float getFloatValue() {
                return floatValue;
        }
        
        public void setFloatValue(Float floatValue) {
                this.floatValue = floatValue;
        }
        
        public String getGlobalKey() {
                return globalKey;
        }
        
        public void setGlobalKey(String globalKey) {
                this.globalKey = globalKey;
        }
        
        public String getItemKey() {
                return itemKey;
        }
        
        public void setItemKey(String itemKey) {
                this.itemKey = itemKey;
        }
        
        public int getItemType() {
                return itemType;
        }
        
        public void setItemType(int itemType) {
                this.itemType = itemType;
        }
        
        public java.math.BigDecimal getNumberValue() {
                return numberValue;
        }
        
        public void setNumberValue(java.math.BigDecimal numberValue) {
                this.numberValue = numberValue;
        }
        
        public String getStringValue() {
                return stringValue;
        }
        
        public void setStringValue(String stringValue) {
                this.stringValue = stringValue;
        }
}

