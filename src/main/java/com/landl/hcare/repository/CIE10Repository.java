package com.landl.hcare.repository;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.CIE10;
import com.landl.hcare.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CIE10Repository extends JpaRepository<CIE10, Long>{
	
	@Query(value = "select new com.landl.hcare.entity.AutoCompleteField(cie10.code || ' - ' || cie10.description, cie10.id ) from CIE10 cie10")
    List<AutoCompleteField> findCodeAndDescriptionForAutoCompleteFields();
}
