package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bank.service.UsersServices;

@Controller
public class LoginController 
{
   @Autowired
   private UsersServices accountService;
   @GetMapping("/login-user")
   public String loginUser(String userId , String password,Model model)
   {
	   boolean isValid=accountService.validateUser(userId,password);
	   if(isValid)
	   {
		   return "user-login/home"; 
	   }
	   model.addAttribute("msg", "UserId and password is incorrect");
	   return "user-login/login-form";
   }
}
