package com.landl.hcare.service;

import com.landl.hcare.entity.Email;
import com.landl.hcare.entity.MedicalAppointment;

import java.util.List;
import java.util.Optional;

public interface EmailService {
    void sendSimpleMessage(Email email) throws Exception;

    public void buildEmailFromEmailTemplate(Email email) throws Exception;

    public Email save(Email email);

    public List<Email> findAll();

    public List<Email> findByStatus(Integer status);

    public Optional<Email> findById(Long emailId);

    public int sendEmailToPatient(MedicalAppointment medicalAppointment) throws Exception;

    public int sendEmailToDoctor(MedicalAppointment medicalAppointment) throws Exception;
}