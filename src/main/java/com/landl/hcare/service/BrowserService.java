package com.landl.hcare.service;


import com.landl.hcare.entity.DataTableResult;

import java.util.List;
import java.util.Map;

public interface BrowserService {

    public DataTableResult buildDataTableObject(String browseType, Map<String,Object> browseParameters) throws Exception;

}
