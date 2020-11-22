package com.landl.hcare.repository;

import com.landl.hcare.entity.FieldDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<FieldDefinition, Long>{
    @Query(value = "select distinct fd.* from field_definition fd \n" +
            "inner join role_page_section_field rpsf on rpsf.field_definition_id = fd.id\n" +
            "inner join page p on p.id = rpsf.page_id\n" +
            "inner join section sec on sec.id = rpsf.section_id\n" +
            "inner join user_roles ur on ur.role_id = rpsf.role_id\n" +
            "inner join user_profile up on up.id = ur.user_id where p.page_code = :pageCode and sec.section_code = :sectionCode and up.username = :username", nativeQuery = true)
    List<FieldDefinition> getFieldsByPageCodeAndUsername(String pageCode, String sectionCode, String username);

    @Query(value = "select distinct fd.* from field_definition fd \n" +
            "inner join role_page_section_field rpsf on rpsf.field_definition_id = fd.id\n" +
            "inner join section sec on sec.id = rpsf.section_id where sec.section_code = :sectionCode", nativeQuery = true)
    List<FieldDefinition> getFieldsBySectionCode(String sectionCode);

}
