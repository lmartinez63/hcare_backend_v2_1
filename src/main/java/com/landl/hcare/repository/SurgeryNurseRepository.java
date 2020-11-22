package com.landl.hcare.repository;

import com.landl.hcare.entity.SurgeryNurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryNurseRepository extends JpaRepository<SurgeryNurse, Long>{
}
