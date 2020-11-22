package com.landl.hcare.service;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.DataTable;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.PageButton;
import com.landl.hcare.repository.DataTableRepository;
import com.landl.hcare.rule.RuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataTableServiceImpl implements DataTableService {

    @Autowired
    DataTableRepository dataTableRepository;

    @Autowired
    DataColumnService dataColumnService;

    public DataTable save(DataTable dataTable){
        return dataTableRepository.save(dataTable);
    }

    public List<DataTable> findAll(){
        return dataTableRepository.findAll();
    }

    public DataTable findById(Long dataTableId){
        return dataTableRepository.findById(dataTableId).get();
    }

    public DataTable findByDataTableCode(String dataTableCode){
        return dataTableRepository.findByDataTableCode(dataTableCode).get(0);
    }

    public DataTable createDataTable(){
        DataTable dataTable = new DataTable();
        return dataTable;
    }

    public DataTable findByDataTableCodeAndUsername(String dataTableCode, String username){
        DataTable dataTable = dataTableRepository.findByDataTableCode(dataTableCode).get(0);
        if ( dataTable != null){
            dataTable.setDataColumns(dataColumnService.findByDataTableIdAndUsername(dataTable.getId(),username));
        }
        return dataTable;
    }

    public void evaluateRules(DataTable dataTable, Map dataSource) throws Exception {
        //By default set Visible to true
        for (PageButton pageButton:dataTable.getPageButtons()) {
            pageButton.setVisible(true);
            if(!UtilityTools.isEmpty(pageButton.getVisibleRuleExp())){
                try{
                    pageButton.setVisible(RuleManager.evaluateExpression(pageButton.getVisibleRuleExp(),dataSource));
                } catch(Exception e){
                    //e.printStackTrace();
                    pageButton.setVisible(false);
                }
            }
        }
    }

}
