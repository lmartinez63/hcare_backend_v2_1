package com.landl.hcare.service;

import com.landl.hcare.entity.DataColumn;
import com.landl.hcare.repository.DataColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataColumnServiceImpl implements DataColumnService {

    @Autowired
    DataColumnRepository dataColumnRepository;

    @Autowired
    DataTableService dataTableService;

    public DataColumn save(DataColumn dataColumn){
        return dataColumnRepository.save(dataColumn);
    }

    public List<DataColumn> findAll(){
        return dataColumnRepository.findAll();
    }

    public DataColumn createDataColumnFromDataTable(Long dataTableId){
        DataColumn dataColumn = new DataColumn();
        dataColumn.setDataTableId(dataTableId);
        return dataColumn;
    }

    public DataColumn findById(Long dataColumnId){
        return dataColumnRepository.findById(dataColumnId).get();
    }

    public List<DataColumn> findByDataTableIdAndUsername(Long dataTableId, String username){
        return dataColumnRepository.findByDataTableIdAndUsername(dataTableId,username);
    }

}
