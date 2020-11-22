package com.landl.hcare.service;

import com.landl.hcare.entity.Role;
import com.landl.hcare.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public String[] getRolesArray(){
        List<Role> roleList = findAll();
        String[] s_roleArray = new String[roleList.size()];
        return roleList.stream().map(role -> role.getName()).collect(Collectors.toList()).toArray(s_roleArray);
    }

    public Role findById(Long roleId){
        return roleRepository.findById(roleId).get();
    }

}
