package com.landl.hcare.service;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.*;
import com.landl.hcare.repository.MenuRepository;
import com.landl.hcare.rule.RuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    public Menu save(Menu menu){
        return menuRepository.save(menu);
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    public Menu findById(Long menuId){
        return menuRepository.findById(menuId).get();
    }


    public List<Menu> findMenuListByUserCode(String userCode){
        return menuRepository.findMenuListByUserCode(userCode);
    }


}
