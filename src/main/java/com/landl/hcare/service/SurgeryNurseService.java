package com.landl.hcare.service;

import com.landl.hcare.entity.SurgeryNurse;

import java.util.List;

public interface SurgeryNurseService {

    public SurgeryNurse save(SurgeryNurse surgeryNurse) throws Exception;

    public List<SurgeryNurse> findAll() throws Exception;

    public SurgeryNurse findById(Long surgeryNurseId) throws Exception;

    public SurgeryNurse createSurgeryNurse(Long medicalSurgeryId) throws  Exception;

}
