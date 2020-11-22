package com.landl.hcare.service;

import com.landl.hcare.entity.SurgeryType;

import java.util.List;

public interface SurgeryTypeService {

    public SurgeryType save(SurgeryType surgeryArea) throws Exception;

    public List<SurgeryType> findAll() throws Exception;

    public SurgeryType findById(Long surgeryAreaId) throws Exception;

    public SurgeryType createSurgeryType() throws  Exception;

}
