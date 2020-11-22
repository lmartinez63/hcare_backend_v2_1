package com.landl.hcare.service;
import com.landl.hcare.entity.SurgeryAnesthesia;
import com.landl.hcare.repository.SurgeryAnesthesiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SurgeryAnesthesiaServiceImpl implements SurgeryAnesthesiaService {

    @Autowired
    SurgeryAnesthesiaRepository surgeryAnesthesiaRepository;

    public SurgeryAnesthesia save(SurgeryAnesthesia surgeryAnesthesia) throws Exception{
        return surgeryAnesthesiaRepository.save(surgeryAnesthesia);
    }

    public List<SurgeryAnesthesia> findAll() throws Exception{
        return surgeryAnesthesiaRepository.findAll();
    }

    public SurgeryAnesthesia findById(Long surgeryAnesthesiaId) throws Exception{
        return surgeryAnesthesiaRepository.findById(surgeryAnesthesiaId).get();
    }

    public SurgeryAnesthesia createSurgeryAnesthesia(Long surgeryMedicalId) throws  Exception{
        SurgeryAnesthesia surgeryAnesthesia = new SurgeryAnesthesia();
        surgeryAnesthesia.setMedicalSurgeryId(surgeryMedicalId);
        return surgeryAnesthesia;
    }
}
