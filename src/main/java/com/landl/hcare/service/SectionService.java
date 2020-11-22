package com.landl.hcare.service;


import com.landl.hcare.entity.Section;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SectionService {

    public Section save(Section section);

    public List<Section> findAll();

    public List<Section> getSectionsByPageCode(String pageCode);

    public List<Section> getSectionsByPageCodeAndUsername(String pageCode, String username);

    public Section findById(Long sectionId);

    public Section createSection();

    public void evaluateRules(Section section, Map dataSource);

}
