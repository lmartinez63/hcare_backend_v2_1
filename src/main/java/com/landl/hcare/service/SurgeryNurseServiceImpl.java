package com.landl.hcare.service;
import com.landl.hcare.entity.SurgeryNurse;
import com.landl.hcare.repository.SurgeryNurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryNurseServiceImpl implements SurgeryNurseService {

    @Autowired
    SurgeryNurseRepository surgeryNurseRepository;

    public SurgeryNurse save(SurgeryNurse surgeryNurse) throws Exception{
        return surgeryNurseRepository.save(surgeryNurse);
    }

    public List<SurgeryNurse> findAll() throws Exception{
        return surgeryNurseRepository.findAll();
    }

    public SurgeryNurse findById(Long surgeryNurseId) throws Exception{
        return surgeryNurseRepository.findById(surgeryNurseId).get();
    }

    public SurgeryNurse createSurgeryNurse(Long medicalSurgeryId) throws  Exception{
        SurgeryNurse surgeryNurse = new SurgeryNurse();
        surgeryNurse.setMedicalSurgeryId(medicalSurgeryId);
        return surgeryNurse;
    }
}
