package com.example.workflow.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int maxNumberOfStudent;
    private String supervisorName;
    private String companyName;
    private int requiredHoursPerWeek;
    private boolean isAvailable = true;

    public Project(String title, int maxNumberOfStudent, String supervisorName, String companyName, int requiredHoursPerWeek) {
        this.title = title;
        this.maxNumberOfStudent = maxNumberOfStudent;
        this.supervisorName = supervisorName;
        this.companyName = companyName;
        this.requiredHoursPerWeek = requiredHoursPerWeek;
    }

    public Project(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxNumberOfStudent() {
        return maxNumberOfStudent;
    }

    public void setMaxNumberOfStudent(int maxNumberOfStudent) {
        this.maxNumberOfStudent = maxNumberOfStudent;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRequiredHoursPerWeek() {
        return requiredHoursPerWeek;
    }

    public void setRequiredHoursPerWeek(int requiredHoursPerWeek) {
        this.requiredHoursPerWeek = requiredHoursPerWeek;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}


