package com.landl.hcare.service;


import com.landl.hcare.entity.Role;
import com.landl.hcare.entity.Section;

import java.util.List;
import java.util.Map;

public interface RoleService {

    public Role save(Role role);

    public List<Role> findAll();

    public String[] getRolesArray();

    public Role findById(Long roleId);
}
