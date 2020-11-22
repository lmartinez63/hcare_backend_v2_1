package com.landl.hcare.repository;

import com.landl.hcare.entity.MedicalAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAnalysisRepository extends JpaRepository<MedicalAnalysis, Long>{
}
