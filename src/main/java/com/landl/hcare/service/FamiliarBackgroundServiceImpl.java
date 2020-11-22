package com.landl.hcare.service;

import com.landl.hcare.entity.FamiliarBackground;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.repository.FamiliarBackgroundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.concurrent.TimeUnit.SECONDS;


@Service
public class FamiliarBackgroundServiceImpl extends ObjectServiceImpl implements FamiliarBackgroundService{

    @Autowired
    FamiliarBackgroundRepository familiarBackgroundRepository;
    
    @Autowired
    LabelService labelService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FamiliarBackgroundServiceImpl.class);


    public FamiliarBackground save(FamiliarBackground familiarBackground){
        return familiarBackgroundRepository.save(familiarBackground);
    }

    public List<FamiliarBackground> findAll(){
        return familiarBackgroundRepository.findAll();
    }

    public FamiliarBackground findById(Long id){
        return familiarBackgroundRepository.findById(id).get();
    }
    public void getObjectLabeled(FamiliarBackground familiarBackground) throws  Exception{
        transformObjectLabels(familiarBackground);
    }

    public FamiliarBackground createFamiliarBackground(Long medicalAppointmentId){
    	FamiliarBackground familiarBackground = new FamiliarBackground();
    	familiarBackground.setMedicalAppointmentId(medicalAppointmentId);
        return familiarBackground;
    }
}
