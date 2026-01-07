package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.entity.Users;
import com.bank.service.BankServices;

@Controller
public class BankController 
{   
	@Autowired
    private BankServices service;
   @GetMapping("/registration")
   public String registrationForm()
   {
	   return "user-login/registration";
   }
   @PostMapping("/registration-success")
   public String success(@ModelAttribute Users user)
   { 
	   service.save(user);
	   return "user-login/registration-success";
   }
   
}
