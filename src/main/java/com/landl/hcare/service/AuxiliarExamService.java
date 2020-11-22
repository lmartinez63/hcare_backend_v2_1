package com.landl.hcare.service;

import com.landl.hcare.entity.AuxiliarExam;

import java.util.List;

public interface AuxiliarExamService {

    public AuxiliarExam save(AuxiliarExam AuxiliarExam);

    public List<AuxiliarExam> findAll();

    public AuxiliarExam findById(Long id);

}
