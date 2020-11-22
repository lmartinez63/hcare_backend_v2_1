package com.landl.hcare.repository;

import com.landl.hcare.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{
    List<Label> findByLabelCodeAndModuleAndSubModuleAndLanguage(String labelCode, String module, String subModule, String language);
}
