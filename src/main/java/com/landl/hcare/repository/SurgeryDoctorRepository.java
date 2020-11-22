package com.landl.hcare.repository;

import com.landl.hcare.entity.SurgeryDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryDoctorRepository extends JpaRepository<SurgeryDoctor, Long>{
}
