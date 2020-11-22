package com.landl.hcare.controller;

import com.landl.hcare.entity.Page;
import com.landl.hcare.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value="/pages", method = RequestMethod.GET)
    public List<Page> listPages(){
        return pageService.findAll();
    }

    @RequestMapping(value = "/pages/{pageCode}", method = RequestMethod.GET)
    public Page getOne(@PathVariable(value = "pageCode") String pageCode){
        Page page = pageService.findByPageCode(pageCode);
        //pageService.evaluateRules(page);
        return page;
    }

}