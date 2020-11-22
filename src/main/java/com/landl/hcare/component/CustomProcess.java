package com.landl.hcare.component;

import com.landl.hcare.entity.SurgeryAnesthesia;
import com.landl.hcare.entity.UserAuthenticated;
import com.landl.hcare.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class  CustomProcess {

    @Autowired
    RolePageSectionFieldService rolePageSectionFieldService;
    
    @Autowired
    MedicalAppointmentMedicamentService medicalAppointmentMedicamentService;

    @Autowired
    ExamBundleService examBundleService;
    
    @Autowired
    EvolutionLogService evolutionLogService;

    @Autowired
    DocumentTemplateService documentTemplateService;

    @Autowired
    DocumentGenerationService documentGenerationService;

    @Autowired
    MedicalAppointmentService medicalAppointmentService;

    @Autowired
    MedicalSurgeryService medicalSurgeryService;

    @Autowired
    SurgeryDoctorService surgeryDoctorService;

    @Autowired
    SurgeryAnesthesiaService surgeryAnesthesiaService;

    @Autowired
    SurgeryNurseService surgeryNurseService;

    @Autowired
    SurgeryAreaService surgeryAreaService;

    @Autowired
    SurgeryTypeService surgeryTypeService;

    @Autowired
    EventService eventService;

    @Autowired
    MedicalAnalysisService medicalAnalysisService;

    @Autowired
    MedicalAreaService medicalAreaService;

    @Autowired
    PatientService patientService;

    @Autowired
    PageService pageService;

    @Autowired
    DataTableService dataTableService;

    @Autowired
    DataColumnService dataColumnService;

    @Autowired
    PageButtonService pageButtonService;

    @Autowired
    PropertyService propertyService;
    
    @Autowired
    AllergyService allergyService;
    
    @Autowired
    FamiliarBackgroundService familiarBackgroundService;

    @Autowired
    SectionService sectionService;

    @Autowired
    FieldService fieldService;

    @Autowired
    RoleService roleService;

    @Autowired
    DirectoryService directoryService;

    @Autowired
    LabelService labelService;

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    MedicalHistoryService medicalHistoryService;

    @Autowired
    AttachmentService attachmentService;

    private ProcessStatus processStatus;

    private UserAuthenticated userAuthenticated;

    private Map<String,Object> resultMap  = new HashMap<String,Object>();

    private Map<String,Object> parentResultMap  = new HashMap<String,Object>();

    public CustomProcess() {
        this.processStatus = ProcessStatus.INITIALIZED;
    }

    public void executeProcess(Map<String, Object> requestMap) throws Exception{
        //TODO set Logs in the benning and in the end
        try{
            this.setProcessStatus(ProcessStatus.RUNNING);
            setUserAuthenticated((UserAuthenticated)requestMap.get("setUserAuthenticated"));
            this.executeCustomProcess(requestMap);
            this.setProcessStatus(ProcessStatus.SUCCESS);
        } catch (Exception e){
            this.setProcessStatus(ProcessStatus.FAILED);
            throw e;
        }
    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }

    public Map getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map resultMap) {
        this.resultMap = resultMap;
    }

    public void addDataToResultMap(String objectName,Object objectResult) {
        this.resultMap.put(objectName,objectResult);
    }

    public Map<String, Object> getParentResultMap() {
        return parentResultMap;
    }

    public void setParentResultMap(Map<String, Object> parentResultMap) {
        this.parentResultMap = parentResultMap;
    }

    public void addDataToParentResultMap(String objectName,Object objectResult) {
        this.parentResultMap.put(objectName,objectResult);
    }

    public UserAuthenticated getUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated(UserAuthenticated userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }
}
