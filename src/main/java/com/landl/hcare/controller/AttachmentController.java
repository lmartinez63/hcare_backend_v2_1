package com.landl.hcare.controller;

import com.landl.hcare.entity.Attachment;
import com.landl.hcare.service.AttachmentService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

@RestController
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;
/*
    @PostMapping("/uploadAttachment")
    public Attachment uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName, @RequestParam("entity") String entity, @RequestParam("entityId") Long entityId) throws Exception{
        //attachment.setEntity();
        //attachment.setEntityId();
        Attachment attachment = new Attachment(fileName, entity, entityId);
        attachment.setContent(file.getBytes());
        attachment.setContentType(file.getContentType());
        return attachmentService.save(attachment);
    }
*/
    @GetMapping("/attachments/{entity}/{entityId}")
    public List<Attachment> retrieveByEntityAndEntityId(@PathVariable String entity, @PathVariable Long entityId) {
        List<Attachment> attachmentList = attachmentService.findByEntityAndEntityId(entity,entityId);
        return attachmentList;
    }
/*
    @GetMapping(value = "/downloadAttachment/{attachmentId}")
    public ResponseEntity<byte[]> getDownloadData(@PathVariable Long attachmentId) throws Exception {

        Attachment attachment = attachmentService.findById(attachmentId).get();
        byte[] output = attachment.getContent();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf(attachment.getContentType()));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename="+attachment.getFileName());

        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }
*/
}
