package com.landl.hcare.model;

import com.landl.hcare.entity.ExtRevEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ExtRevListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        ExtRevEntity extRevEntity = (ExtRevEntity) revisionEntity;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if(SecurityContextHolder.getContext().getAuthentication()  != null ){
            extRevEntity.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            extRevEntity.setRequestIp(request.getRemoteAddr());
        }
    }
}