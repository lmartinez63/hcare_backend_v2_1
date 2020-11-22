package com.landl.hcare.repository;

import com.landl.hcare.entity.SurgeryArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryAreaRepository extends JpaRepository<SurgeryArea, Long>{
}
