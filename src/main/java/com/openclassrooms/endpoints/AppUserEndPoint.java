package com.openclassrooms.endpoints;

import com.openclassrooms.biblioback.ws.*;
import com.openclassrooms.entities.AppUser;
import com.openclassrooms.services.BookService;
import com.openclassrooms.services.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AppUserEndPoint {
    private static final String NAMESPACE_URI = "http://ws.biblioback.openclassrooms.com";

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    public AppUserEndPoint(BookService bookService){
        this.appUserService = appUserService;
    }

    /**
     *
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAppUserRequest")
    @ResponsePayload
    public void addAppUser(@RequestPayload AppUserAddRequest request){
        AppUser appUser = new AppUser();
        appUser.setFirstName(request.getFirstName());
        appUser.setName(request.getName());
        appUser.setPassword(request.getPassword());
        appUser.setEmail(request.getEmail());
        appUserService.addUser(appUser);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAppUserRequest")
    @ResponsePayload
    public AppUserValidityCheckResponse checkUser(@RequestPayload AppUserValidityCheckRequest request){

       return null;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAppUserssRequest")
    @ResponsePayload
    public AppUserGetAllResponse getAllAppUsers() {
        AppUserGetAllResponse response = new AppUserGetAllResponse();
        List<AppUser> appUsers = appUserService.getAllAppUsers();
        List<com.openclassrooms.biblioback.ws.AppUser> WSAppUsers = new ArrayList<>();

        for (int i = 0; i < appUsers.size(); i++){
            com.openclassrooms.biblioback.ws.AppUser appUser = new com.openclassrooms.biblioback.ws.AppUser();
            BeanUtils.copyProperties(appUsers.get(i),appUser);
            WSAppUsers.add(appUser);
        }

        response.getGetAllAppUsers().addAll(WSAppUsers);

        return response;
    }

}

