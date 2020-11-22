package com.landl.hcare.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("customProcessSelector")
public class CustomProcessSelector {

    @Autowired
    RetrieveEvolutionLogInfo retrieveEvolutionLogInfo;
    
    @Autowired
    RetrieveMedicalAppointmentMedicamentInfo retrieveMedicalAppointmentMedicamentInfo;

    @Autowired
    RetrieveExamBundleListInfo retrieveExamBundleListInfo;
    
    @Autowired
    SaveEvolutionLog saveEvolutionLog;
    
    @Autowired
    SaveMedicalAppointmentMedicament saveMedicalAppointmentMedicament;

    @Autowired
    SaveSurgeryAnesthesia saveSurgeryAnesthesia;

    @Autowired
    GenerateDocumentFromTemplate generateDocumentFromTemplate;

    @Autowired
    RetrieveSurgeryAnesthesiaInfo retrieveSurgeryAnesthesiaInfo;

    @Autowired
    SaveSurgeryDoctor saveSurgeryDoctor;

    @Autowired
    SaveSurgeryNurse saveSurgeryNurse;

    @Autowired
    RetrieveSurgeryNurseInfo retrieveSurgeryNurseInfo;

    @Autowired
    RetrieveSurgeryDoctorInfo retrieveSurgeryDoctorInfo;

    @Autowired
    RetrieveEventInfo retrieveEventInfo;

    @Autowired
    SaveEvent saveEvent;

    @Autowired
    RetrieveSurgeryAreaInfo retrieveSurgeryAreaInfo;

    @Autowired
    SaveSurgeryArea saveSurgeryArea;

    @Autowired
    RetrieveMedicalAppointmentInfo retrieveMedicalAppointmentInfo;

    @Autowired
    RetrieveMedicalSurgeryInfo retrieveMedicalSurgeryInfo;

    @Autowired
    RetrieveMedicalAnalysisInfo retrieveMedicalAnalysisInfo;

    @Autowired
    RetrievePatientInfo retrievePatientInfo;

    @Autowired
    RetrieveMedicalAreaInfo retrieveMedicalAreaInfo;

    @Autowired
    RetrieveUserProfileInfo retrieveUserProfileInfo;

    @Autowired
    GetPatientByDocumentNumber getPatientByDocumentNumber;

    @Autowired
    GetSurgeryAreaListByRequiredDate getSurgeryAreaListByRequiredDate;

    @Autowired
    GetAvailableDatetimeListOnSurgeryArea getAvailableDatetimeListOnSurgeryArea;

    @Autowired
    GetAvailableDatetimeListBySurgeryType getAvailableDatetimeListBySurgeryType;

    @Autowired
    SaveMedicalAppointment saveMedicalAppointment;

    @Autowired
    SaveMedicalSurgery saveMedicalSurgery;

    @Autowired
    SaveMedicalAnalysis saveMedicalAnalysis;

    @Autowired
    SavePatient savePatient;

    @Autowired
    SavePage savePage;

    @Autowired
    SaveSection saveSection;

    @Autowired
    SaveFieldDefinition saveFieldDefinition;

    @Autowired
    SaveMedicalHistory saveMedicalHistory;

    @Autowired
    SaveRolePageSectionField saveRolePageSectionField;

    @Autowired
    SaveLabel saveLabel;

    @Autowired
    SaveUserProfile saveUserProfile;

    @Autowired
    DeleteRolePageSectionField deleteRolePageSectionField;

    @Autowired
    RetrieveMedicalHistoryInfo retrieveMedicalHistoryInfo;

    @Autowired
    RetrievePageInfo retrievePageInfo;

    @Autowired
    RetrieveDataTableInfo retrieveDataTableInfo;

    @Autowired
    RetrieveDataColumnInfo retrieveDataColumnInfo;

    @Autowired
    RetrieveSectionInfo retrieveSectionInfo;

