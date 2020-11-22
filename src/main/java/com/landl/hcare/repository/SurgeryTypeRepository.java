package com.landl.hcare.repository;

import com.landl.hcare.entity.SurgeryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryTypeRepository extends JpaRepository<SurgeryType, Long>{
}
