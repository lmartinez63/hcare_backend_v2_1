package com.landl.hcare.repository;

import com.landl.hcare.entity.AuxiliarExam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuxiliarExamRepository extends JpaRepository<AuxiliarExam, Long>{
}
