package com.example.workflow.Controller;

import com.example.workflow.Model.Project;
import com.example.workflow.Service.BMPNService;
import com.example.workflow.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Named;
import java.util.List;

@Named
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private BMPNService bmpnService;

    @Autowired
    private ProjectService projectService;

    public ProjectController(){}

    @PostMapping("/add-project")
    public @ResponseBody
    Project addProject(@RequestBody Project project) throws Exception {
        Project addedProject = this.projectService.addProject(project);
        String taskId = this.bmpnService.getUserTaskId("Add Project");
        this.bmpnService.completeUserTask(taskId);
        return addedProject;
    }

    @GetMapping("/all-project")
    public @ResponseBody
    List<Project> findAllproject() {
        return this.projectService.findAllProject();
    }

    @PostMapping("/select-project")
    public @ResponseBody
    void selectProject(@RequestBody Project projectId) throws Exception {
        this.projectService.setChosenProjectId(projectId.getId());
        String taskId = this.bmpnService.getUserTaskId("Select Project");
        this.bmpnService.completeUserTask(taskId);
    }
}
