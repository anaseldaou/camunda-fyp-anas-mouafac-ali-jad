package com.example.workflow.Controller;

import com.example.workflow.Model.AppUser;
import com.example.workflow.Service.AppUserService;
import com.example.workflow.Service.AuthenticationService;
import com.example.workflow.Service.BMPNService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.inject.Named;


@Named
@RequestMapping("home")
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private BMPNService bmpnService;

    private String processId;

    public LoginController(){}

    @PostMapping("/login")
    public @ResponseBody AppUser login(@RequestBody AppUser user) throws Exception {
        if (this.authenticationService.isAvailable(user.getEmail())) {
            this.bmpnService.startProcess();
            String taskId = this.bmpnService.getUserTaskId("login");
            Boolean isProfessor = this.authenticationService.isProfessor(user.getEmail());
            this.bmpnService.setVariable(this.bmpnService.getProcessId(),"isProfessor",isProfessor.toString());
            this.bmpnService.completeUserTask(taskId);
            return appUserService.getUserByEmail(user.getEmail());
        } else {
            throw new Exception("email-not-exist");
        }
    }

    @PostMapping("/register")
    private @ResponseBody String register(@RequestBody AppUser user) {
        return this.authenticationService.signUp(user);
    }
}
