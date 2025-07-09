package com.perilousbooklet.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {
  
  /**
   * Home.
   *
   * @return the string
   */
  @GetMapping("/")
  public String home() {
    return "index";
  }
  
}
