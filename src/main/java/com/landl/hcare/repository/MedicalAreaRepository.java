package com.landl.hcare.repository;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.MedicalArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalAreaRepository extends JpaRepository<MedicalArea, Long>{
    @Query(value = "select new com.landl.hcare.entity.AutoCompleteField(ma.areaName, ma.id ) from MedicalArea ma")
    List<AutoCompleteField> findIdAndAreaNameForAutoCompleteFields();
}
