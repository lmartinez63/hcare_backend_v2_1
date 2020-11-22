package com.landl.hcare.repository;

import com.landl.hcare.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
    List<Email> findByStatus(Integer status);
}
