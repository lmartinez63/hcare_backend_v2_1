package com.landl.hcare.service;


import com.landl.hcare.entity.Menu;
import com.landl.hcare.entity.Page;

import java.util.List;

public interface MenuService {

    Menu save(Menu menu);

    List<Menu> findAll();

    Menu findById(Long menuId);

    List<Menu> findMenuListByUserCode(String userCode);
}
