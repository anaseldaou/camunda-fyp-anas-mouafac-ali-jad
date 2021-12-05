package com.example.workflow;

import com.example.workflow.Model.AppUser;
import com.example.workflow.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  @Autowired
  private AppUserRepository appUserRepository;

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}