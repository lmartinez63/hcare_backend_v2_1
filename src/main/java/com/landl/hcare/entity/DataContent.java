package com.landl.hcare.entity;

import java.util.HashMap;
import java.util.Map;

public class DataContent {
    Map<String, Object> dataMap;
    Map<String, Object> parentDataMap;

    public DataContent() {
        this.dataMap = new HashMap<String, Object>();
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }
    public void addData(String stringData, Object entityData) {
        this.dataMap.put(stringData, entityData);
    }

    public Map<String, Object> getParentDataMap() {
        return parentDataMap;
    }

    public void setParentDataMap(Map<String, Object> parentDataMap) {
        this.parentDataMap = parentDataMap;
    }
}
