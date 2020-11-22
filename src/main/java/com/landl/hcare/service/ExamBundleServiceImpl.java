package com.landl.hcare.service;

import com.landl.hcare.entity.AuxiliarExam;
import com.landl.hcare.entity.ExamBundle;
import com.landl.hcare.repository.ExamBundleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamBundleServiceImpl implements ExamBundleService{

    @Autowired
    ExamBundleRepository examBundleRepository;

    @Autowired
    AttachmentService attachmentService;

    @PersistenceContext
    private EntityManager em;

    public List<ExamBundle> findAll(){
        return examBundleRepository.findAll();
    }

    public List<Map> convertDirectoryToFrontEndFormat(List<ExamBundle> examBundleList) throws Exception{
        List<Map> items =  new ArrayList<Map>();
        for(ExamBundle examBundle:examBundleList) {
        	Map childFile = new HashMap<>();
        	childFile.put("code",examBundle.getCode());
        	childFile.put("description",examBundle.getDescription());
        	List childItems =  new ArrayList();
            if(examBundle.getChildExamBundles() != null && examBundle.getChildExamBundles().size() > 0){
            	childItems.addAll(convertDirectoryToFrontEndFormat(examBundle.getChildExamBundles()));
            }
            if(examBundle.getAuxiliarExamList() != null && examBundle.getAuxiliarExamList().size() > 0){
            	childItems.addAll(examBundle.getAuxiliarExamList());
            }
        	childFile.put("children",childItems);
            items.add(childFile);
        }
        return items;
    }
}
