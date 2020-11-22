package com.landl.hcare.service;


import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.MedicalArea;

import java.util.List;
import java.util.Optional;

public interface LabelService {

    public Label save(Label label);

    public List<Label> findAll();

    public Label findById(Long labelId);

    public Label createLabel();

    public Label getByLabelCodeAndUserLanguage(String labelCode, String module, String subModule);

}
