package com.landl.hcare.service;


import com.landl.hcare.entity.DataColumn;
import com.landl.hcare.entity.DataTable;

import java.util.List;

public interface DataColumnService {

    public DataColumn save(DataColumn dataColumn);

    public List<DataColumn> findAll();

    public DataColumn findById(Long dataColumnId);

    public DataColumn createDataColumnFromDataTable(Long dataTableId);

    public List<DataColumn> findByDataTableIdAndUsername(Long dataTableId, String username);


}
