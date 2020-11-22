package com.landl.hcare.service;

import com.landl.hcare.entity.Attachment;
import com.landl.hcare.entity.MedicalSurgery;
import com.landl.hcare.entity.SurgeryAnesthesia;
import com.landl.hcare.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    SurgeryAnesthesiaService surgeryAnesthesiaService;

    @Autowired
    MedicalSurgeryService medicalSurgeryService;

    public Attachment save(Attachment attachment) throws Exception{
        Attachment attachmentSave = attachmentRepository.save(attachment);
        if ( attachment.getFieldToMatchEntiyId() != null ){
            switch (attachment.getEntity()){
                case "surgeryAnesthesia":
                    SurgeryAnesthesia surgeryAnesthesia = surgeryAnesthesiaService.findById(attachment.getEntityId());
                    if ( attachment.getFieldToMatchEntiyId().compareTo("anesthesiaReportId") == 0 ){
                        surgeryAnesthesia.setAnesthesiaReport(attachment);
                    } else if ( attachment.getFieldToMatchEntiyId().compareTo("postAnesthesiaReportId") == 0 ){
                        surgeryAnesthesia.setPostAnesthesiaReport(attachment);
                    }
                    surgeryAnesthesiaService.save(surgeryAnesthesia);
                    break;
                case "medicalSurgery":
                    MedicalSurgery medicalSurgery = medicalSurgeryService.findById(attachment.getEntityId());
                    if ( attachment.getFieldToMatchEntiyId().compareTo("informedConsentReportId") == 0 ){
                        medicalSurgery.setInformedConsentReport(attachment);
                    } else if ( attachment.getFieldToMatchEntiyId().compareTo("surgeryReportId") == 0 ){
                        medicalSurgery.setSurgeryReport(attachment);
                    } else if ( attachment.getFieldToMatchEntiyId().compareTo("verificationListReportId") == 0 ){
                        medicalSurgery.setVerificationListReport(attachment);
                    }
                    medicalSurgeryService.save(medicalSurgery);
                    break;
                default:
                        break;
            }

        }
        return attachmentSave;
    }

    public List<Attachment> findAll(){
        return attachmentRepository.findAll();
    }

    public Optional<Attachment> findById(Long attachmentId){
        return attachmentRepository.findById(attachmentId);
    }

    public List<Attachment> findByEntityAndEntityId(String entity, Long entityId){
        return  attachmentRepository.findByEntityAndEntityId(entity,entityId);
    }
}
