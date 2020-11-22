package com.landl.hcare.repository;

import com.landl.hcare.entity.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataTableRepository extends JpaRepository<DataTable, Long>{
    List<DataTable> findByDataTableCode(String dataTableCode);
}
