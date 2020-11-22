package com.landl.hcare.repository;

import com.landl.hcare.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
    List<Property> findByPropertyCode(String property);
    
    Property findByModuleAndPropertyCodeAndPropertyValue(String module,String propertyCode,String propertyValue);

    @Query(value = "select prop.module,prop.property_code,prop.property_value,lab.label_value from property prop\n" +
            "left join label lab on lab.label_code = prop.property_value and lab.module = prop.module and lab.sub_module = prop.property_code", nativeQuery = true)
    List<Object[]> findPropertyGroupByModule();
}
