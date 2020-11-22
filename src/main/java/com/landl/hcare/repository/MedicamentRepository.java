package com.landl.hcare.repository;

import com.landl.hcare.entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long>{
    Medicament findByCode(String code);
  
}
