package com.landl.hcare.service;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.Attachment;
import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.JsonFileRep;
import com.landl.hcare.repository.DirectoryRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DirectoryServiceImpl implements DirectoryService{

    @Autowired
    DirectoryRepository directoryRepository;

    @Autowired
    AttachmentService attachmentService;

    @PersistenceContext
    private EntityManager em;

    public Directory findByEntityName(String entityName){
        return directoryRepository.findByEntityName(entityName);
    }

    public Directory findByEntityNameAndParentDirectoryIdIsNull(String entityName){
        return directoryRepository.findByEntityNameAndParentDirectoryIdIsNull(entityName);
    }

    public void retrieveAttachmentInformation(Directory directory, String sourceValue) throws Exception{
        String entityName = directory.getEntityName();
        String entityColumnName = directory.getEntityColumnName();
        String entityRelColumnName = directory.getEntityRelColumnName();

        String queryString = "SELECT distinct "+entityColumnName+" FROM "+entityName +" WHERE "+entityRelColumnName+" = '"+sourceValue+"'";
        Query q = em.createNativeQuery(queryString);

        for(Directory childDirectory:directory.getChildDirectories()){
            String subQueryString = "SELECT "+childDirectory.getParentColumnName()+" FROM "+directory.getEntityName() +" WHERE "+directory.getEntityRelColumnName()+" = "+sourceValue;
            q = em.createNativeQuery(subQueryString);
            Object subResult = (Object) q.getSingleResult();
            String subSource = null;
            if ( subResult != null){
                if(subResult instanceof BigInteger){
                    subSource = ((BigInteger) subResult).toString();
                } else if (subResult instanceof String){
                    subSource = (String) subResult;
                }
                retrieveAttachmentInformation(childDirectory, subSource);
            }
        }

        //Object entityColumnValue = readOnlyRepository.getData(entityColumnName,entityName, parentColumnName,sourceValue);
        //TODO add validations to prevent query injection


        List resultList = q.getResultList();

        for(Object resultObject:resultList){
            Long entityIdLong = null;
            if(resultObject instanceof BigInteger){
                entityIdLong = ((BigInteger) resultObject).longValue();
            }
            List<Attachment> attachmentList = attachmentService.findByEntityAndEntityId(UtilityTools.toCamelCase(entityName),entityIdLong);
            if(resultList.size() > 1){
                Directory newChildDirectory = new Directory();
                newChildDirectory.setEntityName(String.valueOf(entityIdLong));
                newChildDirectory.setAttachmentList(attachmentList);
                directory.addChildDirectories(newChildDirectory);
            } else{
                directory.setAttachmentList(attachmentList);
            }
        }

    }


    public List<Map> convertDirectoryToFrontEndFormat(Directory directory) throws Exception {
        List<Map> items =  new ArrayList<Map>();
        if(directory.getAttachmentList() != null && directory.getAttachmentList().size() > 0){
            items.addAll(convertAttachmentsToFrontEndFormat(directory.getAttachmentList()));
        }
        if(directory.getChildDirectories() != null && directory.getChildDirectories().size() > 0) {
            for(Directory childDirectory:directory.getChildDirectories()){
                Map childFile = new HashMap<>();
                //TODO Change set label
                childFile.put("name",childDirectory.getEntityName());
                List childList = convertDirectoryToFrontEndFormat(childDirectory);
                if(childList != null && childList.size() > 0){
                    childFile.put("children",convertDirectoryToFrontEndFormat(childDirectory));
                }
                items.add(childFile);
            }
        }
        return items;
    }

    public List<Map> convertAttachmentsToFrontEndFormat(List<Attachment> attachmentList) throws Exception{
        List<Map> items =  new ArrayList<Map>();
        for(Attachment attachment:attachmentList){
            Map file = new HashMap<>();
            //TODO Change set label
            String extension = FilenameUtils.getExtension(attachment.getInternalFileName());
            file.put("name",attachment.getFileTitle()+"."+extension);
            file.put("src",attachment.getContent());
            file.put("id",attachment.getId());
            file.put("fileType",extension);
            file.put("contentType",attachment.getContentType());
            items.add(file);
        }
        return items;
    }
}
