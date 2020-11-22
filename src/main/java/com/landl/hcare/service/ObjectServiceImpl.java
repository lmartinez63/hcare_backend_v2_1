package com.landl.hcare.service;

import com.google.common.base.CaseFormat;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.Label;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Service
public class ObjectServiceImpl implements ObjectService {

	@Autowired
	LabelService labelService;

	@Autowired
	PropertyService propertyService;

	public void transformObjectLabels(Object tObject) throws  Exception{
        if (tObject != null) {
            Class classInstance = tObject.getClass();
            Field[] attributes = classInstance.getDeclaredFields();
            for (Field field : attributes) {
                if (field.getName().startsWith("label")) {
                    String fieldValueName = field.getName().substring(5);
                    Method targetMethod = classInstance.getMethod("get" + fieldValueName, null);
                    Object returnObject = targetMethod.invoke(tObject, null);
                    if (returnObject != null) {
                    	Label labelField = null;
                    	if (fieldValueName.compareToIgnoreCase("status") == 0) {
                        	labelField = propertyService.findLabelOfPropertyByModuleAndPropertyCodeAndPropertyValue(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, classInstance.getSimpleName()).toUpperCase(), "STATUS", returnObject.toString());
                        	PropertyUtils.setSimpleProperty(tObject, field.getName(), labelField.getLabelValueEsEs());
                        } else {
                        	String propertyLabel = (Character.toLowerCase(fieldValueName.charAt(0)) + fieldValueName.substring(1)).replaceAll("([A-Z])", "_$1").toUpperCase(); 
                        	labelField = labelService.getByLabelCodeAndUserLanguage(returnObject.toString(), "GENERAL", propertyLabel);

                        	//For special status get from entity
                        	if (labelField == null){
                        		//To get for example from DISTRICT(getDistrict) Property instead of ADDRESSDISTRICT(getAddressDistrict)
                        		int fuc = UtilityTools.findFirstUppercaseChar(fieldValueName, 1);
                        		if (fuc > 1)
                        		labelField = labelService.getByLabelCodeAndUserLanguage(returnObject.toString(), "GENERAL", fieldValueName.substring(fuc,fieldValueName.length()).toUpperCase());
                        }
                        }
                        if (labelField != null)
                			PropertyUtils.setSimpleProperty(tObject, field.getName(), labelField.getLabelValueEsEs());
                        
                    }
                }
            }
        }
    }

}
