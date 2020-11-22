package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveUserProfileInfo")
public class RetrieveUserProfileInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_userProfileId = (String)requestMap.get("userProfileId");
        UserProfile userProfile = null;
        if(s_userProfileId != null){
            Long l_userProfileId = Long.parseLong(s_userProfileId);
            //final Patient patientRequest = mapper.convertValue(requestMap.get("patient"), Patient.class);

            userProfile = userService.findById(l_userProfileId);
        } else {
            userProfile = userService.createUserProfile();
        }
        addDataToResultMap("userProfile",userProfile);
    }
}