    @Autowired
    RetrieveFieldDefinitionInfo retrieveFieldDefinitionInfo;

    @Autowired
    RetrieveRolePageSectionFieldInfo retrieveRolePageSectionFieldInfo;

    @Autowired
    RetrieveLabelInfo retrieveLabelInfo;

    @Autowired
    RetrieveAllRoles retrieveAllRoles;

    @Autowired
    RetrieveAllSections retrieveAllSections;

    @Autowired
    RetrieveAllPages retrieveAllPages;

    @Autowired
    RetrievePropertyInfo retrievePropertyInfo;
    
    @Autowired
    RetrieveAllergyInfo retrieveAllergyInfo;
    
    @Autowired
    RetrieveFamiliarBackgroundInfo retrieveFamiliarBackgroundInfo;

    @Autowired
    SaveProperty saveProperty;
    
    @Autowired
    SaveAllergy saveAllergy;
    
    @Autowired
    SaveFamiliarBackground saveFamiliarBackground;

    @Autowired
    SaveDataTable saveDataTable;

    @Autowired
    SaveDataColumn saveDataColumn;

    @Autowired
    RetrieveAllFieldDefinitions retrieveAllFieldDefinitions;

    @Autowired
    RetrievePageButtonInfo retrievePageButtonInfo;

    @Autowired
    SavePageButton savePageButton;

