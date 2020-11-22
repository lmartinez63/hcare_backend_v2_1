package com.landl.hcare.service;

import com.landl.hcare.entity.AuxiliarExam;
import com.landl.hcare.repository.AuxiliarExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class AuxiliarExamServiceImpl implements AuxiliarExamService{

    @Autowired
    AuxiliarExamRepository AuxiliarExamRepository;
    
    @Autowired
    LabelService labelService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuxiliarExamServiceImpl.class);


    public AuxiliarExam save(AuxiliarExam AuxiliarExam){
        return AuxiliarExamRepository.save(AuxiliarExam);
    }

    public List<AuxiliarExam> findAll(){
        return AuxiliarExamRepository.findAll();
    }

    public AuxiliarExam findById(Long id){
        return AuxiliarExamRepository.findById(id).get();
    }
}
