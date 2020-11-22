package com.landl.hcare.repository;

import com.landl.hcare.entity.MedicalSurgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalSurgeryRepository extends JpaRepository<MedicalSurgery, Long>{
}
