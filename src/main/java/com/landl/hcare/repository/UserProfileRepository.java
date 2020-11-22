package com.landl.hcare.repository;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    UserProfile findByUsername(String username);

    @Query(value = "select up.* from user_profile up join user_roles ur on up.id = ur.user_id join role r on r.id = ur.role_id where r.name = :roleName", nativeQuery = true)
    List<UserProfile> findByRoleName(String roleName);

    @Query(value = "select up.first_name || ' ' || up.last_name, up.id from user_profile up join user_roles ur on up.id = ur.user_id join role r on r.id = ur.role_id where r.name = :roleName", nativeQuery = true)
    List<Object[]> findByRoleForAutoCompleteFields(String roleName);


    @Query(value = "select p.page_code, sec.section_code from user_profile up \n" +
            "inner join user_roles ur on ur.user_id = up.id \n" +
            "inner join role_page_section_field rpsf on rpsf.role_id = ur.role_id\n" +
            "inner join page p on p.id = rpsf.page_id\n" +
            "left join section sec on sec.id = rpsf.section_id where up.username = :username", nativeQuery = true)
    List<Object[]> getPageAndSectionsAssigned(String username);

}