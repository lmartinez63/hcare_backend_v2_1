package com.landl.hcare.service;

import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.Medicament;
import com.landl.hcare.repository.MedicamentRepository;
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
@CacheDefaults(cacheName = "medicament")
public class MedicamentServiceImpl implements MedicamentService{

    @Autowired
    MedicamentRepository medicamentRepository;
    

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicamentServiceImpl.class);

    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
        @Override
        public void customize(CacheManager cacheManager)
        {
            cacheManager.createCache("medicament", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 1000)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        }
    }

    public Medicament save(Medicament medicament){
        return medicamentRepository.save(medicament);
    }

    public Medicament createMedicament(){
        Medicament medicament = new Medicament();
        return medicament;
    }

    public List<Medicament> findAll(){
        return medicamentRepository.findAll();
    }

    @CacheResult
    public Medicament findByMedicamentCode(String medicamentCode){
        Medicament medicament = medicamentRepository.findByCode(medicamentCode);
        return medicament;
    }

    public Medicament findById(Long medicamentId){

        return medicamentRepository.findById(medicamentId).get();
    }

}
