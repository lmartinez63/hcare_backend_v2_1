package com.landl.hcare.repository;

import com.landl.hcare.entity.DataColumn;
import com.landl.hcare.entity.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataColumnRepository extends JpaRepository<DataColumn, Long>{
    @Query(value = "select distinct dc.* from data_column dc\n" +
            "inner join role_data_table_column rdtc on rdtc.dt_id = dc.data_table_id and rdtc.dc_id = dc.id\n" +
            "inner join role r on r.id = rdtc.role_id\n" +
            "inner join user_roles ur on r.id = ur.role_id\n" +
            "inner join user_profile up on ur.user_id = up.id\n" +
            "where dc.data_table_id = :dataTableId and up.username = :username order by dc.order_number asc", nativeQuery = true)
    List<DataColumn> findByDataTableIdAndUsername(Long dataTableId, String username);
}
