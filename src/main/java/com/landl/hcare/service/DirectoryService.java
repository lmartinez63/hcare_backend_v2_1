package com.landl.hcare.service;

import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.JsonFileRep;

import java.util.List;
import java.util.Map;


public interface DirectoryService {

    public Directory findByEntityName(String entityName);
    public Directory findByEntityNameAndParentDirectoryIdIsNull(String entityName);

    public void retrieveAttachmentInformation(Directory directory, String sourceValue) throws Exception;

    public List<Map> convertDirectoryToFrontEndFormat(Directory directory) throws Exception;

}
