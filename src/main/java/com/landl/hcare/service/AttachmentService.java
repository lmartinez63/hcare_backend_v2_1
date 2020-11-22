package com.landl.hcare.service;


import com.landl.hcare.entity.Attachment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AttachmentService {

    public Attachment save(Attachment patient) throws Exception;

    public List<Attachment> findAll();

    public Optional<Attachment> findById(Long attachmentId);

    public List<Attachment> findByEntityAndEntityId(String entity, Long entityId);

}
