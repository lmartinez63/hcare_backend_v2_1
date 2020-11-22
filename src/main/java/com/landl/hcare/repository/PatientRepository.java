package com.landl.hcare.repository;

import com.landl.hcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    List<Patient> findByBirthday(Date birthday);
    List<Patient> findByDocumentNumber(String documentNumber);
    List<Patient> findByHistoryCode(Long historyCode);
}
