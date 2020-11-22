package com.landl.hcare.rule;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.entity.type.MedicalAppointmentStatus;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static com.landl.hcare.common.UtilityTools.getFormatedValue;

import java.util.HashMap;
import java.util.Map;

public class RuleManager {
    public static Object resolveExpression(String expression, Map entityMap, Class classType) throws Exception {
        String formattedValue = getFormatedValue(expression, entityMap);
        return (classType.cast(formattedValue));
    }
    
    public static Boolean evaluateExpression(String expression,Map entityMap) throws Exception {
        Boolean result = true;
        String formattedValue = UtilityTools.getFormatedValue(expression, entityMap);

        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        //Examples
        //String formattedValue = "('abc' == 'xyz' && 'thy' == 'thy') || ('ujy' == 'ujy')";
        //String formattedValue = "'{{medicalAppointment.status}}' > '10'";
        return new Boolean(se.eval(formattedValue).toString());
    }

    public static void main(String[] args){

        try {
            Map<String, Object> entityMap = new HashMap<String, Object>();
            MedicalAppointment medicalAppointment = new MedicalAppointment();
            medicalAppointment.setStatus(MedicalAppointmentStatus.PENDING_ANALYSIS_RESULTS);
            entityMap.put("medicalAppointment",medicalAppointment);

            Patient patient = new Patient();
            patient.setHistoryCode(new Long(123123));
            String expression = "{{patient.historyCode}} !== null";
            entityMap.put("patient",patient);
            evaluateExpression(expression, entityMap);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
