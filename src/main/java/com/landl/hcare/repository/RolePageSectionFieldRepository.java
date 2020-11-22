package com.landl.hcare.repository;

import com.landl.hcare.entity.RolePageSectionField;
import com.landl.hcare.entity.RolePageSectionFieldId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePageSectionFieldRepository extends JpaRepository<RolePageSectionField, RolePageSectionFieldId>{

}
