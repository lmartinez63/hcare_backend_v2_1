package com.landl.hcare.service;


import com.landl.hcare.entity.DataTable;
import com.landl.hcare.entity.Page;

import java.util.List;
import java.util.Map;

public interface DataTableService {

    public DataTable save(DataTable dataTable);

    public List<DataTable> findAll();

    public DataTable findById(Long dataTableId);

    public DataTable createDataTable();

    public DataTable findByDataTableCode(String dataTableCode);

    public DataTable findByDataTableCodeAndUsername(String dataTableCode, String username);

    public void evaluateRules(DataTable dataTable, Map dataSource) throws Exception;


}
