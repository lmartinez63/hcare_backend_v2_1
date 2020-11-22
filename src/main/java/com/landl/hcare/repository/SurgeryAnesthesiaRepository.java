package com.landl.hcare.repository;

import com.landl.hcare.entity.SurgeryAnesthesia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryAnesthesiaRepository extends JpaRepository<SurgeryAnesthesia, Long>{
}
