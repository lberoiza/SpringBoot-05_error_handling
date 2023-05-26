package com.springboot.error_handling.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
  
  @GetMapping({"", "/", "/index"})
  public String index() {
    return "index";
  }
  
  @GetMapping({"/divide"})
  public String divide() {
    Integer i = 5/0;
    System.out.println(i);
    return "index";
  }
  
  @GetMapping({"/number"})
  public String number() {
    Integer i = Integer.parseInt("10xaq");
    System.out.println(i);
    return "index";
  }

}
