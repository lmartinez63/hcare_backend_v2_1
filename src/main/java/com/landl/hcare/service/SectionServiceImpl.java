package com.landl.hcare.service;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.PageButton;
import com.landl.hcare.entity.Section;
import com.landl.hcare.repository.PageButtonRepository;
import com.landl.hcare.repository.SectionRepository;
import com.landl.hcare.rule.RuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService{

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    PageButtonRepository pageButtonRepository;

    @Autowired
    FieldService fieldService;

    public Section save(Section section){
        return sectionRepository.save(section);
    }

    public List<Section> findAll(){
        return sectionRepository.findAll();
    }

    public List<Section> getSectionsByPageCode(String pageCode){
        List<Section> sectionList = sectionRepository.getSectionsByPageCode(pageCode);
        return sectionList;
    }

    public List<Section> getSectionsByPageCodeAndUsername(String pageCode, String username){
        List<Section> sectionList = sectionRepository.getSectionsByPageCodeAndUsername(pageCode, username);
        for(Section section:sectionList){
            section.setFieldDefinitionList(fieldService.getFieldsByPageSectionCodeAndUsername(pageCode, section.getSectionCode(), username));
            section.setFieldDefinitionMap(section.getFieldDefinitionList().stream().collect(Collectors.toMap(FieldDefinition::getFieldDefinitionCode, item -> item)));
            section.setSectionButtons(pageButtonRepository.findBySectionId(section.getId()));
        }
        return sectionList;
    }

    public Section findById(Long sectionId){
        return sectionRepository.findById(sectionId).get();
    }

    public Section createSection(){
        Section section = new Section();
        section.setVisibleRuleExp("true");
        return section;
    }

    public void evaluateRules(Section section, Map dataSource) {
        //By default set Visible to true
        section.setVisible(true);
        if(!UtilityTools.isEmpty(section.getVisibleRuleExp())){
            try{
                section.setVisible(RuleManager.evaluateExpression(section.getVisibleRuleExp(),dataSource));
            } catch(Exception e){
                e.printStackTrace();
                section.setVisible(false);
            }
        }

        for (PageButton sectionButton:section.getSectionButtons()) {
            sectionButton.setVisible(true);
            if(!UtilityTools.isEmpty(sectionButton.getVisibleRuleExp())){
                try{
                    sectionButton.setVisible(RuleManager.evaluateExpression(sectionButton.getVisibleRuleExp(),dataSource));
                } catch(Exception e){
                    //e.printStackTrace();
                    sectionButton.setVisible(false);
                }
            }
        }

    }
    /* Not Longer neccesary
    public void evaluateFields(Section section, Map dataSource) throws  Exception {

        Label label = labelService.getByLabelCodeAndUserLanguage(section.getLabelCode(), section.getLabelModule(), section.getLabelSubModule());
        if (label != null){
            section.setLabelValue(label.getLabelValue());
        }

    }
    */
}
