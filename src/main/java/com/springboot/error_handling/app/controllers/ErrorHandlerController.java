package com.springboot.error_handling.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
  
  @ExceptionHandler(ArithmeticException.class)
  public String arithmeticError(ArithmeticException aEx, Model model) {
    model.addAttribute("error", "Arithmetical Error");
    model.addAttribute("message", aEx.getMessage());
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("timestamp", new Date());
    return "error/custom/arithmetic_exception";
  }
  

  @ExceptionHandler(NumberFormatException.class)
  public String numberFormatError(NumberFormatException nfEx, Model model) {
    model.addAttribute("error", "Number Format Exception");
    model.addAttribute("message", nfEx.getMessage());
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("timestamp", new Date());
    return "error/custom/number_format_exception";
  }
  
}
