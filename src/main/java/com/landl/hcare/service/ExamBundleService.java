package com.landl.hcare.service;

import com.landl.hcare.entity.ExamBundle;

import java.util.List;
import java.util.Map;


public interface ExamBundleService {

    public List<ExamBundle> findAll();
    public List<Map> convertDirectoryToFrontEndFormat(List<ExamBundle> examBundleList) throws Exception;

}
