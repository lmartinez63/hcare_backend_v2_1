package com.landl.hcare.service;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.CIE10;
import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.Property;
import com.landl.hcare.repository.CIE10Repository;
import com.landl.hcare.repository.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.util.*;

import static java.util.concurrent.TimeUnit.SECONDS;


@Service
@CacheDefaults(cacheName = "cie10")
public class CIE10ServiceImpl implements CIE10Service{

    @Autowired
    CIE10Repository cie10Repository;
    
    @Autowired
    LabelService labelService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CIE10ServiceImpl.class);

    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
        @Override
        public void customize(CacheManager cacheManager)
        {
            cacheManager.createCache("cie10", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 1000)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        }
    }

    public CIE10 save(CIE10 cie10){
        return cie10Repository.save(cie10);
    }

    public List<CIE10> findAll(){
        return cie10Repository.findAll();
    }

    public CIE10 findById(Long id){
        return cie10Repository.findById(id).get();
    }
    
    public List<AutoCompleteField> findCodeAndDescriptionForAutoCompleteFields() {
        return cie10Repository.findCodeAndDescriptionForAutoCompleteFields();
    }
}
