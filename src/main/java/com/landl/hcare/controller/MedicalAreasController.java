package com.landl.hcare.controller;

import com.landl.hcare.entity.MedicalArea;
import com.landl.hcare.service.AttachmentService;
import com.landl.hcare.service.MedicalAreaService;
import com.landl.hcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MedicalAreasController {

    @Autowired
    private MedicalAreaService medicalAreaService;

    @GetMapping("/medicalAreas")
    public List<MedicalArea> retrieveAllMedicalAreas() {
        return medicalAreaService.findAll();
    }

    @GetMapping("/medicalAreas/{medicalAreaId}")
    public MedicalArea retrieveByMedicalHistoryId(@PathVariable Long medicalAreaId) {
        MedicalArea medicalArea = medicalAreaService.findById(medicalAreaId).get();
        return medicalArea;
    }

    @PostMapping("/medicalAreas")
    public MedicalArea saveMedicalArea(@Valid @RequestBody MedicalArea medicalArea) {
        return medicalAreaService.save(medicalArea);
    }

}
