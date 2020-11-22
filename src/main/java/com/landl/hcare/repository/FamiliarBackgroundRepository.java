package com.landl.hcare.repository;

import com.landl.hcare.entity.Allergy;
import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.FamiliarBackground;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FamiliarBackgroundRepository extends JpaRepository<FamiliarBackground, Long>{
	
}
