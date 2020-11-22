package com.landl.hcare.entity;

import java.util.List;

public class DataTableResult {
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<Object> data;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
        if (data != null){
            this.setRecordsTotal(data.size());
            this.setRecordsFiltered(data.size());
        }
    }
}
