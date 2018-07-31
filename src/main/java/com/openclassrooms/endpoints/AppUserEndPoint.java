package com.openclassrooms.endpoints;

import com.openclassrooms.biblioback.ws.test.*;
import com.openclassrooms.entities.AppUser;
import com.openclassrooms.services.AppUserService;
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
    private static final String NAMESPACE_URI = "http://test.ws.biblioback.openclassrooms.com";

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    public AppUserEndPoint(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    /**
     *
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserAddRequest")
    @ResponsePayload
    public AppUserAddResponse addAppUser(@RequestPayload AppUserAddRequest request){
        AppUserAddResponse response = new AppUserAddResponse();

        try {
            AppUser appUser = new AppUser();
            appUser.setFirstName(request.getFirstName());
            appUser.setName(request.getName());
            appUser.setPassword(request.getPassword());
            appUser.setEmail(request.getEmail());
            appUserService.addUser(appUser);
            response.setConfirmation(true);
        }catch (Exception e ){
            System.out.println("L'utilisateur n'a pas pu être enregistré");
            response.setConfirmation(false);
        }
       return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserValidityCheckRequest")
    @ResponsePayload
    public AppUserValidityCheckResponse checkUser(@RequestPayload AppUserValidityCheckRequest request){
        AppUserValidityCheckResponse response = new AppUserValidityCheckResponse();
        AppUser au = appUserService.checkUser(request.getEmail());
        com.openclassrooms.biblioback.ws.test.AppUser auws = new com.openclassrooms.biblioback.ws.test.AppUser();
        BeanUtils.copyProperties(au, auws);
        if (au.getPassword().equals(request.getPassword()))
            response.setUser(auws);

       return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserGetAllRequest")
    @ResponsePayload
    public AppUserGetAllResponse getAllAppUsers() {
        AppUserGetAllResponse response = new AppUserGetAllResponse();
        List<AppUser> appUsers = appUserService.getAllAppUsers();
        List<com.openclassrooms.biblioback.ws.test.AppUser> WSAppUsers = new ArrayList<>();

        for (int i = 0; i < appUsers.size(); i++){
            com.openclassrooms.biblioback.ws.test.AppUser appUser = new com.openclassrooms.biblioback.ws.test.AppUser();
            BeanUtils.copyProperties(appUsers.get(i),appUser);
            WSAppUsers.add(appUser);
        }

        response.getGetAllAppUsers().addAll(WSAppUsers);

        return response;
    }

   // @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserGetByIdRequest")
   // @ResponsePayload
   // public AppUserGetByIdResponse getBookById(@RequestPayload AppUserGetByIdRequest request) {
   //     BookGetByIdResponse response = new BookGetByIdResponse();
   //     Book book = new Book();
   //     BeanUtils.copyProperties(bookService.getBookById(request.getId()), book);
   //     response.setBookGet(book);
   //     return response;
   // }


}

