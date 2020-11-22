package com.landl.hcare.controller;

import com.landl.hcare.config.TokenProvider;
import com.landl.hcare.entity.UserProfile;
import com.landl.hcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/api/users", method = RequestMethod.GET)
    public List<UserProfile> listUser() throws Exception{
        return userService.findAll();
    }

    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public UserProfile getOne(@PathVariable(value = "id") Long id) throws Exception{
        return userService.findById(id);
    }

    @RequestMapping(value = "/api/getUserInfoByToken/{token}", method = RequestMethod.GET)
    public UserProfile getUserInfoByToken(@PathVariable(value = "token") String token) throws Exception{
        return tokenProvider.getUserProfileFromToken(token);
    }


    @RequestMapping(value="/api/signup", method = RequestMethod.POST)
    public UserProfile save(@Valid @RequestBody UserProfile userProfile) throws Exception{
        return userService.save(userProfile);
    }



}