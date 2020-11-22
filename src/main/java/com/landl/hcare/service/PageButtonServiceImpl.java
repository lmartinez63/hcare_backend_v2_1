package com.landl.hcare.service;

import com.landl.hcare.entity.*;
import com.landl.hcare.repository.PageButtonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageButtonServiceImpl implements PageButtonService {

    @Autowired
    PageButtonRepository pageButtonRepository;

    @Autowired
    UserService userService;

    public PageButton save(PageButton pageButton){
        return pageButtonRepository.save(pageButton);
    }

    public List<PageButton> findAll(){
        return pageButtonRepository.findAll();
    }

    public PageButton findById(Long pageButtonId){
        return pageButtonRepository.findById(pageButtonId).get();
    }

    public PageButton createPageButton(Long pageId, Long browseId){
        PageButton pageButton = new PageButton();
        pageButton.setPageId(pageId);
        pageButton.setBrowseId(browseId);
        return pageButton;
    }

}
