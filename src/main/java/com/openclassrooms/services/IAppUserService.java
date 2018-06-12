package com.openclassrooms.services;

import com.openclassrooms.entities.AppUser;

public interface IAppUserService {

    void addUser(AppUser user);
    AppUser checkUser(AppUser user);
    Boolean checkUserValidity(AppUser user);

}
