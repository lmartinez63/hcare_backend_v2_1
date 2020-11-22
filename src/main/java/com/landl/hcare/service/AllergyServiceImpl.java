package com.landl.hcare.service;

import com.landl.hcare.entity.Allergy;
import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.CIE10;
import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.Property;
import com.landl.hcare.repository.AllergyRepository;
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
@CacheDefaults(cacheName = "allergy")
public class AllergyServiceImpl implements AllergyService{

    @Autowired
    AllergyRepository allergyRepository;
    
    @Autowired
    LabelService labelService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AllergyServiceImpl.class);

    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
        @Override
        public void customize(CacheManager cacheManager)
        {
            cacheManager.createCache("allergy", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 1000)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        }
    }

    public Allergy save(Allergy allergy){
        return allergyRepository.save(allergy);
    }

    public List<Allergy> findAll(){
        return allergyRepository.findAll();
    }

    public Allergy findById(Long id){
        return allergyRepository.findById(id).get();
    }
    
    public List<AutoCompleteField> findCodeAndDescriptionForAutoCompleteFields() {
        return allergyRepository.findCodeAndDescriptionForAutoCompleteFields();
    }
    
    public Allergy createAllergy(){
    	Allergy allergy = new Allergy();
        return allergy;
    }
}
