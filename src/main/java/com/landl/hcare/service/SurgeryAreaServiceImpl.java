package com.landl.hcare.service;
import com.landl.hcare.entity.SurgeryArea;
import com.landl.hcare.entity.type.GeneralStatus;
import com.landl.hcare.repository.SurgeryAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SurgeryAreaServiceImpl implements SurgeryAreaService {

    @Autowired
    SurgeryAreaRepository surgeryAreaRepository;
    
    @Autowired
    EventService eventService;

    public SurgeryArea save(SurgeryArea surgeryArea) throws Exception{
        return surgeryAreaRepository.save(surgeryArea);
    }

    public List<SurgeryArea> findAll() throws Exception{
        return surgeryAreaRepository.findAll();
    }

    public List<SurgeryArea> findAvailableSurgeryArea(Long surgeryTypeId, Date requiredDate) throws Exception{
        List<SurgeryArea> surgeryAreaList =  new ArrayList<SurgeryArea>();
        surgeryAreaList = surgeryAreaRepository.findAll();
        return surgeryAreaList;
    }

    public SurgeryArea findById(Long surgeryAreaId) throws Exception{
        SurgeryArea surgeryArea = surgeryAreaRepository.findById(surgeryAreaId).get();
        surgeryArea.setEventList(eventService.findBySurgeryAreaId(surgeryArea.getId()));
        return surgeryArea;
    }

    public SurgeryArea createSurgeryArea() throws  Exception{
        SurgeryArea surgeryArea = new SurgeryArea();
        surgeryArea.setActivationStatus(false);
        return surgeryArea;
    }
}
