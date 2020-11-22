package com.landl.hcare.repository;

import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{
    @Query(value = "select sec.* from section sec \n" +
            "inner join role_page_section_field rpsf on rpsf.section_id = sec.id\n" +
            "inner join page p on p.id = rpsf.page_id\n" +
            "inner join user_roles ur on ur.role_id = rpsf.role_id\n" +
            "inner join user_profile up on up.id = ur.user_id where p.page_code = :pageCode and up.username = :username " +
            "group by sec.id, sec.section_code, sec.visible_rule_exp, sec.created_at, sec.updated_at, sec.label_id", nativeQuery = true)
    List<Section> getSectionsByPageCodeAndUsername(String pageCode, String username);

    @Query(value = "select distinct sec.* from section sec \n" +
            "inner join role_page_section_field rpsf on rpsf.section_id = sec.id\n" +
            "inner join page pag on pag.id = rpsf.page_id where pag.page_code = :pageCode", nativeQuery = true)
    List<Section> getSectionsByPageCode(String pageCode);

}
