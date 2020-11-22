package com.landl.hcare.repository;

import com.landl.hcare.entity.PageButton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageButtonRepository extends JpaRepository<PageButton, Long>{
    List<PageButton> findBySectionId(Long sectionId);
}
