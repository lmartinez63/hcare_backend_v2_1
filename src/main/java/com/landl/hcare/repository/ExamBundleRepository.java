package com.landl.hcare.repository;

import com.landl.hcare.entity.ExamBundle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamBundleRepository extends JpaRepository<ExamBundle, Long>{
}
