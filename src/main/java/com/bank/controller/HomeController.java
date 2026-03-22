package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController 
{
	@GetMapping("/")
   public String homePageView()
   {
	   
	   return "user-login/login-form";
   }
}
