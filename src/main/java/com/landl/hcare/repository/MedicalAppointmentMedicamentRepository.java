package com.landl.hcare.repository;

import com.landl.hcare.entity.MedicalAppointmentMedicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentMedicamentRepository extends JpaRepository<MedicalAppointmentMedicament, Long>{
}
