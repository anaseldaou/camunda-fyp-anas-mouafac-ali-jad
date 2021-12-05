package com.example.workflow.Service;

import com.example.workflow.Model.AppUser;
import com.example.workflow.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser getUserByEmail(String email) {
        return this.appUserRepository.findByEmail(email);
    }
}
