package com.landl.hcare.component;

import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("retrieveAllRole")
public class RetrieveAllRoles extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        List<Role> roleList = roleService.findAll();

        addDataToResultMap("roleList",roleList);

    }



}
