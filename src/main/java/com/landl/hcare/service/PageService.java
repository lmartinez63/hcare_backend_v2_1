package com.landl.hcare.service;


import com.landl.hcare.entity.Page;

import java.util.List;
import java.util.Map;

public interface PageService {

    public Page save(Page page);

    public List<Page> findAll();

    public Page findById(Long pageId);

    public Page findByPageCode(String pageCode);

    public Page createPage();

    public Page findByPageCodeAndUsername(String pageCode,String username) throws Exception;

    public Page findPageSectionAndFieldsByPageCodeAndUserName(String pageCode, String username) throws Exception;

    public void verifyIfCurrentUserIsAuthorizated(Page page, Map dataSource);

    public void evaluateRules(Page page, Map dataSource) throws Exception;

    public void processFields(Page page, Map dataSource) throws Exception;
}
