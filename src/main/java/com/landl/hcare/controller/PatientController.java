package com.landl.hcare.controller;

import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.exception.ResourceNotFoundException;
import com.landl.hcare.service.MedicalHistoryService;
import com.landl.hcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    /*
    @GetMapping("/patients")
    public List<Patient> retrieveAllPatients() {
        return patientService.findAll();
    }
    */

    @GetMapping("/retrievePatientByDocumentNumber/{documentNumber}")
    public Patient retrievePatientByDocumentNumber(@PathVariable String documentNumber) throws Exception {
        return patientService.findByDocumentNumber(documentNumber);
    }

}
