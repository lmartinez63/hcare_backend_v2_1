package com.landl.hcare.repository;

import com.landl.hcare.entity.Allergy;
import com.landl.hcare.entity.AutoCompleteField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long>{
	
	@Query(value = "select new com.landl.hcare.entity.AutoCompleteField(allergy.code || ' - ' || allergy.description, allergy.id ) from Allergy allergy")
    List<AutoCompleteField> findCodeAndDescriptionForAutoCompleteFields();
}
