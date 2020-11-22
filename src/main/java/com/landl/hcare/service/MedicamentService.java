package com.landl.hcare.service;

import com.landl.hcare.entity.Medicament;

import java.util.List;

public interface MedicamentService {

    public Medicament save(Medicament medicament);

    public Medicament createMedicament();

    public List<Medicament> findAll();

    public Medicament findById(Long medicamentId);


}
