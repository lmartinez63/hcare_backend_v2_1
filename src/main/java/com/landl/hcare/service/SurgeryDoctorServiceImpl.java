package com.landl.hcare.service;
import com.landl.hcare.entity.SurgeryDoctor;
import com.landl.hcare.repository.SurgeryDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryDoctorServiceImpl implements SurgeryDoctorService {

    @Autowired
    SurgeryDoctorRepository surgeryDoctorRepository;

    public SurgeryDoctor save(SurgeryDoctor surgeryDoctor) throws Exception{
        return surgeryDoctorRepository.save(surgeryDoctor);
    }

    public List<SurgeryDoctor> findAll() throws Exception{
        return surgeryDoctorRepository.findAll();
    }

    public SurgeryDoctor findById(Long surgeryDoctorId) throws Exception{
        return surgeryDoctorRepository.findById(surgeryDoctorId).get();
    }

    public SurgeryDoctor createSurgeryDoctor(Long medicalSurgeryId) throws  Exception{
        SurgeryDoctor surgeryDoctor = new SurgeryDoctor();
        surgeryDoctor.setMedicalSurgeryId(medicalSurgeryId);
        return surgeryDoctor;
    }
}
