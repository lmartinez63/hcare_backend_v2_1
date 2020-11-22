package com.landl.hcare.repository;

import com.landl.hcare.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
    @Query(value = "select m.* from menu m where :usercode = :usercode", nativeQuery = true)
    List<Menu> findMenuListByUserCode(String usercode);
}
