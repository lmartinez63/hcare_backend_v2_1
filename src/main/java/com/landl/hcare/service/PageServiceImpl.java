package com.landl.hcare.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.*;
import com.landl.hcare.repository.PageRepository;
import com.landl.hcare.rule.RuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidatorAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    PageRepository pageRepository;

    @Autowired
    FieldService fieldService;

    @Autowired
    SectionService sectionService;

    @Autowired
    ValidationService validationService;

    @Autowired
    UserService userService;

    public Page save(Page page){
        return pageRepository.save(page);
    }

    public List<Page> findAll(){
        return pageRepository.findAll();
    }

    public Page findById(Long pageId){
        return pageRepository.findById(pageId).get();
    }

    public Page createPage(){
        Page page = new Page();
        page.setVisibleRuleExp("true");
        return page;
    }

    public Page findByPageCode(String pageCode){
        return pageRepository.findByPageCode(pageCode).get(0);
    }

    public Page findByPageCodeAndUsername(String pageCode, String username){
        return pageRepository.findByPageCodeAndUsername(pageCode, username);
    }

    //TODO put on cache
    public Page findPageSectionAndFieldsByPageCodeAndUserName(String pageCode, String username) throws Exception{
        UserProfile userProfile = userService.getPageAndFieldsAssigned(username);
        Page page = findByPageCode(pageCode);
            page.setSectionList(sectionService.getSectionsByPageCodeAndUsername(pageCode, username));
        page.setSectionMap(page.getSectionList().stream().collect(Collectors.toMap(Section::getSectionCode, item -> item)));
        return page;
    }

    public void verifyIfCurrentUserIsAuthorizated(Page page,Map dataSource){
        page.setVisible(true);
        if(!UtilityTools.isEmpty(page.getVisibleRuleExp())){
            try{
                page.setVisible(RuleManager.evaluateExpression(page.getVisibleRuleExp(),dataSource));
            } catch(Exception e){
                e.printStackTrace();
                page.setVisible(false);
            }
        }
    }
    
    

    public void evaluateRules(Page page, Map dataSource) throws Exception {
        //By default set Visible to true
        for (PageButton pageButton:page.getPageButtons()) {
            pageButton.setVisible(true);
            if(!UtilityTools.isEmpty(pageButton.getVisibleRuleExp())){
                try{
                    pageButton.setVisible(RuleManager.evaluateExpression(pageButton.getVisibleRuleExp(),dataSource));
                } catch(Exception e){
                    //e.printStackTrace();
                    pageButton.setVisible(false);
                }
            }
        }
    }
    
    public void evaluateFields(Page page, Map dataSource) throws Exception {
        //By default set Visible to true
    	if ( UtilityTools.hasExpressions(page.getTitleDefinition()) ) {
    		page.setTitleDefinition((String)RuleManager.resolveExpression(page.getTitleDefinition(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getCoTitleDefinition()) ) {
    		page.setCoTitleDefinition((String)RuleManager.resolveExpression(page.getCoTitleDefinition(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText()) ) {
    		page.setHeaderText((String)RuleManager.resolveExpression(page.getHeaderText(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText1()) ) {
    		page.setHeaderText1((String)RuleManager.resolveExpression(page.getHeaderText1(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText2()) ) {
    		page.setHeaderText2((String)RuleManager.resolveExpression(page.getHeaderText2(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText3()) ) {
    		page.setHeaderText3((String)RuleManager.resolveExpression(page.getHeaderText3(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText4()) ) {
    		page.setHeaderText4((String)RuleManager.resolveExpression(page.getHeaderText4(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText5()) ) {
    		page.setHeaderText5((String)RuleManager.resolveExpression(page.getHeaderText5(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText6()) ) {
    		page.setHeaderText6((String)RuleManager.resolveExpression(page.getHeaderText6(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText7()) ) {
    		page.setHeaderText7((String)RuleManager.resolveExpression(page.getHeaderText7(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText8()) ) {
    		page.setHeaderText8((String)RuleManager.resolveExpression(page.getHeaderText8(),dataSource,String.class));
    	}
    	if ( UtilityTools.hasExpressions(page.getHeaderText9()) ) {
    		page.setHeaderText9((String)RuleManager.resolveExpression(page.getHeaderText9(),dataSource,String.class));
    	}
    	
    }


    public void processFields(Page page, Map dataSource) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        evaluateRules(page,dataSource);
        evaluateFields(page,dataSource);
        for(Section section:page.getSectionList()){
            sectionService.evaluateRules(section, dataSource);
            //Not longer neccesary labels comes from label relation
            //sectionService.evaluateFields(section, dataSource);
            for(FieldDefinition fieldDefinition:section.getFieldDefinitionList()){
                fieldService.evaluateRules(fieldDefinition, dataSource);
                fieldService.evaluateFields(fieldDefinition, dataSource);
                for(Validation validation:validationService.getValidationsByFieldDefinition(page.getId(),section.getId(),fieldDefinition.getId())){
                    if(validation.getValidationType().compareTo(1) ==0){
                        fieldDefinition.setRequired(true);
                    }
                    if(validation.getValidationType().compareTo(1) ==0){
                        fieldDefinition.setRequired(true);
                    }
                }
                //fieldDefinition.setValidationList(validationService.getValidationsByFieldDefinition(page.getId(),section.getId(),fieldDefinition.getId()));
            }
            section.setFieldDefinitionMap(section.getFieldDefinitionList().stream().collect(Collectors.toMap(FieldDefinition::getFieldDefinitionCode, item -> item)));
        }
        page.setSectionMap(page.getSectionList().stream().collect(Collectors.toMap(Section::getSectionCode, item -> item)));
    }

}
