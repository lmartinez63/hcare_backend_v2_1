package com.landl.hcare.repository;

import com.landl.hcare.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long>{

}
