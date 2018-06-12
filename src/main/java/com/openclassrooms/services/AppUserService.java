package com.openclassrooms.services;

import com.openclassrooms.entities.AppUser;
import com.openclassrooms.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public void addUser(AppUser user) {
        appUserRepository.save(user);
    }

    @Override
    public AppUser checkUser(AppUser user) {
        return appUserRepository.findByEmail(user.getEmail());
    }

    @Override
    public Boolean checkUserValidity(AppUser user) {
        return checkUser(user).getPassword().equals(user.getPassword());
    }
}
