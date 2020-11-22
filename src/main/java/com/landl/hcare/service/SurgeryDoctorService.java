package com.landl.hcare.service;

import com.landl.hcare.entity.SurgeryDoctor;

import java.util.List;

public interface SurgeryDoctorService {

    public SurgeryDoctor save(SurgeryDoctor surgeryDoctor) throws Exception;

    public List<SurgeryDoctor> findAll() throws Exception;

    public SurgeryDoctor findById(Long surgeryDoctorId) throws Exception;

    public SurgeryDoctor createSurgeryDoctor(Long medicalSurgeryId) throws  Exception;

}
