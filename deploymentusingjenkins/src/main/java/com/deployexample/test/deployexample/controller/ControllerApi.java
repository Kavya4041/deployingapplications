package com.deployexample.test.deployexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@PropertySource("/application.properties")
public class ControllerApi {

  public String name1;


  public ControllerApi(@Value("${name}")String name) {

    this.name1 = name;
  }

  public String getName() {

    return name1;
  }

  @GetMapping("/hello")
    public String display()
    {

      return name1;
    }
}
