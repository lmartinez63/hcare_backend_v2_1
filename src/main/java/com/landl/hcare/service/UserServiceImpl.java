package com.landl.hcare.service;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.Menu;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.entity.UserProfile;
import com.landl.hcare.repository.MenuRepository;
import com.landl.hcare.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;


    public UserProfile findByUsername(String username){
        return userProfileRepository.findByUsername(username);
    }

    //TODO put on cache
    public UserProfile getPageAndFieldsAssigned(String username) throws  Exception{
        UserProfile userProfile = findByUsername(username);
        List<Object[]> pages = userProfileRepository.getPageAndSectionsAssigned(userProfile.getUsername());
        //Map<Integer, BigDecimal> dpaMap = adjustments.stream().collect(Collectors.toMap(a -> (Integer)a[0], a -> BigDecimal.valueOf((Float) a[1])));
        Map<String,List<String>> pageSectionMap = new HashMap<>();
        for(Object[] page:pages){
            String pageCode = (String) page[0];
            String sectionCode = (String) page[1];
            if(pageSectionMap.containsKey(pageCode)){
                pageSectionMap.get(pageCode).add(sectionCode);
            } else {
                List<String> newSectionList = new ArrayList<String>();
                newSectionList.add(sectionCode);
                pageSectionMap.put(pageCode,newSectionList);
            }
        }
        userProfile.setPageSectionMap(pageSectionMap);
        return userProfile;
    }
    
  //TODO put on cache
    public UserProfile getMenuAndPageAssigned(String username) throws  Exception{
        UserProfile userProfile = findByUsername(username);
        List menus = menuRepository.findMenuListByUserCode(userProfile.getUsername());
        userProfile.setMenus(menus);
        return userProfile;
    }
    
    public List<Map> convertMenusToFrontEndFormat(List<Menu> menus) throws Exception {
        List<Map> menusFrontEndFormat =  new ArrayList<Map>();
        for (Menu menu:menus) {
        	Map menuFrontEndFormat = new HashMap<>();
        	menuFrontEndFormat.put("icon",menu.getIcon());
        	menuFrontEndFormat.put("text",menu.getLabel().getLabelValueEsEs());
        	if(menu.getChildMenus() != null && menu.getChildMenus().size() > 0) {
        		menuFrontEndFormat.put("links",convertMenusToFrontEndFormat(menu.getChildMenus()));
        	}
        	menusFrontEndFormat.add(menuFrontEndFormat);
        }
        return menusFrontEndFormat;
    }

    public UserProfile createUserProfile() throws  Exception{
        UserProfile userProfile = new UserProfile();
        //TODO it should come from database
        //DefaultValues
        userProfile.setEmailAddress("");
        userProfile.setFirstName("");
        userProfile.setLastName("");
        userProfile.setPhoneNumber("");
        return userProfile;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = findByUsername(username);
        if(userProfile == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(userProfile.getUsername(), userProfile.getPassword(), getAuthority(userProfile));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserProfile userProfile) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        userProfile.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<UserProfile> findAll() {
        List<UserProfile> list = new ArrayList<>();
        userProfileRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public List<UserProfile> findByRole(String roleName) {
        List<UserProfile> list = new ArrayList<>();
        userProfileRepository.findByRoleName(roleName).iterator().forEachRemaining(list::add);
        return list;
    };

    public List<AutoCompleteField> findByRoleForAutoCompleteFields(String roleName) {
        List<AutoCompleteField> list = new ArrayList<>();
        userProfileRepository.findByRoleForAutoCompleteFields(roleName).iterator().forEachRemaining(u -> list.add(new AutoCompleteField((String)u[0],u[1])));
        return list;
    };


    @Override
    public void delete(long id) {
        userProfileRepository.deleteById(id);
    }

    @Override
    public UserProfile findOne(String username) {
        return userProfileRepository.findByUsername(username);
    }

    @Override
    public UserProfile findById(Long id) {
        return userProfileRepository.findById(id).get();
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        if(userProfile.getId() == null){
            //TODO default password should be a property
            userProfile.setPassword("password");
        }

        userProfile.setPassword(bcryptEncoder.encode(userProfile.getPassword()));
        return userProfileRepository.save(userProfile);
    }
}
