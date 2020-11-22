package com.landl.hcare.service;


import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.PageButton;

import java.util.List;
import java.util.Map;

public interface PageButtonService {

    public PageButton save(PageButton pageButton);

    public List<PageButton> findAll();

    public PageButton findById(Long pageButtonId);

    public PageButton createPageButton(Long pageId, Long browseId);
}
