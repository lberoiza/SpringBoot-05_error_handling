package com.springboot.error_handling.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.error_handling.app.exceptions.UserNotFoundException;
import com.springboot.error_handling.app.models.User;
import com.springboot.error_handling.app.services.UserService;

@Controller
public class AppController {

  @Autowired
  private UserService userService;

  @GetMapping({ "", "/", "/index" })
  public String index() {
    return "index";
  }

  @GetMapping({ "/divide" })
  public String divide() {
    Integer i = 5 / 0;
    System.out.println(i);
    return "index";
  }

  @GetMapping({ "/number" })
  public String number() {
    Integer i = Integer.parseInt("10xaq");
    System.out.println(i);
    return "index";
  }

  @GetMapping({ "/user/{userId}" })
  public String getUser(@PathVariable Integer userId, Model model) throws UserNotFoundException {
    User user = userService.getById(userId);
    model.addAttribute("title", "User Details");
    model.addAttribute("user", user);
    return "user";
  }

}
