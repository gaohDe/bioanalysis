package com.ys.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.ys.util.Row;

public abstract class BaseEntity implements Serializable {
   private static final long serialVersionUID = 5510966496699243858L;
   private String queryString;
   private Row row = new Row();
 
   private Map<String, Object> map = new HashMap<String, Object>();
 
   public Map<String, Object> getMap()
   {
     return this.map;
   }
 
   public Row getRow() {
     return this.row;
   }
 
   public void setMap(Map<String, Object> map) {
     this.map = map;
   }
 
   public void setRow(Row row) {
     this.row = row;
   }
 
   public String getQueryString() {
     return this.queryString;
   }
 
   public void setQueryString(String queryString) {
     this.queryString = queryString;
   }
}
