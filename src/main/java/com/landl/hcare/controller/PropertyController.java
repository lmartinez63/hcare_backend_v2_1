package com.landl.hcare.controller;

import com.landl.hcare.entity.Property;
import com.landl.hcare.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/properties/{propertyCode}", method = RequestMethod.GET)
    public Property getProperty(@PathVariable(value = "propertyCode") String propertyCode){
        return propertyService.findByPropertyCode(propertyCode);
    }

}