    public CustomProcess getCustomProcessClass(String customProcessName) throws Exception{
        CustomProcess customProcess = null;
        switch(customProcessName){
        	case "RetrieveMedicalAppointmentMedicamentInfo":
        		customProcess = retrieveMedicalAppointmentMedicamentInfo;
        		break;
        	case "SaveMedicalAppointmentMedicament":
        		customProcess = saveMedicalAppointmentMedicament;
        		break;
        	case "RetrieveExamBundleListInfo":
        		customProcess = retrieveExamBundleListInfo;
        		break;
        	case "SaveEvolutionLog":
                customProcess = saveEvolutionLog;
                break;
            case "RetrieveEvolutionLogInfo":
                customProcess = retrieveEvolutionLogInfo;
                break;
            case "GenerateDocumentFromTemplate":
                customProcess = generateDocumentFromTemplate;
                break;
            case "SaveSurgeryAnesthesia":
                customProcess = saveSurgeryAnesthesia;
                break;
            case "RetrieveSurgeryAnesthesiaInfo":
                customProcess = retrieveSurgeryAnesthesiaInfo;
                break;
            case "SaveSurgeryDoctor":
                customProcess = saveSurgeryDoctor;
                break;
            case "SaveSurgeryNurse":
                customProcess = saveSurgeryNurse;
                break;
            case "RetrieveSurgeryDoctorInfo":
                customProcess = retrieveSurgeryDoctorInfo;
                break;
            case "RetrieveSurgeryNurseInfo":
                customProcess = retrieveSurgeryNurseInfo;
                break;
            case "RetrieveEventInfo":
                customProcess = retrieveEventInfo;
                break;
            case "SaveEvent":
                customProcess = saveEvent;
                break;
            case "RetrieveSurgeryAreaInfo":
                customProcess = retrieveSurgeryAreaInfo;
                break;
            case "SaveSurgeryArea":
                customProcess = saveSurgeryArea;
                break;
            case "RetrieveMedicalAnalysisInfo":
                customProcess = retrieveMedicalAnalysisInfo;
                break;
            case "RetrieveMedicalSurgeryInfo":
                customProcess = retrieveMedicalSurgeryInfo;
                break;
            case "RetrieveMedicalAppointmentInfo":
                customProcess = retrieveMedicalAppointmentInfo;
                break;
            case "RetrievePatientInfo":
                customProcess = retrievePatientInfo;
                break;
            case "RetrieveUserProfileInfo":
                customProcess = retrieveUserProfileInfo;
                break;
            case "RetrieveMedicalAreaInfo":
                customProcess = retrieveMedicalAreaInfo;
                break;
            case "RetrieveRolePageSectionFieldInfo":
                customProcess = retrieveRolePageSectionFieldInfo;
                break;
            case "RetrievePageInfo":
                customProcess = retrievePageInfo;
                break;
            case "RetrieveSectionInfo":
                customProcess = retrieveSectionInfo;
                break;
            case "RetrieveFieldDefinitionInfo":
                customProcess = retrieveFieldDefinitionInfo;
                break;
            case "RetrieveAllRoles":
                customProcess = retrieveAllRoles;
                break;
            case "RetrieveAllPages":
                customProcess = retrieveAllPages;
                break;
            case "RetrieveAllSections":
                customProcess = retrieveAllSections;
                break;
            case "RetrieveAllFieldDefinitions":
                customProcess = retrieveAllFieldDefinitions;
                break;
            case "RetrieveLabelInfo":
                customProcess = retrieveLabelInfo;
                break;
            case "RetrieveMedicalHistoryInfo":
                customProcess = retrieveMedicalHistoryInfo;
                break;
            case "GetPatientByDocumentNumber":
                customProcess = getPatientByDocumentNumber;
                break;
            case "GetSurgeryAreaListByRequiredDate":
                customProcess = getSurgeryAreaListByRequiredDate;
                break;
            case "GetAvailableDatetimeListOnSurgeryArea":
                customProcess = getAvailableDatetimeListOnSurgeryArea;
                break;
            case "GetAvailableDatetimeListBySurgeryType":
                customProcess = getAvailableDatetimeListBySurgeryType;
                break;
            case "SaveMedicalHistory":
                customProcess = saveMedicalHistory;
                break;
            case "SaveMedicalAppointment":
                customProcess = saveMedicalAppointment;
                break;
            case "SaveMedicalSurgery":
                customProcess = saveMedicalSurgery;
                break;
            case "SaveMedicalAnalysis":
                customProcess = saveMedicalAnalysis;
                break;
            case "SavePatient":
                customProcess = savePatient;
                break;
            case "SavePage":
                customProcess = savePage;
                break;
            case "SaveSection":
                customProcess = saveSection;
                break;
            case "SaveFieldDefinition":
                customProcess = saveFieldDefinition;
                break;
            case "SaveRolePageSectionField":
                customProcess = saveRolePageSectionField;
                break;
            case "SaveLabel":
                customProcess = saveLabel;
                break;
            case "SaveUserProfile":
                customProcess = saveUserProfile;
                break;
            case "RetrievePropertyInfo":
                customProcess = retrievePropertyInfo;
                break;
            case "RetrieveAllergyInfo":
                customProcess = retrieveAllergyInfo;
                break;
            case "RetrieveFamiliarBackgroundInfo":
                customProcess = retrieveFamiliarBackgroundInfo;
                break;
            case "SaveProperty":
                customProcess = saveProperty;
                break;
            case "SaveAllergy":
                customProcess = saveAllergy;
                break;
            case "SaveFamiliarBackground":
                customProcess = saveFamiliarBackground;
                break;
            case "DeleteRolePageSectionField":
                customProcess = deleteRolePageSectionField;
                break;
            case "RetrieveDataTableInfo":
                customProcess = retrieveDataTableInfo;
                break;
            case "RetrieveDataColumnInfo":
                customProcess = retrieveDataColumnInfo;
                break;
            case "SaveDataTable":
                customProcess = saveDataTable;
                break;
            case "SaveDataColumn":
                customProcess = saveDataColumn;
                break;
            case "RetrievePageButtonInfo":
                customProcess = retrievePageButtonInfo;
                break;
            case "SavePageButton":
                customProcess = savePageButton;
                break;

            default:
                    throw new Exception("Process "+customProcessName+" has not been found");
        }
        return customProcess;
    }
}
