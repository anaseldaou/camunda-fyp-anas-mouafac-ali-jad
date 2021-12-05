package com.example.workflow.Service;

import com.example.workflow.Repository.ProjectRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class projectValidator implements JavaDelegate {

    @Autowired
    public BMPNService bmpnService;

    @Autowired
    public ProjectService projectService;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("hello");
        Boolean isValid = this.projectService.checkProjectIfValid();
        this.projectService.setProjectAsInvalid(this.projectService.getSelectedProject());
        this.bmpnService.setVariable(this.bmpnService.getProcessId(),"projectIsValid",isValid.toString());
    }
}
