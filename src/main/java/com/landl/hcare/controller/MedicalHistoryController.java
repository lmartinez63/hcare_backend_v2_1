package com.landl.hcare.controller;

import com.landl.hcare.entity.Attachment;
import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.exception.ResourceNotFoundException;
import com.landl.hcare.service.MedicalHistoryService;
import com.landl.hcare.service.PatientService;
import com.landl.hcare.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/medicalHistories")
    public List<MedicalHistory> retrieveAllMedicalHistories() throws Exception{
        return medicalHistoryService.findAll();
    }

    @GetMapping("/medicalHistories/{historyCode}")
    public MedicalHistory retrieveByHistoryCode(@PathVariable Long historyCode) throws Exception{
        MedicalHistory medicalHistory = medicalHistoryService.findById(historyCode);
        if (medicalHistory != null) {
            if (medicalHistory.getHistoryCode() != null) {
                Patient patient = patientService.findByHistoryCode(medicalHistory.getHistoryCode());
                medicalHistory.setPatient(patient);
            }
            medicalHistory.setAttachmentList(attachmentService.findByEntityAndEntityId("medicalHistory", medicalHistory.getHistoryCode()));
        }
        return medicalHistory;
    }

    @PostMapping("/medicalHistories")
    public MedicalHistory saveMedicalHistory(@Valid @RequestBody MedicalHistory medicalHistory) throws Exception{
        MedicalHistory medicalHistorySaved = medicalHistoryService.save(medicalHistory);
        if (medicalHistorySaved.getHistoryCode() != null) {
            Patient patient = patientService.findByHistoryCode(medicalHistorySaved.getHistoryCode());
            medicalHistorySaved.setPatient(patient);
            medicalHistorySaved.setAttachmentList(attachmentService.findByEntityAndEntityId("medicalHistory", medicalHistorySaved.getHistoryCode()));
        }
        return medicalHistorySaved;
    }
}
