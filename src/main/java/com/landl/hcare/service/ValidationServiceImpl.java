package com.landl.hcare.service;

import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.Validation;
import com.landl.hcare.repository.LabelRepository;
import com.landl.hcare.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class ValidationServiceImpl implements ValidationService{

    @Autowired
    ValidationRepository validationRepository;


    public Validation save(Validation validation){
        return validationRepository.save(validation);
    }

    public List<Validation> findAll(){
        return validationRepository.findAll();
    }

    public Optional<Validation> findById(Long validationId){
        return validationRepository.findById(validationId);
    }

    public List<Validation> getValidationsByFieldDefinition(FieldDefinition fieldDefinition){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //new UserAuthenticated((User) authentication.getPrincipal()));
        List<Validation> validationList = new ArrayList<Validation>();
        //TODO get language from current user
        String language = "ES_ES";
        /* TODO Pending to to fix to get validations data
        List<Object[]> validationFields = validationRepository.findByFieldDefinitionIdAndLabel(fieldDefinition.getId(), language, fieldDefinition.getLabelCode(), fieldDefinition.getLabelModule(), fieldDefinition.getLabelSubModule());
        for(Object[] validationField:validationFields){
            validationList.add(new Validation(((BigInteger)validationField[0]).longValue(), ((BigInteger)validationField[1]).longValue(), (String)validationField[2], (String)validationField[3], (String)validationField[4]));
        }
        */
        return validationList;
    }

    public List<Validation> getValidationsByFieldDefinition(Long pageId, Long sectionId, Long fieldDefinitionId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Validation> validationList = validationRepository.findByFieldDefinitionIdAndLabel(username,pageId,sectionId,fieldDefinitionId);
        return validationList;
    }
}
