package com.landl.hcare.repository;

import com.landl.hcare.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long>{
    Directory findByEntityName(String entityName);

    @Query(value = "select d.* from directory d where d.entity_name = :entityName and d.parent_directory_id is not null",nativeQuery = true)
    Directory findByEntityNameAndParentDirectoryIdIsNotNull(String entityName);

    @Query(value = "select d.* from directory d where d.entity_name = :entityName and d.parent_directory_id is null",nativeQuery = true)
    Directory findByEntityNameAndParentDirectoryIdIsNull(String entityName);
}
