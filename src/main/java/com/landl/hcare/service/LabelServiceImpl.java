package com.landl.hcare.service;

import com.landl.hcare.entity.*;
import com.landl.hcare.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.util.List;
import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@CacheDefaults(cacheName = "label")
public class LabelServiceImpl implements LabelService{

    @Autowired
    LabelRepository labelRepository;

    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
        @Override
        public void customize(CacheManager cacheManager)
        {
            cacheManager.createCache("label", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 1000)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        }
    }

    public Label save(Label label){
        return labelRepository.save(label);
    }

    public List<Label> findAll(){
        return labelRepository.findAll();
    }

    public Label findById(Long labelId){
        return labelRepository.findById(labelId).get();
    }

    public Label createLabel(){
        Label label = new Label();
        return label;
    }

    @CacheResult
    public Label getByLabelCodeAndUserLanguage(String labelCode, String module, String subModule){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //new UserAuthenticated((User) authentication.getPrincipal()));
        //TODO get language from current user
        String language = "ES_ES";
        List<Label> labelsResult = labelRepository.findByLabelCodeAndModuleAndSubModuleAndLanguage(labelCode, module, subModule, language);
        if(labelsResult.size() > 0){
            return labelsResult.get(0);
        } else {
            return null;
        }
    }
}
