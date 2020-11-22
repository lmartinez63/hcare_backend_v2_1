package com.landl.hcare.service;
import com.landl.hcare.entity.SurgeryType;
import com.landl.hcare.repository.SurgeryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryTypeServiceImpl implements SurgeryTypeService {

    @Autowired
    SurgeryTypeRepository surgeryTypeRepository;

    public SurgeryType save(SurgeryType surgeryType) throws Exception{
        return surgeryTypeRepository.save(surgeryType);
    }

    public List<SurgeryType> findAll() throws Exception{
        return surgeryTypeRepository.findAll();
    }

    public SurgeryType findById(Long surgeryTypeId) throws Exception{
        return surgeryTypeRepository.findById(surgeryTypeId).get();
    }

    public SurgeryType createSurgeryType() throws  Exception{
        SurgeryType surgeryArea = new SurgeryType();
        return surgeryArea;
    }
}
