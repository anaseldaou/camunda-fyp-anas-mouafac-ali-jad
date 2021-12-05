package com.example.workflow.Service;

import com.example.workflow.Model.AppUser;
import com.example.workflow.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    public boolean isAvailable(String username) {
        return this.appUserRepository.findByEmail(username) != null;
    }

    public boolean isProfessor(String email) {
        return this.appUserRepository.findByEmail(email).getIsProfessor();
    }

    public String signUp(AppUser user) {
        appUserRepository.save(new AppUser("anas","anas",true));
        appUserRepository.save(new AppUser("mouafac","mouafac",true));
        appUserRepository.save(new AppUser("ali","ali",false));
        appUserRepository.save(new AppUser("jad","jad",false));
        return "successful";
    }
}
